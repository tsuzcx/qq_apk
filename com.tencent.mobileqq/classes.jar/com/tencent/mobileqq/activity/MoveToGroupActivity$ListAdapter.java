package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.data.Groups;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class MoveToGroupActivity$ListAdapter
  extends BaseAdapter
{
  private MoveToGroupActivity$ListAdapter(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public int getCount()
  {
    if (MoveToGroupActivity.a(this.a) != null) {
      return MoveToGroupActivity.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null) {
      localView = this.a.getLayoutInflater().inflate(2131559471, null);
    } else {
      localView = paramView;
    }
    int i = (byte)((Groups)MoveToGroupActivity.a(this.a).get(paramInt)).group_id;
    Object localObject = (ImageView)localView.findViewById(2131364622);
    if (i == MoveToGroupActivity.a(this.a)) {
      ((ImageView)localObject).setVisibility(0);
    } else {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = (TextView)localView.findViewById(2131367879);
    ((TextView)localObject).setText(((Groups)MoveToGroupActivity.a(this.a).get(paramInt)).group_name);
    localView.setContentDescription(((TextView)localObject).getText().toString());
    localView.setTag(Integer.valueOf(paramInt));
    localView.setOnClickListener(this.a);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */