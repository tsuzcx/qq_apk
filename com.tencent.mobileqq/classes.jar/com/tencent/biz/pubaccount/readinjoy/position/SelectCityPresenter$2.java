package com.tencent.biz.pubaccount.readinjoy.position;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import mqq.util.WeakReference;
import psn;
import pso;

public class SelectCityPresenter$2
  implements Runnable
{
  public SelectCityPresenter$2(psn parampsn, SelectPositionModule.PositionData paramPositionData) {}
  
  public void run()
  {
    pso localpso = (pso)psn.a(this.this$0).get();
    if (localpso != null) {
      localpso.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2
 * JD-Core Version:    0.7.0.1
 */