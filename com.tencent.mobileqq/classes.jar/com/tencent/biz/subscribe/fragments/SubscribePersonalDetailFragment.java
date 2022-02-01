package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
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
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.biz.subscribe.bizdapters.SubscribePersonalBottomBlock;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.BlockMerger.ShareData;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.part.extendsblock.SingleViewBlock;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.biz.videostory.FastClickUtils;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements View.OnClickListener, SimpleEventReceiver
{
  private long jdField_a_of_type_Long;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SubscribePersonalBottomBlock jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock;
  private SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver;
  private BlockContainer jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer;
  private SingleViewBlock jdField_a_of_type_ComTencentBizSubscribePartExtendsblockSingleViewBlock;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ImageView c;
  
  private void a(LoadInfo paramLoadInfo)
  {
    if (paramLoadInfo == null) {}
    do
    {
      return;
      if (paramLoadInfo.c())
      {
        a(true);
        return;
      }
    } while (!paramLoadInfo.d());
    a(false);
  }
  
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
    if (SubscribeUtils.d(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
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
    SubscribePersonalDetailFragment.2 local2 = new SubscribePersonalDetailFragment.2(this);
    if ((PreLoader.exists("1001" + this.jdField_a_of_type_JavaLangString)) && (paramBoolean))
    {
      PreLoader.addListener("1001" + this.jdField_a_of_type_JavaLangString, new SubscribePersonalDetailFragment.3(this, local2));
      return;
    }
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.getInstance().sendRequest(localSubscribePersonalDetailRequest, local2);
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
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167374));
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().d();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().a(getResources().getString(2131701552));
    }
  }
  
  private boolean b()
  {
    return a(4);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView = new RelativePersonalDetailHeadItemView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setHostActivity(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131377036));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373672));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369813));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369722));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131370600));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369721));
    d();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369579).setOnClickListener(this);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver = new SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver, localIntentFilter);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private boolean c()
  {
    return a(1);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockSingleViewBlock = new SubscribePersonalDetailFragment.1(this, null);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribePartExtendsblockSingleViewBlock);
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock = new SubscribePersonalBottomBlock(null);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.c();
    }
  }
  
  private void e()
  {
    boolean bool2 = true;
    SubscribeBaseBottomPersonalFragment.BottomData localBottomData;
    if ((b()) && (c()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      VSReporter.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null)
      {
        localBottomData = new SubscribeBaseBottomPersonalFragment.BottomData();
        localBottomData.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label289;
        }
        bool1 = true;
        label137:
        localBottomData.jdField_a_of_type_Boolean = bool1;
        localBottomData.jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        localBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        localBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        localBottomData.jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!SubscribeDraftManager.a().a(getActivity().app.getAccount())) || (!c())) {
            break label294;
          }
        }
      }
    }
    label289:
    label294:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localBottomData.jdField_b_of_type_Boolean = bool1;
      localBottomData.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      localBottomData.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock.b("share_key_subscribe_opus", new BlockMerger.ShareData(localBottomData));
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
    return 2131558854;
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
    case 2131373672: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (FastClickUtils.a("subscribe_publish_feed_button", 2000L));
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (boolean bool1 = PermissionUtils.isStorePermissionEnable(getActivity());; bool1 = true)
    {
      if (!bool1)
      {
        DialogUtil.a(getActivity());
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
        VSReporter.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
        break;
      }
      onBackEvent();
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      SubscribeLaucher.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      localObject = new ShareInfoBean();
      if (!c())
      {
        bool1 = true;
        label339:
        ((ShareInfoBean)localObject).jdField_a_of_type_Boolean = bool1;
        ((ShareInfoBean)localObject).jdField_a_of_type_Int = 1;
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!c())) {
          break label398;
        }
      }
      label398:
      for (bool1 = bool2;; bool1 = false)
      {
        ((ShareInfoBean)localObject).jdField_b_of_type_Boolean = bool1;
        a((ShareInfoBean)localObject);
        break;
        bool1 = false;
        break label339;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver);
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
      VSReporter.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */