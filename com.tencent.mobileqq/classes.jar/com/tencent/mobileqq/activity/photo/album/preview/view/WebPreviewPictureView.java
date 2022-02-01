package com.tencent.mobileqq.activity.photo.album.preview.view;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPicturePresenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;
import com.tencent.sharpP.SharpPUtils;

public class WebPreviewPictureView
  extends PreviewPictureView
{
  public WebPreviewPictureView(Context paramContext, PreviewPicturePresenter paramPreviewPicturePresenter)
  {
    super(paramContext, paramPreviewPicturePresenter);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentRichmediabrowserViewRecyclerviewBrowserScaleView.post(new WebPreviewPictureView.2(this, paramURLDrawable));
  }
  
  public void bindView(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPicturePresenter.a(paramInt);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.mScreenWidthPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.mScreenHeightPx;
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = Constants.TRANSPARENT;
    localObject1 = SharpPUtils.getWebpUrl((String)localObject1);
    localObject2 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
    if (localObject2 == null) {
      QLog.w("QQAlbum", 2, "WebPreviewPictureView drawable == null");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebPreviewPictureView url:");
      localStringBuilder.append((String)localObject1);
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
    ((URLDrawable)localObject2).setURLDrawableListener(new WebPreviewPictureView.1(this));
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("drawable.getStatus()：");
      ((StringBuilder)localObject1).append(((URLDrawable)localObject2).getStatus());
      QLog.d("QQAlbum", 2, ((StringBuilder)localObject1).toString());
    }
    if (((URLDrawable)localObject2).getStatus() == 1)
    {
      a((URLDrawable)localObject2);
      return;
    }
    ((URLDrawable)localObject2).startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView
 * JD-Core Version:    0.7.0.1
 */