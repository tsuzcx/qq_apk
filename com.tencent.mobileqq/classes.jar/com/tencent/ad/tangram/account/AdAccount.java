package com.tencent.ad.tangram.account;

import android.support.annotation.Keep;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public enum AdAccount
{
  INSTANCE;
  
  private static final String TAG = "AdAccount";
  private CopyOnWriteArrayList<AdAccountListener> listeners = new CopyOnWriteArrayList();
  
  private AdAccount() {}
  
  public void addAccountListener(AdAccountListener paramAdAccountListener)
  {
    if (!this.listeners.contains(paramAdAccountListener)) {
      this.listeners.add(paramAdAccountListener);
    }
  }
  
  public void onAccountStatusChanged(String paramString1, String paramString2)
  {
    Object localObject = this.listeners;
    if ((localObject != null) && (!((CopyOnWriteArrayList)localObject).isEmpty()))
    {
      localObject = this.listeners.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AdAccountListener localAdAccountListener = (AdAccountListener)((Iterator)localObject).next();
        if (localAdAccountListener != null) {
          localAdAccountListener.onAccountStatusChanged(paramString1, paramString2);
        }
      }
    }
  }
  
  public void removeAccountListener(AdAccountListener paramAdAccountListener)
  {
    if (this.listeners.contains(paramAdAccountListener)) {
      this.listeners.remove(paramAdAccountListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.account.AdAccount
 * JD-Core Version:    0.7.0.1
 */