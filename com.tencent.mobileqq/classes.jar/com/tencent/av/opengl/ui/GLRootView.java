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
  private static int jdField_c_of_type_Int;
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  private GLCanvas jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas;
  protected GLView a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected final String a;
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  long jdField_b_of_type_Long;
  private volatile boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
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
    //   3: invokespecial 30	android/opengl/GLSurfaceView:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;)V
    //   6: aload_0
    //   7: bipush 20
    //   9: putfield 32	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Int	I
    //   12: aload_0
    //   13: new 34	java/util/concurrent/locks/ReentrantLock
    //   16: dup
    //   17: invokespecial 36	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   20: putfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   23: aload_0
    //   24: lconst_0
    //   25: putfield 40	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Long	J
    //   28: aload_0
    //   29: iconst_0
    //   30: putfield 42	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Int	I
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 44	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Boolean	Z
    //   38: aload_0
    //   39: iconst_2
    //   40: putfield 46	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Int	I
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield 48	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Boolean	Z
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 50	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Boolean	Z
    //   53: aload_0
    //   54: iconst_1
    //   55: putfield 52	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Boolean	Z
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 54	com/tencent/av/opengl/ui/GLRootView:e	Z
    //   63: aload_0
    //   64: new 56	com/tencent/av/opengl/ui/GLRootView$1
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 59	com/tencent/av/opengl/ui/GLRootView$1:<init>	(Lcom/tencent/av/opengl/ui/GLRootView;)V
    //   72: putfield 61	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   75: aload_0
    //   76: invokestatic 66	com/tencent/av/utils/AudioHelper:b	()J
    //   79: putfield 68	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Long	J
    //   82: new 70	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   89: astore 4
    //   91: aload 4
    //   93: ldc 73
    //   95: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 4
    //   101: aload_0
    //   102: getfield 68	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Long	J
    //   105: invokevirtual 80	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: aload 4
    //   112: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: putfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   118: invokestatic 92	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   121: ifeq +13 -> 134
    //   124: aload_0
    //   125: getfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   128: iconst_1
    //   129: ldc 94
    //   131: invokestatic 98	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: getstatic 103	android/os/Build:MODEL	Ljava/lang/String;
    //   137: ldc 105
    //   139: invokevirtual 111	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   142: ifne +22 -> 164
    //   145: getstatic 103	android/os/Build:MODEL	Ljava/lang/String;
    //   148: ldc 113
    //   150: invokevirtual 111	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   153: ifeq +6 -> 159
    //   156: goto +8 -> 164
    //   159: iconst_0
    //   160: istore_3
    //   161: goto +5 -> 166
    //   164: iconst_1
    //   165: istore_3
    //   166: aload_0
    //   167: iload_3
    //   168: putfield 54	com/tencent/av/opengl/ui/GLRootView:e	Z
    //   171: aload_0
    //   172: invokevirtual 116	com/tencent/av/opengl/ui/GLRootView:isInEditMode	()Z
    //   175: ifeq +4 -> 179
    //   178: return
    //   179: aload_0
    //   180: iconst_1
    //   181: aload_0
    //   182: getfield 46	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Int	I
    //   185: ior
    //   186: putfield 46	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Int	I
    //   189: aload_0
    //   190: aconst_null
    //   191: invokevirtual 120	com/tencent/av/opengl/ui/GLRootView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   194: aload_2
    //   195: ifnull +98 -> 293
    //   198: aload_1
    //   199: aload_2
    //   200: getstatic 126	com/tencent/mobileqq/R$styleable:GLRootView	[I
    //   203: iconst_0
    //   204: iconst_0
    //   205: invokevirtual 132	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnull +83 -> 293
    //   213: aload_0
    //   214: aload_2
    //   215: iconst_0
    //   216: iconst_0
    //   217: invokevirtual 138	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   220: putfield 44	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Boolean	Z
    //   223: aload_2
    //   224: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   227: goto +66 -> 293
    //   230: astore_1
    //   231: goto +56 -> 287
    //   234: astore 4
    //   236: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq -16 -> 223
    //   242: aload_0
    //   243: getfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: astore 5
    //   248: new 70	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   255: astore 6
    //   257: aload 6
    //   259: ldc 146
    //   261: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 6
    //   267: aload 4
    //   269: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 5
    //   275: iconst_2
    //   276: aload 6
    //   278: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: goto -61 -> 223
    //   287: aload_2
    //   288: invokevirtual 141	android/content/res/TypedArray:recycle	()V
    //   291: aload_1
    //   292: athrow
    //   293: aload_0
    //   294: aload_1
    //   295: invokestatic 156	com/tencent/av/opengl/utils/Utils:a	(Landroid/content/Context;)I
    //   298: invokevirtual 160	com/tencent/av/opengl/ui/GLRootView:setEGLContextClientVersion	(I)V
    //   301: aload_0
    //   302: getfield 44	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Boolean	Z
    //   305: ifeq +32 -> 337
    //   308: aload_0
    //   309: bipush 8
    //   311: bipush 8
    //   313: bipush 8
    //   315: bipush 8
    //   317: bipush 16
    //   319: iconst_0
    //   320: invokevirtual 164	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   323: aload_0
    //   324: invokevirtual 168	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   327: bipush 253
    //   329: invokeinterface 173 2 0
    //   334: goto +56 -> 390
    //   337: getstatic 174	com/tencent/av/opengl/utils/Utils:jdField_b_of_type_Boolean	Z
    //   340: ifeq +29 -> 369
    //   343: aload_0
    //   344: bipush 8
    //   346: bipush 8
    //   348: bipush 8
    //   350: iconst_0
    //   351: iconst_0
    //   352: iconst_0
    //   353: invokevirtual 164	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   356: aload_0
    //   357: invokevirtual 168	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   360: iconst_3
    //   361: invokeinterface 173 2 0
    //   366: goto +24 -> 390
    //   369: aload_0
    //   370: iconst_5
    //   371: bipush 6
    //   373: iconst_5
    //   374: iconst_0
    //   375: iconst_0
    //   376: iconst_0
    //   377: invokevirtual 164	com/tencent/av/opengl/ui/GLRootView:setEGLConfigChooser	(IIIIII)V
    //   380: aload_0
    //   381: invokevirtual 168	com/tencent/av/opengl/ui/GLRootView:getHolder	()Landroid/view/SurfaceHolder;
    //   384: iconst_4
    //   385: invokeinterface 173 2 0
    //   390: aload_0
    //   391: aload_0
    //   392: invokevirtual 178	com/tencent/av/opengl/ui/GLRootView:setRenderer	(Landroid/opengl/GLSurfaceView$Renderer;)V
    //   395: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	GLRootView
    //   0	396	1	paramContext	Context
    //   0	396	2	paramAttributeSet	android.util.AttributeSet
    //   160	8	3	bool	boolean
    //   89	22	4	localStringBuilder1	StringBuilder
    //   234	34	4	localException	Exception
    //   246	28	5	str	String
    //   255	22	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   213	223	230	finally
    //   236	284	230	finally
    //   213	223	234	java/lang/Exception
  }
  
  private void b()
  {
    this.jdField_d_of_type_Int &= 0xFFFFFFFD;
    int i = getWidth();
    int j = getHeight();
    GLView localGLView = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if ((localGLView != null) && (i != 0) && (j != 0)) {
      localGLView.b(0, 0, i, j);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) && ((this.jdField_d_of_type_Int & 0x2) == 0))
      {
        int i = this.jdField_d_of_type_Int;
        if ((i & 0x1) != 0) {}
      }
      else
      {
        return;
      }
      this.jdField_d_of_type_Int |= 0x2;
      requestRender();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  protected void a(GL10 paramGL10)
  {
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.d();
    UploadedTexture.f();
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_d_of_type_Int & 0x2) != 0) {
      b();
    }
    paramGL10 = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if (paramGL10 != null) {
      paramGL10.a(this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas);
    } else {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a();
    }
    if (UploadedTexture.e()) {
      requestRender();
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    GLView localGLView = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
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
    int i = paramMotionEvent.getAction();
    if ((i != 3) && (i != 1))
    {
      if ((!this.jdField_c_of_type_Boolean) && (i != 0)) {
        return false;
      }
    }
    else {
      this.jdField_c_of_type_Boolean = false;
    }
    for (;;)
    {
      try
      {
        bool = this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.tryLock(500L, TimeUnit.MILLISECONDS);
        if (bool)
        {
          try
          {
            if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView == null) || (!this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b(paramMotionEvent))) {
              break label146;
            }
            bool = true;
            if ((i == 0) && (bool)) {
              this.jdField_c_of_type_Boolean = true;
            }
            return bool;
          }
          finally
          {
            this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
          }
        }
        else
        {
          QLog.e(this.jdField_a_of_type_JavaLangString, 1, "dispatchTouchEvent failed. tryLock failed.");
          return false;
        }
      }
      catch (InterruptedException paramMotionEvent)
      {
        QLog.e(this.jdField_a_of_type_JavaLangString, 1, "dispatchTouchEvent failed. tryLock failed.", paramMotionEvent);
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
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "GLRootView, 虚构");
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
    //   1: getfield 54	com/tencent/av/opengl/ui/GLRootView:e	Z
    //   4: ifeq +83 -> 87
    //   7: aload_0
    //   8: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   11: invokevirtual 198	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   14: getstatic 275	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Int	I
    //   17: iconst_1
    //   18: if_icmpeq +62 -> 80
    //   21: aload_0
    //   22: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   25: invokevirtual 201	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   28: aload_0
    //   29: getfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore_1
    //   33: new 70	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload 5
    //   44: ldc_w 277
    //   47: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 5
    //   53: getstatic 275	com/tencent/av/opengl/ui/GLRootView:jdField_c_of_type_Int	I
    //   56: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: iconst_1
    //   62: aload 5
    //   64: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 48	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Boolean	Z
    //   75: aload_0
    //   76: invokevirtual 202	com/tencent/av/opengl/ui/GLRootView:requestRender	()V
    //   79: return
    //   80: aload_0
    //   81: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   84: invokevirtual 201	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   90: pop2
    //   91: invokestatic 288	com/tencent/av/opengl/ui/AnimationTime:a	()V
    //   94: aload_0
    //   95: getfield 44	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_Boolean	Z
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
    //   112: invokestatic 294	android/opengl/GLES20:glClearColor	(FFFF)V
    //   115: sipush 16640
    //   118: invokestatic 297	android/opengl/GLES20:glClear	(I)V
    //   121: aload_0
    //   122: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   125: invokevirtual 198	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   128: aload_0
    //   129: monitorenter
    //   130: aload_0
    //   131: getfield 42	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Int	I
    //   134: ifle +13 -> 147
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 42	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Int	I
    //   142: iconst_1
    //   143: isub
    //   144: putfield 42	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Int	I
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual 299	com/tencent/av/opengl/ui/GLRootView:a	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   154: aload_0
    //   155: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   158: invokevirtual 201	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   161: goto +172 -> 333
    //   164: astore_1
    //   165: goto +201 -> 366
    //   168: astore_1
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield 48	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Boolean	Z
    //   174: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -23 -> 154
    //   180: aload_0
    //   181: getfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   184: astore 5
    //   186: new 70	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   193: astore 6
    //   195: aload 6
    //   197: ldc_w 301
    //   200: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 6
    //   206: aload_1
    //   207: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: iconst_2
    //   214: aload 6
    //   216: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_1
    //   223: invokevirtual 305	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   226: astore 5
    //   228: aload 5
    //   230: arraylength
    //   231: istore 4
    //   233: ldc_w 307
    //   236: astore_1
    //   237: iconst_0
    //   238: istore_3
    //   239: iload_3
    //   240: iload 4
    //   242: if_icmpge +79 -> 321
    //   245: new 70	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   252: astore 6
    //   254: aload 6
    //   256: aload_1
    //   257: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 6
    //   263: ldc_w 309
    //   266: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 6
    //   272: iload_3
    //   273: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 6
    //   279: ldc_w 311
    //   282: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 6
    //   288: aload 5
    //   290: iload_3
    //   291: aaload
    //   292: invokevirtual 314	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   295: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 6
    //   301: ldc_w 316
    //   304: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: astore_1
    //   314: iload_3
    //   315: iconst_1
    //   316: iadd
    //   317: istore_3
    //   318: goto -79 -> 239
    //   321: aload_0
    //   322: getfield 86	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   325: iconst_2
    //   326: aload_1
    //   327: invokestatic 151	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto -176 -> 154
    //   333: aload_0
    //   334: getfield 52	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Boolean	Z
    //   337: ifeq +21 -> 358
    //   340: aload_0
    //   341: getfield 190	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_ComTencentAvOpenglUiGLView	Lcom/tencent/av/opengl/ui/GLView;
    //   344: astore_1
    //   345: aload_1
    //   346: ifnull +12 -> 358
    //   349: aload_0
    //   350: iconst_0
    //   351: putfield 52	com/tencent/av/opengl/ui/GLRootView:jdField_d_of_type_Boolean	Z
    //   354: aload_1
    //   355: invokevirtual 318	com/tencent/av/opengl/ui/GLView:e	()V
    //   358: aload_0
    //   359: invokestatic 285	android/os/SystemClock:elapsedRealtime	()J
    //   362: putfield 40	com/tencent/av/opengl/ui/GLRootView:jdField_b_of_type_Long	J
    //   365: return
    //   366: aload_0
    //   367: getfield 38	com/tencent/av/opengl/ui/GLRootView:jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   370: invokevirtual 201	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
    //   102	10	2	f	float
    //   238	80	3	i	int
    //   231	12	4	j	int
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
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "onPause");
    }
    if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView instanceof GLViewGroup)) {
      queueEvent(new GLRootView.2(this));
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onSurfaceChanged: error system callback - width or height is Zero value");
    }
    paramGL10 = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if ((paramGL10 != null) && ((paramGL10 instanceof GLViewGroup))) {
      ((GLViewGroup)paramGL10).b(paramInt1, paramInt2);
    }
    Process.setThreadPriority(-4);
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas.a(paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = (GL11)paramGL10;
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    try
    {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLCanvas = new GLES20Canvas();
      BasicTexture.d();
      if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView != null) && ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView instanceof GLViewGroup))) {
        ((GLViewGroup)this.jdField_a_of_type_ComTencentAvOpenglUiGLView).j();
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      TextureProgramFactory.a();
      setRenderMode(0);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
  }
  
  @SuppressLint({"NewApi"})
  public void requestRender()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    long l = SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long;
    if ((l > 0L) && (l < 20L)) {
      try
      {
        if (this.jdField_b_of_type_Int >= 2) {
          return;
        }
        this.jdField_b_of_type_Int += 1;
        super.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 20L - l);
        return;
      }
      finally {}
    }
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void setContentPane(GLView paramGLView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglUiGLView;
    if (localObject == paramGLView) {
      return;
    }
    if (localObject != null)
    {
      if (this.jdField_c_of_type_Boolean)
      {
        long l = SystemClock.uptimeMillis();
        localObject = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.jdField_a_of_type_ComTencentAvOpenglUiGLView.b((MotionEvent)localObject);
        ((MotionEvent)localObject).recycle();
        this.jdField_c_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentAvOpenglUiGLView.a();
      BasicTexture.c();
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLView = paramGLView;
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
    if (this.e)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_c_of_type_Int += 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("STest. surfaceCreated. sCreatedSurfaceCnt = ");
    localStringBuilder.append(jdField_c_of_type_Int);
    QLog.i(str, 1, localStringBuilder.toString());
    super.surfaceCreated(paramSurfaceHolder);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.e)
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
      jdField_c_of_type_Int -= 1;
      this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    }
    if ((this.jdField_a_of_type_ComTencentAvOpenglUiGLView instanceof GLViewGroup)) {
      queueEvent(new GLRootView.3(this));
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("STest. surfaceDestroyed. sCreatedSurfaceCnt = ");
    localStringBuilder.append(jdField_c_of_type_Int);
    QLog.i(str, 1, localStringBuilder.toString());
    super.surfaceDestroyed(paramSurfaceHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.ui.GLRootView
 * JD-Core Version:    0.7.0.1
 */