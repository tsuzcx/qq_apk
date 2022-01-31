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
    if ((this.m == null) || (this.o == null) || (this.o.getOptions() == null)) {}
    do
    {
      return;
      k();
      paramlq = this.m.az.b.f;
    } while (paramlq == null);
    this.h = new ir(paramlq, b(this.o.getOptions()));
    or.a("create InfoWindowView:" + this.u);
    a(fy.a(this.u));
  }
  
  static View a(Context paramContext, gj paramgj, TencentMap.InfoWindowAdapter paramInfoWindowAdapter, Marker paramMarker)
  {
    if ((paramContext == null) || (paramgj == null))
    {
      paramgj = null;
      return paramgj;
    }
    String str2;
    String str1;
    if (paramMarker != null)
    {
      str2 = paramMarker.getTitle();
      str1 = paramMarker.getSnippet();
    }
    for (;;)
    {
      if (paramInfoWindowAdapter == null) {
        return a(paramContext, paramgj, str2, str1);
      }
      paramgj = (LinearLayout)paramgj.g();
      if (paramgj == null) {}
      for (paramContext = a(paramContext);; paramContext = paramgj)
      {
        View localView = paramInfoWindowAdapter.getInfoWindow(paramMarker);
        if (localView != null)
        {
          paramgj = paramContext;
          if (localView.getParent() == paramContext) {
            break;
          }
          if ((localView.getParent() instanceof ViewGroup)) {
            ((ViewGroup)localView.getParent()).removeAllViews();
          }
          paramContext.setBackgroundDrawable(null);
          paramContext.removeAllViews();
          paramContext.addView(localView);
          return paramContext;
        }
        paramInfoWindowAdapter = paramInfoWindowAdapter.getInfoContents(paramMarker);
        if (paramInfoWindowAdapter != null)
        {
          paramgj = paramContext;
          if (paramInfoWindowAdapter.getParent() == paramContext) {
            break;
          }
          if ((paramInfoWindowAdapter.getParent() instanceof ViewGroup)) {
            ((ViewGroup)paramInfoWindowAdapter.getParent()).removeAllViews();
          }
          a(paramContext, "marker_infowindow.9.png");
          paramContext.removeAllViews();
          paramContext.addView(paramInfoWindowAdapter);
          return paramContext;
        }
        a(paramContext, "marker_infowindow.9.png");
        paramContext.removeAllViews();
        a(paramContext, "tencent_map_infowindow_content_title", str2);
        a(paramContext, "tencent_map_infowindow_content_snippet", str1);
        return paramContext;
      }
      str1 = "";
      str2 = "";
    }
  }
  
  private static View a(Context paramContext, gj paramgj, String paramString1, String paramString2)
  {
    paramgj = (LinearLayout)paramgj.g();
    if (paramgj == null) {}
    for (paramContext = a(paramContext);; paramContext = paramgj)
    {
      a(paramContext, "marker_infowindow.9.png");
      a(paramContext, "tencent_map_infowindow_content_title", paramString1);
      a(paramContext, "tencent_map_infowindow_content_snippet", paramString2);
      return paramContext;
      paramgj.removeAllViews();
    }
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
    if (paramBitmap == null) {}
    String str;
    do
    {
      return;
      or.a("setBitmapAssist:".concat(String.valueOf(paramBitmap)));
      str = paramBitmap.hashCode() + s.getAndIncrement();
    } while (this.h == null);
    this.h.a(str, new Bitmap[] { paramBitmap });
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
    if ((paramLinearLayout == null) || (paramLinearLayout.getContext() == null)) {}
    Context localContext;
    TextView localTextView;
    do
    {
      return;
      localContext = paramLinearLayout.getContext();
      localTextView = (TextView)paramLinearLayout.findViewWithTag(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        break;
      }
    } while (localTextView == null);
    paramLinearLayout.removeView(localTextView);
    return;
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
    if ((this.m == null) || (this.m.ay == null)) {}
    do
    {
      return;
      TencentMap.InfoWindowAdapter localInfoWindowAdapter = null;
      if (this.n != null) {
        localInfoWindowAdapter = this.n.e;
      }
      this.u = a(this.m.ay, this, localInfoWindowAdapter, this.o);
    } while (this.u == null);
    this.u.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.j = this.u.getMeasuredWidth();
    this.k = this.u.getMeasuredHeight();
    this.u.layout(0, 0, this.u.getMeasuredWidth(), this.u.getMeasuredHeight());
  }
  
  private void l()
  {
    if ((this.o == null) || (this.m.ay == null)) {
      return;
    }
    int i3 = this.o.getWidth(this.m.ay);
    if (this.o.getOptions() != null) {}
    for (float f1 = this.o.getOptions().getInfoWindowAnchorU();; f1 = 0.5F)
    {
      int i2 = this.j;
      int i1 = i2;
      if (i2 == 0) {
        i1 = 1;
      }
      float f2 = i3;
      this.q = (f1 + (this.o.getAnchorU() - 0.5F) * f2 / i1);
      return;
    }
  }
  
  private void n()
  {
    if ((this.o == null) || (this.m.ay == null)) {
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
    this.r = ((f1 * i1 + f2) / i1);
  }
  
  public final Rect a(fu paramfu)
  {
    if (this.h == null) {
      return null;
    }
    return this.h.a(paramfu);
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
    if (paramLatLng == null) {}
    for (;;)
    {
      return;
      if (this.l == null) {
        this.l = fz.a(paramLatLng);
      }
      while (this.h != null)
      {
        this.h.a(this.l);
        return;
        this.l.setLatitudeE6((int)(paramLatLng.latitude * 1000000.0D));
        this.l.setLongitudeE6((int)(paramLatLng.longitude * 1000000.0D));
      }
    }
  }
  
  public final void a(MarkerOptions paramMarkerOptions)
  {
    if ((paramMarkerOptions == null) || (this.h == null)) {}
    do
    {
      return;
      this.e = paramMarkerOptions.isVisible();
      d(paramMarkerOptions.getLevel());
      k();
      paramMarkerOptions = b(paramMarkerOptions);
    } while (paramMarkerOptions == null);
    this.h.a(paramMarkerOptions);
    a(fy.a(this.u));
  }
  
  public final void a(GL10 paramGL10)
  {
    if (!this.e) {}
    while (this.h == null) {
      return;
    }
    this.h.a(paramGL10);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
    if ((this.m != null) && (this.m.az != null)) {
      this.m.az.b.k();
    }
  }
  
  public final boolean a()
  {
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.h == null) {
      return false;
    }
    return this.h.a(paramFloat1, paramFloat2);
  }
  
  public final void a_()
  {
    int i1 = 0;
    int i2;
    if ((this.o != null) && (this.o.getOptions() != null))
    {
      i2 = this.o.getOptions().getInfoWindowOffsetX();
      i1 = this.o.getOptions().getInfowindowOffsetY();
    }
    for (;;)
    {
      l();
      n();
      float f1 = this.q;
      float f2 = i2 * 1.0F / this.j;
      float f3 = this.r;
      float f4 = i1 * 1.0F / this.k;
      if (this.h != null) {
        this.h.b(f1 - f2, f3 - f4);
      }
      return;
      i2 = 0;
    }
  }
  
  public final Rect b(fu paramfu)
  {
    if (this.h != null) {
      return this.h.b(paramfu);
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
    if (this.h != null) {
      this.h.a(paramBoolean);
    }
  }
  
  public final void c()
  {
    if (this.i != null)
    {
      this.i.recycle();
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
    if (this.o == null) {
      return;
    }
    a(this.o.getOptions());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.mr
 * JD-Core Version:    0.7.0.1
 */