package com.tencent.biz.pubaccount.readinjoy.fragment;

import aciy;
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
import azve;
import badq;
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
import java.util.Map<Ljava.lang.Long;Lpov;>;
import java.util.Set;
import ndn;
import nii;
import nzs;
import nzt;
import nzv;
import nzx;
import obz;
import ojc;
import ojd;
import oje;
import ojf;
import ojg;
import ojh;
import oji;
import ojm;
import ojn;
import ojt;
import oju;
import ojw;
import org.json.JSONException;
import org.json.JSONObject;
import pov;
import put;
import qmu;
import qmv;
import qoe;
import rhd;
import rvf;
import rvk;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<ojm>
  implements nzt
{
  public static final int c;
  public int a;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  public ReadInjoyXRecyclerView a;
  public ArrayList<ojm> a;
  public Map<Long, pov> a;
  public Set<Long> a;
  public nzs a;
  protected ojt a;
  public ojw a;
  private rhd jdField_a_of_type_Rhd;
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
    TextView localTextView = (TextView)paramView.findViewById(2131302847);
    Object localObject = (LinearLayout)paramView.findViewById(2131302849);
    localObject = (ImageView)paramView.findViewById(2131302848);
    paramView = (TextView)paramView.findViewById(2131302804);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new ojh(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.c) {
      azve.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = obz.c(paramArticleInfo);
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
      Object localObject2 = obz.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, badq.h(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), paramArticleInfo);
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
          ndn.a(null, obz.c(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, qoe.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
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
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ojm> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131494368, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131311559);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      put.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131299097);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new ojd(this, paramViewGroup.getContext());
    paramViewGroup = new oje(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, aciy.a(3.0F, getResources()), 0, aciy.a(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new ojn(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_Ojw = new ojw(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ojw);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new ojf(this));
      this.jdField_b_of_type_Int = aciy.a(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new oju(this, this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Nii);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_Rhd = new rhd(getActivity(), new ojg(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, aciy.a(3.0F, getResources()), 0, aciy.a(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
  }
  
  public ojc a()
  {
    if (this.jdField_a_of_type_Ojt == null) {
      this.jdField_a_of_type_Ojt = new oji(this);
    }
    return this.jdField_a_of_type_Ojt;
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
    paramView = ((ojm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
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
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, obz.d(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      nzv.a((nzx)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (ojm)paramObject;
    nzv.a(getActivity(), "0X8009A70", a(), paramString.a.mChannelCoverId);
  }
  
  public void a(Map<Long, pov> paramMap, boolean paramBoolean, Map<Long, rvk> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyPicWaterFallFragment", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    pov localpov;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localpov = (pov)localIterator.next();
        if (!localpov.jdField_a_of_type_Boolean)
        {
          localpov.jdField_a_of_type_Boolean = true;
          if ((localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localpov.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localpov.jdField_c_of_type_Int = 1009;
            }
          }
          ndn.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, a(), localpov.jdField_d_of_type_Int), false);
          ndn.a("0X80066FC", "", "", Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, a(), localpov.jdField_d_of_type_Int));
          paramMap = obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, a(), localpov.jdField_d_of_type_Int, localpov.jdField_e_of_type_Int, badq.h(getActivity()), localpov.jdField_a_of_type_JavaLangString, localpov.jdField_c_of_type_JavaLangString, localpov.jdField_e_of_type_JavaLangString, obz.e(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localpov.jdField_f_of_type_Int, localpov.g, localpov.h, localpov.jdField_f_of_type_Boolean, localpov.j, localpov.i, localpov.m);
          if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localpov.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, pov>)localObject;
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
            if (rvf.a(a()))
            {
              localObject = "0X8009354";
              paramMap = new qmv(paramMap);
              paramMap.a(localpov.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localpov.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              ndn.a(null, "CliOper", "", localpov.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), paramMap.a().a(), false);
              ndn.a((String)localObject, localpov.jdField_d_of_type_JavaLangString, Long.toString(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localpov.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localpov.jdField_b_of_type_Int), obz.a(localpov.jdField_a_of_type_Long, localpov.jdField_c_of_type_Int, a(), localpov.jdField_d_of_type_Int, localpov.jdField_e_of_type_Int, badq.h(getActivity()), localpov.jdField_a_of_type_JavaLangString, localpov.jdField_c_of_type_JavaLangString, localpov.jdField_e_of_type_JavaLangString, obz.e(localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localpov.jdField_f_of_type_Int, localpov.g, localpov.h, localpov.jdField_f_of_type_Boolean, localpov.j, localpov.i, localpov.m));
              if ((localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localpov.jdField_b_of_type_Long;
              j = localpov.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label910;
              }
              l1 = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label910:
    for (long l2 = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = nzv.a(getActivity(), obz.a(), 16, l1, l3, j, paramMap, (String)localObject, i, a());
      ndn.a(null, localpov.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      nzv.a(7, obz.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      rvf.a(paramMap1);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Ojw != null) {
      this.jdField_a_of_type_Ojw.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Nii != null) {
      this.jdField_a_of_type_Nii.k();
    }
    if (this.jdField_a_of_type_Nzs != null)
    {
      this.jdField_a_of_type_Nzs.b();
      this.jdField_a_of_type_Nzs.a();
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
    this.jdField_a_of_type_Nzs = new nzs(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ojw != null) {
      this.jdField_a_of_type_Ojw.notifyDataSetChanged();
    }
    if (f()) {
      put.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */