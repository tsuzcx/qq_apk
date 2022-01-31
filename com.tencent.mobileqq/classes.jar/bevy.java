import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.FPSCallback;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITHttp;
import com.tencent.mobileqq.triton.sdk.ITLog;
import com.tencent.mobileqq.triton.sdk.ITSoLoader;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.audio.IAudioPlayerBuilder;
import com.tencent.mobileqq.triton.sdk.bridge.IInspectorAgent;
import com.tencent.mobileqq.triton.sdk.bridge.IJSEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.mobileqq.triton.sdk.game.GameLifecycle;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.util.Map;
import java.util.concurrent.Executor;

public class bevy
  implements ITTEngine
{
  private APIProxy jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy;
  private ITTEngine jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine;
  
  public void a(ITTEngine paramITTEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine = paramITTEngine;
  }
  
  public void addFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addFPSCallback(paramFPSCallback);
    }
  }
  
  public void addGameLifeCycle(GameLifecycle paramGameLifecycle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.addGameLifeCycle(paramGameLifecycle);
    }
  }
  
  public View createGameView(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.createGameView(paramActivity, paramInt1, paramInt2);
    }
    return null;
  }
  
  public APIProxy getApiProxy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getApiProxy();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy;
  }
  
  public long getCurrentDrawCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getCurrentDrawCount();
    }
    return 0L;
  }
  
  public int getDisplayRefreshRate()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getDisplayRefreshRate();
    }
    return 0;
  }
  
  public IGameLauncher getGameLauncher()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getGameLauncher();
    }
    return null;
  }
  
  public IJSEngine getJsEngine()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsEngine();
    }
    return null;
  }
  
  public ITTJSRuntime getJsRuntime(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getJsRuntime(paramInt);
    }
    return null;
  }
  
  public long getLastBlackTime()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getLastBlackTime();
    }
    return -1L;
  }
  
  public ITNativeBufferPool getNativeBufferPool()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getNativeBufferPool();
    }
    return null;
  }
  
  public ITHttp getNativeHttp()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getNativeHttp();
    }
    return null;
  }
  
  public boolean getOptionalSoLoadStatus(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getOptionalSoLoadStatus(paramString);
    }
    return false;
  }
  
  public Map<String, String> getResPathCache()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getResPathCache();
    }
    return null;
  }
  
  public void getScreenShot(ScreenShotCallback paramScreenShotCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getScreenShot(paramScreenShotCallback);
    }
  }
  
  public int getTargetFPS()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.getTargetFPS();
    }
    return 0;
  }
  
  public void handleFocusGain()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.handleFocusGain();
    }
  }
  
  public void handleFocusLoss()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.handleFocusLoss();
    }
  }
  
  public int initEngine(Context paramContext, ITTEngine.IListener paramIListener, @Nullable IInspectorAgent paramIInspectorAgent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.initEngine(paramContext, paramIListener, paramIInspectorAgent);
    }
    return 1;
  }
  
  public void onCreate(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onCreate(paramActivity);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onDestroy();
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.onResume();
    }
  }
  
  public void removeFPSCallback(FPSCallback paramFPSCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.removeFPSCallback(paramFPSCallback);
    }
  }
  
  public void setApiProxy(APIProxy paramAPIProxy)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setApiProxy(paramAPIProxy);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTritonSdkAPIProxy = paramAPIProxy;
  }
  
  public void setAudioPlayerBuilder(IAudioPlayerBuilder paramIAudioPlayerBuilder)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setAudioPlayerBuilder(paramIAudioPlayerBuilder);
    }
  }
  
  public void setDiskIoExecutor(Executor paramExecutor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setDiskIoExecutor(paramExecutor);
    }
  }
  
  public void setEnableCodeCache(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableCodeCache(paramBoolean);
    }
  }
  
  public void setEnableJankCanary(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEnableJankCanary(paramBoolean);
    }
  }
  
  public void setEngineListener(ITTEngine.IListener paramIListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setEngineListener(paramIListener);
    }
  }
  
  public void setJsEngine(IJSEngine paramIJSEngine)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setJsEngine(paramIJSEngine);
    }
  }
  
  public void setLog(ITLog paramITLog)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setLog(paramITLog);
    }
  }
  
  public void setQQEnv(IQQEnv paramIQQEnv)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setQQEnv(paramIQQEnv);
    }
  }
  
  public void setSoLoader(ITSoLoader paramITSoLoader)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setSoLoader(paramITSoLoader);
    }
  }
  
  public void setTargetFPS(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine != null) {
      this.jdField_a_of_type_ComTencentMobileqqTritonSdkITTEngine.setTargetFPS(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevy
 * JD-Core Version:    0.7.0.1
 */