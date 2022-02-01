package com.tencent.livesdk.servicefactory.builder.floatheart;

import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.floatheartservice_interface.FloatHeartServiceAdapter;
import com.tencent.ilivesdk.liveconfigservice_interface.LiveConfigServiceInterface;
import com.tencent.ilivesdk.roompushservice_interface.RoomPushServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import org.json.JSONException;
import org.json.JSONObject;

class FloatHeartServiceBuilder$1
  implements FloatHeartServiceAdapter
{
  FloatHeartServiceBuilder$1(FloatHeartServiceBuilder paramFloatHeartServiceBuilder, ServiceAccessor paramServiceAccessor) {}
  
  public PushReceiver createPushReceiver()
  {
    return ((RoomPushServiceInterface)this.val$serviceManager.getService(RoomPushServiceInterface.class)).createRoomPushReceiver();
  }
  
  public long getAnchorUid()
  {
    if ((((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo != null)) {
      return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().anchorInfo.uid;
    }
    return 0L;
  }
  
  public ChannelInterface getChannel()
  {
    return (ChannelInterface)this.val$serviceManager.getService(ChannelInterface.class);
  }
  
  public DataReportInterface getDataReport()
  {
    return (DataReportInterface)this.val$serviceManager.getService(DataReportInterface.class);
  }
  
  public JSONObject getFloatHeartURLConfig()
  {
    JSONObject localJSONObject = ((LiveConfigServiceInterface)this.val$serviceManager.getService(LiveConfigServiceInterface.class)).getJson("float_heart");
    if (localJSONObject != null) {
      try
      {
        localJSONObject = localJSONObject.getJSONObject("float_heart_icon_url");
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)this.val$serviceManager.getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)this.val$serviceManager.getService(LogInterface.class);
  }
  
  public String getProgramId()
  {
    if ((((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo != null)) {
      return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo.programId;
    }
    return "";
  }
  
  public long getRoomId()
  {
    if ((((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo() != null) && (((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo != null)) {
      return ((RoomServiceInterface)this.val$serviceManager.getService(RoomServiceInterface.class)).getLiveInfo().roomInfo.roomId;
    }
    return 0L;
  }
  
  public JSONObject updateGiftLogoFormatKey()
  {
    return ((LiveConfigServiceInterface)this.val$serviceManager.getService(LiveConfigServiceInterface.class)).getJson("common_urls");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.floatheart.FloatHeartServiceBuilder.1
 * JD-Core Version:    0.7.0.1
 */