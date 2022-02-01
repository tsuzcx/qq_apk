package com.tencent.biz.pubaccount.readinjoy.fragment;

import afez;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.math.BigInteger;
import ozs;
import pag;
import pfd;
import phf;
import phg;
import phh;
import phi;
import qyg;
import zps;

public class ReadInJoyAtlasCommentFragment
  extends PublicBaseFragment
{
  private static String jdField_a_of_type_JavaLangString = "ReadInJoyAtlasCommentFragment";
  private int jdField_a_of_type_Int = 3;
  protected TranslateAnimation a;
  protected ReadInJoyCommentListFragment a;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  public ArticleInfo a;
  protected boolean a;
  private TranslateAnimation b;
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, AnchorData paramAnchorData, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    int i;
    if (((paramContext instanceof Activity)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (paramBundle == null) {
        break label379;
      }
      i = paramBundle.getInt("source", 3);
    }
    for (CommonCommentData localCommonCommentData = (CommonCommentData)paramBundle.getSerializable("commonCommentData");; localCommonCommentData = null)
    {
      boolean bool = true;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("canBiu", true);
      }
      ArticleInfo localArticleInfo = new ArticleInfo();
      int j;
      if (i == 3) {
        j = 1;
      }
      for (;;)
      {
        localArticleInfo.mIsGallery = j;
        localArticleInfo.innerUniqueID = paramString1;
        localArticleInfo.mTitle = paramString2;
        localArticleInfo.mSummary = paramString3;
        localArticleInfo.mFirstPagePicUrl = paramString4;
        if (!bool)
        {
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.a = new qyg();
          localArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean = true;
        }
        if ((localCommonCommentData != null) && (!TextUtils.isEmpty(localCommonCommentData.getArticleId()))) {}
        try
        {
          localArticleInfo.mArticleID = Long.parseLong(localCommonCommentData.getArticleId());
          if ((localCommonCommentData != null) && (!TextUtils.isEmpty(localCommonCommentData.getFeedsId()))) {
            localArticleInfo.mFeedId = new BigInteger(localCommonCommentData.getFeedsId()).longValue();
          }
          if ((localCommonCommentData != null) && (localCommonCommentData.getFeedsType() != -1)) {
            localArticleInfo.mFeedType = localCommonCommentData.getFeedsType();
          }
          paramString1 = new Intent();
          paramString1.putExtra("public_fragment_window_feature", 1);
          paramString1.putExtra("arg_article_info", localArticleInfo);
          if (i == 3) {
            paramString1.putExtra("readinjoy_open_comment_from_atlas", true);
          }
          paramString1.putExtra("readinjoy_open_comment_with_edit_panel", paramBoolean1);
          paramString1.putExtra("source", i);
          paramString1.putExtra("mNeedImmersive", paramBoolean2);
          paramString1.putExtra("anchorData", paramAnchorData);
          paramString1.putExtra("commonCommentData", localCommonCommentData);
          if (paramBundle != null) {
            paramString1.putExtra("bundle", paramBundle);
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, "readToStartComment");
          afez.a((Activity)paramContext, paramString1, PublicTransFragmentActivity.class, ReadInJoyAtlasCommentFragment.class, 6003);
          return;
          j = 0;
        }
        catch (NumberFormatException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
      label379:
      i = 3;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", getActivity().getIntent().getBooleanExtra("readinjoy_open_comment_with_edit_panel", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new phi(this), (ViewGroup)getView().findViewById(2131376167));
      localObject = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376167, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      AnchorData localAnchorData = (AnchorData)getActivity().getIntent().getParcelableExtra("anchorData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c(2131376167);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo, localAnchorData, this.jdField_a_of_type_Int);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onBackEvent();
    boolean bool1 = bool2;
    if (!bool2)
    {
      getView().startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
      bool1 = true;
    }
    return bool1;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("mNeedImmersive", true);
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("source", 3);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)getActivity().getIntent().getSerializableExtra("commonCommentData"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)getActivity().getIntent().getParcelableExtra("arg_article_info"));
    QLog.d(jdField_a_of_type_JavaLangString, 1, "oncreatView  mNeedImmersive = " + this.jdField_a_of_type_Boolean);
    int i;
    if (getActivity().mSystemBarComp == null)
    {
      getActivity().setImmersiveStatus(0);
      paramLayoutInflater = new FrameLayout(getActivity());
      paramViewGroup = new View(getActivity());
      paramLayoutInflater.addView(paramViewGroup, new LinearLayout.LayoutParams(-1, -1));
      paramViewGroup.setOnClickListener(new phf(this));
      paramLayoutInflater.post(new ReadInJoyAtlasCommentFragment.2(this));
      paramViewGroup = new FrameLayout(getActivity());
      paramViewGroup.setId(2131376167);
      if (!this.jdField_a_of_type_Boolean) {
        break label333;
      }
      paramBundle = ozs.a(getActivity());
      i = (int)(paramBundle[1] - paramBundle[0] / 16.0F * 9.0F);
      paramBundle = new FrameLayout.LayoutParams(zps.a(getActivity()), i);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    for (;;)
    {
      this.b = ((TranslateAnimation)AnimationUtils.loadAnimation(getActivity(), 2130772021));
      paramViewGroup.setAnimation(this.b);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
      break;
      label333:
      i = zps.c(getActivity());
      int j = zps.e(getActivity());
      paramBundle = new FrameLayout.LayoutParams(zps.a(getActivity()), i - j);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    pag.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    pfd.a().i();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getActivity(), 2130772001));
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new phg(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
    if (this.b != null) {
      this.b.setAnimationListener(new phh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment
 * JD-Core Version:    0.7.0.1
 */