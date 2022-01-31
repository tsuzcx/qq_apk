package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.HorizontalLabelLayout;
import mqs;
import mqt;
import mqu;

public class SimpleViewCreator
  implements ItemCreator
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.d)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
    case 13: 
      return 7;
    case 8: 
    case 14: 
      return 8;
    }
    return 13;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    switch (a(paramBaseData))
    {
    default: 
      throw new IllegalArgumentException();
    case 7: 
      return new mqu(this, localLayoutInflater.inflate(2130969611, paramViewGroup, false), paramBaseData);
    case 8: 
      return new mqt(this, localLayoutInflater.inflate(2130969607, paramViewGroup, false), paramBaseData);
    }
    paramViewGroup = new HorizontalLabelLayout(paramContext);
    int i = AIOUtils.a(15.0F, paramContext.getResources());
    paramViewGroup.setPadding(i, 0, i, 0);
    return new mqs(this, paramViewGroup, paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.d == 7) || (paramBaseData.d == 8) || (paramBaseData.d == 13) || (paramBaseData.d == 14) || (paramBaseData.d == 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.SimpleViewCreator
 * JD-Core Version:    0.7.0.1
 */