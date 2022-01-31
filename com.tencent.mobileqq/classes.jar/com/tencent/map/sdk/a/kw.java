package com.tencent.map.sdk.a;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import com.tencent.map.lib.MapLanguage;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

public abstract interface kw
{
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt, boolean paramBoolean);
  
  public abstract float a(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean);
  
  public abstract int a(CameraUpdate paramCameraUpdate);
  
  public abstract int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback);
  
  public abstract CameraPosition a();
  
  public abstract CameraPosition a(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract CameraPosition a(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback);
  
  public abstract TileOverlay a(TileOverlayOptions paramTileOverlayOptions);
  
  public abstract String a(LatLng paramLatLng);
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void a(int paramInt);
  
  public abstract void a(Handler paramHandler, Bitmap.Config paramConfig);
  
  public abstract void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void a(TencentMap.OnCompassClickedListener paramOnCompassClickedListener);
  
  public abstract void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener);
  
  public abstract void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener);
  
  public abstract void a(TencentMap.OnMapClickListener paramOnMapClickListener);
  
  public abstract void a(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback);
  
  public abstract void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener);
  
  public abstract void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener);
  
  public abstract void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener);
  
  public abstract void a(Language paramLanguage);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt);
  
  public abstract void a(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(List<hk> paramList, List<LatLng> paramList1);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract float b();
  
  public abstract void b(float paramFloat1, float paramFloat2);
  
  public abstract void b(int paramInt);
  
  public abstract void b(TencentMap.OnCameraChangeListener paramOnCameraChangeListener);
  
  public abstract void b(TencentMapGestureListener paramTencentMapGestureListener);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract float c();
  
  public abstract void c(int paramInt);
  
  public abstract void c(boolean paramBoolean);
  
  public abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract void d(boolean paramBoolean);
  
  public abstract int e();
  
  public abstract void e(boolean paramBoolean);
  
  public abstract void f(boolean paramBoolean);
  
  public abstract boolean f();
  
  public abstract void g(boolean paramBoolean);
  
  public abstract boolean g();
  
  public abstract void h();
  
  public abstract void h(boolean paramBoolean);
  
  public abstract void i();
  
  public abstract void i(boolean paramBoolean);
  
  public abstract void j();
  
  public abstract String k();
  
  public abstract MapLanguage l();
  
  public abstract void m();
  
  public abstract int n();
  
  public abstract String[] o();
  
  public abstract IndoorBuilding p();
  
  public abstract boolean q();
  
  public abstract boolean r();
  
  public abstract boolean s();
  
  public abstract String t();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.kw
 * JD-Core Version:    0.7.0.1
 */