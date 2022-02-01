package com.tencent.av.opengl.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Process;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.program.TextureProgramFactory;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.UploadedTexture;
import com.tencent.av.qavperf.fps.IFpsDrawCallback;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import mqq.os.MqqHandler;

public class GLRootView
  extends GLSurfaceView
  implements GLSurfaceView.Renderer
{
  private static int h;
  final long a;
  final int b;
  protected final String c;
  protected GLView d;
  long e;
  int f;
  boolean g;
  private final ReentrantLock i;
  private GLCanvas j;
  private int k;
  private volatile boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private IFpsDrawCallback p;
  private Runnable q;
  
  public GLRootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  /* Error */
  public GLRootView(Context paramContext, android.util.AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: invokespecial 43	android/opengl/GLSurfaceView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: bipush 20
    //   9: putfield 45	com/tencent/av/opengl/ui/GLRootView:b	I
    //   12: aload_0
    //   13: new 47	java/util/concurrent/locks/ReentrantLock
    //   16: dup
    //   17: invokespecial 49	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   20: putfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   23: aload_0
    //   24: lconst_0
    //   25: putfield 53	com/tencent/av/opengl/ui/GLRootView:e	J
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 55	com/tencent/av/opengl/ui/GLRootView:f	I
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 57	com/tencent/av/opengl/ui/GLRootView:g	Z
    //   38: aload_0
    //   39: iconst_2
    //   40: putfield 59	com/tencent/av/opengl/ui/GLRootView:k	I
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 61	com/tencent/av/opengl/ui/GLRootView:l	Z
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 63	com/tencent/av/opengl/ui/GLRootView:m	Z
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 65	com/tencent/av/opengl/ui/GLRootView:n	Z
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 67	com/tencent/av/opengl/ui/GLRootView:o	Z
    //   63: aload_0
    //   64: new 69	com/tencent/av/opengl/ui/GLRootView$1
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 72	com/tencent/av/opengl/ui/GLRootView$1:<init>	(Lcom/tencent/av/opengl/ui/GLRootView;)V
    //   72: putfield 74	com/tencent/av/opengl/ui/GLRootView:q	Ljava/lang/Runnable;
    //   75: aload_0
    //   76: invokestatic 79	com/tencent/av/utils/AudioHelper:c	()J
    //   79: putfield 81	com/tencent/av/opengl/ui/GLRootView:a	J
    //   82: new 83	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   89: astore 4
    //   91: aload 4
    //   93: ldc 86
    //   95: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: aload_0
    //   102: getfield 81	com/tencent/av/opengl/ui/GLRootView:a	J
    //   105: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: aload 4
    //   112: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: putfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   118: aload_0
    //   119: invokestatic 104	com/tencent/av/qavperf/fps/QAVPFpsDrawImpl:b	()Lcom/tencent/av/qavperf/fps/QAVPFpsDrawImpl;
    //   122: putfield 106	com/tencent/av/opengl/ui/GLRootView:p	Lcom/tencent/av/qavperf/fps/IFpsDrawCallback;
    //   125: invokestatic 112	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   128: ifeq +13 -> 141
    //   131: aload_0
    //   132: getfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   135: iconst_1
    //   136: ldc 114
    //   138: invokestatic 118	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: getstatic 123	android/os/Build:MODEL	Ljava/lang/String;
    //   144: ldc 125
    //   146: invokevirtual 131	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   149: ifne +22 -> 171
    //   152: getstatic 123	android/os/Build:MODEL	Ljava/lang/String;
    //   155: ldc 133
    //   157: invokevirtual 131	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifeq +6 -> 166
    //   163: goto +8 -> 171
    //   166: iconst_0
    //   167: istore_3
    //   168: goto +5 -> 173
    //   171: iconst_1
    //   172: istore_3
    //   173: aload_0
    //   174: iload_3
    //   175: putfield 67	com/tencent/av/opengl/ui/GLRootView:o	Z
    //   178: aload_0
    //   179: invokevirtual 136	com/tencent/av/opengl/ui/GLRootView:isInEditMode	()Z
    //   182: ifeq +4 -> 186
    //   185: return
    //   186: aload_0
    //   187: iconst_1
    //   188: aload_0
    //   189: getfield 59	com/tencent/av/opengl/ui/GLRootView:k	I
    //   192: ior
    //   193: putfield 59	com/tencent/av/opengl/ui/GLRootView:k	I
    //   196: aload_0
    //   197: aconst_null
    //   198: invokevirtual 140	com/tencent/av/opengl/ui/GLRootView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   201: aload_2
    //   202: ifnull +98 -> 300
    //   205: aload_1
    //   206: aload_2
    //   207: getstatic 146	com/tencent/mobileqq/R$styleable:GLRootView	[I
    //   210: iconst_0
    //   211: iconst_0
    //   212: invokevirtual 152	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   215: astore_2
    //   216: aload_2
    //   217: ifnull +83 -> 300
    //   220: aload_0
    //   221: aload_2
    //   222: iconst_0
    //   223: iconst_0
    //   224: invokevirtual 158	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   227: putfield 57	com/tencent/av/opengl/ui/GLRootView:g	Z
    //   230: aload_2
    //   231: invokevirtual 161	android/content/res/TypedArray:recycle	()V
    //   234: goto +66 -> 300
    //   237: astore_1
    //   238: goto +56 -> 294
    //   241: astore 4
    //   243: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   246: ifeq -16 -> 230
    //   249: aload_0
    //   250: getfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   253: astore 5
    //   255: new 83	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   262: astore 6
    //   264: aload 6
    //   266: ldc 166
    //   268: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 6
    //   274: aload 4
    //   276: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 5
    //   282: iconst_2
    //   283: aload 6
    //   285: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: goto -61 -> 230
    //   294: aload_2
    //   295: invokevirtual 161	android/content/res/TypedArray:recycle	()V
    //   298: aload_1
    //   299: athrow
    //   300: aload_0
    //   301: aload_1
    //   302: invokestatic 176	com/tencent/av/opengl/utils/Utils:a	(Landroid/content/Context;)I
    //   305: invokevirtual 180	com/tencent/av/opengl/ui/GLRootView:setEGLContextClientVersion	(I)V
    //   308: aload_0
    //   309: getfield 57	com/tencent/av/opengl/ui/GLRootView:g	Z
    //   312: ifeq +32 -> 344
    //   315: aload_0
    //   316: bipush 8
    //   318: bipush 8
    //   320: bipush 8
    //   322: bipush 8
    //   324: bipush 16
    //   326: iconst_0
    //   327: invokevirtual 184	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   330: aload_0
    //   331: invokevirtual 188	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   334: bipush 253
    //   336: invokeinterface 193 2 0
    //   341: goto +56 -> 397
    //   344: getstatic 195	com/tencent/av/opengl/utils/Utils:c	Z
    //   347: ifeq +29 -> 376
    //   350: aload_0
    //   351: bipush 8
    //   353: bipush 8
    //   355: bipush 8
    //   357: iconst_0
    //   358: iconst_0
    //   359: iconst_0
    //   360: invokevirtual 184	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   363: aload_0
    //   364: invokevirtual 188	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   367: iconst_3
    //   368: invokeinterface 193 2 0
    //   373: goto +24 -> 397
    //   376: aload_0
    //   377: iconst_5
    //   378: bipush 6
    //   380: iconst_5
    //   381: iconst_0
    //   382: iconst_0
    //   383: iconst_0
    //   384: invokevirtual 184	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   387: aload_0
    //   388: invokevirtual 188	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   391: iconst_4
    //   392: invokeinterface 193 2 0
    //   397: aload_0
    //   398: aload_0
    //   399: invokevirtual 199	com/tencent/av/opengl/ui/GLRootView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   402: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	GLRootView
    //   0	403	1	paramContext	Context
    //   0	403	2	paramAttributeSet	android.util.AttributeSet
    //   167	8	3	bool	boolean
    //   89	22	4	localStringBuilder1	StringBuilder
    //   241	34	4	localException	Exception
    //   253	28	5	str	String
    //   262	22	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   220	230	237	finally
    //   243	291	237	finally
    //   220	230	241	java/lang/Exception
  }
  
  private void b()
  {
    this.k &= 0xFFFFFFFD;
    int i1 = getWidth();
    int i2 = getHeight();
    GLView localGLView = this.d;
    if ((localGLView != null) && (i1 != 0) && (i2 != 0)) {
      localGLView.c(0, 0, i1, i2);
    }
  }
  
  public void a()
  {
    this.i.lock();
    try
    {
      if ((this.d != null) && ((this.k & 0x2) == 0))
      {
        int i1 = this.k;
        if ((i1 & 0x1) != 0) {}
      }
      else
      {
        return;
      }
      this.k |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  protected void a(GL10 paramGL10)
  {
    this.j.h();
    UploadedTexture.A();
    this.l = false;
    if ((this.k & 0x2) != 0) {
      b();
    }
    paramGL10 = this.d;
    if (paramGL10 != null) {
      paramGL10.a(this.j);
    } else {
      this.j.d();
    }
    if (UploadedTexture.B()) {
      requestRender();
    }
    paramGL10 = this.p;
    if (paramGL10 != null) {
      paramGL10.a();
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    GLView localGLView = this.d;
    if ((localGLView != null) && ((localGLView instanceof VideoLayerUI)) && (((VideoLayerUI)localGLView).c(paramMotionEvent))) {
      return true;
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction();
    if ((i1 != 3) && (i1 != 1))
    {
      if ((!this.m) && (i1 != 0)) {
        return false;
      }
    }
    else {
      this.m = false;
    }
    for (;;)
    {
      try
      {
        bool = this.i.tryLock(500L, TimeUnit.MILLISECONDS);
        if (bool)
        {
          try
          {
            if ((this.d == null) || (!this.d.b(paramMotionEvent))) {
              break label146;
            }
            bool = true;
            if ((i1 == 0) && (bool)) {
              this.m = true;
            }
            return bool;
          }
          finally
          {
            this.i.unlock();
          }
        }
        else
        {
          QLog.e(this.c, 1, "dispatchTouchEvent failed. tryLock failed.");
          return false;
        }
      }
      catch (InterruptedException paramMotionEvent)
      {
        QLog.e(this.c, 1, "dispatchTouchEvent failed. tryLock failed.", paramMotionEvent);
        return false;
      }
      label146:
      boolean bool = false;
    }
  }
  
  protected void finalize()
  {
    try
    {
      try
      {
        
        label3:
        super.finalize();
      }
      finally
      {
        super.finalize();
      }
      QLog.w(this.c, 1, "GLRootView, 虚构");
      return;
    }
    catch (Exception localException)
    {
      break label3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  /* Error */
  public void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/tencent/av/opengl/ui/GLRootView:o	Z
    //   4: ifeq +83 -> 87
    //   7: aload_0
    //   8: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   11: invokevirtual 219	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   14: getstatic 301	com/tencent/av/opengl/ui/GLRootView:h	I
    //   17: iconst_1
    //   18: if_icmpeq +62 -> 80
    //   21: aload_0
    //   22: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 222	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   28: aload_0
    //   29: getfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   32: astore_1
    //   33: new 83	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload 5
    //   44: ldc_w 303
    //   47: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: getstatic 301	com/tencent/av/opengl/ui/GLRootView:h	I
    //   56: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: iconst_1
    //   62: aload 5
    //   64: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 61	com/tencent/av/opengl/ui/GLRootView:l	Z
    //   75: aload_0
    //   76: invokevirtual 223	com/tencent/av/opengl/ui/GLRootView:requestRender	()V
    //   79: return
    //   80: aload_0
    //   81: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   84: invokevirtual 222	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: invokestatic 311	android/os/SystemClock:elapsedRealtime	()J
    //   90: pop2
    //   91: invokestatic 314	com/tencent/av/opengl/ui/AnimationTime:a	()V
    //   94: aload_0
    //   95: getfield 57	com/tencent/av/opengl/ui/GLRootView:g	Z
    //   98: ifeq +8 -> 106
    //   101: fconst_0
    //   102: fstore_2
    //   103: goto +5 -> 108
    //   106: fconst_1
    //   107: fstore_2
    //   108: fconst_0
    //   109: fconst_0
    //   110: fconst_0
    //   111: fload_2
    //   112: invokestatic 320	android/opengl/GLES20:glClearColor	(FFFF)V
    //   115: sipush 16640
    //   118: invokestatic 323	android/opengl/GLES20:glClear	(I)V
    //   121: aload_0
    //   122: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 219	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   128: aload_0
    //   129: monitorenter
    //   130: aload_0
    //   131: getfield 55	com/tencent/av/opengl/ui/GLRootView:f	I
    //   134: ifle +13 -> 147
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 55	com/tencent/av/opengl/ui/GLRootView:f	I
    //   142: iconst_1
    //   143: isub
    //   144: putfield 55	com/tencent/av/opengl/ui/GLRootView:f	I
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual 325	com/tencent/av/opengl/ui/GLRootView:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   154: aload_0
    //   155: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   158: invokevirtual 222	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   161: goto +172 -> 333
    //   164: astore_1
    //   165: goto +201 -> 366
    //   168: astore_1
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 61	com/tencent/av/opengl/ui/GLRootView:l	Z
    //   174: invokestatic 164	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -23 -> 154
    //   180: aload_0
    //   181: getfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   184: astore 5
    //   186: new 83	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   193: astore 6
    //   195: aload 6
    //   197: ldc_w 327
    //   200: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 6
    //   206: aload_1
    //   207: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: iconst_2
    //   214: aload 6
    //   216: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_1
    //   223: invokevirtual 331	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   226: astore 5
    //   228: aload 5
    //   230: arraylength
    //   231: istore 4
    //   233: ldc_w 333
    //   236: astore_1
    //   237: iconst_0
    //   238: istore_3
    //   239: iload_3
    //   240: iload 4
    //   242: if_icmpge +79 -> 321
    //   245: new 83	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   252: astore 6
    //   254: aload 6
    //   256: aload_1
    //   257: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 6
    //   263: ldc_w 335
    //   266: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 6
    //   272: iload_3
    //   273: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 6
    //   279: ldc_w 337
    //   282: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: aload 5
    //   290: iload_3
    //   291: aaload
    //   292: invokevirtual 340	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   295: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 6
    //   301: ldc_w 342
    //   304: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: astore_1
    //   314: iload_3
    //   315: iconst_1
    //   316: iadd
    //   317: istore_3
    //   318: goto -79 -> 239
    //   321: aload_0
    //   322: getfield 99	com/tencent/av/opengl/ui/GLRootView:c	Ljava/lang/String;
    //   325: iconst_2
    //   326: aload_1
    //   327: invokestatic 171	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto -176 -> 154
    //   333: aload_0
    //   334: getfield 65	com/tencent/av/opengl/ui/GLRootView:n	Z
    //   337: ifeq +21 -> 358
    //   340: aload_0
    //   341: getfield 211	com/tencent/av/opengl/ui/GLRootView:d	Lcom/tencent/av/opengl/ui/GLView;
    //   344: astore_1
    //   345: aload_1
    //   346: ifnull +12 -> 358
    //   349: aload_0
    //   350: iconst_0
    //   351: putfield 65	com/tencent/av/opengl/ui/GLRootView:n	Z
    //   354: aload_1
    //   355: invokevirtual 344	com/tencent/av/opengl/ui/GLView:p	()V
    //   358: aload_0
    //   359: invokestatic 311	android/os/SystemClock:elapsedRealtime	()J
    //   362: putfield 53	com/tencent/av/opengl/ui/GLRootView:e	J
    //   365: return
    //   366: aload_0
    //   367: getfield 51	com/tencent/av/opengl/ui/GLRootView:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   370: invokevirtual 222	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   373: aload_1
    //   374: athrow
    //   375: astore_1
    //   376: aload_0
    //   377: monitorexit
    //   378: goto +5 -> 383
    //   381: aload_1
    //   382: athrow
    //   383: goto -2 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	GLRootView
    //   0	386	1	paramGL10	GL10
    //   102	10	2	f1	float
    //   238	80	3	i1	int
    //   231	12	4	i2	int
    //   40	249	5	localObject	Object
    //   193	116	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	154	164	finally
    //   169	233	164	finally
    //   245	314	164	finally
    //   321	330	164	finally
    //   149	154	168	java/lang/Exception
    //   130	147	375	finally
    //   147	149	375	finally
    //   376	378	375	finally
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean) {
      a();
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.c, 2, "onPause");
    }
    if ((this.d instanceof GLViewGroup)) {
      queueEvent(new GLRootView.2(this));
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.l = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSurfaceChanged: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("x");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", gl10: ");
      localStringBuilder.append(paramGL10.toString());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      QLog.d(this.c, 1, "onSurfaceChanged: error system callback - width or height is Zero value");
    }
    paramGL10 = this.d;
    if ((paramGL10 != null) && ((paramGL10 instanceof GLViewGroup))) {
      ((GLViewGroup)paramGL10).b(paramInt1, paramInt2);
    }
    Process.setThreadPriority(-4);
    this.j.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.i.lock();
    try
    {
      this.j = new GLES20Canvas();
      BasicTexture.r();
      if ((this.d != null) && ((this.d instanceof GLViewGroup))) {
        ((GLViewGroup)this.d).w();
      }
      this.i.unlock();
      TextureProgramFactory.a();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.i.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    long l1 = SystemClock.elapsedRealtime() - this.e;
    if ((l1 > 0L) && (l1 < 20L)) {
      try
      {
        if (this.f >= 2) {
          return;
        }
        this.f += 1;
        super.postDelayed(this.q, 20L - l1);
        return;
      }
      finally {}
    }
    ThreadManager.getUIHandler().post(this.q);
  }
  
  public void setContentPane(GLView paramGLView)
  {
    Object localObject = this.d;
    if (localObject == paramGLView) {
      return;
    }
    if (localObject != null)
    {
      if (this.m)
      {
        long l1 = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        this.d.b((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        this.m = false;
      }
      this.d.d();
      BasicTexture.q();
    }
    this.d = paramGLView;
    if (paramGLView != null)
    {
      paramGLView.a(this);
      a();
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (this.o)
    {
      this.i.lock();
      h += 1;
      this.i.unlock();
    }
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("STest. surfaceCreated. sCreatedSurfaceCnt = ");
    localStringBuilder.append(h);
    QLog.i(str, 1, localStringBuilder.toString());
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.o)
    {
      this.i.lock();
      h -= 1;
      this.i.unlock();
    }
    if ((this.d instanceof GLViewGroup)) {
      queueEvent(new GLRootView.3(this));
    }
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("STest. surfaceDestroyed. sCreatedSurfaceCnt = ");
    localStringBuilder.append(h);
    QLog.i(str, 1, localStringBuilder.toString());
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */