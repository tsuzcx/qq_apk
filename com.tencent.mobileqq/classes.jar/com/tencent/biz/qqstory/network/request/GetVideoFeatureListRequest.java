package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchVideoFeatureList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchVideoFeatureList;
import com.tencent.biz.qqstory.network.response.GetVideoFeatureListResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVideoFeatureListRequest
  extends NetworkRequest
{
  public String a;
  public List a;
  
  public GetVideoFeatureListRequest()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchVideoFeatureList localRspGetBatchVideoFeatureList = new qqstory_service.RspGetBatchVideoFeatureList();
    try
    {
      localRspGetBatchVideoFeatureList.mergeFrom(paramArrayOfByte);
      return new GetVideoFeatureListResponse(localRspGetBatchVideoFeatureList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.player:GetVideoFeatureListRequest", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.get_batch_video_feature_desc");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqGetBatchVideoFeatureList localReqGetBatchVideoFeatureList = new qqstory_service.ReqGetBatchVideoFeatureList();
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
    }
    localReqGetBatchVideoFeatureList.vid_list.addAll(localArrayList);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localReqGetBatchVideoFeatureList.union_id.set(ByteStringMicro.copyFromUtf8(a(this.jdField_a_of_type_JavaLangString)));
    }
    return localReqGetBatchVideoFeatureList.toByteArray();
  }
  
  public String toString()
  {
    return "GetVideoBasicInfoListRequest{vidList='" + this.jdField_a_of_type_JavaUtilList + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVideoFeatureListRequest
 * JD-Core Version:    0.7.0.1
 */