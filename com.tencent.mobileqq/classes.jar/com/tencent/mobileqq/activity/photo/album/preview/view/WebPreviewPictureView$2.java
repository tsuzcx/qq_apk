package com.tencent.mobileqq.activity.photo.album.preview.view;

import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScaleView;

class WebPreviewPictureView$2
  implements Runnable
{
  WebPreviewPictureView$2(WebPreviewPictureView paramWebPreviewPictureView, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    this.this$0.b.setImageDrawable(this.a);
    this.this$0.b.initDrawable(this.a, this.this$0.mScreenWidthPx, this.this$0.mScreenHeightPx, 0);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mScreenWidthPx：");
      localStringBuilder.append(this.this$0.mScreenWidthPx);
      localStringBuilder.append("，mScreenHeightPx：");
      localStringBuilder.append(this.this$0.mScreenHeightPx);
      localStringBuilder.append("，getIntrinsicWidth：");
      localStringBuilder.append(this.a.getIntrinsicWidth());
      localStringBuilder.append("，getIntrinsicHeight：");
      localStringBuilder.append(this.a.getIntrinsicHeight());
      QLog.d("QQAlbum", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView.2
 * JD-Core Version:    0.7.0.1
 */