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
  public String a = "";
  public long b;
  public String b;
  public int c;
  public int d;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspShareVideoCollectionList();
    try
    {
      ((qqstory_service.RspShareVideoCollectionList)localObject).mergeFrom(paramArrayOfByte);
      return new GetShareGroupListResponse(this.jdField_b_of_type_JavaLangString, (qqstory_service.RspShareVideoCollectionList)localObject);
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
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_share_group_collection_list");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqShareVideoCollectionList localReqShareVideoCollectionList = new qqstory_service.ReqShareVideoCollectionList();
    if (!TextUtils.isEmpty(this.a)) {
      localReqShareVideoCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.a));
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localReqShareVideoCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.jdField_b_of_type_JavaLangString));
    }
    localReqShareVideoCollectionList.collection_count.set(this.c);
    localReqShareVideoCollectionList.collection_video_count.set(this.d);
    localReqShareVideoCollectionList.seqno.set(this.jdField_b_of_type_Long);
    return localReqShareVideoCollectionList.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupListRequest{startCookie='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", collectionCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", collectionVideoCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", seqno=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupListRequest
 * JD-Core Version:    0.7.0.1
 */