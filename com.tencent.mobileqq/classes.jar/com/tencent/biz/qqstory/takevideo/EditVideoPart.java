package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tribe.async.dispatch.IEventReceiver;

public abstract class EditVideoPart
  implements IEventReceiver
{
  @NonNull
  public final EditVideoPartManager a;
  public EditVideoUi a;
  public long c;
  
  public EditVideoPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager = paramEditVideoPartManager;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi == null) {
      throw new IllegalStateException("have not attached ui");
    }
  }
  
  public void N_()
  {
    e();
  }
  
  public void O_()
  {
    e();
  }
  
  @NonNull
  public Context a()
  {
    e();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a();
  }
  
  @NonNull
  public Resources a()
  {
    e();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().getResources();
  }
  
  @NonNull
  public View a(int paramInt)
  {
    e();
    View localView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi.a().findViewById(paramInt);
    if (localView == null) {
      throw new IllegalArgumentException("can not find view by id " + paramInt);
    }
    return localView;
  }
  
  public EditVideoPart.EditExport a(Class paramClass)
  {
    e();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramClass);
  }
  
  @NonNull
  public EditVideoUi a()
  {
    e();
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi;
  }
  
  protected String a(int paramInt)
  {
    e();
    return a().getString(paramInt);
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e();
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
    e();
  }
  
  public void a(EditVideoUi paramEditVideoUi)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi != null) {
      throw new IllegalStateException("attach context duplicate");
    }
    if (paramEditVideoUi == null) {
      throw new IllegalArgumentException("ui should not be null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoUi = paramEditVideoUi;
  }
  
  @Deprecated
  public void a(@NonNull GenerateContext paramGenerateContext) {}
  
  public void a(Class paramClass, EditVideoPart.EditExport paramEditExport)
  {
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(paramClass, paramEditExport);
  }
  
  public void a(@NonNull Error paramError) {}
  
  public boolean a()
  {
    e();
    return false;
  }
  
  public boolean a(Message paramMessage)
  {
    return false;
  }
  
  public void b(Bundle paramBundle)
  {
    e();
  }
  
  public void b(@NonNull GenerateContext paramGenerateContext) {}
  
  public final boolean b(@NonNull Message paramMessage)
  {
    boolean bool = a(paramMessage);
    paramMessage.recycle();
    return bool;
  }
  
  public void d()
  {
    e();
  }
  
  public void f()
  {
    e();
  }
  
  public void g()
  {
    e();
  }
  
  public boolean isValidate()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.isValidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPart
 * JD-Core Version:    0.7.0.1
 */