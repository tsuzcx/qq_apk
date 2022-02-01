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
  public static ArrayList<Class<? extends IJumpControllerInterface>> a;
  @ConfigInject(configPath="Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version=1)
  public static HashMap<String, Class<? extends IJumpBusinessInterface>> a;
  @ConfigInject(configPath="Business/qqjump-api/src/main/resources/Inject_jump_activity_config.yml", version=1)
  public static ArrayList<Class<? extends IJumpParserInterface>> b;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(JumpControllerInject.class);
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("573", ShortCutJumpSmartDeviceResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("570", ShortCutJumpQFileResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("25", WebSecurityVerifyResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("572", ShortCutJumpQQComicResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("2", SingleVoiceCallResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("1", MultiVoiceCallResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("24", MiniAppLoginResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("27", ThirdPartyGesturePWDResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("26", ThirdPartyLoginResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("22", WPAGesturePWDResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("21", WPALoginResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("20", ViewLoginResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("19", ShareLoginResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("18", LBSResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("880", ProfilePreviewResultPlugin.class);
    jdField_a_of_type_JavaUtilHashMap.put("800", ProfilePreviewResultPlugin.class);
    b = new ArrayList();
    b.add(JumpParserInject.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.JumpActivityInjectUtil
 * JD-Core Version:    0.7.0.1
 */