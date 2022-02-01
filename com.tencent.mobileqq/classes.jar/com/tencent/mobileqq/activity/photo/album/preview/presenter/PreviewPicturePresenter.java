package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

public class PreviewPicturePresenter
  extends BasePreviewPresent
{
  public String a(int paramInt)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = getItem(paramInt);
    if ((localRichMediaBrowserInfo != null) && ((localRichMediaBrowserInfo.baseData instanceof PreviewPictureData))) {
      return ((PreviewPictureData)localRichMediaBrowserInfo.baseData).filePath;
    }
    return null;
  }
  
  public void a()
  {
    if ((this.mainBrowserPresenter instanceof PreviewPresenter)) {
      ((PreviewPresenter)this.mainBrowserPresenter).a.e(100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPicturePresenter
 * JD-Core Version:    0.7.0.1
 */