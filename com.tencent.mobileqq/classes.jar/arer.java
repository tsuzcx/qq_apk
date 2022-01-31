import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.HashMap;

public class arer
  extends aref
{
  private long jdField_a_of_type_Long;
  public final areg a;
  private ExcitingTransferDownloadCompletedInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
  private ExcitingTransferDownloaderFirstPkgRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  public arer(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Areg = new areg();
  }
  
  private long a(long paramLong, int paramInt)
  {
    if (paramLong == 9004L) {}
    do
    {
      return paramLong;
      if ((paramLong != 0L) && (paramInt != 0))
      {
        if ((paramInt == -29120) || (paramInt == -29150) || (paramInt == -21122) || (paramInt == -28123) || (paramInt == -25081) || (paramInt == -28126) || (paramInt == -6101) || (paramInt == -7003) || (paramInt == -403) || (paramInt == -9006) || (paramInt == -9004) || (paramInt == -9017) || (paramInt == -2813)) {
          return 9042L;
        }
        return paramInt;
      }
      switch ((int)paramLong)
      {
      default: 
        return paramLong;
      case 0: 
        return 0L;
      case 101: 
        return 9037L;
      case 201: 
        return 9001L;
      case 300: 
      case 301: 
      case 302: 
      case 303: 
      case 400: 
        if ((AppNetConnInfo.isNetSupport()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {
          return 9052L;
        }
        return 9004L;
      }
    } while ((AppNetConnInfo.isNetSupport()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()));
    return 9004L;
    return 9343L;
    return 9321L;
    if ((AppNetConnInfo.isNetSupport()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {
      return 9050L;
    }
    return 9004L;
    return 9056L;
    return 9058L;
    return 9009L;
    return -9527L;
    if (b()) {
      return 9040L;
    }
    return 9003L;
    return 9040L;
    return 9082L;
  }
  
  private boolean b()
  {
    if (bdep.a()) {}
    for (long l = bdep.a() * 1024L; this.jdField_a_of_type_Areg.d > l; l = bdep.b() * 1024L) {
      return true;
    }
    return false;
  }
  
  protected String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "actFileDown";
    }
    return "actPDFileDownload";
  }
  
  protected HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_Areg != null) {
      localHashMap.putAll(this.jdField_a_of_type_Areg.a());
    }
    localHashMap.put("param_SubReason", String.valueOf(this.jdField_a_of_type_Long));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.getReportData());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null) {
      localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.getReportData());
    }
    if (this.jdField_b_of_type_Long != 0L) {
      localHashMap.put("param_SrvRetCode", String.valueOf(this.jdField_b_of_type_Long));
    }
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Areg.jdField_a_of_type_Long = 5L;
    this.jdField_a_of_type_Long = 3L;
    this.jdField_a_of_type_Areg.jdField_b_of_type_Long = 9004L;
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Long = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    areg localareg = new areg();
    localareg.jdField_b_of_type_Int = this.jdField_a_of_type_Areg.jdField_b_of_type_Int;
    localareg.jdField_a_of_type_Int = this.jdField_a_of_type_Areg.jdField_a_of_type_Int;
    localareg.c = this.jdField_a_of_type_Areg.c;
    localareg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Areg.jdField_a_of_type_JavaLangString;
    localareg.d = this.jdField_a_of_type_Areg.d;
    localareg.jdField_a_of_type_Long = paramInt1;
    localareg.jdField_b_of_type_Long = paramInt2;
    super.a(localareg, paramExcitingTransferOneSlotComplete);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize != -1L) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramLong;
  }
  
  public void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHttpFirstTime = (paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataTime - paramExcitingTransferDownloadCompletedInfo.m_uStartTime);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = paramExcitingTransferDownloadCompletedInfo.m_uFirstRecvDataSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo != null)
    {
      localHashMap.put("serverip", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_Server", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_ftnIP", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_strLastServerHost));
      localHashMap.put("param_retry", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uRetryTimes));
      localHashMap.put("param_FailCode", String.valueOf(a(this.jdField_a_of_type_Areg.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode)));
      localHashMap.put("param_fsized", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize));
      localHashMap.put("param_ipStackType", String.valueOf(arsx.a()));
      localHashMap.put("param_realTransferType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uProxyType));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes != 0L) {
        localHashMap.put("param_speed", String.valueOf((float)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize / 1048576L) / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes));
      }
    }
    for (;;)
    {
      localHashMap.put("param_uuid", "");
      localHashMap.put("param_MD5", "");
      localHashMap.put("param_fsizeo", String.valueOf(this.jdField_a_of_type_Areg.d));
      localHashMap.put("param_PeerUin", String.valueOf(this.jdField_a_of_type_Areg.c));
      localHashMap.put("param_url", String.valueOf(""));
      localHashMap.put("param_rspHeader", String.valueOf(""));
      localHashMap.put("param_nSessionId", String.valueOf(""));
      localHashMap.put("param_fromType", String.valueOf("1"));
      return localHashMap;
      localHashMap.put("param_speed", "0");
      continue;
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Areg.jdField_b_of_type_Long));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Areg.jdField_a_of_type_Long = 1L;
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Long = 3L;; this.jdField_a_of_type_Long = 2L)
    {
      this.jdField_a_of_type_Areg.jdField_b_of_type_Long = 9037L;
      a(false);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Areg.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Areg.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = ayzl.a();
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Areg.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 7L;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Areg.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = ayzl.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arer
 * JD-Core Version:    0.7.0.1
 */