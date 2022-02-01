import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.3.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public final class apco
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
    } while (SosoInterface.a(paramTencentLocation, paramInt, j));
    SosoInterface.a().removeMessages(1001);
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
      SosoInterface.a(paramInt);
      l = SystemClock.elapsedRealtime() - SosoInterface.a() - SosoInterface.a();
      SosoInterface.a(SystemClock.elapsedRealtime());
      SosoInterface.b(SosoInterface.a);
      localObject2 = paramTencentLocation.getExtra().getString("qq_caller");
      String str = paramTencentLocation.getExtra().getString("qq_caller_route");
      bool1 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
      bool2 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
      localObject3 = TencentExtraKeys.getRawData(paramTencentLocation);
      SosoInterface.a(paramInt);
      if (bool2)
      {
        if (i == 0) {
          break label497;
        }
        SosoInterface.c(0);
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
        localObject1 = ((StringBuilder)localObject1).append(i).append(" isGoonCallback=").append(bool1).append(" failInt=").append(SosoInterface.c()).append(" caller rote: ").append(str).append(" verify key length:");
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
      localObject1 = SosoInterface.a();
      if ((paramInt != 0) || (bool2)) {}
      try
      {
        SosoInterface.a(j, paramTencentLocation, (String)localObject2);
        if ((localObject3 != null) && (localObject3.length > 0)) {
          SosoInterface.a(paramTencentLocation.getProvider(), (byte[])localObject3);
        }
        SosoInterface.a(paramTencentLocation, paramInt, paramString, l);
        paramTencentLocation = SosoInterface.a();
        paramString = SosoInterface.b();
        localObject2 = SosoInterface.c();
        localObject3 = SosoInterface.d();
        if (paramTencentLocation != null) {
          bool1 = true;
        }
        if (SosoInterface.a().size() != 0) {
          break label556;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 4, "listener is empty.");
        }
        SosoInterface.d();
        return;
      }
      finally {}
      i = 0;
      break;
      label497:
      SosoInterface.b();
      break label154;
      label504:
      localObject1 = " reason=" + paramString;
      break label193;
      i = localObject3.length;
      break label255;
    }
    label556:
    SosoInterface.a(bool1, paramTencentLocation, paramString, (apcq)localObject2, (apcq)localObject3);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onStatusUpdate name: " + paramString1 + " status: " + paramInt + " desc: " + paramString2);
    }
    for (;;)
    {
      int i;
      apcq localapcq;
      synchronized (SosoInterface.a())
      {
        if (SosoInterface.a().isEmpty()) {
          return;
        }
        i = SosoInterface.a().size() - 1;
        if (i < 0) {
          break label154;
        }
        localapcq = (apcq)SosoInterface.a().get(i);
        if (localapcq == null) {
          break label158;
        }
        if (localapcq.uiThread) {
          ThreadManager.getUIHandler().post(new SosoInterface.3.1(this, localapcq, paramString1, paramInt, paramString2));
        }
      }
      localapcq.onStatusUpdate(paramString1, paramInt, paramString2);
      break label158;
      label154:
      return;
      label158:
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apco
 * JD-Core Version:    0.7.0.1
 */