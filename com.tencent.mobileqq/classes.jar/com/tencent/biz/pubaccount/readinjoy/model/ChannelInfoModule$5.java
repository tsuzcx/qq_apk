package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import ors;
import oxb;
import pfi;
import phc;

public class ChannelInfoModule$5
  implements Runnable
{
  public ChannelInfoModule$5(pfi parampfi, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      oxb.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      oxb.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    pfi.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!ors.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      phc.a().a(this.jdField_b_of_type_JavaUtilList);
      phc.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    oxb.a().b(true, this.this$0.e());
    if (!ors.a())
    {
      oxb.a().c(true, this.this$0.f());
      return;
    }
    oxb.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */