package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class TroopClassChoiceActivity$TroopClassChoiceAdapter
  extends BaseAdapter
{
  TroopClassChoiceActivity$TroopClassChoiceAdapter(TroopClassChoiceActivity paramTroopClassChoiceActivity) {}
  
  public int getCount()
  {
    if (this.a.a != null) {
      return this.a.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.a.getLayoutInflater().inflate(2131629564, null);
    }
    TextView localTextView1 = (TextView)localView.findViewById(2131447917);
    TextView localTextView2 = (TextView)localView.findViewById(2131447916);
    ImageView localImageView = (ImageView)localView.findViewById(2131439594);
    GroupCatalogBean localGroupCatalogBean2 = (GroupCatalogBean)this.a.a.get(paramInt);
    if ((this.a.b != null) && (localGroupCatalogBean2.a < this.a.b.a))
    {
      Object localObject = this.a.b;
      GroupCatalogBean localGroupCatalogBean1;
      for (paramView = ((GroupCatalogBean)localObject).e; (paramView != null) && (paramView.a >= localGroupCatalogBean2.a); paramView = localGroupCatalogBean1)
      {
        if (localGroupCatalogBean2.c.equals(paramView.c))
        {
          i = 1;
          break label172;
        }
        localGroupCatalogBean1 = paramView.e;
        localObject = paramView;
      }
      int i = 0;
      label172:
      if (i != 0)
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(((GroupCatalogBean)localObject).b);
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130853332, 0);
      }
      else
      {
        localTextView2.setVisibility(4);
      }
    }
    else if ((this.a.b != null) && (localGroupCatalogBean2.c.equals(this.a.b.c)))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText("");
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130853332, 0);
    }
    else
    {
      localTextView2.setVisibility(4);
    }
    localTextView1.setText(localGroupCatalogBean2.b);
    if ((localGroupCatalogBean2.d != null) && (localGroupCatalogBean2.d.size() > 0)) {
      localImageView.setVisibility(0);
    } else {
      localImageView.setVisibility(4);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity.TroopClassChoiceAdapter
 * JD-Core Version:    0.7.0.1
 */