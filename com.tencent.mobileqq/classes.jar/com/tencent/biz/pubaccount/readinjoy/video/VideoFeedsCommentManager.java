package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.IAdapter;
import com.tencent.hippy.qq.utils.tkd.TKDCommentFragmentHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class VideoFeedsCommentManager
  implements VideoFeedsRecyclerView.ListEventListener
{
  private int jdField_a_of_type_Int = 0;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = null;
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener = null;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
  private IAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoIAdapter = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  
  public VideoFeedsCommentManager(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, IAdapter paramIAdapter, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (paramVideoFeedsRecyclerView != null) {
      paramVideoFeedsRecyclerView.a(this);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoMultivideoIAdapter = paramIAdapter;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = paramVideoFeedsPlayManager;
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130772085));
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new LinearInterpolator());
    }
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2130772003));
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new VideoFeedsCommentManager.1(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null) {
      return;
    }
    int j = a();
    int i = 0;
    if (j == 2) {
      i = 1;
    }
    RIJTransMergeKanDianReport.a(i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.b(), paramInt);
  }
  
  private void j()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
    ((Bundle)localObject).putBoolean("is_from_viola", true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(VideoFeedsResourceLoader.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, a(), this.jdField_a_of_type_AndroidViewViewGroup);
    localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    ((FragmentTransaction)localObject).add(2131365103, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void k()
  {
    RIJUserLevelModule.a().a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, new VideoFeedsCommentManager.4(this));
  }
  
  private void l()
  {
    try
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new VideoFeedsCommentManager.5(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void E_() {}
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a();
    }
    return -1;
  }
  
  public VideoInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  }
  
  @NotNull
  public ReadInJoyCommentUtils.FirstCommentEvent a()
  {
    return new VideoFeedsCommentManager.2(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        this.c = true;
      }
    }
    while (!this.c) {
      return;
    }
    this.c = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void a(AnchorData paramAnchorData)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null) {
      b();
    }
    ArticleInfo localArticleInfo;
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (TKDCommentFragmentHelper.enableHippyComment()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a()))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramAnchorData);
      }
      c();
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 100);
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentById(2131365103);
        if ((localFragment instanceof ReadInJoyCommentListFragment)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
        }
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (localArticleInfo != null)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo == null) {
          break label252;
        }
      }
    }
    label252:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(localArticleInfo, paramAnchorData, bool, 2);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (NetworkUtil.h(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(true);
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener.a(true);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.g();
      }
      return;
    }
  }
  
  public void a(VideoFeedsCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener = paramCommentEventListener;
  }
  
  public boolean a()
  {
    a(2);
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.d());
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (VideoFeedsHelper.c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) - this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    d();
    l();
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = (VideoFeedsHelper.c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) - this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
  }
  
  public void d()
  {
    j();
  }
  
  public void e()
  {
    a(null);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.e();
      }
      if ((this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) && (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)) {
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
      }
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCommentManager$CommentEventListener.a(false);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.h();
      }
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        e();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(new VideoFeedsCommentManager.3(this));
      }
    }
    else {
      return;
    }
    e();
    k();
  }
  
  public void h()
  {
    if (a()) {
      f();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(null);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsCommentManager
 * JD-Core Version:    0.7.0.1
 */