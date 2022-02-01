package com.tencent.biz.qqcircle.richframework.util;

public class AsyncLruCache<K, V>
{
  private int a;
  private int b;
  private int c;
  
  public final String toString()
  {
    int i = this.b;
    int j = this.c + i;
    if (j != 0) {
      i = i * 100 / j;
    } else {
      i = 0;
    }
    return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.AsyncLruCache
 * JD-Core Version:    0.7.0.1
 */