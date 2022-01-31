package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class AppVideoDecoder
  implements BitmapDecoder
{
  Context jdField_a_of_type_AndroidContentContext;
  LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  
  public AppVideoDecoder(Context paramContext, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
  }
  
  public Bitmap a(URL paramURL)
  {
    return ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, 3), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbWidth, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.AppVideoDecoder
 * JD-Core Version:    0.7.0.1
 */