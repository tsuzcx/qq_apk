package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$7
  extends MediaFileFilter
{
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = MimeHelper.getMimeType(paramString);
    } while ((arrayOfString != null) && ((("image".equals(arrayOfString[0])) && (MimeHelper.validateImageType(arrayOfString[1])) && (!arrayOfString[1].equals("gif"))) || (MimeHelper.validateVideoType(paramString))));
    return true;
  }
  
  public boolean isSupportHeif()
  {
    return true;
  }
  
  public boolean showImage()
  {
    return true;
  }
  
  public boolean showVideo()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.7
 * JD-Core Version:    0.7.0.1
 */