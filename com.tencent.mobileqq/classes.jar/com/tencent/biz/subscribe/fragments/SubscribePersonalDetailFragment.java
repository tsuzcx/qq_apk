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
  private RelativePersonalDetailHeadItemView h;
  private CertifiedAccountRead.StGetMainPageRsp i;
  private String j;
  private SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private TextView o;
  private LinearLayout p;
  private long q;
  private long r;
  private SubscribePersonalBottomBlock s;
  private SingleViewBlock t;
  private BlockContainer u;
  
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
    RelativePersonalDetailHeadItemView localRelativePersonalDetailHeadItemView = this.h;
    if (localRelativePersonalDetailHeadItemView != null)
    {
      localRelativePersonalDetailHeadItemView.a(this.i);
      if (!VSNetworkHelper.isProtocolCache(paramString)) {
        this.h.setCardReport(true);
      }
    }
    paramString = this.i;
    if (paramString != null)
    {
      if (paramString.user.type.get() == 1)
      {
        this.n.setVisibility(0);
        this.m.setVisibility(8);
        return;
      }
      this.n.setVisibility(8);
      if (SubscribeUtils.d(this.i.user.attr.get()))
      {
        this.m.setVisibility(0);
        VSReporter.b(this.i.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
        return;
      }
      this.m.setVisibility(8);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.a != null) && (this.a.poster != null)) {
      this.j = this.a.poster.id.get();
    }
    this.q = System.currentTimeMillis();
    Object localObject = new SubscribePersonalDetailRequest(this.j, null);
    SubscribePersonalDetailFragment.2 local2 = new SubscribePersonalDetailFragment.2(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1001");
    localStringBuilder.append(this.j);
    if ((PreLoader.exists(localStringBuilder.toString())) && (paramBoolean))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("1001");
      ((StringBuilder)localObject).append(this.j);
      PreLoader.addListener(((StringBuilder)localObject).toString(), new SubscribePersonalDetailFragment.3(this, local2));
      return;
    }
    ((SubscribePersonalDetailRequest)localObject).setEnableCache(paramBoolean);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, local2);
  }
  
  private boolean a(int paramInt)
  {
    Object localObject = this.i;
    if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).user != null))
    {
      localObject = Long.toBinaryString(this.i.user.attr.get());
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
  
  private void b(boolean paramBoolean)
  {
    this.u.getStatusView().c();
    if ((!paramBoolean) && (isAdded())) {
      this.u.getStatusView().a(getResources().getString(2131899714));
    }
  }
  
  private void i()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131168464));
      ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
    }
  }
  
  private void j()
  {
    this.h = new RelativePersonalDetailHeadItemView(getBaseActivity());
    this.h.setExtraTypeInfo(this.b);
    this.h.setHostActivity(getBaseActivity());
    this.h.setPostUserData(this.a.poster);
    this.u = ((BlockContainer)this.mContentView.findViewById(2131444760));
    this.l = ((ImageView)this.mContentView.findViewById(2131440854));
    this.l.setOnClickListener(this);
    this.m = ((ImageView)this.h.findViewById(2131436579));
    this.n = ((ImageView)this.h.findViewById(2131436457));
    this.p = ((LinearLayout)this.h.findViewById(2131437448));
    this.o = ((TextView)this.h.findViewById(2131436456));
    k();
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.h.findViewById(2131436275).setOnClickListener(this);
    if (getBaseActivity() != null)
    {
      this.k = new SubscribePersonalDetailFragment.SubscribePersonalBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getBaseActivity().registerReceiver(this.k, localIntentFilter);
    }
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void k()
  {
    if (this.u != null)
    {
      this.t = new SubscribePersonalDetailFragment.1(this, null);
      this.u.a(this.t);
      this.s = new SubscribePersonalBottomBlock(null);
      this.u.a(this.s);
      this.u.setEnableRefresh(true);
      this.u.setEnableLoadMore(false);
      this.u.setExtraTypeInfo(this.b);
      this.u.e();
    }
  }
  
  private void l()
  {
    boolean bool1 = m();
    boolean bool2 = false;
    Object localObject;
    if ((bool1) && (n()))
    {
      localObject = this.i;
      if ((localObject != null) && (((CertifiedAccountRead.StGetMainPageRsp)localObject).vecFeed.get().size() > 0))
      {
        this.l.setVisibility(0);
        VSReporter.a(((CertifiedAccountMeta.StUser)this.i.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
        break label107;
      }
    }
    this.l.setVisibility(8);
    label107:
    if (this.u != null)
    {
      localObject = new SubscribeBaseBottomPersonalFragment.BottomData();
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).d = a(this.i);
      if (this.i.isFinish.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).b = bool1;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).c = this.i.extInfo;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).e = this.a;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).f = ((CertifiedAccountMeta.StUser)this.i.user.get());
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).a = "share_key_subscribe_opus";
      if ((isAdded()) && (getBaseActivity().app != null))
      {
        bool1 = bool2;
        if (SubscribeDraftManager.a().a(getBaseActivity().app.getAccount()))
        {
          bool1 = bool2;
          if (n()) {
            bool1 = true;
          }
        }
        ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).g = bool1;
      }
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).h = this.i;
      ((SubscribeBaseBottomPersonalFragment.BottomData)localObject).i = this.j;
      SubscribePersonalBottomBlock localSubscribePersonalBottomBlock = this.s;
      if (localSubscribePersonalBottomBlock != null) {
        localSubscribePersonalBottomBlock.b("share_key_subscribe_opus", new BlockMerger.ShareData(localObject));
      }
    }
  }
  
  private boolean m()
  {
    return a(4);
  }
  
  private boolean n()
  {
    return a(1);
  }
  
  protected View a()
  {
    Object localObject = this.p;
    if ((localObject != null) && (((LinearLayout)localObject).getChildCount() > 0))
    {
      int i1 = this.p.getChildCount() - 1;
      while (i1 >= 0)
      {
        localObject = this.p.getChildAt(i1);
        if (((View)localObject).getVisibility() == 0) {
          return localObject;
        }
        i1 -= 1;
      }
    }
    return null;
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
    if (this.a != null) {
      this.a.status.set(2);
    }
    i();
    hideTitleBar();
    j();
    QZoneHelper.prepareForQQPublicAccountPublishPage();
  }
  
  protected TextView b()
  {
    return this.o;
  }
  
  protected int getContentLayoutId()
  {
    return 2131624372;
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
    int i1 = paramView.getId();
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    switch (i1)
    {
    default: 
      break;
    case 2131440854: 
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
          ((Intent)localObject).putExtra("postUin", this.j);
          CertifiedAccountRead.StGetMainPageRsp localStGetMainPageRsp = this.i;
          if ((localStGetMainPageRsp != null) && (localStGetMainPageRsp.user.youZhan.size() > 0))
          {
            if (((CertifiedAccountMeta.StYouZanShop)this.i.user.youZhan.get(0)).type.get() > 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            ((Intent)localObject).putExtra("has_shop", bool1);
          }
          QZoneHelper.forwardToQQPublicAccountPublishPage(getBaseActivity(), (Intent)localObject, 0);
          localObject = this.i;
          if (localObject != null) {
            VSReporter.a(((CertifiedAccountMeta.StUser)((CertifiedAccountRead.StGetMainPageRsp)localObject).user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
          }
        }
      }
      break;
    case 2131436579: 
      localObject = this.i;
      if (localObject != null)
      {
        SubscribeLaucher.a(((CertifiedAccountRead.StGetMainPageRsp)localObject).user.yzOrderPage.get());
        VSReporter.b(this.i.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      }
      break;
    case 2131436457: 
      if (this.i != null)
      {
        localObject = new ShareInfoBean();
        ((ShareInfoBean)localObject).f = (n() ^ true);
        ((ShareInfoBean)localObject).a = 1;
        bool1 = bool2;
        if (this.i.vecFeed.get().size() > 0)
        {
          bool1 = bool2;
          if (n()) {
            bool1 = true;
          }
        }
        ((ShareInfoBean)localObject).g = bool1;
        a((ShareInfoBean)localObject);
      }
      break;
    case 2131436275: 
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getBaseActivity() != null) && (this.k != null)) {
      getBaseActivity().unregisterReceiver(this.k);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.a != null) && (this.a.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.r;
      String str = this.a.poster.id.get();
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
          g().post(new SubscribePersonalDetailFragment.4(this, paramSimpleBaseEvent));
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.r = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */