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
  public final Context a;
  public List<StoryVideoItem> b = new ArrayList();
  public VideoListFeedItem c;
  public Activity d;
  public AutoPlayManager e;
  public int f;
  public int g;
  public BaseViewHolder h;
  protected QQStoryAutoPlayView.StoryCoverClickListener i;
  public boolean j = true;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private LruCache<String, QQUserUIItem> n = new LruCache(1024);
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt)
  {
    this(paramContext, paramActivity, paramInt, 0);
  }
  
  public FeedItemThumbAdapter(Context paramContext, Activity paramActivity, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.d = paramActivity;
    this.f = paramInt1;
    this.g = paramInt2;
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
    if (getCount() <= 2)
    {
      localAnimatorSet.play(localObjectAnimator).with(paramView).with(paramViewGroup);
    }
    else
    {
      localStoryHomeHorizontalListView.scrollTo(300, 0);
      localAnimatorSet.play(localObjectAnimator).with(paramView);
      localObjectAnimator.addUpdateListener(new FeedItemThumbAdapter.2(this, localStoryHomeHorizontalListView));
    }
    localAnimatorSet.start();
  }
  
  protected View a(int paramInt, BaseViewHolder paramBaseViewHolder, ViewGroup paramViewGroup)
  {
    paramBaseViewHolder.f = paramInt;
    Object localObject = this.b;
    if ((localObject != null) && (paramInt < ((List)localObject).size()))
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.b.get(paramInt);
      QQStoryAutoPlayView localQQStoryAutoPlayView = (QQStoryAutoPlayView)paramBaseViewHolder.a(2131442690);
      TextView localTextView = (TextView)paramBaseViewHolder.a(2131442691);
      StoryNickNameView localStoryNickNameView = (StoryNickNameView)paramBaseViewHolder.a(2131442689);
      int i1 = this.k;
      if ((i1 != 0) && (i1 != localQQStoryAutoPlayView.getLayoutParams().width))
      {
        i1 = this.l;
        if ((i1 != 0) && (i1 != localQQStoryAutoPlayView.getLayoutParams().height))
        {
          localQQStoryAutoPlayView.getLayoutParams().width = this.k;
          localQQStoryAutoPlayView.getLayoutParams().height = this.l;
          paramBaseViewHolder.a().getLayoutParams().width = this.k;
        }
      }
      if (this.m > 0) {
        localQQStoryAutoPlayView.getSrcImageView().setCorner(this.m);
      }
      localQQStoryAutoPlayView.setItemData(this.c, localStoryVideoItem, paramInt);
      localObject = this.e;
      if (localObject != null) {
        localQQStoryAutoPlayView.a((AutoPlayManager)localObject);
      }
      localObject = this.i;
      if (localObject != null) {
        localQQStoryAutoPlayView.setStoryCoverClickListener((QQStoryAutoPlayView.StoryCoverClickListener)localObject);
      }
      FeedSegment.a(localStoryVideoItem, localQQStoryAutoPlayView, "QQStory_feed_min", this.k, this.l);
      if (localStoryVideoItem.mHadRead == 1) {
        localTextView.setTextColor(this.a.getResources().getColor(2131168133));
      } else {
        localTextView.setTextColor(this.a.getResources().getColor(2131167993));
      }
      if (localStoryVideoItem.isUploadFail())
      {
        localTextView.setText(HardCodeUtil.a(2131902471));
        localTextView.setTextColor(this.a.getResources().getColor(2131168133));
        localStoryNickNameView.setUnionId(null);
      }
      else
      {
        if (localStoryVideoItem.mTimeZoneOffsetMillis != 2147483647L) {
          localObject = UIUtils.a(localStoryVideoItem.mCreateTime, localStoryVideoItem.mTimeZoneOffsetMillis);
        } else {
          localObject = UIUtils.b(localStoryVideoItem.mCreateTime);
        }
        localTextView.setText((CharSequence)localObject);
        if ((this.c.getOwner() instanceof ShareGroupItem))
        {
          localStoryNickNameView.setUnionId(null);
          localStoryNickNameView.setVisibility(0);
          localStoryNickNameView.setText(localStoryVideoItem.mOwnerName);
        }
        else if ((this.c.getOwner() instanceof TagUserItem))
        {
          localStoryNickNameView.setUnionId(null);
        }
        else if ((FeedSegment.a(localStoryVideoItem)) && (localStoryVideoItem.getVideoLinkInfo().h != null))
        {
          localStoryNickNameView.setFormat(HardCodeUtil.a(2131902469));
          localStoryNickNameView.a(this.n);
          localStoryNickNameView.setUnionId(localStoryVideoItem.getVideoLinkInfo().h.a);
        }
        else
        {
          localStoryNickNameView.setUnionId(null);
        }
        if ((this.c.getOwner() instanceof TagUserItem)) {
          localTextView.setVisibility(8);
        } else {
          localTextView.setVisibility(0);
        }
      }
      if (localStoryVideoItem.isUploading())
      {
        localQQStoryAutoPlayView.getProgressView().a(localStoryVideoItem.mVid);
        localQQStoryAutoPlayView.getProgressView().a(0);
        StoryVideoUploadProgressManager.a().a(localStoryVideoItem.mVid, localQQStoryAutoPlayView.getProgressView());
      }
      else
      {
        if (StoryVideoItem.isFakeVid(localStoryVideoItem.mVid)) {
          localObject = localStoryVideoItem.mVid;
        } else {
          localObject = StoryVideoUploadProgressManager.a().e(localStoryVideoItem.mVid);
        }
        localQQStoryAutoPlayView.getProgressView().a((String)localObject);
        if (localQQStoryAutoPlayView.getProgressView().b())
        {
          SLog.a("Q.qqstory.detail.FeedItemThumbAdapter", "vid:%s, animation not end", localObject);
          localQQStoryAutoPlayView.getProgressView().a(new FeedItemThumbAdapter.1(this, (String)localObject, localQQStoryAutoPlayView));
        }
        else
        {
          localQQStoryAutoPlayView.getProgressView().a(4);
          StoryVideoUploadProgressManager.a().a(localQQStoryAutoPlayView.getProgressView());
        }
      }
      if ((StoryDepends.a()) && (this.j) && (paramInt == 0) && (this.c.getOwner().isMe()))
      {
        this.j = false;
        a(paramViewGroup, localQQStoryAutoPlayView);
      }
      if ((this.c.type == 3) && ((this.c.getOwner() instanceof QQUserUIItem)))
      {
        paramViewGroup = (QQUserUIItem)this.c.getOwner();
        if ((paramViewGroup.isVip) && (!paramViewGroup.isSubscribe())) {
          StoryReportor.c("video_exp", "exp_IDrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
        }
      }
      if (this.c.type == 6) {
        StoryReportor.c("video_exp", "exp_topicrecommend", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      }
      return paramBaseViewHolder.a();
    }
    SLog.e("Q.qqstory.detail.FeedItemThumbAdapter", "bind view failed because of invalidate data.");
    return paramBaseViewHolder.a();
  }
  
  protected BaseViewHolder a(int paramInt, ViewGroup paramViewGroup)
  {
    return new BaseViewHolder(LayoutInflater.from(this.a).inflate(2131628049, paramViewGroup, false));
  }
  
  public void a(int paramInt)
  {
    this.m = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public void a(@NonNull LruCache<String, QQUserUIItem> paramLruCache)
  {
    this.n = paramLruCache;
  }
  
  public void a(AutoPlayManager paramAutoPlayManager)
  {
    this.e = paramAutoPlayManager;
  }
  
  public void a(QQStoryAutoPlayView.StoryCoverClickListener paramStoryCoverClickListener)
  {
    this.i = paramStoryCoverClickListener;
  }
  
  public void a(List<StoryVideoItem> paramList, VideoListFeedItem paramVideoListFeedItem)
  {
    this.b.clear();
    this.b.addAll(paramList);
    this.c = paramVideoListFeedItem;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.b;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (paramInt < localList.size())) {
      return this.b.get(paramInt);
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
      if (this.h == null) {
        this.h = a(0, paramViewGroup);
      }
      localObject = a(0, this.h, paramViewGroup);
      TraceUtils.traceEnd();
    }
    else
    {
      if (paramView == null)
      {
        localObject = a(paramInt, paramViewGroup);
      }
      else
      {
        BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
        localObject = localBaseViewHolder;
        if (localBaseViewHolder == null) {
          localObject = a(paramInt, paramViewGroup);
        }
      }
      localObject = a(paramInt, (BaseViewHolder)localObject, paramViewGroup);
      TraceUtils.traceEnd();
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.view.segment.FeedItemThumbAdapter
 * JD-Core Version:    0.7.0.1
 */