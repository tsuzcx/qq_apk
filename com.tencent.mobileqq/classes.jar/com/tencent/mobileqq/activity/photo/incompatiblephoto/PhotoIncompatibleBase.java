package com.tencent.mobileqq.activity.photo.incompatiblephoto;

public abstract class PhotoIncompatibleBase
{
  String a;
  String b;
  String c;
  
  public PhotoIncompatibleBase(String paramString)
  {
    this.c = paramString;
  }
  
  public static boolean b(String paramString)
  {
    return c(paramString) != null;
  }
  
  public static PhotoIncompatibleBase c(String paramString)
  {
    if (PhotoWebp.a(paramString)) {
      return new PhotoWebp(paramString);
    }
    if (PhotoHeif.a(paramString)) {
      return new PhotoHeif(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase
 * JD-Core Version:    0.7.0.1
 */