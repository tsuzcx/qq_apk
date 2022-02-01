package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public class AddFriendHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  protected final AIOContext a;
  protected final QQAppInterface b;
  protected final Activity c;
  protected final Context d;
  protected final SessionInfo e;
  public QQProgressDialog f;
  protected LinearLayout g;
  protected TextView h;
  protected TextView i;
  protected MessageObserver j = new AddFriendHelper.7(this);
  private FriendListObserver k = new AddFriendHelper.8(this);
  
  public AddFriendHelper(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = paramAIOContext.a();
    this.c = paramAIOContext.b();
    this.d = paramAIOContext.b();
    this.e = ((SessionInfo)paramAIOContext.O());
  }
  
  private void c(String paramString)
  {
    if (!b().equals(paramString)) {
      return;
    }
    paramString = UinTypeUtil.d;
    int i2 = paramString.length;
    int i1 = 0;
    int m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= i2) {
        break;
      }
      n = paramString[m];
      if (this.e.a == n)
      {
        n = 1;
        break;
      }
      m += 1;
    }
    if (n == 0) {
      return;
    }
    this.c.runOnUiThread(new AddFriendHelper.6(this));
  }
  
  protected void a(String paramString)
  {
    ChatActivityUtils.a(this.b, this.c, this.e.a, paramString, this.e.f, false);
    if (this.e.a == 1010) {
      ReportController.b(this.b, "CliOper", "", this.e.b, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.post(new AddFriendHelper.2(this, paramString, paramBoolean), 8, null, true);
  }
  
  protected boolean a()
  {
    return false;
  }
  
  protected String b()
  {
    return this.e.b;
  }
  
  protected void b(String paramString)
  {
    ChatActivityUtils.a(this.b, this.c, this.e.a, paramString, this.e.f, true);
    if (this.e.a == 1010) {
      ReportController.b(this.b, "CliOper", "", this.e.b, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
    }
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendHelper", 2, "showAddFriendAndShield() ==== called.");
    }
    String str = b();
    if (this.e.a == 1006) {
      str = this.e.g;
    }
    Object localObject;
    if (this.g == null)
    {
      AddFriendHelper.1 local1 = new AddFriendHelper.1(this);
      this.g = new LinearLayout(this.d);
      this.g.setId(2131428151);
      this.g.setVisibility(8);
      this.g.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.b.getApplication().getResources().getDimension(2131297461));
      localLayoutParams.addRule(3, 2131444897);
      if (!this.a.I()) {
        localLayoutParams.topMargin = 0;
      }
      this.h = new DrawableCenterTextView(this.d);
      if ((this.e.a == 1006) && ((this.e.g == null) || (this.e.g.equals(""))))
      {
        this.h.setEnabled(false);
        this.h.setClickable(false);
      }
      else
      {
        this.h.setEnabled(true);
        this.h.setClickable(true);
      }
      this.h.setTextSize(0, this.b.getApplication().getResources().getDimension(2131296687));
      this.h.setCompoundDrawablePadding(AIOUtils.b(8.0F, this.b.getApplication().getResources()));
      this.h.setOnClickListener(local1);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      View localView = new View(this.d);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
      this.i = new DrawableCenterTextView(this.d);
      this.i.setText(this.d.getString(2131886467));
      this.i.setTextSize(0, this.d.getResources().getDimensionPixelSize(2131296687));
      if (this.a.I()) {
        localObject = this.d.getResources().getDrawable(2130837930);
      } else {
        localObject = this.d.getResources().getDrawable(2130837933);
      }
      this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.i.setCompoundDrawablePadding(AIOUtils.b(8.0F, this.d.getResources()));
      localObject = this.i;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      this.i.setOnClickListener(local1);
      this.i.setTag(Integer.valueOf(3));
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      if (this.a.I())
      {
        localView.setBackgroundColor(Color.parseColor("#d3d5dc"));
        this.h.setBackgroundDrawable(this.b.getApplication().getResources().getDrawable(2130838291));
        this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2130838291));
        this.h.setTextColor(this.b.getApplication().getResources().getColorStateList(2131168115));
        this.i.setTextColor(this.d.getResources().getColorStateList(2131168115));
      }
      else
      {
        this.h.setBackgroundDrawable(this.b.getApplication().getResources().getDrawable(2130838290));
        this.i.setBackgroundDrawable(this.d.getResources().getDrawable(2130838290));
        localView.setBackgroundColor(this.d.getResources().getColor(2131167318));
        this.h.setTextColor(this.b.getApplication().getResources().getColorStateList(2131168114));
        this.i.setTextColor(this.d.getResources().getColorStateList(2131168114));
      }
      this.g.addView(this.h, localLayoutParams1);
      this.g.addView(localView, localLayoutParams2);
      this.g.addView(this.i, (ViewGroup.LayoutParams)localObject);
      this.a.a(this.g, localLayoutParams);
    }
    if (this.a.I()) {
      localObject = this.b.getApplication().getResources().getDrawable(2130838292);
    } else {
      localObject = this.b.getApplication().getResources().getDrawable(2130838295);
    }
    boolean bool = this.a.A();
    if (bool)
    {
      localObject = this.b.getApplication().getResources().getDrawable(2130837957);
      this.h.setText(this.b.getApplication().getResources().getString(2131916690));
      this.h.setTag(Integer.valueOf(4));
    }
    this.h.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    a(bool, str);
    this.g.setVisibility(0);
    this.a.z().d().a((int)this.c.getResources().getDimension(2131297461));
  }
  
  protected void d()
  {
    boolean bool2 = this.a.A();
    if (bool2) {
      ReportController.b(this.b, "CliOper", "", this.e.b, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    Activity localActivity = this.c;
    SessionInfo localSessionInfo = this.e;
    String str = this.b.getApp().getString(2131887625);
    boolean bool1;
    if (this.c.getIntent().getStringExtra("param_return_addr") != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ChatActivityUtils.a(localActivity, localSessionInfo, str, bool1, bool2, b());
  }
  
  protected void e()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.c, null);
    localActionSheet.setMainTitle(this.b.getApplication().getResources().getString(2131916692));
    localActionSheet.addButton(2131916690, 3);
    localActionSheet.addButton(2131916689);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new AddFriendHelper.3(this, localActionSheet));
    localActionSheet.show();
    ReportController.b(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
  
  protected void f()
  {
    LinearLayout localLinearLayout = this.g;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    this.a.z().d().a(ImmersiveUtils.getStatusBarHeight(this.d));
  }
  
  public void g()
  {
    if (h())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      this.c.runOnUiThread(new AddFriendHelper.4(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    this.c.runOnUiThread(new AddFriendHelper.5(this));
  }
  
  @NonNull
  public String getTag()
  {
    return "AddFriendHelper";
  }
  
  protected boolean h()
  {
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 9, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    g();
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      Object localObject;
      if (paramInt != 7)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          f();
          if (a()) {
            this.b.removeObserver(this.j);
          }
          this.b.removeObserver(this.k);
          localObject = this.f;
          if (localObject != null)
          {
            ((QQProgressDialog)localObject).dismiss();
            this.f = null;
          }
          localObject = this.g;
          if (localObject != null)
          {
            ((LinearLayout)localObject).removeAllViews();
            this.a.a(this.g);
            localObject = this.h;
            if (localObject != null) {
              AIOUtils.a(((TextView)localObject).getBackground());
            }
            localObject = this.i;
            if (localObject != null) {
              AIOUtils.a(((TextView)localObject).getBackground());
            }
            this.g = null;
            this.h = null;
            this.i = null;
          }
        }
        else
        {
          g();
        }
      }
      else
      {
        int m = ImmersiveUtils.getStatusBarHeight(this.d);
        localObject = this.g;
        paramInt = m;
        if (localObject != null)
        {
          paramInt = m;
          if (((LinearLayout)localObject).getVisibility() == 0) {
            paramInt = (int)this.c.getResources().getDimension(2131297461);
          }
        }
        this.a.z().d().a(paramInt);
      }
    }
    else
    {
      if (a()) {
        this.b.addDefaultObservers(this.j);
      }
      this.b.addObserver(this.k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper
 * JD-Core Version:    0.7.0.1
 */