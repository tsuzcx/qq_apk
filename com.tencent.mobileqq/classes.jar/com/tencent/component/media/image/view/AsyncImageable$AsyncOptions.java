package com.tencent.component.media.image.view;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;

public class AsyncImageable$AsyncOptions
{
  boolean alwaysLoad = false;
  int clipHeight = -1;
  int clipWidth = -1;
  Drawable defaultImage = null;
  int defaultImageId = 0;
  Drawable failImage = null;
  int failImageId = 0;
  String fileRootPath = null;
  Bitmap.Config imageConfig = ImageLoader.Options.DEFAULT_IMAGE_CONFIG;
  ImageProcessor imageProcessor = null;
  Animation inAnimation = null;
  boolean justCover = true;
  boolean justMemoryCache = false;
  boolean needShowGifAnimation = false;
  Animation outAnimation = null;
  boolean preferQuality = false;
  boolean priority = true;
  RawImageProcessor rawImageProcessor = null;
  boolean tryStream = false;
  
  public final void fillOptions(ImageLoader.Options paramOptions)
  {
    paramOptions.clipWidth = this.clipWidth;
    paramOptions.clipHeight = this.clipHeight;
    paramOptions.preferQuality = this.preferQuality;
    paramOptions.justCover = this.justCover;
    paramOptions.needShowGifAnimation = this.needShowGifAnimation;
    paramOptions.imageConfig = this.imageConfig;
    paramOptions.extraProcessor = this.imageProcessor;
    paramOptions.processor = this.rawImageProcessor;
    paramOptions.priority = this.priority;
    paramOptions.fileRootPath = this.fileRootPath;
  }
  
  protected void onClipSizeChanged(int paramInt1, int paramInt2) {}
  
  public void setAlwaysLoad(boolean paramBoolean)
  {
    if (this.alwaysLoad != paramBoolean) {
      this.alwaysLoad = paramBoolean;
    }
  }
  
  public void setAnimation(Animation paramAnimation1, Animation paramAnimation2)
  {
    if ((this.inAnimation != paramAnimation1) || (this.outAnimation != paramAnimation2))
    {
      this.inAnimation = paramAnimation1;
      this.outAnimation = paramAnimation2;
    }
  }
  
  public void setClipSize(int paramInt1, int paramInt2)
  {
    if ((this.clipWidth != paramInt1) || (this.clipHeight != paramInt2))
    {
      this.clipWidth = paramInt1;
      this.clipHeight = paramInt2;
      onClipSizeChanged(paramInt1, paramInt2);
    }
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.defaultImageId = paramInt;
    this.defaultImage = null;
  }
  
  public void setDefaultImage(Drawable paramDrawable)
  {
    this.defaultImageId = 0;
    this.defaultImage = paramDrawable;
  }
  
  public void setFailImage(int paramInt)
  {
    this.failImageId = paramInt;
    this.failImage = null;
  }
  
  public void setFailImage(Drawable paramDrawable)
  {
    this.failImageId = 0;
    this.failImage = paramDrawable;
  }
  
  public void setFileRootPath(String paramString)
  {
    if ((paramString != null) && (!paramString.equals(this.fileRootPath)))
    {
      this.fileRootPath = paramString;
      return;
    }
    if (paramString == null) {
      this.fileRootPath = null;
    }
  }
  
  public void setImageConfig(Bitmap.Config paramConfig)
  {
    if (this.imageConfig != paramConfig) {
      this.imageConfig = paramConfig;
    }
  }
  
  public void setImageProcessor(ImageProcessor paramImageProcessor)
  {
    if (this.imageProcessor != paramImageProcessor) {
      this.imageProcessor = paramImageProcessor;
    }
  }
  
  public void setJustCover(boolean paramBoolean)
  {
    if (this.justCover != paramBoolean) {
      this.justCover = paramBoolean;
    }
  }
  
  public void setJustMemoryCache(boolean paramBoolean)
  {
    if (this.justMemoryCache != paramBoolean) {
      this.justMemoryCache = paramBoolean;
    }
  }
  
  public void setNeedShowGifAnimation(boolean paramBoolean)
  {
    if (this.needShowGifAnimation != paramBoolean) {
      this.needShowGifAnimation = paramBoolean;
    }
  }
  
  public void setPreferQuality(boolean paramBoolean)
  {
    if (this.preferQuality != paramBoolean) {
      this.preferQuality = paramBoolean;
    }
  }
  
  public void setPriority(boolean paramBoolean)
  {
    if (this.priority != paramBoolean) {
      this.priority = paramBoolean;
    }
  }
  
  public void setRawImageProcessor(RawImageProcessor paramRawImageProcessor)
  {
    if (this.rawImageProcessor != paramRawImageProcessor) {
      this.rawImageProcessor = paramRawImageProcessor;
    }
  }
  
  public void setTryStream(boolean paramBoolean)
  {
    if (this.tryStream != paramBoolean) {
      this.tryStream = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncOptions
 * JD-Core Version:    0.7.0.1
 */