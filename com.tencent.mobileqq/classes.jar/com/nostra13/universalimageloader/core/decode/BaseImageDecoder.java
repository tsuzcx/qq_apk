package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder
  implements ImageDecoder
{
  protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
  protected static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
  protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
  protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
  protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
  protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
  protected final boolean loggingEnabled;
  
  public BaseImageDecoder(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }
  
  private boolean canDefineExifParams(String paramString1, String paramString2)
  {
    return ("image/jpeg".equalsIgnoreCase(paramString2)) && (ImageDownloader.Scheme.ofUri(paramString1) == ImageDownloader.Scheme.FILE);
  }
  
  protected Bitmap considerExactScaleAndOrientatiton(Bitmap paramBitmap, ImageDecodingInfo paramImageDecodingInfo, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize1;
    ImageSize localImageSize2;
    ViewScaleType localViewScaleType;
    if ((localImageScaleType == ImageScaleType.EXACTLY) || (localImageScaleType == ImageScaleType.EXACTLY_STRETCHED))
    {
      localImageSize1 = new ImageSize(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      localImageSize2 = paramImageDecodingInfo.getTargetSize();
      localViewScaleType = paramImageDecodingInfo.getViewScaleType();
      if (localImageScaleType != ImageScaleType.EXACTLY_STRETCHED) {
        break label257;
      }
    }
    label257:
    for (boolean bool = true;; bool = false)
    {
      float f = ImageSizeUtils.computeImageScale(localImageSize1, localImageSize2, localViewScaleType, bool);
      if (Float.compare(f, 1.0F) != 0)
      {
        localMatrix.setScale(f, f);
        if (this.loggingEnabled) {
          L.d("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] { localImageSize1, localImageSize1.scale(f), Float.valueOf(f), paramImageDecodingInfo.getImageKey() });
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.loggingEnabled) {
          L.d("Flip image horizontally [%s]", new Object[] { paramImageDecodingInfo.getImageKey() });
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.loggingEnabled) {
          L.d("Rotate image on %1$d° [%2$s]", new Object[] { Integer.valueOf(paramInt), paramImageDecodingInfo.getImageKey() });
        }
      }
      paramImageDecodingInfo = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (paramImageDecodingInfo != paramBitmap) {
        paramBitmap.recycle();
      }
      return paramImageDecodingInfo;
    }
  }
  
  public Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
  {
    InputStream localInputStream2 = getImageStream(paramImageDecodingInfo);
    if (localInputStream2 == null)
    {
      L.e("No stream for image [%s]", new Object[] { paramImageDecodingInfo.getImageKey() });
      return null;
    }
    InputStream localInputStream1 = localInputStream2;
    BaseImageDecoder.ImageFileInfo localImageFileInfo;
    Bitmap localBitmap;
    try
    {
      localImageFileInfo = defineImageSizeAndRotation(localInputStream2, paramImageDecodingInfo);
      localInputStream1 = localInputStream2;
      localInputStream2 = resetStream(localInputStream2, paramImageDecodingInfo);
      localInputStream1 = localInputStream2;
      localBitmap = BitmapFactory.decodeStream(localInputStream2, null, prepareDecodingOptions(localImageFileInfo.imageSize, paramImageDecodingInfo));
      IoUtils.closeSilently(localInputStream2);
      if (localBitmap == null)
      {
        L.e("Image can't be decoded [%s]", new Object[] { paramImageDecodingInfo.getImageKey() });
        return localBitmap;
      }
    }
    finally
    {
      IoUtils.closeSilently(localInputStream1);
    }
    return considerExactScaleAndOrientatiton(localBitmap, paramImageDecodingInfo, localImageFileInfo.exif.rotation, localImageFileInfo.exif.flipHorizontal);
  }
  
  protected BaseImageDecoder.ExifInfo defineExifOrientation(String paramString)
  {
    int j = 0;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    try
    {
      int k = new ExifInterface(ImageDownloader.Scheme.FILE.crop(paramString)).getAttributeInt("Orientation", 1);
      i = j;
      switch (k)
      {
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        L.w("Can't read EXIF tags from file [%s]", new Object[] { paramString });
      }
    }
    bool1 = false;
    i = j;
    for (;;)
    {
      return new BaseImageDecoder.ExifInfo(i, bool1);
      bool2 = false;
      i = 90;
      bool1 = bool2;
      continue;
      bool3 = false;
      i = 180;
      bool1 = bool3;
      continue;
      bool4 = false;
      i = 270;
      bool1 = bool4;
    }
  }
  
  protected BaseImageDecoder.ImageFileInfo defineImageSizeAndRotation(InputStream paramInputStream, ImageDecodingInfo paramImageDecodingInfo)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    paramInputStream = paramImageDecodingInfo.getImageUri();
    if ((paramImageDecodingInfo.shouldConsiderExifParams()) && (canDefineExifParams(paramInputStream, localOptions.outMimeType))) {}
    for (paramInputStream = defineExifOrientation(paramInputStream);; paramInputStream = new BaseImageDecoder.ExifInfo()) {
      return new BaseImageDecoder.ImageFileInfo(new ImageSize(localOptions.outWidth, localOptions.outHeight, paramInputStream.rotation), paramInputStream);
    }
  }
  
  protected InputStream getImageStream(ImageDecodingInfo paramImageDecodingInfo)
  {
    return paramImageDecodingInfo.getDownloader().getStream(paramImageDecodingInfo.getImageUri(), paramImageDecodingInfo.getExtraForDownloader());
  }
  
  protected BitmapFactory.Options prepareDecodingOptions(ImageSize paramImageSize, ImageDecodingInfo paramImageDecodingInfo)
  {
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    if (localImageScaleType == ImageScaleType.NONE) {}
    for (int i = 1;; i = ImageSizeUtils.computeMinImageSampleSize(paramImageSize))
    {
      if ((i > 1) && (this.loggingEnabled)) {
        L.d("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] { paramImageSize, paramImageSize.scaleDown(i), Integer.valueOf(i), paramImageDecodingInfo.getImageKey() });
      }
      paramImageSize = paramImageDecodingInfo.getDecodingOptions();
      paramImageSize.inSampleSize = i;
      return paramImageSize;
      if (localImageScaleType != ImageScaleType.NONE_SAFE) {
        break;
      }
    }
    ImageSize localImageSize = paramImageDecodingInfo.getTargetSize();
    if (localImageScaleType == ImageScaleType.IN_SAMPLE_POWER_OF_2) {}
    for (boolean bool = true;; bool = false)
    {
      i = ImageSizeUtils.computeImageSampleSize(paramImageSize, localImageSize, paramImageDecodingInfo.getViewScaleType(), bool);
      break;
    }
  }
  
  protected InputStream resetStream(InputStream paramInputStream, ImageDecodingInfo paramImageDecodingInfo)
  {
    if (paramInputStream.markSupported()) {
      try
      {
        paramInputStream.reset();
        return paramInputStream;
      }
      catch (IOException localIOException) {}
    }
    IoUtils.closeSilently(paramInputStream);
    return getImageStream(paramImageDecodingInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.BaseImageDecoder
 * JD-Core Version:    0.7.0.1
 */