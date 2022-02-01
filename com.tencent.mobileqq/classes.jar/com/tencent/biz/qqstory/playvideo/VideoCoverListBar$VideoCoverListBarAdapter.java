package com.tencent.biz.qqstory.playvideo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class VideoCoverListBar$VideoCoverListBarAdapter
  extends BaseAdapter
{
  private VideoCoverListBar$VideoCoverListBarAdapter(VideoCoverListBar paramVideoCoverListBar) {}
  
  public String a(int paramInt)
  {
    return (String)VideoCoverListBar.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return VideoCoverListBar.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131561741, null);
      paramView = new VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder(this, localView);
      localView.setTag(paramView);
    }
    else
    {
      VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder localViewHolder = (VideoCoverListBar.VideoCoverListBarAdapter.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localViewHolder;
    }
    paramView.a(paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.VideoCoverListBar.VideoCoverListBarAdapter
 * JD-Core Version:    0.7.0.1
 */