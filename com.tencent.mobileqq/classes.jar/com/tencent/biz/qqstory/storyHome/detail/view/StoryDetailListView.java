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
import uoo;
import upc;
import urq;
import urr;
import urv;
import urw;
import urx;
import ury;
import usc;
import usd;
import ush;
import usj;
import wcr;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<wcr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uoo jdField_a_of_type_Uoo;
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
    wcr localwcr;
    if (localIterator.hasNext())
    {
      localwcr = (wcr)localIterator.next();
      if ((localwcr instanceof urr)) {
        i = localwcr.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localwcr.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new ush(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new usj(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new urq(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ury(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new usd(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urv(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new usc(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urr(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urw(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urx(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((wcr)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130849312);
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
      wcr localwcr = (wcr)localIterator.next();
      if ((localwcr instanceof ury)) {
        return false;
      }
      if (localwcr.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Uoo != null) {
      this.jdField_a_of_type_Uoo.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    wcr localwcr;
    for (int i = 0;; i = localwcr.a() + i) {
      if (localIterator.hasNext())
      {
        localwcr = (wcr)localIterator.next();
        if (!(localwcr instanceof urr)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(upc paramupc)
  {
    ush localush = (ush)a("GeneralFeedProfileSegment");
    usj localusj = (usj)a("ShareGroupFeedProfileSegment");
    urq localurq = (urq)a("BannerProfileSegment");
    ury localury = (ury)a("DetailInteractSegment");
    urv localurv = (urv)a("DetailDoubleTabSegment");
    usc localusc = (usc)a("DetailLikeListSegment");
    urr localurr = (urr)a("DetailCommentSegment");
    localush.a(paramupc);
    localusj.a(paramupc);
    localurq.a(paramupc);
    localury.a(paramupc);
    localurv.a(paramupc);
    localusc.a(paramupc);
    localurr.a(paramupc);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      wcr localwcr;
      if (localIterator.hasNext())
      {
        localwcr = (wcr)localIterator.next();
        if (!(localwcr instanceof ury)) {}
      }
      else
      {
        return;
      }
      localwcr.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(uoo paramuoo)
  {
    this.jdField_a_of_type_Uoo = paramuoo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */