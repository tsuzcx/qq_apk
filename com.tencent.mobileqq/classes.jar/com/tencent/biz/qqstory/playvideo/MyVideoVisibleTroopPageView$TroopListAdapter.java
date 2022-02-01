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
    TroopInfo localTroopInfo = (TroopInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      paramView = new MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder(this);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561997, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368336));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372288));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopInfo.getTroopDisplayName());
      Object localObject = PlayModeUtils.a().getTroopFaceDrawable(localTroopInfo.troopuin);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */