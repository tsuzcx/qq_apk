package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.OnGetShareGroupInfoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class PlayModeUtils$10
  implements GetShareGroupInfoHandler.OnGetShareGroupInfoCallback
{
  PlayModeUtils$10(GetShareGroupInfoHandler.OnGetShareGroupInfoCallback paramOnGetShareGroupInfoCallback) {}
  
  public void a(GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    ThreadManager.getUIHandler().post(new PlayModeUtils.10.1(this, paramGetShareGroupInfoEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.10
 * JD-Core Version:    0.7.0.1
 */