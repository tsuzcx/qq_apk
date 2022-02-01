package com.tencent.mobileqq.activity.photo;

import android.util.SparseArray;
import java.util.ArrayList;

public class MediaFileFilter
  implements Cloneable
{
  public static final MediaFileFilter MEDIA_FILTER_DEFAULT;
  public static final MediaFileFilter MEDIA_FILTER_DEFAULT_AND_HEIF = ;
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
  public static final int MIN_SIZE = 1000;
  public ArrayList<String> blockPaths;
  public int imageMaxHeight = -1;
  public int imageMaxWidth = -1;
  public int imageMinHeight = -1;
  public long imageMinSize = 1000L;
  public int imageMinWidth = -1;
  public boolean needGif = true;
  public boolean needHeif = false;
  public boolean needImage = true;
  public boolean needVideo = true;
  public boolean needWebp = false;
  public long videoMaxDuration = -1L;
  public int videoMaxHeight = -1;
  public int videoMaxWidth = -1;
  public int videoMinHeight = -1;
  public int videoMinWidth = -1;
  public long videoSizeLimit = -1L;
  
  static
  {
    MEDIA_FILTER_DEFAULT = createDefaultFilter();
    MEDIA_FILTER_SHOW_IMAGE_AND_HEIF = createImageAndHeifFilter();
    MEDIA_FILTER_SHOW_IMAGE = createImageFilter();
    MEDIA_FILTER_SHOW_VIDEO = createVideoFilter();
    MEDIA_FILTER_NO_GIF = createNoGifFilter();
    MEDIA_FILTER_NO_GIF_AND_HEIF = createNoGifAndHeifFilter();
    MEDIA_FILTER_SHOW_IMAGE_NO_GIF = createNoGifAndImageFilter();
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
  
  private static MediaFileFilter createDefaultAndHeifFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needHeif = true;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createDefaultFilter()
  {
    return new MediaFileFilter();
  }
  
  private static MediaFileFilter createImageAndHeifFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needHeif = true;
    localMediaFileFilter.needVideo = false;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createImageFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needVideo = false;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createNoGifAndHeifFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needGif = false;
    localMediaFileFilter.needHeif = true;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createNoGifAndImageFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needGif = false;
    localMediaFileFilter.needVideo = false;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createNoGifFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needGif = false;
    return localMediaFileFilter;
  }
  
  private static MediaFileFilter createVideoFilter()
  {
    MediaFileFilter localMediaFileFilter = new MediaFileFilter();
    localMediaFileFilter.needImage = false;
    return localMediaFileFilter;
  }
  
  public static MediaFileFilter getFilter(int paramInt)
  {
    MediaFileFilter localMediaFileFilter1 = (MediaFileFilter)MEDIA_FILTER_MAP.get(paramInt);
    if (localMediaFileFilter1 != null) {
      try
      {
        MediaFileFilter localMediaFileFilter2 = (MediaFileFilter)localMediaFileFilter1.clone();
        return localMediaFileFilter2;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
        return localMediaFileFilter1;
      }
    }
    return new MediaFileFilter();
  }
  
  public boolean filter(String paramString)
  {
    String[] arrayOfString = MimeHelper.getMimeType(paramString);
    if (arrayOfString != null) {
      if ("image".equals(arrayOfString[0]))
      {
        if (!this.needImage) {
          return true;
        }
        if ((!this.needGif) && (MimeHelper.validateImageType(arrayOfString[1])) && (arrayOfString[1].equals("gif"))) {
          return true;
        }
        if ((!this.needWebp) && ("image/webp".equals(paramString))) {
          return true;
        }
        if ((!this.needHeif) && (("image/heif".equals(paramString)) || ("image/heic".equals(paramString)))) {
          return true;
        }
      }
      else if ("video".equals(arrayOfString[0]))
      {
        if (!MimeHelper.validateVideoType(paramString)) {
          return true;
        }
        if (this.needVideo) {}
      }
      else
      {
        return true;
      }
    }
    return false;
  }
  
  public boolean showImage()
  {
    return this.needImage;
  }
  
  public boolean showVideo()
  {
    return this.needVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.MediaFileFilter
 * JD-Core Version:    0.7.0.1
 */