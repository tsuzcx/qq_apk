package com.tencent.biz.pubaccount.weishi_new.report;

import axrl;
import com.google.gson.Gson;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import sne;

public class WSStatisticsReporter
{
  private static final String TAG = "WSStatisticsReporter";
  private String mEventName;
  private boolean mFlush;
  private HashMap<String, String> mReportParams = new HashMap();
  
  private WSStatisticsReporter() {}
  
  private WSStatisticsReporter(WSStatisticsReporter.Builder paramBuilder)
  {
    this.mEventName = WSStatisticsReporter.Builder.access$000(paramBuilder);
    this.mFlush = WSStatisticsReporter.Builder.access$100(paramBuilder);
    WSStatisticsBaseCollector.setExtendInfo(new Gson().toJson(WSStatisticsReporter.Builder.access$200(paramBuilder)));
    this.mReportParams.putAll(WSStatisticsReporter.Builder.access$300(paramBuilder));
    this.mReportParams.putAll(WSStatisticsBaseCollector.getBaseParams());
  }
  
  public void report()
  {
    axrl.a(BaseApplication.getContext()).a(null, this.mEventName, true, 0L, 0L, this.mReportParams, "", this.mFlush);
    sne.b("WSStatisticsReporter", "event report: " + this.mEventName + " params:" + this.mReportParams.toString() + " isFlush: " + this.mFlush);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter
 * JD-Core Version:    0.7.0.1
 */