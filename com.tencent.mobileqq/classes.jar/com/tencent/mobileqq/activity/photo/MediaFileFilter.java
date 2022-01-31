package com.tencent.mobileqq.activity.photo;

import android.util.SparseArray;

public abstract class MediaFileFilter
  implements Cloneable
{
  public static final MediaFileFilter MEDIA_FILTER_DEFAULT;
  public static final MediaFileFilter MEDIA_FILTER_DEFAULT_AND_HEIF = new MediaFileFilter.1();
  public static final SparseArray<MediaFileFilter> MEDIA_FILTER_MAP;
  public static final MediaFileFilter MEDIA_FILTER_NO_GIF;
  public static final MediaFileFilter MEDIA_FILTER_NO_GIF_AND_HEIF;
  public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE;
  public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE_AND_HEIF;
  public static final MediaFileFilter MEDIA_FILTER_SHOW_IMAGE_NO_GIF;
  public static final MediaFileFilter MEDIA_FILTER_SHOW_VIDEO;
  public static final int MF_DEFAULT = 0;
  public static final int MF_DEFAULT_AND_HEIF = 5;
  public static final int MF_NO_GIF = 3;
  public static final int MF_NO_GIF_AND_HEIF = 7;
  public static final int MF_SHOW_IMAGE = 1;
  public static final int MF_SHOW_IMAGE_AND_HEIF = 6;
  public static final int MF_SHOW_IMAGE_NO_GIF = 4;
  public static final int MF_SHOW_VIDEO = 2;
  private boolean supportWebp = false;
  
  static
  {
    MEDIA_FILTER_DEFAULT = new MediaFileFilter.2();
    MEDIA_FILTER_SHOW_IMAGE_AND_HEIF = new MediaFileFilter.3();
    MEDIA_FILTER_SHOW_IMAGE = new MediaFileFilter.4();
    MEDIA_FILTER_SHOW_VIDEO = new MediaFileFilter.5();
    MEDIA_FILTER_NO_GIF = new MediaFileFilter.6();
    MEDIA_FILTER_NO_GIF_AND_HEIF = new MediaFileFilter.7();
    MEDIA_FILTER_SHOW_IMAGE_NO_GIF = new MediaFileFilter.8();
    MEDIA_FILTER_MAP = new SparseArray();
    MEDIA_FILTER_MAP.put(0, MEDIA_FILTER_DEFAULT);
    MEDIA_FILTER_MAP.put(1, MEDIA_FILTER_SHOW_IMAGE);
    MEDIA_FILTER_MAP.put(2, MEDIA_FILTER_SHOW_VIDEO);
    MEDIA_FILTER_MAP.put(3, MEDIA_FILTER_NO_GIF);
    MEDIA_FILTER_MAP.put(4, MEDIA_FILTER_SHOW_IMAGE_NO_GIF);
    MEDIA_FILTER_MAP.put(5, MEDIA_FILTER_DEFAULT_AND_HEIF);
    MEDIA_FILTER_MAP.put(6, MEDIA_FILTER_SHOW_IMAGE_AND_HEIF);
    MEDIA_FILTER_MAP.put(7, MEDIA_FILTER_NO_GIF_AND_HEIF);
  }
  
  public static MediaFileFilter getFilter(int paramInt)
  {
    MediaFileFilter localMediaFileFilter2 = (MediaFileFilter)MEDIA_FILTER_MAP.get(paramInt);
    MediaFileFilter localMediaFileFilter1 = localMediaFileFilter2;
    if (localMediaFileFilter2 != null) {}
    try
    {
      localMediaFileFilter1 = (MediaFileFilter)localMediaFileFilter2.clone();
      return localMediaFileFilter1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return localMediaFileFilter2;
  }
  
  public boolean filter(String paramString)
  {
    if ((isSupportWebp()) && ("image/webp".equals(paramString))) {}
    while ((isSupportHeif()) && (("image/heif".equals(paramString)) || ("image/heic".equals(paramString)))) {
      return false;
    }
    return true;
  }
  
  public boolean isSupportHeif()
  {
    return false;
  }
  
  public boolean isSupportWebp()
  {
    return this.supportWebp;
  }
  
  public void setSupportWebp(boolean paramBoolean)
  {
    this.supportWebp = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter
 * JD-Core Version:    0.7.0.1
 */