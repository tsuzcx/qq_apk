package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import bday;
import com.enrique.stackblur.StackBlurManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

class QQIdentiferActivity$9
  implements Runnable
{
  QQIdentiferActivity$9(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void run()
  {
    try
    {
      if (QQIdentiferActivity.a(this.this$0) == null)
      {
        QLog.e("qq_Identification.act", 1, "blur bmp error, mLastPreviewData is null");
        return;
      }
      Camera localCamera = bday.a().a;
      if (localCamera == null)
      {
        QLog.e("qq_Identification.act", 1, "blur bmp error, camera is null");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("qq_Identification.act", 1, "blur last img error : " + localException.getMessage());
      return;
      Object localObject1 = localException.getParameters().getPreviewSize();
      Object localObject2 = new YuvImage(QQIdentiferActivity.a(this.this$0), 17, ((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height, null);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height), 100, localByteArrayOutputStream);
      localObject2 = new StackBlurManager(BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size())).process(15);
      int i = bday.a().b();
      localObject1 = new Matrix();
      ((Matrix)localObject1).setRotate(i);
      localObject2 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, false);
      ((Matrix)localObject1).reset();
      ((Matrix)localObject1).postScale(-1.0F, 1.0F);
      localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), (Matrix)localObject1, false);
      ThreadManagerV2.getUIHandlerV2().post(new QQIdentiferActivity.9.1(this, (Bitmap)localObject1));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("qq_Identification.act", 1, "blur last img out of memory");
      QQIdentiferActivity.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.9
 * JD-Core Version:    0.7.0.1
 */