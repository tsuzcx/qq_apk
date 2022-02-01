package com.tencent.av.utils.api;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IAudioHelperApi
  extends QRouteApi
{
  public abstract void changButtonStyle(Resources paramResources, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void changButtonStyle(Resources paramResources, TextView paramTextView, boolean paramBoolean, int paramInt);
  
  public abstract void changViewStyle(View paramView, boolean paramBoolean, int paramInt);
  
  @TargetApi(17)
  public abstract long elapsedRealtimeNanos();
  
  public abstract long enlargeVolumWrapper(Context paramContext, byte[] paramArrayOfByte, int paramInt, float paramFloat);
  
  public abstract long genDebugSeq();
  
  public abstract int getDebugValue(int paramInt);
  
  public abstract String getLogString(Object paramObject);
  
  public abstract String getResIDName(Resources paramResources, int paramInt);
  
  public abstract String getResIDName(View paramView, int paramInt);
  
  public abstract long getServerMSTime();
  
  public abstract void initDebugValue();
  
  public abstract boolean isAccelerateSensorInsensitive();
  
  public abstract boolean isBluetoothHeadsetA2dpOn();
  
  public abstract boolean isBluetoothHeadsetOn(Context paramContext);
  
  public abstract boolean isBluetoothHeadsetScoOn(Context paramContext);
  
  public abstract boolean isBluetoothScoOn(Context paramContext);
  
  @TargetApi(15)
  public abstract boolean isBluetoothSupportA2dp(BluetoothDevice paramBluetoothDevice);
  
  public abstract boolean isDev();
  
  public abstract boolean isForbidByRubbishMeizu(int paramInt);
  
  public abstract boolean isForbidByRubbishMeizu(int paramInt, Context paramContext);
  
  public abstract boolean isForbidByRubbishXiaomi(int paramInt);
  
  public abstract boolean isHuaweiGreen();
  
  public abstract boolean isHuaweiGreenForSegment();
  
  public abstract boolean isLogColorOrGary();
  
  public abstract void print(String paramString, Intent paramIntent);
  
  public abstract void print(String paramString, Bundle paramBundle);
  
  public abstract void print(String paramString, Bundle paramBundle, boolean paramBoolean);
  
  public abstract <T1, T2> void print(String paramString, Map<T1, T2> paramMap, boolean paramBoolean);
  
  public abstract String printBaseInfo(AppInterface paramAppInterface);
  
  public abstract String printBaseInfo(AppInterface paramAppInterface, int paramInt);
  
  @TargetApi(17)
  public abstract void printTime(String paramString);
  
  public abstract boolean registDebugReceiver(BaseApplication paramBaseApplication, long paramLong);
  
  public abstract void reportExp(String paramString, boolean paramBoolean);
  
  public abstract void saveAudioPlayerParam(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void sendValueChanged(BaseApplication paramBaseApplication, int paramInt);
  
  public abstract void setBeaconDebug(Context paramContext);
  
  public abstract void setCurAccount(long paramLong);
  
  public abstract void setDebugValue(int paramInt1, int paramInt2);
  
  public abstract void showDebugToast(String paramString);
  
  public abstract long stringToLong(String paramString);
  
  public abstract void syncPrintBaseInfo(AppInterface paramAppInterface);
  
  public abstract void writeTestLog(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.api.IAudioHelperApi
 * JD-Core Version:    0.7.0.1
 */