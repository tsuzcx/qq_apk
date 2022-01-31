package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import tcz;

public class StoryManager$3
  implements Runnable
{
  public StoryManager$3(tcz paramtcz, String paramString) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = this.this$0.a(this.a);
    if (localStoryVideoItem != null)
    {
      localStoryVideoItem.mHadRead = 1;
      this.this$0.a(this.a, localStoryVideoItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.3
 * JD-Core Version:    0.7.0.1
 */