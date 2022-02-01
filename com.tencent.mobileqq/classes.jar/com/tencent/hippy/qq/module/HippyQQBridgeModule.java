package com.tencent.hippy.qq.module;

import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import org.json.JSONObject;

@HippyNativeModule(name="bridge")
public class HippyQQBridgeModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "bridge";
  private QQBridgeModule mBridgeModule = new QQBridgeModule();
  
  public HippyQQBridgeModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    this.mBridgeModule.setEngineId(paramHippyEngineContext.getEngineId());
  }
  
  @HippyMethod(name="addFavorite")
  public void addFavorite(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.addFavorite(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="c2sReport")
  public void c2sReport(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.c2sReport(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="cancelUploadingVideo")
  public void cancelUploadingVideo(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.cancelUploadingVideo(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="cancelVideoPreDownload")
  public void cancelVideoPreDownload()
  {
    this.mBridgeModule.cancelVideoPreDownload();
  }
  
  @HippyMethod(name="chooseVideoAddToTopic")
  public void chooseVideoAddToTopic(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.chooseVideoAddToTopic(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="dwellTimeMillisReport")
  public void dwellTimeMillisReport(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.dwellTimeMillisReport(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="getALDConfig")
  public void getALDConfig(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getALDConfig(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getAllowedStateOfOperationAction")
  public void getAllowedStateOfOperationAction(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getAllowedStateOfOperationAction(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getCreateTopicPermission")
  public void getCreateTopicPermission(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getCreateTopicPermission(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getDeviceInfo")
  public void getDeviceInfo(Promise paramPromise)
  {
    this.mBridgeModule.getDeviceInfo(paramPromise, false);
  }
  
  @HippyMethod(name="getGdtDeviceInfo")
  public void getGdtDeviceInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getGdtDeviceInfo(paramPromise, paramHippyMap, true);
      return;
    }
  }
  
  @HippyMethod(name="getMotiveAd")
  public void getMotiveAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getMotiveAd(paramPromise, paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="getNetType")
  public void getNetType(Promise paramPromise)
  {
    this.mBridgeModule.getNetType(paramPromise, false);
  }
  
  @HippyMethod(name="getUploadVideoPermission")
  public void getUploadVideoPermission(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getUploadVideoPermission(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getUploadingVideoInfo")
  public void getUploadingVideoInfo(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.getUploadingVideoInfo(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="getUserInfo")
  public void getUserInfo(Promise paramPromise)
  {
    this.mBridgeModule.getUserInfo(paramPromise, false);
  }
  
  @HippyMethod(name="handleClick")
  public void handleClick(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.handleClick(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="hasApp")
  public void hasApp(String paramString, Promise paramPromise)
  {
    this.mBridgeModule.hasApp(paramString, paramPromise, false);
  }
  
  @HippyMethod(name="hideTopicVideoComment")
  public void hideTopicVideoComment(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.hideTopicVideoComment(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="invoke")
  public void invoke(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      HippyQQEngine.runTaskInUIThread(new HippyQQBridgeModule.2(this, paramHippyMap, paramPromise));
      return;
    }
  }
  
  @HippyMethod(name="isKindCard")
  public void isKindCard(Promise paramPromise) {}
  
  @HippyMethod(name="openAddVideoView")
  public void openAddVideoView(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openAddVideoView(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openApp")
  public void openApp(String paramString)
  {
    this.mBridgeModule.openApp(paramString);
  }
  
  @HippyMethod(name="openCreateTopicView")
  public void openCreateTopicView(Promise paramPromise)
  {
    this.mBridgeModule.openCreateTopicView(paramPromise);
  }
  
  @HippyMethod(name="openEditTopicView")
  public void openEditTopicView(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openEditTopicView(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openRewardAd")
  public void openRewardAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openRewardAd(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openTopicVideoComment")
  public void openTopicVideoComment(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openTopicVideoComment(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="openVideo")
  public void openVideo(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openVideo(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="pauseUploadingVideo")
  public void pauseUploadingVideo(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.pauseUploadingVideo(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="performLikeAnimation")
  public void performLikeAnimation(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.performLikeAnimation(paramHippyMap);
      return;
    }
  }
  
  public void popFromBottomStateChange(Promise paramPromise) {}
  
  @HippyMethod(name="resetSatusBarBlackStyle")
  public void resetSatusBarBlackStyle(HippyMap paramHippyMap, Promise paramPromise)
  {
    this.mBridgeModule.resetSatusBarBlackStyle();
  }
  
  @HippyMethod(name="resetSatusBarWhiteStyle")
  public void resetSatusBarWhiteStyle(HippyMap paramHippyMap, Promise paramPromise)
  {
    this.mBridgeModule.resetSatusBarWhiteStyle();
  }
  
  @HippyMethod(name="resumeUploadingVideo")
  public void resumeUploadingVideo(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.resumeUploadingVideo(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="setNavBtn")
  public void setNavBtn(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      HippyQQEngine.runTaskInUIThread(new HippyQQBridgeModule.1(this, paramHippyMap, paramPromise));
      return;
    }
  }
  
  public void setPresentPopFromBottom(int paramInt) {}
  
  @HippyMethod(name="shareVideoWithFriend")
  public void shareVideoWithFriend(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.shareVideoWithFriend(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="showLevelDialog")
  public void showLevelDialog(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.openUserLevelDialog(paramHippyMap, paramPromise);
      return;
    }
  }
  
  @HippyMethod(name="showMotiveAd")
  public void showMotiveAd(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null)
    {
      paramHippyMap.toJSONObject();
      return;
    }
    new JSONObject();
  }
  
  @HippyMethod(name="startImagePreDownload")
  public void startImagePreDownload(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.startImagePreDownload(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="startVideoPreDownload")
  public void startVideoPreDownload(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.startVideoPreDownload(paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="susCommentViewHide")
  public void susCommentViewHide() {}
  
  @HippyMethod(name="susCommentViewShow")
  public void susCommentViewShow() {}
  
  @HippyMethod(name="updateIndepentTabState")
  public void updateIndepentTabState(HippyMap paramHippyMap)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      HippyQQEngine.runTaskInUIThread(new HippyQQBridgeModule.3(this, paramHippyMap));
      return;
    }
  }
  
  @HippyMethod(name="vaNetworkChange")
  public void vaNetworkChange(Promise paramPromise)
  {
    this.mBridgeModule.vaNetworkChange(paramPromise);
  }
  
  @HippyMethod(name="videoPlayFeedback")
  public void videoPlayFeedback(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mBridgeModule.videoPlayFeedback(paramHippyMap, paramPromise);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQBridgeModule
 * JD-Core Version:    0.7.0.1
 */