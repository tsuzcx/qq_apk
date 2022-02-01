package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.UiThread;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Fragment
  implements ComponentCallbacks, View.OnCreateContextMenuListener, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner
{
  static final int ACTIVITY_CREATED = 2;
  static final int ATTACHED = 0;
  static final int CREATED = 1;
  static final int INITIALIZING = -1;
  static final int RESUMED = 4;
  static final int STARTED = 3;
  static final Object USE_DEFAULT_TRANSITION = new Object();
  boolean mAdded;
  Fragment.AnimationInfo mAnimationInfo;
  Bundle mArguments;
  int mBackStackNesting;
  private boolean mCalled;
  @NonNull
  FragmentManager mChildFragmentManager = new FragmentManagerImpl();
  ViewGroup mContainer;
  int mContainerId;
  @LayoutRes
  private int mContentLayoutId;
  private ViewModelProvider.Factory mDefaultFactory;
  boolean mDeferStart;
  boolean mDetached;
  int mFragmentId;
  FragmentManager mFragmentManager;
  boolean mFromLayout;
  boolean mHasMenu;
  boolean mHidden;
  boolean mHiddenChanged;
  FragmentHostCallback<?> mHost;
  boolean mInLayout;
  boolean mIsCreated;
  boolean mIsNewlyAdded;
  private Boolean mIsPrimaryNavigationFragment = null;
  LayoutInflater mLayoutInflater;
  LifecycleRegistry mLifecycleRegistry;
  Lifecycle.State mMaxState = Lifecycle.State.RESUMED;
  boolean mMenuVisible = true;
  Fragment mParentFragment;
  boolean mPerformedCreateView;
  float mPostponedAlpha;
  Runnable mPostponedDurationRunnable = new Fragment.1(this);
  boolean mRemoving;
  boolean mRestored;
  boolean mRetainInstance;
  boolean mRetainInstanceChangedWhileDetached;
  Bundle mSavedFragmentState;
  SavedStateRegistryController mSavedStateRegistryController;
  @Nullable
  Boolean mSavedUserVisibleHint;
  SparseArray<Parcelable> mSavedViewState;
  int mState = -1;
  String mTag;
  Fragment mTarget;
  int mTargetRequestCode;
  String mTargetWho = null;
  boolean mUserVisibleHint = true;
  View mView;
  @Nullable
  FragmentViewLifecycleOwner mViewLifecycleOwner;
  MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData = new MutableLiveData();
  @NonNull
  String mWho = UUID.randomUUID().toString();
  
  public Fragment()
  {
    initLifecycle();
  }
  
  @ContentView
  public Fragment(@LayoutRes int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private Fragment.AnimationInfo ensureAnimationInfo()
  {
    if (this.mAnimationInfo == null) {
      this.mAnimationInfo = new Fragment.AnimationInfo();
    }
    return this.mAnimationInfo;
  }
  
  private void initLifecycle()
  {
    this.mLifecycleRegistry = new LifecycleRegistry(this);
    this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
    if (Build.VERSION.SDK_INT >= 19) {
      this.mLifecycleRegistry.addObserver(new Fragment.2(this));
    }
  }
  
  @Deprecated
  @NonNull
  public static Fragment instantiate(@NonNull Context paramContext, @NonNull String paramString)
  {
    return instantiate(paramContext, paramString, null);
  }
  
  @Deprecated
  @NonNull
  public static Fragment instantiate(@NonNull Context paramContext, @NonNull String paramString, @Nullable Bundle paramBundle)
  {
    try
    {
      paramContext = (Fragment)FragmentFactory.loadFragmentClass(paramContext.getClassLoader(), paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(paramContext.getClass().getClassLoader());
        paramContext.setArguments(paramBundle);
      }
      return paramContext;
    }
    catch (InstantiationException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (IllegalAccessException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": make sure class name exists, is public, and has an empty constructor that is public", paramContext);
    }
    catch (NoSuchMethodException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": could not find Fragment constructor", paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      throw new Fragment.InstantiationException("Unable to instantiate fragment " + paramString + ": calling Fragment constructor caused an exception", paramContext);
    }
  }
  
  void callStartTransitionListener()
  {
    Fragment.OnStartEnterTransitionListener localOnStartEnterTransitionListener = null;
    if (this.mAnimationInfo == null) {}
    for (;;)
    {
      if (localOnStartEnterTransitionListener != null) {
        localOnStartEnterTransitionListener.onStartEnterTransition();
      }
      return;
      this.mAnimationInfo.mEnterTransitionPostponed = false;
      localOnStartEnterTransitionListener = this.mAnimationInfo.mStartEnterTransitionListener;
      this.mAnimationInfo.mStartEnterTransitionListener = null;
    }
  }
  
  public void dump(@NonNull String paramString, @Nullable FileDescriptor paramFileDescriptor, @NonNull PrintWriter paramPrintWriter, @Nullable String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mFragmentId=#");
    paramPrintWriter.print(Integer.toHexString(this.mFragmentId));
    paramPrintWriter.print(" mContainerId=#");
    paramPrintWriter.print(Integer.toHexString(this.mContainerId));
    paramPrintWriter.print(" mTag=");
    paramPrintWriter.println(this.mTag);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mState=");
    paramPrintWriter.print(this.mState);
    paramPrintWriter.print(" mWho=");
    paramPrintWriter.print(this.mWho);
    paramPrintWriter.print(" mBackStackNesting=");
    paramPrintWriter.println(this.mBackStackNesting);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mAdded=");
    paramPrintWriter.print(this.mAdded);
    paramPrintWriter.print(" mRemoving=");
    paramPrintWriter.print(this.mRemoving);
    paramPrintWriter.print(" mFromLayout=");
    paramPrintWriter.print(this.mFromLayout);
    paramPrintWriter.print(" mInLayout=");
    paramPrintWriter.println(this.mInLayout);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mHidden=");
    paramPrintWriter.print(this.mHidden);
    paramPrintWriter.print(" mDetached=");
    paramPrintWriter.print(this.mDetached);
    paramPrintWriter.print(" mMenuVisible=");
    paramPrintWriter.print(this.mMenuVisible);
    paramPrintWriter.print(" mHasMenu=");
    paramPrintWriter.println(this.mHasMenu);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mRetainInstance=");
    paramPrintWriter.print(this.mRetainInstance);
    paramPrintWriter.print(" mUserVisibleHint=");
    paramPrintWriter.println(this.mUserVisibleHint);
    if (this.mFragmentManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mFragmentManager=");
      paramPrintWriter.println(this.mFragmentManager);
    }
    if (this.mHost != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mHost=");
      paramPrintWriter.println(this.mHost);
    }
    if (this.mParentFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mParentFragment=");
      paramPrintWriter.println(this.mParentFragment);
    }
    if (this.mArguments != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mArguments=");
      paramPrintWriter.println(this.mArguments);
    }
    if (this.mSavedFragmentState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedFragmentState=");
      paramPrintWriter.println(this.mSavedFragmentState);
    }
    if (this.mSavedViewState != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mSavedViewState=");
      paramPrintWriter.println(this.mSavedViewState);
    }
    Fragment localFragment = getTargetFragment();
    if (localFragment != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTarget=");
      paramPrintWriter.print(localFragment);
      paramPrintWriter.print(" mTargetRequestCode=");
      paramPrintWriter.println(this.mTargetRequestCode);
    }
    if (getNextAnim() != 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mNextAnim=");
      paramPrintWriter.println(getNextAnim());
    }
    if (this.mContainer != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mContainer=");
      paramPrintWriter.println(this.mContainer);
    }
    if (this.mView != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mView=");
      paramPrintWriter.println(this.mView);
    }
    if (getAnimatingAway() != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAnimatingAway=");
      paramPrintWriter.println(getAnimatingAway());
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStateAfterAnimating=");
      paramPrintWriter.println(getStateAfterAnimating());
    }
    if (getContext() != null) {
      LoaderManager.getInstance(this).dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("Child " + this.mChildFragmentManager + ":");
    this.mChildFragmentManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  @Nullable
  Fragment findFragmentByWho(@NonNull String paramString)
  {
    if (paramString.equals(this.mWho)) {
      return this;
    }
    return this.mChildFragmentManager.findFragmentByWho(paramString);
  }
  
  @Nullable
  public final FragmentActivity getActivity()
  {
    if (this.mHost == null) {
      return null;
    }
    return (FragmentActivity)this.mHost.getActivity();
  }
  
  public boolean getAllowEnterTransitionOverlap()
  {
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.mAllowEnterTransitionOverlap == null)) {
      return true;
    }
    return this.mAnimationInfo.mAllowEnterTransitionOverlap.booleanValue();
  }
  
  public boolean getAllowReturnTransitionOverlap()
  {
    if ((this.mAnimationInfo == null) || (this.mAnimationInfo.mAllowReturnTransitionOverlap == null)) {
      return true;
    }
    return this.mAnimationInfo.mAllowReturnTransitionOverlap.booleanValue();
  }
  
  View getAnimatingAway()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mAnimatingAway;
  }
  
  Animator getAnimator()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mAnimator;
  }
  
  @Nullable
  public final Bundle getArguments()
  {
    return this.mArguments;
  }
  
  @NonNull
  public final FragmentManager getChildFragmentManager()
  {
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }
    return this.mChildFragmentManager;
  }
  
  @Nullable
  public Context getContext()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.getContext();
  }
  
  @NonNull
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory()
  {
    if (this.mFragmentManager == null) {
      throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }
    if (this.mDefaultFactory == null) {
      this.mDefaultFactory = new SavedStateViewModelFactory(requireActivity().getApplication(), this, getArguments());
    }
    return this.mDefaultFactory;
  }
  
  @Nullable
  public Object getEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mEnterTransition;
  }
  
  SharedElementCallback getEnterTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mEnterTransitionCallback;
  }
  
  @Nullable
  public Object getExitTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mExitTransition;
  }
  
  SharedElementCallback getExitTransitionCallback()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mExitTransitionCallback;
  }
  
  @Deprecated
  @Nullable
  public final FragmentManager getFragmentManager()
  {
    return this.mFragmentManager;
  }
  
  @Nullable
  public final Object getHost()
  {
    if (this.mHost == null) {
      return null;
    }
    return this.mHost.onGetHost();
  }
  
  public final int getId()
  {
    return this.mFragmentId;
  }
  
  @NonNull
  public final LayoutInflater getLayoutInflater()
  {
    if (this.mLayoutInflater == null) {
      return performGetLayoutInflater(null);
    }
    return this.mLayoutInflater;
  }
  
  @Deprecated
  @NonNull
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public LayoutInflater getLayoutInflater(@Nullable Bundle paramBundle)
  {
    if (this.mHost == null) {
      throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }
    paramBundle = this.mHost.onGetLayoutInflater();
    LayoutInflaterCompat.setFactory2(paramBundle, this.mChildFragmentManager.getLayoutInflaterFactory());
    return paramBundle;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @Deprecated
  @NonNull
  public LoaderManager getLoaderManager()
  {
    return LoaderManager.getInstance(this);
  }
  
  int getNextAnim()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mNextAnim;
  }
  
  int getNextTransition()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mNextTransition;
  }
  
  @Nullable
  public final Fragment getParentFragment()
  {
    return this.mParentFragment;
  }
  
  @NonNull
  public final FragmentManager getParentFragmentManager()
  {
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (localFragmentManager == null) {
      throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }
    return localFragmentManager;
  }
  
  @Nullable
  public Object getReenterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mReenterTransition == USE_DEFAULT_TRANSITION) {
      return getExitTransition();
    }
    return this.mAnimationInfo.mReenterTransition;
  }
  
  @NonNull
  public final Resources getResources()
  {
    return requireContext().getResources();
  }
  
  public final boolean getRetainInstance()
  {
    return this.mRetainInstance;
  }
  
  @Nullable
  public Object getReturnTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mReturnTransition == USE_DEFAULT_TRANSITION) {
      return getEnterTransition();
    }
    return this.mAnimationInfo.mReturnTransition;
  }
  
  @NonNull
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  @Nullable
  public Object getSharedElementEnterTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    return this.mAnimationInfo.mSharedElementEnterTransition;
  }
  
  @Nullable
  public Object getSharedElementReturnTransition()
  {
    if (this.mAnimationInfo == null) {
      return null;
    }
    if (this.mAnimationInfo.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION) {
      return getSharedElementEnterTransition();
    }
    return this.mAnimationInfo.mSharedElementReturnTransition;
  }
  
  int getStateAfterAnimating()
  {
    if (this.mAnimationInfo == null) {
      return 0;
    }
    return this.mAnimationInfo.mStateAfterAnimating;
  }
  
  @NonNull
  public final String getString(@StringRes int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  @NonNull
  public final String getString(@StringRes int paramInt, @Nullable Object... paramVarArgs)
  {
    return getResources().getString(paramInt, paramVarArgs);
  }
  
  @Nullable
  public final String getTag()
  {
    return this.mTag;
  }
  
  @Nullable
  public final Fragment getTargetFragment()
  {
    if (this.mTarget != null) {
      return this.mTarget;
    }
    if ((this.mFragmentManager != null) && (this.mTargetWho != null)) {
      return this.mFragmentManager.findActiveFragment(this.mTargetWho);
    }
    return null;
  }
  
  public final int getTargetRequestCode()
  {
    return this.mTargetRequestCode;
  }
  
  @NonNull
  public final CharSequence getText(@StringRes int paramInt)
  {
    return getResources().getText(paramInt);
  }
  
  @Deprecated
  public boolean getUserVisibleHint()
  {
    return this.mUserVisibleHint;
  }
  
  @Nullable
  public View getView()
  {
    return this.mView;
  }
  
  @MainThread
  @NonNull
  public LifecycleOwner getViewLifecycleOwner()
  {
    if (this.mViewLifecycleOwner == null) {
      throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }
    return this.mViewLifecycleOwner;
  }
  
  @NonNull
  public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData()
  {
    return this.mViewLifecycleOwnerLiveData;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (this.mFragmentManager == null) {
      throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }
    return this.mFragmentManager.getViewModelStore(this);
  }
  
  @SuppressLint({"KotlinPropertyAccess"})
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final boolean hasOptionsMenu()
  {
    return this.mHasMenu;
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  void initState()
  {
    initLifecycle();
    this.mWho = UUID.randomUUID().toString();
    this.mAdded = false;
    this.mRemoving = false;
    this.mFromLayout = false;
    this.mInLayout = false;
    this.mRestored = false;
    this.mBackStackNesting = 0;
    this.mFragmentManager = null;
    this.mChildFragmentManager = new FragmentManagerImpl();
    this.mHost = null;
    this.mFragmentId = 0;
    this.mContainerId = 0;
    this.mTag = null;
    this.mHidden = false;
    this.mDetached = false;
  }
  
  public final boolean isAdded()
  {
    return (this.mHost != null) && (this.mAdded);
  }
  
  public final boolean isDetached()
  {
    return this.mDetached;
  }
  
  public final boolean isHidden()
  {
    return this.mHidden;
  }
  
  boolean isHideReplaced()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.mIsHideReplaced;
  }
  
  final boolean isInBackStack()
  {
    return this.mBackStackNesting > 0;
  }
  
  public final boolean isInLayout()
  {
    return this.mInLayout;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final boolean isMenuVisible()
  {
    return (this.mMenuVisible) && ((this.mFragmentManager == null) || (this.mFragmentManager.isParentMenuVisible(this.mParentFragment)));
  }
  
  boolean isPostponed()
  {
    if (this.mAnimationInfo == null) {
      return false;
    }
    return this.mAnimationInfo.mEnterTransitionPostponed;
  }
  
  public final boolean isRemoving()
  {
    return this.mRemoving;
  }
  
  final boolean isRemovingParent()
  {
    Fragment localFragment = getParentFragment();
    return (localFragment != null) && ((localFragment.isRemoving()) || (localFragment.isRemovingParent()));
  }
  
  public final boolean isResumed()
  {
    return this.mState >= 4;
  }
  
  public final boolean isStateSaved()
  {
    if (this.mFragmentManager == null) {
      return false;
    }
    return this.mFragmentManager.isStateSaved();
  }
  
  public final boolean isVisible()
  {
    return (isAdded()) && (!isHidden()) && (this.mView != null) && (this.mView.getWindowToken() != null) && (this.mView.getVisibility() == 0);
  }
  
  void noteStateNotSaved()
  {
    this.mChildFragmentManager.noteStateNotSaved();
  }
  
  @CallSuper
  @MainThread
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent) {}
  
  @Deprecated
  @CallSuper
  @MainThread
  public void onAttach(@NonNull Activity paramActivity)
  {
    this.mCalled = true;
  }
  
  @CallSuper
  @MainThread
  public void onAttach(@NonNull Context paramContext)
  {
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.getActivity())
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onAttach(paramContext);
      }
      return;
    }
  }
  
  @MainThread
  public void onAttachFragment(@NonNull Fragment paramFragment) {}
  
  @CallSuper
  public void onConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    this.mCalled = true;
  }
  
  @MainThread
  public boolean onContextItemSelected(@NonNull MenuItem paramMenuItem)
  {
    return false;
  }
  
  @CallSuper
  @MainThread
  public void onCreate(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
    restoreChildFragmentState(paramBundle);
    if (!this.mChildFragmentManager.isStateAtLeast(1)) {
      this.mChildFragmentManager.dispatchCreate();
    }
  }
  
  @MainThread
  @Nullable
  public Animation onCreateAnimation(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  @MainThread
  @Nullable
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  @MainThread
  public void onCreateContextMenu(@NonNull ContextMenu paramContextMenu, @NonNull View paramView, @Nullable ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    requireActivity().onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  @MainThread
  public void onCreateOptionsMenu(@NonNull Menu paramMenu, @NonNull MenuInflater paramMenuInflater) {}
  
  @MainThread
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (this.mContentLayoutId != 0) {}
    for (paramLayoutInflater = paramLayoutInflater.inflate(this.mContentLayoutId, paramViewGroup, false);; paramLayoutInflater = null)
    {
      AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  @CallSuper
  @MainThread
  public void onDestroy()
  {
    this.mCalled = true;
  }
  
  @MainThread
  public void onDestroyOptionsMenu() {}
  
  @CallSuper
  @MainThread
  public void onDestroyView()
  {
    this.mCalled = true;
  }
  
  @CallSuper
  @MainThread
  public void onDetach()
  {
    this.mCalled = true;
  }
  
  @NonNull
  public LayoutInflater onGetLayoutInflater(@Nullable Bundle paramBundle)
  {
    return getLayoutInflater(paramBundle);
  }
  
  @MainThread
  public void onHiddenChanged(boolean paramBoolean) {}
  
  @Deprecated
  @CallSuper
  @UiThread
  public void onInflate(@NonNull Activity paramActivity, @NonNull AttributeSet paramAttributeSet, @Nullable Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  @CallSuper
  @UiThread
  public void onInflate(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, @Nullable Bundle paramBundle)
  {
    this.mCalled = true;
    if (this.mHost == null) {}
    for (paramContext = null;; paramContext = this.mHost.getActivity())
    {
      if (paramContext != null)
      {
        this.mCalled = false;
        onInflate(paramContext, paramAttributeSet, paramBundle);
      }
      return;
    }
  }
  
  @CallSuper
  @MainThread
  public void onLowMemory()
  {
    this.mCalled = true;
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  @MainThread
  public boolean onOptionsItemSelected(@NonNull MenuItem paramMenuItem)
  {
    return false;
  }
  
  @MainThread
  public void onOptionsMenuClosed(@NonNull Menu paramMenu) {}
  
  @CallSuper
  @MainThread
  public void onPause()
  {
    this.mCalled = true;
  }
  
  public void onPictureInPictureModeChanged(boolean paramBoolean) {}
  
  @MainThread
  public void onPrepareOptionsMenu(@NonNull Menu paramMenu) {}
  
  @MainThread
  public void onPrimaryNavigationFragmentChanged(boolean paramBoolean) {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt) {}
  
  @CallSuper
  @MainThread
  public void onResume()
  {
    this.mCalled = true;
  }
  
  @MainThread
  public void onSaveInstanceState(@NonNull Bundle paramBundle) {}
  
  @CallSuper
  @MainThread
  public void onStart()
  {
    this.mCalled = true;
  }
  
  @CallSuper
  @MainThread
  public void onStop()
  {
    this.mCalled = true;
  }
  
  @MainThread
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle) {}
  
  @CallSuper
  @MainThread
  public void onViewStateRestored(@Nullable Bundle paramBundle)
  {
    this.mCalled = true;
  }
  
  void performActivityCreated(Bundle paramBundle)
  {
    this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 2;
    this.mCalled = false;
    onActivityCreated(paramBundle);
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
    }
    this.mChildFragmentManager.dispatchActivityCreated();
  }
  
  void performAttach()
  {
    this.mChildFragmentManager.attachController(this.mHost, new Fragment.4(this), this);
    this.mState = 0;
    this.mCalled = false;
    onAttach(this.mHost.getContext());
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
    }
  }
  
  void performConfigurationChanged(@NonNull Configuration paramConfiguration)
  {
    onConfigurationChanged(paramConfiguration);
    this.mChildFragmentManager.dispatchConfigurationChanged(paramConfiguration);
  }
  
  boolean performContextItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if (onContextItemSelected(paramMenuItem)) {}
      while (this.mChildFragmentManager.dispatchContextItemSelected(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  void performCreate(Bundle paramBundle)
  {
    this.mChildFragmentManager.noteStateNotSaved();
    this.mState = 1;
    this.mCalled = false;
    this.mSavedStateRegistryController.performRestore(paramBundle);
    onCreate(paramBundle);
    this.mIsCreated = true;
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
  }
  
  boolean performCreateOptionsMenu(@NonNull Menu paramMenu, @NonNull MenuInflater paramMenuInflater)
  {
    boolean bool = false;
    int j = 0;
    if (!this.mHidden)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onCreateOptionsMenu(paramMenu, paramMenuInflater);
        }
      }
      bool = i | this.mChildFragmentManager.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
    return bool;
  }
  
  void performCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.mChildFragmentManager.noteStateNotSaved();
    this.mPerformedCreateView = true;
    this.mViewLifecycleOwner = new FragmentViewLifecycleOwner();
    this.mView = onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mView != null)
    {
      this.mViewLifecycleOwner.initialize();
      this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
      return;
    }
    if (this.mViewLifecycleOwner.isInitialized()) {
      throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }
    this.mViewLifecycleOwner = null;
  }
  
  void performDestroy()
  {
    this.mChildFragmentManager.dispatchDestroy();
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    this.mState = 0;
    this.mCalled = false;
    this.mIsCreated = false;
    onDestroy();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }
  }
  
  void performDestroyView()
  {
    this.mChildFragmentManager.dispatchDestroyView();
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }
    this.mState = 1;
    this.mCalled = false;
    onDestroyView();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
    }
    LoaderManager.getInstance(this).markForRedelivery();
    this.mPerformedCreateView = false;
  }
  
  void performDetach()
  {
    this.mState = -1;
    this.mCalled = false;
    onDetach();
    this.mLayoutInflater = null;
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }
    if (!this.mChildFragmentManager.isDestroyed())
    {
      this.mChildFragmentManager.dispatchDestroy();
      this.mChildFragmentManager = new FragmentManagerImpl();
    }
  }
  
  @NonNull
  LayoutInflater performGetLayoutInflater(@Nullable Bundle paramBundle)
  {
    this.mLayoutInflater = onGetLayoutInflater(paramBundle);
    return this.mLayoutInflater;
  }
  
  void performLowMemory()
  {
    onLowMemory();
    this.mChildFragmentManager.dispatchLowMemory();
  }
  
  void performMultiWindowModeChanged(boolean paramBoolean)
  {
    onMultiWindowModeChanged(paramBoolean);
    this.mChildFragmentManager.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  boolean performOptionsItemSelected(@NonNull MenuItem paramMenuItem)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible) && (onOptionsItemSelected(paramMenuItem))) {}
      while (this.mChildFragmentManager.dispatchOptionsItemSelected(paramMenuItem)) {
        return true;
      }
    }
    return false;
  }
  
  void performOptionsMenuClosed(@NonNull Menu paramMenu)
  {
    if (!this.mHidden)
    {
      if ((this.mHasMenu) && (this.mMenuVisible)) {
        onOptionsMenuClosed(paramMenu);
      }
      this.mChildFragmentManager.dispatchOptionsMenuClosed(paramMenu);
    }
  }
  
  void performPause()
  {
    this.mChildFragmentManager.dispatchPause();
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    this.mState = 3;
    this.mCalled = false;
    onPause();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }
  }
  
  void performPictureInPictureModeChanged(boolean paramBoolean)
  {
    onPictureInPictureModeChanged(paramBoolean);
    this.mChildFragmentManager.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  boolean performPrepareOptionsMenu(@NonNull Menu paramMenu)
  {
    boolean bool = false;
    int j = 0;
    if (!this.mHidden)
    {
      int i = j;
      if (this.mHasMenu)
      {
        i = j;
        if (this.mMenuVisible)
        {
          i = 1;
          onPrepareOptionsMenu(paramMenu);
        }
      }
      bool = i | this.mChildFragmentManager.dispatchPrepareOptionsMenu(paramMenu);
    }
    return bool;
  }
  
  void performPrimaryNavigationFragmentChanged()
  {
    boolean bool = this.mFragmentManager.isPrimaryNavigation(this);
    if ((this.mIsPrimaryNavigationFragment == null) || (this.mIsPrimaryNavigationFragment.booleanValue() != bool))
    {
      this.mIsPrimaryNavigationFragment = Boolean.valueOf(bool);
      onPrimaryNavigationFragmentChanged(bool);
      this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
    }
  }
  
  void performResume()
  {
    this.mChildFragmentManager.noteStateNotSaved();
    this.mChildFragmentManager.execPendingActions(true);
    this.mState = 4;
    this.mCalled = false;
    onResume();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
    }
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }
    this.mChildFragmentManager.dispatchResume();
  }
  
  void performSaveInstanceState(Bundle paramBundle)
  {
    onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
    Parcelable localParcelable = this.mChildFragmentManager.saveAllState();
    if (localParcelable != null) {
      paramBundle.putParcelable("android:support:fragments", localParcelable);
    }
  }
  
  void performStart()
  {
    this.mChildFragmentManager.noteStateNotSaved();
    this.mChildFragmentManager.execPendingActions(true);
    this.mState = 3;
    this.mCalled = false;
    onStart();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
    }
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }
    this.mChildFragmentManager.dispatchStart();
  }
  
  void performStop()
  {
    this.mChildFragmentManager.dispatchStop();
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }
    this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    this.mState = 2;
    this.mCalled = false;
    onStop();
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }
  }
  
  public void postponeEnterTransition()
  {
    ensureAnimationInfo().mEnterTransitionPostponed = true;
  }
  
  public final void postponeEnterTransition(long paramLong, @NonNull TimeUnit paramTimeUnit)
  {
    ensureAnimationInfo().mEnterTransitionPostponed = true;
    if (this.mFragmentManager != null) {}
    for (Handler localHandler = this.mFragmentManager.mHost.getHandler();; localHandler = new Handler(Looper.getMainLooper()))
    {
      localHandler.removeCallbacks(this.mPostponedDurationRunnable);
      localHandler.postDelayed(this.mPostponedDurationRunnable, paramTimeUnit.toMillis(paramLong));
      return;
    }
  }
  
  public void registerForContextMenu(@NonNull View paramView)
  {
    paramView.setOnCreateContextMenuListener(this);
  }
  
  public final void requestPermissions(@NonNull String[] paramArrayOfString, int paramInt)
  {
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.mHost.onRequestPermissionsFromFragment(this, paramArrayOfString, paramInt);
  }
  
  @NonNull
  public final FragmentActivity requireActivity()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }
    return localFragmentActivity;
  }
  
  @NonNull
  public final Bundle requireArguments()
  {
    Bundle localBundle = getArguments();
    if (localBundle == null) {
      throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }
    return localBundle;
  }
  
  @NonNull
  public final Context requireContext()
  {
    Context localContext = getContext();
    if (localContext == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }
    return localContext;
  }
  
  @Deprecated
  @NonNull
  public final FragmentManager requireFragmentManager()
  {
    return getParentFragmentManager();
  }
  
  @NonNull
  public final Object requireHost()
  {
    Object localObject = getHost();
    if (localObject == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }
    return localObject;
  }
  
  @NonNull
  public final Fragment requireParentFragment()
  {
    Fragment localFragment = getParentFragment();
    if (localFragment == null)
    {
      if (getContext() == null) {
        throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
      }
      throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }
    return localFragment;
  }
  
  @NonNull
  public final View requireView()
  {
    View localView = getView();
    if (localView == null) {
      throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }
    return localView;
  }
  
  void restoreChildFragmentState(@Nullable Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getParcelable("android:support:fragments");
      if (paramBundle != null)
      {
        this.mChildFragmentManager.restoreSaveState(paramBundle);
        this.mChildFragmentManager.dispatchCreate();
      }
    }
  }
  
  final void restoreViewState(Bundle paramBundle)
  {
    if (this.mSavedViewState != null)
    {
      this.mView.restoreHierarchyState(this.mSavedViewState);
      this.mSavedViewState = null;
    }
    this.mCalled = false;
    onViewStateRestored(paramBundle);
    if (!this.mCalled) {
      throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }
    if (this.mView != null) {
      this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }
  }
  
  public void setAllowEnterTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowEnterTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  public void setAllowReturnTransitionOverlap(boolean paramBoolean)
  {
    ensureAnimationInfo().mAllowReturnTransitionOverlap = Boolean.valueOf(paramBoolean);
  }
  
  void setAnimatingAway(View paramView)
  {
    ensureAnimationInfo().mAnimatingAway = paramView;
  }
  
  void setAnimator(Animator paramAnimator)
  {
    ensureAnimationInfo().mAnimator = paramAnimator;
  }
  
  public void setArguments(@Nullable Bundle paramBundle)
  {
    if ((this.mFragmentManager != null) && (isStateSaved())) {
      throw new IllegalStateException("Fragment already added and state has been saved");
    }
    this.mArguments = paramBundle;
  }
  
  public void setEnterSharedElementCallback(@Nullable SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mEnterTransitionCallback = paramSharedElementCallback;
  }
  
  public void setEnterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mEnterTransition = paramObject;
  }
  
  public void setExitSharedElementCallback(@Nullable SharedElementCallback paramSharedElementCallback)
  {
    ensureAnimationInfo().mExitTransitionCallback = paramSharedElementCallback;
  }
  
  public void setExitTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mExitTransition = paramObject;
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    if (this.mHasMenu != paramBoolean)
    {
      this.mHasMenu = paramBoolean;
      if ((isAdded()) && (!isHidden())) {
        this.mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  void setHideReplaced(boolean paramBoolean)
  {
    ensureAnimationInfo().mIsHideReplaced = paramBoolean;
  }
  
  public void setInitialSavedState(@Nullable Fragment.SavedState paramSavedState)
  {
    if (this.mFragmentManager != null) {
      throw new IllegalStateException("Fragment already added");
    }
    if ((paramSavedState != null) && (paramSavedState.mState != null)) {}
    for (paramSavedState = paramSavedState.mState;; paramSavedState = null)
    {
      this.mSavedFragmentState = paramSavedState;
      return;
    }
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    if (this.mMenuVisible != paramBoolean)
    {
      this.mMenuVisible = paramBoolean;
      if ((this.mHasMenu) && (isAdded()) && (!isHidden())) {
        this.mHost.onSupportInvalidateOptionsMenu();
      }
    }
  }
  
  void setNextAnim(int paramInt)
  {
    if ((this.mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo().mNextAnim = paramInt;
  }
  
  void setNextTransition(int paramInt)
  {
    if ((this.mAnimationInfo == null) && (paramInt == 0)) {
      return;
    }
    ensureAnimationInfo();
    this.mAnimationInfo.mNextTransition = paramInt;
  }
  
  void setOnStartEnterTransitionListener(Fragment.OnStartEnterTransitionListener paramOnStartEnterTransitionListener)
  {
    ensureAnimationInfo();
    if (paramOnStartEnterTransitionListener == this.mAnimationInfo.mStartEnterTransitionListener) {}
    do
    {
      return;
      if ((paramOnStartEnterTransitionListener != null) && (this.mAnimationInfo.mStartEnterTransitionListener != null)) {
        throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
      }
      if (this.mAnimationInfo.mEnterTransitionPostponed) {
        this.mAnimationInfo.mStartEnterTransitionListener = paramOnStartEnterTransitionListener;
      }
    } while (paramOnStartEnterTransitionListener == null);
    paramOnStartEnterTransitionListener.startListening();
  }
  
  public void setReenterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mReenterTransition = paramObject;
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.mRetainInstance = paramBoolean;
    if (this.mFragmentManager != null)
    {
      if (paramBoolean)
      {
        this.mFragmentManager.addRetainedFragment(this);
        return;
      }
      this.mFragmentManager.removeRetainedFragment(this);
      return;
    }
    this.mRetainInstanceChangedWhileDetached = true;
  }
  
  public void setReturnTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mReturnTransition = paramObject;
  }
  
  public void setSharedElementEnterTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mSharedElementEnterTransition = paramObject;
  }
  
  public void setSharedElementReturnTransition(@Nullable Object paramObject)
  {
    ensureAnimationInfo().mSharedElementReturnTransition = paramObject;
  }
  
  void setStateAfterAnimating(int paramInt)
  {
    ensureAnimationInfo().mStateAfterAnimating = paramInt;
  }
  
  public void setTargetFragment(@Nullable Fragment paramFragment, int paramInt)
  {
    FragmentManager localFragmentManager = this.mFragmentManager;
    if (paramFragment != null) {}
    for (Object localObject = paramFragment.mFragmentManager; (localFragmentManager != null) && (localObject != null) && (localFragmentManager != localObject); localObject = null) {
      throw new IllegalArgumentException("Fragment " + paramFragment + " must share the same FragmentManager to be set as a target fragment");
    }
    for (localObject = paramFragment; localObject != null; localObject = ((Fragment)localObject).getTargetFragment()) {
      if (localObject == this) {
        throw new IllegalArgumentException("Setting " + paramFragment + " as the target of " + this + " would create a target cycle");
      }
    }
    if (paramFragment == null)
    {
      this.mTargetWho = null;
      this.mTarget = null;
    }
    for (;;)
    {
      this.mTargetRequestCode = paramInt;
      return;
      if ((this.mFragmentManager != null) && (paramFragment.mFragmentManager != null))
      {
        this.mTargetWho = paramFragment.mWho;
        this.mTarget = null;
      }
      else
      {
        this.mTargetWho = null;
        this.mTarget = paramFragment;
      }
    }
  }
  
  @Deprecated
  public void setUserVisibleHint(boolean paramBoolean)
  {
    if ((!this.mUserVisibleHint) && (paramBoolean) && (this.mState < 3) && (this.mFragmentManager != null) && (isAdded()) && (this.mIsCreated)) {
      this.mFragmentManager.performPendingDeferredStart(this);
    }
    this.mUserVisibleHint = paramBoolean;
    if ((this.mState < 3) && (!paramBoolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.mDeferStart = bool;
      if (this.mSavedFragmentState != null) {
        this.mSavedUserVisibleHint = Boolean.valueOf(paramBoolean);
      }
      return;
    }
  }
  
  public boolean shouldShowRequestPermissionRationale(@NonNull String paramString)
  {
    if (this.mHost != null) {
      return this.mHost.onShouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent)
  {
    startActivity(paramIntent, null);
  }
  
  public void startActivity(@SuppressLint({"UnknownNullness"}) Intent paramIntent, @Nullable Bundle paramBundle)
  {
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.mHost.onStartActivityFromFragment(this, paramIntent, -1, paramBundle);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    startActivityForResult(paramIntent, paramInt, null);
  }
  
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.mHost.onStartActivityFromFragment(this, paramIntent, paramInt, paramBundle);
  }
  
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (this.mHost == null) {
      throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }
    this.mHost.onStartIntentSenderFromFragment(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public void startPostponedEnterTransition()
  {
    if ((this.mFragmentManager == null) || (this.mFragmentManager.mHost == null))
    {
      ensureAnimationInfo().mEnterTransitionPostponed = false;
      return;
    }
    if (Looper.myLooper() != this.mFragmentManager.mHost.getHandler().getLooper())
    {
      this.mFragmentManager.mHost.getHandler().postAtFrontOfQueue(new Fragment.3(this));
      return;
    }
    callStartTransitionListener();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("}");
    localStringBuilder.append(" (");
    localStringBuilder.append(this.mWho);
    localStringBuilder.append(")");
    if (this.mFragmentId != 0)
    {
      localStringBuilder.append(" id=0x");
      localStringBuilder.append(Integer.toHexString(this.mFragmentId));
    }
    if (this.mTag != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mTag);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void unregisterForContextMenu(@NonNull View paramView)
  {
    paramView.setOnCreateContextMenuListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.Fragment
 * JD-Core Version:    0.7.0.1
 */