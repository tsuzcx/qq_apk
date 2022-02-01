package com.tencent.avgame.audio;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistCallback;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AudioRouter
  implements SurvivalAssistCallback
{
  private int jdField_a_of_type_Int = -1;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new AudioRouter.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b = false;
  
  private void a(int paramInt1, int paramInt2)
  {
    QLog.d("AudioRouter", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(a()), Boolean.valueOf(b()), Integer.valueOf(paramInt2) }));
    c(paramInt1);
    b(paramInt1, paramInt2);
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    AVGameHandler.a().a().post(new AudioRouter.3(this, paramIntent, str));
  }
  
  private boolean a()
  {
    return ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if ((paramInt != 0) && (a()))
    {
      c(0);
      paramInt = 3;
    }
    for (;;)
    {
      b(i, paramInt);
      return;
      if ((paramInt != 2) && (b()))
      {
        c(2);
        i = 2;
        paramInt = 0;
      }
      else
      {
        c(1);
        paramInt = 0;
        i = 1;
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    AVGameBusinessCtrl.b().a(paramInt1, paramInt2);
  }
  
  private boolean b()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    int i;
    int j;
    int k;
    if (((BluetoothAdapter)localObject).isEnabled())
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i != 2) {}
    }
    for (;;)
    {
      localObject = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
      if ((i != -1) || (((AudioManager)localObject).isBluetoothA2dpOn()))
      {
        return true;
        i = j;
        if (j == 2) {
          continue;
        }
        if (k == 2) {
          i = k;
        }
      }
      else
      {
        return false;
      }
      i = -1;
    }
  }
  
  private void c(int paramInt)
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    if (paramInt == 0)
    {
      try
      {
        localAudioManager.stopBluetoothSco();
        localAudioManager.setBluetoothScoOn(false);
        localAudioManager.setSpeakerphoneOn(false);
        if (Build.VERSION.SDK_INT >= 21) {
          localAudioManager.setMode(3);
        }
        for (;;)
        {
          this.jdField_a_of_type_Int = paramInt;
          return;
          localAudioManager.setMode(2);
        }
        if (paramInt != 1) {
          break label97;
        }
      }
      catch (Exception localException)
      {
        AVLog.a("AudioRouter", "setAudioRouteInternal fail.", localException);
        return;
      }
    }
    else
    {
      localException.stopBluetoothSco();
      localException.setBluetoothScoOn(false);
      localException.setSpeakerphoneOn(true);
      localException.setMode(3);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    label97:
    if (paramInt == 2)
    {
      localException.startBluetoothSco();
      localException.setBluetoothScoOn(true);
      localException.setSpeakerphoneOn(false);
      localException.setMode(3);
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    QLog.d("AudioRouter", 1, "start");
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = -1;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.b = true;
    AVGameHandler.a().a().post(new AudioRouter.2(this));
  }
  
  public void a(int paramInt)
  {
    c(paramInt);
    b(paramInt, 0);
  }
  
  public void b()
  {
    QLog.d("AudioRouter", 1, "stop");
    this.jdField_a_of_type_Int = -1;
    if (this.b)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.b = false;
    }
  }
  
  public void c()
  {
    if (a()) {
      c(0);
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Int, -1);
      return;
      if (b()) {
        c(2);
      } else {
        c(1);
      }
    }
  }
  
  public void d()
  {
    a();
  }
  
  public void e()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.audio.AudioRouter
 * JD-Core Version:    0.7.0.1
 */