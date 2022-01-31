package com.tencent.biz.qqstory.storyHome.atvideo.view;

import ajya;
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
import tcz;
import uos;
import uot;
import uou;
import uoz;
import upk;
import upn;
import upp;
import uqa;
import use;
import uwd;
import uyh;
import vba;
import vdq;
import ved;
import vei;
import vzl;
import wdd;

public class StoryAtVideoFragment
  extends QQStoryBaseFragment
  implements uoz, upn, uyh, vdq, wdd
{
  public ViewGroup a;
  public RelativeLayout a;
  public TextView a;
  public QQStoryAutoPlayView a;
  public StoryHomeHorizontalListView a;
  public String a;
  public uou a;
  public upk a;
  public upp a;
  public uqa a;
  public uwd a;
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
    uou.a(getActivity(), paramVideoListFeedItem, paramStoryVideoItem);
    getActivity().finish();
  }
  
  public void a(CommentEntry paramCommentEntry, int paramInt) {}
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new uot(this), "StoryDetailPresenter");
    paramMap.put(new uos(this), "");
  }
  
  public void a(upp paramupp)
  {
    int j = -7829368;
    int i = 0;
    if ((paramupp == null) || (!paramupp.c())) {
      ved.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
    }
    label269:
    label731:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Upp = paramupp;
      ved.b("Q.qqstory.atvideo.StoryAtVideoFragment", "update feed video info. %s.", paramupp.toString());
      if ((this.jdField_a_of_type_Upp.a == null) || (this.jdField_a_of_type_Upp.a().isEmpty()))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      if (this.jdField_a_of_type_Upp.a().size() == 1)
      {
        localObject1 = (StoryVideoItem)this.jdField_a_of_type_Upp.a().get(0);
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
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setItemData(this.jdField_a_of_type_Upp.a(), (StoryVideoItem)localObject1, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView.setStoryCoverClickListener(this);
        vba.a((StoryVideoItem)localObject1, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView, "QQStory_feed");
        paramupp = this.jdField_a_of_type_AndroidWidgetTextView;
        if (((StoryVideoItem)localObject1).mHadRead == 1)
        {
          i = -7829368;
          paramupp.setTextColor(i);
          paramupp = this.jdField_b_of_type_AndroidWidgetTextView;
          if (((StoryVideoItem)localObject1).mHadRead != 1) {
            break label351;
          }
          i = j;
          paramupp.setTextColor(i);
          if (((StoryVideoItem)localObject1).mTimeZoneOffsetMillis == 2147483647L) {
            break label357;
          }
        }
        label351:
        label357:
        for (paramupp = vzl.a(((StoryVideoItem)localObject1).mCreateTime, ((StoryVideoItem)localObject1).mTimeZoneOffsetMillis);; paramupp = vzl.b(((StoryVideoItem)localObject1).mCreateTime))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(paramupp);
          if (!(this.jdField_a_of_type_Upp.a.getOwner() instanceof ShareGroupItem)) {
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
      if (this.jdField_a_of_type_Uou == null)
      {
        this.jdField_a_of_type_Uou = new uou(getActivity(), getActivity(), 0, 0);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setAdapter(this.jdField_a_of_type_Uou);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDividerWidth(getResources().getDimensionPixelSize(2131298330));
      }
      paramupp = this.jdField_a_of_type_Upp.a();
      Object localObject1 = new ArrayList();
      if (!paramupp.isEmpty())
      {
        localObject2 = paramupp.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          StoryVideoItem localStoryVideoItem = (StoryVideoItem)((Iterator)localObject2).next();
          if ((!localStoryVideoItem.isUploading()) && (!localStoryVideoItem.isUploadFail())) {
            ((List)localObject1).add(localStoryVideoItem);
          }
        }
      }
      this.jdField_a_of_type_Uou.a((List)localObject1, this.jdField_a_of_type_Upp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setDataCount(((List)localObject1).size());
      Object localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView;
      boolean bool;
      if (!this.jdField_a_of_type_Upp.a().mIsVideoEnd)
      {
        bool = true;
        ((StoryHomeHorizontalListView)localObject2).setLoadMoreComplete(bool);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnLoadMoreListener(this);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setOnScrollChangeListener(this);
        if ((paramupp.size() != ((List)localObject1).size()) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
      }
      else
      {
        for (;;)
        {
          if (i >= this.jdField_a_of_type_Upp.a().size()) {
            break label731;
          }
          if (((StoryVideoItem)this.jdField_a_of_type_Upp.a().get(i)).mVid.equals(this.jdField_b_of_type_JavaLangString))
          {
            ved.b("Q.qqstory.atvideo.StoryAtVideoFragment", "select video position:%d.", Integer.valueOf(i));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.resetCurrentX(use.a(getActivity(), i));
            return;
            bool = false;
            break;
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(upp paramupp, boolean paramBoolean, ErrorMessage paramErrorMessage)
  {
    if (a())
    {
      ved.e("Q.qqstory.atvideo.StoryAtVideoFragment", "feed data back after activity destroy.");
      return;
    }
    boolean bool;
    if (paramBoolean)
    {
      if (paramErrorMessage.isSuccess()) {
        a(paramupp);
      }
      a(false);
      bool = paramErrorMessage.isSuccess();
      if (!paramErrorMessage.isSuccess()) {
        break label151;
      }
    }
    label151:
    for (paramupp = this.jdField_a_of_type_Upp.toString();; paramupp = "null")
    {
      ved.a("Q.qqstory.atvideo.StoryAtVideoFragment", "on feed data back. result=%s, isLocal = %s, data = %s.", Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramupp);
      return;
      if (!paramErrorMessage.isSuccess()) {
        break;
      }
      if (this.jdField_a_of_type_Uqa != null)
      {
        if (!this.jdField_a_of_type_Upp.c())
        {
          ved.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list.");
          return;
        }
        FeedVideoInfo localFeedVideoInfo = this.jdField_a_of_type_Upp.a().getVideoInfo();
        this.jdField_a_of_type_Uqa.a(localFeedVideoInfo.mVideoPullType, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mVideoSeq);
      }
      a(paramupp);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Upk.a();
      return;
    }
    this.jdField_a_of_type_Upk.b();
  }
  
  public boolean a(boolean paramBoolean)
  {
    ved.b("Q.qqstory.atvideo.StoryAtVideoFragment", "load more video");
    b();
    return true;
  }
  
  public void b()
  {
    ved.c("Q.qqstory.atvideo.StoryAtVideoFragment", "request load next page video.");
    if (this.jdField_a_of_type_Uqa == null)
    {
      if (!this.jdField_a_of_type_Upp.c())
      {
        ved.e("Q.qqstory.atvideo.StoryAtVideoFragment", "this feed does not support video list. can't execute loading next page.");
        return;
      }
      this.jdField_a_of_type_Uqa = new uqa(2, this.jdField_a_of_type_Upp.a().getVideoInfo());
      this.jdField_a_of_type_Uqa.b("StoryDetailPresenter");
    }
    this.jdField_a_of_type_Uqa.c();
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
    setTitle(ajya.a(2131714411));
    setLeftButton(ajya.a(2131714410), null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView = ((StoryHomeHorizontalListView)a(2131362838));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131373260));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAutoplayQQStoryAutoPlayView = ((QQStoryAutoPlayView)a(2131373257));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131373259));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131373258));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131373234));
    this.jdField_a_of_type_Uwd = ((uwd)tcz.a(12));
    this.jdField_a_of_type_Upk = new upk(this.jdField_a_of_type_JavaLangString, this, false);
    a(true);
    vei.a("home_page", "exp_choose", 0, 0, new String[0]);
  }
  
  public void f() {}
  
  public int getContentLayoutId()
  {
    return 2131561198;
  }
  
  public boolean onBackEvent()
  {
    uou.a(getActivity(), null, null);
    vei.a("home_page", "choose_cancel", 0, 0, new String[0]);
    return super.onBackEvent();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Upk != null) {
      this.jdField_a_of_type_Upk.c();
    }
    if (this.jdField_a_of_type_Uqa != null) {
      this.jdField_a_of_type_Uqa.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.atvideo.view.StoryAtVideoFragment
 * JD-Core Version:    0.7.0.1
 */