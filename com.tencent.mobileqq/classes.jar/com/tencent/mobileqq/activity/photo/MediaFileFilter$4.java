package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$4
  extends MediaFileFilter
{
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {}
    do
    {
      return false;
      paramString = MimeHelper.getMimeType(paramString);
    } while ((paramString != null) && ("image".equals(paramString[0])) && (MimeHelper.validateImageType(paramString[1])));
    return true;
  }
  
  public boolean showVideo()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.4
 * JD-Core Version:    0.7.0.1
 */