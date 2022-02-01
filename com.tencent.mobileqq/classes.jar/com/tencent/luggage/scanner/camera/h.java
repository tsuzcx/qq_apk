package com.tencent.luggage.scanner.camera;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import com.tencent.luggage.wxa.qz.o;

public class h
{
  public static int a()
  {
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    while (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 0)
      {
        o.e("ScanCameraUtil", String.format("cam get bid %d", new Object[] { Integer.valueOf(i) }));
        break label64;
      }
      i += 1;
    }
    i = 0;
    label64:
    o.e("ScanCameraUtil", String.format("cam getBackCameraId %d", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  public static h.a.a a(int paramInt1, int paramInt2)
  {
    if (Build.MODEL.equals("M9")) {
      return new e().a(paramInt1, paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openCamera(), CameraUtilImplAPI9, cameraId = ");
    localStringBuilder.append(paramInt1);
    o.e("ScanCameraUtil", localStringBuilder.toString());
    return new d().a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.h
 * JD-Core Version:    0.7.0.1
 */