package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce.MsgBody;

public class SubType0xce
  implements Msg0X210SubTypeDecoder
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xce push message ");
    }
    Object localObject = new submsgtype0xce.MsgBody();
    try
    {
      ((submsgtype0xce.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = ((submsgtype0xce.MsgBody)localObject).string_params.get();
      if (QLog.isColorLevel()) {
        WLog.c("Q.msg.BaseMessageProcessor", "yuyue(push):OnLinePushMessageProcessor receive 0xce strJson=" + paramMsgType0x210);
      }
      localObject = new JSONObject(paramMsgType0x210).optString("appid");
      String[] arrayOfString = GameCenterSpUtils.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < arrayOfString.length)
        {
          if ((!TextUtils.isEmpty(arrayOfString[i])) && (!TextUtils.isEmpty((CharSequence)localObject)) && (arrayOfString[i].equals(localObject))) {
            j = 1;
          }
        }
        else
        {
          if ((j == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            GameCenterUtils.b((String)localObject, "APPOINTMENT_LIST");
            GameCenterUtils.a((String)localObject, paramMsgType0x210, "APPOINT_APPID_DETAIL_");
            GameCenterBroadcastReceiver.a();
          }
          GameCenterCheck.a();
          GameCenterUtils.a(paramQQAppInterface, "426", "202136", (String)localObject, "42601", "1", "116");
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xce
 * JD-Core Version:    0.7.0.1
 */