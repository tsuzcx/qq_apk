package com.tencent.biz.qqstory.storyHome.memory.controller;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.List;
import stb;
import tcm;
import tcz;
import utv;
import utw;
import ved;

public class ShareGroupPageLoader$1
  implements Runnable
{
  public void run()
  {
    ??? = ((tcm)tcz.a(19)).b(this.this$0.a);
    utw localutw = new utw(new ErrorMessage(), utv.a(this.this$0));
    localutw.b = true;
    localutw.jdField_a_of_type_Boolean = true;
    localutw.c = true;
    localutw.jdField_a_of_type_JavaUtilList = ((List)???);
    localutw.jdField_a_of_type_Int = ((List)???).size();
    synchronized (this.this$0)
    {
      if (!this.this$0.b)
      {
        stb.a().dispatch(localutw);
        ved.a("Q.qqstory.memories:ShareGroupPageLoader", "dispatch share group list return from cache: %s", localutw);
        return;
      }
      ved.d("Q.qqstory.memories:ShareGroupPageLoader", "load cache data later than load from network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.ShareGroupPageLoader.1
 * JD-Core Version:    0.7.0.1
 */