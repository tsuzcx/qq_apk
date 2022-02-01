package com.tencent.biz.qqstory.playvideo.floatdialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.widget.AbsListView.LayoutParams;

public class EmptyPlaceHolderSegment
  extends SegmentView
{
  public static final String KEY = "EmptyPlaceHolderSegment";
  private final int a;
  private BaseViewHolder b;
  
  public EmptyPlaceHolderSegment(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
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
    paramViewGroup = new View(this.l);
    paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, this.a));
    if (QQStoryContext.e()) {
      paramViewGroup.setBackgroundColor(this.l.getResources().getColor(2131167383));
    } else {
      paramViewGroup.setBackgroundColor(this.l.getResources().getColor(2131165875));
    }
    this.b = new BaseViewHolder(paramViewGroup);
    return this.b;
  }
  
  public String b()
  {
    return "EmptyPlaceHolderSegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.floatdialog.EmptyPlaceHolderSegment
 * JD-Core Version:    0.7.0.1
 */