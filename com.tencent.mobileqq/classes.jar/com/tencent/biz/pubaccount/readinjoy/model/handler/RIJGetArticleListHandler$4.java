package com.tencent.biz.pubaccount.readinjoy.model.handler;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo;
import java.util.List;

class RIJGetArticleListHandler$4
  implements Runnable
{
  RIJGetArticleListHandler$4(RIJGetArticleListHandler paramRIJGetArticleListHandler, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.this$0.a.a().b(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
    List localList = RIJGetArticleListHandler.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().c(this.jdField_a_of_type_Int, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.4
 * JD-Core Version:    0.7.0.1
 */