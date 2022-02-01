package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class KplRoleGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof ChatMessage))
    {
      bool = paramBoolean;
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
      {
        Object localObject = null;
        try
        {
          String str = KplHelper.a(paramQQAppInterface, paramMessageRecord.selfuin);
          paramQQAppInterface = KplHelper.a(paramQQAppInterface, paramMessageRecord.frienduin);
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put(paramMessageRecord.selfuin, str);
          localJSONObject.put(paramMessageRecord.frienduin, paramQQAppInterface);
          paramQQAppInterface = localJSONObject.toString();
          if (QLog.isColorLevel())
          {
            paramMessageRecord = new StringBuilder();
            paramMessageRecord.append("general kpl flag=");
            paramMessageRecord.append(paramQQAppInterface);
            QLog.d("KplMessage", 2, paramMessageRecord.toString());
          }
          paramQQAppInterface = paramQQAppInterface.getBytes("utf-8");
        }
        catch (Exception paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d("KplMessage", 2, "some error at MessageHandlerUtils::getGeneralFlagElemFromMsg()");
          }
          paramQQAppInterface.printStackTrace();
          paramQQAppInterface = localObject;
        }
        bool = paramBoolean;
        if (paramQQAppInterface != null)
        {
          bool = true;
          paramResvAttr.bytes_kpl_info.set(ByteStringMicro.copyFrom(paramQQAppInterface));
        }
      }
    }
    return bool;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a((QQAppInterface)paramAppInterface, paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.KplRoleGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */