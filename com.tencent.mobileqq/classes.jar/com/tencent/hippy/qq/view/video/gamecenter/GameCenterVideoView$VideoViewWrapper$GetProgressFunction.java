package com.tencent.hippy.qq.view.video.gamecenter;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.modules.Promise;

class GameCenterVideoView$VideoViewWrapper$GetProgressFunction
  implements GameCenterVideoView.FunctionExecutor
{
  private GameCenterVideoView$VideoViewWrapper$GetProgressFunction(GameCenterVideoView.VideoViewWrapper paramVideoViewWrapper) {}
  
  public void execute(HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramPromise == null) {
      return;
    }
    paramPromise.resolve(GameCenterVideoView.VideoViewWrapper.access$2000(this.this$1, this.this$1.getCurrentPostion()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.GetProgressFunction
 * JD-Core Version:    0.7.0.1
 */