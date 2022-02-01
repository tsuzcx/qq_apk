package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.common.danmaku.DanmakuDependImp;
import com.tencent.common.danmaku.IDanmakuDepend;
import com.tencent.common.danmaku.inject.VideoDanmakuConfig;
import com.tencent.common.danmaku.util.Logger;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceDanmakuView
  implements SurfaceHolder.Callback, IDanmakuView
{
  private SurfaceView a;
  private SurfaceHolder b;
  private IDanmakuView.CallBack c;
  private volatile ReentrantLock d;
  private volatile Object e;
  private volatile boolean f;
  private volatile Object g;
  private volatile boolean h = false;
  
  public SurfaceDanmakuView(SurfaceView paramSurfaceView)
  {
    this.a = paramSurfaceView;
    this.a.setWillNotCacheDrawing(true);
    this.a.setDrawingCacheEnabled(false);
    this.a.setWillNotDraw(true);
    this.a.setZOrderMediaOverlay(true);
    this.b = this.a.getHolder();
    this.b.addCallback(this);
    this.b.setFormat(-2);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (DanmakuDependImp.a().b().d())
    {
      this.b.unlockCanvasAndPost(paramCanvas);
      return;
    }
    this.b.getSurface().unlockCanvasAndPost(paramCanvas);
    if (this.d != null) {
      this.d.unlock();
    }
  }
  
  private void g()
  {
    h();
    i();
  }
  
  private void h()
  {
    Object localObject = DanmakuDependImp.a().b().a(SurfaceView.class, "mSurfaceLock", this.a);
    if ((localObject instanceof ReentrantLock)) {
      this.d = ((ReentrantLock)localObject);
    }
  }
  
  private void i()
  {
    this.e = DanmakuDependImp.a().b().a(SurfaceView.class, "mDrawingStopped", this.a);
    this.g = DanmakuDependImp.a().b().a(SurfaceView.class, "mWindow", this.a);
    if ((this.e instanceof Boolean)) {
      this.f = ((Boolean)this.e).booleanValue();
    }
  }
  
  private boolean j()
  {
    g();
    return (this.d != null) && (this.e != null) && (this.g != null);
  }
  
  private boolean k()
  {
    return (VideoDanmakuConfig.a()) && (((Build.VERSION.SDK_INT == 23) && (j())) || (DanmakuDependImp.a().b().d()));
  }
  
  private Canvas l()
  {
    if (DanmakuDependImp.a().b().d()) {
      return this.b.lockHardwareCanvas();
    }
    this.d.lock();
    i();
    Canvas localCanvas2;
    if ((!this.f) && (this.g != null)) {
      try
      {
        Canvas localCanvas1 = this.b.getSurface().lockHardwareCanvas();
      }
      catch (Exception localException)
      {
        Logger.a("SurfaceDanmakuView", "Exception locking surface", localException);
      }
    } else {
      localCanvas2 = null;
    }
    if (localCanvas2 != null) {
      return localCanvas2;
    }
    this.d.unlock();
    return null;
  }
  
  public Canvas a()
  {
    if (this.h) {
      return l();
    }
    return this.b.lockCanvas();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.h)
    {
      b(paramCanvas);
      return;
    }
    this.b.unlockCanvasAndPost(paramCanvas);
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.setOnTouchListener(paramOnTouchListener);
  }
  
  public void a(IDanmakuView.CallBack paramCallBack)
  {
    this.c = paramCallBack;
  }
  
  public void a(boolean paramBoolean) {}
  
  public float b()
  {
    return this.a.getY();
  }
  
  public void b(boolean paramBoolean) {}
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: invokestatic 69	com/tencent/common/danmaku/DanmakuDependImp:a	()Lcom/tencent/common/danmaku/DanmakuDependImp;
    //   3: invokevirtual 72	com/tencent/common/danmaku/DanmakuDependImp:b	()Lcom/tencent/common/danmaku/IDanmakuDepend;
    //   6: ldc 33
    //   8: ldc 101
    //   10: aload_0
    //   11: getfield 31	com/tencent/common/danmaku/render/SurfaceDanmakuView:a	Landroid/view/SurfaceView;
    //   14: invokeinterface 104 4 0
    //   19: checkcast 91	java/util/concurrent/locks/ReentrantLock
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 31	com/tencent/common/danmaku/render/SurfaceDanmakuView:a	Landroid/view/SurfaceView;
    //   27: invokevirtual 50	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   30: invokeinterface 84 1 0
    //   35: astore_2
    //   36: ldc 86
    //   38: ldc 175
    //   40: iconst_1
    //   41: anewarray 177	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: getstatic 183	java/lang/Long:TYPE	Ljava/lang/Class;
    //   49: aastore
    //   50: invokevirtual 187	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   53: astore_3
    //   54: aload_3
    //   55: iconst_1
    //   56: invokevirtual 192	java/lang/reflect/Method:setAccessible	(Z)V
    //   59: ldc 86
    //   61: ldc 194
    //   63: invokevirtual 198	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_1
    //   71: invokevirtual 201	java/lang/reflect/Field:setAccessible	(Z)V
    //   74: aload 4
    //   76: aload_2
    //   77: invokevirtual 205	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 179	java/lang/Long
    //   83: astore 5
    //   85: new 207	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc 210
    //   98: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: aload 5
    //   106: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: ldc 219
    //   112: aload 6
    //   114: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload 5
    //   122: invokevirtual 230	java/lang/Long:longValue	()J
    //   125: lconst_0
    //   126: lcmp
    //   127: ifeq +18 -> 145
    //   130: aload_3
    //   131: aconst_null
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload 5
    //   140: aastore
    //   141: invokevirtual 234	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: aload 4
    //   147: aload_2
    //   148: lconst_0
    //   149: invokevirtual 238	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   152: ldc 219
    //   154: ldc 240
    //   156: invokestatic 242	com/tencent/common/danmaku/util/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: new 207	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: aload_2
    //   168: ldc 244
    //   170: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: aload_1
    //   176: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: ldc 219
    //   182: aload_2
    //   183: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: aload_1
    //   190: ifnull +78 -> 268
    //   193: aload_1
    //   194: invokevirtual 247	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   197: ifeq +71 -> 268
    //   200: goto +57 -> 257
    //   203: astore_2
    //   204: goto +65 -> 269
    //   207: astore_2
    //   208: ldc 219
    //   210: ldc 249
    //   212: aload_2
    //   213: invokestatic 155	com/tencent/common/danmaku/util/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: new 207	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   223: astore_2
    //   224: aload_2
    //   225: ldc 244
    //   227: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_2
    //   232: aload_1
    //   233: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: ldc 219
    //   239: aload_2
    //   240: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: ifnull +21 -> 268
    //   250: aload_1
    //   251: invokevirtual 247	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   254: ifeq +14 -> 268
    //   257: ldc 219
    //   259: ldc 251
    //   261: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: invokevirtual 94	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   268: return
    //   269: new 207	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   276: astore_3
    //   277: aload_3
    //   278: ldc 244
    //   280: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_3
    //   285: aload_1
    //   286: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 219
    //   292: aload_3
    //   293: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: ifnull +21 -> 321
    //   303: aload_1
    //   304: invokevirtual 247	java/util/concurrent/locks/ReentrantLock:isLocked	()Z
    //   307: ifeq +14 -> 321
    //   310: ldc 219
    //   312: ldc 251
    //   314: invokestatic 226	com/tencent/common/danmaku/util/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_1
    //   318: invokevirtual 94	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   321: aload_2
    //   322: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	SurfaceDanmakuView
    //   22	296	1	localReentrantLock	ReentrantLock
    //   35	148	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   207	6	2	localException	Exception
    //   223	99	2	localStringBuilder1	StringBuilder
    //   53	240	3	localObject3	Object
    //   66	80	4	localField	java.lang.reflect.Field
    //   83	56	5	localLong	java.lang.Long
    //   92	21	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   36	145	203	finally
    //   145	159	203	finally
    //   208	216	203	finally
    //   36	145	207	java/lang/Exception
    //   145	159	207	java/lang/Exception
  }
  
  public void d() {}
  
  public boolean e()
  {
    return false;
  }
  
  public boolean f()
  {
    return false;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.u();
    }
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceChanged, width = ");
    paramSurfaceHolder.append(paramInt2);
    paramSurfaceHolder.append(", height = ");
    paramSurfaceHolder.append(paramInt3);
    Logger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.t();
    }
    this.h = k();
    paramSurfaceHolder = new StringBuilder();
    paramSurfaceHolder.append("surfaceCreated, isHardwareAccelerateEnable = ");
    paramSurfaceHolder.append(this.h);
    Logger.c("SurfaceDanmakuView", paramSurfaceHolder.toString());
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.c;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.v();
    }
    Logger.c("SurfaceDanmakuView", "surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.render.SurfaceDanmakuView
 * JD-Core Version:    0.7.0.1
 */