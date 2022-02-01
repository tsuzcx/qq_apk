package com.google.protobuf;

import java.util.ListIterator;

class UnmodifiableLazyStringList$1
  implements ListIterator<String>
{
  ListIterator<String> a = UnmodifiableLazyStringList.a(this.c).listIterator(this.b);
  
  UnmodifiableLazyStringList$1(UnmodifiableLazyStringList paramUnmodifiableLazyStringList, int paramInt) {}
  
  public String a()
  {
    return (String)this.a.next();
  }
  
  public void a(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String b()
  {
    return (String)this.a.previous();
  }
  
  public void b(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public boolean hasPrevious()
  {
    return this.a.hasPrevious();
  }
  
  public int nextIndex()
  {
    return this.a.nextIndex();
  }
  
  public int previousIndex()
  {
    return this.a.previousIndex();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnmodifiableLazyStringList.1
 * JD-Core Version:    0.7.0.1
 */