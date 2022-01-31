package com.tencent.av.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.mediacodec.VideoDecTest;
import com.tencent.av.mediacodec.VideoEncTest;
import com.tencent.av.mediacodec.config.CodecConfigParser;
import com.tencent.av.utils.ImageResUtil;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.av.videoeffect.config.VideoEffectConfigParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jeu;
import jev;
import jew;
import jex;

public class DeviceCapabilityExamination
{
  public VideoAppInterface a;
  
  public DeviceCapabilityExamination(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
    paramVideoAppInterface = new jex(this);
    this.a.a().postDelayed(paramVideoAppInterface, 5000L);
  }
  
  private void a()
  {
    b();
    c();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    if (!((SharedPreferences)localObject).getBoolean("hwcodec_avc_decode_test", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCapabilityExamination", 2, "startH264DecoderTest");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hwcodec_avc_decode_test", true);
      ((SharedPreferences.Editor)localObject).commit();
      new VideoDecTest(ImageResUtil.c() + "bitv.mp4", paramBoolean, new jeu(this)).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceCapabilityExamination", 2, "startH264DecoderTest decode tested.");
  }
  
  private void b()
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed");
    }
    Object localObject = ConfigSystemImpl.a(this.a.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed hwcodec test config: \n" + (String)localObject);
      }
      localObject = new CodecConfigParser((String)localObject);
      i = ((CodecConfigParser)localObject).a();
      if ((i == 1) || (i == 2))
      {
        if (!new File(ImageResUtil.c(), "bitv.mp4").exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed start download test file!");
          }
          this.a.d(0);
        }
      }
      else
      {
        i = ((CodecConfigParser)localObject).b();
        if ((i == 1) || (i == 2))
        {
          if (new File(ImageResUtil.c(), "test2Frame.yuv").exists()) {
            break label212;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed start download test file!");
          }
          this.a.d(0);
        }
      }
    }
    label212:
    while (!QLog.isColorLevel())
    {
      int i;
      return;
      if (i == 2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        a(bool1);
        break;
      }
      if (i == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        b(bool1);
        return;
      }
    }
    QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed do not need test.");
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    if (!((SharedPreferences)localObject).getBoolean("hwcodec_avc_encode_test", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed startH264EncoderTest");
      }
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hwcodec_avc_encode_test", true);
      ((SharedPreferences.Editor)localObject).commit();
      new VideoEncTest(ImageResUtil.c() + "test2Frame.yuv", paramBoolean, new jev(this)).a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("DeviceCapabilityExamination", 2, "testHWCodecIfNeed startH264EncoderTest encode tested.");
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed");
    }
    Object localObject = ConfigSystemImpl.a(this.a.getApp());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed test config: \n" + (String)localObject);
      }
      if (new VideoEffectConfigParser((String)localObject).a() == 1)
      {
        localObject = this.a.getApp().getSharedPreferences("qav_sp_video_effect", 0);
        if (((SharedPreferences)localObject).getBoolean("qav_key_test_executed", false)) {
          break label147;
        }
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean("qav_key_test_executed", true);
        ((SharedPreferences.Editor)localObject).commit();
        new VideoEffectTest(new jew(this)).a();
      }
    }
    label147:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed test executed.");
      return;
    }
    QLog.d("DeviceCapabilityExamination", 2, "testVideoEffectIfNeed do not need test.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination
 * JD-Core Version:    0.7.0.1
 */