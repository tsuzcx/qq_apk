package com.tencent.biz.richframework.animation.drawable;

import android.os.Build.VERSION;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.concurrent.ArrayBlockingQueue;

class QQAnimationDrawable$Task<T>
{
  final AbstractCollection<T> a;
  
  public QQAnimationDrawable$Task(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.a = new ArrayDeque();
      return;
    }
    this.a = new ArrayBlockingQueue(30);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(T paramT)
  {
    AbstractCollection localAbstractCollection;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localAbstractCollection = this.a;
      if ((localAbstractCollection instanceof ArrayDeque)) {
        ((ArrayDeque)localAbstractCollection).offer(paramT);
      }
    }
    else
    {
      localAbstractCollection = this.a;
      if ((localAbstractCollection instanceof ArrayBlockingQueue)) {
        ((ArrayBlockingQueue)localAbstractCollection).offer(paramT);
      }
    }
  }
  
  public T b()
  {
    AbstractCollection localAbstractCollection;
    if (Build.VERSION.SDK_INT >= 9)
    {
      localAbstractCollection = this.a;
      if ((localAbstractCollection instanceof ArrayDeque)) {
        return ((ArrayDeque)localAbstractCollection).poll();
      }
    }
    else
    {
      localAbstractCollection = this.a;
      if ((localAbstractCollection instanceof ArrayBlockingQueue)) {
        return ((ArrayBlockingQueue)localAbstractCollection).poll();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.Task
 * JD-Core Version:    0.7.0.1
 */