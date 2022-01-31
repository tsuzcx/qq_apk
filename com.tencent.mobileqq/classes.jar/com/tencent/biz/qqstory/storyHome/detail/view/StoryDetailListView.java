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
import uol;
import uoz;
import urn;
import uro;
import urs;
import urt;
import uru;
import urv;
import urz;
import usa;
import use;
import usg;
import wco;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private List<wco> jdField_a_of_type_JavaUtilList = new ArrayList();
  private uol jdField_a_of_type_Uol;
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
    wco localwco;
    if (localIterator.hasNext())
    {
      localwco = (wco)localIterator.next();
      if ((localwco instanceof uro)) {
        i = localwco.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localwco.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new use(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new usg(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new urn(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urv(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new usa(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urs(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urz(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new uro(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new urt(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new uru(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((wco)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130849321);
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
      wco localwco = (wco)localIterator.next();
      if ((localwco instanceof urv)) {
        return false;
      }
      if (localwco.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    super.a(paramInt, paramView, paramListView);
    if (this.jdField_a_of_type_Uol != null) {
      this.jdField_a_of_type_Uol.a();
    }
    return true;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    wco localwco;
    for (int i = 0;; i = localwco.a() + i) {
      if (localIterator.hasNext())
      {
        localwco = (wco)localIterator.next();
        if (!(localwco instanceof uro)) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public void setCallback(uoz paramuoz)
  {
    use localuse = (use)a("GeneralFeedProfileSegment");
    usg localusg = (usg)a("ShareGroupFeedProfileSegment");
    urn localurn = (urn)a("BannerProfileSegment");
    urv localurv = (urv)a("DetailInteractSegment");
    urs localurs = (urs)a("DetailDoubleTabSegment");
    urz localurz = (urz)a("DetailLikeListSegment");
    uro localuro = (uro)a("DetailCommentSegment");
    localuse.a(paramuoz);
    localusg.a(paramuoz);
    localurn.a(paramuoz);
    localurv.a(paramuoz);
    localurs.a(paramuoz);
    localurz.a(paramuoz);
    localuro.a(paramuoz);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      wco localwco;
      if (localIterator.hasNext())
      {
        localwco = (wco)localIterator.next();
        if (!(localwco instanceof urv)) {}
      }
      else
      {
        return;
      }
      localwco.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(uol paramuol)
  {
    this.jdField_a_of_type_Uol = paramuol;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */