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
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  private PublicView.PublicAccountAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter;
  private PublicView.UiHandler jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$UiHandler = new PublicView.UiHandler(this);
  private PublicAccountObserver jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver = new PublicView.2(this);
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
    ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)).a(paramSosoLbsInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
      this.jdField_a_of_type_JavaUtilArrayList = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).d();
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))) {
      f();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter = new PublicView.PublicAccountAdapter(this, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter.notifyDataSetChanged();
      return;
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.i("PublicView", 2, "PublicView onCreate used(milliseconds):" + (l1 - l2));
      }
      i();
    }
  }
  
  private boolean a()
  {
    if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      l();
      return true;
    }
    a(1, 2131694459);
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376854));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131373658));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838979);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
    View localView = localLayoutInflater.inflate(2131561035, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362212));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(getResources().getDimensionPixelSize(2131298279), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130850762);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131559765, this.jdField_a_of_type_ComTencentWidgetXListView, false));
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
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PublicView.1(this, 1, true, true, 0L, false, false, "PublicView"));
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
    return getResources().getDimensionPixelSize(2131298179);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    super.a();
    setContentView(2131561034);
    e();
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    a(true);
    l();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void d()
  {
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppPublicAccountObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactPublicaccountPublicView$PublicAccountAdapter.c();
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
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
      SearchUtils.a("add_page", "search", "active_frame", 3, 0, new String[] { "" });
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 3, 0, "", "", "", "");
      continue;
      PublicView.ViewHolder localViewHolder = (PublicView.ViewHolder)paramView.getTag();
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localViewHolder.a.mSource, localViewHolder.a.mEqqNameAccount, String.valueOf(localViewHolder.a.mPublicuin), localViewHolder.a.accountflag, localViewHolder.a.mPublicname, 3);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView
 * JD-Core Version:    0.7.0.1
 */