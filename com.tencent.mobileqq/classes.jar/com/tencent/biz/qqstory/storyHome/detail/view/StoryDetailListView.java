package com.tencent.biz.qqstory.storyHome.detail.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqstory.storyHome.RequestDataListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.BannerProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailCommentSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailDoubleTabSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptyInteractionSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailEmptySegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailInteractSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailLikeListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.DetailTagListSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.ShareGroupFeedProfileSegment;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.biz.qqstory.view.segment.SegmentView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryDetailListView
  extends SegmentList
{
  public int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RequestDataListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeRequestDataListener;
  private List<SegmentView> jdField_a_of_type_JavaUtilList = new ArrayList();
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
    SegmentView localSegmentView;
    if (localIterator.hasNext())
    {
      localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof DetailCommentSegment)) {
        i = localSegmentView.a() + i;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        return 0;
        i = localSegmentView.a() + i;
        break;
      }
      return i;
    }
  }
  
  public void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.jdField_a_of_type_JavaUtilList.add(new GeneralFeedProfileSegment(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new ShareGroupFeedProfileSegment(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int, this.b));
    this.jdField_a_of_type_JavaUtilList.add(new BannerProfileSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailInteractSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailTagListSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailDoubleTabSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailLikeListSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailCommentSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailEmptyInteractionSegment(this.jdField_a_of_type_AndroidAppActivity));
    this.jdField_a_of_type_JavaUtilList.add(new DetailEmptySegment(this.jdField_a_of_type_AndroidAppActivity));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      a((SegmentView)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130850857);
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
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof DetailInteractSegment)) {
        return false;
      }
      if (localSegmentView.a() > 0) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    SegmentView localSegmentView;
    for (int i = 0;; i = localSegmentView.a() + i) {
      if (localIterator.hasNext())
      {
        localSegmentView = (SegmentView)localIterator.next();
        if (!(localSegmentView instanceof DetailCommentSegment)) {}
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeRequestDataListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeRequestDataListener.a();
    }
    return true;
  }
  
  public void setCallback(DetailEventCallback paramDetailEventCallback)
  {
    GeneralFeedProfileSegment localGeneralFeedProfileSegment = (GeneralFeedProfileSegment)a("GeneralFeedProfileSegment");
    ShareGroupFeedProfileSegment localShareGroupFeedProfileSegment = (ShareGroupFeedProfileSegment)a("ShareGroupFeedProfileSegment");
    BannerProfileSegment localBannerProfileSegment = (BannerProfileSegment)a("BannerProfileSegment");
    DetailInteractSegment localDetailInteractSegment = (DetailInteractSegment)a("DetailInteractSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)a("DetailDoubleTabSegment");
    DetailLikeListSegment localDetailLikeListSegment = (DetailLikeListSegment)a("DetailLikeListSegment");
    DetailCommentSegment localDetailCommentSegment = (DetailCommentSegment)a("DetailCommentSegment");
    localGeneralFeedProfileSegment.a(paramDetailEventCallback);
    localShareGroupFeedProfileSegment.a(paramDetailEventCallback);
    localBannerProfileSegment.a(paramDetailEventCallback);
    localDetailInteractSegment.a(paramDetailEventCallback);
    localDetailDoubleTabSegment.a(paramDetailEventCallback);
    localDetailLikeListSegment.a(paramDetailEventCallback);
    localDetailCommentSegment.a(paramDetailEventCallback);
  }
  
  public void setProfileSegmentDisplay(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      SegmentView localSegmentView;
      if (localIterator.hasNext())
      {
        localSegmentView = (SegmentView)localIterator.next();
        if (!(localSegmentView instanceof DetailInteractSegment)) {}
      }
      else
      {
        return;
      }
      localSegmentView.e_(paramBoolean);
    }
  }
  
  public void setRequestDataListener(RequestDataListener paramRequestDataListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeRequestDataListener = paramRequestDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */