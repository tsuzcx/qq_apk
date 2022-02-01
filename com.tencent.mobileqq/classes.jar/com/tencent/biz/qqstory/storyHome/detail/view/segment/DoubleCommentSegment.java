package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.biz.qqstory.view.widget.SlideTabViewPager;
import com.tencent.mobileqq.app.HardCodeUtil;

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
    paramViewGroup = (SlideTabViewPager)paramBaseViewHolder.a(2131374957);
    TextView localTextView1;
    TextView localTextView2;
    if (paramViewGroup.a() == 0)
    {
      localTextView1 = new TextView(this.a);
      localTextView2 = new TextView(this.a);
      localTextView1.setText(HardCodeUtil.a(2131703460));
      localTextView2.setText(HardCodeUtil.a(2131703459));
      paramViewGroup.a(0, HardCodeUtil.a(2131703457), localTextView1);
      paramViewGroup.a(1, HardCodeUtil.a(2131703462), localTextView2);
      paramViewGroup.a(0);
    }
    for (;;)
    {
      return paramBaseViewHolder.a();
      localTextView1 = new TextView(this.a);
      localTextView2 = new TextView(this.a);
      localTextView1.setText(HardCodeUtil.a(2131703464));
      localTextView2.setText(HardCodeUtil.a(2131703458));
      paramViewGroup.a(0, HardCodeUtil.a(2131703461), localTextView1);
      paramViewGroup.a(1, HardCodeUtil.a(2131703463), localTextView2);
    }
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2131561777, paramViewGroup, false));
  }
  
  public String a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DoubleCommentSegment
 * JD-Core Version:    0.7.0.1
 */