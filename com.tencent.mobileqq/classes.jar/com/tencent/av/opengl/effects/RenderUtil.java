package com.tencent.av.opengl.effects;

import android.os.Build;
import com.tencent.av.opengl.config.EffectFaceDeviceConfig;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.view.RendererUtils;

public class RenderUtil
{
  static int a = -1;
  private static Boolean b;
  
  public static int a(boolean paramBoolean)
  {
    int i = a;
    int j = 1;
    if (i == -1)
    {
      Object localObject = EffectFaceDeviceConfig.g();
      if (((localObject != null) && (((EffectFaceDeviceConfig)localObject).f())) || (b())) {
        a = 1;
      } else {
        a = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFrameAngle, mInversion[");
      ((StringBuilder)localObject).append(a);
      ((StringBuilder)localObject).append("], manufacture[");
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append("], model[");
      ((StringBuilder)localObject).append(Build.MODEL);
      ((StringBuilder)localObject).append("]");
      QLog.i("Render", 1, ((StringBuilder)localObject).toString());
    }
    i = j;
    if (paramBoolean)
    {
      i = j;
      if (a != 1) {
        i = 3;
      }
    }
    return i;
  }
  
  public static void a()
  {
    if (!EffectsRenderController.c()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      FileUtil.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static boolean b()
  {
    if (b == null)
    {
      Object localObject = null;
      try
      {
        String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.isInversionWhenFaceDetect.name(), "0");
        localObject = str;
        if ("1".equals(str))
        {
          localObject = str;
          b = Boolean.valueOf(true);
          localObject = str;
        }
        else
        {
          localObject = str;
          if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER))
          {
            localObject = str;
            if (!"TAH-AN00".equalsIgnoreCase(Build.MODEL))
            {
              localObject = str;
              if (!"TAH-AN00m".equalsIgnoreCase(Build.MODEL)) {}
            }
            else
            {
              localObject = str;
              b = Boolean.valueOf(true);
              localObject = str;
              break label132;
            }
          }
          localObject = str;
          b = Boolean.valueOf(false);
          localObject = str;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i("Render", 1, "isSpecialDevices", localThrowable);
      }
      label132:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSpecialDevices, [");
      localStringBuilder.append(b);
      localStringBuilder.append("], manufacture[");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("], model[");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("], dpcValue[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i("Render", 1, localStringBuilder.toString());
    }
    return b.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderUtil
 * JD-Core Version:    0.7.0.1
 */