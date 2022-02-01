package com.tencent.mobileqq.activity.troop;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.AbsTroopCommonProcessor;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopCommonProcessor
  extends AbsTroopCommonProcessor
{
  public void a(List<String> paramList)
  {
    TroopUtils.a(paramList);
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return SharedPreUtils.a(paramContext, paramString1).contains(paramString2);
  }
  
  public boolean a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    return ((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopInfo, paramBoolean);
  }
  
  public boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {
      return ((HotChatManager)paramAppRuntime.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramString);
    }
    return false;
  }
  
  public boolean b(AppRuntime paramAppRuntime, String paramString)
  {
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString))) {
      return ((ITroopRobotService)paramAppRuntime.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.TroopCommonProcessor
 * JD-Core Version:    0.7.0.1
 */