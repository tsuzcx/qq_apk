package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract interface BlockingDeque<E>
  extends Deque<E>, BlockingQueue<E>
{
  public abstract boolean add(E paramE);
  
  public abstract void addFirst(E paramE);
  
  public abstract void addLast(E paramE);
  
  public abstract boolean contains(Object paramObject);
  
  public abstract E element();
  
  public abstract Iterator<E> iterator();
  
  public abstract boolean offer(E paramE);
  
  public abstract boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean offerFirst(E paramE);
  
  public abstract boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean offerLast(E paramE);
  
  public abstract boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract E peek();
  
  public abstract E poll();
  
  public abstract E poll(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract E pollFirst(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract E pollLast(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void push(E paramE);
  
  public abstract void put(E paramE);
  
  public abstract void putFirst(E paramE);
  
  public abstract void putLast(E paramE);
  
  public abstract E remove();
  
  public abstract boolean remove(Object paramObject);
  
  public abstract boolean removeFirstOccurrence(Object paramObject);
  
  public abstract boolean removeLastOccurrence(Object paramObject);
  
  public abstract int size();
  
  public abstract E take();
  
  public abstract E takeFirst();
  
  public abstract E takeLast();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.BlockingDeque
 * JD-Core Version:    0.7.0.1
 */