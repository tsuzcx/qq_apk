package com.tencent.mobileqq.activity.springfestival;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.protofile.shua1shua_onlinenumber.OnlineNumberReply;
import com.tencent.protofile.shua1shua_onlinenumber.OnlineNumberRequest;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class HBEntryBannerServlet
  extends MSFServlet
{
  public void a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((QQAppInterface)localObject).startServlet(new NewIntent(((QQAppInterface)localObject).getApp(), HBEntryBannerServlet.class));
      return;
    }
    QLog.d("HBEntryBannerView", 2, "send req when mApp null");
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramIntent = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(paramIntent);
        paramFromServiceMsg = new shua1shua_onlinenumber.OnlineNumberReply();
        paramFromServiceMsg.mergeFrom(paramIntent);
        paramIntent = paramFromServiceMsg.msg.get();
        int i = paramFromServiceMsg.interval.get();
        int j = paramFromServiceMsg.num.get();
        int k = paramFromServiceMsg.ret.get();
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive, msg:");
        paramFromServiceMsg.append(paramIntent);
        paramFromServiceMsg.append(", ret:");
        paramFromServiceMsg.append(k);
        paramFromServiceMsg.append(", number:");
        paramFromServiceMsg.append(j);
        paramFromServiceMsg.append(", interval:");
        paramFromServiceMsg.append(i);
        QLog.d("HBEntryBannerView", 2, paramFromServiceMsg.toString());
        if (i > 0) {
          HBEntryBannerView.a = i;
        }
        if (j > 0)
        {
          HBEntryBannerView.b = j;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = new shua1shua_onlinenumber.OnlineNumberRequest();
    paramPacket.setSSOCommand("trpc.shua1shua.onlinenumber.Getter.GetOnlineNumber");
    paramPacket.putSendData(WupUtil.a(paramIntent.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerServlet
 * JD-Core Version:    0.7.0.1
 */