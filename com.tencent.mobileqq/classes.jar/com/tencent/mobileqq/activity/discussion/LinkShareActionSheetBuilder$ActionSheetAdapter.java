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
    if (paramView == null) {
      paramView = LayoutInflater.from(LinkShareActionSheetBuilder.a(this.a)).inflate(2131563141, null);
    }
    for (;;)
    {
      int k;
      int j;
      int i;
      switch (paramInt)
      {
      case 4: 
      default: 
        k = 2130839210;
        j = 2131719302;
        i = 2131719735;
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131362887);
        TextView localTextView = (TextView)paramView.findViewById(2131362899);
        localImageView.setImageResource(k);
        localTextView.setText(j);
        if (AppSetting.d) {
          paramView.setContentDescription(LinkShareActionSheetBuilder.a(this.a).getString(i));
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
        continue;
        i = 2131717005;
        j = 2131717005;
        k = 2130842649;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.discussion.LinkShareActionSheetBuilder.ActionSheetAdapter
 * JD-Core Version:    0.7.0.1
 */