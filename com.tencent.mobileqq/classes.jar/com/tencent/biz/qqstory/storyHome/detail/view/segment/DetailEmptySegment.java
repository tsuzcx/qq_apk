package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.segment.SegmentView;

public class DetailEmptySegment
  extends SegmentView
{
  public static final String KEY = "DetailEmptySegment";
  
  public DetailEmptySegment(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void J_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramInt = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getTitleBarHeight();
    int i = UIUtils.c(this.jdField_a_of_type_AndroidContentContext);
    int j = UIUtils.a(this.jdField_a_of_type_AndroidContentContext);
    int k = UIUtils.b(this.jdField_a_of_type_AndroidContentContext);
    paramBaseViewHolder.a().getLayoutParams().width = j;
    paramBaseViewHolder.a().getLayoutParams().height = (k - paramInt - i);
    SLog.b("Q.qqstory.detail.DetailEmptySegment", "titleBarHeight=%d, statusBarHeight=%d, screenHeight=%d.", Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(k));
    return paramBaseViewHolder.a();
  }
  
  public BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970702, paramViewGroup, false));
  }
  
  public String a()
  {
    return "DetailEmptySegment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptySegment
 * JD-Core Version:    0.7.0.1
 */