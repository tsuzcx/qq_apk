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
    paramViewGroup = (SlideTabViewPager)paramBaseViewHolder.a(2131442659);
    TextView localTextView1;
    TextView localTextView2;
    if (paramViewGroup.getTabCount() == 0)
    {
      localTextView1 = new TextView(this.l);
      localTextView2 = new TextView(this.l);
      localTextView1.setText(HardCodeUtil.a(2131901542));
      localTextView2.setText(HardCodeUtil.a(2131901541));
      paramViewGroup.a(0, HardCodeUtil.a(2131901539), localTextView1);
      paramViewGroup.a(1, HardCodeUtil.a(2131901544), localTextView2);
      paramViewGroup.a(0);
    }
    else
    {
      localTextView1 = new TextView(this.l);
      localTextView2 = new TextView(this.l);
      localTextView1.setText(HardCodeUtil.a(2131901546));
      localTextView2.setText(HardCodeUtil.a(2131901540));
      paramViewGroup.b(0, HardCodeUtil.a(2131901543), localTextView1);
      paramViewGroup.b(1, HardCodeUtil.a(2131901545), localTextView2);
    }
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628018, paramViewGroup, false));
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DoubleCommentSegment
 * JD-Core Version:    0.7.0.1
 */