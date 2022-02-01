import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class auby
  extends aubd
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ExcitingTransferUploaderRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  
  public auby(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected String a(boolean paramBoolean)
  {
    return "actC2CXTFUploadSender";
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_TransferType", String.valueOf(0));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_FileName", String.valueOf(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Suffix", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_TargetUin", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_GroupCode", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_FileSize", String.valueOf(this.jdField_d_of_type_Long));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp != null)
    {
      localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_nResult));
      localHashMap.put("param_IsBigData", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_bIsBigData));
      localHashMap.put("param_HttpTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_u64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_nSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_u64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_u64TransferSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_strServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_wServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.m_strFileUrl));
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("param_stackType", String.valueOf(auoo.b()));
      localHashMap.put("param_loginType", String.valueOf(auoo.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.jdField_d_of_type_Int));
      QLog.d("ExcitingTransfer.OfflineSenderRP<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> SenderDataReport:" + localHashMap.toString());
      return localHashMap;
      localHashMap.put("param_IsBigData", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", String.valueOf(0));
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
    }
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Long = paramLong3;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp = paramExcitingTransferUploaderRp;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected HashMap<String, String> b()
  {
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auby
 * JD-Core Version:    0.7.0.1
 */