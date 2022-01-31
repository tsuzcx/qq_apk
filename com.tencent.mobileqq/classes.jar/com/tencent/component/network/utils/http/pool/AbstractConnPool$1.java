package com.tencent.component.network.utils.http.pool;

class AbstractConnPool$1
  extends RouteSpecificPool<T, C, E>
{
  AbstractConnPool$1(AbstractConnPool paramAbstractConnPool, Object paramObject1, Object paramObject2)
  {
    super(paramObject1);
  }
  
  protected E createEntry(C paramC)
  {
    return this.this$0.createEntry(this.val$route, paramC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.http.pool.AbstractConnPool.1
 * JD-Core Version:    0.7.0.1
 */