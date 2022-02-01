package com.tencent.mobileqq.apollo.config;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.utils.api.IApolloABTestApi;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;

public class CmShowWnsUtils
{
  public static boolean A()
  {
    return a("CMShow", "CMShowAvatarVideoCompress", 1) > 0;
  }
  
  public static boolean B()
  {
    return a("CMShow", "enableEGLOffscreenConfig", 1) > 0;
  }
  
  public static boolean C()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowGroupAIOWithAt", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static Long D()
  {
    return Long.valueOf(a("CMShow", "CmshowCEOffscreenEvlJSDelayTime", 100L));
  }
  
  public static int E()
  {
    return a("CMShow", "CMShowMemeCacheKey", 0);
  }
  
  public static boolean F()
  {
    return a("CMShow", "CMShowEvalScriptDirectlyOnGLThread", 1) > 0;
  }
  
  public static boolean G()
  {
    return a("CMShow", "CMShowTexturePendingRelease", 1) > 0;
  }
  
  public static boolean H()
  {
    return a("CMShow", "CMShowMemeIceBreak", 1) > 0;
  }
  
  public static boolean I()
  {
    boolean bool = false;
    if (a("CMShow", "CEAIOFriendCardDependOnPlayer", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String J()
  {
    return a("CMShow", "CMShowCERoleUrl", "https://qqshowar.gtimg.cn/cedata_only/vipApollo_role_");
  }
  
  public static String K()
  {
    return a("CMShow", "CMShowCEActionUrl", "https://qqshowar.gtimg.cn/cedata_only/vipApollo_action_");
  }
  
  public static String L()
  {
    return a("CMShow", "CMShowCEDressUrl", "https://qqshowar.gtimg.cn/cedata_only/vipApollo_item_");
  }
  
  public static long M()
  {
    return a("CMShow", "CMShowCERoleVersion", 1619591913L);
  }
  
  public static long N()
  {
    return a("CMShow", "CMShowCEActionVersion", 1617715031L);
  }
  
  public static long O()
  {
    return a("CMShow", "CMShowCEDressVersion", 1619200008L);
  }
  
  public static boolean P()
  {
    return a("CMShow", "CMShowMemeInitEngineOnUiThread", 1) > 0;
  }
  
  public static boolean Q()
  {
    return a("CMShow", "CMShowAvatar3DSwitch", 1) > 0;
  }
  
  public static String R()
  {
    boolean bool = ((IApolloABTestApi)QRoute.api(IApolloABTestApi.class)).canCmStatusExp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check shouldShowCmStatus: ");
    localStringBuilder.append(bool);
    QLog.i("[cmshow]CmShowWnsUtils", 1, localStringBuilder.toString());
    if (!bool) {
      return null;
    }
    return a("CMShow", "CMShowQQStatusAction", ApolloCmQQStatusData.getDefaultConfigs());
  }
  
  public static String S()
  {
    return a("CMShow", "CMShowAvatarTitle", "厘米秀头像");
  }
  
  public static int T()
  {
    return a("CMShow", "CMShowAioLoverWhiteFaceShowCount", 2);
  }
  
  public static boolean U()
  {
    boolean bool = false;
    if (a("CMShow", "EnableAudioInDrawer", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static String V()
  {
    return a("CMShow", "CMShowActionJsonUrl", "https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipList_apollo_data/tab_list_android_v730.json");
  }
  
  public static boolean W()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowEnable3DEmotion", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean X()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowEnableTabAvatar", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static int Y()
  {
    if (CMShowPlatform.a.b(Scene.MEME_PLAYER)) {
      return a("CMShow", "MemeFrameWaitingIndexCE", 2);
    }
    return a("CMShow", "MemeFrameWaitingIndexBK", 1);
  }
  
  public static boolean Z()
  {
    return a("CMShow", "CmshowEnableDeleteOldVersionAssets", 1) == 1;
  }
  
  public static float a(String paramString1, String paramString2, float paramFloat)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramFloat);
  }
  
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramInt);
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramString3);
  }
  
  public static boolean a()
  {
    return a("CMShow", "CMShowWhiteFace3D", 1) > 0;
  }
  
  private static boolean a(int paramInt)
  {
    return a("CMShow", "CmshowMakeupUseCrossEngine", paramInt) == 1;
  }
  
  public static boolean a(Scene paramScene, int paramInt)
  {
    if (paramScene == Scene.MAKE_UP_3D) {
      return a(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CmshowUseCrossEngineFor");
    localStringBuilder.append(paramScene);
    return a("CMShow", localStringBuilder.toString(), paramInt) > 0;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramBoolean);
  }
  
  public static boolean aa()
  {
    return a("CMShow", "enableDensityCorrect", 1) > 0;
  }
  
  public static String ab()
  {
    return a("CMShow", "CMShowMakeupPanelUrl", "https://open.cmshow.qq.com/ac/cmshow_h5/html/pages/dress_up.html");
  }
  
  public static boolean ac()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowGroupAIOWithAt", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean ad()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowAIOPanelTag", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static float ae()
  {
    return a("CMShow", "AioCMShowDisplayHeight", 0.3F);
  }
  
  public static float af()
  {
    return a("CMShow", "AioCMShowDisappearHeight", 0.3F);
  }
  
  public static float ag()
  {
    return a("CMShow", "AioCMShowOffscreenHeight", 118.0F);
  }
  
  public static String ah()
  {
    return a("CMShow", "CMShow3DFaceCosHost", "3dcmshow-75972.gzc.vod.tencent-cloud.com");
  }
  
  public static String ai()
  {
    return a("CMShow", "CMShow3DFaceCdnHost", "3dcmshow.gtimg.cn");
  }
  
  public static boolean aj()
  {
    return a("CMShow", "CMShow3DFaceUrlReplace", true);
  }
  
  public static String ak()
  {
    return a("CMShow", "CMShowActionUsedTag", "最近使用");
  }
  
  public static boolean al()
  {
    boolean bool = false;
    if (a("CMShow", "OptimizeSpineUpdate", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b()
  {
    boolean bool = false;
    if (a("CMShow", "AioCMShowToggleButtonSwitch", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean c()
  {
    return a("CMShow", "CMShowNewAnimation", 1) > 0;
  }
  
  public static float d()
  {
    return a("CMShow", "AioCMShowOffscreenHeight", 118.0F);
  }
  
  public static boolean e()
  {
    return a("CMShow", "CMShowMemeTab", 1) > 0;
  }
  
  public static boolean f()
  {
    boolean bool = false;
    if (a("CMShow", "CMShowMemeTabInFace", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean g()
  {
    return a("CMShow", "CMShowKeywordAssociation", 1) > 0;
  }
  
  public static boolean h()
  {
    String str = a("CMShow", "CMShowAEKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean i()
  {
    String str = a("CMShow", "CMShowCrossEngineKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
  
  public static float j()
  {
    return a("CMShow", "CmsPanelGetCoverFrameTime", 33.333332F);
  }
  
  public static long k()
  {
    if (BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0).getBoolean("test_3d_action", false)) {
      return 60000L;
    }
    return a("CMShow", "CmsPlayerRecordTimeout", 15000L);
  }
  
  public static boolean l()
  {
    boolean bool = false;
    if (a("CMShow", "apolloPanelExtendEnable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean m()
  {
    boolean bool = false;
    if (a("CMShow", "C2CCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean n()
  {
    boolean bool = false;
    if (a("CMShow", "GroupCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean o()
  {
    return a("CMShow", "addAnimToFav", 1) > 0;
  }
  
  public static boolean p()
  {
    boolean bool = false;
    if (a("CMShow", "panelRedDot", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean q()
  {
    return a("CMShow", "panel3DStore", 1) > 0;
  }
  
  public static boolean r()
  {
    boolean bool = false;
    if (a("CMShow", "encounterChatSupportSprite", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean s()
  {
    return a("CMShow", "enableSizeCorrect", 1) > 0;
  }
  
  public static boolean t()
  {
    return a("CMShow", "CMShowAsyncGetDpcSwitch", 1) > 0;
  }
  
  public static int u()
  {
    String str = a("CMShow", "recordThreadPoolSize", "4,2,1");
    if (TextUtils.isEmpty(str)) {
      return 1;
    }
    String[] arrayOfString = str.split(",");
    int i;
    if (arrayOfString != null)
    {
      if (arrayOfString.length != 3) {
        return 1;
      }
      try
      {
        if (DeviceInfoUtils.isHighPerfDevice()) {
          i = Integer.parseInt(arrayOfString[0]);
        } else if (DeviceInfoUtils.isLowPerfDevice()) {
          i = Integer.parseInt(arrayOfString[2]);
        } else {
          i = Integer.parseInt(arrayOfString[1]);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecordAsyncThreadMaxCount exception, config:");
        localStringBuilder.append(str);
        QLog.e("[cmshow]CmShowWnsUtils", 1, localStringBuilder.toString(), localNumberFormatException);
      }
    }
    else
    {
      return 1;
    }
    return i;
  }
  
  public static boolean v()
  {
    return a("CMShow", "framePlayOpen", 1) > 0;
  }
  
  public static boolean w()
  {
    return a("CMShow", "frameDrawableLowMemoryMode", 1) > 0;
  }
  
  public static int x()
  {
    return a("CMShow", "frameDrawableMaxCount", 20);
  }
  
  public static boolean y()
  {
    return a("CMShow", "CMShowAvatarEnable", 1) > 0;
  }
  
  public static int z()
  {
    return a("CMShow", "CMShowGetFrameDelayTime", 200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.CmShowWnsUtils
 * JD-Core Version:    0.7.0.1
 */