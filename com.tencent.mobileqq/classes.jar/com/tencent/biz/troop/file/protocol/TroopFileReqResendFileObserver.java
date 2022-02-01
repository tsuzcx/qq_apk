package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.ResendRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class TroopFileReqResendFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    b(paramInt, paramArrayOfByte, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d6.ResendRspBody paramResendRspBody, Bundle paramBundle);
  
  protected void b(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null, paramBundle);
      return;
    }
    oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.ResendRspBody)localRspBody.resend_file_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        a(true, 0, paramArrayOfByte, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, -1, null, paramBundle);
      return;
    }
    a(false, -1, null, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileReqResendFileObserver
 * JD-Core Version:    0.7.0.1
 */