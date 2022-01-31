package com.tencent.mobileqq.activity.photo;

import android.os.FileObserver;

public class MediaScannerFileObserver
  extends FileObserver
{
  private MediaScanner jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner;
  private final String jdField_a_of_type_JavaLangString = "MediaScannerFileObserver";
  private String b;
  
  public MediaScannerFileObserver(MediaScanner paramMediaScanner, String paramString)
  {
    super(paramString);
    this.b = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner = paramMediaScanner;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaScanner.a(paramInt, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaScannerFileObserver
 * JD-Core Version:    0.7.0.1
 */