package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aala;
import aanb;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhdj;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import zos;
import zoz;
import zpo;
import zpr;
import zqm;
import zqn;
import zsf;
import ztm;
import zwv;
import zxo;
import zxp;
import zxq;
import zxr;
import zzf;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements View.OnClickListener, SimpleEventReceiver
{
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private String jdField_a_of_type_JavaLangString;
  private zpo jdField_a_of_type_Zpo;
  private ztm jdField_a_of_type_Ztm;
  private zxr jdField_a_of_type_Zxr;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
      if (!VSNetworkHelper.isProtocolCache(paramString)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setCardReport(true);
      }
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.type.get() == 1)
      {
        this.c.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.c.setVisibility(8);
    if (zqn.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(zoz paramzoz)
  {
    if (paramzoz == null) {}
    do
    {
      return;
      if (paramzoz.c())
      {
        a(true);
        return;
      }
    } while (!paramzoz.d());
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, null);
    zxp localzxp = new zxp(this);
    if ((zpr.a("1001" + this.jdField_a_of_type_JavaLangString)) && (paramBoolean))
    {
      zpr.a("1001" + this.jdField_a_of_type_JavaLangString, new zxq(this, localzxp));
      return;
    }
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, localzxp);
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
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167363));
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().c();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().a(getResources().getString(2131700977));
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
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setHostActivity(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376641));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373354));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369546));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369463));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131370331));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369462));
    d();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369324).setOnClickListener(this);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Zxr = new zxr(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Zxr, localIntentFilter);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_Zpo = new zxo(this, null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Zpo);
      this.jdField_a_of_type_Ztm = new ztm(null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Ztm);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    }
  }
  
  private void e()
  {
    boolean bool2 = true;
    zwv localzwv;
    if ((a()) && (b()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      aanb.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
      {
        localzwv = new zwv();
        localzwv.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label289;
        }
        bool1 = true;
        label137:
        localzwv.jdField_a_of_type_Boolean = bool1;
        localzwv.jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        localzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        localzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        localzwv.jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!zzf.a().a(getActivity().app.getAccount())) || (!b())) {
            break label294;
          }
        }
      }
    }
    label289:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localzwv.jdField_b_of_type_Boolean = bool1;
      localzwv.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      localzwv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Ztm != null) {
        this.jdField_a_of_type_Ztm.b("share_key_subscribe_opus", new zos(localzwv));
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      bool1 = false;
      break label137;
    }
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
    return this.jdField_a_of_type_AndroidWidgetTextView;
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
    QZoneHelper.prepareForQQPublicAccountPublishPage();
  }
  
  public int getContentLayoutId()
  {
    return 2131558814;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribePublishFeedsEvent.class);
    return localArrayList;
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
    default: 
    case 2131373354: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (aala.a("subscribe_publish_feed_button", 2000L));
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (boolean bool1 = PermissionUtils.isStorePermissionEnable(getActivity());; bool1 = true)
    {
      if (!bool1)
      {
        bhdj.a(getActivity());
        break;
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("postUin", this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() > 0)) {
        if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).type.get() <= 1) {
          break label248;
        }
      }
      label248:
      for (bool1 = true;; bool1 = false)
      {
        ((Intent)localObject).putExtra("has_shop", bool1);
        QZoneHelper.forwardToQQPublicAccountPublishPage(getActivity(), (Intent)localObject, 0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
          break;
        }
        aanb.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
        break;
      }
      onBackEvent();
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      zqm.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      aanb.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      localObject = new zsf();
      if (!b())
      {
        bool1 = true;
        label339:
        ((zsf)localObject).jdField_a_of_type_Boolean = bool1;
        ((zsf)localObject).jdField_a_of_type_Int = 1;
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!b())) {
          break label398;
        }
      }
      label398:
      for (bool1 = bool2;; bool1 = false)
      {
        ((zsf)localObject).jdField_b_of_type_Boolean = bool1;
        a((zsf)localObject);
        break;
        bool1 = false;
        break label339;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Zxr != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Zxr);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      aanb.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof SubscribePublishFeedsEvent)) && (((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mState == 1))
    {
      paramSimpleBaseEvent = ((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mFeed;
      if (paramSimpleBaseEvent != null) {
        a().post(new SubscribePersonalDetailFragment.4(this, paramSimpleBaseEvent));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */