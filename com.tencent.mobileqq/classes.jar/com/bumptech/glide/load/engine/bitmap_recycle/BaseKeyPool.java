package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable>
{
  private final Queue<T> a = Util.a(20);
  
  public void a(T paramT)
  {
    if (this.a.size() < 20) {
      this.a.offer(paramT);
    }
  }
  
  abstract T b();
  
  T c()
  {
    Poolable localPoolable2 = (Poolable)this.a.poll();
    Poolable localPoolable1 = localPoolable2;
    if (localPoolable2 == null) {
      localPoolable1 = b();
    }
    return localPoolable1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
 * JD-Core Version:    0.7.0.1
 */