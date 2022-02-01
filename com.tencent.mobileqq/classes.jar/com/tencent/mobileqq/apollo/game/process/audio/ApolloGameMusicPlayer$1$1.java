package com.tencent.mobileqq.apollo.game.process.audio;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.cmshow.brickengine.apollo.IApolloRunnableTask;

class ApolloGameMusicPlayer$1$1
  extends IApolloRunnableTask
{
  ApolloGameMusicPlayer$1$1(ApolloGameMusicPlayer.1 param1, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    if (this.b.d != 0L) {
      this.a.getRender().getSavaWrapper().audioCallBack(this.b.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */