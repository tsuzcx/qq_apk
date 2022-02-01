package com.tencent.biz.troop.file.protocol;

import android.os.Bundle;
import android.text.TextUtils;
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

public abstract class TroopFileGetFilePreviewObserver
  extends ProtoUtils.TroopProtocolObserver
{
  protected void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    Object localObject;
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      localObject = new oidb_0x6d8.RspBody();
    }
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
      paramArrayOfByte = (oidb_0x6d8.GetFilePreviewRspBody)((oidb_0x6d8.RspBody)localObject).file_preview_rsp.get();
      if (!paramArrayOfByte.bytes_download_url.has())
      {
        a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
        return;
      }
      i = paramArrayOfByte.int32_ret_code.get();
      localObject = paramArrayOfByte.str_ret_msg.get();
      str1 = paramArrayOfByte.str_client_wording.get();
      j = paramArrayOfByte.int32_server_ip.get();
      k = paramArrayOfByte.int32_server_port.get();
      str2 = paramArrayOfByte.str_download_dns.get();
      localByteStringMicro1 = paramArrayOfByte.bytes_download_url.get();
      localByteStringMicro2 = paramArrayOfByte.bytes_reserved_field.get();
      str3 = paramArrayOfByte.str_cookie_val.get();
      paramArrayOfByte.str_download_dns_https.get().toStringUtf8();
      paramArrayOfByte.uint32_preview_port_https.get();
      if (paramBundle == null) {
        paramArrayOfByte = new Bundle();
      } else {
        paramArrayOfByte = paramBundle;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      int i;
      String str1;
      int j;
      int k;
      String str2;
      ByteStringMicro localByteStringMicro1;
      ByteStringMicro localByteStringMicro2;
      String str3;
      label279:
      break label282;
    }
    try
    {
      if (!TextUtils.isEmpty(str2))
      {
        paramArrayOfByte.putString("strHttpsDomain", str2);
        paramArrayOfByte.putInt("httpsPort", 443);
      }
      a(true, i, (String)localObject, str1, j, k, str2, localByteStringMicro1, str3, localByteStringMicro2, paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      break label279;
    }
    break label284;
    label282:
    paramArrayOfByte = paramBundle;
    label284:
    a(false, paramInt, null, null, 0, 0, null, null, null, null, paramArrayOfByte);
    return;
    a(false, paramInt, null, null, 0, 0, null, null, null, null, paramBundle);
  }
  
  public abstract void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, ByteStringMicro paramByteStringMicro1, String paramString4, ByteStringMicro paramByteStringMicro2, Bundle paramBundle);
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    a(paramInt, paramArrayOfByte, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver
 * JD-Core Version:    0.7.0.1
 */