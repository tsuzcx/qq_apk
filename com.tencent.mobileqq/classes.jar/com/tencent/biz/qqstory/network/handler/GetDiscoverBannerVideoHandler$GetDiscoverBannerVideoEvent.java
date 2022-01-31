package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse;
import java.util.List;

public class GetDiscoverBannerVideoHandler$GetDiscoverBannerVideoEvent
  extends BaseEvent
{
  public GetDiscoverBannerVideoResponse a;
  
  public GetDiscoverBannerVideoHandler$GetDiscoverBannerVideoEvent(GetDiscoverBannerVideoResponse paramGetDiscoverBannerVideoResponse)
  {
    this.a = paramGetDiscoverBannerVideoResponse;
  }
  
  public String toString()
  {
    if (this.a == null) {
      return super.toString();
    }
    return "GetDiscoverBannerVideoEvent{, vidSize=" + this.a.jdField_a_of_type_JavaUtilList.size() + ", feedIdSize=" + this.a.jdField_b_of_type_JavaUtilList.size() + ", totalCount=" + this.a.jdField_b_of_type_Int + ", isEnd=" + this.a.jdField_a_of_type_Boolean + ", nextCookie=" + this.a.jdField_a_of_type_JavaLangString + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetDiscoverBannerVideoHandler.GetDiscoverBannerVideoEvent
 * JD-Core Version:    0.7.0.1
 */