package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xa4.submsgtype0xa4.MsgBody;

public class SubType0xa4
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    Object localObject2;
    boolean bool1;
    try
    {
      Object localObject1 = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
      if ((localObject1 != null) && (((List)localObject1).size() >= 1))
      {
        localObject1 = ((ActivityManager.RunningTaskInfo)((List)localObject1).get(0)).topActivity.getClassName();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleMsgType0x210SubMsgType0xa4 : curActivity: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject2).toString());
        }
        bool1 = "com.tencent.mobileqq.activity.QQBrowserActivity".equals(localObject1);
      }
      else
      {
        bool1 = false;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get curActivity.");
      }
      localException1.printStackTrace();
      bool1 = false;
    }
    boolean bool2;
    try
    {
      bool2 = ((PowerManager)paramQQAppInterface.getApp().getSystemService("power")).isScreenOn();
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to get screen on.");
      }
      localException2.printStackTrace();
      bool2 = true;
    }
    if ((!bool2) || ((paramQQAppInterface.isBackgroundPause) && (!bool1))) {
      localObject2 = new submsgtype0xa4.MsgBody();
    }
    for (;;)
    {
      try
      {
        ((submsgtype0xa4.MsgBody)localObject2).mergeFrom(paramMsgType0x210.vProtobuf);
        if (!((submsgtype0xa4.MsgBody)localObject2).bytes_title.has()) {
          break label541;
        }
        paramMsgType0x210 = ((submsgtype0xa4.MsgBody)localObject2).bytes_title.get().toStringUtf8();
        if (!((submsgtype0xa4.MsgBody)localObject2).bytes_brief.has()) {
          break label546;
        }
        str = ((submsgtype0xa4.MsgBody)localObject2).bytes_brief.get().toStringUtf8();
        if (!((submsgtype0xa4.MsgBody)localObject2).bytes_url.has()) {
          break label552;
        }
        localObject2 = ((submsgtype0xa4.MsgBody)localObject2).bytes_url.get().toStringUtf8();
        if ((!TextUtils.isEmpty(paramMsgType0x210)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleMsgType0x210SubMsgType0xa4 : title: ");
            ((StringBuilder)localObject3).append(paramMsgType0x210);
            ((StringBuilder)localObject3).append(", brief: ");
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append(", url:");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject3).toString());
          }
          Object localObject3 = new Intent(paramQQAppInterface.getApp(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("url", (String)localObject2);
          ((Intent)localObject3).putExtra("uintype", 3001);
          localObject2 = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
          ((ToServiceMsg)localObject2).extraData.putStringArray("cmds", new String[] { str, paramMsgType0x210, str });
          ((ToServiceMsg)localObject2).extraData.putParcelable("intent", (Parcelable)localObject3);
          ((ToServiceMsg)localObject2).extraData.putParcelable("bitmap", null);
          paramQQAppInterface.sendToService((ToServiceMsg)localObject2);
          ReportController.b(null, "dc00898", "", "", "0X8006425", "0X8006425", 0, 0, "", "", "", "");
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xa4 : fail to parse 0x210_0xa4.");
        }
        paramQQAppInterface.printStackTrace();
      }
      return;
      label541:
      paramMsgType0x210 = null;
      continue;
      label546:
      String str = null;
      continue;
      label552:
      localObject2 = null;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa4
 * JD-Core Version:    0.7.0.1
 */