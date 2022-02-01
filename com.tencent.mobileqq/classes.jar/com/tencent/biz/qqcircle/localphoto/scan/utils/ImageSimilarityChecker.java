package com.tencent.biz.qqcircle.localphoto.scan.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ImageSimilarityChecker
{
  private static final String a = "ImageSimilarityChecker";
  private static int b = -1;
  private static int c = 8;
  private Canvas d = new Canvas();
  private Paint e = new Paint();
  
  public ImageSimilarityChecker()
  {
    Object localObject = new ColorMatrix();
    ((ColorMatrix)localObject).setSaturation(0.0F);
    localObject = new ColorMatrixColorFilter((ColorMatrix)localObject);
    this.e.setColorFilter((ColorFilter)localObject);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (paramString1.length() != paramString2.length()) {
          return false;
        }
        int i = 0;
        int k;
        for (int j = 0; i < paramString1.length(); j = k)
        {
          k = j;
          if (paramString1.charAt(i) != paramString2.charAt(i)) {
            k = j + 1;
          }
          i += 1;
        }
        bool1 = bool2;
        if (j < c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String a(Bitmap paramBitmap)
  {
    int i;
    int j;
    boolean bool;
    for (;;)
    {
      try
      {
        paramBitmap = b(Bitmap.createScaledBitmap(paramBitmap, 9, 8, true));
        localArrayList = new ArrayList();
        i = 0;
      }
      catch (Throwable paramBitmap)
      {
        ArrayList localArrayList;
        int k;
        label63:
        QLog.e(a, 1, "getDHash failed t:", paramBitmap);
        return "";
      }
      if (j >= 8) {
        break label229;
      }
      k = paramBitmap.getPixel(j, i);
      j += 1;
      if (k <= paramBitmap.getPixel(j, i)) {
        break label223;
      }
      bool = true;
      localArrayList.add(Boolean.valueOf(bool));
    }
    label223:
    label229:
    label234:
    for (;;)
    {
      int m = localArrayList.size();
      paramBitmap = "";
      k = 0;
      i = 0;
      while (k < m)
      {
        j = i;
        if (((Boolean)localArrayList.get(k)).booleanValue()) {
          j = i + (k % 8 ^ 0x2);
        }
        Object localObject = paramBitmap;
        i = j;
        if (k % 8 == 7)
        {
          localObject = String.format("%s%s", new Object[] { paramBitmap, String.format("%02x", new Object[] { Integer.valueOf(j) }) });
          i = 0;
        }
        k += 1;
        paramBitmap = (Bitmap)localObject;
      }
      return paramBitmap;
      for (;;)
      {
        if (i >= 8) {
          break label234;
        }
        j = 0;
        break;
        bool = false;
        break label63;
        i += 1;
      }
    }
  }
  
  public Bitmap b(Bitmap paramBitmap)
  {
    Bitmap localBitmap = Bitmap.createBitmap(9, 8, Bitmap.Config.RGB_565);
    this.d.setBitmap(localBitmap);
    this.d.drawBitmap(paramBitmap, 0.0F, 0.0F, this.e);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.utils.ImageSimilarityChecker
 * JD-Core Version:    0.7.0.1
 */