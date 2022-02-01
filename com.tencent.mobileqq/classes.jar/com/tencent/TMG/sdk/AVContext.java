package com.tencent.TMG.sdk;

import android.content.Context;
import android.view.SurfaceHolder;
import com.tencent.TMG.opengl.GraphicRendererMgr;

public abstract class AVContext
{
  public static final String sdkVersion = "";
  
  public static AVContext createInstance(Context paramContext)
  {
    AVContextImpl localAVContextImpl = new AVContextImpl();
    if (localAVContextImpl.create(paramContext, false)) {
      return localAVContextImpl;
    }
    return null;
  }
  
  public static AVContext createInstance(Context paramContext, boolean paramBoolean)
  {
    AVContextImpl localAVContextImpl = new AVContextImpl();
    if (localAVContextImpl.create(paramContext, paramBoolean)) {
      return localAVContextImpl;
    }
    return null;
  }
  
  public static int getSoExtractError()
  {
    return AVContextImpl.getSoExtractError();
  }
  
  public static String getVersion()
  {
    return AVContextImpl.getVersion();
  }
  
  abstract int codecTranslate(String paramString1, String paramString2, int paramInt);
  
  public abstract void destroy();
  
  public abstract void enterRoom(AVRoomMulti.EventListener paramEventListener, AVRoomMulti.EnterParam paramEnterParam);
  
  public abstract int exitRoom();
  
  public abstract AVAudioCtrl getAudioCtrl();
  
  public abstract AVAudioEffectCtrl getAudioEffectCtrl();
  
  public abstract AVCloudSpearEngineCtrl getCloudSpearEngineCtrl();
  
  public abstract AVCustomSpearEngineCtrl getCustomSpearEngineCtrl();
  
  public abstract String getParam(String paramString);
  
  public abstract AVRoomMulti getRoom();
  
  public abstract AVVideoCtrl getVideoCtrl();
  
  public abstract void setAppVersion(String paramString);
  
  public abstract int setParam(String paramString1, String paramString2);
  
  public abstract int setRenderMgr(GraphicRendererMgr paramGraphicRendererMgr);
  
  public abstract int setRenderMgrAndHolder(GraphicRendererMgr paramGraphicRendererMgr, SurfaceHolder paramSurfaceHolder);
  
  public abstract int setSurfaceHolder(SurfaceHolder paramSurfaceHolder);
  
  public abstract void start(AVContext.StartParam paramStartParam, AVCallback paramAVCallback);
  
  public abstract void start(AVContext.StartParam paramStartParam, AVSDKLogSetting paramAVSDKLogSetting, AVCallback paramAVCallback);
  
  abstract int startPreservingEncData(String paramString1, String paramString2);
  
  public abstract int stop();
  
  abstract int stopPreservingEncData();
  
  @Deprecated
  public abstract void switchRoom(int paramInt);
  
  public abstract void switchRoom(AVRoomMulti.ChangeRoomInfo paramChangeRoomInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVContext
 * JD-Core Version:    0.7.0.1
 */