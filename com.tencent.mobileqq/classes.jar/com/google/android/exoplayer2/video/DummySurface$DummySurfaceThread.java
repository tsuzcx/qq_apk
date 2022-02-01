package com.google.android.exoplayer2.video;

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
import com.google.android.exoplayer2.util.Assertions;

class DummySurface$DummySurfaceThread
  extends HandlerThread
  implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback
{
  private static final int MSG_INIT = 1;
  private static final int MSG_RELEASE = 3;
  private static final int MSG_UPDATE_TEXTURE = 2;
  private EGLContext context;
  private EGLDisplay display;
  private Handler handler;
  private Error initError;
  private RuntimeException initException;
  private EGLSurface pbuffer;
  private DummySurface surface;
  private SurfaceTexture surfaceTexture;
  private final int[] textureIdHolder = new int[1];
  
  public DummySurface$DummySurfaceThread()
  {
    super("dummySurface");
  }
  
  private void initInternal(int paramInt)
  {
    boolean bool2 = false;
    this.display = EGL14.eglGetDisplay(0);
    if (this.display != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1, "eglGetDisplay failed");
    Object localObject = new int[2];
    Assertions.checkState(EGL14.eglInitialize(this.display, (int[])localObject, 0, (int[])localObject, 1), "eglInitialize failed");
    localObject = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if ((EGL14.eglChooseConfig(this.display, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 }, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0)) && (arrayOfInt[0] > 0) && (localObject[0] != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1, "eglChooseConfig failed");
    arrayOfInt = localObject[0];
    if (paramInt == 0)
    {
      localObject = new int[3];
      Object tmp233_231 = localObject;
      tmp233_231[0] = 12440;
      Object tmp239_233 = tmp233_231;
      tmp239_233[1] = 2;
      Object tmp243_239 = tmp239_233;
      tmp243_239[2] = 12344;
      tmp243_239;
    }
    else
    {
      localObject = new int[5];
      Object tmp260_258 = localObject;
      tmp260_258[0] = 12440;
      Object tmp266_260 = tmp260_258;
      tmp266_260[1] = 2;
      Object tmp270_266 = tmp266_260;
      tmp270_266[2] = 12992;
      Object tmp276_270 = tmp270_266;
      tmp276_270[3] = 1;
      Object tmp280_276 = tmp276_270;
      tmp280_276[4] = 12344;
      tmp280_276;
    }
    this.context = EGL14.eglCreateContext(this.display, arrayOfInt, EGL14.EGL_NO_CONTEXT, (int[])localObject, 0);
    if (this.context != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1, "eglCreateContext failed");
    if (paramInt == 1)
    {
      localObject = EGL14.EGL_NO_SURFACE;
    }
    else
    {
      if (paramInt == 2)
      {
        localObject = new int[7];
        Object tmp352_350 = localObject;
        tmp352_350[0] = 12375;
        Object tmp358_352 = tmp352_350;
        tmp358_352[1] = 1;
        Object tmp362_358 = tmp358_352;
        tmp362_358[2] = 12374;
        Object tmp368_362 = tmp362_358;
        tmp368_362[3] = 1;
        Object tmp372_368 = tmp368_362;
        tmp372_368[4] = 12992;
        Object tmp378_372 = tmp372_368;
        tmp378_372[5] = 1;
        Object tmp382_378 = tmp378_372;
        tmp382_378[6] = 12344;
        tmp382_378;
      }
      else
      {
        localObject = new int[5];
        Object tmp400_398 = localObject;
        tmp400_398[0] = 12375;
        Object tmp406_400 = tmp400_398;
        tmp406_400[1] = 1;
        Object tmp410_406 = tmp406_400;
        tmp410_406[2] = 12374;
        Object tmp416_410 = tmp410_406;
        tmp416_410[3] = 1;
        Object tmp420_416 = tmp416_410;
        tmp420_416[4] = 12344;
        tmp420_416;
      }
      this.pbuffer = EGL14.eglCreatePbufferSurface(this.display, arrayOfInt, (int[])localObject, 0);
      if (this.pbuffer != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Assertions.checkState(bool1, "eglCreatePbufferSurface failed");
      localObject = this.pbuffer;
    }
    Assertions.checkState(EGL14.eglMakeCurrent(this.display, (EGLSurface)localObject, (EGLSurface)localObject, this.context), "eglMakeCurrent failed");
    GLES20.glGenTextures(1, this.textureIdHolder, 0);
    this.surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
    this.surfaceTexture.setOnFrameAvailableListener(this);
    localObject = this.surfaceTexture;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      bool1 = true;
    }
    this.surface = new DummySurface(this, (SurfaceTexture)localObject, bool1, null);
  }
  
  private void releaseInternal()
  {
    try
    {
      if (this.surfaceTexture != null)
      {
        this.surfaceTexture.release();
        GLES20.glDeleteTextures(1, this.textureIdHolder, 0);
      }
      Object localObject1;
      return;
    }
    finally
    {
      Object localObject3 = this.pbuffer;
      if (localObject3 != null) {
        EGL14.eglDestroySurface(this.display, (EGLSurface)localObject3);
      }
      localObject3 = this.context;
      if (localObject3 != null) {
        EGL14.eglDestroyContext(this.display, (EGLContext)localObject3);
      }
      this.pbuffer = null;
      this.context = null;
      this.display = null;
      this.surface = null;
      this.surfaceTexture = null;
    }
  }
  
  /* Error */
  public boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 154	android/os/Message:what	I
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
    //   23: invokespecial 156	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:releaseInternal	()V
    //   26: aload_0
    //   27: invokevirtual 160	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:quit	()Z
    //   30: pop
    //   31: iconst_1
    //   32: ireturn
    //   33: astore_1
    //   34: goto +16 -> 50
    //   37: astore_1
    //   38: ldc 162
    //   40: ldc 164
    //   42: aload_1
    //   43: invokestatic 170	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   46: pop
    //   47: goto -21 -> 26
    //   50: aload_0
    //   51: invokevirtual 160	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:quit	()Z
    //   54: pop
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: getfield 115	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   61: invokevirtual 173	android/graphics/SurfaceTexture:updateTexImage	()V
    //   64: iconst_1
    //   65: ireturn
    //   66: aload_0
    //   67: aload_1
    //   68: getfield 176	android/os/Message:arg1	I
    //   71: invokespecial 178	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initInternal	(I)V
    //   74: aload_0
    //   75: monitorenter
    //   76: aload_0
    //   77: invokevirtual 183	java/lang/Object:notify	()V
    //   80: aload_0
    //   81: monitorexit
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: goto +63 -> 153
    //   93: astore_1
    //   94: ldc 162
    //   96: ldc 185
    //   98: aload_1
    //   99: invokestatic 170	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   102: pop
    //   103: aload_0
    //   104: aload_1
    //   105: putfield 187	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initError	Ljava/lang/Error;
    //   108: aload_0
    //   109: monitorenter
    //   110: aload_0
    //   111: invokevirtual 183	java/lang/Object:notify	()V
    //   114: aload_0
    //   115: monitorexit
    //   116: iconst_1
    //   117: ireturn
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: ldc 162
    //   126: ldc 185
    //   128: aload_1
    //   129: invokestatic 170	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   132: pop
    //   133: aload_0
    //   134: aload_1
    //   135: putfield 189	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initException	Ljava/lang/RuntimeException;
    //   138: aload_0
    //   139: monitorenter
    //   140: aload_0
    //   141: invokevirtual 183	java/lang/Object:notify	()V
    //   144: aload_0
    //   145: monitorexit
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    //   153: aload_0
    //   154: monitorenter
    //   155: aload_0
    //   156: invokevirtual 183	java/lang/Object:notify	()V
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: goto +5 -> 171
    //   169: aload_1
    //   170: athrow
    //   171: goto -2 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	this	DummySurfaceThread
    //   0	174	1	paramMessage	Message
    //   4	14	2	i	int
    // Exception table:
    //   from	to	target	type
    //   22	26	33	finally
    //   38	47	33	finally
    //   22	26	37	java/lang/Throwable
    //   76	82	84	finally
    //   85	87	84	finally
    //   66	74	89	finally
    //   94	108	89	finally
    //   124	138	89	finally
    //   66	74	93	java/lang/Error
    //   110	116	118	finally
    //   119	121	118	finally
    //   66	74	123	java/lang/RuntimeException
    //   140	146	148	finally
    //   149	151	148	finally
    //   155	161	163	finally
    //   164	166	163	finally
  }
  
  public DummySurface init(int paramInt)
  {
    start();
    this.handler = new Handler(getLooper(), this);
    for (;;)
    {
      try
      {
        localObject1 = this.handler;
        int i = 0;
        ((Handler)localObject1).obtainMessage(1, paramInt, 0).sendToTarget();
        paramInt = i;
        if ((this.surface == null) && (this.initException == null))
        {
          localObject1 = this.initError;
          if (localObject1 != null) {
            break;
          }
        }
      }
      finally
      {
        Object localObject1;
        continue;
        throw localObject2;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
      }
      paramInt = 1;
    }
    if (paramInt != 0) {
      Thread.currentThread().interrupt();
    }
    localObject1 = this.initException;
    if (localObject1 == null)
    {
      localObject1 = this.initError;
      if (localObject1 == null) {
        return this.surface;
      }
      throw ((Throwable)localObject1);
    }
    throw ((Throwable)localObject1);
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.handler.sendEmptyMessage(2);
  }
  
  public void release()
  {
    this.handler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread
 * JD-Core Version:    0.7.0.1
 */