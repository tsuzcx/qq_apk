package com.tencent.biz.qqcircle.picload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import atwl;
import bkdi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import vou;
import voy;

public class QCircleFeedPicLoader$PicDeCodeTask
  extends QCircleFeedPicLoader.PicDownLoadTask
{
  public QCircleFeedPicLoader$PicDeCodeTask(QCircleFeedPicLoader paramQCircleFeedPicLoader, vou paramvou)
  {
    super(paramQCircleFeedPicLoader, paramvou);
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
  
  private Bitmap a(String paramString, BitmapFactory.Options paramOptions, vou paramvou)
  {
    localObject = null;
    Bitmap localBitmap = null;
    if (SharpPUtil.isSharpPFile(new File(paramString))) {
      if ((bkdi.a(BaseApplicationImpl.getContext())) && (bkdi.b()))
      {
        paramOptions = SharpPUtil.decodeSharpPByFilePath(paramString);
        if (paramOptions != null) {
          QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " decode sharp success  ifFromPreload:" + this.jdField_a_of_type_Vou.b());
        }
      }
    }
    for (paramvou.jdField_c_of_type_Int = 1;; paramvou.jdField_c_of_type_Int = 0)
    {
      if ((paramOptions == null) && (paramString.contains(QCircleFeedPicLoader.a())))
      {
        atwl.c(paramString);
        QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " decode bitmap failed delete ifFromPreload:" + this.jdField_a_of_type_Vou.b());
      }
      return paramOptions;
      QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " decode sharp failed  ifFromPreload:" + this.jdField_a_of_type_Vou.b());
      break;
      QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " decode sharp not support  ifFromPreload:" + this.jdField_a_of_type_Vou.b());
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
      QLog.d(QCircleFeedPicLoader.a, 4, "seq = " + this.jdField_a_of_type_Vou.a() + " , decode start cost in queue: " + (l - this.jdField_a_of_type_Vou.jdField_c_of_type_JavaLangLong.longValue()) + " ifFromPreload:" + this.jdField_a_of_type_Vou.b());
      if (this.jdField_a_of_type_Voy != null) {
        this.jdField_a_of_type_Voy.a(QCircleFeedPicLoader.e, this.jdField_a_of_type_Vou);
      }
      localObject = this.jdField_a_of_type_Vou.c();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      Bitmap localBitmap;
      if ((this.jdField_a_of_type_Vou.c() > 0) && (this.jdField_a_of_type_Vou.b() > 0))
      {
        localOptions.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile((String)localObject, localOptions);
        localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_Vou.c(), this.jdField_a_of_type_Vou.b());
        int i = localOptions.outWidth;
        int j = localOptions.outHeight;
        localOptions.inJustDecodeBounds = false;
        localBitmap = a((String)localObject, localOptions, this.jdField_a_of_type_Vou);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " , decode cost : " + (System.currentTimeMillis() - l) + " ,sampleSize:" + localOptions.inSampleSize + " origin:" + i + " " + j + "  request:" + this.jdField_a_of_type_Vou.c() + "  " + this.jdField_a_of_type_Vou.b() + " result:" + localBitmap.getWidth() + "  " + localBitmap.getHeight() + " ifFromPreload:" + this.jdField_a_of_type_Vou.b());
          localObject = localBitmap;
        }
      }
      while (this.jdField_a_of_type_Int != QCircleFeedPicLoader.d)
      {
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou.b(), (Bitmap)localObject);
        if (localObject != null) {
          break label569;
        }
        if (this.jdField_a_of_type_Voy != null)
        {
          this.jdField_a_of_type_Voy.a(QCircleFeedPicLoader.h, this.jdField_a_of_type_Vou);
          QCircleFeedPicLoader.c(this.this$0, this.jdField_a_of_type_Vou, 1);
          QCircleFeedPicLoader.b(this.this$0, this.jdField_a_of_type_Vou, 1);
        }
        QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou, this.jdField_a_of_type_Vou.b());
        return;
        localOptions.inSampleSize = 1;
        localOptions.inJustDecodeBounds = false;
        localBitmap = a((String)localObject, localOptions, this.jdField_a_of_type_Vou);
        localObject = localBitmap;
        if (localBitmap != null)
        {
          QLog.d(QCircleFeedPicLoader.a, 1, "seq = " + this.jdField_a_of_type_Vou.a() + " ,decode origin cost: " + (System.currentTimeMillis() - l) + " ifFromPreload:" + this.jdField_a_of_type_Vou.b());
          localObject = localBitmap;
        }
      }
    }
    label569:
    if (this.jdField_a_of_type_Voy != null) {
      this.jdField_a_of_type_Voy.a(QCircleFeedPicLoader.f, this.jdField_a_of_type_Vou);
    }
    QCircleFeedPicLoader.a(this.this$0, this.jdField_a_of_type_Vou, (Bitmap)localObject);
    QCircleFeedPicLoader.c(this.this$0, this.jdField_a_of_type_Vou, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader.PicDeCodeTask
 * JD-Core Version:    0.7.0.1
 */