package com.android.dex;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

final class Dex$ClassDefIterable
  implements Iterable<ClassDef>
{
  private Dex$ClassDefIterable(Dex paramDex) {}
  
  public Iterator<ClassDef> iterator()
  {
    if (!Dex.access$1000(this.this$0).classDefs.exists()) {
      return Collections.emptySet().iterator();
    }
    return new Dex.ClassDefIterator(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.Dex.ClassDefIterable
 * JD-Core Version:    0.7.0.1
 */