package com.tencent.aekit.openrender.internal;

import java.util.List;

public abstract class AEChainI
{
  public List<String> AI()
  {
    return null;
  }
  
  public String filterName()
  {
    return getClass().getName();
  }
  
  public abstract Frame render(Frame paramFrame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.AEChainI
 * JD-Core Version:    0.7.0.1
 */