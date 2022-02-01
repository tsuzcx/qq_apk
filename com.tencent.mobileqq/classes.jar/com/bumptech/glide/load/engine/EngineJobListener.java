package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

abstract interface EngineJobListener
{
  public abstract void a(EngineJob<?> paramEngineJob, Key paramKey);
  
  public abstract void a(EngineJob<?> paramEngineJob, Key paramKey, EngineResource<?> paramEngineResource);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.EngineJobListener
 * JD-Core Version:    0.7.0.1
 */