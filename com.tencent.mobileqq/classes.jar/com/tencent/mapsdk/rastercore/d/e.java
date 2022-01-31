package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

public final class e
  implements d.b
{
  private static int D = 160;
  public static StringBuffer a = new StringBuffer();
  public static StringBuffer b = new StringBuffer();
  private static volatile Context c;
  private static boolean q = true;
  private static boolean s = false;
  private static volatile int t = com.tencent.mapsdk.rastercore.b.a;
  private static volatile int u = com.tencent.mapsdk.rastercore.b.b;
  private static volatile int v = 0;
  private static volatile int w = 1000;
  private static volatile int x = 1000;
  private static volatile int y = 0;
  private static volatile String z = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private MapView d;
  private a e;
  private b f;
  private f g;
  private com.tencent.mapsdk.rastercore.tile.a.1 h;
  private com.tencent.mapsdk.rastercore.tile.e i;
  private c j;
  private a.1 k;
  private volatile com.tencent.mapsdk.rastercore.g.b l;
  private com.tencent.mapsdk.rastercore.g.a m;
  private int n = 1;
  private TencentMap.OnScreenShotListener o = null;
  private boolean p = false;
  private Rect r = null;
  
  public e(MapView paramMapView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.A = paramBoolean1;
    Object localObject;
    if (!paramBoolean2)
    {
      paramBoolean2 = true;
      this.B = paramBoolean2;
      y = paramInt;
      localObject = paramMapView.getContext().getApplicationContext();
      c = (Context)localObject;
      if (localObject != null) {
        break label463;
      }
    }
    label463:
    for (paramBoolean2 = false;; paramBoolean2 = c.getSharedPreferences("mapsdk_pref", 0).getBoolean("worldEnable", false))
    {
      s = paramBoolean2;
      com.tencent.mapsdk.rastercore.tile.a.a.a().a(c);
      if (c != null)
      {
        D = c.getResources().getDisplayMetrics().densityDpi;
        if (!paramBoolean1)
        {
          d.a.a();
          x = d.a.a(c.getPackageName(), false);
        }
        d.a.a();
        y = d.a.b(c.getPackageName(), false);
        d.a.a();
        t = d.a.a(x, y, false);
        d.a.a();
        w = d.a.a(c.getPackageName(), true);
        d.a.a();
        v = d.a.b(c.getPackageName(), true);
        d.a.a();
        u = d.a.a(w, v, true);
        new Thread()
        {
          public final void run()
          {
            com.tencent.mapsdk.rastercore.tile.a.a.a().a(e.C(), e.D(), MapTile.MapSource.BING);
            com.tencent.mapsdk.rastercore.tile.a.a.a().a(e.E(), e.F(), MapTile.MapSource.TENCENT);
            com.tencent.mapsdk.rastercore.tile.a.a.a().a(e.E(), e.F(), MapTile.MapSource.QQAR);
            com.tencent.mapsdk.rastercore.tile.a.a.a().d();
          }
        }.start();
      }
      this.d = paramMapView;
      this.k = new a.1(this);
      this.l = new com.tencent.mapsdk.rastercore.g.b(this);
      this.j = new c(this);
      this.m = new com.tencent.mapsdk.rastercore.g.a(this);
      this.e = new a(this);
      this.f = new b(this);
      this.g = new f(this);
      this.h = new com.tencent.mapsdk.rastercore.tile.a.1(this, y, t);
      this.i = new com.tencent.mapsdk.rastercore.tile.e(this);
      this.j.a();
      localObject = new ViewGroup.LayoutParams(-1, -1);
      paramMapView.addView(this.f, (ViewGroup.LayoutParams)localObject);
      paramMapView.addView(this.m, (ViewGroup.LayoutParams)localObject);
      paramMapView.addView(this.l, (ViewGroup.LayoutParams)localObject);
      this.k.b(1);
      this.k.a(true);
      this.k.c(0);
      if (this.B) {
        com.tencent.mapsdk.rastercore.a.a(this);
      }
      new d(c, this, paramInt, v).a();
      return;
      paramBoolean2 = false;
      break;
    }
  }
  
  public static int B()
  {
    return D;
  }
  
  public static Context a()
  {
    return c;
  }
  
  public static void a(String paramString)
  {
    z = paramString;
  }
  
  private void a(final StringBuffer paramStringBuffer, final String paramString)
  {
    if ((paramStringBuffer == null) || (paramStringBuffer.length() <= 0) || (!this.B)) {}
    while ((paramStringBuffer == null) || (paramStringBuffer.length() <= 0)) {
      return;
    }
    paramStringBuffer.deleteCharAt(paramStringBuffer.length() - 1);
    new Thread()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: new 27	java/net/URL
        //   5: dup
        //   6: new 29	java/lang/StringBuilder
        //   9: dup
        //   10: ldc 31
        //   12: invokespecial 34	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   15: getstatic 37	com/tencent/mapsdk/rastercore/a:a	Ljava/lang/StringBuffer;
        //   18: invokevirtual 43	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   21: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   24: ldc 49
        //   26: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   29: aload_0
        //   30: getfield 16	com/tencent/mapsdk/rastercore/d/e$3:a	Ljava/lang/StringBuffer;
        //   33: invokevirtual 43	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   36: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: ldc 51
        //   41: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   44: aload_0
        //   45: getfield 18	com/tencent/mapsdk/rastercore/d/e$3:b	Ljava/lang/String;
        //   48: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   51: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   54: invokespecial 53	java/net/URL:<init>	(Ljava/lang/String;)V
        //   57: invokevirtual 57	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   60: checkcast 59	java/net/HttpURLConnection
        //   63: astore_1
        //   64: aload_1
        //   65: ldc 61
        //   67: invokevirtual 64	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   70: aload_1
        //   71: invokevirtual 67	java/net/HttpURLConnection:connect	()V
        //   74: aload_1
        //   75: invokevirtual 71	java/net/HttpURLConnection:getResponseCode	()I
        //   78: sipush 200
        //   81: if_icmpne +21 -> 102
        //   84: aload_1
        //   85: invokevirtual 75	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   88: pop
        //   89: aload_0
        //   90: getfield 16	com/tencent/mapsdk/rastercore/d/e$3:a	Ljava/lang/StringBuffer;
        //   93: astore_2
        //   94: aload_0
        //   95: getfield 16	com/tencent/mapsdk/rastercore/d/e$3:a	Ljava/lang/StringBuffer;
        //   98: iconst_0
        //   99: invokevirtual 79	java/lang/StringBuffer:setLength	(I)V
        //   102: aload_1
        //   103: ifnull +7 -> 110
        //   106: aload_1
        //   107: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
        //   110: return
        //   111: astore_1
        //   112: aconst_null
        //   113: astore_1
        //   114: aload_1
        //   115: ifnull -5 -> 110
        //   118: aload_1
        //   119: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
        //   122: return
        //   123: astore_3
        //   124: aload_2
        //   125: astore_1
        //   126: aload_3
        //   127: astore_2
        //   128: aload_1
        //   129: ifnull +7 -> 136
        //   132: aload_1
        //   133: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
        //   136: aload_2
        //   137: athrow
        //   138: astore_2
        //   139: goto -11 -> 128
        //   142: astore_2
        //   143: goto -29 -> 114
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	146	0	this	3
        //   63	44	1	localHttpURLConnection	java.net.HttpURLConnection
        //   111	1	1	localException1	java.lang.Exception
        //   113	20	1	localObject1	Object
        //   1	136	2	localObject2	Object
        //   138	1	2	localObject3	Object
        //   142	1	2	localException2	java.lang.Exception
        //   123	4	3	localObject4	Object
        // Exception table:
        //   from	to	target	type
        //   2	64	111	java/lang/Exception
        //   2	64	123	finally
        //   64	102	138	finally
        //   64	102	142	java/lang/Exception
      }
    }.start();
  }
  
  public static void c(boolean paramBoolean)
  {
    q = false;
  }
  
  public static void d(boolean paramBoolean)
  {
    s = paramBoolean;
  }
  
  public static void e(boolean paramBoolean)
  {
    if (c == null) {
      return;
    }
    SharedPreferences.Editor localEditor = c.getSharedPreferences("mapsdk_pref", 0).edit();
    localEditor.putBoolean("worldEnable", paramBoolean);
    localEditor.commit();
  }
  
  public static void n() {}
  
  public static boolean q()
  {
    return q;
  }
  
  public static boolean r()
  {
    return s;
  }
  
  public static int s()
  {
    return u;
  }
  
  public static int t()
  {
    return v;
  }
  
  public static int u()
  {
    return w;
  }
  
  public static String v()
  {
    return z;
  }
  
  public static int w()
  {
    return t;
  }
  
  public static int x()
  {
    return y;
  }
  
  public static int y()
  {
    return x;
  }
  
  public final boolean A()
  {
    return this.C;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 2) {
      this.l.a(true);
    }
    for (;;)
    {
      this.n = paramInt;
      a(false, false);
      return;
      this.l.a(false);
    }
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: aload_0
    //   10: getfield 119	com/tencent/mapsdk/rastercore/d/e:A	Z
    //   13: ifne +7 -> 20
    //   16: iload_2
    //   17: putstatic 92	com/tencent/mapsdk/rastercore/d/e:y	I
    //   20: iload_1
    //   21: putstatic 316	com/tencent/mapsdk/rastercore/b:e	I
    //   24: iload_3
    //   25: putstatic 80	com/tencent/mapsdk/rastercore/d/e:t	I
    //   28: iload 6
    //   30: putstatic 84	com/tencent/mapsdk/rastercore/d/e:u	I
    //   33: iload 5
    //   35: putstatic 86	com/tencent/mapsdk/rastercore/d/e:v	I
    //   38: iload 4
    //   40: putstatic 88	com/tencent/mapsdk/rastercore/d/e:w	I
    //   43: aload_0
    //   44: getfield 226	com/tencent/mapsdk/rastercore/d/e:h	Lcom/tencent/mapsdk/rastercore/tile/a$1;
    //   47: iload_2
    //   48: invokevirtual 318	com/tencent/mapsdk/rastercore/tile/a$1:a	(I)V
    //   51: aload_0
    //   52: getfield 226	com/tencent/mapsdk/rastercore/d/e:h	Lcom/tencent/mapsdk/rastercore/tile/a$1;
    //   55: iload_3
    //   56: invokevirtual 319	com/tencent/mapsdk/rastercore/tile/a$1:b	(I)V
    //   59: aload_0
    //   60: getfield 194	com/tencent/mapsdk/rastercore/d/e:l	Lcom/tencent/mapsdk/rastercore/g/b;
    //   63: ifnull +12 -> 75
    //   66: aload_0
    //   67: getfield 194	com/tencent/mapsdk/rastercore/d/e:l	Lcom/tencent/mapsdk/rastercore/g/b;
    //   70: aload 7
    //   72: invokevirtual 322	com/tencent/mapsdk/rastercore/g/b:a	(Landroid/graphics/Bitmap;)V
    //   75: invokestatic 164	com/tencent/mapsdk/rastercore/d$a:a	()Lcom/tencent/mapsdk/rastercore/d$a;
    //   78: pop
    //   79: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   82: lstore 8
    //   84: invokestatic 141	com/tencent/mapsdk/rastercore/tile/a/a:a	()Lcom/tencent/mapsdk/rastercore/tile/a/a;
    //   87: invokevirtual 330	com/tencent/mapsdk/rastercore/tile/a/a:c	()Ljava/lang/String;
    //   90: astore 15
    //   92: aload 15
    //   94: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +11 -> 108
    //   100: aload 15
    //   102: invokestatic 339	com/tencent/mapsdk/rastercore/d$a:b	(Ljava/lang/String;)Z
    //   105: ifne +4 -> 109
    //   108: return
    //   109: new 341	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   116: aload 15
    //   118: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: getstatic 351	java/io/File:separator	Ljava/lang/String;
    //   124: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc_w 353
    //   130: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 10
    //   138: new 358	java/util/Properties
    //   141: dup
    //   142: invokespecial 359	java/util/Properties:<init>	()V
    //   145: astore 16
    //   147: new 348	java/io/File
    //   150: dup
    //   151: aload 10
    //   153: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;)V
    //   156: astore 7
    //   158: aload 7
    //   160: invokevirtual 364	java/io/File:exists	()Z
    //   163: ifeq +225 -> 388
    //   166: aload 7
    //   168: invokevirtual 367	java/io/File:isFile	()Z
    //   171: ifeq +217 -> 388
    //   174: new 369	java/io/FileInputStream
    //   177: dup
    //   178: aload 10
    //   180: invokespecial 370	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   183: astore 7
    //   185: aload 7
    //   187: astore 11
    //   189: aload 16
    //   191: aload 7
    //   193: invokevirtual 374	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   196: aload 16
    //   198: ldc_w 376
    //   201: lload 8
    //   203: invokestatic 382	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   206: invokevirtual 386	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: new 388	java/io/FileOutputStream
    //   213: dup
    //   214: aload 10
    //   216: invokespecial 389	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   219: astore 10
    //   221: aload 16
    //   223: aload 10
    //   225: ldc_w 391
    //   228: invokevirtual 395	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   231: aload 7
    //   233: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   236: aload 10
    //   238: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   241: return
    //   242: astore 10
    //   244: aconst_null
    //   245: astore 7
    //   247: aload 13
    //   249: astore 12
    //   251: aload 7
    //   253: astore 11
    //   255: new 341	java/lang/StringBuilder
    //   258: dup
    //   259: ldc_w 400
    //   262: invokespecial 401	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   265: aload 15
    //   267: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc_w 403
    //   273: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 10
    //   278: invokevirtual 406	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   281: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 7
    //   287: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   290: aload 13
    //   292: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   295: return
    //   296: astore 7
    //   298: aconst_null
    //   299: astore 10
    //   301: aload 14
    //   303: astore 12
    //   305: aload 10
    //   307: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   310: aload 12
    //   312: invokestatic 398	com/tencent/mapsdk/rastercore/d$a:a	(Ljava/io/Closeable;)V
    //   315: aload 7
    //   317: athrow
    //   318: astore 7
    //   320: aload 11
    //   322: astore 10
    //   324: goto -19 -> 305
    //   327: astore 11
    //   329: aload 7
    //   331: astore 10
    //   333: aload 11
    //   335: astore 7
    //   337: aload 14
    //   339: astore 12
    //   341: goto -36 -> 305
    //   344: astore 12
    //   346: aload 7
    //   348: astore 11
    //   350: aload 12
    //   352: astore 7
    //   354: aload 10
    //   356: astore 12
    //   358: aload 11
    //   360: astore 10
    //   362: goto -57 -> 305
    //   365: astore 10
    //   367: goto -120 -> 247
    //   370: astore 10
    //   372: goto -125 -> 247
    //   375: astore 11
    //   377: aload 10
    //   379: astore 13
    //   381: aload 11
    //   383: astore 10
    //   385: goto -138 -> 247
    //   388: aconst_null
    //   389: astore 7
    //   391: goto -195 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	e
    //   0	394	1	paramInt1	int
    //   0	394	2	paramInt2	int
    //   0	394	3	paramInt3	int
    //   0	394	4	paramInt4	int
    //   0	394	5	paramInt5	int
    //   0	394	6	paramInt6	int
    //   0	394	7	paramBitmap	Bitmap
    //   82	120	8	l1	long
    //   136	101	10	localObject1	Object
    //   242	35	10	localException1	java.lang.Exception
    //   299	62	10	localObject2	Object
    //   365	1	10	localException2	java.lang.Exception
    //   370	8	10	localException3	java.lang.Exception
    //   383	1	10	localObject3	Object
    //   187	134	11	localBitmap1	Bitmap
    //   327	7	11	localObject4	Object
    //   348	11	11	localBitmap2	Bitmap
    //   375	7	11	localException4	java.lang.Exception
    //   4	336	12	localObject5	Object
    //   344	7	12	localObject6	Object
    //   356	1	12	localObject7	Object
    //   7	373	13	localObject8	Object
    //   1	337	14	localObject9	Object
    //   90	176	15	str	String
    //   145	77	16	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   138	185	242	java/lang/Exception
    //   138	185	296	finally
    //   189	196	318	finally
    //   255	285	318	finally
    //   196	221	327	finally
    //   221	231	344	finally
    //   189	196	365	java/lang/Exception
    //   196	221	370	java/lang/Exception
    //   221	231	375	java/lang/Exception
  }
  
  public final void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.k.e(paramBundle.getBoolean("ANIMATION_ENABLED", true));
      this.k.b(paramBundle.getBoolean("SCROLL_ENABLED", true));
      this.k.c(paramBundle.getBoolean("ZOOM_ENABLED", true));
      this.k.b(paramBundle.getInt("LOGO_POSITION", 0));
      this.k.c(paramBundle.getInt("SCALEVIEW_POSITION", 0));
      this.k.a(paramBundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
      this.f.b(paramBundle.getDouble("ZOOM", this.f.c()), false, null);
      Double localDouble = Double.valueOf(paramBundle.getDouble("CENTERX", (0.0D / 0.0D)));
      paramBundle = Double.valueOf(paramBundle.getDouble("CENTERY", (0.0D / 0.0D)));
      if ((!localDouble.isNaN()) && (!paramBundle.isNaN())) {
        this.f.a(new com.tencent.mapsdk.rastercore.b.c(localDouble.doubleValue(), paramBundle.doubleValue()));
      }
    }
  }
  
  public final void a(TencentMap.OnScreenShotListener paramOnScreenShotListener)
  {
    a(paramOnScreenShotListener, null);
  }
  
  public final void a(TencentMap.OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    this.o = paramOnScreenShotListener;
    this.r = paramRect;
    if (this.p)
    {
      o();
      return;
    }
    this.f.a(true);
    a(false, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.m.setVisibility(0);
      this.m.d();
      return;
    }
    com.tencent.mapsdk.rastercore.g.a locala = this.m;
    com.tencent.mapsdk.rastercore.g.a.b();
    locala = this.m;
    com.tencent.mapsdk.rastercore.g.a.c();
    this.m.setVisibility(8);
  }
  
  public final void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    this.d.post(new Runnable()
    {
      public final void run()
      {
        e.a(e.this, false);
        e.a(e.this).a(paramBoolean1, paramBoolean2);
        e.b(e.this).layout();
        e.b(e.this).postInvalidate();
      }
    });
  }
  
  public final c b()
  {
    return this.j;
  }
  
  public final void b(int paramInt)
  {
    if (this.l != null)
    {
      this.l.a(paramInt);
      this.l.invalidate();
      if (this.m.getVisibility() == 0) {
        this.m.invalidate();
      }
    }
  }
  
  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("ANIMATION_ENABLED", this.k.k());
    paramBundle.putBoolean("SCROLL_ENABLED", this.k.h());
    paramBundle.putBoolean("ZOOM_ENABLED", this.k.i());
    paramBundle.putInt("LOGO_POSITION", this.k.j());
    paramBundle.putInt("SCALEVIEW_POSITION", this.k.f());
    paramBundle.putBoolean("SCALE_CONTROLL_ENABLED", this.k.g());
    paramBundle.putDouble("ZOOM", this.f.c());
    paramBundle.putDouble("CENTERX", this.f.b().b());
    paramBundle.putDouble("CENTERY", this.f.b().a());
  }
  
  protected final void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public final b c()
  {
    return this.f;
  }
  
  public final void c(int paramInt)
  {
    if ((this.m != null) && (this.m.getVisibility() == 0))
    {
      this.m.a(paramInt);
      this.m.invalidate();
    }
  }
  
  public final MapView d()
  {
    return this.d;
  }
  
  public final a e()
  {
    return this.e;
  }
  
  public final a.1 f()
  {
    return this.k;
  }
  
  public final void f(boolean paramBoolean)
  {
    this.C = true;
  }
  
  public final com.tencent.mapsdk.rastercore.tile.a.1 g()
  {
    return this.h;
  }
  
  public final f h()
  {
    return this.g;
  }
  
  public final com.tencent.mapsdk.rastercore.tile.e i()
  {
    return this.i;
  }
  
  public final void j()
  {
    this.m.e();
  }
  
  public final void k()
  {
    this.m.d();
  }
  
  public final int l()
  {
    return this.n;
  }
  
  public final void m()
  {
    this.m.a();
    this.l.a();
    this.e.b();
    this.d.stopAnimation();
    this.d.removeAllViews();
    this.h.a();
    a(a, "1");
    a(b, "2");
    System.gc();
  }
  
  protected final void o()
  {
    if (this.o != null)
    {
      this.d.setDrawingCacheEnabled(true);
      this.d.buildDrawingCache();
      if (this.r != null) {
        break label58;
      }
    }
    label58:
    for (Bitmap localBitmap = Bitmap.createBitmap(this.d.getDrawingCache());; localBitmap = Bitmap.createBitmap(this.d.getDrawingCache(), this.r.left, this.r.top, this.r.width(), this.r.height()))
    {
      this.d.destroyDrawingCache();
      this.o.onMapScreenShot(localBitmap);
      return;
    }
  }
  
  public final void p()
  {
    if (this.l != null) {
      this.l.invalidate();
    }
  }
  
  public final boolean z()
  {
    return !this.B;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.d.e
 * JD-Core Version:    0.7.0.1
 */