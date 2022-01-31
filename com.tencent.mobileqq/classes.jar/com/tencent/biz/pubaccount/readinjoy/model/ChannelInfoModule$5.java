package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import onk;
import osm;
import pad;
import pbt;

public class ChannelInfoModule$5
  implements Runnable
{
  public ChannelInfoModule$5(pad parampad, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      osm.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      osm.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    pad.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!onk.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      pbt.a().a(this.jdField_b_of_type_JavaUtilList);
      pbt.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    osm.a().b(true, this.this$0.e());
    if (!onk.a())
    {
      osm.a().c(true, this.this$0.f());
      return;
    }
    osm.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.5
 * JD-Core Version:    0.7.0.1
 */