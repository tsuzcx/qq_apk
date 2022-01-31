package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import uht;
import urd;
import urr;
import wej;
import wel;
import wsv;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (urd)urr.a(15);
    ??? = wej.a(this.this$0);
    if (wej.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((urd)localObject1).a((String)???, bool);
      localObject1 = new wel(new ErrorMessage(), wej.a(this.this$0));
      ((wel)localObject1).jdField_b_of_type_Boolean = true;
      ((wel)localObject1).jdField_a_of_type_Boolean = wej.a(this.this$0);
      ((wel)localObject1).jdField_a_of_type_Int = wej.a(this.this$0);
      ((wel)localObject1).c = -1;
      ((wel)localObject1).jdField_b_of_type_Int = -1;
      ((wel)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!wej.b(this.this$0))
        {
          uht.a().dispatch((Dispatcher.Dispatchable)localObject1);
          wsv.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        wsv.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */