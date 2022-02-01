package com.tencent.biz.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import auog;
import blem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import vrd;
import vrh;

public class QCircleFeedPicLoader$PicDeCodeTask
  extends QCircleFeedPicLoader.PicDownLoadTask
{
  public QCircleFeedPicLoader$PicDeCodeTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, vrd paramvrd)
  {
    super(paramQCircleFeedPicLoader, paramvrd);
    this.jdField_a_of_type_Int = QCircleFeedPicLoader.e;
  }
  
  private int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int k = 1;
    int j = k;
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0) {
        break label25;
      }
      j = k;
    }
    label25:
    int n;
    do
    {
      return j;
      n = paramOptions.outHeight;
      m = paramOptions.outWidth;
      if (n > paramInt2) {
        break;
      }
      j = k;
    } while (m <= paramInt1);
    k = (int)(n / 1.4F);
    int m = (int)(m / 1.4F);
    for (;;)
    {
      if (k / i <= paramInt2)
      {
        j = i;
        if (m / i <= paramInt1) {
          break;
        }
      }
      i *= 2;
    }
  }
  
  private Bitmap a(String paramString, BitmapFactory.Options paramOptions, vrd paramvrd)
  {
    localObject = null;
    Bitmap localBitmap = null;
    if (SharpPUtil.isSharpPFile(new File(paramString))) {
      if ((blem.a(BaseApplicationImpl.getContext())) && (blem.b()))
      {
        paramOptions = SharpPUtil.decodeSharpPByFilePath(paramString);
        if (paramOptions != null) {
          QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " decode sharp success  ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
        }
      }
    }
    for (paramvrd.jdField_c_of_type_Int = 1;; paramvrd.jdField_c_of_type_Int = 0)
    {
      if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.a())))
      {
        auog.c(paramString);
        QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " decode bitmap failed delete ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      }
      return paramOptions;
      QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " decode sharp failed  ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      break;
      QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " decode sharp not support  ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      paramOptions = localBitmap;
      break;
      try
      {
        localBitmap = SafeBitmapFactory.decodeFile(paramString, paramOptions);
        paramOptions = localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          System.gc();
          localOutOfMemoryError.printStackTrace();
          try
          {
            paramOptions.inSampleSize *= 2;
            paramOptions = SafeBitmapFactory.decodeFile(paramString, paramOptions);
          }
          catch (OutOfMemoryError paramOptions)
          {
            System.gc();
            localOutOfMemoryError.printStackTrace();
            paramOptions = localObject;
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == QCircleFeedPicLoader.d) {}
    Object localObject;
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      QLog.i(QCircleFeedPicLoader.a, 4, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " , decode start cost in queue: " + (l - this.jdField_a_of_type_Vrd.jdField_c_of_type_JavaLangLong.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
      if (this.jdField_a_of_type_Vrh != null) {
        this.jdField_a_of_type_Vrh.a(QCircleFeedPicLoader.e, this.jdField_a_of_type_Vrd);
      }
      localObject = this.jdField_a_of_type_Vrd.c();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      Bitmap localBitmap;
      if ((this.jdField_a_of_type_Vrd.c() > 0) && (this.jdField_a_of_type_Vrd.b() > 0))
      {
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile((String)localObject, localOptions);
        localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_Vrd.c(), this.jdField_a_of_type_Vrd.b());
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        localOptions.inJustDecodeBounds = false;
        localBitmap = a((String)localObject, localOptions, this.jdField_a_of_type_Vrd);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " , decode cost : " + (System.currentTimeMillis() - l) + " ,sampleSize:" + localOptions.inSampleSize + " origin:" + i + " " + j + "  request:" + this.jdField_a_of_type_Vrd.c() + "  " + this.jdField_a_of_type_Vrd.b() + " result:" + localBitmap.getWidth() + "  " + localBitmap.getHeight() + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
          localObject = localBitmap;
        }
      }
      while (this.jdField_a_of_type_Int != QCircleFeedPicLoader.d)
      {
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd.b(), (Bitmap)localObject);
        if (localObject != null) {
          break label614;
        }
        if (this.jdField_a_of_type_Vrh != null)
        {
          this.jdField_a_of_type_Vrh.a(QCircleFeedPicLoader.h, this.jdField_a_of_type_Vrd);
          QCircleFeedPicLoader.c(this.this$0, this.jdField_a_of_type_Vrd, 1);
          QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vrd, 1);
        }
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd, this.jdField_a_of_type_Vrd.b());
        return;
        localOptions.inSampleSize = 1;
        localOptions.inJustDecodeBounds = false;
        localBitmap = a((String)localObject, localOptions, this.jdField_a_of_type_Vrd);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          QLog.i(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " cacheKey = " + this.jdField_a_of_type_Vrd.b() + " ,decode origin cost: " + (System.currentTimeMillis() - l) + " ifFromPreload:" + this.jdField_a_of_type_Vrd.b());
          localObject = localBitmap;
        }
      }
    }
    label614:
    if (this.jdField_a_of_type_Vrh != null) {
      this.jdField_a_of_type_Vrh.a(QCircleFeedPicLoader.f, this.jdField_a_of_type_Vrd);
    }
    QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vrd, (Bitmap)localObject);
    QCircleFeedPicLoader.c(this.this$0, this.jdField_a_of_type_Vrd, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDeCodeTask
 * JD-Core Version:    0.7.0.1
 */