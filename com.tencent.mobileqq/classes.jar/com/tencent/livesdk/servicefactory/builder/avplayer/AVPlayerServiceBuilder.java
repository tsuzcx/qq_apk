package com.tencent.livesdk.servicefactory.builder.avplayer;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.utils.PreloadUtil;
import com.tencent.ilivesdk.avplayerbuilderservice.AVPlayerBuilderService;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class AVPlayerServiceBuilder
  implements BaseServiceBuilder
{
  private void initPreloadAdapter(AVPlayerBuilderServiceInterface paramAVPlayerBuilderServiceInterface, ServiceAccessor paramServiceAccessor)
  {
    if (!PreloadUtil.a()) {
      return;
    }
    paramAVPlayerBuilderServiceInterface.setPlayerPreloadAdapter(new AVPlayerServiceBuilder.3(this, paramAVPlayerBuilderServiceInterface, (AVPreloadServiceInterface)paramServiceAccessor.getService(AVPreloadServiceInterface.class)));
  }
  
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    AVPlayerBuilderService localAVPlayerBuilderService = new AVPlayerBuilderService();
    localAVPlayerBuilderService.setBuilderAdapter(new AVPlayerServiceBuilder.1(this));
    localAVPlayerBuilderService.setPlayerAdapter(new AVPlayerServiceBuilder.2(this, paramServiceAccessor, (RoomServiceInterface)paramServiceAccessor.getService(RoomServiceInterface.class)));
    initPreloadAdapter(localAVPlayerBuilderService, paramServiceAccessor);
    return localAVPlayerBuilderService;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.avplayer.AVPlayerServiceBuilder
 * JD-Core Version:    0.7.0.1
 */