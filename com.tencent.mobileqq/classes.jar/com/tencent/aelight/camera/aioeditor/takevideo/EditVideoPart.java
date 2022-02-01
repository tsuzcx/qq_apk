package com.tencent.aelight.camera.aioeditor.takevideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class EditVideoPart
  implements IEventReceiver
{
  protected long a;
  @NonNull
  public final EditVideoPartManager a;
  protected EditVideoUi a;
  protected boolean g;
  
  public EditVideoPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager = paramEditVideoPartManager;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == null) {
      ShortVideoExceptionReporter.a(new IllegalStateException("have not attached ui"));
    }
  }
  
  public void A_()
  {
    b();
  }
  
  @NonNull
  public Context a()
  {
    b();
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext();
  }
  
  @NonNull
  public Resources a()
  {
    b();
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getContext().getResources();
  }
  
  @NonNull
  protected View a(int paramInt)
  {
    b();
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getRootView().findViewById(paramInt);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find view by id ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public EditVideoPart.EditExport a(Class<? extends EditVideoPart.EditExport> paramClass)
  {
    b();
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramClass);
  }
  
  @NonNull
  public EditVideoUi a()
  {
    b();
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi;
  }
  
  protected String a(int paramInt)
  {
    b();
    return a().getString(paramInt);
  }
  
  public void a()
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    b();
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    a(paramInt2, paramObject);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    a(paramGenerateContext);
  }
  
  public void a(int paramInt, Object paramObject) {}
  
  public void a(Bundle paramBundle)
  {
    b();
  }
  
  public void a(EditVideoUi paramEditVideoUi)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi == null)
    {
      if (paramEditVideoUi != null)
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi = paramEditVideoUi;
        return;
      }
      throw new IllegalArgumentException("ui should not be null");
    }
    throw new IllegalStateException("attach context duplicate");
  }
  
  @Deprecated
  public void a(@NonNull GenerateContext paramGenerateContext) {}
  
  public void a(Class<? extends EditVideoPart.EditExport> paramClass, EditVideoPart.EditExport paramEditExport)
  {
    b();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(paramClass, paramEditExport);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public boolean a()
  {
    b();
    return false;
  }
  
  protected boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    b();
  }
  
  public void b(@NonNull GenerateContext paramGenerateContext)
  {
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi.getActivity());
  }
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.i();
  }
  
  public void d()
  {
    b();
  }
  
  public void e()
  {
    this.g = true;
    n();
  }
  
  public void f(boolean paramBoolean)
  {
    b();
  }
  
  public void i() {}
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.isValidate();
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoUi = null;
  }
  
  public void o()
  {
    b();
  }
  
  public void p() {}
  
  public void z_()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPart
 * JD-Core Version:    0.7.0.1
 */