package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View.MeasureSpec;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.BlockRouteRequest;
import com.tencent.map.tools.net.AdapterType;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetManager;
import com.tencent.tencentmap.io.QStorageManager;
import com.tencent.tencentmap.mapsdk.maps.BaseMapView;
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
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ln
  implements hc, kw, lc, le
{
  public IMapRenderView a = null;
  public volatile pn b = null;
  public Context c = null;
  public lu d = null;
  public jj e = null;
  CameraPosition f;
  byte[] g = new byte[0];
  pd.a h = new ln.2(this);
  public he i = new ln.6(this);
  private String j = null;
  private hv k = null;
  private iy l = null;
  private final GeoPoint m = null;
  private final GeoPoint n = null;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private boolean t = false;
  private float u = 1.0F;
  private boolean v = false;
  private final ln.b w = new ln.b(this, false);
  private final ln.b x = new ln.b(this, true);
  private kl.a y = new ln.1(this);
  
  public ln(int paramInt, BaseMapView paramBaseMapView, TencentMapOptions paramTencentMapOptions)
  {
    this.c = paramBaseMapView.getContext().getApplicationContext();
    this.u = pz.a(this.c);
    pn localpn;
    Context localContext;
    Object localObject2;
    if (this.a == null)
    {
      localObject1 = this.c;
      switch (paramInt)
      {
      default: 
        localObject1 = new py((Context)localObject1, paramTencentMapOptions);
        this.a = ((IMapRenderView)localObject1);
        this.b = ((pn)this.a.getVectorMapDelegate());
        localpn = this.b;
        localContext = localpn.ay.getApplicationContext();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("halley_app_id", 3203);
        ((Bundle)localObject1).putString("halley_app_name", pz.a);
        ((Bundle)localObject1).putString("halley_app_version", "android_vector_sdk_4.2.8.1");
        localObject1 = NetManager.buildAdapter(AdapterType.Halley, (Bundle)localObject1);
        NetManager.getInstance().setAdapter(localContext, (NetAdapter)localObject1);
        localObject2 = QStorageManager.getInstance(localContext);
        on.a(((QStorageManager)localObject2).getMapPath());
        on.a(((QStorageManager)localObject2).getSatPath());
        if ((paramTencentMapOptions == null) || (nl.a(paramTencentMapOptions.getSubKey()))) {
          break;
        }
      }
    }
    for (Object localObject1 = paramTencentMapOptions.getSubKey();; localObject1 = null)
    {
      on.a(((QStorageManager)localObject2).getConfigPath((String)localObject1));
      on.a(((QStorageManager)localObject2).getAssetsLoadPath((String)localObject1));
      on.a(((QStorageManager)localObject2).getRouteBlockPath());
      String str;
      if (paramTencentMapOptions != null)
      {
        if (paramTencentMapOptions.getCustomAssetsPath() == null) {
          break label893;
        }
        str = paramTencentMapOptions.getCustomAssetsPath();
        if ((str != null) && (str.trim().length() != 0))
        {
          localObject2 = str;
          if (!str.endsWith(File.separator)) {
            localObject2 = str + File.separator;
          }
          gd.a = (String)localObject2;
        }
      }
      label484:
      hy.a(localContext, (String)localObject1);
      localpn.H = new pp(localpn, (String)localObject1);
      localObject1 = localpn.H;
      localObject2 = jn.a();
      if (localpn.aA.a(localpn.ay.getApplicationContext(), (ly)localObject1, (qe)localObject2)) {
        localpn.aA.c.g();
      }
      localObject1 = (ng)MapServiceManager.getService(ng.class);
      localObject2 = localpn.az;
      localObject1 = ((ng)localObject1).e();
      localObject2 = ((pm)localObject2).b;
      if (((lw)localObject2).a != null)
      {
        localObject2 = ((lw)localObject2).a;
        if (((pf)localObject2).b != 0L) {
          ((pf)localObject2).f.a(new pf.28((pf)localObject2, (String)localObject1));
        }
      }
      localObject2 = (na)MapServiceManager.getService(na.class);
      localObject1 = localpn.az;
      localObject2 = ((BlockRouteRequest)((na)localObject2).c()).getBlockRouteUrl(fz.a(), "4.2.8", fz.b());
      ((pm)localObject1).b.w = ((String)localObject2);
      if (!localpn.az.b.k) {
        localpn.az.a(0);
      }
      for (;;)
      {
        if (localpn.R) {
          localpn.o();
        }
        if (fy.b == null) {
          fy.b = new fy.a();
        }
        this.b.a(this);
        localObject1 = this.b.az;
        localObject2 = this.y;
        ((pm)localObject1).b.c.l = ((kl.a)localObject2);
        this.b.az.a(this.i);
        if ((paramTencentMapOptions != null) && (!nl.a(paramTencentMapOptions.getSubKey()))) {
          this.j = paramTencentMapOptions.getSubKey();
        }
        this.e = new jj(this.c, this.j);
        if (this.d == null) {
          this.d = new lu(paramBaseMapView, this.a);
        }
        return;
        localObject1 = new py((Context)localObject1, paramTencentMapOptions);
        break;
        localObject1 = new px((Context)localObject1, paramTencentMapOptions);
        break;
        localObject1 = new pw((Context)localObject1, paramTencentMapOptions);
        break;
        label893:
        if (paramTencentMapOptions.getCustomLocalPath() == null) {
          break label484;
        }
        str = paramTencentMapOptions.getCustomLocalPath();
        if ((str == null) || (str.trim().length() == 0)) {
          break label484;
        }
        localObject2 = str;
        if (!str.endsWith(File.separator)) {
          localObject2 = str + File.separator;
        }
        gd.b = (String)localObject2;
        break label484;
        localpn.az.a(5);
      }
    }
  }
  
  private float a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    int i2 = this.b.aq;
    int i1 = this.b.ar;
    if ((i2 == 0) || (i1 == 0) || (paramLatLng1 == null) || (paramLatLng2 == null)) {
      return 0.0F;
    }
    paramLatLng1 = fz.a(paramLatLng1);
    paramLatLng2 = fz.a(paramLatLng2);
    pn localpn = this.b;
    paramLatLng1 = a(paramLatLng1);
    paramLatLng2 = a(paramLatLng2);
    double d2 = paramLatLng2.x - paramLatLng1.x;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = Math.abs(d2);
    }
    double d3 = paramLatLng2.y - paramLatLng1.y;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = Math.abs(d3);
    }
    paramInt2 = i2 - paramInt1 - paramInt2;
    float f1 = paramFloat;
    if (paramFloat == 90.0F) {
      f1 = 89.0F;
    }
    paramInt3 = (int)((i1 - paramInt3 - paramInt4) / Math.cos(f1 * 3.141592653589793D / 180.0D));
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    paramInt2 = paramInt3;
    if (paramInt3 <= 0) {
      paramInt2 = 1;
    }
    double d4 = Math.log(1.0D * d1 / paramInt1) / Math.log(2.0D);
    d3 = Math.log(d2 * 1.0D / paramInt2) / Math.log(2.0D);
    d1 = d4;
    if (d4 < 0.0D) {
      d1 = 0.0D;
    }
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = 0.0D;
    }
    return (float)(20.0D - Math.max(d1, d2));
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramLatLng1, paramLatLng2, localGeoPoint);
    if (paramLatLng3 != null)
    {
      paramLatLng3.latitude = (localGeoPoint.getLatitudeE6() / 1000000.0D);
      paramLatLng3.longitude = (localGeoPoint.getLongitudeE6() / 1000000.0D);
    }
    return f1;
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramLatLngBounds == null) {
      return -1;
    }
    if ((paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null)) {
      return -1;
    }
    if ((this.b.aq == 0) || (this.b.ar == 0))
    {
      this.b.aj = paramLatLngBounds.southwest;
      this.b.ak = paramLatLngBounds.northeast;
      this.b.am = paramInt1;
      this.b.an = paramInt2;
      this.b.ao = paramInt3;
      this.b.ap = paramInt4;
      this.b.D = paramCancelableCallback;
      if (paramBoolean) {}
      for (this.b.F = this.x;; this.b.F = this.w)
      {
        int i1 = pz.b(this.c);
        int i2 = pz.c(this.c);
        if ((paramInt1 + paramInt2 + this.o + this.q <= i1) && (paramInt3 + paramInt4 + this.p + this.r <= i2)) {
          break;
        }
        return -1;
      }
      return 0;
    }
    this.b.F = null;
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramLatLngBounds.southwest, paramLatLngBounds.northeast, localGeoPoint);
    if (f1 < 0.0F) {
      return (int)f1;
    }
    paramInt1 = localGeoPoint.getLatitudeE6();
    paramInt2 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.b.az.a(paramInt1, paramInt2);
      a(f1, false, paramLong, null);
      this.b.az.b(0.0F);
      this.b.az.a(0.0F);
    }
    for (;;)
    {
      return 0;
      paramLatLngBounds = new pd();
      paramLatLngBounds.c(0.0F);
      paramLatLngBounds.d(0.0F);
      paramLatLngBounds.b(paramInt1, paramInt2);
      paramLatLngBounds.a(f1);
      paramLatLngBounds.a = this.h;
      paramLatLngBounds.d = paramCancelableCallback;
      paramLatLngBounds.a(paramLong);
      this.b.az.a(paramLatLngBounds);
    }
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramLatLngBounds == null) {
      return -1;
    }
    if ((paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null)) {
      return -1;
    }
    if ((this.b.aq == 0) || (this.b.ar == 0))
    {
      this.b.aj = paramLatLngBounds.southwest;
      this.b.ak = paramLatLngBounds.northeast;
      this.b.al = paramInt;
      this.b.D = paramCancelableCallback;
      if (paramBoolean) {}
      for (this.b.F = this.x;; this.b.F = this.w)
      {
        i1 = pz.b(this.c);
        int i2 = pz.c(this.c);
        if ((paramInt * 2 + this.o + this.q <= i1) && (paramInt * 2 + this.p + this.r <= i2)) {
          break;
        }
        return -1;
      }
      return 0;
    }
    this.b.F = null;
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt, paramInt, paramInt, paramInt, paramLatLngBounds.southwest, paramLatLngBounds.northeast, localGeoPoint);
    if (f1 < 0.0F) {
      return (int)f1;
    }
    paramInt = localGeoPoint.getLatitudeE6();
    int i1 = localGeoPoint.getLongitudeE6();
    if (!paramBoolean)
    {
      this.b.az.a(paramInt, i1);
      a(f1, false, paramLong, null);
    }
    for (;;)
    {
      return 0;
      paramLatLngBounds = new pd();
      paramLatLngBounds.b(paramInt, i1);
      paramLatLngBounds.a(f1);
      paramLatLngBounds.a = this.h;
      paramLatLngBounds.d = paramCancelableCallback;
      paramLatLngBounds.a(paramLong);
      this.b.az.a(paramLatLngBounds);
    }
  }
  
  private int a(List<gl> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    kb localkb = (kb)this.b.az.i();
    if ((paramList == null) || (paramList.isEmpty())) {
      return -1;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      gl localgl = (gl)paramList.next();
      if ((localgl != null) && (localgl.getMapElements() != null)) {
        localArrayList.addAll(localgl.getMapElements());
      }
    }
    if ((this.b.aq == 0) || (this.b.ar == 0))
    {
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2)) {
        return -1;
      }
      return 0;
    }
    if ((paramInt1 + paramInt2 > this.b.aq) || (paramInt3 + paramInt4 > this.b.ar)) {
      return -1;
    }
    localkb.a(localArrayList, null, new Rect(paramInt1, paramInt3, paramInt2, paramInt4), new ln.3(this, paramBoolean, paramCancelableCallback, paramLong));
    return 0;
  }
  
  private DoublePoint a(GeoPoint paramGeoPoint)
  {
    double d3 = 2.684355E+008F * this.u;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    double d5 = Math.min(Math.max(Math.sin(paramGeoPoint.getLatitudeE6() / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d4 = paramGeoPoint.getLongitudeE6() / 1000000.0D;
    d5 = Math.log((1.0D + d5) / (1.0D - d5));
    paramGeoPoint = new DoublePoint();
    paramGeoPoint.set(d2 * d4 + d1, d3 * d5 * 0.5D + d1);
    return paramGeoPoint;
  }
  
  private GeoPoint a(DoublePoint paramDoublePoint)
  {
    double d3 = 2.684355E+008F * this.u;
    double d1 = d3 / 2.0D;
    double d2 = d3 / 360.0D;
    d3 /= 6.283185307179586D;
    d2 = (paramDoublePoint.x - d1) / d2;
    d1 = Math.asin(1.0D - 2.0D / (Math.pow(2.718281828459045D, (paramDoublePoint.y - d1) / 0.5D / d3) + 1.0D)) * 180.0D / 3.141592653589793D;
    paramDoublePoint = new GeoPoint(0, 0);
    paramDoublePoint.setLatitudeE6((int)(d1 * 1000000.0D));
    paramDoublePoint.setLongitudeE6((int)(1000000.0D * d2));
    return paramDoublePoint;
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    int i1 = (int)(1000000.0D * paramDouble1);
    int i2 = (int)(1000000.0D * paramDouble2);
    Object localObject = this.b;
    int i3 = this.b.az.d;
    if (paramFloat < i3) {
      paramFloat = i3;
    }
    for (;;)
    {
      float f1 = paramFloat;
      if (paramFloat > 20.0F) {
        f1 = 20.0F;
      }
      paramDouble1 = 1.0D / Math.pow(2.0D, 20.0F - f1);
      if (!paramBoolean)
      {
        this.b.az.a(i1, i2);
        this.b.az.c((float)paramDouble1);
        return;
      }
      localObject = new pd();
      ((pd)localObject).b(i1, i2);
      ((pd)localObject).a(f1);
      ((pd)localObject).a = this.h;
      ((pd)localObject).d = paramCancelableCallback;
      ((pd)localObject).a(paramLong);
      this.b.az.a((nv)localObject);
      return;
    }
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(1000000.0D * paramDouble2);
    if (!paramBoolean)
    {
      this.b.az.a(i1, i2);
      return;
    }
    pd localpd = new pd();
    localpd.b(i1, i2);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {}
    while (paramFloat1 == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat1 < 0.0F) {}
      for (paramFloat1 = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat1)));; paramFloat1 = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat1))))
      {
        paramCancelableCallback = this.b.az;
        double d1 = paramFloat1;
        double d2 = paramFloat2;
        double d3 = paramFloat3;
        double d4 = paramFloat2;
        double d5 = paramFloat3;
        paramCancelableCallback.b.c.a(d1, d2, d3, d4, d5, null);
        return;
      }
    }
    pd localpd = new pd();
    localpd.a((int)paramFloat2, (int)paramFloat3);
    localpd.b(paramFloat1);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  private void a(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {}
    while ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {
      return;
    }
    if (!paramBoolean)
    {
      this.b.az.b((int)paramFloat1, (int)paramFloat2);
      return;
    }
    pd localpd = new pd();
    int i1 = (int)paramFloat1;
    int i2 = (int)paramFloat2;
    if ((i1 == 0) && (i2 == 0)) {
      localpd.f = false;
    }
    localpd.g = i1;
    localpd.h = i2;
    localpd.f = true;
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  private void a(CameraPosition paramCameraPosition, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {}
    GeoPoint localGeoPoint;
    float f2;
    do
    {
      do
      {
        return;
      } while (paramCameraPosition == null);
      localGeoPoint = fz.a(paramCameraPosition.target);
      f2 = paramCameraPosition.zoom;
      localObject = this.b;
      int i1 = this.b.az.d;
      float f1 = f2;
      if (f2 < i1) {
        f1 = i1;
      }
      f2 = f1;
      if (f1 > 20.0F) {
        f2 = 20.0F;
      }
      if (paramBoolean) {
        break;
      }
      double d1 = 1.0D / Math.pow(2.0D, 20.0F - f2);
      if (localGeoPoint != null) {
        this.b.az.a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      this.b.az.c((float)d1);
      this.b.az.b(paramCameraPosition.bearing);
    } while (paramCameraPosition.tilt < 0.0F);
    this.b.az.a(paramCameraPosition.tilt);
    return;
    Object localObject = new pd();
    if (localGeoPoint != null) {
      ((pd)localObject).b(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    ((pd)localObject).a(f2);
    ((pd)localObject).c(paramCameraPosition.bearing);
    if (paramCameraPosition.tilt >= 0.0F) {
      ((pd)localObject).d(paramCameraPosition.tilt);
    }
    ((pd)localObject).a = this.h;
    ((pd)localObject).a(paramLong);
    ((pd)localObject).d = paramCancelableCallback;
    this.b.az.a((nv)localObject);
  }
  
  private void a(boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (!paramBoolean)
    {
      int i1 = this.b.az.c();
      this.b.az.b(i1 + 1);
      return;
    }
    pd localpd = new pd();
    localpd.b(1.0F);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  private void b(float paramFloat1, float paramFloat2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramBoolean == true)
    {
      pd localpd = new pd();
      localpd.c(paramFloat1);
      if (paramFloat2 >= 0.0F) {
        localpd.d(paramFloat2);
      }
      localpd.a = this.h;
      localpd.d = paramCancelableCallback;
      localpd.a(paramLong);
      this.b.az.a(localpd);
    }
    do
    {
      return;
      this.b.az.b(paramFloat1);
    } while (paramFloat2 < 0.0F);
    this.b.az.a(paramFloat2);
  }
  
  private void b(float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {}
    while (paramFloat == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat < 0.0F) {}
      for (paramFloat = (float)(1.0D / Math.pow(2.0D, Math.abs(paramFloat)));; paramFloat = (float)(1.0D / Math.pow(0.5D, Math.abs(paramFloat))))
      {
        float f1 = this.b.az.d();
        this.b.az.a(paramFloat * f1);
        return;
      }
    }
    pd localpd = new pd();
    localpd.b(paramFloat);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  private void b(boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (!paramBoolean)
    {
      int i1 = this.b.az.c();
      this.b.az.b(i1 - 1);
      return;
    }
    pd localpd = new pd();
    localpd.b(-1.0F);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  public final double a(double paramDouble)
  {
    return this.b.az.b.h.a(paramDouble);
  }
  
  public final float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2, GeoPoint paramGeoPoint)
  {
    int i4 = this.b.aq;
    int i5 = this.b.ar;
    if ((i4 == 0) || (i5 == 0) || (paramLatLng1 == null) || (paramLatLng2 == null)) {
      return -2.0F;
    }
    if ((paramInt1 + paramInt2 + this.o + this.q > i4) || (paramInt3 + paramInt4 + this.p + this.r > i5)) {
      return -1.0F;
    }
    Object localObject2 = fz.a(paramLatLng1);
    Object localObject1 = fz.a(paramLatLng2);
    pn localpn = this.b;
    localObject2 = a((GeoPoint)localObject2);
    localObject1 = a((GeoPoint)localObject1);
    double d2 = ((DoublePoint)localObject1).x - ((DoublePoint)localObject2).x;
    double d1 = d2;
    if (d2 < 0.0D) {
      d1 = Math.abs(d2);
    }
    double d3 = ((DoublePoint)localObject1).y - ((DoublePoint)localObject2).y;
    d2 = d3;
    if (d3 < 0.0D) {
      d2 = Math.abs(d3);
    }
    int i2 = i4 - paramInt1 - paramInt2 - this.o - this.q;
    int i3 = i5 - paramInt3 - paramInt4 - this.p - this.r;
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 1;
    }
    i2 = i3;
    if (i3 <= 0) {
      i2 = 1;
    }
    d1 = Math.max(d1 / i1, d2 / i2);
    float f1 = (float)(20.0D - Math.log(d1) / Math.log(2.0D));
    float f3 = b();
    float f2 = c();
    if (f3 < f1)
    {
      d1 = Math.pow(2.0D, 20.0F - f3);
      f1 = f3;
    }
    for (;;)
    {
      if (f2 > f1)
      {
        d1 = Math.pow(2.0D, 20.0F - f2);
        f1 = f2;
      }
      for (;;)
      {
        paramLatLng1 = new LatLng((paramLatLng1.latitude + paramLatLng2.latitude) / 2.0D, (paramLatLng1.longitude + paramLatLng2.longitude) / 2.0D);
        d2 = (paramInt2 - paramInt1) * d1 / 2.0D;
        d3 = (paramInt3 - paramInt4) * d1 / 2.0D;
        paramLatLng1 = a(fz.a(paramLatLng1));
        paramLatLng1.x = (d2 + paramLatLng1.x);
        paramLatLng1.y = (d3 + paramLatLng1.y);
        double d4 = paramLatLng1.x;
        double d5 = paramLatLng1.y;
        if (this.v)
        {
          paramInt1 = this.o - this.q;
          paramInt2 = this.p - this.r;
          f2 = (this.o - this.q) / (2.0F * i4) + 0.5F;
          if (f2 < 0.25D)
          {
            paramInt1 = (int)(-0.5D * i4);
            f2 = (this.p - this.r) / (2.0F * i5) + 0.5F;
            if (f2 >= 0.25D) {
              break label725;
            }
            paramInt2 = (int)(-0.5D * i5);
            label570:
            double d6 = paramInt1 * d1 / 2.0D;
            double d7 = paramInt2 * d1 / 2.0D;
            paramLatLng1 = this.b.az.b.n.r;
            if (paramLatLng1 != null) {
              break label747;
            }
            d3 = 0.0D;
            d2 = 0.0D;
            label621:
            double d8 = i4;
            d3 = d5 - d7 - d1 * (d3 * i5);
            d2 = d2 * d8 * d1 + (d4 - d6);
            d1 = d3;
          }
        }
        for (;;)
        {
          paramLatLng1 = a(new DoublePoint(d2, d1));
          paramGeoPoint.setLatitudeE6(paramLatLng1.getLatitudeE6());
          paramGeoPoint.setLongitudeE6(paramLatLng1.getLongitudeE6());
          return f1;
          if (f2 <= 0.75D) {
            break;
          }
          paramInt1 = (int)(0.5D * i4);
          break;
          label725:
          if (f2 <= 0.75D) {
            break label570;
          }
          paramInt2 = (int)(0.5D * i5);
          break label570;
          label747:
          d2 = paramLatLng1.a;
          d3 = paramLatLng1.b;
          break label621;
          d1 = d5;
          d2 = d4;
        }
      }
    }
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(0, 0, 0, 0, paramLatLng1, paramLatLng2, null);
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null)) {
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      return a(paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, localBuilder.build().southwest, localBuilder.build().northeast);
    }
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f1 = 0.0F;
    if ((paramLatLng1 == null) || (paramLatLng2 == null)) {
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat = f1;
    }
    for (;;)
    {
      return a(paramFloat, 0, 0, paramInt, 0, localBuilder.build().southwest, localBuilder.build().northeast);
    }
  }
  
  public final float a(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f1 = 0.0F;
    if (paramLatLngBounds == null) {
      return 0.0F;
    }
    int i1;
    if (paramBoolean == true)
    {
      i1 = this.b.K;
      if (paramBoolean) {
        break label91;
      }
      paramFloat = f1;
    }
    label91:
    for (;;)
    {
      int i2 = i1;
      if (i1 < 0) {
        i2 = this.b.aq / 2;
      }
      return a(paramFloat, 0, 0, paramInt, this.b.ar - i2, paramLatLngBounds.southwest, paramLatLngBounds.northeast);
      i1 = this.b.M;
      break;
    }
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject1 = this.b.az.b.c;
    ((kl)localObject1).n = paramInt1;
    ((kl)localObject1).o = paramInt2;
    ((kl)localObject1).p = paramInt3;
    ((kl)localObject1).q = paramInt4;
    int i1;
    if ((((kl)localObject1).j != null) && (((kl)localObject1).j.width() > 0) && (((kl)localObject1).j.height() > 0)) {
      if ((paramInt1 + paramInt3 > ((kl)localObject1).j.width()) || (paramInt2 + paramInt4 > ((kl)localObject1).j.height())) {
        i1 = -1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        this.o = paramInt1;
        this.p = paramInt2;
        this.q = paramInt3;
        this.r = paramInt4;
      }
      return i1;
      Object localObject2 = ((kl)localObject1).b();
      ((kl)localObject1).a(((PointF)localObject2).x, ((PointF)localObject2).y, paramBoolean);
      i1 = 0;
      continue;
      localObject2 = new kl.1((kl)localObject1, paramBoolean);
      if (!((kl)localObject1).c.contains(localObject2)) {
        ((kl)localObject1).c.add(localObject2);
      }
      if ((((kl)localObject1).h instanceof lw))
      {
        localObject1 = ((lw)((kl)localObject1).h).l;
        if ((paramInt1 + paramInt3 > pz.b((Context)localObject1)) || (paramInt2 + paramInt4 > pz.c((Context)localObject1))) {
          i1 = -1;
        } else {
          i1 = 0;
        }
      }
      else
      {
        i1 = -2;
      }
    }
  }
  
  public final int a(CameraUpdate paramCameraUpdate)
  {
    if (paramCameraUpdate == null) {
      return -1;
    }
    paramCameraUpdate = paramCameraUpdate.getParams();
    if (paramCameraUpdate == null) {
      return -1;
    }
    switch (paramCameraUpdate.o)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        return 0;
        a(false, 0L, null);
        continue;
        b(false, 0L, null);
        continue;
        a(paramCameraUpdate.p, paramCameraUpdate.q, false, 0L, null);
        continue;
        a(paramCameraUpdate.r, false, 0L, null);
        continue;
        b(paramCameraUpdate.s, false, 0L, null);
        continue;
        a(paramCameraUpdate.t, paramCameraUpdate.u.x, paramCameraUpdate.u.y, false, 0L, null);
        continue;
        a(paramCameraUpdate.v, false, 0L, null);
        continue;
        a(paramCameraUpdate.w.latitude, paramCameraUpdate.w.longitude, false, 0L, null);
        continue;
        a(paramCameraUpdate.x.latitude, paramCameraUpdate.x.longitude, paramCameraUpdate.y, false, 0L, null);
        continue;
        return a(paramCameraUpdate.z, paramCameraUpdate.A, false, 0L, null);
        return a(paramCameraUpdate.B, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, false, 0L, null);
        return a(paramCameraUpdate.B, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, false, 0L, null);
        b(paramCameraUpdate.J, paramCameraUpdate.K, false, 0L, null);
      }
    }
    return a(paramCameraUpdate.L, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, false, 0L, null);
  }
  
  public final int a(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramCameraUpdate == null) {
      return -1;
    }
    paramCameraUpdate = paramCameraUpdate.getParams();
    if (paramCameraUpdate == null) {
      return -1;
    }
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    switch (paramCameraUpdate.o)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      for (;;)
      {
        return 0;
        break;
        a(true, paramLong, paramCancelableCallback);
        continue;
        b(true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.p, paramCameraUpdate.q, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.r, true, paramLong, paramCancelableCallback);
        continue;
        b(paramCameraUpdate.s, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.t, paramCameraUpdate.u.x, paramCameraUpdate.u.y, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.v, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.w.latitude, paramCameraUpdate.w.longitude, true, paramLong, paramCancelableCallback);
        continue;
        a(paramCameraUpdate.x.latitude, paramCameraUpdate.x.longitude, paramCameraUpdate.y, true, paramLong, paramCancelableCallback);
        continue;
        return a(paramCameraUpdate.z, paramCameraUpdate.A, true, paramLong, paramCancelableCallback);
        return a(paramCameraUpdate.B, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, true, paramLong, paramCancelableCallback);
        return a(paramCameraUpdate.B, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, true, paramLong, paramCancelableCallback);
        b(paramCameraUpdate.J, paramCameraUpdate.K, true, paramLong, paramCancelableCallback);
      }
    }
    return a(paramCameraUpdate.L, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, true, paramLong, paramCancelableCallback);
  }
  
  public final CameraPosition a()
  {
    LatLng localLatLng = fz.a(this.b.az.b());
    float f2 = this.b.az.g();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = this.b.az.h();
    float f3 = w();
    return CameraPosition.builder().zoom(f3).target(localLatLng).bearing(f1).tilt(f2).build();
  }
  
  public final CameraPosition a(List<IOverlay> arg1, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.b.aq == 0) || (this.b.ar == 0))
    {
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      if ((paramInt1 + paramInt2 > i1) || (paramInt3 + paramInt4 > i2)) {
        return null;
      }
    }
    else if ((paramInt1 + paramInt2 > this.b.aq) || (paramInt3 + paramInt4 > this.b.ar))
    {
      return null;
    }
    Object localObject = (kb)this.b.az.i();
    double d3;
    double d4;
    double d2;
    double d1;
    if ((??? == null) || (???.isEmpty()))
    {
      if ((paramList1 == null) || (paramList1.isEmpty())) {
        return null;
      }
      if (paramList1.size() == 1) {
        return new CameraPosition((LatLng)paramList1.get(0), this.b.az.e(), this.b.az.h(), this.b.az.g());
      }
      ??? = paramList1.iterator();
      d3 = 0.0D;
      d4 = 0.0D;
      d2 = 0.0D;
      d1 = 0.0D;
      while (???.hasNext())
      {
        paramList1 = (LatLng)???.next();
        if (paramList1 != null)
        {
          if (d4 != 0.0D) {
            break label653;
          }
          d4 = paramList1.latitude;
        }
      }
    }
    label653:
    for (;;)
    {
      if (d2 == 0.0D) {
        d2 = paramList1.longitude;
      }
      for (;;)
      {
        if (d3 == 0.0D) {}
        for (double d5 = paramList1.latitude;; d5 = d3)
        {
          if (d1 == 0.0D) {}
          for (d3 = paramList1.longitude;; d3 = d1)
          {
            if (paramList1.latitude < d4) {}
            for (d1 = paramList1.latitude;; d1 = d4)
            {
              if (paramList1.latitude > d5) {}
              for (d4 = paramList1.latitude;; d4 = d5)
              {
                if (paramList1.longitude < d2) {
                  d2 = paramList1.longitude;
                }
                for (;;)
                {
                  if (paramList1.longitude > d3) {
                    d3 = paramList1.longitude;
                  }
                  for (;;)
                  {
                    d5 = d1;
                    d1 = d3;
                    d3 = d4;
                    d4 = d5;
                    break;
                    ??? = new LatLng(d4, d2);
                    paramList1 = new LatLng(d3, d1);
                    localObject = new LatLng(0.0D, 0.0D);
                    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, ???, paramList1, (LatLng)localObject);
                    if (f1 < 0.0F) {
                      return null;
                    }
                    return new CameraPosition((LatLng)localObject, f1, this.b.az.h(), this.b.az.g());
                    ArrayList localArrayList = new ArrayList();
                    ??? = ???.iterator();
                    while (???.hasNext())
                    {
                      gl localgl = (gl)???.next();
                      if ((localgl != null) && (localgl.getMapElements() != null)) {
                        localArrayList.addAll(localgl.getMapElements());
                      }
                    }
                    ??? = new Rect(paramInt1, paramInt3, paramInt2, paramInt4);
                    this.f = null;
                    ((kb)localObject).a(localArrayList, fz.a(paramList1), ???, new ln.4(this));
                    synchronized (this.g)
                    {
                      try
                      {
                        this.g.wait(1000L);
                        return this.f;
                      }
                      catch (InterruptedException paramList1)
                      {
                        for (;;)
                        {
                          or.b(Log.getStackTraceString(paramList1));
                          Thread.currentThread().interrupt();
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final CameraPosition a(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    if ((this.b.aq == 0) || (this.b.ar == 0))
    {
      pz.b(this.c);
      pz.c(this.c);
    }
    Object localObject;
    while ((paramInt1 + paramInt2 <= this.b.aq) && (paramInt3 + paramInt4 <= this.b.ar))
    {
      localObject = (kb)this.b.az.i();
      if ((paramList != null) && (!paramList.isEmpty())) {
        break label511;
      }
      if ((paramList1 != null) && (!paramList1.isEmpty())) {
        break;
      }
      if (paramAsyncOperateCallback != null) {
        paramAsyncOperateCallback.onOperateFinished(null);
      }
      paramList = null;
      return paramList;
    }
    if (paramAsyncOperateCallback != null) {
      paramAsyncOperateCallback.onOperateFinished(null);
    }
    return null;
    if (paramList1.size() == 1)
    {
      paramList = new CameraPosition((LatLng)paramList1.get(0), this.b.az.d(), this.b.az.h(), this.b.az.g());
      if (paramAsyncOperateCallback != null) {
        paramAsyncOperateCallback.onOperateFinished(paramList);
      }
      return paramList;
    }
    paramList = paramList1.iterator();
    double d3 = 0.0D;
    double d4 = 0.0D;
    double d2 = 0.0D;
    double d1 = 0.0D;
    label230:
    while (paramList.hasNext())
    {
      paramList1 = (LatLng)paramList.next();
      if (paramList1 != null)
      {
        if (d4 != 0.0D) {
          break label661;
        }
        d4 = paramList1.latitude;
      }
    }
    label661:
    for (;;)
    {
      if (d2 == 0.0D) {
        d2 = paramList1.longitude;
      }
      for (;;)
      {
        if (d3 == 0.0D) {}
        for (double d5 = paramList1.latitude;; d5 = d3)
        {
          if (d1 == 0.0D) {}
          for (d3 = paramList1.longitude;; d3 = d1)
          {
            if (paramList1.latitude < d4) {}
            for (d1 = paramList1.latitude;; d1 = d4)
            {
              if (paramList1.latitude > d5) {}
              for (d4 = paramList1.latitude;; d4 = d5)
              {
                if (paramList1.longitude < d2) {
                  d2 = paramList1.longitude;
                }
                for (;;)
                {
                  if (paramList1.longitude > d3) {
                    d3 = paramList1.longitude;
                  }
                  for (;;)
                  {
                    d5 = d1;
                    d1 = d3;
                    d3 = d4;
                    d4 = d5;
                    break label230;
                    paramList = new LatLng(d4, d2);
                    paramList1 = new LatLng(d3, d1);
                    localObject = new LatLng(0.0D, 0.0D);
                    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramList, paramList1, (LatLng)localObject);
                    if (f1 < 0.0F)
                    {
                      if (paramAsyncOperateCallback != null) {
                        paramAsyncOperateCallback.onOperateFinished(null);
                      }
                      return null;
                    }
                    paramList1 = new CameraPosition((LatLng)localObject, f1, this.b.az.h(), this.b.az.g());
                    paramList = paramList1;
                    if (paramAsyncOperateCallback == null) {
                      break;
                    }
                    paramAsyncOperateCallback.onOperateFinished(paramList1);
                    return paramList1;
                    label511:
                    ArrayList localArrayList = new ArrayList();
                    paramList = paramList.iterator();
                    while (paramList.hasNext())
                    {
                      gl localgl = (gl)paramList.next();
                      if ((localgl != null) && (localgl.getMapElements() != null)) {
                        localArrayList.addAll(localgl.getMapElements());
                      }
                    }
                    paramList = new Rect(paramInt1, paramInt3, paramInt2, paramInt4);
                    this.f = null;
                    ((kb)localObject).a(localArrayList, fz.a(paramList1), paramList, new ln.5(this, paramAsyncOperateCallback));
                    return null;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final LatLng a(Point paramPoint)
  {
    if (paramPoint == null) {
      return null;
    }
    paramPoint = new DoublePoint(paramPoint.x, paramPoint.y);
    return fz.a(this.b.az.b.h.a(paramPoint));
  }
  
  public final TileOverlay a(TileOverlayOptions paramTileOverlayOptions)
  {
    if ((this.b == null) || (this.b.az == null)) {
      return null;
    }
    return this.b.az.a(paramTileOverlayOptions);
  }
  
  public final String a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    paramLatLng = fz.a(paramLatLng);
    lw locallw = this.b.az.b;
    if (locallw.a == null) {
      return "";
    }
    return locallw.a.a(paramLatLng);
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      return;
    }
    float f1;
    if (paramFloat1 < 0.0F)
    {
      f1 = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label91;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i1 = (int)(this.b.aq * f1);
      int i2 = (int)(this.b.ar * paramFloat1);
      this.b.d(i1, i2);
      this.b.N = f1;
      this.b.O = paramFloat1;
      return;
      f1 = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f1 = 1.0F;
      break;
      label91:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.v = true;
    this.b.az.b.c.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  final void a(float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    if (!paramBoolean)
    {
      paramCancelableCallback = this.b;
      paramBoolean = this.b.o.h;
      int i2 = this.b.az.c;
      if (paramBoolean) {}
      for (int i1 = 22;; i1 = 20)
      {
        double d1 = 1.0D / Math.pow(2.0D, 20.0F - Math.min(paramFloat, Math.min(i2, i1)));
        this.b.az.a((float)d1);
        return;
      }
    }
    pd localpd = new pd();
    localpd.a(paramFloat);
    localpd.a = this.h;
    localpd.d = paramCancelableCallback;
    localpd.a(paramLong);
    this.b.az.a(localpd);
  }
  
  public final void a(int paramInt)
  {
    if (this.t) {
      return;
    }
    int i1 = paramInt;
    if (this.e != null) {
      i1 = this.e.a(paramInt);
    }
    this.s = i1;
    this.b.az.a(i1);
    fz.h();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 == 0)) {}
  }
  
  public final void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    pn localpn = this.b;
    localpn.G = paramHandler;
    localpn.I = paramConfig;
    localpn.az.b.k();
  }
  
  public final void a(gs paramgs, TencentMapOptions paramTencentMapOptions)
  {
    lu locallu = this.d;
    if ((paramTencentMapOptions != null) && (paramTencentMapOptions.getExtSurface() != null) && (locallu.d != null) && (paramTencentMapOptions != null))
    {
      jr localjr = locallu.d;
      if ((localjr.r != null) && (paramgs != null)) {
        localjr.r.add(paramgs);
      }
      int i1 = paramTencentMapOptions.getExtSurfaceWidth();
      int i2 = paramTencentMapOptions.getExtSurfaceHeight();
      locallu.a.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
      locallu.a(i1, i2);
    }
  }
  
  public final void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.b.a(paramOnCameraChangeListener);
  }
  
  public final void a(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    if (this.b != null) {
      this.b.E = paramOnCompassClickedListener;
    }
  }
  
  public final void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    this.b.a(paramOnIndoorStateChangeListener);
  }
  
  public final void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    this.b.A = paramOnInfoWindowClickListener;
  }
  
  public final void a(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    this.b.s = paramOnMapClickListener;
  }
  
  public final void a(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    this.b.x = paramOnMapLoadedCallback;
  }
  
  public final void a(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.b.v = paramOnMapLongClickListener;
  }
  
  public final void a(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    this.b.B = paramOnMapPoiClickListener;
  }
  
  public final void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.b.z = paramOnMarkerClickListener;
  }
  
  public final void a(Language paramLanguage)
  {
    if ((this.b == null) || (this.b.k == null)) {}
    jz localjz;
    do
    {
      return;
      localjz = this.b.k;
    } while (paramLanguage == null);
    localjz.d = paramLanguage;
    localjz.a();
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    a(paramLatLng, paramFloat1, paramFloat2, 0.0F, true);
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    pd localpd = new pd();
    localpd.b((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    localpd.a(paramFloat3);
    localpd.c(paramFloat1);
    localpd.d(paramFloat2);
    localpd.a = this.h;
    localpd.e = true;
    localpd.a(1000L);
    this.b.az.j();
    this.b.az.a(localpd);
  }
  
  public final void a(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    pd localpd = new pd();
    localpd.b((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    localpd.a(paramFloat3);
    localpd.c(paramFloat1);
    localpd.d(paramFloat2);
    localpd.a = this.h;
    localpd.e = true;
    localpd.a(1000L);
    if (paramBoolean == true) {
      localpd.a(this.b.J, this.b.K);
    }
    for (;;)
    {
      this.b.az.j();
      this.b.az.a(localpd);
      return;
      localpd.a(this.b.L, this.b.M);
    }
  }
  
  public final void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    if ((this.b == null) || (this.b.az == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.b.az;
      } while (((pm)localObject).b == null);
      localObject = ((pm)localObject).b;
    } while (((lw)localObject).a == null);
    if (paramLatLngBounds == null)
    {
      ((lw)localObject).a.a(null, null, 0);
      return;
    }
    pf localpf = ((lw)localObject).a;
    double d1 = paramLatLngBounds.getLonWest();
    double d2 = paramLatLngBounds.getLatSouth();
    double d3 = paramLatLngBounds.getLonEast();
    double d4 = paramLatLngBounds.getLatNorth();
    double d5 = ((lw)localObject).y;
    double d6 = ((lw)localObject).z;
    localpf.a(new double[] { d1, d2, d3, d4 }, new double[] { 0.0D, 0.0D, d5, d6 }, paramInt);
  }
  
  public final void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (this.b == null) {
      return;
    }
    this.b.a(paramTencentMapGestureListener);
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 64	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   12: getfield 314	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   15: astore 5
    //   17: aload 5
    //   19: ifnull -12 -> 7
    //   22: aload 5
    //   24: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   27: astore 4
    //   29: aload 4
    //   31: getfield 323	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   34: ifnull +32 -> 66
    //   37: aload 4
    //   39: getfield 323	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   42: astore 4
    //   44: aload 4
    //   46: invokevirtual 1148	com/tencent/map/sdk/a/pf:y	()V
    //   49: aload 4
    //   51: getfield 328	com/tencent/map/sdk/a/pf:b	J
    //   54: lstore_2
    //   55: lload_2
    //   56: lconst_0
    //   57: lcmp
    //   58: ifne +17 -> 75
    //   61: aload 4
    //   63: invokevirtual 1150	com/tencent/map/sdk/a/pf:z	()V
    //   66: aload 5
    //   68: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   71: invokevirtual 1036	com/tencent/map/sdk/a/lw:k	()V
    //   74: return
    //   75: aload 4
    //   77: monitorenter
    //   78: aload 4
    //   80: getfield 1153	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   83: aload 4
    //   85: getfield 328	com/tencent/map/sdk/a/pf:b	J
    //   88: aload_1
    //   89: invokevirtual 1159	com/tencent/map/sdk/engine/jni/JNI:nativeMapLoadKMLFile	(JLjava/lang/String;)V
    //   92: aload 4
    //   94: monitorexit
    //   95: aload 4
    //   97: invokevirtual 1150	com/tencent/map/sdk/a/pf:z	()V
    //   100: goto -34 -> 66
    //   103: astore_1
    //   104: aload 4
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload 4
    //   112: invokevirtual 1150	com/tencent/map/sdk/a/pf:z	()V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ln
    //   0	117	1	paramString	String
    //   54	2	2	l1	long
    //   27	84	4	localObject	Object
    //   15	52	5	localpm	pm
    // Exception table:
    //   from	to	target	type
    //   78	95	103	finally
    //   104	107	103	finally
    //   44	55	109	finally
    //   75	78	109	finally
    //   107	109	109	finally
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((this.b == null) || (this.b.az == null)) {}
    pm localpm;
    do
    {
      return;
      localpm = this.b.az;
    } while (localpm == null);
    localpm.a(paramString1, paramString2);
  }
  
  public final void a(List<hk> paramList, List<LatLng> paramList1)
  {
    if (this.b == null) {}
    do
    {
      return;
      localObject = this.b.az;
    } while (localObject == null);
    paramList1 = fz.a(paramList1);
    Object localObject = ((pm)localObject).b;
    if (((lw)localObject).u == null) {
      ((lw)localObject).u = new lw.c((lw)localObject);
    }
    localObject = ((lw)localObject).u;
    ((lw.c)localObject).a = paramList;
    ((lw.c)localObject).b = paramList1;
    ((lw.c)localObject).c.a.a(paramList, paramList1);
  }
  
  public final void a(boolean paramBoolean)
  {
    pm localpm = this.b.az;
    if (paramBoolean)
    {
      localpm.a(true);
      return;
    }
    localpm.a(false);
  }
  
  /* Error */
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   4: getfield 314	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   7: astore_3
    //   8: aload_3
    //   9: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   12: ifnull +11 -> 23
    //   15: aload_3
    //   16: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   19: iload_2
    //   20: putfield 1185	com/tencent/map/sdk/a/lw:B	Z
    //   23: aload_0
    //   24: getfield 64	com/tencent/map/sdk/a/ln:b	Lcom/tencent/map/sdk/a/pn;
    //   27: getfield 314	com/tencent/map/sdk/a/pt:az	Lcom/tencent/map/sdk/a/pm;
    //   30: astore_3
    //   31: aload_3
    //   32: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   35: ifnull +58 -> 93
    //   38: aload_3
    //   39: getfield 320	com/tencent/map/sdk/a/pm:b	Lcom/tencent/map/sdk/a/lw;
    //   42: astore_3
    //   43: aload_3
    //   44: iload_1
    //   45: putfield 1187	com/tencent/map/sdk/a/lw:s	Z
    //   48: aload_3
    //   49: getfield 323	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   52: ifnull +41 -> 93
    //   55: aload_3
    //   56: getfield 323	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   59: astore_3
    //   60: aload_3
    //   61: invokevirtual 1148	com/tencent/map/sdk/a/pf:y	()V
    //   64: lconst_0
    //   65: aload_3
    //   66: getfield 328	com/tencent/map/sdk/a/pf:b	J
    //   69: lcmp
    //   70: ifeq +19 -> 89
    //   73: aload_3
    //   74: monitorenter
    //   75: aload_3
    //   76: getfield 1153	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   79: aload_3
    //   80: getfield 328	com/tencent/map/sdk/a/pf:b	J
    //   83: iload_1
    //   84: invokevirtual 1191	com/tencent/map/sdk/engine/jni/JNI:nativeSetBuilding3DEffect	(JZ)V
    //   87: aload_3
    //   88: monitorexit
    //   89: aload_3
    //   90: invokevirtual 1150	com/tencent/map/sdk/a/pf:z	()V
    //   93: return
    //   94: astore 4
    //   96: aload_3
    //   97: monitorexit
    //   98: aload 4
    //   100: athrow
    //   101: astore 4
    //   103: aload_3
    //   104: invokevirtual 1150	com/tencent/map/sdk/a/pf:z	()V
    //   107: aload 4
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ln
    //   0	110	1	paramBoolean1	boolean
    //   0	110	2	paramBoolean2	boolean
    //   7	97	3	localObject1	Object
    //   94	5	4	localObject2	Object
    //   101	7	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   75	89	94	finally
    //   96	98	94	finally
    //   60	75	101	finally
    //   98	101	101	finally
  }
  
  public final float b()
  {
    return this.b.az.c;
  }
  
  public final Point b(LatLng paramLatLng)
  {
    if (this.b == null) {}
    do
    {
      return null;
      paramLatLng = fz.a(paramLatLng);
      paramLatLng = this.b.az.b.h.a(paramLatLng);
    } while (paramLatLng == null);
    Point localPoint = new Point();
    localPoint.x = ((int)Math.round(paramLatLng.x));
    localPoint.y = ((int)Math.round(paramLatLng.y));
    return localPoint;
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      return;
    }
    float f1;
    if (paramFloat1 < 0.0F)
    {
      f1 = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label91;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i1 = (int)(this.b.aq * f1);
      int i2 = (int)(this.b.ar * paramFloat1);
      this.b.e(i1, i2);
      this.b.P = f1;
      this.b.Q = paramFloat1;
      return;
      f1 = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f1 = 1.0F;
      break;
      label91:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void b(int paramInt)
  {
    if ((this.b == null) || (this.b.o == null)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = this.b.o;
        } while (((kj)localObject).g == null);
        localObject = ((kj)localObject).g.b;
      } while (((lw)localObject).a == null);
      localObject = ((lw)localObject).a;
    } while ((0L == ((pf)localObject).b) || (((pf)localObject).f == null));
    ((pf)localObject).f.a(new pf.11((pf)localObject, paramInt));
  }
  
  public final void b(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    this.b.a(paramOnCameraChangeListener);
  }
  
  public final void b(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (this.b == null) {
      return;
    }
    this.b.b(paramTencentMapGestureListener);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if (paramBoolean)
    {
      this.b.az.a(11);
      return;
    }
    this.b.az.a(this.s);
  }
  
  public final float c()
  {
    return this.b.az.d;
  }
  
  public final void c(int paramInt)
  {
    if (this.b == null) {}
    pm localpm;
    do
    {
      return;
      this.b.g = paramInt;
      localpm = this.b.az;
    } while (localpm == null);
    localpm.e(paramInt);
    localpm.b.k();
  }
  
  public final void c(boolean paramBoolean)
  {
    if ((this.b == null) || (this.b.o == null)) {
      return;
    }
    this.b.o.a(paramBoolean);
  }
  
  public final void d()
  {
    this.b.az.j();
  }
  
  public final void d(int paramInt)
  {
    if (this.b == null) {}
    pm localpm;
    do
    {
      return;
      localpm = this.b.az;
    } while (localpm == null);
    localpm.d = paramInt;
    localpm.b.a.b(paramInt);
    localpm.b.k();
  }
  
  public final void d(boolean paramBoolean)
  {
    if (this.b == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.b.az;
      } while (localObject == null);
      localObject = ((pm)localObject).b;
    } while (((lw)localObject).p == null);
    if (((lw)localObject).v == null) {
      ((lw)localObject).v = new ib((lw)localObject, ((lw)localObject).p.b());
    }
    ((lw)localObject).v.a(paramBoolean);
  }
  
  public final int e()
  {
    int i1 = this.b.az.a();
    if (this.e != null)
    {
      jj localjj = this.e;
      if ((localjj.b == null) || (localjj.b.size() == 0) || (i1 < 0)) {
        return i1;
      }
      if ((i1 > 8) || (localjj.d >= jj.a)) {
        return jj.a + i1;
      }
      Iterator localIterator = localjj.b.iterator();
      while (localIterator.hasNext())
      {
        ji localji = (ji)localIterator.next();
        if (i1 == localji.a)
        {
          if ((i1 == 0) && (localji.b == 0) && (localjj.d <= 0)) {
            return jj.a;
          }
          return localji.c;
        }
      }
      return i1;
    }
    return -1;
  }
  
  public final void e(boolean paramBoolean)
  {
    if (this.b == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (paramBoolean)
        {
          this.b.o();
          return;
        }
        localObject = this.b;
      } while (((pn)localObject).l == null);
      localObject = ((pn)localObject).l;
    } while (((jd)localObject).a == null);
    ((jd)localObject).a.remove();
    ((jd)localObject).a = null;
  }
  
  public final void f(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.as = paramBoolean;
    }
  }
  
  public final boolean f()
  {
    return this.t;
  }
  
  public final void g(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.b = paramBoolean;
    }
  }
  
  public final boolean g()
  {
    return this.b.az.b.k;
  }
  
  public final void h()
  {
    this.a.onResume();
    if (this.d != null) {
      this.d.j();
    }
  }
  
  public final void h(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.au = paramBoolean;
  }
  
  public final void i()
  {
    this.a.onDestroy();
    if (this.k != null)
    {
      this.k.b();
      this.k = null;
    }
    lu locallu;
    if (this.d != null)
    {
      locallu = this.d;
      if ((locallu.a != null) && (locallu.b != null)) {
        break label60;
      }
    }
    for (;;)
    {
      this.d = null;
      return;
      label60:
      if (locallu.h != null) {
        locallu.h.removeCallbacksAndMessages(null);
      }
      locallu.a.removeAllViews();
      locallu.b.r = null;
      Iterator localIterator = locallu.g.iterator();
      while (localIterator.hasNext()) {
        ((gh)localIterator.next()).a();
      }
      locallu.c = null;
      locallu.c = null;
      locallu.g.clear();
      locallu.g = null;
      locallu.b = null;
      locallu.a = null;
    }
  }
  
  public final void i(boolean paramBoolean)
  {
    if ((this.b == null) || (this.b.az == null)) {
      return;
    }
    pm localpm = this.b.az;
    localpm.e = paramBoolean;
    localpm.b.d(paramBoolean);
  }
  
  public final void j()
  {
    this.a.onPause();
  }
  
  public final String k()
  {
    return "4.2.8";
  }
  
  public final MapLanguage l()
  {
    if (this.b == null) {
      return MapLanguage.LAN_CHINESE;
    }
    Object localObject = this.b.az;
    if (localObject == null) {
      return MapLanguage.LAN_CHINESE;
    }
    localObject = ((pm)localObject).b;
    if (((lw)localObject).t == null) {
      ((lw)localObject).t = new lw.b((lw)localObject);
    }
    localObject = ((lw)localObject).t;
    if ((((lw.b)localObject).b.a != null) && (((lw.b)localObject).b.a.t() == 1)) {
      return MapLanguage.LAN_ENGLISH;
    }
    return MapLanguage.LAN_CHINESE;
  }
  
  public final void m()
  {
    if (this.b == null) {}
    do
    {
      return;
      localObject = this.b.az;
    } while (localObject == null);
    Object localObject = ((pm)localObject).b;
    if (((lw)localObject).u == null) {
      ((lw)localObject).u = new lw.c((lw)localObject);
    }
    localObject = ((lw)localObject).u;
    ((lw.c)localObject).c.a.s();
    ((lw.c)localObject).a = null;
    ((lw.c)localObject).b = null;
  }
  
  public final int n()
  {
    if ((this.b == null) || (this.b.o == null)) {}
    kj localkj;
    do
    {
      return -1;
      localkj = this.b.o;
    } while (localkj.i == null);
    return localkj.i.getActiveLevelIndex();
  }
  
  public final String[] o()
  {
    if ((this.b == null) || (this.b.o == null)) {}
    do
    {
      return null;
      localObject = this.b.o;
    } while ((((kj)localObject).i == null) || (((kj)localObject).i.getLevels() == null) || (((kj)localObject).i.getLevels().isEmpty()));
    Object localObject = ((kj)localObject).i.getLevels();
    String[] arrayOfString = new String[((List)localObject).size()];
    int i1 = 0;
    while (i1 < ((List)localObject).size())
    {
      arrayOfString[i1] = ((IndoorLevel)((List)localObject).get(i1)).getName();
      i1 += 1;
    }
    return arrayOfString;
  }
  
  public final IndoorBuilding p()
  {
    if ((this.b == null) || (this.b.o == null)) {
      return null;
    }
    return this.b.o.i;
  }
  
  public final boolean q()
  {
    if (this.b == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = this.b.az;
      } while (localObject == null);
      localObject = ((pm)localObject).b;
    } while (((lw)localObject).v == null);
    return ((lw)localObject).v.a();
  }
  
  public final boolean r()
  {
    if (this.b == null) {}
    pn localpn;
    do
    {
      return false;
      localpn = this.b;
    } while ((localpn.l == null) || (localpn.l.a == null));
    return true;
  }
  
  public final boolean s()
  {
    if (this.b == null) {
      return false;
    }
    return this.b.au;
  }
  
  public final String t()
  {
    if ((this.c == null) || (this.b == null)) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject;
      if (!nl.a(this.j))
      {
        localObject = ge.a(this.c, this.j);
        localJSONObject.put("cfgVer", ((gc)localObject).b());
        int i1 = pz.b(this.c);
        int i2 = pz.c(this.c);
        localJSONObject.put("resolution", "{" + i1 + "," + i2 + "}");
        localJSONObject.put("density", this.u);
        localObject = this.b.az;
        if (((pm)localObject).b != null) {
          break label215;
        }
        localObject = null;
        label149:
        localJSONObject.put("renderStatus", localObject);
        localObject = this.b.az;
        if (((pm)localObject).b != null) {
          break label243;
        }
        localObject = null;
      }
      for (;;)
      {
        localJSONObject.put("renderError", localObject);
        localJSONObject.put("sdkver", "4.2.8.1");
        return localJSONObject.toString();
        localObject = gf.a(this.c);
        break;
        label215:
        localObject = ((pm)localObject).b;
        if (((lw)localObject).a == null)
        {
          localObject = null;
          break label149;
        }
        localObject = ((lw)localObject).a.v();
        break label149;
        label243:
        localObject = ((pm)localObject).b;
        if (((lw)localObject).a == null)
        {
          localObject = null;
        }
        else
        {
          pf localpf = ((lw)localObject).a;
          localObject = localpf.h;
          localpf.h = null;
        }
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public final VisibleRegion u()
  {
    Object localObject2 = new Point(0, this.b.ar);
    Object localObject4 = new Point(this.b.aq, this.b.ar);
    Object localObject3 = new Point(0, 0);
    Object localObject1 = new Point(this.b.aq, 0);
    localObject2 = a((Point)localObject2);
    localObject4 = a((Point)localObject4);
    localObject3 = a((Point)localObject3);
    localObject1 = a((Point)localObject1);
    return new VisibleRegion((LatLng)localObject2, (LatLng)localObject4, (LatLng)localObject3, (LatLng)localObject1, LatLngBounds.builder().include((LatLng)localObject2).include((LatLng)localObject4).include((LatLng)localObject3).include((LatLng)localObject1).build());
  }
  
  public final IMapRenderView v()
  {
    return this.a;
  }
  
  public final float w()
  {
    return this.b.az.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln
 * JD-Core Version:    0.7.0.1
 */