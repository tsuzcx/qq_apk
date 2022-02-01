import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEModuleConfig;
import com.tencent.aekit.api.standard.AEModuleConfig.Builder;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.sveffects.SvEffectSdkInitor;
import com.tencent.ttpic.openai.ttpicmodule.AEGenderDetector;
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
import com.tencent.ttpic.openapi.ttpicmodule.AECatDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.video.AECoderFactory;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;

public class bljd
{
  private static boolean a;
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if (!AEResUtil.checkAEResVersionOK(AEResInfo.AE_RES_BASE_PACKAGE)) {
      return false;
    }
    if (!b())
    {
      SLog.e("AEKitForQQ", "sdk version Limited!");
      return false;
    }
    SvEffectSdkInitor.init();
    String str = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    SharedPreferences localSharedPreferences = bmbk.a().a();
    AEOpenRenderConfig.setEnableStrictMode(false);
    AEModule.initialize(localBaseApplication, AEModuleConfig.newBuilder().setLoadSo(false).setLutDir(str).setModelDir(str).setSoDir(str).setAuthMode(1).setPreferences(localSharedPreferences).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
    AECoderFactory.setAEDecoder(new blje());
    AECoderFactory.setAEEncoder(new bljf());
    AIManager.registerDetector(AEHandDetector.class);
    AIManager.registerDetector(AECatDetector.class);
    AIManager.registerDetector(AEGenderDetector.class);
    AIManager.registerDetector(PTEmotionDetector.class);
    AIManager.registerDetector(PTHairSegmenter.class);
    AIManager.registerDetector(PTSkySegmenter.class);
    AIManager.registerDetector(PTHumanSegmenter.class);
    dov.com.qq.im.ae.data.AEMaterialConfigParser.a = OfflineConfig.getPhonePerfLevel();
    CfConfig.setDecryptListener(new bljg());
    a = true;
    return true;
  }
  
  public static boolean b()
  {
    return (AEModule.isAeKitSupportVersion()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljd
 * JD-Core Version:    0.7.0.1
 */