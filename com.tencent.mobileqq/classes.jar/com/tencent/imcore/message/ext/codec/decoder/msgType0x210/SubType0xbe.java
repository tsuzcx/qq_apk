package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;

public class SubType0xbe
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe");
    }
    Object localObject = new SubMsgType0xbe.MsgBody();
    try
    {
      ((SubMsgType0xbe.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : msg has not uint64_group_code");
        }
        return;
      }
      try
      {
        paramArrayOfByte = new JSONObject();
        if (((SubMsgType0xbe.MsgBody)localObject).uint64_uin.has()) {
          paramArrayOfByte.put("uin", ((SubMsgType0xbe.MsgBody)localObject).uint64_uin.get());
        }
        if (((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has()) {
          paramArrayOfByte.put("groupCode", ((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.get());
        }
        if (((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.has()) {
          paramArrayOfByte.put("notifyType", ((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.get());
        }
        if (((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.has()) {
          paramArrayOfByte.put("onlineLevel", ((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.get());
        }
        if (((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.has())
        {
          JSONArray localJSONArray = new JSONArray();
          localObject = ((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            SubMsgType0xbe.Medal localMedal = (SubMsgType0xbe.Medal)((Iterator)localObject).next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", localMedal.uint32_id.get());
            localJSONObject.put("level", localMedal.uint32_level.get());
            localJSONObject.put("type", localMedal.uint32_type.get());
            localJSONObject.put("iconUrl", localMedal.str_icon_url.get());
            localJSONObject.put("flashUrl", localMedal.str_flash_url.get());
            localJSONObject.put("name", localMedal.str_name.get());
            localJSONArray.put(localJSONObject);
          }
          paramArrayOfByte.put("medalList", localJSONArray);
        }
        paramQQAppInterface.getGAudioHandler().a(paramArrayOfByte.toString());
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label349:
      break label349;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : fail to parse submsgtype0xbe.");
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xbe
 * JD-Core Version:    0.7.0.1
 */