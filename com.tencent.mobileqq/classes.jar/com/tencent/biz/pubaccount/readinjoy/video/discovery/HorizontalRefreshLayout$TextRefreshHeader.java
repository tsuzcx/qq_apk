package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HorizontalRefreshLayout$TextRefreshHeader
  implements HorizontalRefreshLayout.RefreshHeader
{
  public TextView a;
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560433, paramViewGroup, false);
    this.a = ((TextView)paramViewGroup.findViewById(2131365890));
    this.a.setText("继续滑动\n进入详情");
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.HorizontalRefreshLayout.TextRefreshHeader
 * JD-Core Version:    0.7.0.1
 */