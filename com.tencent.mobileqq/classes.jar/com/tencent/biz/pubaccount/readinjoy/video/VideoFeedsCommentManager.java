package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import maq;
import mar;
import mas;

public class VideoFeedsCommentManager
  implements VideoFeedsListView.ListViewEventListener
{
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener;
  private VideoFeedsListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  VideoFeedsCommentManager(FragmentActivity paramFragmentActivity, VideoFeedsListView paramVideoFeedsListView, VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView = paramVideoFeedsListView;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131034193));
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131034135));
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new maq(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(200L);
    }
  }
  
  private void f()
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new mas(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo);
    }
  }
  
  public void a(VideoFeedsCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener = paramCommentEventListener;
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        this.b = true;
      }
    }
    while (!this.b) {
      return;
    }
    this.b = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    if (this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setNeedDetectScreenOrientation(false);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
          this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setIsScrollItemToTop(true, true);
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (NetworkUtil.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(true);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener.a(paramBoolean1);
      }
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(false);
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 100);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setScrollable(false);
      break;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setNeedDetectScreenOrientation(true);
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        break label232;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setIsScrollItemToTop(false, false);
      label214:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) {
        break label271;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(false);
    }
    label232:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter.a(true);
    if (paramBoolean2) {
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsListView.setScrollable(true);
      break label214;
      label271:
      break;
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 8, 100);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.f()) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
      a(false, paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = VideoFeedsHelper.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    e();
    f();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = VideoFeedsHelper.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new mar(this), this.jdField_a_of_type_AndroidViewViewGroup);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131367310, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager
 * JD-Core Version:    0.7.0.1
 */