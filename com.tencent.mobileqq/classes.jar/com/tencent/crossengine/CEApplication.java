package com.tencent.crossengine;

import android.content.Context;
import androidx.annotation.Keep;
import com.tencent.crossengine.debugJs.InspectorBridge;
import com.tencent.crossengine.debugJs.WebSocketServerInspectAgent;
import com.tencent.crossengine.font.FontPixelsFactory;
import com.tencent.crossengine.font.SpineTextPainter;
import com.tencent.crossengine.log.LogDelegate;
import com.tencent.crossengine.log.Logger;
import com.tencent.crossengine.offscreen.OffscreenWorldCallback;
import com.tencent.crossengine.util.DisplayInfo;
import org.json.JSONObject;

@Keep
public class CEApplication
{
  private static final String NATIVE_LOG_TAG = "CrossEngine";
  private static final String TAG = "CEApplication";
  public static final int WORLD_TIME_SCALE_FIXED_DELTA_TIME = 1000;
  public static final int WORLD_TIME_SCALE_HALF = 2;
  public static final int WORLD_TIME_SCALE_OFF = 1;
  public static final int WORLD_TIME_SCALE_ONETHIRD = 3;
  public static final int WORLD_TIME_SCALE_QUATER = 4;
  private String mAssetsPath;
  private CEJSEventListener mCEJSEventListener;
  private CELifeCycle mCELifeCycle;
  private CERenderView mCERenderView;
  private Context mContext;
  private int mDefaultFPS;
  private DisplayInfo mDisplayInfo;
  private boolean mEnableDebugJS = false;
  private boolean mEnableGPUSkinning = false;
  private FrameCallback mFrameCallback;
  private GameMainThread mGameMainThread;
  private long mNativeHandle;
  private OffscreenWorldCallback mOffscreenWorldCallback;
  private boolean mOptimizeSpineUpdate = false;
  private RenderContext mRenderContext;
  private String mStartUpWorld;
  private TouchProcessor mTouchProcessor;
  
  public CEApplication(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mGameMainThread = new GameMainThread(this);
    this.mDisplayInfo = new DisplayInfo(paramContext, paramBoolean);
    this.mRenderContext = new RenderContext(this.mDisplayInfo);
    this.mTouchProcessor = new TouchProcessor(this);
  }
  
  private native long nCreateNativeCEApp(long paramLong, String paramString1, String paramString2, InspectorBridge paramInspectorBridge, int paramInt, boolean paramBoolean);
  
  private native void nCreateOffScreenWorld(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, InspectorBridge paramInspectorBridge);
  
  private native void nDestroyWorld(long paramLong, String paramString);
  
  private native void nDispatchTouchEvent(long paramLong, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2);
  
  private native void nEvaluateJs(long paramLong, String paramString);
  
  private native void nEvaluateJsSync(long paramLong, String paramString);
  
  private native void nEvaluateWorldJs(long paramLong, String paramString1, String paramString2);
  
  private native void nExit(long paramLong);
  
  private native void nGameLoop(long paramLong);
  
  private native void nResizeOffscreenWorld(long paramLong, String paramString, int paramInt1, int paramInt2);
  
  private native void nRunScriptFile(long paramLong, String paramString);
  
  private native void nRunWorldScriptFile(long paramLong, String paramString1, String paramString2);
  
  private native void nSetOptimizeSpineUpdate(long paramLong, boolean paramBoolean);
  
  private native void nSetTimeScaleForWorld(long paramLong, String paramString, int paramInt, float paramFloat);
  
  private void onFirstFrame()
  {
    CELifeCycle localCELifeCycle = this.mCELifeCycle;
    if (localCELifeCycle != null) {
      localCELifeCycle.onFirstFrame();
    }
  }
  
  private void onFrameCallback(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    FrameCallback localFrameCallback = this.mFrameCallback;
    if (localFrameCallback != null) {
      localFrameCallback.onFrameCallback(paramString, paramArrayOfByte, paramInt1, paramInt2, paramInt3);
    }
  }
  
  private void onGameEnd()
  {
    CELifeCycle localCELifeCycle = this.mCELifeCycle;
    if (localCELifeCycle != null) {
      localCELifeCycle.onGameEnd();
    }
  }
  
  private void onInit()
  {
    CELifeCycle localCELifeCycle = this.mCELifeCycle;
    if (localCELifeCycle != null) {
      localCELifeCycle.onInit();
    }
  }
  
  private void onOffscreenSurfaceReady(String paramString)
  {
    OffscreenWorldCallback localOffscreenWorldCallback = this.mOffscreenWorldCallback;
    if (localOffscreenWorldCallback != null) {
      localOffscreenWorldCallback.b(paramString);
    }
  }
  
  private void onOffscreenWorldCreated(String paramString)
  {
    OffscreenWorldCallback localOffscreenWorldCallback = this.mOffscreenWorldCallback;
    if (localOffscreenWorldCallback != null) {
      localOffscreenWorldCallback.a(paramString);
    }
  }
  
  private void printNativeLog(int paramInt, String paramString)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 4) && (paramInt != 5)) {
            return;
          }
          Logger.d("CrossEngine", paramString);
          return;
        }
        Logger.c("CrossEngine", paramString);
        return;
      }
      Logger.b("CrossEngine", paramString);
      return;
    }
    Logger.a("CrossEngine", paramString);
  }
  
  public void createOffScreenWorld(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    InspectorBridge localInspectorBridge;
    if (this.mEnableDebugJS)
    {
      localInspectorBridge = new InspectorBridge();
      localInspectorBridge.setProxy(new WebSocketServerInspectAgent(paramString1));
    }
    else
    {
      localInspectorBridge = null;
    }
    nCreateOffScreenWorld(this.mNativeHandle, paramString1, paramString2, paramInt1, paramInt2, paramBoolean, localInspectorBridge);
  }
  
  public CERenderView createRenderView(Context paramContext)
  {
    if (this.mCERenderView == null) {
      this.mCERenderView = new CERenderView(paramContext, this.mRenderContext, this.mTouchProcessor);
    }
    return this.mCERenderView;
  }
  
  public void destoryWorld(String paramString)
  {
    nDestroyWorld(this.mNativeHandle, paramString);
  }
  
  public void destroy()
  {
    this.mRenderContext.destroy();
  }
  
  public void dispatchTouchEvent(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    nDispatchTouchEvent(this.mNativeHandle, paramInt1, paramInt2, paramFloat1, paramFloat2);
  }
  
  public void evaluateJs(String paramString)
  {
    nEvaluateJs(this.mNativeHandle, paramString);
  }
  
  public void evaluateJsSync(String paramString)
  {
    nEvaluateJsSync(this.mNativeHandle, paramString);
  }
  
  public void evaluateWorldJs(String paramString1, String paramString2)
  {
    nEvaluateWorldJs(this.mNativeHandle, paramString1, paramString2);
  }
  
  public void exit()
  {
    nExit(this.mNativeHandle);
  }
  
  public void gameLoop()
  {
    nGameLoop(this.mNativeHandle);
  }
  
  public int getHeight()
  {
    return this.mRenderContext.getHeight();
  }
  
  public long getNativeHandle()
  {
    return this.mNativeHandle;
  }
  
  public RenderContext getRenderContext()
  {
    return this.mRenderContext;
  }
  
  public float getScale()
  {
    return this.mDisplayInfo.a();
  }
  
  public TouchProcessor getTouchProcessor()
  {
    return this.mTouchProcessor;
  }
  
  public int getWidth()
  {
    return this.mRenderContext.getWidth();
  }
  
  public String onScriptEvent(String paramString1, String paramString2)
  {
    CEJSEventListener localCEJSEventListener = this.mCEJSEventListener;
    if (localCEJSEventListener != null) {
      return localCEJSEventListener.onScriptEvent(paramString1, paramString2);
    }
    return new JSONObject().toString();
  }
  
  public void pause()
  {
    this.mRenderContext.pause();
  }
  
  public void resizeOffscreenWorld(String paramString, int paramInt1, int paramInt2)
  {
    nResizeOffscreenWorld(this.mNativeHandle, paramString, paramInt1, paramInt2);
  }
  
  public void resume()
  {
    this.mRenderContext.resume();
  }
  
  public void runScriptFile(String paramString)
  {
    nRunScriptFile(this.mNativeHandle, paramString);
  }
  
  public void runWorldScriptFile(String paramString1, String paramString2)
  {
    nRunWorldScriptFile(this.mNativeHandle, paramString1, paramString2);
  }
  
  public void setAssetsPath(String paramString)
  {
    this.mAssetsPath = paramString;
  }
  
  public void setCEJSEventListener(CEJSEventListener paramCEJSEventListener)
  {
    this.mCEJSEventListener = paramCEJSEventListener;
  }
  
  public void setCELifeCycle(CELifeCycle paramCELifeCycle)
  {
    this.mCELifeCycle = paramCELifeCycle;
  }
  
  public void setDefaultFPS(int paramInt)
  {
    this.mDefaultFPS = paramInt;
  }
  
  public void setEnableDebugJS(boolean paramBoolean)
  {
    this.mEnableDebugJS = paramBoolean;
  }
  
  public void setEnableGPUSkinning(boolean paramBoolean)
  {
    this.mEnableGPUSkinning = paramBoolean;
  }
  
  public void setFontPixelsFactory(FontPixelsFactory paramFontPixelsFactory)
  {
    SpineTextPainter.setFontPixelsFactory(paramFontPixelsFactory);
  }
  
  public void setFrameCallback(FrameCallback paramFrameCallback)
  {
    this.mFrameCallback = paramFrameCallback;
  }
  
  public void setLogger(LogDelegate paramLogDelegate)
  {
    if (paramLogDelegate != null) {
      Logger.a.a(paramLogDelegate);
    }
  }
  
  public void setOffscreenWorldCallback(OffscreenWorldCallback paramOffscreenWorldCallback)
  {
    this.mOffscreenWorldCallback = paramOffscreenWorldCallback;
  }
  
  public void setOptimizeSpineUpdate(boolean paramBoolean)
  {
    this.mOptimizeSpineUpdate = paramBoolean;
  }
  
  public void setStartUpWorld(String paramString)
  {
    this.mStartUpWorld = paramString;
  }
  
  public void setTimeScaleForWorld(String paramString, int paramInt, float paramFloat)
  {
    nSetTimeScaleForWorld(this.mNativeHandle, paramString, paramInt, paramFloat);
  }
  
  public void startGame()
  {
    InspectorBridge localInspectorBridge;
    if (this.mEnableDebugJS)
    {
      localInspectorBridge = new InspectorBridge();
      localInspectorBridge.setProxy(new WebSocketServerInspectAgent(this.mStartUpWorld));
    }
    else
    {
      localInspectorBridge = null;
    }
    this.mNativeHandle = nCreateNativeCEApp(this.mRenderContext.getNativeHandle(), this.mAssetsPath, this.mStartUpWorld, localInspectorBridge, this.mDefaultFPS, this.mEnableGPUSkinning);
    try
    {
      nSetOptimizeSpineUpdate(this.mNativeHandle, this.mOptimizeSpineUpdate);
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    this.mGameMainThread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.CEApplication
 * JD-Core Version:    0.7.0.1
 */