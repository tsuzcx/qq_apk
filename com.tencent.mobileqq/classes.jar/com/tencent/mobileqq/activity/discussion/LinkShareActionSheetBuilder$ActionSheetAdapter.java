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
      localView = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2131629572, null);
    }
    int i = 2130839217;
    int j = 2131916556;
    int k = 2131917020;
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
              i = 2130843501;
              j = 2131914121;
              k = 2131914121;
            }
          }
          else
          {
            j = 2131916568;
            i = 2130839219;
            k = 2131917028;
          }
        }
        else
        {
          j = 2131916577;
          i = 2130839225;
          k = 2131917047;
        }
      }
      else
      {
        j = 2131916572;
        i = 2130839222;
        k = 2131917040;
      }
    }
    else
    {
      j = 2131916570;
      i = 2130839221;
      k = 2131917039;
    }
    paramView = (ImageView)localView.findViewById(2131428619);
    TextView localTextView = (TextView)localView.findViewById(2131428632);
    paramView.setImageResource(i);
    localTextView.setText(j);
    if (AppSetting.e) {
      localView.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(k));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */