import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import mqq.app.AppRuntime;

public class anme
{
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    a(paramInt, paramString1, paramString2, null);
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ApolloTianshuReportUtil", 1, new Object[] { "tianshuReport action:", Integer.valueOf(paramInt), ", itemId=", paramString1, ",traceInfo=", paramString2, ", bizInfo=", paramString3 });
    TianShuReportData localTianShuReportData = new TianShuReportData();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localTianShuReportData.mTraceId = (str + "_" + l);
    localTianShuReportData.mTraceNum = 1;
    localTianShuReportData.mAppId = "tianshu.75";
    localTianShuReportData.mPageId = "tianshu.75";
    localTianShuReportData.mItemId = paramString1;
    localTianShuReportData.mSubItemId = "";
    localTianShuReportData.mOperTime = l;
    localTianShuReportData.mActionId = paramInt;
    localTianShuReportData.mActionValue = 1;
    localTianShuReportData.mActionAttr = 1;
    localTianShuReportData.mTriggerInfo = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      localTianShuReportData.mBusiInfo = paramString3;
    }
    TianShuManager.getInstance().report(localTianShuReportData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anme
 * JD-Core Version:    0.7.0.1
 */