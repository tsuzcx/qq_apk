package com.tencent.mobileqq.activity.photo.album.preview;

import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.io.File;

public class PreviewAdapter
  extends BasePreviewAdapter
{
  public PreviewAdapter(PhotoPreviewLogicBase paramPhotoPreviewLogicBase)
  {
    super(paramPhotoPreviewLogicBase);
  }
  
  protected BasePreviewPresent generatePreviewPresent(PreviewBean paramPreviewBean)
  {
    if ((this.mPhotoPreviewData.canUseURL) && (AlbumUtil.isNetUrl(paramPreviewBean.getPath()))) {
      return new WebPicPreviewPresent(paramPreviewBean);
    }
    String str = paramPreviewBean.getPath();
    if ((str != null) && (new File(str).exists()) && (paramPreviewBean.mMediaType == 1)) {
      return new QVideoPreviewPresent(paramPreviewBean);
    }
    return super.generatePreviewPresent(paramPreviewBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.PreviewAdapter
 * JD-Core Version:    0.7.0.1
 */