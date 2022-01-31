package com.tencent.biz.videostory.network.request;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicReq;
import NS_QQ_STORY_CLIENT.CLIENT.StSmartMatchMusicRsp;
import bcez;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;

public class SmartMusicMatchRequest
  extends VSBaseRequest
{
  private static final long serialVersionUID = 6159666206339855822L;
  private final CLIENT.StSmartMatchMusicReq req = new CLIENT.StSmartMatchMusicReq();
  
  public SmartMusicMatchRequest(ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, SosoInterface.SosoLocation paramSosoLocation, boolean paramBoolean, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramSosoLocation != null)
    {
      this.req.fLat.set(paramSosoLocation.a);
      this.req.fLon.set(paramSosoLocation.b);
    }
    paramSosoLocation = this.req.videoType;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramSosoLocation.set(i);
      this.req.cameraType.set(paramInt);
      if ((paramBoolean) && (paramLocalMediaInfo != null))
      {
        this.req.videoLat.set(paramLocalMediaInfo.latitude / 1000000.0D);
        this.req.videoLon.set(paramLocalMediaInfo.longitude / 1000000.0D);
        this.req.videoTime.set(paramLocalMediaInfo.addedDate);
      }
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramSosoLocation = ((FrameVideoHelper.FrameBuffer)paramArrayList.next()).getData();
        this.req.vecPicBuff.add(ByteStringMicro.copyFrom(paramSosoLocation));
      }
    }
    paramArrayList = new COMM.Entry();
    paramArrayList.key.set("wifi_mac");
    paramArrayList.value.set(bcez.a());
    this.req.extInfo.mapInfo.add(paramArrayList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CLIENT.StSmartMatchMusicRsp localStSmartMatchMusicRsp = new CLIENT.StSmartMatchMusicRsp();
    localStSmartMatchMusicRsp.mergeFrom(paramArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.SmartMusicMatchRequest
 * JD-Core Version:    0.7.0.1
 */