package com.tencent.biz.pubaccount.readinjoy.position;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.IPositionOrCityListChangedListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.qav.thread.ThreadManager;
import java.util.List;
import mqq.util.WeakReference;

public class SelectCityPresenter
  implements SelectPositionModule.IPositionOrCityListChangedListener
{
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = ReadInJoyLogicEngine.a().a();
  private WeakReference<SelectCityPresenter.IView> jdField_a_of_type_MqqUtilWeakReference;
  
  public SelectCityPresenter(SelectCityPresenter.IView paramIView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIView);
  }
  
  private void b(List<SelectCityAdapter.CityData> paramList)
  {
    SelectCityPresenter.IView localIView = (SelectCityPresenter.IView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localIView != null) && (paramList != null)) {
      localIView.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(SelectPositionModule.PositionData paramPositionData)
  {
    ThreadManager.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<SelectCityAdapter.CityData> paramList)
  {
    ThreadManager.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.position.SelectCityPresenter
 * JD-Core Version:    0.7.0.1
 */