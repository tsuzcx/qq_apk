package com.tencent.biz.pubaccount.weishi_new.report;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import mqq.os.MqqHandler;
import ujn;
import uju;
import umw;
import una;
import unb;
import uni;

public class WSStatisticsReporter
{
  public static final String BEACON_REALTIME_DEBUG_KEY = "0M000A1RC72MXXRH";
  public static final int REPORT_REQUEST_ERROR_TYPE_CLIENT = 1;
  public static final int REPORT_REQUEST_ERROR_TYPE_PARSE_DATA = 3;
  public static final int REPORT_REQUEST_ERROR_TYPE_SERVER = 2;
  private static final String TAG = "WSStatisticsReporter";
  private WSStatisticsBaseCollector mBaseCollector;
  private WSStatisticsReporter.Builder mBuilder;
  private String mEventName;
  private boolean mFlush;
  private boolean mIsImmediatelyUpload;
  private HashMap<String, String> mReportParams = new HashMap();
  
  private WSStatisticsReporter() {}
  
  private WSStatisticsReporter(WSStatisticsReporter.Builder paramBuilder)
  {
    this.mEventName = WSStatisticsReporter.Builder.access$000(paramBuilder);
    this.mFlush = WSStatisticsReporter.Builder.access$100(paramBuilder);
    this.mIsImmediatelyUpload = WSStatisticsReporter.Builder.access$200(paramBuilder);
    this.mBaseCollector = WSStatisticsReporter.Builder.access$300(paramBuilder);
    this.mBuilder = paramBuilder;
  }
  
  private void beaconData2Server()
  {
    uju localuju = new uju(new uni(this.mEventName, this.mReportParams), null, new una(this), 4009);
    ujn.a().a(localuju);
  }
  
  private void reportRequestFailure(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    Object localObject2 = this.mEventName;
    Object localObject1 = "";
    String str = "";
    if (this.mReportParams != null)
    {
      localObject1 = (String)this.mReportParams.get("position");
      str = (String)this.mReportParams.get("sop_name");
    }
    localHashMap.put("event_name", localObject2);
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "";
    }
    localHashMap.put("position", localObject2);
    localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = "";
    }
    localHashMap.put("sop_name", localObject1);
    localHashMap.put("err_type", paramString1);
    localHashMap.put("err_code", paramString2);
    localHashMap.put("err_msg", paramString3);
    umw.a(localHashMap);
    unb.a().a(localHashMap);
  }
  
  public void report()
  {
    ThreadManager.getSubThreadHandler().post(new WSStatisticsReporter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter
 * JD-Core Version:    0.7.0.1
 */