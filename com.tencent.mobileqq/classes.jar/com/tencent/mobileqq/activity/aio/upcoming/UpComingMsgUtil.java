package com.tencent.mobileqq.activity.aio.upcoming;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.messageclean.MessageTypeUtils;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class UpComingMsgUtil
{
  private static int a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp != null)
    {
      Object localObject = paramMessageForArkApp.ark_app_message;
      if (localObject != null)
      {
        paramMessageForArkApp = ((ArkAppMessage)localObject).appName;
        localObject = ((ArkAppMessage)localObject).appView;
        if ((!android.text.TextUtils.isEmpty(paramMessageForArkApp)) && (!android.text.TextUtils.isEmpty((CharSequence)localObject)))
        {
          if ("com.tencent.map".equals(paramMessageForArkApp)) {
            return 10;
          }
          if (("com.tencent.miniapp_01".equals(paramMessageForArkApp)) || (("com.tencent.structmsg".equals(paramMessageForArkApp)) && ("news".equals(localObject)))) {
            return 9;
          }
        }
      }
    }
    return 6;
  }
  
  public static long a(ColorNote paramColorNote)
  {
    long l2 = a(paramColorNote, 0);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis() + 1000L;
    }
    return l1;
  }
  
  private static long a(ColorNote paramColorNote, int paramInt)
  {
    try
    {
      paramColorNote = c(paramColorNote);
      if ((paramColorNote != null) && (paramColorNote.length > 0) && (paramInt < paramColorNote.length))
      {
        long l = Long.valueOf(paramColorNote[paramInt]).longValue();
        return l;
      }
    }
    catch (Exception paramColorNote)
    {
      QLog.d("UpComingMsgLogic.", 1, "parseMindTimeFromEntity error!", paramColorNote);
    }
    return 0L;
  }
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    String str = "";
    if (paramMessageRecord == null)
    {
      if (paramQQAppInterface == null) {
        return "";
      }
      return paramQQAppInterface.getCurrentAccountUin();
    }
    if (paramMessageRecord.msg != null) {
      str = paramMessageRecord.msg;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("message type = ");
      localStringBuilder.append(paramMessageRecord.msgtype);
      localStringBuilder.append(", result = ");
      localStringBuilder.append(str);
      QLog.d("UpComingMsgLogic.UpComingMsgUtil", 2, localStringBuilder.toString());
    }
    if ((paramMessageRecord.msgtype != -2000) && (paramMessageRecord.msgtype != -5015) && (paramMessageRecord.msgtype != -2007))
    {
      if (paramMessageRecord.msgtype == -1031) {
        return "[语音]";
      }
      if (paramMessageRecord.msgtype == -2002) {
        return c(paramMessageRecord);
      }
      if (paramMessageRecord.msgtype == -2017)
      {
        if ((paramMessageRecord instanceof MessageForTroopFile))
        {
          paramQQAppInterface = (MessageForTroopFile)paramMessageRecord;
          if (!android.text.TextUtils.isEmpty(paramQQAppInterface.fileName))
          {
            paramMessageRecord = new StringBuilder();
            paramMessageRecord.append("[文件]");
            paramMessageRecord.append(paramQQAppInterface.fileName);
            return paramMessageRecord.toString();
          }
        }
        return "[文件]";
      }
      if (paramMessageRecord.msgtype == -2005) {
        return FileManagerUtil.a(paramQQAppInterface, paramMessageRecord);
      }
      if (paramMessageRecord.msgtype == -3017)
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("[文件]");
        paramQQAppInterface.append(((MessageForDLFile)paramMessageRecord).fileName);
        return paramQQAppInterface.toString();
      }
      if (ActionMsgUtil.a(paramMessageRecord.msgtype))
      {
        paramQQAppInterface = "[分享]";
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("[分享]");
          paramQQAppInterface.append(((MessageForStructing)paramMessageRecord).getSummaryMsg());
          return paramQQAppInterface.toString();
        }
      }
      else
      {
        if (paramMessageRecord.msgtype == -2022) {
          return "[视频]";
        }
        if (paramMessageRecord.msgtype == -2011)
        {
          paramQQAppInterface = str;
          if ((paramMessageRecord instanceof MessageForStructing))
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append(str);
            paramQQAppInterface.append(((MessageForStructing)paramMessageRecord).getSummaryMsg());
            return paramQQAppInterface.toString();
          }
        }
        else
        {
          paramQQAppInterface = str;
          if (paramMessageRecord.msgtype == -8018)
          {
            paramQQAppInterface = str;
            if ((paramMessageRecord instanceof MessageForAniSticker)) {
              return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(((MessageForAniSticker)paramMessageRecord).sevrId));
            }
          }
        }
      }
    }
    else
    {
      paramQQAppInterface = "[图片]";
    }
    return paramQQAppInterface;
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean)
  {
    if ((paramBaseActivity != null) && (!paramBoolean))
    {
      Intent localIntent = paramBaseActivity.getIntent();
      if ((localIntent != null) && (localIntent.getBooleanExtra("flag_open_up_coming_list", false)))
      {
        localIntent.removeExtra("flag_open_up_coming_list");
        ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).showListFromAddTodo(paramBaseActivity, true);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        bool1 = bool2;
        if (paramInt != 1000)
        {
          bool1 = bool2;
          if (paramInt != 3000)
          {
            bool1 = bool2;
            if (paramInt != 1004)
            {
              if (paramInt == 1006) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(MessageForStructing paramMessageForStructing)
  {
    boolean bool2 = false;
    if (paramMessageForStructing == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramMessageForStructing.structingMsg != null)
    {
      bool1 = bool2;
      if ("viewMultiMsg".equals(paramMessageForStructing.structingMsg.mMsgAction)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    int i = paramMessageRecord.istroop;
    boolean bool = true;
    if ((1 == i) || (3000 == paramMessageRecord.istroop))
    {
      if (paramMessageRecord.extraflag == 32772) {
        return paramMessageRecord.isValid;
      }
      if (paramMessageRecord.msgtype != -2006) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static int b(MessageRecord paramMessageRecord)
  {
    boolean bool = paramMessageRecord instanceof MessageForText;
    int i = 6;
    if ((!bool) && (!(paramMessageRecord instanceof MessageForLongMsg)))
    {
      if ((paramMessageRecord instanceof MessageForPic)) {
        return 2;
      }
      if ((paramMessageRecord instanceof MessageForArkApp)) {
        return a((MessageForArkApp)paramMessageRecord);
      }
      if ((paramMessageRecord instanceof MessageForPtt)) {
        return 3;
      }
      if ((paramMessageRecord instanceof MessageForMixedMsg)) {
        return 4;
      }
      if ((!(paramMessageRecord instanceof MessageForFile)) && (!(paramMessageRecord instanceof MessageForTroopFile)) && (!(paramMessageRecord instanceof MessageForDeviceFile)) && (!(paramMessageRecord instanceof MessageForDLFile)))
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          if (a((MessageForStructing)paramMessageRecord)) {
            return 11;
          }
        }
        else
        {
          if (MessageTypeUtils.a(paramMessageRecord)) {
            return 6;
          }
          return 7;
        }
      }
      else {
        return d(paramMessageRecord);
      }
    }
    else
    {
      if (com.tencent.mobileqq.text.TextUtils.isAllSystemEmotcation(paramMessageRecord.msg)) {
        return 12;
      }
      i = 1;
    }
    return i;
  }
  
  public static UpComingMsgModel b(ColorNote paramColorNote)
  {
    if ((paramColorNote != null) && (paramColorNote.getServiceType() == 17235968))
    {
      paramColorNote = new String(paramColorNote.getReserve());
      UpComingMsgModel localUpComingMsgModel = new UpComingMsgModel();
      localUpComingMsgModel.parseFromJson(paramColorNote);
      return localUpComingMsgModel;
    }
    return new UpComingMsgModel();
  }
  
  private static String c(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      if (paramMessageRecord.hasSttTxt())
      {
        paramMessageRecord = paramMessageRecord.sttText;
        break label30;
      }
    }
    paramMessageRecord = "";
    label30:
    Object localObject = paramMessageRecord;
    if (android.text.TextUtils.isEmpty(paramMessageRecord)) {
      localObject = "[语音]";
    }
    return localObject;
  }
  
  private static String[] c(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      paramColorNote = paramColorNote.getSubType();
      if (!android.text.TextUtils.isEmpty(paramColorNote))
      {
        paramColorNote = paramColorNote.split("_");
        if (paramColorNote.length == 2) {
          return paramColorNote;
        }
      }
    }
    return new String[0];
  }
  
  private static int d(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile))
    {
      if (FileManagerUtil.c(((MessageForFile)paramMessageRecord).fileName) == 0) {
        return 2;
      }
    }
    else if ((paramMessageRecord instanceof MessageForDeviceFile))
    {
      if (2 == ((MessageForDeviceFile)paramMessageRecord).nFileMsgType) {
        return 2;
      }
    }
    else if (((paramMessageRecord instanceof MessageForTroopFile)) && (FileManagerUtil.c(((MessageForTroopFile)paramMessageRecord).fileName) == 0)) {
      return 2;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgUtil
 * JD-Core Version:    0.7.0.1
 */