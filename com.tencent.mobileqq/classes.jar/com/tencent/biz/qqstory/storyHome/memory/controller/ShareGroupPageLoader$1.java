package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import wjj;
import wsu;
import wth;
import ykc;
import ykd;
import yuk;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((wsu)wth.a(19)).b(this.this$0.a);
    ykd localykd = new ykd(new ErrorMessage(), ykc.a(this.this$0));
    localykd.b = true;
    localykd.jdField_a_of_type_Boolean = true;
    localykd.c = true;
    localykd.jdField_a_of_type_JavaUtilList = ((List)???);
    localykd.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        wjj.a().dispatch(localykd);
        yuk.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localykd);
        return;
      }
      yuk.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */