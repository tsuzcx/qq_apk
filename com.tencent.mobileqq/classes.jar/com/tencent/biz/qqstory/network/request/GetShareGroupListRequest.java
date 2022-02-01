package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.biz.qqstory.network.response.GetShareGroupListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetShareGroupListRequest
  extends NetworkRequest<GetShareGroupListResponse>
{
  public String e = "";
  public int f;
  public int g;
  public long h;
  public String i;
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_share_group_collection_list");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspShareVideoCollectionList();
    try
    {
      ((qqstory_service.RspShareVideoCollectionList)localObject).mergeFrom(paramArrayOfByte);
      return new GetShareGroupListResponse(this.i, (qqstory_service.RspShareVideoCollectionList)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("Q.qqstory:GetShareGroupListRequest", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqShareVideoCollectionList localReqShareVideoCollectionList = new qqstory_service.ReqShareVideoCollectionList();
    if (!TextUtils.isEmpty(this.e)) {
      localReqShareVideoCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.e));
    }
    if (!TextUtils.isEmpty(this.i)) {
      localReqShareVideoCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.i));
    }
    localReqShareVideoCollectionList.collection_count.set(this.f);
    localReqShareVideoCollectionList.collection_video_count.set(this.g);
    localReqShareVideoCollectionList.seqno.set(this.h);
    return localReqShareVideoCollectionList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupListRequest{startCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", collectionCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", collectionVideoCount=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", seqno=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupListRequest
 * JD-Core Version:    0.7.0.1
 */