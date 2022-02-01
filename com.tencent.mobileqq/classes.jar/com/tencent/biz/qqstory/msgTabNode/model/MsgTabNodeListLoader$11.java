package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class MsgTabNodeListLoader$11
  implements Runnable
{
  MsgTabNodeListLoader$11(MsgTabNodeListLoader paramMsgTabNodeListLoader, MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      while (localIterator.hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
      }
      if ((QLog.isDevelopLevel()) && (this.this$0.d.isEmpty())) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11
 * JD-Core Version:    0.7.0.1
 */