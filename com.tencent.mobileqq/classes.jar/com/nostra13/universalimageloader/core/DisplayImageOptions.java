package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public final class DisplayImageOptions
{
  private final boolean cacheInMemory;
  private final boolean cacheOnDisk;
  private final boolean considerExifParams;
  private final BitmapFactory.Options decodingOptions;
  private final int delayBeforeLoading;
  private final BitmapDisplayer displayer;
  private final Object extraForDownloader;
  private final Handler handler;
  private final Drawable imageForEmptyUri;
  private final Drawable imageOnFail;
  private final Drawable imageOnLoading;
  private final int imageResForEmptyUri;
  private final int imageResOnFail;
  private final int imageResOnLoading;
  private final ImageScaleType imageScaleType;
  private final boolean isSyncLoading;
  private final BitmapProcessor postProcessor;
  private final BitmapProcessor preProcessor;
  private final boolean resetViewBeforeLoading;
  
  private DisplayImageOptions(DisplayImageOptions.Builder paramBuilder)
  {
    this.imageResOnLoading = DisplayImageOptions.Builder.access$000(paramBuilder);
    this.imageResForEmptyUri = DisplayImageOptions.Builder.access$100(paramBuilder);
    this.imageResOnFail = DisplayImageOptions.Builder.access$200(paramBuilder);
    this.imageOnLoading = DisplayImageOptions.Builder.access$300(paramBuilder);
    this.imageForEmptyUri = DisplayImageOptions.Builder.access$400(paramBuilder);
    this.imageOnFail = DisplayImageOptions.Builder.access$500(paramBuilder);
    this.resetViewBeforeLoading = DisplayImageOptions.Builder.access$600(paramBuilder);
    this.cacheInMemory = DisplayImageOptions.Builder.access$700(paramBuilder);
    this.cacheOnDisk = DisplayImageOptions.Builder.access$800(paramBuilder);
    this.imageScaleType = DisplayImageOptions.Builder.access$900(paramBuilder);
    this.decodingOptions = DisplayImageOptions.Builder.access$1000(paramBuilder);
    this.delayBeforeLoading = DisplayImageOptions.Builder.access$1100(paramBuilder);
    this.considerExifParams = DisplayImageOptions.Builder.access$1200(paramBuilder);
    this.extraForDownloader = DisplayImageOptions.Builder.access$1300(paramBuilder);
    this.preProcessor = DisplayImageOptions.Builder.access$1400(paramBuilder);
    this.postProcessor = DisplayImageOptions.Builder.access$1500(paramBuilder);
    this.displayer = DisplayImageOptions.Builder.access$1600(paramBuilder);
    this.handler = DisplayImageOptions.Builder.access$1700(paramBuilder);
    this.isSyncLoading = DisplayImageOptions.Builder.access$1800(paramBuilder);
  }
  
  public static DisplayImageOptions createSimple()
  {
    return new DisplayImageOptions.Builder().build();
  }
  
  public BitmapFactory.Options getDecodingOptions()
  {
    return this.decodingOptions;
  }
  
  public int getDelayBeforeLoading()
  {
    return this.delayBeforeLoading;
  }
  
  public BitmapDisplayer getDisplayer()
  {
    return this.displayer;
  }
  
  public Object getExtraForDownloader()
  {
    return this.extraForDownloader;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public Drawable getImageForEmptyUri(Resources paramResources)
  {
    int i = this.imageResForEmptyUri;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageForEmptyUri;
  }
  
  public Drawable getImageOnFail(Resources paramResources)
  {
    int i = this.imageResOnFail;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageOnFail;
  }
  
  public Drawable getImageOnLoading(Resources paramResources)
  {
    int i = this.imageResOnLoading;
    if (i != 0) {
      return paramResources.getDrawable(i);
    }
    return this.imageOnLoading;
  }
  
  public ImageScaleType getImageScaleType()
  {
    return this.imageScaleType;
  }
  
  public BitmapProcessor getPostProcessor()
  {
    return this.postProcessor;
  }
  
  public BitmapProcessor getPreProcessor()
  {
    return this.preProcessor;
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
  
  public boolean isResetViewBeforeLoading()
  {
    return this.resetViewBeforeLoading;
  }
  
  boolean isSyncLoading()
  {
    return this.isSyncLoading;
  }
  
  public boolean shouldDelayBeforeLoading()
  {
    return this.delayBeforeLoading > 0;
  }
  
  public boolean shouldPostProcess()
  {
    return this.postProcessor != null;
  }
  
  public boolean shouldPreProcess()
  {
    return this.preProcessor != null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayImageOptions
 * JD-Core Version:    0.7.0.1
 */