package com.tencent.biz.richframework.network.request;

import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.ArrayList;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicReq;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class SmartMusicMatchRequest
  extends VSBaseRequest
{
  private static final int VIDEO_LOCATION_DIVIDE = 1000000;
  private static final long serialVersionUID = 6159666206339855822L;
  private final QQCircleSmartMatchMusic.SmartMatchMusicReq req;
  
  public SmartMusicMatchRequest(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, SosoLocation paramSosoLocation, boolean paramBoolean, int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSmartMatchMusic.SmartMatchMusicRsp localSmartMatchMusicRsp = new QQCircleSmartMatchMusic.SmartMatchMusicRsp();
    try
    {
      localSmartMatchMusicRsp.mergeFrom(paramArrayOfByte);
      return localSmartMatchMusicRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSmartMatchMusicRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMatchMusic";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.SmartMusicMatchRequest
 * JD-Core Version:    0.7.0.1
 */