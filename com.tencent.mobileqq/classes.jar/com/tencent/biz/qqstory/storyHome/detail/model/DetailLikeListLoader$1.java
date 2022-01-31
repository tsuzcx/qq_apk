package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import sgi;
import sps;
import sqg;
import ucy;
import uda;
import urk;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (sps)sqg.a(15);
    ??? = ucy.a(this.this$0);
    if (ucy.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((sps)localObject1).a((String)???, bool);
      localObject1 = new uda(new ErrorMessage(), ucy.a(this.this$0));
      ((uda)localObject1).jdField_b_of_type_Boolean = true;
      ((uda)localObject1).jdField_a_of_type_Boolean = ucy.a(this.this$0);
      ((uda)localObject1).jdField_a_of_type_Int = ucy.a(this.this$0);
      ((uda)localObject1).c = -1;
      ((uda)localObject1).jdField_b_of_type_Int = -1;
      ((uda)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!ucy.b(this.this$0))
        {
          sgi.a().dispatch((Dispatcher.Dispatchable)localObject1);
          urk.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        urk.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */