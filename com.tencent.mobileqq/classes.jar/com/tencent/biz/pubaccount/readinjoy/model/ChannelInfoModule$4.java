package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import pay;
import pkp;
import puh;
import pwq;

public class ChannelInfoModule$4
  implements Runnable
{
  public ChannelInfoModule$4(puh parampuh, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      pkp.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      pkp.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    puh.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!pay.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      pwq.a().a(this.jdField_b_of_type_JavaUtilList);
      pwq.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    pkp.a().b(true, this.this$0.e());
    if (!pay.a())
    {
      pkp.a().c(true, this.this$0.f());
      return;
    }
    pkp.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */