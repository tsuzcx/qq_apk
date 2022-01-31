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
  extends NetworkRequest
{
  public long a;
  public String a;
  public String b;
  public int c;
  public int d;
  
  public GetShareGroupListRequest()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspShareVideoCollectionList localRspShareVideoCollectionList = new qqstory_service.RspShareVideoCollectionList();
    try
    {
      localRspShareVideoCollectionList.mergeFrom(paramArrayOfByte);
      return new GetShareGroupListResponse(this.b, localRspShareVideoCollectionList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:GetShareGroupListRequest", "" + paramArrayOfByte);
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localReqShareVideoCollectionList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    if (!TextUtils.isEmpty(this.b)) {
      localReqShareVideoCollectionList.union_id.set(ByteStringMicro.copyFromUtf8(this.b));
    }
    localReqShareVideoCollectionList.collection_count.set(this.c);
    localReqShareVideoCollectionList.collection_video_count.set(this.d);
    localReqShareVideoCollectionList.seqno.set(this.jdField_a_of_type_Long);
    return localReqShareVideoCollectionList.toByteArray();
  }
  
  public String toString()
  {
    return "GetShareGroupListRequest{startCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + ", collectionCount=" + this.c + ", collectionVideoCount=" + this.d + ", seqno=" + this.jdField_a_of_type_Long + ", unionId='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetShareGroupListRequest
 * JD-Core Version:    0.7.0.1
 */