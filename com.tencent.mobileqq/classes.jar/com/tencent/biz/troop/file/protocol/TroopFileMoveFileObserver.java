package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.MoveFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class TroopFileMoveFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d6.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.MoveFileRspBody)paramBundle.move_file_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, paramArrayOfByte.str_parent_folder_id.get());
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), null);
        return;
      }
      a(false, -1, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label93:
      break label93;
    }
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, String paramString);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileMoveFileObserver
 * JD-Core Version:    0.7.0.1
 */