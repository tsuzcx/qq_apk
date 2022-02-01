package com.tencent.biz.qqstory.album.network;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckBlackList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckBlackList;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CheckBlackPOIRequest
  extends NetworkRequest<CheckBlackPOIRequest.GetBlackListResponse>
{
  private static final String jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.check_location_blacklist");
  private List<GeoHashUtils.Gps> jdField_a_of_type_JavaUtilList;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspCheckBlackList localRspCheckBlackList = new qqstory_service.RspCheckBlackList();
    try
    {
      localRspCheckBlackList.mergeFrom(paramArrayOfByte);
      return new CheckBlackPOIRequest.GetBlackListResponse(localRspCheckBlackList);
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
  
  protected byte[] a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = new qqstory_service.ReqCheckBlackList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GeoHashUtils.Gps)localIterator.next()).a());
      }
      ((qqstory_service.ReqCheckBlackList)localObject).gps_list.addAll(localArrayList);
      return ((qqstory_service.ReqCheckBlackList)localObject).toByteArray();
    }
    Object localObject = new QQStoryCmdHandler.IllegalUinException("req gps list is null");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.network.CheckBlackPOIRequest
 * JD-Core Version:    0.7.0.1
 */