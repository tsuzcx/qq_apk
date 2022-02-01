package com.tencent.biz.richframework.network.request;

import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicReq;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.ArrayList;

public class SmartMusicMatchRequest
  extends VSBaseRequest
{
  private static final int VIDEO_LOCATION_DIVIDE = 1000000;
  private static final long serialVersionUID = 6159666206339855822L;
  private final CLIENT.StSmartMatchMusicReq req;
  
  public SmartMusicMatchRequest(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, SosoLocation paramSosoLocation, boolean paramBoolean, int paramInt, LocalMediaInfo paramLocalMediaInfo) {}
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CLIENT.StSmartMatchMusicRsp localStSmartMatchMusicRsp = new CLIENT.StSmartMatchMusicRsp();
    try
    {
      localStSmartMatchMusicRsp.mergeFrom(paramArrayOfByte);
      return localStSmartMatchMusicRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStSmartMatchMusicRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.qq_story_client.SmartMatchMusic";
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