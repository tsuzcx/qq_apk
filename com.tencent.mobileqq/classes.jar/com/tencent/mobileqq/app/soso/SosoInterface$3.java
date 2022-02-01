package com.tencent.mobileqq.app.soso;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

final class SosoInterface$3
  implements TencentLocationListener
{
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramTencentLocation == null) {}
    int j;
    do
    {
      return;
      j = paramTencentLocation.getExtra().getInt("qq_level");
    } while (SosoInterface.access$600(paramTencentLocation, paramInt, j));
    SosoInterface.access$200().removeMessages(1001);
    long l;
    Object localObject2;
    boolean bool1;
    boolean bool2;
    Object localObject3;
    label154:
    Object localObject1;
    if (paramInt == 0)
    {
      i = 1;
      SosoInterface.access$702(paramInt);
      l = SystemClock.elapsedRealtime() - SosoInterface.access$800() - SosoInterface.access$900();
      SosoInterface.access$802(SystemClock.elapsedRealtime());
      SosoInterface.access$902(SosoInterface.sContinuousLocationInterval);
      localObject2 = paramTencentLocation.getExtra().getString("qq_caller");
      String str = paramTencentLocation.getExtra().getString("qq_caller_route");
      bool1 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
      bool2 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      localObject3 = TencentExtraKeys.getRawData(paramTencentLocation);
      SosoInterface.access$1000(paramInt);
      if (bool2)
      {
        if (i == 0) {
          break label497;
        }
        SosoInterface.access$1102(0);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("onLocationChanged() err=").append(paramInt);
        if ((paramString != null) && (paramString.length() != 0)) {
          break label504;
        }
        localObject1 = "";
        label193:
        localObject1 = localStringBuilder.append((String)localObject1).append(" caller=").append((String)localObject2).append(" level=").append(j).append(" reqLocation=").append(bool2).append(" consume=").append(l).append(" rawData=");
        if (localObject3 != null) {
          break label528;
        }
        i = 0;
        label255:
        localObject1 = ((StringBuilder)localObject1).append(i).append(" isGoonCallback=").append(bool1).append(" failInt=").append(SosoInterface.access$1100()).append(" caller rote: ").append(str).append(" verify key length:");
        if (paramTencentLocation.getVerifyKey() != null) {
          break label536;
        }
      }
    }
    label528:
    label536:
    for (int i = 0;; i = paramTencentLocation.getVerifyKey().length())
    {
      QLog.d("SOSO.LBS", 2, i + " source:" + paramTencentLocation.getSourceProvider() + " adcode :" + paramTencentLocation.getCityCode() + " lon*lat :" + (int)(paramTencentLocation.getLongitude() * paramTencentLocation.getLatitude()));
      bool1 = false;
      localObject1 = SosoInterface.access$400();
      if ((paramInt != 0) || (bool2)) {}
      try
      {
        SosoInterface.access$1200(j, paramTencentLocation, (String)localObject2);
        if ((localObject3 != null) && (localObject3.length > 0)) {
          SosoInterface.updateRawData(paramTencentLocation.getProvider(), (byte[])localObject3);
        }
        SosoInterface.access$1300(paramTencentLocation, paramInt, paramString, l);
        paramTencentLocation = SosoInterface.access$1400();
        paramString = SosoInterface.access$1500();
        localObject2 = SosoInterface.access$1600();
        localObject3 = SosoInterface.access$1700();
        if (paramTencentLocation != null) {
          bool1 = true;
        }
        if (SosoInterface.access$500().size() != 0) {
          break label556;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 4, "listener is empty.");
        }
        SosoInterface.access$100();
        return;
      }
      finally {}
      i = 0;
      break;
      label497:
      SosoInterface.access$1108();
      break label154;
      label504:
      localObject1 = " reason=" + paramString;
      break label193;
      i = localObject3.length;
      break label255;
    }
    label556:
    SosoInterface.access$1800(bool1, paramTencentLocation, paramString, (SosoInterface.OnLocationListener)localObject2, (SosoInterface.OnLocationListener)localObject3);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onStatusUpdate name: " + paramString1 + " status: " + paramInt + " desc: " + paramString2);
    }
    for (;;)
    {
      int i;
      SosoInterface.OnLocationListener localOnLocationListener;
      synchronized (SosoInterface.access$400())
      {
        if (SosoInterface.access$500().isEmpty()) {
          return;
        }
        i = SosoInterface.access$500().size() - 1;
        if (i < 0) {
          break label154;
        }
        localOnLocationListener = (SosoInterface.OnLocationListener)SosoInterface.access$500().get(i);
        if (localOnLocationListener == null) {
          break label158;
        }
        if (localOnLocationListener.uiThread) {
          ThreadManager.getUIHandler().post(new SosoInterface.3.1(this, localOnLocationListener, paramString1, paramInt, paramString2));
        }
      }
      localOnLocationListener.onStatusUpdate(paramString1, paramInt, paramString2);
      break label158;
      label154:
      return;
      label158:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.3
 * JD-Core Version:    0.7.0.1
 */