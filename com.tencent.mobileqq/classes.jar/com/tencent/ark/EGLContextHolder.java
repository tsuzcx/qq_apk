package com.tencent.ark;

import android.graphics.SurfaceTexture;
import android.opengl.GLES10;
import android.opengl.GLUtils;
import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class EGLContextHolder
  extends ark.NativeObject
{
  public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  public static final int EGL_OPENGL_ES2_BIT = 4;
  protected static final ArkEnvironmentManager ENV = ;
  public static final int RETRY_COUNT = 3;
  protected static final String TAG = "ArkApp.EGLContextHolder";
  public static final DeviceMatcher[] sDisableList = { new DeviceMatcher(null, "JSS15J\\.I9300.*", ".*I9300", null, null), new DeviceMatcher(null, null, ".*IdeaCentre B300.*", null, null), new DeviceMatcher("generic_x86/sdk_phone_x86/generic_x86.*", null, ".*Android SDK built for x86.*", null, null) };
  public static EGL10 sEgl;
  public static EGLConfig[] sEglConfig;
  public static int[] sEglConfigCount;
  public static EGLConfig[] sEglPbufferConfig;
  public static int[] sEglPbufferConfigCount;
  public static boolean sIsVirtualContext = false;
  public static final DeviceMatcher[] sVirtvalContextList = { new DeviceMatcher(null, null, null, "Adreno.*", null), new DeviceMatcher(null, null, null, "Mali.*", null), new DeviceMatcher(null, null, null, "Power.*", null) };
  public EGLContext mContext = EGL10.EGL_NO_CONTEXT;
  public EGLDisplay mDisplay = EGL10.EGL_NO_DISPLAY;
  public EGLSurface mSurface = EGL10.EGL_NO_SURFACE;
  public SurfaceTexture mSurfaceTexture;
  
  private native void deleteNativeObject();
  
  static final boolean isDeviceSupported()
  {
    boolean bool = false;
    Object localObject = sDisableList;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].matchOS(Build.FINGERPRINT, Build.DISPLAY, Build.MODEL))
      {
        ENV.logI("ArkApp.EGLContextHolder", String.format("disable.gl.model.%s.%s.end", new Object[] { Build.MODEL, Build.FINGERPRINT }));
        return false;
      }
      i += 1;
    }
    localObject = new EGLContextHolder();
    if (!((EGLContextHolder)localObject).createImpl(EGL10.EGL_NO_CONTEXT, null))
    {
      ENV.logD("ArkApp.EGLContextHolder", String.format("EGLContextHolder.create.fail.model.%s.%s.end", new Object[] { Build.MODEL, Build.FINGERPRINT }));
      ((EGLContextHolder)localObject).releaseImpl();
      return bool;
    }
    String str1 = GLES10.glGetString(7937);
    String str2 = GLES10.glGetString(7938);
    DeviceMatcher[] arrayOfDeviceMatcher = sDisableList;
    j = arrayOfDeviceMatcher.length;
    i = 0;
    for (;;)
    {
      if (i >= j) {
        break label209;
      }
      if (arrayOfDeviceMatcher[i].matchGL(str1, str2))
      {
        ENV.logI("ArkApp.EGLContextHolder", String.format("disable.gl.render.%s.version.%s.end", new Object[] { str1, str2 }));
        break;
      }
      i += 1;
    }
    label209:
    arrayOfDeviceMatcher = sVirtvalContextList;
    j = arrayOfDeviceMatcher.length;
    i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (arrayOfDeviceMatcher[i].matchGL(str1, str2))
        {
          sIsVirtualContext = true;
          ENV.logI("ArkApp.EGLContextHolder", String.format("shared.context.gl.render.%s.version.%s.end", new Object[] { str1, str2 }));
        }
      }
      else
      {
        if (ENV.mIsDebug) {
          ENV.logI("ArkApp.EGLContextHolder", String.format("gl.render.%s.version.%s.end", new Object[] { str1, str2 }));
        }
        bool = true;
        break;
      }
      i += 1;
    }
  }
  
  private native void nativeResetContext();
  
  private native boolean nativeSizeChanged(int paramInt1, int paramInt2);
  
  private native boolean newNativeObject(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static final native void setOffscreenContext(EGLContextHolder paramEGLContextHolder);
  
  public boolean create(EGLContext paramEGLContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!createImpl(paramEGLContext, paramSurfaceTexture)) {
      bool = false;
    }
    label50:
    label56:
    do
    {
      return bool;
      if (paramSurfaceTexture != null) {
        if (paramSurfaceTexture == null) {
          break label50;
        }
      }
      for (;;)
      {
        if (newNativeObject(paramInt1, paramInt2, sIsVirtualContext)) {
          break label56;
        }
        release();
        return false;
        paramInt1 = 1;
        break;
        paramInt2 = 1;
      }
    } while (paramSurfaceTexture != null);
    setOffscreenContext(this);
    return true;
  }
  
  protected boolean createImpl(EGLContext paramEGLContext, SurfaceTexture paramSurfaceTexture)
  {
    int i = 4;
    if (!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) {
      return true;
    }
    if (sEgl == null)
    {
      if (!(EGLContext.getEGL() instanceof EGL10))
      {
        ENV.logD("ArkApp.EGLContextHolder", "getEGL.return.null");
        return false;
      }
      sEgl = (EGL10)EGLContext.getEGL();
    }
    EGL10 localEGL10 = sEgl;
    if (paramSurfaceTexture == null) {}
    for (int k = 1;; k = 0)
    {
      try
      {
        this.mDisplay = localEGL10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if ((this.mDisplay != null) && (!this.mDisplay.equals(EGL10.EGL_NO_DISPLAY))) {
          break;
        }
        throw new Exception(String.format("eglGetDisplay.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
      }
      catch (Exception paramEGLContext)
      {
        i = 0;
      }
      ENV.logD("ArkApp.EGLContextHolder", paramEGLContext.getMessage());
      ENV.logD("ArkApp.EGLContextHolder", "egl.start");
      paramEGLContext = localEGL10.eglQueryString(this.mDisplay, 12371);
      ENV.logD("ArkApp.EGLContextHolder", String.format("egl.vendor.%s", new Object[] { paramEGLContext }));
      paramEGLContext = localEGL10.eglQueryString(this.mDisplay, 12372);
      ENV.logD("ArkApp.EGLContextHolder", String.format("egl.version.%s", new Object[] { paramEGLContext }));
      paramEGLContext = localEGL10.eglQueryString(this.mDisplay, 12373);
      ENV.logD("ArkApp.EGLContextHolder", String.format("egl.extension.%s", new Object[] { paramEGLContext }));
      ENV.logD("ArkApp.EGLContextHolder", "egl.end");
      if (i != 0)
      {
        paramEGLContext = GLES10.glGetString(7937);
        if (paramEGLContext != null)
        {
          ENV.logD("ArkApp.EGLContextHolder", "gl.start");
          ENV.logD("ArkApp.EGLContextHolder", String.format("gl.renderer.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7936);
          ENV.logD("ArkApp.EGLContextHolder", String.format("gl.vendor.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7938);
          ENV.logD("ArkApp.EGLContextHolder", String.format("gl.version.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7939);
          ENV.logD("ArkApp.EGLContextHolder", String.format("gl.extension.%s", new Object[] { paramEGLContext }));
          ENV.logD("ArkApp.EGLContextHolder", "gl.end");
        }
      }
      ENV.logD("ArkApp.EGLContextHolder", "phone.info.start");
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.BOARD.%s", new Object[] { Build.BOARD }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.BRAND.%s", new Object[] { Build.BRAND }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.DEVICE.%s", new Object[] { Build.DEVICE }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.FINGERPRINT.%s", new Object[] { Build.FINGERPRINT }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.MANUFACTURER.%s", new Object[] { Build.MANUFACTURER }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.MODEL.%s", new Object[] { Build.MODEL }));
      ENV.logD("ArkApp.EGLContextHolder", String.format("Build.PRODUCT.%s", new Object[] { Build.PRODUCT }));
      ENV.logD("ArkApp.EGLContextHolder", "phone.info.end");
      release();
      return false;
    }
    Object localObject1;
    label825:
    label833:
    int j;
    if (!localEGL10.eglInitialize(this.mDisplay, new int[] { 1, 0 }))
    {
      throw new Exception(String.format("eglInitialize.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
      int[] arrayOfInt;
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label902;
        }
        arrayOfInt = new int[1];
        localObject1 = new EGLConfig[1];
        if (k != 0) {
          i = 1;
        }
        if (localEGL10.eglChooseConfig(this.mDisplay, new int[] { 12352, 4, 12339, i, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12344 }, (EGLConfig[])localObject1, 1, arrayOfInt)) {
          break;
        }
        throw new Exception(String.format("eglChooseConfig.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
        localObject1 = sEglConfigCount;
        break label1343;
        localObject1 = sEglConfig;
      }
      if (localObject1[0] == null) {
        throw new Exception(String.format("eglChooseConfig.succ.but.eglConfigs[0].null.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
      }
      Object localObject2 = localObject1;
      if (k == 0)
      {
        sEglConfigCount = arrayOfInt;
        sEglConfig = (EGLConfig[])localObject1;
        localObject2 = localObject1;
      }
      label902:
      label927:
      int m;
      if ((sIsVirtualContext) && (paramEGLContext != null) && (!paramEGLContext.equals(EGL10.EGL_NO_CONTEXT)))
      {
        this.mContext = paramEGLContext;
        j = 12288;
        m = 0;
      }
      for (;;)
      {
        i = j;
        if ((m >= 3) || (k == 0)) {}
        label1176:
        do
        {
          for (;;)
          {
            try
            {
              this.mSurface = localEGL10.eglCreateWindowSurface(this.mDisplay, localObject2[0], paramSurfaceTexture, null);
              if (this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                break label1176;
              }
              i = j;
              if (!this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                break label1354;
              }
              throw new Exception(String.format("eglCreateWindowSurface.failed.%s", new Object[] { GLUtils.getEGLErrorString(i) }));
            }
            catch (Exception paramEGLContext)
            {
              i = 1;
            }
            break;
            this.mContext = localEGL10.eglCreateContext(this.mDisplay, localObject2[0], paramEGLContext, new int[] { 12440, 2, 12344 });
            if (!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) {
              break label927;
            }
            throw new Exception(String.format("eglCreateContext.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
            this.mSurface = localEGL10.eglCreatePbufferSurface(this.mDisplay, localObject2[0], new int[] { 12375, 1, 12374, 1, 12376, 1, 12344 });
          }
          j = localEGL10.eglGetError();
          i = j;
        } while (j != 12291);
        m += 1;
      }
    }
    for (;;)
    {
      j = i;
      if (k < 3)
      {
        j = 12288;
        if (!localEGL10.eglMakeCurrent(this.mDisplay, this.mSurface, this.mSurface, this.mContext)) {
          break label1279;
        }
      }
      for (;;)
      {
        if (j != 12288)
        {
          throw new Exception(String.format("eglMakeCurrent.failed.%s", new Object[] { GLUtils.getEGLErrorString(j) }));
          label1279:
          i = localEGL10.eglGetError();
          j = i;
          if (i == 12291)
          {
            k += 1;
            break;
          }
        }
      }
      this.mSurfaceTexture = paramSurfaceTexture;
      ENV.logD("ArkApp.EGLContextHolder", String.format("egl.context.create.%h", new Object[] { this.mContext }));
      return true;
      if (k == 0) {
        break label825;
      }
      label1343:
      if (k == 0) {
        break label833;
      }
      localObject1 = null;
      break;
      label1354:
      k = 0;
    }
  }
  
  public boolean makeCurrent()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((sEgl == null) || (this.mContext.equals(EGL10.EGL_NO_CONTEXT)) || (this.mSurface.equals(EGL10.EGL_NO_SURFACE)) || (this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)))
    {
      ENV.logD("ArkApp.EGLContextHolder", "egl.not.initialize");
      bool1 = false;
    }
    label184:
    do
    {
      do
      {
        return bool1;
        if (!this.mContext.equals(sEgl.eglGetCurrentContext())) {
          break;
        }
        bool1 = bool2;
      } while (this.mSurface.equals(sEgl.eglGetCurrentSurface(12377)));
      int j = 0;
      int k;
      for (int i = 12288;; i = k)
      {
        if (j < 3)
        {
          if (!sEgl.eglMakeCurrent(this.mDisplay, this.mSurface, this.mSurface, this.mContext)) {
            break label184;
          }
          i = 12288;
        }
        do
        {
          if (i == 12288) {
            break;
          }
          ENV.logD("ArkApp.EGLContextHolder", String.format("eglMakeCurrent.failed.%s", new Object[] { GLUtils.getEGLErrorString(i) }));
          return false;
          k = sEgl.eglGetError();
          i = k;
        } while (k != 12291);
        j += 1;
      }
      if (sIsVirtualContext) {
        nativeResetContext();
      }
      if (!this.mContext.equals(sEgl.eglGetCurrentContext())) {
        ENV.logE("ArkApp.EGLContextHolder", String.format("eglMakeCurrent.wtf.succ.but.not.current.%h.mContext.%h!!!", new Object[] { sEgl.eglGetCurrentContext(), this.mContext }));
      }
      bool1 = bool2;
    } while (!ENV.mIsDebug);
    ENV.logD("ArkApp.EGLContextHolder", String.format("eglMakeCurrent.succ.%h", new Object[] { this.mContext }));
    return true;
  }
  
  public void release()
  {
    if (this.mNative != 0L)
    {
      deleteNativeObject();
      if (this.mSurfaceTexture == null) {
        setOffscreenContext(null);
      }
    }
    releaseImpl();
  }
  
  protected void releaseImpl()
  {
    int i = 1;
    EGL10 localEGL10 = sEgl;
    ENV.logD("ArkApp.EGLContextHolder", String.format("egl.context.destroy.%h", new Object[] { this.mContext }));
    if (this.mSurfaceTexture == null) {}
    for (;;)
    {
      this.mSurfaceTexture = null;
      if (localEGL10 != null)
      {
        if (this.mContext.equals(localEGL10.eglGetCurrentContext())) {
          localEGL10.eglMakeCurrent(EGL10.EGL_NO_DISPLAY, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }
        if ((!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) && ((!sIsVirtualContext) || (i != 0))) {
          localEGL10.eglDestroyContext(this.mDisplay, this.mContext);
        }
        if (!this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
          localEGL10.eglDestroySurface(this.mDisplay, this.mSurface);
        }
        if (!this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)) {
          localEGL10.eglTerminate(this.mDisplay);
        }
      }
      this.mContext = EGL10.EGL_NO_CONTEXT;
      this.mSurface = EGL10.EGL_NO_SURFACE;
      this.mDisplay = EGL10.EGL_NO_DISPLAY;
      return;
      i = 0;
    }
  }
  
  public boolean sizeChanged(int paramInt1, int paramInt2)
  {
    return (makeCurrent()) && (swapBuffer()) && (nativeSizeChanged(paramInt1, paramInt2));
  }
  
  public boolean swapBuffer()
  {
    if ((sEgl == null) || (this.mContext.equals(EGL10.EGL_NO_CONTEXT)) || (this.mSurface.equals(EGL10.EGL_NO_SURFACE)) || (this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)))
    {
      ENV.logD("ArkApp.EGLContextHolder", "egl.not.initialize");
      return false;
    }
    return sEgl.eglSwapBuffers(this.mDisplay, this.mSurface);
  }
  
  private static class DeviceMatcher
  {
    private Pattern mFingerprint;
    private Pattern mModel;
    private Pattern mRenderer;
    private Pattern mRom;
    private Pattern mVersion;
    
    public DeviceMatcher(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      if (paramString1 != null) {
        this.mFingerprint = Pattern.compile(paramString1);
      }
      if (paramString2 != null) {
        this.mRom = Pattern.compile(paramString2);
      }
      if (paramString3 != null) {
        this.mModel = Pattern.compile(paramString3);
      }
      if (paramString4 != null) {
        this.mRenderer = Pattern.compile(paramString4);
      }
      if (paramString5 != null) {
        this.mVersion = Pattern.compile(paramString5);
      }
    }
    
    private static boolean matchImpl(Pattern paramPattern, String paramString)
    {
      if ((paramPattern != null) && (paramString != null))
      {
        paramPattern = paramPattern.matcher(paramString);
        if ((paramPattern == null) || (!paramPattern.matches())) {
          return false;
        }
      }
      return true;
    }
    
    public boolean matchGL(String paramString1, String paramString2)
    {
      if ((this.mRenderer == null) && (this.mVersion == null)) {}
      while ((!matchImpl(this.mRenderer, paramString1)) || (!matchImpl(this.mVersion, paramString2))) {
        return false;
      }
      return true;
    }
    
    public boolean matchOS(String paramString1, String paramString2, String paramString3)
    {
      if ((this.mFingerprint == null) && (this.mRom == null) && (this.mModel == null)) {}
      while ((!matchImpl(this.mFingerprint, paramString1)) || (!matchImpl(this.mRom, paramString2)) || (!matchImpl(this.mModel, paramString3))) {
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.EGLContextHolder
 * JD-Core Version:    0.7.0.1
 */