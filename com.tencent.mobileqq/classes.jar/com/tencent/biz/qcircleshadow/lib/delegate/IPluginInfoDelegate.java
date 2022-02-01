package com.tencent.biz.qcircleshadow.lib.delegate;

import java.util.List;

public abstract interface IPluginInfoDelegate
{
  public abstract List<String> getAllPluginInitInfo();
  
  public abstract String getCurrentPluginInfo();
  
  public abstract int getCurrentPluginVersion();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.IPluginInfoDelegate
 * JD-Core Version:    0.7.0.1
 */