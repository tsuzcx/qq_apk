package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.position.SelectCityAdapter.CityData;
import java.util.List;

public abstract interface SelectPositionModule$IPositionOrCityListChangedListener
{
  public abstract void a(SelectPositionModule.PositionData paramPositionData);
  
  public abstract void a(List<SelectCityAdapter.CityData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.IPositionOrCityListChangedListener
 * JD-Core Version:    0.7.0.1
 */