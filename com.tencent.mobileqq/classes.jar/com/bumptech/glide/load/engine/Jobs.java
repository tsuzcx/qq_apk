package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

final class Jobs
{
  private final Map<Key, EngineJob<?>> a = new HashMap();
  private final Map<Key, EngineJob<?>> b = new HashMap();
  
  private Map<Key, EngineJob<?>> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.b;
    }
    return this.a;
  }
  
  EngineJob<?> a(Key paramKey, boolean paramBoolean)
  {
    return (EngineJob)a(paramBoolean).get(paramKey);
  }
  
  void a(Key paramKey, EngineJob<?> paramEngineJob)
  {
    a(paramEngineJob.a()).put(paramKey, paramEngineJob);
  }
  
  void b(Key paramKey, EngineJob<?> paramEngineJob)
  {
    Map localMap = a(paramEngineJob.a());
    if (paramEngineJob.equals(localMap.get(paramKey))) {
      localMap.remove(paramKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Jobs
 * JD-Core Version:    0.7.0.1
 */