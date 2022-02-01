package com.tencent.biz.qqstory.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class BaseManger
  implements IManager
{
  protected AtomicBoolean h = new AtomicBoolean(false);
  
  public void a() {}
  
  public void b()
  {
    this.h.set(true);
  }
  
  public boolean i()
  {
    return this.h.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.BaseManger
 * JD-Core Version:    0.7.0.1
 */