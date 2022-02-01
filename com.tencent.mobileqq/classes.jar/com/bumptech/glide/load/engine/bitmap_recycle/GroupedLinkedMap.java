package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V>
{
  private final GroupedLinkedMap.LinkedEntry<K, V> a = new GroupedLinkedMap.LinkedEntry();
  private final Map<K, GroupedLinkedMap.LinkedEntry<K, V>> b = new HashMap();
  
  private void a(GroupedLinkedMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    d(paramLinkedEntry);
    GroupedLinkedMap.LinkedEntry localLinkedEntry = this.a;
    paramLinkedEntry.c = localLinkedEntry;
    paramLinkedEntry.b = localLinkedEntry.b;
    c(paramLinkedEntry);
  }
  
  private void b(GroupedLinkedMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    d(paramLinkedEntry);
    paramLinkedEntry.c = this.a.c;
    paramLinkedEntry.b = this.a;
    c(paramLinkedEntry);
  }
  
  private static <K, V> void c(GroupedLinkedMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    paramLinkedEntry.b.c = paramLinkedEntry;
    paramLinkedEntry.c.b = paramLinkedEntry;
  }
  
  private static <K, V> void d(GroupedLinkedMap.LinkedEntry<K, V> paramLinkedEntry)
  {
    paramLinkedEntry.c.b = paramLinkedEntry.b;
    paramLinkedEntry.b.c = paramLinkedEntry.c;
  }
  
  @Nullable
  public V a()
  {
    for (GroupedLinkedMap.LinkedEntry localLinkedEntry = this.a.c; !localLinkedEntry.equals(this.a); localLinkedEntry = localLinkedEntry.c)
    {
      Object localObject = localLinkedEntry.a();
      if (localObject != null) {
        return localObject;
      }
      d(localLinkedEntry);
      this.b.remove(localLinkedEntry.a);
      ((Poolable)localLinkedEntry.a).a();
    }
    return null;
  }
  
  @Nullable
  public V a(K paramK)
  {
    GroupedLinkedMap.LinkedEntry localLinkedEntry = (GroupedLinkedMap.LinkedEntry)this.b.get(paramK);
    if (localLinkedEntry == null)
    {
      localLinkedEntry = new GroupedLinkedMap.LinkedEntry(paramK);
      this.b.put(paramK, localLinkedEntry);
      paramK = localLinkedEntry;
    }
    else
    {
      paramK.a();
      paramK = localLinkedEntry;
    }
    a(paramK);
    return paramK.a();
  }
  
  public void a(K paramK, V paramV)
  {
    GroupedLinkedMap.LinkedEntry localLinkedEntry = (GroupedLinkedMap.LinkedEntry)this.b.get(paramK);
    if (localLinkedEntry == null)
    {
      localLinkedEntry = new GroupedLinkedMap.LinkedEntry(paramK);
      b(localLinkedEntry);
      this.b.put(paramK, localLinkedEntry);
      paramK = localLinkedEntry;
    }
    else
    {
      paramK.a();
      paramK = localLinkedEntry;
    }
    paramK.a(paramV);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GroupedLinkedMap( ");
    GroupedLinkedMap.LinkedEntry localLinkedEntry = this.a.b;
    int i = 0;
    while (!localLinkedEntry.equals(this.a))
    {
      i = 1;
      localStringBuilder.append('{');
      localStringBuilder.append(localLinkedEntry.a);
      localStringBuilder.append(':');
      localStringBuilder.append(localLinkedEntry.b());
      localStringBuilder.append("}, ");
      localLinkedEntry = localLinkedEntry.b;
    }
    if (i != 0) {
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    }
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap
 * JD-Core Version:    0.7.0.1
 */