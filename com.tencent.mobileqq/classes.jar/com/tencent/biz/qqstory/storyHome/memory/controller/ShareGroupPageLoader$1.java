package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import wad;
import wjf;
import wjs;
import yai;
import yaj;
import ykq;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wjf)wjs.a(19)).b(this.this$0.a);
    yaj localyaj = new yaj(new ErrorMessage(), yai.a(this.this$0));
    localyaj.b = true;
    localyaj.jdField_a_of_type_Boolean = true;
    localyaj.c = true;
    localyaj.jdField_a_of_type_JavaUtilList = ((List)???);
    localyaj.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        wad.a().dispatch(localyaj);
        ykq.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localyaj);
        return;
      }
      ykq.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */