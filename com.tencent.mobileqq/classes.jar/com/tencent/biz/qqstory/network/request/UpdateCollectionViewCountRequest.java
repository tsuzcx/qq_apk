package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.handler.UpdateCollectionViewCountHandler.CollectionID;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCollectionViewCount;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount;
import com.tencent.biz.qqstory.network.response.UpdateCollectionViewCountResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateCollectionViewCountRequest
  extends NetworkRequest<UpdateCollectionViewCountResponse>
{
  public static final String a;
  public List<UpdateCollectionViewCountHandler.CollectionID> a;
  public String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.get_colleciton_view_count");
  }
  
  public UpdateCollectionViewCountRequest()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCollectionViewCount localRspCollectionViewCount = new qqstory_service.RspCollectionViewCount();
    try
    {
      localRspCollectionViewCount.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory:UpdateCollectionViewCountRequest", paramArrayOfByte.toString());
    }
    return new UpdateCollectionViewCountResponse(this.b, localRspCollectionViewCount);
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqCollectionViewCount localReqCollectionViewCount = new qqstory_service.ReqCollectionViewCount();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      UpdateCollectionViewCountHandler.CollectionID localCollectionID = (UpdateCollectionViewCountHandler.CollectionID)localIterator.next();
      localReqCollectionViewCount.collection_id.add(localCollectionID.a());
    }
    return localReqCollectionViewCount.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateCollectionViewCountRequest{mIdList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.UpdateCollectionViewCountRequest
 * JD-Core Version:    0.7.0.1
 */