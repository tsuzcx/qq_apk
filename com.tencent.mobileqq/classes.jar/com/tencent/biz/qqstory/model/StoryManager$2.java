package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.mobileqq.persistence.EntityManager;

class StoryManager$2
  implements Runnable
{
  StoryManager$2(StoryManager paramStoryManager, EntityManager paramEntityManager, StoryEntry paramStoryEntry, String paramString, int paramInt) {}
  
  public void run()
  {
    this.a.remove(this.b, StoryEntry.getUidSelectionNoArg(), new String[] { String.valueOf(this.c), String.valueOf(this.d) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.StoryManager.2
 * JD-Core Version:    0.7.0.1
 */