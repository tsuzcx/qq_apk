package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class ChannelInfoModule$3
  implements Runnable
{
  ChannelInfoModule$3(ChannelInfoModule paramChannelInfoModule, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoyLogicEngineEventDispatcher.a().d(false, null);
      return;
    }
    SpecialChannelFilter.a().a(this.jdField_a_of_type_JavaUtilList);
    this.this$0.f(this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().d(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.3
 * JD-Core Version:    0.7.0.1
 */