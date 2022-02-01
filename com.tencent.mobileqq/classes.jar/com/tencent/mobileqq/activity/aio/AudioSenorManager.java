package com.tencent.mobileqq.activity.aio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AudioSenorManager
  extends BroadcastReceiver
{
  public static int a;
  float jdField_a_of_type_Float;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private AudioSenorManager.AccelerationEventListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$AccelerationEventListener;
  private AudioSenorManager.IAudioSenorListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$IAudioSenorListener = null;
  private AudioSenorManager.ProximityEventListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$ProximityEventListener;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new AudioSenorManager.1(this);
  private List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  float jdField_b_of_type_Float;
  private volatile int jdField_b_of_type_Int = 0;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  Runnable jdField_b_of_type_JavaLangRunnable = new AudioSenorManager.2(this);
  private boolean jdField_b_of_type_Boolean = false;
  float c;
  private float d;
  private float e = 0.6F;
  private float f = 0.02F;
  
  static
  {
    jdField_a_of_type_Int = 1000;
  }
  
  public AudioSenorManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApp();
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramQQAppInterface.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.audiosenormanager.audio.start");
    localIntentFilter.addAction("mqq.audiosenormanager.audio.end");
    paramQQAppInterface.registerReceiver(this, localIntentFilter);
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  private void a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString);
      }
      c();
      ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
      ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
    }
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  private void b()
  {
    int k = 0;
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_audio_play.name(), null);
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SenorManager", 2, "MediaPlayerManager.initSensors | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {}
    for (;;)
    {
      int i;
      float f1;
      try
      {
        localObject = ((String)localObject).split("\\|");
        bool = "1".equals(localObject[0]);
        if (!bool) {
          i = 1;
        }
      }
      catch (Exception localException1)
      {
        boolean bool;
        i = 1;
        f1 = 0.0F;
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_SenorManager", 2, "parse dpc error", localException1);
        }
        continue;
      }
      try
      {
        f1 = Float.parseFloat(localObject[1]);
      }
      catch (Exception localException3)
      {
        f1 = 0.0F;
        continue;
      }
      try
      {
        if (localObject.length >= 5)
        {
          this.e = Float.parseFloat(localObject[2]);
          this.f = Float.parseFloat(localObject[3]);
          jdField_a_of_type_Int = Integer.parseInt(localObject[4]);
        }
        if (jdField_a_of_type_Int < 0) {
          jdField_a_of_type_Int = 1000;
        }
        if (this.e > 0.0F) {
          break label498;
        }
        i = 0;
      }
      catch (Exception localException4)
      {
        continue;
        continue;
      }
      localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.qq_audio_play_fix.name(), null);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SenorManager", 2, "DPC config to UIN | dpcConfig = " + (String)localObject);
      }
      float f2 = f1;
      int j = i;
      float f3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        f2 = f1;
        j = i;
        if (((String)localObject).length() > 1) {
          f3 = f1;
        }
      }
      try
      {
        localObject = ((String)localObject).split("\\|");
        f2 = f1;
        f3 = f1;
        if (!"-1".equals(localObject[4]))
        {
          f3 = f1;
          f2 = Float.parseFloat(localObject[4]);
        }
        f3 = f2;
        bool = "1".equals(localObject[5]);
        i = k;
        if (!bool) {
          i = 1;
        }
        j = i;
      }
      catch (Exception localException2)
      {
        f2 = f3;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AudioPlayer_SenorManager", 2, "DPC config to UIN error.", localException2);
        f2 = f3;
        j = i;
        continue;
        if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
          continue;
        }
        this.d = a(this.jdField_a_of_type_AndroidHardwareSensor);
        continue;
      }
      if (j != 0)
      {
        this.jdField_b_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$AccelerationEventListener = new AudioSenorManager.AccelerationEventListener(this);
      }
      this.jdField_a_of_type_AndroidHardwareSensor = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$ProximityEventListener = new AudioSenorManager.ProximityEventListener(this);
      if (f2 > 0.5F)
      {
        this.d = f2;
        this.jdField_b_of_type_Boolean = true;
        return;
        i = 0;
      }
      else
      {
        label498:
        f1 = 0.0F;
        i = 1;
      }
    }
  }
  
  private void b(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.indexOf(paramString));
      }
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
        ThreadManager.excute(this.jdField_b_of_type_JavaLangRunnable, 16, null, false);
        if (this.jdField_b_of_type_Int != 0)
        {
          this.jdField_b_of_type_Int = 0;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$IAudioSenorListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$IAudioSenorListener.a(this.jdField_b_of_type_Int);
          }
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Float = -999.0F;
    this.jdField_b_of_type_Float = -999.0F;
    this.c = -999.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$IAudioSenorListener = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    ThreadManager.removeJobFromThreadPool(this.jdField_b_of_type_JavaLangRunnable, 16);
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$AccelerationEventListener);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$ProximityEventListener);
  }
  
  public void a(AudioSenorManager.IAudioSenorListener paramIAudioSenorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioSenorManager$IAudioSenorListener = paramIAudioSenorListener;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("audiosenormanager.playkey");
    if ((paramContext != null) && (paramContext.equals("mqq.audiosenormanager.audio.start")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_START_NOTIFY key = " + paramIntent);
      }
      if (!this.jdField_b_of_type_Boolean) {
        b();
      }
      a(paramIntent);
    }
    while ((paramContext == null) || (!paramContext.equals("mqq.audiosenormanager.audio.end"))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_SenorManager", 2, "onReceive AUDIO_SENOR_END_NOTIFY key = " + paramIntent);
    }
    b(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioSenorManager
 * JD-Core Version:    0.7.0.1
 */