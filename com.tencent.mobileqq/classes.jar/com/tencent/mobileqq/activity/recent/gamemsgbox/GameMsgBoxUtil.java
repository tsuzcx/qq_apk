package com.tencent.mobileqq.activity.recent.gamemsgbox;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgBoxUtil
{
  public static IGameMsgCallback a;
  @ConfigInject(configPath="Business/qqgamemsgbox-impl/src/main/resources/Inject_GameMsgBoxConfig.yml", version=1)
  public static ArrayList<Class<? extends IGameMsgCallback>> b = new ArrayList();
  
  static
  {
    b.add(GameMsgBoxCallback.class);
    try
    {
      a = (IGameMsgCallback)((Class)b.get(0)).newInstance();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MsgBoxUtil", 1, "registerCallback error: ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */