package com.tencent.hippy.qq.api;

import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

public abstract interface IHippyComponentFactory
{
  public abstract HippyAPIProvider getApiProvider();
  
  public abstract HippyCustomViewCreator getViewCreator();
  
  public abstract boolean matchName(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyComponentFactory
 * JD-Core Version:    0.7.0.1
 */