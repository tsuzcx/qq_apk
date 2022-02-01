package com.tencent.biz.subscribe.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public abstract class CertifiedAccountAbstractServlet
  extends MSFServlet
{
  private static String b = "com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet";
  protected int a;
  
  public static String a()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(localSimpleDateFormat.format(new Date()));
    localStringBuilder.append(System.currentTimeMillis() % 1000L);
    localStringBuilder.append("_");
    localStringBuilder.append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  protected abstract void a(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte);
  
  @CallSuper
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      localBundle.putLong("key_index", paramIntent.getLongExtra("key_index", -1L));
      if (paramFromServiceMsg != null)
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        if (bool)
        {
          localObject = new PROTOCAL.StQWebRsp();
          ((PROTOCAL.StQWebRsp)localObject).mergeFrom(WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          localBundle.putLong("key_index", ((PROTOCAL.StQWebRsp)localObject).Seq.get());
          localBundle.putLong("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
          localBundle.putString("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
          a(paramIntent, localBundle, ((PROTOCAL.StQWebRsp)localObject).busiBuff.get().toByteArray());
          return;
        }
        localBundle.putLong("retCode", paramFromServiceMsg.getBusinessFailCode());
        localBundle.putString("errMsg", paramFromServiceMsg.getBusinessFailMsg());
        notifyObserver(paramIntent, this.a, false, localBundle, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "onReceive. inform  resultcode fail.");
      }
      notifyObserver(paramIntent, this.a, false, localBundle, null);
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      Object localObject = b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append("onReceive error");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      notifyObserver(paramIntent, this.a, false, localBundle, null);
    }
  }
  
  @CallSuper
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject = null;
    if (paramPacket != null) {
      paramPacket = paramPacket.toMsg();
    } else {
      paramPacket = null;
    }
    if (paramPacket != null)
    {
      String str = paramPacket.getServiceCmd();
      paramPacket = localObject;
      if (paramIntent != null) {
        paramPacket = paramIntent.getStringExtra("traceid");
      }
      paramIntent = new StringBuilder();
      paramIntent.append("send request cmd=");
      paramIntent.append(str);
      paramIntent.append(" traceId=");
      paramIntent.append(paramPacket);
      QLog.i("certified-account-cmd", 1, paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountAbstractServlet
 * JD-Core Version:    0.7.0.1
 */