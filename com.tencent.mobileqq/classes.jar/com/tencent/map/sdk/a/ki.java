package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class ki
{
  public kw a = null;
  public TencentMap.SnapshotReadyCallback b = null;
  public Handler c = new ki.1(this, Looper.getMainLooper());
  
  public ki(kw paramkw)
  {
    this.a = paramkw;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public final int a(CameraUpdate paramCameraUpdate)
  {
    kw localkw = this.a;
    if (localkw == null) {
      return -2147483648;
    }
    return localkw.a(paramCameraUpdate);
  }
  
  public final int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    kw localkw = this.a;
    if (localkw == null) {
      return -2147483648;
    }
    return localkw.a(paramCameraUpdate, paramLong, paramCancelableCallback);
  }
  
  public final CameraPosition a()
  {
    kw localkw = this.a;
    if (localkw == null) {
      return null;
    }
    return localkw.a();
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    kw localkw = this.a;
    if (localkw == null) {
      return;
    }
    localkw.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public final boolean b()
  {
    kw localkw = this.a;
    if (localkw != null) {
      return localkw.s();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ki
 * JD-Core Version:    0.7.0.1
 */