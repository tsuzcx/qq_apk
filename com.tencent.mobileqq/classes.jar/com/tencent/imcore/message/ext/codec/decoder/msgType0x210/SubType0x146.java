package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.FrameAddPushNotifier;
import com.tencent.mobileqq.activity.home.OnTabFrameAddCallback;
import com.tencent.mobileqq.activity.home.TabData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x146.submsgtype0x146.TabData;

public class SubType0x146
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private TabData a(submsgtype0x146.MsgBody paramMsgBody)
  {
    submsgtype0x146.TabData localTabData = (submsgtype0x146.TabData)paramMsgBody.tab_data.get();
    TabData localTabData1 = new TabData();
    localTabData1.d = paramMsgBody.uint32_push_from.get();
    localTabData1.e = paramMsgBody.uint32_push_type.get();
    localTabData1.g = paramMsgBody.bytes_content.get().toByteArray();
    localTabData1.c = localTabData.first_show.get();
    int i = localTabData.tab_id.get();
    localTabData1.a = i;
    localTabData1.b = localTabData.tab_status.get();
    localTabData1.f = a(i);
    return localTabData1;
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return "RIJ";
      }
      return "GUILD";
    }
    return "NEW_WORLD";
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    Object localObject = new submsgtype0x146.MsgBody();
    try
    {
      ((submsgtype0x146.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      int i = ((submsgtype0x146.MsgBody)localObject).uint32_push_from.get();
      if ((i != 1) && (i != 2))
      {
        QLog.d("SubType0x146", 1, new Object[] { "unknown push from : ", Integer.valueOf(i) });
        return;
      }
      i = ((submsgtype0x146.MsgBody)localObject).uint32_push_type.get();
      if ((i != 1) && (i != 2))
      {
        QLog.d("SubType0x146", 1, new Object[] { "unknown push type : ", Integer.valueOf(i) });
        return;
      }
      MobileQQ localMobileQQ = MobileQQ.getMobileQQ();
      if (localMobileQQ == null)
      {
        QLog.d("SubType0x146", 1, "mobileQQ is null");
        return;
      }
      AppRuntime localAppRuntime = localMobileQQ.waitAppRuntime(null);
      if (!(localAppRuntime instanceof AppInterface))
      {
        QLog.d("SubType0x146", 1, new Object[] { "appRuntime not appInterface : ", localAppRuntime });
        return;
      }
      QLog.d("SubType0x146", 1, "start notify update main tab");
      AppInterface localAppInterface = (AppInterface)localAppRuntime;
      paramArrayOfByte = a((submsgtype0x146.MsgBody)localObject);
      TabDataHelper.updateTabSwitchByPush(localMobileQQ, localAppRuntime.getCurrentUin(), paramArrayOfByte);
      ((TabDataHandler)localAppInterface.getBusinessHandler(TabDataHandler.class.getName())).notifyUI(0, true, null);
      localObject = FrameAddPushNotifier.a().b();
      QLog.d("SubType0x146", 1, new Object[] { "start notify callback, callback size : ", Integer.valueOf(((List)localObject).size()) });
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnTabFrameAddCallback)((Iterator)localObject).next()).a(paramArrayOfByte);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("SubType0x146", 1, "submsgtype0x146.MsgBody decode error : ", paramArrayOfByte);
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    QLog.d("SubType0x146", 1, "start decode");
    a(paramArrayOfByte);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x146
 * JD-Core Version:    0.7.0.1
 */