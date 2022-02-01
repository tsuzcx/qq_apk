package com.microrapid.opencv;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.List;

public class ImageAutoProcessor
{
  public static ImageStatisticsData getImageStatistics(Bitmap paramBitmap, String paramString)
  {
    return new ImageStatisticsData(nativeGetImageStatistics(paramBitmap, paramString));
  }
  
  @NonNull
  public static List<ImageMainColorData> mainColorExtract(@NonNull Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = nativeMainColorExtract(paramBitmap, paramInt);
    LinkedList localLinkedList = new LinkedList();
    if (paramBitmap == null) {
      return localLinkedList;
    }
    int i = paramBitmap.length;
    paramInt = 0;
    if (paramInt < i)
    {
      Object localObject = paramBitmap[paramInt];
      if (localObject == null) {}
      for (;;)
      {
        paramInt += 1;
        break;
        localLinkedList.add(new ImageMainColorData(localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5]));
      }
    }
    return localLinkedList;
  }
  
  public static native void nativeContrastAuto(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native void nativeDenoiseBEEPS(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native double[] nativeGetImageStatistics(Bitmap paramBitmap, String paramString);
  
  public static native void nativeLightnessAuto(Bitmap paramBitmap1, Bitmap paramBitmap2);
  
  public static native float[][] nativeMainColorExtract(Bitmap paramBitmap, int paramInt);
  
  public static native double nativeTemperatureFromUIColor(String paramString, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.microrapid.opencv.ImageAutoProcessor
 * JD-Core Version:    0.7.0.1
 */