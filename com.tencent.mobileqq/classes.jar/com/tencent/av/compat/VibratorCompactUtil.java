package com.tencent.av.compat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.os.Vibrator;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;

public class VibratorCompactUtil
{
  @SuppressLint({"NewApi"})
  public static AudioAttributes a()
  {
    if (AVUtil.b())
    {
      AudioAttributes.Builder localBuilder = new AudioAttributes.Builder();
      localBuilder.setUsage(6);
      localBuilder.setContentType(0);
      return localBuilder.build();
    }
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, long paramLong)
  {
    AudioAttributes localAudioAttributes = null;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    }
    if (paramContext != null)
    {
      localAudioAttributes = a();
      if (localAudioAttributes == null) {
        paramContext.vibrate(paramLong);
      } else {
        paramContext.vibrate(paramLong, localAudioAttributes);
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vibrate, audioAttributes[");
      localStringBuilder.append(localAudioAttributes);
      localStringBuilder.append("], vibrate[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], milliseconds[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("VibratorCompactUtil", 2, localStringBuilder.toString());
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, long[] paramArrayOfLong, int paramInt)
  {
    AudioAttributes localAudioAttributes = null;
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    }
    if (paramContext != null)
    {
      localAudioAttributes = a();
      if (localAudioAttributes == null) {
        paramContext.vibrate(paramArrayOfLong, paramInt);
      } else {
        paramContext.vibrate(paramArrayOfLong, paramInt, localAudioAttributes);
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfLong = new StringBuilder();
      paramArrayOfLong.append("vibrate, audioAttributes[");
      paramArrayOfLong.append(localAudioAttributes);
      paramArrayOfLong.append("], vibrate[");
      paramArrayOfLong.append(paramContext);
      paramArrayOfLong.append("]");
      QLog.i("VibratorCompactUtil", 2, paramArrayOfLong.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.compat.VibratorCompactUtil
 * JD-Core Version:    0.7.0.1
 */