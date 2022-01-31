package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public abstract class pt
  implements mk, pu
{
  private if a;
  public lw aA;
  public float aB = 0.5F;
  public Handler aC = new Handler();
  public int aD = 0;
  protected IMapRenderView aE = null;
  public jg aF;
  public TencentMapOptions aG;
  public volatile boolean aH;
  public Context ay;
  public pm az;
  private lx b;
  
  public pt(IMapRenderView paramIMapRenderView, Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.aE = paramIMapRenderView;
    this.ay = paramContext;
    this.aG = paramTencentMapOptions;
    if (this.ay != null)
    {
      paramIMapRenderView = jh.a(this);
      if (paramIMapRenderView.a == 0) {
        paramIMapRenderView.a();
      }
      paramIMapRenderView.a += 1;
      this.aF = new jg();
      this.aF.a = System.currentTimeMillis();
      this.a = new if(this);
      if (this.aA == null) {
        this.aA = new lw(this.ay, this);
      }
      this.az = new pm(this.aA);
      this.a.b = this.aA;
      this.aA.E = this.aF;
      paramIMapRenderView = (WindowManager)this.ay.getSystemService("window");
      int i = paramIMapRenderView.getDefaultDisplay().getWidth();
      int j = paramIMapRenderView.getDefaultDisplay().getHeight();
      paramIMapRenderView = this.aA;
      if (paramIMapRenderView.i != null) {
        paramIMapRenderView.i.set(0, 0, i, j);
      }
      this.b = new lx(this.aA);
      this.b.start();
      paramIMapRenderView = this.az;
      if (paramIMapRenderView.b != null) {
        paramIMapRenderView.b.C = this;
      }
      this.aH = true;
    }
  }
  
  public static float b(float paramFloat)
  {
    int i = (int)paramFloat;
    paramFloat = (float)Math.pow(2.0D, paramFloat - i);
    return (1 << i - 3) * 3.051758E-005F * paramFloat;
  }
  
  public final void a(gr paramgr)
  {
    this.a.a(paramgr);
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = this.aA;
    if (paramGL10.a != null)
    {
      paramGL10.q = true;
      paramGL10.i.set(0, 0, paramInt1, paramInt2);
      paramGL10.a(0, 0, paramInt1, paramInt2, false);
      paramGL10 = paramGL10.c;
      Object localObject = paramGL10.k;
      if ((paramGL10.j == null) || (localObject == null)) {
        paramGL10 = paramGL10.c.iterator();
      }
      while (paramGL10.hasNext())
      {
        localObject = (mm)paramGL10.next();
        if (localObject != null)
        {
          try
          {
            ((mm)localObject).a();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          continue;
          paramGL10.k = localException;
          lw locallw;
          if ((paramGL10.h instanceof lw))
          {
            locallw = (lw)paramGL10.h;
            if ((locallw.i != null) && (localException != null)) {
              break label160;
            }
          }
          for (;;)
          {
            paramGL10.d();
            break;
            label160:
            locallw.A = localException;
            paramInt1 = locallw.i.width();
            paramInt2 = locallw.i.height();
            locallw.a(localException.left, localException.bottom, paramInt1 - localException.right - localException.left, paramInt2 - localException.bottom - localException.top, true);
          }
        }
      }
    }
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = this.aA;
    if ((paramGL10.a != null) && (paramGL10.b != null)) {
      paramGL10.b.a();
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (this.b != null)
    {
      this.b.a();
      this.b.a(paramArrayOfByte);
    }
  }
  
  public boolean a(GL10 paramGL10)
  {
    return this.aA.a(paramGL10);
  }
  
  public final Context b()
  {
    return this.ay;
  }
  
  public final void b(gr paramgr)
  {
    if localif = this.a;
    synchronized (localif.a)
    {
      localif.a.b(paramgr);
      return;
    }
  }
  
  public final jg c()
  {
    return this.aF;
  }
  
  public final TencentMapOptions d()
  {
    return this.aG;
  }
  
  public final void e()
  {
    long l;
    jg localjg;
    if (this.aH)
    {
      l = System.currentTimeMillis();
      localjg = this.aF;
      if (localjg != null)
      {
        localjg.a(true);
        if (localjg.c.c <= 0L) {
          break label56;
        }
        localjg.c.b = (l - localjg.a);
      }
    }
    for (;;)
    {
      this.aH = false;
      return;
      label56:
      localjg.c.c = (l - localjg.a);
    }
  }
  
  public int getEGLContextHash()
  {
    Object localObject = (EGL10)EGLContext.getEGL();
    if (localObject != null)
    {
      localObject = ((EGL10)localObject).eglGetCurrentContext();
      if (localObject != null) {
        return localObject.hashCode();
      }
    }
    return 0;
  }
  
  public int getHeight()
  {
    if (this.aE != null) {
      return this.aE.getHeight();
    }
    return 2147483647;
  }
  
  public lf getVectorMapDelegate()
  {
    return this;
  }
  
  public int getWidth()
  {
    if (this.aE != null) {
      return this.aE.getWidth();
    }
    return 2147483647;
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: invokestatic 320	com/tencent/map/sdk/a/oi:a	()V
    //   3: aload_0
    //   4: getfield 67	com/tencent/map/sdk/a/pt:aF	Lcom/tencent/map/sdk/a/jg;
    //   7: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   10: aload_0
    //   11: getfield 67	com/tencent/map/sdk/a/pt:aF	Lcom/tencent/map/sdk/a/jg;
    //   14: getfield 76	com/tencent/map/sdk/a/jg:a	J
    //   17: lsub
    //   18: putfield 321	com/tencent/map/sdk/a/jg:b	J
    //   21: aload_0
    //   22: invokestatic 58	com/tencent/map/sdk/a/jh:a	(Lcom/tencent/map/sdk/a/lf;)Lcom/tencent/map/sdk/a/jh;
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 67	com/tencent/map/sdk/a/pt:aF	Lcom/tencent/map/sdk/a/jg;
    //   30: astore_2
    //   31: aload_1
    //   32: aload_1
    //   33: getfield 60	com/tencent/map/sdk/a/jh:a	I
    //   36: iconst_1
    //   37: isub
    //   38: putfield 60	com/tencent/map/sdk/a/jh:a	I
    //   41: aload_2
    //   42: ifnull +18 -> 60
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_1
    //   48: getfield 323	com/tencent/map/sdk/a/jh:b	Ljava/util/List;
    //   51: aload_2
    //   52: invokeinterface 327 2 0
    //   57: pop
    //   58: aload_1
    //   59: monitorexit
    //   60: aload_1
    //   61: getfield 60	com/tencent/map/sdk/a/jh:a	I
    //   64: ifne +46 -> 110
    //   67: aload_1
    //   68: aload_1
    //   69: getfield 323	com/tencent/map/sdk/a/jh:b	Ljava/util/List;
    //   72: invokevirtual 330	com/tencent/map/sdk/a/jh:a	(Ljava/util/List;)Lorg/json/JSONArray;
    //   75: invokevirtual 336	org/json/JSONArray:toString	()Ljava/lang/String;
    //   78: astore_2
    //   79: aload_1
    //   80: getfield 339	com/tencent/map/sdk/a/jh:c	Ljava/util/concurrent/ExecutorService;
    //   83: new 341	com/tencent/map/sdk/a/jh$2
    //   86: dup
    //   87: aload_1
    //   88: aload_2
    //   89: invokespecial 344	com/tencent/map/sdk/a/jh$2:<init>	(Lcom/tencent/map/sdk/a/jh;Ljava/lang/String;)V
    //   92: invokeinterface 350 2 0
    //   97: aload_1
    //   98: monitorenter
    //   99: aload_1
    //   100: getfield 323	com/tencent/map/sdk/a/jh:b	Ljava/util/List;
    //   103: invokeinterface 353 1 0
    //   108: aload_1
    //   109: monitorexit
    //   110: return
    //   111: astore_2
    //   112: aload_1
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    //   116: astore_2
    //   117: aload_1
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	pt
    //   25	93	1	localjh	jh
    //   30	59	2	localObject1	Object
    //   111	4	2	localObject2	Object
    //   116	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	60	111	finally
    //   112	114	111	finally
    //   99	110	116	finally
    //   117	119	116	finally
  }
  
  /* Error */
  public void onPause()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 141	com/tencent/map/sdk/a/pt:b	Lcom/tencent/map/sdk/a/lx;
    //   4: ifnull +11 -> 15
    //   7: aload_0
    //   8: getfield 141	com/tencent/map/sdk/a/pt:b	Lcom/tencent/map/sdk/a/lx;
    //   11: iconst_1
    //   12: putfield 356	com/tencent/map/sdk/a/lx:a	Z
    //   15: aload_0
    //   16: getfield 85	com/tencent/map/sdk/a/pt:aA	Lcom/tencent/map/sdk/a/lw;
    //   19: astore_1
    //   20: aload_1
    //   21: getfield 195	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   24: ifnull +145 -> 169
    //   27: aload_1
    //   28: iconst_0
    //   29: putfield 198	com/tencent/map/sdk/a/lw:q	Z
    //   32: aload_1
    //   33: iconst_0
    //   34: putfield 359	com/tencent/map/sdk/a/lw:x	Z
    //   37: aload_1
    //   38: getfield 363	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   41: ifnull +12 -> 53
    //   44: aload_1
    //   45: getfield 363	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   48: invokeinterface 366 1 0
    //   53: aload_1
    //   54: getfield 160	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   57: astore_2
    //   58: aload_2
    //   59: getfield 369	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   62: ifnull +26 -> 88
    //   65: aload_2
    //   66: getfield 369	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   69: astore_2
    //   70: aload_2
    //   71: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   74: ifnull +10 -> 84
    //   77: aload_2
    //   78: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   81: invokevirtual 377	com/tencent/map/sdk/a/kf$a:a	()V
    //   84: aload_2
    //   85: invokevirtual 379	com/tencent/map/sdk/a/kf:c	()V
    //   88: aload_1
    //   89: getfield 195	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 384	com/tencent/map/sdk/a/pf:y	()V
    //   97: aload_2
    //   98: getfield 385	com/tencent/map/sdk/a/pf:b	J
    //   101: lconst_0
    //   102: lcmp
    //   103: ifeq +18 -> 121
    //   106: aload_2
    //   107: monitorenter
    //   108: aload_2
    //   109: getfield 388	com/tencent/map/sdk/a/pf:a	Lcom/tencent/map/sdk/engine/jni/JNI;
    //   112: aload_2
    //   113: getfield 385	com/tencent/map/sdk/a/pf:b	J
    //   116: invokevirtual 394	com/tencent/map/sdk/engine/jni/JNI:nativeHideStreetRoad	(J)V
    //   119: aload_2
    //   120: monitorexit
    //   121: aload_2
    //   122: invokevirtual 397	com/tencent/map/sdk/a/pf:z	()V
    //   125: aload_1
    //   126: getfield 399	com/tencent/map/sdk/a/lw:k	Z
    //   129: ifeq +40 -> 169
    //   132: aload_1
    //   133: getfield 402	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   136: ifnull +33 -> 169
    //   139: aload_1
    //   140: getfield 402	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   143: astore_1
    //   144: aload_1
    //   145: getfield 407	com/tencent/map/sdk/a/jq:b	Lcom/tencent/map/sdk/a/jp;
    //   148: ifnull +21 -> 169
    //   151: aload_1
    //   152: getfield 407	com/tencent/map/sdk/a/jq:b	Lcom/tencent/map/sdk/a/jp;
    //   155: astore_1
    //   156: aload_1
    //   157: iconst_1
    //   158: putfield 410	com/tencent/map/sdk/a/jp:a	Z
    //   161: aload_1
    //   162: monitorenter
    //   163: aload_1
    //   164: invokevirtual 413	java/lang/Object:notifyAll	()V
    //   167: aload_1
    //   168: monitorexit
    //   169: return
    //   170: astore_1
    //   171: aload_2
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload_2
    //   177: invokevirtual 397	com/tencent/map/sdk/a/pf:z	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_2
    //   183: aload_1
    //   184: monitorexit
    //   185: aload_2
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	pt
    //   19	149	1	localObject1	Object
    //   170	4	1	localObject2	Object
    //   175	9	1	localObject3	Object
    //   57	120	2	localObject4	Object
    //   182	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   108	121	170	finally
    //   171	173	170	finally
    //   93	108	175	finally
    //   173	175	175	finally
    //   163	169	182	finally
    //   183	185	182	finally
  }
  
  public void onRedraw()
  {
    if (this.aE != null) {
      this.aE.onRedraw();
    }
  }
  
  /* Error */
  public void onResume()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 141	com/tencent/map/sdk/a/pt:b	Lcom/tencent/map/sdk/a/lx;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 141	com/tencent/map/sdk/a/pt:b	Lcom/tencent/map/sdk/a/lx;
    //   11: invokevirtual 265	com/tencent/map/sdk/a/lx:a	()V
    //   14: aload_0
    //   15: getfield 85	com/tencent/map/sdk/a/pt:aA	Lcom/tencent/map/sdk/a/lw;
    //   18: astore_3
    //   19: aload_3
    //   20: getfield 195	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   23: ifnull +177 -> 200
    //   26: aload_3
    //   27: iconst_1
    //   28: putfield 198	com/tencent/map/sdk/a/lw:q	Z
    //   31: aload_3
    //   32: iconst_1
    //   33: putfield 359	com/tencent/map/sdk/a/lw:x	Z
    //   36: aload_3
    //   37: getfield 420	com/tencent/map/sdk/a/lw:r	Z
    //   40: ifeq +161 -> 201
    //   43: aload_3
    //   44: getfield 160	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   47: getfield 369	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   50: astore 4
    //   52: aload 4
    //   54: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   57: ifnull +11 -> 68
    //   60: aload 4
    //   62: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   65: invokevirtual 423	com/tencent/map/sdk/a/kf$a:destroy	()V
    //   68: aload 4
    //   70: new 376	com/tencent/map/sdk/a/kf$a
    //   73: dup
    //   74: aload 4
    //   76: iconst_0
    //   77: invokespecial 426	com/tencent/map/sdk/a/kf$a:<init>	(Lcom/tencent/map/sdk/a/kf;B)V
    //   80: putfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   83: aload 4
    //   85: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   88: invokevirtual 427	com/tencent/map/sdk/a/kf$a:start	()V
    //   91: aload_3
    //   92: iconst_0
    //   93: putfield 420	com/tencent/map/sdk/a/lw:r	Z
    //   96: aload_3
    //   97: getfield 431	com/tencent/map/sdk/a/lw:g	Ljava/lang/ref/WeakReference;
    //   100: ifnull +28 -> 128
    //   103: aload_3
    //   104: getfield 431	com/tencent/map/sdk/a/lw:g	Ljava/lang/ref/WeakReference;
    //   107: invokevirtual 436	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   110: ifnull +18 -> 128
    //   113: aload_3
    //   114: getfield 431	com/tencent/map/sdk/a/lw:g	Ljava/lang/ref/WeakReference;
    //   117: invokevirtual 436	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   120: checkcast 438	com/tencent/map/sdk/a/lf
    //   123: invokeinterface 439 1 0
    //   128: aload_3
    //   129: getfield 441	com/tencent/map/sdk/a/lw:j	Z
    //   132: ifeq +31 -> 163
    //   135: aload_3
    //   136: getfield 195	com/tencent/map/sdk/a/lw:a	Lcom/tencent/map/sdk/a/pf;
    //   139: astore 4
    //   141: aload 4
    //   143: invokevirtual 384	com/tencent/map/sdk/a/pf:y	()V
    //   146: aload 4
    //   148: getfield 385	com/tencent/map/sdk/a/pf:b	J
    //   151: lstore_1
    //   152: lload_1
    //   153: lconst_0
    //   154: lcmp
    //   155: ifne +86 -> 241
    //   158: aload 4
    //   160: invokevirtual 397	com/tencent/map/sdk/a/pf:z	()V
    //   163: aload_3
    //   164: getfield 399	com/tencent/map/sdk/a/lw:k	Z
    //   167: ifeq +17 -> 184
    //   170: aload_3
    //   171: getfield 402	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   174: ifnull +10 -> 184
    //   177: aload_3
    //   178: getfield 402	com/tencent/map/sdk/a/lw:d	Lcom/tencent/map/sdk/a/jq;
    //   181: invokevirtual 443	com/tencent/map/sdk/a/jq:b	()V
    //   184: aload_3
    //   185: getfield 363	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   188: ifnull +12 -> 200
    //   191: aload_3
    //   192: getfield 363	com/tencent/map/sdk/a/lw:v	Lcom/tencent/map/sdk/a/id;
    //   195: invokeinterface 444 1 0
    //   200: return
    //   201: aload_3
    //   202: getfield 160	com/tencent/map/sdk/a/lw:c	Lcom/tencent/map/sdk/a/kl;
    //   205: astore 4
    //   207: aload 4
    //   209: getfield 369	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   212: ifnull -116 -> 96
    //   215: aload 4
    //   217: getfield 369	com/tencent/map/sdk/a/kl:a	Lcom/tencent/map/sdk/a/kf;
    //   220: astore 4
    //   222: aload 4
    //   224: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   227: ifnull -131 -> 96
    //   230: aload 4
    //   232: getfield 374	com/tencent/map/sdk/a/kf:a	Lcom/tencent/map/sdk/a/kf$a;
    //   235: invokevirtual 445	com/tencent/map/sdk/a/kf$a:b	()V
    //   238: goto -142 -> 96
    //   241: aload 4
    //   243: getfield 448	com/tencent/map/sdk/a/pf:f	Lcom/tencent/map/sdk/a/lw;
    //   246: new 450	com/tencent/map/sdk/a/pf$13
    //   249: dup
    //   250: aload 4
    //   252: invokespecial 453	com/tencent/map/sdk/a/pf$13:<init>	(Lcom/tencent/map/sdk/a/pf;)V
    //   255: invokevirtual 456	com/tencent/map/sdk/a/lw:a	(Lcom/tencent/map/sdk/a/lw$a;)V
    //   258: aload 4
    //   260: invokevirtual 397	com/tencent/map/sdk/a/pf:z	()V
    //   263: goto -100 -> 163
    //   266: astore_3
    //   267: aload 4
    //   269: invokevirtual 397	com/tencent/map/sdk/a/pf:z	()V
    //   272: aload_3
    //   273: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	pt
    //   151	2	1	l	long
    //   18	184	3	locallw	lw
    //   266	7	3	localObject1	Object
    //   50	218	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   141	152	266	finally
    //   241	258	266	finally
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return this.a.onTouch(null, paramMotionEvent);
    }
    return false;
  }
  
  public final void r()
  {
    if (this.aA != null)
    {
      getEGLContextHash();
      this.aA.j();
    }
  }
  
  public final void s()
  {
    if (this.aE != null) {
      this.aE.onRedraw();
    }
  }
  
  public void setZOrderMediaOverlay(boolean paramBoolean)
  {
    if (this.aE != null) {
      this.aE.setZOrderMediaOverlay(paramBoolean);
    }
  }
  
  public final void t()
  {
    if (this.aA != null) {
      this.aA.q = true;
    }
  }
  
  public final boolean u()
  {
    Object localObject = this.ay;
    if (localObject == null) {
      return false;
    }
    localObject = (AccessibilityManager)((Context)localObject).getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    if (Build.VERSION.SDK_INT < 14) {
      return bool1;
    }
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    return (bool1) && (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.pt
 * JD-Core Version:    0.7.0.1
 */