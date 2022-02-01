package com.sina.weibo.sdk.b;

import java.util.concurrent.FutureTask;

abstract class c$c
  extends FutureTask<Result>
  implements Comparable<Object>
{
  int priority;
  
  public c$c(c paramc, c.d paramd)
  {
    super(paramd);
    this.priority = paramd.priority;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.b.c.c
 * JD-Core Version:    0.7.0.1
 */