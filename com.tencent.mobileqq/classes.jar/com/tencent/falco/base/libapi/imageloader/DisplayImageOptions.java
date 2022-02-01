package com.tencent.falco.base.libapi.imageloader;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;

public final class DisplayImageOptions
{
  private final BitmapDisplayer bitmapDisplayer;
  private final boolean cacheInMemory;
  private final boolean cacheOnDisk;
  private final boolean considerExifParams;
  private final BitmapFactory.Options decodingOptions;
  private final Drawable imageForEmptyUri;
  private final Drawable imageOnFail;
  private final Drawable imageOnLoading;
  private final int imageResForEmptyUri;
  private final int imageResOnFail;
  private final int imageResOnLoading;
  private final DisplayImageOptions.OptionBitmapProcessor processor;
  
  private DisplayImageOptions(DisplayImageOptions.Builder paramBuilder)
  {
    this.imageResOnLoading = DisplayImageOptions.Builder.access$000(paramBuilder);
    this.imageResForEmptyUri = DisplayImageOptions.Builder.access$100(paramBuilder);
    this.imageResOnFail = DisplayImageOptions.Builder.access$200(paramBuilder);
    this.imageOnLoading = DisplayImageOptions.Builder.access$300(paramBuilder);
    this.imageForEmptyUri = DisplayImageOptions.Builder.access$400(paramBuilder);
    this.imageOnFail = DisplayImageOptions.Builder.access$500(paramBuilder);
    this.cacheInMemory = DisplayImageOptions.Builder.access$600(paramBuilder);
    this.cacheOnDisk = DisplayImageOptions.Builder.access$700(paramBuilder);
    this.decodingOptions = DisplayImageOptions.Builder.access$800(paramBuilder);
    this.considerExifParams = DisplayImageOptions.Builder.access$900(paramBuilder);
    this.bitmapDisplayer = DisplayImageOptions.Builder.access$1000(paramBuilder);
    this.processor = DisplayImageOptions.Builder.access$1100(paramBuilder);
  }
  
  public static DisplayImageOptions createSimple()
  {
    return new DisplayImageOptions.Builder().build();
  }
  
  public BitmapDisplayer getBitmapDisplayer()
  {
    return this.bitmapDisplayer;
  }
  
  public BitmapFactory.Options getDecodingOptions()
  {
    return this.decodingOptions;
  }
  
  public int getImageForEmptyUri()
  {
    return this.imageResForEmptyUri;
  }
  
  public Drawable getImageForEmptyUri(Resources paramResources)
  {
    int i = this.imageResForEmptyUri;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageForEmptyUri;
  }
  
  public int getImageOnFail()
  {
    return this.imageResOnFail;
  }
  
  public Drawable getImageOnFail(Resources paramResources)
  {
    int i = this.imageResOnFail;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageOnFail;
  }
  
  public int getImageOnLoading()
  {
    return this.imageResOnLoading;
  }
  
  public Drawable getImageOnLoading(Resources paramResources)
  {
    int i = this.imageResOnLoading;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageOnLoading;
  }
  
  public DisplayImageOptions.OptionBitmapProcessor getProcessor()
  {
    return this.processor;
  }
  
  public boolean isCacheInMemory()
  {
    return this.cacheInMemory;
  }
  
  public boolean isCacheOnDisk()
  {
    return this.cacheOnDisk;
  }
  
  public boolean isConsiderExifParams()
  {
    return this.considerExifParams;
  }
  
  public boolean shouldShowImageForEmptyUri()
  {
    return (this.imageForEmptyUri != null) || (this.imageResForEmptyUri != 0);
  }
  
  public boolean shouldShowImageOnFail()
  {
    return (this.imageOnFail != null) || (this.imageResOnFail != 0);
  }
  
  public boolean shouldShowImageOnLoading()
  {
    return (this.imageOnLoading != null) || (this.imageResOnLoading != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.DisplayImageOptions
 * JD-Core Version:    0.7.0.1
 */