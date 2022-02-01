package com.tencent.biz.pubaccount.readinjoy.position;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import mqq.util.WeakReference;

class SelectCityPresenter$2
  implements Runnable
{
  SelectCityPresenter$2(SelectCityPresenter paramSelectCityPresenter, SelectPositionModule.PositionData paramPositionData) {}
  
  public void run()
  {
    SelectCityPresenter.IView localIView = (SelectCityPresenter.IView)SelectCityPresenter.a(this.this$0).get();
    if (localIView != null) {
      localIView.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter.2
 * JD-Core Version:    0.7.0.1
 */