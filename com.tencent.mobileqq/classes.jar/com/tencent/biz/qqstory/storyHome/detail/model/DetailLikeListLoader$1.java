package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import wfo;
import woy;
import wpm;
import ycd;
import ycf;
import yqp;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (woy)wpm.a(15);
    ??? = ycd.a(this.this$0);
    if (ycd.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((woy)localObject1).a((String)???, bool);
      localObject1 = new ycf(new ErrorMessage(), ycd.a(this.this$0));
      ((ycf)localObject1).jdField_b_of_type_Boolean = true;
      ((ycf)localObject1).jdField_a_of_type_Boolean = ycd.a(this.this$0);
      ((ycf)localObject1).jdField_a_of_type_Int = ycd.a(this.this$0);
      ((ycf)localObject1).c = -1;
      ((ycf)localObject1).jdField_b_of_type_Int = -1;
      ((ycf)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!ycd.b(this.this$0))
        {
          wfo.a().dispatch((Dispatcher.Dispatchable)localObject1);
          yqp.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        yqp.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */