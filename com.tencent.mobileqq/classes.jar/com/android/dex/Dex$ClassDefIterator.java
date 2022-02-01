package com.android.dex;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Dex$ClassDefIterator
  implements Iterator<ClassDef>
{
  private int count = 0;
  private final Dex.Section in = this.this$0.open(Dex.access$1000(this.this$0).classDefs.off);
  
  private Dex$ClassDefIterator(Dex paramDex) {}
  
  public boolean hasNext()
  {
    return this.count < Dex.access$1000(this.this$0).classDefs.size;
  }
  
  public ClassDef next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.count += 1;
    return this.in.readClassDef();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.ClassDefIterator
 * JD-Core Version:    0.7.0.1
 */