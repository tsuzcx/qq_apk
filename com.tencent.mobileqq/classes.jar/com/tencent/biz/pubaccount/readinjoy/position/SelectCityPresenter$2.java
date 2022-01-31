package com.tencent.biz.pubaccount.readinjoy.position;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import mqq.util.WeakReference;
import pco;
import pcp;

public class SelectCityPresenter$2
  implements Runnable
{
  public SelectCityPresenter$2(pco parampco, SelectPositionModule.PositionData paramPositionData) {}
  
  public void run()
  {
    pcp localpcp = (pcp)pco.a(this.this$0).get();
    if (localpcp != null) {
      localpcp.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2
 * JD-Core Version:    0.7.0.1
 */