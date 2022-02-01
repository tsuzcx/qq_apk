package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class ChannelInfoModule$4
  implements Runnable
{
  ChannelInfoModule$4(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean1, boolean paramBoolean2, List paramList1, List paramList2) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(false, null);
      return;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    ChannelInfoModule.a(this.this$0, true);
    this.this$0.a(this.jdField_a_of_type_JavaUtilList, true);
    this.this$0.f(this.jdField_b_of_type_JavaUtilList);
    if (!RIJQQAppInterfaceUtil.a())
    {
      List localList = this.this$0.a(this.jdField_a_of_type_JavaUtilList);
      SpecialChannelFilter.a().a(this.jdField_b_of_type_JavaUtilList);
      SpecialChannelFilter.a().b(localList);
      localList = this.this$0.g();
      if (!this.jdField_b_of_type_JavaUtilList.equals(localList)) {
        this.this$0.e(this.this$0.g());
      }
    }
    ReadInJoyLogicEngineEventDispatcher.a().b(true, this.this$0.e());
    if (!RIJQQAppInterfaceUtil.a())
    {
      ReadInJoyLogicEngineEventDispatcher.a().c(true, this.this$0.f());
      return;
    }
    ReadInJoyLogicEngineEventDispatcher.a().c(true, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.4
 * JD-Core Version:    0.7.0.1
 */