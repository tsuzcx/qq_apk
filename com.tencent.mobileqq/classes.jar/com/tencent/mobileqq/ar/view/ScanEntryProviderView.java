package com.tencent.mobileqq.ar.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.AbstractSession;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.AlbumUtil;

public abstract class ScanEntryProviderView
  extends FrameLayout
{
  protected Context a;
  protected AppInterface a;
  protected AbstractSession a;
  protected ScanEntryContainerViewListener a;
  private boolean a;
  protected View b;
  public boolean k = false;
  protected boolean l = false;
  protected boolean m = false;
  
  public ScanEntryProviderView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener = paramScanEntryContainerViewListener;
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo) {}
  
  public void a(String paramString) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.g();
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public boolean c()
  {
    return ((ScanTorchActivity)this.jdField_a_of_type_AndroidContentContext).isResume();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.h();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.j();
    }
  }
  
  public void f()
  {
    this.m = true;
    this.l = false;
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.g();
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqArViewScanEntryContainerViewListener.a(paramBoolean);
      }
    }
  }
  
  public void g()
  {
    this.m = false;
    this.l = true;
    if (this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession != null) {
      this.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession.h();
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
    AlbumUtil.anim(localScanTorchActivity, false, true);
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void setRectAreas(Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderView
 * JD-Core Version:    0.7.0.1
 */