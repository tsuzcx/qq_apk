package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import wly;
import wmd;
import wmk;

public class MsgTabNodeListLoader$11
  implements Runnable
{
  public MsgTabNodeListLoader$11(wmd paramwmd, wly paramwly, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      if (localIterator.hasNext()) {
        ((wmk)localIterator.next()).a(this.jdField_a_of_type_Wly, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
      }
    }
    if ((QLog.isDevelopLevel()) && (this.this$0.d.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11
 * JD-Core Version:    0.7.0.1
 */