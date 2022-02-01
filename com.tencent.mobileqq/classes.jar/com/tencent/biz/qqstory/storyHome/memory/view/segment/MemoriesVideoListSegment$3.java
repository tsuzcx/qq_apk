package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.support.logging.SLog;

class MemoriesVideoListSegment$3
  implements Runnable
{
  MemoriesVideoListSegment$3(MemoriesVideoListSegment paramMemoriesVideoListSegment, int paramInt, VideoCollectionItem paramVideoCollectionItem, String paramString) {}
  
  public void run()
  {
    SLog.b("Q.qqstory.memories.MemoriesVideoListSegment", "doScrollHorizal, findViewHolder, null, waiting done");
    MemoriesVideoListSegment.a(this.this$0, this.a, this.b, this.c, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.3
 * JD-Core Version:    0.7.0.1
 */