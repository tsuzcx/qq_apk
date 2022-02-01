package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public final class mr
  extends mu
  implements gj
{
  private static AtomicInteger s = new AtomicInteger(0);
  private ir h;
  private Bitmap i = null;
  private int j = 0;
  private int k = 0;
  private GeoPoint l = null;
  private pn m = null;
  private lq n;
  private Marker o = null;
  private boolean p = false;
  private float q = 0.5F;
  private float r = 0.5F;
  private boolean t = false;
  private View u;
  
  mr(lq paramlq, Marker paramMarker)
  {
    this.n = paramlq;
    this.m = this.n.a;
    this.o = paramMarker;
    if (this.m != null)
    {
      paramlq = this.o;
      if (paramlq != null)
      {
        if (paramlq.getOptions() == null) {
          return;
        }
        k();
        paramlq = this.m.az.b.f;
        if (paramlq != null)
        {
          this.h = new ir(paramlq, b(this.o.getOptions()));
          paramlq = new StringBuilder("create InfoWindowView:");
          paramlq.append(this.u);
          or.a(paramlq.toString());
          a(fy.a(this.u));
        }
      }
    }
  }
  
  static View a(Context paramContext, gj paramgj, TencentMap.InfoWindowAdapter paramInfoWindowAdapter, Marker paramMarker)
  {
    if (paramContext != null)
    {
      if (paramgj == null) {
        return null;
      }
      String str1 = "";
      String str2;
      if (paramMarker != null)
      {
        str1 = paramMarker.getTitle();
        str2 = paramMarker.getSnippet();
      }
      else
      {
        str2 = "";
      }
      if (paramInfoWindowAdapter == null) {
        return a(paramContext, paramgj, str1, str2);
      }
      LinearLayout localLinearLayout = (LinearLayout)paramgj.g();
      paramgj = localLinearLayout;
      if (localLinearLayout == null) {
        paramgj = a(paramContext);
      }
      paramContext = paramInfoWindowAdapter.getInfoWindow(paramMarker);
      if (paramContext != null)
      {
        if (paramContext.getParent() == paramgj) {
          return paramgj;
        }
        if ((paramContext.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramContext.getParent()).removeAllViews();
        }
        paramgj.setBackgroundDrawable(null);
        paramgj.removeAllViews();
        paramgj.addView(paramContext);
        return paramgj;
      }
      paramContext = paramInfoWindowAdapter.getInfoContents(paramMarker);
      if (paramContext != null)
      {
        if (paramContext.getParent() == paramgj) {
          return paramgj;
        }
        if ((paramContext.getParent() instanceof ViewGroup)) {
          ((ViewGroup)paramContext.getParent()).removeAllViews();
        }
        a(paramgj, "marker_infowindow.9.png");
        paramgj.removeAllViews();
        paramgj.addView(paramContext);
        return paramgj;
      }
      a(paramgj, "marker_infowindow.9.png");
      paramgj.removeAllViews();
      a(paramgj, "tencent_map_infowindow_content_title", str1);
      a(paramgj, "tencent_map_infowindow_content_snippet", str2);
      return paramgj;
    }
    return null;
  }
  
  private static View a(Context paramContext, gj paramgj, String paramString1, String paramString2)
  {
    paramgj = (LinearLayout)paramgj.g();
    if (paramgj == null)
    {
      paramContext = a(paramContext);
    }
    else
    {
      paramgj.removeAllViews();
      paramContext = paramgj;
    }
    a(paramContext, "marker_infowindow.9.png");
    a(paramContext, "tencent_map_infowindow_content_title", paramString1);
    a(paramContext, "tencent_map_infowindow_content_snippet", paramString2);
    return paramContext;
  }
  
  private static LinearLayout a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = new LinearLayout(paramContext);
    paramContext.setTag("tencent_map_infowindow_view");
    paramContext.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
    paramContext.setOrientation(1);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.i = paramBitmap;
    if (paramBitmap == null) {
      return;
    }
    or.a("setBitmapAssist:".concat(String.valueOf(paramBitmap)));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramBitmap.hashCode() + s.getAndIncrement());
    localObject = ((StringBuilder)localObject).toString();
    ir localir = this.h;
    if (localir != null) {
      localir.a((String)localObject, new Bitmap[] { paramBitmap });
    }
  }
  
  private static void a(ViewGroup paramViewGroup, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramViewGroup.setBackgroundDrawable(null);
    }
    paramString = fy.b(paramViewGroup.getContext(), paramString);
    if (paramString != null)
    {
      byte[] arrayOfByte = paramString.getNinePatchChunk();
      paramViewGroup.setBackgroundDrawable(new NinePatchDrawable(paramViewGroup.getContext().getResources(), paramString, arrayOfByte, new Rect(10, 10, 10, 30), null));
    }
  }
  
  private static void a(LinearLayout paramLinearLayout, String paramString1, String paramString2)
  {
    if (paramLinearLayout != null)
    {
      if (paramLinearLayout.getContext() == null) {
        return;
      }
      Context localContext = paramLinearLayout.getContext();
      TextView localTextView = (TextView)paramLinearLayout.findViewWithTag(paramString1);
      if (TextUtils.isEmpty(paramString2))
      {
        if (localTextView != null) {
          paramLinearLayout.removeView(localTextView);
        }
      }
      else
      {
        Object localObject = localTextView;
        if (localTextView == null)
        {
          localObject = new pc(localContext);
          ((TextView)localObject).setTag(paramString1);
          ((TextView)localObject).setGravity(3);
          ((TextView)localObject).setTextColor(-16777216);
          paramLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-2, -2));
        }
        ((TextView)localObject).setText(paramString2);
      }
    }
  }
  
  private is b(MarkerOptions paramMarkerOptions)
  {
    int i1 = paramMarkerOptions.getInfoWindowOffsetX();
    int i2 = paramMarkerOptions.getInfowindowOffsetY();
    l();
    n();
    float f1 = this.q;
    float f2 = i1 * 1.0F / this.j;
    float f3 = this.r;
    float f4 = i2 * 1.0F / this.k;
    is localis = new is();
    localis.a = fz.a(paramMarkerOptions.getPosition());
    localis.e = paramMarkerOptions.getAlpha();
    localis = localis.a(f1 - f2, f3 - f4);
    localis.f = false;
    localis.j = ((int)paramMarkerOptions.getZIndex());
    localis.k = paramMarkerOptions.getLevel();
    localis.l = this.p;
    localis.m = true;
    return localis;
  }
  
  private void k()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      if (((pt)localObject).ay == null) {
        return;
      }
      localObject = null;
      lq locallq = this.n;
      if (locallq != null) {
        localObject = locallq.e;
      }
      this.u = a(this.m.ay, this, (TencentMap.InfoWindowAdapter)localObject, this.o);
      localObject = this.u;
      if (localObject != null)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.j = this.u.getMeasuredWidth();
        this.k = this.u.getMeasuredHeight();
        localObject = this.u;
        ((View)localObject).layout(0, 0, ((View)localObject).getMeasuredWidth(), this.u.getMeasuredHeight());
      }
    }
  }
  
  private void l()
  {
    if (this.o != null)
    {
      if (this.m.ay == null) {
        return;
      }
      int i3 = this.o.getWidth(this.m.ay);
      float f;
      if (this.o.getOptions() != null) {
        f = this.o.getOptions().getInfoWindowAnchorU();
      } else {
        f = 0.5F;
      }
      int i2 = this.j;
      int i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      this.q = (f + i3 * (this.o.getAnchorU() - 0.5F) / i1);
    }
  }
  
  private void n()
  {
    if (this.o != null)
    {
      if (this.m.ay == null) {
        return;
      }
      int i3 = (int)(this.o.getHeight(this.m.ay) * this.o.getAnchorV());
      int i2 = this.k;
      float f1 = 1.0F;
      if (this.o.getOptions() != null) {
        f1 = this.o.getOptions().getInfoWindowAnchorV();
      }
      int i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      float f2 = i3;
      float f3 = i1;
      this.r = ((f2 + f1 * f3) / f3);
    }
  }
  
  public final Rect a(fu paramfu)
  {
    ir localir = this.h;
    if (localir == null) {
      return null;
    }
    return localir.a(paramfu);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.h != null)
    {
      b(true);
      GeoPoint localGeoPoint = new GeoPoint(paramInt2, paramInt1);
      this.h.a(localGeoPoint);
    }
  }
  
  public final void a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return;
    }
    GeoPoint localGeoPoint = this.l;
    if (localGeoPoint == null)
    {
      this.l = fz.a(paramLatLng);
    }
    else
    {
      localGeoPoint.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
      this.l.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
    }
    paramLatLng = this.h;
    if (paramLatLng != null) {
      paramLatLng.a(this.l);
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions)
  {
    if (paramMarkerOptions != null)
    {
      if (this.h == null) {
        return;
      }
      this.e = paramMarkerOptions.isVisible();
      d(paramMarkerOptions.getLevel());
      k();
      paramMarkerOptions = b(paramMarkerOptions);
      if (paramMarkerOptions == null) {
        return;
      }
      this.h.a(paramMarkerOptions);
      a(fy.a(this.u));
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (!this.e) {
      return;
    }
    ir localir = this.h;
    if (localir != null) {
      localir.a(paramGL10);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
    pn localpn = this.m;
    if ((localpn != null) && (localpn.az != null)) {
      this.m.az.b.k();
    }
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    ir localir = this.h;
    if (localir == null) {
      return false;
    }
    return localir.a(paramFloat1, paramFloat2);
  }
  
  public final void a_()
  {
    Object localObject = this.o;
    int i2 = 0;
    int i1;
    if ((localObject != null) && (((Marker)localObject).getOptions() != null))
    {
      i2 = this.o.getOptions().getInfoWindowOffsetX();
      i1 = this.o.getOptions().getInfowindowOffsetY();
    }
    else
    {
      i1 = 0;
    }
    l();
    n();
    float f1 = this.q;
    float f2 = i2 * 1.0F / this.j;
    float f3 = this.r;
    float f4 = i1 * 1.0F / this.k;
    localObject = this.h;
    if (localObject != null) {
      ((ir)localObject).b(f1 - f2, f3 - f4);
    }
  }
  
  public final Rect b(fu paramfu)
  {
    ir localir = this.h;
    if (localir != null) {
      return localir.b(paramfu);
    }
    return new Rect(0, 0, 0, 0);
  }
  
  public final void b()
  {
    c();
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    ir localir = this.h;
    if (localir != null) {
      localir.a(paramBoolean);
    }
  }
  
  public final void c()
  {
    Bitmap localBitmap = this.i;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.i = null;
    }
    this.o = null;
    this.m = null;
  }
  
  public final void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void d() {}
  
  public final boolean e()
  {
    return (this.t) && (this.i != null);
  }
  
  public final void f()
  {
    Marker localMarker = this.o;
    if (localMarker == null) {
      return;
    }
    a(localMarker.getOptions());
  }
  
  public final View g()
  {
    return this.u;
  }
  
  public final void h()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mr
 * JD-Core Version:    0.7.0.1
 */