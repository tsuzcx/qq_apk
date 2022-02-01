package com.tencent.ilivesdk.roomservice;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.protobuf.nano.MessageNano;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface.BizCommitScene;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.DeviceInfoUtil;
import com.tencent.falco.utils.StringUtil;
import com.tencent.ilivesdk.roomservice_interface.EnterRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.protobuf.iliveRoomPlay.nano.EnterReq;
import com.tencent.trpcprotocol.ilive.iliveRoomDispatch.iliveRoomDispatch.nano.LeaveRoomReq;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class RoomDataServer
{
  private static String convertExtData(RoomServiceAdapter paramRoomServiceAdapter, SparseArray<String> paramSparseArray)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramSparseArray != null) {}
    try
    {
      if (paramSparseArray.size() > 0)
      {
        JSONArray localJSONArray1 = new JSONArray();
        localJSONObject1.put("infos", localJSONArray1);
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        while (i < paramSparseArray.size())
        {
          int j = paramSparseArray.keyAt(i);
          String str = (String)paramSparseArray.get(j);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("key", String.valueOf(j));
          localJSONObject2.put("value", str);
          localJSONArray2.put(localJSONObject2);
          i += 1;
        }
        paramSparseArray = new JSONObject();
        paramSparseArray.put("items", localJSONArray2);
        paramSparseArray.put("client_type", paramRoomServiceAdapter.getAppInfo().getClientType());
        localJSONArray1.put(paramSparseArray);
      }
    }
    catch (Exception paramRoomServiceAdapter)
    {
      label162:
      break label162;
    }
    return localJSONObject1.toString();
  }
  
  public static void requestEnterRoom(Context paramContext, RoomServiceAdapter paramRoomServiceAdapter, EnterRoomInfo paramEnterRoomInfo, EnterRoomCallback paramEnterRoomCallback)
  {
    Object localObject = paramRoomServiceAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestEnterRoom roomInfo=");
    localStringBuilder.append(paramEnterRoomInfo.toString());
    ((LogInterface)localObject).i("RoomDataServer", localStringBuilder.toString(), new Object[0]);
    localObject = new EnterReq();
    ((EnterReq)localObject).roomid = paramEnterRoomInfo.roomId;
    ((EnterReq)localObject).source = paramEnterRoomInfo.source;
    ((EnterReq)localObject).machine = paramEnterRoomInfo.machine;
    ((EnterReq)localObject).programId = paramEnterRoomInfo.programId;
    if (TextUtils.isEmpty(((EnterReq)localObject).machine)) {
      ((EnterReq)localObject).machine = DeviceInfoUtil.getDeviceID(paramContext);
    }
    paramContext = MessageNano.toByteArray((MessageNano)localObject);
    paramRoomServiceAdapter.getChannel().send(1505, 4, paramContext, new RoomDataServer.1(paramEnterRoomInfo, paramEnterRoomCallback));
  }
  
  public static void requestExitRoom(RoomServiceAdapter paramRoomServiceAdapter, LiveRoomInfo paramLiveRoomInfo)
  {
    LeaveRoomReq localLeaveRoomReq = new LeaveRoomReq();
    localLeaveRoomReq.jdField_a_of_type_Long = ((int)paramLiveRoomInfo.roomId);
    localLeaveRoomReq.b = 0L;
    localLeaveRoomReq.jdField_a_of_type_JavaLangString = convertExtData(paramRoomServiceAdapter, paramRoomServiceAdapter.getHostProxyInterface().getBizCommitData(HostProxyInterface.BizCommitScene.EXIT_ROOM));
    paramRoomServiceAdapter.getChannel().sendWithTRpc("ilive-ilive_room_dispatch-ilive_room_dispatch-LeaveRoom", MessageNano.toByteArray(localLeaveRoomReq), new RoomDataServer.2(paramRoomServiceAdapter));
  }
  
  public static void requestWatchEnterRoom(Context paramContext, RoomServiceAdapter paramRoomServiceAdapter, EnterRoomInfo paramEnterRoomInfo, EnterRoomCallback paramEnterRoomCallback)
  {
    paramContext = paramRoomServiceAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestEnterRoom roomInfo=");
    localStringBuilder.append(paramEnterRoomInfo.toString());
    paramContext.i("RoomDataServer", localStringBuilder.toString(), new Object[0]);
    paramContext = new EnterRoomRequest();
    paramContext.roomId = paramEnterRoomInfo.roomId;
    paramContext.format = paramEnterRoomInfo.videoFormat;
    paramContext.extData = convertExtData(paramRoomServiceAdapter, paramRoomServiceAdapter.getHostProxyInterface().getBizCommitData(HostProxyInterface.BizCommitScene.ENTER_ROOM));
    if (!StringUtil.isEmpty(paramEnterRoomInfo.source)) {
      paramContext.fromSource = paramEnterRoomInfo.source.getBytes();
    }
    paramContext.machineCode = paramEnterRoomInfo.machine;
    paramContext = MessageNano.toByteArray(paramContext);
    paramRoomServiceAdapter.getChannel().sendWithTRpc("ilive-room_access-room_access", "EnterRoom", paramContext, new RoomDataServer.3(paramEnterRoomInfo, paramRoomServiceAdapter, paramEnterRoomCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.RoomDataServer
 * JD-Core Version:    0.7.0.1
 */