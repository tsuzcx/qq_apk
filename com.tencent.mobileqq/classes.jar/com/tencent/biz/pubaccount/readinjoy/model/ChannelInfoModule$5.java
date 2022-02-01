package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import pha;
import pmk;
import pwn;
import pym;

public class ChannelInfoModule$5
  implements Runnable
{
  public ChannelInfoModule$5(pwn parampwn, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      pmk.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      pmk.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    pwn.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!pha.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      pym.a().a(this.jdField_b_of_type_JavaUtilList);
      pym.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    pmk.a().b(true, this.this$0.e());
    if (!pha.a())
    {
      pmk.a().c(true, this.this$0.f());
      return;
    }
    pmk.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */