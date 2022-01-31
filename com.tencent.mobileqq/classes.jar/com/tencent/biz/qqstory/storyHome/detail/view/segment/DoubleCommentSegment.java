package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;

public class DoubleCommentSegment
  extends SegmentView
{
  public DoubleCommentSegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramViewGroup = (SlideTabViewPager)paramBaseViewHolder.a(2131371523);
    TextView localTextView1;
    TextView localTextView2;
    if (paramViewGroup.a() == 0)
    {
      localTextView1 = new TextView(this.a);
      localTextView2 = new TextView(this.a);
      localTextView1.setText("我就随便写点东西");
      localTextView2.setText("爱上快递费开啦伺机待发啊是打开链接发");
      paramViewGroup.a(0, "好友", localTextView1);
      paramViewGroup.a(1, "粉丝", localTextView2);
      paramViewGroup.a(0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      localTextView1 = new TextView(this.a);
      localTextView2 = new TextView(this.a);
      localTextView1.setText("我这次有数据啦");
      localTextView2.setText("我也有数据啦");
      paramViewGroup.a(0, "好友", localTextView1);
      paramViewGroup.a(1, "粉丝", localTextView2);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2130970653, paramViewGroup, false));
  }
  
  public String a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DoubleCommentSegment
 * JD-Core Version:    0.7.0.1
 */