package com.tencent.biz.qqstory.playmode.util;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.response.GetCollectionVideoListResponse;

class PlayModeUtils$6$1
  implements Runnable
{
  PlayModeUtils$6$1(PlayModeUtils.6 param6, GetCollectionVideoListResponse paramGetCollectionVideoListResponse, ErrorMessage paramErrorMessage) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b.isSuccess()))
    {
      this.this$0.a.a(this.a.f);
      return;
    }
    this.this$0.a.a(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.6.1
 * JD-Core Version:    0.7.0.1
 */