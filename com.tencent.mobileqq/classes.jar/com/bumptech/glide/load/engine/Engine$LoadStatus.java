package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;

public class Engine$LoadStatus
{
  private final EngineJob<?> a;
  private final ResourceCallback b;
  
  Engine$LoadStatus(ResourceCallback paramResourceCallback, EngineJob<?> paramEngineJob)
  {
    this.b = paramResourceCallback;
    this.a = paramEngineJob;
  }
  
  public void a()
  {
    this.a.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.Engine.LoadStatus
 * JD-Core Version:    0.7.0.1
 */