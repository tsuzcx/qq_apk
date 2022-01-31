package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagFeedItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nue;

@TargetApi(11)
public class FeedItemThumbAdapter
  extends BaseAdapter
  implements QQStoryAutoPlayView.StoryCoverClickListener
{
  public int a;
  public Activity a;
  public final Context a;
  public VideoListFeedItem a;
  public AutoPlayManager a;
  public BaseViewHolder a;
  public List a;
  public boolean a;
  public int b;
  private int c;
  private int d;
  private int e;
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt)
  {
    this(paramContext, paramActivity, paramInt, 0);
  }
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static int a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploading()) {
      return 3;
    }
    if (paramStoryVideoItem.isUploadFail()) {
      return 2;
    }
    return 1;
  }
  
  private View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramBaseViewHolder.b = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      SLog.e("Q.qqstory.detail.FeedItemThumbAdapter", "bind view failed because of invalidate data.");
      return paramBaseViewHolder.a();
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QQStoryAutoPlayView localQQStoryAutoPlayView = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131371586);
    TextView localTextView1 = (TextView)paramBaseViewHolder.a(2131371587);
    TextView localTextView2 = (TextView)paramBaseViewHolder.a(2131371588);
    if ((this.c != 0) && (this.c != localQQStoryAutoPlayView.getLayoutParams().width) && (this.d != 0) && (this.d != localQQStoryAutoPlayView.getLayoutParams().height))
    {
      localQQStoryAutoPlayView.getLayoutParams().width = this.c;
      localQQStoryAutoPlayView.getLayoutParams().height = this.d;
      paramBaseViewHolder.a().getLayoutParams().width = this.c;
    }
    if (this.e > 0) {
      localQQStoryAutoPlayView.a().setCorner(this.e);
    }
    localQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem, localStoryVideoItem, paramInt);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager != null) {
      localQQStoryAutoPlayView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager);
    }
    localQQStoryAutoPlayView.setStoryCoverClickListener(this);
    FeedSegment.a(localStoryVideoItem, localQQStoryAutoPlayView, "QQStory_feed_min", this.c, this.d);
    if (localStoryVideoItem.mHadRead == 1)
    {
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494270));
      if (!localStoryVideoItem.isUploadFail()) {
        break label372;
      }
      localTextView1.setText("上传失败");
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494270));
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      if ((StoryDepends.a()) && (this.jdField_a_of_type_Boolean) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner().isMe()))
      {
        this.jdField_a_of_type_Boolean = false;
        a(paramViewGroup, localQQStoryAutoPlayView);
      }
      return paramBaseViewHolder.a();
      localTextView1.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494207));
      break;
      label372:
      String str;
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
      {
        str = UIUtils.a(localStoryVideoItem.mCreateTime, localStoryVideoItem.mTimeZoneOffsetMillis);
        label399:
        localTextView1.setText(str);
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label471;
        }
        localTextView2.setVisibility(0);
        localTextView2.setText(localStoryVideoItem.mOwnerName);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem)) {
          break label504;
        }
        localTextView1.setVisibility(8);
        break;
        str = UIUtils.b(localStoryVideoItem.mCreateTime);
        break label399;
        label471:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem)) {
          localTextView2.setVisibility(8);
        } else {
          localTextView2.setVisibility(8);
        }
      }
      label504:
      localTextView1.setVisibility(0);
    }
  }
  
  private BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970688, paramViewGroup, false));
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    SLog.d("Q.qqstory.detail.FeedItemThumbAdapter", "publishAnimationForQIM");
    StoryHomeHorizontalListView localStoryHomeHorizontalListView = (StoryHomeHorizontalListView)paramViewGroup;
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.0F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.0F, 1.0F });
    paramViewGroup = ObjectAnimator.ofFloat(paramViewGroup, "translationX", new float[] { -300.0F, 0.0F });
    localAnimatorSet.setDuration(500L);
    if (getCount() <= 2) {
      localAnimatorSet.play(localObjectAnimator).with(paramView).with(paramViewGroup);
    }
    for (;;)
    {
      localAnimatorSet.start();
      return;
      localStoryHomeHorizontalListView.scrollTo(300, 0);
      localAnimatorSet.play(localObjectAnimator).with(paramView);
      localObjectAnimator.addUpdateListener(new nue(this, localStoryHomeHorizontalListView));
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    if (UIUtils.b()) {
      return;
    }
    paramInt = PlayModeUtils.a(this.jdField_a_of_type_Int, this.b);
    int i = FeedSegment.a(paramVideoListFeedItem);
    if (StoryVideoItem.isFakeVid(paramStoryVideoItem.mVid))
    {
      StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramVideoListFeedItem.ownerId, paramStoryVideoItem.mVid, paramVideoListFeedItem.feedId, paramInt, -1, paramView);
      paramInt = StoryReportor.b(paramVideoListFeedItem);
      if (!(paramVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
        break label409;
      }
    }
    label409:
    for (paramView = paramVideoListFeedItem.getOwner().getUnionId();; paramView = "")
    {
      StoryReportor.a("home_page", "clk_card", StoryReportor.a(paramVideoListFeedItem), a(paramStoryVideoItem), new String[] { String.valueOf(paramInt), StoryReportor.a(this.jdField_a_of_type_Int), paramVideoListFeedItem.feedId, paramView });
      return;
      if (((paramVideoListFeedItem instanceof GeneralFeedItem)) || ((paramVideoListFeedItem instanceof GeneralRecommendFeedItem)))
      {
        localObject = null;
        if ((paramVideoListFeedItem.getOwner() instanceof QQUserUIItem)) {
          localObject = ((QQUserUIItem)paramVideoListFeedItem.getOwner()).qq;
        }
        StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, paramVideoListFeedItem.ownerId, paramVideoListFeedItem.feedId, i, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType, true, paramInt, this.jdField_a_of_type_Int, paramView);
        break;
      }
      if ((paramVideoListFeedItem instanceof ShareGroupFeedItem))
      {
        localObject = null;
        l = ((ShareGroupItem)paramVideoListFeedItem.getOwner()).groupUin;
        if (l != -1L) {
          localObject = String.valueOf(l);
        }
        StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, paramVideoListFeedItem.ownerId, paramVideoListFeedItem.feedId, i, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType, true, paramInt, this.jdField_a_of_type_Int, paramView);
        break;
      }
      if (!(paramVideoListFeedItem instanceof TagFeedItem)) {
        break;
      }
      long l = ((TagFeedItem)paramVideoListFeedItem).tagItem.a.a;
      Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ArrayList)localObject).add(((StoryVideoItem)localIterator.next()).mAttachedFeedId);
      }
      StoryPlayVideoActivity.a(this.jdField_a_of_type_AndroidAppActivity, String.valueOf(l), paramVideoListFeedItem.feedId, (ArrayList)localObject, paramStoryVideoItem.mVid, paramVideoListFeedItem.mVideoPullType, true, paramInt, this.jdField_a_of_type_Int, paramView);
      break;
    }
  }
  
  public void a(AutoPlayManager paramAutoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager = paramAutoPlayManager;
  }
  
  public void a(List paramList, VideoListFeedItem paramVideoListFeedItem)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = paramVideoListFeedItem;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.a("FeedItem.getView");
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = a(0, paramViewGroup);
      }
      paramView = a(0, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder, paramViewGroup);
      TraceUtils.a();
      return paramView;
    }
    if (paramView == null) {
      paramView = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      paramView = a(paramInt, paramView, paramViewGroup);
      TraceUtils.a();
      return paramView;
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      paramView = localBaseViewHolder;
      if (localBaseViewHolder == null) {
        paramView = a(paramInt, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter
 * JD-Core Version:    0.7.0.1
 */