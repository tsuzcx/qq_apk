package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager.AblumListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import mqq.os.MqqHandler;

class QzoneSlideShowPreparingFragment$4
  implements SlideShowPhotoListManager.AblumListener
{
  QzoneSlideShowPreparingFragment$4(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void a()
  {
    QLog.d(QzoneSlideShowPreparingFragment.b(), 2, "createSlideShowNew AblumListener - endMerge.");
    QzoneSlideShowPreparingFragment.d(this.a).removeCallbacks(QzoneSlideShowPreparingFragment.a(this.a));
    ThreadManager.getUIHandler().post(new QzoneSlideShowPreparingFragment.4.1(this));
    if (QzoneSlideShowPreparingFragment.f(this.a) == 18) {
      LpReportInfo_pf00064.allReport(585, 15, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.4
 * JD-Core Version:    0.7.0.1
 */