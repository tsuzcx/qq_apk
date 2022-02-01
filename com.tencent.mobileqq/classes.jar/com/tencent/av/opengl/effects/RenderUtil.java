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
  private static Boolean jdField_a_of_type_JavaLangBoolean = null;
  
  public static int a(boolean paramBoolean)
  {
    int j = 1;
    if (jdField_a_of_type_Int == -1)
    {
      EffectFaceDeviceConfig localEffectFaceDeviceConfig = EffectFaceDeviceConfig.a();
      if (((localEffectFaceDeviceConfig == null) || (!localEffectFaceDeviceConfig.h())) && (!a())) {
        break label107;
      }
    }
    label107:
    for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
    {
      QLog.i("Render", 1, "getFrameAngle, mInversion[" + jdField_a_of_type_Int + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "]");
      int i = j;
      if (paramBoolean)
      {
        i = j;
        if (jdField_a_of_type_Int != 1) {
          i = 3;
        }
      }
      return i;
    }
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
    if (jdField_a_of_type_JavaLangBoolean == null) {}
    for (;;)
    {
      try
      {
        str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.isInversionWhenFaceDetect.name(), "0");
        try
        {
          if ("1".equals(str))
          {
            jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            QLog.i("Render", 1, "isSpecialDevices, [" + jdField_a_of_type_JavaLangBoolean + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], dpcValue[" + str + "]");
            return jdField_a_of_type_JavaLangBoolean.booleanValue();
          }
          if ((!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || ((!"TAH-AN00".equalsIgnoreCase(Build.MODEL)) && (!"TAH-AN00m".equalsIgnoreCase(Build.MODEL)))) {
            continue;
          }
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
          continue;
          QLog.i("Render", 1, "isSpecialDevices", localThrowable1);
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        String str = null;
        continue;
      }
      continue;
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderUtil
 * JD-Core Version:    0.7.0.1
 */