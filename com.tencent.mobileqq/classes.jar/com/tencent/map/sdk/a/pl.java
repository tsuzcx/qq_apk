package com.tencent.map.sdk.a;

import android.annotation.TargetApi;
import android.opengl.GLUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;

public final class pl
  extends Thread
{
  private static int d = 60;
  private static long p = 1500L;
  private WeakReference<pn> a;
  private AtomicBoolean b = new AtomicBoolean(true);
  private AtomicBoolean c = new AtomicBoolean(false);
  private byte[] e = new byte[0];
  private WeakReference<Object> f;
  private volatile boolean g = false;
  private EGLConfig h = null;
  private EGL10 i;
  private EGLDisplay j = EGL10.EGL_NO_DISPLAY;
  private EGLContext k = EGL10.EGL_NO_CONTEXT;
  private EGLSurface l = EGL10.EGL_NO_SURFACE;
  private GL m;
  private volatile long n = 0L;
  private boolean o = false;
  
  public pl(Object paramObject, pn parampn)
  {
    this.f = new WeakReference(paramObject);
    this.a = new WeakReference(parampn);
  }
  
  @TargetApi(14)
  private void e()
  {
    while (this.b.get())
    {
      f();
      try
      {
        if (this.f != null)
        {
          if (this.f.get() == null) {
            return;
          }
          this.l = this.i.eglCreateWindowSurface(this.j, this.h, this.f.get(), null);
          StringBuilder localStringBuilder1;
          if (this.l == EGL10.EGL_NO_SURFACE)
          {
            localStringBuilder1 = new StringBuilder("eglCreateWindowSurface failed,errorDetail:");
            localStringBuilder1.append(GLUtils.getEGLErrorString(this.i.eglGetError()));
            Log.e("tencentmap_glthread", localStringBuilder1.toString());
            continue;
          }
          if (!this.i.eglMakeCurrent(this.j, this.l, this.l, this.k))
          {
            localStringBuilder1 = new StringBuilder("eglMakeCurrent failed,errorDetail:");
            localStringBuilder1.append(GLUtils.getEGLErrorString(this.i.eglGetError()));
            Log.e("tencentmap_glthread", localStringBuilder1.toString());
            continue;
          }
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder2 = new StringBuilder("updateSurface failed,errorDetail:");
        localStringBuilder2.append(Log.getStackTraceString(localThrowable));
        Log.e("tencentmap_glthread", localStringBuilder2.toString());
      }
    }
  }
  
  private void f()
  {
    EGLSurface localEGLSurface = this.l;
    if (localEGLSurface != null)
    {
      if (localEGLSurface == EGL10.EGL_NO_SURFACE) {
        return;
      }
      this.i.eglDestroySurface(this.j, this.l);
      this.l = EGL10.EGL_NO_SURFACE;
    }
  }
  
  public final void a()
  {
    this.c.set(true);
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public final void a(Object paramObject)
  {
    this.f = new WeakReference(paramObject);
    this.g = true;
  }
  
  public final void b()
  {
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notifyAll();
      return;
    }
  }
  
  public final void c()
  {
    this.b.set(false);
    this.c.set(false);
    synchronized (this.e)
    {
      this.e.notifyAll();
      interrupt();
      return;
    }
  }
  
  public final void d()
  {
    this.o = true;
    this.n = System.currentTimeMillis();
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 180	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: getfield 51	com/tencent/map/sdk/a/pl:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   8: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   11: ifeq +617 -> 628
    //   14: aload_0
    //   15: getfield 87	com/tencent/map/sdk/a/pl:f	Ljava/lang/ref/WeakReference;
    //   18: ifnull +610 -> 628
    //   21: aload_0
    //   22: getfield 87	com/tencent/map/sdk/a/pl:f	Ljava/lang/ref/WeakReference;
    //   25: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   28: ifnonnull +6 -> 34
    //   31: goto +597 -> 628
    //   34: aload_0
    //   35: getfield 87	com/tencent/map/sdk/a/pl:f	Ljava/lang/ref/WeakReference;
    //   38: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_0
    //   43: invokestatic 186	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
    //   46: checkcast 61	javax/microedition/khronos/egl/EGL10
    //   49: putfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   52: aload_0
    //   53: aload_0
    //   54: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   57: getstatic 190	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
    //   60: invokeinterface 194 2 0
    //   65: putfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   68: aload_0
    //   69: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   72: getstatic 64	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   75: if_acmpne +43 -> 118
    //   78: new 111	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 196
    //   84: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: astore_1
    //   88: aload_1
    //   89: aload_0
    //   90: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   93: invokeinterface 120 1 0
    //   98: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   101: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: ldc 132
    //   107: aload_1
    //   108: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: goto -111 -> 4
    //   118: iconst_2
    //   119: newarray int
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   126: aload_0
    //   127: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   130: aload_2
    //   131: invokeinterface 200 3 0
    //   136: ifne +43 -> 179
    //   139: new 111	java/lang/StringBuilder
    //   142: dup
    //   143: ldc 202
    //   145: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   148: astore_1
    //   149: aload_1
    //   150: aload_0
    //   151: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   154: invokeinterface 120 1 0
    //   159: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   162: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: ldc 132
    //   168: aload_1
    //   169: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   175: pop
    //   176: goto -172 -> 4
    //   179: iconst_1
    //   180: newarray int
    //   182: astore_2
    //   183: iconst_1
    //   184: anewarray 204	javax/microedition/khronos/egl/EGLConfig
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   192: aload_0
    //   193: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   196: bipush 15
    //   198: newarray int
    //   200: dup
    //   201: iconst_0
    //   202: sipush 12324
    //   205: iastore
    //   206: dup
    //   207: iconst_1
    //   208: bipush 8
    //   210: iastore
    //   211: dup
    //   212: iconst_2
    //   213: sipush 12323
    //   216: iastore
    //   217: dup
    //   218: iconst_3
    //   219: bipush 8
    //   221: iastore
    //   222: dup
    //   223: iconst_4
    //   224: sipush 12322
    //   227: iastore
    //   228: dup
    //   229: iconst_5
    //   230: bipush 8
    //   232: iastore
    //   233: dup
    //   234: bipush 6
    //   236: sipush 12321
    //   239: iastore
    //   240: dup
    //   241: bipush 7
    //   243: bipush 8
    //   245: iastore
    //   246: dup
    //   247: bipush 8
    //   249: sipush 12325
    //   252: iastore
    //   253: dup
    //   254: bipush 9
    //   256: bipush 16
    //   258: iastore
    //   259: dup
    //   260: bipush 10
    //   262: sipush 12326
    //   265: iastore
    //   266: dup
    //   267: bipush 11
    //   269: iconst_0
    //   270: iastore
    //   271: dup
    //   272: bipush 12
    //   274: sipush 12352
    //   277: iastore
    //   278: dup
    //   279: bipush 13
    //   281: iconst_4
    //   282: iastore
    //   283: dup
    //   284: bipush 14
    //   286: sipush 12344
    //   289: iastore
    //   290: aload_3
    //   291: iconst_1
    //   292: aload_2
    //   293: invokeinterface 208 6 0
    //   298: ifne +43 -> 341
    //   301: new 111	java/lang/StringBuilder
    //   304: dup
    //   305: ldc 210
    //   307: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: astore_1
    //   311: aload_1
    //   312: aload_0
    //   313: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   316: invokeinterface 120 1 0
    //   321: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   324: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: ldc 132
    //   330: aload_1
    //   331: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   337: pop
    //   338: goto -334 -> 4
    //   341: aload_0
    //   342: aload_3
    //   343: iconst_0
    //   344: aaload
    //   345: putfield 59	com/tencent/map/sdk/a/pl:h	Ljavax/microedition/khronos/egl/EGLConfig;
    //   348: aload_0
    //   349: aload_0
    //   350: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   353: aload_0
    //   354: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   357: aload_0
    //   358: getfield 59	com/tencent/map/sdk/a/pl:h	Ljavax/microedition/khronos/egl/EGLConfig;
    //   361: aload_1
    //   362: aconst_null
    //   363: invokeinterface 109 5 0
    //   368: putfield 76	com/tencent/map/sdk/a/pl:l	Ljavax/microedition/khronos/egl/EGLSurface;
    //   371: aload_0
    //   372: getfield 76	com/tencent/map/sdk/a/pl:l	Ljavax/microedition/khronos/egl/EGLSurface;
    //   375: getstatic 74	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   378: if_acmpne +43 -> 421
    //   381: new 111	java/lang/StringBuilder
    //   384: dup
    //   385: ldc 212
    //   387: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: astore_1
    //   391: aload_1
    //   392: aload_0
    //   393: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   396: invokeinterface 120 1 0
    //   401: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   404: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 132
    //   410: aload_1
    //   411: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   417: pop
    //   418: goto -414 -> 4
    //   421: aload_0
    //   422: aload_0
    //   423: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   426: aload_0
    //   427: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   430: aload_3
    //   431: iconst_0
    //   432: aaload
    //   433: getstatic 69	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   436: iconst_3
    //   437: newarray int
    //   439: dup
    //   440: iconst_0
    //   441: sipush 12440
    //   444: iastore
    //   445: dup
    //   446: iconst_1
    //   447: iconst_2
    //   448: iastore
    //   449: dup
    //   450: iconst_2
    //   451: sipush 12344
    //   454: iastore
    //   455: invokeinterface 216 5 0
    //   460: putfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   463: aload_0
    //   464: getfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   467: getstatic 69	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   470: if_acmpne +43 -> 513
    //   473: new 111	java/lang/StringBuilder
    //   476: dup
    //   477: ldc 218
    //   479: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: astore_1
    //   483: aload_1
    //   484: aload_0
    //   485: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   488: invokeinterface 120 1 0
    //   493: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   496: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: ldc 132
    //   502: aload_1
    //   503: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   509: pop
    //   510: goto -506 -> 4
    //   513: aload_0
    //   514: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   517: aload_0
    //   518: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   521: aload_0
    //   522: getfield 76	com/tencent/map/sdk/a/pl:l	Ljavax/microedition/khronos/egl/EGLSurface;
    //   525: aload_0
    //   526: getfield 76	com/tencent/map/sdk/a/pl:l	Ljavax/microedition/khronos/egl/EGLSurface;
    //   529: aload_0
    //   530: getfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   533: invokeinterface 145 5 0
    //   538: ifne +43 -> 581
    //   541: new 111	java/lang/StringBuilder
    //   544: dup
    //   545: ldc 147
    //   547: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   550: astore_1
    //   551: aload_1
    //   552: aload_0
    //   553: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   556: invokeinterface 120 1 0
    //   561: invokestatic 126	android/opengl/GLUtils:getEGLErrorString	(I)Ljava/lang/String;
    //   564: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 132
    //   570: aload_1
    //   571: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   577: pop
    //   578: goto -574 -> 4
    //   581: aload_0
    //   582: aload_0
    //   583: getfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   586: invokevirtual 222	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   589: putfield 224	com/tencent/map/sdk/a/pl:m	Ljavax/microedition/khronos/opengles/GL;
    //   592: goto +36 -> 628
    //   595: astore_1
    //   596: new 111	java/lang/StringBuilder
    //   599: dup
    //   600: ldc 226
    //   602: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   605: astore_2
    //   606: aload_2
    //   607: aload_1
    //   608: invokestatic 153	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   611: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: ldc 132
    //   617: aload_2
    //   618: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   624: pop
    //   625: goto -621 -> 4
    //   628: aload_0
    //   629: getfield 51	com/tencent/map/sdk/a/pl:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   632: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   635: ifeq +243 -> 878
    //   638: aload_0
    //   639: getfield 55	com/tencent/map/sdk/a/pl:e	[B
    //   642: astore_1
    //   643: aload_1
    //   644: monitorenter
    //   645: aload_0
    //   646: getfield 53	com/tencent/map/sdk/a/pl:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   649: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   652: ifeq +13 -> 665
    //   655: aload_0
    //   656: getfield 55	com/tencent/map/sdk/a/pl:e	[B
    //   659: invokevirtual 229	java/lang/Object:wait	()V
    //   662: goto -17 -> 645
    //   665: aload_1
    //   666: monitorexit
    //   667: aload_0
    //   668: getfield 57	com/tencent/map/sdk/a/pl:g	Z
    //   671: ifeq +21 -> 692
    //   674: aload_0
    //   675: invokespecial 231	com/tencent/map/sdk/a/pl:e	()V
    //   678: aload_0
    //   679: iconst_1
    //   680: putfield 80	com/tencent/map/sdk/a/pl:o	Z
    //   683: aload_0
    //   684: iconst_0
    //   685: putfield 57	com/tencent/map/sdk/a/pl:g	Z
    //   688: aload_0
    //   689: invokevirtual 233	com/tencent/map/sdk/a/pl:d	()V
    //   692: aload_0
    //   693: getfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   696: ifnull -68 -> 628
    //   699: aload_0
    //   700: getfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   703: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   706: ifnull -78 -> 628
    //   709: aload_0
    //   710: getfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   713: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   716: checkcast 235	com/tencent/map/sdk/a/pn
    //   719: astore_1
    //   720: aload_0
    //   721: getfield 80	com/tencent/map/sdk/a/pl:o	Z
    //   724: ifeq +29 -> 753
    //   727: invokestatic 175	java/lang/System:currentTimeMillis	()J
    //   730: aload_0
    //   731: getfield 78	com/tencent/map/sdk/a/pl:n	J
    //   734: lsub
    //   735: getstatic 237	com/tencent/map/sdk/a/pl:p	J
    //   738: lcmp
    //   739: ifge +14 -> 753
    //   742: aload_1
    //   743: ifnull +20 -> 763
    //   746: aload_1
    //   747: invokevirtual 240	com/tencent/map/sdk/a/pn:t	()V
    //   750: goto +13 -> 763
    //   753: aload_0
    //   754: iconst_0
    //   755: putfield 80	com/tencent/map/sdk/a/pl:o	Z
    //   758: aload_0
    //   759: lconst_0
    //   760: putfield 78	com/tencent/map/sdk/a/pl:n	J
    //   763: aload_1
    //   764: ifnull +35 -> 799
    //   767: aload_1
    //   768: aload_0
    //   769: getfield 224	com/tencent/map/sdk/a/pl:m	Ljavax/microedition/khronos/opengles/GL;
    //   772: checkcast 242	javax/microedition/khronos/opengles/GL10
    //   775: invokevirtual 245	com/tencent/map/sdk/a/pn:a	(Ljavax/microedition/khronos/opengles/GL10;)Z
    //   778: ifeq +21 -> 799
    //   781: aload_0
    //   782: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   785: aload_0
    //   786: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   789: aload_0
    //   790: getfield 76	com/tencent/map/sdk/a/pl:l	Ljavax/microedition/khronos/egl/EGLSurface;
    //   793: invokeinterface 248 3 0
    //   798: pop
    //   799: aload_0
    //   800: monitorenter
    //   801: aload_0
    //   802: sipush 1000
    //   805: getstatic 250	com/tencent/map/sdk/a/pl:d	I
    //   808: idiv
    //   809: i2l
    //   810: invokevirtual 253	java/lang/Object:wait	(J)V
    //   813: aload_0
    //   814: monitorexit
    //   815: goto -187 -> 628
    //   818: astore_1
    //   819: aload_0
    //   820: monitorexit
    //   821: aload_1
    //   822: athrow
    //   823: astore_2
    //   824: aload_1
    //   825: monitorexit
    //   826: aload_2
    //   827: athrow
    //   828: astore_1
    //   829: aload_0
    //   830: getfield 51	com/tencent/map/sdk/a/pl:b	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   833: invokevirtual 98	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   836: ifne +10 -> 846
    //   839: aload_1
    //   840: instanceof 178
    //   843: ifne -215 -> 628
    //   846: new 111	java/lang/StringBuilder
    //   849: dup
    //   850: ldc 255
    //   852: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   855: astore_2
    //   856: aload_2
    //   857: aload_1
    //   858: invokestatic 153	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   861: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: ldc 132
    //   867: aload_2
    //   868: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 141	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   874: pop
    //   875: goto -247 -> 628
    //   878: aload_0
    //   879: getfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   882: astore_1
    //   883: aload_1
    //   884: ifnull +73 -> 957
    //   887: aload_1
    //   888: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   891: ifnull +66 -> 957
    //   894: aload_0
    //   895: getfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   898: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   901: checkcast 235	com/tencent/map/sdk/a/pn
    //   904: astore_2
    //   905: iconst_1
    //   906: newarray byte
    //   908: astore_1
    //   909: aload_2
    //   910: aload_1
    //   911: invokevirtual 258	com/tencent/map/sdk/a/pn:a	([B)V
    //   914: aload_1
    //   915: monitorenter
    //   916: aload_1
    //   917: ldc2_w 259
    //   920: invokevirtual 253	java/lang/Object:wait	(J)V
    //   923: goto +21 -> 944
    //   926: astore_2
    //   927: goto +26 -> 953
    //   930: astore_3
    //   931: aload_3
    //   932: invokestatic 153	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   935: invokestatic 264	com/tencent/map/sdk/a/or:b	(Ljava/lang/String;)V
    //   938: invokestatic 268	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   941: invokevirtual 269	java/lang/Thread:interrupt	()V
    //   944: aload_1
    //   945: monitorexit
    //   946: aload_2
    //   947: invokevirtual 272	com/tencent/map/sdk/a/pn:r	()V
    //   950: goto +7 -> 957
    //   953: aload_1
    //   954: monitorexit
    //   955: aload_2
    //   956: athrow
    //   957: aload_0
    //   958: aconst_null
    //   959: putfield 89	com/tencent/map/sdk/a/pl:a	Ljava/lang/ref/WeakReference;
    //   962: aload_0
    //   963: invokespecial 100	com/tencent/map/sdk/a/pl:f	()V
    //   966: aload_0
    //   967: getfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   970: astore_1
    //   971: aload_1
    //   972: ifnull +38 -> 1010
    //   975: aload_1
    //   976: getstatic 69	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   979: if_acmpne +6 -> 985
    //   982: goto +28 -> 1010
    //   985: aload_0
    //   986: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   989: aload_0
    //   990: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   993: aload_0
    //   994: getfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   997: invokeinterface 276 3 0
    //   1002: pop
    //   1003: aload_0
    //   1004: getstatic 69	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   1007: putfield 71	com/tencent/map/sdk/a/pl:k	Ljavax/microedition/khronos/egl/EGLContext;
    //   1010: aload_0
    //   1011: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1014: ifnull +7 -> 1021
    //   1017: getstatic 64	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1020: astore_1
    //   1021: aload_0
    //   1022: getfield 105	com/tencent/map/sdk/a/pl:i	Ljavax/microedition/khronos/egl/EGL10;
    //   1025: aload_0
    //   1026: getfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1029: invokeinterface 280 2 0
    //   1034: pop
    //   1035: aload_0
    //   1036: getstatic 64	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1039: putfield 66	com/tencent/map/sdk/a/pl:j	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1042: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1043	0	this	pl
    //   41	530	1	localObject1	Object
    //   595	13	1	localThrowable1	Throwable
    //   642	126	1	localObject2	Object
    //   818	7	1	localObject3	Object
    //   828	30	1	localThrowable2	Throwable
    //   882	139	1	localObject4	Object
    //   121	497	2	localObject5	Object
    //   823	4	2	localObject6	Object
    //   855	55	2	localObject7	Object
    //   926	30	2	localObject8	Object
    //   187	244	3	arrayOfEGLConfig	EGLConfig[]
    //   930	2	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   14	31	595	java/lang/Throwable
    //   34	115	595	java/lang/Throwable
    //   118	176	595	java/lang/Throwable
    //   179	338	595	java/lang/Throwable
    //   341	418	595	java/lang/Throwable
    //   421	510	595	java/lang/Throwable
    //   513	578	595	java/lang/Throwable
    //   581	592	595	java/lang/Throwable
    //   801	815	818	finally
    //   819	821	818	finally
    //   645	662	823	finally
    //   665	667	823	finally
    //   824	826	823	finally
    //   638	645	828	java/lang/Throwable
    //   667	692	828	java/lang/Throwable
    //   692	742	828	java/lang/Throwable
    //   746	750	828	java/lang/Throwable
    //   753	763	828	java/lang/Throwable
    //   767	799	828	java/lang/Throwable
    //   799	801	828	java/lang/Throwable
    //   821	823	828	java/lang/Throwable
    //   826	828	828	java/lang/Throwable
    //   916	923	926	finally
    //   931	944	926	finally
    //   944	946	926	finally
    //   953	955	926	finally
    //   916	923	930	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pl
 * JD-Core Version:    0.7.0.1
 */