package com.tencent.mobileqq.auto.engine.loader;

import com.tencent.mobileqq.auto.engine.loader.selector.IPluginSelector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ASEngineConfig
{
  private String a;
  private boolean b;
  private boolean c;
  private CopyOnWriteArrayList<IPluginSelector<ASPluginBean>> d;
  private boolean e;
  
  public ASEngineConfig a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public ASEngineConfig a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public ASEngineConfig b(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public CopyOnWriteArrayList<IPluginSelector<ASPluginBean>> b()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.ASEngineConfig
 * JD-Core Version:    0.7.0.1
 */