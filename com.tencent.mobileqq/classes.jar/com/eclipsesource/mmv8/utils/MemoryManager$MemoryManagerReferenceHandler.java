package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.ReferenceHandler;
import com.eclipsesource.mmv8.V8Value;
import java.util.ArrayList;
import java.util.Iterator;

class MemoryManager$MemoryManagerReferenceHandler
  implements ReferenceHandler
{
  private MemoryManager$MemoryManagerReferenceHandler(MemoryManager paramMemoryManager) {}
  
  public void v8HandleCreated(V8Value paramV8Value)
  {
    MemoryManager.access$100(this.this$0).add(paramV8Value);
  }
  
  public void v8HandleDisposed(V8Value paramV8Value)
  {
    if (!MemoryManager.access$200(this.this$0))
    {
      Iterator localIterator = MemoryManager.access$100(this.this$0).iterator();
      while (localIterator.hasNext()) {
        if (localIterator.next() == paramV8Value) {
          localIterator.remove();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.MemoryManager.MemoryManagerReferenceHandler
 * JD-Core Version:    0.7.0.1
 */