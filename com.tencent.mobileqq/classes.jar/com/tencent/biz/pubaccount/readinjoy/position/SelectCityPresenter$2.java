package com.tencent.biz.pubaccount.readinjoy.position;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import mqq.util.WeakReference;
import pcr;
import pcs;

public class SelectCityPresenter$2
  implements Runnable
{
  public SelectCityPresenter$2(pcr parampcr, SelectPositionModule.PositionData paramPositionData) {}
  
  public void run()
  {
    pcs localpcs = (pcs)pcr.a(this.this$0).get();
    if (localpcs != null) {
      localpcs.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2
 * JD-Core Version:    0.7.0.1
 */