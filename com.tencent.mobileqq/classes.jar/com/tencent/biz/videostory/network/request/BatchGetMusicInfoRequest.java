package com.tencent.biz.videostory.network.request;

import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoReq;
import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;

public class BatchGetMusicInfoRequest
  extends VSBaseRequest
{
  private final CLIENT.StBatchGetMusicInfoReq req = new CLIENT.StBatchGetMusicInfoReq();
  
  public BatchGetMusicInfoRequest(ArrayList<String> paramArrayList)
  {
    this.req.needLyric.set(1);
    this.req.vecSongMid.set(paramArrayList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    CLIENT.StBatchGetMusicInfoRsp localStBatchGetMusicInfoRsp = new CLIENT.StBatchGetMusicInfoRsp();
    localStBatchGetMusicInfoRsp.mergeFrom(paramArrayOfByte);
    return localStBatchGetMusicInfoRsp;
  }
  
  public String getCmdName()
  {
    return "LightAppSvc.qq_story_client.BatchGetMusicInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.request.BatchGetMusicInfoRequest
 * JD-Core Version:    0.7.0.1
 */