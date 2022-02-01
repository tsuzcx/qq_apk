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
  private long jdField_a_of_type_Long = 0L;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
  private PublicView.PublicAccountAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter;
  private PublicView.UiHandler jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$UiHandler = new PublicView.UiHandler(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<PublicRecommendAccountInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  
  public PublicView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
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
    ((IPublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).getRecommendList(paramSosoLbsInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null) {
        ((ArrayList)localObject).size();
      }
      this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicRecommendAccountList());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && ((localObject == null) || (((ArrayList)localObject).size() != 0)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PublicView onCreate used(milliseconds):");
        ((StringBuilder)localObject).append(l1 - l2);
        QLog.i("PublicView", 2, ((StringBuilder)localObject).toString());
      }
      i();
    }
    else
    {
      f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter = new PublicView.PublicAccountAdapter(this, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter.notifyDataSetChanged();
  }
  
  private boolean a()
  {
    if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      l();
      return true;
    }
    a(1, 2131694424);
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376345));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131373231));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838739);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
    View localView = localLayoutInflater.inflate(2131560899, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362237));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(getResources().getDimensionPixelSize(2131298274), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130850688);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559642, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): BEGIN");
    }
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicView.2(this, 1, true, true, 0L, false, false, "PublicView"));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$UiHandler.sendEmptyMessageDelayed(4, 3000L);
    if (QLog.isColorLevel()) {
      QLog.d("PublicView", 2, "getCurrentLocation(): END");
    }
  }
  
  private void k()
  {
    if (!this.jdField_a_of_type_Boolean) {
      a(null);
    }
  }
  
  private void l()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        AppActivity localAppActivity = (AppActivity)this.jdField_a_of_type_AndroidAppActivity;
        localAppActivity.requestPermissions(new PublicView.3(this, localAppActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      j();
      return;
    }
    j();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298174);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = ((IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(new PublicView.1(this));
    super.a();
    setContentView(2131560898);
    e();
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    a(true);
    l();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void d()
  {
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    PublicView.PublicAccountAdapter localPublicAccountAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter;
    if (localPublicAccountAdapter != null) {
      localPublicAccountAdapter.c();
    }
    super.d();
  }
  
  @QQPermissionDenied(1)
  public void denied()
  {
    QLog.d("PublicView", 1, "User requestPermissions denied, use default lbs info ...");
    k();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("PublicView", 1, "User requestPermissions grant...");
    j();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362237)
    {
      if (i == 2131374038)
      {
        PublicView.ViewHolder localViewHolder = (PublicView.ViewHolder)paramView.getTag();
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localViewHolder.a.mSource, localViewHolder.a.mEqqNameAccount, String.valueOf(localViewHolder.a.mPublicuin), localViewHolder.a.accountflag, localViewHolder.a.mPublicname, 3);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      SearchUtils.a("add_page", "search", "active_frame", 3, 0, new String[] { "" });
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 3, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$UiHandler.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView
 * JD-Core Version:    0.7.0.1
 */