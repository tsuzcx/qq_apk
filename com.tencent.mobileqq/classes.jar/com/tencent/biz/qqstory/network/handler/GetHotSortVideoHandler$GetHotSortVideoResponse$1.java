package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.HotSortVideoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;

class GetHotSortVideoHandler$GetHotSortVideoResponse$1
  implements Runnable
{
  GetHotSortVideoHandler$GetHotSortVideoResponse$1(GetHotSortVideoHandler.GetHotSortVideoResponse paramGetHotSortVideoResponse, ArrayList paramArrayList, GetHotSortVideoHandler.GetVideoByHotSortEvent paramGetVideoByHotSortEvent) {}
  
  public void run()
  {
    ((HotSortVideoManager)SuperManager.a(25)).a(this.a, GetHotSortVideoHandler.a(this.c.c), true);
    this.b.a = this.a;
    StoryDispatcher.a().dispatch(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoResponse.1
 * JD-Core Version:    0.7.0.1
 */