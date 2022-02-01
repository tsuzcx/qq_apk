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
  Intent jdField_a_of_type_AndroidContentIntent;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  boolean jdField_a_of_type_Boolean;
  
  public SendTask(BaseActivity paramBaseActivity, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (paramIntent != null) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    } else {
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentIntent.getExtras().getBoolean("send_in_background");
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
    a(this.jdField_a_of_type_AndroidContentIntent);
    CodecParam.mRecordFrames = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_frame_count", 0);
    CodecParam.mRecordTime = this.jdField_a_of_type_AndroidContentIntent.getIntExtra("sv_total_record_time", 0);
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("thumbfile_send_path");
    Object localObject;
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      localObject = URLDrawable.getDrawable(new File(str), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).downloadImediatly();
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new SendTask.1(this));
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#SendTask# run(): UrlDrawable status not success, path=");
        ((StringBuilder)localObject).append(str);
        QLog.d("SendVideoActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new SendTask.2(this));
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
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new SendTask.3(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendTask
 * JD-Core Version:    0.7.0.1
 */