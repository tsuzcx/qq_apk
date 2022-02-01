package com.tencent.ilivesdk.roomservice;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveMediaInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveTlvInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveVideoStatus;
import com.tencent.ilivesdk.roomservice_interface.model.LiveWatchMediaInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceAddressInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceFrameInfo;
import com.tencent.ilivesdk.roomservice_interface.model.streaminfo.ServiceStreamInfo;
import com.tencent.protobuf.iliveRoomPlay.nano.EnterRsp;
import com.tencent.protobuf.iliveRoomPlay.nano.MediaInfo;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.AVInfo;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Address;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.DesignatedStreamInfo;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.EnterRoomReply;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Frame;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.OpenSdkUrl;
import com.tencent.trpcprotocol.ilive.roomAccess.roomAccess.nano.Stream;
import java.util.ArrayList;
import java.util.List;

public class LiveInfoProvider
{
  private static final String TAG = "LiveInfoProvider";
  static final int origin_7 = 7;
  static final int origin_Pause = 3;
  static final int origin_Restart = 5;
  static final int origin_Resume = 6;
  static final int origin_Start = 1;
  static final int origin_Stop = 2;
  static final int origin_Stuck = 4;
  static final int origin_Unknown = 0;
  
  public static LiveInfo parseLiveAudienceLiveInfo(EnterRoomReply paramEnterRoomReply, EnterRoomInfo paramEnterRoomInfo, LogInterface paramLogInterface)
  {
    paramEnterRoomInfo = new LiveInfo();
    Object localObject1 = new LiveRoomInfo();
    if (paramEnterRoomReply.roomInfo != null)
    {
      ((LiveRoomInfo)localObject1).roomId = paramEnterRoomReply.roomInfo.roomId;
      ((LiveRoomInfo)localObject1).roomType = paramEnterRoomReply.roomInfo.gameType;
      ((LiveRoomInfo)localObject1).roomName = paramEnterRoomReply.roomInfo.name;
      ((LiveRoomInfo)localObject1).roomLogo = paramEnterRoomReply.roomInfo.logo;
      ((LiveRoomInfo)localObject1).goodsFlag = paramEnterRoomReply.roomInfo.goodsFlag;
      ((LiveRoomInfo)localObject1).giftFlag = paramEnterRoomReply.roomInfo.giftFlag;
      ((LiveRoomInfo)localObject1).programId = paramEnterRoomReply.roomInfo.programId;
      ((LiveRoomInfo)localObject1).enterRoomSystemNotice = paramEnterRoomReply.roomInfo.systemNotice;
    }
    paramEnterRoomInfo.roomInfo = ((LiveRoomInfo)localObject1);
    localObject1 = new LiveAnchorInfo();
    if (paramEnterRoomReply.anchorInfo != null)
    {
      ((LiveAnchorInfo)localObject1).uid = paramEnterRoomReply.anchorInfo.uid;
      ((LiveAnchorInfo)localObject1).nickName = paramEnterRoomReply.anchorInfo.nick;
      ((LiveAnchorInfo)localObject1).initialClientType = paramEnterRoomReply.anchorInfo.initialClientType;
      ((LiveAnchorInfo)localObject1).headUrl = paramEnterRoomReply.anchorInfo.headUrl;
      ((LiveAnchorInfo)localObject1).explicitId = paramEnterRoomReply.anchorInfo.explicitId;
      ((LiveAnchorInfo)localObject1).imsdkTinyId = paramEnterRoomReply.anchorInfo.imsdkTinyid;
      ((LiveAnchorInfo)localObject1).businessUid = paramEnterRoomReply.anchorInfo.businessUid;
    }
    paramEnterRoomInfo.anchorInfo = ((LiveAnchorInfo)localObject1);
    localObject1 = new LiveWatchMediaInfo();
    if (paramEnterRoomReply.sdkInfo != null)
    {
      Object localObject2;
      Object localObject3;
      int k;
      int i;
      switch (paramEnterRoomReply.sdkInfo.videoStatus)
      {
      default: 
        ((LiveWatchMediaInfo)localObject1).mVideoStatus = LiveVideoStatus.Unknown;
        ((LiveWatchMediaInfo)localObject1).mRtmp_url = "";
        ((LiveWatchMediaInfo)localObject1).mRtmp_url_high = "";
        ((LiveWatchMediaInfo)localObject1).mRtmp_url_low = "";
        ((LiveWatchMediaInfo)localObject1).mRtmp_url_lowest = "";
        if (paramEnterRoomReply.sdkInfo.rtmp != null)
        {
          ((LiveWatchMediaInfo)localObject1).mRtmp_url = paramEnterRoomReply.sdkInfo.rtmp.raw;
          ((LiveWatchMediaInfo)localObject1).mRtmp_url_high = paramEnterRoomReply.sdkInfo.rtmp.hd;
          ((LiveWatchMediaInfo)localObject1).mRtmp_url_low = paramEnterRoomReply.sdkInfo.rtmp.sd;
          ((LiveWatchMediaInfo)localObject1).mRtmp_url_lowest = paramEnterRoomReply.sdkInfo.rtmp.ld;
        }
        if (paramEnterRoomReply.sdkInfo.hls != null) {
          ((LiveWatchMediaInfo)localObject1).mHLS_url = paramEnterRoomReply.sdkInfo.hls.raw;
        }
        if (paramEnterRoomReply.sdkInfo.flv != null)
        {
          ((LiveWatchMediaInfo)localObject1).mFlv_url = paramEnterRoomReply.sdkInfo.flv.raw;
          ((LiveWatchMediaInfo)localObject1).mFlv_url_high = paramEnterRoomReply.sdkInfo.flv.hd;
          ((LiveWatchMediaInfo)localObject1).mFlv_url_low = paramEnterRoomReply.sdkInfo.flv.sd;
          ((LiveWatchMediaInfo)localObject1).mFlv_url_lowest = paramEnterRoomReply.sdkInfo.flv.ld;
        }
        ((LiveWatchMediaInfo)localObject1).sig = paramEnterRoomReply.sdkInfo.sig;
        ((LiveWatchMediaInfo)localObject1).sigTimeOut = paramEnterRoomReply.sdkInfo.time;
        ((LiveWatchMediaInfo)localObject1).mSdkType = paramEnterRoomReply.sdkInfo.mode;
        if (paramEnterRoomReply.sdkInfo.streamInfo == null) {
          break label995;
        }
        localObject2 = paramEnterRoomReply.sdkInfo.streamInfo;
        ((LiveWatchMediaInfo)localObject1).sugLevel = ((DesignatedStreamInfo)localObject2).sugLevel;
        if ((((DesignatedStreamInfo)localObject2).streams == null) || (((DesignatedStreamInfo)localObject2).streams.length <= 0)) {
          break label861;
        }
        localObject3 = localObject2.streams[0];
        if (localObject3 == null) {
          break label1109;
        }
        localObject2 = new ServiceStreamInfo();
        ((ServiceStreamInfo)localObject2).name = ((Stream)localObject3).name;
        ((ServiceStreamInfo)localObject2).rawLevel = ((Stream)localObject3).rawLevel;
        ((LiveWatchMediaInfo)localObject1).mLevel = ((ServiceStreamInfo)localObject2).rawLevel;
        if (((Stream)localObject3).frames != null)
        {
          localObject3 = ((Stream)localObject3).frames;
          k = localObject3.length;
          i = 0;
        }
        break;
      case 1: 
      case 5: 
      case 6: 
      case 7: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          if (i >= k) {
            break label854;
          }
          Address[] arrayOfAddress = localObject3[i];
          ServiceFrameInfo localServiceFrameInfo = new ServiceFrameInfo();
          localServiceFrameInfo.level = arrayOfAddress.level;
          if (arrayOfAddress.addresses != null)
          {
            arrayOfAddress = arrayOfAddress.addresses;
            int m = arrayOfAddress.length;
            int j = 0;
            for (;;)
            {
              if (j < m)
              {
                Address localAddress = arrayOfAddress[j];
                ServiceAddressInfo localServiceAddressInfo = new ServiceAddressInfo();
                localServiceAddressInfo.bitrate = localAddress.bitrate;
                localServiceAddressInfo.url = localAddress.url;
                localServiceFrameInfo.addresses.add(localServiceAddressInfo);
                j += 1;
                continue;
                ((LiveWatchMediaInfo)localObject1).mVideoStatus = LiveVideoStatus.Start;
                break;
                ((LiveWatchMediaInfo)localObject1).mVideoStatus = LiveVideoStatus.Stop;
                break;
                ((LiveWatchMediaInfo)localObject1).mVideoStatus = LiveVideoStatus.Pause;
                break;
                ((LiveWatchMediaInfo)localObject1).mVideoStatus = LiveVideoStatus.Stuck;
                break;
              }
            }
          }
          if (localServiceFrameInfo.level == ((LiveWatchMediaInfo)localObject1).sugLevel) {
            ((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo = localServiceFrameInfo;
          }
          ((ServiceStreamInfo)localObject2).frames.add(localServiceFrameInfo);
          i += 1;
        }
      }
      label854:
      ((LiveWatchMediaInfo)localObject1).serviceStreamInfo = ((ServiceStreamInfo)localObject2);
      label861:
      if (((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo == null) {
        break label1153;
      }
      if (((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo.addresses.size() <= 0) {
        break label1131;
      }
      ((LiveWatchMediaInfo)localObject1).mUrl = ((ServiceAddressInfo)((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo.addresses.get(0)).url;
      ((LiveWatchMediaInfo)localObject1).mUrlHigh = ((ServiceAddressInfo)((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo.addresses.get(0)).url;
      ((LiveWatchMediaInfo)localObject1).mUrlLow = ((ServiceAddressInfo)((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo.addresses.get(0)).url;
      ((LiveWatchMediaInfo)localObject1).mUrlLowest = ((ServiceAddressInfo)((LiveWatchMediaInfo)localObject1).sugServiceFrameInfo.addresses.get(0)).url;
    }
    label1153:
    for (;;)
    {
      if (paramEnterRoomReply.sdkInfo.streamInfo.switch_ == 1) {
        ((LiveWatchMediaInfo)localObject1).forceSwitch = true;
      }
      label995:
      if ((paramEnterRoomReply.sdkInfo.rtmp != null) && (TextUtils.isEmpty(((LiveWatchMediaInfo)localObject1).mUrl)))
      {
        ((LiveWatchMediaInfo)localObject1).mUrl = paramEnterRoomReply.sdkInfo.rtmp.raw;
        ((LiveWatchMediaInfo)localObject1).mUrlHigh = paramEnterRoomReply.sdkInfo.rtmp.hd;
        ((LiveWatchMediaInfo)localObject1).mUrlLow = paramEnterRoomReply.sdkInfo.rtmp.sd;
        ((LiveWatchMediaInfo)localObject1).mUrlLowest = paramEnterRoomReply.sdkInfo.rtmp.ld;
        ((LiveWatchMediaInfo)localObject1).mLevel = -1;
        if (paramLogInterface != null) {
          paramLogInterface.e("LiveInfoProvider", "liveWatchMediaInfo.mLevel = -1;", new Object[0]);
        }
      }
      paramEnterRoomInfo.watchMediaInfo = ((LiveWatchMediaInfo)localObject1);
      return paramEnterRoomInfo;
      label1109:
      if (paramLogInterface == null) {
        break;
      }
      paramLogInterface.e("LiveInfoProvider", "stream = null!!", new Object[0]);
      break;
      label1131:
      if (paramLogInterface != null)
      {
        paramLogInterface.e("LiveInfoProvider", "liveWatchMediaInfo.sugFrameInfo.addresses.size() == 0", new Object[0]);
        continue;
        if (paramLogInterface != null) {
          paramLogInterface.e("LiveInfoProvider", "liveWatchMediaInfo.sugFrameInfo = null!!", new Object[0]);
        }
      }
    }
  }
  
  public static LiveInfo parseLiveInfo(EnterRsp paramEnterRsp, EnterRoomInfo paramEnterRoomInfo)
  {
    LiveInfo localLiveInfo = new LiveInfo();
    LiveRoomInfo localLiveRoomInfo = new LiveRoomInfo();
    if (paramEnterRsp.room != null)
    {
      localLiveRoomInfo.roomId = paramEnterRsp.room.id;
      localLiveRoomInfo.roomName = paramEnterRsp.room.name;
      localLiveRoomInfo.roomLogo = paramEnterRsp.room.logo;
      localLiveRoomInfo.programId = paramEnterRsp.room.programId;
      localLiveRoomInfo.goodsNum = paramEnterRsp.room.goodsNum;
      localLiveRoomInfo.goodsUrl = paramEnterRsp.room.goodsUrl;
      localLiveRoomInfo.programId = paramEnterRsp.room.programId;
      localLiveRoomInfo.enterRoomSystemNotice = paramEnterRsp.room.systemNotice;
    }
    if (TextUtils.isEmpty(localLiveRoomInfo.programId)) {
      localLiveRoomInfo.programId = paramEnterRoomInfo.programId;
    }
    paramEnterRoomInfo = new LiveAnchorInfo();
    if (paramEnterRsp.user != null)
    {
      paramEnterRoomInfo.uid = paramEnterRsp.user.id;
      paramEnterRoomInfo.nickName = paramEnterRsp.user.name;
      paramEnterRoomInfo.explicitId = paramEnterRsp.user.explicit;
      paramEnterRoomInfo.headUrl = paramEnterRsp.user.head;
      paramEnterRoomInfo.businessUid = paramEnterRsp.user.businessUid;
      paramEnterRoomInfo.initialClientType = paramEnterRsp.user.initialClientType;
    }
    LiveMediaInfo localLiveMediaInfo = new LiveMediaInfo();
    if (paramEnterRsp.media != null)
    {
      localLiveMediaInfo.sig = paramEnterRsp.media.sig;
      localLiveMediaInfo.timeOut = paramEnterRsp.media.timeout;
    }
    paramEnterRsp = new LiveTlvInfo();
    localLiveInfo.roomInfo = localLiveRoomInfo;
    localLiveInfo.anchorInfo = paramEnterRoomInfo;
    localLiveInfo.mediaInfo = localLiveMediaInfo;
    localLiveInfo.tlvInfos = new ArrayList();
    localLiveInfo.tlvInfos.add(paramEnterRsp);
    return localLiveInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.LiveInfoProvider
 * JD-Core Version:    0.7.0.1
 */