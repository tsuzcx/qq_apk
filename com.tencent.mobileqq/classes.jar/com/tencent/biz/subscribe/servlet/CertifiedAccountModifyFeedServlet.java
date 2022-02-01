package com.tencent.biz.subscribe.servlet;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class CertifiedAccountModifyFeedServlet
  extends CertifiedAccountAbstractServlet
{
  public void a(Intent paramIntent, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    paramBundle.putByteArray("key_data", paramArrayOfByte);
    notifyObserver(paramIntent, this.a, true, paramBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("key_ext");
    Object localObject1 = null;
    Object localObject3 = null;
    if (arrayOfByte1 != null)
    {
      localObject2 = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject2).mergeFrom(arrayOfByte1);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        QLog.e("CertifiedAccountModifyFeedServlet", 2, QLog.getStackTraceString(localInvalidProtocolBufferMicroException1));
      }
    }
    else
    {
      localObject2 = null;
    }
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("key_request_feed_bytes");
    if (arrayOfByte2 != null) {
      try
      {
        localObject1 = new CertifiedAccountMeta.StFeed();
        try
        {
          ((CertifiedAccountMeta.StFeed)localObject1).mergeFrom(arrayOfByte2);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2) {}
        QLog.e("CertifiedAccountModifyFeedServlet", 2, QLog.getStackTraceString(localInvalidProtocolBufferMicroException3));
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException3)
      {
        localObject1 = localObject3;
      }
    }
    Object localObject2 = new CertifiedAccountModifyFeedRequest((COMM.StCommonExt)localObject2, (CertifiedAccountMeta.StFeed)localObject1).a(paramIntent, i, a());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("CertifiedAccountSvc.certified_account_write.ModifyFeed");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountModifyFeedServlet
 * JD-Core Version:    0.7.0.1
 */