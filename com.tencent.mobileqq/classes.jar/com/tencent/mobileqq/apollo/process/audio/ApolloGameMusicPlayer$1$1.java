package com.tencent.mobileqq.apollo.process.audio;

import akwk;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public class ApolloGameMusicPlayer$1$1
  extends IApolloRunnableTask
{
  public ApolloGameMusicPlayer$1$1(akwk paramakwk, ApolloSurfaceView paramApolloSurfaceView) {}
  
  public String a()
  {
    return "mediaPlayer_onCompletion";
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Akwk.a != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender().getSavaWrapper().a(this.jdField_a_of_type_Akwk.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.audio.ApolloGameMusicPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */