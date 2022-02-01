package com.tencent.mobileqq.app.parser.jumpcontroller;

import com.tencent.mobileqq.app.parser.jumpcontroller.business.LBSResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.MiniAppLoginResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.MultiVoiceCallResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ProfilePreviewResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ShareLoginResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQFileResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpQQComicResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpSmartDeviceResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.SingleVoiceCallResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ThirdPartyGesturePWDResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ThirdPartyLoginResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.ViewLoginResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.WPAGesturePWDResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.WPALoginResultPlugin;
import com.tencent.mobileqq.app.parser.jumpcontroller.business.WebSecurityVerifyResultPlugin;
import com.tencent.mobileqq.jumpcontroller.JumpControllerInject;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.HashMap;

public class JumpActivityInjectUtil
{
  @ConfigInject(configPath="Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version=1)
  public static ArrayList<Class<? extends IJumpControllerInterface>> a = new ArrayList();
  @ConfigInject(configPath="Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version=1)
  public static HashMap<String, Class<? extends IJumpBusinessInterface>> b;
  @ConfigInject(configPath="Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version=1)
  public static ArrayList<Class<? extends IJumpParserInterface>> c;
  
  static
  {
    a.add(JumpControllerInject.class);
    b = new HashMap();
    b.put("573", ShortCutJumpSmartDeviceResultPlugin.class);
    b.put("570", ShortCutJumpQFileResultPlugin.class);
    b.put("25", WebSecurityVerifyResultPlugin.class);
    b.put("572", ShortCutJumpQQComicResultPlugin.class);
    b.put("2", SingleVoiceCallResultPlugin.class);
    b.put("1", MultiVoiceCallResultPlugin.class);
    b.put("24", MiniAppLoginResultPlugin.class);
    b.put("27", ThirdPartyGesturePWDResultPlugin.class);
    b.put("26", ThirdPartyLoginResultPlugin.class);
    b.put("22", WPAGesturePWDResultPlugin.class);
    b.put("21", WPALoginResultPlugin.class);
    b.put("20", ViewLoginResultPlugin.class);
    b.put("19", ShareLoginResultPlugin.class);
    b.put("18", LBSResultPlugin.class);
    b.put("880", ProfilePreviewResultPlugin.class);
    b.put("800", ProfilePreviewResultPlugin.class);
    c = new ArrayList();
    c.add(JumpParserInject.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.JumpActivityInjectUtil
 * JD-Core Version:    0.7.0.1
 */