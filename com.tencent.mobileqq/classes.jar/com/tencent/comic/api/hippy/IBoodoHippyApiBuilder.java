package com.tencent.comic.api.hippy;

import com.tencent.mtt.hippy.HippyAPIProvider;

public abstract interface IBoodoHippyApiBuilder
{
  public abstract BoodoModuleProxy createBoodoModuleImp();
  
  public abstract HippyAPIProvider createBoodoProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.hippy.IBoodoHippyApiBuilder
 * JD-Core Version:    0.7.0.1
 */