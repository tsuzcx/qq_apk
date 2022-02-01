package com.tencent.imcore.message.msgproxy;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.MsgProxyUtils.Callback;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;

public class MsgProxyUtilsCallback
  implements MsgProxyUtils.Callback
{
  static String[] a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0) && (paramString.charAt(0) == '\026')) {
      return paramString.split("\\|");
    }
    return null;
  }
  
  public int a()
  {
    return 480;
  }
  
  public MessageRecord a(ArrayList<MessageRecord> paramArrayList)
  {
    return new MessageForLongMsg(paramArrayList);
  }
  
  public void a(Exception paramException, List<MessageRecord> paramList)
  {
    CaughtExceptionReport.a(paramException, " addToTailWhenException ");
  }
  
  public boolean a(int paramInt)
  {
    return MessageUtils.b(paramInt);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return AnonymousChatHelper.f(paramMessageRecord);
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return ((paramMessageRecord2 instanceof MessageForUniteGrayTip)) && ((paramMessageRecord1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramMessageRecord2).tipParam.n > ((MessageForUniteGrayTip)paramMessageRecord1).tipParam.n);
  }
  
  public boolean a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString1, String paramString2)
  {
    int i = paramMessageRecord2.msgtype;
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool2 = false;
    if (i == -2002)
    {
      if (((paramMessageRecord2 instanceof MessageForPtt)) && ((paramMessageRecord1 instanceof MessageForPtt)))
      {
        paramMessageRecord1 = (MessageForPtt)paramMessageRecord1;
        if ((paramMessageRecord1.urlAtServer != null) && (paramMessageRecord1.urlAtServer.length() > 0))
        {
          paramMessageRecord2 = (MessageForPtt)paramMessageRecord2;
          if ((paramMessageRecord2.urlAtServer != null) && (paramMessageRecord2.urlAtServer.length() > 0)) {
            return paramMessageRecord1.urlAtServer.equals(paramMessageRecord2.urlAtServer);
          }
        }
      }
      return false;
    }
    if (paramMessageRecord2.msgtype == -2011)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("c2c");
        paramString1.append(Arrays.toString(paramMessageRecord1.msgData));
        paramString1.append(" : ");
        paramString1.append(Arrays.toString(paramMessageRecord2.msgData));
        QLog.d("Debug", 2, paramString1.toString());
      }
      return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
    }
    if (paramMessageRecord2.msgtype == -2000)
    {
      if ((paramString1 != null) && (paramString2 != null) && (paramString1.length() > 0) && (paramString2.length() > 0) && (paramString1.charAt(0) == '\026') && (paramString2.charAt(0) == '\026'))
      {
        paramMessageRecord1 = a(paramString2);
        paramString2 = a(paramString1);
        if (paramMessageRecord1 != null)
        {
          if (paramString2 == null) {
            return false;
          }
          if (paramMessageRecord1[1].equals(paramString2[1]))
          {
            if (!paramMessageRecord1[2].equals(paramString2[2])) {
              return false;
            }
            if ((paramMessageRecord2.issend != 2) && (!paramMessageRecord2.isSendFromLocal()))
            {
              if (paramString1.contains(AppConstants.SDCARD_PATH))
              {
                paramMessageRecord2 = paramString2[0].split("/");
                paramString1 = paramMessageRecord2[(paramMessageRecord2.length - 1)].split("\\.")[0];
                paramMessageRecord2 = MD5.toMD5(paramMessageRecord1[4]);
                if (!paramMessageRecord2.equals(paramString1)) {
                  break label1346;
                }
                if (QLog.isColorLevel())
                {
                  paramString1 = new StringBuilder();
                  paramString1.append("-------->compMsgContent: samePic: picSize:");
                  paramString1.append(paramMessageRecord1[1]);
                  paramString1.append(",picType:");
                  paramString1.append(paramMessageRecord1[2]);
                  paramString1.append(",Path:");
                  paramString1.append(paramMessageRecord2);
                  QLog.d("Q.msg.MsgProxyUtils", 2, paramString1.toString());
                }
                return true;
              }
              return paramString2[0].equals(paramMessageRecord1[0]);
            }
            if (QLog.isColorLevel())
            {
              paramMessageRecord2 = new StringBuilder();
              paramMessageRecord2.append("-------->compMsgContent: samePic: picSize:");
              paramMessageRecord2.append(paramMessageRecord1[1]);
              paramMessageRecord2.append(",picType:");
              paramMessageRecord2.append(paramMessageRecord1[2]);
              paramMessageRecord2.append(",isSend == true");
              QLog.d("Q.msg.MsgProxyUtils", 2, paramMessageRecord2.toString());
            }
            return true;
          }
        }
        return false;
      }
      else
      {
        paramMessageRecord1 = (MessageForPic)paramMessageRecord1;
        if ((paramMessageRecord1.uuid != null) && (paramMessageRecord1.uuid.length() > 0))
        {
          paramMessageRecord2 = (MessageForPic)paramMessageRecord2;
          if ((paramMessageRecord2.uuid != null) && (paramMessageRecord2.uuid.length() > 0)) {
            return paramMessageRecord1.uuid.equals(paramMessageRecord2.uuid);
          }
        }
        return false;
      }
    }
    else
    {
      if ((paramMessageRecord2.msgtype == -2007) && (paramMessageRecord1.msgtype == -2007)) {
        return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
      }
      if ((paramMessageRecord2.msgtype == -8018) && (paramMessageRecord1.msgtype == -8018)) {
        return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
      }
      if ((paramMessageRecord2.msgtype == -2058) && (paramMessageRecord1.msgtype == -2058))
      {
        if ((((paramMessageRecord2 instanceof MessageForMarketFace)) && ((paramMessageRecord1 instanceof MessageForMarketFace))) || (((paramMessageRecord2 instanceof MessageForText)) && ((paramMessageRecord1 instanceof MessageForText))) || (((paramMessageRecord2 instanceof MessageForPic)) && ((paramMessageRecord1 instanceof MessageForPic)))) {
          return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
        }
      }
      else
      {
        if ((paramMessageRecord2.msgtype == -1035) && (paramMessageRecord1.msgtype == -1035)) {
          return Arrays.equals(paramMessageRecord2.msgData, paramMessageRecord1.msgData);
        }
        if ((paramMessageRecord2.msgtype == -1034) && (paramMessageRecord1.msgtype == -1034))
        {
          bool1 = bool2;
          if (paramMessageRecord2.time == paramMessageRecord1.time)
          {
            bool1 = bool2;
            if (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq) {
              bool1 = true;
            }
          }
          return bool1;
        }
        if ((paramMessageRecord2.msgtype == -1042) && (paramMessageRecord1.msgtype == -1042))
        {
          if (paramMessageRecord2.time == paramMessageRecord1.time) {
            bool1 = true;
          }
          return bool1;
        }
        if ((paramMessageRecord2.msgtype == -2015) && (paramMessageRecord1.msgtype == -2015))
        {
          bool1 = bool3;
          if (paramMessageRecord2.time == paramMessageRecord1.time)
          {
            bool1 = bool3;
            if (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq) {
              bool1 = true;
            }
          }
          return bool1;
        }
        if ((paramMessageRecord2.msgtype == -7007) && (paramMessageRecord1.msgtype == -7007))
        {
          bool1 = bool4;
          if (paramMessageRecord2.time == paramMessageRecord1.time)
          {
            bool1 = bool4;
            if (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq) {
              bool1 = true;
            }
          }
          return bool1;
        }
        if ((paramMessageRecord2.msgtype == -2060) && (paramMessageRecord1.msgtype == -2060)) {
          return ((MessageForPLNews)paramMessageRecord2).msgEquals((MessageForPLNews)paramMessageRecord1);
        }
        if ((paramMessageRecord2.msgtype == -2065) || (paramMessageRecord2.msgtype == -2062) || (paramMessageRecord2.msgtype == -4023) || (paramMessageRecord2.msgtype == -2066) || (paramMessageRecord2.msgtype == -7009) || (paramMessageRecord2.msgtype == -7010) || (paramMessageRecord2.msgtype == -7011) || (paramMessageRecord2.msgtype == -7012) || (paramMessageRecord2.msgtype == -7013) || (paramMessageRecord2.msgtype == -7015)) {
          break label1348;
        }
        if (paramMessageRecord2.msgtype == -2005)
        {
          bool1 = bool5;
          if ((paramMessageRecord2 instanceof MessageForFile))
          {
            bool1 = bool5;
            if ((paramMessageRecord1 instanceof MessageForFile))
            {
              bool1 = bool5;
              if (paramMessageRecord2.msgUid == paramMessageRecord1.msgUid)
              {
                bool1 = bool5;
                if (paramMessageRecord2.msgseq == paramMessageRecord1.msgseq) {
                  bool1 = true;
                }
              }
            }
          }
          return bool1;
        }
        if (paramMessageRecord2.msgtype == -2017) {
          return false;
        }
        if (paramMessageRecord2.msgtype == -5008)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxyUtils", 2, new Object[] { "AAShare.compMsgContent recRecord.msgUid=", Long.valueOf(paramMessageRecord2.msgUid), ",cacheRecord.msgUid,", Long.valueOf(paramMessageRecord1.msgUid) });
          }
          bool1 = bool6;
          if (paramMessageRecord2.msgUid == paramMessageRecord1.msgUid) {
            bool1 = true;
          }
          return bool1;
        }
        if (paramMessageRecord2.msgtype == -2022)
        {
          paramMessageRecord2 = (MessageForShortVideo)paramMessageRecord2;
          if (!TextUtils.isEmpty(paramMessageRecord2.md5))
          {
            paramString1 = (MessageForShortVideo)paramMessageRecord1;
            if (!TextUtils.isEmpty(paramString1.md5)) {
              return paramString1.md5.equals(paramMessageRecord2.md5);
            }
          }
          if (!TextUtils.isEmpty(paramMessageRecord2.uuid))
          {
            paramMessageRecord1 = (MessageForShortVideo)paramMessageRecord1;
            if (!TextUtils.isEmpty(paramMessageRecord1.uuid)) {
              return paramMessageRecord1.uuid.equals(paramMessageRecord2.uuid);
            }
          }
          return false;
        }
        if (TextUtils.equals(paramString1, paramString2)) {
          return true;
        }
      }
    }
    label1346:
    return false;
    label1348:
    bool1 = bool7;
    if (paramMessageRecord2.uniseq == paramMessageRecord1.uniseq) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(AppRuntime paramAppRuntime, MessageRecord paramMessageRecord)
  {
    return ((QQAppInterface)paramAppRuntime).getConversationFacade().a(paramMessageRecord.frienduin);
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForText)) || ((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForReplyText));
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    if ((MsgProxyUtils.d(paramMessageRecord.msgtype)) && ((paramMessageRecord instanceof MessageForUniteGrayTip)))
    {
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramMessageRecord.tipParam != null) {
        return paramMessageRecord.tipParam.q;
      }
    }
    return false;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    return UniteGrayTipMsgUtil.b(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback
 * JD-Core Version:    0.7.0.1
 */