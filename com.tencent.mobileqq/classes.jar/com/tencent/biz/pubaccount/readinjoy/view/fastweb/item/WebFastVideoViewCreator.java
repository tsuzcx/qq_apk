package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import mnq;

public class WebFastVideoViewCreator
  implements ItemCreator
{
  public int a(BaseData paramBaseData)
  {
    return 5;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new mnq(LayoutInflater.from(paramContext).inflate(2130969622, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.d == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastVideoViewCreator
 * JD-Core Version:    0.7.0.1
 */