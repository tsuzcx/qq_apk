package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFileInfoRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileGetOneFileInfoObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, null);
      return;
    }
    paramBundle = new oidb_0x6d8.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d8.GetFileInfoRspBody)paramBundle.file_info_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          paramArrayOfByte = (group_file_common.FileInfo)paramArrayOfByte.file_info.get();
          if (paramArrayOfByte == null) {
            break label142;
          }
          a(true, 0, paramArrayOfByte);
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), null);
        return;
      }
      if (paramArrayOfByte.file_info.has())
      {
        paramArrayOfByte = (group_file_common.FileInfo)paramArrayOfByte.file_info.get();
        if (paramArrayOfByte == null) {
          break label142;
        }
        a(true, 0, paramArrayOfByte);
        return;
      }
      a(false, -1, null);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label135:
      label142:
      break label135;
    }
    a(false, -1, null);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver
 * JD-Core Version:    0.7.0.1
 */