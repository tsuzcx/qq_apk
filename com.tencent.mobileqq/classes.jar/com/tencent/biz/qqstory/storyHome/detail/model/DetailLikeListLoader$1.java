package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import stb;
import tcl;
import tcz;
import upr;
import upt;
import ved;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (tcl)tcz.a(15);
    ??? = upr.a(this.this$0);
    if (upr.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((tcl)localObject1).a((String)???, bool);
      localObject1 = new upt(new ErrorMessage(), upr.a(this.this$0));
      ((upt)localObject1).jdField_b_of_type_Boolean = true;
      ((upt)localObject1).jdField_a_of_type_Boolean = upr.a(this.this$0);
      ((upt)localObject1).jdField_a_of_type_Int = upr.a(this.this$0);
      ((upt)localObject1).c = -1;
      ((upt)localObject1).jdField_b_of_type_Int = -1;
      ((upt)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!upr.b(this.this$0))
        {
          stb.a().dispatch((Dispatcher.Dispatchable)localObject1);
          ved.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        ved.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */