package com.tencent.luggage.wxa.ap;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.luggage.wxa.ao.a;

class c$a
  extends HandlerThread
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
{
  private final int[] a = new int[1];
  private EGLDisplay b;
  private EGLContext c;
  private EGLSurface d;
  private Handler e;
  private SurfaceTexture f;
  private Error g;
  private RuntimeException h;
  private c i;
  
  public c$a()
  {
    super("dummySurface");
  }
  
  private void b()
  {
    try
    {
      if (this.f != null)
      {
        this.f.release();
        GLES20.glDeleteTextures(1, this.a, 0);
      }
      Object localObject1;
      return;
    }
    finally
    {
      Object localObject3 = this.d;
      if (localObject3 != null) {
        EGL14.eglDestroySurface(this.b, (EGLSurface)localObject3);
      }
      localObject3 = this.c;
      if (localObject3 != null) {
        EGL14.eglDestroyContext(this.b, (EGLContext)localObject3);
      }
      this.d = null;
      this.c = null;
      this.b = null;
      this.i = null;
      this.f = null;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.b = EGL14.eglGetDisplay(0);
    boolean bool;
    if (this.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool, "eglGetDisplay failed");
    Object localObject1 = new int[2];
    a.b(EGL14.eglInitialize(this.b, (int[])localObject1, 0, (int[])localObject1, 1), "eglInitialize failed");
    localObject1 = new EGLConfig[1];
    Object localObject2 = new int[1];
    if ((EGL14.eglChooseConfig(this.b, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 }, 0, (EGLConfig[])localObject1, 0, 1, (int[])localObject2, 0)) && (localObject2[0] > 0) && (localObject1[0] != null)) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool, "eglChooseConfig failed");
    localObject2 = localObject1[0];
    if (paramBoolean)
    {
      localObject1 = new int[5];
      Object tmp222_221 = localObject1;
      tmp222_221[0] = 12440;
      Object tmp228_222 = tmp222_221;
      tmp228_222[1] = 2;
      Object tmp232_228 = tmp228_222;
      tmp232_228[2] = 12992;
      Object tmp238_232 = tmp232_228;
      tmp238_232[3] = 1;
      Object tmp242_238 = tmp238_232;
      tmp242_238[4] = 12344;
      tmp242_238;
    }
    else
    {
      localObject1 = new int[3];
      Object tmp257_256 = localObject1;
      tmp257_256[0] = 12440;
      Object tmp263_257 = tmp257_256;
      tmp263_257[1] = 2;
      Object tmp267_263 = tmp263_257;
      tmp267_263[2] = 12344;
      tmp267_263;
    }
    this.c = EGL14.eglCreateContext(this.b, (EGLConfig)localObject2, EGL14.EGL_NO_CONTEXT, (int[])localObject1, 0);
    if (this.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool, "eglCreateContext failed");
    if (paramBoolean)
    {
      localObject1 = new int[7];
      Object tmp322_321 = localObject1;
      tmp322_321[0] = 12375;
      Object tmp328_322 = tmp322_321;
      tmp328_322[1] = 1;
      Object tmp332_328 = tmp328_322;
      tmp332_328[2] = 12374;
      Object tmp338_332 = tmp332_328;
      tmp338_332[3] = 1;
      Object tmp342_338 = tmp338_332;
      tmp342_338[4] = 12992;
      Object tmp348_342 = tmp342_338;
      tmp348_342[5] = 1;
      Object tmp352_348 = tmp348_342;
      tmp352_348[6] = 12344;
      tmp352_348;
    }
    else
    {
      localObject1 = new int[5];
      Object tmp368_367 = localObject1;
      tmp368_367[0] = 12375;
      Object tmp374_368 = tmp368_367;
      tmp374_368[1] = 1;
      Object tmp378_374 = tmp374_368;
      tmp378_374[2] = 12374;
      Object tmp384_378 = tmp378_374;
      tmp384_378[3] = 1;
      Object tmp388_384 = tmp384_378;
      tmp388_384[4] = 12344;
      tmp388_384;
    }
    this.d = EGL14.eglCreatePbufferSurface(this.b, (EGLConfig)localObject2, (int[])localObject1, 0);
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool, "eglCreatePbufferSurface failed");
    localObject1 = this.b;
    localObject2 = this.d;
    a.b(EGL14.eglMakeCurrent((EGLDisplay)localObject1, (EGLSurface)localObject2, (EGLSurface)localObject2, this.c), "eglMakeCurrent failed");
    GLES20.glGenTextures(1, this.a, 0);
    this.f = new SurfaceTexture(this.a[0]);
    this.f.setOnFrameAvailableListener(this);
    this.i = new c(this, this.f, paramBoolean, null);
  }
  
  public c a(boolean paramBoolean)
  {
    start();
    this.e = new Handler(getLooper(), this);
    try
    {
      localObject1 = this.e;
      k = 0;
      if (!paramBoolean) {
        break label152;
      }
      j = 1;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int k;
        for (;;)
        {
          throw localObject2;
        }
        int j = 0;
      }
    }
    ((Handler)localObject1).obtainMessage(1, j, 0).sendToTarget();
    for (j = k; (this.i == null) && (this.h == null); j = 1) {
      for (;;)
      {
        localObject1 = this.g;
        if (localObject1 != null) {
          break label89;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          label84:
          break label84;
        }
      }
    }
    label89:
    if (j != 0) {
      Thread.currentThread().interrupt();
    }
    localObject1 = this.h;
    if (localObject1 == null)
    {
      localObject1 = this.g;
      if (localObject1 == null) {
        return this.i;
      }
      throw ((Throwable)localObject1);
    }
    throw ((Throwable)localObject1);
  }
  
  public void a()
  {
    this.e.sendEmptyMessage(3);
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 189	android/os/Message:what	I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_1
    //   7: if_icmpeq +59 -> 66
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpeq +45 -> 57
    //   15: iload_2
    //   16: iconst_3
    //   17: if_icmpeq +5 -> 22
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: invokespecial 191	com/tencent/luggage/wxa/ap/c$a:b	()V
    //   26: aload_0
    //   27: invokevirtual 195	com/tencent/luggage/wxa/ap/c$a:quit	()Z
    //   30: pop
    //   31: iconst_1
    //   32: ireturn
    //   33: astore_1
    //   34: goto +16 -> 50
    //   37: astore_1
    //   38: ldc 197
    //   40: ldc 199
    //   42: aload_1
    //   43: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   46: pop
    //   47: goto -21 -> 26
    //   50: aload_0
    //   51: invokevirtual 195	com/tencent/luggage/wxa/ap/c$a:quit	()Z
    //   54: pop
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: getfield 38	com/tencent/luggage/wxa/ap/c$a:f	Landroid/graphics/SurfaceTexture;
    //   61: invokevirtual 207	android/graphics/SurfaceTexture:updateTexImage	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_1
    //   67: getfield 210	android/os/Message:arg1	I
    //   70: ifeq +113 -> 183
    //   73: iconst_1
    //   74: istore_3
    //   75: goto +3 -> 78
    //   78: aload_0
    //   79: iload_3
    //   80: invokespecial 212	com/tencent/luggage/wxa/ap/c$a:b	(Z)V
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_0
    //   86: invokevirtual 215	java/lang/Object:notify	()V
    //   89: aload_0
    //   90: monitorexit
    //   91: iconst_1
    //   92: ireturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: astore_1
    //   99: goto +63 -> 162
    //   102: astore_1
    //   103: ldc 197
    //   105: ldc 217
    //   107: aload_1
    //   108: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   111: pop
    //   112: aload_0
    //   113: aload_1
    //   114: putfield 159	com/tencent/luggage/wxa/ap/c$a:g	Ljava/lang/Error;
    //   117: aload_0
    //   118: monitorenter
    //   119: aload_0
    //   120: invokevirtual 215	java/lang/Object:notify	()V
    //   123: aload_0
    //   124: monitorexit
    //   125: iconst_1
    //   126: ireturn
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_1
    //   131: athrow
    //   132: astore_1
    //   133: ldc 197
    //   135: ldc 217
    //   137: aload_1
    //   138: invokestatic 204	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: aload_0
    //   143: aload_1
    //   144: putfield 157	com/tencent/luggage/wxa/ap/c$a:h	Ljava/lang/RuntimeException;
    //   147: aload_0
    //   148: monitorenter
    //   149: aload_0
    //   150: invokevirtual 215	java/lang/Object:notify	()V
    //   153: aload_0
    //   154: monitorexit
    //   155: iconst_1
    //   156: ireturn
    //   157: astore_1
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_1
    //   161: athrow
    //   162: aload_0
    //   163: monitorenter
    //   164: aload_0
    //   165: invokevirtual 215	java/lang/Object:notify	()V
    //   168: aload_0
    //   169: monitorexit
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: monitorexit
    //   175: goto +5 -> 180
    //   178: aload_1
    //   179: athrow
    //   180: goto -2 -> 178
    //   183: iconst_0
    //   184: istore_3
    //   185: goto -107 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	a
    //   0	188	1	paramMessage	Message
    //   4	14	2	j	int
    //   74	111	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   22	26	33	finally
    //   38	47	33	finally
    //   22	26	37	java/lang/Throwable
    //   85	91	93	finally
    //   94	96	93	finally
    //   66	73	98	finally
    //   78	83	98	finally
    //   103	117	98	finally
    //   133	147	98	finally
    //   66	73	102	java/lang/Error
    //   78	83	102	java/lang/Error
    //   119	125	127	finally
    //   128	130	127	finally
    //   66	73	132	java/lang/RuntimeException
    //   78	83	132	java/lang/RuntimeException
    //   149	155	157	finally
    //   158	160	157	finally
    //   164	170	172	finally
    //   173	175	172	finally
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.e.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.c.a
 * JD-Core Version:    0.7.0.1
 */