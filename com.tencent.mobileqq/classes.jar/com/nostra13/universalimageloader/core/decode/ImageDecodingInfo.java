package com.nostra13.universalimageloader.core.decode;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class ImageDecodingInfo
{
  private final boolean considerExifParams;
  private final BitmapFactory.Options decodingOptions;
  private final ImageDownloader downloader;
  private final Object extraForDownloader;
  private final String imageKey;
  private final ImageScaleType imageScaleType;
  private final String imageUri;
  private final String originalImageUri;
  private final ImageSize targetSize;
  private final ViewScaleType viewScaleType;
  
  public ImageDecodingInfo(String paramString1, String paramString2, String paramString3, ImageSize paramImageSize, ViewScaleType paramViewScaleType, ImageDownloader paramImageDownloader, DisplayImageOptions paramDisplayImageOptions)
  {
    this.imageKey = paramString1;
    this.imageUri = paramString2;
    this.originalImageUri = paramString3;
    this.targetSize = paramImageSize;
    this.imageScaleType = paramDisplayImageOptions.getImageScaleType();
    this.viewScaleType = paramViewScaleType;
    this.downloader = paramImageDownloader;
    this.extraForDownloader = paramDisplayImageOptions.getExtraForDownloader();
    this.considerExifParams = paramDisplayImageOptions.isConsiderExifParams();
    this.decodingOptions = new BitmapFactory.Options();
    copyOptions(paramDisplayImageOptions.getDecodingOptions(), this.decodingOptions);
  }
  
  private void copyOptions(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inDensity = paramOptions1.inDensity;
    paramOptions2.inDither = paramOptions1.inDither;
    paramOptions2.inInputShareable = paramOptions1.inInputShareable;
    paramOptions2.inJustDecodeBounds = paramOptions1.inJustDecodeBounds;
    paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
    paramOptions2.inPurgeable = paramOptions1.inPurgeable;
    paramOptions2.inSampleSize = paramOptions1.inSampleSize;
    paramOptions2.inScaled = paramOptions1.inScaled;
    paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
    paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
    paramOptions2.inTempStorage = paramOptions1.inTempStorage;
    if (Build.VERSION.SDK_INT >= 10) {
      copyOptions10(paramOptions1, paramOptions2);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      copyOptions11(paramOptions1, paramOptions2);
    }
  }
  
  @TargetApi(10)
  private void copyOptions10(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
  }
  
  @TargetApi(11)
  private void copyOptions11(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inBitmap = paramOptions1.inBitmap;
    paramOptions2.inMutable = paramOptions1.inMutable;
  }
  
  public BitmapFactory.Options getDecodingOptions()
  {
    return this.decodingOptions;
  }
  
  public ImageDownloader getDownloader()
  {
    return this.downloader;
  }
  
  public Object getExtraForDownloader()
  {
    return this.extraForDownloader;
  }
  
  public String getImageKey()
  {
    return this.imageKey;
  }
  
  public ImageScaleType getImageScaleType()
  {
    return this.imageScaleType;
  }
  
  public String getImageUri()
  {
    return this.imageUri;
  }
  
  public String getOriginalImageUri()
  {
    return this.originalImageUri;
  }
  
  public ImageSize getTargetSize()
  {
    return this.targetSize;
  }
  
  public ViewScaleType getViewScaleType()
  {
    return this.viewScaleType;
  }
  
  public boolean shouldConsiderExifParams()
  {
    return this.considerExifParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.ImageDecodingInfo
 * JD-Core Version:    0.7.0.1
 */