package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class BaseFaceListAdapter$CacheRefMap$CacheRef
  extends SoftReference<V>
{
  private K b;
  
  public BaseFaceListAdapter$CacheRefMap$CacheRef(K paramK, V paramV, ReferenceQueue<? super V> paramReferenceQueue)
  {
    super(paramReferenceQueue, localReferenceQueue);
    this.b = paramV;
  }
  
  public K a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter.CacheRefMap.CacheRef
 * JD-Core Version:    0.7.0.1
 */