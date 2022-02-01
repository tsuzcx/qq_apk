package com.tencent.av.wtogether.media;

import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.log.AVLog;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;

public class WatchTogetherAudioDecodeHelper
  implements ISuperPlayer.OnAudioFrameOutputListener
{
  private volatile Float a;
  private boolean b = false;
  private float c = 1.01F;
  private float d = 0.99F;
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.b)) {
      AudioProcess.b().startPlay(3);
    }
  }
  
  public void a(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    if (localAudioManager != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVideoVolumeValue:");
      localStringBuilder.append(paramInt);
      AVLog.d("WatchTogetherAudioDecodeHelper", localStringBuilder.toString());
      localAudioManager.setStreamVolume(3, paramInt, 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = Float.valueOf(paramInt2 * 1.0F / paramInt1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (!this.b)
        {
          AudioProcess.a(VideoController.f().j(), VideoController.f());
          this.b = true;
        }
        a();
      }
    }
    else if ((Build.VERSION.SDK_INT >= 16) && (this.b))
    {
      AudioProcess.c();
      this.b = false;
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      return;
    }
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = ((AudioManager)localObject).getStreamVolume(0);
    int j = ((AudioManager)localObject).getStreamMaxVolume(0);
    this.a = Float.valueOf(i * 1.0F / j);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init scaleFacors:=");
    ((StringBuilder)localObject).append(this.a);
    AVLog.d("WatchTogetherAudioDecodeHelper", ((StringBuilder)localObject).toString());
  }
  
  public int c()
  {
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    if (localObject != null)
    {
      int i = ((AudioManager)localObject).getStreamVolume(3);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCurrentVolumeValue:");
      ((StringBuilder)localObject).append(i);
      AVLog.d("WatchTogetherAudioDecodeHelper", ((StringBuilder)localObject).toString());
      return i;
    }
    return 0;
  }
  
  public int d()
  {
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    if (localObject != null)
    {
      int i = ((AudioManager)localObject).getStreamMaxVolume(3);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMaxVolumeValue:");
      ((StringBuilder)localObject).append(i);
      AVLog.d("WatchTogetherAudioDecodeHelper", ((StringBuilder)localObject).toString());
      return i;
    }
    return 0;
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    b();
    if ((Build.VERSION.SDK_INT >= 16) && (this.b))
    {
      if (paramTPAudioFrameBuffer.getChannelLayout() == 3L)
      {
        int n = paramTPAudioFrameBuffer.getSize()[0] / 2;
        byte[] arrayOfByte1 = new byte[n];
        int k = 0;
        int m = 0;
        while (k < n)
        {
          byte[] arrayOfByte2 = paramTPAudioFrameBuffer.data[0];
          int i4 = k * 2;
          int i2 = (short)arrayOfByte2[i4];
          int i1 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 1)];
          int i3 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 2)];
          i4 = (short)paramTPAudioFrameBuffer.data[0][(i4 + 3)];
          i2 = (i2 + i3) / 2;
          i1 = (i1 + i4) / 2;
          i3 = m + 1;
          int j = -128;
          int i;
          if (i2 > 127) {
            i = 127;
          } else if (i2 < -128) {
            i = -128;
          } else {
            i = (byte)i2;
          }
          arrayOfByte1[m] = i;
          m = i3 + 1;
          if (i1 > 127) {
            i = 127;
          } else if (i1 < -128) {
            i = j;
          } else {
            i = (byte)i1;
          }
          arrayOfByte1[i3] = i;
          k += 2;
        }
        if ((this.a.floatValue() < this.d) || (this.a.floatValue() > this.c)) {
          AudioProcess.b().scaleVolumeValue(arrayOfByte1, this.a.floatValue());
        }
        AudioProcess.b().addPCMData(arrayOfByte1, arrayOfByte1.length);
        return;
      }
      if (paramTPAudioFrameBuffer.getChannelLayout() == 4L)
      {
        if ((this.a.floatValue() < this.d) || (this.a.floatValue() > this.c)) {
          AudioProcess.b().scaleVolumeValue(paramTPAudioFrameBuffer.data[0], this.a.floatValue());
        }
        AudioProcess.b().addPCMData(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherAudioDecodeHelper
 * JD-Core Version:    0.7.0.1
 */