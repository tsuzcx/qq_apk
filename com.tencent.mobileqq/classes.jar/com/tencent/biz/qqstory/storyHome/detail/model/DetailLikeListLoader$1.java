package com.tencent.biz.qqstory.storyHome.detail.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.List;
import umc;
import uvm;
import uwa;
import wis;
import wiu;
import wxe;

public class DetailLikeListLoader$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = (uvm)uwa.a(15);
    ??? = wis.a(this.this$0);
    if (wis.a(this.this$0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ??? = ((uvm)localObject1).a((String)???, bool);
      localObject1 = new wiu(new ErrorMessage(), wis.a(this.this$0));
      ((wiu)localObject1).jdField_b_of_type_Boolean = true;
      ((wiu)localObject1).jdField_a_of_type_Boolean = wis.a(this.this$0);
      ((wiu)localObject1).jdField_a_of_type_Int = wis.a(this.this$0);
      ((wiu)localObject1).c = -1;
      ((wiu)localObject1).jdField_b_of_type_Int = -1;
      ((wiu)localObject1).jdField_a_of_type_JavaUtilList = ((List)???);
      synchronized (this.this$0)
      {
        if (!wis.b(this.this$0))
        {
          umc.a().dispatch((Dispatcher.Dispatchable)localObject1);
          wxe.a("Q.qqstory.detail:DetailLikeListLoader", "dispatch like list return from cache: %s", localObject1);
          return;
        }
        wxe.d("Q.qqstory.detail:DetailLikeListLoader", "load cache data later than load from network");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailLikeListLoader.1
 * JD-Core Version:    0.7.0.1
 */