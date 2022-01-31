package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import sgi;
import spt;
import sqg;
import uhc;
import uhd;
import urk;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((spt)sqg.a(19)).b(this.this$0.a);
    uhd localuhd = new uhd(new ErrorMessage(), uhc.a(this.this$0));
    localuhd.b = true;
    localuhd.jdField_a_of_type_Boolean = true;
    localuhd.c = true;
    localuhd.jdField_a_of_type_JavaUtilList = ((List)???);
    localuhd.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        sgi.a().dispatch(localuhd);
        urk.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localuhd);
        return;
      }
      urk.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */