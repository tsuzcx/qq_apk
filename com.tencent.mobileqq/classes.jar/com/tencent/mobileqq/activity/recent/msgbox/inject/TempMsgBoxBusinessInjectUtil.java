package com.tencent.mobileqq.activity.recent.msgbox.inject;

import com.tencent.mobileqq.activity.recent.msgbox.ITempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxCallback;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.GameMsgBoxHandler;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.ITempMsgBoxBusinessHandler;
import com.tencent.mobileqq.activity.recent.msgbox.businesshandler.PublicAccountMsgBoxHandler;
import com.tencent.mobileqq.activity.recent.msgbox.tempchat.AbstractTempChatPlugin;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;
import java.util.HashMap;

public class TempMsgBoxBusinessInjectUtil
{
  @ConfigInject(configPath="Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version=1)
  public static ArrayList<Class<? extends ITempMsgBoxCallback>> a;
  @ConfigInject(configPath="Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version=1)
  public static HashMap<String, Class<? extends ITempMsgBoxBusinessHandler>> a;
  @ConfigInject(configPath="Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version=1)
  public static HashMap<String, Class<? extends AbstractTempChatPlugin>> b = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("publicAccount", PublicAccountMsgBoxHandler.class);
    jdField_a_of_type_JavaUtilHashMap.put("tempGameMsg", GameMsgBoxHandler.class);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(TempMsgBoxCallback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.inject.TempMsgBoxBusinessInjectUtil
 * JD-Core Version:    0.7.0.1
 */