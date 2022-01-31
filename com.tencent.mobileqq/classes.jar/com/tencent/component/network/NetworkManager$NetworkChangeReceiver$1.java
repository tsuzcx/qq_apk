package com.tencent.component.network;

import com.tencent.component.network.module.common.DnsService;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class NetworkManager$NetworkChangeReceiver$1
  implements Runnable
{
  NetworkManager$NetworkChangeReceiver$1(NetworkManager.NetworkChangeReceiver paramNetworkChangeReceiver) {}
  
  public void run()
  {
    String str1 = this.this$0.getApnValue();
    if ((NetworkManager.isNetworkAvailable()) && (!str1.equals(NetworkManager.NetworkChangeReceiver.access$000(this.this$0)))) {
      DnsService.getInstance().reset();
    }
    if (!str1.equals(NetworkManager.NetworkChangeReceiver.access$000(this.this$0))) {
      synchronized (NetworkManager.access$100())
      {
        Iterator localIterator = NetworkManager.access$200().iterator();
        while (localIterator.hasNext())
        {
          NetworkManager.NetStatusListener localNetStatusListener = (NetworkManager.NetStatusListener)((WeakReference)localIterator.next()).get();
          if (localNetStatusListener != null) {
            localNetStatusListener.onNetworkChanged(NetworkManager.NetworkChangeReceiver.access$000(this.this$0), str1);
          }
        }
      }
    }
    NetworkManager.NetworkChangeReceiver.access$002(this.this$0, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager.NetworkChangeReceiver.1
 * JD-Core Version:    0.7.0.1
 */