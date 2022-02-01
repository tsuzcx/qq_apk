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
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.vas.troopkeyword.TroopKeywordManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class VibrateSoundHelper
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private final boolean jdField_a_of_type_Boolean;
  private final boolean b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private boolean h;
  private boolean i;
  
  public VibrateSoundHelper(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    this.jdField_a_of_type_Boolean = paramQQAppInterface.isRingerSilent();
    this.b = NoDisturbUtil.a(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    this.c = b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    this.d = NoDisturbUtil.b(paramQQAppInterface.getApp().getApplicationContext(), paramQQAppInterface);
    this.e = paramQQAppInterface.isCallIdle();
    this.f = paramQQAppInterface.recordingPttStopped();
    this.h = paramQQAppInterface.canPlaySound();
    this.i = paramQQAppInterface.canVibrator();
    this.g = paramQQAppInterface.isVideoChatting();
    if (QLog.isColorLevel()) {
      QLog.d("VibrateSoundHelper", 2, new Object[] { "isRingerSilent is:" + this.jdField_a_of_type_Boolean + ",canDisturb is:" + this.b, " isMute:", Boolean.valueOf(this.d), " newMsgNotificationEnabled: ", Boolean.valueOf(this.c), " isCallIdle: ", Boolean.valueOf(this.e), " notRecordingPtt: ", Boolean.valueOf(this.f), " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.h), " canVibratorInGeneralSetting: ", Boolean.valueOf(this.i) });
    }
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1004)) {
      return paramMessageRecord.frienduin;
    }
    if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
      return AppConstants.CONFESS_UIN;
    }
    return paramMessageRecord.senderuin;
  }
  
  private void a(int paramInt)
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibrateListenerList.size();
    int j = 0;
    while (j < k)
    {
      ((VibrateListener)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibrateListenerList.get(j)).a(paramInt);
      j += 1;
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_for_message_enableSeparateSound", new Object[0]);
    int k = SettingCloneUtil.readValueForInt(BaseApplication.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    AudioManager localAudioManager;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("audio");
      localStringBuilder = new StringBuilder().append("StreamVolume=");
      if (localAudioManager != null) {
        break label131;
      }
    }
    label131:
    for (int j = 0;; j = localAudioManager.getStreamVolume(2))
    {
      QLog.d("VibrateSoundHelper", 2, j + ",SoundRid=" + k);
      if (localMessageNotificationSettingManager != null)
      {
        if (!MessageNotificationSettingManager.a(paramMessageRecord)) {
          break;
        }
        localMessageNotificationSettingManager.b(paramMessageRecord);
      }
      return;
    }
    localMessageNotificationSettingManager.b();
  }
  
  static boolean a(int paramInt, Message paramMessage, boolean paramBoolean)
  {
    boolean bool3 = true;
    if ((paramInt == 0) && (paramBoolean)) {}
    for (boolean bool2 = true;; bool2 = false)
    {
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
      bool2 = bool1;
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
      if (paramMessage.istroop == 9002) {}
      for (boolean bool1 = bool3;; bool1 = paramBoolean)
      {
        paramBoolean = bool1;
        if (paramMessage.istroop == 1037)
        {
          paramBoolean = bool1;
          if (SdkInfoUtil.isOreo()) {
            paramBoolean = false;
          }
        }
        bool1 = paramBoolean;
        if (paramMessage.istroop == 1044)
        {
          bool1 = paramBoolean;
          if (SdkInfoUtil.isOreo()) {
            bool1 = false;
          }
        }
        paramBoolean = bool1;
        if (paramMessage.istroop == 1045)
        {
          paramBoolean = bool1;
          if (SdkInfoUtil.isOreo()) {
            paramBoolean = false;
          }
        }
        return paramBoolean;
      }
    }
  }
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool1;
    boolean bool2;
    if ((paramMessageRecord != null) && (localMessageNotificationSettingManager != null))
    {
      boolean bool3 = localMessageNotificationSettingManager.b(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      boolean bool4 = localMessageNotificationSettingManager.a(paramMessageRecord.senderuin);
      bool1 = bool4;
      bool2 = bool3;
      if (QLog.isColorLevel())
      {
        QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " message: ", paramMessageRecord, " message.senderuin: ", paramMessageRecord.senderuin, " message.frienduin: ", paramMessageRecord.frienduin, " message.istroop: ", Integer.valueOf(paramMessageRecord.istroop) });
        bool2 = bool3;
        bool1 = bool4;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " enableSeparateSoundWhenGlobalOff: ", Boolean.valueOf(bool2), " spCareFriendRingEnable: ", Boolean.valueOf(bool1), " spCareFriendRingEnable: ", Boolean.valueOf(bool1) });
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_sp_message", new Object[] { Boolean.valueOf(paramBoolean2) });
      if (((paramBoolean1) && (bool2) && (bool1)) || ((TroopKeywordManager.a(paramMessageRecord)) && (localMessageNotificationSettingManager != null))) {
        localMessageNotificationSettingManager.b(paramMessageRecord);
      }
      return;
      bool1 = false;
      bool2 = false;
    }
  }
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = this.h;
    boolean bool1 = bool2;
    if (localMessageNotificationSettingManager != null)
    {
      bool1 = bool2;
      if (paramMessageRecord != null) {
        bool1 = localMessageNotificationSettingManager.b(this.h, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.h), " isVideoing: ", Boolean.valueOf(this.g), " isRingerVibrate(): ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()), " isRingEqualsZero(): ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()), " isCallIdle: ", Boolean.valueOf(this.e), " notRecordingPtt: ", Boolean.valueOf(this.f), " enableSeparateSound: ", Boolean.valueOf(bool1) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_for_message", new Object[0]);
    int j;
    if ((this.h) && (!this.g) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()) && (this.e) && (this.f))
    {
      j = 1;
      if ((this.h) || (this.g) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()) || (!this.e) || (!this.f)) {
        break label356;
      }
    }
    label356:
    for (int k = 1;; k = 0)
    {
      if ((j == 0) || (!bool1)) {
        break label362;
      }
      a(paramMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
      return;
      j = 0;
      break;
    }
    label362:
    if (k != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
      try
      {
        c(paramMessageRecord, paramBoolean, bool1);
        return;
      }
      catch (Throwable paramMessageRecord)
      {
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_no_need_play_sound_for_message", new Object[] { "独立会话支持的会话类型，并且独立会话声音开关关闭，这种场景不用播放铃声（即使全局铃声开关打开）" });
  }
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    Object localObject = BaseApplication.getContext();
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject).getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    Vibrator localVibrator = (Vibrator)((BaseApplication)localObject).getSystemService("vibrator");
    localObject = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = this.i;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (paramMessageRecord != null) {
        bool1 = ((MessageNotificationSettingManager)localObject).a(this.i, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_enableSeparateVibrate", new Object[] { Boolean.valueOf(bool1) });
    int j;
    if ((this.i) && (paramBoolean2))
    {
      paramBoolean2 = true;
      this.i = paramBoolean2;
      if ((!this.i) || (!this.e) || (this.g) || (!this.f) || (!bool1)) {
        break label251;
      }
      j = 1;
      label160:
      if (j != 0)
      {
        if ((paramMessageRecord == null) || (!paramBoolean1) || (paramMessageRecord.msgtype != -2020) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStauts() != 11L)) {
          break label257;
        }
        j = 1;
        label200:
        if (j == 0) {
          break label263;
        }
        localVibrator.vibrate(QQAppInterface.VIBRATOR_PATTERN_SHAKE, -1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_shake_window_type", new Object[] { Integer.valueOf(2) });
        j = 2;
      }
    }
    for (;;)
    {
      a(j);
      return;
      paramBoolean2 = false;
      break;
      label251:
      j = 0;
      break label160;
      label257:
      j = 0;
      break label200;
      label263:
      localObject = "";
      if (paramMessageRecord != null)
      {
        paramMessageRecord = a(paramMessageRecord);
        localObject = "special_sound_type" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + paramMessageRecord;
      }
      if (localSharedPreferences.contains((String)localObject))
      {
        localVibrator.vibrate(1000L);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(3) });
        j = 3;
      }
      else
      {
        localVibrator.vibrate(QQAppInterface.VIBRATOR_PATTERN, -1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(1) });
        j = k;
      }
    }
  }
  
  void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_public_account_start", new Object[0]);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    Uri localUri = RingtoneManager.getActualDefaultRingtoneUri(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2);
    Vibrator localVibrator = (Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator");
    int j;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (this.b) && (!this.d))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
      j = 1;
      bool = false;
    }
    for (;;)
    {
      if ((j != 0) && (paramBoolean)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQAppInterface", 2, "canVibrator: " + paramBoolean + " canPlaySound: " + bool + " uri: " + localUri);
        }
        if ((paramBoolean) && (localVibrator != null))
        {
          localVibrator.vibrate(QQAppInterface.VIBRATOR_PATTERN, -1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_vibrate_invoked", new Object[0]);
        }
        if ((bool) && (localUri != null))
        {
          AudioUtil.a(localUri, false, false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_sound_invoked", new Object[] { localUri });
        }
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate()) && (this.b) && (!this.d))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
          j = 1;
          bool = true;
          break;
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate()) || (!this.b) || (this.d)) {
          break label411;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
        j = 0;
        bool = true;
        break;
      }
      label411:
      j = 0;
      bool = false;
    }
  }
  
  boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.b) && (!this.d);
  }
  
  boolean a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingRing() == 1) {}
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
        return bool;
      }
    }
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1001)
      {
        bool1 = bool2;
        if (!MsgBoxUtil.b(paramMessageRecord))
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause)
          {
            if (QLog.isColorLevel()) {
              QLog.e("SpecialCare", 2, "message.istroop = " + paramMessageRecord.istroop + " MsgBoxUtil.shouldInMsgBox(message) = " + MsgBoxUtil.b(paramMessageRecord));
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_UIN_TYPE_LBS_FRIEND", new Object[0]);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_invoked", new Object[0]);
    if (QLog.isColorLevel())
    {
      str = null;
      if (paramMessageRecord != null) {
        if (paramMessageRecord.msgtype != -2020) {
          break label79;
        }
      }
    }
    label79:
    for (String str = paramMessageRecord.getBaseInfoString();; str = "not shake msg,uinSeq is:" + paramMessageRecord.uniseq)
    {
      QLog.d("VibrateSoundHelper", 2, "message is:" + str + ",isOnline is:" + paramBoolean);
      return;
    }
  }
  
  void b(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_silent_start", new Object[0]);
    boolean bool2 = a(RoamSettingController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      if ((!this.h) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.troopCanPlaySound())) {
        break label216;
      }
      bool1 = true;
      this.h = bool1;
      if ((!this.i) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.troopCanVibrator())) {
        break label222;
      }
    }
    label216:
    label222:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.i = bool1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_troop_sound_vibrator", new Object[] { Boolean.valueOf(this.h), Boolean.valueOf(this.i) });
      if (QLog.isColorLevel()) {
        QLog.d("VibrateSoundHelper", 2, "canVibratorInGeneralSetting is:" + this.i + ",isVideoing is:" + this.g + ",isCallIdle is:" + this.e + ",notRecordingPtt is:" + this.f);
      }
      a(paramMessageRecord, paramBoolean1, paramBoolean2);
      a(paramMessageRecord, bool2);
      return;
      bool1 = false;
      break;
    }
  }
  
  boolean b(MessageRecord paramMessageRecord)
  {
    NewMsgNotificationManager localNewMsgNotificationManager = (NewMsgNotificationManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_MSG_NOTIFICATION_MANAGER);
    if (localNewMsgNotificationManager != null) {
      return localNewMsgNotificationManager.a(paramMessageRecord);
    }
    return true;
  }
  
  boolean c(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord != null) && (paramMessageRecord.istroop == 1008) && (AppConstants.REMINDER_UIN.equals(paramMessageRecord.senderuin));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.VibrateSoundHelper
 * JD-Core Version:    0.7.0.1
 */