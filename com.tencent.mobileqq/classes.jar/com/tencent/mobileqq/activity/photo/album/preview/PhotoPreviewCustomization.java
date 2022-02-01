package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.IPresenterCallBack;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.ISceneCallback;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;

public abstract class PhotoPreviewCustomization<O extends OtherCommonData>
  implements IPresenterCallBack, ISceneCallback
{
  public PeakFragmentActivity a;
  public O a;
  public PhotoCommonBaseData<O> a;
  public PhotoPreviewBaseData a;
  public PreviewPresenter a;
  
  protected PhotoPreviewCustomization(PeakFragmentActivity paramPeakFragmentActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPeakFragmentActivity = paramPeakFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData = PhotoCommonBaseData.getInstance(paramPeakFragmentActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.bindCommonData(a());
    paramPeakFragmentActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.addHoldNember();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPhotoPreviewBaseData = new PhotoPreviewBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoPreviewCustomization new，activity = ");
      localStringBuilder.append(paramPeakFragmentActivity);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  protected OtherCommonData a()
  {
    return new PhotoPreviewCustomization.1(this);
  }
  
  public PreviewScene a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a;
  }
  
  public boolean d()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomization
 * JD-Core Version:    0.7.0.1
 */