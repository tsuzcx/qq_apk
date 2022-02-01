package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import vli;
import vuk;
import vux;
import xln;
import xlo;
import xvv;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((vuk)vux.a(19)).b(this.this$0.a);
    xlo localxlo = new xlo(new ErrorMessage(), xln.a(this.this$0));
    localxlo.b = true;
    localxlo.jdField_a_of_type_Boolean = true;
    localxlo.c = true;
    localxlo.jdField_a_of_type_JavaUtilList = ((List)???);
    localxlo.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        vli.a().dispatch(localxlo);
        xvv.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localxlo);
        return;
      }
      xvv.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */