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
import com.tencent.map.sdk.engine.jni.JNI;
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
  public IMapRenderView a;
  public volatile pn b;
  public Context c;
  public lu d;
  public jj e;
  CameraPosition f;
  byte[] g;
  pd.a h;
  public he i;
  private String j;
  private hv k;
  private iy l;
  private final GeoPoint m;
  private final GeoPoint n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private float u;
  private boolean v;
  private final ln.b w;
  private final ln.b x;
  private kl.a y;
  
  public ln(int paramInt, BaseMapView paramBaseMapView, TencentMapOptions paramTencentMapOptions)
  {
    Object localObject2 = null;
    this.a = null;
    this.b = null;
    this.c = null;
    this.j = null;
    this.d = null;
    this.k = null;
    this.l = null;
    this.e = null;
    this.m = null;
    this.n = null;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.g = new byte[0];
    this.s = 0;
    this.t = false;
    this.u = 1.0F;
    this.v = false;
    this.w = new ln.b(this, false);
    this.x = new ln.b(this, true);
    this.y = new ln.1(this);
    this.h = new ln.2(this);
    this.i = new ln.6(this);
    this.c = paramBaseMapView.getContext().getApplicationContext();
    this.u = pz.a(this.c);
    if (this.a == null)
    {
      localObject1 = this.c;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            localObject1 = new py((Context)localObject1, paramTencentMapOptions);
          } else {
            localObject1 = new pw((Context)localObject1, paramTencentMapOptions);
          }
        }
        else {
          localObject1 = new px((Context)localObject1, paramTencentMapOptions);
        }
      }
      else {
        localObject1 = new py((Context)localObject1, paramTencentMapOptions);
      }
      this.a = ((IMapRenderView)localObject1);
      this.b = ((pn)this.a.getVectorMapDelegate());
      pn localpn = this.b;
      Context localContext = localpn.ay.getApplicationContext();
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("halley_app_id", 3203);
      ((Bundle)localObject1).putString("halley_app_name", pz.a);
      ((Bundle)localObject1).putString("halley_app_version", "android_vector_sdk_4.2.8.2");
      localObject1 = NetManager.buildAdapter(AdapterType.Halley, (Bundle)localObject1);
      NetManager.getInstance().setAdapter(localContext, (NetAdapter)localObject1);
      Object localObject3 = QStorageManager.getInstance(localContext);
      on.a(((QStorageManager)localObject3).getMapPath());
      on.a(((QStorageManager)localObject3).getSatPath());
      localObject1 = localObject2;
      if (paramTencentMapOptions != null)
      {
        localObject1 = localObject2;
        if (!nl.a(paramTencentMapOptions.getSubKey())) {
          localObject1 = paramTencentMapOptions.getSubKey();
        }
      }
      on.a(((QStorageManager)localObject3).getConfigPath((String)localObject1));
      on.a(((QStorageManager)localObject3).getAssetsLoadPath((String)localObject1));
      on.a(((QStorageManager)localObject3).getRouteBlockPath());
      if (paramTencentMapOptions != null) {
        if (paramTencentMapOptions.getCustomAssetsPath() != null)
        {
          localObject3 = paramTencentMapOptions.getCustomAssetsPath();
          if ((localObject3 != null) && (((String)localObject3).trim().length() != 0))
          {
            localObject2 = localObject3;
            if (!((String)localObject3).endsWith(File.separator))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject3);
              ((StringBuilder)localObject2).append(File.separator);
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            gd.a = (String)localObject2;
          }
        }
        else if (paramTencentMapOptions.getCustomLocalPath() != null)
        {
          localObject3 = paramTencentMapOptions.getCustomLocalPath();
          if ((localObject3 != null) && (((String)localObject3).trim().length() != 0))
          {
            localObject2 = localObject3;
            if (!((String)localObject3).endsWith(File.separator))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject3);
              ((StringBuilder)localObject2).append(File.separator);
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            gd.b = (String)localObject2;
          }
        }
      }
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
      } else {
        localpn.az.a(5);
      }
      if (localpn.R) {
        localpn.o();
      }
    }
    if (fy.b == null) {
      fy.b = new fy.a();
    }
    this.b.a(this);
    Object localObject1 = this.b.az;
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
  }
  
  private float a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    int i2 = this.b.aq;
    int i1 = this.b.ar;
    if ((i2 != 0) && (i1 != 0) && (paramLatLng1 != null) && (paramLatLng2 != null))
    {
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
      d3 = i1 - paramInt3 - paramInt4;
      double d4 = f1;
      Double.isNaN(d4);
      d4 = Math.cos(d4 * 3.141592653589793D / 180.0D);
      Double.isNaN(d3);
      paramInt3 = (int)(d3 / d4);
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = 1;
      }
      paramInt2 = paramInt3;
      if (paramInt3 <= 0) {
        paramInt2 = 1;
      }
      d3 = paramInt1;
      Double.isNaN(d3);
      d3 = Math.log(d1 * 1.0D / d3) / Math.log(2.0D);
      d1 = paramInt2;
      Double.isNaN(d1);
      d4 = Math.log(d2 * 1.0D / d1) / Math.log(2.0D);
      d1 = d3;
      if (d3 < 0.0D) {
        d1 = 0.0D;
      }
      d2 = d4;
      if (d4 < 0.0D) {
        d2 = 0.0D;
      }
      return (float)(20.0D - Math.max(d1, d2));
    }
    return 0.0F;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3)
  {
    GeoPoint localGeoPoint = new GeoPoint();
    float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramLatLng1, paramLatLng2, localGeoPoint);
    if (paramLatLng3 != null)
    {
      double d1 = localGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      paramLatLng3.latitude = (d1 / 1000000.0D);
      d1 = localGeoPoint.getLongitudeE6();
      Double.isNaN(d1);
      paramLatLng3.longitude = (d1 / 1000000.0D);
    }
    return f1;
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramLatLngBounds == null) {
      return -1;
    }
    if (paramLatLngBounds.northeast != null)
    {
      if (paramLatLngBounds.southwest == null) {
        return -1;
      }
      if ((this.b.aq != 0) && (this.b.ar != 0))
      {
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
          return 0;
        }
        paramLatLngBounds = new pd();
        paramLatLngBounds.c(0.0F);
        paramLatLngBounds.d(0.0F);
        paramLatLngBounds.b(paramInt1, paramInt2);
        paramLatLngBounds.a(f1);
        paramLatLngBounds.a = this.h;
        paramLatLngBounds.d = paramCancelableCallback;
        paramLatLngBounds.a(paramLong);
        this.b.az.a(paramLatLngBounds);
        return 0;
      }
      this.b.aj = paramLatLngBounds.southwest;
      this.b.ak = paramLatLngBounds.northeast;
      this.b.am = paramInt1;
      this.b.an = paramInt2;
      this.b.ao = paramInt3;
      this.b.ap = paramInt4;
      this.b.D = paramCancelableCallback;
      if (paramBoolean) {
        this.b.F = this.x;
      } else {
        this.b.F = this.w;
      }
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      if (paramInt1 + paramInt2 + this.o + this.q <= i1)
      {
        if (paramInt3 + paramInt4 + this.p + this.r > i2) {
          return -1;
        }
        return 0;
      }
    }
    return -1;
  }
  
  private int a(LatLngBounds paramLatLngBounds, int paramInt, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (paramLatLngBounds == null) {
      return -1;
    }
    if (paramLatLngBounds.northeast != null)
    {
      if (paramLatLngBounds.southwest == null) {
        return -1;
      }
      if ((this.b.aq != 0) && (this.b.ar != 0))
      {
        this.b.F = null;
        GeoPoint localGeoPoint = new GeoPoint();
        float f1 = a(paramInt, paramInt, paramInt, paramInt, paramLatLngBounds.southwest, paramLatLngBounds.northeast, localGeoPoint);
        if (f1 < 0.0F) {
          return (int)f1;
        }
        paramInt = localGeoPoint.getLatitudeE6();
        i1 = localGeoPoint.getLongitudeE6();
        if (!paramBoolean)
        {
          this.b.az.a(paramInt, i1);
          a(f1, false, paramLong, null);
          return 0;
        }
        paramLatLngBounds = new pd();
        paramLatLngBounds.b(paramInt, i1);
        paramLatLngBounds.a(f1);
        paramLatLngBounds.a = this.h;
        paramLatLngBounds.d = paramCancelableCallback;
        paramLatLngBounds.a(paramLong);
        this.b.az.a(paramLatLngBounds);
        return 0;
      }
      this.b.aj = paramLatLngBounds.southwest;
      this.b.ak = paramLatLngBounds.northeast;
      this.b.al = paramInt;
      this.b.D = paramCancelableCallback;
      if (paramBoolean) {
        this.b.F = this.x;
      } else {
        this.b.F = this.w;
      }
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      paramInt *= 2;
      if (this.o + paramInt + this.q <= i1)
      {
        if (paramInt + this.p + this.r > i2) {
          return -1;
        }
        return 0;
      }
    }
    return -1;
  }
  
  private int a(List<gl> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    kb localkb = (kb)this.b.az.i();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
      if ((this.b.aq != 0) && (this.b.ar != 0))
      {
        if (paramInt1 + paramInt2 <= this.b.aq)
        {
          if (paramInt3 + paramInt4 > this.b.ar) {
            return -1;
          }
          localkb.a(localArrayList, null, new Rect(paramInt1, paramInt3, paramInt2, paramInt4), new ln.3(this, paramBoolean, paramCancelableCallback, paramLong));
          return 0;
        }
        return -1;
      }
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      if (paramInt1 + paramInt2 <= i1)
      {
        if (paramInt3 + paramInt4 > i2) {
          return -1;
        }
        return 0;
      }
    }
    return -1;
  }
  
  private DoublePoint a(GeoPoint paramGeoPoint)
  {
    double d3 = this.u * 2.684355E+008F;
    Double.isNaN(d3);
    double d1 = d3 / 2.0D;
    Double.isNaN(d3);
    double d2 = d3 / 360.0D;
    Double.isNaN(d3);
    d3 /= 6.283185307179586D;
    double d4 = paramGeoPoint.getLatitudeE6();
    Double.isNaN(d4);
    d4 = Math.min(Math.max(Math.sin(d4 / 1000000.0D * 0.0174532925199433D), -0.9999D), 0.9999D);
    double d5 = paramGeoPoint.getLongitudeE6();
    Double.isNaN(d5);
    d5 /= 1000000.0D;
    d4 = Math.log((d4 + 1.0D) / (1.0D - d4));
    paramGeoPoint = new DoublePoint();
    paramGeoPoint.set(d5 * d2 + d1, d1 + d4 * d3 * 0.5D);
    return paramGeoPoint;
  }
  
  private GeoPoint a(DoublePoint paramDoublePoint)
  {
    double d3 = this.u * 2.684355E+008F;
    Double.isNaN(d3);
    double d1 = d3 / 2.0D;
    Double.isNaN(d3);
    double d2 = d3 / 360.0D;
    Double.isNaN(d3);
    d3 /= 6.283185307179586D;
    d2 = (paramDoublePoint.x - d1) / d2;
    d1 = Math.asin(1.0D - 2.0D / (Math.pow(2.718281828459045D, (paramDoublePoint.y - d1) / 0.5D / d3) + 1.0D)) * 180.0D / 3.141592653589793D;
    paramDoublePoint = new GeoPoint(0, 0);
    paramDoublePoint.setLatitudeE6((int)(d1 * 1000000.0D));
    paramDoublePoint.setLongitudeE6((int)(d2 * 1000000.0D));
    return paramDoublePoint;
  }
  
  private void a(double paramDouble1, double paramDouble2, float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(paramDouble2 * 1000000.0D);
    Object localObject = this.b;
    float f1 = this.b.az.d;
    if (paramFloat < f1) {
      paramFloat = f1;
    }
    f1 = paramFloat;
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
  }
  
  private void a(double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    int i1 = (int)(paramDouble1 * 1000000.0D);
    int i2 = (int)(paramDouble2 * 1000000.0D);
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
    if (this.b == null) {
      return;
    }
    if (paramFloat1 == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      if (paramFloat1 < 0.0F) {
        d1 = Math.pow(2.0D, Math.abs(paramFloat1));
      } else {
        d1 = Math.pow(0.5D, Math.abs(paramFloat1));
      }
      paramFloat1 = (float)(1.0D / d1);
      paramCancelableCallback = this.b.az;
      double d1 = paramFloat1;
      double d2 = paramFloat2;
      double d3 = paramFloat3;
      paramCancelableCallback.b.c.a(d1, d2, d3, d2, d3, null);
      return;
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
    if (this.b == null) {
      return;
    }
    if ((paramFloat1 == 0.0F) && (paramFloat2 == 0.0F)) {
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
    if (this.b == null) {
      return;
    }
    if (paramCameraPosition == null) {
      return;
    }
    GeoPoint localGeoPoint = fz.a(paramCameraPosition.target);
    float f2 = paramCameraPosition.zoom;
    Object localObject = this.b;
    float f3 = this.b.az.d;
    float f1 = f2;
    if (f2 < f3) {
      f1 = f3;
    }
    f2 = f1;
    if (f1 > 20.0F) {
      f2 = 20.0F;
    }
    if (!paramBoolean)
    {
      double d1 = 1.0D / Math.pow(2.0D, 20.0F - f2);
      if (localGeoPoint != null) {
        this.b.az.a(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      this.b.az.c((float)d1);
      this.b.az.b(paramCameraPosition.bearing);
      if (paramCameraPosition.tilt >= 0.0F) {
        this.b.az.a(paramCameraPosition.tilt);
      }
      return;
    }
    localObject = new pd();
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
      return;
    }
    this.b.az.b(paramFloat1);
    if (paramFloat2 >= 0.0F) {
      this.b.az.a(paramFloat2);
    }
  }
  
  private void b(float paramFloat, boolean paramBoolean, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (this.b == null) {
      return;
    }
    if (paramFloat == 0.0F) {
      return;
    }
    if (!paramBoolean)
    {
      double d1;
      if (paramFloat < 0.0F) {
        d1 = Math.pow(2.0D, Math.abs(paramFloat));
      } else {
        d1 = Math.pow(0.5D, Math.abs(paramFloat));
      }
      paramFloat = (float)(1.0D / d1);
      float f1 = this.b.az.d();
      this.b.az.a(f1 * paramFloat);
      return;
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
    int i5 = this.b.aq;
    int i6 = this.b.ar;
    if ((i5 != 0) && (i6 != 0) && (paramLatLng1 != null) && (paramLatLng2 != null))
    {
      if ((paramInt1 + paramInt2 + this.o + this.q <= i5) && (paramInt3 + paramInt4 + this.p + this.r <= i6))
      {
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
        int i4 = i5 - paramInt1 - paramInt2 - this.o - this.q;
        int i2 = i6 - paramInt3 - paramInt4 - this.p - this.r;
        int i3 = 1;
        int i1 = i4;
        if (i4 <= 0) {
          i1 = 1;
        }
        if (i2 <= 0) {
          i2 = i3;
        }
        d3 = i1;
        Double.isNaN(d3);
        d1 /= d3;
        d3 = i2;
        Double.isNaN(d3);
        d1 = Math.max(d1, d2 / d3);
        float f2 = (float)(20.0D - Math.log(d1) / Math.log(2.0D));
        float f4 = b();
        float f3 = c();
        float f1 = f2;
        if (f4 < f2)
        {
          d1 = Math.pow(2.0D, 20.0F - f4);
          f1 = f4;
        }
        f2 = f1;
        if (f3 > f1)
        {
          d1 = Math.pow(2.0D, 20.0F - f3);
          f2 = f3;
        }
        paramLatLng1 = new LatLng((paramLatLng1.latitude + paramLatLng2.latitude) / 2.0D, (paramLatLng1.longitude + paramLatLng2.longitude) / 2.0D);
        d2 = paramInt2 - paramInt1;
        Double.isNaN(d2);
        d2 = d2 * d1 / 2.0D;
        d3 = paramInt3 - paramInt4;
        Double.isNaN(d3);
        d3 = d3 * d1 / 2.0D;
        paramLatLng1 = a(fz.a(paramLatLng1));
        paramLatLng1.x += d2;
        paramLatLng1.y += d3;
        double d5 = paramLatLng1.x;
        double d4 = paramLatLng1.y;
        if (this.v)
        {
          paramInt1 = this.o;
          paramInt3 = this.q;
          paramInt2 = this.p - this.r;
          d2 = (paramInt1 - paramInt3) / (i5 * 2.0F) + 0.5F;
          if (d2 < 0.25D)
          {
            d2 = i5;
            Double.isNaN(d2);
          }
          for (d2 *= -0.5D;; d2 *= 0.5D)
          {
            paramInt1 = (int)d2;
            break label628;
            if (d2 <= 0.75D) {
              break;
            }
            d2 = i5;
            Double.isNaN(d2);
          }
          paramInt1 -= paramInt3;
          label628:
          d2 = (this.p - this.r) / (i6 * 2.0F) + 0.5F;
          if (d2 < 0.25D)
          {
            d2 = i6;
            Double.isNaN(d2);
          }
          for (d2 *= -0.5D;; d2 *= 0.5D)
          {
            paramInt2 = (int)d2;
            break;
            if (d2 <= 0.75D) {
              break;
            }
            d2 = i6;
            Double.isNaN(d2);
          }
          d2 = paramInt1;
          Double.isNaN(d2);
          double d7 = d2 * d1 / 2.0D;
          d2 = paramInt2;
          Double.isNaN(d2);
          double d6 = d2 * d1 / 2.0D;
          paramLatLng1 = this.b.az.b.n.r;
          if (paramLatLng1 == null)
          {
            d2 = 0.0D;
            d3 = 0.0D;
          }
          else
          {
            d3 = paramLatLng1.a;
            f1 = paramLatLng1.b;
            d2 = f1;
          }
          double d8 = i5;
          Double.isNaN(d8);
          d3 = d5 - d7 + d3 * d8 * d1;
          d5 = i6;
          Double.isNaN(d5);
          d1 = d4 - d6 - d2 * d5 * d1;
          d2 = d3;
        }
        else
        {
          d2 = d5;
          d1 = d4;
        }
        paramLatLng1 = a(new DoublePoint(d2, d1));
        paramGeoPoint.setLatitudeE6(paramLatLng1.getLatitudeE6());
        paramGeoPoint.setLongitudeE6(paramLatLng1.getLongitudeE6());
        return f2;
      }
      return -1.0F;
    }
    return -2.0F;
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(0, 0, 0, 0, paramLatLng1, paramLatLng2, null);
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if (paramLatLng1 != null)
    {
      if (paramLatLng2 == null) {
        return 0.0F;
      }
      LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
      localBuilder.include(paramLatLng1);
      localBuilder.include(paramLatLng2);
      if (!paramBoolean) {
        paramFloat = 0.0F;
      }
      return a(paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, localBuilder.build().southwest, localBuilder.build().northeast);
    }
    return 0.0F;
  }
  
  public final float a(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (paramLatLng1 != null)
    {
      if (paramLatLng2 == null) {
        return 0.0F;
      }
      LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
      localBuilder.include(paramLatLng1);
      localBuilder.include(paramLatLng2);
      if (!paramBoolean) {
        paramFloat = 0.0F;
      }
      return a(paramFloat, 0, 0, paramInt, 0, localBuilder.build().southwest, localBuilder.build().northeast);
    }
    return 0.0F;
  }
  
  public final float a(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (paramLatLngBounds == null) {
      return 0.0F;
    }
    int i1;
    if (paramBoolean == true) {
      i1 = this.b.K;
    } else {
      i1 = this.b.M;
    }
    if (!paramBoolean) {
      paramFloat = 0.0F;
    }
    int i2 = i1;
    if (i1 < 0) {
      i2 = this.b.aq / 2;
    }
    return a(paramFloat, 0, 0, paramInt, this.b.ar - i2, paramLatLngBounds.southwest, paramLatLngBounds.northeast);
  }
  
  public final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Object localObject1 = this.b.az.b.c;
    ((kl)localObject1).n = paramInt1;
    ((kl)localObject1).o = paramInt2;
    ((kl)localObject1).p = paramInt3;
    ((kl)localObject1).q = paramInt4;
    Object localObject2 = ((kl)localObject1).j;
    int i1 = 0;
    if ((localObject2 != null) && (((kl)localObject1).j.width() > 0) && (((kl)localObject1).j.height() > 0))
    {
      if ((paramInt1 + paramInt3 <= ((kl)localObject1).j.width()) && (paramInt2 + paramInt4 <= ((kl)localObject1).j.height()))
      {
        localObject2 = ((kl)localObject1).b();
        ((kl)localObject1).a(((PointF)localObject2).x, ((PointF)localObject2).y, paramBoolean);
        break label234;
      }
    }
    else
    {
      localObject2 = new kl.1((kl)localObject1, paramBoolean);
      if (!((kl)localObject1).c.contains(localObject2)) {
        ((kl)localObject1).c.add(localObject2);
      }
      if (!(((kl)localObject1).h instanceof lw)) {
        break label230;
      }
      localObject1 = ((lw)((kl)localObject1).h).l;
      if ((paramInt1 + paramInt3 <= pz.b((Context)localObject1)) && (paramInt2 + paramInt4 <= pz.c((Context)localObject1))) {
        break label234;
      }
    }
    i1 = -1;
    break label234;
    label230:
    i1 = -2;
    label234:
    if (i1 == 0)
    {
      this.o = paramInt1;
      this.p = paramInt2;
      this.q = paramInt3;
      this.r = paramInt4;
    }
    return i1;
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
      return 0;
    case 13: 
      return a(paramCameraUpdate.L, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, false, 0L, null);
    case 12: 
      b(paramCameraUpdate.J, paramCameraUpdate.K, false, 0L, null);
      return 0;
    case 11: 
      return a(paramCameraUpdate.B, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, false, 0L, null);
    case 10: 
      return a(paramCameraUpdate.B, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, false, 0L, null);
    case 9: 
      return a(paramCameraUpdate.z, paramCameraUpdate.A, false, 0L, null);
    case 8: 
      a(paramCameraUpdate.x.latitude, paramCameraUpdate.x.longitude, paramCameraUpdate.y, false, 0L, null);
      return 0;
    case 7: 
      a(paramCameraUpdate.w.latitude, paramCameraUpdate.w.longitude, false, 0L, null);
      return 0;
    case 6: 
      a(paramCameraUpdate.v, false, 0L, null);
      return 0;
    case 5: 
      a(paramCameraUpdate.t, paramCameraUpdate.u.x, paramCameraUpdate.u.y, false, 0L, null);
      return 0;
    case 4: 
      b(paramCameraUpdate.s, false, 0L, null);
      return 0;
    case 3: 
      a(paramCameraUpdate.r, false, 0L, null);
      return 0;
    case 2: 
      a(paramCameraUpdate.p, paramCameraUpdate.q, false, 0L, null);
      return 0;
    case 1: 
      b(false, 0L, null);
      return 0;
    }
    a(false, 0L, null);
    return 0;
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
      break;
    case 13: 
      return a(paramCameraUpdate.L, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, true, paramLong, paramCancelableCallback);
    case 12: 
      b(paramCameraUpdate.J, paramCameraUpdate.K, true, paramLong, paramCancelableCallback);
      break;
    case 11: 
      return a(paramCameraUpdate.B, paramCameraUpdate.F, paramCameraUpdate.G, paramCameraUpdate.H, paramCameraUpdate.I, true, paramLong, paramCancelableCallback);
    case 10: 
      return a(paramCameraUpdate.B, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, paramCameraUpdate.E, true, paramLong, paramCancelableCallback);
    case 9: 
      return a(paramCameraUpdate.z, paramCameraUpdate.A, true, paramLong, paramCancelableCallback);
    case 8: 
      a(paramCameraUpdate.x.latitude, paramCameraUpdate.x.longitude, paramCameraUpdate.y, true, paramLong, paramCancelableCallback);
      break;
    case 7: 
      a(paramCameraUpdate.w.latitude, paramCameraUpdate.w.longitude, true, paramLong, paramCancelableCallback);
      break;
    case 6: 
      a(paramCameraUpdate.v, true, paramLong, paramCancelableCallback);
      break;
    case 5: 
      a(paramCameraUpdate.t, paramCameraUpdate.u.x, paramCameraUpdate.u.y, true, paramLong, paramCancelableCallback);
      break;
    case 4: 
      b(paramCameraUpdate.s, true, paramLong, paramCancelableCallback);
      break;
    case 3: 
      a(paramCameraUpdate.r, true, paramLong, paramCancelableCallback);
      break;
    case 2: 
      a(paramCameraUpdate.p, paramCameraUpdate.q, true, paramLong, paramCancelableCallback);
      break;
    case 1: 
      b(true, paramLong, paramCancelableCallback);
      break;
    case 0: 
      a(true, paramLong, paramCancelableCallback);
    }
    return 0;
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
    if ((this.b.aq != 0) && (this.b.ar != 0))
    {
      if ((paramInt1 + paramInt2 > this.b.aq) || (paramInt3 + paramInt4 > this.b.ar)) {
        return null;
      }
    }
    else
    {
      int i1 = pz.b(this.c);
      int i2 = pz.c(this.c);
      if (paramInt1 + paramInt2 > i1) {
        break label671;
      }
      if (paramInt3 + paramInt4 > i2) {
        return null;
      }
    }
    Object localObject = (kb)this.b.az.i();
    if ((??? != null) && (!???.isEmpty()))
    {
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
      try
      {
        synchronized (this.g)
        {
          this.g.wait(1000L);
        }
      }
      catch (InterruptedException paramList1)
      {
        or.b(Log.getStackTraceString(paramList1));
        Thread.currentThread().interrupt();
        return this.f;
      }
      throw paramList1;
    }
    if (paramList1 != null)
    {
      if (paramList1.isEmpty()) {
        return null;
      }
      if (paramList1.size() == 1) {
        return new CameraPosition((LatLng)paramList1.get(0), this.b.az.e(), this.b.az.h(), this.b.az.g());
      }
      ??? = paramList1.iterator();
      double d5 = 0.0D;
      double d4 = d5;
      double d3 = d4;
      double d2 = d3;
      while (???.hasNext())
      {
        paramList1 = (LatLng)???.next();
        if (paramList1 != null)
        {
          double d1 = d5;
          if (d5 == 0.0D) {
            d1 = paramList1.latitude;
          }
          d5 = d4;
          if (d4 == 0.0D) {
            d5 = paramList1.longitude;
          }
          d4 = d3;
          d3 = d4;
          if (d4 == 0.0D) {
            d3 = paramList1.latitude;
          }
          d4 = d3;
          d3 = d2;
          if (d2 == 0.0D) {
            d3 = paramList1.longitude;
          }
          d2 = d1;
          if (paramList1.latitude < d1) {
            d2 = paramList1.latitude;
          }
          d1 = d4;
          if (paramList1.latitude > d4) {
            d1 = paramList1.latitude;
          }
          d4 = d5;
          if (paramList1.longitude < d5) {
            d4 = paramList1.longitude;
          }
          d5 = d3;
          if (paramList1.longitude > d3) {
            d5 = paramList1.longitude;
          }
          double d6 = d5;
          d5 = d2;
          d3 = d1;
          d2 = d6;
        }
      }
      ??? = new LatLng(d5, d4);
      paramList1 = new LatLng(d3, d2);
      localObject = new LatLng(0.0D, 0.0D);
      float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, ???, paramList1, (LatLng)localObject);
      if (f1 < 0.0F) {
        return null;
      }
      return new CameraPosition((LatLng)localObject, f1, this.b.az.h(), this.b.az.g());
    }
    label671:
    return null;
  }
  
  public final CameraPosition a(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    if ((this.b.aq != 0) && (this.b.ar != 0))
    {
      if ((paramInt1 + paramInt2 > this.b.aq) || (paramInt3 + paramInt4 > this.b.ar))
      {
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(null);
        }
        return null;
      }
    }
    else
    {
      pz.b(this.c);
      pz.c(this.c);
    }
    Object localObject = (kb)this.b.az.i();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
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
    if ((paramList1 != null) && (!paramList1.isEmpty()))
    {
      if (paramList1.size() == 1)
      {
        paramList = new CameraPosition((LatLng)paramList1.get(0), this.b.az.d(), this.b.az.h(), this.b.az.g());
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(paramList);
        }
        return paramList;
      }
      paramList = paramList1.iterator();
      double d5 = 0.0D;
      double d4 = d5;
      double d3 = d4;
      double d2 = d3;
      while (paramList.hasNext())
      {
        paramList1 = (LatLng)paramList.next();
        if (paramList1 != null)
        {
          double d1 = d5;
          if (d5 == 0.0D) {
            d1 = paramList1.latitude;
          }
          d5 = d4;
          if (d4 == 0.0D) {
            d5 = paramList1.longitude;
          }
          d4 = d3;
          d3 = d4;
          if (d4 == 0.0D) {
            d3 = paramList1.latitude;
          }
          d4 = d3;
          d3 = d2;
          if (d2 == 0.0D) {
            d3 = paramList1.longitude;
          }
          d2 = d1;
          if (paramList1.latitude < d1) {
            d2 = paramList1.latitude;
          }
          d1 = d4;
          if (paramList1.latitude > d4) {
            d1 = paramList1.latitude;
          }
          d4 = d5;
          if (paramList1.longitude < d5) {
            d4 = paramList1.longitude;
          }
          d5 = d3;
          if (paramList1.longitude > d3) {
            d5 = paramList1.longitude;
          }
          double d6 = d5;
          d5 = d2;
          d3 = d1;
          d2 = d6;
        }
      }
      paramList = new LatLng(d5, d4);
      paramList1 = new LatLng(d3, d2);
      localObject = new LatLng(0.0D, 0.0D);
      float f1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramList, paramList1, (LatLng)localObject);
      if (f1 < 0.0F)
      {
        if (paramAsyncOperateCallback != null) {
          paramAsyncOperateCallback.onOperateFinished(null);
        }
        return null;
      }
      paramList = new CameraPosition((LatLng)localObject, f1, this.b.az.h(), this.b.az.g());
      if (paramAsyncOperateCallback != null) {
        paramAsyncOperateCallback.onOperateFinished(paramList);
      }
      return paramList;
    }
    if (paramAsyncOperateCallback != null) {
      paramAsyncOperateCallback.onOperateFinished(null);
    }
    return null;
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
    if ((this.b != null) && (this.b.az != null)) {
      return this.b.az.a(paramTileOverlayOptions);
    }
    return null;
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
    }
    else
    {
      f1 = paramFloat1;
      if (paramFloat1 > 1.0F) {
        f1 = 1.0F;
      }
    }
    if (paramFloat2 < 0.0F)
    {
      paramFloat1 = 0.0F;
    }
    else
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
    int i1 = (int)(this.b.aq * f1);
    int i2 = (int)(this.b.ar * paramFloat1);
    this.b.d(i1, i2);
    this.b.N = f1;
    this.b.O = paramFloat1;
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
      int i1;
      if (paramBoolean) {
        i1 = 22;
      } else {
        i1 = 20;
      }
      double d1 = 1.0D / Math.pow(2.0D, 20.0F - Math.min(paramFloat, Math.min(i2, i1)));
      this.b.az.a((float)d1);
      return;
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
    jj localjj = this.e;
    int i1 = paramInt;
    if (localjj != null) {
      i1 = localjj.a(paramInt);
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
    if (this.b != null)
    {
      if (this.b.k == null) {
        return;
      }
      jz localjz = this.b.k;
      if (paramLanguage != null)
      {
        localjz.d = paramLanguage;
        localjz.a();
      }
    }
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
    } else {
      localpd.a(this.b.L, this.b.M);
    }
    this.b.az.j();
    this.b.az.a(localpd);
  }
  
  public final void a(LatLngBounds paramLatLngBounds, int paramInt)
  {
    if (this.b != null)
    {
      if (this.b.az == null) {
        return;
      }
      Object localObject = this.b.az;
      if (((pm)localObject).b != null)
      {
        localObject = ((pm)localObject).b;
        if (((lw)localObject).a != null)
        {
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
      }
    }
  }
  
  public final void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (this.b == null) {
      return;
    }
    this.b.a(paramTencentMapGestureListener);
  }
  
  public final void a(String paramString)
  {
    if (this.b == null) {
      return;
    }
    pm localpm = this.b.az;
    if (localpm == null) {
      return;
    }
    Object localObject = localpm.b;
    if (((lw)localObject).a != null)
    {
      localObject = ((lw)localObject).a;
      try
      {
        ((pf)localObject).y();
        long l1 = ((pf)localObject).b;
        if (l1 == 0L) {}
        for (;;)
        {
          ((pf)localObject).z();
          break label107;
          try
          {
            ((pf)localObject).a.nativeMapLoadKMLFile(((pf)localObject).b, paramString);
          }
          finally {}
        }
        localpm.b.k();
      }
      finally
      {
        ((pf)localObject).z();
      }
    }
    label107:
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.b != null)
    {
      if (this.b.az == null) {
        return;
      }
      pm localpm = this.b.az;
      if (localpm != null) {
        localpm.a(paramString1, paramString2);
      }
    }
  }
  
  public final void a(List<hk> paramList, List<LatLng> paramList1)
  {
    if (this.b == null) {
      return;
    }
    Object localObject = this.b.az;
    if (localObject == null) {
      return;
    }
    paramList1 = fz.a(paramList1);
    localObject = ((pm)localObject).b;
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
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = this.b.az;
    if (((pm)localObject1).b != null) {
      ((pm)localObject1).b.B = paramBoolean2;
    }
    localObject1 = this.b.az;
    if (((pm)localObject1).b != null)
    {
      localObject1 = ((pm)localObject1).b;
      ((lw)localObject1).s = paramBoolean1;
      if (((lw)localObject1).a != null)
      {
        localObject1 = ((lw)localObject1).a;
        try
        {
          ((pf)localObject1).y();
          if (0L != ((pf)localObject1).b) {
            try
            {
              ((pf)localObject1).a.nativeSetBuilding3DEffect(((pf)localObject1).b, paramBoolean1);
            }
            finally {}
          }
          return;
        }
        finally
        {
          ((pf)localObject1).z();
        }
      }
    }
  }
  
  public final float b()
  {
    return this.b.az.c;
  }
  
  public final Point b(LatLng paramLatLng)
  {
    if (this.b == null) {
      return null;
    }
    paramLatLng = fz.a(paramLatLng);
    paramLatLng = this.b.az.b.h.a(paramLatLng);
    if (paramLatLng == null) {
      return null;
    }
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
    }
    else
    {
      f1 = paramFloat1;
      if (paramFloat1 > 1.0F) {
        f1 = 1.0F;
      }
    }
    if (paramFloat2 < 0.0F)
    {
      paramFloat1 = 0.0F;
    }
    else
    {
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
    int i1 = (int)(this.b.aq * f1);
    int i2 = (int)(this.b.ar * paramFloat1);
    this.b.e(i1, i2);
    this.b.P = f1;
    this.b.Q = paramFloat1;
  }
  
  public final void b(int paramInt)
  {
    if (this.b != null)
    {
      if (this.b.o == null) {
        return;
      }
      Object localObject = this.b.o;
      if (((kj)localObject).g != null)
      {
        localObject = ((kj)localObject).g.b;
        if (((lw)localObject).a != null)
        {
          localObject = ((lw)localObject).a;
          if (0L != ((pf)localObject).b)
          {
            if (((pf)localObject).f == null) {
              return;
            }
            ((pf)localObject).f.a(new pf.11((pf)localObject, paramInt));
          }
        }
      }
    }
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
    if (this.b == null) {
      return;
    }
    this.b.g = paramInt;
    pm localpm = this.b.az;
    if (localpm == null) {
      return;
    }
    localpm.e(paramInt);
    localpm.b.k();
  }
  
  public final void c(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (this.b.o == null) {
        return;
      }
      this.b.o.a(paramBoolean);
    }
  }
  
  public final void d()
  {
    this.b.az.j();
  }
  
  public final void d(int paramInt)
  {
    if (this.b == null) {
      return;
    }
    pm localpm = this.b.az;
    if (localpm == null) {
      return;
    }
    localpm.d = paramInt;
    localpm.b.a.b(paramInt);
    localpm.b.k();
  }
  
  public final void d(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    Object localObject = this.b.az;
    if (localObject == null) {
      return;
    }
    localObject = ((pm)localObject).b;
    if (((lw)localObject).p != null)
    {
      if (((lw)localObject).v == null) {
        ((lw)localObject).v = new ib((lw)localObject, ((lw)localObject).p.b());
      }
      ((lw)localObject).v.a(paramBoolean);
    }
  }
  
  public final int e()
  {
    int i1 = this.b.az.a();
    jj localjj = this.e;
    if (localjj != null)
    {
      int i2 = i1;
      if (localjj.b != null)
      {
        i2 = i1;
        if (localjj.b.size() != 0)
        {
          if (i1 < 0) {
            return i1;
          }
          if ((i1 <= 8) && (localjj.d < jj.a))
          {
            Iterator localIterator = localjj.b.iterator();
            ji localji;
            do
            {
              i2 = i1;
              if (!localIterator.hasNext()) {
                break;
              }
              localji = (ji)localIterator.next();
            } while (i1 != localji.a);
            if ((i1 == 0) && (localji.b == 0) && (localjj.d <= 0)) {
              return jj.a;
            }
            i2 = localji.c;
            return i2;
          }
          i2 = i1 + jj.a;
        }
      }
      return i2;
    }
    return -1;
  }
  
  public final void e(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    if (paramBoolean)
    {
      this.b.o();
      return;
    }
    Object localObject = this.b;
    if (((pn)localObject).l != null)
    {
      localObject = ((pn)localObject).l;
      if (((jd)localObject).a != null)
      {
        ((jd)localObject).a.remove();
        ((jd)localObject).a = null;
      }
    }
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
    lu locallu = this.d;
    if (locallu != null) {
      locallu.j();
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
    Object localObject = this.k;
    if (localObject != null)
    {
      ((hv)localObject).b();
      this.k = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      if ((((lu)localObject).a != null) && (((lu)localObject).b != null))
      {
        if (((lu)localObject).h != null) {
          ((lu)localObject).h.removeCallbacksAndMessages(null);
        }
        ((lu)localObject).a.removeAllViews();
        ((lu)localObject).b.r = null;
        Iterator localIterator = ((lu)localObject).g.iterator();
        while (localIterator.hasNext()) {
          ((gh)localIterator.next()).a();
        }
        ((lu)localObject).c = null;
        ((lu)localObject).c = null;
        ((lu)localObject).g.clear();
        ((lu)localObject).g = null;
        ((lu)localObject).b = null;
        ((lu)localObject).a = null;
      }
      this.d = null;
    }
  }
  
  public final void i(boolean paramBoolean)
  {
    if (this.b != null)
    {
      if (this.b.az == null) {
        return;
      }
      pm localpm = this.b.az;
      localpm.e = paramBoolean;
      localpm.b.d(paramBoolean);
    }
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
    if (this.b == null) {
      return;
    }
    Object localObject = this.b.az;
    if (localObject == null) {
      return;
    }
    localObject = ((pm)localObject).b;
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
    if (this.b != null)
    {
      if (this.b.o == null) {
        return -1;
      }
      kj localkj = this.b.o;
      if (localkj.i == null) {
        return -1;
      }
      return localkj.i.getActiveLevelIndex();
    }
    return -1;
  }
  
  public final String[] o()
  {
    Object localObject = this.b;
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = arrayOfString2;
    if (localObject != null)
    {
      if (this.b.o == null) {
        return null;
      }
      localObject = this.b.o;
      arrayOfString1 = arrayOfString2;
      if (((kj)localObject).i != null)
      {
        arrayOfString1 = arrayOfString2;
        if (((kj)localObject).i.getLevels() != null)
        {
          if (((kj)localObject).i.getLevels().isEmpty()) {
            return null;
          }
          localObject = ((kj)localObject).i.getLevels();
          arrayOfString2 = new String[((List)localObject).size()];
          int i1 = 0;
          for (;;)
          {
            arrayOfString1 = arrayOfString2;
            if (i1 >= ((List)localObject).size()) {
              break;
            }
            arrayOfString2[i1] = ((IndoorLevel)((List)localObject).get(i1)).getName();
            i1 += 1;
          }
        }
      }
    }
    return arrayOfString1;
  }
  
  public final IndoorBuilding p()
  {
    if ((this.b != null) && (this.b.o != null)) {
      return this.b.o.i;
    }
    return null;
  }
  
  public final boolean q()
  {
    if (this.b == null) {
      return false;
    }
    Object localObject = this.b.az;
    if (localObject == null) {
      return false;
    }
    localObject = ((pm)localObject).b;
    if (((lw)localObject).v == null) {
      return false;
    }
    return ((lw)localObject).v.a();
  }
  
  public final boolean r()
  {
    if (this.b == null) {
      return false;
    }
    pn localpn = this.b;
    return (localpn.l != null) && (localpn.l.a != null);
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
    if (this.c != null) {
      if (this.b == null) {
        return null;
      }
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (!nl.a(this.j)) {
          localObject1 = ge.a(this.c, this.j);
        } else {
          localObject1 = gf.a(this.c);
        }
        localJSONObject.put("cfgVer", ((gc)localObject1).b());
        int i1 = pz.b(this.c);
        int i2 = pz.c(this.c);
        Object localObject1 = new StringBuilder("{");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(",");
        ((StringBuilder)localObject1).append(i2);
        ((StringBuilder)localObject1).append("}");
        localJSONObject.put("resolution", ((StringBuilder)localObject1).toString());
        localJSONObject.put("density", this.u);
        localObject1 = this.b.az;
        if (((pm)localObject1).b == null) {
          break label292;
        }
        localObject1 = ((pm)localObject1).b;
        if (((lw)localObject1).a == null) {
          break label292;
        }
        localObject1 = ((lw)localObject1).a.v();
        localJSONObject.put("renderStatus", localObject1);
        localObject1 = this.b.az;
        if (((pm)localObject1).b == null) {
          break label297;
        }
        localObject1 = ((pm)localObject1).b;
        if (((lw)localObject1).a == null) {
          break label297;
        }
        pf localpf = ((lw)localObject1).a;
        localObject1 = localpf.h;
        localpf.h = null;
        localJSONObject.put("renderError", localObject1);
        localJSONObject.put("sdkver", "4.2.8.2");
        localObject1 = localJSONObject.toString();
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return null;
      label292:
      Object localObject2 = null;
      continue;
      label297:
      localObject2 = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ln
 * JD-Core Version:    0.7.0.1
 */