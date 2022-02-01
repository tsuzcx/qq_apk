package com.tencent.biz.pubaccount.accountdetail.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PubAccountMoreInfoActivity
  extends IphoneTitleBarActivity
{
  PublicAccountDetailImpl a;
  String b;
  AccountDetailGroupListContainer c;
  ScrollView d;
  float e;
  protected NewIntent f;
  protected BusinessObserver g;
  mobileqq_mp.GetPublicAccountDetailInfoResponse h;
  private View i;
  
  private void c()
  {
    super.setContentView(2131623970);
    this.d = ((ScrollView)super.findViewById(2131445159));
    setTitle(getResources().getString(2131892947));
    this.i = super.findViewById(2131442127);
    View localView;
    if (QQTheme.isNowThemeIsNight())
    {
      localView = this.i;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.i;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    this.e = super.getResources().getDisplayMetrics().density;
    if (this.a != null)
    {
      this.c = new AccountDetailGroupListContainer(this.app, this, this.b, this.a, true);
      this.d.addView(this.c.c());
    }
  }
  
  private void d()
  {
    this.c = new AccountDetailGroupListContainer(this.app, this, this.b, this.a, true);
    this.d.addView(this.c.c());
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "init");
    }
    Object localObject = getIntent();
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (localObject != null) {
      this.b = ((Intent)localObject).getStringExtra("uin");
    }
    localObject = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      this.a = ((PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.b));
    }
    if (this.a == null) {
      b();
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.f = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.f.putExtra("cmd", "get_detail_info");
    localObject = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).versionInfo.set("8.8.17,3,5770");
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).version.set(1);
    if (this.a != null) {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(this.a.seqno);
    } else {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(0);
    }
    try
    {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).uin.set((int)Long.parseLong(this.b));
      label129:
      this.f.putExtra("data", ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).toByteArray());
      this.g = new PubAccountMoreInfoActivity.1(this);
      this.f.setObserver(this.g);
      this.app.startServlet(this.f);
      return;
    }
    catch (Exception localException)
    {
      break label129;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AccountDetailGroupListContainer localAccountDetailGroupListContainer = this.c;
    if (localAccountDetailGroupListContainer != null) {
      localAccountDetailGroupListContainer.b();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.activity.PubAccountMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */