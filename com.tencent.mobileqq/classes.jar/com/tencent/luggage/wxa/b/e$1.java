package com.tencent.luggage.wxa.b;

import java.util.Iterator;

class e$1
  implements Iterator<e.b>
{
  e$1(e parame, Iterator paramIterator1, Iterator paramIterator2) {}
  
  public e.b a()
  {
    return new e.b((String)this.a.next(), (h)this.b.next());
  }
  
  public boolean hasNext()
  {
    return this.a.hasNext();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.b.e.1
 * JD-Core Version:    0.7.0.1
 */