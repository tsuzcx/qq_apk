package com.tencent.mobileqq.activity.aio.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.qphone.base.util.QLog;

public class TroopGameNotifyUpdateHelper
  implements ILifeCycleHelper
{
  public static long a = 86400L;
  public static long b = 36000L;
  protected String c = "";
  protected ITroopGameHandler d;
  private BaseChatPie e;
  
  public TroopGameNotifyUpdateHelper(BaseChatPie paramBaseChatPie)
  {
    this.e = paramBaseChatPie;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setNotifyUpdateTime, troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", curTime = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("TroopGameNotifyUpdateHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_GAME_NOTIFY_UPDATE_");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramQQAppInterface = localStringBuilder.toString();
    ((SharedPreferences)localObject).edit().putLong(paramQQAppInterface, paramLong).commit();
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    SharedPreferences localSharedPreferences = paramQQAppInterface.getPreferences();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_GAME_NOTIFY_UPDATE_");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("hasNotifyUpdate, updateTime = ");
      paramQQAppInterface.append(l1);
      paramQQAppInterface.append(", curTime = ");
      paramQQAppInterface.append(l2);
      QLog.d("TroopGameNotifyUpdateHelper", 2, paramQQAppInterface.toString());
    }
    long l3 = b;
    if (l1 < l3) {
      return false;
    }
    if (l1 > l2) {
      return false;
    }
    long l4 = a;
    if ((l2 - l3) / l4 == (l1 - l3) / l4) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    paramString = this.e.d.getMessageFacade().getLastMessage(paramString, 1);
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameNotifyUpdateHelper", 2, "checkSendMsgAfterTenClockToday, lastMsg is null");
      }
      return false;
    }
    long l1 = paramString.time;
    long l4 = NetConnInfoCenter.getServerTime();
    long l2 = b;
    long l3 = a;
    l4 = (l4 - l2) / l3;
    l1 = (l1 - l2) / l3;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("checkSendMsgAfterTenClockToday, curDay = ");
      paramString.append(l4);
      paramString.append(", updateDay = ");
      paramString.append(l1);
      QLog.d("TroopGameNotifyUpdateHelper", 2, paramString.toString());
    }
    if (l4 == l1) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void b()
  {
    if (this.d == null) {
      this.d = ((ITroopGameHandler)this.e.d.getBusinessHandler(BusinessHandlerFactory.TROOP_GAME_HANDLER));
    }
    Object localObject = this.d;
    if (localObject != null)
    {
      ((ITroopGameHandler)localObject).b(this.c);
      long l = NetConnInfoCenter.getServerTime();
      a(this.e.d, this.c, l);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyUpdate, curTime = ");
        ((StringBuilder)localObject).append(l);
        QLog.d("TroopGameNotifyUpdateHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    if (((BaseChatPie)localObject).ah == null) {
      return;
    }
    if (StudyModeManager.h()) {
      return;
    }
    this.c = this.e.ah.b;
    if (TextUtils.isEmpty(this.c)) {
      return;
    }
    localObject = (TroopGameCardConfig)QConfigManager.b().b(695);
    if (localObject != null)
    {
      if (!((TroopGameCardConfig)localObject).d(this.c)) {
        return;
      }
      localObject = ((TroopManager)this.e.d.getManager(QQManagerFactory.TROOP_MANAGER)).g(this.c);
      if (localObject == null) {
        return;
      }
      if (((TroopInfo)localObject).isHomeworkTroop()) {
        return;
      }
      if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
        return;
      }
      if (a(this.e.d, this.c)) {
        return;
      }
      if (a(this.c)) {
        return;
      }
      b();
    }
  }
  
  public String getTag()
  {
    return "TroopGameNotifyUpdateHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameNotifyUpdateHelper
 * JD-Core Version:    0.7.0.1
 */