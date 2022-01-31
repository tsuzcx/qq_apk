package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import ammv;
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
import bdcd;
import bizm;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.component.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
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
import java.util.ArrayList;
import java.util.List;
import xxk;
import xxl;
import xzf;
import yam;
import ydw;
import yeb;
import yei;
import yej;
import yel;
import yem;
import yff;
import yfg;
import yfh;
import yfi;
import yfo;
import yho;
import ytg;
import yvu;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements View.OnClickListener, yel
{
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ComponentPageView jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private String jdField_a_of_type_JavaLangString;
  private yam jdField_a_of_type_Yam;
  private yei jdField_a_of_type_Yei;
  private yfi jdField_a_of_type_Yfi;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
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
    if (xxl.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      yvu.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(yeb paramyeb)
  {
    if (paramyeb == null) {}
    do
    {
      return;
      if (paramyeb.c())
      {
        a(true);
        return;
      }
    } while (!paramyeb.d());
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, null);
    yfg localyfg = new yfg(this);
    if ((yfo.a("1001" + this.jdField_a_of_type_JavaLangString)) && (paramBoolean))
    {
      yfo.a("1001" + this.jdField_a_of_type_JavaLangString, new yfh(this, localyfg));
      return;
    }
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, localyfg);
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
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167192));
      ImmersiveUtils.a(true, getActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().e();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().a(getResources().getString(2131701852));
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
    this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView = ((ComponentPageView)this.mContentView.findViewById(2131375710));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131372444));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131368901));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131368823));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369627));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131368822));
    d();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131368697).setOnClickListener(this);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_Yfi = new yfi(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_Yfi, localIntentFilter);
    }
    yej.a().a(this);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)
    {
      this.jdField_a_of_type_Yei = new yff(this, null);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yei);
      this.jdField_a_of_type_Yam = new yam(null);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a(this.jdField_a_of_type_Yam);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.a().setEnableNestScrollingParent(true);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView.e();
    }
  }
  
  private void e()
  {
    boolean bool2 = true;
    yem localyem;
    if ((a()) && (b()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      yvu.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizSubscribeComponentBaseComponentPageView != null)
      {
        localyem = new yem();
        localyem.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label289;
        }
        bool1 = true;
        label137:
        localyem.jdField_a_of_type_Boolean = bool1;
        localyem.jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        localyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        localyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        localyem.jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!yho.a().a(getActivity().app.getAccount())) || (!b())) {
            break label294;
          }
        }
      }
    }
    label289:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localyem.jdField_b_of_type_Boolean = bool1;
      localyem.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      localyem.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_Yam != null) {
        this.jdField_a_of_type_Yam.b("share_key_subscribe_opus", new ydw(localyem));
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
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribePublishFeedsEvent.class);
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
    bizm.a();
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof SubscribePublishFeedsEvent)) && (((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mState == 1))
    {
      paramSimpleBaseEvent = ((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mFeed;
      if (paramSimpleBaseEvent != null) {
        a().post(new SubscribePersonalDetailFragment.4(this, paramSimpleBaseEvent));
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558718;
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
    case 2131372444: 
      do
      {
        return;
      } while (ytg.a("subscribe_publish_feed_button", 2000L));
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (boolean bool1 = ammv.a(getActivity());; bool1 = true)
    {
      if (!bool1)
      {
        bdcd.b(getActivity());
        return;
      }
      paramView = new Intent();
      paramView.putExtra("postUin", this.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() > 0)) {
        if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).type.get() <= 1) {
          break label233;
        }
      }
      label233:
      for (bool1 = true;; bool1 = false)
      {
        paramView.putExtra("has_shop", bool1);
        bizm.a(getActivity(), paramView, 0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
          break;
        }
        yvu.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
        return;
      }
      onBackEvent();
      return;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      xxk.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      yvu.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      return;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      paramView = new xzf();
      if (!b())
      {
        bool1 = true;
        paramView.jdField_a_of_type_Boolean = bool1;
        paramView.jdField_a_of_type_Int = 1;
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!b())) {
          break label372;
        }
      }
      label372:
      for (bool1 = bool2;; bool1 = false)
      {
        paramView.jdField_b_of_type_Boolean = bool1;
        a(paramView);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_Yfi != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_Yfi);
    }
    yej.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      yvu.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */