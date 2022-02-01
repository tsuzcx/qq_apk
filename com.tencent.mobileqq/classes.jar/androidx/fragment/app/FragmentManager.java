package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.os.CancellationSignal;
import androidx.core.util.LogWriter;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager
{
  private static boolean DEBUG = false;
  public static final int POP_BACK_STACK_INCLUSIVE = 1;
  static final String TAG = "FragmentManager";
  ArrayList<BackStackRecord> mBackStack;
  private ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  private final AtomicInteger mBackStackIndex = new AtomicInteger();
  FragmentContainer mContainer;
  private ArrayList<Fragment> mCreatedMenus;
  int mCurState = -1;
  private boolean mDestroyed;
  private Runnable mExecCommit = new FragmentManager.4(this);
  private boolean mExecutingActions;
  private ConcurrentHashMap<Fragment, HashSet<CancellationSignal>> mExitAnimationCancellationSignals = new ConcurrentHashMap();
  private FragmentFactory mFragmentFactory = null;
  private final FragmentStore mFragmentStore = new FragmentStore();
  private final FragmentTransition.Callback mFragmentTransitionCallback = new FragmentManager.2(this);
  private boolean mHavePendingDeferredStart;
  FragmentHostCallback<?> mHost;
  private FragmentFactory mHostFragmentFactory = new FragmentManager.3(this);
  private final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
  private final FragmentLifecycleCallbacksDispatcher mLifecycleCallbacksDispatcher = new FragmentLifecycleCallbacksDispatcher(this);
  private boolean mNeedMenuInvalidate;
  private FragmentManagerViewModel mNonConfig;
  private final OnBackPressedCallback mOnBackPressedCallback = new FragmentManager.1(this, false);
  private OnBackPressedDispatcher mOnBackPressedDispatcher;
  private Fragment mParent;
  private final ArrayList<FragmentManager.OpGenerator> mPendingActions = new ArrayList();
  private ArrayList<FragmentManager.StartEnterTransitionListener> mPostponedTransactions;
  @Nullable
  Fragment mPrimaryNav;
  private boolean mStateSaved;
  private boolean mStopped;
  private ArrayList<Fragment> mTmpAddedFragments;
  private ArrayList<Boolean> mTmpIsPop;
  private ArrayList<BackStackRecord> mTmpRecords;
  
  private void addAddedFragments(@NonNull ArraySet<Fragment> paramArraySet)
  {
    int i = this.mCurState;
    if (i < 1) {
      return;
    }
    i = Math.min(i, 3);
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment.mState < i)
      {
        moveToState(localFragment, i);
        if ((localFragment.mView != null) && (!localFragment.mHidden) && (localFragment.mIsNewlyAdded)) {
          paramArraySet.add(localFragment);
        }
      }
    }
  }
  
  private void cancelExitAnimation(@NonNull Fragment paramFragment)
  {
    HashSet localHashSet = (HashSet)this.mExitAnimationCancellationSignals.get(paramFragment);
    if (localHashSet != null)
    {
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext()) {
        ((CancellationSignal)localIterator.next()).cancel();
      }
      localHashSet.clear();
      destroyFragmentView(paramFragment);
      this.mExitAnimationCancellationSignals.remove(paramFragment);
    }
  }
  
  private void checkStateLoss()
  {
    if (!isStateSaved()) {
      return;
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeShowHideFragment(@NonNull Fragment paramFragment)
  {
    if (paramFragment.mView != null)
    {
      FragmentAnim.AnimationOrAnimator localAnimationOrAnimator = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, paramFragment, paramFragment.mHidden ^ true);
      if ((localAnimationOrAnimator != null) && (localAnimationOrAnimator.animator != null))
      {
        localAnimationOrAnimator.animator.setTarget(paramFragment.mView);
        if (paramFragment.mHidden)
        {
          if (paramFragment.isHideReplaced())
          {
            paramFragment.setHideReplaced(false);
          }
          else
          {
            ViewGroup localViewGroup = paramFragment.mContainer;
            View localView = paramFragment.mView;
            localViewGroup.startViewTransition(localView);
            localAnimationOrAnimator.animator.addListener(new FragmentManager.5(this, localViewGroup, localView, paramFragment));
          }
        }
        else {
          paramFragment.mView.setVisibility(0);
        }
        localAnimationOrAnimator.animator.start();
      }
      else
      {
        if (localAnimationOrAnimator != null)
        {
          paramFragment.mView.startAnimation(localAnimationOrAnimator.animation);
          localAnimationOrAnimator.animation.start();
        }
        int i;
        if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {
          i = 8;
        } else {
          i = 0;
        }
        paramFragment.mView.setVisibility(i);
        if (paramFragment.isHideReplaced()) {
          paramFragment.setHideReplaced(false);
        }
      }
    }
    if ((paramFragment.mAdded) && (isMenuAvailable(paramFragment))) {
      this.mNeedMenuInvalidate = true;
    }
    paramFragment.mHiddenChanged = false;
    paramFragment.onHiddenChanged(paramFragment.mHidden);
  }
  
  private void destroyFragmentView(@NonNull Fragment paramFragment)
  {
    paramFragment.performDestroyView();
    this.mLifecycleCallbacksDispatcher.dispatchOnFragmentViewDestroyed(paramFragment, false);
    paramFragment.mContainer = null;
    paramFragment.mView = null;
    paramFragment.mViewLifecycleOwner = null;
    paramFragment.mViewLifecycleOwnerLiveData.setValue(null);
    paramFragment.mInLayout = false;
  }
  
  private void dispatchParentPrimaryNavigationFragmentChanged(@Nullable Fragment paramFragment)
  {
    if ((paramFragment != null) && (paramFragment.equals(findActiveFragment(paramFragment.mWho)))) {
      paramFragment.performPrimaryNavigationFragmentChanged();
    }
  }
  
  private void dispatchStateChange(int paramInt)
  {
    try
    {
      this.mExecutingActions = true;
      this.mFragmentStore.dispatchStateChange(paramInt);
      moveToState(paramInt, false);
      this.mExecutingActions = false;
      execPendingActions(true);
      return;
    }
    finally
    {
      this.mExecutingActions = false;
    }
  }
  
  private void doPendingDeferredStart()
  {
    if (this.mHavePendingDeferredStart)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
  }
  
  @Deprecated
  public static void enableDebugLogging(boolean paramBoolean)
  {
    DEBUG = paramBoolean;
  }
  
  private void endAnimatingAwayFragments()
  {
    if (!this.mExitAnimationCancellationSignals.isEmpty())
    {
      Iterator localIterator = this.mExitAnimationCancellationSignals.keySet().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        cancelExitAnimation(localFragment);
        moveToState(localFragment, localFragment.getStateAfterAnimating());
      }
    }
  }
  
  private void ensureExecReady(boolean paramBoolean)
  {
    if (!this.mExecutingActions)
    {
      if (this.mHost == null)
      {
        if (this.mDestroyed) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      if (Looper.myLooper() == this.mHost.getHandler().getLooper())
      {
        if (!paramBoolean) {
          checkStateLoss();
        }
        if (this.mTmpRecords == null)
        {
          this.mTmpRecords = new ArrayList();
          this.mTmpIsPop = new ArrayList();
        }
        this.mExecutingActions = true;
        try
        {
          executePostponedTransaction(null, null);
          return;
        }
        finally
        {
          this.mExecutingActions = false;
        }
      }
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
    throw new IllegalStateException("FragmentManager is already executing transactions");
  }
  
  private static void executeOps(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(paramInt1);
      boolean bool2 = ((Boolean)paramArrayList1.get(paramInt1)).booleanValue();
      boolean bool1 = true;
      if (bool2)
      {
        localBackStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 != paramInt2 - 1) {
          bool1 = false;
        }
        localBackStackRecord.executePopOps(bool1);
      }
      else
      {
        localBackStackRecord.bumpBackStackNesting(1);
        localBackStackRecord.executeOps();
      }
      paramInt1 += 1;
    }
  }
  
  private void executeOpsTogether(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    boolean bool = ((BackStackRecord)paramArrayList.get(i)).mReorderingAllowed;
    Object localObject = this.mTmpAddedFragments;
    if (localObject == null) {
      this.mTmpAddedFragments = new ArrayList();
    } else {
      ((ArrayList)localObject).clear();
    }
    this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
    localObject = getPrimaryNavigationFragment();
    int k = i;
    int j = 0;
    while (k < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(k);
      if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
        localObject = localBackStackRecord.expandOps(this.mTmpAddedFragments, (Fragment)localObject);
      } else {
        localObject = localBackStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, (Fragment)localObject);
      }
      if ((j == 0) && (!localBackStackRecord.mAddToBackStack)) {
        j = 0;
      } else {
        j = 1;
      }
      k += 1;
    }
    this.mTmpAddedFragments.clear();
    if (!bool) {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false, this.mFragmentTransitionCallback);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new ArraySet();
      addAddedFragments((ArraySet)localObject);
      k = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (ArraySet)localObject);
      makeRemovedFragmentsInvisible((ArraySet)localObject);
    }
    else
    {
      k = paramInt2;
    }
    int m = i;
    if (k != i)
    {
      m = i;
      if (bool)
      {
        FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, k, true, this.mFragmentTransitionCallback);
        moveToState(this.mCurState, true);
        m = i;
      }
    }
    while (m < paramInt2)
    {
      localObject = (BackStackRecord)paramArrayList.get(m);
      if ((((Boolean)paramArrayList1.get(m)).booleanValue()) && (((BackStackRecord)localObject).mIndex >= 0)) {
        ((BackStackRecord)localObject).mIndex = -1;
      }
      ((BackStackRecord)localObject).runOnCommitRunnables();
      m += 1;
    }
    if (j != 0) {
      reportBackStackChanged();
    }
  }
  
  private void executePostponedTransaction(@Nullable ArrayList<BackStackRecord> paramArrayList, @Nullable ArrayList<Boolean> paramArrayList1)
  {
    Object localObject = this.mPostponedTransactions;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ArrayList)localObject).size();
    }
    int k = 0;
    int j;
    for (int m = i; k < m; m = j)
    {
      localObject = (FragmentManager.StartEnterTransitionListener)this.mPostponedTransactions.get(k);
      if ((paramArrayList != null) && (!((FragmentManager.StartEnterTransitionListener)localObject).mIsBack))
      {
        i = paramArrayList.indexOf(((FragmentManager.StartEnterTransitionListener)localObject).mRecord);
        if ((i != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
        {
          this.mPostponedTransactions.remove(k);
          i = k - 1;
          j = m - 1;
          ((FragmentManager.StartEnterTransitionListener)localObject).cancelTransaction();
          break label248;
        }
      }
      if (!((FragmentManager.StartEnterTransitionListener)localObject).isReady())
      {
        i = k;
        j = m;
        if (paramArrayList != null)
        {
          i = k;
          j = m;
          if (!((FragmentManager.StartEnterTransitionListener)localObject).mRecord.interactsWith(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.mPostponedTransactions.remove(k);
        i = k - 1;
        j = m - 1;
        if ((paramArrayList != null) && (!((FragmentManager.StartEnterTransitionListener)localObject).mIsBack))
        {
          k = paramArrayList.indexOf(((FragmentManager.StartEnterTransitionListener)localObject).mRecord);
          if ((k != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(k)).booleanValue()))
          {
            ((FragmentManager.StartEnterTransitionListener)localObject).cancelTransaction();
            break label248;
          }
        }
        ((FragmentManager.StartEnterTransitionListener)localObject).completeTransaction();
      }
      label248:
      k = i + 1;
    }
  }
  
  @NonNull
  public static <F extends Fragment> F findFragment(@NonNull View paramView)
  {
    Object localObject = findViewFragment(paramView);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" does not have a Fragment set");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  static FragmentManager findFragmentManager(@NonNull View paramView)
  {
    Object localObject1 = findViewFragment(paramView);
    if (localObject1 != null) {
      return ((Fragment)localObject1).getChildFragmentManager();
    }
    localObject1 = paramView.getContext();
    Object localObject3 = null;
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject3;
      if (!(localObject1 instanceof ContextWrapper)) {
        break;
      }
      if ((localObject1 instanceof FragmentActivity))
      {
        localObject2 = (FragmentActivity)localObject1;
        break;
      }
      localObject1 = ((ContextWrapper)localObject1).getBaseContext();
    }
    if (localObject2 != null) {
      return ((FragmentActivity)localObject2).getSupportFragmentManager();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("View ");
    ((StringBuilder)localObject1).append(paramView);
    ((StringBuilder)localObject1).append(" is not within a subclass of FragmentActivity.");
    paramView = new IllegalStateException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramView;
    }
  }
  
  @Nullable
  private static Fragment findViewFragment(@NonNull View paramView)
  {
    while (paramView != null)
    {
      Fragment localFragment = getViewFragment(paramView);
      if (localFragment != null) {
        return localFragment;
      }
      paramView = paramView.getParent();
      if ((paramView instanceof View)) {
        paramView = (View)paramView;
      } else {
        paramView = null;
      }
    }
    return null;
  }
  
  private void forcePostponedTransactions()
  {
    if (this.mPostponedTransactions != null) {
      while (!this.mPostponedTransactions.isEmpty()) {
        ((FragmentManager.StartEnterTransitionListener)this.mPostponedTransactions.remove(0)).completeTransaction();
      }
    }
  }
  
  private boolean generateOpsForPendingActions(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1)
  {
    synchronized (this.mPendingActions)
    {
      boolean bool = this.mPendingActions.isEmpty();
      int i = 0;
      if (bool) {
        return false;
      }
      int j = this.mPendingActions.size();
      bool = false;
      while (i < j)
      {
        bool |= ((FragmentManager.OpGenerator)this.mPendingActions.get(i)).generateOps(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      return bool;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  @NonNull
  private FragmentManagerViewModel getChildNonConfig(@NonNull Fragment paramFragment)
  {
    return this.mNonConfig.getChildNonConfig(paramFragment);
  }
  
  private ViewGroup getFragmentContainer(@NonNull Fragment paramFragment)
  {
    if (paramFragment.mContainerId <= 0) {
      return null;
    }
    if (this.mContainer.onHasView())
    {
      paramFragment = this.mContainer.onFindViewById(paramFragment.mContainerId);
      if ((paramFragment instanceof ViewGroup)) {
        return (ViewGroup)paramFragment;
      }
    }
    return null;
  }
  
  @Nullable
  static Fragment getViewFragment(@NonNull View paramView)
  {
    paramView = paramView.getTag(2131367214);
    if ((paramView instanceof Fragment)) {
      return (Fragment)paramView;
    }
    return null;
  }
  
  static boolean isLoggingEnabled(int paramInt)
  {
    return (DEBUG) || (Log.isLoggable("FragmentManager", paramInt));
  }
  
  private boolean isMenuAvailable(@NonNull Fragment paramFragment)
  {
    return ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) || (paramFragment.mChildFragmentManager.checkForMenus());
  }
  
  private void makeInactive(@NonNull FragmentStateManager paramFragmentStateManager)
  {
    Fragment localFragment = paramFragmentStateManager.getFragment();
    if (!this.mFragmentStore.containsActiveFragment(localFragment.mWho)) {
      return;
    }
    if (isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Removed fragment from active set ");
      localStringBuilder.append(localFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    this.mFragmentStore.makeInactive(paramFragmentStateManager);
    removeRetainedFragment(localFragment);
  }
  
  private void makeRemovedFragmentsInvisible(@NonNull ArraySet<Fragment> paramArraySet)
  {
    int j = paramArraySet.size();
    int i = 0;
    while (i < j)
    {
      Fragment localFragment = (Fragment)paramArraySet.valueAt(i);
      if (!localFragment.mAdded)
      {
        View localView = localFragment.requireView();
        localFragment.mPostponedAlpha = localView.getAlpha();
        localView.setAlpha(0.0F);
      }
      i += 1;
    }
  }
  
  private boolean popBackStackImmediate(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    execPendingActions(false);
    ensureExecReady(true);
    Fragment localFragment = this.mPrimaryNav;
    if ((localFragment != null) && (paramInt1 < 0) && (paramString == null) && (localFragment.getChildFragmentManager().popBackStackImmediate())) {
      return true;
    }
    boolean bool = popBackStackState(this.mTmpRecords, this.mTmpIsPop, paramString, paramInt1, paramInt2);
    if (bool) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
    }
    finally
    {
      cleanupExec();
    }
    doPendingDeferredStart();
    this.mFragmentStore.burpActive();
    return bool;
  }
  
  private int postponePostponableTransactions(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, @NonNull ArraySet<Fragment> paramArraySet)
  {
    int i = paramInt2 - 1;
    int k;
    for (int j = paramInt2; i >= paramInt1; j = k)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(i);
      boolean bool = ((Boolean)paramArrayList1.get(i)).booleanValue();
      int m;
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList, i + 1, paramInt2))) {
        m = 1;
      } else {
        m = 0;
      }
      k = j;
      if (m != 0)
      {
        if (this.mPostponedTransactions == null) {
          this.mPostponedTransactions = new ArrayList();
        }
        FragmentManager.StartEnterTransitionListener localStartEnterTransitionListener = new FragmentManager.StartEnterTransitionListener(localBackStackRecord, bool);
        this.mPostponedTransactions.add(localStartEnterTransitionListener);
        localBackStackRecord.setOnStartPostponedListener(localStartEnterTransitionListener);
        if (bool) {
          localBackStackRecord.executeOps();
        } else {
          localBackStackRecord.executePopOps(false);
        }
        k = j - 1;
        if (i != k)
        {
          paramArrayList.remove(i);
          paramArrayList.add(k, localBackStackRecord);
        }
        addAddedFragments(paramArraySet);
      }
      i -= 1;
    }
    return j;
  }
  
  private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1)
  {
    if (paramArrayList.isEmpty()) {
      return;
    }
    if (paramArrayList.size() == paramArrayList1.size())
    {
      executePostponedTransaction(paramArrayList, paramArrayList1);
      int n = paramArrayList.size();
      int i = 0;
      int j;
      for (int k = 0; i < n; k = j)
      {
        int m = i;
        j = k;
        if (!((BackStackRecord)paramArrayList.get(i)).mReorderingAllowed)
        {
          if (k != i) {
            executeOpsTogether(paramArrayList, paramArrayList1, k, i);
          }
          k = i + 1;
          j = k;
          if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
            for (;;)
            {
              j = k;
              if (k >= n) {
                break;
              }
              j = k;
              if (!((Boolean)paramArrayList1.get(k)).booleanValue()) {
                break;
              }
              j = k;
              if (((BackStackRecord)paramArrayList.get(k)).mReorderingAllowed) {
                break;
              }
              k += 1;
            }
          }
          executeOpsTogether(paramArrayList, paramArrayList1, i, j);
          m = j - 1;
        }
        i = m + 1;
      }
      if (k != n) {
        executeOpsTogether(paramArrayList, paramArrayList1, k, n);
      }
      return;
    }
    paramArrayList = new IllegalStateException("Internal error with the back stack records");
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  private void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null)
    {
      int i = 0;
      while (i < this.mBackStackChangeListeners.size())
      {
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
        i += 1;
      }
    }
  }
  
  static int reverseTransit(int paramInt)
  {
    int i = 8194;
    if (paramInt != 4097)
    {
      if (paramInt != 4099)
      {
        if (paramInt != 8194) {
          return 0;
        }
        return 4097;
      }
      i = 4099;
    }
    return i;
  }
  
  private void setVisibleRemovingFragment(@NonNull Fragment paramFragment)
  {
    ViewGroup localViewGroup = getFragmentContainer(paramFragment);
    if (localViewGroup != null)
    {
      if (localViewGroup.getTag(2131380961) == null) {
        localViewGroup.setTag(2131380961, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(2131380961)).setNextAnim(paramFragment.getNextAnim());
    }
  }
  
  private void startPendingDeferredFragments()
  {
    Iterator localIterator = this.mFragmentStore.getActiveFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        performPendingDeferredStart(localFragment);
      }
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    FragmentHostCallback localFragmentHostCallback = this.mHost;
    if (localFragmentHostCallback != null) {
      try
      {
        localFragmentHostCallback.onDump("  ", null, localPrintWriter, new String[0]);
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
      }
    } else {
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
    throw paramRuntimeException;
  }
  
  private void updateOnBackPressedCallbackEnabled()
  {
    synchronized (this.mPendingActions)
    {
      boolean bool2 = this.mPendingActions.isEmpty();
      boolean bool1 = true;
      if (!bool2)
      {
        this.mOnBackPressedCallback.setEnabled(true);
        return;
      }
      ??? = this.mOnBackPressedCallback;
      if ((getBackStackEntryCount() <= 0) || (!isPrimaryNavigation(this.mParent))) {
        bool1 = false;
      }
      ((OnBackPressedCallback)???).setEnabled(bool1);
      return;
    }
  }
  
  void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
  }
  
  void addCancellationSignal(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal)
  {
    if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {
      this.mExitAnimationCancellationSignals.put(paramFragment, new HashSet());
    }
    ((HashSet)this.mExitAnimationCancellationSignals.get(paramFragment)).add(paramCancellationSignal);
  }
  
  void addFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      this.mFragmentStore.addFragment(paramFragment);
      paramFragment.mRemoving = false;
      if (paramFragment.mView == null) {
        paramFragment.mHiddenChanged = false;
      }
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
    }
  }
  
  public void addOnBackStackChangedListener(@NonNull FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  void addRetainedFragment(@NonNull Fragment paramFragment)
  {
    if (isStateSaved())
    {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
      return;
    }
    if ((this.mNonConfig.addRetainedFragment(paramFragment)) && (isLoggingEnabled(2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Updating retained Fragments: Added ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  int allocBackStackIndex()
  {
    return this.mBackStackIndex.getAndIncrement();
  }
  
  void attachController(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentContainer paramFragmentContainer, @Nullable Fragment paramFragment)
  {
    if (this.mHost == null)
    {
      this.mHost = paramFragmentHostCallback;
      this.mContainer = paramFragmentContainer;
      this.mParent = paramFragment;
      if (this.mParent != null) {
        updateOnBackPressedCallbackEnabled();
      }
      if ((paramFragmentHostCallback instanceof OnBackPressedDispatcherOwner))
      {
        paramFragmentContainer = (OnBackPressedDispatcherOwner)paramFragmentHostCallback;
        this.mOnBackPressedDispatcher = paramFragmentContainer.getOnBackPressedDispatcher();
        if (paramFragment != null) {
          paramFragmentContainer = paramFragment;
        }
        this.mOnBackPressedDispatcher.addCallback(paramFragmentContainer, this.mOnBackPressedCallback);
      }
      if (paramFragment != null)
      {
        this.mNonConfig = paramFragment.mFragmentManager.getChildNonConfig(paramFragment);
        return;
      }
      if ((paramFragmentHostCallback instanceof ViewModelStoreOwner))
      {
        this.mNonConfig = FragmentManagerViewModel.getInstance(((ViewModelStoreOwner)paramFragmentHostCallback).getViewModelStore());
        return;
      }
      this.mNonConfig = new FragmentManagerViewModel(false);
      return;
    }
    throw new IllegalStateException("Already attached");
  }
  
  void attachFragment(@NonNull Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (isLoggingEnabled(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("attach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        this.mFragmentStore.addFragment(paramFragment);
        if (isLoggingEnabled(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("add from attach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
      }
    }
  }
  
  @NonNull
  public FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  boolean checkForMenus()
  {
    Iterator localIterator = this.mFragmentStore.getActiveFragments().iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      boolean bool2 = bool1;
      if (localFragment != null) {
        bool2 = isMenuAvailable(localFragment);
      }
      bool1 = bool2;
      if (bool2) {
        return true;
      }
    }
    return false;
  }
  
  void completeExecute(@NonNull BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      paramBackStackRecord.executePopOps(paramBoolean3);
    } else {
      paramBackStackRecord.executeOps();
    }
    Object localObject1 = new ArrayList(1);
    Object localObject2 = new ArrayList(1);
    ((ArrayList)localObject1).add(paramBackStackRecord);
    ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
    if (paramBoolean2) {
      FragmentTransition.startTransitions(this, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true, this.mFragmentTransitionCallback);
    }
    if (paramBoolean3) {
      moveToState(this.mCurState, true);
    }
    localObject1 = this.mFragmentStore.getActiveFragments().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Fragment)localObject2).mView != null) && (((Fragment)localObject2).mIsNewlyAdded) && (paramBackStackRecord.interactsWith(((Fragment)localObject2).mContainerId)))
      {
        if (((Fragment)localObject2).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject2).mView.setAlpha(((Fragment)localObject2).mPostponedAlpha);
        }
        if (paramBoolean3)
        {
          ((Fragment)localObject2).mPostponedAlpha = 0.0F;
        }
        else
        {
          ((Fragment)localObject2).mPostponedAlpha = -1.0F;
          ((Fragment)localObject2).mIsNewlyAdded = false;
        }
      }
    }
  }
  
  void detachFragment(@NonNull Fragment paramFragment)
  {
    StringBuilder localStringBuilder;
    if (isLoggingEnabled(2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("detach: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (isLoggingEnabled(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("remove from detach: ");
          localStringBuilder.append(paramFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        this.mFragmentStore.removeFragment(paramFragment);
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
        setVisibleRemovingFragment(paramFragment);
      }
    }
  }
  
  void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(2);
  }
  
  void dispatchConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performConfigurationChanged(paramConfiguration);
      }
    }
  }
  
  boolean dispatchContextItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (this.mCurState < 1) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void dispatchCreate()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(1);
  }
  
  boolean dispatchCreateOptionsMenu(@NonNull Menu paramMenu, @NonNull MenuInflater paramMenuInflater)
  {
    int j = this.mCurState;
    int i = 0;
    if (j < 1) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (isParentMenuVisible(localFragment)) && (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater)))
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool = true;
        localObject1 = localObject2;
      }
    }
    if (this.mCreatedMenus != null) {
      while (i < this.mCreatedMenus.size())
      {
        paramMenu = (Fragment)this.mCreatedMenus.get(i);
        if ((localObject1 == null) || (!localObject1.contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
        i += 1;
      }
    }
    this.mCreatedMenus = localObject1;
    return bool;
  }
  
  void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions(true);
    endAnimatingAwayFragments();
    dispatchStateChange(-1);
    this.mHost = null;
    this.mContainer = null;
    this.mParent = null;
    if (this.mOnBackPressedDispatcher != null)
    {
      this.mOnBackPressedCallback.remove();
      this.mOnBackPressedDispatcher = null;
    }
  }
  
  void dispatchDestroyView()
  {
    dispatchStateChange(1);
  }
  
  void dispatchLowMemory()
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performLowMemory();
      }
    }
  }
  
  void dispatchMultiWindowModeChanged(boolean paramBoolean)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performMultiWindowModeChanged(paramBoolean);
      }
    }
  }
  
  boolean dispatchOptionsItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (this.mCurState < 1) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
        return true;
      }
    }
    return false;
  }
  
  void dispatchOptionsMenuClosed(@NonNull Menu paramMenu)
  {
    if (this.mCurState < 1) {
      return;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performOptionsMenuClosed(paramMenu);
      }
    }
  }
  
  void dispatchPause()
  {
    dispatchStateChange(3);
  }
  
  void dispatchPictureInPictureModeChanged(boolean paramBoolean)
  {
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.performPictureInPictureModeChanged(paramBoolean);
      }
    }
  }
  
  boolean dispatchPrepareOptionsMenu(@NonNull Menu paramMenu)
  {
    int i = this.mCurState;
    boolean bool = false;
    if (i < 1) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment != null) && (localFragment.performPrepareOptionsMenu(paramMenu))) {
        bool = true;
      }
    }
    return bool;
  }
  
  void dispatchPrimaryNavigationFragmentChanged()
  {
    updateOnBackPressedCallbackEnabled();
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  void dispatchResume()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(4);
  }
  
  void dispatchStart()
  {
    this.mStateSaved = false;
    this.mStopped = false;
    dispatchStateChange(3);
  }
  
  void dispatchStop()
  {
    this.mStopped = true;
    dispatchStateChange(2);
  }
  
  public void dump(@NonNull String paramString, @Nullable FileDescriptor arg2, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("    ");
    localObject = ((StringBuilder)localObject).toString();
    this.mFragmentStore.dump(paramString, ???, paramPrintWriter, paramArrayOfString);
    ??? = this.mCreatedMenus;
    int j = 0;
    int k;
    int i;
    if (??? != null)
    {
      k = ???.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          ??? = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          i += 1;
        }
      }
    }
    ??? = this.mBackStack;
    if (??? != null)
    {
      k = ???.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          ??? = (BackStackRecord)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(???.toString());
          ???.dump((String)localObject, paramPrintWriter);
          i += 1;
        }
      }
    }
    paramPrintWriter.print(paramString);
    ??? = new StringBuilder();
    ???.append("Back Stack Index: ");
    ???.append(this.mBackStackIndex.get());
    paramPrintWriter.println(???.toString());
    synchronized (this.mPendingActions)
    {
      k = this.mPendingActions.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Pending Actions:");
        i = j;
        while (i < k)
        {
          paramArrayOfString = (FragmentManager.OpGenerator)this.mPendingActions.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramArrayOfString);
          i += 1;
        }
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("FragmentManager misc state:");
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mHost=");
      paramPrintWriter.println(this.mHost);
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mContainer=");
      paramPrintWriter.println(this.mContainer);
      if (this.mParent != null)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mParent=");
        paramPrintWriter.println(this.mParent);
      }
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mCurState=");
      paramPrintWriter.print(this.mCurState);
      paramPrintWriter.print(" mStateSaved=");
      paramPrintWriter.print(this.mStateSaved);
      paramPrintWriter.print(" mStopped=");
      paramPrintWriter.print(this.mStopped);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(this.mDestroyed);
      if (this.mNeedMenuInvalidate)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  mNeedMenuInvalidate=");
        paramPrintWriter.println(this.mNeedMenuInvalidate);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  void enqueueAction(@NonNull FragmentManager.OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.mHost == null)
      {
        if (this.mDestroyed) {
          throw new IllegalStateException("FragmentManager has been destroyed");
        }
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
      }
      checkStateLoss();
    }
    synchronized (this.mPendingActions)
    {
      if (this.mHost == null)
      {
        if (paramBoolean) {
          return;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
      this.mPendingActions.add(paramOpGenerator);
      scheduleCommit();
      return;
    }
  }
  
  boolean execPendingActions(boolean paramBoolean)
  {
    ensureExecReady(paramBoolean);
    paramBoolean = false;
    for (;;)
    {
      if (generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
        this.mExecutingActions = true;
      }
      try
      {
        removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
        cleanupExec();
        paramBoolean = true;
      }
      finally
      {
        cleanupExec();
      }
    }
    doPendingDeferredStart();
    this.mFragmentStore.burpActive();
    return paramBoolean;
  }
  
  void execSingleAction(@NonNull FragmentManager.OpGenerator paramOpGenerator, boolean paramBoolean)
  {
    if ((paramBoolean) && ((this.mHost == null) || (this.mDestroyed))) {
      return;
    }
    ensureExecReady(paramBoolean);
    if (paramOpGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
      this.mExecutingActions = true;
    }
    try
    {
      removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
      cleanupExec();
    }
    finally
    {
      cleanupExec();
    }
    doPendingDeferredStart();
    this.mFragmentStore.burpActive();
  }
  
  public boolean executePendingTransactions()
  {
    boolean bool = execPendingActions(true);
    forcePostponedTransactions();
    return bool;
  }
  
  @Nullable
  Fragment findActiveFragment(@NonNull String paramString)
  {
    return this.mFragmentStore.findActiveFragment(paramString);
  }
  
  @Nullable
  public Fragment findFragmentById(@IdRes int paramInt)
  {
    return this.mFragmentStore.findFragmentById(paramInt);
  }
  
  @Nullable
  public Fragment findFragmentByTag(@Nullable String paramString)
  {
    return this.mFragmentStore.findFragmentByTag(paramString);
  }
  
  Fragment findFragmentByWho(@NonNull String paramString)
  {
    return this.mFragmentStore.findFragmentByWho(paramString);
  }
  
  int getActiveFragmentCount()
  {
    return this.mFragmentStore.getActiveFragmentCount();
  }
  
  @NonNull
  List<Fragment> getActiveFragments()
  {
    return this.mFragmentStore.getActiveFragments();
  }
  
  @NonNull
  public FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public int getBackStackEntryCount()
  {
    ArrayList localArrayList = this.mBackStack;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  @Nullable
  public Fragment getFragment(@NonNull Bundle paramBundle, @NonNull String paramString)
  {
    paramBundle = paramBundle.getString(paramString);
    if (paramBundle == null) {
      return null;
    }
    Fragment localFragment = findActiveFragment(paramBundle);
    if (localFragment == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment no longer exists for key ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": unique id ");
      localStringBuilder.append(paramBundle);
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    return localFragment;
  }
  
  @NonNull
  public FragmentFactory getFragmentFactory()
  {
    Object localObject = this.mFragmentFactory;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.mParent;
    if (localObject != null) {
      return ((Fragment)localObject).mFragmentManager.getFragmentFactory();
    }
    return this.mHostFragmentFactory;
  }
  
  @NonNull
  public List<Fragment> getFragments()
  {
    return this.mFragmentStore.getFragments();
  }
  
  @NonNull
  LayoutInflater.Factory2 getLayoutInflaterFactory()
  {
    return this.mLayoutInflaterFactory;
  }
  
  @NonNull
  FragmentLifecycleCallbacksDispatcher getLifecycleCallbacksDispatcher()
  {
    return this.mLifecycleCallbacksDispatcher;
  }
  
  @Nullable
  Fragment getParent()
  {
    return this.mParent;
  }
  
  @Nullable
  public Fragment getPrimaryNavigationFragment()
  {
    return this.mPrimaryNav;
  }
  
  @NonNull
  ViewModelStore getViewModelStore(@NonNull Fragment paramFragment)
  {
    return this.mNonConfig.getViewModelStore(paramFragment);
  }
  
  void handleOnBackPressed()
  {
    execPendingActions(true);
    if (this.mOnBackPressedCallback.isEnabled())
    {
      popBackStackImmediate();
      return;
    }
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  void hideFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      paramFragment.mHiddenChanged = (true ^ paramFragment.mHiddenChanged);
      setVisibleRemovingFragment(paramFragment);
    }
  }
  
  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  boolean isParentMenuVisible(@Nullable Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    return paramFragment.isMenuVisible();
  }
  
  boolean isPrimaryNavigation(@Nullable Fragment paramFragment)
  {
    if (paramFragment == null) {
      return true;
    }
    FragmentManager localFragmentManager = paramFragment.mFragmentManager;
    return (paramFragment.equals(localFragmentManager.getPrimaryNavigationFragment())) && (isPrimaryNavigation(localFragmentManager.mParent));
  }
  
  boolean isStateAtLeast(int paramInt)
  {
    return this.mCurState >= paramInt;
  }
  
  public boolean isStateSaved()
  {
    return (this.mStateSaved) || (this.mStopped);
  }
  
  void makeActive(@NonNull Fragment paramFragment)
  {
    if (this.mFragmentStore.containsActiveFragment(paramFragment.mWho)) {
      return;
    }
    Object localObject = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, paramFragment);
    ((FragmentStateManager)localObject).restoreState(this.mHost.getContext().getClassLoader());
    this.mFragmentStore.makeActive((FragmentStateManager)localObject);
    if (paramFragment.mRetainInstanceChangedWhileDetached)
    {
      if (paramFragment.mRetainInstance) {
        addRetainedFragment(paramFragment);
      } else {
        removeRetainedFragment(paramFragment);
      }
      paramFragment.mRetainInstanceChangedWhileDetached = false;
    }
    ((FragmentStateManager)localObject).setFragmentManagerState(this.mCurState);
    if (isLoggingEnabled(2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Added fragment to active set ");
      ((StringBuilder)localObject).append(paramFragment);
      Log.v("FragmentManager", ((StringBuilder)localObject).toString());
    }
  }
  
  void moveFragmentToExpectedState(@NonNull Fragment paramFragment)
  {
    Object localObject;
    if (!this.mFragmentStore.containsActiveFragment(paramFragment.mWho))
    {
      if (isLoggingEnabled(3))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Ignoring moving ");
        ((StringBuilder)localObject).append(paramFragment);
        ((StringBuilder)localObject).append(" to state ");
        ((StringBuilder)localObject).append(this.mCurState);
        ((StringBuilder)localObject).append("since it is not added to ");
        ((StringBuilder)localObject).append(this);
        Log.d("FragmentManager", ((StringBuilder)localObject).toString());
      }
      return;
    }
    moveToState(paramFragment);
    if (paramFragment.mView != null)
    {
      localObject = this.mFragmentStore.findFragmentUnder(paramFragment);
      if (localObject != null)
      {
        localObject = ((Fragment)localObject).mView;
        ViewGroup localViewGroup = paramFragment.mContainer;
        int i = localViewGroup.indexOfChild((View)localObject);
        int j = localViewGroup.indexOfChild(paramFragment.mView);
        if (j < i)
        {
          localViewGroup.removeViewAt(j);
          localViewGroup.addView(paramFragment.mView, i);
        }
      }
      if ((paramFragment.mIsNewlyAdded) && (paramFragment.mContainer != null))
      {
        if (paramFragment.mPostponedAlpha > 0.0F) {
          paramFragment.mView.setAlpha(paramFragment.mPostponedAlpha);
        }
        paramFragment.mPostponedAlpha = 0.0F;
        paramFragment.mIsNewlyAdded = false;
        localObject = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, paramFragment, true);
        if (localObject != null) {
          if (((FragmentAnim.AnimationOrAnimator)localObject).animation != null)
          {
            paramFragment.mView.startAnimation(((FragmentAnim.AnimationOrAnimator)localObject).animation);
          }
          else
          {
            ((FragmentAnim.AnimationOrAnimator)localObject).animator.setTarget(paramFragment.mView);
            ((FragmentAnim.AnimationOrAnimator)localObject).animator.start();
          }
        }
      }
    }
    if (paramFragment.mHiddenChanged) {
      completeShowHideFragment(paramFragment);
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.mCurState)) {
      return;
    }
    this.mCurState = paramInt;
    Object localObject = this.mFragmentStore.getFragments().iterator();
    while (((Iterator)localObject).hasNext()) {
      moveFragmentToExpectedState((Fragment)((Iterator)localObject).next());
    }
    localObject = this.mFragmentStore.getActiveFragments().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject).next();
      if ((localFragment != null) && (!localFragment.mIsNewlyAdded)) {
        moveFragmentToExpectedState(localFragment);
      }
    }
    startPendingDeferredFragments();
    if (this.mNeedMenuInvalidate)
    {
      localObject = this.mHost;
      if ((localObject != null) && (this.mCurState == 4))
      {
        ((FragmentHostCallback)localObject).onSupportInvalidateOptionsMenu();
        this.mNeedMenuInvalidate = false;
      }
    }
  }
  
  void moveToState(@NonNull Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState);
  }
  
  void moveToState(@NonNull Fragment paramFragment, int paramInt)
  {
    Object localObject2 = this.mFragmentStore.getFragmentStateManager(paramFragment.mWho);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, paramFragment);
      ((FragmentStateManager)localObject1).setFragmentManagerState(1);
    }
    int i = Math.min(paramInt, ((FragmentStateManager)localObject1).computeMaxState());
    paramInt = paramFragment.mState;
    ViewGroup localViewGroup = null;
    int j;
    if (paramInt <= i)
    {
      if ((paramFragment.mState < i) && (!this.mExitAnimationCancellationSignals.isEmpty())) {
        cancelExitAnimation(paramFragment);
      }
      paramInt = paramFragment.mState;
      if (paramInt != -1)
      {
        if (paramInt != 0)
        {
          if (paramInt == 1) {
            break label434;
          }
          if (paramInt == 2) {
            break label468;
          }
          if (paramInt == 3) {
            break label478;
          }
          j = i;
          break label984;
        }
      }
      else if (i > -1)
      {
        if (isLoggingEnabled(3))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("moveto ATTACHED: ");
          ((StringBuilder)localObject2).append(paramFragment);
          Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        if (paramFragment.mTarget != null) {
          if (paramFragment.mTarget.equals(findActiveFragment(paramFragment.mTarget.mWho)))
          {
            if (paramFragment.mTarget.mState < 1) {
              moveToState(paramFragment.mTarget, 1);
            }
            paramFragment.mTargetWho = paramFragment.mTarget.mWho;
            paramFragment.mTarget = null;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" declared target fragment ");
            ((StringBuilder)localObject1).append(paramFragment.mTarget);
            ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
            throw new IllegalStateException(((StringBuilder)localObject1).toString());
          }
        }
        if (paramFragment.mTargetWho != null)
        {
          localObject2 = findActiveFragment(paramFragment.mTargetWho);
          if (localObject2 != null)
          {
            if (((Fragment)localObject2).mState < 1) {
              moveToState((Fragment)localObject2, 1);
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" declared target fragment ");
            ((StringBuilder)localObject1).append(paramFragment.mTargetWho);
            ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
            throw new IllegalStateException(((StringBuilder)localObject1).toString());
          }
        }
        ((FragmentStateManager)localObject1).attach(this.mHost, this, this.mParent);
      }
      if (i > 0) {
        ((FragmentStateManager)localObject1).create();
      }
      label434:
      if (i > -1) {
        ((FragmentStateManager)localObject1).ensureInflatedView();
      }
      if (i > 1)
      {
        ((FragmentStateManager)localObject1).createView(this.mContainer);
        ((FragmentStateManager)localObject1).activityCreated();
        ((FragmentStateManager)localObject1).restoreViewState();
      }
      label468:
      if (i > 2) {
        ((FragmentStateManager)localObject1).start();
      }
      label478:
      j = i;
      if (i > 3)
      {
        ((FragmentStateManager)localObject1).resume();
        j = i;
      }
    }
    else
    {
      j = i;
      if (paramFragment.mState > i)
      {
        int k = paramFragment.mState;
        paramInt = i;
        if (k != 0)
        {
          j = 0;
          if (k != 1)
          {
            if (k != 2)
            {
              if (k != 3)
              {
                if (k != 4)
                {
                  j = i;
                  break label984;
                }
                if (i < 4) {
                  ((FragmentStateManager)localObject1).pause();
                }
              }
              if (i < 3) {
                ((FragmentStateManager)localObject1).stop();
              }
            }
            if (i < 2)
            {
              if (isLoggingEnabled(3))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("movefrom ACTIVITY_CREATED: ");
                ((StringBuilder)localObject2).append(paramFragment);
                Log.d("FragmentManager", ((StringBuilder)localObject2).toString());
              }
              if ((paramFragment.mView != null) && (this.mHost.onShouldSaveFragmentState(paramFragment)) && (paramFragment.mSavedViewState == null)) {
                ((FragmentStateManager)localObject1).saveViewState();
              }
              if ((paramFragment.mView != null) && (paramFragment.mContainer != null))
              {
                paramFragment.mContainer.endViewTransition(paramFragment.mView);
                paramFragment.mView.clearAnimation();
                if (!paramFragment.isRemovingParent())
                {
                  localObject2 = localViewGroup;
                  if (this.mCurState > -1)
                  {
                    localObject2 = localViewGroup;
                    if (!this.mDestroyed)
                    {
                      localObject2 = localViewGroup;
                      if (paramFragment.mView.getVisibility() == 0)
                      {
                        localObject2 = localViewGroup;
                        if (paramFragment.mPostponedAlpha >= 0.0F) {
                          localObject2 = FragmentAnim.loadAnimation(this.mHost.getContext(), this.mContainer, paramFragment, false);
                        }
                      }
                    }
                  }
                  paramFragment.mPostponedAlpha = 0.0F;
                  localViewGroup = paramFragment.mContainer;
                  View localView = paramFragment.mView;
                  if (localObject2 != null)
                  {
                    paramFragment.setStateAfterAnimating(i);
                    FragmentAnim.animateRemoveFragment(paramFragment, (FragmentAnim.AnimationOrAnimator)localObject2, this.mFragmentTransitionCallback);
                  }
                  localViewGroup.removeView(localView);
                  if (localViewGroup != paramFragment.mContainer) {
                    return;
                  }
                }
              }
              if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {
                destroyFragmentView(paramFragment);
              } else {
                paramFragment.setStateAfterAnimating(i);
              }
            }
          }
          paramInt = i;
          if (i < 1)
          {
            paramInt = j;
            if (paramFragment.mRemoving)
            {
              paramInt = j;
              if (!paramFragment.isInBackStack()) {
                paramInt = 1;
              }
            }
            if ((paramInt == 0) && (!this.mNonConfig.shouldDestroy(paramFragment)))
            {
              if (paramFragment.mTargetWho != null)
              {
                localObject2 = findActiveFragment(paramFragment.mTargetWho);
                if ((localObject2 != null) && (((Fragment)localObject2).getRetainInstance())) {
                  paramFragment.mTarget = ((Fragment)localObject2);
                }
              }
            }
            else {
              makeInactive((FragmentStateManager)localObject1);
            }
            if (this.mExitAnimationCancellationSignals.get(paramFragment) != null)
            {
              paramFragment.setStateAfterAnimating(i);
              paramInt = 1;
            }
            else
            {
              ((FragmentStateManager)localObject1).destroy(this.mHost, this.mNonConfig);
              paramInt = i;
            }
          }
        }
        j = paramInt;
        if (paramInt < 0)
        {
          ((FragmentStateManager)localObject1).detach(this.mNonConfig);
          j = paramInt;
        }
      }
    }
    label984:
    if (paramFragment.mState != j)
    {
      if (isLoggingEnabled(3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("moveToState: Fragment state for ");
        ((StringBuilder)localObject1).append(paramFragment);
        ((StringBuilder)localObject1).append(" not updated inline; expected state ");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(" found ");
        ((StringBuilder)localObject1).append(paramFragment.mState);
        Log.d("FragmentManager", ((StringBuilder)localObject1).toString());
      }
      paramFragment.mState = j;
    }
  }
  
  void noteStateNotSaved()
  {
    if (this.mHost == null) {
      return;
    }
    this.mStateSaved = false;
    this.mStopped = false;
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment != null) {
        localFragment.noteStateNotSaved();
      }
    }
  }
  
  @Deprecated
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public FragmentTransaction openTransaction()
  {
    return beginTransaction();
  }
  
  void performPendingDeferredStart(@NonNull Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (this.mExecutingActions)
      {
        this.mHavePendingDeferredStart = true;
        return;
      }
      paramFragment.mDeferStart = false;
      moveToState(paramFragment, this.mCurState);
    }
  }
  
  public void popBackStack()
  {
    enqueueAction(new FragmentManager.PopBackStackState(this, null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      enqueueAction(new FragmentManager.PopBackStackState(this, null, paramInt1, paramInt2), false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad id: ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void popBackStack(@Nullable String paramString, int paramInt)
  {
    enqueueAction(new FragmentManager.PopBackStackState(this, paramString, -1, paramInt), false);
  }
  
  public boolean popBackStackImmediate()
  {
    return popBackStackImmediate(null, -1, 0);
  }
  
  public boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0) {
      return popBackStackImmediate(null, paramInt1, paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bad id: ");
    localStringBuilder.append(paramInt1);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public boolean popBackStackImmediate(@Nullable String paramString, int paramInt)
  {
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.mBackStack;
    if (localObject == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = ((ArrayList)localObject).size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
      return true;
    }
    int j;
    if ((paramString == null) && (paramInt1 < 0))
    {
      j = -1;
    }
    else
    {
      int i = this.mBackStack.size() - 1;
      while (i >= 0)
      {
        localObject = (BackStackRecord)this.mBackStack.get(i);
        if (((paramString != null) && (paramString.equals(((BackStackRecord)localObject).getName()))) || ((paramInt1 >= 0) && (paramInt1 == ((BackStackRecord)localObject).mIndex))) {
          break;
        }
        i -= 1;
      }
      if (i < 0) {
        return false;
      }
      j = i;
      if ((paramInt2 & 0x1) != 0) {
        for (;;)
        {
          paramInt2 = i - 1;
          j = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject = (BackStackRecord)this.mBackStack.get(paramInt2);
          if (paramString != null)
          {
            i = paramInt2;
            if (paramString.equals(((BackStackRecord)localObject).getName())) {}
          }
          else
          {
            j = paramInt2;
            if (paramInt1 < 0) {
              break;
            }
            j = paramInt2;
            if (paramInt1 != ((BackStackRecord)localObject).mIndex) {
              break;
            }
            i = paramInt2;
          }
        }
      }
    }
    if (j == this.mBackStack.size() - 1) {
      return false;
    }
    paramInt1 = this.mBackStack.size() - 1;
    while (paramInt1 > j)
    {
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
      paramInt1 -= 1;
    }
    return true;
  }
  
  public void putFragment(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull Fragment paramFragment)
  {
    if (paramFragment.mFragmentManager != this)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    paramBundle.putString(paramString, paramFragment.mWho);
  }
  
  public void registerFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks, boolean paramBoolean)
  {
    this.mLifecycleCallbacksDispatcher.registerFragmentLifecycleCallbacks(paramFragmentLifecycleCallbacks, paramBoolean);
  }
  
  void removeCancellationSignal(@NonNull Fragment paramFragment, @NonNull CancellationSignal paramCancellationSignal)
  {
    HashSet localHashSet = (HashSet)this.mExitAnimationCancellationSignals.get(paramFragment);
    if ((localHashSet != null) && (localHashSet.remove(paramCancellationSignal)) && (localHashSet.isEmpty()))
    {
      this.mExitAnimationCancellationSignals.remove(paramFragment);
      if (paramFragment.mState < 3)
      {
        destroyFragmentView(paramFragment);
        moveToState(paramFragment, paramFragment.getStateAfterAnimating());
      }
    }
  }
  
  void removeFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("remove: ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" nesting=");
      localStringBuilder.append(paramFragment.mBackStackNesting);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    boolean bool = paramFragment.isInBackStack();
    if ((!paramFragment.mDetached) || ((bool ^ true)))
    {
      this.mFragmentStore.removeFragment(paramFragment);
      if (isMenuAvailable(paramFragment)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mRemoving = true;
      setVisibleRemovingFragment(paramFragment);
    }
  }
  
  public void removeOnBackStackChangedListener(@NonNull FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    ArrayList localArrayList = this.mBackStackChangeListeners;
    if (localArrayList != null) {
      localArrayList.remove(paramOnBackStackChangedListener);
    }
  }
  
  void removeRetainedFragment(@NonNull Fragment paramFragment)
  {
    if (isStateSaved())
    {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
      return;
    }
    if ((this.mNonConfig.removeRetainedFragment(paramFragment)) && (isLoggingEnabled(2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Updating retained Fragments: Removed ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
  }
  
  void restoreAllState(@Nullable Parcelable paramParcelable, @Nullable FragmentManagerNonConfig paramFragmentManagerNonConfig)
  {
    if ((this.mHost instanceof ViewModelStoreOwner)) {
      throwException(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
    }
    this.mNonConfig.restoreFromSnapshot(paramFragmentManagerNonConfig);
    restoreSaveState(paramParcelable);
  }
  
  void restoreSaveState(@Nullable Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return;
    }
    FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
    if (localFragmentManagerState.mActive == null) {
      return;
    }
    this.mFragmentStore.resetActiveFragments();
    Object localObject1 = localFragmentManagerState.mActive.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      paramParcelable = (FragmentState)((Iterator)localObject1).next();
      if (paramParcelable != null)
      {
        localObject2 = this.mNonConfig.findRetainedFragmentByWho(paramParcelable.mWho);
        StringBuilder localStringBuilder;
        if (localObject2 != null)
        {
          if (isLoggingEnabled(2))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("restoreSaveState: re-attaching retained ");
            localStringBuilder.append(localObject2);
            Log.v("FragmentManager", localStringBuilder.toString());
          }
          paramParcelable = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, (Fragment)localObject2, paramParcelable);
        }
        else
        {
          paramParcelable = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mHost.getContext().getClassLoader(), getFragmentFactory(), paramParcelable);
        }
        localObject2 = paramParcelable.getFragment();
        ((Fragment)localObject2).mFragmentManager = this;
        if (isLoggingEnabled(2))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("restoreSaveState: active (");
          localStringBuilder.append(((Fragment)localObject2).mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localObject2);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
        paramParcelable.restoreState(this.mHost.getContext().getClassLoader());
        this.mFragmentStore.makeActive(paramParcelable);
        paramParcelable.setFragmentManagerState(this.mCurState);
      }
    }
    paramParcelable = this.mNonConfig.getRetainedFragments().iterator();
    while (paramParcelable.hasNext())
    {
      localObject1 = (Fragment)paramParcelable.next();
      if (!this.mFragmentStore.containsActiveFragment(((Fragment)localObject1).mWho))
      {
        if (isLoggingEnabled(2))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Discarding retained Fragment ");
          ((StringBuilder)localObject2).append(localObject1);
          ((StringBuilder)localObject2).append(" that was not found in the set of active Fragments ");
          ((StringBuilder)localObject2).append(localFragmentManagerState.mActive);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
        moveToState((Fragment)localObject1, 1);
        ((Fragment)localObject1).mRemoving = true;
        moveToState((Fragment)localObject1, -1);
      }
    }
    this.mFragmentStore.restoreAddedFragments(localFragmentManagerState.mAdded);
    if (localFragmentManagerState.mBackStack != null)
    {
      this.mBackStack = new ArrayList(localFragmentManagerState.mBackStack.length);
      int i = 0;
      while (i < localFragmentManagerState.mBackStack.length)
      {
        paramParcelable = localFragmentManagerState.mBackStack[i].instantiate(this);
        if (isLoggingEnabled(2))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("restoreAllState: back stack #");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(" (index ");
          ((StringBuilder)localObject1).append(paramParcelable.mIndex);
          ((StringBuilder)localObject1).append("): ");
          ((StringBuilder)localObject1).append(paramParcelable);
          Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          localObject1 = new PrintWriter(new LogWriter("FragmentManager"));
          paramParcelable.dump("  ", (PrintWriter)localObject1, false);
          ((PrintWriter)localObject1).close();
        }
        this.mBackStack.add(paramParcelable);
        i += 1;
      }
    }
    this.mBackStack = null;
    this.mBackStackIndex.set(localFragmentManagerState.mBackStackIndex);
    if (localFragmentManagerState.mPrimaryNavActiveWho != null)
    {
      this.mPrimaryNav = findActiveFragment(localFragmentManagerState.mPrimaryNavActiveWho);
      dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }
  }
  
  @Deprecated
  FragmentManagerNonConfig retainNonConfig()
  {
    if ((this.mHost instanceof ViewModelStoreOwner)) {
      throwException(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
    }
    return this.mNonConfig.getSnapshot();
  }
  
  Parcelable saveAllState()
  {
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions(true);
    this.mStateSaved = true;
    ArrayList localArrayList1 = this.mFragmentStore.saveActiveFragments();
    boolean bool = localArrayList1.isEmpty();
    Object localObject2 = null;
    if (bool)
    {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "saveAllState: no fragments!");
      }
      return null;
    }
    ArrayList localArrayList2 = this.mFragmentStore.saveAddedFragments();
    ArrayList localArrayList3 = this.mBackStack;
    Object localObject1 = localObject2;
    if (localArrayList3 != null)
    {
      int j = localArrayList3.size();
      localObject1 = localObject2;
      if (j > 0)
      {
        localObject2 = new BackStackState[j];
        int i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= j) {
            break;
          }
          localObject2[i] = new BackStackState((BackStackRecord)this.mBackStack.get(i));
          if (isLoggingEnabled(2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("saveAllState: adding back stack #");
            ((StringBuilder)localObject1).append(i);
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append(this.mBackStack.get(i));
            Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
          }
          i += 1;
        }
      }
    }
    localObject2 = new FragmentManagerState();
    ((FragmentManagerState)localObject2).mActive = localArrayList1;
    ((FragmentManagerState)localObject2).mAdded = localArrayList2;
    ((FragmentManagerState)localObject2).mBackStack = ((BackStackState[])localObject1);
    ((FragmentManagerState)localObject2).mBackStackIndex = this.mBackStackIndex.get();
    localObject1 = this.mPrimaryNav;
    if (localObject1 != null) {
      ((FragmentManagerState)localObject2).mPrimaryNavActiveWho = ((Fragment)localObject1).mWho;
    }
    return localObject2;
  }
  
  @Nullable
  public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment paramFragment)
  {
    FragmentStateManager localFragmentStateManager = this.mFragmentStore.getFragmentStateManager(paramFragment.mWho);
    if ((localFragmentStateManager == null) || (!localFragmentStateManager.getFragment().equals(paramFragment)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      throwException(new IllegalStateException(localStringBuilder.toString()));
    }
    return localFragmentStateManager.saveInstanceState();
  }
  
  void scheduleCommit()
  {
    for (;;)
    {
      int j;
      synchronized (this.mPendingActions)
      {
        ArrayList localArrayList2 = this.mPostponedTransactions;
        j = 0;
        if ((localArrayList2 != null) && (!this.mPostponedTransactions.isEmpty()))
        {
          i = 1;
          if (this.mPendingActions.size() != 1) {
            break label99;
          }
          j = 1;
          break label99;
          this.mHost.getHandler().removeCallbacks(this.mExecCommit);
          this.mHost.getHandler().post(this.mExecCommit);
          updateOnBackPressedCallbackEnabled();
          return;
        }
      }
      int i = 0;
      continue;
      label99:
      if (i == 0) {
        if (j == 0) {}
      }
    }
  }
  
  void setExitAnimationOrder(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = getFragmentContainer(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof FragmentContainerView))) {
      ((FragmentContainerView)paramFragment).setDrawDisappearingViewsLast(paramBoolean ^ true);
    }
  }
  
  public void setFragmentFactory(@NonNull FragmentFactory paramFragmentFactory)
  {
    this.mFragmentFactory = paramFragmentFactory;
  }
  
  void setMaxLifecycle(@NonNull Fragment paramFragment, @NonNull Lifecycle.State paramState)
  {
    if ((paramFragment.equals(findActiveFragment(paramFragment.mWho))) && ((paramFragment.mHost == null) || (paramFragment.mFragmentManager == this)))
    {
      paramFragment.mMaxState = paramState;
      return;
    }
    paramState = new StringBuilder();
    paramState.append("Fragment ");
    paramState.append(paramFragment);
    paramState.append(" is not an active fragment of FragmentManager ");
    paramState.append(this);
    throw new IllegalArgumentException(paramState.toString());
  }
  
  void setPrimaryNavigationFragment(@Nullable Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(findActiveFragment(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Fragment ");
      ((StringBuilder)localObject).append(paramFragment);
      ((StringBuilder)localObject).append(" is not an active fragment of FragmentManager ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = this.mPrimaryNav;
    this.mPrimaryNav = paramFragment;
    dispatchParentPrimaryNavigationFragmentChanged((Fragment)localObject);
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  void showFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("show: ");
      localStringBuilder.append(paramFragment);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      paramFragment.mHiddenChanged ^= true;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Object localObject = this.mParent;
    if (localObject != null)
    {
      localStringBuilder.append(localObject.getClass().getSimpleName());
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mParent)));
      localStringBuilder.append("}");
    }
    else
    {
      localObject = this.mHost;
      if (localObject != null)
      {
        localStringBuilder.append(localObject.getClass().getSimpleName());
        localStringBuilder.append("{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        localStringBuilder.append("}");
      }
      else
      {
        localStringBuilder.append("null");
      }
    }
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(paramFragmentLifecycleCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */