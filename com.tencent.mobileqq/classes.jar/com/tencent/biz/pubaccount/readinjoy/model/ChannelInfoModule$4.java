package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import pnn;
import pvm;
import qfb;
import qhw;

public class ChannelInfoModule$4
  implements Runnable
{
  public ChannelInfoModule$4(qfb paramqfb, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      pvm.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      pvm.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    qfb.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!pnn.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      qhw.a().a(this.jdField_b_of_type_JavaUtilList);
      qhw.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    pvm.a().b(true, this.this$0.e());
    if (!pnn.a())
    {
      pvm.a().c(true, this.this$0.f());
      return;
    }
    pvm.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */