package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import com.tencent.commonsdk.util.notification.SdkInfoUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.utils.SoundAndVibrateUtils;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VibrateSoundHelper
{
  QQAppInterface a;
  private final MessageRecord b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private boolean j;
  private boolean k;
  
  public VibrateSoundHelper(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    this.a = paramQQAppInterface;
    this.b = paramMessageRecord;
    this.c = paramQQAppInterface.isRingerSilent();
    this.d = NoDisturbUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    this.e = b(this.b);
    this.f = NoDisturbUtil.b(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    this.g = paramQQAppInterface.isCallIdle();
    this.h = paramQQAppInterface.recordingPttStopped();
    this.j = paramQQAppInterface.canPlaySound();
    this.k = paramQQAppInterface.canVibrator();
    this.i = paramQQAppInterface.isVideoChatting();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isRingerSilent is:");
      paramQQAppInterface.append(this.c);
      paramQQAppInterface.append(",canDisturb is:");
      paramQQAppInterface.append(this.d);
      QLog.d("VibrateSoundHelper", 2, new Object[] { paramQQAppInterface.toString(), " isMute:", Boolean.valueOf(this.f), " newMsgNotificationEnabled: ", Boolean.valueOf(this.e), " isCallIdle: ", Boolean.valueOf(this.g), " notRecordingPtt: ", Boolean.valueOf(this.h), " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.j), " canVibratorInGeneralSetting: ", Boolean.valueOf(this.k) });
    }
  }
  
  static boolean a(int paramInt, Message paramMessage, boolean paramBoolean)
  {
    if ((paramInt == 0) && (paramBoolean)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramMessage.istroop != 1001)
    {
      bool1 = bool2;
      if (paramMessage.istroop != 10002) {}
    }
    else
    {
      bool1 = bool2;
      if (paramMessage.msgtype == -3001) {
        bool1 = true;
      }
    }
    boolean bool2 = bool1;
    if (paramMessage.istroop == 1008) {
      if ((paramMessage.extStr == null) || ((paramMessage.extLong & 0x1) != 0) || (!paramMessage.extStr.contains("lockDisplay")))
      {
        bool2 = bool1;
        if (paramMessage.extStr != null)
        {
          bool2 = bool1;
          if ((paramMessage.extLong & 0x1) == 1)
          {
            bool2 = bool1;
            if (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {}
          }
        }
      }
      else
      {
        bool2 = bool1;
        if (paramBoolean) {
          bool2 = true;
        }
      }
    }
    paramBoolean = bool2;
    if (paramMessage.istroop == 1008)
    {
      paramBoolean = bool2;
      if (AppConstants.REMINDER_UIN.equals(paramMessage.senderuin)) {
        paramBoolean = true;
      }
    }
    boolean bool1 = paramBoolean;
    if (paramMessage.istroop == 9002) {
      bool1 = true;
    }
    paramBoolean = bool1;
    if (paramMessage.istroop == 1044)
    {
      paramBoolean = bool1;
      if (SdkInfoUtil.isOreo()) {
        paramBoolean = false;
      }
    }
    bool1 = paramBoolean;
    if (paramMessage.istroop == 1045)
    {
      bool1 = paramBoolean;
      if (SdkInfoUtil.isOreo()) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void b(int paramInt)
  {
    int n = this.a.vibrateListenerList.size();
    int m = 0;
    while (m < n)
    {
      ((VibrateListener)this.a.vibrateListenerList.get(m)).a(paramInt);
      m += 1;
    }
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.a);
    boolean bool2;
    boolean bool1;
    if ((paramMessageRecord != null) && (localMessageNotificationSettingManager != null))
    {
      boolean bool3 = localMessageNotificationSettingManager.b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      boolean bool4 = localMessageNotificationSettingManager.a(paramMessageRecord.senderuin);
      bool2 = bool3;
      bool1 = bool4;
      if (QLog.isColorLevel())
      {
        QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " message: ", paramMessageRecord, " message.senderuin: ", paramMessageRecord.senderuin, " message.frienduin: ", paramMessageRecord.frienduin, " message.istroop: ", Integer.valueOf(paramMessageRecord.istroop) });
        bool2 = bool3;
        bool1 = bool4;
      }
    }
    else
    {
      bool2 = false;
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " enableSeparateSoundWhenGlobalOff: ", Boolean.valueOf(bool2), " spCareFriendRingEnable: ", Boolean.valueOf(bool1), " spCareFriendRingEnable: ", Boolean.valueOf(bool1) });
    }
    this.a.unitTestLog("vibratorAndAudio_play_sound_for_sp_message", new Object[] { Boolean.valueOf(paramBoolean2) });
    if (((paramBoolean1) && (bool2) && (bool1)) || ((TroopKeywordManager.a(paramMessageRecord)) && (localMessageNotificationSettingManager != null))) {
      localMessageNotificationSettingManager.b(paramMessageRecord);
    }
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.a);
    Object localObject = this.a;
    int m = 0;
    ((QQAppInterface)localObject).unitTestLog("vibratorAndAudio_check_sound_for_message_enableSeparateSound", new Object[0]);
    int n = SettingCloneUtil.readValueForInt(BaseApplication.context, this.a.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.h);
    if (QLog.isColorLevel())
    {
      localObject = (AudioManager)this.a.getApp().getSystemService("audio");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StreamVolume=");
      if (localObject != null) {
        m = ((AudioManager)localObject).getStreamVolume(2);
      }
      localStringBuilder.append(m);
      localStringBuilder.append(",SoundRid=");
      localStringBuilder.append(n);
      QLog.d("VibrateSoundHelper", 2, localStringBuilder.toString());
    }
    if (localMessageNotificationSettingManager != null)
    {
      if (MessageNotificationSettingManager.c(paramMessageRecord))
      {
        localMessageNotificationSettingManager.b(paramMessageRecord);
        return;
      }
      localMessageNotificationSettingManager.c();
    }
  }
  
  private String e(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004))
    {
      if (UinTypeUtil.e(paramMessageRecord.istroop) == 1032) {
        return AppConstants.CONFESS_UIN;
      }
      return paramMessageRecord.senderuin;
    }
    return paramMessageRecord.frienduin;
  }
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.a);
    boolean bool2 = this.j;
    boolean bool1 = bool2;
    if (localMessageNotificationSettingManager != null)
    {
      bool1 = bool2;
      if (paramMessageRecord != null) {
        bool1 = localMessageNotificationSettingManager.b(bool2, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.j), " isVideoing: ", Boolean.valueOf(this.i), " isRingerVibrate(): ", Boolean.valueOf(this.a.isRingerVibrate()), " isRingEqualsZero(): ", Boolean.valueOf(this.a.isRingEqualsZero()), " isCallIdle: ", Boolean.valueOf(this.g), " notRecordingPtt: ", Boolean.valueOf(this.h), " enableSeparateSound: ", Boolean.valueOf(bool1) });
    }
    this.a.unitTestLog("vibratorAndAudio_check_sound_for_message", new Object[0]);
    int m;
    if ((this.j) && (!this.i) && (!this.a.isRingerVibrate()) && (!this.a.isRingEqualsZero()) && (this.g) && (this.h)) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if ((!this.j) && (!this.i) && (!this.a.isRingerVibrate()) && (!this.a.isRingEqualsZero()) && (this.g) && (this.h)) {
      n = 1;
    } else {
      n = 0;
    }
    if ((m != 0) && (bool1))
    {
      d(paramMessageRecord);
      this.a.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
      return;
    }
    if (n != 0) {
      this.a.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
    }
    try
    {
      c(paramMessageRecord, paramBoolean, bool1);
      return;
    }
    catch (Throwable paramMessageRecord) {}
    this.a.unitTestLog("vibratorAndAudio_no_need_play_sound_for_message", new Object[] { "独立会话支持的会话类型，并且独立会话声音开关关闭，这种场景不用播放铃声（即使全局铃声开关打开）" });
    return;
  }
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = BaseApplication.getContext();
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject1).getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    localObject1 = (Vibrator)((BaseApplication)localObject1).getSystemService("vibrator");
    Object localObject2 = MessageNotificationSettingManager.a(this.a);
    boolean bool2 = this.k;
    boolean bool1 = bool2;
    if (localObject2 != null)
    {
      bool1 = bool2;
      if (paramMessageRecord != null) {
        bool1 = ((MessageNotificationSettingManager)localObject2).a(bool2, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    this.a.unitTestLog("vibratorAndAudio_enableSeparateVibrate", new Object[] { Boolean.valueOf(bool1) });
    if ((this.k) && (paramBoolean2)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    this.k = paramBoolean2;
    int m;
    if ((this.k) && (this.g) && (!this.i) && (this.h) && (bool1)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m != 0)
    {
      if ((paramMessageRecord != null) && (paramBoolean1) && (paramMessageRecord.msgtype == -2020) && (this.a.getOnlineStauts() == 11L)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        ((Vibrator)localObject1).vibrate(SoundAndVibrateUtils.f, -1);
        m = 2;
        this.a.unitTestLog("vibratorAndAudio_shake_window_type", new Object[] { Integer.valueOf(2) });
      }
      else
      {
        if (paramMessageRecord != null)
        {
          paramMessageRecord = e(paramMessageRecord);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("special_sound_type");
          ((StringBuilder)localObject2).append(this.a.getCurrentAccountUin());
          ((StringBuilder)localObject2).append(paramMessageRecord);
          paramMessageRecord = ((StringBuilder)localObject2).toString();
        }
        else
        {
          paramMessageRecord = "";
        }
        if (localSharedPreferences.contains(paramMessageRecord))
        {
          ((Vibrator)localObject1).vibrate(1000L);
          m = 3;
          this.a.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(3) });
        }
        else
        {
          ((Vibrator)localObject1).vibrate(SoundAndVibrateUtils.e, -1);
          this.a.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(1) });
          m = 1;
        }
      }
      b(m);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = this.a;
    Object localObject1 = Boolean.valueOf(false);
    ((QQAppInterface)localObject2).unitTestLog("vibratorAndAudio_check_public_account_start", new Object[0]);
    Object localObject3 = this.a;
    localObject2 = Boolean.valueOf(true);
    ((QQAppInterface)localObject3).unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject1, localObject1 });
    localObject3 = RingtoneManager.getActualDefaultRingtoneUri(this.a.getApp(), 2);
    Vibrator localVibrator = (Vibrator)this.a.getApp().getSystemService("vibrator");
    int m;
    if ((this.a.isRingerVibrate()) && (this.d) && (!this.f))
    {
      this.a.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject1, localObject2 });
      m = 1;
    }
    else
    {
      if ((this.a.isRingerNormal()) && (this.a.isRingerNormalVibrate()) && (this.d) && (!this.f)) {
        this.a.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject2, localObject2 });
      }
      for (m = 1;; m = 0)
      {
        bool = true;
        break label279;
        if ((!this.a.isRingerNormal()) || (this.a.isRingerNormalVibrate()) || (!this.d) || (this.f)) {
          break;
        }
        this.a.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject2, localObject1 });
      }
      m = 0;
    }
    boolean bool = false;
    label279:
    if ((m != 0) && (paramBoolean)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("canVibrator: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" canPlaySound: ");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(" uri: ");
      ((StringBuilder)localObject1).append(localObject3);
      QLog.d("QQAppInterface", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramBoolean) && (localVibrator != null))
    {
      localVibrator.vibrate(SoundAndVibrateUtils.e, -1);
      this.a.unitTestLog("vibratorAndAudio_vibrate_invoked", new Object[0]);
    }
    if ((bool) && (localObject3 != null))
    {
      AudioUtil.a((Uri)localObject3, false, false);
      this.a.unitTestLog("vibratorAndAudio_sound_invoked", new Object[] { localObject3 });
    }
  }
  
  public boolean a()
  {
    return (!this.c) && (this.d) && (!this.f);
  }
  
  boolean a(int paramInt)
  {
    boolean bool;
    if (paramInt == 0)
    {
      if (this.a.getALLGeneralSettingRing() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.a.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.a.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1001) && (!MsgBoxUtil.b(paramMessageRecord)) && (!this.a.isBackgroundPause))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("message.istroop = ");
        localStringBuilder.append(paramMessageRecord.istroop);
        localStringBuilder.append(" MsgBoxUtil.shouldInMsgBox(message) = ");
        localStringBuilder.append(MsgBoxUtil.b(paramMessageRecord));
        QLog.e("SpecialCare", 2, localStringBuilder.toString());
      }
      this.a.unitTestLog("vibratorAndAudio_UIN_TYPE_LBS_FRIEND", new Object[0]);
      return true;
    }
    return false;
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    this.a.unitTestLog("vibratorAndAudio_invoked", new Object[0]);
    if (QLog.isColorLevel())
    {
      Object localObject = null;
      if (paramMessageRecord != null) {
        if (paramMessageRecord.msgtype == -2020)
        {
          localObject = paramMessageRecord.getBaseInfoString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("not shake msg,uinSeq is:");
          ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("message is:");
      paramMessageRecord.append((String)localObject);
      paramMessageRecord.append(",isOnline is:");
      paramMessageRecord.append(paramBoolean);
      QLog.d("VibrateSoundHelper", 2, paramMessageRecord.toString());
    }
  }
  
  public void b(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.unitTestLog("vibratorAndAudio_check_silent_start", new Object[0]);
    boolean bool2 = a(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.a));
    if ((paramMessageRecord != null) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 10014)))
    {
      boolean bool1;
      if ((this.j) && (this.a.troopCanPlaySound())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.j = bool1;
      if ((this.k) && (this.a.troopCanVibrator())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.k = bool1;
      this.a.unitTestLog("vibratorAndAudio_troop_sound_vibrator", new Object[] { Boolean.valueOf(this.j), Boolean.valueOf(this.k) });
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canVibratorInGeneralSetting is:");
      localStringBuilder.append(this.k);
      localStringBuilder.append(",isVideoing is:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",isCallIdle is:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",notRecordingPtt is:");
      localStringBuilder.append(this.h);
      QLog.d("VibrateSoundHelper", 2, localStringBuilder.toString());
    }
    a(paramMessageRecord, paramBoolean1, paramBoolean2);
    a(paramMessageRecord, bool2);
  }
  
  boolean b(MessageRecord paramMessageRecord)
  {
    NewMsgNotificationManager localNewMsgNotificationManager = (NewMsgNotificationManager)this.a.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
    if (localNewMsgNotificationManager != null) {
      return localNewMsgNotificationManager.a(paramMessageRecord);
    }
    return true;
  }
  
  public boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.istroop == 1008) && (AppConstants.REMINDER_UIN.equals(paramMessageRecord.senderuin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VibrateSoundHelper
 * JD-Core Version:    0.7.0.1
 */