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
  
  public View a()
  {
    return a().b();
  }
  
  public RelativeLayout.LayoutParams a()
  {
    return a().a();
  }
  
  public Class<? extends AbstractPhotoListActivity> a()
  {
    return AbstractPhotoListActivity.class;
  }
  
  public void a()
  {
    a().a();
  }
  
  public void a(int paramInt)
  {
    a().a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a(paramIntent);
  }
  
  public void a(View paramView)
  {
    a().a(paramView);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean) {}
  
  public View b()
  {
    return a().c();
  }
  
  public RelativeLayout.LayoutParams b()
  {
    return a().b();
  }
  
  public void b()
  {
    a().c();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.c();
  }
  
  public void e(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.e(paramInt);
  }
  
  public void g()
  {
    a().b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.i();
  }
  
  public void j()
  {
    a().d();
  }
  
  public void k()
  {
    a().e();
  }
  
  public void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.l();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    if (paramFloat < 0.8F) {
      a().getContentView().setVisibility(4);
    }
  }
  
  public void onGestureFinish()
  {
    g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity.overridePendingTransition(2130772065, 2130772067);
  }
  
  public void onResetPosition()
  {
    a().getContentView().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomizationBase
 * JD-Core Version:    0.7.0.1
 */