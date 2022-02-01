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
import yax;
import ybl;
import ydz;
import yea;
import yee;
import yef;
import yeg;
import yeh;
import yel;
import yem;
import yeq;
import yes;
import zpa;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<zpa> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yax jdField_a_of_type_Yax;
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
    zpa localzpa;
    if (localIterator.hasNext())
    {
      localzpa = (zpa)localIterator.next();
      if ((localzpa instanceof yea)) {
        i = localzpa.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzpa.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new yeq(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new yes(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new ydz(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yeh(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yem(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yee(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yel(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yea(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yef(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yeg(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((zpa)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130850415);
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
      zpa localzpa = (zpa)localIterator.next();
      if ((localzpa instanceof yeh)) {
        return false;
      }
      if (localzpa.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Yax != null) {
      this.jdField_a_of_type_Yax.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zpa localzpa;
    for (int i = 0;; i = localzpa.a() + i) {
      if (localIterator.hasNext())
      {
        localzpa = (zpa)localIterator.next();
        if (!(localzpa instanceof yea)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(ybl paramybl)
  {
    yeq localyeq = (yeq)a("GeneralFeedProfileSegment");
    yes localyes = (yes)a("ShareGroupFeedProfileSegment");
    ydz localydz = (ydz)a("BannerProfileSegment");
    yeh localyeh = (yeh)a("DetailInteractSegment");
    yee localyee = (yee)a("DetailDoubleTabSegment");
    yel localyel = (yel)a("DetailLikeListSegment");
    yea localyea = (yea)a("DetailCommentSegment");
    localyeq.a(paramybl);
    localyes.a(paramybl);
    localydz.a(paramybl);
    localyeh.a(paramybl);
    localyee.a(paramybl);
    localyel.a(paramybl);
    localyea.a(paramybl);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      zpa localzpa;
      if (localIterator.hasNext())
      {
        localzpa = (zpa)localIterator.next();
        if (!(localzpa instanceof yeh)) {}
      }
      else
      {
        return;
      }
      localzpa.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(yax paramyax)
  {
    this.jdField_a_of_type_Yax = paramyax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */