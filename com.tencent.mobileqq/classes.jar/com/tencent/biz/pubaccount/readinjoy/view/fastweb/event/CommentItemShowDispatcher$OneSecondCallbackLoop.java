package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import mqq.os.MqqHandler;

public class CommentItemShowDispatcher$OneSecondCallbackLoop
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  
  public void run()
  {
    QLog.d("CommentItemShowDispatcher", 2, "  1秒到了 ");
    CommentItemShowDispatcher.a(this.this$0, this.jdField_a_of_type_ComTencentWidgetAbsListView, this.jdField_a_of_type_Int);
    if (CommentItemShowDispatcher.a(this.this$0)) {
      ThreadManager.getUIHandler().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.CommentItemShowDispatcher.OneSecondCallbackLoop
 * JD-Core Version:    0.7.0.1
 */