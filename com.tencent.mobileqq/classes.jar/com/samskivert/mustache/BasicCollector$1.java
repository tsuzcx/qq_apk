package com.samskivert.mustache;

import java.util.Iterator;

class BasicCollector$1
  implements Iterator<Object>
{
  private int _count = this.val$helper.length(this.val$value);
  private int _idx;
  
  BasicCollector$1(BasicCollector paramBasicCollector, BasicCollector.ArrayHelper paramArrayHelper, Object paramObject) {}
  
  public boolean hasNext()
  {
    return this._idx < this._count;
  }
  
  public Object next()
  {
    BasicCollector.ArrayHelper localArrayHelper = this.val$helper;
    Object localObject = this.val$value;
    int i = this._idx;
    this._idx = (i + 1);
    return localArrayHelper.get(localObject, i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.BasicCollector.1
 * JD-Core Version:    0.7.0.1
 */