package com.tencent.component.media.image;

import android.graphics.Bitmap.Config;
import com.tencent.component.media.annotation.Public;

@Public
public class ImageLoader$ImageOptions
  implements Cloneable
{
  public static final int DEFAULT_CLIP_HEIGHT = -1;
  public static final int DEFAULT_CLIP_WIDTH = -1;
  public static final Bitmap.Config DEFAULT_IMAGE_CONFIG = Bitmap.Config.RGB_565;
  public static final boolean DEFAULT_JUST_COVER = true;
  public static final boolean DEFAULT_PREFER_QUALITY = false;
  public static final boolean DEFAULT_PRIORITY = true;
  public static final SecondImageProcessor DEFAULT_PROCESSOR = null;
  public static final boolean DEFAULT_TRY_STREAM = false;
  public int clipHeight = -1;
  public int clipWidth = -1;
  public Bitmap.Config imageConfig = DEFAULT_IMAGE_CONFIG;
  public boolean isNeedPieceLoad = false;
  public boolean justCover = true;
  public boolean needCache = true;
  public boolean needShowGifAnimation = false;
  public boolean preferQuality = false;
  public boolean priority = true;
  public SecondImageProcessor processor = DEFAULT_PROCESSOR;
  
  public final ImageOptions copy()
  {
    try
    {
      ImageOptions localImageOptions = (ImageOptions)clone();
      return localImageOptions;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.ImageOptions
 * JD-Core Version:    0.7.0.1
 */