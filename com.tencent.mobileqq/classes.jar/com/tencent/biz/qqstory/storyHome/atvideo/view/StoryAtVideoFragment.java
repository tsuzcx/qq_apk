package com.tencent.biz.qqstory.storyHome.atvideo.view;

import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.QQStoryAutoPlayView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sqg;
import ubz;
import uca;
import ucb;
import ucg;
import ucr;
import ucu;
import ucw;
import udh;
import ufl;
import ujk;
import ulo;
import uoh;
import uqx;
import urk;
import urp;
import vms;
import vqk;

public class StoryAtVideoFragment
  extends QQStoryBaseFragment
  implements ucg, ucu, ulo, uqx, vqk
{
  public ViewGroup a;
  public RelativeLayout a;
  public TextView a;
  public QQStoryAutoPlayView a;
  public StoryHomeHorizontalListView a;
  public String a;
  public ucb a;
  public ucr a;
  public ucw a;
  public udh a;
  public ujk a;
  public TextView b;
  public String b;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_at_video_feed_id", paramString1);
    localIntent.putExtra("extra_at_video_scroll_to_feed_id", paramString2);
    PublicFragmentActivity.a(paramActivity, localIntent, StoryAtVideoFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772277, 2130771990);
  }
  
  public void N_() {}
  
  public void O_() {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    ucb.a(getActivity(), paramVideoListFeedItem, paramStoryVideoItem);
    getActivity().finish();
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new uca(this), "StoryDetailPresenter");
    paramMap.put(new ubz(this), "");
  }
  
  public void a(ucw paramucw)
  {
    int j = -7829368;
    int i = 0;
    if ((paramucw == null) || (!paramucw.c())) {
      urk.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
    }
    label269:
    label731:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Ucw = paramucw;
      urk.b("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramucw.toString());
      if ((this.jdField_a_of_type_Ucw.a == null) || (this.jdField_a_of_type_Ucw.a().isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      if (this.jdField_a_of_type_Ucw.a().size() == 1)
      {
        localObject1 = (StoryVideoItem)this.jdField_a_of_type_Ucw.a().get(0);
        if ((((StoryVideoItem)localObject1).isUploading()) || (((StoryVideoItem)localObject1).isUploadFail()))
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_Ucw.a(), (StoryVideoItem)localObject1, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setStoryCoverClickListener(this);
        uoh.a((StoryVideoItem)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView, "QQStory_feed");
        paramucw = this.jdField_a_of_type_AndroidWidgetTextView;
        if (((StoryVideoItem)localObject1).mHadRead == 1)
        {
          i = -7829368;
          paramucw.setTextColor(i);
          paramucw = this.jdField_b_of_type_AndroidWidgetTextView;
          if (((StoryVideoItem)localObject1).mHadRead != 1) {
            break label351;
          }
          i = j;
          paramucw.setTextColor(i);
          if (((StoryVideoItem)localObject1).mTimeZoneOffsetMillis == 2147483647L) {
            break label357;
          }
        }
        label351:
        label357:
        for (paramucw = vms.a(((StoryVideoItem)localObject1).mCreateTime, ((StoryVideoItem)localObject1).mTimeZoneOffsetMillis);; paramucw = vms.b(((StoryVideoItem)localObject1).mCreateTime))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramucw);
          if (!(this.jdField_a_of_type_Ucw.a.getOwner() instanceof ShareGroupItem)) {
            break label369;
          }
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((StoryVideoItem)localObject1).mOwnerName);
          return;
          i = -16777216;
          break;
          i = -16777216;
          break label269;
        }
        label369:
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_Ucb == null)
      {
        this.jdField_a_of_type_Ucb = new ucb(getActivity(), getActivity(), 0, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_Ucb);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131167237));
      }
      paramucw = this.jdField_a_of_type_Ucw.a();
      Object localObject1 = new ArrayList();
      if (!paramucw.isEmpty())
      {
        localObject2 = paramucw.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
          if ((!localStoryVideoItem.isUploading()) && (!localStoryVideoItem.isUploadFail())) {
            ((List)localObject1).add(localStoryVideoItem);
          }
        }
      }
      this.jdField_a_of_type_Ucb.a((List)localObject1, this.jdField_a_of_type_Ucw.a());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(((List)localObject1).size());
      Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      boolean bool;
      if (!this.jdField_a_of_type_Ucw.a().mIsVideoEnd)
      {
        bool = true;
        ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(bool);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnLoadMoreListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnScrollChangeListener(this);
        if ((paramucw.size() != ((List)localObject1).size()) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Ucw.a().size()) {
            break label731;
          }
          if (((StoryVideoItem)this.jdField_a_of_type_Ucw.a().get(i)).mVid.equals(this.jdField_b_of_type_JavaLangString))
          {
            urk.b("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.resetCurrentX(ufl.a(getActivity(), i));
            return;
            bool = false;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(ucw paramucw, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (a())
    {
      urk.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    boolean bool;
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        a(paramucw);
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label151;
      }
    }
    label151:
    for (paramucw = this.jdField_a_of_type_Ucw.toString();; paramucw = "null")
    {
      urk.a("Q.qqstory.atvideo.StoryAtVideoFragment", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramucw);
      return;
      if (!paramErrorMessage.isSuccess()) {
        break;
      }
      if (this.jdField_a_of_type_Udh != null)
      {
        if (!this.jdField_a_of_type_Ucw.c())
        {
          urk.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Ucw.a().getVideoInfo();
        this.jdField_a_of_type_Udh.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      a(paramucw);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Ucr.a();
      return;
    }
    this.jdField_a_of_type_Ucr.b();
  }
  
  public boolean a(boolean paramBoolean)
  {
    urk.b("Q.qqstory.atvideo.StoryAtVideoFragment", "load more video");
    b();
    return true;
  }
  
  public void b()
  {
    urk.c("Q.qqstory.atvideo.StoryAtVideoFragment", "request load next page video.");
    if (this.jdField_a_of_type_Udh == null)
    {
      if (!this.jdField_a_of_type_Ucw.c())
      {
        urk.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Udh = new udh(2, this.jdField_a_of_type_Ucw.a().getVideoInfo());
      this.jdField_a_of_type_Udh.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Udh.c();
  }
  
  public void b(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt) {}
  
  public void b(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = getArguments();
    this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("extra_at_video_feed_id");
    this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("extra_at_video_scroll_to_feed_id");
    setTitle(ajjy.a(2131648611));
    setLeftButton(ajjy.a(2131648610), null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)a(2131297299));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131307545));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)a(2131307542));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131307544));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131307543));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131307519));
    this.jdField_a_of_type_Ujk = ((ujk)sqg.a(12));
    this.jdField_a_of_type_Ucr = new ucr(this.jdField_a_of_type_JavaLangString, this, false);
    a(true);
    urp.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public void f() {}
  
  public int getContentLayoutId()
  {
    return 2131495608;
  }
  
  public boolean onBackEvent()
  {
    ucb.a(getActivity(), null, null);
    urp.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Ucr != null) {
      this.jdField_a_of_type_Ucr.c();
    }
    if (this.jdField_a_of_type_Udh != null) {
      this.jdField_a_of_type_Udh.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */