package com.tencent.mobileqq.activity.photo;

public class DynamicImageMediaFileFilter
  extends MediaFileFilter
{
  private MediaFileFilter mFilter;
  
  public DynamicImageMediaFileFilter(MediaFileFilter paramMediaFileFilter)
  {
    this.mFilter = paramMediaFileFilter;
  }
  
  public boolean filter(String paramString)
  {
    if (!super.filter(paramString)) {
      return false;
    }
    String[] arrayOfString = MimeHelper.getMimeType(paramString);
    if ((arrayOfString != null) && ("image".equals(arrayOfString[0])) && ("gif".equals(arrayOfString[1]))) {
      return true;
    }
    return this.mFilter.filter(paramString);
  }
  
  public boolean showImage()
  {
    return this.mFilter.showImage();
  }
  
  public boolean showVideo()
  {
    return this.mFilter.showVideo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter
 * JD-Core Version:    0.7.0.1
 */