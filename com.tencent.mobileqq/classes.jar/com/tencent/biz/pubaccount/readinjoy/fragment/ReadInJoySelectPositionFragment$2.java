package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.position.SelectCityAdapter.CityData;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class ReadInJoySelectPositionFragment$2
  implements AdapterView.OnItemClickListener
{
  ReadInJoySelectPositionFragment$2(ReadInJoySelectPositionFragment paramReadInJoySelectPositionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt <= 0) {}
    do
    {
      return;
      paramAdapterView = (SelectCityAdapter.CityData)ReadInJoySelectPositionFragment.a(this.a).get(paramInt - 1);
    } while (paramAdapterView.a != 2);
    this.a.a(new SelectPositionModule.PositionData(paramAdapterView.d, paramAdapterView.c, paramAdapterView.b, paramAdapterView.e));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelectPositionFragment.2
 * JD-Core Version:    0.7.0.1
 */