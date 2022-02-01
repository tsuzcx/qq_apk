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
  private float jdField_a_of_type_Float = 1.01F;
  private volatile Float jdField_a_of_type_JavaLangFloat;
  private boolean jdField_a_of_type_Boolean = false;
  private float b = 0.99F;
  
  public void a()
  {
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Boolean)) {
      AudioProcess.a().startPlay(3);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(paramInt2 * 1.0F / paramInt1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
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
    else if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Boolean))
    {
      AudioProcess.a();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaLangFloat != null) {
      return;
    }
    Object localObject = (AudioManager)BaseApplicationImpl.getApplication().getSystemService("audio");
    int i = ((AudioManager)localObject).getStreamVolume(0);
    int j = ((AudioManager)localObject).getStreamMaxVolume(0);
    this.jdField_a_of_type_JavaLangFloat = Float.valueOf(i * 1.0F / j);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init scaleFacors:=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangFloat);
    AVLog.d("WatchTogetherAudioDecodeHelper", ((StringBuilder)localObject).toString());
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    b();
    if ((Build.VERSION.SDK_INT >= 16) && (this.jdField_a_of_type_Boolean))
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
        if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < this.b) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > this.jdField_a_of_type_Float)) {
          AudioProcess.a().scaleVolumeValue(arrayOfByte1, this.jdField_a_of_type_JavaLangFloat.floatValue());
        }
        AudioProcess.a().addPCMData(arrayOfByte1, arrayOfByte1.length);
        return;
      }
      if (paramTPAudioFrameBuffer.getChannelLayout() == 4L)
      {
        if ((this.jdField_a_of_type_JavaLangFloat.floatValue() < this.b) || (this.jdField_a_of_type_JavaLangFloat.floatValue() > this.jdField_a_of_type_Float)) {
          AudioProcess.a().scaleVolumeValue(paramTPAudioFrameBuffer.data[0], this.jdField_a_of_type_JavaLangFloat.floatValue());
        }
        AudioProcess.a().addPCMData(paramTPAudioFrameBuffer.data[0], paramTPAudioFrameBuffer.data[0].length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherAudioDecodeHelper
 * JD-Core Version:    0.7.0.1
 */