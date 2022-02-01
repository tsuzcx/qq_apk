package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class AudioDeviceManager
  extends BroadcastReceiver
  implements AudioSenorManager.IAudioSenorListener, Manager
{
  private AudioSenorManager jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager;
  private List<AudioDeviceManager.IAudioDeviceListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  public AudioDeviceManager(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    if (Build.VERSION.SDK_INT >= 11)
    {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager = new AudioSenorManager(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager.a(this);
    a(paramQQAppInterface);
  }
  
  public static AudioDeviceManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (AudioDeviceManager)paramQQAppInterface.getManager(QQManagerFactory.AUDIO_DEVICE_MANAGER);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioDeviceManager", 2, "notifyAllDeviceStatusChanged: changedType=" + paramInt + " changedValue=" + paramBoolean);
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AudioDeviceManager.IAudioDeviceListener localIAudioDeviceListener = (AudioDeviceManager.IAudioDeviceListener)localIterator.next();
      if ((localIAudioDeviceListener.a() & paramInt) == paramInt)
      {
        QLog.d("AudioDeviceManager", 2, "notifyAllDeviceStatusChanged: audioDeviceListener=" + localIAudioDeviceListener.getClass());
        localIAudioDeviceListener.a(paramInt, paramBoolean);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioDeviceManager", 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      a();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().unregisterReceiver(this);
      }
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      if (QLog.isColorLevel()) {
        QLog.d("AudioDeviceManager", 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioDeviceManager", 2, "", localException);
    }
  }
  
  public void a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioDeviceManager", 2, "onNearToEarStatusChanged: senorIsNear=" + bool + " | isRingerMode_not_normal =" + this.c);
      }
      if (bool != this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = bool;
        a(2, bool);
      }
      return;
      bool = false;
    }
  }
  
  public void a(AudioDeviceManager.IAudioDeviceListener paramIAudioDeviceListener)
  {
    if (paramIAudioDeviceListener == null)
    {
      QLog.e("AudioDeviceManager", 2, "registerAudioDeviceListener listener is null");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramIAudioDeviceListener))
    {
      QLog.e("AudioDeviceManager", 2, "registerAudioDeviceListener listener is contains");
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramIAudioDeviceListener);
  }
  
  public void b(AudioDeviceManager.IAudioDeviceListener paramIAudioDeviceListener)
  {
    if (paramIAudioDeviceListener == null)
    {
      QLog.e("AudioDeviceManager", 2, "unRegisterAudioDeviceListener listener is null");
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramIAudioDeviceListener))
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIAudioDeviceListener);
      return;
    }
    QLog.e("AudioDeviceManager", 2, "unRegisterAudioDeviceListener listener is not contains");
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager = null;
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label73;
        }
        bool1 = true;
        if (this.b != bool1)
        {
          this.b = bool1;
          a(4, bool1);
        }
      }
    }
    label73:
    int i;
    label376:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            bool1 = false;
            break;
            if ("android.media.RINGER_MODE_CHANGED".equals(str))
            {
              paramContext = (AudioManager)paramContext.getSystemService("audio");
              try
              {
                i = paramContext.getRingerMode();
                if (QLog.isColorLevel()) {
                  QLog.d("AudioDeviceManager", 2, "currentRingerMode:" + i);
                }
                if (i != 2)
                {
                  bool1 = true;
                  if (bool1 == this.c) {
                    continue;
                  }
                  this.c = bool1;
                  if (!bool1) {
                    continue;
                  }
                  if (this.jdField_a_of_type_MqqUtilWeakReference != null)
                  {
                    paramContext = (QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get();
                    if (paramContext != null) {
                      paramContext.setLoudSpeakerState(false);
                    }
                  }
                  a(1, false);
                }
              }
              catch (Throwable paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("AudioDeviceManager", 2, "onReceive getRingerMode error:" + paramContext.getMessage());
                  }
                  i = 2;
                  continue;
                  bool1 = false;
                }
              }
            }
          }
          if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) {
            break label376;
          }
          i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        } while ((i != 2) && (i != 0));
        if (i == 2) {}
        for (;;)
        {
          if (bool1 != this.d)
          {
            this.d = bool1;
            a(8, bool1);
          }
          if (i != 0) {
            break;
          }
          bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
          bool2 = AudioHelper.c();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("AudioPlayer", 2, "BluetoothHeadset.STATE_DISCONNECTED: isSysA2dpOn=" + bool1 + "| isAppA2dpOn = " + bool2);
          return;
          bool1 = false;
        }
      } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(str));
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((i != 2) && (i != 0));
    if (i == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      if (bool1 != this.e)
      {
        this.e = bool1;
        a(16, bool1);
      }
      if (i != 0) {
        break;
      }
      bool1 = ((AudioManager)paramContext.getSystemService("audio")).isBluetoothA2dpOn();
      bool2 = AudioHelper.c();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AudioPlayer", 2, "BluetoothA2dp.STATE_DISCONNECTED: isSysA2dpOn=" + bool1 + "| isAppA2dpOn = " + bool2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioDeviceManager
 * JD-Core Version:    0.7.0.1
 */