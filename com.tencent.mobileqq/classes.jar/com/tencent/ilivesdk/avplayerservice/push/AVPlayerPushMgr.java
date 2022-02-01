package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.falco.base.libapi.channel.helper.PushReceiver;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.IOUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.avplayerservice.state.VideoQuality;
import com.tencent.ilivesdk.avplayerservice.state.VideoStatus;
import com.tencent.ilivesdk.avplayerservice_interface.AVPlayerServiceAdapter;
import com.tencent.ilivesdk.avplayerservice_interface.PlayerStatusListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AVPlayerPushMgr
{
  private final String TAG = "AVPlayerPushMgr";
  private PlayerStatusListener mPlayerStatusListener;
  private AVPlayerServiceAdapter mServiceAdapter;
  protected VideoQuality mVideoQuality = VideoQuality.OK;
  protected VideoStatus mVideoStatus = VideoStatus.STOP;
  private PushReceiver roomPushReceiver0x4a;
  
  public AVPlayerPushMgr(AVPlayerServiceAdapter paramAVPlayerServiceAdapter)
  {
    this.mServiceAdapter = paramAVPlayerServiceAdapter;
  }
  
  private void dispatcher(VideoBroadcastEvent paramVideoBroadcastEvent)
  {
    if (this.mPlayerStatusListener == null) {
      return;
    }
    Object localObject = this.mServiceAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("videoPushDispatcher,dispatcher,event.operType:");
    localStringBuilder.append(paramVideoBroadcastEvent.operType);
    ((LogInterface)localObject).i("AVPlayerPushMgr", localStringBuilder.toString(), new Object[0]);
    if (paramVideoBroadcastEvent.operType == -2)
    {
      this.mVideoStatus = VideoStatus.STOP;
      if (this.mPlayerStatusListener != null)
      {
        this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "PhonePlayer,videoPushDispatcher,dispatcher,onPlayOver:", new Object[0]);
        this.mPlayerStatusListener.onPushPlayOver();
      }
    }
    else if (paramVideoBroadcastEvent.operType == 0)
    {
      this.mVideoStatus = VideoStatus.PLAY;
      localObject = this.mPlayerStatusListener;
      if (localObject != null) {
        ((PlayerStatusListener)localObject).onPlayResume(paramVideoBroadcastEvent.uin);
      }
    }
    else if (paramVideoBroadcastEvent.operType == 2)
    {
      this.mVideoStatus = VideoStatus.PAUSE;
      localObject = this.mPlayerStatusListener;
      if (localObject != null) {
        ((PlayerStatusListener)localObject).onPlayPause(paramVideoBroadcastEvent.uin);
      }
    }
    else if (paramVideoBroadcastEvent.operType == 3)
    {
      this.mVideoStatus = VideoStatus.PLAY;
      int i = paramVideoBroadcastEvent.avTypeChange;
      localObject = this.mPlayerStatusListener;
      if (localObject != null) {
        ((PlayerStatusListener)localObject).onPlayResume(paramVideoBroadcastEvent.uin);
      }
    }
    else
    {
      if (paramVideoBroadcastEvent.operType == 6) {
        return;
      }
      if (paramVideoBroadcastEvent.operType == 7)
      {
        this.mVideoQuality = VideoQuality.CATON;
        paramVideoBroadcastEvent = this.mPlayerStatusListener;
        if (paramVideoBroadcastEvent != null) {
          paramVideoBroadcastEvent.onPlayCaton();
        }
      }
      else if (paramVideoBroadcastEvent.operType == 8)
      {
        this.mVideoStatus = VideoStatus.PLAY;
        this.mVideoQuality = VideoQuality.OK;
        this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "video OK", new Object[0]);
        paramVideoBroadcastEvent = this.mPlayerStatusListener;
        if (paramVideoBroadcastEvent != null) {
          paramVideoBroadcastEvent.onPlayCatonRecover();
        }
      }
    }
  }
  
  private void initVideoPush()
  {
    this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "--initVideoPush--", new Object[0]);
    PushReceiver localPushReceiver = this.mServiceAdapter.createPushReceiver();
    if (localPushReceiver != null) {
      this.roomPushReceiver0x4a = localPushReceiver.init(75, new AVPlayerPushMgr.1(this));
    }
  }
  
  private void processPushMsg0x4a(byte[] paramArrayOfByte)
  {
    this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "processPushMsg:", new Object[0]);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    for (;;)
    {
      try
      {
        Object localObject1 = IOUtil.readWLenData(paramArrayOfByte, true);
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          paramArrayOfByte = new ProtocolVideoState.RoomVideoStateBroadcast();
          paramArrayOfByte.mergeFrom((byte[])localObject1);
          long l = paramArrayOfByte.RoomID.get();
          if (l != this.mServiceAdapter.getRoomId()) {
            return;
          }
          localObject1 = this.mServiceAdapter.getLogger();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("processPushMsg,rid:");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(" roomid:");
          ((StringBuilder)localObject2).append(this.mServiceAdapter.getRoomId());
          ((StringBuilder)localObject2).append(" mRoomType=");
          ((StringBuilder)localObject2).append(this.mServiceAdapter.getRoomType());
          ((LogInterface)localObject1).i("AVPlayerPushMgr", ((StringBuilder)localObject2).toString(), new Object[0]);
          localObject1 = new VideoBroadcastEvent();
          ((VideoBroadcastEvent)localObject1).uin = paramArrayOfByte.Uin.get();
          ((VideoBroadcastEvent)localObject1).operType = paramArrayOfByte.OperType.get();
          ((VideoBroadcastEvent)localObject1).liveType = paramArrayOfByte.LiveType.get();
          ((VideoBroadcastEvent)localObject1).avTypeChange = paramArrayOfByte.av_type_change.get();
          localObject2 = this.mServiceAdapter.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("processPushMsg,rvsb.OperType.get():");
          localStringBuilder.append(paramArrayOfByte.OperType.get());
          localStringBuilder.append("-rvsb.LiveType.get():");
          localStringBuilder.append(paramArrayOfByte.LiveType.get());
          ((LogInterface)localObject2).i("AVPlayerPushMgr", localStringBuilder.toString(), new Object[0]);
          if (paramArrayOfByte.CloseType.has())
          {
            i = paramArrayOfByte.CloseType.get();
            ((VideoBroadcastEvent)localObject1).OperReasonType = i;
            ((VideoBroadcastEvent)localObject1).OperReasonNote = paramArrayOfByte.CloseDescription.get().toStringUtf8();
            if (((VideoBroadcastEvent)localObject1).operType == 0) {
              ((VideoBroadcastEvent)localObject1).operType = -2;
            }
            if (((VideoBroadcastEvent)localObject1).OperReasonType == 10)
            {
              ((VideoBroadcastEvent)localObject1).operType = 6;
              this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "violate supervise", new Object[0]);
            }
            else if (!paramArrayOfByte.PlayingInfos.has())
            {
              ((VideoBroadcastEvent)localObject1).operType = -2;
              this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "has none live playing info", new Object[0]);
            }
            else if ((!paramArrayOfByte.VideoChanel.has()) || (paramArrayOfByte.VideoChanel.get() != 0))
            {
              this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "video channel %d not supported!", new Object[] { Integer.valueOf(paramArrayOfByte.VideoChanel.get()) });
            }
            ThreadCenter.postDefaultUITask(new AVPlayerPushMgr.2(this, (VideoBroadcastEvent)localObject1));
          }
        }
        else
        {
          this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "pb length is invalid!", new Object[0]);
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        this.mServiceAdapter.getLogger().printStackTrace(paramArrayOfByte);
        return;
      }
      int i = 0;
    }
  }
  
  public void addPlayerStatusListener(PlayerStatusListener paramPlayerStatusListener)
  {
    this.mPlayerStatusListener = paramPlayerStatusListener;
  }
  
  public void init()
  {
    initVideoPush();
  }
  
  public void unInit()
  {
    PushReceiver localPushReceiver = this.roomPushReceiver0x4a;
    if (localPushReceiver != null) {
      localPushReceiver.unInit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.AVPlayerPushMgr
 * JD-Core Version:    0.7.0.1
 */