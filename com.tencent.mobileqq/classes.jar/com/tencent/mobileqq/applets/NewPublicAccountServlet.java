package com.tencent.mobileqq.applets;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NewPublicAccountServlet
  extends MSFServlet
{
  private String a = "com.tencent.mobileqq.applets.NewPublicAccountServlet";
  
  protected byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      return WupUtil.b(paramFromServiceMsg.getWupBuffer());
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onReceive");
    }
    Object localObject2 = paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_CMD");
    Object localObject1 = a(paramFromServiceMsg);
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putByteArray("data", (byte[])localObject1);
    ((Bundle)localObject3).putInt("respones_code", paramFromServiceMsg.getBusinessFailCode());
    if ("newFollow".equals(localObject2)) {
      try
      {
        localObject2 = (NewPublicAccountObserver)((PublicAccountIntent)paramIntent).a();
        if (paramFromServiceMsg.isSuccess())
        {
          paramIntent = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramIntent.mergeFrom((byte[])localObject1);
            paramIntent = paramFromServiceMsg;
          }
          catch (Exception paramFromServiceMsg)
          {
            QLog.w(this.a, 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
          }
          catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
          {
            QLog.w(this.a, 4, paramFromServiceMsg.getMessage(), paramFromServiceMsg);
          }
          int j = -1;
          int i = j;
          if (paramIntent != null)
          {
            i = j;
            if (paramIntent.uint32_result.has())
            {
              j = paramIntent.uint32_result.get();
              i = j;
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = this.a;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("handle OidbSvc.0xc96|OIDBSSOPke.result=");
                ((StringBuilder)localObject3).append(j);
                QLog.i(paramFromServiceMsg, 2, ((StringBuilder)localObject3).toString());
                i = j;
              }
            }
          }
          if ((i == 0) && (paramIntent.bytes_bodybuffer.has()) && (paramIntent.bytes_bodybuffer.get() != null))
          {
            paramIntent.bytes_bodybuffer.get().toByteArray();
            super.getAppRuntime().runOnUiThread(new NewPublicAccountServlet.1(this, (NewPublicAccountObserver)localObject2, (byte[])localObject1));
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.a, 2, "0xc96 fail");
            }
            super.getAppRuntime().runOnUiThread(new NewPublicAccountServlet.2(this, (NewPublicAccountObserver)localObject2));
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramIntent = this.a;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("handleGetAppletPublicAccount res.isSuccess=false   failCode: ");
            ((StringBuilder)localObject1).append(paramFromServiceMsg.getBusinessFailCode());
            QLog.d(paramIntent, 2, ((StringBuilder)localObject1).toString());
          }
          super.getAppRuntime().runOnUiThread(new NewPublicAccountServlet.3(this, (NewPublicAccountObserver)localObject2));
        }
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, new Object[] { "onReceive CMD_PUBLIC_ACCOUNT_FOLLOW fail,", paramIntent.toString() });
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onReceive exit");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onSend");
    }
    paramIntent.getByteArrayExtra("data");
    Object localObject1 = paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_CMD");
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "cmd=", localObject1 });
    }
    if ("newFollow".equals(localObject1))
    {
      paramIntent = (PublicAccountIntent)paramIntent;
      try
      {
        localObject1 = (QQAppInterface)super.getAppRuntime();
        localObject2 = (NewPublicAccountObserver)paramIntent.a();
        ((NewPublicAccountObserver)localObject2).a((QQAppInterface)localObject1);
        ((QQAppInterface)localObject1).addObserver((BusinessObserver)localObject2);
        PublicAccountStateReporter.a((QQAppInterface)localObject1, paramIntent.getBooleanExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", false), paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN"), paramIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
        paramPacket.setSSOCommand(null);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, new Object[] { "ClassCastException e", localClassCastException.toString() });
        }
        oidb_cmd0xc96.ReqBody localReqBody = new oidb_cmd0xc96.ReqBody();
        localReqBody.puin.set(Long.parseLong(paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN")));
        Object localObject2 = new oidb_cmd0xc96.FollowExt();
        ((oidb_cmd0xc96.FollowExt)localObject2).source_from.set(paramIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
        paramIntent = new oidb_cmd0xc96.FollowReq();
        paramIntent.ext.set((MessageMicro)localObject2);
        localReqBody.follow_req.set(paramIntent);
        localReqBody.cmd_type.set(1);
        paramIntent = new oidb_sso.OIDBSSOPkg();
        paramIntent.uint32_command.set(3222);
        paramIntent.uint32_result.set(0);
        paramIntent.uint32_service_type.set(0);
        paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramIntent = paramIntent.toByteArray();
        paramPacket.setSSOCommand("OidbSvc.0xc96");
        paramPacket.putSendData(WupUtil.a(paramIntent));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.applets.NewPublicAccountServlet
 * JD-Core Version:    0.7.0.1
 */