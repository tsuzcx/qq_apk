package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public class DisplayImageOptions$Builder
{
  private boolean cacheInMemory = false;
  private boolean cacheOnDisk = false;
  private boolean considerExifParams = false;
  private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
  private int delayBeforeLoading = 0;
  private BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
  private Object extraForDownloader = null;
  private Handler handler = null;
  private Drawable imageForEmptyUri = null;
  private Drawable imageOnFail = null;
  private Drawable imageOnLoading = null;
  private int imageResForEmptyUri = 0;
  private int imageResOnFail = 0;
  private int imageResOnLoading = 0;
  private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
  private boolean isSyncLoading = false;
  private BitmapProcessor postProcessor = null;
  private BitmapProcessor preProcessor = null;
  private boolean resetViewBeforeLoading = false;
  
  public Builder bitmapConfig(Bitmap.Config paramConfig)
  {
    if (paramConfig != null)
    {
      this.decodingOptions.inPreferredConfig = paramConfig;
      return this;
    }
    throw new IllegalArgumentException("bitmapConfig can't be null");
  }
  
  public DisplayImageOptions build()
  {
    return new DisplayImageOptions(this, null);
  }
  
  @Deprecated
  public Builder cacheInMemory()
  {
    this.cacheInMemory = true;
    return this;
  }
  
  public Builder cacheInMemory(boolean paramBoolean)
  {
    this.cacheInMemory = paramBoolean;
    return this;
  }
  
  @Deprecated
  public Builder cacheOnDisc()
  {
    return cacheOnDisk(true);
  }
  
  @Deprecated
  public Builder cacheOnDisc(boolean paramBoolean)
  {
    return cacheOnDisk(paramBoolean);
  }
  
  public Builder cacheOnDisk(boolean paramBoolean)
  {
    this.cacheOnDisk = paramBoolean;
    return this;
  }
  
  public Builder cloneFrom(DisplayImageOptions paramDisplayImageOptions)
  {
    this.imageResOnLoading = DisplayImageOptions.access$1900(paramDisplayImageOptions);
    this.imageResForEmptyUri = DisplayImageOptions.access$2000(paramDisplayImageOptions);
    this.imageResOnFail = DisplayImageOptions.access$2100(paramDisplayImageOptions);
    this.imageOnLoading = DisplayImageOptions.access$2200(paramDisplayImageOptions);
    this.imageForEmptyUri = DisplayImageOptions.access$2300(paramDisplayImageOptions);
    this.imageOnFail = DisplayImageOptions.access$2400(paramDisplayImageOptions);
    this.resetViewBeforeLoading = DisplayImageOptions.access$2500(paramDisplayImageOptions);
    this.cacheInMemory = DisplayImageOptions.access$2600(paramDisplayImageOptions);
    this.cacheOnDisk = DisplayImageOptions.access$2700(paramDisplayImageOptions);
    this.imageScaleType = DisplayImageOptions.access$2800(paramDisplayImageOptions);
    this.decodingOptions = DisplayImageOptions.access$2900(paramDisplayImageOptions);
    this.delayBeforeLoading = DisplayImageOptions.access$3000(paramDisplayImageOptions);
    this.considerExifParams = DisplayImageOptions.access$3100(paramDisplayImageOptions);
    this.extraForDownloader = DisplayImageOptions.access$3200(paramDisplayImageOptions);
    this.preProcessor = DisplayImageOptions.access$3300(paramDisplayImageOptions);
    this.postProcessor = DisplayImageOptions.access$3400(paramDisplayImageOptions);
    this.displayer = DisplayImageOptions.access$3500(paramDisplayImageOptions);
    this.handler = DisplayImageOptions.access$3600(paramDisplayImageOptions);
    this.isSyncLoading = DisplayImageOptions.access$3700(paramDisplayImageOptions);
    return this;
  }
  
  public Builder considerExifParams(boolean paramBoolean)
  {
    this.considerExifParams = paramBoolean;
    return this;
  }
  
  public Builder decodingOptions(BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null)
    {
      this.decodingOptions = paramOptions;
      return this;
    }
    throw new IllegalArgumentException("decodingOptions can't be null");
  }
  
  public Builder delayBeforeLoading(int paramInt)
  {
    this.delayBeforeLoading = paramInt;
    return this;
  }
  
  public Builder displayer(BitmapDisplayer paramBitmapDisplayer)
  {
    if (paramBitmapDisplayer != null)
    {
      this.displayer = paramBitmapDisplayer;
      return this;
    }
    throw new IllegalArgumentException("displayer can't be null");
  }
  
  public Builder extraForDownloader(Object paramObject)
  {
    this.extraForDownloader = paramObject;
    return this;
  }
  
  public Builder handler(Handler paramHandler)
  {
    this.handler = paramHandler;
    return this;
  }
  
  public Builder imageScaleType(ImageScaleType paramImageScaleType)
  {
    this.imageScaleType = paramImageScaleType;
    return this;
  }
  
  public Builder postProcessor(BitmapProcessor paramBitmapProcessor)
  {
    this.postProcessor = paramBitmapProcessor;
    return this;
  }
  
  public Builder preProcessor(BitmapProcessor paramBitmapProcessor)
  {
    this.preProcessor = paramBitmapProcessor;
    return this;
  }
  
  public Builder resetViewBeforeLoading()
  {
    this.resetViewBeforeLoading = true;
    return this;
  }
  
  public Builder resetViewBeforeLoading(boolean paramBoolean)
  {
    this.resetViewBeforeLoading = paramBoolean;
    return this;
  }
  
  public Builder showImageForEmptyUri(int paramInt)
  {
    this.imageResForEmptyUri = paramInt;
    return this;
  }
  
  public Builder showImageForEmptyUri(Drawable paramDrawable)
  {
    this.imageForEmptyUri = paramDrawable;
    return this;
  }
  
  public Builder showImageOnFail(int paramInt)
  {
    this.imageResOnFail = paramInt;
    return this;
  }
  
  public Builder showImageOnFail(Drawable paramDrawable)
  {
    this.imageOnFail = paramDrawable;
    return this;
  }
  
  public Builder showImageOnLoading(int paramInt)
  {
    this.imageResOnLoading = paramInt;
    return this;
  }
  
  public Builder showImageOnLoading(Drawable paramDrawable)
  {
    this.imageOnLoading = paramDrawable;
    return this;
  }
  
  @Deprecated
  public Builder showStubImage(int paramInt)
  {
    this.imageResOnLoading = paramInt;
    return this;
  }
  
  Builder syncLoading(boolean paramBoolean)
  {
    this.isSyncLoading = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayImageOptions.Builder
 * JD-Core Version:    0.7.0.1
 */