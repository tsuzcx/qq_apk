package com.tencent.biz.qqstory.storyHome.atvideo.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailEventCallback;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.OnFeedItemPullListener;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.detail.model.VideoListPageLoader;
import com.tencent.biz.qqstory.storyHome.detail.view.segment.GeneralFeedProfileSegment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView.StoryCoverClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnScrollChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper.OnLoadMoreListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoryAtVideoFragment
  extends QQStoryBaseFragment
  implements DetailEventCallback, DetailFeedAllInfoPuller.OnFeedItemPullListener, QQStoryAutoPlayView.StoryCoverClickListener, StoryHomeHorizontalListView.OnScrollChangeListener, LoadingMoreHelper.OnLoadMoreListener
{
  public StoryHomeHorizontalListView a;
  public RelativeLayout b;
  public QQStoryAutoPlayView c;
  public TextView d;
  public TextView e;
  public ViewGroup f;
  public StoryAtVideoThumbAdapter g;
  public DetailFeedAllInfoPuller h;
  public VideoListPageLoader i;
  public String q;
  public String r;
  public DetailFeedItem s;
  public FeedVideoManager t;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_at_video_feed_id", paramString1);
    localIntent.putExtra("extra_at_video_scroll_to_feed_id", paramString2);
    PublicFragmentActivity.a(paramActivity, localIntent, StoryAtVideoFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772434, 2130772007);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.r = null;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    StoryAtVideoThumbAdapter.a(getBaseActivity(), paramVideoListFeedItem, paramStoryVideoItem);
    getBaseActivity().finish();
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    if ((paramDetailFeedItem != null) && (paramDetailFeedItem.e()))
    {
      this.s = paramDetailFeedItem;
      SLog.b("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramDetailFeedItem.toString());
      paramDetailFeedItem = this.s.a;
      int j = 0;
      if ((paramDetailFeedItem != null) && (!this.s.a().isEmpty()))
      {
        if (this.s.a().size() == 1)
        {
          localObject = (StoryVideoItem)this.s.a().get(0);
          if ((!((StoryVideoItem)localObject).isUploading()) && (!((StoryVideoItem)localObject).isUploadFail()))
          {
            this.b.setVisibility(0);
            this.a.setVisibility(8);
            this.f.setVisibility(8);
            this.c.setItemData(this.s.f(), (StoryVideoItem)localObject, 0);
            this.c.setStoryCoverClickListener(this);
            FeedSegment.a((StoryVideoItem)localObject, this.c, "QQStory_feed");
            paramDetailFeedItem = this.d;
            j = ((StoryVideoItem)localObject).mHadRead;
            int k = -7829368;
            if (j == 1) {
              j = -7829368;
            } else {
              j = -16777216;
            }
            paramDetailFeedItem.setTextColor(j);
            paramDetailFeedItem = this.e;
            if (((StoryVideoItem)localObject).mHadRead == 1) {
              j = k;
            } else {
              j = -16777216;
            }
            paramDetailFeedItem.setTextColor(j);
            if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L) {
              paramDetailFeedItem = UIUtils.a(((StoryVideoItem)localObject).mCreateTime, ((StoryVideoItem)localObject).mTimeZoneOffsetMillis);
            } else {
              paramDetailFeedItem = UIUtils.b(((StoryVideoItem)localObject).mCreateTime);
            }
            this.d.setText(paramDetailFeedItem);
            if ((this.s.a.getOwner() instanceof ShareGroupItem))
            {
              this.e.setVisibility(0);
              this.e.setText(((StoryVideoItem)localObject).mOwnerName);
              return;
            }
            this.e.setVisibility(8);
            return;
          }
          this.b.setVisibility(8);
          this.a.setVisibility(8);
          this.f.setVisibility(0);
          return;
        }
        this.b.setVisibility(8);
        this.a.setVisibility(0);
        this.f.setVisibility(8);
        if (this.g == null)
        {
          this.g = new StoryAtVideoThumbAdapter(getBaseActivity(), getBaseActivity(), 0, 0);
          this.a.setAdapter(this.g);
          this.a.setDividerWidth(getResources().getDimensionPixelSize(2131299317));
        }
        paramDetailFeedItem = this.s.a();
        Object localObject = new ArrayList();
        if (!paramDetailFeedItem.isEmpty())
        {
          Iterator localIterator = paramDetailFeedItem.iterator();
          while (localIterator.hasNext())
          {
            StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
            if ((!localStoryVideoItem.isUploading()) && (!localStoryVideoItem.isUploadFail())) {
              ((List)localObject).add(localStoryVideoItem);
            }
          }
        }
        this.g.a((List)localObject, this.s.f());
        this.a.setDataCount(((List)localObject).size());
        this.a.setLoadMoreComplete(true ^ this.s.f().mIsVideoEnd);
        this.a.setOnLoadMoreListener(this);
        this.a.setOnScrollChangeListener(this);
        if ((paramDetailFeedItem.size() != ((List)localObject).size()) || (TextUtils.isEmpty(this.r))) {}
      }
      else
      {
        while (j < this.s.a().size())
        {
          if (((StoryVideoItem)this.s.a().get(j)).mVid.equals(this.r))
          {
            SLog.b("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(j));
            this.a.resetCurrentX(GeneralFeedProfileSegment.a(getBaseActivity(), j));
            return;
          }
          j += 1;
          continue;
          this.b.setVisibility(8);
          this.a.setVisibility(8);
          this.f.setVisibility(0);
        }
      }
      return;
    }
    SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (f())
    {
      SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        a(paramDetailFeedItem);
      }
      b(false);
    }
    else if (paramErrorMessage.isSuccess())
    {
      if (this.i != null)
      {
        if (!this.s.e())
        {
          SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.s.f().getVideoInfo();
        this.i.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      a(paramDetailFeedItem);
    }
    boolean bool = paramErrorMessage.isSuccess();
    if (paramErrorMessage.isSuccess()) {
      paramDetailFeedItem = this.s.toString();
    } else {
      paramDetailFeedItem = "null";
    }
    SLog.a("Q.qqstory.atvideo.StoryAtVideoFragment", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramDetailFeedItem);
  }
  
  protected void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new StoryAtVideoFragment.FeedVideoListReceiver(this), "StoryDetailPresenter");
    paramMap.put(new StoryAtVideoFragment.FeedVideoCookieUpdateReceiver(this), "");
  }
  
  public boolean a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.atvideo.StoryAtVideoFragment", "load more video");
    b();
    return true;
  }
  
  public void b()
  {
    SLog.c("Q.qqstory.atvideo.StoryAtVideoFragment", "request load next page video.");
    if (this.i == null)
    {
      if (!this.s.e())
      {
        SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.i = new VideoListPageLoader(2, this.s.f().getVideoInfo());
      this.i.b("StoryDetailPresenter");
    }
    this.i.c();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void b(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.h.a();
      return;
    }
    this.h.b();
  }
  
  public void bo_() {}
  
  public void bp_() {}
  
  public void bx_() {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    this.q = paramLayoutInflater.getString("extra_at_video_feed_id");
    this.r = paramLayoutInflater.getString("extra_at_video_scroll_to_feed_id");
    setTitle(HardCodeUtil.a(2131911724));
    setLeftButton(HardCodeUtil.a(2131898212), null);
    this.a = ((StoryHomeHorizontalListView)a(2131428828));
    this.b = ((RelativeLayout)a(2131442679));
    this.c = ((QQStoryAutoPlayView)a(2131442676));
    this.d = ((TextView)a(2131442678));
    this.e = ((TextView)a(2131442677));
    this.f = ((ViewGroup)a(2131442653));
    this.t = ((FeedVideoManager)SuperManager.a(12));
    this.h = new DetailFeedAllInfoPuller(this.q, this, false);
    b(true);
    StoryReportor.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public void g() {}
  
  protected int getContentLayoutId()
  {
    return 2131628004;
  }
  
  public void h_(int paramInt) {}
  
  public boolean onBackEvent()
  {
    StoryAtVideoThumbAdapter.a(getBaseActivity(), null, null);
    StoryReportor.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.h;
    if (localObject != null) {
      ((DetailFeedAllInfoPuller)localObject).c();
    }
    localObject = this.i;
    if (localObject != null) {
      ((VideoListPageLoader)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */