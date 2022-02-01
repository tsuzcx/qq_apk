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
    if ((getJsBizAdapter() == null) || (this.avPlayerService == null)) {}
    do
    {
      return;
      paramMap = (String)paramMap.get("status");
      logI("RecordJavascriptInterface", "playpause--playStatus=" + paramMap);
      if (paramMap.equals("0"))
      {
        getJsBizAdapter().onPlayerPause();
        this.avPlayerService.pausePlay();
        return;
      }
    } while (!paramMap.equals("1"));
    getJsBizAdapter().onPlayerResume();
    this.avPlayerService.resumePlay();
  }
  
  @NewJavascriptInterface
  public void seekto(Map<String, String> paramMap)
  {
    if (this.avPlayerService == null) {
      return;
    }
    paramMap = (String)paramMap.get("time");
    logI("RecordJavascriptInterface", "seekto--time=" + paramMap);
    try
    {
      i = Integer.parseInt(paramMap);
      i *= 1000;
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    this.avPlayerService.seekTo(i);
    this.avPlayerService.startPlay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.RecordJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */