import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aphn
  extends aphu
{
  long jdField_a_of_type_Long = 0L;
  ExcitingTransferUploadResultRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  final String jdField_a_of_type_JavaLangString = "ExcitingTransfer.ExtfGroupRP<FileAssistant>";
  boolean jdField_a_of_type_Boolean = false;
  long b = 0L;
  long c;
  
  public aphn(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected int a()
  {
    return 2;
  }
  
  protected String a(boolean paramBoolean)
  {
    return "actGroupXTFUpload";
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = super.a();
    localHashMap.put("param_IsFlashFile", String.valueOf(this.jdField_a_of_type_Boolean));
    localHashMap.put("param_TotalCostTime", String.valueOf(this.c));
    localHashMap.put("param_CalcShaCostTime", String.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("param_CalcHashCostTime", String.valueOf(this.b));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null)
    {
      localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_nResult));
      localHashMap.put("param_IsXTFValid", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_bIsXTFValid));
      localHashMap.put("param_HttpTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_nSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64TransferSize));
      localHashMap.put("param_StartSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_u64StartSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_strServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_wServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_strFileUrl));
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uMaxUploadingFtnNum));
      localHashMap.put("param_RetryCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uRetryCount));
      localHashMap.put("param_IpChangeCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uIpChangeCount));
      localHashMap.put("param_RollBackCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uRollBackCount));
      localHashMap.put("param_QueryHoleCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uQueryHoleCount));
      localHashMap.put("param_RangDiffCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uRangDiffCount));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_uDelayTotoalCount));
      localHashMap.put("param_TcpCnnCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_nTcpCnnCode));
      localHashMap.put("param_TcpSocketCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_nTcpSocketCode));
      localHashMap.put("param_HttpsSupport", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.m_wHttpsSupport));
    }
    for (;;)
    {
      QLog.i("ExcitingTransfer.ExtfGroupRP<FileAssistant>", 1, "Id[" + this.d + "] >>> GroupSendDataReport:act=" + a(false) + localHashMap.toString());
      return localHashMap;
      localHashMap.put("param_IsXTFValid", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_StartSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", "");
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
      localHashMap.put("param_MaxUploadingFtnNum", String.valueOf(0));
      localHashMap.put("param_RetryCount", String.valueOf(0));
      localHashMap.put("param_IpChangeCount", String.valueOf(0));
      localHashMap.put("param_RollBackCount", String.valueOf(0));
      localHashMap.put("param_QueryHoleCount", String.valueOf(0));
      localHashMap.put("param_RangDiffCount", String.valueOf(0));
      localHashMap.put("param_DelayTotoalCount", String.valueOf(0));
      localHashMap.put("param_TcpCnnCode", String.valueOf(0));
      localHashMap.put("param_TcpSocketCode", String.valueOf(0));
      localHashMap.put("param_HttpsSupport", String.valueOf(0));
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  public void b(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphn
 * JD-Core Version:    0.7.0.1
 */