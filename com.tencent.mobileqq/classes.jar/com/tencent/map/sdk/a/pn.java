package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.tencent.map.core.functions.animation.GlAnimation;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.map.sdk.engine.jni.models.TappedElement;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.CancelableCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCompassClickedListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnDismissCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnIndoorStateChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLongClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapPoiClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MapPoi;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListenerList;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class pn
  extends pt
  implements TencentMap.OnCameraChangeListener
{
  public TencentMap.OnInfoWindowClickListener A;
  public TencentMap.OnMapPoiClickListener B;
  protected final Handler C;
  public TencentMap.CancelableCallback D;
  public TencentMap.OnCompassClickedListener E;
  public ln.a F;
  public Handler G;
  public ly H;
  public Bitmap.Config I;
  public int J;
  public int K;
  public int L;
  public int M;
  public float N;
  public float O;
  public float P;
  public float Q;
  public boolean R;
  public boolean S;
  public int T;
  public int U;
  protected boolean V;
  protected boolean W;
  protected boolean X;
  protected boolean Y;
  protected boolean Z;
  public final byte[] a = new byte[0];
  private String aI = "";
  private List<mu> aJ;
  private List<mu> aK;
  private List<mu> aL;
  private Map<Class<? extends mu>, mb> aM;
  private List<hc> aN;
  private TencentMap.OnDismissCallback aO;
  private final lh aP;
  private ih aQ;
  private final hb aR;
  private he aS;
  private Comparator<mu> aT;
  private boolean aU;
  private GeoPoint aV;
  private jx aW;
  private float aX;
  private float aY;
  private volatile boolean aZ;
  protected boolean aa;
  public int ab;
  public int ac;
  public Handler ad;
  public boolean ae;
  public boolean af;
  public volatile boolean ag;
  public volatile boolean ah;
  protected int ai;
  public LatLng aj;
  public LatLng ak;
  public int al;
  public int am;
  public int an;
  public int ao;
  public int ap;
  public int aq;
  public int ar;
  public boolean as;
  public ms at;
  public boolean au;
  public hr av;
  public List<ms> aw;
  public List<MapPoi> ax;
  public boolean b = false;
  private boolean ba;
  private int bb;
  private boolean bc;
  private float bd;
  private AtomicBoolean be;
  private final gr bf;
  private fv bg;
  private boolean bh;
  public GlAnimation c;
  public GlAnimation d;
  public GlAnimation e;
  protected volatile IndoorBuilding f;
  public int g;
  public List<mu> h;
  public List<mu> i;
  public lj j;
  public jz k;
  public jd l;
  public jr m;
  public ij n;
  public kj o;
  protected TencentMapGestureListenerList p;
  public AnimationListener q;
  public gw r;
  public TencentMap.OnMapClickListener s;
  public lq.a t;
  public List<TencentMap.OnCameraChangeListener> u;
  public TencentMap.OnMapLongClickListener v;
  volatile boolean w;
  public volatile TencentMap.OnMapLoadedCallback x;
  protected TencentMap.OnIndoorStateChangeListener y;
  public TencentMap.OnMarkerClickListener z;
  
  public pn(IMapRenderView paramIMapRenderView, Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramIMapRenderView, paramContext, paramTencentMapOptions);
    Object localObject = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.g = 22;
    this.h = new ArrayList();
    this.i = new ArrayList();
    this.aJ = new ArrayList();
    this.aK = new ArrayList();
    this.k = null;
    this.l = null;
    this.aL = new ArrayList();
    this.o = null;
    this.p = null;
    this.q = null;
    this.r = null;
    this.aM = new HashMap();
    this.aN = null;
    this.s = null;
    this.t = null;
    this.u = new CopyOnWriteArrayList();
    this.v = null;
    this.w = false;
    this.x = null;
    this.aO = null;
    this.z = null;
    this.A = null;
    this.B = null;
    this.aQ = new pg(this);
    this.D = null;
    this.E = null;
    this.F = null;
    this.aS = new pi(this);
    this.aT = new pn.1(this);
    this.I = Bitmap.Config.RGB_565;
    this.aU = true;
    this.J = -2147483648;
    this.K = -2147483648;
    this.L = -2147483648;
    this.M = -2147483648;
    this.N = 0.5F;
    this.O = 0.5F;
    this.P = 0.5F;
    this.Q = 0.5F;
    this.aV = null;
    this.aW = null;
    this.R = false;
    this.aX = 100.0F;
    this.aY = 100.0F;
    this.S = true;
    this.aZ = false;
    this.ba = false;
    this.bb = 10;
    this.T = 0;
    this.U = 0;
    this.bc = false;
    this.V = true;
    this.W = true;
    this.X = true;
    this.Y = true;
    this.Z = true;
    this.aa = true;
    this.ab = 19;
    this.ac = 3;
    this.bd = 0.0F;
    this.be = new AtomicBoolean(false);
    this.ad = null;
    this.ae = true;
    this.af = true;
    this.ag = false;
    this.ah = false;
    this.ai = 0;
    this.aj = null;
    this.ak = null;
    this.al = 0;
    this.am = 0;
    this.an = 0;
    this.ao = 0;
    this.ap = 0;
    this.aq = 0;
    this.ar = 0;
    this.as = false;
    this.at = null;
    this.au = false;
    this.bh = true;
    this.aw = new ArrayList();
    this.ax = new ArrayList();
    this.C = new pe(this);
    this.aR = new pr(this);
    this.aQ = new pg(this);
    this.bf = new pk(this);
    this.aS = new pi(this);
    this.aP = new ph(this);
    this.aW = new jx();
    jx.a(paramContext);
    this.ab = this.az.c;
    this.ac = this.az.d;
    a(this.bf);
    this.az.a(this.aP);
    this.az.a(this.aS);
    paramContext = this.az;
    paramIMapRenderView = this.aQ;
    paramContext = paramContext.b.c.b;
    paramContext.b = paramIMapRenderView;
    boolean bool = paramIMapRenderView.a();
    if ((paramContext.c != null) && (paramContext.c.get() == null)) {
      if (bool) {
        ((lf)paramContext.c.get()).b(paramContext);
      } else {
        ((lf)paramContext.c.get()).a(paramContext);
      }
    }
    this.az.a(this.aR);
    this.az.a(this);
    if (this.ad == null) {
      this.ad = new Handler();
    }
    paramIMapRenderView = (WindowManager)this.ay.getSystemService("window");
    this.aq = paramIMapRenderView.getDefaultDisplay().getWidth();
    this.ar = paramIMapRenderView.getDefaultDisplay().getHeight();
    paramIMapRenderView = localObject;
    if (paramTencentMapOptions != null)
    {
      paramIMapRenderView = localObject;
      if (!nl.a(paramTencentMapOptions.getSubKey())) {
        paramIMapRenderView = paramTencentMapOptions.getSubKey();
      }
    }
    this.o = new kj(this, paramIMapRenderView);
    this.k = new jz(this);
    if (paramTencentMapOptions != null)
    {
      this.R = paramTencentMapOptions.isHandDrawMapEnable();
      this.as = paramTencentMapOptions.isMultipleInfoWindowEnable();
    }
  }
  
  private boolean a(mu parammu, float paramFloat1, float paramFloat2)
  {
    if ((parammu != null) && (parammu.a()))
    {
      if (!parammu.m()) {
        return false;
      }
      if (!parammu.a(paramFloat1, paramFloat2)) {
        return false;
      }
      mb localmb = (mb)this.aM.get(parammu.getClass());
      if (localmb != null) {
        return localmb.a(parammu, this.az.b.h.a(new DoublePoint(paramFloat1, paramFloat2)));
      }
    }
    return false;
  }
  
  public static boolean a(LatLng paramLatLng, fw[] paramArrayOffw)
  {
    if (paramLatLng == null) {
      return false;
    }
    paramLatLng = kd.b(fz.a(paramLatLng));
    return (paramLatLng.b >= paramArrayOffw[0].b) && (paramLatLng.b <= paramArrayOffw[1].b) && (paramLatLng.a <= paramArrayOffw[0].a) && (paramLatLng.a >= paramArrayOffw[1].a);
  }
  
  private String d(float paramFloat1, float paramFloat2)
  {
    int i1;
    Object localObject3;
    synchronized (this.a)
    {
      i1 = this.h.size() - 1;
      if (i1 >= 0)
      {
        Object localObject1 = (mu)this.h.get(i1);
        if ((localObject1 != null) && (((mu)localObject1).a()) && ((localObject1 instanceof ms)) && (((mu)localObject1).a(paramFloat1, paramFloat2)))
        {
          localObject1 = ((mu)localObject1).L;
          return localObject1;
        }
      }
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if ((paramBoolean) && (!jx.d()))
    {
      this.az.a(null);
      return;
    }
    this.az.a(this.aP);
  }
  
  public final mb a(Class<? extends mu> paramClass)
  {
    return (mb)this.aM.get(paramClass);
  }
  
  public final mu a(String paramString, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    label155:
    synchronized (this.a)
    {
      Iterator localIterator = this.h.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (mu)localIterator.next();
      } while ((localObject1 == null) || (!TextUtils.equals(((mu)localObject1).L, paramString)));
      localIterator.remove();
      if (paramBoolean)
      {
        ((mu)localObject1).h();
        break label155;
        if (localObject1 != null)
        {
          this.i.remove(localObject1);
          this.aJ.remove(localObject1);
          this.aK.remove(localObject1);
        }
        return localObject1;
      }
    }
  }
  
  public final void a()
  {
    Object localObject1 = this.az.b.c;
    Object localObject2;
    if (((kl)localObject1).d != null)
    {
      ((kl)localObject1).k();
      localObject2 = ((kl)localObject1).d.iterator();
      while (((Iterator)localObject2).hasNext()) {
        gv localgv = (gv)((Iterator)localObject2).next();
      }
    }
    ((kl)localObject1).a.c();
    double d1 = ((kl)localObject1).h();
    Double.isNaN(d1);
    double d2 = (0.0D - d1) % 360.0D;
    if (d2 > 180.0D)
    {
      d1 = d2 - 360.0D;
    }
    else
    {
      d1 = d2;
      if (d2 < -180.0D) {
        d1 = d2 + 360.0D;
      }
    }
    d2 = ((kl)localObject1).i();
    Double.isNaN(d2);
    d2 = 0.0D - d2;
    if ((d1 != 0.0D) || (d2 != 0.0D))
    {
      localObject2 = new StringBuilder("postRotateAndSkew distance:");
      ((StringBuilder)localObject2).append(d1);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(d2);
      or.a(((StringBuilder)localObject2).toString());
      long l1 = System.currentTimeMillis();
      float f1 = (float)(d1 * 0.1000000014901161D);
      float f2 = (float)(0.1000000014901161D * d2);
      ((kl)localObject1).a(new kl.2((kl)localObject1, new double[] { 0.0D, 0.0D, 0.0D, 0.0D }, l1, f1, f2, d1, d2));
    }
    localObject1 = this.E;
    if (localObject1 != null) {
      ((TencentMap.OnCompassClickedListener)localObject1).onCompassClicked();
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.bd == paramFloat) {
      return;
    }
    this.bd = paramFloat;
    if (this.r != null)
    {
      hj localhj = new hj();
      localhj.a = 1;
      localhj.d = this.az.c();
      localhj.e = this.az.b.h.a(new Point(0, this.ar / 2), new Point(this.aq, this.ar / 2));
      this.r.a(localhj);
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.aN;
    if (localObject1 != null)
    {
      int i2 = ((List)localObject1).size();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject1 = (hc)this.aN.get(i1);
        if (localObject1 != null) {
          ((hc)localObject1).a(paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    localObject1 = this.a;
    if (localObject1 != null) {
      try
      {
        if (this.h != null)
        {
          Iterator localIterator = this.h.iterator();
          while (localIterator.hasNext()) {
            localIterator.next();
          }
        }
        return;
      }
      finally {}
    }
  }
  
  public final void a(hc paramhc)
  {
    if (this.aN == null) {
      this.aN = new ArrayList();
    }
    if (this.aN.contains(paramhc)) {
      return;
    }
    this.aN.add(paramhc);
  }
  
  public final void a(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    List localList = this.u;
    if ((localList != null) && (paramOnCameraChangeListener != null)) {
      localList.add(paramOnCameraChangeListener);
    }
    boolean bool;
    if (paramOnCameraChangeListener == null) {
      bool = true;
    } else {
      bool = false;
    }
    g(bool);
  }
  
  public final void a(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    this.y = paramOnIndoorStateChangeListener;
  }
  
  public final void a(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (this.p == null) {
      this.p = new TencentMapGestureListenerList();
    }
    this.p.addListener(paramTencentMapGestureListener);
  }
  
  public final void a(Class<? extends mu> paramClass, mb parammb)
  {
    this.aM.put(paramClass, parammb);
  }
  
  public final void a(String paramString)
  {
    synchronized (this.a)
    {
      this.aI = paramString;
      return;
    }
  }
  
  public final void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.a(paramGL10, paramInt1, paramInt2);
    this.aq = paramInt1;
    this.ar = paramInt2;
    d((int)(this.aq * this.N), (int)(this.ar * this.O));
    e((int)(this.aq * this.P), (int)(this.ar * this.Q));
    paramGL10 = this.F;
    if (paramGL10 != null) {
      paramGL10.a();
    }
  }
  
  public final void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    super.a(paramGL10, paramEGLConfig);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.W = paramBoolean;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.t != null)
    {
      localObject = d(paramFloat1, paramFloat2);
      if ((localObject != null) && (((String)localObject).trim().length() != 0))
      {
        this.t.a((String)localObject);
        return true;
      }
    }
    if ((this.v != null) && (this.aa))
    {
      localObject = new DoublePoint(paramFloat1, paramFloat2);
      localObject = fz.a(this.az.b.h.a((DoublePoint)localObject));
      this.v.onMapLongClick((LatLng)localObject);
    }
    return false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    hr localhr = this.av;
    if (localhr != null) {
      return localhr.dispatchHoverEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final boolean a(mu parammu)
  {
    int i1 = 0;
    if (parammu == null) {
      return false;
    }
    int i4;
    int i2;
    int i3;
    int i5;
    synchronized (this.a)
    {
      int i6 = this.h.size();
      i4 = i6;
      i2 = 0;
      if (i1 < i6)
      {
        mu localmu = (mu)this.h.get(i1);
        i3 = i4;
        i5 = i2;
        if (localmu != null)
        {
          i3 = i4;
          i5 = i2;
          if (i2 == 0)
          {
            i3 = i4;
            i5 = i2;
            if (localmu.i() >= parammu.i())
            {
              i3 = i1;
              i5 = 1;
            }
          }
        }
      }
      else
      {
        this.h.add(i4, parammu);
        if ((parammu != null) && (parammu.q() != null))
        {
          if (this.f != null) {
            parammu.a(this.f);
          }
          this.aL.add(parammu);
        }
        if ((parammu instanceof ms))
        {
          this.i.add(parammu);
          Collections.sort(this.i, this.aT);
        }
        else if ((parammu instanceof mw))
        {
          this.aJ.add(parammu);
          Collections.sort(this.aJ, this.aT);
        }
        else
        {
          this.aK.add(parammu);
          Collections.sort(this.aK, this.aT);
        }
        return true;
      }
    }
  }
  
  public final boolean a(GL10 paramGL10)
  {
    int i2;
    Object localObject2;
    int i1;
    int i3;
    Object localObject1;
    Object localObject3;
    label305:
    label576:
    label834:
    synchronized (this.a)
    {
      i2 = this.h.size();
      localObject2 = null;
      i1 = 0;
      if (i1 < i2)
      {
        i3 = i2;
        if (this.h.size() > i2) {
          i3 = this.h.size();
        }
        if (i1 < this.h.size())
        {
          localObject1 = (mu)this.h.get(i1);
          localObject3 = localObject2;
          if (localObject1 == null) {
            break label834;
          }
          if (TextUtils.equals(((mu)localObject1).L, this.aI))
          {
            if ((((mu)localObject1).a()) || (this.bc)) {
              break label830;
            }
            ((mu)localObject1).c();
            localObject3 = localObject2;
            break label834;
          }
          if ((localObject1 instanceof mv))
          {
            ((mv)localObject1).a(this.az.b.h, paramGL10);
            localObject3 = localObject2;
            break label834;
          }
          ((mu)localObject1).a(paramGL10);
          localObject3 = localObject2;
          break label834;
        }
      }
      else
      {
        if (localObject2 != null) {
          ((mu)localObject2).a(paramGL10);
        }
        boolean bool2 = super.a(paramGL10);
        int i4;
        if (((this.G != null) || (!this.w)) && (this.az != null) && (this.az.a))
        {
          localObject1 = this.k;
          if ((localObject1 != null) && (((jz)localObject1).e))
          {
            if (this.aA != null)
            {
              localObject1 = this.aA;
              boolean bool1;
              if (((lw)localObject1).a != null) {
                bool1 = ((lw)localObject1).a.f();
              } else {
                bool1 = false;
              }
              if (bool1)
              {
                i1 = 1;
                break label305;
              }
            }
            i1 = 0;
            if (i1 != 0)
            {
              if (!this.w)
              {
                localObject1 = this.C;
                if (localObject1 != null) {
                  ((Handler)localObject1).sendEmptyMessage(2);
                }
              }
              if (this.G != null)
              {
                if (this.bh)
                {
                  this.bh = false;
                  paramGL10 = this.m;
                  if (paramGL10.r != null)
                  {
                    localObject1 = paramGL10.r.iterator();
                    while (((Iterator)localObject1).hasNext()) {
                      ((gs)((Iterator)localObject1).next()).a(paramGL10);
                    }
                  }
                  t();
                  return bool2;
                }
                if (paramGL10 != null)
                {
                  i3 = this.aq;
                  i4 = this.ar;
                  i1 = i3 * i4;
                  localObject1 = new int[i1];
                  localObject2 = new int[i1];
                  localObject3 = IntBuffer.wrap((int[])localObject1);
                  ((IntBuffer)localObject3).position(0);
                  paramGL10.glReadPixels(0, 0, i3, i4, 6408, 5121, (Buffer)localObject3);
                  i1 = 0;
                  while (i1 < i4)
                  {
                    i2 = 0;
                    while (i2 < i3)
                    {
                      int i5 = localObject1[(i1 * i3 + i2)];
                      localObject2[((i4 - i1 - 1) * i3 + i2)] = (i5 & 0xFF00FF00 | i5 << 16 & 0xFF0000 | i5 >> 16 & 0xFF);
                      i2 += 1;
                    }
                    i1 += 1;
                  }
                }
              }
            }
          }
        }
        try
        {
          paramGL10 = Bitmap.createBitmap((int[])localObject2, i3, i4, this.I);
        }
        catch (OutOfMemoryError paramGL10)
        {
          break label576;
        }
        paramGL10 = null;
        localObject1 = paramGL10;
        if (this.aE != null)
        {
          localObject1 = paramGL10;
          if (!(this.aE instanceof pw))
          {
            localObject1 = paramGL10;
            if (this.m.h())
            {
              localObject1 = this.m;
              if (((jr)localObject1).b == null) {}
              do
              {
                localObject1 = null;
                break;
                localObject1 = ((jr)localObject1).b.getDrawable();
              } while (localObject1 == null);
              localObject1 = ((BitmapDrawable)localObject1).getBitmap();
              if ((paramGL10 != null) && (!paramGL10.isRecycled()) && (localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
              {
                localObject2 = Bitmap.createBitmap(paramGL10.getWidth(), paramGL10.getHeight(), paramGL10.getConfig());
                localObject3 = new Canvas((Bitmap)localObject2);
                ((Canvas)localObject3).drawBitmap(paramGL10, new Matrix(), null);
                ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, this.m.d().left, this.m.d().top, null);
                localObject1 = localObject2;
              }
              else
              {
                localObject1 = null;
              }
            }
          }
        }
        paramGL10 = this.G;
        paramGL10.sendMessage(paramGL10.obtainMessage(0, localObject1));
        this.G = null;
        this.m.i();
        this.bh = true;
        return bool2;
      }
    }
  }
  
  public final mb b(Class<? extends mu> paramClass)
  {
    return (mb)this.aM.remove(paramClass);
  }
  
  public final Marker b(String paramString)
  {
    if (nl.a(paramString)) {
      return null;
    }
    synchronized (this.a)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        mu localmu = (mu)localIterator.next();
        if ((localmu.L.equals(paramString)) && ((localmu instanceof ms)))
        {
          paramString = ((ms)localmu).G;
          return paramString;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.T = paramInt1;
    this.U = paramInt2;
    this.az.c(paramInt1, paramInt2);
    s();
  }
  
  public final void b(TencentMapGestureListener paramTencentMapGestureListener)
  {
    TencentMapGestureListenerList localTencentMapGestureListenerList = this.p;
    if (localTencentMapGestureListenerList == null) {
      return;
    }
    localTencentMapGestureListenerList.removeListener(paramTencentMapGestureListener);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    boolean bool1;
    boolean bool2;
    int i1;
    label892:
    label895:
    Object localObject8;
    label1042:
    Object localObject3;
    label1052:
    label1065:
    label1078:
    synchronized (this.a)
    {
      ??? = (ms)c(this.aI);
      Object localObject12 = null;
      if (??? != null)
      {
        Object localObject4 = ((ms)???).J;
        if ((this.aI.equals("")) || (??? == null) || (localObject4 == null) || (!((gj)localObject4).e())) {
          break label1052;
        }
        bool1 = ((gj)localObject4).a(paramFloat1, paramFloat2);
        if (!bool1) {
          break label1042;
        }
        ??? = ((ms)???).G;
        Object localObject9 = ???;
        Object localObject11 = localObject4;
        bool2 = bool1;
        if (!bool1)
        {
          i1 = this.i.size() - 1;
          localObject9 = ???;
          localObject11 = localObject4;
          bool2 = bool1;
          if (i1 >= 0)
          {
            localObject9 = (ms)this.i.get(i1);
            localObject11 = ((ms)localObject9).J;
            bool2 = bool1;
            if (((mu)localObject9).L.equals(this.aI)) {
              break label1065;
            }
            bool2 = bool1;
            if (localObject11 == null) {
              break label1065;
            }
            bool2 = bool1;
            if (!((gj)localObject11).e()) {
              break label1065;
            }
            bool1 = ((gj)localObject11).a(paramFloat1, paramFloat2);
            bool2 = bool1;
            if (!bool1) {
              break label1065;
            }
            localObject9 = ((ms)localObject9).G;
            bool2 = bool1;
          }
        }
        if (bool2)
        {
          if ((this.az != null) && (this.A != null) && (localObject9 != null) && (localObject11 != null) && (((Marker)localObject9).isInfoWindowShown()))
          {
            this.A.onInfoWindowClick((Marker)localObject9);
            ??? = ((gj)localObject11).a(this.az.b.h);
            if (??? != null) {
              this.A.onInfoWindowClickLocation(((Rect)???).width(), ((Rect)???).height(), (int)paramFloat1 - ((Rect)???).left, (int)paramFloat2 - ((Rect)???).top);
            }
          }
          return true;
        }
        i1 = this.i.size() - 1;
        for (bool1 = false; i1 >= 0; bool1 = bool2)
        {
          bool2 = a((mu)this.i.get(i1), paramFloat1, paramFloat2);
          bool1 = bool2;
          if (bool2) {
            break;
          }
          i1 -= 1;
        }
        if (bool1) {
          return bool1;
        }
        i1 = this.aJ.size() - 1;
        while (i1 >= 0)
        {
          bool2 = a((mu)this.aJ.get(i1), paramFloat1, paramFloat2);
          bool1 = bool2;
          if (bool2) {
            break;
          }
          i1 -= 1;
          bool1 = bool2;
        }
        if (bool1) {
          return bool1;
        }
        i1 = this.aK.size() - 1;
        for (;;)
        {
          bool2 = bool1;
          if (i1 < 0) {
            break;
          }
          bool1 = a((mu)this.aK.get(i1), paramFloat1, paramFloat2);
          bool2 = bool1;
          if (bool1) {
            break;
          }
          i1 -= 1;
        }
        if (bool2) {
          return bool2;
        }
        if (this.b)
        {
          ??? = this.a;
          i1 = 0;
          try
          {
            if (i1 < this.i.size())
            {
              localObject4 = (ms)this.i.get(i1);
              if (((ms)localObject4).J == null) {
                break label1078;
              }
              ((ms)localObject4).J.a(false);
              break label1078;
            }
          }
          finally {}
        }
        ??? = this.az.b;
        ??? = localObject12;
        if (((lw)???).a != null) {
          ??? = ((lw)???).a.b(paramFloat1, paramFloat2);
        }
        if (??? != null)
        {
          i1 = ((TappedElement)???).type;
          if (i1 != 0)
          {
            if (i1 != 1)
            {
              if (i1 != 8) {
                break label892;
              }
            }
            else if (this.B != null)
            {
              if (((TappedElement)???).itemType == 1)
              {
                ??? = new IndoorMapPoi();
                ((IndoorMapPoi)???).buildingName = ((TappedElement)???).buildingName;
                ((IndoorMapPoi)???).buildingId = ((TappedElement)???).buildingId;
                ((IndoorMapPoi)???).floorName = ((TappedElement)???).floorName;
              }
              else
              {
                ??? = new MapPoi();
              }
              ((MapPoi)???).name = ((TappedElement)???).name;
              ??? = gb.a(((TappedElement)???).pixelX, ((TappedElement)???).pixelY);
              double d1 = ((GeoPoint)???).getLatitudeE6();
              Double.isNaN(d1);
              d1 /= 1000000.0D;
              double d2 = ((GeoPoint)???).getLongitudeE6();
              Double.isNaN(d2);
              ((MapPoi)???).position = new LatLng(d1, d2 / 1000000.0D);
              this.B.onClicked((MapPoi)???);
            }
            i1 = 1;
            break label895;
          }
        }
        i1 = 0;
        if (i1 != 0) {
          return true;
        }
        if ((this.s != null) && (this.aa))
        {
          ??? = new DoublePoint(paramFloat1, paramFloat2);
          ??? = fz.a(this.az.b.h.a((DoublePoint)???));
          this.s.onMapClick((LatLng)???);
        }
        synchronized (this.a)
        {
          synchronized (this.a)
          {
            if (this.j != null) {
              this.j.e();
            }
            s();
            return false;
          }
        }
      }
    }
  }
  
  public final mu c(String paramString)
  {
    int i1;
    label93:
    synchronized (this.a)
    {
      int i2 = this.h.size();
      i1 = 0;
      Object localObject = null;
      if (i1 < i2)
      {
        mu localmu = (mu)this.h.get(i1);
        localObject = localmu;
        if (localmu == null) {
          break label93;
        }
        localObject = localmu;
        if (!TextUtils.equals(localmu.L, paramString))
        {
          localObject = null;
          break label93;
        }
      }
      return localObject;
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return;
      }
      if (this.aV == null)
      {
        GeoPoint localGeoPoint = this.az.b();
        this.aV = new GeoPoint(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
      }
      this.aV.setLatitudeE6(paramInt1);
      this.aV.setLongitudeE6(paramInt2);
    }
  }
  
  public final void c(Class<? extends mu> paramClass)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
      {
        mu localmu = (mu)localIterator.next();
        if ((localmu != null) && (paramClass.isInstance(localmu)) && (!localmu.p()))
        {
          localmu.h();
          localIterator.remove();
          this.i.remove(localmu);
          this.aJ.remove(localmu);
          this.aK.remove(localmu);
        }
      }
      this.az.b.k();
      return;
    }
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    if (!this.aa) {
      return false;
    }
    lm locallm = this.az.b.e;
    TappedElement localTappedElement = locallm.a.g().b(paramFloat1, paramFloat2);
    if ((localTappedElement != null) && (localTappedElement.type == 3))
    {
      if (locallm.b != null) {
        locallm.b.a();
      }
      return true;
    }
    return false;
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    this.J = paramInt1;
    this.K = paramInt2;
  }
  
  public final void d(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    this.L = paramInt1;
    this.M = paramInt2;
  }
  
  public final void e(boolean paramBoolean)
  {
    this.Z = paramBoolean;
  }
  
  public final CameraPosition f()
  {
    pm localpm = this.az;
    Object localObject = localpm.b();
    if (localObject != null)
    {
      List localList = this.u;
      if (((localList != null) && (localList.size() > 0)) || (this.bf != null))
      {
        localObject = fz.a((GeoPoint)localObject);
        float f2 = localpm.g();
        float f1 = f2;
        if (f2 < 0.0F) {
          f1 = f2 % 360.0F + 360.0F;
        }
        f2 = localpm.h();
        float f3 = localpm.c();
        double d2 = localpm.f();
        double d1 = f3;
        d2 = Math.log(d2) / Math.log(2.0D);
        Double.isNaN(d1);
        f3 = (float)(d1 + d2);
        return CameraPosition.builder().zoom(f3).target((LatLng)localObject).bearing(f1).tilt(f2).build();
      }
    }
    return null;
  }
  
  public final void f(boolean paramBoolean)
  {
    this.aa = paramBoolean;
  }
  
  public final String g()
  {
    synchronized (this.a)
    {
      String str = this.aI;
      return str;
    }
  }
  
  public final boolean h()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.j != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public final boolean i()
  {
    return this.W;
  }
  
  public final boolean j()
  {
    return this.X;
  }
  
  public final boolean k()
  {
    return this.Y;
  }
  
  public final boolean l()
  {
    return this.Z;
  }
  
  public final void m()
  {
    ??? = this.ad;
    if (??? != null) {
      ((Handler)???).removeCallbacksAndMessages(null);
    }
    ??? = this.C;
    if (??? != null) {
      ((Handler)???).removeCallbacksAndMessages(null);
    }
    ??? = this.G;
    if (??? != null) {
      ((Handler)???).removeCallbacksAndMessages(null);
    }
    ??? = this.aN;
    if (??? != null)
    {
      ((List)???).clear();
      this.aN = null;
    }
    synchronized (this.a)
    {
      if (this.h != null)
      {
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
        {
          mu localmu = (mu)localIterator.next();
          if (localmu != null) {
            localmu.h();
          }
          localIterator.remove();
        }
        this.i.clear();
        this.aJ.clear();
        this.aK.clear();
      }
      ??? = this.aM;
      if (??? != null) {
        ((Map)???).clear();
      }
      this.s = null;
      this.A = null;
      this.v = null;
      this.E = null;
      this.q = null;
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final GeoPoint n()
  {
    if (this.aV == null)
    {
      if (this.J == -2147483648) {
        this.J = (this.aq / 2);
      }
      if (this.K == -2147483648) {
        this.K = (this.ar / 2);
      }
      DoublePoint localDoublePoint = new DoublePoint(this.J, this.K);
      this.aV = this.az.b.h.a(localDoublePoint);
    }
    return this.aV;
  }
  
  public final void o()
  {
    if (this.l == null) {
      this.l = new jd(this);
    }
    this.l.a();
  }
  
  public final void onCameraChange(CameraPosition paramCameraPosition)
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)((Iterator)localObject).next();
        if (localOnCameraChangeListener != null) {
          localOnCameraChangeListener.onCameraChange(paramCameraPosition);
        }
      }
    }
  }
  
  public final void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    Object localObject = this.u;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)((Iterator)localObject).next();
        if (localOnCameraChangeListener != null) {
          localOnCameraChangeListener.onCameraChangeFinished(paramCameraPosition);
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    this.az.a(null);
    Object localObject = this.u;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.av;
    if (localObject != null)
    {
      ((hr)localObject).d.az.b((he)localObject);
      ((hr)localObject).a.clear();
      ((hr)localObject).b.clear();
      ((hr)localObject).c.clear();
    }
    this.ba = true;
  }
  
  public final boolean onIndoorBuildingDeactivated()
  {
    this.f = null;
    Iterator localIterator = this.aL.iterator();
    while (localIterator.hasNext()) {
      ((mu)localIterator.next()).r();
    }
    return false;
  }
  
  public final boolean onIndoorBuildingFocused()
  {
    return false;
  }
  
  public final boolean onIndoorLevelActivated(IndoorBuilding paramIndoorBuilding)
  {
    this.f = paramIndoorBuilding;
    Iterator localIterator = this.aL.iterator();
    while (localIterator.hasNext()) {
      ((mu)localIterator.next()).a(paramIndoorBuilding);
    }
    return false;
  }
  
  public final void onResume()
  {
    super.onResume();
    this.ai = 0;
    this.ah = false;
    if (u())
    {
      if ((this.aE instanceof View))
      {
        if (this.av == null)
        {
          this.av = new hr((View)this.aE, this);
          this.av.b();
        }
        ViewCompat.setAccessibilityDelegate((View)this.aE, this.av);
      }
    }
    else if (this.av != null)
    {
      ViewCompat.setAccessibilityDelegate((View)this.aE, null);
      localObject1 = this.av;
      ((hr)localObject1).d.az.b((he)localObject1);
      this.av = null;
    }
    Object localObject1 = this.o;
    if ((localObject1 != null) && (((kj)localObject1).i != null))
    {
      String str = ((kj)localObject1).i.getBuidlingId();
      int i1 = ((kj)localObject1).i.getActiveLevelIndex();
      Object localObject2 = ((kj)localObject1).i.getLevels();
      if (localObject2 != null)
      {
        if (i1 >= ((List)localObject2).size()) {
          return;
        }
        localObject2 = ((IndoorLevel)((List)localObject2).get(i1)).getName();
        if ((!nl.a(str)) && (!nl.a((String)localObject2))) {
          ((kj)localObject1).d.az.a(str, (String)localObject2);
        }
      }
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    lq.a locala = this.t;
    if (locala != null) {
      locala.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final fv p()
  {
    fw[] arrayOffw = q();
    fw localfw = kd.b(this.az.b());
    float f1 = this.az.c();
    fv localfv = this.bg;
    if (localfv == null) {
      this.bg = new fv(localfw, arrayOffw, f1);
    } else {
      localfv.a(localfw, arrayOffw, f1);
    }
    return this.bg;
  }
  
  public final fw[] q()
  {
    fw[] arrayOffw = new fw[8];
    float f1 = this.aq;
    float f2 = this.ar;
    if ((f1 > 2.0F) && (f2 > 2.0F))
    {
      DoublePoint localDoublePoint1 = new DoublePoint(0.0D, 0.0D);
      int i1 = 0;
      double d1 = f1 / 2.0F;
      DoublePoint localDoublePoint2 = new DoublePoint(d1, 0.0D);
      double d2 = f1;
      DoublePoint localDoublePoint3 = new DoublePoint(d2, 0.0D);
      double d3 = f2 / 2.0F;
      DoublePoint localDoublePoint4 = new DoublePoint(d2, d3);
      double d4 = f2;
      DoublePoint localDoublePoint5 = new DoublePoint(d2, d4);
      DoublePoint localDoublePoint6 = new DoublePoint(d1, d4);
      DoublePoint localDoublePoint7 = new DoublePoint(0.0D, d4);
      DoublePoint localDoublePoint8 = new DoublePoint(0.0D, d3);
      while (i1 < 8)
      {
        arrayOffw[i1] = kd.b(this.az.b.h.a(new DoublePoint[] { localDoublePoint1, localDoublePoint2, localDoublePoint3, localDoublePoint4, localDoublePoint5, localDoublePoint6, localDoublePoint7, localDoublePoint8 }[i1]));
        i1 += 1;
      }
      return arrayOffw;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pn
 * JD-Core Version:    0.7.0.1
 */