package com.tencent.biz.pubaccount.readinjoy.preload.util;

import com.tencent.qphone.base.util.QLog;
import ndn;
import obz;

public final class FeedsPreloadDataReport$1
  implements Runnable
{
  public FeedsPreloadDataReport$1(String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = obz.a();
    QLog.d("FeedsPreloadDataReport", 1, new Object[] { "actionName = ", this.a, "\n", "r2 = ", str, " r5 = ", this.b });
    ndn.a(null, "", this.a, this.a, 0, 0, str, "", "", this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.preload.util.FeedsPreloadDataReport.1
 * JD-Core Version:    0.7.0.1
 */