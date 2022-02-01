package com.tencent.mobileqq.activity.aio.qcircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.MobileQQ;

public class QCircleChatUtil
{
  public static Pair<Integer, List<String>> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!(MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof QQAppInterface)) {
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    return a(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageProxy(10008).a(AppConstants.QCIRCLE_CHAT_UIN, 10008));
  }
  
  public static Pair<Integer, List<String>> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      RFLog.i("QCircleChatUtil", RFLog.USR, "getQCircleChatList null");
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      String str = localMessageRecord.senderuin;
      int j = localMessageRecord.istroop;
      j = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getConversationFacade().a(str, j);
      if (j > 0) {
        localArrayList.add(str);
      }
      i += j;
    }
    RFLog.i("QCircleChatUtil", RFLog.USR, "getQCircleChatRedPointNum num:" + i + "getSenderList:" + localArrayList.toString());
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  public static MessageForQCircleIceBreak a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      MessageForQCircleIceBreak localMessageForQCircleIceBreak = (MessageForQCircleIceBreak)MessageRecordFactory.a(-7013);
      long l1 = MessageCache.a() - 5L;
      long l2;
      if (paramMessageRecord != null)
      {
        l2 = paramMessageRecord.shmsgseq - 1L;
        l1 = paramMessageRecord.time - 5L;
        localMessageForQCircleIceBreak.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "", l1, -7013, paramInt, l2);
        localMessageForQCircleIceBreak.isread = true;
        localMessageForQCircleIceBreak.shmsgseq = l2;
      }
      try
      {
        localMessageForQCircleIceBreak.saveExtInfoToExtStr("qcircle_chat_msg_data_key", new String(paramArrayOfByte, "utf-8"));
        if (RFLog.isDevelopLevel()) {
          RFLog.i("QCircleChatUtil", RFLog.DEV, String.format(Locale.getDefault(), "addIceBreakMessage in seq %s  time %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }));
        }
        paramString = localMessageForQCircleIceBreak;
        if (MessageHandlerUtils.a(paramQQAppInterface, localMessageForQCircleIceBreak, false)) {
          continue;
        }
        paramQQAppInterface.getMessageFacade().a(localMessageForQCircleIceBreak, paramQQAppInterface.getCurrentAccountUin(), false, false, true, true);
        return localMessageForQCircleIceBreak;
        l2 = Math.abs(new Random().nextInt());
      }
      catch (UnsupportedEncodingException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, MessageRecord paramMessageRecord)
  {
    if (RFLog.isColorLevel()) {
      RFLog.i("QCircleChatUtil", RFLog.CLR, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, MessageRecordUtil.a(paramString2) }));
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    long l2 = MessageCache.a();
    if (paramMessageRecord != null) {}
    for (long l1 = paramMessageRecord.shmsgseq;; l1 = Math.abs(new Random().nextInt()))
    {
      if (RFLog.isColorLevel()) {
        RFLog.d("QCircleChatUtil", RFLog.CLR, "addGrayTipsMessage start add tip message");
      }
      paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5022, 656395, l2);
      paramString1.d = paramString2;
      paramString1.c = paramString2;
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l1;
      paramString2.mNeedTimeStamp = false;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      UniteGrayTipUtil.a(paramQQAppInterface, paramString2);
      return paramString2;
    }
  }
  
  public static String a(int paramInt)
  {
    if (paramInt > 99) {
      return "99+";
    }
    return String.valueOf(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      RFLog.e("QCircleChatUtil", RFLog.CLR, new Object[] { "setIceBreakMsgHasShownToSp with null app or empty friendUin:", paramString });
    }
    do
    {
      return;
      RFLog.d("QCircleChatUtil", RFLog.CLR, new Object[] { "setIceBreakMsgHasShownToSp friendUin:", paramString });
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putBoolean("sp_icebreak_has_shown_key_" + paramString, true).apply();
  }
  
  public static void a(List<String> paramList, boolean paramBoolean)
  {
    if ((!(MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof QQAppInterface)) || (paramList == null)) {
      RFLog.e("QCircleChatUtil", RFLog.USR, "clearUnRead param error");
    }
    for (;;)
    {
      return;
      RFLog.d("QCircleChatUtil", RFLog.USR, "setRead uinSize" + paramList.size() + " needDeleteItem:" + paramBoolean);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        int i = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getConversationFacade().a(str, 10008);
        if (paramBoolean) {
          ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, 1044, str, ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin());
        }
        if (i > 0)
        {
          RFLog.d("QCircleChatUtil", RFLog.USR, "setRead uin" + str + " unreadCount:" + i);
          ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageFacade().a(str, 10008, true, false);
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return 10008 == paramInt;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      RFLog.e("QCircleChatUtil", RFLog.CLR, new Object[] { "getIceBreakMsgHasShownFromSp with null app or empty friendUin:", paramString });
      return false;
    }
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_icebreak_has_shown_key_" + paramString, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, List<MessageRecord> paramList)
  {
    boolean bool2;
    if ((paramList == null) || (paramList.size() == 0)) {
      bool2 = true;
    }
    boolean bool1;
    do
    {
      return bool2;
      paramList = paramList.iterator();
      bool1 = true;
      bool2 = bool1;
    } while (!paramList.hasNext());
    Object localObject = (MessageRecord)paramList.next();
    if ((localObject instanceof MessageForUniteGrayTip))
    {
      localObject = (MessageForUniteGrayTip)localObject;
      if (((MessageForUniteGrayTip)localObject).tipParam.b == 656395) {
        paramQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageForUniteGrayTip)localObject).msgtype, ((MessageForUniteGrayTip)localObject).uniseq);
      }
    }
    for (;;)
    {
      break;
      if ((localObject instanceof MessageForQCircleIceBreak))
      {
        localObject = (MessageForQCircleIceBreak)localObject;
        paramQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageForQCircleIceBreak)localObject).msgtype, ((MessageForQCircleIceBreak)localObject).uniseq);
      }
      else if (!((MessageRecord)localObject).isSelf())
      {
        bool1 = false;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return false;
      } while ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip)));
      paramQQAppInterface = (MessageForUniteGrayTip)paramMessageRecord;
    } while ((paramQQAppInterface.tipParam.b != 656395) || (paramString.equals(paramQQAppInterface.tipParam.d)));
    paramQQAppInterface.tipParam.d = paramString;
    paramQQAppInterface.msg = paramString;
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (a(paramMessageRecord.istroop));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil
 * JD-Core Version:    0.7.0.1
 */