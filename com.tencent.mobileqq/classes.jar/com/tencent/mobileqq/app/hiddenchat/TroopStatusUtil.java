package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class TroopStatusUtil
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.f(String.valueOf(paramLong));
    int k = 0;
    int m = 0;
    int j = 1;
    int i;
    if (localTroopInfo == null)
    {
      localTroopInfo = new TroopInfo();
      localTroopInfo.cmdUinFlagEx2 = paramInt;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeSinglePbMsg_GroupDis, groupMemberFlagEx2=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", troopUin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", hummer message cmdUinFlagEx2=");
      localStringBuilder.append(localTroopInfo.cmdUinFlagEx2);
      QLog.d("TroopRankConfig", 2, localStringBuilder.toString());
    }
    paramLong = localTroopInfo.cmdUinFlagEx2;
    long l = paramInt;
    if (paramLong != l)
    {
      paramInt = m;
      if (TroopInfo.isCmdUinFlagEx2Open(localTroopInfo.cmdUinFlagEx2, 512) != TroopInfo.isCmdUinFlagEx2Open(l, 512)) {
        paramInt = 1;
      }
      localTroopInfo.cmdUinFlagEx2 = l;
      i = j;
    }
    else
    {
      paramInt = k;
    }
    if (i != 0)
    {
      localTroopManager.b(localTroopInfo);
      if (paramInt != 0) {
        a(paramQQAppInterface, localTroopInfo);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Map<String, Boolean> paramMap)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("TroopStatusUtil", 2, new Object[] { "HummerMessage::updateTroopRingId: invoked. ", " ringId: ", Integer.valueOf(paramInt), " groupCode: ", Long.valueOf(paramLong) });
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo2 = localTroopManager.f(String.valueOf(paramLong));
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.udwCmdUinRingtoneID = paramInt;
      i = 1;
    }
    paramLong = localTroopInfo1.udwCmdUinRingtoneID;
    long l = paramInt;
    if (paramLong != l)
    {
      localTroopInfo1.udwCmdUinRingtoneID = l;
      i = 1;
    }
    if (i != 0)
    {
      localTroopManager.b(localTroopInfo1);
      MessageNotificationSettingManager.a(paramQQAppInterface).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil
 * JD-Core Version:    0.7.0.1
 */