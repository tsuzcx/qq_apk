package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.mobileqq.app.BaseActivity;

public class DetailEmptySegment
  extends SegmentView
{
  public static final String KEY = "DetailEmptySegment";
  
  public DetailEmptySegment(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.m) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    if ((this.l instanceof BaseActivity)) {
      paramInt = ((BaseActivity)this.l).getTitleBarHeight();
    } else {
      paramInt = 0;
    }
    int i = UIUtils.f(this.l);
    int j = UIUtils.b(this.l);
    int k = UIUtils.e(this.l);
    paramBaseViewHolder.a().getLayoutParams().width = j;
    paramBaseViewHolder.a().getLayoutParams().height = (k - paramInt - i);
    SLog.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.l).inflate(2131628021, paramViewGroup, false));
  }
  
  public String b()
  {
    return "DetailEmptySegment";
  }
  
  public void br_()
  {
    if (((StoryDetailListView)w()).b())
    {
      this.m = false;
      return;
    }
    this.m = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptySegment
 * JD-Core Version:    0.7.0.1
 */