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
  public static final String e = StoryApi.a("StorySvc.get_colleciton_view_count");
  public String f;
  public List<UpdateCollectionViewCountHandler.CollectionID> g = new ArrayList();
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
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
    return new UpdateCollectionViewCountResponse(this.f, localRspCollectionViewCount);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqCollectionViewCount localReqCollectionViewCount = new qqstory_service.ReqCollectionViewCount();
    Iterator localIterator = this.g.iterator();
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
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.UpdateCollectionViewCountRequest
 * JD-Core Version:    0.7.0.1
 */