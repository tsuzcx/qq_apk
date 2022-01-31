package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import umc;
import uvn;
import uwa;
import wmw;
import wmx;
import wxe;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((uvn)uwa.a(19)).b(this.this$0.a);
    wmx localwmx = new wmx(new ErrorMessage(), wmw.a(this.this$0));
    localwmx.b = true;
    localwmx.jdField_a_of_type_Boolean = true;
    localwmx.c = true;
    localwmx.jdField_a_of_type_JavaUtilList = ((List)???);
    localwmx.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        umc.a().dispatch(localwmx);
        wxe.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localwmx);
        return;
      }
      wxe.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */