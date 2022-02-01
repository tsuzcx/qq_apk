package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import com.tencent.image.Utils;

public class PhotoHeif
  extends PhotoIncompatibleBase
{
  public PhotoHeif(String paramString)
  {
    super(paramString);
    this.a = "PhotoIncompatibleWebp";
    this.b = "reportGenerateHeif";
  }
  
  static boolean a(String paramString)
  {
    return Utils.isHeifFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoHeif
 * JD-Core Version:    0.7.0.1
 */