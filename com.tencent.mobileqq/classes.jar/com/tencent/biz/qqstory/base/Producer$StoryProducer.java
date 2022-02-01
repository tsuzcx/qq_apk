package com.tencent.biz.qqstory.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer$StoryProducer<T>
  implements Producer.IProducer<T>
{
  private final Producer.IConsumer<T> jdField_a_of_type_ComTencentBizQqstoryBaseProducer$IConsumer;
  private List<T> jdField_a_of_type_JavaUtilList = new ArrayList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  public Producer$StoryProducer(Producer.IConsumer<T> paramIConsumer)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$IConsumer = paramIConsumer;
    this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$IConsumer.a(this);
  }
  
  public T a()
  {
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilList.remove(0);
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$IConsumer.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<T> paramList)
  {
    if (paramList != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseProducer$IConsumer.a();
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.Producer.StoryProducer
 * JD-Core Version:    0.7.0.1
 */