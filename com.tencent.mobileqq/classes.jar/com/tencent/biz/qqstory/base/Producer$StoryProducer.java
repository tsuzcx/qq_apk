package com.tencent.biz.qqstory.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Producer$StoryProducer<T>
  implements Producer.IProducer<T>
{
  private final Producer.IConsumer<T> a;
  private List<T> b = new ArrayList();
  private AtomicBoolean c = new AtomicBoolean(false);
  
  public Producer$StoryProducer(Producer.IConsumer<T> paramIConsumer)
  {
    this.a = paramIConsumer;
    this.a.a(this);
  }
  
  public T a()
  {
    try
    {
      if ((!this.c.get()) && (this.b.size() != 0))
      {
        Object localObject1 = this.b.remove(0);
        return localObject1;
      }
      return null;
    }
    finally {}
  }
  
  public void a(List<T> paramList)
  {
    if (paramList != null) {}
    try
    {
      this.b.addAll(paramList);
      this.a.a();
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.c.set(true);
      this.a.c();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.Producer.StoryProducer
 * JD-Core Version:    0.7.0.1
 */