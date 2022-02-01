package com.tencent.ilive.litepages.room.webmodule.jsmodule;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import org.json.JSONObject;

public abstract interface JsBizAdapter
{
  public abstract void callJsFunctionByNative(String paramString, JSONObject paramJSONObject, JsBizAdapter.ValueCallback paramValueCallback);
  
  public abstract HttpInterface getHttp();
  
  public abstract LogInterface getLogger();
  
  public abstract ModuleEvent getModuleEvent();
  
  public abstract RoomEngine getModuleRoomEngine();
  
  public abstract RoomPageActionInterface getRoomPageAction();
  
  public abstract void onGetRoomInfo(RoomExtInfo paramRoomExtInfo);
  
  public abstract void onPlayerPause();
  
  public abstract void onPlayerResume();
  
  public abstract void onSubscribeStateChanged(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter
 * JD-Core Version:    0.7.0.1
 */