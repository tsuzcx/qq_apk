package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aaak;
import aaam;
import aabn;
import aabu;
import aacq;
import aadg;
import aaej;
import aaek;
import aagc;
import aahj;
import aaks;
import aall;
import aalm;
import aaln;
import aalo;
import aanf;
import aazb;
import abbe;
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
import apdr;
import bhlq;
import bmtd;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements aaam, View.OnClickListener
{
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private aacq jdField_a_of_type_Aacq;
  private aahj jdField_a_of_type_Aahj;
  private aalo jdField_a_of_type_Aalo;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  private void a(aabu paramaabu)
  {
    if (paramaabu == null) {}
    do
    {
      return;
      if (paramaabu.c())
      {
        a(true);
        return;
      }
    } while (!paramaabu.d());
    a(false);
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
    if (aaek.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      abbe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, null);
    aalm localaalm = new aalm(this);
    if ((aadg.a("1001" + this.jdField_a_of_type_JavaLangString)) && (paramBoolean))
    {
      aadg.a("1001" + this.jdField_a_of_type_JavaLangString, new aaln(this, localaalm));
      return;
    }
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, localaalm);
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
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167302));
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().d();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().d(getResources().getString(2131700391));
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
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376621));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373177));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369383));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369280));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131370166));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369279));
    d();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369134).setOnClickListener(this);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Aalo = new aalo(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Aalo, localIntentFilter);
    }
    aaak.a().a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_Aacq = new aall(this, null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aacq);
      this.jdField_a_of_type_Aahj = new aahj(null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Aahj);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.c();
    }
  }
  
  private void e()
  {
    boolean bool2 = true;
    aaks localaaks;
    if ((a()) && (b()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      abbe.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
      {
        localaaks = new aaks();
        localaaks.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label289;
        }
        bool1 = true;
        label137:
        localaaks.jdField_a_of_type_Boolean = bool1;
        localaaks.jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        localaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        localaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        localaaks.jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!aanf.a().a(getActivity().app.getAccount())) || (!b())) {
            break label294;
          }
        }
      }
    }
    label289:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localaaks.jdField_b_of_type_Boolean = bool1;
      localaaks.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      localaaks.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Aahj != null) {
        this.jdField_a_of_type_Aahj.setShareData("share_key_subscribe_opus", new aabn(localaaks));
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
    bmtd.a();
  }
  
  public int getContentLayoutId()
  {
    return 2131558781;
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
    case 2131373177: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (aazb.a("subscribe_publish_feed_button", 2000L));
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (boolean bool1 = apdr.a(getActivity());; bool1 = true)
    {
      if (!bool1)
      {
        bhlq.b(getActivity());
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
        bmtd.a(getActivity(), (Intent)localObject, 0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
          break;
        }
        abbe.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
        break;
      }
      onBackEvent();
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      aaej.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      abbe.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      localObject = new aagc();
      if (!b())
      {
        bool1 = true;
        label339:
        ((aagc)localObject).jdField_a_of_type_Boolean = bool1;
        ((aagc)localObject).jdField_a_of_type_Int = 1;
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!b())) {
          break label398;
        }
      }
      label398:
      for (bool1 = bool2;; bool1 = false)
      {
        ((aagc)localObject).jdField_b_of_type_Boolean = bool1;
        a((aagc)localObject);
        break;
        bool1 = false;
        break label339;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Aalo != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Aalo);
    }
    aaak.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      abbe.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
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