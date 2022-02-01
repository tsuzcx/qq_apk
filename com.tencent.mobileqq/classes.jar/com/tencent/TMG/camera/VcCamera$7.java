package com.tencent.TMG.camera;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.Display;
import com.tencent.TMG.sdk.AVUILoopProxy;
import com.tencent.TMG.utils.QLog;
import java.util.Iterator;
import java.util.List;

class VcCamera$7
  implements Camera.PreviewCallback
{
  VcCamera$7(VcCamera paramVcCamera) {}
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (VcCamera.nInFPS > 0)
    {
      int i;
      int j;
      label345:
      Object localObject;
      if (VcCamera.access$800(this.this$0))
      {
        if (this.this$0.CUR_CAMERA == 0)
        {
          if ((this.this$0.screenOrientation != 2) && (this.this$0.screenOrientation != 1)) {
            i = this.this$0.devDisplay.getRotation() * 90;
          } else {
            i = 0;
          }
          i = (360 - (i + this.this$0.getOrientation()) % 360) % 360;
        }
        else if (this.this$0.CUR_CAMERA == 1)
        {
          i = this.this$0.devDisplay.getRotation();
          i = (this.this$0.getOrientation() - i * 90 + 360) % 360;
        }
        else
        {
          i = 0;
        }
        i = this.this$0.getRotation() + i;
        if ((this.this$0.getOrientation() != 270) && (this.this$0.getOrientation() != 90))
        {
          if (this.this$0.getOrientation() != 0)
          {
            j = i;
            if (this.this$0.getOrientation() != 180) {
              break label345;
            }
          }
          if ((this.this$0.getRotation() != 90) && (this.this$0.getRotation() != 270))
          {
            j = i;
            if (this.this$0.CUR_CAMERA != 0) {
              break label345;
            }
            j = i;
            if (!this.this$0.mbIsTablet) {
              break label345;
            }
          }
          else
          {
            j = i;
            if (this.this$0.CUR_CAMERA != 0) {
              break label345;
            }
            j = i;
            if (this.this$0.mbIsTablet) {
              break label345;
            }
          }
        }
        else
        {
          j = i;
          if (this.this$0.getRotation() % 180 != 0) {
            break label345;
          }
          j = i;
          if (this.this$0.CUR_CAMERA != 0) {
            break label345;
          }
          j = i;
          if (VcCamera.access$900(this.this$0).equalsIgnoreCase("ZTE")) {
            break label345;
          }
        }
        j = i + 180;
        if (this.this$0.CUR_CAMERA == 0)
        {
          if (this.this$0.mFrontCameraAngle > 0)
          {
            i = 360 - this.this$0.mFrontCameraAngle + j;
            break label663;
          }
          localObject = this.this$0;
          i = ((VcCamera)localObject).getRemoteAngleForFrontCamera(((VcCamera)localObject).getRotation());
        }
        else if (this.this$0.mBackCameraAngle > 0)
        {
          i = this.this$0.mBackCameraAngle;
        }
        else
        {
          localObject = this.this$0;
          i = ((VcCamera)localObject).getRemoteAngleForBackCamera(((VcCamera)localObject).getRotation());
        }
        i += j;
      }
      else
      {
        j = (this.this$0.getRotation() + this.this$0.CompenSateRecvAngle + 90) % 360;
        if (this.this$0.getOrientation() != 270)
        {
          i = j;
          if (this.this$0.getOrientation() != 90) {}
        }
        else if (this.this$0.CUR_CAMERA == 0)
        {
          i = j + 90;
        }
        else
        {
          i = j + 180;
        }
        if (this.this$0.CUR_CAMERA == 0)
        {
          j = i;
          if (VcCamera.access$900(this.this$0).equalsIgnoreCase("ZTE")) {}
        }
        else
        {
          j = i + 180;
        }
        if (this.this$0.CUR_CAMERA == 0)
        {
          if (this.this$0.mFrontCameraAngle > 0)
          {
            i = j + (360 - this.this$0.mFrontCameraAngle);
            break label663;
          }
          localObject = this.this$0;
          i = ((VcCamera)localObject).getRemoteAngleForFrontCamera(((VcCamera)localObject).getRotation());
        }
        else if (this.this$0.mBackCameraAngle > 0)
        {
          i = this.this$0.mBackCameraAngle;
        }
        else
        {
          localObject = this.this$0;
          i = ((VcCamera)localObject).getRemoteAngleForBackCamera(((VcCamera)localObject).getRotation());
        }
        i = j + i;
      }
      label663:
      int k = i % 360 / 90;
      if (paramArrayOfByte == null)
      {
        QLog.d("VcCamera", 0, "onPreviewFrame data null");
        return;
      }
      if (this.this$0.LAST_CAMERA != this.this$0.CUR_CAMERA)
      {
        localObject = this.this$0;
        AVUILoopProxy.postTaskToMainLooper(new VcCamera.CameraPreviewChangeRunnable((VcCamera)localObject, ((VcCamera)localObject).CUR_CAMERA));
        localObject = this.this$0;
        ((VcCamera)localObject).LAST_CAMERA = ((VcCamera)localObject).CUR_CAMERA;
      }
      int m = paramArrayOfByte.length;
      if (m != this.this$0.VideoChatSettings.width * this.this$0.VideoChatSettings.height * ImageFormat.getBitsPerPixel(this.this$0.VideoChatSettings.format) / 8)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("camera param is not the same as setting, real data_width:");
        ((StringBuilder)localObject).append(this.this$0.VideoChatSettings.width);
        ((StringBuilder)localObject).append("data_height:");
        ((StringBuilder)localObject).append(this.this$0.VideoChatSettings.height);
        ((StringBuilder)localObject).append("data_format:");
        ((StringBuilder)localObject).append(this.this$0.VideoChatSettings.format);
        ((StringBuilder)localObject).append("real length: ");
        ((StringBuilder)localObject).append(m);
        QLog.d("VcCamera", 0, ((StringBuilder)localObject).toString());
        if (this.this$0.mFrameSizes != null)
        {
          localObject = this.this$0.mFrameSizes.iterator();
          while (((Iterator)localObject).hasNext())
          {
            Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
            if (localSize.height * localSize.width * ImageFormat.getBitsPerPixel(this.this$0.VideoChatSettings.format) / 8 == m)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("get real size form support sizes, width: ");
              localStringBuilder.append(localSize.width);
              localStringBuilder.append("data_height:");
              localStringBuilder.append(localSize.height);
              localStringBuilder.append("data_format:");
              localStringBuilder.append(this.this$0.VideoChatSettings.format);
              localStringBuilder.append("real length: ");
              localStringBuilder.append(m);
              QLog.d("VcCamera", 0, localStringBuilder.toString());
              if (localSize.width >= localSize.height)
              {
                VcCamera.access$1000(this.this$0, paramArrayOfByte, m, localSize.width, localSize.height, k, this.this$0.VideoChatSettings.format);
                i = 1;
                break label1129;
              }
            }
          }
        }
        i = 0;
        label1129:
        j = i;
        if (i == 0)
        {
          j = i;
          if (paramCamera != null)
          {
            try
            {
              localObject = paramCamera.getParameters();
              j = i;
              if (localObject == null) {
                break label1335;
              }
              int n = ((Camera.Parameters)localObject).getPreviewSize().width;
              int i1 = ((Camera.Parameters)localObject).getPreviewSize().height;
              int i2 = ((Camera.Parameters)localObject).getPreviewFormat();
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("get preview camera info, data_width: ");
              ((StringBuilder)localObject).append(n);
              ((StringBuilder)localObject).append("data_height: ");
              ((StringBuilder)localObject).append(i1);
              ((StringBuilder)localObject).append("data_format: ");
              ((StringBuilder)localObject).append(i2);
              ((StringBuilder)localObject).append("real length: ");
              ((StringBuilder)localObject).append(m);
              QLog.d("VcCamera", 0, ((StringBuilder)localObject).toString());
              int i3 = n * i1 * ImageFormat.getBitsPerPixel(i2) / 8;
              j = i;
              if (i3 != m) {
                break label1335;
              }
              try
              {
                VcCamera.access$1000(this.this$0, paramArrayOfByte, m, n, i1, k, i2);
                j = 1;
              }
              catch (Exception localException1)
              {
                i = 1;
              }
              localException2.printStackTrace();
            }
            catch (Exception localException2) {}
            j = i;
          }
        }
        label1335:
        if (j == 0) {
          QLog.d("VcCamera", 0, "data len is not matched");
        }
      }
      else
      {
        VcCamera localVcCamera = this.this$0;
        VcCamera.access$1000(localVcCamera, paramArrayOfByte, m, localVcCamera.VideoChatSettings.width, this.this$0.VideoChatSettings.height, k, this.this$0.VideoChatSettings.format);
      }
      this.this$0.mCallbackBufferAddStrategy.supplement(paramCamera, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.camera.VcCamera.7
 * JD-Core Version:    0.7.0.1
 */