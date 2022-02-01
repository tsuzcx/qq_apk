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
  List<TroopInfo> a = new ArrayList();
  Context b;
  
  public MyVideoVisibleTroopPageView$TroopListAdapter(MyVideoVisibleTroopPageView paramMyVideoVisibleTroopPageView, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a(List<TroopInfo> paramList)
  {
    if (paramList != null)
    {
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (TroopInfo)this.a.get(paramInt);
    MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder(this);
      paramView = LayoutInflater.from(this.b).inflate(2131628210, null);
      localViewHolder.a = ((ImageView)paramView.findViewById(2131434940));
      localViewHolder.b = ((TextView)paramView.findViewById(2131439320));
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (MyVideoVisibleTroopPageView.TroopListAdapter.ViewHolder)paramView.getTag();
    }
    localViewHolder.b.setText(((TroopInfo)localObject).getTroopDisplayName());
    localObject = PlayModeUtils.b().getTroopFaceDrawable(((TroopInfo)localObject).troopuin);
    localViewHolder.a.setImageDrawable((Drawable)localObject);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */