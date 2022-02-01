package androidx.activity;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
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
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements OnBackPressedDispatcherOwner, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner
{
  @LayoutRes
  private int mContentLayoutId;
  private ViewModelProvider.Factory mDefaultFactory;
  private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  private final OnBackPressedDispatcher mOnBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity.1(this));
  private final SavedStateRegistryController mSavedStateRegistryController = SavedStateRegistryController.create(this);
  private ViewModelStore mViewModelStore;
  
  public ComponentActivity()
  {
    if (getLifecycle() == null) {
      throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getLifecycle().addObserver(new ComponentActivity.2(this));
    }
    getLifecycle().addObserver(new ComponentActivity.3(this));
    if ((19 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 23)) {
      getLifecycle().addObserver(new ImmLeaksCleaner(this));
    }
  }
  
  @ContentView
  public ComponentActivity(@LayoutRes int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
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
  public ViewModelProvider.Factory getDefaultViewModelProviderFactory()
  {
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
    Application localApplication;
    if (this.mDefaultFactory == null)
    {
      localApplication = getApplication();
      if (getIntent() == null) {
        break label63;
      }
    }
    label63:
    for (Bundle localBundle = getIntent().getExtras();; localBundle = null)
    {
      this.mDefaultFactory = new SavedStateViewModelFactory(localApplication, this, localBundle);
      return this.mDefaultFactory;
    }
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
    if (getApplication() == null) {
      throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }
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
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mSavedStateRegistryController.performRestore(paramBundle);
    ReportFragment.injectIfNeededIn(this);
    if (this.mContentLayoutId != 0) {
      setContentView(this.mContentLayoutId);
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
  public void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    Lifecycle localLifecycle = getLifecycle();
    if ((localLifecycle instanceof LifecycleRegistry)) {
      ((LifecycleRegistry)localLifecycle).setCurrentState(Lifecycle.State.CREATED);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.performSave(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.activity.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */