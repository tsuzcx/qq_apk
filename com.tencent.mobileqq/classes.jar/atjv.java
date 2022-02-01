import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class atjv
  extends atjj
{
  int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  public final atjk a;
  private ExcitingTransferDownloadCompletedInfo jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo;
  private ExcitingTransferDownloaderFirstPkgRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp;
  List<Integer> jdField_a_of_type_JavaUtilList = null;
  Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = null;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  int c = 0;
  
  public atjv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Atjk = new atjk();
  }
  
  private long a(long paramLong, int paramInt)
  {
    if (paramLong == 9004L) {
      return paramLong;
    }
    if ((paramLong != 0L) && (paramInt != 0))
    {
      f();
      if (this.jdField_a_of_type_JavaUtilList.indexOf(Integer.valueOf(paramInt)) >= 0) {
        return 9042L;
      }
      return paramInt;
    }
    g();
    if (paramLong < 300L) {}
    switch ((int)paramLong)
    {
    default: 
      if ((!AppNetConnInfo.isNetSupport()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin())) {
        return 9004L;
      }
      break;
    case 0: 
      return 0L;
    case 101: 
      return 9037L;
    case 201: 
      return 9001L;
    }
    g();
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramLong))).intValue();
    }
    switch ((int)paramLong)
    {
    default: 
      return paramLong;
    case 501: 
    case 502: 
    case 503: 
    case 505: 
      if (b()) {
        return 9040L;
      }
      return 9003L;
    case 506: 
      return 9040L;
    }
    return 9082L;
  }
  
  private boolean b()
  {
    if (bgjq.a()) {}
    for (long l = bgjq.a() * 1024L; this.jdField_a_of_type_Atjk.d > l; l = bgjq.b() * 1024L) {
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
    if (this.jdField_a_of_type_Atjk != null) {
      localHashMap.putAll(this.jdField_a_of_type_Atjk.a());
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
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
    localHashMap.put("param_stackType", String.valueOf(atwt.b()));
    localHashMap.put("param_loginType", String.valueOf(atwt.c()));
    localHashMap.put("param_ishttps", String.valueOf(this.c));
    return localHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Atjk.jdField_a_of_type_Long = 5L;
    this.jdField_a_of_type_Long = 3L;
    this.jdField_a_of_type_Atjk.jdField_b_of_type_Long = 9004L;
    a(false);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Long = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    atjk localatjk = new atjk();
    localatjk.jdField_b_of_type_Int = this.jdField_a_of_type_Atjk.jdField_b_of_type_Int;
    localatjk.jdField_a_of_type_Int = this.jdField_a_of_type_Atjk.jdField_a_of_type_Int;
    localatjk.c = this.jdField_a_of_type_Atjk.c;
    localatjk.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Atjk.jdField_a_of_type_JavaLangString;
    localatjk.d = this.jdField_a_of_type_Atjk.d;
    localatjk.jdField_a_of_type_Long = paramInt1;
    localatjk.jdField_b_of_type_Long = paramInt2;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
    if (paramExcitingTransferOneSlotComplete != null) {
      localHashMap.put("param_ipAddrType", String.valueOf(atwt.b(paramExcitingTransferOneSlotComplete.m_strIp)));
    }
    for (;;)
    {
      localHashMap.put("param_stackType", String.valueOf(atwt.b()));
      localHashMap.put("param_loginType", String.valueOf(atwt.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.c));
      super.a(localatjk, paramExcitingTransferOneSlotComplete, localHashMap);
      return;
      localHashMap.put("param_ipAddrType", String.valueOf(0));
    }
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
      localHashMap.put("param_FailCode", String.valueOf(a(this.jdField_a_of_type_Atjk.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode)));
      localHashMap.put("param_fsized", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize));
      localHashMap.put("param_ipStackType", String.valueOf(atwt.a()));
      localHashMap.put("param_realTransferType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uProxyType));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes != 0L) {
        localHashMap.put("param_speed", String.valueOf((float)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uDownloadedSize / 1048576L) / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo.m_uTotalTimes));
      }
    }
    for (;;)
    {
      localHashMap.put("param_uuid", "");
      localHashMap.put("param_MD5", "");
      localHashMap.put("param_fsizeo", String.valueOf(this.jdField_a_of_type_Atjk.d));
      localHashMap.put("param_PeerUin", String.valueOf(this.jdField_a_of_type_Atjk.c));
      localHashMap.put("param_url", String.valueOf(""));
      localHashMap.put("param_rspHeader", String.valueOf(""));
      localHashMap.put("param_nSessionId", String.valueOf(""));
      localHashMap.put("param_fromType", String.valueOf("1"));
      localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_stackType", String.valueOf(atwt.b()));
      localHashMap.put("param_loginType", String.valueOf(atwt.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.c));
      return localHashMap;
      localHashMap.put("param_speed", "0");
      continue;
      localHashMap.put("param_FailCode", String.valueOf(this.jdField_a_of_type_Atjk.jdField_b_of_type_Long));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Atjk.jdField_a_of_type_Long = 1L;
    if (this.jdField_a_of_type_Boolean) {}
    for (this.jdField_a_of_type_Long = 3L;; this.jdField_a_of_type_Long = 2L)
    {
      this.jdField_a_of_type_Atjk.jdField_b_of_type_Long = 9037L;
      a(false);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_Atjk.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Atjk.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSStartTime = bbyp.a();
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_Atjk.jdField_a_of_type_Long = 2L;
    this.jdField_a_of_type_Long = 7L;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Atjk.jdField_b_of_type_Long = paramLong;
    a(false);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.c = i;
      return;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloaderFirstPkgRp.mCSEndTime = bbyp.a();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void f()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29120));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29120));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-29150));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-21122));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-28123));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-25081));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-28126));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-6101));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-7003));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-403));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9006));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9004));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-9017));
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(-2813));
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(300), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(301), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(302), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(303), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(400), Integer.valueOf(9052));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(304), Integer.valueOf(304));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(305), Integer.valueOf(305));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(306), Integer.valueOf(306));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(307), Integer.valueOf(307));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(308), Integer.valueOf(308));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(401), Integer.valueOf(9343));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(402), Integer.valueOf(9321));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(403), Integer.valueOf(9050));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(405), Integer.valueOf(9058));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(406), Integer.valueOf(9058));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(407), Integer.valueOf(9009));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(408), Integer.valueOf(-9527));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(404), Integer.valueOf(9056));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjv
 * JD-Core Version:    0.7.0.1
 */