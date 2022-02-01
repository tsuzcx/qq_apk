package com.tencent.av.business.manager.magicface;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.av.AVLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class MagicfaceNormalDecoder
  extends MagicfaceBaseDecoder
{
  public MagicfaceNormalDecoder()
  {
    AVLog.printColorLog("MagicfaceNormalDecoder", "==init==");
  }
  
  @TargetApi(16)
  private Bitmap a(String paramString, Bitmap paramBitmap)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    if (localOptions.outWidth * localOptions.outHeight == 0) {
      return null;
    }
    int i = localOptions.outWidth * localOptions.outHeight;
    if (Build.VERSION.SDK_INT >= 15) {
      localOptions.inBitmap = paramBitmap;
    } else if (paramBitmap != null) {
      paramBitmap.recycle();
    }
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = 1;
    while (i > 921600)
    {
      localOptions.inSampleSize *= 2;
      i /= 4;
    }
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      AVLog.printErrorLog("MagicfaceNormalDecoder", "getBitmap|decodeFile failed.");
    }
    return null;
  }
  
  public int a()
  {
    long l1 = 1000 / this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.fps;
    int i = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.repeat_count;
    String str2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.b();
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.hasbackground)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("background/background.png");
      localObject1 = a(((StringBuilder)localObject1).toString(), null);
    }
    else
    {
      localObject1 = null;
    }
    long l4 = 0L;
    int n = 0;
    Bitmap localBitmap = null;
    long l3 = 0L;
    long l2 = l3;
    int j = 0;
    int k = 0;
    for (;;)
    {
      String str1 = "MagicfaceNormalDecoder";
      if (j >= i) {
        break;
      }
      long l5 = l2;
      int m = 0;
      l2 = l3;
      l3 = l5;
      while ((m < this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a()) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a(k, j);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a(m));
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.src_prefix);
        ((StringBuilder)localObject2).append(m);
        ((StringBuilder)localObject2).append(".png");
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("maigcfaceDecoder:");
        localStringBuilder1.append(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a());
        localStringBuilder1.append("|");
        localStringBuilder1.append((String)localObject2);
        AVLog.printColorLog(str1, localStringBuilder1.toString());
        l5 = System.currentTimeMillis();
        localBitmap = a((String)localObject2, localBitmap);
        long l6 = System.currentTimeMillis();
        l3 = System.currentTimeMillis() - l3;
        if (l3 < l1) {
          try
          {
            Thread.sleep(l1 - l3);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        if ((m == this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.frame_index) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
          a(str2, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.is_repeat);
        } else if ((m == this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.c) && (this.jdField_a_of_type_JavaLangRefWeakReference != null)) {
          c(str2);
        }
        l3 = System.currentTimeMillis();
        if (localBitmap == null)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("maigcfaceDecoder bmp null:");
          localStringBuilder2.append((String)localObject2);
          AVLog.printColorLog(str1, localStringBuilder2.toString());
        }
        else if ((this.b != null) && (this.b.get() != null))
        {
          localObject2 = (MagicfaceBaseDecoder.MagicfaceRenderListener)this.b.get();
          long l7 = System.currentTimeMillis();
          boolean bool1;
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width == -1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          boolean bool2;
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height == -1) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          ((MagicfaceBaseDecoder.MagicfaceRenderListener)localObject2).a(localBitmap, (Bitmap)localObject1, bool1, bool2, false, false, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.b);
          l2 += System.currentTimeMillis() - l7;
        }
        m += 1;
        k += 1;
        l4 += l6 - l5;
      }
      j += 1;
      l5 = l3;
      l3 = l2;
      l2 = l5;
    }
    AVLog.printColorLog("MagicfaceNormalDecoder", String.format("maigcfaceDecoder| readCost=%s(ms), renderCost=%s(ms), r=(%s), frame(%s)", new Object[] { Long.valueOf(l4), Long.valueOf(l3), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a()) }));
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    j = n;
    if (k == i * this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.a()) {
      j = 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceNormalDecoder
 * JD-Core Version:    0.7.0.1
 */