import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;

final class bhfs
  extends AsyncTask<Void, Void, Void>
{
  bhfs(String paramString1, int paramInt, String paramString2) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = bhgy.a(ServerConfigManager.ConfigType.common, bhfr.p());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS openStr ：" + paramVarArgs);
    }
    if ((paramVarArgs == null) || (!"1".equals(paramVarArgs))) {
      return null;
    }
    int i;
    for (;;)
    {
      try
      {
        localSharedPreferences = bhfr.a();
        if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_Int <= 0)) {
          break label631;
        }
        if ((this.jdField_a_of_type_Int >= 60) && (QLog.isDevelopLevel())) {
          QLog.e("PerformanceReportUtils", 4, "reportFPS  fps error fpsvalue :" + this.jdField_a_of_type_Int);
        }
        l2 = localSharedPreferences.getLong(this.jdField_a_of_type_JavaLangString, 0L);
        l1 = bhfr.a();
        paramVarArgs = bhgy.a(ServerConfigManager.ConfigType.common, bhfr.q());
        if (paramVarArgs == null) {}
      }
      catch (Exception paramVarArgs)
      {
        SharedPreferences localSharedPreferences;
        long l2;
        long l1;
        HashMap localHashMap;
        BaseApplicationImpl localBaseApplicationImpl;
        break label631;
        i = 1;
        continue;
      }
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("PerformanceReportUtils", 4, "reportFPS  server time：" + paramVarArgs);
        }
        l1 = Long.valueOf(paramVarArgs).longValue();
        l1 *= 1000L;
      }
      catch (Exception paramVarArgs)
      {
        l1 = bhfr.a();
        continue;
        paramVarArgs = this.jdField_a_of_type_JavaLangString + "_new";
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportFPS report_time ：" + l1 + ",lastRp" + l2 + ",reportFPS fpsvalue：" + this.jdField_a_of_type_Int);
    }
    if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2))
    {
      if (SystemClock.uptimeMillis() - l2 < l1) {
        break label633;
      }
      break label626;
      bool = UnifiedMonitor.a().whetherReportThisTime(12, false);
      if ((i == 0) && (!bool)) {
        break label631;
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FPS", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("aioBusiness", this.b);
      localHashMap.put("theme_Id", QQAppInterface.getCurrentThemeId());
      localHashMap.put("param_threadOpId", String.valueOf(aoem.a().a()));
      if (QLog.isDevelopLevel()) {
        QLog.d("PerformanceReportUtils", 4, "reportFPS real report  fpsvalue：" + this.jdField_a_of_type_Int);
      }
      localHashMap.put("param_DeviceType", String.valueOf(aklj.a()));
      paramVarArgs = null;
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (localBaseApplicationImpl != null) {
        paramVarArgs = localBaseApplicationImpl.getRuntime();
      }
      if ((paramVarArgs != null) && ((paramVarArgs instanceof QQAppInterface)))
      {
        if (((QQAppInterface)paramVarArgs).mAutomator.a == 0L) {
          break label638;
        }
        bool = true;
        label457:
        localHashMap.put("param_is_logining", String.valueOf(bool));
        if (((QQAppInterface)paramVarArgs).mAutomator.c()) {
          break label644;
        }
      }
    }
    label644:
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("param_syncing_msg", String.valueOf(bool));
      localHashMap.put("param_NetType", String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
      if (i != 0)
      {
        paramVarArgs = this.jdField_a_of_type_JavaLangString;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(bhgy.a(), paramVarArgs, bhfr.a(this.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_Int, 0L, localHashMap, bhfr.o());
        if (i == 0) {
          break label631;
        }
        localSharedPreferences.edit().putLong(this.jdField_a_of_type_JavaLangString, SystemClock.uptimeMillis()).commit();
      }
      label626:
      label631:
      return null;
      label633:
      i = 0;
      break;
      label638:
      bool = false;
      break label457;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfs
 * JD-Core Version:    0.7.0.1
 */