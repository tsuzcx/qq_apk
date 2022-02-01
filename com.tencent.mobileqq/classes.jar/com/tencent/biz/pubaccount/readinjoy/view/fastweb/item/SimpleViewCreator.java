package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.widget.HorizontalLabelLayout;

public class SimpleViewCreator
  implements ItemCreator
{
  public int a(BaseData paramBaseData)
  {
    switch (paramBaseData.s)
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
    case 15: 
      return 13;
    }
    return 14;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    switch (a(paramBaseData))
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      throw new IllegalArgumentException();
    case 7: 
      return new SimpleViewCreator.TitleHeaderViewHolder(this, localLayoutInflater.inflate(2131560304, paramViewGroup, false), paramBaseData);
    case 8: 
      return new SimpleViewCreator.CommonBottomViewHolder(this, localLayoutInflater.inflate(2131560301, paramViewGroup, false), paramBaseData);
    case 13: 
      paramViewGroup = new HorizontalLabelLayout(paramContext);
      int i = AIOUtils.a(15.0F, paramContext.getResources());
      paramViewGroup.setPadding(i, 0, i, 0);
      return new SimpleViewCreator.ArticleTopicFlagViewHolder(this, paramViewGroup, paramBaseData);
    }
    return new SimpleViewCreator.NoCommentBgViewHolder(this, localLayoutInflater.inflate(2131560231, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.s == 7) || (paramBaseData.s == 8) || (paramBaseData.s == 13) || (paramBaseData.s == 14) || (paramBaseData.s == 15) || (paramBaseData.s == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.SimpleViewCreator
 * JD-Core Version:    0.7.0.1
 */