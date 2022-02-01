package com.tencent.av.camera.api.impl;

import android.content.Context;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.camera.api.ICameraUtilsStaticApi;
import com.tencent.mobileqq.qroute.QRoute;

public class CameraUtilsStaticApiImpl
  implements ICameraUtilsStaticApi
{
  private static volatile ICameraManagerApi sInstance;
  
  public ICameraManagerApi getInstance(Context paramContext)
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null)
        {
          sInstance = (ICameraManagerApi)QRoute.api(ICameraManagerApi.class);
          sInstance.setUp(paramContext);
        }
      }
      finally {}
    }
    return sInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraUtilsStaticApiImpl
 * JD-Core Version:    0.7.0.1
 */