package com.tencent.ad.tangram.settings;

import java.lang.ref.WeakReference;

class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public void run()
  {
    if ((a.access$500(this.this$0) != null) && (a.access$500(this.this$0).get() != null)) {
      ((AdSettingsManager.Listener)a.access$500(this.this$0).get()).onUpdated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.settings.a.3
 * JD-Core Version:    0.7.0.1
 */