package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.CommodityAdapter;
import com.tencent.biz.subscribe.bizdapters.MultiPicHeaderBlock;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import mqq.os.MqqHandler;

public class SubscribeMultiPicFragment
  extends SubscribeBaseFragment
{
  private BlockContainer h;
  private View i;
  private View j;
  private TextView k;
  private boolean l;
  private LinearLayout m;
  private long n;
  private MultiPicHeaderBlock o;
  private View p;
  
  private void l()
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("bundle_key_subscribe_feed_bytes_array", this.a.toByteArray());
    localBundle.putSerializable("bundle_key_feed_extra_type_info", this.b);
    this.o = new MultiPicHeaderBlock(localBundle);
    this.o.a(getBaseActivity().mSystemBarComp);
    if (this.g != null) {
      this.g.a(this.o);
    }
    this.h = ((BlockContainer)this.mContentView.findViewById(2131431491));
    this.m = ((LinearLayout)this.mContentView.findViewById(2131437470));
    this.i = this.mContentView.findViewById(2131436276);
    this.j = this.mContentView.findViewById(2131436572);
    this.k = ((TextView)this.mContentView.findViewById(2131436456));
    this.p = this.mContentView.findViewById(2131437017);
    this.h.setParentFragment(this);
    this.h.setLayoutManagerType(3, 2);
    this.h.setEnableLoadMore(true);
    this.h.setExtraTypeInfo(this.b);
    this.h.a(this.o);
    this.h.a(new CommodityAdapter(localBundle));
    this.h.a(new RelativeFeedsAdapter(localBundle));
    this.i.setOnClickListener(new SubscribeMultiPicFragment.1(this));
    this.h.e();
    this.j.setOnClickListener(new SubscribeMultiPicFragment.2(this));
  }
  
  private void m()
  {
    Object localObject = this.o;
    if ((localObject != null) && (((MultiPicHeaderBlock)localObject).k() != null) && (this.h.getExtraTypeInfo() != null))
    {
      localObject = this.o.k().poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("auth_");
      localStringBuilder.append(SubscribeShareHelper.a(this.h.getExtraTypeInfo()));
      VSReporter.a((String)localObject, localStringBuilder.toString(), "read", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.n), "", this.o.k().id.get() });
    }
  }
  
  protected View a()
  {
    return this.j;
  }
  
  public void a(long paramLong)
  {
    this.n = paramLong;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    MultiPicHeaderBlock localMultiPicHeaderBlock = this.o;
    if (localMultiPicHeaderBlock != null) {
      localMultiPicHeaderBlock.a(paramStFeed);
    }
  }
  
  protected void a(View paramView) {}
  
  public int[] a(int paramInt1, int paramInt2)
  {
    float f2 = paramInt2 / paramInt1;
    float f1 = 1.333333F;
    if (f2 <= 1.333333F) {
      f1 = f2;
    }
    paramInt1 = (int)(ImmersiveUtils.getScreenWidth() * f1);
    return new int[] { (int)(paramInt1 / f2), paramInt1 };
  }
  
  protected TextView b()
  {
    return this.k;
  }
  
  public void b(CertifiedAccountMeta.StFeed paramStFeed)
  {
    super.b(paramStFeed);
    ThreadManager.getSubThreadHandler().post(new SubscribeMultiPicFragment.3(this, paramStFeed));
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    hideTitleBar();
    l();
  }
  
  protected int getContentLayoutId()
  {
    return 2131624367;
  }
  
  public int h()
  {
    return ImmersiveUtils.dpToPx(50.0F);
  }
  
  public View i()
  {
    return this.p;
  }
  
  public boolean isWrapContent()
  {
    return this.l;
  }
  
  public View j()
  {
    return this.j;
  }
  
  public LinearLayout k()
  {
    return this.m;
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((BlockContainer)localObject).b())) {
      return true;
    }
    if ((this.b != null) && (this.b.sourceType == 9001))
    {
      localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(getBaseActivity(), (String)localObject, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.h;
    if (localObject != null) {
      ((BlockContainer)localObject).c();
    }
    TimeAndCountHelper.a().a("subscribe_freshman_interaction_guide");
    TimeAndCountHelper.a().a("subscribe_freshman_share_guide");
    localObject = this.o;
    if (localObject != null) {
      ((MultiPicHeaderBlock)localObject).n();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    m();
  }
  
  public void onResume()
  {
    super.onResume();
    this.n = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment
 * JD-Core Version:    0.7.0.1
 */