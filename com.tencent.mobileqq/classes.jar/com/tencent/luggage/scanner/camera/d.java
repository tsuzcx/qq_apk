package com.tencent.luggage.scanner.camera;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.luggage.wxa.qz.o;

class d
  implements h.a
{
  public h.a.a a(int paramInt1, int paramInt2)
  {
    h.a.a locala = new h.a.a();
    locala.a = null;
    try
    {
      long l = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call Camera.open cameraID ");
      ((StringBuilder)localObject).append(paramInt1);
      o.d("CameraUtilImpl23", ((StringBuilder)localObject).toString());
      locala.a = Camera.open(paramInt1);
      o.d("CameraUtilImpl23", String.format("Call Camera.open back, use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      if (locala.a == null)
      {
        o.b("CameraUtilImpl23", "open camera error, not exception, but camera null");
        return null;
      }
      localObject = new Camera.CameraInfo();
      l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Call Camera.getCameraInfo cameraID ");
      localStringBuilder.append(paramInt1);
      o.d("CameraUtilImpl23", localStringBuilder.toString());
      Camera.getCameraInfo(paramInt1, (Camera.CameraInfo)localObject);
      o.d("CameraUtilImpl23", String.format("Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      if (paramInt2 != 0)
      {
        if (paramInt2 == 1) {
          break label220;
        }
        if (paramInt2 == 2) {
          break label213;
        }
        if (paramInt2 == 3) {}
      }
      else
      {
        paramInt1 = 0;
        break label223;
      }
      paramInt1 = 270;
      break label223;
      label213:
      paramInt1 = 180;
      break label223;
      label220:
      paramInt1 = 90;
      label223:
      if (((Camera.CameraInfo)localObject).facing == 1) {
        paramInt1 = (360 - ((Camera.CameraInfo)localObject).orientation % 360) % 360;
      } else {
        paramInt1 = (((Camera.CameraInfo)localObject).orientation - paramInt1 + 360) % 360;
      }
      l = System.currentTimeMillis();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Call Camera.setDisplayOrientation ");
      ((StringBuilder)localObject).append(paramInt1);
      o.d("CameraUtilImpl23", ((StringBuilder)localObject).toString());
      locala.a.setDisplayOrientation(paramInt1);
      o.d("CameraUtilImpl23", String.format("Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      locala.b = paramInt1;
      return locala;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open camera error ");
      ((StringBuilder)localObject).append(localException.getMessage());
      o.b("CameraUtilImpl23", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.d
 * JD-Core Version:    0.7.0.1
 */