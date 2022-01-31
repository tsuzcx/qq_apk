package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import ste;
import tcp;
import tdc;
import uty;
import utz;
import veg;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((tcp)tdc.a(19)).b(this.this$0.a);
    utz localutz = new utz(new ErrorMessage(), uty.a(this.this$0));
    localutz.b = true;
    localutz.jdField_a_of_type_Boolean = true;
    localutz.c = true;
    localutz.jdField_a_of_type_JavaUtilList = ((List)???);
    localutz.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        ste.a().dispatch(localutz);
        veg.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localutz);
        return;
      }
      veg.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */