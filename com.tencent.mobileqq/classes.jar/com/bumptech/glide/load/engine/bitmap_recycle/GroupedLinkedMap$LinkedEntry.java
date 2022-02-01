package com.bumptech.glide.load.engine.bitmap_recycle;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

class GroupedLinkedMap$LinkedEntry<K, V>
{
  final K a;
  LinkedEntry<K, V> b = this;
  LinkedEntry<K, V> c = this;
  private List<V> d;
  
  GroupedLinkedMap$LinkedEntry()
  {
    this(null);
  }
  
  GroupedLinkedMap$LinkedEntry(K paramK)
  {
    this.a = paramK;
  }
  
  @Nullable
  public V a()
  {
    int i = b();
    if (i > 0) {
      return this.d.remove(i - 1);
    }
    return null;
  }
  
  public void a(V paramV)
  {
    if (this.d == null) {
      this.d = new ArrayList();
    }
    this.d.add(paramV);
  }
  
  public int b()
  {
    List localList = this.d;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap.LinkedEntry
 * JD-Core Version:    0.7.0.1
 */