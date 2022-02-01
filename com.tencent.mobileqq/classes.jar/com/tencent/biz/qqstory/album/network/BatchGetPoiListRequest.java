package com.tencent.biz.qqstory.album.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqBatchGetPOIList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchGetPOIList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetPoiListRequest
  extends NetworkRequest<BatchGetPoiListRequest.BatchGetPoiListResponse>
{
  private static final String e = StoryApi.a("StorySvc.batch_get_poi_list");
  private List<GeoHashUtils.Gps> f;
  
  public BatchGetPoiListRequest.BatchGetPoiListResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspBatchGetPOIList localRspBatchGetPOIList = new qqstory_service.RspBatchGetPOIList();
    try
    {
      localRspBatchGetPOIList.mergeFrom(paramArrayOfByte);
      return new BatchGetPoiListRequest.BatchGetPoiListResponse(localRspBatchGetPOIList);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return e;
  }
  
  public void a(@NonNull List<GeoHashUtils.Gps> paramList)
  {
    this.f = paramList;
  }
  
  public int b()
  {
    List localList = this.f;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  protected byte[] c()
  {
    Object localObject = this.f;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      if ((QLog.isDebugVersion()) && (this.f.size() > 100)) {
        throw new QQStoryCmdHandler.IllegalUinException("over LIMIT_MX data to send LIMIT_MX=100");
      }
      localObject = new qqstory_service.ReqBatchGetPOIList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GeoHashUtils.Gps)localIterator.next()).c());
      }
      ((qqstory_service.ReqBatchGetPOIList)localObject).gps.addAll(localArrayList);
      return ((qqstory_service.ReqBatchGetPOIList)localObject).toByteArray();
    }
    localObject = new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.BatchGetPoiListRequest
 * JD-Core Version:    0.7.0.1
 */