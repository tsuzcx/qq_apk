package com.tencent.biz.qqstory.storyHome.atvideo.view;

import ajyc;
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
import tdc;
import uov;
import uow;
import uox;
import upc;
import upn;
import upq;
import ups;
import uqd;
import ush;
import uwg;
import uyk;
import vbd;
import vdt;
import veg;
import vel;
import vzo;
import wdg;

public class StoryAtVideoFragment
  extends QQStoryBaseFragment
  implements upc, upq, uyk, vdt, wdg
{
  public ViewGroup a;
  public RelativeLayout a;
  public TextView a;
  public QQStoryAutoPlayView a;
  public StoryHomeHorizontalListView a;
  public String a;
  public uox a;
  public upn a;
  public ups a;
  public uqd a;
  public uwg a;
  public TextView b;
  public String b;
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_at_video_feed_id", paramString1);
    localIntent.putExtra("extra_at_video_scroll_to_feed_id", paramString2);
    PublicFragmentActivity.a(paramActivity, localIntent, StoryAtVideoFragment.class, paramInt);
    paramActivity.overridePendingTransition(2130772278, 2130771990);
  }
  
  public void L_() {}
  
  public void M_() {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(View paramView, VideoListFeedItem paramVideoListFeedItem, StoryVideoItem paramStoryVideoItem, int paramInt)
  {
    uox.a(getActivity(), paramVideoListFeedItem, paramStoryVideoItem);
    getActivity().finish();
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new uow(this), "StoryDetailPresenter");
    paramMap.put(new uov(this), "");
  }
  
  public void a(ups paramups)
  {
    int j = -7829368;
    int i = 0;
    if ((paramups == null) || (!paramups.c())) {
      veg.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
    }
    label269:
    label731:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Ups = paramups;
      veg.b("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramups.toString());
      if ((this.jdField_a_of_type_Ups.a == null) || (this.jdField_a_of_type_Ups.a().isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      if (this.jdField_a_of_type_Ups.a().size() == 1)
      {
        localObject1 = (StoryVideoItem)this.jdField_a_of_type_Ups.a().get(0);
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
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_Ups.a(), (StoryVideoItem)localObject1, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setStoryCoverClickListener(this);
        vbd.a((StoryVideoItem)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView, "QQStory_feed");
        paramups = this.jdField_a_of_type_AndroidWidgetTextView;
        if (((StoryVideoItem)localObject1).mHadRead == 1)
        {
          i = -7829368;
          paramups.setTextColor(i);
          paramups = this.jdField_b_of_type_AndroidWidgetTextView;
          if (((StoryVideoItem)localObject1).mHadRead != 1) {
            break label351;
          }
          i = j;
          paramups.setTextColor(i);
          if (((StoryVideoItem)localObject1).mTimeZoneOffsetMillis == 2147483647L) {
            break label357;
          }
        }
        label351:
        label357:
        for (paramups = vzo.a(((StoryVideoItem)localObject1).mCreateTime, ((StoryVideoItem)localObject1).mTimeZoneOffsetMillis);; paramups = vzo.b(((StoryVideoItem)localObject1).mCreateTime))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramups);
          if (!(this.jdField_a_of_type_Ups.a.getOwner() instanceof ShareGroupItem)) {
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
      if (this.jdField_a_of_type_Uox == null)
      {
        this.jdField_a_of_type_Uox = new uox(getActivity(), getActivity(), 0, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_Uox);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131298330));
      }
      paramups = this.jdField_a_of_type_Ups.a();
      Object localObject1 = new ArrayList();
      if (!paramups.isEmpty())
      {
        localObject2 = paramups.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
          if ((!localStoryVideoItem.isUploading()) && (!localStoryVideoItem.isUploadFail())) {
            ((List)localObject1).add(localStoryVideoItem);
          }
        }
      }
      this.jdField_a_of_type_Uox.a((List)localObject1, this.jdField_a_of_type_Ups.a());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(((List)localObject1).size());
      Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      boolean bool;
      if (!this.jdField_a_of_type_Ups.a().mIsVideoEnd)
      {
        bool = true;
        ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(bool);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnLoadMoreListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnScrollChangeListener(this);
        if ((paramups.size() != ((List)localObject1).size()) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Ups.a().size()) {
            break label731;
          }
          if (((StoryVideoItem)this.jdField_a_of_type_Ups.a().get(i)).mVid.equals(this.jdField_b_of_type_JavaLangString))
          {
            veg.b("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.resetCurrentX(ush.a(getActivity(), i));
            return;
            bool = false;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(ups paramups, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (a())
    {
      veg.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    boolean bool;
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        a(paramups);
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label151;
      }
    }
    label151:
    for (paramups = this.jdField_a_of_type_Ups.toString();; paramups = "null")
    {
      veg.a("Q.qqstory.atvideo.StoryAtVideoFragment", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramups);
      return;
      if (!paramErrorMessage.isSuccess()) {
        break;
      }
      if (this.jdField_a_of_type_Uqd != null)
      {
        if (!this.jdField_a_of_type_Ups.c())
        {
          veg.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Ups.a().getVideoInfo();
        this.jdField_a_of_type_Uqd.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      a(paramups);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Upn.a();
      return;
    }
    this.jdField_a_of_type_Upn.b();
  }
  
  public boolean a(boolean paramBoolean)
  {
    veg.b("Q.qqstory.atvideo.StoryAtVideoFragment", "load more video");
    b();
    return true;
  }
  
  public void b()
  {
    veg.c("Q.qqstory.atvideo.StoryAtVideoFragment", "request load next page video.");
    if (this.jdField_a_of_type_Uqd == null)
    {
      if (!this.jdField_a_of_type_Ups.c())
      {
        veg.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Uqd = new uqd(2, this.jdField_a_of_type_Ups.a().getVideoInfo());
      this.jdField_a_of_type_Uqd.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Uqd.c();
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
    setTitle(ajyc.a(2131714400));
    setLeftButton(ajyc.a(2131714399), null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)a(2131362839));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373258));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)a(2131373255));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131373257));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131373256));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131373232));
    this.jdField_a_of_type_Uwg = ((uwg)tdc.a(12));
    this.jdField_a_of_type_Upn = new upn(this.jdField_a_of_type_JavaLangString, this, false);
    a(true);
    vel.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public void f() {}
  
  public int getContentLayoutId()
  {
    return 2131561199;
  }
  
  public boolean onBackEvent()
  {
    uox.a(getActivity(), null, null);
    vel.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Upn != null) {
      this.jdField_a_of_type_Upn.c();
    }
    if (this.jdField_a_of_type_Uqd != null) {
      this.jdField_a_of_type_Uqd.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */