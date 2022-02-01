package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import java.io.File;

class PhotoPreviewCustomizationAIO$6
  implements Runnable
{
  PhotoPreviewCustomizationAIO$6(PhotoPreviewCustomizationAIO paramPhotoPreviewCustomizationAIO, String paramString) {}
  
  public void run()
  {
    QQAlbumUtils.a(new File(this.a).getParent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.6
 * JD-Core Version:    0.7.0.1
 */