package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelStoreOwner;

class FragmentStateManager
{
  private static final String TAG = "FragmentManager";
  private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  private static final String TARGET_STATE_TAG = "android:target_state";
  private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  private static final String VIEW_STATE_TAG = "android:view_state";
  private final FragmentLifecycleCallbacksDispatcher mDispatcher;
  @NonNull
  private final Fragment mFragment;
  private int mFragmentManagerState = -1;
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull Fragment paramFragment)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    this.mFragment = paramFragment;
  }
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull Fragment paramFragment, @NonNull FragmentState paramFragmentState)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    this.mFragment = paramFragment;
    this.mFragment.mSavedViewState = null;
    this.mFragment.mBackStackNesting = 0;
    this.mFragment.mInLayout = false;
    this.mFragment.mAdded = false;
    paramFragment = this.mFragment;
    if (this.mFragment.mTarget != null) {}
    for (paramFragmentLifecycleCallbacksDispatcher = this.mFragment.mTarget.mWho;; paramFragmentLifecycleCallbacksDispatcher = null)
    {
      paramFragment.mTargetWho = paramFragmentLifecycleCallbacksDispatcher;
      this.mFragment.mTarget = null;
      if (paramFragmentState.mSavedFragmentState == null) {
        break;
      }
      this.mFragment.mSavedFragmentState = paramFragmentState.mSavedFragmentState;
      return;
    }
    this.mFragment.mSavedFragmentState = new Bundle();
  }
  
  FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher paramFragmentLifecycleCallbacksDispatcher, @NonNull ClassLoader paramClassLoader, @NonNull FragmentFactory paramFragmentFactory, @NonNull FragmentState paramFragmentState)
  {
    this.mDispatcher = paramFragmentLifecycleCallbacksDispatcher;
    this.mFragment = paramFragmentFactory.instantiate(paramClassLoader, paramFragmentState.mClassName);
    if (paramFragmentState.mArguments != null) {
      paramFragmentState.mArguments.setClassLoader(paramClassLoader);
    }
    this.mFragment.setArguments(paramFragmentState.mArguments);
    this.mFragment.mWho = paramFragmentState.mWho;
    this.mFragment.mFromLayout = paramFragmentState.mFromLayout;
    this.mFragment.mRestored = true;
    this.mFragment.mFragmentId = paramFragmentState.mFragmentId;
    this.mFragment.mContainerId = paramFragmentState.mContainerId;
    this.mFragment.mTag = paramFragmentState.mTag;
    this.mFragment.mRetainInstance = paramFragmentState.mRetainInstance;
    this.mFragment.mRemoving = paramFragmentState.mRemoving;
    this.mFragment.mDetached = paramFragmentState.mDetached;
    this.mFragment.mHidden = paramFragmentState.mHidden;
    this.mFragment.mMaxState = androidx.lifecycle.Lifecycle.State.values()[paramFragmentState.mMaxLifecycleState];
    if (paramFragmentState.mSavedFragmentState != null) {}
    for (this.mFragment.mSavedFragmentState = paramFragmentState.mSavedFragmentState;; this.mFragment.mSavedFragmentState = new Bundle())
    {
      if (FragmentManager.isLoggingEnabled(2)) {
        Log.v("FragmentManager", "Instantiated fragment " + this.mFragment);
      }
      return;
    }
  }
  
  private Bundle saveBasicState()
  {
    Object localObject2 = new Bundle();
    this.mFragment.performSaveInstanceState((Bundle)localObject2);
    this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, (Bundle)localObject2, false);
    Object localObject1 = localObject2;
    if (((Bundle)localObject2).isEmpty()) {
      localObject1 = null;
    }
    if (this.mFragment.mView != null) {
      saveViewState();
    }
    localObject2 = localObject1;
    if (this.mFragment.mSavedViewState != null)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new Bundle();
      }
      ((Bundle)localObject2).putSparseParcelableArray("android:view_state", this.mFragment.mSavedViewState);
    }
    localObject1 = localObject2;
    if (!this.mFragment.mUserVisibleHint)
    {
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Bundle();
      }
      ((Bundle)localObject1).putBoolean("android:user_visible_hint", this.mFragment.mUserVisibleHint);
    }
    return localObject1;
  }
  
  void activityCreated()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.mFragment);
    }
    this.mFragment.performActivityCreated(this.mFragment.mSavedFragmentState);
    this.mDispatcher.dispatchOnFragmentActivityCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
  }
  
  void attach(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentManager paramFragmentManager, @Nullable Fragment paramFragment)
  {
    this.mFragment.mHost = paramFragmentHostCallback;
    this.mFragment.mParentFragment = paramFragment;
    this.mFragment.mFragmentManager = paramFragmentManager;
    this.mDispatcher.dispatchOnFragmentPreAttached(this.mFragment, paramFragmentHostCallback.getContext(), false);
    this.mFragment.performAttach();
    if (this.mFragment.mParentFragment == null) {
      paramFragmentHostCallback.onAttachFragment(this.mFragment);
    }
    for (;;)
    {
      this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, paramFragmentHostCallback.getContext(), false);
      return;
      this.mFragment.mParentFragment.onAttachFragment(this.mFragment);
    }
  }
  
  int computeMaxState()
  {
    int j = this.mFragmentManagerState;
    int i = j;
    if (this.mFragment.mFromLayout)
    {
      if (this.mFragment.mInLayout) {
        i = Math.max(this.mFragmentManagerState, 1);
      }
    }
    else
    {
      label36:
      j = i;
      if (!this.mFragment.mAdded) {
        j = Math.min(i, 1);
      }
      i = j;
      if (this.mFragment.mRemoving) {
        if (!this.mFragment.isInBackStack()) {
          break label196;
        }
      }
    }
    label196:
    for (i = Math.min(j, 1);; i = Math.min(j, -1))
    {
      j = i;
      if (this.mFragment.mDeferStart)
      {
        j = i;
        if (this.mFragment.mState < 3) {
          j = Math.min(i, 2);
        }
      }
      i = j;
      switch (FragmentStateManager.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[this.mFragment.mMaxState.ordinal()])
      {
      default: 
        i = Math.min(j, -1);
      case 1: 
        return i;
        if (this.mFragmentManagerState < 2)
        {
          i = Math.min(j, this.mFragment.mState);
          break label36;
        }
        i = Math.min(j, 1);
        break label36;
      }
    }
    return Math.min(j, 3);
    return Math.min(j, 1);
  }
  
  void create()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "moveto CREATED: " + this.mFragment);
    }
    if (!this.mFragment.mIsCreated)
    {
      this.mDispatcher.dispatchOnFragmentPreCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
      this.mFragment.performCreate(this.mFragment.mSavedFragmentState);
      this.mDispatcher.dispatchOnFragmentCreated(this.mFragment, this.mFragment.mSavedFragmentState, false);
      return;
    }
    this.mFragment.restoreChildFragmentState(this.mFragment.mSavedFragmentState);
    this.mFragment.mState = 1;
  }
  
  void createView(@NonNull FragmentContainer paramFragmentContainer)
  {
    if (this.mFragment.mFromLayout) {}
    Object localObject;
    do
    {
      return;
      if (FragmentManager.isLoggingEnabled(3)) {
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
      }
      localObject = null;
      if (this.mFragment.mContainer == null) {
        break;
      }
      localObject = this.mFragment.mContainer;
      this.mFragment.mContainer = ((ViewGroup)localObject);
      this.mFragment.performCreateView(this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState), (ViewGroup)localObject, this.mFragment.mSavedFragmentState);
    } while (this.mFragment.mView == null);
    this.mFragment.mView.setSaveFromParentEnabled(false);
    this.mFragment.mView.setTag(2131367439, this.mFragment);
    if (localObject != null) {
      ((ViewGroup)localObject).addView(this.mFragment.mView);
    }
    if (this.mFragment.mHidden) {
      this.mFragment.mView.setVisibility(8);
    }
    ViewCompat.requestApplyInsets(this.mFragment.mView);
    this.mFragment.onViewCreated(this.mFragment.mView, this.mFragment.mSavedFragmentState);
    this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
    paramFragmentContainer = this.mFragment;
    if ((this.mFragment.mView.getVisibility() == 0) && (this.mFragment.mContainer != null)) {}
    for (boolean bool = true;; bool = false)
    {
      paramFragmentContainer.mIsNewlyAdded = bool;
      return;
      if (this.mFragment.mContainerId == 0) {
        break;
      }
      if (this.mFragment.mContainerId == -1) {
        throw new IllegalArgumentException("Cannot create fragment " + this.mFragment + " for a container view with no id");
      }
      paramFragmentContainer = (ViewGroup)paramFragmentContainer.onFindViewById(this.mFragment.mContainerId);
      localObject = paramFragmentContainer;
      if (paramFragmentContainer != null) {
        break;
      }
      localObject = paramFragmentContainer;
      if (this.mFragment.mRestored) {
        break;
      }
      try
      {
        paramFragmentContainer = this.mFragment.getResources().getResourceName(this.mFragment.mContainerId);
        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.mFragment.mContainerId) + " (" + paramFragmentContainer + ") for fragment " + this.mFragment);
      }
      catch (Resources.NotFoundException paramFragmentContainer)
      {
        for (;;)
        {
          paramFragmentContainer = "unknown";
        }
      }
    }
  }
  
  void destroy(@NonNull FragmentHostCallback<?> paramFragmentHostCallback, @NonNull FragmentManagerViewModel paramFragmentManagerViewModel)
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "movefrom CREATED: " + this.mFragment);
    }
    int i;
    int j;
    label76:
    boolean bool;
    if ((this.mFragment.mRemoving) && (!this.mFragment.isInBackStack()))
    {
      i = 1;
      if ((i == 0) && (!paramFragmentManagerViewModel.shouldDestroy(this.mFragment))) {
        break label136;
      }
      j = 1;
      if (j == 0) {
        break label183;
      }
      if (!(paramFragmentHostCallback instanceof ViewModelStoreOwner)) {
        break label142;
      }
      bool = paramFragmentManagerViewModel.isCleared();
    }
    for (;;)
    {
      if ((i != 0) || (bool)) {
        paramFragmentManagerViewModel.clearNonConfigState(this.mFragment);
      }
      this.mFragment.performDestroy();
      this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
      return;
      i = 0;
      break;
      label136:
      j = 0;
      break label76;
      label142:
      if ((paramFragmentHostCallback.getContext() instanceof Activity))
      {
        if (!((Activity)paramFragmentHostCallback.getContext()).isChangingConfigurations()) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else {
        bool = true;
      }
    }
    label183:
    this.mFragment.mState = 0;
  }
  
  void detach(@NonNull FragmentManagerViewModel paramFragmentManagerViewModel)
  {
    int j = 0;
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "movefrom ATTACHED: " + this.mFragment);
    }
    this.mFragment.performDetach();
    this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
    this.mFragment.mState = -1;
    this.mFragment.mHost = null;
    this.mFragment.mParentFragment = null;
    this.mFragment.mFragmentManager = null;
    int i = j;
    if (this.mFragment.mRemoving)
    {
      i = j;
      if (!this.mFragment.isInBackStack()) {
        i = 1;
      }
    }
    if ((i != 0) || (paramFragmentManagerViewModel.shouldDestroy(this.mFragment)))
    {
      if (FragmentManager.isLoggingEnabled(3)) {
        Log.d("FragmentManager", "initState called for fragment: " + this.mFragment);
      }
      this.mFragment.initState();
    }
  }
  
  void ensureInflatedView()
  {
    if ((this.mFragment.mFromLayout) && (this.mFragment.mInLayout) && (!this.mFragment.mPerformedCreateView))
    {
      if (FragmentManager.isLoggingEnabled(3)) {
        Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.mFragment);
      }
      this.mFragment.performCreateView(this.mFragment.performGetLayoutInflater(this.mFragment.mSavedFragmentState), null, this.mFragment.mSavedFragmentState);
      if (this.mFragment.mView != null)
      {
        this.mFragment.mView.setSaveFromParentEnabled(false);
        this.mFragment.mView.setTag(2131367439, this.mFragment);
        if (this.mFragment.mHidden) {
          this.mFragment.mView.setVisibility(8);
        }
        this.mFragment.onViewCreated(this.mFragment.mView, this.mFragment.mSavedFragmentState);
        this.mDispatcher.dispatchOnFragmentViewCreated(this.mFragment, this.mFragment.mView, this.mFragment.mSavedFragmentState, false);
      }
    }
  }
  
  @NonNull
  Fragment getFragment()
  {
    return this.mFragment;
  }
  
  void pause()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "movefrom RESUMED: " + this.mFragment);
    }
    this.mFragment.performPause();
    this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
  }
  
  void restoreState(@NonNull ClassLoader paramClassLoader)
  {
    if (this.mFragment.mSavedFragmentState == null) {}
    for (;;)
    {
      return;
      this.mFragment.mSavedFragmentState.setClassLoader(paramClassLoader);
      this.mFragment.mSavedViewState = this.mFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
      this.mFragment.mTargetWho = this.mFragment.mSavedFragmentState.getString("android:target_state");
      if (this.mFragment.mTargetWho != null) {
        this.mFragment.mTargetRequestCode = this.mFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
      }
      if (this.mFragment.mSavedUserVisibleHint != null)
      {
        this.mFragment.mUserVisibleHint = this.mFragment.mSavedUserVisibleHint.booleanValue();
        this.mFragment.mSavedUserVisibleHint = null;
      }
      while (!this.mFragment.mUserVisibleHint)
      {
        this.mFragment.mDeferStart = true;
        return;
        this.mFragment.mUserVisibleHint = this.mFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
      }
    }
  }
  
  void restoreViewState()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this.mFragment);
    }
    if (this.mFragment.mView != null) {
      this.mFragment.restoreViewState(this.mFragment.mSavedFragmentState);
    }
    this.mFragment.mSavedFragmentState = null;
  }
  
  void resume()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "moveto RESUMED: " + this.mFragment);
    }
    this.mFragment.performResume();
    this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
    this.mFragment.mSavedFragmentState = null;
    this.mFragment.mSavedViewState = null;
  }
  
  @Nullable
  Fragment.SavedState saveInstanceState()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.mFragment.mState > -1)
    {
      Bundle localBundle = saveBasicState();
      localObject1 = localObject2;
      if (localBundle != null) {
        localObject1 = new Fragment.SavedState(localBundle);
      }
    }
    return localObject1;
  }
  
  @NonNull
  FragmentState saveState()
  {
    FragmentState localFragmentState = new FragmentState(this.mFragment);
    if ((this.mFragment.mState > -1) && (localFragmentState.mSavedFragmentState == null))
    {
      localFragmentState.mSavedFragmentState = saveBasicState();
      if (this.mFragment.mTargetWho != null)
      {
        if (localFragmentState.mSavedFragmentState == null) {
          localFragmentState.mSavedFragmentState = new Bundle();
        }
        localFragmentState.mSavedFragmentState.putString("android:target_state", this.mFragment.mTargetWho);
        if (this.mFragment.mTargetRequestCode != 0) {
          localFragmentState.mSavedFragmentState.putInt("android:target_req_state", this.mFragment.mTargetRequestCode);
        }
      }
      return localFragmentState;
    }
    localFragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
    return localFragmentState;
  }
  
  void saveViewState()
  {
    if (this.mFragment.mView == null) {}
    SparseArray localSparseArray;
    do
    {
      return;
      localSparseArray = new SparseArray();
      this.mFragment.mView.saveHierarchyState(localSparseArray);
    } while (localSparseArray.size() <= 0);
    this.mFragment.mSavedViewState = localSparseArray;
  }
  
  void setFragmentManagerState(int paramInt)
  {
    this.mFragmentManagerState = paramInt;
  }
  
  void start()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "moveto STARTED: " + this.mFragment);
    }
    this.mFragment.performStart();
    this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
  }
  
  void stop()
  {
    if (FragmentManager.isLoggingEnabled(3)) {
      Log.d("FragmentManager", "movefrom STARTED: " + this.mFragment);
    }
    this.mFragment.performStop();
    this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentStateManager
 * JD-Core Version:    0.7.0.1
 */