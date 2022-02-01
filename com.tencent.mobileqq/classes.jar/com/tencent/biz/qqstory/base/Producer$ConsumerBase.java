package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.support.logging.SLog;

public abstract class Producer$ConsumerBase<T>
  implements Producer.IConsumer<T>
{
  private Producer.IProducer<T> a;
  
  public void a()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      a(localObject);
      SLog.a("Q.qqstory.home.data.Producer", "start one consumer:%s", localObject);
      return;
    }
    SLog.d("Q.qqstory.home.data.Producer", "no data return");
  }
  
  public void a(Producer.IProducer<T> paramIProducer)
  {
    this.a = paramIProducer;
  }
  
  public abstract void a(T paramT);
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.Producer.ConsumerBase
 * JD-Core Version:    0.7.0.1
 */