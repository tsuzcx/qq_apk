package com.tencent.mobileqq.activity.photo;

public class DynamicImageMediaFileFilter
  extends MediaFileFilter
{
  private MediaFileFilter f;
  
  public DynamicImageMediaFileFilter(MediaFileFilter paramMediaFileFilter)
  {
    this.f = paramMediaFileFilter;
  }
  
  public boolean a()
  {
    return this.f.a();
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = MimeHelper.a(paramString);
    if ((arrayOfString != null) && ("image".equals(arrayOfString[0])) && ("gif".equals(arrayOfString[1]))) {
      return true;
    }
    return this.f.a(paramString);
  }
  
  public boolean b()
  {
    return this.f.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter
 * JD-Core Version:    0.7.0.1
 */