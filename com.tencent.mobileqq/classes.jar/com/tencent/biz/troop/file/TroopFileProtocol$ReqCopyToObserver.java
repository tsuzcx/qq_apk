package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public abstract class TroopFileProtocol$ReqCopyToObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopFileProtocol$ReqCopyToObserver()
  {
    super(false);
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, null, paramBundle);
      return;
    }
    cmd0x383.RspBody localRspBody = new cmd0x383.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      if (localRspBody.int32_ret_code.has())
      {
        a(true, localRspBody, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, localRspBody, paramBundle);
      return;
    }
    a(false, localRspBody, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver
 * JD-Core Version:    0.7.0.1
 */