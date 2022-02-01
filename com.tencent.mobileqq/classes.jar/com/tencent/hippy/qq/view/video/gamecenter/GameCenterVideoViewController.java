package com.tencent.hippy.qq.view.video.gamecenter;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

@HippyController(name="gcVideoView")
public class GameCenterVideoViewController
  extends HippyViewController<GameCenterVideoView>
{
  public static final String CLASS_NAME = "gcVideoView";
  private static final String TAG = "GameCenterVideoViewCont";
  private int mHippyEngineId = -2147483648;
  
  @HippyControllerProps(name="clearDanmu")
  public void clearDanmu(GameCenterVideoView paramGameCenterVideoView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoViewCont", 1, "clearDanmu call");
    }
    paramGameCenterVideoView.clearDanmu();
  }
  
  public View createView(HippyRootView paramHippyRootView, int paramInt, HippyEngineContext paramHippyEngineContext, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyEngineContext != null) {
      this.mHippyEngineId = paramHippyEngineContext.getEngineId();
    }
    return super.createView(paramHippyRootView, paramInt, paramHippyEngineContext, paramString, paramHippyMap);
  }
  
  public View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new GameCenterVideoView(paramContext, this.mHippyEngineId);
  }
  
  public void dispatchFunction(GameCenterVideoView paramGameCenterVideoView, String paramString, HippyArray paramHippyArray)
  {
    paramGameCenterVideoView.dispatchFunction(paramString, paramHippyArray, null);
  }
  
  public void dispatchFunction(GameCenterVideoView paramGameCenterVideoView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    paramGameCenterVideoView.dispatchFunction(paramString, paramHippyArray, paramPromise);
  }
  
  public void onAfterUpdateProps(GameCenterVideoView paramGameCenterVideoView)
  {
    paramGameCenterVideoView.onAfterUpdateProps();
  }
  
  public void onViewDestroy(GameCenterVideoView paramGameCenterVideoView)
  {
    QLog.d("GameCenterVideoViewCont", 1, "onViewDestroy");
    super.onViewDestroy(paramGameCenterVideoView);
    if (paramGameCenterVideoView != null) {
      paramGameCenterVideoView.destory();
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="autoPlay")
  public void setAutoPlay(GameCenterVideoView paramGameCenterVideoView, boolean paramBoolean)
  {
    paramGameCenterVideoView.setAutoPlay(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="string", name="coverUrl")
  public void setCoverUrl(GameCenterVideoView paramGameCenterVideoView, String paramString)
  {
    paramGameCenterVideoView.setCoverUrl(paramString);
  }
  
  @HippyControllerProps(defaultType="string", name="setDanmuData")
  public void setDanmuData(GameCenterVideoView paramGameCenterVideoView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterVideoViewCont", 1, "setDanmuData call");
    }
    paramGameCenterVideoView.setDanmuData(paramString);
  }
  
  @HippyControllerProps(defaultType="number", name="loop")
  public void setLoop(GameCenterVideoView paramGameCenterVideoView, int paramInt)
  {
    paramGameCenterVideoView.setLoop(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="muted")
  public void setMuted(GameCenterVideoView paramGameCenterVideoView, boolean paramBoolean)
  {
    paramGameCenterVideoView.setMuted(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onProgress")
  public void setOnProgress(GameCenterVideoView paramGameCenterVideoView, boolean paramBoolean)
  {
    paramGameCenterVideoView.setListenProgress(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="boolean", name="preload")
  public void setPreload(GameCenterVideoView paramGameCenterVideoView, boolean paramBoolean)
  {
    paramGameCenterVideoView.setPreload(paramBoolean);
  }
  
  @HippyControllerProps(defaultType="string", name="src")
  public void setSrc(GameCenterVideoView paramGameCenterVideoView, String paramString)
  {
    paramGameCenterVideoView.setSrc(paramString);
  }
  
  @HippyControllerProps(defaultType="number", name="type")
  public void setType(GameCenterVideoView paramGameCenterVideoView, int paramInt)
  {
    paramGameCenterVideoView.setType(paramInt);
  }
  
  @HippyControllerProps(defaultType="number", name="uiStyle")
  public void setUIStyle(GameCenterVideoView paramGameCenterVideoView, int paramInt)
  {
    paramGameCenterVideoView.setUIStyle(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoViewController
 * JD-Core Version:    0.7.0.1
 */