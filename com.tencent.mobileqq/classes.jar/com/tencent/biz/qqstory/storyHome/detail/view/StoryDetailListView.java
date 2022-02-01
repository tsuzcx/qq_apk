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
import yes;
import yfg;
import yhu;
import yhv;
import yhz;
import yia;
import yib;
import yic;
import yig;
import yih;
import yil;
import yin;
import zsv;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<zsv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private yes jdField_a_of_type_Yes;
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
    zsv localzsv;
    if (localIterator.hasNext())
    {
      localzsv = (zsv)localIterator.next();
      if ((localzsv instanceof yhv)) {
        i = localzsv.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localzsv.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new yil(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new yin(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new yhu(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yic(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yih(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yhz(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yig(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yhv(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yia(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new yib(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((zsv)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130850427);
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
      zsv localzsv = (zsv)localIterator.next();
      if ((localzsv instanceof yic)) {
        return false;
      }
      if (localzsv.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Yes != null) {
      this.jdField_a_of_type_Yes.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    zsv localzsv;
    for (int i = 0;; i = localzsv.a() + i) {
      if (localIterator.hasNext())
      {
        localzsv = (zsv)localIterator.next();
        if (!(localzsv instanceof yhv)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(yfg paramyfg)
  {
    yil localyil = (yil)a("GeneralFeedProfileSegment");
    yin localyin = (yin)a("ShareGroupFeedProfileSegment");
    yhu localyhu = (yhu)a("BannerProfileSegment");
    yic localyic = (yic)a("DetailInteractSegment");
    yhz localyhz = (yhz)a("DetailDoubleTabSegment");
    yig localyig = (yig)a("DetailLikeListSegment");
    yhv localyhv = (yhv)a("DetailCommentSegment");
    localyil.a(paramyfg);
    localyin.a(paramyfg);
    localyhu.a(paramyfg);
    localyic.a(paramyfg);
    localyhz.a(paramyfg);
    localyig.a(paramyfg);
    localyhv.a(paramyfg);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      zsv localzsv;
      if (localIterator.hasNext())
      {
        localzsv = (zsv)localIterator.next();
        if (!(localzsv instanceof yic)) {}
      }
      else
      {
        return;
      }
      localzsv.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(yes paramyes)
  {
    this.jdField_a_of_type_Yes = paramyes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */