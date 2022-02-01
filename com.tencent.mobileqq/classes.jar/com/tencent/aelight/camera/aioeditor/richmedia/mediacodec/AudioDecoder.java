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
  public AudioDecodeConfig a;
  private AudioDecoder.AudioPlayRunnable b;
  private AudioDecoder.BgmAudioPlayRunnable c;
  private Thread d;
  private Thread e;
  
  private void a(AudioTrack paramAudioTrack, byte[] paramArrayOfByte, int paramInt)
  {
    int j = this.a.d;
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
            if (!this.a.e) {
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
    if ((!this.a.e) && (paramInt == 0) && (paramArrayOfByte != null)) {
      paramAudioTrack.write(paramArrayOfByte, 0, i);
    }
  }
  
  public void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).a();
      QLog.d("AudioDecoder", 4, "repeat");
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).c();
      QLog.d("AudioDecoder", 4, " bgm repeat");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AudioDecodeConfig)localObject).d = paramInt;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSpeedType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AudioDecoder", 4, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).a(paramLong, this.a.h);
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
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.w("AudioDecoder", 4, "you must start play first");
      return;
    }
    if ((paramLong1 == ((AudioDecodeConfig)localObject).f) && (paramLong2 == this.a.g))
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
    localObject = this.a;
    ((AudioDecodeConfig)localObject).f = paramLong1;
    ((AudioDecodeConfig)localObject).g = paramLong2;
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
        if (this.a == null) {
          this.a = new AudioDecodeConfig();
        }
        this.a.a(paramAudioDecodeConfig);
        if (this.a.g == 0L) {
          this.a.g = this.a.h;
        }
        f2 = (float)this.a.f / (float)this.a.h;
        f3 = (float)this.a.g / (float)this.a.h;
        f1 = f2;
        if (f2 >= 0.0F) {
          break label238;
        }
        f1 = 0.0F;
      }
      finally {}
      this.b = new AudioDecoder.AudioPlayRunnable(this, f1, f2);
      this.d = ThreadManager.newFreeThread(this.b, "AudioPlay", 8);
      this.d.start();
      if (!TextUtils.isEmpty(paramAudioDecodeConfig.i))
      {
        this.c = new AudioDecoder.BgmAudioPlayRunnable(this);
        this.e = ThreadManager.newFreeThread(this.c, "BgmPlay", 8);
        this.e.start();
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
    if (this.a == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setMuteAudio: ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AudioDecoder", 1, localStringBuilder.toString());
    this.a.e = paramBoolean;
  }
  
  public void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.d = null;
      this.b.a = true;
      QLog.d("AudioDecoder", 4, "stopAudio");
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((Thread)localObject).interrupt();
      this.e = null;
      localObject = this.c;
      if (localObject != null) {
        ((AudioDecoder.BgmAudioPlayRunnable)localObject).d();
      }
      QLog.d("AudioDecoder", 4, "bgm stopAudio");
    }
  }
  
  public void c()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).b();
      QLog.d("AudioDecoder", 4, "pausePlay");
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).a();
      QLog.d("AudioDecoder", 4, "bgm pausePlay");
    }
  }
  
  public void d()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((AudioDecoder.AudioPlayRunnable)localObject).c();
      QLog.d("AudioDecoder", 4, "resumePlay");
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((AudioDecoder.BgmAudioPlayRunnable)localObject).b();
      QLog.d("AudioDecoder", 4, "bgm resumePlay");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */