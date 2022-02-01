package com.tencent.mobileqq.activity.contact.addcontact.publicaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class PublicView
  extends ContactBaseView
  implements View.OnClickListener, OverScrollViewListener
{
  private XListView a;
  private TextView b;
  private ProgressBar c;
  private ArrayList<PublicRecommendAccountInfo> d = new ArrayList();
  private PublicView.PublicAccountAdapter e;
  private PullRefreshHeader f;
  private PublicView.UiHandler g = new PublicView.UiHandler(this);
  private long h = 0L;
  private boolean i = false;
  private IPublicAccountObserver j;
  
  public PublicView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.F).isResume()) {
      QQToast.makeText(this.F, paramInt1, getResources().getString(paramInt2), 0).show(((BaseActivity)this.F).getTitleBarHeight());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      paramString2 = new Intent();
      paramString2.putExtra("source", paramInt3);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(paramString2, paramQQAppInterface, paramContext, paramString1, -7);
      return;
    }
    paramString1 = new Intent();
    paramString1.putExtra("uinname", paramString3);
    paramString1.putExtra("source", paramInt3);
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).gotoProfile(paramString1, paramQQAppInterface, paramContext, paramString2, paramInt2);
  }
  
  private void a(SosoLbsInfo paramSosoLbsInfo)
  {
    ((IPublicAccountHandler)this.G.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getRecommendList(paramSosoLbsInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.d;
      if (localObject != null) {
        ((ArrayList)localObject).size();
      }
      this.d = ((ArrayList)((IPublicAccountDataManager)this.G.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicRecommendAccountList());
    }
    Object localObject = this.d;
    if ((localObject != null) && ((localObject == null) || (((ArrayList)localObject).size() != 0)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.h;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PublicView onCreate used(milliseconds):");
        ((StringBuilder)localObject).append(l1 - l2);
        QLog.i("PublicView", 2, ((StringBuilder)localObject).toString());
      }
      g();
    }
    else
    {
      f();
    }
    if (this.e == null) {
      this.e = new PublicView.PublicAccountAdapter(this, this.F, this.G, this.a);
    }
    this.e.notifyDataSetChanged();
  }
  
  private void e()
  {
    this.c = ((ProgressBar)findViewById(2131444560));
    this.a = ((XListView)findViewById(2131440840));
    this.a.setContentBackground(2130838958);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.F);
    View localView = localLayoutInflater.inflate(2131627240, this.a, false);
    this.b = ((TextView)localView.findViewById(2131427818));
    this.b.setPadding(getResources().getDimensionPixelSize(2131298975), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130852492);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.b.setCompoundDrawables(localDrawable, null, null, null);
    this.b.setFocusable(false);
    this.b.setCursorVisible(false);
    this.b.setOnClickListener(this);
    this.a.addHeaderView(localView, null, false);
    this.f = ((PullRefreshHeader)localLayoutInflater.inflate(2131625671, this.a, false));
    this.a.setOverScrollHeader(this.f);
    this.a.setOverScrollListener(this);
  }
  
  private void f()
  {
    this.c.setVisibility(0);
  }
  
  private void g()
  {
    this.c.setVisibility(8);
  }
  
  private void getCurrentLocation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): BEGIN");
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicView.2(this, 1, true, true, 0L, false, false, "PublicView"));
    this.i = false;
    this.g.sendEmptyMessageDelayed(4, 3000L);
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): END");
    }
  }
  
  private void j()
  {
    if (!this.i) {
      a(null);
    }
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.F.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        AppActivity localAppActivity = (AppActivity)this.F;
        localAppActivity.requestPermissions(new PublicView.3(this, localAppActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      getCurrentLocation();
      return;
    }
    getCurrentLocation();
  }
  
  private boolean l()
  {
    if (NetworkUtil.isNetworkAvailable(this.F))
    {
      k();
      return true;
    }
    a(1, 2131892104);
    return false;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      this.h = System.currentTimeMillis();
    }
    this.j = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.j.setOnCallback(new PublicView.1(this));
    super.a();
    setContentView(2131627239);
    e();
    ((BaseActivity)this.F).addObserver(this.j.getBusinessObserver());
    a(true);
    k();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void d()
  {
    ((BaseActivity)this.F).removeObserver(this.j.getBusinessObserver());
    PublicView.PublicAccountAdapter localPublicAccountAdapter = this.e;
    if (localPublicAccountAdapter != null) {
      localPublicAccountAdapter.c();
    }
    super.d();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("PublicView", 1, "User requestPermissions denied, use default lbs info ...");
    j();
  }
  
  public int getHeightToTabBar()
  {
    return getResources().getDimensionPixelSize(2131298867);
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("PublicView", 1, "User requestPermissions grant...");
    getCurrentLocation();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131427818)
    {
      if (k == 2131442132)
      {
        PublicView.ViewHolder localViewHolder = (PublicView.ViewHolder)paramView.getTag();
        a(this.G, this.F, localViewHolder.c.mSource, localViewHolder.c.mEqqNameAccount, String.valueOf(localViewHolder.c.mPublicuin), localViewHolder.c.accountflag, localViewHolder.c.mPublicname, 3);
      }
    }
    else
    {
      this.E.c();
      SearchUtils.a("add_page", "search", "active_frame", 3, 0, new String[] { "" });
      ReportController.b(this.G, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 3, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.f.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.f.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.f.a(0L);
    if (!l()) {
      this.g.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView
 * JD-Core Version:    0.7.0.1
 */