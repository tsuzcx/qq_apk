package com.tencent.biz.troop.file;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.GetFilePreviewRspBody;
import tencent.im.oidb.cmd0x6d8.oidb_0x6d8.RspBody;

public abstract class TroopFileProtocol$GetFilePreviewObserver
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
      return;
    }
    Object localObject = new oidb_0x6d8.RspBody();
    try
    {
      ((oidb_0x6d8.RspBody)localObject).mergeFrom(paramArrayOfByte);
      localObject.toString();
      if (!((oidb_0x6d8.RspBody)localObject).file_preview_rsp.has())
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtocol", 2, "no file_preview rsp.");
        }
        a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
      return;
    }
    paramArrayOfByte = (oidb_0x6d8.GetFilePreviewRspBody)((oidb_0x6d8.RspBody)localObject).file_preview_rsp.get();
    if (!paramArrayOfByte.bytes_download_url.has())
    {
      a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
      return;
    }
    int i = paramArrayOfByte.int32_ret_code.get();
    localObject = paramArrayOfByte.str_ret_msg.get();
    String str1 = paramArrayOfByte.str_client_wording.get();
    int j = paramArrayOfByte.int32_server_ip.get();
    int k = paramArrayOfByte.int32_server_port.get();
    String str2 = paramArrayOfByte.str_download_dns.get();
    ByteStringMicro localByteStringMicro1 = paramArrayOfByte.bytes_download_url.get();
    ByteStringMicro localByteStringMicro2 = paramArrayOfByte.bytes_reserved_field.get();
    a(true, i, (String)localObject, str1, j, k, str2, localByteStringMicro1, paramArrayOfByte.str_cookie_val.get(), localByteStringMicro2, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.file.TroopFileProtocol.GetFilePreviewObserver
 * JD-Core Version:    0.7.0.1
 */