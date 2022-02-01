package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.comment.lego.LegoNetworkRequester;

public class GetHotSortVideoHandler
{
  public boolean a;
  private String b;
  private long c;
  private String d;
  
  public GetHotSortVideoHandler(String paramString)
  {
    this.d = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler
 * JD-Core Version:    0.7.0.1
 */