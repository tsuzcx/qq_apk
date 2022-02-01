package com.tencent.mobileqq.apollo.config;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.debug.utils.ApolloDebugUtils;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import common.config.service.QzoneConfig;
import java.util.HashMap;

public class CmShowWnsUtils
{
  private static final HashMap<Scene, Boolean> a = new HashMap();
  
  public static boolean A()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CEAIOFriendCardDependOnPlayer", 1) > 0;
  }
  
  public static boolean B()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CEShowAioPanelSlaveTab", 0L) > 0L;
  }
  
  public static boolean C()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeInitEngineOnUiThread", 1) > 0;
  }
  
  public static boolean D()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAvatar3DSwitch", 1) > 0;
  }
  
  public static boolean E()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "EnableAudioInDrawer", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static float a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowOffscreenHeight", 118.0F);
  }
  
  public static int a()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "recordThreadPoolSize", "4,2,1");
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
        if (DeviceInfoUtils.a()) {
          i = Integer.parseInt(arrayOfString[0]);
        } else if (DeviceInfoUtils.b()) {
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
  
  public static long a()
  {
    if (BaseApplicationImpl.getApplication().getSharedPreferences("apollo_test", 0).getBoolean("test_3d_action", false)) {
      return 60000L;
    }
    return QzoneConfig.getInstance().getConfig("CMShow", "CmsPlayerRecordTimeout", 15000L);
  }
  
  public static Long a()
  {
    return Long.valueOf(QzoneConfig.getInstance().getConfig("CMShow", "CmshowCEOffscreenEvlJSDelayTime", 100L));
  }
  
  public static String a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCERoleUrl", "https://qqshowar.gtimg.cn/cedata/vipApollo_role_");
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowWhiteFace3D", 1) > 0;
  }
  
  public static boolean a(Scene paramScene, int paramInt)
  {
    if (a.containsKey(paramScene)) {
      return ((Boolean)a.get(paramScene)).booleanValue();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CmshowUseCrossEngineFor");
    ((StringBuilder)localObject).append(paramScene);
    localObject = ((StringBuilder)localObject).toString();
    paramInt = QzoneConfig.getInstance().getConfig("CMShow", (String)localObject, paramInt);
    boolean bool3 = false;
    boolean bool1;
    if (paramInt > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool4 = ApolloDebugUtils.a(paramScene.debugConfigKey());
    boolean bool2;
    if ((paramScene == Scene.AIO) || (paramScene == Scene.FRIEND_CARD))
    {
      bool2 = A();
      boolean bool5 = CMShowPlatform.a.b(Scene.MEME_PLAYER);
      if ((bool2) && (bool5))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enableCrossEngineForScene current scene:");
        ((StringBuilder)localObject).append(paramScene);
        ((StringBuilder)localObject).append(", return true for memePlayer run on CE, enableByWns:");
        ((StringBuilder)localObject).append(bool1);
        QLog.w("[cmshow]CmShowWnsUtils", 1, ((StringBuilder)localObject).toString());
        a.put(paramScene, Boolean.valueOf(true));
        return true;
      }
    }
    localObject = a;
    if ((!bool4) && (!bool1)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    ((HashMap)localObject).put(paramScene, Boolean.valueOf(bool2));
    if (!bool4)
    {
      bool2 = bool3;
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
  
  public static float b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmsPanelGetCoverFrameTime", 33.333332F);
  }
  
  public static int b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "frameDrawableMaxCount", 20);
  }
  
  public static long b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCERoleVersion", 1617882823L);
  }
  
  public static String b()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCEActionUrl", "https://qqshowar.gtimg.cn/cedata/vipApollo_action_");
  }
  
  public static boolean b()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "AioCMShowToggleButtonSwitch", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static int c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowGetFrameDelayTime", 200);
  }
  
  public static long c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCEActionVersion", 1617715031L);
  }
  
  public static String c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCEDressUrl", "https://qqshowar.gtimg.cn/cedata/vipApollo_item_");
  }
  
  public static boolean c()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowNewAnimation", 1) > 0;
  }
  
  public static int d()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeCacheKey", 0);
  }
  
  public static long d()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowCEDressVersion", 1617866371L);
  }
  
  public static String d()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAvatarTitle", "厘米秀头像");
  }
  
  public static boolean d()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowMemeTab", 1) > 0;
  }
  
  public static boolean e()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "CMShowMemeTabInFace", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean f()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowKeywordAssociation", 1) > 0;
  }
  
  public static boolean g()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowAEKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean h()
  {
    String str = QzoneConfig.getInstance().getConfig("CMShow", "CMShowCrossEngineKitDeviceBlackList", "");
    if (!TextUtils.isEmpty(str)) {
      return str.contains(Build.MODEL);
    }
    return false;
  }
  
  public static boolean i()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "apolloPanelExtendEnable", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean j()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "C2CCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean k()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "GroupCMShowPanelBattleGameEntrance", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean l()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "addAnimToFav", 1) > 0;
  }
  
  public static boolean m()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "panelRedDot", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean n()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "encounterChatSupportSprite", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean o()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "enableSizeCorrect", 1) > 0;
  }
  
  public static boolean p()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAsyncGetDpcSwitch", 1) > 0;
  }
  
  public static boolean q()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "framePlayOpen", 1) > 0;
  }
  
  public static boolean r()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "frameDrawableLowMemoryMode", 1) > 0;
  }
  
  public static boolean s()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAvatarEnable", 1) > 0;
  }
  
  public static boolean t()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowAvatarVideoCompress", 1) > 0;
  }
  
  public static boolean u()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "enableEGLOffscreenConfig", 1) > 0;
  }
  
  public static boolean v()
  {
    QzoneConfig localQzoneConfig = QzoneConfig.getInstance();
    boolean bool = false;
    if (localQzoneConfig.getConfig("CMShow", "CMShowGroupAIOWithAt", 0) > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean w()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmshowMakeupUseCrossEngine", 1) == 1;
  }
  
  public static boolean x()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CmshowUseCrossEngineOffscreenWorld", 1) == 1;
  }
  
  public static boolean y()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowEvalScriptDirectlyOnGLThread", 1) > 0;
  }
  
  public static boolean z()
  {
    return QzoneConfig.getInstance().getConfig("CMShow", "CMShowTexturePendingRelease", 1) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.config.CmShowWnsUtils
 * JD-Core Version:    0.7.0.1
 */