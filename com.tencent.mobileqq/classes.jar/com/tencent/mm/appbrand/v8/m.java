package com.tencent.mm.appbrand.v8;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", "elements", "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"}, k=1, mv={1, 1, 16})
public final class m<T>
  implements Queue<T>
{
  public static final m.a a = new m.a(null);
  private int b;
  private final Queue<T> c;
  
  public m(@NotNull Queue<T> paramQueue)
  {
    this.c = paramQueue;
    this.b = -1;
  }
  
  private final int a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = this.b;
    } else {
      i = this.c.size();
    }
    this.b = -1;
    return i;
  }
  
  public final void a(T paramT, boolean paramBoolean)
  {
    offer(paramT);
    if (paramBoolean) {
      b();
    }
  }
  
  public final void a(@NotNull Queue<T> paramQueue, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramQueue, "anotherQueue");
    int k = a(paramBoolean);
    Iterator localIterator = ((Iterable)this.c).iterator();
    int j = 0;
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      if (i <= k) {
        paramQueue.offer(localObject);
      }
      i += 1;
    }
    if (k >= 0)
    {
      i = j;
      for (;;)
      {
        this.c.poll();
        if (i == k) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public final boolean a()
  {
    return this.b >= 0;
  }
  
  public boolean add(T paramT)
  {
    return this.c.add(paramT);
  }
  
  public boolean addAll(@NotNull Collection<? extends T> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return this.c.addAll(paramCollection);
  }
  
  public final void b()
  {
    this.b = (this.c.size() - 1);
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public void clear()
  {
    this.c.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.c.contains(paramObject);
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return this.c.containsAll(paramCollection);
  }
  
  public T element()
  {
    return this.c.element();
  }
  
  public boolean isEmpty()
  {
    return this.c.isEmpty();
  }
  
  @NotNull
  public Iterator<T> iterator()
  {
    return this.c.iterator();
  }
  
  public boolean offer(T paramT)
  {
    return this.c.offer(paramT);
  }
  
  public T peek()
  {
    return this.c.peek();
  }
  
  public T poll()
  {
    return this.c.poll();
  }
  
  public T remove()
  {
    return this.c.remove();
  }
  
  public boolean remove(Object paramObject)
  {
    return this.c.remove(paramObject);
  }
  
  public boolean removeAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return this.c.removeAll(paramCollection);
  }
  
  public boolean retainAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return this.c.retainAll(paramCollection);
  }
  
  public final int size()
  {
    return c();
  }
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.m
 * JD-Core Version:    0.7.0.1
 */