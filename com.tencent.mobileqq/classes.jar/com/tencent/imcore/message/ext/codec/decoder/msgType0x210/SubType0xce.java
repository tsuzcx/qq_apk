package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce.MsgBody;

public class SubType0xce
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xce push message ");
    }
    Object localObject = new submsgtype0xce.MsgBody();
    for (;;)
    {
      int i;
      try
      {
        ((submsgtype0xce.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = ((submsgtype0xce.MsgBody)localObject).string_params.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("yuyue(push):OnLinePushMessageProcessor receive 0xce strJson=");
          ((StringBuilder)localObject).append(paramMsgType0x210);
          QLog.i("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new JSONObject(paramMsgType0x210).optString("appid");
        String[] arrayOfString = GameCenterSpUtils.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
        int k = 0;
        i = 0;
        int j = k;
        if (i < arrayOfString.length)
        {
          if ((TextUtils.isEmpty(arrayOfString[i])) || (TextUtils.isEmpty((CharSequence)localObject)) || (!arrayOfString[i].equals(localObject))) {
            break label237;
          }
          j = 1;
        }
        if ((j == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          GameCenterUtil.a((String)localObject, "APPOINTMENT_LIST");
          GameCenterUtil.a((String)localObject, paramMsgType0x210, "APPOINT_APPID_DETAIL_");
          GameCenterBroadcastReceiver.a();
        }
        ((IQQGameCheckService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameCheckService.class, "")).checkGameCenter();
        GameCenterUtils.a(paramQQAppInterface, "426", "202136", (String)localObject, "42601", "1", "116");
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label237:
      i += 1;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xce
 * JD-Core Version:    0.7.0.1
 */