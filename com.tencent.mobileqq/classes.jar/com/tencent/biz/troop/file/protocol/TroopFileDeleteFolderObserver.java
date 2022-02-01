package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.DeleteFolderRspBody;
import tencent.im.oidb.cmd0x6d7.oidb_0x6d7.RspBody;

public abstract class TroopFileDeleteFolderObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt);
      return;
    }
    paramBundle = new oidb_0x6d7.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d7.DeleteFolderRspBody)paramBundle.delete_folder_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0);
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get());
        return;
      }
      a(false, -1);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label83:
      break label83;
    }
    a(false, -1);
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileDeleteFolderObserver
 * JD-Core Version:    0.7.0.1
 */