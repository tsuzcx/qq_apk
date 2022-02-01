package com.tencent.commonsdk.pool;

public class RecyclablePool$Recyclable
{
  public boolean inPool;
  private Recyclable next;
  
  public void changeNext(Recyclable paramRecyclable, boolean paramBoolean)
  {
    if ((this.inPool) && (paramBoolean)) {
      throw new RuntimeException("WTF");
    }
    this.next = paramRecyclable;
  }
  
  public Recyclable getNext()
  {
    return this.next;
  }
  
  public void recycle()
  {
    this.next = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.pool.RecyclablePool.Recyclable
 * JD-Core Version:    0.7.0.1
 */