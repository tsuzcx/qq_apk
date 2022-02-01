package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.mobileqq.videocodec.audio.AudioDecodeConfig;
import com.tencent.qphone.base.util.QLog;

@TargetApi(16)
public class AudioDecoder
{
  private AudioDecoder.AudioPlayRunnable jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
  private AudioDecoder.BgmAudioPlayRunnable jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
  public AudioDecodeConfig a;
  private Thread jdField_a_of_type_JavaLangThread;
  private Thread b;
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_Int;
    int i = 1;
    byte[] arrayOfByte;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Boolean) {
              paramAudioTrack.write(paramArrayOfByte, 0, paramInt);
            }
            paramArrayOfByte = null;
            j = 0;
            paramInt = i;
            i = j;
            break label179;
          }
          paramInt = paramArrayOfByte.length * 4;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 4);
          paramArrayOfByte = arrayOfByte;
        }
        else
        {
          paramInt = paramArrayOfByte.length * 2 / 3;
          arrayOfByte = new byte[paramInt];
          AudioDataUtil.b(paramArrayOfByte, 0, arrayOfByte, paramInt);
          paramArrayOfByte = arrayOfByte;
        }
      }
      else
      {
        paramInt = paramArrayOfByte.length * 2;
        arrayOfByte = new byte[paramInt];
        AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt, 2);
        paramArrayOfByte = arrayOfByte;
      }
    }
    else
    {
      paramInt = paramArrayOfByte.length / 2;
      arrayOfByte = new byte[paramInt];
      AudioDataUtil.a(paramArrayOfByte, 0, arrayOfByte, paramInt);
      paramArrayOfByte = arrayOfByte;
    }
    j = 0;
    i = paramInt;
    paramInt = j;
    label179:
    if ((!this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Boolean) && (paramInt == 0) && (paramArrayOfByte != null)) {
      paramAudioTrack.write(paramArrayOfByte, 0, i);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).a();
      QLog.d("AudioDecoder", 4, "repeat");
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).c();
      QLog.d("AudioDecoder", 4, " bgm repeat");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    if (localObject != null)
    {
      ((AudioDecodeConfig)localObject).jdField_a_of_type_Int = paramInt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSpeedType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AudioDecoder", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).a(paramLong, this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.c);
      QLog.d("AudioDecoder", 1, new Object[] { "seekTo: ", Long.valueOf(paramLong) });
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekTo failed: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AudioDecoder", 4, ((StringBuilder)localObject).toString());
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    if (localObject == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == ((AudioDecodeConfig)localObject).jdField_a_of_type_Long) && (paramLong2 == this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Long))
    {
      SLog.d("AudioDecoder", "segment not changed, setPlayRange ignore, startTimeMs=%d, endTimeMs=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setPlayRange begin startTimeMs=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(" endTimeMs=");
    ((StringBuilder)localObject).append(paramLong2);
    QLog.d("AudioDecoder", 4, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig;
    ((AudioDecodeConfig)localObject).jdField_a_of_type_Long = paramLong1;
    ((AudioDecodeConfig)localObject).jdField_b_of_type_Long = paramLong2;
    a((AudioDecodeConfig)localObject);
  }
  
  public void a(AudioDecodeConfig paramAudioDecodeConfig)
  {
    for (;;)
    {
      float f2;
      float f3;
      float f1;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startPlay ");
        localStringBuilder.append(paramAudioDecodeConfig.toString());
        QLog.d("AudioDecoder", 4, localStringBuilder.toString());
        c();
        b();
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig == null) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig = new AudioDecodeConfig();
        }
        this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.a(paramAudioDecodeConfig);
        if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Long == 0L) {
          this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.c;
        }
        f2 = (float)this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.c;
        f3 = (float)this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.c;
        f1 = f2;
        if (f2 >= 0.0F) {
          break label238;
        }
        f1 = 0.0F;
      }
      finally {}
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable = new AudioDecoder.AudioPlayRunnable(this, f1, f2);
      this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable, "AudioPlay", 8);
      this.jdField_a_of_type_JavaLangThread.start();
      if (!TextUtils.isEmpty(paramAudioDecodeConfig.jdField_b_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable = new AudioDecoder.BgmAudioPlayRunnable(this);
        this.b = ThreadManager.newFreeThread(this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable, "BgmPlay", 8);
        this.b.start();
      }
      return;
      label238:
      if (f3 != 0.0F)
      {
        f2 = f3;
        if (f3 <= 1.0F) {}
      }
      else
      {
        f2 = 1.0F;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMuteAudio: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AudioDecoder", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqVideocodecAudioAudioDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_JavaLangThread;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable.a = true;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.b = null;
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
      if (localObject != null) {
        ((AudioDecoder.BgmAudioPlayRunnable)localObject).d();
      }
      QLog.d("AudioDecoder", 4, "bgm stopAudio");
    }
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).b();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).a();
      QLog.d("AudioDecoder", 4, "bgm pausePlay");
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$AudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).c();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorRichmediaMediacodecAudioDecoder$BgmAudioPlayRunnable;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).b();
      QLog.d("AudioDecoder", 4, "bgm resumePlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */