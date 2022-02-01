package com.qq.android.dexposed.callbacks;

import android.os.Bundle;
import com.qq.android.dexposed.DexposedBridge.CopyOnWriteSortedSet;

public class XCallback$Param
{
  public final Object[] callbacks;
  private Bundle extra;
  
  protected XCallback$Param()
  {
    this.callbacks = null;
  }
  
  protected XCallback$Param(DexposedBridge.CopyOnWriteSortedSet<? extends XCallback> paramCopyOnWriteSortedSet)
  {
    this.callbacks = paramCopyOnWriteSortedSet.getSnapshot();
  }
  
  public Bundle getExtra()
  {
    try
    {
      if (this.extra == null) {
        this.extra = new Bundle();
      }
      Bundle localBundle = this.extra;
      return localBundle;
    }
    finally {}
  }
  
  public Object getObjectExtra(String paramString)
  {
    paramString = getExtra().getSerializable(paramString);
    if ((paramString instanceof XCallback.Param.SerializeWrapper)) {
      return XCallback.Param.SerializeWrapper.access$0((XCallback.Param.SerializeWrapper)paramString);
    }
    return null;
  }
  
  public void setObjectExtra(String paramString, Object paramObject)
  {
    getExtra().putSerializable(paramString, new XCallback.Param.SerializeWrapper(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.callbacks.XCallback.Param
 * JD-Core Version:    0.7.0.1
 */