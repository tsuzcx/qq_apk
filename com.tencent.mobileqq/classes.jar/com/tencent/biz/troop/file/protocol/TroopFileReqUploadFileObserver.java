package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.UploadFileRspBody;

public abstract class TroopFileReqUploadFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
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
      paramArrayOfByte = (oidb_0x6d6.UploadFileRspBody)localRspBody.upload_file_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        a(true, 0, paramArrayOfByte, paramBundle);
        return;
      }
      a(false, -1, null, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label69:
      break label69;
    }
    a(false, -1, null, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, oidb_0x6d6.UploadFileRspBody paramUploadFileRspBody, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver
 * JD-Core Version:    0.7.0.1
 */