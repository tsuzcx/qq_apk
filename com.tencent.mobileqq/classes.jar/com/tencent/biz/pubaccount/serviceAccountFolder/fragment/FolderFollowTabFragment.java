package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomLstItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.TabItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp.Bottom;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.network.SubscribeGetFollowFeedsRequest;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.PbProtocol;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FolderFollowTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.OnDragModeChangedListener
{
  public static int g = 1;
  public static String h = "FolderFollowTabFragment";
  public static String i = "";
  public TextView j;
  private Activity k;
  private BlockContainer l;
  private ServiceFolderFollowPBHeadView m;
  private final MqqHandler n = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private QQAppInterface o;
  private DragFrameLayout p;
  private boolean q;
  private ExtraTypeInfo r;
  private RelativeLiveFeedsAdapter s;
  private BlankRecommendFeedsAdapter t;
  private boolean u = true;
  private FolderFollowTabFragment.FollowTabBroadcastReceiver v;
  private ViewPager w;
  private LinearLayout x;
  private TextView y;
  private LinearLayout z;
  
  private void a(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    if (!TextUtils.isEmpty(this.o.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(this.o.getCurrentUin()).longValue());
    }
    if (!TextUtils.isEmpty(paramRelativeLiveFeedsAdapter.D().i())) {
      localGetSubscriptionReq.page_info.set("");
    }
    localGetSubscriptionReq.page_id.set(1);
    PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new FolderFollowTabFragment.5(this, paramRelativeLiveFeedsAdapter));
  }
  
  private void a(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter, List<CertifiedAccountRead.GetPortalRsp.RoomLstItem> paramList, CertifiedAccountRead.GetSubscriptionRsp.Bottom paramBottom, String paramString, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Object localObject = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(0)).room_lst.get();
      if ((localObject != null) && (((List)localObject).size() == 0))
      {
        localObject = ((CertifiedAccountRead.GetPortalRsp.RoomLstItem)paramList.get(0)).tab_info.name.get();
        this.m.a(true, (String)localObject);
      }
      else
      {
        this.m.a(false, null);
      }
      paramBoolean = paramRelativeLiveFeedsAdapter.a(paramBoolean, paramList);
      paramRelativeLiveFeedsAdapter.a(paramList, paramBottom, paramString);
    }
    else
    {
      paramRelativeLiveFeedsAdapter.b();
      this.m.a(true, null);
    }
    if ((paramBottom != null) && (paramBoolean))
    {
      a(paramBoolean, paramBottom.desc.get(), paramBottom.jump_url.get());
      return;
    }
    a(false, null, null);
  }
  
  private void a(String paramString)
  {
    ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.m;
    if (localServiceFolderFollowPBHeadView != null) {
      localServiceFolderFollowPBHeadView.setJumpWebMessageListUrl(paramString);
    }
  }
  
  private void a(List<ServiceAccountFolderFeed> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderFollowTabFragment.10(this, paramList));
  }
  
  private void a(boolean paramBoolean, Object paramObject, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (this.m == null) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
    {
      Object localObject1 = h;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isSuccess:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" setAddonRsp:");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject2 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
      paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).room_lst.get();
      localObject1 = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject2).bottom.get();
      localObject2 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).page_info.get();
      paramRelativeLiveFeedsAdapter.D().b((String)localObject2);
      TextView localTextView = this.j;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      a(paramRelativeLiveFeedsAdapter, paramObject, (CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1, (String)localObject2, false);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    LinearLayout localLinearLayout = this.x;
    if ((localLinearLayout != null) && (this.z != null))
    {
      TextView localTextView = this.y;
      if (localTextView == null) {
        return;
      }
      i = paramString2;
      if (paramBoolean)
      {
        localTextView.setText(paramString1);
        this.x.setVisibility(0);
        this.z.setVisibility(0);
        MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "tab_page", "bottom_button", 101, 1, System.currentTimeMillis(), "");
        return;
      }
      localLinearLayout.setVisibility(8);
      this.z.setVisibility(8);
    }
  }
  
  private void b(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    CertifiedAccountRead.GetSubscriptionReq localGetSubscriptionReq = new CertifiedAccountRead.GetSubscriptionReq();
    if (!TextUtils.isEmpty(this.o.getCurrentUin())) {
      localGetSubscriptionReq.uin.set(Long.valueOf(this.o.getCurrentUin()).longValue());
    }
    if (!TextUtils.isEmpty(paramRelativeLiveFeedsAdapter.D().i())) {
      localGetSubscriptionReq.page_info.set(paramRelativeLiveFeedsAdapter.D().i());
    }
    localGetSubscriptionReq.page_id.set(1);
    PbProtocol.a("QQLive.GetSubscriptionData", localGetSubscriptionReq, CertifiedAccountRead.GetSubscriptionRsp.class, new FolderFollowTabFragment.6(this, paramRelativeLiveFeedsAdapter));
  }
  
  private void b(boolean paramBoolean, Object paramObject, RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    if (this.m == null) {
      return;
    }
    if ((paramBoolean) && ((paramObject instanceof CertifiedAccountRead.GetSubscriptionRsp)))
    {
      Object localObject1 = h;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isSuccess:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" addFeedsData:");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject2 = (CertifiedAccountRead.GetSubscriptionRsp)paramObject;
      paramObject = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).room_lst.get();
      localObject1 = (CertifiedAccountRead.GetSubscriptionRsp.Bottom)((CertifiedAccountRead.GetSubscriptionRsp)localObject2).bottom.get();
      localObject2 = ((CertifiedAccountRead.GetSubscriptionRsp)localObject2).page_info.get();
      paramRelativeLiveFeedsAdapter.D().b((String)localObject2);
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramRelativeLiveFeedsAdapter.b(paramObject, (CertifiedAccountRead.GetSubscriptionRsp.Bottom)localObject1, (String)localObject2);
        return;
      }
      paramRelativeLiveFeedsAdapter.d(false);
    }
  }
  
  private boolean b(String paramString)
  {
    IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.o.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localIPublicAccountDataManager != null)
    {
      paramString = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(paramString);
      if ((paramString != null) && (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) == -10L)) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    ServiceAccountFolderManager localServiceAccountFolderManager = ServiceAccountFolderManager.a();
    List localList = localServiceAccountFolderManager.m();
    if ((localList != null) && (localList.size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localList;
      localMessage.what = 101;
      localMessage.arg1 = g;
      this.n.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderFollowTabFragment.1(this, localServiceAccountFolderManager));
    localServiceAccountFolderManager.a(this.o, NetConnInfoCenter.getServerTime());
    PublicTracker.a("SERVICE_FOLDER_COST", null);
  }
  
  private void c(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    paramRelativeLiveFeedsAdapter = new SubscribeGetFollowFeedsRequest(null);
    paramRelativeLiveFeedsAdapter.setEnableCache(true);
    this.u = true;
    VSNetworkHelper.getInstance().sendRequest(paramRelativeLiveFeedsAdapter, new FolderFollowTabFragment.7(this));
  }
  
  private void d()
  {
    this.p = DragFrameLayout.a(getBaseActivity());
    this.p.a(this, false);
    f();
    if (getBaseActivity() != null)
    {
      this.v = new FolderFollowTabFragment.FollowTabBroadcastReceiver(this, null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_refresh_return_page");
      getBaseActivity().registerReceiver(this.v, localIntentFilter);
    }
    this.j = ((TextView)this.b.findViewById(2131432602));
    e();
  }
  
  private void d(RelativeLiveFeedsAdapter paramRelativeLiveFeedsAdapter)
  {
    paramRelativeLiveFeedsAdapter = new SubscribeGetFollowFeedsRequest(paramRelativeLiveFeedsAdapter.D().g(), paramRelativeLiveFeedsAdapter.D().i());
    VSNetworkHelper.getInstance().sendRequest(paramRelativeLiveFeedsAdapter, new FolderFollowTabFragment.8(this));
  }
  
  private void e()
  {
    this.x = ((LinearLayout)this.b.findViewById(2131430114));
    this.y = ((TextView)this.b.findViewById(2131447061));
    this.z = ((LinearLayout)this.b.findViewById(2131430115));
    this.y.setText("发现更多精彩内容");
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, this.y.getPaint().getTextSize() * this.y.getText().length(), 0.0F, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP);
    this.y.getPaint().setShader(localLinearGradient);
    this.x.setOnClickListener(new FolderFollowTabFragment.2(this));
  }
  
  private void f()
  {
    this.l = ((BlockContainer)this.b.findViewById(2131445669));
    this.l.setParentFragment(this);
    this.l.setLayoutManagerType(3, 2);
    this.l.setEnableLoadMore(true);
    this.m = new ServiceFolderFollowPBHeadView(getBaseActivity());
    this.m.setDragHost(this.p);
    this.m.setmFolderViewPager(this.w);
    this.s = new RelativeLiveFeedsAdapter(null);
    this.s.b(this.q);
    this.s.a(false);
    this.s.a(new FolderFollowTabFragment.3(this));
    this.s.b(0);
    this.t = new BlankRecommendFeedsAdapter(null);
    this.t.a(this.q);
    this.l.a(new FolderFollowTabFragment.4(this, null));
    this.l.a(this.s);
    this.l.setExtraTypeInfo(this.r);
    this.l.setEnableRefresh(true);
    this.l.e();
  }
  
  protected void a()
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(getBaseActivity()).inflate(2131624391, null, false);
    }
    this.q = SubscribeUtils.a();
    this.o = getBaseActivity().app;
    Object localObject1 = this.o;
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).setHandler(FolderFollowTabFragment.class, this.n);
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject2 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ExtraTypeInfo();
      }
      this.r = new ExtraTypeInfo(7003, ((ExtraTypeInfo)localObject1).sourceType);
    }
    this.k = getBaseActivity();
    d();
    c();
    localObject1 = FolderBaseTabFragment.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initViewData:");
    ((StringBuilder)localObject2).append(b());
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
  }
  
  public void a(int paramInt)
  {
    ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.m;
    if (localServiceFolderFollowPBHeadView != null) {
      localServiceFolderFollowPBHeadView.a(paramInt);
    }
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.w = paramViewPager;
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == b())
    {
      paramServiceAccountFolderActivityNew.a(true);
      if (paramServiceAccountFolderActivityNew.b())
      {
        paramServiceAccountFolderActivityNew.a(8);
        c();
        paramServiceAccountFolderActivityNew = this.s;
        if (paramServiceAccountFolderActivityNew != null)
        {
          c(paramServiceAccountFolderActivityNew);
          a(this.s);
        }
      }
    }
  }
  
  public int b()
  {
    return d;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i1 = paramMessage.arg1;
      this.n.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderFollowTabFragment.9(this, i1));
      return true;
    }
    if (paramMessage.what == 101)
    {
      paramMessage = (List)paramMessage.obj;
      if (paramMessage.isEmpty())
      {
        paramMessage = this.m;
        if (paramMessage != null)
        {
          paramMessage.setTopBannerVisibility(false);
          return true;
        }
      }
      else
      {
        ServiceFolderFollowPBHeadView localServiceFolderFollowPBHeadView = this.m;
        if (localServiceFolderFollowPBHeadView != null)
        {
          localServiceFolderFollowPBHeadView.setTopBannerVisibility(true);
          this.m.setData(paramMessage);
        }
      }
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.p.getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131445666))
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)paramDragFrameLayout.getDragView().getTag(2131445660);
      paramInt = ((Integer)paramDragFrameLayout.getDragView().getTag(2131445658)).intValue();
      if (localServiceAccountFolderFeed != null)
      {
        long l1 = ServiceAccountFolderManager.a().a(localServiceAccountFolderFeed);
        Object localObject1 = this.o;
        if (localServiceAccountFolderFeed.a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localServiceAccountFolderFeed.d);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramInt + 1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l1);
        ReportController.b((AppRuntime)localObject1, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject2, (String)localObject3, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.o, localServiceAccountFolderFeed, true);
        VSReporter.a(localServiceAccountFolderFeed.b, "auth_page", "ignore", 0, 0, new String[0]);
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = h;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onChange->drag red dot:");
          ((StringBuilder)localObject1).append(localServiceAccountFolderFeed.b);
          QLog.d(paramDragFrameLayout, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(getBaseActivity()).inflate(2131624391, null, false);
    }
    this.q = SubscribeUtils.a();
    if (this.q) {
      this.b.setBackgroundColor(-16777216);
    } else {
      this.b.setBackgroundColor(-657670);
    }
    paramLayoutInflater = FolderBaseTabFragment.a;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView:");
    paramViewGroup.append(b());
    QLog.d(paramLayoutInflater, 4, paramViewGroup.toString());
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.m;
    if (localObject != null) {
      ((ServiceFolderFollowPBHeadView)localObject).a();
    }
    if ((getBaseActivity() != null) && (this.v != null)) {
      getBaseActivity().unregisterReceiver(this.v);
    }
    localObject = this.l;
    if (localObject != null) {
      ((BlockContainer)localObject).c();
    }
    localObject = this.o;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeHandler(FolderFollowTabFragment.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */