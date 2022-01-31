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
import wdd;
import wdr;
import wgf;
import wgg;
import wgk;
import wgl;
import wgm;
import wgn;
import wgr;
import wgs;
import wgw;
import wgy;
import xrg;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<xrg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private wdd jdField_a_of_type_Wdd;
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
    xrg localxrg;
    if (localIterator.hasNext())
    {
      localxrg = (xrg)localIterator.next();
      if ((localxrg instanceof wgg)) {
        i = localxrg.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localxrg.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new wgw(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new wgy(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new wgf(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgn(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgs(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgk(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgr(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgg(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgl(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new wgm(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((xrg)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130849754);
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
      xrg localxrg = (xrg)localIterator.next();
      if ((localxrg instanceof wgn)) {
        return false;
      }
      if (localxrg.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Wdd != null) {
      this.jdField_a_of_type_Wdd.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    xrg localxrg;
    for (int i = 0;; i = localxrg.a() + i) {
      if (localIterator.hasNext())
      {
        localxrg = (xrg)localIterator.next();
        if (!(localxrg instanceof wgg)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(wdr paramwdr)
  {
    wgw localwgw = (wgw)a("GeneralFeedProfileSegment");
    wgy localwgy = (wgy)a("ShareGroupFeedProfileSegment");
    wgf localwgf = (wgf)a("BannerProfileSegment");
    wgn localwgn = (wgn)a("DetailInteractSegment");
    wgk localwgk = (wgk)a("DetailDoubleTabSegment");
    wgr localwgr = (wgr)a("DetailLikeListSegment");
    wgg localwgg = (wgg)a("DetailCommentSegment");
    localwgw.a(paramwdr);
    localwgy.a(paramwdr);
    localwgf.a(paramwdr);
    localwgn.a(paramwdr);
    localwgk.a(paramwdr);
    localwgr.a(paramwdr);
    localwgg.a(paramwdr);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      xrg localxrg;
      if (localIterator.hasNext())
      {
        localxrg = (xrg)localIterator.next();
        if (!(localxrg instanceof wgn)) {}
      }
      else
      {
        return;
      }
      localxrg.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(wdd paramwdd)
  {
    this.jdField_a_of_type_Wdd = paramwdd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */