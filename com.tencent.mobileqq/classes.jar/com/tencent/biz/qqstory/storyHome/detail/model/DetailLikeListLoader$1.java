package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import ste;
import tco;
import tdc;
import upu;
import upw;
import veg;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (tco)tdc.a(15);
    ??? = upu.a(this.this$0);
    if (upu.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((tco)localObject1).a((String)???, bool);
      localObject1 = new upw(new ErrorMessage(), upu.a(this.this$0));
      ((upw)localObject1).jdField_b_of_type_Boolean = true;
      ((upw)localObject1).jdField_a_of_type_Boolean = upu.a(this.this$0);
      ((upw)localObject1).jdField_a_of_type_Int = upu.a(this.this$0);
      ((upw)localObject1).c = -1;
      ((upw)localObject1).jdField_b_of_type_Int = -1;
      ((upw)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!upu.b(this.this$0))
        {
          ste.a().dispatch((Dispatcher.Dispatchable)localObject1);
          veg.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        veg.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */