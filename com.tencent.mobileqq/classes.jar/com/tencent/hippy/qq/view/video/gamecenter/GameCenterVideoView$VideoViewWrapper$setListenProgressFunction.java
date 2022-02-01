package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

class GameCenterVideoView$VideoViewWrapper$setListenProgressFunction
  implements GameCenterVideoView.FunctionExecutor
{
  private GameCenterVideoView$VideoViewWrapper$setListenProgressFunction(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper) {}
  
  public void execute(HippyArray paramHippyArray, Promise paramPromise)
  {
    this.this$1.this$0.setListenProgress(paramHippyArray.getBoolean(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.setListenProgressFunction
 * JD-Core Version:    0.7.0.1
 */