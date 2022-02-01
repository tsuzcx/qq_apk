package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.tencentmap.mapsdk.maps.model.BubbleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;

final class lj$a
{
  BubbleOptions a = null;
  int b = 0;
  ir c = null;
  private Bitmap[] e = new Bitmap[4];
  
  public lj$a(lj paramlj, BubbleOptions paramBubbleOptions, int paramInt)
  {
    this.a = paramBubbleOptions;
    this.b = paramInt;
    this.e[0] = a(lj.a(this.d), lj.b.a);
    this.e[1] = a(lj.a(this.d), lj.b.b);
    this.e[2] = a(lj.a(this.d), lj.b.c);
    this.e[3] = a(lj.a(this.d), lj.b.d);
    if (this.a != null) {
      this.c = new ir(lj.b(this.d).az.b.f, new is().a(0.5F, 0.5F).a(a(lj.b.a), new Bitmap[] { this.e[0] }));
    }
  }
  
  private Bitmap a(Context paramContext, int paramInt)
  {
    paramContext = b(paramContext, paramInt);
    paramContext.measure(0, 0);
    paramInt = paramContext.getMeasuredWidth();
    int i = paramContext.getMeasuredHeight();
    paramContext.layout(0, 0, paramInt, i);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
    localBitmap.eraseColor(0);
    paramContext.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  private View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    paramContext = new pc(paramContext);
    paramContext.setGravity(17);
    paramContext.setPadding(30, 30, 30, 30);
    paramContext.setId(100);
    paramContext.setTextSize(14.0F);
    paramContext.setTextColor(-16777216);
    paramContext.setText(this.a.getContent());
    localLinearLayout.addView(paramContext, new LinearLayout.LayoutParams(-2, -2));
    return paramContext;
  }
  
  private String a(int paramInt)
  {
    String str = toString();
    if (paramInt == lj.b.a) {
      return "b_lt_".concat(String.valueOf(str));
    }
    if (paramInt == lj.b.b) {
      return "b_rt_".concat(String.valueOf(str));
    }
    if (paramInt == lj.b.c) {
      return "b_rb_".concat(String.valueOf(str));
    }
    return "b_lb_".concat(String.valueOf(str));
  }
  
  private View b(Context paramContext, int paramInt)
  {
    Object localObject2 = this.a.getBackground();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length >= 4) {}
    }
    else
    {
      localObject1 = lj.c(this.d);
    }
    View localView = this.a.getContentView();
    localObject2 = localView;
    if (localView == null) {
      localObject2 = a(paramContext);
    }
    ((View)localObject2).setBackgroundDrawable(localObject1[(paramInt - 1)]);
    return localObject2;
  }
  
  public final int a()
  {
    BubbleOptions localBubbleOptions = this.a;
    if (localBubbleOptions == null) {
      return 0;
    }
    return localBubbleOptions.getDisplayLevel();
  }
  
  public final ir a(fu paramfu, int paramInt)
  {
    Marker localMarker = this.a.getMarker();
    Object localObject2 = this.a.getPosition();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localMarker.getPosition();
    }
    if (localObject1 == null) {
      return null;
    }
    localObject1 = paramfu.a(lj.a((LatLng)localObject1));
    if (localMarker != null)
    {
      j = localMarker.getWidth(lj.a(this.d));
      i = localMarker.getHeight(lj.a(this.d));
    }
    else
    {
      j = this.a.getMarkerWidth();
      i = this.a.getMarkerHeight();
    }
    float f2;
    float f1;
    if (localMarker != null)
    {
      f2 = localMarker.getAnchorU();
      f1 = localMarker.getAnchorV();
    }
    else
    {
      f2 = this.a.getMarkerAnchorU();
      f1 = this.a.getMarkerAnchorV();
    }
    double d1;
    double d2;
    if ((f2 >= 0.0F) && (f2 <= 1.0F))
    {
      d1 = f2;
      Double.isNaN(d1);
      d2 = j;
      Double.isNaN(d2);
      ((DoublePoint)localObject1).x -= (d1 - 0.5D) * d2;
    }
    if ((f1 >= 0.0F) && (f1 <= 1.0F))
    {
      d1 = f1;
      Double.isNaN(d1);
      d2 = i;
      Double.isNaN(d2);
      ((DoublePoint)localObject1).y -= (d1 - 0.5D) * d2;
    }
    localObject2 = this.e[(paramInt - 1)];
    int j = ((Bitmap)localObject2).getWidth() / 2;
    int i = ((Bitmap)localObject2).getHeight() / 2 + i / 2;
    double d3;
    if (paramInt == lj.b.a)
    {
      d1 = ((DoublePoint)localObject1).x;
      d2 = j;
      Double.isNaN(d2);
      d1 -= d2;
      d2 = ((DoublePoint)localObject1).y;
      d3 = i;
      Double.isNaN(d3);
    }
    for (;;)
    {
      d2 -= d3;
      break label491;
      if (paramInt != lj.b.b) {
        break;
      }
      d1 = ((DoublePoint)localObject1).x;
      d2 = j;
      Double.isNaN(d2);
      d1 += d2;
      d2 = ((DoublePoint)localObject1).y;
      d3 = i;
      Double.isNaN(d3);
    }
    if (paramInt == lj.b.c)
    {
      d1 = ((DoublePoint)localObject1).x;
      d2 = j;
      Double.isNaN(d2);
      d1 += d2;
      d2 = ((DoublePoint)localObject1).y;
      d3 = i;
      Double.isNaN(d3);
    }
    else
    {
      d1 = ((DoublePoint)localObject1).x;
      d2 = j;
      Double.isNaN(d2);
      d1 -= d2;
      d2 = ((DoublePoint)localObject1).y;
      d3 = i;
      Double.isNaN(d3);
    }
    d2 += d3;
    label491:
    localObject1 = new DoublePoint(d1, d2);
    this.c.a(paramfu.a((DoublePoint)localObject1));
    this.c.a(a(paramInt), new Bitmap[] { localObject2 });
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.lj.a
 * JD-Core Version:    0.7.0.1
 */