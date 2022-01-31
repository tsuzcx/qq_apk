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
import com.tencent.ttpic.openai.ttpicmodule.AEHandDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTEmotionDetector;
import com.tencent.ttpic.openapi.ttpicmodule.PTSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_hair_segment.PTHairSegmenter;
import com.tencent.ttpic.openapi.ttpicmodule.module_sky_segment.PTSkySegmenter;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.video.AECoderFactory;

public class biik
{
  private static boolean a;
  
  public static boolean a()
  {
    if (a) {
      return true;
    }
    if (!b())
    {
      SLog.e("AEKitForQQ", "sdk version Limited!");
      return false;
    }
    bfma.a();
    String str = SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    SharedPreferences localSharedPreferences = bjaa.a().a();
    AEOpenRenderConfig.setEnableStrictMode(false);
    AEModule.initialize(localBaseApplication, AEModuleConfig.newBuilder().setLoadSo(false).setLutDir(null).setModelDir(str).setSoDir(str).setLicense("youtusdk_mqq.licence").setPreferences(localSharedPreferences).setEnableDebug(false).setFramebufferFetchEnable(false).setEnableResourceCheck(false).setEnableProfiler(false).setEnableDefaultBasic3(false).build());
    AECoderFactory.setAEDecoder(new biil());
    AECoderFactory.setAEEncoder(new biim());
    AIManager.registerDetector(AEHandDetector.class);
    AIManager.registerDetector(PTHairSegmenter.class);
    AIManager.registerDetector(PTSkySegmenter.class);
    AIManager.registerDetector(PTSegmenter.class);
    AIManager.registerDetector(PTEmotionDetector.class);
    CfConfig.setDecryptListener(new biin());
    a = true;
    return true;
  }
  
  public static boolean b()
  {
    return (AEModule.isAeKitSupportVersion()) && (Build.VERSION.SDK_INT >= 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biik
 * JD-Core Version:    0.7.0.1
 */