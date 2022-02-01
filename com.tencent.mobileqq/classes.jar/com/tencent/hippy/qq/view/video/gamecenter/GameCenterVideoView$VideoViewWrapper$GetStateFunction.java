package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;

class GameCenterVideoView$VideoViewWrapper$GetStateFunction
  implements GameCenterVideoView.FunctionExecutor
{
  private GameCenterVideoView$VideoViewWrapper$GetStateFunction(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper) {}
  
  public void execute(HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    paramHippyArray = new HippyMap();
    paramHippyArray.pushInt("playState", this.this$1.getCurrentStatus());
    paramPromise.resolve(paramHippyArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.GetStateFunction
 * JD-Core Version:    0.7.0.1
 */