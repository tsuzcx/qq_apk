package com.tencent.biz.pubaccount.weishi_new.report;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tgx;
import the;
import tjy;
import tka;

public class WSStatisticsReporter
{
  private static final String TAG = "WSStatisticsReporter";
  private WSStatisticsBaseCollector mBaseCollector;
  private WSStatisticsReporter.Builder mBuilder;
  private String mEventName;
  private boolean mFlush;
  private HashMap<String, String> mReportParams = new HashMap();
  
  private WSStatisticsReporter() {}
  
  private WSStatisticsReporter(WSStatisticsReporter.Builder paramBuilder)
  {
    this.mEventName = WSStatisticsReporter.Builder.access$000(paramBuilder);
    this.mFlush = WSStatisticsReporter.Builder.access$100(paramBuilder);
    this.mBaseCollector = WSStatisticsReporter.Builder.access$200(paramBuilder);
    this.mBuilder = paramBuilder;
  }
  
  private void beaconData2Server()
  {
    the localthe = new the(new tka(this.mEventName, this.mReportParams), null, new tjy(this), 4009);
    tgx.a().a(localthe);
  }
  
  public void report()
  {
    ThreadManager.getSubThreadHandler().post(new WSStatisticsReporter.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter
 * JD-Core Version:    0.7.0.1
 */