package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class WeakNetManager$1
  implements Runnable
{
  WeakNetManager$1(WeakNetManager paramWeakNetManager, long paramLong) {}
  
  public void run()
  {
    WeakNetManager.a(this.this$0, null);
    if (WeakNetHelper.a())
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131718463, 1).a();
      try
      {
        WeakNetHelper.a("0X8009D08", RIJTransMergeKanDianReport.a().a("loading_time", String.valueOf(this.a)).a());
        QLog.d("WeakNetManager", 1, "show weak net toast.");
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WeakNetManager", 1, "show weak net data report exception, e = ", localJSONException);
        }
      }
    }
    QLog.d("WeakNetManager", 1, "no need to show toast.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */