package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.Cmd2HandlerMap;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import java.util.Map;
import java.util.Random;
import mqq.app.MSFServlet;

public class VideoFeedsService
  extends MobileQQServiceBase
{
  VideoFeedsAppInterface jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface;
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  
  VideoFeedsService(VideoFeedsAppInterface paramVideoFeedsAppInterface)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface = paramVideoFeedsAppInterface;
    seq = Math.abs(this.jdField_a_of_type_JavaUtilRandom.nextInt());
  }
  
  public AppInterface getAppInterface()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAppInterface;
  }
  
  public Map<String, String[]> getCompatibleCmd2HandlerMap()
  {
    return Cmd2HandlerMap.a();
  }
  
  public Class<? extends MSFServlet> getServlet()
  {
    return VideoFeedsServlet.class;
  }
  
  public void initCoders()
  {
    try
    {
      super.initCoders();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsService
 * JD-Core Version:    0.7.0.1
 */