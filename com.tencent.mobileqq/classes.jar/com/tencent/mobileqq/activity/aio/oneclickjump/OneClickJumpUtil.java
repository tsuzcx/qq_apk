package com.tencent.mobileqq.activity.aio.oneclickjump;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class OneClickJumpUtil
{
  public static long a = 0L;
  public static long b = 0L;
  public static boolean c = false;
  public static MessageForUniteGrayTip d;
  public static boolean e = false;
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    long l = paramMessageRecord.time;
    Object localObject = paramQQAppInterface.getApp().getString(2131897108);
    localObject = new UniteGrayTipParam(paramMessageRecord.frienduin, paramMessageRecord.senderuin, (String)localObject, paramMessageRecord.istroop, -5040, 131093, l + 1L);
    ((UniteGrayTipParam)localObject).m = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 67);
    localBundle.putString("key_action_DATA", String.valueOf(paramMessageRecord.shmsgseq));
    ((UniteGrayTipParam)localObject).a(3, 7, localBundle);
    localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, (UniteGrayTipParam)localObject);
    localMessageForUniteGrayTip.shmsgseq = paramMessageRecord.shmsgseq;
    return localMessageForUniteGrayTip;
  }
  
  public static void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ONE_CLICK_JUMP_UNREAD_NUM = ");
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append(", ONE_CLICK_JUMP_COST = ");
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(", HAS_ROAM = ");
    ((StringBuilder)localObject).append(c);
    QLog.d("OneClickJumpUtil", 1, ((StringBuilder)localObject).toString());
    if ((a > 0L) && (b > 0L))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("unreadNum", String.valueOf(a));
      ((HashMap)localObject).put("consume", String.valueOf(b));
      if (c) {
        ((HashMap)localObject).put("entry", "2");
      } else {
        ((HashMap)localObject).put("entry", "1");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "actionGotoUnreadMsgEvent", true, 0L, 0L, (HashMap)localObject, "");
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext = QQToast.makeText(paramContext, 2131897109, 0).create(0);
    paramContext.setGravity(17, 0, 0);
    paramContext.show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (e)
    {
      paramQQAppInterface.getMessageFacade().b(d.frienduin, d.istroop, d.uniseq, false);
      d = null;
      e = false;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    String str = paramMessageRecord.frienduin;
    List localList = paramQQAppInterface.getMessageProxy(i).i(str, i);
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      MessageForUniteGrayTip localMessageForUniteGrayTip = a(paramQQAppInterface, paramMessageRecord);
      d = localMessageForUniteGrayTip;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tip.uniseq = ");
        localStringBuilder.append(localMessageForUniteGrayTip.uniseq);
        localStringBuilder.append("messageRecord.uniseq = ");
        localStringBuilder.append(paramMessageRecord.uniseq);
        QLog.d("OneClickJumpUtil", 2, localStringBuilder.toString());
      }
      if (paramMessageRecord.istroop == 1) {
        paramQQAppInterface.getMessageFacade().p().a(i, str, localMessageForUniteGrayTip, localList);
      } else if (paramMessageRecord.istroop == 10014) {
        paramQQAppInterface.getMessageFacade().s().a(i, str, localMessageForUniteGrayTip, localList);
      }
      UniteGrayTipMsgUtil.a(paramQQAppInterface, localMessageForUniteGrayTip);
      e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil
 * JD-Core Version:    0.7.0.1
 */