package com.tencent.av.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.BaseActivity;

class ShareActionSheetBuilder$ActionSheetAdapter
  extends BaseAdapter
{
  public int getCount()
  {
    return 5;
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
      localView = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2131629572, null);
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
          if (paramInt == 3)
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
      localView.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(k));
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.ShareActionSheetBuilder.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */