package com.tencent.ilive.litepages.room.webmodule.js.interfaces;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.BaseLiteJSModule;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import java.util.Map;

public abstract class BaseLiteAppJavascriptInterface
  extends BaseLiteJSModule
{
  public BaseLiteAppJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  public abstract void addHistory(Map<String, String> paramMap);
  
  public abstract void beginDraw(Map<String, String> paramMap);
  
  public abstract void changeVideoRate(Map<String, String> paramMap);
  
  public abstract void checkcertificated(Map<String, String> paramMap);
  
  public abstract void clearDynamicEffectQueue(Map<String, String> paramMap);
  
  public abstract void close(Map<String, String> paramMap);
  
  public abstract void closePendantWebview(Map<String, String> paramMap);
  
  public abstract void contentLoaded(Map<String, String> paramMap);
  
  public abstract void doShare(Map<String, String> paramMap);
  
  public abstract void endDraw(Map<String, String> paramMap);
  
  public abstract void getClientScreenMode(Map<String, String> paramMap);
  
  public abstract void getLittleWindowStatus(Map<String, String> paramMap);
  
  public abstract void getNetworkType(Map<String, String> paramMap);
  
  public abstract void isAppInstalled(Map<String, String> paramMap);
  
  public abstract void loadFailed(Map<String, String> paramMap);
  
  public abstract void loadInputViewPlaceholder(Map<String, String> paramMap);
  
  public abstract void loadLiveVerticalGuideUserCommentData(Map<String, String> paramMap);
  
  public abstract void loadSucc(Map<String, String> paramMap);
  
  public abstract void navigateToMiniProgram(Map<String, String> paramMap);
  
  public abstract void onReConnect(Map<String, String> paramMap);
  
  public abstract void onSubscribeChanged(Map<String, String> paramMap);
  
  public abstract void openLoginPage(Map<String, String> paramMap);
  
  public abstract void openPendantWebview(Map<String, String> paramMap);
  
  public abstract void preloadDynamicEffectResource(Map<String, String> paramMap);
  
  public abstract void setLittleWindowStatus(Map<String, String> paramMap);
  
  public abstract void setScreenMode(Map<String, String> paramMap);
  
  public abstract void showDynamicEffect(Map<String, String> paramMap);
  
  public abstract void showKeyboard(Map<String, String> paramMap);
  
  public abstract void stopDynamicEffect(Map<String, String> paramMap);
  
  public abstract void transferBetweenWebviews(Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteAppJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */