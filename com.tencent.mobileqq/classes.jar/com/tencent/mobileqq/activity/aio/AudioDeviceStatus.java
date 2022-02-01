package com.tencent.mobileqq.activity.aio;

import android.media.AudioManager;
import com.tencent.av.audio.AudioSettingManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class AudioDeviceStatus
{
  protected volatile AudioDeviceStatus.AudioDeviceStatusResult a;
  protected boolean a;
  AudioPlayerHelper.AudioPlayerParameter[] a;
  protected volatile boolean b = false;
  protected volatile boolean c = false;
  protected volatile boolean d = false;
  private volatile boolean e = false;
  private boolean f = false;
  
  public AudioDeviceStatus()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult = null;
  }
  
  private AudioPlayerHelper.AudioPlayerParameter a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = AudioPlayerHelper.a();
    }
    AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter2 = this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[0];
    AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter1 = localAudioPlayerParameter2;
    if (paramInt >= 0)
    {
      localAudioPlayerParameter1 = localAudioPlayerParameter2;
      if (paramInt < this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter.length) {
        localAudioPlayerParameter1 = this.jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[paramInt];
      }
    }
    return localAudioPlayerParameter1;
  }
  
  public int a()
  {
    return 31;
  }
  
  public AudioDeviceStatus.AudioDeviceStatusResult a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult == null) {
      new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult;
  }
  
  public AudioDeviceStatus.AudioDeviceStatusResult a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      a("onAudioDeviceStatusChanged changeType = " + paramInt + "|" + paramBoolean);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult;
      a(paramBoolean);
      continue;
      b(paramBoolean);
      continue;
      c(paramBoolean);
      continue;
      d(paramBoolean);
    }
  }
  
  public AudioPlayerHelper.AudioPlayerParameter a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult.a() == null)) {
      return a(0);
    }
    a("getCurrentProperParam");
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult = new AudioDeviceStatus.AudioDeviceStatusResult(a(0), 0);
    this.b = AudioSettingManager.a(BaseApplicationImpl.getContext());
    this.e = AudioHelper.a(BaseApplicationImpl.getContext());
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_Boolean = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getLoudSpeakerState();
    }
    this.d = AudioHelper.c(BaseApplicationImpl.getContext());
    c();
    a("init ");
  }
  
  public void a(AudioManager paramAudioManager)
  {
    a("doOnBluetoothSCODisconnected isBluetoothA2dpOn = " + paramAudioManager.isBluetoothA2dpOn());
    if ((this.e) && (!paramAudioManager.isBluetoothA2dpOn())) {
      this.e = false;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (!StringUtil.a(paramString)) {
        localStringBuilder.append(paramString);
      }
      localStringBuilder.append("\n mCurDeviceStatus = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult.a);
      localStringBuilder.append("\n  userLoudSpeakerStatus = " + this.jdField_a_of_type_Boolean);
      localStringBuilder.append("\n  mNearToEar = " + this.c);
      localStringBuilder.append("\n  wiredHeadsetConnect = " + this.b);
      localStringBuilder.append("\n  blueHeadsetConnect = " + this.e);
      localStringBuilder.append("\n  mblueHeadsetSCOConnect = " + this.d);
      QLog.d("AudioPlayer_DeviceStatus", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.f)
    {
      e(AudioHelper.c(BaseApplicationImpl.getContext()));
      this.f = true;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.c != paramBoolean) {
      this.c = paramBoolean;
    }
    c();
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  protected void c()
  {
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult1 = a();
    int i = 0;
    if ((AudioPlayerBase.b) && (this.d)) {
      i = 4;
    }
    while (localAudioDeviceStatusResult1 == null)
    {
      return;
      if (this.b) {
        i = 2;
      } else if (this.e) {
        i = 3;
      } else if ((!this.jdField_a_of_type_Boolean) || (this.c)) {
        i = 1;
      }
    }
    AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult2 = new AudioDeviceStatus.AudioDeviceStatusResult(a(i), i, true);
    if (!localAudioDeviceStatusResult1.a(localAudioDeviceStatusResult2)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus$AudioDeviceStatusResult = localAudioDeviceStatusResult2;
    }
    a("updateCurrentStatus end nextStatusType = " + i);
  }
  
  protected void c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    c();
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  protected void d(boolean paramBoolean)
  {
    this.e = AudioHelper.a(BaseApplicationImpl.getContext());
    this.d = AudioHelper.c(BaseApplicationImpl.getContext());
    c();
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioDeviceStatus
 * JD-Core Version:    0.7.0.1
 */