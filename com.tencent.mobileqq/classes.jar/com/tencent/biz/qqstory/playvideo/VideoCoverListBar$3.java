package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

class VideoCoverListBar$3
  implements Runnable
{
  VideoCoverListBar$3(VideoCoverListBar paramVideoCoverListBar, int paramInt) {}
  
  public void run()
  {
    VideoCoverListBar localVideoCoverListBar = this.this$0;
    localVideoCoverListBar.smoothScrollToPositionFromTop(this.a, VideoCoverListBar.b(localVideoCoverListBar) + VideoCoverListBar.c(this.this$0));
    SLog.a("Q.qqstory.player:VideoCoverListBar", "notify cover list changed , new index = %d , total size = %d", Integer.valueOf(this.a), Integer.valueOf(VideoCoverListBar.d(this.this$0).size()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.3
 * JD-Core Version:    0.7.0.1
 */