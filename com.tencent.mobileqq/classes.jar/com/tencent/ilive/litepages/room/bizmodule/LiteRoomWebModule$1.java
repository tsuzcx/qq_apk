package com.tencent.ilive.litepages.room.bizmodule;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

class LiteRoomWebModule$1
  implements JsBizAdapter
{
  LiteRoomWebModule$1(LiteRoomWebModule paramLiteRoomWebModule) {}
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject, JsBizAdapter.ValueCallback paramValueCallback)
  {
    if (paramJSONObject != null) {}
    for (paramString = "javascript:(" + paramString + "(" + paramJSONObject.toString() + "))";; paramString = "javascript:" + paramString + "()")
    {
      LiteRoomWebModule.access$000(this.this$0).evaluateJavascript(paramString, new LiteRoomWebModule.1.1(this, paramValueCallback));
      return;
    }
  }
  
  public HttpInterface getHttp()
  {
    return this.this$0.getHttp();
  }
  
  public LogInterface getLogger()
  {
    return this.this$0.getLog();
  }
  
  public ModuleEvent getModuleEvent()
  {
    return this.this$0.getEvent();
  }
  
  public RoomEngine getModuleRoomEngine()
  {
    return this.this$0.getRoomEngine();
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    return this.this$0.getAudienceRoomPager().getRoomPageAction();
  }
  
  public void onGetRoomInfo(RoomExtInfo paramRoomExtInfo) {}
  
  public void onPlayerPause() {}
  
  public void onPlayerResume() {}
  
  public void onSubscribeStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteRoomWebModule.1
 * JD-Core Version:    0.7.0.1
 */