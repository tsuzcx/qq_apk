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
    if (paramView == null) {
      paramView = LayoutInflater.from(ShareActionSheetBuilder.a(this.a)).inflate(2131563141, null);
    }
    for (;;)
    {
      int j;
      int k;
      int i;
      switch (paramInt)
      {
      default: 
        j = 2131719302;
        k = 2130839210;
        i = 2131719735;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362887);
        TextView localTextView = (TextView)paramView.findViewById(2131362899);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.d) {
          paramView.setContentDescription(ShareActionSheetBuilder.a(this.a).getString(i));
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        j = 2131719316;
        k = 2130839214;
        i = 2131719752;
        continue;
        j = 2131719318;
        k = 2130839215;
        i = 2131719753;
        continue;
        j = 2131719323;
        k = 2130839218;
        i = 2131719760;
        continue;
        j = 2131719314;
        k = 2130839212;
        i = 2131719742;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.ShareActionSheetBuilder.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */