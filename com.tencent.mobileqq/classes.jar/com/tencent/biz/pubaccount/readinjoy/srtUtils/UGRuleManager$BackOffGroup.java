package com.tencent.biz.pubaccount.readinjoy.srtUtils;

import java.util.Deque;
import java.util.LinkedList;

class UGRuleManager$BackOffGroup
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  Deque<UGRuleManager.FreshInfo> jdField_a_of_type_JavaUtilDeque = new LinkedList();
  int b;
  int c = 0;
  private final int d = 50;
  
  UGRuleManager$BackOffGroup(UGRuleManager paramUGRuleManager) {}
  
  boolean a(UGRuleManager.FreshInfo paramFreshInfo)
  {
    if (this.jdField_a_of_type_JavaUtilDeque.size() >= 50) {
      this.jdField_a_of_type_JavaUtilDeque.poll();
    }
    return this.jdField_a_of_type_JavaUtilDeque.offer(paramFreshInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager.BackOffGroup
 * JD-Core Version:    0.7.0.1
 */