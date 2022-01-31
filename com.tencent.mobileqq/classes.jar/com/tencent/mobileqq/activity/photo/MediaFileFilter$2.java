package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$2
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
    } while ((arrayOfString != null) && ((("image".equals(arrayOfString[0])) && (MimeHelper.validateImageType(arrayOfString[1]))) || (MimeHelper.validateVideoType(paramString))));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.2
 * JD-Core Version:    0.7.0.1
 */