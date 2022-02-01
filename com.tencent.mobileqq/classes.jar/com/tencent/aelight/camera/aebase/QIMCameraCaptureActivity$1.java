package com.tencent.aelight.camera.aebase;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;

class QIMCameraCaptureActivity$1
  implements Runnable
{
  QIMCameraCaptureActivity$1(QIMCameraCaptureActivity paramQIMCameraCaptureActivity, int paramInt) {}
  
  public void run()
  {
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "enter_story_capture_count", true, 0L, 0L, null, "");
    StoryReportor.a("video_shoot_new", "shoot_exp", StoryReportor.c(this.a), 0, new String[] { "", "", "", String.valueOf(this.this$0.getIntent().getIntExtra("entrance_type", 0)) });
    boolean bool = TextUtils.isEmpty(this.this$0.getIntent().getStringExtra("KEY_ISENTER_SO_DOWNLOAD"));
    AEBaseDataReporter.a().b(bool ^ true);
    try
    {
      AEBaseDataReporter.a().al();
      return;
    }
    catch (Exception localException)
    {
      AEQLog.d("QIMCameraCaptureActivity", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMCameraCaptureActivity.1
 * JD-Core Version:    0.7.0.1
 */