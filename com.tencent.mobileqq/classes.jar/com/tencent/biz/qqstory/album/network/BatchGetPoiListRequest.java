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
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.batch_get_poi_list");
  private List<GeoHashUtils.Gps> jdField_a_of_type_JavaUtilList;
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
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
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a(@NonNull List<GeoHashUtils.Gps> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public byte[] a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      throw new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    }
    if ((QLog.isDebugVersion()) && (this.jdField_a_of_type_JavaUtilList.size() > 100)) {
      throw new QQStoryCmdHandler.IllegalUinException("over LIMIT_MX data to send LIMIT_MX=100");
    }
    qqstory_service.ReqBatchGetPOIList localReqBatchGetPOIList = new qqstory_service.ReqBatchGetPOIList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((GeoHashUtils.Gps)localIterator.next()).a());
    }
    localReqBatchGetPOIList.gps.addAll(localArrayList);
    return localReqBatchGetPOIList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.BatchGetPoiListRequest
 * JD-Core Version:    0.7.0.1
 */