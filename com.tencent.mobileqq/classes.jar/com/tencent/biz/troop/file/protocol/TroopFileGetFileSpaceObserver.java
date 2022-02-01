package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetSpaceRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileGetFileSpaceObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      paramBundle = new oidb_0x6d8.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (!paramBundle.group_space_rsp.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtocol", 2, "no group_space_rsp rsp.");
        }
        a(false, 0L, 0L, 0);
        return;
      }
      paramArrayOfByte = (oidb_0x6d8.GetSpaceRspBody)paramBundle.group_space_rsp.get();
      a(true, paramArrayOfByte.uint64_total_space.get(), paramArrayOfByte.uint64_used_space.get(), paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label90:
      break label90;
    }
    a(false, 0L, 0L, 0);
    return;
    a(false, 0L, 0L, 0);
  }
  
  public abstract void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileGetFileSpaceObserver
 * JD-Core Version:    0.7.0.1
 */