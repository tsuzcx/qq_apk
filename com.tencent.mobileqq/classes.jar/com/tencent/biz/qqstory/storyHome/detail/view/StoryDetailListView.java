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
  public int b;
  private RequestDataListener c;
  private Activity d;
  private List<SegmentView> m = new ArrayList();
  
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
  
  protected void a()
  {
    super.setActTAG("list_qqstory_detail");
    this.m.add(new GeneralFeedProfileSegment(this.d, this.a, this.b));
    this.m.add(new ShareGroupFeedProfileSegment(this.d, this.a, this.b));
    this.m.add(new BannerProfileSegment(this.d));
    this.m.add(new DetailInteractSegment(this.d));
    this.m.add(new DetailTagListSegment(this.d));
    this.m.add(new DetailDoubleTabSegment(this.d));
    this.m.add(new DetailLikeListSegment(this.d));
    this.m.add(new DetailCommentSegment(this.d));
    this.m.add(new DetailEmptyInteractionSegment(this.d));
    this.m.add(new DetailEmptySegment(this.d));
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      a((SegmentView)localIterator.next());
    }
    super.setDivider(null);
    super.setVerticalScrollBarEnabled(false);
    super.setHorizontalScrollBarEnabled(false);
    super.setBackgroundResource(2130852616);
  }
  
  public void a(Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(1);
      return;
    }
    super.a(1, g);
  }
  
  public boolean b()
  {
    Iterator localIterator = this.m.iterator();
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
  
  public int getCommentSegmentIndex()
  {
    Iterator localIterator = this.m.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof DetailCommentSegment)) {
        return i;
      }
      i += localSegmentView.a();
    }
    return i;
  }
  
  public int getLastCommentPoi()
  {
    Iterator localIterator = this.m.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof DetailCommentSegment))
      {
        j = i + localSegmentView.a();
        break;
      }
      i += localSegmentView.a();
    }
    if (j == 0) {
      return 0;
    }
    return j;
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    paramView = this.c;
    if (paramView != null) {
      paramView.a();
    }
    return true;
  }
  
  public void setCallback(DetailEventCallback paramDetailEventCallback)
  {
    GeneralFeedProfileSegment localGeneralFeedProfileSegment = (GeneralFeedProfileSegment)b("GeneralFeedProfileSegment");
    ShareGroupFeedProfileSegment localShareGroupFeedProfileSegment = (ShareGroupFeedProfileSegment)b("ShareGroupFeedProfileSegment");
    BannerProfileSegment localBannerProfileSegment = (BannerProfileSegment)b("BannerProfileSegment");
    DetailInteractSegment localDetailInteractSegment = (DetailInteractSegment)b("DetailInteractSegment");
    DetailDoubleTabSegment localDetailDoubleTabSegment = (DetailDoubleTabSegment)b("DetailDoubleTabSegment");
    DetailLikeListSegment localDetailLikeListSegment = (DetailLikeListSegment)b("DetailLikeListSegment");
    DetailCommentSegment localDetailCommentSegment = (DetailCommentSegment)b("DetailCommentSegment");
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
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext())
    {
      SegmentView localSegmentView = (SegmentView)localIterator.next();
      if ((localSegmentView instanceof DetailInteractSegment)) {
        return;
      }
      localSegmentView.c(paramBoolean);
    }
  }
  
  public void setRequestDataListener(RequestDataListener paramRequestDataListener)
  {
    this.c = paramRequestDataListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView
 * JD-Core Version:    0.7.0.1
 */