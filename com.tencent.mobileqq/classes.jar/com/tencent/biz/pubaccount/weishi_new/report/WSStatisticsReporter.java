package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboExpHelper;
import com.tencent.biz.pubaccount.weishi_new.combo.WSComboHelper;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetService;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSNetUtil;
import com.tencent.biz.pubaccount.weishi_new.request.newreq.WSBeaconSendRequest;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class WSStatisticsReporter
{
  public static final String BEACON_REALTIME_DEBUG_KEY = "0M000A1RC72MXXRH";
  public static final int REPORT_REQUEST_ERROR_TYPE_CLIENT = 1;
  public static final int REPORT_REQUEST_ERROR_TYPE_PARSE_DATA = 3;
  public static final int REPORT_REQUEST_ERROR_TYPE_SERVER = 2;
  private static final String TAG = "WSStatisticsReporter";
  private static final String TAG_VIDEO_SESSION = "reportVideoSession";
  private WSStatisticsBaseCollector mBaseCollector;
  private WSStatisticsReporter.Builder mBuilder;
  private String mEventName;
  private boolean mFlush;
  private boolean mIsSendServer;
  private HashMap<String, String> mReportParams = new HashMap();
  
  private WSStatisticsReporter() {}
  
  private WSStatisticsReporter(WSStatisticsReporter.Builder paramBuilder)
  {
    this.mEventName = WSStatisticsReporter.Builder.access$000(paramBuilder);
    this.mFlush = WSStatisticsReporter.Builder.access$100(paramBuilder);
    this.mIsSendServer = WSStatisticsReporter.Builder.access$200(paramBuilder);
    this.mBaseCollector = WSStatisticsReporter.Builder.access$300(paramBuilder);
    this.mBuilder = paramBuilder;
  }
  
  private void addGeneralExtParams(Map<String, String> paramMap)
  {
    paramMap.put("scenes_channel_from", getEnterPublicAccFrom());
    paramMap.put("last_test_id", WSPublicAccReport.getInstance().getLocalTestId());
    paramMap.put("teen", String.valueOf(WSNetUtil.b()));
    if (WSComboExpHelper.a.a()) {
      paramMap.put("bottom_tab_id", WSComboHelper.a.a());
    }
  }
  
  private void beaconData2Server()
  {
    WSNetService.a(new WSBeaconSendRequest(this.mEventName, this.mReportParams)).a(new WSStatisticsReporter.2(this));
  }
  
  private static String getEnterPublicAccFrom()
  {
    String str = WSPublicAccReport.getInstance().getEnterPublicAccFrom();
    switch (str.hashCode())
    {
    default: 
      break;
    case 1977485053: 
      if (str.equals("from_search_rzh_ws")) {
        i = 1;
      }
      break;
    case 1949083137: 
      if (str.equals("from_trends_tab")) {
        i = 0;
      }
      break;
    case 1330251343: 
      if (str.equals("from_qq_scheme")) {
        i = 6;
      }
      break;
    case 1312853792: 
      if (str.equals("from_audio_assistant")) {
        i = 3;
      }
      break;
    case 712893722: 
      if (str.equals("from_operation_h5")) {
        i = 7;
      }
      break;
    case 403146370: 
      if (str.equals("from_qq_chat")) {
        i = 4;
      }
      break;
    case 15659634: 
      if (str.equals("from_user_contacts")) {
        i = 2;
      }
      break;
    case -314972999: 
      if (str.equals("from_open_home_then_video")) {
        i = 8;
      }
      break;
    case -1142266013: 
      if (str.equals("from_search_trends_ws")) {
        i = 5;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return "0";
    case 6: 
    case 7: 
    case 8: 
      return WSPublicAccReport.getInstance().getScenesChannelFrom();
    case 5: 
      return "10";
    case 4: 
      return "6";
    case 3: 
      return "5";
    case 2: 
      return "3";
    case 1: 
      return "2";
    }
    return "1";
  }
  
  private void printReportLog()
  {
    if (QLog.isColorLevel())
    {
      HashMap localHashMap = new HashMap(WSStatisticsReporter.Builder.access$1000(this.mBuilder));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventReport feedPassKey:");
      localStringBuilder.append((String)localHashMap.get("feed_pass_key"));
      WSLog.b("WSReportFeedPassKey", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("EventReport globalKey:");
      localStringBuilder.append((String)localHashMap.get("global_key"));
      WSLog.b("WSReportFeedGlobalKey", localStringBuilder.toString());
      localHashMap.remove("feed_pass_key");
      localHashMap.remove("global_key");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[EventReport] mSceneFrom:");
      localStringBuilder.append((String)this.mReportParams.get("scenes_from"));
      localStringBuilder.append(", mEventName:");
      localStringBuilder.append(this.mEventName);
      localStringBuilder.append(", mSopName:");
      localStringBuilder.append((String)this.mReportParams.get("sop_name"));
      localStringBuilder.append(", mPosition:");
      localStringBuilder.append((String)this.mReportParams.get("position"));
      localStringBuilder.append(", mSubSessionId:");
      localStringBuilder.append((String)this.mReportParams.get("sub_session_id"));
      localStringBuilder.append(", mTabId:");
      localStringBuilder.append((String)WSStatisticsReporter.Builder.access$800(this.mBuilder).get("tab_id"));
      localStringBuilder.append(", mCustomParams:");
      localStringBuilder.append(localHashMap.toString());
      localStringBuilder.append(", mBaseParams:");
      localStringBuilder.append(this.mBaseCollector.getBaseParams().toString());
      WSLog.e("WSStatisticsReporter", localStringBuilder.toString());
    }
  }
  
  private void reportRequestFailure(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.mEventName;
    Object localObject1 = this.mReportParams;
    String str2 = "";
    String str1;
    if (localObject1 != null)
    {
      str1 = (String)((HashMap)localObject1).get("position");
      localObject1 = (String)this.mReportParams.get("sop_name");
    }
    else
    {
      str1 = "";
      localObject1 = str1;
    }
    localHashMap.put("event_name", localObject2);
    localObject2 = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject2 = "";
    }
    localHashMap.put("position", localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = str2;
    }
    localHashMap.put("sop_name", localObject1);
    localHashMap.put("err_type", paramString1);
    localHashMap.put("err_code", paramString2);
    localHashMap.put("err_msg", paramString3);
    WSReportDc00898.a(localHashMap);
    WsBeaconReportPresenter.a().a(localHashMap);
  }
  
  public void report()
  {
    String str = WSReportUtils.c();
    ThreadManager.getSubThreadHandler().post(new WSStatisticsReporter.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter
 * JD-Core Version:    0.7.0.1
 */