package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import mnd;

public class WebFastAttachedAdCreator
  implements ItemCreator
{
  public int a(BaseData paramBaseData)
  {
    return 11;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new mnd(LayoutInflater.from(paramContext).inflate(2130969608, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.d == 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastAttachedAdCreator
 * JD-Core Version:    0.7.0.1
 */