package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import wad;
import wje;
import wjs;
import xwe;
import xwg;
import ykq;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (wje)wjs.a(15);
    ??? = xwe.a(this.this$0);
    if (xwe.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((wje)localObject1).a((String)???, bool);
      localObject1 = new xwg(new ErrorMessage(), xwe.a(this.this$0));
      ((xwg)localObject1).jdField_b_of_type_Boolean = true;
      ((xwg)localObject1).jdField_a_of_type_Boolean = xwe.a(this.this$0);
      ((xwg)localObject1).jdField_a_of_type_Int = xwe.a(this.this$0);
      ((xwg)localObject1).c = -1;
      ((xwg)localObject1).jdField_b_of_type_Int = -1;
      ((xwg)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!xwe.b(this.this$0))
        {
          wad.a().dispatch((Dispatcher.Dispatchable)localObject1);
          ykq.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        ykq.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */