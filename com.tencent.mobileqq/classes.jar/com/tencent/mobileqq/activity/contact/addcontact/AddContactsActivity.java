package com.tencent.mobileqq.activity.contact.addcontact;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView;
import com.tencent.mobileqq.activity.contact.addcontact.publicaccount.PublicView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.CfgProcess;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.TextHook;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AddContactsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  LinearLayout a;
  boolean b;
  ContactBaseView.IAddContactContext c = new AddContactsActivity.2(this);
  Handler d = new AddContactsActivity.4(this);
  private ContactBaseView e;
  private AddContactsView f;
  private TroopView g;
  private PublicView h;
  private FrameLayout i;
  private RadioGroup j;
  private RadioButton k;
  private RadioButton l;
  private RadioButton m;
  private TextView n;
  private ImageView o;
  private boolean p;
  private boolean q = false;
  private RadioGroup.OnCheckedChangeListener r = new AddContactsActivity.1(this);
  
  public static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, AddContactsActivity.class);
    localIntent.putExtra("tab_index_key", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private void a(ContactBaseView paramContactBaseView)
  {
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != paramContactBaseView)
    {
      if (localContactBaseView != null)
      {
        if (isResume()) {
          this.e.c();
        }
        this.e.i();
      }
      this.e = paramContactBaseView;
      paramContactBaseView = this.e;
      if (paramContactBaseView != null)
      {
        paramContactBaseView.h();
        if (isResume()) {
          this.e.b();
        }
        this.i.removeAllViews();
        this.i.addView(this.e);
      }
    }
  }
  
  @TargetApi(14)
  private void c()
  {
    ((TextView)findViewById(2131436227)).setText(2131886199);
    this.a = ((LinearLayout)findViewById(2131445137));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.a.setFitsSystemWindows(true);
      this.a.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.n = ((TextView)findViewById(2131436180));
    this.n.setText("");
    this.n.setOnClickListener(this);
    this.n.setContentDescription(getString(2131893864));
    this.o = ((ImageView)findViewById(2131436238));
    this.o.setOnClickListener(this);
    this.j = ((RadioGroup)findViewById(2131427786));
    this.k = ((RadioButton)findViewById(2131446741));
    this.l = ((RadioButton)findViewById(2131446743));
    this.m = ((RadioButton)findViewById(2131446742));
    this.j.setOnCheckedChangeListener(this.r);
    if (StudyModeManager.k()) {
      this.j.setVisibility(4);
    }
    d();
    if (this.q)
    {
      this.m.setVisibility(0);
    }
    else
    {
      this.m.setVisibility(8);
      this.l.setGravity(16);
      this.l.setBackgroundDrawable(getResources().getDrawable(2130851735));
      int i1 = this.m.getPaddingRight();
      if (!TextHook.getInstance().isDefault()) {
        i1 = 0;
      }
      this.l.setPadding(this.m.getPaddingLeft(), this.m.getPaddingTop(), i1, this.m.getPaddingBottom());
    }
    this.i = ((FrameLayout)findViewById(2131431260));
    b();
  }
  
  private void d()
  {
    String str = Build.MODEL.toUpperCase();
    if ((str.contains("S968T")) || (str.contains("A0001")) || (str.contains("B9388")) || (str.equals("MI 2")) || (str.contains("LENOVO K900")) || (str.contains("VIVO X3L"))) {
      this.j.setPadding(0, 0, 0, 0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("adaptTabContainerPaddingByModel  model = ");
      localStringBuilder.append(str);
      QLog.i("AddContactsActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void e()
  {
    String str = CfgProcess.a(this.app.getCurrentAccountUin(), "add_contact_page_public_account_switch");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("public account switch config is: ");
      localStringBuilder.append(str);
      QLog.i("addContacts.Activity", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        int i1 = new JSONObject(str).optInt("showPublicTab");
        bool = true;
        if (i1 != 1) {
          break label143;
        }
        this.q = bool;
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("public account switch config is: ");
          localStringBuilder.append(QLog.getStackTraceString(localJSONException));
          QLog.i("addContacts.Activity", 2, localStringBuilder.toString());
        }
      }
      return;
      label143:
      boolean bool = false;
    }
  }
  
  private void f()
  {
    int i1 = getIntent().getIntExtra("tab_index_key", 0);
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2) {
          return;
        }
        this.m.setChecked(true);
        return;
      }
      this.l.setChecked(true);
      return;
    }
    this.k.setChecked(true);
  }
  
  private void g()
  {
    if (this.f == null)
    {
      this.f = new AddContactsView(this.c);
      this.f.a();
    }
    a(this.f);
  }
  
  private void h()
  {
    if (this.g == null)
    {
      this.g = new TroopView(this.c);
      this.g.setNavStickyListener(new AddContactsActivity.3(this));
      this.g.a();
    }
    a(this.g);
    ReportController.b(this.app, "dc00899", "Grp_find_new", "", "grptab", "exp", 0, 0, "", "", "", "");
  }
  
  private void i()
  {
    if (this.h == null)
    {
      this.h = new PublicView(this.c);
      this.h.a();
    }
    a(this.h);
  }
  
  int a()
  {
    ContactBaseView localContactBaseView = this.e;
    if ((localContactBaseView instanceof AddContactsView)) {
      return 0;
    }
    if ((localContactBaseView instanceof TroopView)) {
      return 1;
    }
    return 2;
  }
  
  protected void b()
  {
    boolean bool = QQTheme.isNowSimpleUI();
    ColorStateList localColorStateList;
    if (bool) {
      localColorStateList = getResources().getColorStateList(2131168193);
    } else {
      localColorStateList = getResources().getColorStateList(2131168206);
    }
    this.k.setTextColor(localColorStateList);
    this.l.setTextColor(localColorStateList);
    this.m.setTextColor(localColorStateList);
    if (bool)
    {
      this.k.setPadding(0, 0, 0, 0);
      this.l.setPadding(0, 0, 0, 0);
      this.m.setPadding(0, 0, 0, 0);
      this.k.setGravity(17);
      this.l.setGravity(17);
      this.m.setGravity(17);
      return;
    }
    this.k.setPadding(0, 0, ViewUtils.dpToPx(10.0F), 0);
    this.l.setPadding(0, 0, 0, 0);
    this.m.setPadding(ViewUtils.dpToPx(10.0F), 0, 0, 0);
    this.k.setGravity(21);
    this.l.setGravity(17);
    this.m.setGravity(16);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != null) {
      localContactBaseView.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putParcelable("android:support:fragments", null);
    }
    super.doOnCreate(paramBundle);
    super.setContentView(2131627236);
    getWindow().setBackgroundDrawable(null);
    e();
    c();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((AddContactsView)localObject).d();
    }
    localObject = this.g;
    if (localObject != null) {
      ((TroopView)localObject).d();
    }
    localObject = this.h;
    if (localObject != null) {
      ((PublicView)localObject).d();
    }
    super.doOnDestroy();
    ((IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class)).resetAttribute();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != null) {
      localContactBaseView.c();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != null) {
      localContactBaseView.b();
    }
    if (this.b) {
      this.d.sendEmptyMessage(0);
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != null) {
      localContactBaseView.h();
    }
    this.d.sendEmptyMessage(1);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    ContactBaseView localContactBaseView = this.e;
    if (localContactBaseView != null) {
      localContactBaseView.i();
    }
  }
  
  protected boolean onBackEvent()
  {
    finish();
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if ((i1 == 2131436238) && (1 == a()))
      {
        Intent localIntent = new Intent(this, SearchContactsActivity.class);
        localIntent.putExtra("from_key", a());
        localIntent.putExtra("fromType", 13);
        startActivity(localIntent);
        overridePendingTransition(0, 0);
      }
    }
    else {
      onBackEvent();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    b();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity
 * JD-Core Version:    0.7.0.1
 */