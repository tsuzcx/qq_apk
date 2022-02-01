package com.tencent.biz.pubaccount.readinjoy.model.handler;

import java.util.List;
import pvm;
import qep;
import qga;
import qit;

public class RIJGetArticleListHandler$4
  implements Runnable
{
  public RIJGetArticleListHandler$4(qit paramqit, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.this$0.a.a().b(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
    List localList = qit.a(this.this$0, this.jdField_a_of_type_JavaUtilList);
    pvm.a().c(this.jdField_a_of_type_Int, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.4
 * JD-Core Version:    0.7.0.1
 */