package com.tencent.av.utils.upload;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public abstract class FileUpload
{
  final String a;
  protected AppInterface b;
  private final int c;
  
  protected FileUpload(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileUpload_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    this.a = localStringBuilder.toString();
    this.c = paramInt;
    this.b = paramAppInterface;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null) {
      paramAppInterface.getHwEngine().preConnect();
    }
  }
  
  public static byte[] a(String paramString, AppInterface paramAppInterface)
  {
    try
    {
      String str = paramAppInterface.getCurrentAccountUin();
      if (SessionInfo.getInstance(str).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(str).getHttpconn_sig_session().length;
        paramString = new byte[i];
        System.arraycopy(SessionInfo.getInstance(str).getHttpconn_sig_session(), 0, paramString, 0, i);
        return paramString;
      }
      HwServlet.getConfig(paramAppInterface, str);
      QLog.w(paramString, 1, "getSig, fail");
      return null;
    }
    finally {}
  }
  
  protected boolean b(String paramString, FileUpload.UploadCallback paramUploadCallback)
  {
    long l = new File(paramString).length();
    String str = ARCloudFileUpload.a(this.b);
    if (l == 0L)
    {
      paramUploadCallback.a(-10001, str, "", null);
      return false;
    }
    Object localObject = a(this.a, this.b);
    if ((localObject != null) && (localObject.length != 0))
    {
      byte[] arrayOfByte = ARCloudFileUpload.a(paramString);
      if ((arrayOfByte != null) && (arrayOfByte.length != 0))
      {
        FileUpload.1 local1 = new FileUpload.1(this, str, l, arrayOfByte, paramUploadCallback);
        Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
        localCommFileExtReq.uint32_action_type.set(0);
        localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
        localObject = new Transaction(this.b.getCurrentAccountUin(), this.c, paramString, 0, (byte[])localObject, arrayOfByte, local1, localCommFileExtReq.toByteArray());
        int i = this.b.getHwEngine().submitTransactionTask((Transaction)localObject);
        if (i != 0) {
          paramUploadCallback.a(i, str, "", null);
        }
        paramUploadCallback = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("requestToUpload, localFile[");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("], sessionId[");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("]");
        QLog.w(paramUploadCallback, 1, ((StringBuilder)localObject).toString());
        return i == 0;
      }
      paramUploadCallback.a(-10002, str, "", null);
      return false;
    }
    paramUploadCallback.a(-10003, str, "", null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.upload.FileUpload
 * JD-Core Version:    0.7.0.1
 */