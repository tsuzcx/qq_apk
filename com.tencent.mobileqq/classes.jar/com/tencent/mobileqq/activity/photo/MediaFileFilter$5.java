package com.tencent.mobileqq.activity.photo;

final class MediaFileFilter$5
  extends MediaFileFilter
{
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {}
    while (MimeHelper.validateVideoType(paramString)) {
      return false;
    }
    return true;
  }
  
  public boolean showImage()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter.5
 * JD-Core Version:    0.7.0.1
 */