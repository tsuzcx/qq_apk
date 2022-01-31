package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class NullSegmentView
  extends SegmentView
{
  private final String a;
  
  public NullSegmentView(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a_(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NullSegmentView
 * JD-Core Version:    0.7.0.1
 */