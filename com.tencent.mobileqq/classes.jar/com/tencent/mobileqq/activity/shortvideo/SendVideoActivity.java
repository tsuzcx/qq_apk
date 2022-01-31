package com.tencent.mobileqq.activity.shortvideo;

import agyc;
import ajlj;
import ajye;
import ajyg;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import azds;
import azey;
import bamw;
import batw;
import bdlq;
import bhoe;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class SendVideoActivity
  extends BaseActivity
  implements Handler.Callback
{
  private static bhoe a;
  
  public static void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("sv_encode_max_bitrate", -1);
    if (i > 0) {
      azds.r = i;
    }
    i = paramIntent.getIntExtra("sv_encode_min_bitrate", -1);
    if (i > 0) {
      azds.s = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmax", -1);
    if (i > 0) {
      azds.t = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmin", -1);
    if (i > 0) {
      azds.u = i;
    }
    i = paramIntent.getIntExtra("sv_encode_qmaxdiff", -1);
    if (i > 0) {
      azds.v = i;
    }
    i = paramIntent.getIntExtra("sv_encode_ref_frame", -1);
    if (i > 0) {
      azds.w = i;
    }
    i = paramIntent.getIntExtra("sv_encode_smooth", -1);
    if (i > 0) {
      azds.x = i;
    }
    azds.E = paramIntent.getIntExtra("sv_encode_totaltime_adjust", 0);
    azds.F = paramIntent.getIntExtra("sv_encode_timestamp_fix", 0);
    azds.G = paramIntent.getIntExtra("sv_encode_bless_audio_time_low", 0);
    azds.H = paramIntent.getIntExtra("sv_encode_bless_audio_time_high", 0);
    azds.I = paramIntent.getIntExtra("sv_encode_bless_audio_time_ratio", 65537);
    azds.a(paramIntent.getBooleanExtra("sv_encode_baseline_mp4", false));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = getIntent().getIntExtra("file_send_business_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SendVideoActivity", 2, "doOnCreate(), ===>> busiType=" + i + ",VideoFileDir = " + getIntent().getStringExtra("file_video_source_dir"));
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "doOnCreate(), <<===");
      }
      return true;
      new ajyg(this, null).execute(new Void[0]);
      continue;
      paramBundle = getIntent().getStringExtra("activity_before_enter_send_video");
      if ((paramBundle != null) && (ShortVideoPreviewActivity.class.getName().equals(paramBundle)))
      {
        new ajye(this).execute(new Void[0]);
      }
      else
      {
        ThreadManager.getSubThreadHandler().post(new SendVideoActivity.SendTask(this, null));
        if (getIntent().getIntExtra("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
        {
          int j = getIntent().getIntExtra("uintype", -1);
          i = 3;
          if (j == 1) {
            i = 1;
          }
          for (;;)
          {
            ajlj.a("", "0X80088E4", String.valueOf(i));
            azey.a(this.app, false);
            break;
            if (j == 3000) {
              i = 2;
            }
          }
          paramBundle = getIntent().getStringExtra("uin");
          if (QLog.isColorLevel()) {
            QLog.d("SendVideoActivity", 2, "doOnCreate, uin= " + paramBundle);
          }
          if ((paramBundle != null) && (paramBundle.equals("0")))
          {
            j = getIntent().getIntExtra("uintype", -1);
            if (j != 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("SendVideoActivity", 2, "doOnCreate error, uinType= " + j + " busiType= " + i);
              }
              finish();
            }
            else
            {
              a = new bhoe(this);
              a.sendEmptyMessageDelayed(1, 45000L);
            }
          }
          else
          {
            ThreadManager.getSubThreadHandler().post(new SendVideoActivity.SendTask(this, null));
            continue;
            ThreadManager.getSubThreadHandler().post(new SendVideoActivity.SendTask(this, null));
          }
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (a != null) {
      a.removeMessages(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("SendVideoActivity", 2, "handleMessage: send video timeout!");
      }
      paramMessage = ((agyc)getAppInterface().getManager(138)).a();
      if (paramMessage != null)
      {
        bdlq localbdlq = this.app.a().a(paramMessage.frienduin, paramMessage.uniseq);
        if ((localbdlq != null) && (ShortVideoUploadProcessor.class.isInstance(localbdlq)))
        {
          boolean bool = ((bamw)localbdlq).d();
          int i = paramMessage.videoFileStatus;
          if ((bool) || (i == 1002) || (i == 1001)) {
            this.app.a().d(paramMessage.frienduin, paramMessage.uniseq);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.SendVideoActivity
 * JD-Core Version:    0.7.0.1
 */