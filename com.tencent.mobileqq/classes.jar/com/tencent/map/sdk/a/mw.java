package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.core.functions.animation.GlAlphaAnimation;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.core.functions.animation.GlAnimation.SetAnimatePropertyListener;
import com.tencent.map.core.functions.animation.GlEmergeAnimation;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.OverlayLevel;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.ColorType;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions.Text;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class mw
  extends mu
{
  private static final int[] I = { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 3500, 2000, 1500, 1000, 720, 500, 320, 160, 80 };
  private BitmapDescriptor A = null;
  private int B = 12;
  private GlAnimation C;
  private float D;
  private mw.a E = null;
  private float F = 1.0F;
  private int G = 0;
  private boolean H = true;
  private float J = 0.0F;
  private boolean K = false;
  private String O;
  private int P = -1;
  private List<Integer> Q;
  private int R = 0;
  private final String S;
  private final float T;
  private GlAnimation.SetAnimatePropertyListener U;
  public ip h = null;
  public Polyline i = null;
  protected byte[] j = new byte[0];
  public pn k = null;
  public boolean l = false;
  public int[] m = null;
  public int[] n = null;
  public PolylineOptions.Text o;
  public boolean p = false;
  public boolean q = false;
  public int r = -1;
  public GeoPoint s = null;
  private iq t = null;
  private ArrayList<mw.a> u = null;
  private ArrayList<GeoPoint> v = null;
  private float w;
  private int[] x = null;
  private int y = -7829368;
  private PolylineOptions.ColorType z;
  
  public mw(pn parampn)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.L);
    localStringBuilder.append("_arrow_texture_");
    this.S = localStringBuilder.toString();
    this.U = new mw.1(this);
    this.k = parampn;
    this.u = new ArrayList();
    this.T = this.k.ay.getResources().getDisplayMetrics().density;
  }
  
  private static float a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (paramGeoPoint2 != null)
    {
      int i1 = paramGeoPoint1.getLatitudeE6();
      int i2 = paramGeoPoint2.getLatitudeE6();
      int i3 = paramGeoPoint1.getLongitudeE6();
      int i4 = paramGeoPoint2.getLongitudeE6();
      return (float)(Math.hypot(i1 - i2, i3 - i4) + 0.0D);
    }
    return 0.0F;
  }
  
  private static float a(mw.a parama1, mw.a parama2, GeoPoint paramGeoPoint, mw.a parama3)
  {
    int i1 = parama1.getLongitudeE6();
    int i2 = parama1.getLatitudeE6();
    int i3 = parama2.getLongitudeE6();
    int i4 = parama2.getLatitudeE6();
    int i5 = paramGeoPoint.getLongitudeE6();
    int i6 = paramGeoPoint.getLatitudeE6();
    int i7 = i3 - i1;
    int i8 = i5 - i1;
    int i9 = i4 - i2;
    int i10 = i6 - i2;
    float f1 = i7 * i8 + i9 * i10;
    double d1;
    if (f1 <= 0.0F)
    {
      parama3.setLatitudeE6(parama1.getLatitudeE6());
      parama3.setLongitudeE6(parama1.getLongitudeE6());
      parama3.a = parama1.a;
      d1 = Math.hypot(i8, i10);
    }
    for (;;)
    {
      return (float)d1;
      d1 = i7 * i7 + i9 * i9;
      double d2 = f1;
      if (d2 >= d1)
      {
        parama3.setLatitudeE6(parama2.getLatitudeE6());
        parama3.setLongitudeE6(parama2.getLongitudeE6());
        parama3.a = parama2.a;
        d1 = Math.hypot(i5 - i3, i6 - i4);
      }
      else
      {
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d2 / d1);
        float f2 = i1 + i7 * f1;
        float f3 = i2 + i9 * f1;
        parama3.setLongitudeE6(Math.round(f2));
        parama3.setLatitudeE6(Math.round(f3));
        parama1.a += (parama2.a - parama1.a) * f1;
        d1 = Math.hypot(i5 - f2, i6 - f3);
      }
    }
  }
  
  private int a(int paramInt)
  {
    int i2 = this.B;
    int i1 = paramInt;
    if (paramInt >= i2) {
      i1 = i2 - 1;
    }
    paramInt = i1;
    if (i1 < 0) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  private static int a(Context paramContext, BitmapDescriptor paramBitmapDescriptor)
  {
    if (paramContext != null)
    {
      if (paramBitmapDescriptor == null) {
        return 0;
      }
      paramBitmapDescriptor = paramBitmapDescriptor.getBitmap(paramContext);
      if (paramBitmapDescriptor == null) {
        return 0;
      }
      int i1 = paramBitmapDescriptor.getHeight();
      if (i1 <= 0) {
        return 0;
      }
      float f = pz.a(paramContext);
      double d1 = Math.pow(2.0D, 25.0D) / Math.pow(i1, 2.0D);
      double d2 = f;
      Double.isNaN(d2);
      return (int)(d1 / d2);
    }
    return 0;
  }
  
  private mw.a a(GeoPoint paramGeoPoint)
  {
    Object localObject1 = new mw.a();
    Object localObject5 = this.u;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = localObject4;
    if (localObject5 != null)
    {
      localObject3 = localObject4;
      if (((ArrayList)localObject5).size() >= 2)
      {
        localObject3 = localObject4;
        if (paramGeoPoint != null)
        {
          localObject4 = (mw.a)this.u.get(0);
          int i1 = 1;
          float f2;
          for (float f1 = 3.4028235E+38F;; f1 = f2)
          {
            localObject3 = localObject2;
            if (i1 >= this.u.size()) {
              break;
            }
            localObject5 = (mw.a)this.u.get(i1);
            float f3 = a((mw.a)localObject4, (mw.a)localObject5, paramGeoPoint, (mw.a)localObject1);
            localObject3 = localObject1;
            f2 = f1;
            if (f3 < f1)
            {
              localObject3 = new mw.a();
              f2 = f3;
              localObject2 = localObject1;
            }
            i1 += 1;
            localObject4 = localObject5;
            localObject1 = localObject3;
          }
        }
      }
    }
    return localObject3;
  }
  
  private static mw.a a(mw.a parama1, mw.a parama2, float paramFloat)
  {
    mw.a locala = new mw.a();
    int i1 = parama2.getLongitudeE6();
    int i2 = parama1.getLongitudeE6();
    int i3 = parama2.getLatitudeE6();
    int i4 = parama1.getLatitudeE6();
    locala.setLatitudeE6(parama1.getLatitudeE6() + Math.round((i3 - i4) * paramFloat));
    locala.setLongitudeE6(parama1.getLongitudeE6() + Math.round((i1 - i2) * paramFloat));
    parama1.a += (parama2.a - parama1.a) * paramFloat;
    return locala;
  }
  
  private PolylineOptions.ColorType a(PolylineOptions.ColorType paramColorType)
  {
    if (paramColorType != PolylineOptions.ColorType.LINE_COLOR_NONE) {
      return paramColorType;
    }
    paramColorType = this.m;
    if ((paramColorType != null) && (paramColorType.length > 0))
    {
      int i1 = 0;
      int i2 = paramColorType.length;
      while (i1 < i2)
      {
        paramColorType = this.m;
        if ((paramColorType[i1] >= 0) && (paramColorType[i1] < this.B)) {
          i1 += 1;
        } else {
          return PolylineOptions.ColorType.LINE_COLOR_ARGB;
        }
      }
      return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }
    if ((this.c >= 0) && (this.c < this.B)) {
      return PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }
    return PolylineOptions.ColorType.LINE_COLOR_ARGB;
  }
  
  private void a(GlAlphaAnimation paramGlAlphaAnimation)
  {
    this.C = paramGlAlphaAnimation;
    this.C.setAnimationProperty(this.U);
    this.C.startAnimation(null, null);
    paramGlAlphaAnimation = this.k;
    if ((paramGlAlphaAnimation != null) && (paramGlAlphaAnimation.az != null)) {
      this.k.az.b.k();
    }
  }
  
  private void a(GlEmergeAnimation paramGlEmergeAnimation)
  {
    pn localpn = this.k;
    if (localpn != null)
    {
      if (localpn.az == null) {
        return;
      }
      this.C = paramGlEmergeAnimation;
      this.E = a(fz.a(paramGlEmergeAnimation.getStartPoint()));
      if (this.E != null)
      {
        paramGlEmergeAnimation.setAnimationProperty(this.U);
        paramGlEmergeAnimation.startAnimation(null, null);
        this.k.az.b.k();
        return;
      }
      throw new RuntimeException("Error, start point not found.");
    }
  }
  
  private int[][] b(List<GeoPoint> paramList)
  {
    Object localObject1 = this.m;
    Object localObject2 = Integer.valueOf(0);
    if (localObject1 != null)
    {
      Object localObject3 = this.n;
      if ((localObject3 != null) && (paramList != null) && (localObject1.length != 0) && (localObject3.length != 0) && (!paramList.isEmpty()))
      {
        localObject1 = this.m;
        if (localObject1 != null)
        {
          localObject3 = this.n;
          if (localObject3 != null)
          {
            i2 = Math.min(localObject1.length, localObject3.length);
            break label93;
          }
        }
        i2 = 0;
        label93:
        int[] arrayOfInt = new int[i2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfInt[i1] = this.m[i1];
          if (this.z == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
            arrayOfInt[i1] = a(arrayOfInt[i1]);
          }
          i1 += 1;
        }
        localObject3 = new TreeMap();
        localObject1 = (mw.a)paramList.get(0);
        i1 = 1;
        while (i1 < i2)
        {
          if (((mw.a)localObject1).b <= this.n[i1])
          {
            ((Map)localObject3).put(localObject2, Integer.valueOf(arrayOfInt[(i1 - 1)]));
            i4 = i1;
            break label221;
          }
          i1 += 1;
        }
        int i4 = 0;
        label221:
        int i3 = i4;
        if (i1 == i2)
        {
          i3 = i4;
          if (((Map)localObject3).size() == 0)
          {
            ((Map)localObject3).put(localObject2, Integer.valueOf(arrayOfInt[(i2 - 1)]));
            i3 = i2;
          }
        }
        i4 = 1;
        for (i1 = i3; i4 < paramList.size(); i1 = i3)
        {
          localObject2 = (mw.a)paramList.get(i4);
          i3 = i1;
          while ((i1 < i2) && (((mw.a)localObject2).b > this.n[i1]) && (((mw.a)localObject1).b <= this.n[i1]))
          {
            ((Map)localObject3).put(Integer.valueOf(i4 - 1), Integer.valueOf(arrayOfInt[i1]));
            i3 += 1;
            i1 += 1;
          }
          i4 += 1;
          localObject1 = localObject2;
        }
        paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, ((Map)localObject3).size() });
        localObject1 = ((Map)localObject3).entrySet().iterator();
        i1 = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramList[0][i1] = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
          paramList[1][i1] = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
          i1 += 1;
        }
        return paramList;
      }
    }
    int i2 = this.c;
    int i1 = i2;
    if (this.z == PolylineOptions.ColorType.LINE_COLOR_TEXTURE) {
      i1 = a(i2);
    }
    paramList = (int[][])Array.newInstance(Integer.TYPE, new int[] { 2, 1 });
    paramList[0][0] = i1;
    paramList[1][0] = 0;
    return paramList;
  }
  
  private void f()
  {
    Object localObject1 = this.k;
    if ((localObject1 != null) && (((pt)localObject1).aA != null))
    {
      localObject1 = this.k.aA.a;
      if (localObject1 == null) {
        return;
      }
      if (this.o == null)
      {
        localObject2 = this.t;
        if (localObject2 != null)
        {
          ((iq)localObject2).a();
          this.t = null;
          return;
        }
      }
      Object localObject2 = this.o;
      if (localObject2 != null)
      {
        iq localiq = this.t;
        if (localiq == null)
        {
          localObject2 = this.v;
          if (localObject2 != null)
          {
            if (((ArrayList)localObject2).size() < 2) {
              return;
            }
            localObject2 = this.v;
            this.t = new iq((pf)localObject1, (GeoPoint[])((ArrayList)localObject2).toArray(new GeoPoint[((ArrayList)localObject2).size()]), this.o);
          }
          return;
        }
        localiq.a((PolylineOptions.Text)localObject2);
      }
    }
  }
  
  private hi g()
  {
    Object localObject1 = this.k;
    if ((localObject1 != null) && (((pt)localObject1).az != null))
    {
      localObject1 = new hi();
      Object localObject2 = this.A;
      if ((localObject2 != null) && (((BitmapDescriptor)localObject2).getFormater() != null)) {
        ((hi)localObject1).k = this.A.getFormater().g;
      }
      localObject2 = b(this.v);
      ((hi)localObject1).i = this.l;
      ((hi)localObject1).u = this.P;
      ((hi)localObject1).a(this.v);
      ((hi)localObject1).z = this.y;
      int i1;
      if (this.G == 0)
      {
        i1 = a(this.k.ay, this.A);
        if (i1 > 0)
        {
          float f2 = this.a;
          float f1 = i1;
          if (f2 <= f1) {
            f1 = this.a;
          }
          ((hi)localObject1).j = f1;
        }
        else
        {
          ((hi)localObject1).j = this.a;
        }
      }
      else
      {
        ((hi)localObject1).j = this.a;
      }
      if (this.z == PolylineOptions.ColorType.LINE_COLOR_ARGB)
      {
        ((hi)localObject1).h = true;
        if (this.w * 2.0F > this.a) {
          this.w = (this.a / 3.0F);
        }
        ((hi)localObject1).g = this.w;
      }
      int[] arrayOfInt = this.x;
      if (this.H)
      {
        ((hi)localObject1).a(localObject2[1]);
        if ((this.w > 0.0F) && (arrayOfInt != null) && (arrayOfInt.length > 0)) {
          ((hi)localObject1).a(localObject2[0], arrayOfInt);
        } else {
          ((hi)localObject1).b(localObject2[0]);
        }
      }
      else
      {
        ((hi)localObject1).a(new int[] { 0 });
        if ((this.w > 0.0F) && (arrayOfInt != null) && (arrayOfInt.length > 0))
        {
          i1 = this.c;
          int i2 = arrayOfInt[0];
          ((hi)localObject1).a(new int[] { i1 }, new int[] { i2 });
        }
        else
        {
          ((hi)localObject1).b(new int[] { this.c });
        }
      }
      ((hi)localObject1).m = this.D;
      ((hi)localObject1).o = this.G;
      ((hi)localObject1).s = ((int)this.d);
      ((hi)localObject1).p = this.p;
      ((hi)localObject1).q = this.q;
      ((hi)localObject1).l = this.K;
      ((hi)localObject1).n = this.H;
      ((hi)localObject1).t = this.O;
      ((hi)localObject1).b(this.Q);
      ((hi)localObject1).y = this.g;
      return localObject1;
    }
    return null;
  }
  
  public final void a(GlAnimation paramGlAnimation)
  {
    GlAnimation localGlAnimation = this.C;
    if (localGlAnimation != null)
    {
      localGlAnimation.stopAnimation();
      this.C.setAnimationProperty(null);
    }
    if ((paramGlAnimation instanceof GlEmergeAnimation))
    {
      a((GlEmergeAnimation)paramGlAnimation);
      return;
    }
    if ((paramGlAnimation instanceof GlAlphaAnimation))
    {
      a((GlAlphaAnimation)paramGlAnimation);
      return;
    }
    this.C = null;
  }
  
  public final void a(BitmapDescriptor paramBitmapDescriptor)
  {
    pn localpn = this.k;
    if ((localpn != null) && (localpn.az != null) && (paramBitmapDescriptor != null))
    {
      if (paramBitmapDescriptor.getFormater() == null) {
        return;
      }
      this.A = paramBitmapDescriptor;
      paramBitmapDescriptor = this.A.getBitmap(this.k.ay);
      oi.a(this.A.getFormater().g, paramBitmapDescriptor);
      this.z = PolylineOptions.ColorType.LINE_COLOR_TEXTURE;
    }
  }
  
  public final void a(PolylineOptions paramPolylineOptions)
  {
    Object localObject1 = this.k;
    if ((localObject1 != null) && (((pt)localObject1).az != null))
    {
      if (paramPolylineOptions == null) {
        return;
      }
      if (paramPolylineOptions.getWidth() == -1.0F) {
        a(this.T * 9.0F);
      } else {
        a(paramPolylineOptions.getWidth());
      }
      super.b(paramPolylineOptions.getColor());
      b(paramPolylineOptions.getZIndex());
      c(paramPolylineOptions.isVisible());
      this.D = paramPolylineOptions.getAlpha();
      this.l = paramPolylineOptions.isArrow();
      a(paramPolylineOptions.getColorTexture());
      this.K = paramPolylineOptions.getLineCap();
      this.Q = paramPolylineOptions.getPattern();
      this.w = paramPolylineOptions.getBorderWidth();
      this.x = paramPolylineOptions.getBorderColors();
      this.N = paramPolylineOptions.getIndoorInfo();
      this.G = paramPolylineOptions.getLineType();
      this.g = paramPolylineOptions.getLevel();
      this.y = paramPolylineOptions.getEraseColor();
      if ((paramPolylineOptions.isAbovePillar()) && (this.g == OverlayLevel.OverlayLevelAboveRoads)) {
        this.g = OverlayLevel.OverlayLevelAboveLabels;
      }
      a(paramPolylineOptions.getPoints());
      if (paramPolylineOptions.getArrowTexture() != null)
      {
        localObject1 = paramPolylineOptions.getArrowTexture().getBitmap(this.k.ay);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.S);
        ((StringBuilder)localObject2).append(this.R);
        oi.b(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.S);
        int i1 = this.R + 1;
        this.R = i1;
        ((StringBuilder)localObject2).append(i1);
        localObject2 = ((StringBuilder)localObject2).toString();
        oi.a((String)localObject2, (Bitmap)localObject1);
        this.O = ((String)localObject2);
      }
      this.P = paramPolylineOptions.getArrowSpacing();
      this.H = paramPolylineOptions.isRoad();
      localObject1 = paramPolylineOptions.getAnimation();
      if (localObject1 != null) {
        a(((Animation)localObject1).glAnimation);
      }
      Object localObject2 = paramPolylineOptions.getColors();
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        localObject1 = localObject2[0];
        localObject2 = localObject2[1];
        if ((localObject1 != null) && (localObject2 != null) && (localObject1.length == localObject2.length)) {
          a((int[])localObject1, (int[])localObject2);
        }
      }
      this.z = a(paramPolylineOptions.getColorType());
      this.o = paramPolylineOptions.getText();
      e();
    }
  }
  
  public final void a(List<LatLng> paramList)
  {
    this.J = 0.0F;
    this.u.clear();
    if (paramList == null) {
      return;
    }
    int i2 = paramList.size();
    if (i2 <= 0) {
      return;
    }
    Object localObject1 = null;
    this.v = new ArrayList();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject3 = (LatLng)paramList.get(i1);
      Object localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject3 = fz.a((LatLng)localObject3);
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = new mw.a((GeoPoint)localObject3);
          this.v.add(localObject2);
          if (localObject1 != null)
          {
            this.J += a((GeoPoint)localObject2, (GeoPoint)localObject1);
            ((mw.a)localObject2).a = this.J;
            ((mw.a)localObject1).b += 1;
          }
          this.u.add(localObject2);
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
  }
  
  public final void a(GL10 paramGL10)
  {
    if (!a()) {
      return;
    }
    paramGL10 = this.k;
    if (paramGL10 != null)
    {
      if (paramGL10.az == null) {
        return;
      }
      paramGL10 = this.C;
      if ((paramGL10 != null) && (paramGL10.isStarted()))
      {
        this.C.drawAnimation();
        paramGL10 = this.C;
        if ((paramGL10 instanceof GlEmergeAnimation))
        {
          ArrayList localArrayList2 = this.u;
          ArrayList localArrayList1 = new ArrayList();
          if ((localArrayList2 != null) && (localArrayList2.size() >= 2))
          {
            float f2 = this.E.a;
            float f3 = this.J;
            float f4 = this.E.a;
            float f5 = this.F;
            float f1 = f2 - f2 * f5;
            f2 += (f3 - f4) * f5;
            int i1 = 0;
            mw.a locala1;
            for (paramGL10 = null; i1 < localArrayList2.size(); paramGL10 = locala1)
            {
              locala1 = (mw.a)localArrayList2.get(i1);
              if ((locala1.a > f1) && (locala1.a < f2))
              {
                if ((paramGL10 != null) && (paramGL10.a < f1))
                {
                  f3 = locala1.a;
                  f4 = paramGL10.a;
                  mw.a locala2 = a(paramGL10, locala1, (f1 - paramGL10.a) / (f3 - f4));
                  locala2.b = paramGL10.b;
                  localArrayList1.add(locala2);
                }
                localArrayList1.add(locala1);
              }
              else
              {
                if (locala1.a > f2)
                {
                  if ((paramGL10 == null) || (paramGL10.a >= f2)) {
                    break;
                  }
                  f1 = locala1.a;
                  f3 = paramGL10.a;
                  paramGL10 = a(paramGL10, locala1, (f2 - paramGL10.a) / (f1 - f3));
                  paramGL10.b = locala1.b;
                  localArrayList1.add(paramGL10);
                  break;
                }
                if ((Float.compare(locala1.a, f1) == 0) || (Float.compare(locala1.a, f2) == 0)) {
                  localArrayList1.add(locala1);
                }
              }
              i1 += 1;
            }
          }
          this.v = localArrayList1;
          if (this.v.size() >= 2) {
            e();
          }
        }
        else if ((paramGL10 instanceof GlAlphaAnimation))
        {
          e();
        }
        this.k.az.b.k();
        if (this.C.isEnded())
        {
          this.C.setAnimationProperty(null);
          this.C = null;
        }
      }
    }
  }
  
  public final void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.m = paramArrayOfInt1;
    this.n = paramArrayOfInt2;
    this.z = a(PolylineOptions.ColorType.LINE_COLOR_NONE);
  }
  
  public final boolean a()
  {
    if (q() != null) {
      return (this.e) && (this.M);
    }
    return this.e;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.k;
    if ((localObject != null) && (((pt)localObject).az != null))
    {
      if (!a()) {
        return false;
      }
      localObject = this.h;
      if (localObject != null) {
        return ((ip)localObject).a(paramFloat1, paramFloat2);
      }
    }
    return false;
  }
  
  public final void b()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((pt)localObject).az != null) && (this.h != null))
    {
      this.k.az.b(this.h);
      this.h = null;
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((iq)localObject).a();
      this.t = null;
    }
    localObject = this.u;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.u = null;
    }
    localObject = this.v;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.v = null;
    }
    oi.b(this.O);
    localObject = this.A;
    if ((localObject != null) && (((BitmapDescriptor)localObject).getFormater() != null)) {
      oi.b(this.A.getFormater().g);
    }
  }
  
  public final void b(int paramInt)
  {
    super.b(paramInt);
  }
  
  public final void c() {}
  
  public final void d()
  {
    e();
  }
  
  public final void e()
  {
    Object localObject = this.k;
    if (localObject != null)
    {
      if (((pt)localObject).az == null) {
        return;
      }
      if (!a())
      {
        if (this.h != null)
        {
          this.k.az.b(this.h);
          this.h.g = -1;
          this.h = null;
        }
        return;
      }
      localObject = this.v;
      if (localObject != null)
      {
        if (((ArrayList)localObject).size() < 2) {
          return;
        }
        localObject = this.h;
        if (localObject == null)
        {
          this.h = new ip(this.k.az.b.f, g());
          this.k.az.a(this.h);
        }
        else
        {
          ((ip)localObject).a(g());
        }
        this.h.a(this.r, this.s);
        f();
        this.k.az.b.k();
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof mw)) {
      return false;
    }
    paramObject = (mw)paramObject;
    return TextUtils.equals(this.L, paramObject.L);
  }
  
  public final void h()
  {
    b();
  }
  
  public int hashCode()
  {
    return this.L.hashCode();
  }
  
  public final boolean m()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.mw
 * JD-Core Version:    0.7.0.1
 */