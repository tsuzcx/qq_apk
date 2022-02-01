package com.tencent.kwstudio.office.debug;

import com.tencent.kwstudio.office.preview.IHostInterface;

public abstract interface IDebugger
{
  public abstract boolean cleanCache(IHostInterface paramIHostInterface);
  
  public abstract boolean discardPlugin(IHostInterface paramIHostInterface);
  
  public abstract boolean upgradePlugin(IHostInterface paramIHostInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.kwstudio.office.debug.IDebugger
 * JD-Core Version:    0.7.0.1
 */