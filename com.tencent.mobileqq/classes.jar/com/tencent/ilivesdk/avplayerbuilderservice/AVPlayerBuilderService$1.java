package com.tencent.ilivesdk.avplayerbuilderservice;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.avmediaservice_interface.AvInitCallBack;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceInterface;

class AVPlayerBuilderService$1
  implements AvInitCallBack
{
  AVPlayerBuilderService$1(AVPlayerBuilderService paramAVPlayerBuilderService) {}
  
  public void onAvInitCompleted()
  {
    AVPlayerBuilderService.access$002(true);
    this.this$0.openSdkPlayerService.init(this.this$0.context, AVPlayerBuilderService.access$100(this.this$0));
    this.this$0.currentPlayerService = this.this$0.openSdkPlayerService;
    this.this$0.mPlayerAdapter.getLogger().i("AVPlayerBuilderService", "open sdk onAvInitCompleted", new Object[0]);
  }
  
  public void onAvInitErr()
  {
    AVPlayerBuilderService.access$002(false);
    this.this$0.mPlayerAdapter.getLogger().e("AVPlayerBuilderService", "open sdk onAvInitErr", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerbuilderservice.AVPlayerBuilderService.1
 * JD-Core Version:    0.7.0.1
 */