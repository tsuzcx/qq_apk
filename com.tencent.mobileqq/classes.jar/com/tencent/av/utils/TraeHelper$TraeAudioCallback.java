package com.tencent.av.utils;

import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.ITraeAudioSessionApi;
import com.tencent.sharp.jni.callback.ITraeAudioCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

class TraeHelper$TraeAudioCallback
  implements ITraeAudioCallback
{
  TraeHelper$TraeAudioCallback(TraeHelper paramTraeHelper) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    TraeHelper localTraeHelper = this.a;
    localTraeHelper.jdField_a_of_type_Int = paramInt2;
    localTraeHelper.jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt2;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetConnectedDeviceRes err is: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" device name is: ");
      localStringBuilder.append(paramString);
      QLog.i("TraeSessionHelper", 2, localStringBuilder.toString());
    }
    if (TraeHelper.a(this.a) != null) {
      TraeHelper.a(this.a).a(paramString);
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConnectDeviceRes, err[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], strDeviceName[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], bIsConnected[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().c != 3) {
        this.a.jdField_a_of_type_ComTencentAvVideoController.a().b("onConnectDeviceRes", paramString);
      }
      this.a.a();
      if (this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) {
        this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.getConnectedDevice(l);
      }
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0) {
      return;
    }
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool)
    {
      paramString2 = new StringBuilder();
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        paramString2.append(paramArrayOfString[paramInt]);
        paramString2.append(" ");
        paramInt += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetDeviceListRes strDeviceList: ");
      localStringBuilder.append(paramString2.toString());
      QLog.d("TraeSessionHelper", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    paramString2 = this.a.jdField_a_of_type_ComTencentAvVideoController.a().p;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a = paramArrayOfString;
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().b("onGetDeviceListRes", paramString1);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().q = paramString3;
    TraeHelper.a(this.a, paramArrayOfString);
    TraeHelper.a(this.a, paramString2, paramString1);
    if (paramArrayOfString != null)
    {
      paramInt = i;
      while (paramInt < paramArrayOfString.length)
      {
        if (paramArrayOfString[paramInt].equals("DEVICE_WIRED_HEADSET")) {
          DataReport.k(this.a.jdField_a_of_type_ComTencentAvVideoController);
        }
        paramInt += 1;
      }
    }
  }
  
  public void a(long paramLong)
  {
    MediaPlayer.OnCompletionListener localOnCompletionListener = this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener;
    this.a.jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRingCompletion, mRingComListener[");
    localStringBuilder.append(localOnCompletionListener);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("TraeSessionHelper", 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().a().post(new TraeHelper.TraeAudioCallback.1(this, localOnCompletionListener));
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject = this.a;
    ((TraeHelper)localObject).jdField_a_of_type_Int = paramInt;
    ((TraeHelper)localObject).jdField_a_of_type_ComTencentAvVideoController.a().C = paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStreamTypeUpdate, streamType[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject).toString());
    }
    localObject = this.a;
    ((TraeHelper)localObject).a(paramLong, ((TraeHelper)localObject).jdField_a_of_type_ComTencentAvVideoController.a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ConnectDeviceWhenServiceOn, deviceName[");
        ((StringBuilder)localObject).append(this.a.jdField_b_of_type_JavaLangString);
        ((StringBuilder)localObject).append("], seq[");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append("]");
        QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((TraeHelper)localObject).a(paramLong, ((TraeHelper)localObject).jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    int i;
    if (bool)
    {
      localObject1 = new StringBuilder();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        ((StringBuilder)localObject1).append(paramArrayOfString[i]);
        ((StringBuilder)localObject1).append(" ");
        i += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDeviceListUpdate, strConnectedDeviceName[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("], strPrevConnectedDeviceName[");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("], bluetoothName[");
      ((StringBuilder)localObject2).append(paramString3);
      ((StringBuilder)localObject2).append("], strDeviceList[");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      QLog.w("TraeSessionHelper", 1, ((StringBuilder)localObject2).toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = ((SessionInfo)localObject1).a;
    if (((SessionInfo)localObject1).c != 3)
    {
      paramString2 = ((SessionInfo)localObject1).p;
      ((SessionInfo)localObject1).b("onDeviceListUpdate", paramString1);
    }
    else
    {
      paramString2 = "";
    }
    ((SessionInfo)localObject1).a = paramArrayOfString;
    ((SessionInfo)localObject1).q = paramString3;
    TraeHelper.a(this.a, paramArrayOfString);
    TraeHelper.a(this.a, paramString2, paramString1);
    if (TraeHelper.a(this.a) != null) {
      TraeHelper.a(this.a).notifyDataSetChanged();
    }
    this.a.a();
    if ((this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) && (localObject2 != null) && (paramArrayOfString != null))
    {
      paramString2 = Arrays.asList((Object[])localObject2);
      paramString3 = Arrays.asList(paramArrayOfString);
      if ((paramString3.contains("DEVICE_BLUETOOTH_HEADSET")) && (paramString3.contains("DEVICE_WIRED_HEADSET"))) {
        if ((paramString2.contains("DEVICE_BLUETOOTH_HEADSET")) && (!paramString2.contains("DEVICE_WIRED_HEADSET")))
        {
          if ("DEVICE_BLUETOOTH_HEADSET".equals(paramString1)) {
            this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(paramLong, "DEVICE_WIRED_HEADSET");
          }
        }
        else if ((!paramString2.contains("DEVICE_BLUETOOTH_HEADSET")) && (paramString2.contains("DEVICE_WIRED_HEADSET")) && ("DEVICE_WIRED_HEADSET".equals(paramString1))) {
          this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(paramLong, "DEVICE_BLUETOOTH_HEADSET");
        }
      }
    }
    if (paramArrayOfString != null)
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals("DEVICE_WIRED_HEADSET")) {
          DataReport.k(this.a.jdField_a_of_type_ComTencentAvVideoController);
        }
        i += 1;
      }
    }
    if (!"DEVICE_NONE".equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().s))
    {
      if (!paramString1.equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().s)) {
        this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.connectDevice(paramLong, this.a.jdField_a_of_type_ComTencentAvVideoController.a().s);
      }
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().s = "DEVICE_NONE";
    }
    if (TraeHelper.a(this.a) != null)
    {
      TraeHelper.a(this.a).a(null, new TraeHelper.SoundOutputRes(paramArrayOfString));
      if (this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi != null) {
        this.a.jdField_a_of_type_ComTencentSharpJniApiITraeAudioSessionApi.getConnectedDevice(paramLong);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeginConnectDevice connectedDev: ");
      localStringBuilder.append(paramString);
      QLog.i("TraeSessionHelper", 2, localStringBuilder.toString());
    }
    if ("DEVICE_BLUETOOTH_HEADSET".equals(paramString)) {
      TipsUtil.a((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime(), 3012);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    int i = this.a.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if ((i == 1) || (i == 2))
    {
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.f()) {
        return;
      }
      if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().j()) {
        return;
      }
    }
    if (this.a.jdField_b_of_type_JavaLangRefWeakReference != null)
    {
      Button localButton = (Button)this.a.jdField_b_of_type_JavaLangRefWeakReference.get();
      if ((localButton != null) && (paramBoolean != localButton.isClickable())) {
        localButton.setClickable(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.TraeHelper.TraeAudioCallback
 * JD-Core Version:    0.7.0.1
 */