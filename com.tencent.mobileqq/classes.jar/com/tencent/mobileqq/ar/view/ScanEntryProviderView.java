package com.tencent.mobileqq.ar.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import anfl;
import anhx;
import bdfa;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;

public abstract class ScanEntryProviderView
  extends FrameLayout
{
  public Context a;
  public anfl a;
  public anhx a;
  public AppInterface a;
  private boolean a;
  protected View b;
  public boolean k;
  protected boolean l;
  public boolean m;
  
  public ScanEntryProviderView(Context paramContext, anhx paramanhx)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Anhx = paramanhx;
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo) {}
  
  public void a(String paramString) {}
  
  public void c()
  {
    if (this.jdField_a_of_type_Anfl != null) {
      this.jdField_a_of_type_Anfl.g();
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).isResume();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Anfl != null) {
      this.jdField_a_of_type_Anfl.h();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Anfl != null) {
      this.jdField_a_of_type_Anfl.j();
    }
  }
  
  public void f()
  {
    this.m = true;
    this.l = false;
    if (this.jdField_a_of_type_Anfl != null) {
      this.jdField_a_of_type_Anfl.g();
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Anhx != null) {
        this.jdField_a_of_type_Anhx.a(paramBoolean);
      }
    }
  }
  
  public void g()
  {
    this.m = false;
    this.l = true;
    if (this.jdField_a_of_type_Anfl != null) {
      this.jdField_a_of_type_Anfl.h();
    }
  }
  
  public void l()
  {
    ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).a(false);
  }
  
  public void m()
  {
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent(localScanTorchActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 45);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanTorchActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
    localScanTorchActivity.startActivity(localIntent);
    bdfa.anim(localScanTorchActivity, false, true);
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setRectAreas(Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderView
 * JD-Core Version:    0.7.0.1
 */