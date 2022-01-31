package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tfk;
import tfr;

public class MsgTabNodeListLoader$10
  implements Runnable
{
  public MsgTabNodeListLoader$10(tfk paramtfk, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      if (localIterator.hasNext()) {
        ((tfr)localIterator.next()).a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Boolean, this.b, this.c);
      }
    }
    if ((QLog.isDevelopLevel()) && (this.this$0.d.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.10
 * JD-Core Version:    0.7.0.1
 */