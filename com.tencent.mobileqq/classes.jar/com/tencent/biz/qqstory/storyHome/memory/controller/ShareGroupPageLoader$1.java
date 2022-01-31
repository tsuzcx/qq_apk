package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import uht;
import ure;
import urr;
import win;
import wio;
import wsv;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((ure)urr.a(19)).b(this.this$0.a);
    wio localwio = new wio(new ErrorMessage(), win.a(this.this$0));
    localwio.b = true;
    localwio.jdField_a_of_type_Boolean = true;
    localwio.c = true;
    localwio.jdField_a_of_type_JavaUtilList = ((List)???);
    localwio.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        uht.a().dispatch(localwio);
        wsv.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localwio);
        return;
      }
      wsv.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */