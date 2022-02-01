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
    boolean bool2 = true;
    this.display = EGL14.eglGetDisplay(0);
    Object localObject;
    int[] arrayOfInt;
    if (this.display != null)
    {
      bool1 = true;
      Assertions.checkState(bool1, "eglGetDisplay failed");
      localObject = new int[2];
      Assertions.checkState(EGL14.eglInitialize(this.display, (int[])localObject, 0, (int[])localObject, 1), "eglInitialize failed");
      localObject = new EGLConfig[1];
      arrayOfInt = new int[1];
      if ((!EGL14.eglChooseConfig(this.display, new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 }, 0, (EGLConfig[])localObject, 0, 1, arrayOfInt, 0)) || (arrayOfInt[0] <= 0) || (localObject[0] == null)) {
        break label372;
      }
      bool1 = true;
      label200:
      Assertions.checkState(bool1, "eglChooseConfig failed");
      arrayOfInt = localObject[0];
      if (paramInt != 0) {
        break label377;
      }
      localObject = new int[3];
      Object tmp223_221 = localObject;
      tmp223_221[0] = 12440;
      Object tmp229_223 = tmp223_221;
      tmp229_223[1] = 2;
      Object tmp233_229 = tmp229_223;
      tmp233_229[2] = 12344;
      tmp233_229;
      label240:
      this.context = EGL14.eglCreateContext(this.display, arrayOfInt, EGL14.EGL_NO_CONTEXT, (int[])localObject, 0);
      if (this.context == null) {
        break label414;
      }
      bool1 = true;
      label268:
      Assertions.checkState(bool1, "eglCreateContext failed");
      if (paramInt != 1) {
        break label419;
      }
      localObject = EGL14.EGL_NO_SURFACE;
      Assertions.checkState(EGL14.eglMakeCurrent(this.display, (EGLSurface)localObject, (EGLSurface)localObject, this.context), "eglMakeCurrent failed");
      GLES20.glGenTextures(1, this.textureIdHolder, 0);
      this.surfaceTexture = new SurfaceTexture(this.textureIdHolder[0]);
      this.surfaceTexture.setOnFrameAvailableListener(this);
      localObject = this.surfaceTexture;
      if (paramInt == 0) {
        break label552;
      }
    }
    label414:
    label419:
    label547:
    label552:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.surface = new DummySurface(this, (SurfaceTexture)localObject, bool1, null);
      return;
      bool1 = false;
      break;
      label372:
      bool1 = false;
      break label200;
      label377:
      localObject = new int[5];
      tmp384_382 = localObject;
      tmp384_382[0] = 12440;
      tmp390_384 = tmp384_382;
      tmp390_384[1] = 2;
      tmp394_390 = tmp390_384;
      tmp394_390[2] = 12992;
      tmp400_394 = tmp394_390;
      tmp400_394[3] = 1;
      tmp404_400 = tmp400_394;
      tmp404_400[4] = 12344;
      tmp404_400;
      break label240;
      bool1 = false;
      break label268;
      if (paramInt == 2)
      {
        localObject = new int[7];
        tmp432_430 = localObject;
        tmp432_430[0] = 12375;
        tmp438_432 = tmp432_430;
        tmp438_432[1] = 1;
        tmp442_438 = tmp438_432;
        tmp442_438[2] = 12374;
        tmp448_442 = tmp442_438;
        tmp448_442[3] = 1;
        tmp452_448 = tmp448_442;
        tmp452_448[4] = 12992;
        tmp458_452 = tmp452_448;
        tmp458_452[5] = 1;
        tmp462_458 = tmp458_452;
        tmp462_458[6] = 12344;
        tmp462_458;
        label470:
        this.pbuffer = EGL14.eglCreatePbufferSurface(this.display, arrayOfInt, (int[])localObject, 0);
        if (this.pbuffer == null) {
          break label547;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        Assertions.checkState(bool1, "eglCreatePbufferSurface failed");
        localObject = this.pbuffer;
        break;
        localObject = new int[5];
        tmp517_515 = localObject;
        tmp517_515[0] = 12375;
        tmp523_517 = tmp517_515;
        tmp523_517[1] = 1;
        tmp527_523 = tmp523_517;
        tmp527_523[2] = 12374;
        tmp533_527 = tmp527_523;
        tmp533_527[3] = 1;
        tmp537_533 = tmp533_527;
        tmp537_533[4] = 12344;
        tmp537_533;
        break label470;
      }
    }
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
      return;
    }
    finally
    {
      if (this.pbuffer != null) {
        EGL14.eglDestroySurface(this.display, this.pbuffer);
      }
      if (this.context != null) {
        EGL14.eglDestroyContext(this.display, this.context);
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
    //   4: tableswitch	default:+28 -> 32, 1:+30->34, 2:+129->133, 3:+138->142
    //   33: ireturn
    //   34: aload_0
    //   35: aload_1
    //   36: getfield 157	android/os/Message:arg1	I
    //   39: invokespecial 159	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initInternal	(I)V
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_0
    //   45: invokevirtual 164	java/lang/Object:notify	()V
    //   48: aload_0
    //   49: monitorexit
    //   50: iconst_1
    //   51: ireturn
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: ldc 166
    //   60: ldc 168
    //   62: aload_1
    //   63: invokestatic 174	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   66: pop
    //   67: aload_0
    //   68: aload_1
    //   69: putfield 176	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initException	Ljava/lang/RuntimeException;
    //   72: aload_0
    //   73: monitorenter
    //   74: aload_0
    //   75: invokevirtual 164	java/lang/Object:notify	()V
    //   78: aload_0
    //   79: monitorexit
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: ldc 166
    //   90: ldc 168
    //   92: aload_1
    //   93: invokestatic 174	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   96: pop
    //   97: aload_0
    //   98: aload_1
    //   99: putfield 178	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:initError	Ljava/lang/Error;
    //   102: aload_0
    //   103: monitorenter
    //   104: aload_0
    //   105: invokevirtual 164	java/lang/Object:notify	()V
    //   108: aload_0
    //   109: monitorexit
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: aload_0
    //   119: monitorenter
    //   120: aload_0
    //   121: invokevirtual 164	java/lang/Object:notify	()V
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: aload_0
    //   134: getfield 107	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:surfaceTexture	Landroid/graphics/SurfaceTexture;
    //   137: invokevirtual 181	android/graphics/SurfaceTexture:updateTexImage	()V
    //   140: iconst_1
    //   141: ireturn
    //   142: aload_0
    //   143: invokespecial 183	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:releaseInternal	()V
    //   146: aload_0
    //   147: invokevirtual 187	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:quit	()Z
    //   150: pop
    //   151: iconst_1
    //   152: ireturn
    //   153: astore_1
    //   154: ldc 166
    //   156: ldc 189
    //   158: aload_1
    //   159: invokestatic 174	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   162: pop
    //   163: aload_0
    //   164: invokevirtual 187	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:quit	()Z
    //   167: pop
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_1
    //   171: aload_0
    //   172: invokevirtual 187	com/google/android/exoplayer2/video/DummySurface$DummySurfaceThread:quit	()Z
    //   175: pop
    //   176: aload_1
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	DummySurfaceThread
    //   0	178	1	paramMessage	Message
    // Exception table:
    //   from	to	target	type
    //   44	50	52	finally
    //   53	55	52	finally
    //   34	42	57	java/lang/RuntimeException
    //   74	80	82	finally
    //   83	85	82	finally
    //   34	42	87	java/lang/Error
    //   104	110	112	finally
    //   113	115	112	finally
    //   34	42	117	finally
    //   58	72	117	finally
    //   88	102	117	finally
    //   120	126	128	finally
    //   129	131	128	finally
    //   142	146	153	java/lang/Throwable
    //   142	146	170	finally
    //   154	163	170	finally
  }
  
  public DummySurface init(int paramInt)
  {
    int i = 0;
    start();
    this.handler = new Handler(getLooper(), this);
    try
    {
      this.handler.obtainMessage(1, paramInt, 0).sendToTarget();
      paramInt = i;
      while ((this.surface == null) && (this.initException == null))
      {
        Error localError = this.initError;
        if (localError != null) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        Thread.currentThread().interrupt();
      }
      if (this.initException != null) {
        throw this.initException;
      }
    }
    finally {}
    if (this.initError != null) {
      throw this.initError;
    }
    return this.surface;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface.DummySurfaceThread
 * JD-Core Version:    0.7.0.1
 */