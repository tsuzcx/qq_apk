package com.tencent.ark;

import android.graphics.SurfaceTexture;
import android.opengl.GLES10;
import android.opengl.GLUtils;
import android.os.Build;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONArray;
import org.json.JSONObject;

class EGLContextHolder
  extends ark.NativeObject
{
  private static final String EGL_BAD_ALLOC_EXCEPTION = "eglCreateWindowSurface.failed.EGL_BAD_ALLOC";
  public static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
  public static final int EGL_OPENGL_ES2_BIT = 4;
  protected static final ArkEnvironmentManager ENV = ;
  public static final int RETRY_COUNT = 3;
  protected static final String TAG = "ArkApp.EGLContextHolder";
  private static final EGLContextHolder.DeviceMatcher[] sDisableList = { new EGLContextHolder.DeviceMatcher(null, null, ".*MI-ONE.*", null, null), new EGLContextHolder.DeviceMatcher(null, null, ".*MT7-TL00.*", null, null), new EGLContextHolder.DeviceMatcher(null, "JSS15J\\.I9300.*", ".*I9300", null, null), new EGLContextHolder.DeviceMatcher(null, null, ".*IdeaCentre B300.*", null, null), new EGLContextHolder.DeviceMatcher("generic_x86/sdk_phone_x86/generic_x86.*", null, ".*Android SDK built for x86.*", null, null) };
  public static EGL10 sEgl;
  public static EGLConfig[] sEglConfig;
  public static int[] sEglConfigCount;
  public static EGLConfig[] sEglPbufferConfig;
  public static int[] sEglPbufferConfigCount;
  private static EGLContextHolder.DeviceMatcher[] sExternalDisableList;
  private static EGLContextHolder.DeviceMatcher[] sExternalGPURasterDisableList;
  private static EGLContextHolder.DeviceMatcher[] sExternalVirtualContextDisableList;
  private static EGLContextHolder.DeviceMatcher[] sExternalVirtualContextList;
  private static final EGLContextHolder.DeviceMatcher[] sGPURasterDisableList;
  public static boolean sIsGPURasterDisabled = false;
  public static boolean sIsVirtualContext;
  private static final EGLContextHolder.DeviceMatcher[] sVirtvalContextDisableList;
  private static final EGLContextHolder.DeviceMatcher[] sVirtvalContextList = { new EGLContextHolder.DeviceMatcher(null, null, null, "Adreno.*", null), new EGLContextHolder.DeviceMatcher(null, null, null, "Mali.*", null), new EGLContextHolder.DeviceMatcher(null, null, null, "Power.*", null) };
  public EGLContext mContext = EGL10.EGL_NO_CONTEXT;
  public EGLDisplay mDisplay = EGL10.EGL_NO_DISPLAY;
  public EGLSurface mSurface = EGL10.EGL_NO_SURFACE;
  public SurfaceTexture mSurfaceTexture;
  
  static
  {
    sVirtvalContextDisableList = new EGLContextHolder.DeviceMatcher[] { new EGLContextHolder.DeviceMatcher(null, null, null, "Adreno.*(330|405).*", null) };
    sGPURasterDisableList = new EGLContextHolder.DeviceMatcher[0];
    sExternalDisableList = null;
    sExternalVirtualContextList = null;
    sExternalVirtualContextDisableList = null;
    sExternalGPURasterDisableList = null;
    sIsVirtualContext = false;
  }
  
  private native void deleteNativeObject();
  
  private static boolean deviceMatchGL(EGLContextHolder.DeviceMatcher[] paramArrayOfDeviceMatcher, String paramString1, String paramString2)
  {
    if (paramArrayOfDeviceMatcher == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfDeviceMatcher.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfDeviceMatcher[i].matchGL(paramString1, paramString2)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static boolean deviceMatchOS(EGLContextHolder.DeviceMatcher[] paramArrayOfDeviceMatcher)
  {
    if (paramArrayOfDeviceMatcher == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfDeviceMatcher.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfDeviceMatcher[i].matchOS(Build.FINGERPRINT, Build.DISPLAY, Build.MODEL)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static native EGLContextHolder getApplicationContext();
  
  private static String getStringValueOrNull(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.isNull(paramString)) {
      return null;
    }
    return paramJSONObject.optString(paramString, null);
  }
  
  static final boolean isDeviceSupported()
  {
    boolean bool = false;
    logPhoneInformation();
    if ((deviceMatchOS(sDisableList)) || (deviceMatchOS(sExternalDisableList)))
    {
      ENV.logE("ArkApp.EGLContextHolder", String.format("isDeviceSupported.false.model.disabled.model.%s.%s", new Object[] { Build.MODEL, Build.FINGERPRINT }));
      return false;
    }
    EGLContextHolder localEGLContextHolder = new EGLContextHolder();
    if (!localEGLContextHolder.createImpl(EGL10.EGL_NO_CONTEXT, null)) {
      ENV.logE("ArkApp.EGLContextHolder", String.format("isDeviceSupported.false.create.context.fail.model.%s.%s", new Object[] { Build.MODEL, Build.FINGERPRINT }));
    }
    String str1;
    String str2;
    for (;;)
    {
      localEGLContextHolder.releaseImpl();
      return bool;
      try
      {
        if (!isSkiaSupported()) {
          ENV.logE("ArkApp.EGLContextHolder", String.format("isDeviceSupported.false.skia not supported", new Object[0]));
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        ENV.logE("ArkApp.EGLContextHolder", "isDeviceSupported.fail.UnsatisfiedLinkError");
        str1 = GLES10.glGetString(7937);
        str2 = GLES10.glGetString(7938);
        if ((deviceMatchGL(sDisableList, str1, str2)) || (deviceMatchGL(sExternalDisableList, str1, str2))) {
          ENV.logE("ArkApp.EGLContextHolder", String.format("isDeviceSupported.false.model.disabled.model.%s.%s.%s.%s", new Object[] { Build.MODEL, Build.FINGERPRINT, str1, str2 }));
        } else {
          if (deviceMatchGL(sVirtvalContextDisableList, str1, str2)) {
            break label249;
          }
        }
      }
    }
    if (deviceMatchGL(sExternalVirtualContextDisableList, str1, str2)) {
      label249:
      ENV.logI("ArkApp.EGLContextHolder", String.format("isDeviceSupported.disable.virtual.context.render.%s.version.%s.end", new Object[] { str1, str2 }));
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && ((deviceMatchGL(sVirtvalContextList, str1, str2)) || (deviceMatchGL(sExternalVirtualContextList, str1, str2))))
      {
        sIsVirtualContext = true;
        ENV.logI("ArkApp.EGLContextHolder", String.format("isDeviceSupported.use.virtual.context.render.%s.version.%s", new Object[] { str1, str2 }));
      }
      if ((deviceMatchGL(sGPURasterDisableList, str1, str2)) || (deviceMatchGL(sExternalGPURasterDisableList, str1, str2)))
      {
        sIsGPURasterDisabled = true;
        ENV.logI("ArkApp.EGLContextHolder", String.format("isDeviceSupported.disable.gpu.raster.render.%s.version.%s", new Object[] { str1, str2 }));
      }
      if (ENV.mIsDebug) {
        ENV.logI("ArkApp.EGLContextHolder", String.format("gl.render.%s.version.%s.end", new Object[] { str1, str2 }));
      }
      bool = true;
      break;
    }
  }
  
  public static native boolean isSkiaSupported();
  
  private static final void logPhoneInformation()
  {
    ENV.logI("ArkApp.EGLContextHolder", "phone.info.start");
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.BOARD.%s", new Object[] { Build.BOARD }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.BRAND.%s", new Object[] { Build.BRAND }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.DEVICE.%s", new Object[] { Build.DEVICE }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.FINGERPRINT.%s", new Object[] { Build.FINGERPRINT }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.MANUFACTURER.%s", new Object[] { Build.MANUFACTURER }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.MODEL.%s", new Object[] { Build.MODEL }));
    ENV.logI("ArkApp.EGLContextHolder", String.format("Build.PRODUCT.%s", new Object[] { Build.PRODUCT }));
    ENV.logI("ArkApp.EGLContextHolder", "phone.info.end");
  }
  
  private native void nativeResetContext();
  
  private native boolean nativeSizeChanged(int paramInt1, int paramInt2);
  
  private native boolean newNativeObject(int paramInt1, int paramInt2, boolean paramBoolean);
  
  private static EGLContextHolder.DeviceMatcher parseDeviceMatcher(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    String str1;
    String str2;
    String str3;
    String str4;
    do
    {
      return null;
      str1 = getStringValueOrNull(paramJSONObject, "fingerprint");
      str2 = getStringValueOrNull(paramJSONObject, "rom");
      str3 = getStringValueOrNull(paramJSONObject, "model");
      str4 = getStringValueOrNull(paramJSONObject, "renderer");
      paramJSONObject = getStringValueOrNull(paramJSONObject, "version");
    } while ((str1 == null) && (str2 == null) && (str3 == null) && (str4 == null) && (paramJSONObject == null));
    return new EGLContextHolder.DeviceMatcher(str1, str2, str3, str4, paramJSONObject);
  }
  
  private static EGLContextHolder.DeviceMatcher[] parseDeviceMatcherArray(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      EGLContextHolder.DeviceMatcher localDeviceMatcher = parseDeviceMatcher(paramJSONArray.optJSONObject(i));
      if (localDeviceMatcher != null) {
        localArrayList.add(localDeviceMatcher);
      }
      i += 1;
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramJSONArray = new EGLContextHolder.DeviceMatcher[localArrayList.size()];
    localArrayList.toArray(paramJSONArray);
    return paramJSONArray;
  }
  
  public static native void setApplicationContext(EGLContextHolder paramEGLContextHolder);
  
  public static void setDeviceMatcher(JSONObject paramJSONObject)
  {
    sExternalDisableList = null;
    sExternalVirtualContextList = null;
    sExternalVirtualContextDisableList = null;
    if (paramJSONObject == null) {
      return;
    }
    sExternalDisableList = parseDeviceMatcherArray(paramJSONObject.optJSONArray("disableList"));
    sExternalVirtualContextList = parseDeviceMatcherArray(paramJSONObject.optJSONArray("virtualContextEnableList"));
    sExternalVirtualContextDisableList = parseDeviceMatcherArray(paramJSONObject.optJSONArray("virtualContextDisableList"));
    sExternalGPURasterDisableList = parseDeviceMatcherArray(paramJSONObject.optJSONArray("gpuRasterDisableList"));
  }
  
  public static native void setOffscreenContext(EGLContextHolder paramEGLContextHolder);
  
  public static void setVirtualContext(boolean paramBoolean)
  {
    sIsVirtualContext = paramBoolean;
  }
  
  public boolean create(EGLContext paramEGLContext, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (!createImpl(paramEGLContext, paramSurfaceTexture)) {
      return false;
    }
    if (paramSurfaceTexture != null) {
      if (paramSurfaceTexture == null) {
        break label43;
      }
    }
    for (;;)
    {
      if (newNativeObject(paramInt1, paramInt2, sIsVirtualContext)) {
        break label49;
      }
      release();
      return false;
      paramInt1 = 1;
      break;
      label43:
      paramInt2 = 1;
    }
    label49:
    detachCurrent();
    return true;
  }
  
  protected boolean createImpl(EGLContext paramEGLContext, SurfaceTexture paramSurfaceTexture)
  {
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
    this.mSurfaceTexture = paramSurfaceTexture;
    EGL10 localEGL10 = sEgl;
    if (paramSurfaceTexture == null) {}
    int i;
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
      ENV.logI("ArkApp.EGLContextHolder", paramEGLContext.getMessage());
      ENV.logI("ArkApp.EGLContextHolder", "egl.start");
      paramSurfaceTexture = localEGL10.eglQueryString(this.mDisplay, 12371);
      ENV.logI("ArkApp.EGLContextHolder", String.format("egl.vendor.%s", new Object[] { paramSurfaceTexture }));
      paramSurfaceTexture = localEGL10.eglQueryString(this.mDisplay, 12372);
      ENV.logI("ArkApp.EGLContextHolder", String.format("egl.version.%s", new Object[] { paramSurfaceTexture }));
      paramSurfaceTexture = localEGL10.eglQueryString(this.mDisplay, 12373);
      ENV.logI("ArkApp.EGLContextHolder", String.format("egl.extension.%s", new Object[] { paramSurfaceTexture }));
      ENV.logI("ArkApp.EGLContextHolder", "egl.end");
      if ((i != 0) && (!"eglCreateWindowSurface.failed.EGL_BAD_ALLOC".equals(paramEGLContext.getMessage())))
      {
        paramEGLContext = GLES10.glGetString(7937);
        if (paramEGLContext != null)
        {
          ENV.logI("ArkApp.EGLContextHolder", "gl.start");
          ENV.logI("ArkApp.EGLContextHolder", String.format("gl.renderer.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7936);
          ENV.logI("ArkApp.EGLContextHolder", String.format("gl.vendor.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7938);
          ENV.logI("ArkApp.EGLContextHolder", String.format("gl.version.%s", new Object[] { paramEGLContext }));
          paramEGLContext = GLES10.glGetString(7939);
          ENV.logI("ArkApp.EGLContextHolder", String.format("gl.extension.%s", new Object[] { paramEGLContext }));
          ENV.logI("ArkApp.EGLContextHolder", "gl.end");
        }
      }
      release();
      return false;
    }
    Object localObject1;
    label535:
    label666:
    label674:
    label743:
    int j;
    if (!localEGL10.eglInitialize(this.mDisplay, new int[] { 1, 0 }))
    {
      throw new Exception(String.format("eglInitialize.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
      int[] arrayOfInt;
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 != null) {
          break label743;
        }
        arrayOfInt = new int[1];
        localObject1 = new EGLConfig[1];
        if (k == 0) {
          break label1249;
        }
        i = 1;
        if (localEGL10.eglChooseConfig(this.mDisplay, new int[] { 12352, 4, 12339, i, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12344 }, (EGLConfig[])localObject1, 1, arrayOfInt)) {
          break;
        }
        throw new Exception(String.format("eglChooseConfig.failed.%s", new Object[] { GLUtils.getEGLErrorString(localEGL10.eglGetError()) }));
        localObject1 = sEglConfigCount;
        break label1238;
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
      label794:
      int m;
      if ((sIsVirtualContext) && (paramEGLContext != null) && (!paramEGLContext.equals(EGL10.EGL_NO_CONTEXT)))
      {
        this.mContext = paramEGLContext;
        ENV.logI("ArkApp.EGLContextHolder", String.format("create virtual context, this=%h, context=%h", new Object[] { this, paramEGLContext }));
        j = 12288;
        m = 0;
      }
      for (;;)
      {
        i = j;
        if ((m >= 3) || (k == 0)) {}
        label1076:
        do
        {
          for (;;)
          {
            try
            {
              this.mSurface = localEGL10.eglCreateWindowSurface(this.mDisplay, localObject2[0], paramSurfaceTexture, null);
              if (this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                break label1076;
              }
              i = j;
              if (!this.mSurface.equals(EGL10.EGL_NO_SURFACE)) {
                break label1254;
              }
              throw new Exception(String.format("eglCreateWindowSurface.failed.%s", new Object[] { GLUtils.getEGLErrorString(i) }));
            }
            catch (Exception paramEGLContext)
            {
              i = 1;
            }
            break;
            this.mContext = localEGL10.eglCreateContext(this.mDisplay, localObject2[0], paramEGLContext, new int[] { 12440, 2, 12344 });
            ENV.logI("ArkApp.EGLContextHolder", String.format("create share context, this=%h, context=%h, share=%h", new Object[] { this, this.mContext, paramEGLContext }));
            if (!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) {
              break label794;
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
          break label1179;
        }
      }
      for (;;)
      {
        if (j != 12288)
        {
          throw new Exception(String.format("eglMakeCurrent.failed.%s", new Object[] { GLUtils.getEGLErrorString(j) }));
          label1179:
          i = localEGL10.eglGetError();
          j = i;
          if (i == 12291)
          {
            k += 1;
            break;
          }
        }
      }
      ENV.logI("ArkApp.EGLContextHolder", String.format("egl.context.create.%h", new Object[] { this.mContext }));
      return true;
      if (k == 0) {
        break label666;
      }
      label1238:
      if (k == 0) {
        break label674;
      }
      localObject1 = null;
      break;
      label1249:
      i = 4;
      break label535;
      label1254:
      k = 0;
    }
  }
  
  public boolean detachCurrent()
  {
    ENV.logI("ArkApp.EGLContextHolder", "context.detachCurrent");
    if ((sEgl == null) || (this.mContext.equals(EGL10.EGL_NO_CONTEXT)) || (this.mDisplay.equals(EGL10.EGL_NO_DISPLAY)))
    {
      ENV.logD("ArkApp.EGLContextHolder", "egl.not.initialize");
      return false;
    }
    if (!sEgl.eglMakeCurrent(this.mDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT))
    {
      ENV.logE("ArkApp.EGLContextHolder", "context detach current thread fail");
      return false;
    }
    return true;
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
          ENV.logI("ArkApp.EGLContextHolder", String.format("eglMakeCurrent.failed.%s", new Object[] { GLUtils.getEGLErrorString(i) }));
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
    ENV.logI("ArkApp.EGLContextHolder", String.format("context.release.this.%h.context=%h", new Object[] { this, this.mContext }));
    if (this.mNative != 0L) {
      deleteNativeObject();
    }
    releaseImpl();
  }
  
  protected void releaseImpl()
  {
    EGL10 localEGL10 = sEgl;
    if (this.mSurfaceTexture == null) {}
    for (boolean bool = true;; bool = false)
    {
      ENV.logI("ArkApp.EGLContextHolder", String.format("egl.context.destroy.this.%h.context.%h.surfaceTexture.%h.virtual.%s.offscreen.%s", new Object[] { this, this.mContext, this.mSurfaceTexture, Boolean.toString(sIsVirtualContext), Boolean.toString(bool) }));
      this.mSurfaceTexture = null;
      if (localEGL10 != null)
      {
        if (this.mContext.equals(localEGL10.eglGetCurrentContext())) {
          localEGL10.eglMakeCurrent(this.mDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        }
        if ((!this.mContext.equals(EGL10.EGL_NO_CONTEXT)) && ((!sIsVirtualContext) || (bool))) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.EGLContextHolder
 * JD-Core Version:    0.7.0.1
 */