package com.tencent.mobileqq.activity.discussion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LinkShareActionSheetBuilder$ActionSheetAdapter
  extends BaseAdapter
{
  private LinkShareActionSheetBuilder$ActionSheetAdapter(LinkShareActionSheetBuilder paramLinkShareActionSheetBuilder) {}
  
  public int getCount()
  {
    return 6;
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
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2131562964, null);
    }
    int i = 2130839063;
    int j = 2131719020;
    int k = 2131719459;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 5)
            {
              i = 2130842548;
              j = 2131716658;
              k = 2131716658;
            }
          }
          else
          {
            j = 2131719032;
            i = 2130839065;
            k = 2131719466;
          }
        }
        else
        {
          j = 2131719041;
          i = 2130839071;
          k = 2131719484;
        }
      }
      else
      {
        j = 2131719036;
        i = 2130839068;
        k = 2131719477;
      }
    }
    else
    {
      j = 2131719034;
      i = 2130839067;
      k = 2131719476;
    }
    paramView = (ImageView)localView.findViewById(2131362839);
    TextView localTextView = (TextView)localView.findViewById(2131362851);
    paramView.setImageResource(i);
    localTextView.setText(j);
    if (AppSetting.d) {
      localView.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(k));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */