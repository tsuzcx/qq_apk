package com.tencent.avgame.qav.audio;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.avgame.gamelogic.controller.SurvivalAssistCallback;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

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
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    return ((AudioManager)MobileQQ.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  private void b(int paramInt)
  {
    int j = 1;
    int i = 0;
    if ((paramInt != 0) && (a()))
    {
      c(0);
      paramInt = 0;
      i = 3;
    }
    else if ((paramInt != 2) && (b()))
    {
      c(2);
      paramInt = 2;
    }
    else
    {
      c(1);
      paramInt = j;
    }
    b(paramInt, i);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (IAVGameBusinessCtrl.a() != null) {
      IAVGameBusinessCtrl.a().a(paramInt1, paramInt2);
    }
  }
  
  private boolean b()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = ((BluetoothAdapter)localObject).isEnabled();
    boolean bool1 = true;
    if (bool2)
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      int j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      int k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i == 2) {
        break label71;
      }
      if (j == 2)
      {
        i = j;
        break label71;
      }
      if (k == 2)
      {
        i = k;
        break label71;
      }
    }
    int i = -1;
    label71:
    localObject = MobileQQ.sMobileQQ;
    localObject = (AudioManager)MobileQQ.getContext().getSystemService("audio");
    if (i == -1)
    {
      if (((AudioManager)localObject).isBluetoothA2dpOn()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void c(int paramInt)
  {
    Object localObject = MobileQQ.sMobileQQ;
    localObject = (AudioManager)MobileQQ.getContext().getSystemService("audio");
    if (paramInt == 0) {}
    try
    {
      ((AudioManager)localObject).stopBluetoothSco();
      ((AudioManager)localObject).setBluetoothScoOn(false);
      ((AudioManager)localObject).setSpeakerphoneOn(false);
      if (Build.VERSION.SDK_INT >= 21) {
        ((AudioManager)localObject).setMode(3);
      } else {
        ((AudioManager)localObject).setMode(2);
      }
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    catch (Exception localException)
    {
      label121:
      break label121;
    }
    if (paramInt == 1)
    {
      ((AudioManager)localObject).stopBluetoothSco();
      ((AudioManager)localObject).setBluetoothScoOn(false);
      ((AudioManager)localObject).setSpeakerphoneOn(true);
      ((AudioManager)localObject).setMode(3);
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
    if (paramInt == 2)
    {
      ((AudioManager)localObject).startBluetoothSco();
      ((AudioManager)localObject).setBluetoothScoOn(true);
      ((AudioManager)localObject).setSpeakerphoneOn(false);
      ((AudioManager)localObject).setMode(3);
      this.jdField_a_of_type_Int = paramInt;
      return;
      AVLog.a("AudioRouter", "setAudioRouteInternal fail.", (Throwable)localObject);
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
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    MobileQQ.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
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
      MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      MobileQQ.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.b = false;
    }
  }
  
  public void c()
  {
    if (a()) {
      c(0);
    } else if (b()) {
      c(2);
    } else {
      c(1);
    }
    b(this.jdField_a_of_type_Int, -1);
  }
  
  public void onEnterSurvivalRoom()
  {
    a();
  }
  
  public void onQuitSurvivalRoom()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.audio.AudioRouter
 * JD-Core Version:    0.7.0.1
 */