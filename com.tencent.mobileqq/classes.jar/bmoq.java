import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.QUA;
import cooperation.vip.pb.TianShuReport.UserActionReport;
import cooperation.vip.pb.TianShuReport.UserCommReport;
import cooperation.vip.tianshu.TianShuManager;
import cooperation.vip.tianshu.TianShuReportData;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;

public class bmoq
{
  private static String a = "";
  private static String b = "";
  
  public static Bundle a(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            QLog.e("tools", 1, "parseUrlParams", localIllegalArgumentException);
          }
        }
      }
    }
    return localBundle;
  }
  
  public static TianShuReport.UserActionReport a(TianShuReportData paramTianShuReportData)
  {
    TianShuReport.UserActionReport localUserActionReport = new TianShuReport.UserActionReport();
    a(localUserActionReport, paramTianShuReportData);
    localUserActionReport.appid.set(String.valueOf(paramTianShuReportData.mAppId));
    localUserActionReport.to_uid.set(String.valueOf(paramTianShuReportData.mToUid));
    localUserActionReport.trace_detail.set(String.valueOf(paramTianShuReportData.mTraceDetail));
    localUserActionReport.trace_index.set(String.valueOf(paramTianShuReportData.mTraceIndex));
    localUserActionReport.page_id.set(String.valueOf(paramTianShuReportData.mPageId));
    localUserActionReport.item_id.set(String.valueOf(paramTianShuReportData.mItemId));
    localUserActionReport.sub_item_id.set(String.valueOf(paramTianShuReportData.mSubItemId));
    localUserActionReport.module_id.set(String.valueOf(paramTianShuReportData.mModuleId));
    localUserActionReport.sub_module_id.set(String.valueOf(paramTianShuReportData.mSubModuleId));
    localUserActionReport.position_id.set(String.valueOf(paramTianShuReportData.mPositionId));
    localUserActionReport.test_id.set(paramTianShuReportData.mTestId);
    localUserActionReport.rule_id.set(paramTianShuReportData.mRuleId);
    localUserActionReport.oper_time.set(paramTianShuReportData.mOperTime);
    localUserActionReport.action_id.set(paramTianShuReportData.mActionId);
    localUserActionReport.action_value.set(paramTianShuReportData.mActionValue);
    localUserActionReport.action_attr.set(paramTianShuReportData.mActionAttr);
    localUserActionReport.busi_info.set(String.valueOf(paramTianShuReportData.mBusiInfo));
    localUserActionReport.item_type.set(String.valueOf(paramTianShuReportData.mItemType));
    return localUserActionReport;
  }
  
  public static TianShuReport.UserCommReport a()
  {
    TianShuReport.UserCommReport localUserCommReport = new TianShuReport.UserCommReport();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    localUserCommReport.uid.set(str);
    localUserCommReport.guid.set(String.valueOf(b()));
    str = LbsManagerService.getCityCode();
    localUserCommReport.city_code.set(String.valueOf(str));
    localUserCommReport.platform.set("AND");
    localUserCommReport.client_type.set("SQ");
    localUserCommReport.app_version.set(AppSetting.f());
    localUserCommReport.qua.set(String.valueOf(QUA.getQUA3()));
    localUserCommReport.network_type.set(c());
    localUserCommReport.mobile_type.set(String.valueOf(Build.MODEL));
    localUserCommReport.os_version.set(String.valueOf(DeviceInfoUtil.getDeviceOSVersion()));
    localUserCommReport.qimei.set(String.valueOf(a()));
    return localUserCommReport;
  }
  
  public static String a()
  {
    if ((b != null) && (b.length() > 0)) {
      return b;
    }
    try
    {
      b = UserAction.getQIMEI();
      label25:
      return b;
    }
    catch (Exception localException)
    {
      break label25;
    }
  }
  
  private static void a(TianShuReport.UserActionReport paramUserActionReport, TianShuReportData paramTianShuReportData)
  {
    String str = paramTianShuReportData.mTraceId;
    if (TextUtils.isEmpty(str))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      str = "";
      if (localAppRuntime != null) {
        str = localAppRuntime.getAccount();
      }
      if (!TextUtils.isEmpty(str))
      {
        str = str + "_" + NetConnInfoCenter.getServerTime();
        paramUserActionReport.trace_id.set(str);
      }
      str = String.valueOf(paramTianShuReportData.mTriggerInfo);
      if (!TextUtils.isEmpty(str)) {
        break label171;
      }
      str = TianShuManager.getInstance().getTraceInfoFromCache(String.valueOf(paramTianShuReportData.mItemId));
      if (!TextUtils.isEmpty(str)) {
        paramUserActionReport.trigger_info.set(str);
      }
    }
    for (;;)
    {
      int j = paramTianShuReportData.mTraceNum;
      int i = j;
      if (j == -1) {
        i = 1;
      }
      paramUserActionReport.trace_num.set(i);
      return;
      paramUserActionReport.trace_id.set(String.valueOf(str));
      break;
      label171:
      paramUserActionReport.trigger_info.set(str);
    }
  }
  
  public static String b()
  {
    if ((a != null) && (a.length() > 0)) {
      return a;
    }
    try
    {
      a = QQDeviceInfo.getIMEI("07aa5e");
      label28:
      return a;
    }
    catch (Exception localException)
    {
      break label28;
    }
  }
  
  public static String c()
  {
    switch (NetworkUtil.getNetworkType(BaseApplicationImpl.getContext()))
    {
    default: 
      return "UNKNOW";
    case 1: 
      return "WIFI";
    case 4: 
      return "4G";
    case 3: 
      return "3G";
    }
    return "2G";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmoq
 * JD-Core Version:    0.7.0.1
 */