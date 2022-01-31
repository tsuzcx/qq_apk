package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bfpr;
import bfrj;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.SubscribePersonalDetailRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import urk;
import vvy;
import vvz;
import vxn;
import vyn;
import wbv;
import wca;
import wci;
import wcj;
import wcl;
import wcm;
import wde;
import wdf;
import wdg;
import wei;
import wpl;
import wye;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements View.OnClickListener, wcl
{
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FollowedRecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private String jdField_a_of_type_JavaLangString;
  private vyn jdField_a_of_type_Vyn;
  private wci jdField_a_of_type_Wci;
  private wdg jdField_a_of_type_Wdg;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView c;
  private ImageView d;
  
  private void a(PublishBoxStatusEvent paramPublishBoxStatusEvent)
  {
    a().post(new SubscribePersonalDetailFragment.4(this, paramPublishBoxStatusEvent));
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
      if (!VSNetworkHelper.a(paramString)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setCardReport(true);
      }
    }
    if (b()) {
      if (b() != null) {
        b().setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
      {
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.type.get() != 1) {
          break;
        }
        this.d.setVisibility(0);
        this.c.setVisibility(8);
      }
      return;
      if (b() != null) {
        b().setVisibility(0);
      }
    }
    this.d.setVisibility(8);
    if (vvz.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.c.setVisibility(0);
      wye.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
      return;
    }
    this.c.setVisibility(8);
  }
  
  private void a(wca paramwca)
  {
    if (paramwca == null) {}
    do
    {
      return;
      if (paramwca.c())
      {
        a(true);
        return;
      }
    } while (!paramwca.d());
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, null);
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, new wdf(this));
  }
  
  private boolean a()
  {
    return a(4);
  }
  
  private boolean a(int paramInt)
  {
    int j = 48;
    int i = j;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      i = j;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null)
      {
        String str = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          i = j;
          if (str.length() > paramInt) {
            i = str.charAt(str.length() - 1 - paramInt);
          }
        }
      }
    }
    return i == 49;
  }
  
  private void b()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131101537));
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().d();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().a(getResources().getString(2131635684));
    }
  }
  
  private boolean b()
  {
    return a(1);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView = new RelativePersonalDetailHeadItemView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131309478));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131306429));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131312853));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131303085));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131303056));
    this.d = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131302990));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131303712));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131302989));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView = ((FollowedRecommendBannerView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131309178));
    d();
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131302883).setOnClickListener(this);
    wcj.a().a(this);
    bfrj.a().a();
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Wdg = new wdg(this, null);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Wdg, (IntentFilter)localObject);
    }
    Object localObject = vvz.a() + File.separator + a() + ".png";
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().b((String)localObject);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)
    {
      this.jdField_a_of_type_Wci = new wde(this, null);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Wci);
      this.jdField_a_of_type_Vyn = new vyn(null);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Vyn);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setEnableNestScrollingParent(true);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.d();
    }
  }
  
  private void e()
  {
    boolean bool2 = true;
    wcm localwcm;
    if ((a()) && (b()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      wye.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)
      {
        localwcm = new wcm();
        localwcm.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label289;
        }
        bool1 = true;
        label137:
        localwcm.jdField_a_of_type_Boolean = bool1;
        localwcm.jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        localwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        localwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        localwcm.jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!wei.a().a(getActivity().app.getAccount())) || (!b())) {
            break label294;
          }
        }
      }
    }
    label289:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localwcm.jdField_b_of_type_Boolean = bool1;
      localwcm.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      localwcm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Vyn != null) {
        this.jdField_a_of_type_Vyn.b("share_key_subscribe_opus", new wbv(localwcm));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      bool1 = false;
      break label137;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)getActivity().getResources().getDrawable(2130847473));
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_b_of_type_AndroidWidgetImageView.getVisibility() == 8)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130848978);
  }
  
  protected View a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0))
    {
      int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localView.getVisibility() == 0) {
          return localView;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  protected TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  protected List<CertifiedAccountMeta.StFeed> a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return ((CertifiedAccountRead.StGetMainPageRsp)paramObject).vecFeed.get();
  }
  
  protected void a(View paramView)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.set(2);
    }
    b();
    hideTitleBar();
    c();
    bfpr.a();
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null) && (TextUtils.equals(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), ((FollowUpdateEvent)paramSimpleBaseEvent).useId)))
    {
      j = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.get();
      if ((((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 1) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 0))
      {
        i = j + 1;
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerFollowedRecommendBannerView.a(((FollowUpdateEvent)paramSimpleBaseEvent).useId);
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.fansCount.set(i);
        this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
        j = ((FollowUpdateEvent)paramSimpleBaseEvent).followStatus;
        a().post(new SubscribePersonalDetailFragment.3(this, i));
        urk.c("SubscribePersonalDetail", "onReceiveEvent  id:" + ((FollowUpdateEvent)paramSimpleBaseEvent).useId + " , status:" + ((FollowUpdateEvent)paramSimpleBaseEvent).followStatus + " " + toString());
      }
    }
    while (!(paramSimpleBaseEvent instanceof PublishBoxStatusEvent)) {
      for (;;)
      {
        int j;
        return;
        int i = j;
        if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus == 0)
        {
          i = j;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.followState.get() == 1)
          {
            i = j;
            if (j > 0) {
              i = j - 1;
            }
          }
        }
      }
    }
    a((PublishBoxStatusEvent)paramSimpleBaseEvent);
  }
  
  protected TextView b()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView != null) {
      return (TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131312354);
    }
    return null;
  }
  
  public int getContentLayoutId()
  {
    return 2131493131;
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    switch (paramView.getId())
    {
    }
    label204:
    do
    {
      do
      {
        do
        {
          return;
        } while (wpl.a("subscribe_publish_feed_button", 2000L));
        paramView = new Intent();
        paramView.putExtra("postUin", this.jdField_a_of_type_JavaLangString);
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() > 0)) {
          if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).type.get() <= 1) {
            break label204;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          paramView.putExtra("has_shop", bool1);
          bfpr.a(getActivity(), paramView, 0);
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
            break;
          }
          wye.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
          return;
        }
        onBackEvent();
        return;
      } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null);
      vvy.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      wye.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      return;
    } while (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null);
    paramView = new vxn();
    if (!b())
    {
      bool1 = true;
      paramView.jdField_a_of_type_Boolean = bool1;
      paramView.jdField_a_of_type_Int = 1;
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!b())) {
        break label343;
      }
    }
    label343:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.jdField_b_of_type_Boolean = bool1;
      a(paramView);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    wcj.a().b(this);
    if ((getActivity() != null) && (this.jdField_a_of_type_Wdg != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Wdg);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      wye.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */