import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;

public class bfyw
  extends bfyu
{
  private ITransactionCallback b;
  protected Transaction b;
  protected boolean b;
  protected String c;
  
  public bfyw(bfyr parambfyr, int paramInt)
  {
    super(parambfyr, paramInt);
    this.jdField_b_of_type_ComTencentMobileqqHighwayApiITransactionCallback = new bfyx(this);
  }
  
  public void a()
  {
    String str1 = this.jdField_a_of_type_Bfyr.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_Bfyr.jdField_a_of_type_JavaLangString;
    boolean bool2 = a(str1);
    boolean bool1 = false;
    if (bool2) {
      bool1 = b(str2);
    }
    if ((bool2) && (bool1)) {
      return;
    }
    e();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      c();
    }
  }
  
  protected boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadVideo path= " + paramString);
    }
    ITransactionCallback localITransactionCallback = this.jdField_b_of_type_ComTencentMobileqqHighwayApiITransactionCallback;
    QQAppInterface localQQAppInterface = a();
    String str = localQQAppInterface.c();
    byte[] arrayOfByte;
    File localFile;
    if (localQQAppInterface != null)
    {
      arrayOfByte = aoyp.a(paramString);
      localFile = new File(paramString);
      if (arrayOfByte != null) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadVideo md5 null ");
      }
    }
    label93:
    int i;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "uploadVideo,file length " + new File(paramString).length());
      }
      PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
      localPttShortVideoUploadReq.setHasFlag(true);
      localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint32_chat_type.set(1);
      localPttShortVideoUploadReq.uint32_client_type.set(1);
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(str));
      localPttShortVideoUploadReq.uint32_agent_type.set(0);
      localPttShortVideoUploadReq.uint32_business_type.set(3001);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(localFile.getName());
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(arrayOfByte));
      localPttShortVideoFileInfo.uint64_file_size.set(localFile.length());
      localPttShortVideoFileInfo.uint32_file_res_length.set(0);
      localPttShortVideoFileInfo.uint32_file_res_width.set(0);
      localPttShortVideoFileInfo.uint32_file_format.set(3);
      localPttShortVideoFileInfo.uint32_file_time.set((int)this.jdField_a_of_type_Bfyr.jdField_a_of_type_Long);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(0L);
      localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      paramString = new Transaction(str, 74, paramString, 0, arrayOfByte, localITransactionCallback, localPttShortVideoUploadReq.toByteArray(), false);
      i = localQQAppInterface.getHwEngine().submitTransactionTask(paramString);
      if (i == 0)
      {
        this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = paramString;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "uploadVideo submitTransactionTask  retCode= " + i);
    return false;
  }
  
  public void c()
  {
    boolean bool = true;
    Bundle localBundle = new Bundle();
    localBundle.putInt("isVideo", 1);
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.c != null))
    {
      localBundle.putInt("result", 1);
      localBundle.putString("url", this.jdField_b_of_type_JavaLangString);
      localBundle.putString("vid", this.c);
    }
    for (;;)
    {
      bfys.a().a(bool, this.jdField_a_of_type_Int, localBundle);
      return;
      localBundle.putInt("result", 0);
      localBundle.putString("error", "");
      bool = false;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyw
 * JD-Core Version:    0.7.0.1
 */