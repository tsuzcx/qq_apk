package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.persistence.notColumn;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ArticlePatchStatus
{
  @notColumn
  public AtomicBoolean a;
  @notColumn
  public AtomicInteger a;
  @notColumn
  public AtomicBoolean b;
  @notColumn
  public AtomicInteger b;
  @notColumn
  public AtomicBoolean c = new AtomicBoolean(false);
  @notColumn
  public AtomicBoolean d = new AtomicBoolean(false);
  
  public ArticlePatchStatus()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.ArticlePatchStatus
 * JD-Core Version:    0.7.0.1
 */