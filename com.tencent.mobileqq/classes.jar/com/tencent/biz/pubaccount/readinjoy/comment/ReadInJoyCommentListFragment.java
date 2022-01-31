package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.List;
import lmc;
import lmd;
import lme;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyCommentListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoyCommentUtils.FirstCommentEvent jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private View d;
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule != null)
    {
      int i = 0;
      if (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().size())
      {
        CommentInfo localCommentInfo = (CommentInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule.getCommentList().get(i);
        if (localCommentInfo.commentByMyself) {}
        do
        {
          i += 1;
          break;
          localArrayList.add(localCommentInfo);
        } while (localArrayList.size() != 10);
      }
    }
    localBundle.putSerializable("backToImageData", localArrayList);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = new ReadInJoyCommentListAdapter(getActivity(), this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    a((ArticleInfo)getActivity().getIntent().getParcelableExtra("arg_article_info"));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollToPositionFromTop(0, 0, 500);
  }
  
  public void a()
  {
    FragmentTransaction localFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.setCustomAnimations(0, 2131034135);
    localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    float f;
    label126:
    QQAppInterface localQQAppInterface;
    String str;
    if (paramInt1 == 2)
    {
      localObject = getActivity().getSupportFragmentManager().beginTransaction();
      if ((paramInt2 > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getView() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getView().getHeight() > 0))
      {
        f = paramInt2 / this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.getView().getHeight();
        if (f <= 0.3F) {
          ((FragmentTransaction)localObject).setCustomAnimations(0, 2131034136);
        }
      }
      else
      {
        ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
        ((FragmentTransaction)localObject).commitAllowingStateLoss();
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_a_of_type_AndroidViewView, true);
        localQQAppInterface = (QQAppInterface)getActivity().getAppInterface();
        str = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (!this.jdField_c_of_type_Boolean) {
          break label246;
        }
      }
    }
    label246:
    for (Object localObject = "1";; localObject = "2")
    {
      PublicAccountReportUtils.a(localQQAppInterface, str, "0X800920E", "0X800920E", 0, 0, (String)localObject, String.valueOf(paramInt1), "", "", false);
      return;
      if (f <= 0.4F)
      {
        ((FragmentTransaction)localObject).setCustomAnimations(0, 2131034137);
        break;
      }
      if (f > 0.5F) {
        break;
      }
      ((FragmentTransaction)localObject).setCustomAnimations(0, 2131034138);
      break;
      if ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent == null)) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(false);
      break label126;
    }
  }
  
  public void a(Bundle paramBundle, ReadInJoyCommentUtils.FirstCommentEvent paramFirstCommentEvent, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent = paramFirstCommentEvent;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    if (!NetworkUtil.g(getActivity())) {
      a(true);
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a(paramArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.b();
      return;
      a(false);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {}
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (this.d != null) {
          this.d.setVisibility(8);
        }
      } while (this.jdField_c_of_type_AndroidViewView == null);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jdField_c_of_type_AndroidViewView);
      return;
      if (this.d != null)
      {
        this.d.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.d);
      }
    } while (this.jdField_c_of_type_AndroidViewView == null);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, CommentInfo paramCommentInfo)
  {
    if (paramBoolean)
    {
      paramCommentInfo = getActivity().getSupportFragmentManager().beginTransaction();
      paramCommentInfo.setCustomAnimations(0, 2131034135);
      paramCommentInfo.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramCommentInfo.commitAllowingStateLoss();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_a_of_type_AndroidViewView, true);
      return;
    }
    FragmentTransaction localFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.setCustomAnimations(2131034134, 2131034121);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(paramCommentInfo, this.jdField_b_of_type_Boolean);
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    localFragmentTransaction.commitAllowingStateLoss();
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramCommentInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, false);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a(true, null);
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int = 0;
    }
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_c_of_type_Boolean) && (getView() != null))
    {
      getView().setFitsSystemWindows(paramBoolean);
      getView().setPadding(0, 0, 0, 0);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a();
      this.jdField_a_of_type_Int = 1;
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int = 0;
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 117) {
      if (this.jdField_a_of_type_Int == 1)
      {
        paramIntent = paramIntent.getStringExtra("arg_result_json");
        Object localObject;
        boolean bool;
        try
        {
          localObject = new JSONObject(paramIntent);
          bool = ((JSONObject)localObject).optBoolean("isSecondReply");
          if (paramInt2 == -1)
          {
            this.jdField_a_of_type_JavaLangString = "";
            if (bool)
            {
              localObject = ((JSONObject)localObject).optString("commentId");
              ReadInJoyCommentUtils.a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 2, (String)localObject, paramIntent, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule, this.jdField_c_of_type_Int, new lmd(this, paramIntent));
              return;
            }
            ReadInJoyCommentUtils.a((QQAppInterface)getActivity().getAppRuntime(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1, null, paramIntent, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule, this.jdField_c_of_type_Int, new lme(this, paramIntent));
            return;
          }
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
        if ((paramInt2 == 0) && (!bool))
        {
          this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("comment");
          this.jdField_a_of_type_JavaLangString = new String(Base64Util.decode(this.jdField_a_of_type_JavaLangString, 0));
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    return a();
  }
  
  public void onClick(View paramView)
  {
    int j = 2;
    switch (paramView.getId())
    {
    default: 
    case 2131362873: 
    case 2131366985: 
    case 2131366986: 
    case 2131366987: 
    case 2131363516: 
    case 2131367007: 
      boolean bool;
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_b_of_type_Boolean)
            {
              getActivity().setResult(-1, a());
              getActivity().finish();
              return;
            }
          } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent == null);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.onClick(paramView);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent.a(this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int);
          this.jdField_b_of_type_Int = 0;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.jdField_a_of_type_Int = 0;
          return;
          k = 4;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
        if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType != 1) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
          break;
        }
        i = 2;
        localObject1 = getActivity();
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localObject3 = this.jdField_a_of_type_JavaLangString;
        if (this.jdField_b_of_type_Boolean) {
          break label427;
        }
        bool = true;
        ReadInJoyCommentUtils.a((Activity)localObject1, (ArticleInfo)localObject2, null, i, "", (String)localObject3, false, null, bool);
      } while (paramView.getId() != 2131363516);
      paramView = (QQAppInterface)getActivity().getAppInterface();
      Object localObject1 = ReadInJoyCommentUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      int k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      Object localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (this.jdField_b_of_type_Boolean) {}
      for (int i = j;; i = 1)
      {
        PublicAccountReportUtils.a(paramView, (String)localObject1, "0X800900C", "0X800900C", 0, 0, String.valueOf(l), String.valueOf(k), (String)localObject2, ReadInJoyCommentUtils.a((ArticleInfo)localObject3, i, ""), false);
        return;
        i = k;
        if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
          break;
        }
        i = k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo == null) {
          break;
        }
        i = k;
        if (!ReadInJoyDeliverBiuActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          break;
        }
        i = 9;
        break;
        bool = false;
        break label245;
      }
    case 2131366984: 
      label245:
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      label427:
      return;
    }
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969558, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131362873).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363516).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131363397).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131367007).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366988);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131366982));
    this.d = paramLayoutInflater.findViewById(2131366983);
    this.jdField_c_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131366984);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    a(false);
    this.jdField_b_of_type_Boolean = getActivity().getIntent().getBooleanExtra("readinjoy_open_comment_from_image", false);
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_c_of_type_Int = 1;; this.jdField_c_of_type_Int = 2)
    {
      paramViewGroup = getArguments();
      this.jdField_c_of_type_Boolean = paramViewGroup.getBoolean("readinjoy_open_comment_from_video", false);
      if (this.jdField_c_of_type_Boolean)
      {
        paramLayoutInflater.setFitsSystemWindows(false);
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup;
      }
      if (paramViewGroup.getBoolean("arg_comment_list_comment_btn", false))
      {
        paramBundle = paramLayoutInflater.findViewById(2131366986);
        paramBundle.setVisibility(0);
        paramBundle.setOnClickListener(this);
      }
      if (paramViewGroup.getBoolean("arg_comment_list_share_btn", false))
      {
        paramBundle = paramLayoutInflater.findViewById(2131366987);
        paramBundle.setVisibility(0);
        paramBundle.setOnClickListener(this);
      }
      if (paramViewGroup.getBoolean("arg_comment_list_biu_btn", false))
      {
        paramViewGroup = paramLayoutInflater.findViewById(2131366985);
        paramViewGroup.setVisibility(0);
        paramViewGroup.setOnClickListener(this);
      }
      b();
      paramViewGroup = new Bundle();
      paramViewGroup.putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(paramViewGroup, new lmc(this), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter);
      paramViewGroup = getActivity().getSupportFragmentManager().beginTransaction();
      paramViewGroup.add(2131366988, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramViewGroup.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramViewGroup.commit();
      if (ThemeUtil.isInNightMode(getActivity().app))
      {
        paramViewGroup = new View(getActivity());
        paramViewGroup.setBackgroundColor(1996488704);
        getActivity().addContentView(paramViewGroup, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)paramLayoutInflater);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFragment(this, this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_a_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentUtils$FirstCommentEvent = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListAdapter = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */