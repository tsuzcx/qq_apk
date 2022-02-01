package com.tencent.biz.qqstory.takevideo.slideshow;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;

public class Image2Video
  implements ConvertRunnable.ConvertRunnableListener
{
  public static final String a;
  public static final String b;
  private Image2Video.EglHandlerThreadEx c;
  private boolean d;
  private HashMap<Long, Image2Video.ConvertContext> e;
  private LinkedList<Image2Video.ConvertContext> f;
  private Context g;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/qq/video/imagevideo/");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("cache/");
    b = localStringBuilder.toString();
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt, boolean paramBoolean)
  {
    int i7 = paramInt;
    if ((i7 >= 1) && (paramBitmap != null))
    {
      int i15 = paramBitmap.getWidth();
      int i6 = paramBitmap.getHeight();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(i15 * paramFloat), Math.round(i6 * paramFloat), false);
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i16 = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int i = i16 * j;
      int[] arrayOfInt3 = new int[i];
      paramBitmap.getPixels(arrayOfInt3, 0, i16, 0, 0, i16, j);
      int i20 = i16 - 1;
      int i17 = j - 1;
      int i18 = i7 + i7 + 1;
      int[] arrayOfInt4 = new int[i];
      int[] arrayOfInt5 = new int[i];
      int[] arrayOfInt6 = new int[i];
      int[] arrayOfInt1 = new int[Math.max(i16, j)];
      i = i18 + 1 >> 1;
      int k = i * i;
      int m = k * 256;
      int[] arrayOfInt2 = new int[m];
      i = 0;
      while (i < m)
      {
        arrayOfInt2[i] = (i / k);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i18, 3 });
      int i19 = i7 + 1;
      int i9 = 0;
      int i10 = 0;
      int i8 = 0;
      i = j;
      int i11;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int i12;
      int[] arrayOfInt7;
      int i13;
      int i14;
      while (i9 < i)
      {
        i11 = -i7;
        n = 0;
        i1 = 0;
        i2 = 0;
        m = 0;
        k = 0;
        j = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        while (i11 <= i7)
        {
          i12 = arrayOfInt3[(i10 + Math.min(i20, Math.max(i11, 0)))];
          arrayOfInt7 = arrayOfInt[(i11 + i7)];
          arrayOfInt7[0] = ((i12 & 0xFF0000) >> 16);
          arrayOfInt7[1] = ((i12 & 0xFF00) >> 8);
          arrayOfInt7[2] = (i12 & 0xFF);
          i12 = i19 - Math.abs(i11);
          n += arrayOfInt7[0] * i12;
          i1 += arrayOfInt7[1] * i12;
          i2 += arrayOfInt7[2] * i12;
          if (i11 > 0)
          {
            i3 += arrayOfInt7[0];
            i4 += arrayOfInt7[1];
            i5 += arrayOfInt7[2];
          }
          else
          {
            m += arrayOfInt7[0];
            k += arrayOfInt7[1];
            j += arrayOfInt7[2];
          }
          i11 += 1;
        }
        i13 = i7;
        i14 = 0;
        i11 = i4;
        i12 = i3;
        i4 = n;
        i3 = i13;
        n = i14;
        while (n < i16)
        {
          arrayOfInt4[i10] = arrayOfInt2[i4];
          arrayOfInt5[i10] = arrayOfInt2[i1];
          arrayOfInt6[i10] = arrayOfInt2[i2];
          arrayOfInt7 = arrayOfInt[((i3 - i7 + i18) % i18)];
          int i21 = arrayOfInt7[0];
          i14 = arrayOfInt7[1];
          i13 = arrayOfInt7[2];
          if (i9 == 0) {
            arrayOfInt1[n] = Math.min(n + i7 + 1, i20);
          }
          int i22 = arrayOfInt3[(i8 + arrayOfInt1[n])];
          arrayOfInt7[0] = ((i22 & 0xFF0000) >> 16);
          arrayOfInt7[1] = ((i22 & 0xFF00) >> 8);
          arrayOfInt7[2] = (i22 & 0xFF);
          i12 += arrayOfInt7[0];
          i11 += arrayOfInt7[1];
          i5 += arrayOfInt7[2];
          i4 = i4 - m + i12;
          i1 = i1 - k + i11;
          i2 = i2 - j + i5;
          i3 = (i3 + 1) % i18;
          arrayOfInt7 = arrayOfInt[(i3 % i18)];
          m = m - i21 + arrayOfInt7[0];
          k = k - i14 + arrayOfInt7[1];
          j = j - i13 + arrayOfInt7[2];
          i12 -= arrayOfInt7[0];
          i11 -= arrayOfInt7[1];
          i5 -= arrayOfInt7[2];
          i10 += 1;
          n += 1;
        }
        i8 += i16;
        i9 += 1;
      }
      j = 0;
      i7 = i;
      i = j;
      for (;;)
      {
        i8 = paramInt;
        if (i >= i16) {
          break;
        }
        i9 = -i8;
        i10 = i9 * i16;
        i4 = 0;
        i5 = 0;
        n = 0;
        m = 0;
        k = 0;
        j = 0;
        i3 = 0;
        i1 = 0;
        i2 = 0;
        while (i9 <= i8)
        {
          i11 = Math.max(0, i10) + i;
          arrayOfInt7 = arrayOfInt[(i9 + i8)];
          arrayOfInt7[0] = arrayOfInt4[i11];
          arrayOfInt7[1] = arrayOfInt5[i11];
          arrayOfInt7[2] = arrayOfInt6[i11];
          i12 = i19 - Math.abs(i9);
          i4 += arrayOfInt4[i11] * i12;
          i5 += arrayOfInt5[i11] * i12;
          i11 = n + arrayOfInt6[i11] * i12;
          if (i9 > 0)
          {
            i3 += arrayOfInt7[0];
            i1 += arrayOfInt7[1];
            i2 += arrayOfInt7[2];
          }
          else
          {
            m += arrayOfInt7[0];
            k += arrayOfInt7[1];
            j += arrayOfInt7[2];
          }
          n = i10;
          if (i9 < i17) {
            n = i10 + i16;
          }
          i9 += 1;
          i10 = n;
          n = i11;
        }
        i10 = i3;
        i12 = 0;
        i11 = i8;
        i3 = i4;
        i4 = i;
        i8 = i2;
        i9 = i1;
        i1 = i11;
        i2 = i5;
        i5 = i3;
        i3 = i12;
        while (i3 < i7)
        {
          arrayOfInt3[i4] = (arrayOfInt3[i4] & 0xFF000000 | arrayOfInt2[i5] << 16 | arrayOfInt2[i2] << 8 | arrayOfInt2[n]);
          arrayOfInt7 = arrayOfInt[((i1 - paramInt + i18) % i18)];
          i13 = arrayOfInt7[0];
          i12 = arrayOfInt7[1];
          i11 = arrayOfInt7[2];
          if (i == 0) {
            arrayOfInt1[i3] = (Math.min(i3 + i19, i17) * i16);
          }
          i14 = arrayOfInt1[i3] + i;
          arrayOfInt7[0] = arrayOfInt4[i14];
          arrayOfInt7[1] = arrayOfInt5[i14];
          arrayOfInt7[2] = arrayOfInt6[i14];
          i10 += arrayOfInt7[0];
          i9 += arrayOfInt7[1];
          i8 += arrayOfInt7[2];
          i5 = i5 - m + i10;
          i2 = i2 - k + i9;
          n = n - j + i8;
          i1 = (i1 + 1) % i18;
          arrayOfInt7 = arrayOfInt[i1];
          m = m - i13 + arrayOfInt7[0];
          k = k - i12 + arrayOfInt7[1];
          j = j - i11 + arrayOfInt7[2];
          i10 -= arrayOfInt7[0];
          i9 -= arrayOfInt7[1];
          i8 -= arrayOfInt7[2];
          i4 += i16;
          i3 += 1;
        }
        i += 1;
      }
      paramBitmap.setPixels(arrayOfInt3, 0, i16, 0, 0, i16, i7);
      if (paramBoolean) {
        return Bitmap.createScaledBitmap(paramBitmap, i15, i6, true);
      }
      return paramBitmap;
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("/noaudio");
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.createFileIfNotExits((String)localObject);
    return localObject;
  }
  
  private void b()
  {
    try
    {
      Object localObject1;
      if (this.e.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("tryStartPendingTask,[not start new request] mRunningTasks.size=:");
          ((StringBuilder)localObject1).append(this.e.size());
          QLog.d("Image2Video", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if (this.f.size() > 0)
      {
        localObject1 = (Image2Video.ConvertContext)this.f.removeFirst();
        if (localObject1 == null) {
          return;
        }
        this.e.put(Long.valueOf(((Image2Video.ConvertContext)localObject1).d), localObject1);
        Object localObject3 = new ConvertRunnable(this.g, ((Image2Video.ConvertContext)localObject1).d, ((Image2Video.ConvertContext)localObject1).h, ((Image2Video.ConvertContext)localObject1).e, ((Image2Video.ConvertContext)localObject1).f, ((Image2Video.ConvertContext)localObject1).g, this.d, this);
        if (this.c != null)
        {
          ((Image2Video.ConvertContext)localObject1).b = ((ConvertRunnable)localObject3);
          this.c.b().post((Runnable)localObject3);
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("tryStartPendingTask, taskid:");
          ((StringBuilder)localObject3).append(((Image2Video.ConvertContext)localObject1).d);
          QLog.d("Image2Video", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Image2Video", 2, "tryStartPendingTask, no pending task:");
      }
      return;
    }
    finally {}
  }
  
  public void a(ResultInfo paramResultInfo)
  {
    if (paramResultInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Image2Video", 2, "onConvertResult, resultinfo is null!!!");
      }
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConvertResult, taskId:");
      ((StringBuilder)localObject).append(paramResultInfo.a);
      ((StringBuilder)localObject).append(", resultcode:");
      ((StringBuilder)localObject).append(paramResultInfo.b);
      ((StringBuilder)localObject).append(", image:");
      ((StringBuilder)localObject).append(paramResultInfo.c);
      ((StringBuilder)localObject).append(". destfile:");
      ((StringBuilder)localObject).append(paramResultInfo.d);
      QLog.d("Image2Video", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = (Image2Video.ConvertContext)this.e.remove(Long.valueOf(paramResultInfo.a));
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Image2Video", 2, "onConvertResult, task not exist.");
        }
        return;
      }
      if (paramResultInfo.b == 7)
      {
        localObject = (Image2Video.Image2VideoListener)((Image2Video.ConvertContext)localObject).c.get();
        if (localObject != null) {
          ((Image2Video.Image2VideoListener)localObject).a(paramResultInfo);
        }
      }
      else
      {
        if (paramResultInfo.b == 0) {
          b();
        }
        localObject = (Image2Video.Image2VideoListener)((Image2Video.ConvertContext)localObject).c.get();
        if (localObject != null) {
          ((Image2Video.Image2VideoListener)localObject).a(paramResultInfo);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Image2Video
 * JD-Core Version:    0.7.0.1
 */