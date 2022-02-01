package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import wfo;
import woz;
import wpm;
import ygh;
import ygi;
import yqp;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((woz)wpm.a(19)).b(this.this$0.a);
    ygi localygi = new ygi(new ErrorMessage(), ygh.a(this.this$0));
    localygi.b = true;
    localygi.jdField_a_of_type_Boolean = true;
    localygi.c = true;
    localygi.jdField_a_of_type_JavaUtilList = ((List)???);
    localygi.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        wfo.a().dispatch(localygi);
        yqp.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localygi);
        return;
      }
      yqp.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */