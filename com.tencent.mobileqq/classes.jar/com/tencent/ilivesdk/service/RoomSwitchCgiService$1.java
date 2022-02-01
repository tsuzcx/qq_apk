package com.tencent.ilivesdk.service;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RoomSwitchCgiService$1
  implements HttpResponse
{
  RoomSwitchCgiService$1(RoomSwitchCgiService paramRoomSwitchCgiService, List paramList, RoomSwitchInterface.IRoomList paramIRoomList) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {}
    while (paramInt != 0) {
      return;
    }
    for (;;)
    {
      SwitchRoomInfo localSwitchRoomInfo;
      try
      {
        paramJSONObject.getInt("retcode");
        localObject = paramJSONObject.getJSONObject("result").getJSONArray("data");
        paramJSONObject = new ArrayList();
        paramInt = i;
        if (paramInt >= ((JSONArray)localObject).length()) {
          break;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(paramInt);
        localSwitchRoomInfo = new SwitchRoomInfo();
        localSwitchRoomInfo.roomId = localJSONObject.getLong("room_id");
        localSwitchRoomInfo.logoUrl = localJSONObject.getString("room_logo_url");
        if (paramInt == 0)
        {
          localSwitchRoomInfo.roomId = 1210982456L;
          localSwitchRoomInfo.videoUrl = "http://flv.6721.liveplay.now.qq.com/live/6721_c21f14dc5c3ce1b2513f5810f359ea15.flv?txSecret=c2993deb92b4907ae09e44280b9bb32a&txTime=5F926D06";
          localSwitchRoomInfo.videoUrl += "&dispatch_from=ztc";
          localSwitchRoomInfo.videoType = VideoType.LIVE;
          paramJSONObject.add(localSwitchRoomInfo);
          paramInt += 1;
          continue;
        }
        if (paramInt == 2)
        {
          localSwitchRoomInfo.videoUrl = this.this$0.video_url1;
          localSwitchRoomInfo.videoType = VideoType.VIDEO;
          continue;
        }
        localSwitchRoomInfo.videoUrl = localJSONObject.getString("hlsurl").replace(".m3u8", ".flv").replace("https://", "http://");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      localSwitchRoomInfo.videoUrl += "&dispatch_from=ztc";
      localSwitchRoomInfo.videoType = VideoType.LIVE;
    }
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.val$roomList);
    ((List)localObject).addAll(paramJSONObject);
    this.val$listener.onResult(0, ((List)localObject).size(), (List)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.service.RoomSwitchCgiService.1
 * JD-Core Version:    0.7.0.1
 */