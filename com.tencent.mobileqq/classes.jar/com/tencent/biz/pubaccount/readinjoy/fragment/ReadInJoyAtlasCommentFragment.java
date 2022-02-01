package com.tencent.biz.pubaccount.readinjoy.fragment;

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
import com.tencent.biz.pubaccount.readinjoy.common.TimeSliceHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.device.RIJDisplayStyleManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.Serializable;
import java.math.BigInteger;

public class ReadInJoyAtlasCommentFragment
  extends PublicBaseFragment
{
  private static String jdField_a_of_type_JavaLangString = "ReadInJoyAtlasCommentFragment";
  private int jdField_a_of_type_Int = -1;
  protected TranslateAnimation a;
  protected ReadInJoyCommentListFragment a;
  private CommonCommentData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  protected ArticleInfo a;
  private TKDCommentDispatcher.HippyCommentEvent jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent = new ReadInJoyAtlasCommentFragment.6(this);
  protected boolean a;
  private int jdField_b_of_type_Int = 3;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  
  public static ArticleInfo a(Bundle paramBundle)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    if (paramBundle != null)
    {
      paramBundle = (ArticleInfo)paramBundle.getParcelable("articleInfo");
      if (paramBundle != null) {
        return paramBundle;
      }
    }
    return localArticleInfo;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, AnchorData paramAnchorData, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    int i;
    long l;
    Object localObject;
    if (((paramContext instanceof Activity)) && (!TextUtils.isEmpty(paramString1)))
    {
      i = 3;
      l = 0L;
      if (paramBundle == null) {
        break label446;
      }
      i = paramBundle.getInt("source", 3);
      l = paramBundle.getLong("recommendSeq", 0L);
      localObject = paramBundle.getSerializable("commonCommentData");
      if (!(localObject instanceof CommonCommentData)) {
        break label440;
      }
      localObject = (CommonCommentData)localObject;
    }
    for (;;)
    {
      ArticleInfo localArticleInfo = a(paramBundle);
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
        localArticleInfo.mRecommendSeq = l;
        boolean bool = true;
        if (paramBundle != null) {
          bool = paramBundle.getBoolean("canBiu", true);
        }
        if (!bool)
        {
          localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
          localArticleInfo.mSocialFeedInfo.a = new SocializeFeedsInfo.PGCFeedsInfo();
          localArticleInfo.mSocialFeedInfo.a.jdField_a_of_type_Boolean = true;
        }
        if ((localObject == null) || (a((CommonCommentData)localObject, ((CommonCommentData)localObject).getArticleId()))) {}
        try
        {
          localArticleInfo.mArticleID = Long.parseLong(((CommonCommentData)localObject).getArticleId());
          if (a((CommonCommentData)localObject, ((CommonCommentData)localObject).getFeedsId())) {
            localArticleInfo.mFeedId = new BigInteger(((CommonCommentData)localObject).getFeedsId()).longValue();
          }
          if (a((CommonCommentData)localObject, ((CommonCommentData)localObject).getFeedsType())) {
            localArticleInfo.mFeedType = ((CommonCommentData)localObject).getFeedsType();
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
          paramString1.putExtra("commonCommentData", (Serializable)localObject);
          if (paramBundle != null)
          {
            paramString1.putExtra("bundle", paramBundle);
            paramString1.putExtra("comment_layout_height", paramBundle.getInt("comment_layout_height", -1));
            paramString1.putExtra("bigT_report_entry", paramBundle.getInt("bigT_report_entry", -1));
          }
          QLog.d(jdField_a_of_type_JavaLangString, 1, "readToStartComment");
          PublicFragmentActivity.Launcher.a((Activity)paramContext, paramString1, PublicTransFragmentActivity.class, ReadInJoyAtlasCommentFragment.class, 6003);
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
      label440:
      localObject = null;
      continue;
      label446:
      localObject = null;
    }
  }
  
  private static boolean a(CommonCommentData paramCommonCommentData, int paramInt)
  {
    return (paramCommonCommentData != null) && (paramCommonCommentData.getFeedsType() != -1);
  }
  
  private static boolean a(CommonCommentData paramCommonCommentData, String paramString)
  {
    return (paramCommonCommentData != null) && (!TextUtils.isEmpty(paramString));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", getActivity().getIntent().getBooleanExtra("readinjoy_open_comment_with_edit_panel", false));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new ReadInJoyAtlasCommentFragment.5(this), (ViewGroup)getView().findViewById(2131376565));
      localObject = getActivity().getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376565, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void c()
  {
    View localView = getView();
    if (localView != null) {
      localView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  public void a()
  {
    b();
    TKDCommentDispatcher.INSTANCE.addEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      AnchorData localAnchorData = (AnchorData)getActivity().getIntent().getParcelableExtra("anchorData");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c(2131376565);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo, localAnchorData, this.jdField_b_of_type_Int);
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
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
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("mNeedImmersive", true);
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("comment_layout_height", -1);
    this.jdField_b_of_type_Int = getActivity().getIntent().getIntExtra("source", 3);
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
      paramViewGroup.setOnClickListener(new ReadInJoyAtlasCommentFragment.1(this));
      paramLayoutInflater.post(new ReadInJoyAtlasCommentFragment.2(this));
      paramViewGroup = new FrameLayout(getActivity());
      paramViewGroup.setId(2131376565);
      if (!this.jdField_a_of_type_Boolean) {
        break label351;
      }
      paramBundle = RIJDisplayStyleManager.a(getActivity());
      i = (int)(paramBundle[1] - paramBundle[0] / 16.0F * 9.0F);
      paramBundle = new FrameLayout.LayoutParams(UIUtils.a(getActivity()), i);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getActivity(), 2130772024));
      paramViewGroup.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
      break;
      label351:
      i = UIUtils.c(getActivity()) - UIUtils.e(getActivity());
      if (this.jdField_a_of_type_Int > 0) {
        i = this.jdField_a_of_type_Int / 3;
      }
      paramBundle = new FrameLayout.LayoutParams(UIUtils.a(getActivity()), i);
      paramBundle.gravity = 80;
      paramLayoutInflater.addView(paramViewGroup, paramBundle);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
  }
  
  public void onResume()
  {
    super.onResume();
    TimeSliceHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#80000000")));
    ReadInJoyLogicEngineEventDispatcher.a().h();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = ((TranslateAnimation)AnimationUtils.loadAnimation(getActivity(), 2130772003));
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ReadInJoyAtlasCommentFragment.3(this));
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(new LinearInterpolator());
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ReadInJoyAtlasCommentFragment.4(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment
 * JD-Core Version:    0.7.0.1
 */