package com.tencent.av.utils.upload;

import android.text.TextUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import java.util.HashMap;

class FileUpload$1
  implements ITransactionCallback
{
  long jdField_a_of_type_Long = 0L;
  
  FileUpload$1(FileUpload paramFileUpload, String paramString, long paramLong, byte[] paramArrayOfByte, FileUpload.UploadCallback paramUploadCallback) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    paramArrayOfByte = this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString;
    paramHashMap = new StringBuilder();
    paramHashMap.append("onFailed, sessionId[");
    paramHashMap.append(this.jdField_a_of_type_JavaLangString);
    paramHashMap.append("], retCode[");
    paramHashMap.append(paramInt);
    paramHashMap.append("]");
    QLog.w(paramArrayOfByte, 1, paramHashMap.toString());
    paramArrayOfByte = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload$UploadCallback.a(paramInt, this.jdField_a_of_type_JavaLangString, "", paramArrayOfByte);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str2 = "";
    String str1 = str2;
    if (paramArrayOfByte != null) {
      str1 = str2;
    }
    try
    {
      localObject = new Bdh_extinfo.CommFileExtRsp();
      str1 = str2;
      ((Bdh_extinfo.CommFileExtRsp)localObject).mergeFrom(paramArrayOfByte);
      str1 = str2;
      str2 = ((Bdh_extinfo.CommFileExtRsp)localObject).bytes_download_url.get().toStringUtf8();
      str1 = str2;
      boolean bool = TextUtils.isEmpty(str2);
      if (bool)
      {
        i = -10010;
        str1 = str2;
      }
    }
    catch (Exception localException2)
    {
      Object localObject;
      int i;
      label167:
      StringBuilder localStringBuilder;
      break label178;
    }
    try
    {
      if (QLog.isDevelopLevel())
      {
        str1 = this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSuccess, sessionId[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("], 原始url[");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("]");
        QLog.w(str1, 1, ((StringBuilder)localObject).toString());
      }
      str1 = URLUtil.a(str2);
    }
    catch (Exception localException1)
    {
      break label167;
    }
    i = -10011;
    str1 = str2;
    break label187;
    label178:
    i = -10012;
    break label187;
    i = 0;
    label187:
    str2 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    localObject = this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSuccess, sessionId[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("], respData[");
    if (paramArrayOfByte != null) {
      paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
    } else {
      paramArrayOfByte = null;
    }
    localStringBuilder.append(paramArrayOfByte);
    localStringBuilder.append("], retCode[");
    localStringBuilder.append(i);
    localStringBuilder.append("], md5[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], url[");
    localStringBuilder.append(str1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    AudioHelper.a(this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString, paramHashMap, false);
    this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload$UploadCallback.a(i, this.jdField_a_of_type_JavaLangString, str1, str2);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    String str = this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTransStart, sessionId[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Long < l)
      {
        String str = this.jdField_a_of_type_ComTencentAvUtilsUploadFileUpload.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpdateProgress, sessionId[");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("], transferedSize[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], totalSize[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
        this.jdField_a_of_type_Long = (l + 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.upload.FileUpload.1
 * JD-Core Version:    0.7.0.1
 */