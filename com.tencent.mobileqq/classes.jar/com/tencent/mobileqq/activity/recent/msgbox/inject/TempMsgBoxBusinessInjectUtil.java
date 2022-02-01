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
  public static HashMap<String, Class<? extends ITempMsgBoxBusinessHandler>> a = new HashMap();
  @ConfigInject(configPath="Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version=1)
  public static ArrayList<Class<? extends ITempMsgBoxCallback>> b;
  @ConfigInject(configPath="Business/qqtempmsgbox-impl/src/main/resources/Inject_TempMsgBoxBusinessHandlerConfig.yml", version=1)
  public static HashMap<String, Class<? extends AbstractTempChatPlugin>> c = new HashMap();
  
  static
  {
    a.put("publicAccount", PublicAccountMsgBoxHandler.class);
    a.put("tempGameMsg", GameMsgBoxHandler.class);
    b = new ArrayList();
    b.add(TempMsgBoxCallback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.inject.TempMsgBoxBusinessInjectUtil
 * JD-Core Version:    0.7.0.1
 */