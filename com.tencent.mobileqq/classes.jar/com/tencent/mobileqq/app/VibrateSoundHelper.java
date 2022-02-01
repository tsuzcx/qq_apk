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
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("isRingerSilent is:");
      paramQQAppInterface.append(this.jdField_a_of_type_Boolean);
      paramQQAppInterface.append(",canDisturb is:");
      paramQQAppInterface.append(this.b);
      QLog.d("VibrateSoundHelper", 2, new Object[] { paramQQAppInterface.toString(), " isMute:", Boolean.valueOf(this.d), " newMsgNotificationEnabled: ", Boolean.valueOf(this.c), " isCallIdle: ", Boolean.valueOf(this.e), " notRecordingPtt: ", Boolean.valueOf(this.f), " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.h), " canVibratorInGeneralSetting: ", Boolean.valueOf(this.i) });
    }
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1004))
    {
      if (UinTypeUtil.a(paramMessageRecord.istroop) == 1032) {
        return AppConstants.CONFESS_UIN;
      }
      return paramMessageRecord.senderuin;
    }
    return paramMessageRecord.frienduin;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = 0;
    ((QQAppInterface)localObject).unitTestLog("vibratorAndAudio_check_sound_for_message_enableSeparateSound", new Object[0]);
    int k = SettingCloneUtil.readValueForInt(BaseApplication.context, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sound_type", "qqsetting_notify_soundtype_key", SoundAndVibrateActivity.b);
    if (QLog.isColorLevel())
    {
      localObject = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("audio");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StreamVolume=");
      if (localObject != null) {
        j = ((AudioManager)localObject).getStreamVolume(2);
      }
      localStringBuilder.append(j);
      localStringBuilder.append(",SoundRid=");
      localStringBuilder.append(k);
      QLog.d("VibrateSoundHelper", 2, localStringBuilder.toString());
    }
    if (localMessageNotificationSettingManager != null)
    {
      if (MessageNotificationSettingManager.a(paramMessageRecord))
      {
        localMessageNotificationSettingManager.b(paramMessageRecord);
        return;
      }
      localMessageNotificationSettingManager.b();
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
  
  private void c(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_sp_message", new Object[] { Boolean.valueOf(paramBoolean2) });
    if (((paramBoolean1) && (bool2) && (bool1)) || ((TroopKeywordManager.a(paramMessageRecord)) && (localMessageNotificationSettingManager != null))) {
      localMessageNotificationSettingManager.b(paramMessageRecord);
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
        bool1 = localMessageNotificationSettingManager.b(bool2, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQAppInterface", 2, new Object[] { "vibratorAndAudio: invoked. ", " canPlaySoundInGeneralSetting: ", Boolean.valueOf(this.h), " isVideoing: ", Boolean.valueOf(this.g), " isRingerVibrate(): ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()), " isRingEqualsZero(): ", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()), " isCallIdle: ", Boolean.valueOf(this.e), " notRecordingPtt: ", Boolean.valueOf(this.f), " enableSeparateSound: ", Boolean.valueOf(bool1) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_for_message", new Object[0]);
    int j;
    if ((this.h) && (!this.g) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()) && (this.e) && (this.f)) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if ((!this.h) && (!this.g) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingEqualsZero()) && (this.e) && (this.f)) {
      k = 1;
    } else {
      k = 0;
    }
    if ((j != 0) && (bool1))
    {
      a(paramMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
      return;
    }
    if (k != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_play_sound_for_message", new Object[] { Boolean.valueOf(bool1) });
    }
    try
    {
      c(paramMessageRecord, paramBoolean, bool1);
      return;
    }
    catch (Throwable paramMessageRecord) {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_no_need_play_sound_for_message", new Object[] { "独立会话支持的会话类型，并且独立会话声音开关关闭，这种场景不用播放铃声（即使全局铃声开关打开）" });
    return;
  }
  
  void a(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = BaseApplication.getContext();
    SharedPreferences localSharedPreferences = ((BaseApplication)localObject1).getSharedPreferences("com.tencent.mobileqq_preferences", 0);
    localObject1 = (Vibrator)((BaseApplication)localObject1).getSystemService("vibrator");
    Object localObject2 = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    boolean bool2 = this.i;
    boolean bool1 = bool2;
    if (localObject2 != null)
    {
      bool1 = bool2;
      if (paramMessageRecord != null) {
        bool1 = ((MessageNotificationSettingManager)localObject2).a(bool2, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_enableSeparateVibrate", new Object[] { Boolean.valueOf(bool1) });
    if ((this.i) && (paramBoolean2)) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    this.i = paramBoolean2;
    int j;
    if ((this.i) && (this.e) && (!this.g) && (this.f) && (bool1)) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      if ((paramMessageRecord != null) && (paramBoolean1) && (paramMessageRecord.msgtype == -2020) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStauts() == 11L)) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        ((Vibrator)localObject1).vibrate(QQAppInterface.VIBRATOR_PATTERN_SHAKE, -1);
        j = 2;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_shake_window_type", new Object[] { Integer.valueOf(2) });
      }
      else
      {
        if (paramMessageRecord != null)
        {
          paramMessageRecord = a(paramMessageRecord);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("special_sound_type");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          j = 3;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(3) });
        }
        else
        {
          ((Vibrator)localObject1).vibrate(QQAppInterface.VIBRATOR_PATTERN, -1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_message", new Object[] { Integer.valueOf(1) });
          j = 1;
        }
      }
      a(j);
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = Boolean.valueOf(false);
    ((QQAppInterface)localObject2).unitTestLog("vibratorAndAudio_check_public_account_start", new Object[0]);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    localObject2 = Boolean.valueOf(true);
    ((QQAppInterface)localObject3).unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject1, localObject1 });
    localObject3 = RingtoneManager.getActualDefaultRingtoneUri(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2);
    Vibrator localVibrator = (Vibrator)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("vibrator");
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerVibrate()) && (this.b) && (!this.d))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject1, localObject2 });
      j = 1;
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate()) && (this.b) && (!this.d)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject2, localObject2 });
      }
      for (j = 1;; j = 0)
      {
        bool = true;
        break label279;
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRingerNormalVibrate()) || (!this.b) || (this.d)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_sound_vibrate", new Object[] { localObject2, localObject1 });
      }
      j = 0;
    }
    boolean bool = false;
    label279:
    if ((j != 0) && (paramBoolean)) {
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
      localVibrator.vibrate(QQAppInterface.VIBRATOR_PATTERN, -1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_vibrate_invoked", new Object[0]);
    }
    if ((bool) && (localObject3 != null))
    {
      AudioUtil.a((Uri)localObject3, false, false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_sound_invoked", new Object[] { localObject3 });
    }
  }
  
  boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (this.b) && (!this.d);
  }
  
  boolean a(int paramInt)
  {
    boolean bool;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getALLGeneralSettingRing() == 1) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_canPlaySpecialFriendSound", new Object[] { Boolean.valueOf(bool) });
    return bool;
  }
  
  boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1001) && (!MsgBoxUtil.b(paramMessageRecord)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundPause))
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_UIN_TYPE_LBS_FRIEND", new Object[0]);
      return true;
    }
    return false;
  }
  
  void b(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_invoked", new Object[0]);
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
  
  void b(MessageRecord paramMessageRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_check_silent_start", new Object[0]);
    boolean bool2 = a(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getSpecialCareRingRoamingSetting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      boolean bool1;
      if ((this.h) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.troopCanPlaySound())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.h = bool1;
      if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.troopCanVibrator())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.i = bool1;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unitTestLog("vibratorAndAudio_troop_sound_vibrator", new Object[] { Boolean.valueOf(this.h), Boolean.valueOf(this.i) });
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canVibratorInGeneralSetting is:");
      localStringBuilder.append(this.i);
      localStringBuilder.append(",isVideoing is:");
      localStringBuilder.append(this.g);
      localStringBuilder.append(",isCallIdle is:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(",notRecordingPtt is:");
      localStringBuilder.append(this.f);
      QLog.d("VibrateSoundHelper", 2, localStringBuilder.toString());
    }
    a(paramMessageRecord, paramBoolean1, paramBoolean2);
    a(paramMessageRecord, bool2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VibrateSoundHelper
 * JD-Core Version:    0.7.0.1
 */