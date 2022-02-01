package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class DefaultMsgDecoder
  implements IMessageDecoder
{
  private void a(Message paramMessage)
  {
    StringBuilder localStringBuilder2 = new StringBuilder(paramMessage.msg);
    String str = paramMessage.getExtInfoFromExtStr("disc_at_info_list");
    Object localObject = localStringBuilder2;
    StringBuilder localStringBuilder1;
    if (paramMessage.istroop == 3000)
    {
      localObject = localStringBuilder2;
      if (!TextUtils.isEmpty(str)) {
        try
        {
          localObject = BaseApplicationImpl.sApplication.getRuntime();
          if (QQAppInterface.class.isInstance(localObject))
          {
            localObject = AtTroopMemberSpan.a((QQAppInterface)localObject, localStringBuilder2, str, paramMessage.frienduin, paramMessage.isSend());
          }
          else
          {
            localObject = localStringBuilder2;
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
              localObject = localStringBuilder2;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("Q.msg.BaseMessageManager", 1, "replaceAtMsgByMarkName", localException);
          localStringBuilder1 = localStringBuilder2;
        }
      }
    }
    if (paramMessage.msgtype == -1000)
    {
      paramMessage.emoRecentMsg = new QQText(MsgUtils.c(localStringBuilder1.toString()), 3, 16);
      return;
    }
    paramMessage.emoRecentMsg = new QQText(localStringBuilder1, 3, 16);
  }
  
  private void a(Message paramMessage, String paramString, AppRuntime paramAppRuntime)
  {
    paramString = paramString.split("\026")[1].split("\\|");
    if (paramString == null) {
      return;
    }
    int i;
    if (paramString.length < 2) {
      i = 1;
    } else {
      i = Integer.valueOf(paramString[2]).intValue();
    }
    paramMessage.fileType = i;
    try
    {
      long l;
      if (paramString.length < 2) {
        l = -1L;
      } else {
        l = Long.valueOf(paramString[1]).longValue();
      }
      paramMessage.fileSize = l;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", localException);
      }
      paramMessage.fileSize = -1L;
    }
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {
            return;
          }
          if (i == 65538) {}
        }
        else
        {
          paramMessage.msg = paramAppRuntime.getApp().getString(2131888237);
          paramMessage.pttUrl = paramString[0];
          return;
        }
      }
      if (paramMessage.msgtype == -3001)
      {
        paramMessage.msg = paramAppRuntime.getApp().getString(2131892404);
        return;
      }
      paramMessage.msg = paramAppRuntime.getApp().getString(2131890793);
    }
    else
    {
      paramMessage.msg = paramAppRuntime.getApp().getString(2131889249);
    }
  }
  
  private void a(Message paramMessage, AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppRuntime.getApp().getString(2131888237));
    localStringBuilder.append("(0x7f)");
    paramMessage.msg = localStringBuilder.toString();
  }
  
  private boolean a(String paramString)
  {
    if (paramString.charAt(0) == '\026')
    {
      paramString = paramString.split("\026")[1].split("\\|");
      if (paramString.length < 2) {
        return true;
      }
      if (paramString.length <= 3) {}
    }
    try
    {
      Long.valueOf(paramString[1]);
      Integer.valueOf(paramString[2]);
      Boolean.valueOf(paramString[3]);
      return true;
    }
    catch (NumberFormatException paramString) {}
    return false;
    return false;
  }
  
  private void b(Message paramMessage, AppRuntime paramAppRuntime)
  {
    MessageForQQWalletTips localMessageForQQWalletTips = new MessageForQQWalletTips();
    localMessageForQQWalletTips.init(paramMessage.selfuin, paramMessage.frienduin, paramMessage.senderuin, "[QQWallet Tips]", MessageCache.c(), paramMessage.msgtype, paramMessage.istroop, MessageCache.c());
    localMessageForQQWalletTips.msgData = paramMessage.msgData;
    localMessageForQQWalletTips.isread = true;
    localMessageForQQWalletTips.parse();
    localMessageForQQWalletTips.buildQQWalletTips((QQAppInterface)paramAppRuntime, paramAppRuntime.getApp(), null);
    paramMessage.msg = localMessageForQQWalletTips.summary;
  }
  
  public void a(Message paramMessage, IMessageManager paramIMessageManager, AppRuntime paramAppRuntime)
  {
    if (paramMessage.msg != null)
    {
      paramIMessageManager = paramMessage.msg;
      Object localObject = "";
      if ("".equals(paramIMessageManager)) {
        return;
      }
      paramIMessageManager = paramMessage.msg;
      if (a(paramIMessageManager))
      {
        a(paramMessage, paramIMessageManager, paramAppRuntime);
        return;
      }
      if (paramMessage.msgtype == -2006)
      {
        a(paramMessage, paramAppRuntime);
        return;
      }
      if (paramMessage.msgtype == -2008)
      {
        paramMessage.msg = paramAppRuntime.getApp().getString(2131916156);
        return;
      }
      if (paramMessage.msg.indexOf("http://maps.google.com/maps?q=") != -1)
      {
        String[] arrayOfString = MessageUtils.a(paramMessage.msg);
        paramIMessageManager = (IMessageManager)localObject;
        if (arrayOfString != null)
        {
          paramIMessageManager = (IMessageManager)localObject;
          if (arrayOfString[2] != null) {
            paramIMessageManager = arrayOfString[2];
          }
        }
        paramMessage.fileType = 65536;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(paramAppRuntime.getApp().getString(2131917343));
        ((StringBuilder)localObject).append("] ");
        ((StringBuilder)localObject).append(paramIMessageManager);
        paramMessage.msg = ((StringBuilder)localObject).toString();
        return;
      }
      if (paramMessage.msgtype == -2029)
      {
        b(paramMessage, paramAppRuntime);
        return;
      }
      if (paramMessage.msgtype == -2068)
      {
        paramIMessageManager = new MessageForDarenAssistant();
        paramIMessageManager.msgData = paramMessage.msgData;
        paramIMessageManager.parse();
        paramMessage.msg = paramIMessageManager.msg;
        return;
      }
      if (ReactivePushHelper.a((QQAppInterface)paramAppRuntime, paramMessage))
      {
        paramMessage.emoRecentMsg = ReactivePushHelper.a(paramAppRuntime.getApp(), paramMessage.msg);
        return;
      }
      a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.decoder.DefaultMsgDecoder
 * JD-Core Version:    0.7.0.1
 */