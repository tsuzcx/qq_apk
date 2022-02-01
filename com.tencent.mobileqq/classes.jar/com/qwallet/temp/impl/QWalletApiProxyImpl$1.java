package com.qwallet.temp.impl;

import com.qwallet.temp.IQWalletApiProxy.OnDecodeListener;
import com.tencent.image.URLDrawable;

class QWalletApiProxyImpl$1
  implements Runnable
{
  QWalletApiProxyImpl$1(QWalletApiProxyImpl paramQWalletApiProxyImpl, URLDrawable paramURLDrawable, IQWalletApiProxy.OnDecodeListener paramOnDecodeListener) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    boolean bool = true;
    if (i == 1)
    {
      ??? = this.jdField_a_of_type_ComQwalletTempIQWalletApiProxy$OnDecodeListener;
      if (??? != null) {
        ((IQWalletApiProxy.OnDecodeListener)???).a(true, this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getConstantState() != null) {
        synchronized (this.jdField_a_of_type_ComTencentImageURLDrawable.getConstantState())
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
        }
      }
      ??? = this.jdField_a_of_type_ComQwalletTempIQWalletApiProxy$OnDecodeListener;
      if (??? != null)
      {
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() != 1) {
          bool = false;
        }
        ((IQWalletApiProxy.OnDecodeListener)???).a(bool, this.jdField_a_of_type_ComTencentImageURLDrawable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletApiProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */