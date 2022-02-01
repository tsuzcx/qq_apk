import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.report.IMTAReporter;
import com.tencent.mobileqq.msf.sdk.report.MTAReportManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatReportStrategy;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class bcdu
  implements IMTAReporter
{
  private static volatile bcdu jdField_a_of_type_Bcdu;
  private Context jdField_a_of_type_AndroidContentContext;
  private StatSpecifyReportedInfo jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo = new StatSpecifyReportedInfo();
  private volatile String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private bcdu(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_Boolean = bcdp.a(this.jdField_a_of_type_AndroidContentContext, true);
  }
  
  public static bcdu a(Context paramContext)
  {
    if (jdField_a_of_type_Bcdu == null) {}
    try
    {
      if (jdField_a_of_type_Bcdu == null) {
        jdField_a_of_type_Bcdu = new bcdu(paramContext);
      }
      return jdField_a_of_type_Bcdu;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    StatConfig.setStatSendStrategy(StatReportStrategy.PERIOD);
    StatConfig.setSendPeriodMinutes(30);
    StatConfig.setEnableSmartReporting(true);
    StatConfig.setStatReportUrl("http://sngmta.qq.com:80/mstat/report/");
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null)
    {
      StatConfig.setCustomUserId(this.jdField_a_of_type_AndroidContentContext, str);
      if (paramBoolean)
      {
        this.jdField_a_of_type_JavaLangString = null;
        StatServiceImpl.reportQQ(this.jdField_a_of_type_AndroidContentContext, str, this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo);
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject instanceof QQAppInterface)) {
          break label175;
        }
      }
    }
    label175:
    for (Object localObject = (QQAppInterface)localObject;; localObject = null)
    {
      Date localDate = new Date(NetConnInfoCenter.getServerTimeMillis());
      bcef.b((QQAppInterface)localObject, "dc00898", "", "", "0X80075F3", "0X80075F3", 0, 0, new SimpleDateFormat("yyyyMMdd", Locale.US).format(localDate), "", "", "");
      MTAReportManager.setMTAReporter(jdField_a_of_type_Bcdu);
      if (QLog.isColorLevel()) {
        QLog.d("MTAReportController", 2, "calledBeforeStat:" + str + ", " + paramBoolean);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    StatConfig.setDebugEnable(paramBoolean);
  }
  
  public void b(String paramString)
  {
    StatConfig.setMTAPreferencesFileName(paramString);
  }
  
  public void initMtaConfig(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo.setAppKey(paramString2);
    this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo.setInstallChannel(paramString1);
    StatConfig.setEnableConcurrentProcess(true);
    StatConfig.setAutoExceptionCaught(false);
    StatServiceImpl.setContext(this.jdField_a_of_type_AndroidContentContext);
    b(false);
  }
  
  public boolean isMtaSupported()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void reportKVEvent(String paramString, Properties paramProperties)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "reportKVEvent " + paramString + " \n\t\t" + paramProperties);
    }
    b(true);
    StatServiceImpl.trackCustomKVEvent(this.jdField_a_of_type_AndroidContentContext, paramString, paramProperties, this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo);
  }
  
  public void reportTimeKVEvent(String paramString, Properties paramProperties, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "reportKVEvent " + paramString + " " + paramInt + "\n\t\t" + paramProperties);
    }
    b(true);
    StatServiceImpl.trackCustomKVTimeIntervalEvent(this.jdField_a_of_type_AndroidContentContext, paramString, paramProperties, paramInt, this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo);
  }
  
  public void trackBeginPage(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "trackBeginPage " + paramString);
    }
    b(true);
    StatServiceImpl.trackBeginPage(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo);
  }
  
  public void trackEndPage(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MTAReportController", 2, "trackEndPage " + paramString);
    }
    b(true);
    StatServiceImpl.trackEndPage(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_ComTencentStatStatSpecifyReportedInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdu
 * JD-Core Version:    0.7.0.1
 */