package com.tencent.biz.pubaccount.readinjoy.fragment;

import aekt;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bcvq;
import bdee;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map<Ljava.lang.Long;Lqkk;>;
import java.util.Set;
import nrt;
import nwu;
import opk;
import opl;
import opn;
import opp;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import ozp;
import ozq;
import ozr;
import ozs;
import ozt;
import ozu;
import ozv;
import ozz;
import paa;
import pag;
import pah;
import paj;
import qkk;
import qqu;
import rom;
import ron;
import rqj;
import skd;
import szp;
import szu;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<ozz>
  implements opl
{
  public static final int c;
  public int a;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  public ReadInjoyXRecyclerView a;
  public ArrayList<ozz> a;
  public Map<Long, qkk> a;
  public Set<Long> a;
  public opk a;
  protected pag a;
  public paj a;
  private skd jdField_a_of_type_Skd;
  public int b;
  private boolean b;
  public final int e;
  final int f;
  private int g = 41522;
  
  static
  {
    jdField_c_of_type_Int = Color.parseColor("#999999");
  }
  
  public ReadInJoyPicWaterFallFragment()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_e_of_type_Int = Color.parseColor("#262626");
    this.jdField_f_of_type_Int = -1;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131368659);
    Object localObject = (LinearLayout)paramView.findViewById(2131368661);
    localObject = (ImageView)paramView.findViewById(2131368660);
    paramView = (TextView)paramView.findViewById(2131368613);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new ozu(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.c) {
      bcvq.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = ors.d(paramArticleInfo);
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label152;
      }
    }
    label152:
    for (int j = 0;; j = 1)
    {
      Object localObject2 = ors.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, bdee.h(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), paramArticleInfo);
      localObject1 = new JSONObject();
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localObject2 = new JSONObject((String)localObject2);
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          continue;
          Object localObject3;
          continue;
        }
        try
        {
          ((JSONObject)localObject2).put("feeds_type", paramInt2);
          localObject1 = localObject2;
          nrt.a(null, ors.d(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, rqj.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
          return;
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localJSONException1;
          localObject3 = localJSONException2;
        }
      }
      i = 0;
      break;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(0L);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setAddDuration(120L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setChangeDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setMoveDuration(250L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator.setRemoveDuration(120L);
  }
  
  public int a()
  {
    return this.g;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ozz> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131560036, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131377910);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      qqu.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131364735);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new ozq(this, paramViewGroup.getContext());
    paramViewGroup = new ozr(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, aekt.a(3.0F, getResources()), 0, aekt.a(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new paa(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_Paj = new paj(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_Paj);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new ozs(this));
      this.jdField_b_of_type_Int = aekt.a(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new pah(this, this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Nwu);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_Skd = new skd(getActivity(), new ozt(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, aekt.a(3.0F, getResources()), 0, aekt.a(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
  }
  
  public ozp a()
  {
    if (this.jdField_a_of_type_Pag == null) {
      this.jdField_a_of_type_Pag = new ozv(this);
    }
    return this.jdField_a_of_type_Pag;
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = getActivity().getIntent();
    this.g = localIntent.getIntExtra("channel_id", 41522);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = ((ozz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
    if (TextUtils.isEmpty(paramView.mChannelJumpUrl))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtra("channel_id", paramView.mChannelCoverId);
      localIntent.putExtra("sub_channel_name", paramView.mChannelCoverName);
      localIntent.putExtra("is_sub_channel", true);
      PublicFragmentActivity.a(getActivity(), localIntent, ReadInJoyPicWaterFallFragment.class);
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    if ((paramBaseArticleInfo != null) && (this.jdField_a_of_type_JavaUtilMap != null)) {
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID))) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, ors.d(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      opn.a((opp)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (ozz)paramObject;
    opn.a(getActivity(), "0X8009A70", a(), paramString.a.mChannelCoverId);
  }
  
  public void a(Map<Long, qkk> paramMap, boolean paramBoolean, Map<Long, szu> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyPicWaterFallFragment", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    qkk localqkk;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localqkk = (qkk)localIterator.next();
        if (!localqkk.jdField_a_of_type_Boolean)
        {
          localqkk.jdField_a_of_type_Boolean = true;
          if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localqkk.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localqkk.jdField_c_of_type_Int = 1009;
            }
          }
          nrt.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, a(), localqkk.jdField_d_of_type_Int), false);
          nrt.a("0X80066FC", "", "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, a(), localqkk.jdField_d_of_type_Int));
          paramMap = ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, a(), localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdee.h(getActivity()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqkk.jdField_f_of_type_Int, localqkk.g, localqkk.h, localqkk.jdField_f_of_type_Boolean, localqkk.j, localqkk.i, localqkk.m);
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localqkk.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, qkk>)localObject;
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                Object localObject;
                int j;
                long l3;
                long l1;
                localJSONException.printStackTrace();
                continue;
                str1 = "0X8007626";
              }
            }
            if (szp.a(a()))
            {
              localObject = "0X8009354";
              paramMap = new ron(paramMap);
              paramMap.a(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), paramMap.a().a(), false);
              nrt.a((String)localObject, localqkk.jdField_d_of_type_JavaLangString, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, a(), localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdee.h(getActivity()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localqkk.jdField_f_of_type_Int, localqkk.g, localqkk.h, localqkk.jdField_f_of_type_Boolean, localqkk.j, localqkk.i, localqkk.m));
              if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localqkk.jdField_b_of_type_Long;
              j = localqkk.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label910;
              }
              l1 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label910:
    for (long l2 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = opn.a(getActivity(), ors.a(), 16, l1, l3, j, paramMap, (String)localObject, i, a());
      nrt.a(null, localqkk.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      opn.a(7, ors.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      szp.a(paramMap1);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Paj != null) {
      this.jdField_a_of_type_Paj.notifyDataSetChanged();
    }
  }
  
  protected boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean g()
  {
    return getActivity() instanceof SplashActivity;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nwu != null) {
      this.jdField_a_of_type_Nwu.k();
    }
    if (this.jdField_a_of_type_Opk != null)
    {
      this.jdField_a_of_type_Opk.b();
      this.jdField_a_of_type_Opk.a();
    }
  }
  
  public boolean onBackEvent()
  {
    j();
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Opk = new opk(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Paj != null) {
      this.jdField_a_of_type_Paj.notifyDataSetChanged();
    }
    if (f()) {
      qqu.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */