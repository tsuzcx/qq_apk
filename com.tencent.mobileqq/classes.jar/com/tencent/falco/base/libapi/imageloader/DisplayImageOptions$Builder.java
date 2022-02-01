package com.tencent.falco.base.libapi.imageloader;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;

public class DisplayImageOptions$Builder
{
  private BitmapDisplayer bitmapDisplayer;
  private boolean cacheInMemory = false;
  private boolean cacheOnDisk = false;
  private boolean considerExifParams = false;
  private BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
  private Drawable imageForEmptyUri = null;
  private Drawable imageOnFail = null;
  private Drawable imageOnLoading = null;
  private int imageResForEmptyUri = 0;
  private int imageResOnFail = 0;
  private int imageResOnLoading = 0;
  private DisplayImageOptions.OptionBitmapProcessor processor;
  
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
    this.imageResOnLoading = DisplayImageOptions.access$1200(paramDisplayImageOptions);
    this.imageResForEmptyUri = DisplayImageOptions.access$1300(paramDisplayImageOptions);
    this.imageResOnFail = DisplayImageOptions.access$1400(paramDisplayImageOptions);
    this.imageOnLoading = DisplayImageOptions.access$1500(paramDisplayImageOptions);
    this.imageForEmptyUri = DisplayImageOptions.access$1600(paramDisplayImageOptions);
    this.imageOnFail = DisplayImageOptions.access$1700(paramDisplayImageOptions);
    this.cacheInMemory = DisplayImageOptions.access$1800(paramDisplayImageOptions);
    this.cacheOnDisk = DisplayImageOptions.access$1900(paramDisplayImageOptions);
    this.decodingOptions = DisplayImageOptions.access$2000(paramDisplayImageOptions);
    this.considerExifParams = DisplayImageOptions.access$2100(paramDisplayImageOptions);
    this.bitmapDisplayer = DisplayImageOptions.access$2200(paramDisplayImageOptions);
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
  
  public Builder displayer(BitmapDisplayer paramBitmapDisplayer)
  {
    this.bitmapDisplayer = paramBitmapDisplayer;
    return this;
  }
  
  public Builder setProcessor(DisplayImageOptions.OptionBitmapProcessor paramOptionBitmapProcessor)
  {
    this.processor = paramOptionBitmapProcessor;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.DisplayImageOptions.Builder
 * JD-Core Version:    0.7.0.1
 */