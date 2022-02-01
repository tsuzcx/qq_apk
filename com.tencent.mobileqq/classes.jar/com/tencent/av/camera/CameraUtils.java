package com.tencent.av.camera;

import android.content.Context;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;
import com.tencent.mobileqq.qroute.QRoute;

public class CameraUtils
{
  public static ICameraManagerApi a(Context paramContext)
  {
    return ((ICameraUtilsStaticApi)QRoute.api(ICameraUtilsStaticApi.class)).getInstance(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.CameraUtils
 * JD-Core Version:    0.7.0.1
 */