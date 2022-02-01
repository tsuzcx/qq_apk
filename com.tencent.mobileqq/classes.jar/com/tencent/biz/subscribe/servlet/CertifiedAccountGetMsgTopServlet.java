package com.tencent.biz.subscribe.servlet;

import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class CertifiedAccountGetMsgTopServlet
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
    if (arrayOfByte1 != null)
    {
      localObject = new COMM.StCommonExt();
      try
      {
        ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte1);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CertifiedAccountGetMsgTopServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    else
    {
      localObject = null;
    }
    int i = paramIntent.getIntExtra("key_index", -1);
    byte[] arrayOfByte2 = new CertifiedAccountGetMsgTopRequest((COMM.StCommonExt)localObject).a(paramIntent, i, a());
    Object localObject = arrayOfByte2;
    if (arrayOfByte2 == null) {
      localObject = new byte[4];
    }
    paramPacket.setSSOCommand("CertifiedAccountSvc.certified_account_read.GetMsgPageTop");
    paramPacket.putSendData(WupUtil.a((byte[])localObject));
    paramPacket.setTimeout(paramIntent.getLongExtra("key_timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.servlet.CertifiedAccountGetMsgTopServlet
 * JD-Core Version:    0.7.0.1
 */