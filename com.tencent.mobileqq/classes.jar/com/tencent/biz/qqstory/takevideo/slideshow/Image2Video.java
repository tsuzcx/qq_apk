package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import bdhb;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;
import xmi;
import xmk;
import xml;
import xmp;

public class Image2Video
  implements xmi
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "cache/";
  private Context jdField_a_of_type_AndroidContentContext;
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private HashMap<Long, xmk> jdField_a_of_type_JavaUtilHashMap;
  private LinkedList<xmk> jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 1) || (paramBitmap == null)) {
      paramBitmap = null;
    }
    int i12;
    int i13;
    Bitmap localBitmap;
    do
    {
      return paramBitmap;
      i12 = paramBitmap.getWidth();
      i13 = paramBitmap.getHeight();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(i12 * paramFloat), Math.round(i13 * paramFloat), false);
      localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i14 = localBitmap.getWidth();
      int i15 = localBitmap.getHeight();
      paramBitmap = new int[i14 * i15];
      localBitmap.getPixels(paramBitmap, 0, i14, 0, 0, i14, i15);
      int i11 = i14 - 1;
      int i16 = i15 - 1;
      int i = i14 * i15;
      int i17 = paramInt + paramInt + 1;
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      int[] arrayOfInt3 = new int[i];
      int[] arrayOfInt4 = new int[Math.max(i14, i15)];
      i = i17 + 1 >> 1;
      int j = i * i;
      int[] arrayOfInt5 = new int[j * 256];
      i = 0;
      while (i < j * 256)
      {
        arrayOfInt5[i] = (i / j);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
      int i18 = paramInt + 1;
      int i7 = 0;
      i = 0;
      int i6 = 0;
      int i8;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int k;
      int i9;
      int[] arrayOfInt6;
      int i10;
      int i19;
      while (i6 < i15)
      {
        j = 0;
        i8 = -paramInt;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        k = 0;
        if (i8 <= paramInt)
        {
          i9 = paramBitmap[(Math.min(i11, Math.max(i8, 0)) + i)];
          arrayOfInt6 = arrayOfInt[(i8 + paramInt)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = i18 - Math.abs(i8);
          i5 += arrayOfInt6[0] * i9;
          i4 += arrayOfInt6[1] * i9;
          i3 += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            m += arrayOfInt6[0];
            k += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i8 = i4;
        i10 = 0;
        i4 = paramInt;
        i9 = i5;
        i5 = i3;
        i3 = i10;
        while (i3 < i14)
        {
          arrayOfInt1[i] = arrayOfInt5[i9];
          arrayOfInt2[i] = arrayOfInt5[i8];
          arrayOfInt3[i] = arrayOfInt5[i5];
          arrayOfInt6 = arrayOfInt[((i4 - paramInt + i17) % i17)];
          int i20 = arrayOfInt6[0];
          i19 = arrayOfInt6[1];
          i10 = arrayOfInt6[2];
          if (i6 == 0) {
            arrayOfInt4[i3] = Math.min(i3 + paramInt + 1, i11);
          }
          int i21 = paramBitmap[(arrayOfInt4[i3] + i7)];
          arrayOfInt6[0] = ((0xFF0000 & i21) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i21) >> 8);
          arrayOfInt6[2] = (i21 & 0xFF);
          m += arrayOfInt6[0];
          k += arrayOfInt6[1];
          j += arrayOfInt6[2];
          i9 = i9 - i2 + m;
          i8 = i8 - i1 + k;
          i5 = i5 - n + j;
          i4 = (i4 + 1) % i17;
          arrayOfInt6 = arrayOfInt[(i4 % i17)];
          i2 = i2 - i20 + arrayOfInt6[0];
          i1 = i1 - i19 + arrayOfInt6[1];
          n = n - i10 + arrayOfInt6[2];
          m -= arrayOfInt6[0];
          k -= arrayOfInt6[1];
          j -= arrayOfInt6[2];
          i += 1;
          i3 += 1;
        }
        i7 += i14;
        i6 += 1;
      }
      i = 0;
      while (i < i14)
      {
        i5 = 0;
        i7 = -paramInt * i14;
        i6 = -paramInt;
        i3 = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        j = 0;
        m = 0;
        k = 0;
        i4 = 0;
        if (i6 <= paramInt)
        {
          i8 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + paramInt)];
          arrayOfInt6[0] = arrayOfInt1[i8];
          arrayOfInt6[1] = arrayOfInt2[i8];
          arrayOfInt6[2] = arrayOfInt3[i8];
          i9 = i18 - Math.abs(i6);
          i10 = arrayOfInt1[i8];
          i11 = arrayOfInt2[i8];
          i19 = arrayOfInt3[i8];
          if (i6 > 0)
          {
            i3 += arrayOfInt6[0];
            i4 += arrayOfInt6[1];
            i5 += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 = i7;
            if (i6 < i16) {
              i8 = i7 + i14;
            }
            i6 += 1;
            j = i19 * i9 + j;
            m = i11 * i9 + m;
            k = i10 * i9 + k;
            i7 = i8;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i9 = m;
        i10 = k;
        i11 = 0;
        k = i;
        i6 = i5;
        i7 = i4;
        i8 = i3;
        m = n;
        n = i1;
        i1 = i2;
        i2 = paramInt;
        i5 = i10;
        i4 = i9;
        i3 = j;
        j = i11;
        while (j < i15)
        {
          paramBitmap[k] = (0xFF000000 & paramBitmap[k] | arrayOfInt5[i5] << 16 | arrayOfInt5[i4] << 8 | arrayOfInt5[i3]);
          arrayOfInt6 = arrayOfInt[((i2 - paramInt + i17) % i17)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[j] = (Math.min(j + i18, i16) * i14);
          }
          i19 = arrayOfInt4[j] + i;
          arrayOfInt6[0] = arrayOfInt1[i19];
          arrayOfInt6[1] = arrayOfInt2[i19];
          arrayOfInt6[2] = arrayOfInt3[i19];
          i8 += arrayOfInt6[0];
          i7 += arrayOfInt6[1];
          i6 += arrayOfInt6[2];
          i5 = i5 - i1 + i8;
          i4 = i4 - n + i7;
          i3 = i3 - m + i6;
          i2 = (i2 + 1) % i17;
          arrayOfInt6 = arrayOfInt[i2];
          i1 = i1 - i11 + arrayOfInt6[0];
          n = n - i10 + arrayOfInt6[1];
          m = m - i9 + arrayOfInt6[2];
          i8 -= arrayOfInt6[0];
          i7 -= arrayOfInt6[1];
          i6 -= arrayOfInt6[2];
          k += i14;
          j += 1;
        }
        i += 1;
      }
      localBitmap.setPixels(paramBitmap, 0, i14, 0, 0, i14, i15);
      paramBitmap = localBitmap;
    } while (!paramBoolean);
    return Bitmap.createScaledBitmap(localBitmap, i12, i13, true);
  }
  
  public static String a()
  {
    String str = jdField_a_of_type_JavaLangString + "/noaudio";
    bdhb.c(str);
    return str;
  }
  
  private void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Image2Video", 2, "tryStartPendingTask,[not start new request] mRunningTasks.size=:" + this.jdField_a_of_type_JavaUtilHashMap.size());
        }
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
        break label199;
      }
      xmk localxmk = (xmk)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
      if (localxmk == null) {
        return;
      }
    }
    finally {}
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localObject.jdField_a_of_type_Long), localObject);
    ConvertRunnable localConvertRunnable = new ConvertRunnable(this.jdField_a_of_type_AndroidContentContext, localObject.jdField_a_of_type_Long, localObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo, localObject.jdField_b_of_type_Int, localObject.c, localObject.jdField_b_of_type_Long, this.jdField_a_of_type_Boolean, this);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
    {
      localObject.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowConvertRunnable = localConvertRunnable;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.a().post(localConvertRunnable);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Image2Video", 2, "tryStartPendingTask, taskid:" + localObject.jdField_a_of_type_Long);
    }
    for (;;)
    {
      return;
      label199:
      if (QLog.isColorLevel()) {
        QLog.d("Image2Video", 2, "tryStartPendingTask, no pending task:");
      }
    }
  }
  
  public void a(xmp paramxmp)
  {
    if (paramxmp == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Image2Video", 2, "onConvertResult, resultinfo is null!!!");
      }
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Image2Video", 2, "onConvertResult, taskId:" + paramxmp.jdField_a_of_type_Long + ", resultcode:" + paramxmp.jdField_a_of_type_Int + ", image:" + paramxmp.jdField_a_of_type_JavaLangString + ". destfile:" + paramxmp.b);
          }
          try
          {
            localObject = (xmk)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramxmp.jdField_a_of_type_Long));
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Image2Video", 2, "onConvertResult, task not exist.");
            }
          }
          finally {}
        }
        if (paramxmp.jdField_a_of_type_Int != 7) {
          break;
        }
        localObject = (xml)((xmk)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      ((xml)localObject).a(paramxmp);
      return;
      if (paramxmp.jdField_a_of_type_Int == 0) {
        a();
      }
      localObject = (xml)((xmk)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ((xml)localObject).a(paramxmp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video
 * JD-Core Version:    0.7.0.1
 */