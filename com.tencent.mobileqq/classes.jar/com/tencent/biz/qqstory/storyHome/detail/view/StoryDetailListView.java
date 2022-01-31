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
import ubs;
import ucg;
import ueu;
import uev;
import uez;
import ufa;
import ufb;
import ufc;
import ufg;
import ufh;
import ufl;
import ufn;
import vpv;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<vpv> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ubs jdField_a_of_type_Ubs;
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
    vpv localvpv;
    if (localIterator.hasNext())
    {
      localvpv = (vpv)localIterator.next();
      if ((localvpv instanceof uev)) {
        i = localvpv.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localvpv.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new ufl(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new ufn(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new ueu(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ufc(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ufh(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new uez(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ufg(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new uev(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ufa(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new ufb(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((vpv)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130849077);
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
      vpv localvpv = (vpv)localIterator.next();
      if ((localvpv instanceof ufc)) {
        return false;
      }
      if (localvpv.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Ubs != null) {
      this.jdField_a_of_type_Ubs.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    vpv localvpv;
    for (int i = 0;; i = localvpv.a() + i) {
      if (localIterator.hasNext())
      {
        localvpv = (vpv)localIterator.next();
        if (!(localvpv instanceof uev)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(ucg paramucg)
  {
    ufl localufl = (ufl)a("GeneralFeedProfileSegment");
    ufn localufn = (ufn)a("ShareGroupFeedProfileSegment");
    ueu localueu = (ueu)a("BannerProfileSegment");
    ufc localufc = (ufc)a("DetailInteractSegment");
    uez localuez = (uez)a("DetailDoubleTabSegment");
    ufg localufg = (ufg)a("DetailLikeListSegment");
    uev localuev = (uev)a("DetailCommentSegment");
    localufl.a(paramucg);
    localufn.a(paramucg);
    localueu.a(paramucg);
    localufc.a(paramucg);
    localuez.a(paramucg);
    localufg.a(paramucg);
    localuev.a(paramucg);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      vpv localvpv;
      if (localIterator.hasNext())
      {
        localvpv = (vpv)localIterator.next();
        if (!(localvpv instanceof ufc)) {}
      }
      else
      {
        return;
      }
      localvpv.f_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(ubs paramubs)
  {
    this.jdField_a_of_type_Ubs = paramubs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */