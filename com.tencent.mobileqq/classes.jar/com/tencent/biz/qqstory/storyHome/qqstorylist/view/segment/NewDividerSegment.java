package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class NewDividerSegment
  extends SegmentView
{
  public static final String KEY = "NewDividerSegment";
  
  public NewDividerSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2130970708, paramViewGroup, false));
  }
  
  public String a()
  {
    return "NewDividerSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewDividerSegment
 * JD-Core Version:    0.7.0.1
 */