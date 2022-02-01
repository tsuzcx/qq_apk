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
  static int jdField_a_of_type_Int = -1;
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  
  public static int a(boolean paramBoolean)
  {
    int i = jdField_a_of_type_Int;
    int j = 1;
    if (i == -1)
    {
      Object localObject = EffectFaceDeviceConfig.a();
      if (((localObject != null) && (((EffectFaceDeviceConfig)localObject).f())) || (a())) {
        jdField_a_of_type_Int = 1;
      } else {
        jdField_a_of_type_Int = 0;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFrameAngle, mInversion[");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
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
      if (jdField_a_of_type_Int != 1) {
        i = 3;
      }
    }
    return i;
  }
  
  public static void a()
  {
    if (!EffectsRenderController.b()) {
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
  
  private static boolean a()
  {
    if (jdField_a_of_type_JavaLangBoolean == null)
    {
      Object localObject = null;
      try
      {
        String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.isInversionWhenFaceDetect.name(), "0");
        localObject = str;
        if ("1".equals(str))
        {
          localObject = str;
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
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
              jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
              localObject = str;
              break label132;
            }
          }
          localObject = str;
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
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
      localStringBuilder.append(jdField_a_of_type_JavaLangBoolean);
      localStringBuilder.append("], manufacture[");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("], model[");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("], dpcValue[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.i("Render", 1, localStringBuilder.toString());
    }
    return jdField_a_of_type_JavaLangBoolean.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderUtil
 * JD-Core Version:    0.7.0.1
 */