package com.tencent.av.wtogether.media;

import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.av.VideoController;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.log.AVLog;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;

public class WatchTogetherAudioDecodeHelper
  implements ISuperPlayer.OnAudioFrameOutputListener
{
  private float jdField_a_of_type_Float = 1.01F;
  private volatile Float jdField_a_of_type_JavaLangFloat;
  private boolean jdField_a_of_type_Boolean = false;
  private float b = 0.99F;
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Boolean)) {
      AudioProcess.a().a(3);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramInt2 * 1.0F / paramInt1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          AudioProcess.a(VideoController.a().a(), VideoController.a());
          this.jdField_a_of_type_Boolean = true;
        }
        a();
      }
    }
    while ((Build.VERSION.SDK_INT < 16) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    AudioProcess.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangFloat != null) {
      return;
    }
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = localAudioManager.getStreamVolume(0);
    int j = localAudioManager.getStreamMaxVolume(0);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(i * 1.0F / j);
    AVLog.d("WatchTogetherAudioDecodeHelper", "init scaleFacors:=" + this.jdField_a_of_type_JavaLangFloat);
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    b();
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Boolean))
    {
      if (paramTPAudioFrameBuffer.getChannelLayout() != 3L) {
        break label282;
      }
      m = paramTPAudioFrameBuffer.getSize()[0] / 2;
      arrayOfByte = new byte[m];
      j = 0;
      k = 0;
      if (j < m)
      {
        i2 = (short)paramTPAudioFrameBuffer.data[0][(j * 2)];
        n = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 1)];
        i3 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 2)];
        i1 = (short)paramTPAudioFrameBuffer.data[0][(j * 2 + 3)];
        i2 = (i2 + i3) / 2;
        n = (n + i1) / 2;
        i1 = k + 1;
        if (i2 > 127)
        {
          i = 127;
          label149:
          arrayOfByte[k] = i;
          k = i1 + 1;
          if (n <= 127) {
            break label204;
          }
          i = 127;
        }
        for (;;)
        {
          arrayOfByte[i1] = i;
          j += 2;
          break;
          if (i2 < -128)
          {
            i = -128;
            break label149;
          }
          i = (byte)i2;
          break label149;
          label204:
          if (n < -128) {
            i = -128;
          } else {
            i = (byte)n;
          }
        }
      }
      if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < this.b) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > this.jdField_a_of_type_Float))
      {
        AudioProcess.a();
        AudioProcess.a(arrayOfByte, this.jdField_a_of_type_JavaLangFloat.floatValue());
      }
      AudioProcess.a().a(arrayOfByte, arrayOfByte.length);
    }
    label282:
    while (paramTPAudioFrameBuffer.getChannelLayout() != 4L)
    {
      int m;
      byte[] arrayOfByte;
      int j;
      int k;
      int i2;
      int n;
      int i3;
      int i1;
      int i;
      return;
    }
    if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < this.b) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > this.jdField_a_of_type_Float))
    {
      AudioProcess.a();
      AudioProcess.a(paramTPAudioFrameBuffer.data[0], this.jdField_a_of_type_JavaLangFloat.floatValue());
    }
    AudioProcess.a().a(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherAudioDecodeHelper
 * JD-Core Version:    0.7.0.1
 */