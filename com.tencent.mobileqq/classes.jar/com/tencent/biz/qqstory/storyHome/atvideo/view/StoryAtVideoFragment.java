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
  public ViewGroup a;
  public RelativeLayout a;
  public TextView a;
  public StoryAtVideoThumbAdapter a;
  public DetailFeedAllInfoPuller a;
  public DetailFeedItem a;
  public VideoListPageLoader a;
  public FeedVideoManager a;
  public QQStoryAutoPlayView a;
  public StoryHomeHorizontalListView a;
  public String a;
  public TextView b;
  public String b;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_at_video_feed_id", paramString1);
    localIntent.putExtra("extra_at_video_scroll_to_feed_id", paramString2);
    PublicFragmentActivity.a(paramActivity, localIntent, StoryAtVideoFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772342, 2130772004);
  }
  
  public void I_() {}
  
  public void J_() {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = null;
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
    if ((paramDetailFeedItem != null) && (paramDetailFeedItem.c()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem = paramDetailFeedItem;
      SLog.b("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramDetailFeedItem.toString());
      paramDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a;
      int i = 0;
      if ((paramDetailFeedItem != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().isEmpty()))
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size() == 1)
        {
          localObject = (StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(0);
          if ((!((StoryVideoItem)localObject).isUploading()) && (!((StoryVideoItem)localObject).isUploadFail()))
          {
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
            this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a(), (StoryVideoItem)localObject, 0);
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setStoryCoverClickListener(this);
            FeedSegment.a((StoryVideoItem)localObject, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView, "QQStory_feed");
            paramDetailFeedItem = this.jdField_a_of_type_AndroidWidgetTextView;
            i = ((StoryVideoItem)localObject).mHadRead;
            int j = -7829368;
            if (i == 1) {
              i = -7829368;
            } else {
              i = -16777216;
            }
            paramDetailFeedItem.setTextColor(i);
            paramDetailFeedItem = this.jdField_b_of_type_AndroidWidgetTextView;
            if (((StoryVideoItem)localObject).mHadRead == 1) {
              i = j;
            } else {
              i = -16777216;
            }
            paramDetailFeedItem.setTextColor(i);
            if (((StoryVideoItem)localObject).mTimeZoneOffsetMillis != 2147483647L) {
              paramDetailFeedItem = UIUtils.a(((StoryVideoItem)localObject).mCreateTime, ((StoryVideoItem)localObject).mTimeZoneOffsetMillis);
            } else {
              paramDetailFeedItem = UIUtils.b(((StoryVideoItem)localObject).mCreateTime);
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText(paramDetailFeedItem);
            if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a.getOwner() instanceof ShareGroupItem))
            {
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              this.jdField_b_of_type_AndroidWidgetTextView.setText(((StoryVideoItem)localObject).mOwnerName);
              return;
            }
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            return;
          }
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoViewStoryAtVideoThumbAdapter == null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoViewStoryAtVideoThumbAdapter = new StoryAtVideoThumbAdapter(getBaseActivity(), getBaseActivity(), 0, 0);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoViewStoryAtVideoThumbAdapter);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131298603));
        }
        paramDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a();
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
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoViewStoryAtVideoThumbAdapter.a((List)localObject, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a());
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(((List)localObject).size());
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setLoadMoreComplete(true ^ this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().mIsVideoEnd);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnLoadMoreListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnScrollChangeListener(this);
        if ((paramDetailFeedItem.size() != ((List)localObject).size()) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
      }
      else
      {
        while (i < this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().size())
        {
          if (((StoryVideoItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().get(i)).mVid.equals(this.jdField_b_of_type_JavaLangString))
          {
            SLog.b("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.resetCurrentX(GeneralFeedProfileSegment.a(getBaseActivity(), i));
            return;
          }
          i += 1;
          continue;
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        }
      }
      return;
    }
    SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
  }
  
  public void a(DetailFeedItem paramDetailFeedItem, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (a())
    {
      SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        a(paramDetailFeedItem);
      }
      a(false);
    }
    else if (paramErrorMessage.isSuccess())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader != null)
      {
        if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
        {
          SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getVideoInfo();
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      a(paramDetailFeedItem);
    }
    boolean bool = paramErrorMessage.isSuccess();
    if (paramErrorMessage.isSuccess()) {
      paramDetailFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.toString();
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
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller.a();
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller.b();
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
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader == null)
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.c())
      {
        SLog.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader = new VideoListPageLoader(2, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedItem.a().getVideoInfo());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader.c();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void b(CommentEntry paramCommentEntry, int paramInt) {}
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("extra_at_video_feed_id");
    this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("extra_at_video_scroll_to_feed_id");
    setTitle(HardCodeUtil.a(2131714201));
    setLeftButton(HardCodeUtil.a(2131714200), null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)a(2131363020));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131374509));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)a(2131374506));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131374508));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131374507));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131374483));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedVideoManager = ((FeedVideoManager)SuperManager.a(12));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller = new DetailFeedAllInfoPuller(this.jdField_a_of_type_JavaLangString, this, false);
    a(true);
    StoryReportor.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public void f() {}
  
  protected int getContentLayoutId()
  {
    return 2131561625;
  }
  
  public boolean onBackEvent()
  {
    StoryAtVideoThumbAdapter.a(getBaseActivity(), null, null);
    StoryReportor.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller;
    if (localObject != null) {
      ((DetailFeedAllInfoPuller)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelVideoListPageLoader;
    if (localObject != null) {
      ((VideoListPageLoader)localObject).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */