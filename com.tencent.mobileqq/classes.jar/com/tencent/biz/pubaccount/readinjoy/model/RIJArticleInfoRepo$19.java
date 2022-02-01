package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;

class RIJArticleInfoRepo$19
  implements Runnable
{
  RIJArticleInfoRepo$19(RIJArticleInfoRepo paramRIJArticleInfoRepo, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    boolean bool = true;
    ReadInJoyLogicEngineEventDispatcher localReadInJoyLogicEngineEventDispatcher = ReadInJoyLogicEngineEventDispatcher.a();
    long l = this.a;
    if (this.b == 1) {}
    for (;;)
    {
      localReadInJoyLogicEngineEventDispatcher.a(l, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.19
 * JD-Core Version:    0.7.0.1
 */