package com.tencent.mobileqq.activity.aio.qcircle;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class QCircleChatUtil
{
  public static Pair<Integer, List<String>> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!(MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof QQAppInterface)) {
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    return a(((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageProxy(10008).b(AppConstants.QCIRCLE_CHAT_UIN, 10008));
  }
  
  public static Pair<Integer, List<String>> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (paramList == null)
    {
      QLog.i("QCircleChatUtil", 1, "getQCircleChatList null");
      return new Pair(Integer.valueOf(0), localArrayList);
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      String str = localMessageRecord.senderuin;
      int j = localMessageRecord.istroop;
      int k = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getConversationFacade().a(str, j);
      j = i + k;
      i = j;
      if (k > 0)
      {
        localArrayList.add(str);
        i = j;
      }
    }
    paramList = new StringBuilder();
    paramList.append("getQCircleChatRedPointNum num:");
    paramList.append(i);
    paramList.append("getSenderList:");
    paramList.append(localArrayList.toString());
    QLog.i("QCircleChatUtil", 1, paramList.toString());
    return new Pair(Integer.valueOf(i), localArrayList);
  }
  
  public static MessageForQCircleIceBreak a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      paramString = b(paramQQAppInterface, paramString, paramInt, paramArrayOfByte, paramMessageRecord);
      if (!MessageHandlerUtils.a(paramQQAppInterface, paramString, false)) {
        paramQQAppInterface.getMessageFacade().a(paramString, paramQQAppInterface.getCurrentAccountUin(), false, false, true, true);
      }
      return paramString;
    }
    return null;
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleChatUtil", 2, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, MessageRecordUtil.a(paramString2) }));
    }
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      long l2 = MessageCache.c();
      long l1;
      if (paramMessageRecord != null) {
        l1 = paramMessageRecord.shmsgseq;
      } else {
        l1 = Math.abs(new Random().nextInt());
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleChatUtil", 2, "addGrayTipsMessage start add tip message");
      }
      paramString1 = new UniteGrayTipParam(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5022, 656395, l2);
      paramString1.p = paramString2;
      paramString1.g = paramString2;
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l1;
      paramString2.mNeedTimeStamp = false;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2);
      return paramString2;
    }
    return null;
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
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      QLog.d("QCircleChatUtil", 2, new Object[] { "setIceBreakMsgHasShownToSp friendUin:", paramString });
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
      if (paramQQAppInterface != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sp_icebreak_has_shown_key_");
        localStringBuilder.append(paramString);
        paramQQAppInterface.putBoolean(localStringBuilder.toString(), true).apply();
      }
      return;
    }
    QLog.e("QCircleChatUtil", 2, new Object[] { "setIceBreakMsgHasShownToSp with null app or empty friendUin:", paramString });
  }
  
  public static void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", paramString);
    localHashMap.put("key_jump_from", "6");
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.context, "openmainpage", localHashMap);
  }
  
  public static void a(List<String> paramList, boolean paramBoolean)
  {
    if (((MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof QQAppInterface)) && (paramList != null))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRead uinSize");
      ((StringBuilder)localObject).append(paramList.size());
      ((StringBuilder)localObject).append(" needDeleteItem:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QCircleChatUtil", 1, ((StringBuilder)localObject).toString());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        int i = ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getConversationFacade().a((String)localObject, 10008);
        if (paramBoolean) {
          ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageFacade().a(AppConstants.MATCH_CHAT_UIN, 1044, (String)localObject, ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getCurrentAccountUin());
        }
        if (i > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setRead uin");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" unreadCount:");
          localStringBuilder.append(i);
          QLog.d("QCircleChatUtil", 1, localStringBuilder.toString());
          ((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getMessageFacade().a((String)localObject, 10008, true, false);
        }
      }
      return;
    }
    QLog.e("QCircleChatUtil", 1, "clearUnRead param error");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, List<MessageRecord> paramList)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return true;
      }
      paramList = paramList.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break;
        }
        Object localObject = (MessageRecord)paramList.next();
        if ((localObject instanceof MessageForUniteGrayTip))
        {
          localObject = (MessageForUniteGrayTip)localObject;
          if (((MessageForUniteGrayTip)localObject).tipParam.i == 656395) {
            paramQQAppInterface.getMessageFacade().a(paramString, paramInt, ((MessageForUniteGrayTip)localObject).msgtype, ((MessageForUniteGrayTip)localObject).uniseq);
          }
        }
        else if ((localObject instanceof MessageForQCircleIceBreak))
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
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramMessageRecord == null) {
        return false;
      }
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        return false;
      }
      paramQQAppInterface = (MessageForUniteGrayTip)paramMessageRecord;
      if ((paramQQAppInterface.tipParam.i == 656395) && (!paramString.equals(paramQQAppInterface.tipParam.p)))
      {
        paramQQAppInterface.tipParam.p = paramString;
        paramQQAppInterface.msg = paramString;
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (b(paramMessageRecord.istroop));
  }
  
  @NotNull
  static MessageForQCircleIceBreak b(QQAppInterface paramQQAppInterface, String paramString, int paramInt, byte[] paramArrayOfByte, MessageRecord paramMessageRecord)
  {
    MessageForQCircleIceBreak localMessageForQCircleIceBreak = (MessageForQCircleIceBreak)MessageRecordFactory.a(-7013);
    long l2 = MessageCache.c();
    long l1;
    if (paramMessageRecord != null)
    {
      l1 = paramMessageRecord.shmsgseq;
      l2 = paramMessageRecord.time;
      l1 -= 1L;
      l2 -= 5L;
    }
    else
    {
      l1 = Math.abs(new Random().nextInt());
      l2 -= 5L;
    }
    localMessageForQCircleIceBreak.init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramQQAppInterface.getCurrentAccountUin(), "", l2, -7013, paramInt, l1);
    localMessageForQCircleIceBreak.isread = true;
    localMessageForQCircleIceBreak.shmsgseq = l1;
    try
    {
      localMessageForQCircleIceBreak.saveExtInfoToExtStr("qcircle_chat_msg_data_key", new String(paramArrayOfByte, "utf-8"));
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QCircleChatUtil", 4, String.format(Locale.getDefault(), "addIceBreakMessage in seq %s  time %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }));
    }
    return localMessageForQCircleIceBreak;
  }
  
  public static boolean b(int paramInt)
  {
    return 10008 == paramInt;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_icebreak_has_shown_key_");
      localStringBuilder.append(paramString);
      return paramQQAppInterface.getBoolean(localStringBuilder.toString(), false);
    }
    QLog.e("QCircleChatUtil", 2, new Object[] { "getIceBreakMsgHasShownFromSp with null app or empty friendUin:", paramString });
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    return 10007 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qcircle.QCircleChatUtil
 * JD-Core Version:    0.7.0.1
 */