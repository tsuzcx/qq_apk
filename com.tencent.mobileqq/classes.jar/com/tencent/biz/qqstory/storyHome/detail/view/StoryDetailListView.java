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
import whm;
import wia;
import wko;
import wkp;
import wkt;
import wku;
import wkv;
import wkw;
import wla;
import wlb;
import wlf;
import wlh;
import xvp;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<xvp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private whm jdField_a_of_type_Whm;
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
    xvp localxvp;
    if (localIterator.hasNext())
    {
      localxvp = (xvp)localIterator.next();
      if ((localxvp instanceof wkp)) {
        i = localxvp.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localxvp.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new wlf(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new wlh(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new wko(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wkw(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wlb(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wkt(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wla(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wkp(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wku(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wkv(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((xvp)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130849827);
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
      xvp localxvp = (xvp)localIterator.next();
      if ((localxvp instanceof wkw)) {
        return false;
      }
      if (localxvp.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Whm != null) {
      this.jdField_a_of_type_Whm.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    xvp localxvp;
    for (int i = 0;; i = localxvp.a() + i) {
      if (localIterator.hasNext())
      {
        localxvp = (xvp)localIterator.next();
        if (!(localxvp instanceof wkp)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(wia paramwia)
  {
    wlf localwlf = (wlf)a("GeneralFeedProfileSegment");
    wlh localwlh = (wlh)a("ShareGroupFeedProfileSegment");
    wko localwko = (wko)a("BannerProfileSegment");
    wkw localwkw = (wkw)a("DetailInteractSegment");
    wkt localwkt = (wkt)a("DetailDoubleTabSegment");
    wla localwla = (wla)a("DetailLikeListSegment");
    wkp localwkp = (wkp)a("DetailCommentSegment");
    localwlf.a(paramwia);
    localwlh.a(paramwia);
    localwko.a(paramwia);
    localwkw.a(paramwia);
    localwkt.a(paramwia);
    localwla.a(paramwia);
    localwkp.a(paramwia);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      xvp localxvp;
      if (localIterator.hasNext())
      {
        localxvp = (xvp)localIterator.next();
        if (!(localxvp instanceof wkw)) {}
      }
      else
      {
        return;
      }
      localxvp.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(whm paramwhm)
  {
    this.jdField_a_of_type_Whm = paramwhm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */