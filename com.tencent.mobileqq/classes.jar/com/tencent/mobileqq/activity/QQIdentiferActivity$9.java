package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
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
      if (QQIdentiferActivity.access$1100(this.this$0) == null)
      {
        QLog.e("qq_Identification.act", 1, "blur bmp error, mLastPreviewData is null");
        return;
      }
      Object localObject1 = QQIdentiferActivity.access$1200(this.this$0).a();
      if (localObject1 == null)
      {
        QLog.e("qq_Identification.act", 1, "blur bmp error, camera is null");
        return;
      }
      localObject1 = ((Camera)localObject1).getParameters().getPreviewSize();
      localObject2 = new YuvImage(QQIdentiferActivity.access$1100(this.this$0), 17, ((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height, null);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ((YuvImage)localObject2).compressToJpeg(new Rect(0, 0, ((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height), 100, localByteArrayOutputStream);
      localObject1 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
      localObject1 = QQIdentiferActivity.access$1200(this.this$0).a((Bitmap)localObject1);
      if (localObject1 == null)
      {
        QLog.e("qq_Identification.act", 1, "blurBitmap return null");
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new QQIdentiferActivity.9.1(this, (Bitmap)localObject1));
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("blur last img error : ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("qq_Identification.act", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label169:
      break label169;
    }
    QLog.e("qq_Identification.act", 1, "blur last img out of memory");
    QQIdentiferActivity.access$1102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.9
 * JD-Core Version:    0.7.0.1
 */