package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

@TargetApi(17)
public final class DummySurface
  extends Surface
{
  private static final int EGL_PROTECTED_CONTENT_EXT = 12992;
  private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
  private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
  private static final int SECURE_MODE_NONE = 0;
  private static final int SECURE_MODE_PROTECTED_PBUFFER = 2;
  private static final int SECURE_MODE_SURFACELESS_CONTEXT = 1;
  private static final String TAG = "DummySurface";
  private static int secureMode;
  private static boolean secureModeInitialized;
  public final boolean secure;
  private final DummySurface.DummySurfaceThread thread;
  private boolean threadReleased;
  
  private DummySurface(DummySurface.DummySurfaceThread paramDummySurfaceThread, SurfaceTexture paramSurfaceTexture, boolean paramBoolean)
  {
    super(paramSurfaceTexture);
    this.thread = paramDummySurfaceThread;
    this.secure = paramBoolean;
  }
  
  private static void assertApiLevel17OrHigher()
  {
    if (Util.SDK_INT < 17) {
      throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
  }
  
  @TargetApi(24)
  private static int getSecureModeV24(Context paramContext)
  {
    if ((Util.SDK_INT < 26) && (("samsung".equals(Util.MANUFACTURER)) || ("XT1650".equals(Util.MODEL)))) {}
    do
    {
      do
      {
        return 0;
      } while ((Util.SDK_INT < 26) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")));
      paramContext = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    } while ((paramContext == null) || (!paramContext.contains("EGL_EXT_protected_content")));
    if (paramContext.contains("EGL_KHR_surfaceless_context")) {
      return 1;
    }
    return 2;
  }
  
  /* Error */
  public static boolean isSecureSupported(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 112	com/google/android/exoplayer2/video/DummySurface:secureModeInitialized	Z
    //   8: ifne +21 -> 29
    //   11: getstatic 53	com/google/android/exoplayer2/util/Util:SDK_INT	I
    //   14: bipush 24
    //   16: if_icmpge +26 -> 42
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: putstatic 114	com/google/android/exoplayer2/video/DummySurface:secureMode	I
    //   25: iconst_1
    //   26: putstatic 112	com/google/android/exoplayer2/video/DummySurface:secureModeInitialized	Z
    //   29: getstatic 114	com/google/android/exoplayer2/video/DummySurface:secureMode	I
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq +16 -> 50
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: aload_0
    //   43: invokestatic 116	com/google/android/exoplayer2/video/DummySurface:getSecureModeV24	(Landroid/content/Context;)I
    //   46: istore_1
    //   47: goto -26 -> 21
    //   50: iconst_0
    //   51: istore_2
    //   52: goto -15 -> 37
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    //   20	27	1	i	int
    //   1	51	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	19	55	finally
    //   21	29	55	finally
    //   29	33	55	finally
    //   42	47	55	finally
  }
  
  public static DummySurface newInstanceV17(Context paramContext, boolean paramBoolean)
  {
    int i = 0;
    assertApiLevel17OrHigher();
    if ((!paramBoolean) || (isSecureSupported(paramContext))) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkState(bool);
      paramContext = new DummySurface.DummySurfaceThread();
      if (paramBoolean) {
        i = secureMode;
      }
      return paramContext.init(i);
    }
  }
  
  public void release()
  {
    super.release();
    synchronized (this.thread)
    {
      if (!this.threadReleased)
      {
        this.thread.release();
        this.threadReleased = true;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.7.0.1
 */