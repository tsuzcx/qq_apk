package com.tencent.mobileqq.app.utils;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageNotifiableChecker;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VibrateSoundHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MobileQQ;

public class SoundAndVibrateUtils
{
  public static final long[] e = { 100L, 200L, 200L, 100L };
  public static final long[] f = { 100L, 400L, 100L, 400L, 100L, 400L };
  public static final long[] g = { 10L, 50L };
  protected MobileQQ a;
  protected QQAppInterface b;
  VibrateSoundHelper c;
  MessageNotifiableChecker d;
  private long h = -1L;
  private volatile byte[] i = new byte[2];
  private volatile long[] j = new long[2];
  
  public SoundAndVibrateUtils(MobileQQ paramMobileQQ, QQAppInterface paramQQAppInterface)
  {
    this.a = paramMobileQQ;
    this.b = paramQQAppInterface;
  }
  
  private boolean a(String paramString)
  {
    return (AppConstants.SYSTEM_MSG_UIN.equals(paramString)) || (AppConstants.QQBROADCAST_MSG_UIN.equals(paramString)) || (AppConstants.LBS_HELLO_UIN.equals(paramString));
  }
  
  private boolean b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    this.b.unitTestLog("vibratorAndAudio_check_time_start", new Object[0]);
    if (this.h == -1L)
    {
      this.b.unitTestLog("vibratorAndAudio_check_time_not_valid", new Object[0]);
    }
    else if (Math.abs(System.currentTimeMillis() - this.h) <= 2000L)
    {
      this.b.unitTestLog("vibratorAndAudio_check_time_in_time_space", new Object[0]);
      if (paramMessageRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SpecialCare", 2, "message = null");
        }
        return true;
      }
      if (paramMessageRecord.msgtype != -2020)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SpecialCare", 2, "message.msgtype != MessageRecord.MSG_TYPE_SHAKE_WINDOW");
        }
        return true;
      }
      if ((!paramBoolean) || (this.b.getOnlineStauts() != 11L))
      {
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("isOnline = ");
          paramMessageRecord.append(paramBoolean);
          paramMessageRecord.append(" getOnlineStatus = ");
          paramMessageRecord.append(this.b.getOnlineStauts());
          QLog.e("SpecialCare", 2, paramMessageRecord.toString());
        }
        return true;
      }
    }
    this.h = System.currentTimeMillis();
    this.b.unitTestLog("vibratorAndAudio_check_time_end", new Object[0]);
    return false;
  }
  
  public BaseApplication a()
  {
    return this.a;
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT > 28) {
      bool = false;
    } else {
      bool = true;
    }
    a(paramMessageRecord, paramBoolean, bool);
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = new VibrateSoundHelper(this.b, paramMessageRecord);
    this.c.b(paramMessageRecord, paramBoolean1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("previous vibrate time is:");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",curr time is:");
    localStringBuilder.append(System.currentTimeMillis());
    QLog.d("QQAppInterface_SoundAndVibrateUtils", 1, localStringBuilder.toString());
    if (this.c.a(paramMessageRecord)) {
      return;
    }
    if (b(paramMessageRecord, paramBoolean1)) {
      return;
    }
    if (this.c.c(paramMessageRecord))
    {
      this.c.a(paramBoolean2);
      return;
    }
    this.b.unitTestLog("vibratorAndAudio_check_public_account_end", new Object[0]);
    if (this.c.a()) {
      this.c.b(paramMessageRecord, paramBoolean1, paramBoolean2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.h = System.currentTimeMillis();
    boolean bool1 = c();
    boolean bool2 = NoDisturbUtil.a(this.a.getApplicationContext(), this.b);
    boolean bool3 = NoDisturbUtil.b(this.a.getApplicationContext(), this.b);
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isRingerSilent is:");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(",canDisturb is:");
      ((StringBuilder)localObject1).append(bool2);
      QLog.d("notification", 2, new Object[] { ((StringBuilder)localObject1).toString(), " isMute:", Boolean.valueOf(bool3) });
    }
    if ((!bool1) && (bool2) && (!bool3))
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(a());
      Object localObject2 = (Vibrator)a().getSystemService("vibrator");
      bool1 = this.b.isVideoChatting();
      bool2 = this.b.canPlaySound();
      bool3 = this.b.canVibrator();
      boolean bool4 = this.b.isCallIdle();
      boolean bool5 = this.b.recordingPttStopped();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("canVibrator is:");
        localStringBuilder.append(bool3);
        localStringBuilder.append(",isVideoing is:");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",isCallIdle is:");
        localStringBuilder.append(bool4);
        localStringBuilder.append(",notRecordingPtt is:");
        localStringBuilder.append(bool5);
        QLog.d("notification", 2, localStringBuilder.toString());
      }
      if ((bool3) && (bool4) && (!bool1) && (bool5)) {
        ((Vibrator)localObject2).vibrate(f, -1);
      }
      if ((paramBoolean) && (bool2) && (!bool1) && (!g()) && (!h()) && (i()) && (this.b.recordingPttStopped()))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sound_type");
        ((StringBuilder)localObject2).append(this.b.getCurrentAccountUin());
        int k = ((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 2131230721);
        if (a(paramString)) {
          k = 2131230861;
        }
        AudioUtil.b(k, false);
      }
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, Message paramMessage, MessageNotifiableChecker paramMessageNotifiableChecker)
  {
    this.d = paramMessageNotifiableChecker;
    if (paramMessageNotifiableChecker.e(paramMessage)) {
      return true;
    }
    int k;
    if ((paramMessage.istroop == 1008) && (AppConstants.REMINDER_UIN.equals(paramMessage.senderuin))) {
      k = 1;
    } else {
      k = 0;
    }
    if (k != 0)
    {
      a(paramMessage, paramBoolean2);
      return true;
    }
    if (paramBoolean1)
    {
      boolean bool = paramMessageNotifiableChecker.j(paramMessage);
      if ((this.b.userActiveStatus == 0) || (bool)) {
        if (!this.b.mainActivityIsForeground)
        {
          a(paramMessage, paramBoolean2);
        }
        else
        {
          if ((this.j[0] == paramMessage.uniseq) && (this.j[1] == 1L)) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0)
          {
            a(paramMessage, paramBoolean2);
          }
          else
          {
            this.i[0] = 1;
            this.i[1] = ((byte)paramBoolean2);
          }
        }
      }
    }
    if ((paramBoolean1) && (paramMessageNotifiableChecker.g(paramMessage))) {
      paramMessageNotifiableChecker.f(paramMessage);
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trySoundAndVibrate is called,needSoundAndVibrations is:");
      ((StringBuilder)localObject).append(Arrays.toString(this.i));
      QLog.d("notification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.getMessageFacade();
    if (localObject == null) {
      return;
    }
    localObject = ((QQMessageFacade)localObject).B();
    if (localObject == null) {
      return;
    }
    this.j[0] = ((Message)localObject).uniseq;
    long[] arrayOfLong = this.j;
    boolean bool = true;
    arrayOfLong[1] = 1L;
    if (this.i[0] == 1)
    {
      if (this.i[1] != 1) {
        bool = false;
      }
      a((MessageRecord)localObject, bool);
      this.i[0] = 0;
    }
  }
  
  public boolean c()
  {
    AudioManager localAudioManager = (AudioManager)this.a.getSystemService("audio");
    if (localAudioManager != null) {}
    try
    {
      k = localAudioManager.getRingerMode();
    }
    catch (Throwable localThrowable)
    {
      int k;
      label26:
      break label26;
    }
    k = 2;
    return k == 0;
  }
  
  public boolean d()
  {
    return ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing(this.b) != 0;
  }
  
  public boolean e()
  {
    return j() != 0;
  }
  
  public boolean f()
  {
    return k() != 0;
  }
  
  public boolean g()
  {
    boolean bool2 = false;
    try
    {
      AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
      boolean bool1 = bool2;
      if (localAudioManager != null)
      {
        int k = localAudioManager.getRingerMode();
        bool1 = bool2;
        if (k == 1) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRingerVibrate error: ");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("QQAppInterface_SoundAndVibrateUtils", 1, localStringBuilder.toString());
    }
    return false;
  }
  
  public boolean h()
  {
    AudioManager localAudioManager = (AudioManager)a().getSystemService("audio");
    return (localAudioManager != null) && (localAudioManager.getStreamVolume(2) == 0);
  }
  
  public boolean i()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)a().getSystemService("phone");
    return (localTelephonyManager != null) && (localTelephonyManager.getCallState() == 0);
  }
  
  public int j()
  {
    return ((IRoamSettingService)this.b.getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.vibrate.switch", 1);
  }
  
  public int k()
  {
    return ((IRoamSettingService)this.b.getRuntimeService(IRoamSettingService.class, "")).getSettingValue("message.ring.switch", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.SoundAndVibrateUtils
 * JD-Core Version:    0.7.0.1
 */