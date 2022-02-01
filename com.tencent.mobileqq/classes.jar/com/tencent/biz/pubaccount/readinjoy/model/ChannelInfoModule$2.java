package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import java.util.List;

class ChannelInfoModule$2
  implements Runnable
{
  ChannelInfoModule$2(ChannelInfoModule paramChannelInfoModule, List paramList) {}
  
  public void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().c(true, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ChannelInfoModule.2
 * JD-Core Version:    0.7.0.1
 */