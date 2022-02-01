package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletApiProxy.OnDecodeListener;
import com.tencent.image.URLDrawable;

class QWalletApiProxyImpl$1
  implements Runnable
{
  QWalletApiProxyImpl$1(QWalletApiProxyImpl paramQWalletApiProxyImpl, URLDrawable paramURLDrawable, IQWalletApiProxy.OnDecodeListener paramOnDecodeListener) {}
  
  public void run()
  {
    int i = this.a.getStatus();
    boolean bool = true;
    if (i == 1)
    {
      ??? = this.b;
      if (??? != null) {
        ((IQWalletApiProxy.OnDecodeListener)???).a(true, this.a);
      }
    }
    else
    {
      if (this.a.getConstantState() != null) {
        synchronized (this.a.getConstantState())
        {
          this.a.downloadImediatly();
        }
      }
      ??? = this.b;
      if (??? != null)
      {
        if (this.a.getStatus() != 1) {
          bool = false;
        }
        ((IQWalletApiProxy.OnDecodeListener)???).a(bool, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletApiProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */