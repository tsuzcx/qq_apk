package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DeleteFileRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.RspBody;

public abstract class TroopFileProtocol$DeleteFileObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, paramBundle, "", "操作失败,请重试");
      return;
    }
    oidb_0x6d6.RspBody localRspBody = new oidb_0x6d6.RspBody();
    try
    {
      localRspBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (oidb_0x6d6.DeleteFileRspBody)localRspBody.delete_file_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has()) {
        break label127;
      }
      if (paramArrayOfByte.int32_ret_code.get() == 0)
      {
        a(true, 0, paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, -1, paramBundle, "", "操作失败,请重试");
      return;
    }
    a(false, paramArrayOfByte.int32_ret_code.get(), paramBundle, paramArrayOfByte.str_ret_msg.get(), paramArrayOfByte.str_client_wording.get());
    return;
    label127:
    a(false, -1, paramBundle, "", "操作失败,请重试");
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, Bundle paramBundle, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.DeleteFileObserver
 * JD-Core Version:    0.7.0.1
 */