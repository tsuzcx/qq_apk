package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.c.a;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

public final class f
  implements c.a, d.a
{
  private static int E = 160;
  public static int a = 0;
  public static int b = 0;
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 0;
  public static int g = 0;
  public static int h = 0;
  private static volatile Context i;
  private static boolean x = true;
  private static volatile String z = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
  private boolean A = false;
  private boolean B = false;
  private com.tencent.mapsdk.rastercore.b.c C;
  private com.tencent.mapsdk.rastercore.a D;
  private MapView j;
  private a k;
  private b l;
  private g m;
  private com.tencent.mapsdk.rastercore.tile.a.1 n;
  private com.tencent.mapsdk.rastercore.tile.f o;
  private com.tencent.mapsdk.rastercore.d.a.a p;
  private c q;
  private a.1 r;
  private volatile com.tencent.mapsdk.rastercore.g.b s;
  private com.tencent.mapsdk.rastercore.g.a t;
  private int u = 1;
  private TencentMap.OnScreenShotListener v = null;
  private boolean w = false;
  private Rect y = null;
  
  public f(MapView paramMapView)
  {
    Object localObject = paramMapView.getContext().getApplicationContext();
    i = (Context)localObject;
    E = ((Context)localObject).getResources().getDisplayMetrics().densityDpi;
    com.tencent.mapsdk.rastercore.tile.a.a.a().a(i);
    com.tencent.mapsdk.rastercore.f.a.a().a(i);
    e.a().a(i);
    h.l();
    this.j = paramMapView;
    this.r = new a.1(this);
    this.s = new com.tencent.mapsdk.rastercore.g.b(this);
    this.p = new com.tencent.mapsdk.rastercore.d.a.a(this);
    this.q = new c(this);
    this.t = new com.tencent.mapsdk.rastercore.g.a(this);
    this.k = new a(this);
    this.l = new b(this);
    this.m = new g(this);
    this.n = new com.tencent.mapsdk.rastercore.tile.a.1(this);
    this.o = new com.tencent.mapsdk.rastercore.tile.f(this);
    this.q.a();
    localObject = new ViewGroup.LayoutParams(-1, -1);
    paramMapView.addView(this.l, (ViewGroup.LayoutParams)localObject);
    paramMapView.addView(this.t, (ViewGroup.LayoutParams)localObject);
    paramMapView.addView(this.s, (ViewGroup.LayoutParams)localObject);
    this.r.b(1);
    this.r.a(true);
    this.r.c(0);
    this.D = new com.tencent.mapsdk.rastercore.a();
    this.D.a();
    new com.tencent.mapsdk.rastercore.c(i, this).a();
    new d(i, this).a();
  }
  
  public static Context a()
  {
    return i;
  }
  
  public static void a(String paramString)
  {
    z = paramString;
  }
  
  public static void e(boolean paramBoolean)
  {
    x = false;
  }
  
  public static void n() {}
  
  public static boolean p()
  {
    return x;
  }
  
  public static String q()
  {
    return z;
  }
  
  public static int s()
  {
    return E;
  }
  
  private com.tencent.mapsdk.rastercore.b.c t()
  {
    com.tencent.mapsdk.rastercore.b.f[] arrayOff = this.q.b();
    com.tencent.mapsdk.rastercore.b.f localf = this.l.b();
    float f1 = this.q.d().getZoom();
    if (this.C == null) {
      this.C = new com.tencent.mapsdk.rastercore.b.c(localf, arrayOff, f1);
    }
    for (;;)
    {
      return this.C;
      this.C.a(localf, arrayOff, f1);
    }
  }
  
  public final void a(float paramFloat)
  {
    if (this.s != null)
    {
      this.s.a(paramFloat);
      this.s.invalidate();
    }
  }
  
  public final void a(int paramInt)
  {
    this.u = paramInt;
    a(false, false);
  }
  
  public final void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.s != null) {
      this.s.a(paramArrayOfInt);
    }
  }
  
  public final void a(Bitmap paramBitmap)
  {
    if (this.s != null)
    {
      this.s.a(paramBitmap);
      this.s.invalidate();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.r.e(paramBundle.getBoolean("ANIMATION_ENABLED", true));
      this.r.b(paramBundle.getBoolean("SCROLL_ENABLED", true));
      this.r.c(paramBundle.getBoolean("ZOOM_ENABLED", true));
      this.r.b(paramBundle.getInt("LOGO_POSITION", 0));
      this.r.c(paramBundle.getInt("SCALEVIEW_POSITION", 0));
      this.r.a(paramBundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
      this.l.b(paramBundle.getDouble("ZOOM", this.l.c()), false, null);
      Double localDouble = Double.valueOf(paramBundle.getDouble("CENTERX", (0.0D / 0.0D)));
      paramBundle = Double.valueOf(paramBundle.getDouble("CENTERY", (0.0D / 0.0D)));
      if ((!localDouble.isNaN()) && (!paramBundle.isNaN())) {
        this.l.a(new com.tencent.mapsdk.rastercore.b.f(localDouble.doubleValue(), paramBundle.doubleValue()));
      }
    }
  }
  
  public final void a(TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    a(paramOnScreenShotListener, null);
  }
  
  public final void a(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    this.v = paramOnScreenShotListener;
    this.y = paramRect;
    com.tencent.mapsdk.rastercore.f.b.a(this.l, 1);
    if (this.w)
    {
      o();
      return;
    }
    this.l.a(true);
    a(false, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      a(false, false);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.w = false;
    if (this.p != null) {
      this.p.a(t());
    }
    this.n.a(paramBoolean1, paramBoolean2);
    this.j.layout();
    this.j.postInvalidate();
  }
  
  public final c b()
  {
    return this.q;
  }
  
  public final void b(int paramInt)
  {
    if (this.s != null)
    {
      this.s.a(paramInt);
      this.s.invalidate();
      if (this.t.getVisibility() == 0) {
        this.t.invalidate();
      }
    }
  }
  
  public final void b(final Bitmap paramBitmap)
  {
    this.j.post(new Runnable()
    {
      public final void run()
      {
        f.this.a(paramBitmap);
      }
    });
  }
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("ANIMATION_ENABLED", this.r.k());
    paramBundle.putBoolean("SCROLL_ENABLED", this.r.h());
    paramBundle.putBoolean("ZOOM_ENABLED", this.r.i());
    paramBundle.putInt("LOGO_POSITION", this.r.j());
    paramBundle.putInt("SCALEVIEW_POSITION", this.r.f());
    paramBundle.putBoolean("SCALE_CONTROLL_ENABLED", this.r.g());
    paramBundle.putDouble("ZOOM", this.l.c());
    paramBundle.putDouble("CENTERX", this.l.b().b());
    paramBundle.putDouble("CENTERY", this.l.b().a());
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.p.a();
    }
    com.tencent.mapsdk.rastercore.d.a.a locala = this.p;
    com.tencent.mapsdk.rastercore.d.a.a.a(h.j());
    this.p.a(t());
    a(false, false);
  }
  
  public final b c()
  {
    return this.l;
  }
  
  public final void c(int paramInt)
  {
    if ((this.t != null) && (this.t.getVisibility() == 0))
    {
      this.t.a(paramInt);
      this.t.invalidate();
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t.setVisibility(0);
      this.t.d();
      return;
    }
    com.tencent.mapsdk.rastercore.g.a locala = this.t;
    com.tencent.mapsdk.rastercore.g.a.b();
    locala = this.t;
    com.tencent.mapsdk.rastercore.g.a.c();
    this.t.setVisibility(8);
  }
  
  public final MapView d()
  {
    return this.j;
  }
  
  protected final void d(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public final a e()
  {
    return this.k;
  }
  
  public final a.1 f()
  {
    return this.r;
  }
  
  protected final void f(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }
  
  public final com.tencent.mapsdk.rastercore.tile.a.1 g()
  {
    return this.n;
  }
  
  public final void g(boolean paramBoolean)
  {
    if (paramBoolean != this.B)
    {
      this.B = paramBoolean;
      a(false, false);
    }
  }
  
  public final g h()
  {
    return this.m;
  }
  
  public final com.tencent.mapsdk.rastercore.tile.f i()
  {
    return this.o;
  }
  
  public final void j()
  {
    this.t.e();
  }
  
  public final void k()
  {
    this.t.d();
  }
  
  public final int l()
  {
    return this.u;
  }
  
  public final void m()
  {
    this.t.a();
    this.s.a();
    this.k.b();
    this.j.stopAnimation();
    this.j.removeAllViews();
    this.n.a();
    this.p.b();
    e.a().b();
    com.tencent.mapsdk.rastercore.tile.a.a.a().c();
    new Thread()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: new 21	java/lang/StringBuilder
        //   5: dup
        //   6: invokespecial 22	java/lang/StringBuilder:<init>	()V
        //   9: getstatic 26	com/tencent/mapsdk/rastercore/d/f:c	I
        //   12: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   15: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   18: ldc 38
        //   20: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: getstatic 41	com/tencent/mapsdk/rastercore/d/f:d	I
        //   26: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   29: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   35: astore_3
        //   36: new 21	java/lang/StringBuilder
        //   39: dup
        //   40: invokespecial 22	java/lang/StringBuilder:<init>	()V
        //   43: getstatic 46	com/tencent/mapsdk/rastercore/d/f:a	I
        //   46: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   52: ldc 38
        //   54: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   57: getstatic 49	com/tencent/mapsdk/rastercore/d/f:b	I
        //   60: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   63: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   69: astore 4
        //   71: new 21	java/lang/StringBuilder
        //   74: dup
        //   75: invokespecial 22	java/lang/StringBuilder:<init>	()V
        //   78: getstatic 52	com/tencent/mapsdk/rastercore/d/f:e	I
        //   81: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   84: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: ldc 38
        //   89: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   92: iconst_0
        //   93: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   96: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   102: astore 5
        //   104: new 21	java/lang/StringBuilder
        //   107: dup
        //   108: invokespecial 22	java/lang/StringBuilder:<init>	()V
        //   111: getstatic 55	com/tencent/mapsdk/rastercore/d/f:f	I
        //   114: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   117: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   120: ldc 38
        //   122: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   125: iconst_0
        //   126: invokestatic 32	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   129: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   135: astore 6
        //   137: new 21	java/lang/StringBuilder
        //   140: dup
        //   141: ldc 57
        //   143: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   146: astore 7
        //   148: aload_0
        //   149: getfield 12	com/tencent/mapsdk/rastercore/d/f$1:a	Lcom/tencent/mapsdk/rastercore/d/f;
        //   152: invokestatic 63	com/tencent/mapsdk/rastercore/d/f:a	(Lcom/tencent/mapsdk/rastercore/d/f;)Lcom/tencent/mapsdk/rastercore/a;
        //   155: ifnull +214 -> 369
        //   158: aload_0
        //   159: getfield 12	com/tencent/mapsdk/rastercore/d/f$1:a	Lcom/tencent/mapsdk/rastercore/d/f;
        //   162: invokestatic 63	com/tencent/mapsdk/rastercore/d/f:a	(Lcom/tencent/mapsdk/rastercore/d/f;)Lcom/tencent/mapsdk/rastercore/a;
        //   165: invokevirtual 67	com/tencent/mapsdk/rastercore/a:c	()Ljava/lang/String;
        //   168: ifnonnull +134 -> 302
        //   171: goto +198 -> 369
        //   174: new 69	java/net/URL
        //   177: dup
        //   178: aload 7
        //   180: aload_1
        //   181: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   184: ldc 71
        //   186: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   189: aload_3
        //   190: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: ldc 73
        //   195: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   198: aload 4
        //   200: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   203: ldc 75
        //   205: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   208: aload 5
        //   210: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   213: ldc 77
        //   215: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: aload 6
        //   220: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   226: invokespecial 78	java/net/URL:<init>	(Ljava/lang/String;)V
        //   229: invokevirtual 82	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   232: checkcast 84	java/net/HttpURLConnection
        //   235: astore_1
        //   236: aload_1
        //   237: ldc 86
        //   239: invokevirtual 89	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   242: aload_1
        //   243: invokevirtual 92	java/net/HttpURLConnection:connect	()V
        //   246: aload_1
        //   247: invokevirtual 96	java/net/HttpURLConnection:getResponseCode	()I
        //   250: sipush 200
        //   253: if_icmpne +40 -> 293
        //   256: aload_1
        //   257: invokevirtual 100	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   260: pop
        //   261: iconst_0
        //   262: putstatic 26	com/tencent/mapsdk/rastercore/d/f:c	I
        //   265: iconst_0
        //   266: putstatic 41	com/tencent/mapsdk/rastercore/d/f:d	I
        //   269: iconst_0
        //   270: putstatic 46	com/tencent/mapsdk/rastercore/d/f:a	I
        //   273: iconst_0
        //   274: putstatic 49	com/tencent/mapsdk/rastercore/d/f:b	I
        //   277: iconst_0
        //   278: putstatic 52	com/tencent/mapsdk/rastercore/d/f:e	I
        //   281: iconst_0
        //   282: putstatic 55	com/tencent/mapsdk/rastercore/d/f:f	I
        //   285: iconst_0
        //   286: putstatic 103	com/tencent/mapsdk/rastercore/d/f:g	I
        //   289: iconst_0
        //   290: putstatic 49	com/tencent/mapsdk/rastercore/d/f:b	I
        //   293: aload_1
        //   294: ifnull +7 -> 301
        //   297: aload_1
        //   298: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
        //   301: return
        //   302: new 21	java/lang/StringBuilder
        //   305: dup
        //   306: invokespecial 22	java/lang/StringBuilder:<init>	()V
        //   309: aload_0
        //   310: getfield 12	com/tencent/mapsdk/rastercore/d/f$1:a	Lcom/tencent/mapsdk/rastercore/d/f;
        //   313: invokestatic 63	com/tencent/mapsdk/rastercore/d/f:a	(Lcom/tencent/mapsdk/rastercore/d/f;)Lcom/tencent/mapsdk/rastercore/a;
        //   316: invokevirtual 67	com/tencent/mapsdk/rastercore/a:c	()Ljava/lang/String;
        //   319: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   322: ldc 108
        //   324: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   327: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   330: astore_1
        //   331: goto -157 -> 174
        //   334: astore_1
        //   335: aconst_null
        //   336: astore_1
        //   337: aload_1
        //   338: ifnull -37 -> 301
        //   341: aload_1
        //   342: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
        //   345: return
        //   346: astore_3
        //   347: aload_2
        //   348: astore_1
        //   349: aload_3
        //   350: astore_2
        //   351: aload_1
        //   352: ifnull +7 -> 359
        //   355: aload_1
        //   356: invokevirtual 106	java/net/HttpURLConnection:disconnect	()V
        //   359: aload_2
        //   360: athrow
        //   361: astore_2
        //   362: goto -11 -> 351
        //   365: astore_2
        //   366: goto -29 -> 337
        //   369: ldc 110
        //   371: astore_1
        //   372: goto -198 -> 174
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	375	0	this	1
        //   180	151	1	localObject1	Object
        //   334	1	1	localException1	java.lang.Exception
        //   336	36	1	localObject2	Object
        //   1	359	2	localObject3	Object
        //   361	1	2	localObject4	Object
        //   365	1	2	localException2	java.lang.Exception
        //   35	155	3	str1	String
        //   346	4	3	localObject5	Object
        //   69	130	4	str2	String
        //   102	107	5	str3	String
        //   135	84	6	str4	String
        //   146	33	7	localStringBuilder	java.lang.StringBuilder
        // Exception table:
        //   from	to	target	type
        //   2	171	334	java/lang/Exception
        //   174	236	334	java/lang/Exception
        //   302	331	334	java/lang/Exception
        //   2	171	346	finally
        //   174	236	346	finally
        //   302	331	346	finally
        //   236	293	361	finally
        //   236	293	365	java/lang/Exception
      }
    }.start();
    System.gc();
  }
  
  protected final void o()
  {
    if (this.v != null)
    {
      this.j.setDrawingCacheEnabled(true);
      this.j.buildDrawingCache();
      if (this.y != null) {
        break label73;
      }
    }
    label73:
    for (Bitmap localBitmap = Bitmap.createBitmap(this.j.getDrawingCache());; localBitmap = Bitmap.createBitmap(this.j.getDrawingCache(), this.y.left, this.y.top, this.y.width(), this.y.height()))
    {
      this.j.destroyDrawingCache();
      this.v.onMapScreenShot(localBitmap);
      if (this.A) {
        com.tencent.mapsdk.rastercore.f.b.a(this.l, 2);
      }
      return;
    }
  }
  
  public final boolean r()
  {
    return this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.f
 * JD-Core Version:    0.7.0.1
 */