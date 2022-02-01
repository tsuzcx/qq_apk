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
  
  public static PhotoIncompatibleBase a(String paramString)
  {
    if (PhotoWebp.a(paramString)) {
      return new PhotoWebp(paramString);
    }
    if (PhotoHeif.a(paramString)) {
      return new PhotoHeif(paramString);
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    return a(paramString) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase
 * JD-Core Version:    0.7.0.1
 */