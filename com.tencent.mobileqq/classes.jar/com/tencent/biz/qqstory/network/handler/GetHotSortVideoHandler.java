package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;

public class GetHotSortVideoHandler
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private String b;
  
  public GetHotSortVideoHandler(String paramString)
  {
    this.b = paramString;
  }
  
  public void a()
  {
    GetHotSortVideoHandler.GetHotSortVideoRequest localGetHotSortVideoRequest = new GetHotSortVideoHandler.GetHotSortVideoRequest(this, false);
    GetHotSortVideoHandler.GetHotSortVideoResponse localGetHotSortVideoResponse = new GetHotSortVideoHandler.GetHotSortVideoResponse(this, false);
    LegoNetworkRequester.a().a(localGetHotSortVideoRequest, localGetHotSortVideoResponse);
  }
  
  public void b()
  {
    GetHotSortVideoHandler.GetHotSortVideoRequest localGetHotSortVideoRequest = new GetHotSortVideoHandler.GetHotSortVideoRequest(this, true);
    GetHotSortVideoHandler.GetHotSortVideoResponse localGetHotSortVideoResponse = new GetHotSortVideoHandler.GetHotSortVideoResponse(this, true);
    LegoNetworkRequester.a().a(localGetHotSortVideoRequest, localGetHotSortVideoResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler
 * JD-Core Version:    0.7.0.1
 */