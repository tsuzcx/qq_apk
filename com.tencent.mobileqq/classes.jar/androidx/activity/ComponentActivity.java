package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements OnBackPressedDispatcherOwner, ContextAware, ActivityResultCaller, ActivityResultRegistryOwner, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner
{
  private ActivityResultRegistry mActivityResultRegistry = new ComponentActivity.2(this);
  @LayoutRes
  private int mContentLayoutId;
  final ContextAwareHelper mContextAwareHelper = new ContextAwareHelper();
  private ViewModelProvider.Factory mDefaultFactory;
  private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity.1(this));
  final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create(this);
  private ViewModelStore mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() != null)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        getLifecycle().addObserver(new ComponentActivity.3(this));
      }
      getLifecycle().addObserver(new ComponentActivity.4(this));
      if ((19 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 23)) {
        getLifecycle().addObserver(new ImmLeaksCleaner(this));
      }
      return;
    }
    throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
  }
  
  @ContentView
  public ComponentActivity(@LayoutRes int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private void initViewTreeOwners()
  {
    ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
    ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
    ViewTreeSavedStateRegistryOwner.set(getWindow().getDecorView(), this);
  }
  
  public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.addContentView(paramView, paramLayoutParams);
  }
  
  public final void addOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener)
  {
    this.mContextAwareHelper.addOnContextAvailableListener(paramOnContextAvailableListener);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @NonNull
  public final ActivityResultRegistry getActivityResultRegistry()
  {
    return this.mActivityResultRegistry;
  }
  
  @NonNull
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory()
  {
    if (getApplication() != null)
    {
      if (this.mDefaultFactory == null)
      {
        Application localApplication = getApplication();
        Bundle localBundle;
        if (getIntent() != null) {
          localBundle = getIntent().getExtras();
        } else {
          localBundle = null;
        }
        this.mDefaultFactory = new SavedStateViewModelFactory(localApplication, this, localBundle);
      }
      return this.mDefaultFactory;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  @Nullable
  public Object getLastCustomNonConfigurationInstance()
  {
    ComponentActivity.NonConfigurationInstances localNonConfigurationInstances = (ComponentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null) {
      return localNonConfigurationInstances.custom;
    }
    return null;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  @NonNull
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.mOnBackPressedDispatcher;
  }
  
  @NonNull
  public final SavedStateRegistry getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.getSavedStateRegistry();
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (getApplication() != null)
    {
      if (this.mViewModelStore == null)
      {
        ComponentActivity.NonConfigurationInstances localNonConfigurationInstances = (ComponentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
        if (localNonConfigurationInstances != null) {
          this.mViewModelStore = localNonConfigurationInstances.viewModelStore;
        }
        if (this.mViewModelStore == null) {
          this.mViewModelStore = new ViewModelStore();
        }
      }
      return this.mViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  @Deprecated
  @CallSuper
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if (!this.mActivityResultRegistry.dispatchResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  @MainThread
  public void onBackPressed()
  {
    this.mOnBackPressedDispatcher.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    this.mSavedStateRegistryController.performRestore(paramBundle);
    this.mContextAwareHelper.dispatchOnContextAvailable(this);
    super.onCreate(paramBundle);
    this.mActivityResultRegistry.onRestoreInstanceState(paramBundle);
    ReportFragment.injectIfNeededIn(this);
    int i = this.mContentLayoutId;
    if (i != 0) {
      setContentView(i);
    }
  }
  
  @Deprecated
  @CallSuper
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if ((!this.mActivityResultRegistry.dispatchResult(paramInt, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", paramArrayOfInt))) && (Build.VERSION.SDK_INT >= 23)) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  @Deprecated
  @Nullable
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  @Nullable
  public final Object onRetainNonConfigurationInstance()
  {
    Object localObject3 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mViewModelStore;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      ComponentActivity.NonConfigurationInstances localNonConfigurationInstances = (ComponentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
      localObject1 = localObject2;
      if (localNonConfigurationInstances != null) {
        localObject1 = localNonConfigurationInstances.viewModelStore;
      }
    }
    if ((localObject1 == null) && (localObject3 == null)) {
      return null;
    }
    localObject2 = new ComponentActivity.NonConfigurationInstances();
    ((ComponentActivity.NonConfigurationInstances)localObject2).custom = localObject3;
    ((ComponentActivity.NonConfigurationInstances)localObject2).viewModelStore = ((ViewModelStore)localObject1);
    return localObject2;
  }
  
  @CallSuper
  protected void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    Lifecycle localLifecycle = getLifecycle();
    if ((localLifecycle instanceof LifecycleRegistry)) {
      ((LifecycleRegistry)localLifecycle).setCurrentState(Lifecycle.State.CREATED);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
    this.mActivityResultRegistry.onSaveInstanceState(paramBundle);
  }
  
  @Nullable
  public Context peekAvailableContext()
  {
    return this.mContextAwareHelper.peekAvailableContext();
  }
  
  @NonNull
  public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultCallback<O> paramActivityResultCallback)
  {
    return registerForActivityResult(paramActivityResultContract, this.mActivityResultRegistry, paramActivityResultCallback);
  }
  
  @NonNull
  public final <I, O> ActivityResultLauncher<I> registerForActivityResult(@NonNull ActivityResultContract<I, O> paramActivityResultContract, @NonNull ActivityResultRegistry paramActivityResultRegistry, @NonNull ActivityResultCallback<O> paramActivityResultCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("activity_rq#");
    localStringBuilder.append(this.mNextLocalRequestCode.getAndIncrement());
    return paramActivityResultRegistry.register(localStringBuilder.toString(), this, paramActivityResultContract, paramActivityResultCallback);
  }
  
  public final void removeOnContextAvailableListener(@NonNull OnContextAvailableListener paramOnContextAvailableListener)
  {
    this.mContextAwareHelper.removeOnContextAvailableListener(paramOnContextAvailableListener);
  }
  
  public void setContentView(@LayoutRes int paramInt)
  {
    initViewTreeOwners();
    super.setContentView(paramInt);
  }
  
  public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView)
  {
    initViewTreeOwners();
    super.setContentView(paramView);
  }
  
  public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View paramView, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams paramLayoutParams)
  {
    initViewTreeOwners();
    super.setContentView(paramView, paramLayoutParams);
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  @Deprecated
  public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  @Deprecated
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  @Deprecated
  public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.activity.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */