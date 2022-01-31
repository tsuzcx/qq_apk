package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import uyg;
import uyl;
import uys;

public class MsgTabNodeListLoader$11
  implements Runnable
{
  public MsgTabNodeListLoader$11(uyl paramuyl, uyg paramuyg, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2) {}
  
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      if (localIterator.hasNext()) {
        ((uys)localIterator.next()).a(this.jdField_a_of_type_Uyg, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Boolean);
      }
    }
    if ((QLog.isDevelopLevel()) && (this.this$0.d.isEmpty())) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.11
 * JD-Core Version:    0.7.0.1
 */