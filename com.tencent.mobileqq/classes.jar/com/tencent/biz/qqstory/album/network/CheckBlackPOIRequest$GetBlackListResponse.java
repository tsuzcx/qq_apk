package com.tencent.biz.qqstory.album.network;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.List;

public class CheckBlackPOIRequest$GetBlackListResponse
  extends BaseResponse
{
  public List<qqstory_struct.GpsMsg> a;
  
  public CheckBlackPOIRequest$GetBlackListResponse(qqstory_service.RspCheckBlackList paramRspCheckBlackList)
  {
    super(paramRspCheckBlackList.result);
    this.a = paramRspCheckBlackList.black_gps_list.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.CheckBlackPOIRequest.GetBlackListResponse
 * JD-Core Version:    0.7.0.1
 */