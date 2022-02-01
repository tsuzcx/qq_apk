package com.qwallet.temp.impl;

import com.qwallet.temp.IConditionSearchManager.IConfigListenerProxy;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

class ConditionSearchManagerImpl$1
  implements ConditionSearchManager.IConfigListener
{
  ConditionSearchManagerImpl$1(ConditionSearchManagerImpl paramConditionSearchManagerImpl, IConditionSearchManager.IConfigListenerProxy paramIConfigListenerProxy) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    IConditionSearchManager.IConfigListenerProxy localIConfigListenerProxy = this.a;
    if (localIConfigListenerProxy != null) {
      localIConfigListenerProxy.a(paramInt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.ConditionSearchManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */