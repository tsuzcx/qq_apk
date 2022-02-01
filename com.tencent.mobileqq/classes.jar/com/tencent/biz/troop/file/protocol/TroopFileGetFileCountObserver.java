package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileCountRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileGetFileCountObserver
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
      if (!paramBundle.group_file_cnt_rsp.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtocol", 2, "no group_file_cnt_rsp rsp.");
        }
        a(false, false, 0, 0, 0);
        return;
      }
      paramArrayOfByte = (oidb_0x6d8.GetFileCountRspBody)paramBundle.group_file_cnt_rsp.get();
      a(true, paramArrayOfByte.bool_file_too_many.get(), paramArrayOfByte.uint32_all_file_count.get(), paramArrayOfByte.uint32_limit_count.get(), paramInt);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label98:
      break label98;
    }
    a(false, false, 0, 0, 0);
    return;
    a(false, false, 0, 0, 0);
  }
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileGetFileCountObserver
 * JD-Core Version:    0.7.0.1
 */