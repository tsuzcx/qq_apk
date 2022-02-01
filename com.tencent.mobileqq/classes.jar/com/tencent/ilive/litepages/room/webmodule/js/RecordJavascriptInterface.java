package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.Context;
import com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteRecordJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.Map;

public class RecordJavascriptInterface
  extends BaseLiteRecordJavascriptInterface
{
  private static final String TAG = "RecordJavascriptInterface";
  private AVPlayerBuilderServiceInterface avPlayerService;
  
  public RecordJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
    if (paramJsBizAdapter.getModuleRoomEngine() != null) {
      this.avPlayerService = ((AVPlayerBuilderServiceInterface)paramJsBizAdapter.getModuleRoomEngine().getService(AVPlayerBuilderServiceInterface.class));
    }
  }
  
  @NewJavascriptInterface
  public void getviderect(Map<String, String> paramMap) {}
  
  @NewJavascriptInterface
  public void playpause(Map<String, String> paramMap)
  {
    if (getJsBizAdapter() != null)
    {
      if (this.avPlayerService == null) {
        return;
      }
      paramMap = (String)paramMap.get("status");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playpause--playStatus=");
      localStringBuilder.append(paramMap);
      logI("RecordJavascriptInterface", localStringBuilder.toString());
      if (paramMap.equals("0"))
      {
        getJsBizAdapter().onPlayerPause();
        this.avPlayerService.pausePlay();
        return;
      }
      if (paramMap.equals("1"))
      {
        getJsBizAdapter().onPlayerResume();
        this.avPlayerService.resumePlay();
      }
    }
  }
  
  @NewJavascriptInterface
  public void seekto(Map<String, String> paramMap)
  {
    if (this.avPlayerService == null) {
      return;
    }
    paramMap = (String)paramMap.get("time");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seekto--time=");
    localStringBuilder.append(paramMap);
    logI("RecordJavascriptInterface", localStringBuilder.toString());
    try
    {
      i = Integer.parseInt(paramMap);
      i *= 1000;
    }
    catch (Exception paramMap)
    {
      int i;
      label65:
      break label65;
    }
    i = 0;
    this.avPlayerService.seekTo(i);
    this.avPlayerService.startPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */