package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import vli;
import vuj;
import vux;
import xhj;
import xhl;
import xvv;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (vuj)vux.a(15);
    ??? = xhj.a(this.this$0);
    if (xhj.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((vuj)localObject1).a((String)???, bool);
      localObject1 = new xhl(new ErrorMessage(), xhj.a(this.this$0));
      ((xhl)localObject1).jdField_b_of_type_Boolean = true;
      ((xhl)localObject1).jdField_a_of_type_Boolean = xhj.a(this.this$0);
      ((xhl)localObject1).jdField_a_of_type_Int = xhj.a(this.this$0);
      ((xhl)localObject1).c = -1;
      ((xhl)localObject1).jdField_b_of_type_Int = -1;
      ((xhl)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!xhj.b(this.this$0))
        {
          vli.a().dispatch((Dispatcher.Dispatchable)localObject1);
          xvv.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        xvv.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */