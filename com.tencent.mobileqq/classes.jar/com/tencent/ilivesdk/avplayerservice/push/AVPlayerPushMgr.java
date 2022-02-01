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
    if (this.mPlayerStatusListener == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "videoPushDispatcher,dispatcher,event.operType:" + paramVideoBroadcastEvent.operType, new Object[0]);
                    if (paramVideoBroadcastEvent.operType != -2) {
                      break;
                    }
                    this.mVideoStatus = VideoStatus.STOP;
                  } while (this.mPlayerStatusListener == null);
                  this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "PhonePlayer,videoPushDispatcher,dispatcher,onPlayOver:", new Object[0]);
                  this.mPlayerStatusListener.onPushPlayOver();
                  return;
                  if (paramVideoBroadcastEvent.operType != 0) {
                    break;
                  }
                  this.mVideoStatus = VideoStatus.PLAY;
                } while (this.mPlayerStatusListener == null);
                this.mPlayerStatusListener.onPlayResume(paramVideoBroadcastEvent.uin);
                return;
                if (paramVideoBroadcastEvent.operType != 2) {
                  break;
                }
                this.mVideoStatus = VideoStatus.PAUSE;
              } while (this.mPlayerStatusListener == null);
              this.mPlayerStatusListener.onPlayPause(paramVideoBroadcastEvent.uin);
              return;
              if (paramVideoBroadcastEvent.operType != 3) {
                break;
              }
              this.mVideoStatus = VideoStatus.PLAY;
            } while ((paramVideoBroadcastEvent.avTypeChange != 0) && (this.mPlayerStatusListener == null));
            this.mPlayerStatusListener.onPlayResume(paramVideoBroadcastEvent.uin);
            return;
          } while (paramVideoBroadcastEvent.operType == 6);
          if (paramVideoBroadcastEvent.operType != 7) {
            break;
          }
          this.mVideoQuality = VideoQuality.CATON;
        } while (this.mPlayerStatusListener == null);
        this.mPlayerStatusListener.onPlayCaton();
        return;
      } while (paramVideoBroadcastEvent.operType != 8);
      this.mVideoStatus = VideoStatus.PLAY;
      this.mVideoQuality = VideoQuality.OK;
      this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "video OK", new Object[0]);
    } while (this.mPlayerStatusListener == null);
    this.mPlayerStatusListener.onPlayCatonRecover();
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
    int i = 0;
    this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "processPushMsg:", new Object[0]);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = IOUtil.readWLenData(paramArrayOfByte, true);
        if ((localObject == null) || (localObject.length == 0))
        {
          this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "pb length is invalid!", new Object[0]);
          return;
        }
        paramArrayOfByte = new ProtocolVideoState.RoomVideoStateBroadcast();
        paramArrayOfByte.mergeFrom((byte[])localObject);
        long l = paramArrayOfByte.RoomID.get();
        if (l != this.mServiceAdapter.getRoomId()) {
          break;
        }
        this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "processPushMsg,rid:" + l + " roomid:" + this.mServiceAdapter.getRoomId() + " mRoomType=" + this.mServiceAdapter.getRoomType(), new Object[0]);
        localObject = new VideoBroadcastEvent();
        ((VideoBroadcastEvent)localObject).uin = paramArrayOfByte.Uin.get();
        ((VideoBroadcastEvent)localObject).operType = paramArrayOfByte.OperType.get();
        ((VideoBroadcastEvent)localObject).liveType = paramArrayOfByte.LiveType.get();
        ((VideoBroadcastEvent)localObject).avTypeChange = paramArrayOfByte.av_type_change.get();
        this.mServiceAdapter.getLogger().i("AVPlayerPushMgr", "processPushMsg,rvsb.OperType.get():" + paramArrayOfByte.OperType.get() + "-rvsb.LiveType.get():" + paramArrayOfByte.LiveType.get(), new Object[0]);
        if (paramArrayOfByte.CloseType.has()) {
          i = paramArrayOfByte.CloseType.get();
        }
        ((VideoBroadcastEvent)localObject).OperReasonType = i;
        ((VideoBroadcastEvent)localObject).OperReasonNote = paramArrayOfByte.CloseDescription.get().toStringUtf8();
        if (((VideoBroadcastEvent)localObject).operType == 0) {
          ((VideoBroadcastEvent)localObject).operType = -2;
        }
        if (((VideoBroadcastEvent)localObject).OperReasonType == 10)
        {
          ((VideoBroadcastEvent)localObject).operType = 6;
          this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "violate supervise", new Object[0]);
          ThreadCenter.postDefaultUITask(new AVPlayerPushMgr.2(this, (VideoBroadcastEvent)localObject));
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        this.mServiceAdapter.getLogger().printStackTrace(paramArrayOfByte);
        return;
      }
      if (!paramArrayOfByte.PlayingInfos.has())
      {
        ((VideoBroadcastEvent)localObject).operType = -2;
        this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "has none live playing info", new Object[0]);
      }
      else if ((!paramArrayOfByte.VideoChanel.has()) || (paramArrayOfByte.VideoChanel.get() != 0))
      {
        this.mServiceAdapter.getLogger().w("AVPlayerPushMgr", "video channel %d not supported!", new Object[] { Integer.valueOf(paramArrayOfByte.VideoChanel.get()) });
      }
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
    if (this.roomPushReceiver0x4a != null) {
      this.roomPushReceiver0x4a.unInit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.AVPlayerPushMgr
 * JD-Core Version:    0.7.0.1
 */