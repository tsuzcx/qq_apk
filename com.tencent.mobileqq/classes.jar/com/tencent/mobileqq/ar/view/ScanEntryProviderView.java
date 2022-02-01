package com.tencent.mobileqq.ar.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationScanEntry;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationScanEntry;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.model.AbstractSession;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.AlbumUtil;

public abstract class ScanEntryProviderView
  extends FrameLayout
{
  protected AppInterface C;
  public boolean D = false;
  protected Context E;
  protected View F;
  protected AbstractSession G;
  protected ScanEntryContainerViewListener H;
  protected boolean I = false;
  protected boolean J = false;
  private boolean a = true;
  
  public ScanEntryProviderView(Context paramContext, ScanEntryContainerViewListener paramScanEntryContainerViewListener)
  {
    super(paramContext);
    this.E = paramContext;
    this.H = paramScanEntryContainerViewListener;
  }
  
  public abstract void a(Bundle paramBundle);
  
  public void a(ARCommonConfigInfo paramARCommonConfigInfo) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void c()
  {
    AbstractSession localAbstractSession = this.G;
    if (localAbstractSession != null) {
      localAbstractSession.k();
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d()
  {
    AbstractSession localAbstractSession = this.G;
    if (localAbstractSession != null) {
      localAbstractSession.m();
    }
  }
  
  public void e()
  {
    AbstractSession localAbstractSession = this.G;
    if (localAbstractSession != null) {
      localAbstractSession.o();
    }
  }
  
  public void f()
  {
    this.J = true;
    this.I = false;
    AbstractSession localAbstractSession = this.G;
    if (localAbstractSession != null) {
      localAbstractSession.k();
    }
  }
  
  public void g()
  {
    this.J = false;
    this.I = true;
    AbstractSession localAbstractSession = this.G;
    if (localAbstractSession != null) {
      localAbstractSession.m();
    }
  }
  
  public boolean getShowEntryFlag()
  {
    return this.a;
  }
  
  public void i_(String paramString) {}
  
  public boolean n()
  {
    return ((ScanTorchActivity)this.E).isResume();
  }
  
  public void o()
  {
    ((ScanTorchActivity)this.E).doOnBackPressed(false);
  }
  
  public void p()
  {
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.E;
    Intent localIntent = new Intent(localScanTorchActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 45);
    localIntent.putExtra("KEY_PHOTO_LIST_CLASS_NAME", PhotoListCustomizationScanEntry.a);
    localIntent.putExtra("KEY_PHOTO_PREVIEW_CLASS_NAME", PhotoPreviewCustomizationScanEntry.a);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ScanTorchActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    localIntent.putExtra("PhotoConst.MULTI_PREVIEW_IN_SINGLE_MODE", true);
    localScanTorchActivity.startActivity(localIntent);
    AlbumUtil.anim(localScanTorchActivity, false, true);
  }
  
  protected void setAllowShowEntry(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      ScanEntryContainerViewListener localScanEntryContainerViewListener = this.H;
      if (localScanEntryContainerViewListener != null) {
        localScanEntryContainerViewListener.a(paramBoolean);
      }
    }
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.C = paramAppInterface;
  }
  
  public void setRectAreas(Rect paramRect) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ScanEntryProviderView
 * JD-Core Version:    0.7.0.1
 */