package com.tencent.mobileqq.apollo.game.process.audio;

import com.tencent.mobileqq.apollo.render.IApolloRunnableTask;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRender;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView;

class ApolloGameMusicPlayer$1$1
  extends IApolloRunnableTask
{
  ApolloGameMusicPlayer$1$1(ApolloGameMusicPlayer.1 param1, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer$1.a != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineApolloApolloSurfaceView.getRender().getSavaWrapper().audioCallBack(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessAudioApolloGameMusicPlayer$1.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.audio.ApolloGameMusicPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */