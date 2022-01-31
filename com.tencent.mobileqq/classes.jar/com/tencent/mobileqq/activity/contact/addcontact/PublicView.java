package com.tencent.mobileqq.activity.contact.addcontact;

import aeuo;
import aeuu;
import aeuv;
import aeuw;
import aeux;
import aeuy;
import aeuz;
import ajoy;
import ajpe;
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
import avwf;
import awqx;
import badq;
import bbmy;
import belq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import mqq.app.AppActivity;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;
import rtr;

public class PublicView
  extends ContactBaseView
  implements View.OnClickListener, belq
{
  private long jdField_a_of_type_Long;
  private aeux jdField_a_of_type_Aeux;
  private aeuy jdField_a_of_type_Aeuy = new aeuy(this);
  private ajpe jdField_a_of_type_Ajpe = new aeuv(this);
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private ArrayList<PublicRecommendAccountInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public PublicView(aeuo paramaeuo)
  {
    super(paramaeuo);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()) {
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    if (paramInt1 == 1)
    {
      paramString2 = new Intent();
      paramString2.putExtra("source", paramInt3);
      rtr.a(paramString2, paramQQAppInterface, paramContext, paramString1, -7);
      return;
    }
    paramString1 = new Intent();
    paramString1.putExtra("uinname", paramString3);
    paramString1.putExtra("source", paramInt3);
    rtr.a(paramString1, paramQQAppInterface, paramContext, paramString2, paramInt2);
  }
  
  private void a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    ((PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11)).a(paramSosoLbsInfo);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {}
      this.jdField_a_of_type_JavaUtilArrayList = ((ajoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c();
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))) {
      f();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aeux == null) {
        this.jdField_a_of_type_Aeux = new aeux(this, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView);
      }
      this.jdField_a_of_type_Aeux.notifyDataSetChanged();
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
    if (badq.g(this.jdField_a_of_type_AndroidAppActivity))
    {
      l();
      return true;
    }
    a(1, 2131628948);
    return false;
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131309309));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131306416));
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838503);
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity);
    View localView = localLayoutInflater.inflate(2131495018, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296574));
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(getResources().getDimensionPixelSize(2131166922), 0, 0, 0);
    Drawable localDrawable = getResources().getDrawable(2130848991);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(localDrawable, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)localLayoutInflater.inflate(2131493891, this.jdField_a_of_type_ComTencentWidgetXListView, false));
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
    SosoInterface.a(new aeuu(this, 1, true, true, 0L, false, false, "PublicView"));
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Aeuy.sendEmptyMessageDelayed(4, 3000L);
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
        localAppActivity.requestPermissions(new aeuw(this, localAppActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      j();
      return;
    }
    j();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131166837);
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    super.a();
    a(2131495017);
    e();
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).addObserver(this.jdField_a_of_type_Ajpe);
    a(true);
    l();
  }
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(0L);
    if (!a()) {
      this.jdField_a_of_type_Aeuy.sendEmptyMessageDelayed(2, 1000L);
    }
    return true;
  }
  
  protected void b()
  {
    super.b();
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.b(0L);
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  protected void d()
  {
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).removeObserver(this.jdField_a_of_type_Ajpe);
    if (this.jdField_a_of_type_Aeux != null) {
      this.jdField_a_of_type_Aeux.c();
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
    default: 
      return;
    case 2131296574: 
      this.jdField_a_of_type_Aeuo.a();
      avwf.a("add_page", "search", "active_frame", 3, 0, new String[] { "" });
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004BEC", "0X8004BEC", 3, 0, "", "", "", "");
      return;
    }
    paramView = (aeuz)paramView.getTag();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramView.a.mSource, paramView.a.mEqqNameAccount, String.valueOf(paramView.a.mPublicuin), paramView.a.accountflag, paramView.a.mPublicname, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.PublicView
 * JD-Core Version:    0.7.0.1
 */