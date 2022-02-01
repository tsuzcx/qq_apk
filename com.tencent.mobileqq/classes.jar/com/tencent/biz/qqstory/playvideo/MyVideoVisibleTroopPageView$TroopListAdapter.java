package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class MyVideoVisibleTroopPageView$TroopListAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  List<TroopInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public MyVideoVisibleTroopPageView$TroopListAdapter(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List<TroopInfo> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder(this);
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561831, null);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368087));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder)paramView.getTag();
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((TroopInfo)localObject).getTroopDisplayName());
    localObject = PlayModeUtils.a().getTroopFaceDrawable(((TroopInfo)localObject).troopuin);
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */