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
import xuy;
import xvm;
import xya;
import xyb;
import xyf;
import xyg;
import xyh;
import xyi;
import xym;
import xyn;
import xyr;
import xyt;
import zgz;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<zgz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private xuy jdField_a_of_type_Xuy;
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
    zgz localzgz;
    if (localIterator.hasNext())
    {
      localzgz = (zgz)localIterator.next();
      if ((localzgz instanceof xyb)) {
        i = localzgz.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzgz.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new xyr(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new xyt(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new xya(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyi(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyn(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyf(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xym(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyb(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyg(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new xyh(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((zgz)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130850454);
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
      zgz localzgz = (zgz)localIterator.next();
      if ((localzgz instanceof xyi)) {
        return false;
      }
      if (localzgz.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zgz localzgz;
    for (int i = 0;; i = localzgz.a() + i) {
      if (localIterator.hasNext())
      {
        localzgz = (zgz)localIterator.next();
        if (!(localzgz instanceof xyb)) {}
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
    if (this.jdField_a_of_type_Xuy != null) {
      this.jdField_a_of_type_Xuy.a();
    }
    return true;
  }
  
  public void setCallback(xvm paramxvm)
  {
    xyr localxyr = (xyr)a("GeneralFeedProfileSegment");
    xyt localxyt = (xyt)a("ShareGroupFeedProfileSegment");
    xya localxya = (xya)a("BannerProfileSegment");
    xyi localxyi = (xyi)a("DetailInteractSegment");
    xyf localxyf = (xyf)a("DetailDoubleTabSegment");
    xym localxym = (xym)a("DetailLikeListSegment");
    xyb localxyb = (xyb)a("DetailCommentSegment");
    localxyr.a(paramxvm);
    localxyt.a(paramxvm);
    localxya.a(paramxvm);
    localxyi.a(paramxvm);
    localxyf.a(paramxvm);
    localxym.a(paramxvm);
    localxyb.a(paramxvm);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      zgz localzgz;
      if (localIterator.hasNext())
      {
        localzgz = (zgz)localIterator.next();
        if (!(localzgz instanceof xyi)) {}
      }
      else
      {
        return;
      }
      localzgz.d_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(xuy paramxuy)
  {
    this.jdField_a_of_type_Xuy = paramxuy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */