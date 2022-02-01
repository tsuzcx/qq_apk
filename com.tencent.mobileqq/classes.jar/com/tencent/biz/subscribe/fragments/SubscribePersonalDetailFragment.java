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
import com.tencent.biz.richframework.network.request.BaseRequest;
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
import com.tencent.mobileqq.app.BaseActivity;
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
    if (paramLoadInfo == null) {
      return;
    }
    if (paramLoadInfo.c())
    {
      a(true);
      return;
    }
    if (paramLoadInfo.d()) {
      a(false);
    }
  }
  
  private void a(String paramString)
  {
    RelativePersonalDetailHeadItemView localRelativePersonalDetailHeadItemView = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
    if (localRelativePersonalDetailHeadItemView != null)
    {
      localRelativePersonalDetailHeadItemView.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
      if (!VSNetworkHelper.isProtocolCache(paramString)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setCardReport(true);
      }
    }
    paramString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
    if (paramString != null)
    {
      if (paramString.user.type.get() == 1)
      {
        this.c.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = new SubscribePersonalDetailRequest(this.jdField_a_of_type_JavaLangString, null);
    SubscribePersonalDetailFragment.2 local2 = new SubscribePersonalDetailFragment.2(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1001");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    if ((PreLoader.exists(localStringBuilder.toString())) && (paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1001");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      PreLoader.addListener(((StringBuilder)localObject).toString(), new SubscribePersonalDetailFragment.3(this, local2));
      return;
    }
    ((SubscribePersonalDetailRequest)localObject).setEnableCache(paramBoolean);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, local2);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
    {
      localObject = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > paramInt))
      {
        paramInt = ((String)localObject).charAt(((String)localObject).length() - 1 - paramInt);
        break label67;
      }
    }
    paramInt = 48;
    label67:
    return paramInt == 49;
  }
  
  private void b()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167394));
      ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().d();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer.a().a(getResources().getString(2131701692));
    }
  }
  
  private boolean b()
  {
    return a(4);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView = new RelativePersonalDetailHeadItemView(getBaseActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setExtraTypeInfo(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setHostActivity(getBaseActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster);
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131376516));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131373245));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369500));
    this.c = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369420));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131370251));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369419));
    d();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369289).setOnClickListener(this);
    if (getBaseActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver = new SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getBaseActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver, localIntentFilter);
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
    boolean bool1 = b();
    boolean bool2 = false;
    Object localObject;
    if ((bool1) && (c()))
    {
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).vecFeed.get().size() > 0))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        VSReporter.a(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
        break label107;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    label107:
    if (this.jdField_a_of_type_ComTencentBizSubscribePartBlockBlockContainer != null)
    {
      localObject = new SubscribeBaseBottomPersonalFragment.BottomData();
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_Boolean = bool1;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_NS_COMMCOMM$StCommonExt = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_JavaLangString = "share_key_subscribe_opus";
      if ((isAdded()) && (getBaseActivity().app != null))
      {
        bool1 = bool2;
        if (SubscribeDraftManager.a().a(getBaseActivity().app.getAccount()))
        {
          bool1 = bool2;
          if (c()) {
            bool1 = true;
          }
        }
        ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_b_of_type_Boolean = bool1;
      }
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      SubscribePersonalBottomBlock localSubscribePersonalBottomBlock = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersSubscribePersonalBottomBlock;
      if (localSubscribePersonalBottomBlock != null) {
        localSubscribePersonalBottomBlock.b("share_key_subscribe_opus", new BlockMerger.ShareData(localObject));
      }
    }
  }
  
  protected View a()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject != null) && (((LinearLayout)localObject).getChildCount() > 0))
    {
      int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1;
      while (i >= 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (((View)localObject).getVisibility() == 0) {
          return localObject;
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
  
  protected int getContentLayoutId()
  {
    return 2131558752;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribePublishFeedsEvent.class);
    return localArrayList;
  }
  
  protected boolean isTransparent()
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
    int i = paramView.getId();
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    switch (i)
    {
    default: 
      break;
    case 2131373245: 
      if (!FastClickUtils.a("subscribe_publish_feed_button", 2000L))
      {
        if (Build.VERSION.SDK_INT >= 23) {
          bool1 = PermissionUtils.isStorePermissionEnable(getBaseActivity());
        } else {
          bool1 = true;
        }
        if (!bool1)
        {
          DialogUtil.a(getBaseActivity());
        }
        else
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("postUin", this.jdField_a_of_type_JavaLangString);
          CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
          if ((localStGetMainPageRsp != null) && (localStGetMainPageRsp.user.youZhan.size() > 0))
          {
            if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).type.get() > 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            ((Intent)localObject).putExtra("has_shop", bool1);
          }
          QZoneHelper.forwardToQQPublicAccountPublishPage(getBaseActivity(), (Intent)localObject, 0);
          localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
          if (localObject != null) {
            VSReporter.a(((CertifiedAccountMeta.StUser)((CertifiedAccountRead.StGetMainPageRsp)localObject).user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
          }
        }
      }
      break;
    case 2131369500: 
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      if (localObject != null)
      {
        SubscribeLaucher.a(((CertifiedAccountRead.StGetMainPageRsp)localObject).user.yzOrderPage.get());
        VSReporter.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      }
      break;
    case 2131369420: 
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
      {
        localObject = new ShareInfoBean();
        ((ShareInfoBean)localObject).jdField_a_of_type_Boolean = (c() ^ true);
        ((ShareInfoBean)localObject).jdField_a_of_type_Int = 1;
        bool1 = bool2;
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0)
        {
          bool1 = bool2;
          if (c()) {
            bool1 = true;
          }
        }
        ((ShareInfoBean)localObject).jdField_b_of_type_Boolean = bool1;
        a((ShareInfoBean)localObject);
      }
      break;
    case 2131369289: 
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getBaseActivity() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver != null)) {
      getBaseActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$SubscribePersonalBroadcastReceiver);
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
      String str = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("");
      VSReporter.a(str, "auth_person", "exp", 0, 0, new String[] { "", localStringBuilder.toString() });
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribePublishFeedsEvent))
    {
      paramSimpleBaseEvent = (SubscribePublishFeedsEvent)paramSimpleBaseEvent;
      if (paramSimpleBaseEvent.mState == 1)
      {
        paramSimpleBaseEvent = paramSimpleBaseEvent.mFeed;
        if (paramSimpleBaseEvent != null) {
          a().post(new SubscribePersonalDetailFragment.4(this, paramSimpleBaseEvent));
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */