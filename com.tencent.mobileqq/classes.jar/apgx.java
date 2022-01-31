import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class apgx
{
  protected long a;
  protected apgv a;
  protected final QQAppInterface a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected ExcitingTransferDownloaderFirstPkgRp a;
  
  public apgx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDFileDownload";
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Apgv = new apgv();
    this.jdField_a_of_type_Apgv.jdField_a_of_type_Long = paramInt;
    this.jdField_a_of_type_Apgv.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Apgv.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Apgv.d = paramLong2;
    this.jdField_a_of_type_Apgv.c = paramLong3;
    this.jdField_a_of_type_Apgv.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Apgv.jdField_b_of_type_Int = 1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime > paramExcitingTransferDownloadCompletedInfo.m_uStartTime) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.m_uStartTime);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Apgv == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo == null))
    {
      QLog.e("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] GroupDownloadDataReport err. param err");
      return;
    }
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Apgv != null) {
      localHashMap.putAll(this.jdField_a_of_type_Apgv.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.getReportData());
    }
    for (;;)
    {
      QLog.i("ExtfGroupDownloadDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> GroupDownloadDataReport: act=" + a() + localHashMap.toString());
      axrl.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), a(), paramBoolean, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_Apgv = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = null;
      return;
      localHashMap.put("param_CSTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstTime", String.valueOf(0));
      localHashMap.put("param_HttpFirstDataSize", String.valueOf(0));
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = paramLong;
  }
  
  public void c(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgx
 * JD-Core Version:    0.7.0.1
 */