package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import pkm;
import puc;

public final class RIJDataFetchManager$1
  implements Runnable
{
  public RIJDataFetchManager$1(int paramInt) {}
  
  public void run()
  {
    puc localpuc = pkm.a().a();
    if (localpuc != null) {
      localpuc.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataFetchManager.1
 * JD-Core Version:    0.7.0.1
 */