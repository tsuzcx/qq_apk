package com.tencent.aelight.camera.ae;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aelight.camera.ae.data.AEMaterialConfigParser;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.openapi.filter.LightNode;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.video.AECoderFactory;
import org.light.DeviceSupportUtil;
import org.light.device.OfflineConfig;

public class AEKitForQQ
{
  private static boolean a = false;
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if (AEResUtil.c(AEResInfo.AE_RES_BASE_PACKAGE))
    {
      if (!AEResUtil.c(AEResInfo.LIGHT_RES_BASE_PACKAGE)) {
        return false;
      }
      LightNode.initResourcePath(AEResUtil.k(), AEResUtil.l());
      DeviceSupportUtil.init(AEResUtil.k());
      if (!b())
      {
        SLog.e("AEKitForQQ", "sdk version Limited!");
        return false;
      }
      SvEffectSdkInitor.a();
      Object localObject1 = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initAEKit modelPath = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      AEQLog.a("AEKitForQQ", ((StringBuilder)localObject2).toString());
      localObject2 = BaseApplicationImpl.getContext();
      SharedPreferences localSharedPreferences = AECameraPrefsUtil.a().b();
      AEOpenRenderConfig.setEnableStrictMode(false);
      AEModule.initialize((Context)localObject2, AEModuleConfig.newBuilder().setLoadSo(false).setLutDir((String)localObject1).setModelDir((String)localObject1).setSoDir((String)localObject1).setAuthMode(1).setPreferences(localSharedPreferences).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
      AECoderFactory.setAEDecoder(new AEKitForQQ.1());
      AECoderFactory.setAEEncoder(new AEKitForQQ.2());
      AEMaterialConfigParser.a = OfflineConfig.getPhonePerfLevel((Context)localObject2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[init][material_downgrade] phoneLevel = ");
      ((StringBuilder)localObject1).append(AEMaterialConfigParser.a);
      AEQLog.a("AEKitForQQ", ((StringBuilder)localObject1).toString());
      QLog.i("AEKitForQQ", 1, "[init][lightSdk] version = 2.6.0.23");
      CfConfig.setDecryptListener(new AEKitForQQ.3());
      a = true;
      return true;
    }
    return false;
  }
  
  public static boolean b()
  {
    return (AEModule.isAeKitSupportVersion()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEKitForQQ
 * JD-Core Version:    0.7.0.1
 */