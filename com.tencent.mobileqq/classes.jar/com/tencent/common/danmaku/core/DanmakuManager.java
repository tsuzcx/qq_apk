package com.tencent.common.danmaku.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.data.BaseDanmaku;
import com.tencent.common.danmaku.inject.DanmakuContext;
import com.tencent.common.danmaku.render.BaseDanmakuRender;
import com.tencent.common.danmaku.render.DanmakuViewFactory;
import com.tencent.common.danmaku.render.IDanmakuView;
import com.tencent.common.danmaku.render.IDanmakuView.CallBack;
import com.tencent.common.danmaku.render.SurfaceDanmakuView;
import com.tencent.common.danmaku.tool.ClickResult;
import com.tencent.common.danmaku.tool.DanmakuDrawTimer;
import com.tencent.common.danmaku.tool.PlayerTimer;
import com.tencent.common.danmaku.tool.TouchPoint;
import com.tencent.common.danmaku.util.DanmakuUncaughtExceptionHandler;
import com.tencent.common.danmaku.util.DanmakuUtils;
import com.tencent.common.danmaku.util.DrawUtils;
import com.tencent.common.danmaku.util.Logger;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class DanmakuManager
  implements View.OnTouchListener, IDanmakuView.CallBack
{
  private static final DecimalFormat F = new DecimalFormat("00.00");
  private static final DecimalFormat G = new DecimalFormat("00");
  private long A;
  private int B;
  private int C;
  private int D;
  private String E;
  private DanmakuManager.DanmakuHandlerCallback H = new DanmakuManager.DanmakuHandlerCallback(this, null);
  private Choreographer I;
  protected final IDanmakuView a;
  protected DanmakuDrawTimer b;
  protected boolean c;
  protected volatile boolean d = true;
  protected long e;
  protected long f;
  protected DanmakuContext g;
  protected final Queue<TouchPoint> h = new LinkedBlockingDeque();
  protected final List<BaseDanmaku> i = new LinkedList();
  protected final AbsWindow j;
  protected volatile DanmakuManager.IDanmakuListener k;
  Choreographer.FrameCallback l;
  private volatile boolean m;
  private volatile boolean n;
  private volatile boolean o;
  private Handler p;
  private HandlerThread q;
  private final DanmakuDataSource r;
  private final DanmakuFactory s;
  private final CacheDrawManager t;
  private final DanmakuMeasureManager u;
  private final PlayerTimer v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  public DanmakuManager(View paramView, DanmakuContext paramDanmakuContext)
  {
    this.g = paramDanmakuContext;
    this.a = DanmakuViewFactory.a(paramView);
    paramView = this.a;
    if (paramView != null)
    {
      paramView.a(this);
      this.a.a(this);
    }
    this.v = new PlayerTimer();
    this.b = new DanmakuDrawTimer();
    this.t = new CacheDrawManager();
    this.u = new DanmakuMeasureManager(paramDanmakuContext);
    paramView = new DanmakuManager.DanmakuComparator();
    this.r = new DanmakuDataSource(this.v, paramView);
    this.r.a(paramDanmakuContext.l());
    this.j = AbsWindow.a(paramDanmakuContext, this.t, paramView, this.v, this.b);
    this.s = new DanmakuFactory(paramDanmakuContext);
  }
  
  private boolean A()
  {
    return this.a instanceof SurfaceDanmakuView;
  }
  
  private void B()
  {
    this.v.a(p());
    this.b.c();
    if (Logger.a >= 5) {
      Logger.a("DanmakuManager", new Object[] { "updateFrame:currentTime:", Long.valueOf(this.b.b()), ",lastInterval:", Long.valueOf(this.b.e()) });
    }
  }
  
  private void C()
  {
    this.j.b();
  }
  
  /* Error */
  private void D()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   8: invokeinterface 215 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +39 -> 54
    //   18: aload_3
    //   19: astore_2
    //   20: aload_3
    //   21: astore_1
    //   22: aload_3
    //   23: invokestatic 220	com/tencent/common/danmaku/util/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 169	com/tencent/common/danmaku/core/DanmakuManager:j	Lcom/tencent/common/danmaku/core/AbsWindow;
    //   34: aload_3
    //   35: aload_0
    //   36: getfield 127	com/tencent/common/danmaku/core/DanmakuManager:v	Lcom/tencent/common/danmaku/tool/PlayerTimer;
    //   39: invokevirtual 222	com/tencent/common/danmaku/tool/PlayerTimer:a	()J
    //   42: invokevirtual 225	com/tencent/common/danmaku/core/AbsWindow:a	(Landroid/graphics/Canvas;J)V
    //   45: aload_3
    //   46: astore_2
    //   47: aload_3
    //   48: astore_1
    //   49: aload_0
    //   50: aload_3
    //   51: invokespecial 227	com/tencent/common/danmaku/core/DanmakuManager:b	(Landroid/graphics/Canvas;)V
    //   54: aload_3
    //   55: ifnull +200 -> 255
    //   58: aload_0
    //   59: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   62: invokeinterface 229 1 0
    //   67: ifeq +9 -> 76
    //   70: aload_0
    //   71: aload_3
    //   72: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   75: return
    //   76: aload_0
    //   77: monitorenter
    //   78: aload_0
    //   79: aload_3
    //   80: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: new 232	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   99: astore 4
    //   101: aload_3
    //   102: astore_1
    //   103: aload 4
    //   105: ldc 235
    //   107: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: aload_1
    //   114: invokevirtual 242	java/lang/Object:hashCode	()I
    //   117: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: ldc 247
    //   123: aload 4
    //   125: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: aload_2
    //   129: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: return
    //   133: astore_1
    //   134: goto +122 -> 256
    //   137: astore 4
    //   139: aload_1
    //   140: astore_2
    //   141: new 232	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   148: astore 5
    //   150: aload_1
    //   151: astore_2
    //   152: aload 5
    //   154: ldc_w 256
    //   157: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_1
    //   162: ifnonnull +10 -> 172
    //   165: ldc_w 258
    //   168: astore_3
    //   169: goto +13 -> 182
    //   172: aload_1
    //   173: astore_2
    //   174: aload_1
    //   175: invokevirtual 242	java/lang/Object:hashCode	()I
    //   178: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: astore_3
    //   182: aload_1
    //   183: astore_2
    //   184: aload 5
    //   186: aload_3
    //   187: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: astore_2
    //   193: ldc 247
    //   195: aload 5
    //   197: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aload 4
    //   202: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_1
    //   206: ifnull +49 -> 255
    //   209: aload_0
    //   210: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   213: invokeinterface 229 1 0
    //   218: ifeq +9 -> 227
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   226: return
    //   227: aload_0
    //   228: monitorenter
    //   229: aload_0
    //   230: aload_1
    //   231: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   234: aload_0
    //   235: monitorexit
    //   236: return
    //   237: astore_2
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_2
    //   241: athrow
    //   242: astore_2
    //   243: new 232	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   250: astore 4
    //   252: goto -149 -> 103
    //   255: return
    //   256: aload_2
    //   257: ifnull +79 -> 336
    //   260: aload_0
    //   261: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   264: invokeinterface 229 1 0
    //   269: ifeq +11 -> 280
    //   272: aload_0
    //   273: aload_2
    //   274: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   277: goto +59 -> 336
    //   280: aload_0
    //   281: monitorenter
    //   282: aload_0
    //   283: aload_2
    //   284: invokespecial 230	com/tencent/common/danmaku/core/DanmakuManager:a	(Landroid/graphics/Canvas;)V
    //   287: aload_0
    //   288: monitorexit
    //   289: goto +47 -> 336
    //   292: astore_3
    //   293: aload_0
    //   294: monitorexit
    //   295: aload_3
    //   296: athrow
    //   297: astore_3
    //   298: new 232	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   305: astore 4
    //   307: aload 4
    //   309: ldc 235
    //   311: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 4
    //   317: aload_2
    //   318: invokevirtual 242	java/lang/Object:hashCode	()I
    //   321: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: ldc 247
    //   327: aload 4
    //   329: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: aload_3
    //   333: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: goto +5 -> 341
    //   339: aload_1
    //   340: athrow
    //   341: goto -2 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	DanmakuManager
    //   1	48	1	localObject1	Object
    //   86	4	1	localObject2	Object
    //   102	12	1	localObject3	Object
    //   133	207	1	localCanvas1	Canvas
    //   3	44	2	localObject4	Object
    //   91	38	2	localThrowable1	Throwable
    //   140	53	2	localCanvas2	Canvas
    //   237	4	2	localObject5	Object
    //   242	76	2	localThrowable2	Throwable
    //   13	174	3	localObject6	Object
    //   292	4	3	localObject7	Object
    //   297	36	3	localThrowable3	Throwable
    //   99	25	4	localStringBuilder1	StringBuilder
    //   137	64	4	localThrowable4	Throwable
    //   250	78	4	localStringBuilder2	StringBuilder
    //   148	48	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   78	85	86	finally
    //   87	89	86	finally
    //   58	75	91	java/lang/Throwable
    //   76	78	91	java/lang/Throwable
    //   89	91	91	java/lang/Throwable
    //   4	14	133	finally
    //   22	26	133	finally
    //   30	45	133	finally
    //   49	54	133	finally
    //   141	150	133	finally
    //   152	161	133	finally
    //   174	182	133	finally
    //   184	191	133	finally
    //   193	205	133	finally
    //   4	14	137	java/lang/Throwable
    //   22	26	137	java/lang/Throwable
    //   30	45	137	java/lang/Throwable
    //   49	54	137	java/lang/Throwable
    //   229	236	237	finally
    //   238	240	237	finally
    //   209	226	242	java/lang/Throwable
    //   227	229	242	java/lang/Throwable
    //   240	242	242	java/lang/Throwable
    //   282	289	292	finally
    //   293	295	292	finally
    //   260	277	297	java/lang/Throwable
    //   280	282	297	java/lang/Throwable
    //   295	297	297	java/lang/Throwable
  }
  
  private void E()
  {
    this.i.addAll(this.j.e());
    this.j.f();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)localIterator.next();
      Bitmap localBitmap = localBaseDanmaku.K();
      if (localBitmap != null)
      {
        localBaseDanmaku.a(null);
        localBaseDanmaku.O();
        this.t.a(localBitmap);
      }
    }
    if (this.k != null) {
      this.k.a(this.i);
    }
    b(this.i);
    this.i.clear();
  }
  
  private boolean F()
  {
    boolean bool;
    if ((this.o) && (!this.m) && (this.n)) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isPrepared() = ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", mIsSurfaceCreated = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", mIsQuited = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", mIsPlaying = ");
    localStringBuilder.append(this.n);
    Logger.a("DanmakuManager", localStringBuilder.toString());
    return bool;
  }
  
  private boolean G()
  {
    return (this.o) && (!this.m) && (T());
  }
  
  private void H()
  {
    Logger.c("DanmakuManager", "handleResume()");
    if (!this.n)
    {
      long l1 = o();
      this.w = (l1 - this.x);
      if (Logger.a >= 5)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleResume, mBaseTime = ");
        localStringBuilder.append(this.w);
        localStringBuilder.append(", currentTime = ");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mPauseTime = ");
        localStringBuilder.append(this.x);
        Logger.b("DanmakuManager", localStringBuilder.toString());
      }
      this.b.d();
    }
    this.n = true;
    this.E = null;
    I();
    if (Logger.a >= 5) {
      Logger.b("DanmakuManager", new Object[] { "message resume:mPausedTime:", Long.valueOf(this.x), ",mBaseTime:", Long.valueOf(this.w) });
    }
  }
  
  private void I()
  {
    Logger.a("DanmakuManager", "resumeUpdateMessage()");
    if (n()) {
      a(4);
    }
  }
  
  private void J()
  {
    Logger.a("DanmakuManager", "removeUpdateMessage()");
    Handler localHandler = this.p;
    if (localHandler != null) {
      localHandler.removeMessages(4);
    }
  }
  
  @RequiresApi(api=16)
  private void K()
  {
    if (this.l == null)
    {
      this.l = new DanmakuManager.1(this);
      this.I.postFrameCallback(this.l);
    }
  }
  
  @RequiresApi(api=16)
  private void L()
  {
    this.p.post(new DanmakuManager.2(this));
  }
  
  private void M()
  {
    Logger.c("DanmakuManager", "handlePause()");
    J();
    this.n = false;
    long l1;
    if (this.g.d()) {
      l1 = this.v.a();
    } else {
      l1 = this.b.b();
    }
    this.x = l1;
    if (Logger.a >= 5) {
      Logger.a("DanmakuManager", new Object[] { "message pause:mPausedTime:", Long.valueOf(this.x) });
    }
  }
  
  private void N()
  {
    Logger.c("DanmakuManager", "handleQuit()");
    this.m = true;
    this.g.g();
    this.r.d();
    this.t.e();
    Logger.c("DanmakuManager", "message quit");
  }
  
  private void O()
  {
    Logger.c("DanmakuManager", "handleConfigChanged()");
    this.j.a();
    this.r.f();
    Logger.c("DanmakuManager", "message config changed");
  }
  
  private void P()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((DanmakuContext)localObject).j();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((BaseDanmakuRender)((Iterator)localObject).next()).a();
        }
      }
    }
  }
  
  private void Q()
  {
    if (this.q != null)
    {
      if (DanmakuUtils.a())
      {
        this.q.quitSafely();
        return;
      }
      this.q.quit();
    }
  }
  
  private void R()
  {
    Logger.c("DanmakuManager", "handleClear()");
    this.j.c();
    this.g.g();
    this.r.d();
  }
  
  private void S()
  {
    if (this.k != null) {
      while (!this.h.isEmpty())
      {
        TouchPoint localTouchPoint = (TouchPoint)this.h.poll();
        BaseDanmaku localBaseDanmaku = this.j.a(localTouchPoint);
        if (Logger.a >= 4) {
          Logger.a("DanmakuManager", new Object[] { "handleClick:", localTouchPoint, ",currentTime:", Long.valueOf(o()) });
        }
        DanmakuDependImp.a().b().c().post(new DanmakuManager.3(this, localBaseDanmaku, localTouchPoint));
      }
    }
    Logger.a("DanmakuManager", "message click");
  }
  
  private boolean T()
  {
    if (A()) {
      return (z()) && (this.p != null);
    }
    return this.p != null;
  }
  
  private void U()
  {
    Logger.c("surface_lock", "handleClearDrawingCache");
    J();
    if (this.a.f()) {
      if (this.o) {
        break label46;
      }
    }
    try
    {
      if (!this.o) {
        return;
      }
      label46:
      V();
      return;
    }
    finally {}
  }
  
  /* Error */
  private void V()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   8: invokeinterface 215 1 0
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +88 -> 103
    //   18: aload_3
    //   19: astore_1
    //   20: aload_3
    //   21: astore_2
    //   22: aload_3
    //   23: invokestatic 220	com/tencent/common/danmaku/util/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   26: aload_3
    //   27: astore_1
    //   28: aload_3
    //   29: astore_2
    //   30: new 232	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   37: astore 5
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: astore_2
    //   43: aload 5
    //   45: ldc_w 514
    //   48: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_3
    //   53: ifnonnull +11 -> 64
    //   56: ldc_w 258
    //   59: astore 4
    //   61: goto +16 -> 77
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: astore_2
    //   68: aload_3
    //   69: invokevirtual 242	java/lang/Object:hashCode	()I
    //   72: invokestatic 263	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: astore 4
    //   77: aload_3
    //   78: astore_1
    //   79: aload_3
    //   80: astore_2
    //   81: aload 5
    //   83: aload 4
    //   85: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_3
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: ldc 247
    //   95: aload 5
    //   97: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 342	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_3
    //   104: ifnull +90 -> 194
    //   107: aload_0
    //   108: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   111: aload_3
    //   112: invokeinterface 515 2 0
    //   117: new 232	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   124: astore_1
    //   125: aload_1
    //   126: ldc_w 517
    //   129: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: aload_3
    //   135: invokevirtual 242	java/lang/Object:hashCode	()I
    //   138: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 247
    //   144: aload_1
    //   145: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 342	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto +43 -> 194
    //   154: astore_1
    //   155: aload_3
    //   156: ifnull +38 -> 194
    //   159: new 232	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc_w 519
    //   171: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: aload_3
    //   177: invokevirtual 242	java/lang/Object:hashCode	()I
    //   180: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: ldc 247
    //   186: aload_2
    //   187: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: aload_1
    //   191: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: invokestatic 487	com/tencent/common/danmaku/DanmakuDependImp:a	()Lcom/tencent/common/danmaku/DanmakuDependImp;
    //   197: invokevirtual 490	com/tencent/common/danmaku/DanmakuDependImp:b	()Lcom/tencent/common/danmaku/IDanmakuDepend;
    //   200: invokeinterface 495 1 0
    //   205: astore_1
    //   206: new 521	com/tencent/common/danmaku/core/DanmakuManager$4
    //   209: dup
    //   210: aload_0
    //   211: invokespecial 522	com/tencent/common/danmaku/core/DanmakuManager$4:<init>	(Lcom/tencent/common/danmaku/core/DanmakuManager;)V
    //   214: astore_2
    //   215: goto +294 -> 509
    //   218: astore_2
    //   219: goto +58 -> 277
    //   222: astore_3
    //   223: aload_2
    //   224: ifnull +173 -> 397
    //   227: aload_2
    //   228: astore_1
    //   229: new 232	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   236: astore 4
    //   238: aload_2
    //   239: astore_1
    //   240: aload 4
    //   242: ldc_w 524
    //   245: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_2
    //   250: astore_1
    //   251: aload 4
    //   253: aload_2
    //   254: invokevirtual 242	java/lang/Object:hashCode	()I
    //   257: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_2
    //   262: astore_1
    //   263: ldc 247
    //   265: aload 4
    //   267: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: aload_3
    //   271: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: goto +123 -> 397
    //   277: aload_1
    //   278: ifnull +94 -> 372
    //   281: aload_0
    //   282: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   285: aload_1
    //   286: invokeinterface 515 2 0
    //   291: new 232	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   298: astore_3
    //   299: aload_3
    //   300: ldc_w 517
    //   303: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_3
    //   308: aload_1
    //   309: invokevirtual 242	java/lang/Object:hashCode	()I
    //   312: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: ldc 247
    //   318: aload_3
    //   319: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 342	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto +47 -> 372
    //   328: astore_3
    //   329: aload_1
    //   330: ifnull +42 -> 372
    //   333: new 232	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   340: astore 4
    //   342: aload 4
    //   344: ldc_w 519
    //   347: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 4
    //   353: aload_1
    //   354: invokevirtual 242	java/lang/Object:hashCode	()I
    //   357: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: ldc 247
    //   363: aload 4
    //   365: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aload_3
    //   369: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   372: invokestatic 487	com/tencent/common/danmaku/DanmakuDependImp:a	()Lcom/tencent/common/danmaku/DanmakuDependImp;
    //   375: invokevirtual 490	com/tencent/common/danmaku/DanmakuDependImp:b	()Lcom/tencent/common/danmaku/IDanmakuDepend;
    //   378: invokeinterface 495 1 0
    //   383: new 521	com/tencent/common/danmaku/core/DanmakuManager$4
    //   386: dup
    //   387: aload_0
    //   388: invokespecial 522	com/tencent/common/danmaku/core/DanmakuManager$4:<init>	(Lcom/tencent/common/danmaku/core/DanmakuManager;)V
    //   391: invokevirtual 412	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   394: pop
    //   395: aload_2
    //   396: athrow
    //   397: aload_2
    //   398: ifnull +90 -> 488
    //   401: aload_0
    //   402: getfield 114	com/tencent/common/danmaku/core/DanmakuManager:a	Lcom/tencent/common/danmaku/render/IDanmakuView;
    //   405: aload_2
    //   406: invokeinterface 515 2 0
    //   411: new 232	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   418: astore_1
    //   419: aload_1
    //   420: ldc_w 517
    //   423: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: aload_2
    //   429: invokevirtual 242	java/lang/Object:hashCode	()I
    //   432: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 247
    //   438: aload_1
    //   439: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 342	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto +43 -> 488
    //   448: astore_1
    //   449: aload_2
    //   450: ifnull +38 -> 488
    //   453: new 232	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   460: astore_3
    //   461: aload_3
    //   462: ldc_w 519
    //   465: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_3
    //   470: aload_2
    //   471: invokevirtual 242	java/lang/Object:hashCode	()I
    //   474: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: ldc 247
    //   480: aload_3
    //   481: invokevirtual 251	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: aload_1
    //   485: invokestatic 254	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   488: invokestatic 487	com/tencent/common/danmaku/DanmakuDependImp:a	()Lcom/tencent/common/danmaku/DanmakuDependImp;
    //   491: invokevirtual 490	com/tencent/common/danmaku/DanmakuDependImp:b	()Lcom/tencent/common/danmaku/IDanmakuDepend;
    //   494: invokeinterface 495 1 0
    //   499: astore_1
    //   500: new 521	com/tencent/common/danmaku/core/DanmakuManager$4
    //   503: dup
    //   504: aload_0
    //   505: invokespecial 522	com/tencent/common/danmaku/core/DanmakuManager$4:<init>	(Lcom/tencent/common/danmaku/core/DanmakuManager;)V
    //   508: astore_2
    //   509: aload_1
    //   510: aload_2
    //   511: invokevirtual 412	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   514: pop
    //   515: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	516	0	this	DanmakuManager
    //   3	142	1	localObject1	Object
    //   154	37	1	localThrowable1	Throwable
    //   205	234	1	localObject2	Object
    //   448	37	1	localThrowable2	Throwable
    //   499	11	1	localHandler	Handler
    //   1	214	2	localObject3	Object
    //   218	253	2	localCanvas1	Canvas
    //   508	3	2	local4	DanmakuManager.4
    //   13	164	3	localCanvas2	Canvas
    //   222	49	3	localThrowable3	Throwable
    //   298	21	3	localStringBuilder1	StringBuilder
    //   328	41	3	localThrowable4	Throwable
    //   460	21	3	localStringBuilder2	StringBuilder
    //   59	305	4	localObject4	Object
    //   37	59	5	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   107	151	154	java/lang/Throwable
    //   4	14	218	finally
    //   22	26	218	finally
    //   30	39	218	finally
    //   43	52	218	finally
    //   68	77	218	finally
    //   81	89	218	finally
    //   93	103	218	finally
    //   229	238	218	finally
    //   240	249	218	finally
    //   251	261	218	finally
    //   263	274	218	finally
    //   4	14	222	java/lang/Throwable
    //   22	26	222	java/lang/Throwable
    //   30	39	222	java/lang/Throwable
    //   43	52	222	java/lang/Throwable
    //   68	77	222	java/lang/Throwable
    //   81	89	222	java/lang/Throwable
    //   93	103	222	java/lang/Throwable
    //   281	325	328	java/lang/Throwable
    //   401	445	448	java/lang/Throwable
  }
  
  private void a(int paramInt)
  {
    if (T())
    {
      this.p.removeMessages(paramInt);
      this.p.sendEmptyMessage(paramInt);
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (T())
    {
      this.p.removeMessages(paramInt);
      this.p.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.o)
    {
      this.a.a(paramCanvas);
      return;
    }
    this.a.c();
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.g.i())
    {
      long l2 = o();
      long l3 = l2 - this.y;
      this.B += 1;
      this.D = ((int)(this.D + l3));
      if (l3 > 16L)
      {
        this.C += 1;
        if (Logger.a >= 5)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("a draw block:");
          ((StringBuilder)localObject).append(l3);
          Logger.d("DanmakuManager", ((StringBuilder)localObject).toString());
        }
      }
      Object localObject = this.r.c();
      if (this.B % 60 == 1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Logger.a);
        localStringBuilder.append(",t:");
        localStringBuilder.append(DanmakuUtils.a(o()));
        localStringBuilder.append(",f:");
        long l1;
        if (this.b.e() == 0L) {
          l1 = 1L;
        } else {
          l1 = this.b.e();
        }
        localStringBuilder.append(1000L / l1);
        localStringBuilder.append(",ds:");
        localStringBuilder.append(this.j.d());
        localStringBuilder.append(",ts:");
        localStringBuilder.append(this.r.e());
        localStringBuilder.append(",mt:");
        localStringBuilder.append(G.format(this.z - this.y));
        localStringBuilder.append(",lt:");
        localStringBuilder.append(G.format(this.A - this.z));
        localStringBuilder.append(",dt:");
        localStringBuilder.append(G.format(l2 - this.A));
        localStringBuilder.append(",tt:");
        localStringBuilder.append(G.format(l3));
        localStringBuilder.append(",jp:");
        localStringBuilder.append(F.format(this.C * 100.0F / this.B));
        localStringBuilder.append("%,at:");
        localStringBuilder.append(F.format(this.D / this.B));
        localStringBuilder.append(",fd:");
        if (localObject == null) {
          localObject = "null";
        } else {
          localObject = DanmakuUtils.a(((BaseDanmaku)localObject).x());
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(",cs:");
        localStringBuilder.append(F.format(this.t.b() / 1024.0F / 1024.0F));
        localStringBuilder.append(",uc:");
        localStringBuilder.append(F.format(this.t.c() * 100.0F / this.t.d()));
        this.E = localStringBuilder.toString();
      }
      localObject = this.E;
      if (localObject != null) {
        DrawUtils.a(paramCanvas, (String)localObject);
      }
    }
  }
  
  private void b(List<BaseDanmaku> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)paramList.next();
      this.g.a(localBaseDanmaku).c(localBaseDanmaku);
      this.s.a(localBaseDanmaku);
    }
  }
  
  private void c(Message paramMessage)
  {
    this.m = false;
    this.c = true;
    if (paramMessage.obj != null) {
      this.x = ((Long)paramMessage.obj).longValue();
    } else {
      this.x = 0L;
    }
    this.B = 0;
    this.C = 0;
    this.D = 0;
    this.b.d();
    this.b.a();
    if (Logger.a >= 3) {
      Logger.c("DanmakuManager", new Object[] { "message start:startTime:", Long.valueOf(this.x) });
    }
  }
  
  private void y()
  {
    if (A())
    {
      if (z()) {
        return;
      }
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DanmakuDrawThreadPriority_");
        localStringBuilder.append(this.g.h());
        this.q = new HandlerThread(localStringBuilder.toString(), this.g.h());
        this.q.setUncaughtExceptionHandler(new DanmakuUncaughtExceptionHandler());
        this.q.start();
        this.p = new Handler(this.q.getLooper(), this.H);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.d("DanmakuManager", new Object[] { localThrowable });
        return;
      }
    }
    this.p = new Handler(Looper.getMainLooper(), this.H);
  }
  
  private boolean z()
  {
    HandlerThread localHandlerThread = this.q;
    return (localHandlerThread != null) && (localHandlerThread.isAlive());
  }
  
  public DanmakuManager a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public BaseDanmaku a(int paramInt, Object paramObject)
  {
    return this.s.a(paramInt, paramObject);
  }
  
  public void a()
  {
    a(0L);
  }
  
  public void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start() time = ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    y();
    localObject = Message.obtain();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = Long.valueOf(paramLong);
    b((Message)localObject);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint.y = ((int)(paramPoint.y - this.a.b()));
    paramPoint = new TouchPoint(this.b.b(), paramPoint, paramInt);
    if (Logger.a >= 4) {
      Logger.a("DanmakuManager", new Object[] { "addClickPoint:", paramPoint });
    }
    this.h.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    b(paramPoint);
  }
  
  protected void a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSeek() msg.obj is null = ");
    boolean bool;
    if (paramMessage.obj == null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    Logger.c("DanmakuManager", localStringBuilder.toString());
    if (paramMessage.obj != null)
    {
      this.x = ((Long)paramMessage.obj).longValue();
      this.c = true;
      H();
    }
    if (Logger.a >= 5) {
      Logger.a("DanmakuManager", new Object[] { "message seek:startTime:", Long.valueOf(this.x) });
    }
  }
  
  public void a(DanmakuManager.IDanmakuListener paramIDanmakuListener)
  {
    this.k = paramIDanmakuListener;
  }
  
  public void a(BaseDanmaku paramBaseDanmaku)
  {
    this.j.b(paramBaseDanmaku);
  }
  
  public void a(List<BaseDanmaku> paramList)
  {
    this.u.a(paramList, new DanmakuManager.8(this));
  }
  
  protected boolean a(ClickResult paramClickResult)
  {
    return (m()) && (paramClickResult.a != -1);
  }
  
  public void b()
  {
    Logger.a("DanmakuManager", "resume()");
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    b(localMessage);
  }
  
  public void b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seek(): postime = ");
    ((StringBuilder)localObject).append(paramLong);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    localObject = Message.obtain();
    ((Message)localObject).what = 5;
    ((Message)localObject).obj = Long.valueOf(paramLong);
    b((Message)localObject);
  }
  
  protected void b(Message paramMessage)
  {
    if (T()) {
      this.p.sendMessage(paramMessage);
    }
  }
  
  public void b(BaseDanmaku paramBaseDanmaku)
  {
    paramBaseDanmaku.g(this.v.a());
    this.u.a(paramBaseDanmaku, new DanmakuManager.7(this));
  }
  
  public void c()
  {
    Logger.c("DanmakuManager", "pause()");
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    b(localMessage);
  }
  
  public void c(BaseDanmaku paramBaseDanmaku)
  {
    DanmakuDataSource localDanmakuDataSource = this.r;
    if (localDanmakuDataSource != null) {
      localDanmakuDataSource.b(paramBaseDanmaku);
    }
  }
  
  public void d()
  {
    Logger.c("DanmakuManager", "clearDrawingCache()");
    Message localMessage = Message.obtain();
    localMessage.what = 11;
    b(localMessage);
  }
  
  public void e()
  {
    Logger.a("DanmakuManager", "clear");
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    b(localMessage);
    w();
  }
  
  public void f()
  {
    Logger.a("DanmakuManager", "quit(); mIsQuited = true");
    this.m = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    b(localMessage);
  }
  
  public void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release() mIsQuited = ");
    ((StringBuilder)localObject).append(this.m);
    Logger.a("DanmakuManager", ((StringBuilder)localObject).toString());
    P();
    if (!this.m) {
      f();
    }
    localObject = Message.obtain();
    ((Message)localObject).what = 8;
    b((Message)localObject);
    this.k = null;
  }
  
  public void h()
  {
    Logger.a("DanmakuManager", "notifyConfigChanged()");
    y();
    Message localMessage = Message.obtain();
    localMessage.what = 7;
    b(localMessage);
  }
  
  public boolean i()
  {
    Object localObject = this.j;
    boolean bool3 = localObject instanceof R2LWindow;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if (!((R2LWindow)localObject).g())
      {
        localObject = this.r;
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (!((DanmakuDataSource)localObject).b()) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected void j()
  {
    B();
    if (this.c)
    {
      this.j.c();
      this.c = false;
    }
    try
    {
      if (Logger.a >= 4) {
        this.y = o();
      }
      k();
      if (Logger.a >= 4) {
        this.z = o();
      }
      C();
      if (Logger.a >= 4) {
        this.A = o();
      }
      D();
      E();
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.a("DanmakuManager", localThrowable.toString(), localThrowable);
    }
  }
  
  protected void k()
  {
    Object localObject = this.r.a();
    if (Logger.a >= 4)
    {
      int i1 = ((List)localObject).size();
      if (i1 > 0) {
        Logger.b("DanmakuManager", new Object[] { "new danmaku to draw:", Integer.valueOf(i1) });
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseDanmaku localBaseDanmaku = (BaseDanmaku)((Iterator)localObject).next();
      ((Iterator)localObject).remove();
      if (localBaseDanmaku.a(this.v.a()))
      {
        if (Logger.a >= 4) {
          Logger.c("DanmakuManager", new Object[] { "before measure ", localBaseDanmaku, " is out side" });
        }
        this.i.add(localBaseDanmaku);
      }
      else
      {
        if ((Logger.a >= 4) && (localBaseDanmaku.P()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("must show danmaku upload to Windown :");
          localStringBuilder.append(localBaseDanmaku);
          Logger.b("DanmakuManager", localStringBuilder.toString());
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload, danmaku = ");
        localStringBuilder.append(localBaseDanmaku);
        Logger.c("DanmakuManager", localStringBuilder.toString());
        localBaseDanmaku.h(this.b.b());
        this.j.a(localBaseDanmaku);
      }
    }
  }
  
  public boolean l()
  {
    if (this.a.f()) {
      return F();
    }
    try
    {
      boolean bool = F();
      return bool;
    }
    finally {}
  }
  
  public boolean m()
  {
    if (this.a.f()) {
      return G();
    }
    try
    {
      boolean bool = G();
      return bool;
    }
    finally {}
  }
  
  public boolean n()
  {
    return (!this.m) && (this.n);
  }
  
  public long o()
  {
    return SystemClock.uptimeMillis();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.d)
    {
      if (Logger.a >= 4) {
        Logger.a("DanmakuManager", new Object[] { "onClick:", paramMotionEvent });
      }
      if ((paramMotionEvent.getAction() & 0xFF) == 0) {
        a(new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()), 0);
      }
    }
    return false;
  }
  
  public long p()
  {
    if (this.g.d()) {
      return o() - this.w;
    }
    long l1 = o();
    long l2 = this.e;
    if (l1 - l2 >= 200L)
    {
      this.e = l1;
      l1 = this.g.e();
      this.f = l1;
      return l1;
    }
    return this.f + l1 - l2;
  }
  
  public DanmakuDrawTimer q()
  {
    return this.b;
  }
  
  protected void r()
  {
    if ((this.a.e()) && (Build.VERSION.SDK_INT >= 16))
    {
      if (this.I == null) {
        this.I = Choreographer.getInstance();
      }
      K();
      return;
    }
    Logger.a("DanmakuManager", "handelUpdate()");
    J();
    if (l())
    {
      long l1 = o();
      j();
      a(4, l1 + 16L - o());
    }
  }
  
  protected void s()
  {
    Logger.c("DanmakuManager", "handleRelease()");
    Q();
    this.u.a();
    this.t.a();
  }
  
  public void t()
  {
    Logger.c("surface_lock", "surfaceCreated");
  }
  
  public void u()
  {
    Logger.c("surface_lock", "surfaceChanged");
    if (this.a.f()) {
      this.o = true;
    }
    try
    {
      this.o = true;
      I();
      return;
    }
    finally {}
  }
  
  public void v()
  {
    if (this.a.f()) {
      this.o = false;
    }
    try
    {
      this.o = false;
      Logger.c("surface_lock", "surfaceDestroyed");
      return;
    }
    finally {}
  }
  
  public void w()
  {
    DanmakuDataSource localDanmakuDataSource = this.r;
    if (localDanmakuDataSource != null) {
      localDanmakuDataSource.d();
    }
  }
  
  public void x()
  {
    this.H = null;
    if ((this.l != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.I.removeFrameCallback(this.l);
    }
    Object localObject = this.p;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.p = null;
    }
    localObject = this.a;
    if (localObject != null) {
      ((IDanmakuView)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.core.DanmakuManager
 * JD-Core Version:    0.7.0.1
 */