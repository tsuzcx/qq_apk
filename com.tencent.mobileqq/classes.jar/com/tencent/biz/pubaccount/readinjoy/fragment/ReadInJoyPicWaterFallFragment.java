package com.tencent.biz.pubaccount.readinjoy.fragment;

import afur;
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
import bgfz;
import bgnt;
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
import java.util.Map<Ljava.lang.Long;Lrev;>;
import java.util.Set;
import oat;
import ogp;
import org.json.JSONException;
import org.json.JSONObject;
import pfb;
import pfc;
import pfe;
import pfg;
import pha;
import ppc;
import ppd;
import ppe;
import ppf;
import ppg;
import pph;
import ppi;
import ppm;
import ppn;
import ppt;
import ppu;
import ppw;
import rev;
import rlr;
import skb;
import skc;
import snh;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tiu;
import ube;
import ubj;

public class ReadInJoyPicWaterFallFragment
  extends ReadInJoyFragmentWithSubChannel<ppm>
  implements pfc
{
  public static final int c;
  public static final int e;
  public int a;
  private RecyclerView.ItemAnimator jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator;
  private View jdField_a_of_type_AndroidViewView;
  public ReadInjoyXRecyclerView a;
  public ArrayList<ppm> a;
  public Map<Long, rev> a;
  public Set<Long> a;
  public pfb a;
  protected ppt a;
  public ppw a;
  private tiu jdField_a_of_type_Tiu;
  public int b;
  private boolean b;
  private int f;
  
  static
  {
    jdField_c_of_type_Int = Color.parseColor("#999999");
    jdField_e_of_type_Int = Color.parseColor("#262626");
  }
  
  public ReadInJoyPicWaterFallFragment()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_f_of_type_Int = 41522;
  }
  
  private void a(View paramView)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131368994);
    Object localObject = (LinearLayout)paramView.findViewById(2131368996);
    localObject = (ImageView)paramView.findViewById(2131368995);
    paramView = (TextView)paramView.findViewById(2131368947);
    localTextView.setText(getActivity().getIntent().getStringExtra("sub_channel_name"));
    paramView.setOnClickListener(new pph(this));
    if (Build.VERSION.SDK_INT > 10) {
      paramView.setLayerType(0, null);
    }
    if (AppSetting.c) {
      bgfz.b(paramView, Button.class.getName());
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    localObject1 = pha.d(paramArticleInfo);
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
      Object localObject2 = pha.a(paramArticleInfo.mAlgorithmID, paramInt2, paramInt1, i, j, bgnt.h(null), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), paramArticleInfo);
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
          oat.a(null, pha.d(paramArticleInfo), "0X8007625", "0X8007625", 0, 0, snh.a(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.businessId), Integer.toString(paramArticleInfo.mStrategyId), ((JSONObject)localObject1).toString(), false);
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
    return this.jdField_f_of_type_Int;
  }
  
  protected View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle, ChannelClassificationListView<ppm> paramChannelClassificationListView)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131560181, null);
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378804);
    if (f())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      a(paramLayoutInflater);
      rlr.a(this);
    }
    paramBundle = (FrameLayout)paramLayoutInflater.findViewById(2131364961);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView = new ppd(this, paramViewGroup.getContext());
    paramViewGroup = new ppe(this, this.jdField_a_of_type_Int, 1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView != null)
    {
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setPadding(0, afur.a(3.0F, getResources()), 0, afur.a(3.0F, getResources()));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 17;
      paramChannelClassificationListView.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView, localLayoutParams);
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewChannelClassificationListView.setAdapter(new ppn(this, null));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setLayoutManager(paramViewGroup);
      this.jdField_a_of_type_Ppw = new ppw(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().setAdapter(this.jdField_a_of_type_Ppw);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addOnScrollListener(new ppf(this));
      this.jdField_b_of_type_Int = afur.a(3.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().addItemDecoration(new ppu(this, this.jdField_b_of_type_Int));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ItemAnimator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().getItemAnimator();
      b();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setBackgroundColor(Color.parseColor("#f7f7f7"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.setRefreshCallback(this.jdField_a_of_type_Ogp);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView, paramViewGroup);
      this.jdField_a_of_type_Tiu = new tiu(getActivity(), new ppg(this));
      return paramLayoutInflater;
      paramChannelClassificationListView = new ReadInJoyPicWaterFallFragment.ScrollableHeader(getActivity());
      paramChannelClassificationListView.setPadding(0, afur.a(3.0F, getResources()), 0, afur.a(3.0F, getResources()));
      paramChannelClassificationListView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
      paramChannelClassificationListView.setMinimumHeight(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyXRecyclerView.a().a(paramChannelClassificationListView);
    }
  }
  
  public ppc a()
  {
    if (this.jdField_a_of_type_Ppt == null) {
      this.jdField_a_of_type_Ppt = new ppi(this);
    }
    return this.jdField_a_of_type_Ppt;
  }
  
  protected void a()
  {
    super.a();
    Intent localIntent = getActivity().getIntent();
    this.jdField_f_of_type_Int = localIntent.getIntExtra("channel_id", 41522);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("is_sub_channel", false);
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = ((ppm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a;
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
        ThreadManager.post(new ReadInJoyPicWaterFallFragment.7(this, paramBaseArticleInfo, paramInt, pha.d(), System.currentTimeMillis()), 5, null, true);
      }
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (paramString.equals("exp_waterfall_operation")) {
      pfe.a((pfg)paramObject);
    }
    while (!paramString.equals("exp_subchannel")) {
      return;
    }
    paramString = (ppm)paramObject;
    pfe.a(getActivity(), "0X8009A70", a(), paramString.a.mChannelCoverId);
  }
  
  public void a(Map<Long, rev> paramMap, boolean paramBoolean, Map<Long, ubj> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyPicWaterFallFragment", 2, "report data is null ");
      return;
    }
    Iterator localIterator = paramMap.values().iterator();
    rev localrev;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrev = (rev)localIterator.next();
        if (!localrev.jdField_a_of_type_Boolean)
        {
          localrev.jdField_a_of_type_Boolean = true;
          if ((localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo != null))
          {
            i = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            localrev.jdField_c_of_type_Int = 1008;
            if (i == 5) {
              localrev.jdField_c_of_type_Int = 1009;
            }
          }
          oat.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, a(), localrev.jdField_d_of_type_Int), false);
          oat.a("0X80066FC", "", "", Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, a(), localrev.jdField_d_of_type_Int));
          paramMap = pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, a(), localrev.jdField_d_of_type_Int, localrev.jdField_e_of_type_Int, bgnt.h(getActivity()), localrev.jdField_a_of_type_JavaLangString, localrev.jdField_c_of_type_JavaLangString, localrev.jdField_e_of_type_JavaLangString, pha.f(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrev.jdField_f_of_type_Int, localrev.g, localrev.h, localrev.jdField_f_of_type_Boolean, localrev.j, localrev.i, localrev.m);
          if (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
          {
            try
            {
              localObject = new JSONObject(paramMap);
              ((JSONObject)localObject).put("feeds_type", localrev.jdField_c_of_type_Int);
              ((JSONObject)localObject).put("folder_status", paramString);
              localObject = ((JSONObject)localObject).toString();
              paramMap = (Map<Long, rev>)localObject;
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
            if (ube.a(a()))
            {
              localObject = "0X8009354";
              paramMap = new skc(paramMap);
              paramMap.a(localrev.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).f(localrev.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              oat.a(null, "CliOper", "", localrev.jdField_d_of_type_JavaLangString, (String)localObject, (String)localObject, 0, 0, Long.toString(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), paramMap.a().a(), false);
              oat.a((String)localObject, localrev.jdField_d_of_type_JavaLangString, Long.toString(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, a(), localrev.jdField_d_of_type_Int, localrev.jdField_e_of_type_Int, bgnt.h(getActivity()), localrev.jdField_a_of_type_JavaLangString, localrev.jdField_c_of_type_JavaLangString, localrev.jdField_e_of_type_JavaLangString, pha.f(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, 0L, -1, localrev.jdField_f_of_type_Int, localrev.g, localrev.h, localrev.jdField_f_of_type_Boolean, localrev.j, localrev.i, localrev.m));
              if ((localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo == null)) {
                continue;
              }
              j = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
              i = 8;
              if (j == 5) {
                i = 12;
              }
              l3 = localrev.jdField_b_of_type_Long;
              j = localrev.k;
              l1 = 0L;
              paramMap = null;
              localObject = null;
              if (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label910;
              }
              l1 = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              paramMap = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
            }
          }
        }
      }
    }
    label910:
    for (long l2 = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str2 = pfe.a(getActivity(), pha.a(), 16, l1, l3, j, paramMap, (String)localObject, i, a());
      oat.a(null, localrev.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str2, false);
      pfe.a(7, pha.a(), (int)l2, 16, l3, j, paramMap, (String)localObject);
      break;
      String str1;
      ube.a(paramMap1);
      return;
    }
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Ppw != null) {
      this.jdField_a_of_type_Ppw.notifyDataSetChanged();
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
    if (this.jdField_a_of_type_Ogp != null) {
      this.jdField_a_of_type_Ogp.k();
    }
    if (this.jdField_a_of_type_Pfb != null)
    {
      this.jdField_a_of_type_Pfb.b();
      this.jdField_a_of_type_Pfb.a();
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
    this.jdField_a_of_type_Pfb = new pfb(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ppw != null) {
      this.jdField_a_of_type_Ppw.notifyDataSetChanged();
    }
    if (f()) {
      rlr.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyPicWaterFallFragment
 * JD-Core Version:    0.7.0.1
 */