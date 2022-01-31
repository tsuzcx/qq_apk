package com.tencent.map.sdk.a;

import android.graphics.Rect;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnPolylineClickListener;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.util.List;

public abstract interface lb
{
  public abstract Polyline a(PolylineOptions paramPolylineOptions, kq paramkq);
  
  public abstract void a();
  
  public abstract void a(TencentMap.OnPolylineClickListener paramOnPolylineClickListener);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, float paramFloat);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, int paramInt, LatLng paramLatLng);
  
  public abstract void a(String paramString, GlAnimation paramGlAnimation);
  
  public abstract void a(String paramString, BitmapDescriptor paramBitmapDescriptor);
  
  public abstract void a(String paramString, PolylineOptions.Text paramText);
  
  public abstract void a(String paramString, PolylineOptions paramPolylineOptions);
  
  public abstract void a(String paramString, List<LatLng> paramList);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  public abstract void b(String paramString, float paramFloat);
  
  public abstract void b(String paramString, int paramInt);
  
  public abstract void b(String paramString, boolean paramBoolean);
  
  public abstract int[][] b(String paramString);
  
  public abstract void c(String paramString);
  
  public abstract void c(String paramString, boolean paramBoolean);
  
  public abstract Rect d(String paramString);
  
  public abstract void d(String paramString, boolean paramBoolean);
  
  public abstract List<gg> e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.lb
 * JD-Core Version:    0.7.0.1
 */