package com.tencent.aelight.camera.aeeditor.arch;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.aelight.camera.aeeditor.AEEditorModuleManager;
import com.tencent.aelight.camera.aeeditor.view.ProgressView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public abstract class AEEditorBaseFragment
  extends QPublicBaseFragment
  implements LifecycleOwner, ViewModelStoreOwner, IAEEditorModule
{
  protected Dialog a;
  protected Handler a;
  private final LifecycleRegistry jdField_a_of_type_AndroidxLifecycleLifecycleRegistry = new LifecycleRegistry(this);
  private ViewModelStore jdField_a_of_type_AndroidxLifecycleViewModelStore;
  private AEEditorModuleManager jdField_a_of_type_ComTencentAelightCameraAeeditorAEEditorModuleManager;
  protected ProgressView a;
  public String a;
  
  public AEEditorBaseFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  private void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable paramEvent)
    {
      label9:
      break label9;
    }
    QLog.e("AEEditorBaseFragment", 1, "mLifecycleRegistry 初始化失败");
  }
  
  @NonNull
  public AEEditorModuleManager a()
  {
    AEEditorModuleManager localAEEditorModuleManager = this.jdField_a_of_type_ComTencentAelightCameraAeeditorAEEditorModuleManager;
    if (localAEEditorModuleManager != null) {
      return localAEEditorModuleManager;
    }
    throw new RuntimeException("moduleManager not set");
  }
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(AEEditorModuleManager paramAEEditorModuleManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorAEEditorModuleManager = paramAEEditorModuleManager;
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    if (getActivity() == null) {
      return;
    }
    FragmentActivity localFragmentActivity = getActivity();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AEEditorBaseFragment.1(this, localFragmentActivity, paramOnDismissListener, paramBoolean, paramCharSequence), paramLong);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new AEEditorBaseFragment.2(this));
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return this.jdField_a_of_type_AndroidxLifecycleLifecycleRegistry;
  }
  
  @NonNull
  public ViewModelStore getViewModelStore()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      if (this.jdField_a_of_type_AndroidxLifecycleViewModelStore == null) {
        this.jdField_a_of_type_AndroidxLifecycleViewModelStore = new ViewModelStore();
      }
      return this.jdField_a_of_type_AndroidxLifecycleViewModelStore;
    }
    throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(Lifecycle.Event.ON_CREATE);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a(Lifecycle.Event.ON_DESTROY);
  }
  
  public void onPause()
  {
    super.onPause();
    a(Lifecycle.Event.ON_PAUSE);
  }
  
  public void onResume()
  {
    super.onResume();
    a(Lifecycle.Event.ON_RESUME);
    if ((this.jdField_a_of_type_ComTencentAelightCameraAeeditorAEEditorModuleManager == null) && (getActivity() != null) && ((getActivity() instanceof AEEditorActivity))) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorAEEditorModuleManager = ((AEEditorActivity)getActivity()).a();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    a(Lifecycle.Event.ON_START);
  }
  
  public void onStop()
  {
    super.onStop();
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.arch.AEEditorBaseFragment
 * JD-Core Version:    0.7.0.1
 */