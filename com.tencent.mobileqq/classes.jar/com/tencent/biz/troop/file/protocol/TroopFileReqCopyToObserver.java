package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.CopyToRspBody;
import tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody;

public abstract class TroopFileReqCopyToObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public TroopFileReqCopyToObserver()
  {
    super(false);
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      a(false, paramInt, 102, null, null, null, paramBundle);
      return;
    }
    Object localObject = new oidb_0x6d9.RspBody();
    try
    {
      ((oidb_0x6d9.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((oidb_0x6d9.RspBody)localObject).copy_to_rsp.has())
      {
        a(false, paramInt, 102, null, null, null, paramBundle);
        return;
      }
      paramArrayOfByte = (oidb_0x6d9.CopyToRspBody)((oidb_0x6d9.RspBody)localObject).copy_to_rsp.get();
      if (!paramArrayOfByte.int32_ret_code.has())
      {
        a(false, paramInt, 102, null, null, null, paramBundle);
        return;
      }
      int i = paramArrayOfByte.int32_ret_code.get();
      localObject = paramArrayOfByte.str_client_wording.get();
      String str1 = paramArrayOfByte.str_ret_msg.get();
      String str2 = paramArrayOfByte.str_save_file_path.get();
      if (paramArrayOfByte.uint32_bus_id.has()) {
        paramInt = paramArrayOfByte.uint32_bus_id.get();
      } else {
        paramInt = 102;
      }
      a(true, i, paramInt, str2, str1, (String)localObject, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label168:
      break label168;
    }
    a(false, paramInt, 102, null, null, null, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver
 * JD-Core Version:    0.7.0.1
 */