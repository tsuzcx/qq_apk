package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;

class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((MemoryManager)SuperManager.a(19)).b(this.this$0.jdField_b_of_type_JavaLangString);
    ShareGroupPageLoader.GetShareGroupListEvent localGetShareGroupListEvent = new ShareGroupPageLoader.GetShareGroupListEvent(new ErrorMessage(), ShareGroupPageLoader.a(this.this$0));
    localGetShareGroupListEvent.jdField_b_of_type_Boolean = true;
    localGetShareGroupListEvent.jdField_a_of_type_Boolean = true;
    localGetShareGroupListEvent.c = true;
    localGetShareGroupListEvent.jdField_a_of_type_JavaUtilList = ((List)???);
    localGetShareGroupListEvent.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.jdField_b_of_type_Boolean)
      {
        StoryDispatcher.a().dispatch(localGetShareGroupListEvent);
        SLog.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localGetShareGroupListEvent);
      }
      else
      {
        SLog.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */