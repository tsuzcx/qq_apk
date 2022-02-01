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
    if (paramJSONObject == null) {
      return;
    }
    if (paramInt == 0) {
      try
      {
        paramJSONObject.getInt("retcode");
        Object localObject1 = paramJSONObject.getJSONObject("result").getJSONArray("data");
        paramJSONObject = new ArrayList();
        paramInt = 0;
        while (paramInt < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(paramInt);
          SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
          localSwitchRoomInfo.roomId = ((JSONObject)localObject2).getLong("room_id");
          localSwitchRoomInfo.logoUrl = ((JSONObject)localObject2).getString("room_logo_url");
          if (paramInt == 0)
          {
            localSwitchRoomInfo.roomId = 1210982456L;
            localSwitchRoomInfo.videoUrl = "http://flv.6721.liveplay.now.qq.com/live/6721_c21f14dc5c3ce1b2513f5810f359ea15.flv?txSecret=c2993deb92b4907ae09e44280b9bb32a&txTime=5F926D06";
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(localSwitchRoomInfo.videoUrl);
            ((StringBuilder)localObject2).append("&dispatch_from=ztc");
            localSwitchRoomInfo.videoUrl = ((StringBuilder)localObject2).toString();
            localSwitchRoomInfo.videoType = VideoType.LIVE;
          }
          else if (paramInt == 2)
          {
            localSwitchRoomInfo.videoUrl = this.this$0.video_url1;
            localSwitchRoomInfo.videoType = VideoType.VIDEO;
          }
          else
          {
            localSwitchRoomInfo.videoUrl = ((JSONObject)localObject2).getString("hlsurl").replace(".m3u8", ".flv").replace("https://", "http://");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(localSwitchRoomInfo.videoUrl);
            ((StringBuilder)localObject2).append("&dispatch_from=ztc");
            localSwitchRoomInfo.videoUrl = ((StringBuilder)localObject2).toString();
            localSwitchRoomInfo.videoType = VideoType.LIVE;
          }
          paramJSONObject.add(localSwitchRoomInfo);
          paramInt += 1;
        }
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(this.val$roomList);
        ((List)localObject1).addAll(paramJSONObject);
        this.val$listener.onResult(0, ((List)localObject1).size(), (List)localObject1);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.RoomSwitchCgiService.1
 * JD-Core Version:    0.7.0.1
 */