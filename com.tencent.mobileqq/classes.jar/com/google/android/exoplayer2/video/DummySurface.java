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
    if (Util.SDK_INT >= 17) {
      return;
    }
    throw new UnsupportedOperationException("Unsupported prior to API level 17");
  }
  
  @TargetApi(24)
  private static int getSecureModeV24(Context paramContext)
  {
    if ((Util.SDK_INT < 26) && (("samsung".equals(Util.MANUFACTURER)) || ("XT1650".equals(Util.MODEL)))) {
      return 0;
    }
    if ((Util.SDK_INT < 26) && (!paramContext.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
      return 0;
    }
    paramContext = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
    if (paramContext == null) {
      return 0;
    }
    if (!paramContext.contains("EGL_EXT_protected_content")) {
      return 0;
    }
    if (paramContext.contains("EGL_KHR_surfaceless_context")) {
      return 1;
    }
    return 2;
  }
  
  public static boolean isSecureSupported(Context paramContext)
  {
    try
    {
      boolean bool2 = secureModeInitialized;
      boolean bool1 = true;
      if (!bool2)
      {
        if (Util.SDK_INT < 24) {
          i = 0;
        } else {
          i = getSecureModeV24(paramContext);
        }
        secureMode = i;
        secureModeInitialized = true;
      }
      int i = secureMode;
      if (i == 0) {
        bool1 = false;
      }
      return bool1;
    }
    finally {}
  }
  
  public static DummySurface newInstanceV17(Context paramContext, boolean paramBoolean)
  {
    assertApiLevel17OrHigher();
    int i = 0;
    boolean bool;
    if ((paramBoolean) && (!isSecureSupported(paramContext))) {
      bool = false;
    } else {
      bool = true;
    }
    Assertions.checkState(bool);
    paramContext = new DummySurface.DummySurfaceThread();
    if (paramBoolean) {
      i = secureMode;
    }
    return paramContext.init(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.DummySurface
 * JD-Core Version:    0.7.0.1
 */