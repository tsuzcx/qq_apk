package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;

public abstract interface ItemCreator
{
  public abstract int a(BaseData paramBaseData);
  
  public abstract BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup);
  
  public abstract boolean a(BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.ItemCreator
 * JD-Core Version:    0.7.0.1
 */