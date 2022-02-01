package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

class QCircleBaseFragment$1$1
  implements Runnable
{
  QCircleBaseFragment$1$1(QCircleBaseFragment.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.getActivity() == null) {
      return;
    }
    long l = System.currentTimeMillis() - this.a.this$0.getActivity().getIntent().getLongExtra("key_bundle_open_page_time", -1L);
    QLog.i("KEY_BUNDLE_OPEN_PAGE_TIME", 1, String.format("FragmentName:%s,pageId:%d, firstRender cost:%d", new Object[] { this.a.this$0.getClass().getSimpleName(), Integer.valueOf(this.a.this$0.a()), Long.valueOf(l) }));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleReportHelper.newEntry("refer", String.valueOf(this.a.this$0.a())));
    localArrayList.add(QCircleReportHelper.newEntry("attach_info", String.valueOf(l)));
    QCircleQualityReporter.reportQualityEvent("key_page_first_render_time_event", localArrayList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment.1.1
 * JD-Core Version:    0.7.0.1
 */