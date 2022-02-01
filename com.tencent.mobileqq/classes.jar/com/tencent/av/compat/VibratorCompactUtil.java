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
    Object localObject = null;
    if (AVUtil.b())
    {
      localObject = new AudioAttributes.Builder();
      ((AudioAttributes.Builder)localObject).setUsage(6);
      ((AudioAttributes.Builder)localObject).setContentType(0);
      localObject = ((AudioAttributes.Builder)localObject).build();
    }
    return localObject;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, long paramLong)
  {
    AudioAttributes localAudioAttributes;
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext == null) {
        break label100;
      }
      localAudioAttributes = a();
      if (localAudioAttributes != null) {
        break label91;
      }
      paramContext.vibrate(paramLong);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VibratorCompactUtil", 2, "vibrate, audioAttributes[" + localAudioAttributes + "], vibrate[" + paramContext + "], milliseconds[" + paramLong + "]");
      }
      return;
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      break;
      label91:
      paramContext.vibrate(paramLong, localAudioAttributes);
      continue;
      label100:
      localAudioAttributes = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, long[] paramArrayOfLong, int paramInt)
  {
    AudioAttributes localAudioAttributes;
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext == null) {
        break label97;
      }
      localAudioAttributes = a();
      if (localAudioAttributes != null) {
        break label85;
      }
      paramContext.vibrate(paramArrayOfLong, paramInt);
      paramArrayOfLong = localAudioAttributes;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VibratorCompactUtil", 2, "vibrate, audioAttributes[" + paramArrayOfLong + "], vibrate[" + paramContext + "]");
      }
      return;
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      break;
      label85:
      paramContext.vibrate(paramArrayOfLong, paramInt, localAudioAttributes);
      paramArrayOfLong = localAudioAttributes;
      continue;
      label97:
      paramArrayOfLong = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.compat.VibratorCompactUtil
 * JD-Core Version:    0.7.0.1
 */