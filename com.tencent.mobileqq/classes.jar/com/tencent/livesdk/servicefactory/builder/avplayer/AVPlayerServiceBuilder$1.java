package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerServiceBuilderAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;
import com.tencent.ilivesdk.avpreloadplayerservice.AVPreloadPlayerService;

class AVPlayerServiceBuilder$1
  implements AVPlayerServiceBuilderAdapter
{
  AVPlayerServiceBuilder$1(AVPlayerServiceBuilder paramAVPlayerServiceBuilder) {}
  
  public AVPlayerServiceInterface getNormalPlayer()
  {
    return new AVPreloadPlayerService();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */