package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class MemoriesPlaceHolderSegment
  extends SegmentView
{
  public static final String KEY = "MemoriesPlaceHolderSegment";
  
  public MemoriesPlaceHolderSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = UIUtils.d(this.a);
    int i = UIUtils.e(this.a);
    paramBaseViewHolder.a().getLayoutParams().height = (paramInt - i);
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2131561707, paramViewGroup, false));
  }
  
  public String a()
  {
    return "MemoriesPlaceHolderSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesPlaceHolderSegment
 * JD-Core Version:    0.7.0.1
 */