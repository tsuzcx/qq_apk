package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqcircle.bizparts.danmaku.config.PhotoDanmakuConfig;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.PhotoDanmakuTimer;
import com.tencent.biz.qqcircle.bizparts.danmaku.util.DrawCacheManager;
import com.tencent.biz.qqcircle.utils.DrawUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class PhotoDanmakuManager
  implements Handler.Callback, TextureView.SurfaceTextureListener, View.OnTouchListener, Thread.UncaughtExceptionHandler
{
  private volatile boolean a;
  private volatile boolean b;
  private volatile boolean c;
  private final Handler d;
  private WeakReference<TextureView> e;
  private final PhotoDanmakuManager.DanmakuComparator f;
  private final PhotoDanmakuDataSource g;
  private final PhotoDanmakuFactory h;
  private final DrawCacheManager i;
  private final PhotoDanmakuTimer j;
  private long k;
  private long l;
  private boolean m;
  private volatile boolean n;
  private long o;
  private int p;
  private final Queue<PhotoDanmakuManager.TouchPoint> q = new LinkedBlockingDeque();
  private final List<AbsDanmaku> r = new LinkedList();
  private final AbsWindow s;
  private IDanmakuLisener t;
  private Rect u;
  
  public PhotoDanmakuManager(Context paramContext, TextureView paramTextureView, int paramInt)
  {
    PhotoDanmakuConfig localPhotoDanmakuConfig = PhotoDanmakuConfig.a(paramContext, 1, paramInt);
    this.e = new WeakReference(paramTextureView);
    ((TextureView)this.e.get()).setSurfaceTextureListener(this);
    this.j = new PhotoDanmakuTimer();
    this.i = new DrawCacheManager(paramContext);
    this.f = new PhotoDanmakuManager.DanmakuComparator();
    this.g = new PhotoDanmakuDataSource(this.j, localPhotoDanmakuConfig, this.f);
    this.s = AbsWindow.a(paramContext, this.i, localPhotoDanmakuConfig, this.f, 1);
    this.h = new PhotoDanmakuFactory(paramContext, this.j, paramInt);
    this.d = new Handler(Looper.getMainLooper(), this);
  }
  
  private void a(int paramInt)
  {
    this.d.sendEmptyMessage(paramInt);
  }
  
  private void a(int paramInt, long paramLong)
  {
    this.d.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  private void a(Canvas paramCanvas, List<AbsDanmaku> paramList)
  {
    this.s.a(paramCanvas);
    paramCanvas = paramList.iterator();
    while (paramCanvas.hasNext())
    {
      paramList = (AbsDanmaku)paramCanvas.next();
      paramCanvas.remove();
      while (paramList.g()) {
        paramList.d(j() + 1000L);
      }
      if (paramList.k() == 1)
      {
        if (!paramList.e()) {
          paramList.b(this.s.a());
        }
        this.s.a(paramList);
      }
    }
    this.s.c();
    this.s.d();
    this.s.e();
    this.r.addAll(this.s.g());
    this.s.h();
    this.r.clear();
  }
  
  private void a(Message paramMessage)
  {
    this.a = false;
    this.m = true;
    if (paramMessage.obj != null)
    {
      this.l = ((Long)paramMessage.obj).longValue();
      return;
    }
    this.l = 0L;
  }
  
  private void b(Message paramMessage)
  {
    if (paramMessage.obj != null)
    {
      this.l = ((Long)paramMessage.obj).longValue();
      this.m = true;
      n();
    }
  }
  
  private void c(Message paramMessage)
  {
    this.d.sendMessage(paramMessage);
  }
  
  /* Error */
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 223	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:m	Z
    //   4: ifeq +15 -> 19
    //   7: aload_0
    //   8: getfield 119	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:s	Lcom/tencent/biz/qqcircle/bizparts/danmaku/core/AbsWindow;
    //   11: invokevirtual 246	com/tencent/biz/qqcircle/bizparts/danmaku/core/AbsWindow:f	()V
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 223	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:m	Z
    //   19: aload_0
    //   20: getfield 112	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:g	Lcom/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDataSource;
    //   23: invokevirtual 248	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDataSource:b	()V
    //   26: aload_0
    //   27: getfield 112	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:g	Lcom/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDataSource;
    //   30: invokevirtual 250	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuDataSource:a	()Ljava/util/List;
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +261 -> 302
    //   44: aload_1
    //   45: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   48: ifnonnull +4 -> 52
    //   51: return
    //   52: aconst_null
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   60: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   63: checkcast 84	android/view/TextureView
    //   66: invokevirtual 254	android/view/TextureView:lockCanvas	()Landroid/graphics/Canvas;
    //   69: astore_3
    //   70: aload_3
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: invokestatic 257	com/tencent/biz/qqcircle/utils/DrawUtils:a	(Landroid/graphics/Canvas;)V
    //   78: aload_3
    //   79: astore_1
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: aload_3
    //   84: aload 4
    //   86: invokespecial 259	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:a	(Landroid/graphics/Canvas;Ljava/util/List;)V
    //   89: aload_0
    //   90: getfield 261	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:c	Z
    //   93: ifeq +148 -> 241
    //   96: aload_0
    //   97: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   100: ifnull +141 -> 241
    //   103: aload_0
    //   104: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   107: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   110: ifnull +131 -> 241
    //   113: aload_3
    //   114: ifnull +127 -> 241
    //   117: aload_0
    //   118: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   121: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   124: checkcast 84	android/view/TextureView
    //   127: aload_3
    //   128: invokevirtual 264	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   131: return
    //   132: astore_1
    //   133: ldc_w 266
    //   136: iconst_1
    //   137: aload_1
    //   138: invokevirtual 270	java/lang/Throwable:toString	()Ljava/lang/String;
    //   141: aload_1
    //   142: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: return
    //   146: astore_2
    //   147: goto +95 -> 242
    //   150: astore_3
    //   151: aload_2
    //   152: astore_1
    //   153: new 277	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   160: astore 4
    //   162: aload_2
    //   163: astore_1
    //   164: aload 4
    //   166: ldc_w 280
    //   169: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: astore_1
    //   175: aload 4
    //   177: aload_3
    //   178: invokevirtual 270	java/lang/Throwable:toString	()Ljava/lang/String;
    //   181: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_2
    //   186: astore_1
    //   187: ldc_w 266
    //   190: iconst_1
    //   191: aload 4
    //   193: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: getfield 261	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:c	Z
    //   203: ifeq +38 -> 241
    //   206: aload_0
    //   207: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   210: ifnull +31 -> 241
    //   213: aload_0
    //   214: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   217: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   220: ifnull +21 -> 241
    //   223: aload_2
    //   224: ifnull +17 -> 241
    //   227: aload_0
    //   228: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   231: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   234: checkcast 84	android/view/TextureView
    //   237: aload_2
    //   238: invokevirtual 264	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   241: return
    //   242: aload_0
    //   243: getfield 261	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:c	Z
    //   246: ifeq +54 -> 300
    //   249: aload_0
    //   250: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   253: ifnull +47 -> 300
    //   256: aload_0
    //   257: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   260: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   263: ifnull +37 -> 300
    //   266: aload_1
    //   267: ifnull +33 -> 300
    //   270: aload_0
    //   271: getfield 78	com/tencent/biz/qqcircle/bizparts/danmaku/core/PhotoDanmakuManager:e	Ljava/lang/ref/WeakReference;
    //   274: invokevirtual 82	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   277: checkcast 84	android/view/TextureView
    //   280: aload_1
    //   281: invokevirtual 264	android/view/TextureView:unlockCanvasAndPost	(Landroid/graphics/Canvas;)V
    //   284: goto +16 -> 300
    //   287: astore_1
    //   288: ldc_w 266
    //   291: iconst_1
    //   292: aload_1
    //   293: invokevirtual 270	java/lang/Throwable:toString	()Ljava/lang/String;
    //   296: aload_1
    //   297: invokestatic 275	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   300: aload_2
    //   301: athrow
    //   302: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	PhotoDanmakuManager
    //   39	41	1	localObject1	Object
    //   132	10	1	localThrowable1	Throwable
    //   152	129	1	localObject2	Object
    //   287	10	1	localThrowable2	Throwable
    //   53	29	2	localObject3	Object
    //   146	155	2	localCanvas1	Canvas
    //   69	59	3	localCanvas2	Canvas
    //   150	28	3	localThrowable3	Throwable
    //   33	159	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   96	113	132	java/lang/Throwable
    //   117	131	132	java/lang/Throwable
    //   206	223	132	java/lang/Throwable
    //   227	241	132	java/lang/Throwable
    //   56	70	146	finally
    //   74	78	146	finally
    //   82	89	146	finally
    //   153	162	146	finally
    //   164	173	146	finally
    //   175	185	146	finally
    //   187	199	146	finally
    //   56	70	150	java/lang/Throwable
    //   74	78	150	java/lang/Throwable
    //   82	89	150	java/lang/Throwable
    //   249	266	287	java/lang/Throwable
    //   270	284	287	java/lang/Throwable
  }
  
  private void n()
  {
    this.b = true;
    this.k = (h() - this.l);
    o();
  }
  
  private void o()
  {
    if (g()) {
      a(4);
    }
  }
  
  private void p()
  {
    this.d.removeMessages(4);
  }
  
  private void q()
  {
    p();
    this.o = i();
    if ((f()) && (!this.a))
    {
      this.j.a(this.o);
      m();
      a(4, 8L);
      return;
    }
    a(4, 100L);
  }
  
  private void r()
  {
    p();
    this.b = false;
    this.l = this.j.a();
  }
  
  private void s()
  {
    this.a = true;
    this.g.c();
    this.i.a();
  }
  
  private void t()
  {
    this.s.b();
  }
  
  private void u() {}
  
  private void v()
  {
    this.s.f();
    this.g.c();
    this.t = null;
  }
  
  private void w()
  {
    if (this.t != null) {
      while (!this.q.isEmpty())
      {
        PhotoDanmakuManager.TouchPoint localTouchPoint = (PhotoDanmakuManager.TouchPoint)this.q.poll();
        if (localTouchPoint == null) {
          return;
        }
        AbsDanmaku localAbsDanmaku = this.s.a(localTouchPoint);
        this.t.a(localAbsDanmaku, localTouchPoint);
      }
    }
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    c(localMessage);
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = Long.valueOf(paramLong);
    c(localMessage);
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    paramPoint = new PhotoDanmakuManager.TouchPoint(i(), paramPoint, paramInt);
    this.q.add(paramPoint);
    paramPoint = Message.obtain();
    paramPoint.what = 10;
    c(paramPoint);
  }
  
  public void a(Rect paramRect)
  {
    this.u = paramRect;
  }
  
  public void a(IDanmakuLisener paramIDanmakuLisener)
  {
    this.t = paramIDanmakuLisener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    c(localMessage);
  }
  
  public void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 9;
    c(localMessage);
  }
  
  public void d()
  {
    this.a = true;
    Message localMessage = Message.obtain();
    localMessage.what = 6;
    c(localMessage);
  }
  
  public void e()
  {
    if (!this.a) {
      d();
    }
    Message localMessage = Message.obtain();
    localMessage.what = 8;
    c(localMessage);
  }
  
  public boolean f()
  {
    return (this.c) && (!this.a) && (this.b);
  }
  
  public boolean g()
  {
    return (!this.a) && (this.b);
  }
  
  public long h()
  {
    return System.currentTimeMillis();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      break;
    case 10: 
      w();
      break;
    case 9: 
      v();
      break;
    case 8: 
      u();
      break;
    case 7: 
      t();
      break;
    case 6: 
      s();
      break;
    case 5: 
      b(paramMessage);
      break;
    case 4: 
      q();
      break;
    case 3: 
      r();
      break;
    case 2: 
      n();
      break;
    case 1: 
      a(paramMessage);
      n();
    }
    return false;
  }
  
  public long i()
  {
    return h() - this.k;
  }
  
  public long j()
  {
    return this.j.a();
  }
  
  public PhotoDanmakuFactory k()
  {
    return this.h;
  }
  
  public PhotoDanmakuDataSource l()
  {
    return this.g;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = this.e;
    if (paramSurfaceTexture != null)
    {
      if (paramSurfaceTexture.get() == null) {
        return;
      }
      paramSurfaceTexture = ((TextureView)this.e.get()).lockCanvas();
      if (paramSurfaceTexture != null)
      {
        DrawUtils.a(paramSurfaceTexture);
        ((TextureView)this.e.get()).unlockCanvasAndPost(paramSurfaceTexture);
      }
      this.c = true;
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.c = false;
    p();
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    o();
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    Rect localRect = this.u;
    if ((localRect != null) && (localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      if (this.n)
      {
        QLog.e("PhotoDanmakuManager", 4, new Object[] { "onClick", paramMotionEvent });
        if ((paramMotionEvent.getAction() & 0xFF) == 0) {
          a(paramView, this.p);
        }
      }
      return true;
    }
    return false;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("photoDanmaku crash thread:");
    localStringBuilder.append(paramThread);
    QLog.e("PhotoDanmakuManager", 1, localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuManager
 * JD-Core Version:    0.7.0.1
 */