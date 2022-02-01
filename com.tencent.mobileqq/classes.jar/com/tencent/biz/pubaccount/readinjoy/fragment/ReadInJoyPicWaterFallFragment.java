package com.tencent.biz.pubaccount.readinjoy.fragment;

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
import bfpm;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ChannelClassificationListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.RecyclerViewWithHeaderFooterFix;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import odq;
import ojk;
import org.json.JSONException;
import org.json.JSONObject;
import oyy;
import oyz;
import ozb;
import ozd;
import pay;
import pgw;
import phd;
import pim;
import pnm;
import pnn;
import pno;
import pnp;
import pnq;
import pnr;
import pns;
import pnw;
import pnx;
import pod;
import poe;
import pog;
import rcn;
import rjl;
import tdo;
import uia;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<pnw>
  implements oyz
{
  public static final int c = Color.parseColor("#999999");
  public static final int e = Color.parseColor("#262626");
  public int a;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  public ReadInjoyXRecyclerView a;
  public ArrayList<pnw> a;
  public Map<Long, rcn> a;
  public Set<Long> a;
  public oyy a;
  protected pod a;
  public pog a;
  private tdo jdField_a_of_type_Tdo;
  public int b;
  private boolean b;
  private int f = 41522;
  
  public ReadInJoyPicWaterFallFragment()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131369115);
    Object localObject = (LinearLayout)paramView.findViewById(2131369117);
    localObject = (ImageView)paramView.findViewById(2131369116);
    paramView = (TextView)paramView.findViewById(2131369068);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new pnr(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.c) {
      bfpm.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = pay.d(paramArticleInfo);
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
      Object localObject2 = pay.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, NetworkUtil.isWifiConnected(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pay.f(paramArticleInfo), paramArticleInfo);
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
          odq.a(null, pay.d(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, phd.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
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
    return this.f;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<pnw> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131560200, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378734);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      rjl.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131365035);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new pnn(this, paramViewGroup.getContext());
    paramViewGroup = new pno(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, AIOUtils.dp2px(3.0F, getResources()), 0, AIOUtils.dp2px(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new pnx(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_Pog = new pog(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_Pog);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new pnp(this));
      this.jdField_b_of_type_Int = AIOUtils.dp2px(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new poe(this, this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Ojk);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_Tdo = new tdo(getActivity(), new pnq(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, AIOUtils.dp2px(3.0F, getResources()), 0, AIOUtils.dp2px(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
  }
  
  public pnm a()
  {
    if (this.jdField_a_of_type_Pod == null) {
      this.jdField_a_of_type_Pod = new pns(this);
    }
    return this.jdField_a_of_type_Pod;
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = getActivity().getIntent();
    this.f = localIntent.getIntExtra("channel_id", 41522);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = ((pnw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
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
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, pay.d(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      ozb.a((ozd)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (pnw)paramObject;
    ozb.a(getActivity(), "0X8009A70", a(), paramString.a.mChannelCoverId);
  }
  
  public void a(Map<Long, rcn> paramMap, boolean paramBoolean, Map<Long, uia> paramMap1, String paramString)
  {
    new pgw().a(paramMap, paramBoolean, paramMap1, paramString, getActivity(), a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Pog != null) {
      this.jdField_a_of_type_Pog.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Ojk != null) {
      this.jdField_a_of_type_Ojk.k();
    }
    if (this.jdField_a_of_type_Oyy != null)
    {
      this.jdField_a_of_type_Oyy.b();
      this.jdField_a_of_type_Oyy.a();
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
    this.jdField_a_of_type_Oyy = new oyy(this);
    pim.a.a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Pog != null) {
      this.jdField_a_of_type_Pog.notifyDataSetChanged();
    }
    if (f()) {
      rjl.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */