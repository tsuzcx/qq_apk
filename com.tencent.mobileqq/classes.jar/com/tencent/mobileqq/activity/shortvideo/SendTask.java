package com.tencent.mobileqq.activity.shortvideo;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SendTask
  implements Runnable
{
  BaseActivity a;
  Intent b;
  boolean c;
  
  public SendTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.a = paramBaseActivity;
    if (paramIntent != null) {
      this.b = paramIntent;
    } else {
      this.b = this.a.getIntent();
    }
    this.c = this.b.getExtras().getBoolean("send_in_background");
  }
  
  public static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      CodecParam.mMaxrate = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      CodecParam.mMinrate = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      CodecParam.mQmax = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      CodecParam.mQmin = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      CodecParam.mMaxQdiff = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      CodecParam.mRefframe = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      CodecParam.mIsSmooth = i;
    }
    CodecParam.mEnableTotalTimeAdjust = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    CodecParam.mEnableTimestampFix = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    CodecParam.mAudioTimestampLow = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    CodecParam.mAudioTimestampHigh = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    CodecParam.mAudioTimeRatio = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    CodecParam.setEnableBaseLineMp4Flag(paramIntent.getBooleanExtra("sv_encode_baseline_mp4", false));
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "#SendTask# run(): start");
    }
    a(this.b);
    CodecParam.mRecordFrames = this.b.getIntExtra("sv_total_frame_count", 0);
    CodecParam.mRecordTime = this.b.getIntExtra("sv_total_record_time", 0);
    String str = this.b.getStringExtra("thumbfile_send_path");
    Object localObject;
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.a.runOnUiThread(new SendTask.1(this));
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#SendTask# run(): UrlDrawable status not success, path=");
        ((StringBuilder)localObject).append(str);
        QLog.d("SendVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.c) {
        this.a.runOnUiThread(new SendTask.2(this));
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#SendTask# run(): thumb not exist, path=");
        ((StringBuilder)localObject).append(str);
        QLog.e("SendVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.c) {
        this.a.runOnUiThread(new SendTask.3(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendTask
 * JD-Core Version:    0.7.0.1
 */