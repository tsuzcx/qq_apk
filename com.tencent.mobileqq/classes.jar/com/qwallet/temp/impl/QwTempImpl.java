package com.qwallet.temp.impl;

import android.app.Activity;
import com.qwallet.temp.IChatActivityFacadeTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.av.ui.funchat.record.AudioFileDecoder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QwTempImpl
  implements IQwTemp
{
  private static final String TAG = "QwTempImpl";
  
  public int AIOUtils$getLifeConst(String paramString)
  {
    if (paramString.equalsIgnoreCase("AIO_ON_NEWINTENT")) {
      return 1;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_CTEATE")) {
      return 2;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_RESUEME")) {
      return 4;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_START")) {
      return 3;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_PAUSE")) {
      return 5;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_STOP")) {
      return 6;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_FINISH")) {
      return 7;
    }
    if (paramString.equalsIgnoreCase("AIO_AFTER_FINISH")) {
      return 8;
    }
    if (paramString.equalsIgnoreCase("AIO_ON_DESTROY")) {
      return 9;
    }
    return 1;
  }
  
  public String ContactUtils$getBuddyName(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return ContactUtils.a(paramAppRuntime, paramString, paramBoolean);
  }
  
  public String ContactUtils$getDateNickName(AppInterface paramAppInterface, String paramString)
  {
    return ContactUtils.h(paramAppInterface, paramString);
  }
  
  public int GifProcessor$convertVideoToGifForLocal(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    return GifProcessor.convertVideoToGifForLocal(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramInt4, paramInt5);
  }
  
  public String ReadInJoyCameraCaptureConstants$KEY_READINJOY_CAPTURE_ABILITY_FLAG()
  {
    return "key_ability_flag";
  }
  
  public Class<? extends Activity> getSendPhotoActivity()
  {
    return SendPhotoActivity.class;
  }
  
  public void mediaPlayer_doStop(boolean paramBoolean, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if (!(paramAppRuntime instanceof QQAppInterface)) {
        return;
      }
      paramAppRuntime = (MediaPlayerManager)((QQAppInterface)paramAppRuntime).getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
      if (paramAppRuntime != null) {
        paramAppRuntime.a(paramBoolean);
      }
    }
  }
  
  public void mixSong(byte[] paramArrayOfByte, String paramString1, String paramString2, RecordParams.RecorderParam paramRecorderParam, String paramString3)
  {
    paramArrayOfByte = new AudioFileDecoder(paramRecorderParam.a, 16, 1);
    paramArrayOfByte.a(new QwTempImpl.1(this));
    long l = System.currentTimeMillis();
    try
    {
      paramArrayOfByte.a(paramString1, paramString3);
    }
    catch (Throwable paramArrayOfByte)
    {
      paramString1 = new StringBuilder();
      paramString1.append("convertMp3ToPcm decode exception:");
      paramString1.append(paramArrayOfByte);
      QLog.e("QwTempImpl", 1, paramString1.toString(), paramArrayOfByte);
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("mp3 to pcm time:");
      paramArrayOfByte.append(System.currentTimeMillis() - l);
      QLog.d("QwTempImpl", 2, paramArrayOfByte.toString());
    }
  }
  
  public IChatActivityFacadeTemp newIChatActivityFacadeTemp()
  {
    return new ChatActivityFacadeTemp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QwTempImpl
 * JD-Core Version:    0.7.0.1
 */