package com.tencent.mobileqq.app.notification;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

public class MessageBriefGenerator
{
  @Nullable
  public static String a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (ActionMsgUtil.d(paramMessage.msgtype)) {
      return EmosmUtils.a(paramQQAppInterface.getApp(), paramMessage);
    }
    if (paramMessage.msgtype == -2009) {
      return paramQQAppInterface.getMessageFacade().b(paramQQAppInterface.getApp(), paramMessage, true);
    }
    if (paramMessage.msgtype == -2040)
    {
      paramQQAppInterface = new MessageForApproval();
      paramQQAppInterface.msgData = paramMessage.msgData;
      return paramQQAppInterface.getFullTitle();
    }
    if (paramMessage.msgtype == -2041)
    {
      paramMessage = paramQQAppInterface.getApp().getString(2131690113);
      paramQQAppInterface = paramQQAppInterface.getApp().getString(2131690112);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMessage);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      return ((StringBuilder)localObject).toString();
    }
    if (paramMessage.msgtype == -2011) {
      return a(paramQQAppInterface, paramMessage, "");
    }
    if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessage)) {
      return paramQQAppInterface.getApp().getString(2131691283);
    }
    if (paramMessage.msgtype == -7001) {
      return paramQQAppInterface.getApp().getString(2131694329);
    }
    if (paramMessage.msgtype == -2052)
    {
      paramQQAppInterface = new MessageForQQStoryComment();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.parse();
      return paramQQAppInterface.getSummaryMsg();
    }
    if (paramMessage.msgtype == -2057) {
      return MessageForTroopStory.MSG_CONTENT;
    }
    if (paramMessage.msgtype == -2059)
    {
      paramQQAppInterface = new MessageForTroopPobing();
      paramQQAppInterface.msgData = paramMessage.msgData;
      paramQQAppInterface.doParse();
      return paramQQAppInterface.getSummaryMsg();
    }
    Object localObject = paramMessage.getMessageText();
    ITroopRobotService localITroopRobotService = (ITroopRobotService)paramQQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    if (localITroopRobotService.hasRobotNewsClassId(paramMessage))
    {
      if (!localITroopRobotService.hasProcessedMoreDetail(paramMessage)) {
        localITroopRobotService.preProcessMessageMoreDetail(paramMessage);
      }
      paramQQAppInterface = localITroopRobotService.generateMoreDetailMsg(paramMessage);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        break label378;
      }
    }
    else if ((paramMessage.msgtype == -5040) && (ReactivePushHelper.a(paramQQAppInterface, paramMessage)))
    {
      paramQQAppInterface = ReactivePushHelper.a(paramMessage.msg);
      break label378;
    }
    paramQQAppInterface = (QQAppInterface)localObject;
    label378:
    paramMessage = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      paramMessage = "";
    }
    if ((paramMessage instanceof QQText)) {
      return ((QQText)paramMessage).toPlainText();
    }
    return new QQText(paramMessage.toString(), 3).toPlainText();
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Message paramMessage, String paramString)
  {
    try
    {
      paramMessage = StructMsgFactory.a(paramMessage.msgData);
      if (paramMessage == null)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, "showInComingMsg,getStructMsg is null");
          return paramString;
        }
      }
      else
      {
        if (paramMessage.mMsgServiceID == 61) {
          paramQQAppInterface = paramQQAppInterface.getApp().getResources().getString(2131698751);
        } else if (paramMessage.mMsgServiceID == 107) {
          paramQQAppInterface = paramQQAppInterface.getApp().getResources().getString(2131698563);
        } else {
          paramQQAppInterface = paramMessage.mMsgBrief;
        }
        return paramQQAppInterface;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("showInComingMsg,getStructMsg error:");
        paramMessage.append(paramQQAppInterface.getMessage());
        QLog.d("StructMsg", 2, paramMessage.toString(), paramQQAppInterface);
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.MessageBriefGenerator
 * JD-Core Version:    0.7.0.1
 */