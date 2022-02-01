package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;

public class PhotoPreviewCustomizationBase<O extends OtherCommonData>
  extends PhotoPreviewCustomization<O>
{
  protected PhotoPreviewCustomizationBase(PeakFragmentActivity paramPeakFragmentActivity)
  {
    super(paramPeakFragmentActivity);
  }
  
  public void a()
  {
    s().f();
  }
  
  public void a(int paramInt)
  {
    s().a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.i.a(paramIntent);
  }
  
  public void a(View paramView)
  {
    s().a(paramView);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    s().h();
  }
  
  public void c()
  {
    this.i.c();
  }
  
  public void e(int paramInt)
  {
    this.i.e(paramInt);
  }
  
  public void i()
  {
    s().g();
  }
  
  public void n()
  {
    this.i.n();
  }
  
  public void o()
  {
    s().j();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.i.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    if (paramFloat < 0.8F) {
      s().getContentView().setVisibility(4);
    }
  }
  
  public void onGestureFinish()
  {
    i();
    this.e.overridePendingTransition(2130772090, 2130772092);
  }
  
  public void onResetPosition()
  {
    s().getContentView().setVisibility(0);
  }
  
  public void p()
  {
    s().k();
  }
  
  public Class<? extends AbstractPhotoListActivity> q()
  {
    return AbstractPhotoListActivity.class;
  }
  
  public void u()
  {
    this.i.u();
  }
  
  public View v()
  {
    return s().b();
  }
  
  public RelativeLayout.LayoutParams w()
  {
    return s().c();
  }
  
  public View x()
  {
    return s().d();
  }
  
  public RelativeLayout.LayoutParams y()
  {
    return s().e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase
 * JD-Core Version:    0.7.0.1
 */