package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import wjj;
import wst;
import wth;
import yfy;
import yga;
import yuk;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (wst)wth.a(15);
    ??? = yfy.a(this.this$0);
    if (yfy.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((wst)localObject1).a((String)???, bool);
      localObject1 = new yga(new ErrorMessage(), yfy.a(this.this$0));
      ((yga)localObject1).jdField_b_of_type_Boolean = true;
      ((yga)localObject1).jdField_a_of_type_Boolean = yfy.a(this.this$0);
      ((yga)localObject1).jdField_a_of_type_Int = yfy.a(this.this$0);
      ((yga)localObject1).c = -1;
      ((yga)localObject1).jdField_b_of_type_Int = -1;
      ((yga)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!yfy.b(this.this$0))
        {
          wjj.a().dispatch((Dispatcher.Dispatchable)localObject1);
          yuk.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        yuk.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */