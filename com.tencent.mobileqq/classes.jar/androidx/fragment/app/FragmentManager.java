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
    if (this.mCurState < 1) {}
    for (;;)
    {
      return;
      int i = Math.min(this.mCurState, 3);
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
    if (isStateSaved()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
  }
  
  private void cleanupExec()
  {
    this.mExecutingActions = false;
    this.mTmpIsPop.clear();
    this.mTmpRecords.clear();
  }
  
  private void completeShowHideFragment(@NonNull Fragment paramFragment)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramFragment.mView != null)
    {
      localObject1 = this.mHost.getContext();
      localObject2 = this.mContainer;
      if (paramFragment.mHidden) {
        break label128;
      }
      bool = true;
      localObject1 = FragmentAnim.loadAnimation((Context)localObject1, (FragmentContainer)localObject2, paramFragment, bool);
      if ((localObject1 == null) || (((FragmentAnim.AnimationOrAnimator)localObject1).animator == null)) {
        break label187;
      }
      ((FragmentAnim.AnimationOrAnimator)localObject1).animator.setTarget(paramFragment.mView);
      if (!paramFragment.mHidden) {
        break label176;
      }
      if (!paramFragment.isHideReplaced()) {
        break label133;
      }
      paramFragment.setHideReplaced(false);
    }
    for (;;)
    {
      ((FragmentAnim.AnimationOrAnimator)localObject1).animator.start();
      if ((paramFragment.mAdded) && (isMenuAvailable(paramFragment))) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.mHiddenChanged = false;
      paramFragment.onHiddenChanged(paramFragment.mHidden);
      return;
      label128:
      bool = false;
      break;
      label133:
      localObject2 = paramFragment.mContainer;
      View localView = paramFragment.mView;
      ((ViewGroup)localObject2).startViewTransition(localView);
      ((FragmentAnim.AnimationOrAnimator)localObject1).animator.addListener(new FragmentManager.5(this, (ViewGroup)localObject2, localView, paramFragment));
      continue;
      label176:
      paramFragment.mView.setVisibility(0);
    }
    label187:
    if (localObject1 != null)
    {
      paramFragment.mView.startAnimation(((FragmentAnim.AnimationOrAnimator)localObject1).animation);
      ((FragmentAnim.AnimationOrAnimator)localObject1).animation.start();
    }
    if ((paramFragment.mHidden) && (!paramFragment.isHideReplaced())) {}
    for (int i = 8;; i = 0)
    {
      paramFragment.mView.setVisibility(i);
      if (!paramFragment.isHideReplaced()) {
        break;
      }
      paramFragment.setHideReplaced(false);
      break;
    }
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
    if (this.mExecutingActions) {
      throw new IllegalStateException("FragmentManager is already executing transactions");
    }
    if (this.mHost == null)
    {
      if (this.mDestroyed) {
        throw new IllegalStateException("FragmentManager has been destroyed");
      }
      throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }
    if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
      throw new IllegalStateException("Must be called from main thread of fragment host");
    }
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
  
  private static void executeOps(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      BackStackRecord localBackStackRecord = (BackStackRecord)paramArrayList.get(paramInt1);
      boolean bool;
      if (((Boolean)paramArrayList1.get(paramInt1)).booleanValue())
      {
        localBackStackRecord.bumpBackStackNesting(-1);
        if (paramInt1 == paramInt2 - 1)
        {
          bool = true;
          label45:
          localBackStackRecord.executePopOps(bool);
        }
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        bool = false;
        break label45;
        localBackStackRecord.bumpBackStackNesting(1);
        localBackStackRecord.executeOps();
      }
    }
  }
  
  private void executeOpsTogether(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2)
  {
    boolean bool = ((BackStackRecord)paramArrayList.get(paramInt1)).mReorderingAllowed;
    Object localObject;
    int j;
    label58:
    BackStackRecord localBackStackRecord;
    if (this.mTmpAddedFragments == null)
    {
      this.mTmpAddedFragments = new ArrayList();
      this.mTmpAddedFragments.addAll(this.mFragmentStore.getFragments());
      localObject = getPrimaryNavigationFragment();
      j = paramInt1;
      i = 0;
      if (j >= paramInt2) {
        break label161;
      }
      localBackStackRecord = (BackStackRecord)paramArrayList.get(j);
      if (((Boolean)paramArrayList1.get(j)).booleanValue()) {
        break label139;
      }
      localObject = localBackStackRecord.expandOps(this.mTmpAddedFragments, (Fragment)localObject);
      label104:
      if ((i == 0) && (!localBackStackRecord.mAddToBackStack)) {
        break label155;
      }
    }
    label139:
    label155:
    for (int i = 1;; i = 0)
    {
      j += 1;
      break label58;
      this.mTmpAddedFragments.clear();
      break;
      localObject = localBackStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments, (Fragment)localObject);
      break label104;
    }
    label161:
    this.mTmpAddedFragments.clear();
    if (!bool) {
      FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, paramInt2, false, this.mFragmentTransitionCallback);
    }
    executeOps(paramArrayList, paramArrayList1, paramInt1, paramInt2);
    if (bool)
    {
      localObject = new ArraySet();
      addAddedFragments((ArraySet)localObject);
      j = postponePostponableTransactions(paramArrayList, paramArrayList1, paramInt1, paramInt2, (ArraySet)localObject);
      makeRemovedFragmentsInvisible((ArraySet)localObject);
    }
    for (;;)
    {
      int k = paramInt1;
      if (j != paramInt1)
      {
        k = paramInt1;
        if (bool)
        {
          FragmentTransition.startTransitions(this, paramArrayList, paramArrayList1, paramInt1, j, true, this.mFragmentTransitionCallback);
          moveToState(this.mCurState, true);
          k = paramInt1;
        }
      }
      while (k < paramInt2)
      {
        localObject = (BackStackRecord)paramArrayList.get(k);
        if ((((Boolean)paramArrayList1.get(k)).booleanValue()) && (((BackStackRecord)localObject).mIndex >= 0)) {
          ((BackStackRecord)localObject).mIndex = -1;
        }
        ((BackStackRecord)localObject).runOnCommitRunnables();
        k += 1;
      }
      if (i != 0) {
        reportBackStackChanged();
      }
      return;
      j = paramInt2;
    }
  }
  
  private void executePostponedTransaction(@Nullable ArrayList<BackStackRecord> paramArrayList, @Nullable ArrayList<Boolean> paramArrayList1)
  {
    int i;
    int j;
    label12:
    FragmentManager.StartEnterTransitionListener localStartEnterTransitionListener;
    int k;
    if (this.mPostponedTransactions == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      localStartEnterTransitionListener = (FragmentManager.StartEnterTransitionListener)this.mPostponedTransactions.get(j);
      if ((paramArrayList == null) || (localStartEnterTransitionListener.mIsBack)) {
        break label125;
      }
      k = paramArrayList.indexOf(localStartEnterTransitionListener.mRecord);
      if ((k == -1) || (paramArrayList1 == null) || (!((Boolean)paramArrayList1.get(k)).booleanValue())) {
        break label125;
      }
      this.mPostponedTransactions.remove(j);
      localStartEnterTransitionListener.cancelTransaction();
      j -= 1;
      i -= 1;
    }
    for (;;)
    {
      j += 1;
      break label12;
      i = this.mPostponedTransactions.size();
      break;
      label125:
      int m;
      if (!localStartEnterTransitionListener.isReady())
      {
        m = j;
        k = i;
        if (paramArrayList != null)
        {
          m = j;
          k = i;
          if (!localStartEnterTransitionListener.mRecord.interactsWith(paramArrayList, 0, paramArrayList.size())) {}
        }
      }
      else
      {
        this.mPostponedTransactions.remove(j);
        m = j - 1;
        k = i - 1;
        if ((paramArrayList != null) && (!localStartEnterTransitionListener.mIsBack))
        {
          i = paramArrayList.indexOf(localStartEnterTransitionListener.mRecord);
          if ((i != -1) && (paramArrayList1 != null) && (((Boolean)paramArrayList1.get(i)).booleanValue()))
          {
            localStartEnterTransitionListener.cancelTransaction();
            j = m;
            i = k;
            continue;
          }
        }
        localStartEnterTransitionListener.completeTransaction();
      }
      j = m;
      i = k;
    }
  }
  
  @NonNull
  public static <F extends Fragment> F findFragment(@NonNull View paramView)
  {
    Fragment localFragment = findViewFragment(paramView);
    if (localFragment == null) {
      throw new IllegalStateException("View " + paramView + " does not have a Fragment set");
    }
    return localFragment;
  }
  
  @NonNull
  static FragmentManager findFragmentManager(@NonNull View paramView)
  {
    Object localObject = findViewFragment(paramView);
    if (localObject != null) {
      return ((Fragment)localObject).getChildFragmentManager();
    }
    localObject = paramView.getContext();
    if ((localObject instanceof ContextWrapper)) {
      if (!(localObject instanceof FragmentActivity)) {}
    }
    for (localObject = (FragmentActivity)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        return ((FragmentActivity)localObject).getSupportFragmentManager();
        localObject = ((ContextWrapper)localObject).getBaseContext();
        break;
      }
      throw new IllegalStateException("View " + paramView + " is not within a subclass of FragmentActivity.");
    }
  }
  
  @Nullable
  private static Fragment findViewFragment(@NonNull View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = getViewFragment(paramView);
      if (localObject1 == null) {}
    }
    else
    {
      return localObject1;
    }
    paramView = paramView.getParent();
    if ((paramView instanceof View)) {}
    for (paramView = (View)paramView;; paramView = null) {
      break;
    }
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
      if (this.mPendingActions.isEmpty()) {
        return false;
      }
      int j = this.mPendingActions.size();
      int i = 0;
      boolean bool = false;
      while (i < j)
      {
        bool |= ((FragmentManager.OpGenerator)this.mPendingActions.get(i)).generateOps(paramArrayList, paramArrayList1);
        i += 1;
      }
      this.mPendingActions.clear();
      this.mHost.getHandler().removeCallbacks(this.mExecCommit);
      return bool;
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
    paramView = paramView.getTag(2131367439);
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
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "Removed fragment from active set " + localFragment);
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
    if ((this.mPrimaryNav != null) && (paramInt1 < 0) && (paramString == null) && (this.mPrimaryNav.getChildFragmentManager().popBackStackImmediate())) {
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
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      this.mFragmentStore.burpActive();
      return bool;
    }
    finally
    {
      cleanupExec();
    }
  }
  
  private int postponePostponableTransactions(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, @NonNull ArraySet<Fragment> paramArraySet)
  {
    int j = paramInt2 - 1;
    int i = paramInt2;
    BackStackRecord localBackStackRecord;
    int k;
    if (j >= paramInt1)
    {
      localBackStackRecord = (BackStackRecord)paramArrayList.get(j);
      boolean bool = ((Boolean)paramArrayList1.get(j)).booleanValue();
      if ((localBackStackRecord.isPostponed()) && (!localBackStackRecord.interactsWith(paramArrayList, j + 1, paramInt2)))
      {
        k = 1;
        label67:
        if (k == 0) {
          break label191;
        }
        if (this.mPostponedTransactions == null) {
          this.mPostponedTransactions = new ArrayList();
        }
        FragmentManager.StartEnterTransitionListener localStartEnterTransitionListener = new FragmentManager.StartEnterTransitionListener(localBackStackRecord, bool);
        this.mPostponedTransactions.add(localStartEnterTransitionListener);
        localBackStackRecord.setOnStartPostponedListener(localStartEnterTransitionListener);
        if (!bool) {
          break label179;
        }
        localBackStackRecord.executeOps();
        label130:
        i -= 1;
        if (j != i)
        {
          paramArrayList.remove(j);
          paramArrayList.add(i, localBackStackRecord);
        }
        addAddedFragments(paramArraySet);
      }
    }
    label179:
    label191:
    for (;;)
    {
      j -= 1;
      break;
      k = 0;
      break label67;
      localBackStackRecord.executePopOps(false);
      break label130;
      return i;
    }
  }
  
  private void removeRedundantOperationsAndExecute(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1)
  {
    int i = 0;
    if (paramArrayList.isEmpty()) {
      return;
    }
    if (paramArrayList.size() != paramArrayList1.size()) {
      throw new IllegalStateException("Internal error with the back stack records");
    }
    executePostponedTransaction(paramArrayList, paramArrayList1);
    int m = paramArrayList.size();
    int j = 0;
    label47:
    if (i < m)
    {
      if (((BackStackRecord)paramArrayList.get(i)).mReorderingAllowed) {
        break label212;
      }
      if (j != i) {
        executeOpsTogether(paramArrayList, paramArrayList1, j, i);
      }
      int k = i + 1;
      j = k;
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        for (;;)
        {
          j = k;
          if (k >= m) {
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
      i = j;
      k = j - 1;
      j = i;
      i = k;
    }
    label212:
    for (;;)
    {
      i += 1;
      break label47;
      if (j == m) {
        break;
      }
      executeOpsTogether(paramArrayList, paramArrayList1, j, m);
      return;
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
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private void setVisibleRemovingFragment(@NonNull Fragment paramFragment)
  {
    ViewGroup localViewGroup = getFragmentContainer(paramFragment);
    if (localViewGroup != null)
    {
      if (localViewGroup.getTag(2131381729) == null) {
        localViewGroup.setTag(2131381729, paramFragment);
      }
      ((Fragment)localViewGroup.getTag(2131381729)).setNextAnim(paramFragment.getNextAnim());
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
    if (this.mHost != null) {}
    for (;;)
    {
      try
      {
        this.mHost.onDump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  private void updateOnBackPressedCallbackEnabled()
  {
    for (boolean bool = true;; bool = false) {
      synchronized (this.mPendingActions)
      {
        if (!this.mPendingActions.isEmpty())
        {
          this.mOnBackPressedCallback.setEnabled(true);
          return;
        }
        ??? = this.mOnBackPressedCallback;
        if ((getBackStackEntryCount() > 0) && (isPrimaryNavigation(this.mParent)))
        {
          ((OnBackPressedCallback)???).setEnabled(bool);
          return;
        }
      }
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
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "add: " + paramFragment);
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
    if (isStateSaved()) {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
      }
    }
    while ((!this.mNonConfig.addRetainedFragment(paramFragment)) || (!isLoggingEnabled(2))) {
      return;
    }
    Log.v("FragmentManager", "Updating retained Fragments: Added " + paramFragment);
  }
  
  int allocBackStackIndex()
  {
    return this.mBackStackIndex.getAndIncrement();
  }
  
  void attachController(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentContainer paramFragmentContainer, @Nullable Fragment paramFragment)
  {
    if (this.mHost != null) {
      throw new IllegalStateException("Already attached");
    }
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
  }
  
  void attachFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        this.mFragmentStore.addFragment(paramFragment);
        if (isLoggingEnabled(2)) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
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
    boolean bool3 = false;
    Iterator localIterator = this.mFragmentStore.getActiveFragments().iterator();
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if (localFragment == null) {
        break label65;
      }
      bool1 = isMenuAvailable(localFragment);
    }
    label65:
    for (;;)
    {
      if (bool1)
      {
        bool2 = true;
        return bool2;
      }
      break;
    }
  }
  
  void completeExecute(@NonNull BackStackRecord paramBackStackRecord, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    Object localObject2;
    if (paramBoolean1)
    {
      paramBackStackRecord.executePopOps(paramBoolean3);
      localObject1 = new ArrayList(1);
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject1).add(paramBackStackRecord);
      ((ArrayList)localObject2).add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        FragmentTransition.startTransitions(this, (ArrayList)localObject1, (ArrayList)localObject2, 0, 1, true, this.mFragmentTransitionCallback);
      }
      if (paramBoolean3) {
        moveToState(this.mCurState, true);
      }
      localObject1 = this.mFragmentStore.getActiveFragments().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        return;
      }
      localObject2 = (Fragment)((Iterator)localObject1).next();
      if ((localObject2 != null) && (((Fragment)localObject2).mView != null) && (((Fragment)localObject2).mIsNewlyAdded) && (paramBackStackRecord.interactsWith(((Fragment)localObject2).mContainerId)))
      {
        if (((Fragment)localObject2).mPostponedAlpha > 0.0F) {
          ((Fragment)localObject2).mView.setAlpha(((Fragment)localObject2).mPostponedAlpha);
        }
        if (paramBoolean3)
        {
          ((Fragment)localObject2).mPostponedAlpha = 0.0F;
          continue;
          paramBackStackRecord.executeOps();
          break;
        }
        ((Fragment)localObject2).mPostponedAlpha = -1.0F;
        ((Fragment)localObject2).mIsNewlyAdded = false;
      }
    }
  }
  
  void detachFragment(@NonNull Fragment paramFragment)
  {
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (isLoggingEnabled(2)) {
          Log.v("FragmentManager", "remove from detach: " + paramFragment);
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
    int i = 0;
    if (this.mCurState < 1) {
      return false;
    }
    Object localObject1 = null;
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment == null) || (!isParentMenuVisible(localFragment)) || (!localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))) {
        break label178;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
      ((ArrayList)localObject2).add(localFragment);
      bool = true;
      localObject1 = localObject2;
    }
    label178:
    for (;;)
    {
      break;
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
    if (this.mCurState < 1) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mFragmentStore.getFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
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
    if (this.mCurState < 1) {
      return false;
    }
    Iterator localIterator = this.mFragmentStore.getFragments().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)localIterator.next();
      if ((localFragment == null) || (!localFragment.performPrepareOptionsMenu(paramMenu))) {
        break label66;
      }
      bool = true;
    }
    label66:
    for (;;)
    {
      break;
      return bool;
    }
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
    int j = 0;
    String str = paramString + "    ";
    this.mFragmentStore.dump(paramString, ???, paramPrintWriter, paramArrayOfString);
    int k;
    int i;
    if (this.mCreatedMenus != null)
    {
      k = this.mCreatedMenus.size();
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
    if (this.mBackStack != null)
    {
      k = this.mBackStack.size();
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
          ???.dump(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
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
    }
    this.mPendingActions.add(paramOpGenerator);
    scheduleCommit();
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
      updateOnBackPressedCallbackEnabled();
      doPendingDeferredStart();
      this.mFragmentStore.burpActive();
      return;
    }
    finally
    {
      cleanupExec();
    }
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
    if (this.mBackStack != null) {
      return this.mBackStack.size();
    }
    return 0;
  }
  
  @Nullable
  public Fragment getFragment(@NonNull Bundle paramBundle, @NonNull String paramString)
  {
    String str = paramBundle.getString(paramString);
    if (str == null) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      localFragment = findActiveFragment(str);
      paramBundle = localFragment;
    } while (localFragment != null);
    throwException(new IllegalStateException("Fragment no longer exists for key " + paramString + ": unique id " + str));
    return localFragment;
  }
  
  @NonNull
  public FragmentFactory getFragmentFactory()
  {
    if (this.mFragmentFactory != null) {
      return this.mFragmentFactory;
    }
    if (this.mParent != null) {
      return this.mParent.mFragmentManager.getFragmentFactory();
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
    boolean bool = true;
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mHiddenChanged) {
        break label65;
      }
    }
    for (;;)
    {
      paramFragment.mHiddenChanged = bool;
      setVisibleRemovingFragment(paramFragment);
      return;
      label65:
      bool = false;
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
    if (paramFragment == null) {}
    FragmentManager localFragmentManager;
    do
    {
      return true;
      localFragmentManager = paramFragment.mFragmentManager;
    } while ((paramFragment.equals(localFragmentManager.getPrimaryNavigationFragment())) && (isPrimaryNavigation(localFragmentManager.mParent)));
    return false;
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
    FragmentStateManager localFragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, paramFragment);
    localFragmentStateManager.restoreState(this.mHost.getContext().getClassLoader());
    this.mFragmentStore.makeActive(localFragmentStateManager);
    if (paramFragment.mRetainInstanceChangedWhileDetached)
    {
      if (!paramFragment.mRetainInstance) {
        break label116;
      }
      addRetainedFragment(paramFragment);
    }
    for (;;)
    {
      paramFragment.mRetainInstanceChangedWhileDetached = false;
      localFragmentStateManager.setFragmentManagerState(this.mCurState);
      if (!isLoggingEnabled(2)) {
        break;
      }
      Log.v("FragmentManager", "Added fragment to active set " + paramFragment);
      return;
      label116:
      removeRetainedFragment(paramFragment);
    }
  }
  
  void moveFragmentToExpectedState(@NonNull Fragment paramFragment)
  {
    if (!this.mFragmentStore.containsActiveFragment(paramFragment.mWho)) {
      if (isLoggingEnabled(3)) {
        Log.d("FragmentManager", "Ignoring moving " + paramFragment + " to state " + this.mCurState + "since it is not added to " + this);
      }
    }
    for (;;)
    {
      return;
      moveToState(paramFragment);
      Object localObject;
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
          if (localObject != null)
          {
            if (((FragmentAnim.AnimationOrAnimator)localObject).animation == null) {
              break label250;
            }
            paramFragment.mView.startAnimation(((FragmentAnim.AnimationOrAnimator)localObject).animation);
          }
        }
      }
      while (paramFragment.mHiddenChanged)
      {
        completeShowHideFragment(paramFragment);
        return;
        label250:
        ((FragmentAnim.AnimationOrAnimator)localObject).animator.setTarget(paramFragment.mView);
        ((FragmentAnim.AnimationOrAnimator)localObject).animator.start();
      }
    }
  }
  
  void moveToState(int paramInt, boolean paramBoolean)
  {
    if ((this.mHost == null) && (paramInt != -1)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (paramInt == this.mCurState)) {}
    do
    {
      return;
      this.mCurState = paramInt;
      Iterator localIterator = this.mFragmentStore.getFragments().iterator();
      while (localIterator.hasNext()) {
        moveFragmentToExpectedState((Fragment)localIterator.next());
      }
      localIterator = this.mFragmentStore.getActiveFragments().iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        if ((localFragment != null) && (!localFragment.mIsNewlyAdded)) {
          moveFragmentToExpectedState(localFragment);
        }
      }
      startPendingDeferredFragments();
    } while ((!this.mNeedMenuInvalidate) || (this.mHost == null) || (this.mCurState != 4));
    this.mHost.onSupportInvalidateOptionsMenu();
    this.mNeedMenuInvalidate = false;
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
    paramInt = Math.min(paramInt, ((FragmentStateManager)localObject1).computeMaxState());
    if (paramFragment.mState <= paramInt)
    {
      if ((paramFragment.mState < paramInt) && (!this.mExitAnimationCancellationSignals.isEmpty())) {
        cancelExitAnimation(paramFragment);
      }
      switch (paramFragment.mState)
      {
      default: 
        if (paramFragment.mState != paramInt)
        {
          if (isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + paramInt + " found " + paramFragment.mState);
          }
          paramFragment.mState = paramInt;
        }
        break;
      }
    }
    ViewGroup localViewGroup;
    do
    {
      return;
      if (paramInt > -1)
      {
        if (isLoggingEnabled(3)) {
          Log.d("FragmentManager", "moveto ATTACHED: " + paramFragment);
        }
        if (paramFragment.mTarget != null)
        {
          if (!paramFragment.mTarget.equals(findActiveFragment(paramFragment.mTarget.mWho))) {
            throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTarget + " that does not belong to this FragmentManager!");
          }
          if (paramFragment.mTarget.mState < 1) {
            moveToState(paramFragment.mTarget, 1);
          }
          paramFragment.mTargetWho = paramFragment.mTarget.mWho;
          paramFragment.mTarget = null;
        }
        if (paramFragment.mTargetWho != null)
        {
          localObject2 = findActiveFragment(paramFragment.mTargetWho);
          if (localObject2 == null) {
            throw new IllegalStateException("Fragment " + paramFragment + " declared target fragment " + paramFragment.mTargetWho + " that does not belong to this FragmentManager!");
          }
          if (((Fragment)localObject2).mState < 1) {
            moveToState((Fragment)localObject2, 1);
          }
        }
        ((FragmentStateManager)localObject1).attach(this.mHost, this, this.mParent);
      }
      if (paramInt > 0) {
        ((FragmentStateManager)localObject1).create();
      }
      if (paramInt > -1) {
        ((FragmentStateManager)localObject1).ensureInflatedView();
      }
      if (paramInt > 1)
      {
        ((FragmentStateManager)localObject1).createView(this.mContainer);
        ((FragmentStateManager)localObject1).activityCreated();
        ((FragmentStateManager)localObject1).restoreViewState();
      }
      if (paramInt > 2) {
        ((FragmentStateManager)localObject1).start();
      }
      if (paramInt <= 3) {
        break;
      }
      ((FragmentStateManager)localObject1).resume();
      break;
      if (paramFragment.mState > paramInt) {}
      switch (paramFragment.mState)
      {
      default: 
        break;
      case 4: 
        if (paramInt < 4) {
          ((FragmentStateManager)localObject1).pause();
        }
      case 3: 
        if (paramInt < 3) {
          ((FragmentStateManager)localObject1).stop();
        }
      case 2: 
        if (paramInt >= 2) {
          break label822;
        }
        if (isLoggingEnabled(3)) {
          Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        }
        if ((paramFragment.mView != null) && (this.mHost.onShouldSaveFragmentState(paramFragment)) && (paramFragment.mSavedViewState == null)) {
          ((FragmentStateManager)localObject1).saveViewState();
        }
        localViewGroup = null;
        if ((paramFragment.mView == null) || (paramFragment.mContainer == null)) {
          break label806;
        }
        paramFragment.mContainer.endViewTransition(paramFragment.mView);
        paramFragment.mView.clearAnimation();
        if (paramFragment.isRemovingParent()) {
          break label806;
        }
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
          paramFragment.setStateAfterAnimating(paramInt);
          FragmentAnim.animateRemoveFragment(paramFragment, (FragmentAnim.AnimationOrAnimator)localObject2, this.mFragmentTransitionCallback);
        }
        localViewGroup.removeView(localView);
      }
    } while (localViewGroup != paramFragment.mContainer);
    label806:
    label822:
    int i;
    if (this.mExitAnimationCancellationSignals.get(paramFragment) == null)
    {
      destroyFragmentView(paramFragment);
      if (paramInt >= 1) {
        break label963;
      }
      if ((!paramFragment.mRemoving) || (paramFragment.isInBackStack())) {
        break label906;
      }
      i = 1;
      label843:
      if ((i == 0) && (!this.mNonConfig.shouldDestroy(paramFragment))) {
        break label911;
      }
      makeInactive((FragmentStateManager)localObject1);
      label864:
      if (this.mExitAnimationCancellationSignals.get(paramFragment) == null) {
        break label950;
      }
      paramFragment.setStateAfterAnimating(paramInt);
      paramInt = 1;
    }
    label906:
    label911:
    label950:
    label963:
    for (;;)
    {
      if (paramInt < 0) {
        ((FragmentStateManager)localObject1).detach(this.mNonConfig);
      }
      break;
      paramFragment.setStateAfterAnimating(paramInt);
      break label822;
      i = 0;
      break label843;
      if (paramFragment.mTargetWho == null) {
        break label864;
      }
      localObject2 = findActiveFragment(paramFragment.mTargetWho);
      if ((localObject2 == null) || (!((Fragment)localObject2).getRetainInstance())) {
        break label864;
      }
      paramFragment.mTarget = ((Fragment)localObject2);
      break label864;
      ((FragmentStateManager)localObject1).destroy(this.mHost, this.mNonConfig);
    }
  }
  
  void noteStateNotSaved()
  {
    if (this.mHost == null) {}
    for (;;)
    {
      return;
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
      if (this.mExecutingActions) {
        this.mHavePendingDeferredStart = true;
      }
    }
    else {
      return;
    }
    paramFragment.mDeferStart = false;
    moveToState(paramFragment, this.mCurState);
  }
  
  public void popBackStack()
  {
    enqueueAction(new FragmentManager.PopBackStackState(this, null, -1, 0), false);
  }
  
  public void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new FragmentManager.PopBackStackState(this, null, paramInt1, paramInt2), false);
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
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackImmediate(null, paramInt1, paramInt2);
  }
  
  public boolean popBackStackImmediate(@Nullable String paramString, int paramInt)
  {
    return popBackStackImmediate(paramString, -1, paramInt);
  }
  
  boolean popBackStackState(@NonNull ArrayList<BackStackRecord> paramArrayList, @NonNull ArrayList<Boolean> paramArrayList1, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    if (this.mBackStack == null) {
      return false;
    }
    if ((paramString == null) && (paramInt1 < 0) && ((paramInt2 & 0x1) == 0))
    {
      paramInt1 = this.mBackStack.size() - 1;
      if (paramInt1 < 0) {
        return false;
      }
      paramArrayList.add(this.mBackStack.remove(paramInt1));
      paramArrayList1.add(Boolean.valueOf(true));
    }
    for (;;)
    {
      return true;
      int i = -1;
      if ((paramString != null) || (paramInt1 >= 0))
      {
        int j = this.mBackStack.size() - 1;
        BackStackRecord localBackStackRecord;
        for (;;)
        {
          if (j >= 0)
          {
            localBackStackRecord = (BackStackRecord)this.mBackStack.get(j);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName()))) {
              break label133;
            }
          }
          label133:
          while ((paramInt1 >= 0) && (paramInt1 == localBackStackRecord.mIndex))
          {
            if (j >= 0) {
              break;
            }
            return false;
          }
          j -= 1;
        }
        i = j;
        if ((paramInt2 & 0x1) != 0)
        {
          paramInt2 = j - 1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt2 < 0) {
              break;
            }
            localBackStackRecord = (BackStackRecord)this.mBackStack.get(paramInt2);
            if ((paramString == null) || (!paramString.equals(localBackStackRecord.getName())))
            {
              i = paramInt2;
              if (paramInt1 < 0) {
                break;
              }
              i = paramInt2;
              if (paramInt1 != localBackStackRecord.mIndex) {
                break;
              }
            }
            paramInt2 -= 1;
          }
        }
      }
      if (i == this.mBackStack.size() - 1) {
        return false;
      }
      paramInt1 = this.mBackStack.size() - 1;
      while (paramInt1 > i)
      {
        paramArrayList.add(this.mBackStack.remove(paramInt1));
        paramArrayList1.add(Boolean.valueOf(true));
        paramInt1 -= 1;
      }
    }
  }
  
  public void putFragment(@NonNull Bundle paramBundle, @NonNull String paramString, @NonNull Fragment paramFragment)
  {
    if (paramFragment.mFragmentManager != this) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
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
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    if (!paramFragment.isInBackStack()) {}
    for (int i = 1;; i = 0)
    {
      if ((!paramFragment.mDetached) || (i != 0))
      {
        this.mFragmentStore.removeFragment(paramFragment);
        if (isMenuAvailable(paramFragment)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mRemoving = true;
        setVisibleRemovingFragment(paramFragment);
      }
      return;
    }
  }
  
  public void removeOnBackStackChangedListener(@NonNull FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  void removeRetainedFragment(@NonNull Fragment paramFragment)
  {
    if (isStateSaved()) {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
      }
    }
    while ((!this.mNonConfig.removeRetainedFragment(paramFragment)) || (!isLoggingEnabled(2))) {
      return;
    }
    Log.v("FragmentManager", "Updating retained Fragments: Removed " + paramFragment);
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
    if (paramParcelable == null) {}
    FragmentManagerState localFragmentManagerState;
    do
    {
      do
      {
        return;
        localFragmentManagerState = (FragmentManagerState)paramParcelable;
      } while (localFragmentManagerState.mActive == null);
      this.mFragmentStore.resetActiveFragments();
      Object localObject = localFragmentManagerState.mActive.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramParcelable = (FragmentState)((Iterator)localObject).next();
        if (paramParcelable != null)
        {
          Fragment localFragment = this.mNonConfig.findRetainedFragmentByWho(paramParcelable.mWho);
          if (localFragment != null) {
            if (isLoggingEnabled(2)) {
              Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + localFragment);
            }
          }
          for (paramParcelable = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, localFragment, paramParcelable);; paramParcelable = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mHost.getContext().getClassLoader(), getFragmentFactory(), paramParcelable))
          {
            localFragment = paramParcelable.getFragment();
            localFragment.mFragmentManager = this;
            if (isLoggingEnabled(2)) {
              Log.v("FragmentManager", "restoreSaveState: active (" + localFragment.mWho + "): " + localFragment);
            }
            paramParcelable.restoreState(this.mHost.getContext().getClassLoader());
            this.mFragmentStore.makeActive(paramParcelable);
            paramParcelable.setFragmentManagerState(this.mCurState);
            break;
          }
        }
      }
      paramParcelable = this.mNonConfig.getRetainedFragments().iterator();
      while (paramParcelable.hasNext())
      {
        localObject = (Fragment)paramParcelable.next();
        if (!this.mFragmentStore.containsActiveFragment(((Fragment)localObject).mWho))
        {
          if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Discarding retained Fragment " + localObject + " that was not found in the set of active Fragments " + localFragmentManagerState.mActive);
          }
          moveToState((Fragment)localObject, 1);
          ((Fragment)localObject).mRemoving = true;
          moveToState((Fragment)localObject, -1);
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
            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + paramParcelable.mIndex + "): " + paramParcelable);
            localObject = new PrintWriter(new LogWriter("FragmentManager"));
            paramParcelable.dump("  ", (PrintWriter)localObject, false);
            ((PrintWriter)localObject).close();
          }
          this.mBackStack.add(paramParcelable);
          i += 1;
        }
      }
      this.mBackStack = null;
      this.mBackStackIndex.set(localFragmentManagerState.mBackStackIndex);
    } while (localFragmentManagerState.mPrimaryNavActiveWho == null);
    this.mPrimaryNav = findActiveFragment(localFragmentManagerState.mPrimaryNavActiveWho);
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
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
    FragmentManagerState localFragmentManagerState = null;
    forcePostponedTransactions();
    endAnimatingAwayFragments();
    execPendingActions(true);
    this.mStateSaved = true;
    ArrayList localArrayList1 = this.mFragmentStore.saveActiveFragments();
    if (localArrayList1.isEmpty())
    {
      if (isLoggingEnabled(2)) {
        Log.v("FragmentManager", "saveAllState: no fragments!");
      }
      return null;
    }
    ArrayList localArrayList2 = this.mFragmentStore.saveAddedFragments();
    Object localObject = localFragmentManagerState;
    if (this.mBackStack != null)
    {
      int j = this.mBackStack.size();
      localObject = localFragmentManagerState;
      if (j > 0)
      {
        localObject = new BackStackState[j];
        int i = 0;
        while (i < j)
        {
          localObject[i] = new BackStackState((BackStackRecord)this.mBackStack.get(i));
          if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
          }
          i += 1;
        }
      }
    }
    localFragmentManagerState = new FragmentManagerState();
    localFragmentManagerState.mActive = localArrayList1;
    localFragmentManagerState.mAdded = localArrayList2;
    localFragmentManagerState.mBackStack = ((BackStackState[])localObject);
    localFragmentManagerState.mBackStackIndex = this.mBackStackIndex.get();
    if (this.mPrimaryNav != null) {
      localFragmentManagerState.mPrimaryNavActiveWho = this.mPrimaryNav.mWho;
    }
    return localFragmentManagerState;
  }
  
  @Nullable
  public Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment paramFragment)
  {
    FragmentStateManager localFragmentStateManager = this.mFragmentStore.getFragmentStateManager(paramFragment.mWho);
    if ((localFragmentStateManager == null) || (!localFragmentStateManager.getFragment().equals(paramFragment))) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    return localFragmentStateManager.saveInstanceState();
  }
  
  void scheduleCommit()
  {
    int j = 1;
    label42:
    label75:
    label85:
    label101:
    label104:
    for (;;)
    {
      int i;
      synchronized (this.mPendingActions)
      {
        if ((this.mPostponedTransactions != null) && (!this.mPostponedTransactions.isEmpty()))
        {
          i = 1;
          if (this.mPendingActions.size() != 1) {
            break label101;
          }
          break label85;
          this.mHost.getHandler().removeCallbacks(this.mExecCommit);
          this.mHost.getHandler().post(this.mExecCommit);
          updateOnBackPressedCallbackEnabled();
          return;
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label104;
        }
        if (j == 0) {
          break label75;
        }
        break label42;
        i = 0;
        break;
        j = 0;
      }
    }
  }
  
  void setExitAnimationOrder(@NonNull Fragment paramFragment, boolean paramBoolean)
  {
    paramFragment = getFragmentContainer(paramFragment);
    if ((paramFragment != null) && ((paramFragment instanceof FragmentContainerView)))
    {
      paramFragment = (FragmentContainerView)paramFragment;
      if (paramBoolean) {
        break label34;
      }
    }
    label34:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFragment.setDrawDisappearingViewsLast(paramBoolean);
      return;
    }
  }
  
  public void setFragmentFactory(@NonNull FragmentFactory paramFragmentFactory)
  {
    this.mFragmentFactory = paramFragmentFactory;
  }
  
  void setMaxLifecycle(@NonNull Fragment paramFragment, @NonNull Lifecycle.State paramState)
  {
    if ((!paramFragment.equals(findActiveFragment(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    paramFragment.mMaxState = paramState;
  }
  
  void setPrimaryNavigationFragment(@Nullable Fragment paramFragment)
  {
    if ((paramFragment != null) && ((!paramFragment.equals(findActiveFragment(paramFragment.mWho))) || ((paramFragment.mHost != null) && (paramFragment.mFragmentManager != this)))) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " is not an active fragment of FragmentManager " + this);
    }
    Fragment localFragment = this.mPrimaryNav;
    this.mPrimaryNav = paramFragment;
    dispatchParentPrimaryNavigationFragmentChanged(localFragment);
    dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
  }
  
  void showFragment(@NonNull Fragment paramFragment)
  {
    boolean bool = false;
    if (isLoggingEnabled(2)) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (!paramFragment.mHiddenChanged) {
        bool = true;
      }
      paramFragment.mHiddenChanged = bool;
    }
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null)
    {
      localStringBuilder.append(this.mParent.getClass().getSimpleName());
      localStringBuilder.append("{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mParent)));
      localStringBuilder.append("}");
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      if (this.mHost != null)
      {
        localStringBuilder.append(this.mHost.getClass().getSimpleName());
        localStringBuilder.append("{");
        localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.mHost)));
        localStringBuilder.append("}");
      }
      else
      {
        localStringBuilder.append("null");
      }
    }
  }
  
  public void unregisterFragmentLifecycleCallbacks(@NonNull FragmentManager.FragmentLifecycleCallbacks paramFragmentLifecycleCallbacks)
  {
    this.mLifecycleCallbacksDispatcher.unregisterFragmentLifecycleCallbacks(paramFragmentLifecycleCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentManager
 * JD-Core Version:    0.7.0.1
 */