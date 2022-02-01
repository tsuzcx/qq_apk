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
  public PeakFragmentActivity e;
  public PhotoCommonBaseData<O> f;
  public O g;
  public PhotoPreviewBaseData h;
  public PreviewPresenter i;
  
  protected PhotoPreviewCustomization(PeakFragmentActivity paramPeakFragmentActivity)
  {
    this.e = paramPeakFragmentActivity;
    this.f = PhotoCommonBaseData.getInstance(paramPeakFragmentActivity.getIntent().getBooleanExtra("NEED_NEW_PHOTO_COMMON_DATA", true));
    this.g = this.f.bindCommonData(r());
    paramPeakFragmentActivity.getIntent().putExtra("NEED_NEW_PHOTO_COMMON_DATA", false);
    this.f.addHoldNember();
    this.h = new PhotoPreviewBaseData();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoPreviewCustomization new，activity = ");
      localStringBuilder.append(paramPeakFragmentActivity);
      localStringBuilder.append(",PhotoCommonData = ");
      localStringBuilder.append(this.f);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
  
  protected OtherCommonData r()
  {
    return new PhotoPreviewCustomization.1(this);
  }
  
  public PreviewScene s()
  {
    return this.i.a;
  }
  
  public boolean t()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PhotoPreviewCustomization
 * JD-Core Version:    0.7.0.1
 */