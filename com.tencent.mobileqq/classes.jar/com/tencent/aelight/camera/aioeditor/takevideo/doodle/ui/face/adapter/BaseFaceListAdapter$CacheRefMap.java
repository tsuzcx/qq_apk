package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class BaseFaceListAdapter$CacheRefMap<K, V>
{
  private HashMap<K, CacheRefMap<K, V>.CacheRef> a = new HashMap();
  private ReferenceQueue<V> b = new ReferenceQueue();
  
  @Nullable
  public V a(K paramK)
  {
    if (this.a.containsKey(paramK))
    {
      paramK = (BaseFaceListAdapter.CacheRefMap.CacheRef)this.a.get(paramK);
      if (paramK.get() != null) {
        return paramK.get();
      }
    }
    return null;
  }
  
  public void a()
  {
    for (;;)
    {
      Reference localReference = this.b.poll();
      if (localReference == null) {
        break;
      }
      this.a.remove(((BaseFaceListAdapter.CacheRefMap.CacheRef)localReference).a());
    }
  }
  
  public void a(@NonNull K paramK, @NonNull V paramV)
  {
    if ((paramK != null) && (paramV != null))
    {
      if ((this.a.containsKey(paramK)) && (((BaseFaceListAdapter.CacheRefMap.CacheRef)this.a.get(paramK)).get() != null)) {
        return;
      }
      this.a.put(paramK, new BaseFaceListAdapter.CacheRefMap.CacheRef(this, paramK, paramV, this.b));
      return;
    }
    throw new IllegalArgumentException("key-value cannot be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter.CacheRefMap
 * JD-Core Version:    0.7.0.1
 */