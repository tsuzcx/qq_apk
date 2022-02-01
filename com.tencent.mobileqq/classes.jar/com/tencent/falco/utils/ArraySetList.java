package com.tencent.falco.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.UnaryOperator;

public class ArraySetList<T>
  implements List<T>
{
  private ArrayList<T> mDataList = new ArrayList();
  private Set<T> mDataSet = new HashSet();
  
  public void add(int paramInt, T paramT)
  {
    if (!contains(paramT))
    {
      this.mDataList.add(paramInt, paramT);
      this.mDataSet.add(paramT);
    }
  }
  
  public boolean add(T paramT)
  {
    if (!contains(paramT))
    {
      this.mDataList.add(paramT);
      this.mDataSet.add(paramT);
      return true;
    }
    return false;
  }
  
  public boolean addAll(int paramInt, @NonNull Collection<? extends T> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!contains(localObject)) {
        localArrayList.add(localObject);
      }
    }
    this.mDataSet.addAll(localArrayList);
    this.mDataList.addAll(paramInt, paramCollection);
    return false;
  }
  
  public boolean addAll(@NonNull Collection<? extends T> paramCollection)
  {
    int i = paramCollection.size();
    boolean bool = false;
    if (i == 0) {
      return false;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (add(paramCollection.next())) {
        bool = true;
      }
    }
    return bool;
  }
  
  public void addFirst(T paramT)
  {
    add(0, paramT);
  }
  
  public void clear()
  {
    this.mDataSet.clear();
    this.mDataList.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return ((paramObject != null) && (this.mDataSet.contains(paramObject))) || (paramObject == null);
  }
  
  public boolean containsAll(@NonNull Collection<?> paramCollection)
  {
    return this.mDataSet.containsAll(paramCollection);
  }
  
  public T get(int paramInt)
  {
    return this.mDataList.get(paramInt);
  }
  
  public T getFirst()
  {
    if (this.mDataList.size() > 0) {
      return this.mDataList.get(0);
    }
    return null;
  }
  
  public List<T> getList()
  {
    return this.mDataList;
  }
  
  public int indexOf(Object paramObject)
  {
    if (contains(paramObject)) {
      return this.mDataList.indexOf(paramObject);
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.mDataList.isEmpty();
  }
  
  @NonNull
  public Iterator<T> iterator()
  {
    return this.mDataList.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    if (contains(paramObject)) {
      return this.mDataList.lastIndexOf(paramObject);
    }
    return -1;
  }
  
  @NonNull
  public ListIterator<T> listIterator()
  {
    return this.mDataList.listIterator();
  }
  
  @NonNull
  public ListIterator<T> listIterator(int paramInt)
  {
    return this.mDataList.listIterator();
  }
  
  public T remove(int paramInt)
  {
    Object localObject = this.mDataList.remove(paramInt);
    this.mDataSet.remove(localObject);
    return localObject;
  }
  
  public boolean remove(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (contains(paramObject))
    {
      this.mDataSet.remove(paramObject);
      this.mDataList.remove(paramObject);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.size() != 0))
    {
      this.mDataSet.removeAll(paramCollection);
      return this.mDataList.removeAll(paramCollection);
    }
    return false;
  }
  
  public T removeByIndex(int paramInt)
  {
    if (this.mDataSet.size() > paramInt)
    {
      Object localObject = this.mDataList.remove(paramInt);
      this.mDataSet.remove(localObject);
      return localObject;
    }
    return null;
  }
  
  public T removeFirst()
  {
    if (this.mDataSet.size() > 0)
    {
      Object localObject = this.mDataList.remove(0);
      this.mDataSet.remove(localObject);
      return localObject;
    }
    return null;
  }
  
  public void replaceAll(UnaryOperator<T> paramUnaryOperator)
  {
    throw new UnsupportedOperationException("尚未实现");
  }
  
  public boolean retainAll(@NonNull Collection<?> paramCollection)
  {
    return this.mDataSet.containsAll(paramCollection);
  }
  
  public T set(int paramInt, T paramT)
  {
    Object localObject = this.mDataList.set(paramInt, paramT);
    this.mDataSet.remove(localObject);
    this.mDataSet.add(paramT);
    return localObject;
  }
  
  public int size()
  {
    return this.mDataSet.size();
  }
  
  @NonNull
  public List<T> subList(int paramInt1, int paramInt2)
  {
    return this.mDataList.subList(paramInt1, paramInt2);
  }
  
  @NonNull
  public Object[] toArray()
  {
    return this.mDataList.toArray();
  }
  
  @NonNull
  public <T1> T1[] toArray(@NonNull T1[] paramArrayOfT1)
  {
    return this.mDataList.toArray(paramArrayOfT1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.ArraySetList
 * JD-Core Version:    0.7.0.1
 */