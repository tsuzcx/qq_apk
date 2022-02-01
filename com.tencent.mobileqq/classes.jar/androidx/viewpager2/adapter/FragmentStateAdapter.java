package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.SavedState;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import java.util.Iterator;
import java.util.Set;

public abstract class FragmentStateAdapter
  extends RecyclerView.Adapter<FragmentViewHolder>
  implements StatefulAdapter
{
  private static final long GRACE_WINDOW_TIME_MS = 10000L;
  private static final String KEY_PREFIX_FRAGMENT = "f#";
  private static final String KEY_PREFIX_STATE = "s#";
  final FragmentManager mFragmentManager;
  private FragmentStateAdapter.FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
  final LongSparseArray<Fragment> mFragments = new LongSparseArray();
  private boolean mHasStaleFragments = false;
  boolean mIsInGracePeriod = false;
  private final LongSparseArray<Integer> mItemIdToViewHolder = new LongSparseArray();
  final Lifecycle mLifecycle;
  private final LongSparseArray<Fragment.SavedState> mSavedStates = new LongSparseArray();
  
  public FragmentStateAdapter(@NonNull Fragment paramFragment)
  {
    this(paramFragment.getChildFragmentManager(), paramFragment.getLifecycle());
  }
  
  public FragmentStateAdapter(@NonNull FragmentActivity paramFragmentActivity)
  {
    this(paramFragmentActivity.getSupportFragmentManager(), paramFragmentActivity.getLifecycle());
  }
  
  public FragmentStateAdapter(@NonNull FragmentManager paramFragmentManager, @NonNull Lifecycle paramLifecycle)
  {
    this.mFragmentManager = paramFragmentManager;
    this.mLifecycle = paramLifecycle;
    super.setHasStableIds(true);
  }
  
  @NonNull
  private static String createKey(@NonNull String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void ensureFragment(int paramInt)
  {
    long l = getItemId(paramInt);
    if (!this.mFragments.containsKey(l))
    {
      Fragment localFragment = createFragment(paramInt);
      localFragment.setInitialSavedState((Fragment.SavedState)this.mSavedStates.get(l));
      this.mFragments.put(l, localFragment);
    }
  }
  
  private boolean isFragmentViewBound(long paramLong)
  {
    if (this.mItemIdToViewHolder.containsKey(paramLong)) {
      return true;
    }
    Object localObject = (Fragment)this.mFragments.get(paramLong);
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    localObject = ((Fragment)localObject).getView();
    if (localObject == null) {
      return false;
    }
    if (((View)localObject).getParent() != null) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isValidKey(@NonNull String paramString1, @NonNull String paramString2)
  {
    return (paramString1.startsWith(paramString2)) && (paramString1.length() > paramString2.length());
  }
  
  private Long itemForViewHolder(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    while (i < this.mItemIdToViewHolder.size())
    {
      Object localObject2 = localObject1;
      if (((Integer)this.mItemIdToViewHolder.valueAt(i)).intValue() == paramInt) {
        if (localObject1 == null) {
          localObject2 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i));
        } else {
          throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  private static long parseIdFromKey(@NonNull String paramString1, @NonNull String paramString2)
  {
    return Long.parseLong(paramString1.substring(paramString2.length()));
  }
  
  private void removeFragment(long paramLong)
  {
    Fragment localFragment = (Fragment)this.mFragments.get(paramLong);
    if (localFragment == null) {
      return;
    }
    if (localFragment.getView() != null)
    {
      ViewParent localViewParent = localFragment.getView().getParent();
      if (localViewParent != null) {
        ((FrameLayout)localViewParent).removeAllViews();
      }
    }
    if (!containsItem(paramLong)) {
      this.mSavedStates.remove(paramLong);
    }
    if (!localFragment.isAdded())
    {
      this.mFragments.remove(paramLong);
      return;
    }
    if (shouldDelayFragmentTransactions())
    {
      this.mHasStaleFragments = true;
      return;
    }
    if ((localFragment.isAdded()) && (containsItem(paramLong))) {
      this.mSavedStates.put(paramLong, this.mFragmentManager.saveFragmentInstanceState(localFragment));
    }
    this.mFragmentManager.beginTransaction().remove(localFragment).commitNow();
    this.mFragments.remove(paramLong);
  }
  
  private void scheduleGracePeriodEnd()
  {
    Handler localHandler = new Handler(Looper.getMainLooper());
    FragmentStateAdapter.4 local4 = new FragmentStateAdapter.4(this);
    this.mLifecycle.addObserver(new FragmentStateAdapter.5(this, localHandler, local4));
    localHandler.postDelayed(local4, 10000L);
  }
  
  private void scheduleViewAttach(Fragment paramFragment, @NonNull FrameLayout paramFrameLayout)
  {
    this.mFragmentManager.registerFragmentLifecycleCallbacks(new FragmentStateAdapter.3(this, paramFragment, paramFrameLayout), false);
  }
  
  void addViewToContainer(@NonNull View paramView, @NonNull FrameLayout paramFrameLayout)
  {
    if (paramFrameLayout.getChildCount() <= 1)
    {
      if (paramView.getParent() == paramFrameLayout) {
        return;
      }
      if (paramFrameLayout.getChildCount() > 0) {
        paramFrameLayout.removeAllViews();
      }
      if (paramView.getParent() != null) {
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      }
      paramFrameLayout.addView(paramView);
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
  
  public boolean containsItem(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong < getItemCount());
  }
  
  @NonNull
  public abstract Fragment createFragment(int paramInt);
  
  void gcFragments()
  {
    if (this.mHasStaleFragments)
    {
      if (shouldDelayFragmentTransactions()) {
        return;
      }
      Object localObject = new ArraySet();
      int j = 0;
      int i = 0;
      long l;
      while (i < this.mFragments.size())
      {
        l = this.mFragments.keyAt(i);
        if (!containsItem(l))
        {
          ((Set)localObject).add(Long.valueOf(l));
          this.mItemIdToViewHolder.remove(l);
        }
        i += 1;
      }
      if (!this.mIsInGracePeriod)
      {
        this.mHasStaleFragments = false;
        i = j;
        while (i < this.mFragments.size())
        {
          l = this.mFragments.keyAt(i);
          if (!isFragmentViewBound(l)) {
            ((Set)localObject).add(Long.valueOf(l));
          }
          i += 1;
        }
      }
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        removeFragment(((Long)((Iterator)localObject).next()).longValue());
      }
    }
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  @CallSuper
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    boolean bool;
    if (this.mFragmentMaxLifecycleEnforcer == null) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.mFragmentMaxLifecycleEnforcer = new FragmentStateAdapter.FragmentMaxLifecycleEnforcer(this);
    this.mFragmentMaxLifecycleEnforcer.register(paramRecyclerView);
  }
  
  public final void onBindViewHolder(@NonNull FragmentViewHolder paramFragmentViewHolder, int paramInt)
  {
    long l = paramFragmentViewHolder.getItemId();
    int i = paramFragmentViewHolder.getContainer().getId();
    Object localObject = itemForViewHolder(i);
    if ((localObject != null) && (((Long)localObject).longValue() != l))
    {
      removeFragment(((Long)localObject).longValue());
      this.mItemIdToViewHolder.remove(((Long)localObject).longValue());
    }
    this.mItemIdToViewHolder.put(l, Integer.valueOf(i));
    ensureFragment(paramInt);
    localObject = paramFragmentViewHolder.getContainer();
    if (ViewCompat.isAttachedToWindow((View)localObject)) {
      if (((FrameLayout)localObject).getParent() == null) {
        ((FrameLayout)localObject).addOnLayoutChangeListener(new FragmentStateAdapter.1(this, (FrameLayout)localObject, paramFragmentViewHolder));
      } else {
        throw new IllegalStateException("Design assumption violated.");
      }
    }
    gcFragments();
  }
  
  @NonNull
  public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return FragmentViewHolder.create(paramViewGroup);
  }
  
  @CallSuper
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    this.mFragmentMaxLifecycleEnforcer.unregister(paramRecyclerView);
    this.mFragmentMaxLifecycleEnforcer = null;
  }
  
  public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder paramFragmentViewHolder)
  {
    return true;
  }
  
  public final void onViewAttachedToWindow(@NonNull FragmentViewHolder paramFragmentViewHolder)
  {
    placeFragmentInViewHolder(paramFragmentViewHolder);
    gcFragments();
  }
  
  public final void onViewRecycled(@NonNull FragmentViewHolder paramFragmentViewHolder)
  {
    paramFragmentViewHolder = itemForViewHolder(paramFragmentViewHolder.getContainer().getId());
    if (paramFragmentViewHolder != null)
    {
      removeFragment(paramFragmentViewHolder.longValue());
      this.mItemIdToViewHolder.remove(paramFragmentViewHolder.longValue());
    }
  }
  
  void placeFragmentInViewHolder(@NonNull FragmentViewHolder paramFragmentViewHolder)
  {
    Fragment localFragment = (Fragment)this.mFragments.get(paramFragmentViewHolder.getItemId());
    if (localFragment != null)
    {
      Object localObject1 = paramFragmentViewHolder.getContainer();
      Object localObject2 = localFragment.getView();
      if ((!localFragment.isAdded()) && (localObject2 != null)) {
        throw new IllegalStateException("Design assumption violated.");
      }
      if ((localFragment.isAdded()) && (localObject2 == null))
      {
        scheduleViewAttach(localFragment, (FrameLayout)localObject1);
        return;
      }
      if ((localFragment.isAdded()) && (((View)localObject2).getParent() != null))
      {
        if (((View)localObject2).getParent() != localObject1) {
          addViewToContainer((View)localObject2, (FrameLayout)localObject1);
        }
        return;
      }
      if (localFragment.isAdded())
      {
        addViewToContainer((View)localObject2, (FrameLayout)localObject1);
        return;
      }
      if (!shouldDelayFragmentTransactions())
      {
        scheduleViewAttach(localFragment, (FrameLayout)localObject1);
        localObject1 = this.mFragmentManager.beginTransaction();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("f");
        ((StringBuilder)localObject2).append(paramFragmentViewHolder.getItemId());
        ((FragmentTransaction)localObject1).add(localFragment, ((StringBuilder)localObject2).toString()).setMaxLifecycle(localFragment, Lifecycle.State.STARTED).commitNow();
        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
        return;
      }
      if (this.mFragmentManager.isDestroyed()) {
        return;
      }
      this.mLifecycle.addObserver(new FragmentStateAdapter.2(this, paramFragmentViewHolder));
      return;
    }
    throw new IllegalStateException("Design assumption violated.");
  }
  
  public final void restoreState(@NonNull Parcelable paramParcelable)
  {
    if ((this.mSavedStates.isEmpty()) && (this.mFragments.isEmpty()))
    {
      paramParcelable = (Bundle)paramParcelable;
      if (paramParcelable.getClassLoader() == null) {
        paramParcelable.setClassLoader(getClass().getClassLoader());
      }
      Iterator localIterator = paramParcelable.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        long l;
        if (isValidKey((String)localObject, "f#"))
        {
          l = parseIdFromKey((String)localObject, "f#");
          localObject = this.mFragmentManager.getFragment(paramParcelable, (String)localObject);
          this.mFragments.put(l, localObject);
        }
        else if (isValidKey((String)localObject, "s#"))
        {
          l = parseIdFromKey((String)localObject, "s#");
          localObject = (Fragment.SavedState)paramParcelable.getParcelable((String)localObject);
          if (containsItem(l)) {
            this.mSavedStates.put(l, localObject);
          }
        }
        else
        {
          paramParcelable = new StringBuilder();
          paramParcelable.append("Unexpected key in savedState: ");
          paramParcelable.append((String)localObject);
          throw new IllegalArgumentException(paramParcelable.toString());
        }
      }
      if (!this.mFragments.isEmpty())
      {
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        gcFragments();
        scheduleGracePeriodEnd();
      }
      return;
    }
    paramParcelable = new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    for (;;)
    {
      throw paramParcelable;
    }
  }
  
  @NonNull
  public final Parcelable saveState()
  {
    Bundle localBundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
    int k = 0;
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = k;
      if (i >= this.mFragments.size()) {
        break;
      }
      l = this.mFragments.keyAt(i);
      Fragment localFragment = (Fragment)this.mFragments.get(l);
      if ((localFragment != null) && (localFragment.isAdded()))
      {
        String str = createKey("f#", l);
        this.mFragmentManager.putFragment(localBundle, str, localFragment);
      }
      i += 1;
    }
    while (j < this.mSavedStates.size())
    {
      l = this.mSavedStates.keyAt(j);
      if (containsItem(l)) {
        localBundle.putParcelable(createKey("s#", l), (Parcelable)this.mSavedStates.get(l));
      }
      j += 1;
    }
    return localBundle;
  }
  
  public final void setHasStableIds(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
  }
  
  boolean shouldDelayFragmentTransactions()
  {
    return this.mFragmentManager.isStateSaved();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.adapter.FragmentStateAdapter
 * JD-Core Version:    0.7.0.1
 */