package com.tencent.biz.qqstory.storyHome.detail.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xgd;
import xgr;
import xjf;
import xjg;
import xjk;
import xjl;
import xjm;
import xjn;
import xjr;
import xjs;
import xjw;
import xjy;
import ysg;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<ysg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xgd jdField_a_of_type_Xgd;
  public int b;
  
  public StoryDetailListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryDetailListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StoryDetailListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public int a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    ysg localysg;
    if (localIterator.hasNext())
    {
      localysg = (ysg)localIterator.next();
      if ((localysg instanceof xjg)) {
        i = localysg.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localysg.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new xjw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new xjy(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new xjf(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjn(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjs(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjk(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjr(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjg(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjl(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xjm(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((ysg)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130850348);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(1);
      return;
    }
    super.a(1, e);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ysg localysg = (ysg)localIterator.next();
      if ((localysg instanceof xjn)) {
        return false;
      }
      if (localysg.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    ysg localysg;
    for (int i = 0;; i = localysg.a() + i) {
      if (localIterator.hasNext())
      {
        localysg = (ysg)localIterator.next();
        if (!(localysg instanceof xjg)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Xgd != null) {
      this.jdField_a_of_type_Xgd.a();
    }
    return true;
  }
  
  public void setCallback(xgr paramxgr)
  {
    xjw localxjw = (xjw)a("GeneralFeedProfileSegment");
    xjy localxjy = (xjy)a("ShareGroupFeedProfileSegment");
    xjf localxjf = (xjf)a("BannerProfileSegment");
    xjn localxjn = (xjn)a("DetailInteractSegment");
    xjk localxjk = (xjk)a("DetailDoubleTabSegment");
    xjr localxjr = (xjr)a("DetailLikeListSegment");
    xjg localxjg = (xjg)a("DetailCommentSegment");
    localxjw.a(paramxgr);
    localxjy.a(paramxgr);
    localxjf.a(paramxgr);
    localxjn.a(paramxgr);
    localxjk.a(paramxgr);
    localxjr.a(paramxgr);
    localxjg.a(paramxgr);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      ysg localysg;
      if (localIterator.hasNext())
      {
        localysg = (ysg)localIterator.next();
        if (!(localysg instanceof xjn)) {}
      }
      else
      {
        return;
      }
      localysg.d_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(xgd paramxgd)
  {
    this.jdField_a_of_type_Xgd = paramxgd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */