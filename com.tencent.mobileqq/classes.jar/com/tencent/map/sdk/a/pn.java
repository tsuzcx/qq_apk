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
  public TencentMap.OnInfoWindowClickListener A = null;
  public TencentMap.OnMapPoiClickListener B = null;
  protected final Handler C = new pe(this);
  public TencentMap.CancelableCallback D = null;
  public TencentMap.OnCompassClickedListener E = null;
  public ln.a F = null;
  public Handler G;
  public ly H;
  public Bitmap.Config I = Bitmap.Config.RGB_565;
  public int J = -2147483648;
  public int K = -2147483648;
  public int L = -2147483648;
  public int M = -2147483648;
  public float N = 0.5F;
  public float O = 0.5F;
  public float P = 0.5F;
  public float Q = 0.5F;
  public boolean R = false;
  public boolean S = true;
  public int T = 0;
  public int U = 0;
  protected boolean V = true;
  protected boolean W = true;
  protected boolean X = true;
  protected boolean Y = true;
  protected boolean Z = true;
  public final byte[] a = new byte[0];
  private String aI = "";
  private List<mu> aJ = new ArrayList();
  private List<mu> aK = new ArrayList();
  private List<mu> aL = new ArrayList();
  private Map<Class<? extends mu>, mb> aM = new HashMap();
  private List<hc> aN = null;
  private TencentMap.OnDismissCallback aO = null;
  private final lh aP = new ph(this);
  private ih aQ = new pg(this);
  private final hb aR = new pr(this);
  private he aS = new pi(this);
  private Comparator<mu> aT = new pn.1(this);
  private boolean aU = true;
  private GeoPoint aV = null;
  private jx aW = null;
  private float aX = 100.0F;
  private float aY = 100.0F;
  private volatile boolean aZ = false;
  protected boolean aa = true;
  public int ab = 19;
  public int ac = 3;
  public Handler ad = null;
  public boolean ae = true;
  public boolean af = true;
  public volatile boolean ag = false;
  public volatile boolean ah = false;
  protected int ai = 0;
  public LatLng aj = null;
  public LatLng ak = null;
  public int al = 0;
  public int am = 0;
  public int an = 0;
  public int ao = 0;
  public int ap = 0;
  public int aq = 0;
  public int ar = 0;
  public boolean as = false;
  public ms at = null;
  public boolean au = false;
  public hr av;
  public List<ms> aw = new ArrayList();
  public List<MapPoi> ax = new ArrayList();
  public boolean b = false;
  private boolean ba = false;
  private int bb = 10;
  private boolean bc = false;
  private float bd = 0.0F;
  private AtomicBoolean be = new AtomicBoolean(false);
  private final gr bf = new pk(this);
  private fv bg;
  private boolean bh = true;
  public GlAnimation c = null;
  public GlAnimation d = null;
  public GlAnimation e = null;
  protected volatile IndoorBuilding f;
  public int g = 22;
  public List<mu> h = new ArrayList();
  public List<mu> i = new ArrayList();
  public lj j;
  public jz k = null;
  public jd l = null;
  public jr m;
  public ij n;
  public kj o = null;
  protected TencentMapGestureListenerList p = null;
  public AnimationListener q = null;
  public gw r = null;
  public TencentMap.OnMapClickListener s = null;
  public lq.a t = null;
  public List<TencentMap.OnCameraChangeListener> u = new CopyOnWriteArrayList();
  public TencentMap.OnMapLongClickListener v = null;
  volatile boolean w = false;
  public volatile TencentMap.OnMapLoadedCallback x = null;
  protected TencentMap.OnIndoorStateChangeListener y;
  public TencentMap.OnMarkerClickListener z = null;
  
  public pn(IMapRenderView paramIMapRenderView, Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramIMapRenderView, paramContext, paramTencentMapOptions);
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
    if ((paramContext.c == null) || (paramContext.c.get() != null))
    {
      this.az.a(this.aR);
      this.az.a(this);
      if (this.ad == null) {
        this.ad = new Handler();
      }
      paramIMapRenderView = (WindowManager)this.ay.getSystemService("window");
      this.aq = paramIMapRenderView.getDefaultDisplay().getWidth();
      this.ar = paramIMapRenderView.getDefaultDisplay().getHeight();
      if ((paramTencentMapOptions == null) || (nl.a(paramTencentMapOptions.getSubKey()))) {
        break label935;
      }
    }
    label935:
    for (paramIMapRenderView = paramTencentMapOptions.getSubKey();; paramIMapRenderView = null)
    {
      this.o = new kj(this, paramIMapRenderView);
      this.k = new jz(this);
      if (paramTencentMapOptions != null)
      {
        this.R = paramTencentMapOptions.isHandDrawMapEnable();
        this.as = paramTencentMapOptions.isMultipleInfoWindowEnable();
      }
      return;
      if (bool)
      {
        ((lf)paramContext.c.get()).b(paramContext);
        break;
      }
      ((lf)paramContext.c.get()).a(paramContext);
      break;
    }
  }
  
  private boolean a(mu parammu, float paramFloat1, float paramFloat2)
  {
    if ((parammu == null) || (!parammu.a()) || (!parammu.m())) {
      return false;
    }
    if (!parammu.a(paramFloat1, paramFloat2)) {
      return false;
    }
    mb localmb = (mb)this.aM.get(parammu.getClass());
    if (localmb != null) {
      return localmb.a(parammu, this.az.b.h.a(new DoublePoint(paramFloat1, paramFloat2)));
    }
    return false;
  }
  
  public static boolean a(LatLng paramLatLng, fw[] paramArrayOffw)
  {
    if (paramLatLng == null) {}
    do
    {
      return false;
      paramLatLng = kd.b(fz.a(paramLatLng));
    } while ((paramLatLng.b < paramArrayOffw[0].b) || (paramLatLng.b > paramArrayOffw[1].b) || (paramLatLng.a > paramArrayOffw[0].a) || (paramLatLng.a < paramArrayOffw[1].a));
    return true;
  }
  
  private String d(float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      int i1;
      synchronized (this.a)
      {
        i1 = this.h.size() - 1;
        if (i1 >= 0)
        {
          Object localObject1 = (mu)this.h.get(i1);
          if ((localObject1 == null) || (!((mu)localObject1).a()) || (!(localObject1 instanceof ms)) || (!((mu)localObject1).a(paramFloat1, paramFloat2))) {
            break label98;
          }
          localObject1 = ((mu)localObject1).L;
          return localObject1;
        }
      }
      Object localObject3 = null;
      continue;
      label98:
      i1 -= 1;
    }
  }
  
  private void g(boolean paramBoolean)
  {
    if ((!paramBoolean) || (jx.d()))
    {
      this.az.a(this.aP);
      return;
    }
    this.az.a(null);
  }
  
  public final mb a(Class<? extends mu> paramClass)
  {
    return (mb)this.aM.get(paramClass);
  }
  
  public final mu a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.h.iterator();
        if (localIterator.hasNext())
        {
          mu localmu = (mu)localIterator.next();
          if ((localmu == null) || (!TextUtils.equals(localmu.L, paramString))) {
            continue;
          }
          localIterator.remove();
          paramString = localmu;
          if (paramBoolean)
          {
            localmu.h();
            paramString = localmu;
          }
          if (paramString != null)
          {
            this.i.remove(paramString);
            this.aJ.remove(paramString);
            this.aK.remove(paramString);
          }
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final void a()
  {
    kl localkl = this.az.b.c;
    if (localkl.d != null)
    {
      localkl.k();
      Iterator localIterator = localkl.d.iterator();
      while (localIterator.hasNext()) {
        if ((gv)localIterator.next() != null) {}
      }
    }
    localkl.a.c();
    double d2 = (0.0D - localkl.h()) % 360.0D;
    double d1;
    if (d2 > 180.0D) {
      d1 = d2 - 360.0D;
    }
    for (;;)
    {
      d2 = 0.0D - localkl.i();
      if ((d1 != 0.0D) || (d2 != 0.0D))
      {
        or.a("postRotateAndSkew distance:" + d1 + "," + d2);
        long l1 = System.currentTimeMillis();
        float f1 = (float)(d1 * 0.1000000014901161D);
        float f2 = (float)(d2 * 0.1000000014901161D);
        localkl.a(new kl.2(localkl, new double[] { 0.0D, 0.0D, 0.0D, 0.0D }, l1, f1, f2, d1, d2));
      }
      if (this.E != null) {
        this.E.onCompassClicked();
      }
      return;
      d1 = d2;
      if (d2 < -180.0D) {
        d1 = d2 + 360.0D;
      }
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.bd == paramFloat) {}
    do
    {
      return;
      this.bd = paramFloat;
    } while (this.r == null);
    hj localhj = new hj();
    localhj.a = 1;
    localhj.d = this.az.c();
    localhj.e = this.az.b.h.a(new Point(0, this.ar / 2), new Point(this.aq, this.ar / 2));
    this.r.a(localhj);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.aN != null)
    {
      int i2 = this.aN.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ??? = (hc)this.aN.get(i1);
        if (??? != null) {
          ((hc)???).a(paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    if (this.a != null) {
      synchronized (this.a)
      {
        if (this.h != null)
        {
          Iterator localIterator = this.h.iterator();
          if (localIterator.hasNext()) {
            localIterator.next();
          }
        }
      }
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
    if ((this.u != null) && (paramOnCameraChangeListener != null)) {
      this.u.add(paramOnCameraChangeListener);
    }
    if (paramOnCameraChangeListener == null) {}
    for (boolean bool = true;; bool = false)
    {
      g(bool);
      return;
    }
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
    if (this.F != null) {
      this.F.a();
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
    if (this.av != null) {
      return this.av.dispatchHoverEvent(paramMotionEvent);
    }
    return false;
  }
  
  public final boolean a(mu parammu)
  {
    if (parammu == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      int i3;
      int i2;
      synchronized (this.a)
      {
        int i5 = this.h.size();
        i1 = 0;
        i3 = 0;
        i2 = i5;
        if (i1 < i5)
        {
          mu localmu = (mu)this.h.get(i1);
          if ((localmu == null) || (i3 != 0) || (localmu.i() < parammu.i())) {
            break label231;
          }
          i2 = 1;
          i3 = i1;
          break label241;
        }
        this.h.add(i2, parammu);
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
          return true;
        }
      }
      if ((parammu instanceof mw))
      {
        this.aJ.add(parammu);
        Collections.sort(this.aJ, this.aT);
      }
      else
      {
        this.aK.add(parammu);
        Collections.sort(this.aK, this.aT);
        continue;
        label231:
        int i4 = i3;
        i3 = i2;
        i2 = i4;
        label241:
        i1 += 1;
        i4 = i3;
        i3 = i2;
        i2 = i4;
      }
    }
  }
  
  public final boolean a(GL10 paramGL10)
  {
    byte[] arrayOfByte = this.a;
    Object localObject1 = null;
    int i2;
    int i1;
    Object localObject3;
    int i3;
    Object localObject2;
    boolean bool2;
    for (;;)
    {
      try
      {
        i2 = this.h.size();
        i1 = 0;
        if (i1 < i2)
        {
          localObject3 = null;
          i3 = i2;
          if (this.h.size() > i2) {
            i3 = this.h.size();
          }
          if (i1 < this.h.size()) {
            localObject3 = (mu)this.h.get(i1);
          }
          if (localObject3 == null) {
            break label829;
          }
          if (TextUtils.equals(((mu)localObject3).L, this.aI))
          {
            localObject2 = localObject3;
            if (((mu)localObject3).a()) {
              break label815;
            }
            localObject2 = localObject3;
            if (this.bc) {
              break label815;
            }
            ((mu)localObject3).c();
            localObject2 = localObject1;
            break label815;
          }
          if ((localObject3 instanceof mv))
          {
            ((mv)localObject3).a(this.az.b.h, paramGL10);
            localObject2 = localObject1;
            break label815;
          }
          ((mu)localObject3).a(paramGL10);
          break label829;
        }
        if (localObject1 != null) {
          ((mu)localObject1).a(paramGL10);
        }
        bool2 = super.a(paramGL10);
        if (((this.G == null) && (this.w)) || (this.az == null) || (!this.az.a) || (this.k == null) || (!this.k.e)) {
          break label411;
        }
        if (this.aA == null) {
          break label402;
        }
        localObject1 = this.aA;
        if (((lw)localObject1).a != null)
        {
          bool1 = ((lw)localObject1).a.f();
          if (!bool1) {
            break label402;
          }
          i1 = 1;
          if (i1 == 0) {
            break label411;
          }
          if ((!this.w) && (this.C != null)) {
            this.C.sendEmptyMessage(2);
          }
          if (this.G == null) {
            break label411;
          }
          if (!this.bh) {
            break label414;
          }
          this.bh = false;
          paramGL10 = this.m;
          if (paramGL10.r == null) {
            break;
          }
          localObject1 = paramGL10.r.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((gs)((Iterator)localObject1).next()).a(paramGL10);
          continue;
        }
        boolean bool1 = false;
      }
      finally {}
      continue;
      label402:
      i1 = 0;
    }
    t();
    label411:
    return bool2;
    label414:
    int i4;
    if (paramGL10 != null)
    {
      i3 = this.aq;
      i4 = this.ar;
      localObject1 = new int[i3 * i4];
      localObject2 = new int[i3 * i4];
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
    try
    {
      paramGL10 = Bitmap.createBitmap((int[])localObject2, i3, i4, this.I);
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
            if (((jr)localObject1).b != null) {
              break label703;
            }
            localObject1 = null;
            if ((paramGL10 != null) && (!paramGL10.isRecycled()) && (localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
              break label737;
            }
            paramGL10 = null;
            localObject1 = paramGL10;
          }
        }
      }
      this.G.sendMessage(this.G.obtainMessage(0, localObject1));
      this.G = null;
      this.m.i();
      this.bh = true;
      return bool2;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        paramGL10 = null;
        continue;
        label703:
        localObject1 = ((jr)localObject1).b.getDrawable();
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((BitmapDrawable)localObject1).getBitmap();
          continue;
          label737:
          localObject2 = Bitmap.createBitmap(paramGL10.getWidth(), paramGL10.getHeight(), paramGL10.getConfig());
          localObject3 = new Canvas((Bitmap)localObject2);
          ((Canvas)localObject3).drawBitmap(paramGL10, new Matrix(), null);
          ((Canvas)localObject3).drawBitmap((Bitmap)localObject1, this.m.d().left, this.m.d().top, null);
          paramGL10 = (GL10)localObject2;
        }
      }
    }
    for (;;)
    {
      label815:
      i1 += 1;
      localObject1 = localObject2;
      i2 = i3;
      break;
      label829:
      localObject2 = localObject1;
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
    }
    return null;
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
    if (this.p == null) {
      return;
    }
    this.p.removeListener(paramTencentMapGestureListener);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.V = paramBoolean;
  }
  
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    Object localObject4 = null;
    boolean bool1;
    label92:
    boolean bool2;
    synchronized (this.a)
    {
      Object localObject9 = (ms)c(this.aI);
      if (localObject9 == null) {
        break label1005;
      }
      Object localObject1 = ((ms)localObject9).J;
      if ((this.aI.equals("")) || (localObject9 == null) || (localObject1 == null) || (!((gj)localObject1).e())) {
        break label996;
      }
      bool1 = ((gj)localObject1).a(paramFloat1, paramFloat2);
      if (!bool1) {
        break label990;
      }
      localObject4 = ((ms)localObject9).G;
      bool2 = bool1;
      if (bool1) {
        break label971;
      }
      i1 = this.i.size() - 1;
      label113:
      bool2 = bool1;
      if (i1 < 0) {
        break label971;
      }
      ms localms = (ms)this.i.get(i1);
      localObject9 = localms.J;
      if ((localms.L.equals(this.aI)) || (localObject9 == null) || (!((gj)localObject9).e())) {
        break label968;
      }
      bool1 = ((gj)localObject9).a(paramFloat1, paramFloat2);
      if (!bool1) {
        break label1011;
      }
      localObject1 = localms.G;
      localObject4 = localObject9;
      label200:
      if (bool1)
      {
        if ((this.az != null) && (this.A != null) && (localObject1 != null) && (localObject4 != null) && (((Marker)localObject1).isInfoWindowShown()))
        {
          this.A.onInfoWindowClick((Marker)localObject1);
          localObject1 = ((gj)localObject4).a(this.az.b.h);
          if (localObject1 != null) {
            this.A.onInfoWindowClickLocation(((Rect)localObject1).width(), ((Rect)localObject1).height(), (int)paramFloat1 - ((Rect)localObject1).left, (int)paramFloat2 - ((Rect)localObject1).top);
          }
        }
        return true;
      }
      i1 = this.i.size();
      bool1 = false;
      i1 -= 1;
      while (i1 >= 0)
      {
        bool2 = a((mu)this.i.get(i1), paramFloat1, paramFloat2);
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
    }
    int i1 = this.aJ.size() - 1;
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
    }
    for (;;)
    {
      try
      {
        if (i1 < this.i.size())
        {
          localObject4 = (ms)this.i.get(i1);
          if (((ms)localObject4).J == null) {
            break label1018;
          }
          ((ms)localObject4).J.a(false);
          break label1018;
        }
        ??? = this.az.b;
        if (((lw)???).a != null)
        {
          ??? = ((lw)???).a.b(paramFloat1, paramFloat2);
          if (??? == null) {
            break label843;
          }
          switch (((TappedElement)???).type)
          {
          default: 
            i1 = 0;
            if (i1 == 0) {
              break label848;
            }
            return true;
          }
        }
      }
      finally {}
      ??? = null;
      continue;
      i1 = 0;
      continue;
      if (this.B != null)
      {
        if (((TappedElement)???).itemType != 1) {
          break label831;
        }
        ??? = new IndoorMapPoi();
        ((IndoorMapPoi)???).buildingName = ((TappedElement)???).buildingName;
        ((IndoorMapPoi)???).buildingId = ((TappedElement)???).buildingId;
        ((IndoorMapPoi)???).floorName = ((TappedElement)???).floorName;
      }
      for (;;)
      {
        ((MapPoi)???).name = ((TappedElement)???).name;
        ??? = gb.a(((TappedElement)???).pixelX, ((TappedElement)???).pixelY);
        ((MapPoi)???).position = new LatLng(((GeoPoint)???).getLatitudeE6() / 1000000.0D, ((GeoPoint)???).getLongitudeE6() / 1000000.0D);
        this.B.onClicked((MapPoi)???);
        i1 = 1;
        break;
        label831:
        ??? = new MapPoi();
      }
      label843:
      i1 = 0;
      continue;
      label848:
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
      label968:
      break label1011;
      label971:
      bool1 = bool2;
      Object localObject11 = localObject7;
      Object localObject8 = ???;
      ??? = localObject11;
      break label200;
      label990:
      ??? = null;
      break label92;
      label996:
      ??? = null;
      bool1 = false;
      break label92;
      label1005:
      ??? = null;
      break;
      label1011:
      i1 -= 1;
      break label113;
      label1018:
      i1 += 1;
    }
  }
  
  public final mu c(String paramString)
  {
    for (;;)
    {
      int i1;
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
            break label87;
          }
          localObject = localmu;
          if (!TextUtils.equals(localmu.L, paramString))
          {
            localObject = null;
            break label87;
          }
        }
        return localObject;
      }
      label87:
      i1 += 1;
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
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
    }
    this.az.b.k();
  }
  
  public final void c(boolean paramBoolean)
  {
    this.X = paramBoolean;
  }
  
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    if (!this.aa) {}
    lm locallm;
    TappedElement localTappedElement;
    do
    {
      return false;
      locallm = this.az.b.e;
      localTappedElement = locallm.a.g().b(paramFloat1, paramFloat2);
    } while ((localTappedElement == null) || (localTappedElement.type != 3));
    if (locallm.b != null) {
      locallm.b.a();
    }
    return true;
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
    if ((localObject == null) || (((this.u == null) || (this.u.size() <= 0)) && (this.bf == null))) {
      return null;
    }
    localObject = fz.a((GeoPoint)localObject);
    float f2 = localpm.g();
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 % 360.0F + 360.0F;
    }
    f2 = localpm.h();
    float f3 = localpm.c();
    double d1 = localpm.f();
    f3 = (float)(f3 + Math.log(d1) / Math.log(2.0D));
    return CameraPosition.builder().zoom(f3).target((LatLng)localObject).bearing(f1).tilt(f2).build();
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
    if (this.ad != null) {
      this.ad.removeCallbacksAndMessages(null);
    }
    if (this.C != null) {
      this.C.removeCallbacksAndMessages(null);
    }
    if (this.G != null) {
      this.G.removeCallbacksAndMessages(null);
    }
    if (this.aN != null)
    {
      this.aN.clear();
      this.aN = null;
    }
    for (;;)
    {
      synchronized (this.a)
      {
        if (this.h == null)
        {
          if (this.aM != null) {
            this.aM.clear();
          }
          this.s = null;
          this.A = null;
          this.v = null;
          this.E = null;
          this.q = null;
          return;
        }
        Iterator localIterator = this.h.iterator();
        if (localIterator.hasNext())
        {
          mu localmu = (mu)localIterator.next();
          if (localmu != null) {
            localmu.h();
          }
          localIterator.remove();
        }
      }
      this.i.clear();
      this.aJ.clear();
      this.aK.clear();
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
    if (this.u != null)
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)localIterator.next();
        if (localOnCameraChangeListener != null) {
          localOnCameraChangeListener.onCameraChange(paramCameraPosition);
        }
      }
    }
  }
  
  public final void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.u != null)
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        TencentMap.OnCameraChangeListener localOnCameraChangeListener = (TencentMap.OnCameraChangeListener)localIterator.next();
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
    if (this.u != null) {
      this.u.clear();
    }
    if (this.av != null)
    {
      hr localhr = this.av;
      localhr.d.az.b(localhr);
      localhr.a.clear();
      localhr.b.clear();
      localhr.c.clear();
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
    if (u()) {
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
    Object localObject1;
    String str;
    Object localObject2;
    do
    {
      int i1;
      for (;;)
      {
        if (this.o != null)
        {
          localObject1 = this.o;
          if (((kj)localObject1).i != null)
          {
            str = ((kj)localObject1).i.getBuidlingId();
            i1 = ((kj)localObject1).i.getActiveLevelIndex();
            localObject2 = ((kj)localObject1).i.getLevels();
            if ((localObject2 != null) && (i1 < ((List)localObject2).size())) {
              break;
            }
          }
        }
        return;
        if (this.av != null)
        {
          ViewCompat.setAccessibilityDelegate((View)this.aE, null);
          localObject1 = this.av;
          ((hr)localObject1).d.az.b((he)localObject1);
          this.av = null;
        }
      }
      localObject2 = ((IndoorLevel)((List)localObject2).get(i1)).getName();
    } while ((nl.a(str)) || (nl.a((String)localObject2)));
    ((kj)localObject1).d.az.a(str, (String)localObject2);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.t != null) {
      this.t.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final fv p()
  {
    fw[] arrayOffw = q();
    fw localfw = kd.b(this.az.b());
    float f1 = this.az.c();
    if (this.bg == null) {
      this.bg = new fv(localfw, arrayOffw, f1);
    }
    for (;;)
    {
      return this.bg;
      this.bg.a(localfw, arrayOffw, f1);
    }
  }
  
  public final fw[] q()
  {
    fw[] arrayOffw2 = new fw[8];
    float f1 = this.aq;
    float f2 = this.ar;
    fw[] arrayOffw1;
    if ((f1 <= 2.0F) || (f2 <= 2.0F))
    {
      arrayOffw1 = null;
      return arrayOffw1;
    }
    DoublePoint localDoublePoint1 = new DoublePoint(0.0D, 0.0D);
    DoublePoint localDoublePoint2 = new DoublePoint(f1 / 2.0F, 0.0D);
    DoublePoint localDoublePoint3 = new DoublePoint(f1, 0.0D);
    DoublePoint localDoublePoint4 = new DoublePoint(f1, f2 / 2.0F);
    DoublePoint localDoublePoint5 = new DoublePoint(f1, f2);
    DoublePoint localDoublePoint6 = new DoublePoint(f1 / 2.0F, f2);
    DoublePoint localDoublePoint7 = new DoublePoint(0.0D, f2);
    DoublePoint localDoublePoint8 = new DoublePoint(0.0D, f2 / 2.0F);
    int i1 = 0;
    for (;;)
    {
      arrayOffw1 = arrayOffw2;
      if (i1 >= 8) {
        break;
      }
      arrayOffw2[i1] = kd.b(this.az.b.h.a(new DoublePoint[] { localDoublePoint1, localDoublePoint2, localDoublePoint3, localDoublePoint4, localDoublePoint5, localDoublePoint6, localDoublePoint7, localDoublePoint8 }[i1]));
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pn
 * JD-Core Version:    0.7.0.1
 */