package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class TroopFileDeleteFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, paramBundle, "", HardCodeUtil.a(2131912640));
      return;
    }
    oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.DeleteFileRspBody)localRspBody.delete_file_rsp.get();
      if (paramArrayOfByte.int32_ret_code.has())
      {
        if (paramArrayOfByte.int32_ret_code.get() == 0)
        {
          a(true, 0, paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
          return;
        }
        a(false, paramArrayOfByte.int32_ret_code.get(), paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
        return;
      }
      a(false, -1, paramBundle, "", HardCodeUtil.a(2131912644));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label132:
      break label132;
    }
    a(false, -1, paramBundle, "", HardCodeUtil.a(2131912636));
  }
  
  protected abstract void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileDeleteFileObserver
 * JD-Core Version:    0.7.0.1
 */