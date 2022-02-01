package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter;
import com.tencent.biz.subscribe.part.block.BlockContainer;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import common.config.service.QzoneConfig;
import cooperation.ilive.util.IlivePreloadHelper;
import cooperation.vip.tianshu.TianShuManager;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class FolderRecommendTabFragment
  extends FolderBaseTabFragment
  implements Handler.Callback, DragFrameLayout.OnDragModeChangedListener
{
  public static View i;
  public static LinearLayout j;
  public static TextView k;
  public static LinearLayout l;
  public static String m = "";
  private static DragFrameLayout v;
  protected ExtraTypeInfo g;
  protected String h;
  private BlockContainer n;
  private int o = QzoneConfig.getInstance().getConfig("qqsubscribe", "RecommendBannerCheckDisplayInterval", 3);
  private boolean p;
  private boolean q;
  private FolderRecommendTabFragment.RecommendHeaderBlock r;
  private RelativeLiveFeedsAdapter s;
  private final MqqHandler t = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private QQAppInterface u;
  private TianShuGetAdvCallback w = new FolderRecommendTabFragment.1(this);
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l1 = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l1);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.c = paramInt2;
    localTianShuReportData.f = paramString1;
    localTianShuReportData.g = paramString2;
    localTianShuReportData.h = paramString3;
    localTianShuReportData.p = paramInt1;
    localTianShuReportData.q = 1;
    localTianShuReportData.o = l1;
    TianShuManager.getInstance().report(localTianShuReportData);
  }
  
  private void a(List<ServiceAccountFolderFeed> paramList)
  {
    ThreadManager.getSubThreadHandler().post(new FolderRecommendTabFragment.5(this, paramList));
  }
  
  private boolean a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      this.u = ((QQAppInterface)localObject);
    }
    localObject = this.u;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (IPublicAccountDataManager)((QQAppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool1 = bool2;
    if (localObject != null)
    {
      paramString = (PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfo(paramString);
      bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType2(paramString.accountFlag2) == -10L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void f()
  {
    j = (LinearLayout)this.b.findViewById(2131430114);
    k = (TextView)this.b.findViewById(2131447061);
    l = (LinearLayout)this.b.findViewById(2131430115);
    k.setText("发现更多精彩内容");
    LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, k.getPaint().getTextSize() * k.getText().length(), 0.0F, Color.parseColor("#FFC235"), Color.parseColor("#FF00CE"), Shader.TileMode.CLAMP);
    k.getPaint().setShader(localLinearGradient);
    j.setOnClickListener(new FolderRecommendTabFragment.3(this));
  }
  
  private boolean g()
  {
    long l1 = c();
    return System.currentTimeMillis() / 1000L - l1 > this.o * 24 * 60 * 60;
  }
  
  private void h()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      this.u = ((QQAppInterface)localObject1);
    }
    localObject1 = ServiceAccountFolderManager.a();
    Object localObject2 = ((ServiceAccountFolderManager)localObject1).m();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      Message localMessage = Message.obtain();
      localMessage.obj = localObject2;
      localMessage.what = 101;
      localMessage.arg1 = FolderFollowTabFragment.g;
      this.t.sendMessage(localMessage);
    }
    ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.6(this, (ServiceAccountFolderManager)localObject1));
    if (localObject1 != null)
    {
      localObject2 = this.u;
      if (localObject2 != null)
      {
        ((ServiceAccountFolderManager)localObject1).a((QQAppInterface)localObject2, NetConnInfoCenter.getServerTime());
        PublicTracker.a("SERVICE_FOLDER_COST", null);
      }
    }
  }
  
  protected void a()
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(getBaseActivity()).inflate(2131624361, null);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      this.u = ((QQAppInterface)localObject1);
    }
    localObject1 = this.u;
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).setHandler(FolderRecommendTabFragment.class, this.t);
    }
    v = DragFrameLayout.a(getBaseActivity());
    v.a(this, false);
    this.h = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    this.p = SubscribeUtils.a();
    if ((getBaseActivity() != null) && (getBaseActivity().getIntent() != null))
    {
      localObject2 = (ExtraTypeInfo)getBaseActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ExtraTypeInfo();
      }
      this.g = new ExtraTypeInfo(7004, ((ExtraTypeInfo)localObject1).sourceType);
    }
    b();
    localObject1 = FolderBaseTabFragment.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initViewData:");
    ((StringBuilder)localObject2).append(d());
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    ThreadManager.postDownLoadTask(new FolderRecommendTabFragment.2(this), 5, null, true);
  }
  
  public void a(ServiceAccountFolderActivityNew paramServiceAccountFolderActivityNew, int paramInt)
  {
    if (paramInt == d())
    {
      paramServiceAccountFolderActivityNew.a(false);
      if (paramServiceAccountFolderActivityNew.b()) {
        h();
      }
      if ((g()) && (!this.q))
      {
        this.q = true;
        VSReporter.a("auth_discover", "reco_exp", 0, 0, new String[0]);
      }
    }
  }
  
  protected void b()
  {
    this.n = ((BlockContainer)this.b.findViewById(2131444760));
    this.n.setParentFragment(this);
    this.n.setLayoutManagerType(3, 2);
    this.n.setEnableLoadMore(true);
    this.r = new FolderRecommendTabFragment.RecommendHeaderBlock(this, null);
    this.n.a(this.r);
    this.s = new RelativeLiveFeedsAdapter(null);
    this.s.c(0);
    this.s.b(this.p);
    this.s.a(false);
    this.s.b(1);
    this.n.a(this.s);
    this.n.setExtraTypeInfo(this.g);
    this.n.setEnableRefresh(true);
    this.n.e();
    i = this.b.findViewById(2131432602);
    h();
    f();
  }
  
  public long c()
  {
    try
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("subscribe_recommend_banner_unlike_timestamp_");
      localStringBuilder.append(this.h);
      long l1 = Long.valueOf(SharePreferenceUtils.a(localBaseApplication, localStringBuilder.toString())).longValue();
      return l1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label50:
      break label50;
    }
    return 0L;
  }
  
  public int d()
  {
    return e;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      int i1 = paramMessage.arg1;
      this.t.removeMessages(100);
      ThreadManager.executeOnSubThread(new FolderRecommendTabFragment.4(this, i1));
      return true;
    }
    if (paramMessage.what == 101)
    {
      paramMessage = (List)paramMessage.obj;
      if (paramMessage.isEmpty())
      {
        paramMessage = this.r;
        if ((paramMessage != null) && (paramMessage.a != null))
        {
          this.r.a.setTopBannerVisibility(false);
          return true;
        }
      }
      else
      {
        FolderRecommendTabFragment.RecommendHeaderBlock localRecommendHeaderBlock = this.r;
        if ((localRecommendHeaderBlock != null) && (localRecommendHeaderBlock.a != null))
        {
          this.r.a.setTopBannerVisibility(true);
          this.r.a.setAdapterData(paramMessage);
        }
      }
    }
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    Object localObject1 = v;
    if ((localObject1 != null) && (((DragFrameLayout)localObject1).getMode() == -1) && (paramDragFrameLayout.getDragView() != null) && (paramDragFrameLayout.getDragView().getId() == 2131445666))
    {
      localObject1 = (ServiceAccountFolderFeed)paramDragFrameLayout.getDragView().getTag(2131445660);
      paramInt = ((Integer)paramDragFrameLayout.getDragView().getTag(2131445658)).intValue();
      if (localObject1 != null)
      {
        long l1 = ServiceAccountFolderManager.a().a((ServiceAccountFolderFeed)localObject1);
        QQAppInterface localQQAppInterface = this.u;
        if (((ServiceAccountFolderFeed)localObject1).a()) {
          paramDragFrameLayout = "0";
        } else {
          paramDragFrameLayout = "1";
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((ServiceAccountFolderFeed)localObject1).d);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramInt + 1);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l1);
        ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, (String)localObject2, (String)localObject3, localStringBuilder.toString());
        ServiceAccountFolderManager.a().b(this.u, (ServiceAccountFolderFeed)localObject1, true);
        VSReporter.a(((ServiceAccountFolderFeed)localObject1).b, "auth_page", "ignore", 0, 0, new String[0]);
        if (QLog.isColorLevel())
        {
          paramDragFrameLayout = new StringBuilder();
          paramDragFrameLayout.append("onChange->drag red dot:");
          paramDragFrameLayout.append(((ServiceAccountFolderFeed)localObject1).b);
          QLog.d("FolderRecommendTabFragment", 2, paramDragFrameLayout.toString());
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.b == null) {
      this.b = LayoutInflater.from(getBaseActivity()).inflate(2131624361, null);
    }
    this.p = SubscribeUtils.a();
    if (this.p) {
      this.b.setBackgroundColor(-16777216);
    } else {
      this.b.setBackgroundColor(-657670);
    }
    paramLayoutInflater = FolderBaseTabFragment.a;
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView:");
    paramViewGroup.append(d());
    QLog.d(paramLayoutInflater, 4, paramViewGroup.toString());
    IlivePreloadHelper.a(getBaseActivity(), 2);
    paramLayoutInflater = this.b;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.n;
    if (localObject != null)
    {
      ((BlockContainer)localObject).c();
      this.n = null;
    }
    localObject = this.r;
    if ((localObject != null) && (((FolderRecommendTabFragment.RecommendHeaderBlock)localObject).a != null))
    {
      this.r.a.a();
      this.r.a = null;
      this.r = null;
    }
    localObject = v;
    if (localObject != null)
    {
      ((DragFrameLayout)localObject).a(this);
      v = null;
    }
    if (i != null) {
      i = null;
    }
    if (j != null) {
      j = null;
    }
    if (k != null) {
      k = null;
    }
    if (l != null) {
      l = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    DragFrameLayout localDragFrameLayout = v;
    if (localDragFrameLayout != null) {
      localDragFrameLayout.a();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((getBaseActivity() instanceof ServiceAccountFolderActivityNew)) {
      ((ServiceAccountFolderActivityNew)getBaseActivity()).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */