package com.tencent.biz.qqstory.storyHome.detail.view.segment;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager;
import com.tencent.biz.qqstory.boundaries.StoryDepends;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo.VipFrwrdLinkInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.TagUserItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayManager;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.StoryUploadProgressView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.StoryNickNameView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class FeedItemThumbAdapter
  extends BaseAdapter
{
  public int a;
  public Activity a;
  public final Context a;
  private LruCache<String, QQUserUIItem> a;
  public VideoListFeedItem a;
  public AutoPlayManager a;
  protected QQStoryAutoPlayView.StoryCoverClickListener a;
  public BaseViewHolder a;
  public List<StoryVideoItem> a;
  public boolean a;
  public int b;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt)
  {
    this(paramContext, paramActivity, paramInt, 0);
  }
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilLruCache = new LruCache(1024);
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
      localObjectAnimator.addUpdateListener(new FeedItemThumbAdapter.2(this, localStoryHomeHorizontalListView));
    }
  }
  
  protected View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramBaseViewHolder.b = paramInt;
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size()))
    {
      SLog.e("Q.qqstory.detail.FeedItemThumbAdapter", "bind view failed because of invalidate data.");
      return paramBaseViewHolder.a();
    }
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    QQStoryAutoPlayView localQQStoryAutoPlayView = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131374989);
    TextView localTextView = (TextView)paramBaseViewHolder.a(2131374990);
    StoryNickNameView localStoryNickNameView = (StoryNickNameView)paramBaseViewHolder.a(2131374988);
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener != null) {
      localQQStoryAutoPlayView.setStoryCoverClickListener(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener);
    }
    FeedSegment.a(localStoryVideoItem, localQQStoryAutoPlayView, "QQStory_feed_min", this.c, this.d);
    if (localStoryVideoItem.mHadRead == 1)
    {
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167127));
      if (!localStoryVideoItem.isUploadFail()) {
        break label574;
      }
      localTextView.setText(HardCodeUtil.a(2131704472));
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167127));
      localStoryNickNameView.setUnionId(null);
      label315:
      if (!localStoryVideoItem.isUploading()) {
        break label777;
      }
      localQQStoryAutoPlayView.a().a(localStoryVideoItem.mVid);
      localQQStoryAutoPlayView.a().a(0);
      StoryVideoUploadProgressManager.a().a(localStoryVideoItem.mVid, localQQStoryAutoPlayView.a());
    }
    for (;;)
    {
      if ((StoryDepends.a()) && (this.jdField_a_of_type_Boolean) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner().isMe()))
      {
        this.jdField_a_of_type_Boolean = false;
        a(paramViewGroup, localQQStoryAutoPlayView);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.type == 3) && ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof QQUserUIItem)))
      {
        paramViewGroup = (QQUserUIItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner();
        if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
          StoryReportor.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
        }
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.type == 6) {
        StoryReportor.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      }
      return paramBaseViewHolder.a();
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167033));
      break;
      label574:
      if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L)
      {
        str = UIUtils.a(localStoryVideoItem.mCreateTime, localStoryVideoItem.mTimeZoneOffsetMillis);
        label601:
        localTextView.setText(str);
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof ShareGroupItem)) {
          break label679;
        }
        localStoryNickNameView.setUnionId(null);
        localStoryNickNameView.setVisibility(0);
        localStoryNickNameView.setText(localStoryVideoItem.mOwnerName);
      }
      for (;;)
      {
        if (!(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem)) {
          break label768;
        }
        localTextView.setVisibility(8);
        break;
        str = UIUtils.b(localStoryVideoItem.mCreateTime);
        break label601;
        label679:
        if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.getOwner() instanceof TagUserItem))
        {
          localStoryNickNameView.setUnionId(null);
        }
        else if ((FeedSegment.a(localStoryVideoItem)) && (localStoryVideoItem.getVideoLinkInfo().a != null))
        {
          localStoryNickNameView.setFormat(HardCodeUtil.a(2131704470));
          localStoryNickNameView.a(this.jdField_a_of_type_AndroidUtilLruCache);
          localStoryNickNameView.setUnionId(localStoryVideoItem.getVideoLinkInfo().a.a);
        }
        else
        {
          localStoryNickNameView.setUnionId(null);
        }
      }
      label768:
      localTextView.setVisibility(0);
      break label315;
      label777:
      if (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {}
      for (String str = localStoryVideoItem.mVid;; str = StoryVideoUploadProgressManager.a().a(localStoryVideoItem.mVid))
      {
        localQQStoryAutoPlayView.a().a(str);
        if (!localQQStoryAutoPlayView.a().a()) {
          break label865;
        }
        SLog.a("Q.qqstory.detail.FeedItemThumbAdapter", "vid:%s, animation not end", str);
        localQQStoryAutoPlayView.a().a(new FeedItemThumbAdapter.1(this, str, localQQStoryAutoPlayView));
        break;
      }
      label865:
      localQQStoryAutoPlayView.a().a(4);
      StoryVideoUploadProgressManager.a().a(localQQStoryAutoPlayView.a());
    }
  }
  
  protected BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561814, paramViewGroup, false));
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
  
  public void a(@NonNull LruCache<String, QQUserUIItem> paramLruCache)
  {
    this.jdField_a_of_type_AndroidUtilLruCache = paramLruCache;
  }
  
  public void a(AutoPlayManager paramAutoPlayManager)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayAutoPlayManager = paramAutoPlayManager;
  }
  
  public void a(QQStoryAutoPlayView.StoryCoverClickListener paramStoryCoverClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView$StoryCoverClickListener = paramStoryCoverClickListener;
  }
  
  public void a(List<StoryVideoItem> paramList, VideoListFeedItem paramVideoListFeedItem)
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
    TraceUtils.traceBegin("FeedItem.getView");
    Object localObject;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder = a(0, paramViewGroup);
      }
      localObject = a(0, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewBaseViewHolder, paramViewGroup);
      TraceUtils.traceEnd();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {
      localObject = a(paramInt, paramViewGroup);
    }
    for (;;)
    {
      localObject = a(paramInt, (BaseViewHolder)localObject, paramViewGroup);
      TraceUtils.traceEnd();
      break;
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      localObject = localBaseViewHolder;
      if (localBaseViewHolder == null) {
        localObject = a(paramInt, paramViewGroup);
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter
 * JD-Core Version:    0.7.0.1
 */