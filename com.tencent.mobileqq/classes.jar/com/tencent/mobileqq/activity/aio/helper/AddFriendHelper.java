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
import mqq.app.MobileQQ;

public class AddFriendHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  protected final Activity a;
  protected final Context a;
  protected LinearLayout a;
  protected TextView a;
  protected final SessionInfo a;
  protected final AIOContext a;
  private FriendListObserver a;
  protected MessageObserver a;
  protected final QQAppInterface a;
  public QQProgressDialog a;
  protected TextView b;
  
  public AddFriendHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AddFriendHelper.7(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AddFriendHelper.8(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_AndroidAppActivity = paramAIOContext.a();
    this.jdField_a_of_type_AndroidContentContext = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramAIOContext.a());
  }
  
  private void c(String paramString)
  {
    if (!a().equals(paramString)) {
      return;
    }
    paramString = UinTypeUtil.c;
    int m = paramString.length;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      j = paramString[i];
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == j)
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AddFriendHelper.6(this));
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendHelper", 2, "showAddFriendAndShield() ==== called.");
    }
    String str = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      AddFriendHelper.1 local1 = new AddFriendHelper.1(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362540);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297080));
      localLayoutParams.addRule(3, 2131376636);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.j()) {
        localLayoutParams.topMargin = 0;
      }
      this.jdField_a_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296453));
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(local1);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      View localView = new View(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
      this.b = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
      this.b.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689826));
      this.b.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296453));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.j()) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837906);
      } else {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837909);
      }
      this.b.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.b.setCompoundDrawablePadding(AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localObject = this.b;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      this.b.setOnClickListener(local1);
      this.b.setTag(Integer.valueOf(3));
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.j())
      {
        localView.setBackgroundColor(Color.parseColor("#d3d5dc"));
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838226));
        this.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838226));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167135));
        this.b.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167135));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838225));
        this.b.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838225));
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166476));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167134));
        this.b.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167134));
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.b, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.j()) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838227);
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838230);
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.g();
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837933);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719154));
      this.jdField_a_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    a(bool, str);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a((int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297080));
  }
  
  protected void a(String paramString)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
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
  
  protected void b()
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.g();
    if (bool2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690706);
    boolean bool1;
    if (this.jdField_a_of_type_AndroidAppActivity.getIntent().getStringExtra("param_return_addr") != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ChatActivityUtils.a(localActivity, localSessionInfo, str, bool1, bool2, a());
  }
  
  protected void b(String paramString)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void c()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidAppActivity, null);
    localActionSheet.setMainTitle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719156));
    localActionSheet.addButton(2131719154, 3);
    localActionSheet.addButton(2131719153);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new AddFriendHelper.3(this, localActionSheet));
    localActionSheet.show();
    ReportController.b(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
  
  protected void d()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(0);
  }
  
  public void e()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AddFriendHelper.4(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new AddFriendHelper.5(this));
  }
  
  @NonNull
  public String getTag()
  {
    return "AddFriendHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 7, 9, 15 };
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    e();
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
          d();
          if (a()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
          if (localObject != null)
          {
            ((QQProgressDialog)localObject).dismiss();
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
          }
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
          if (localObject != null)
          {
            ((LinearLayout)localObject).removeAllViews();
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
            localObject = this.jdField_a_of_type_AndroidWidgetTextView;
            if (localObject != null) {
              AIOUtils.a(((TextView)localObject).getBackground());
            }
            localObject = this.b;
            if (localObject != null) {
              AIOUtils.a(((TextView)localObject).getBackground());
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
            this.jdField_a_of_type_AndroidWidgetTextView = null;
            this.b = null;
          }
        }
        else
        {
          e();
        }
      }
      else
      {
        int i = 0;
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
        paramInt = i;
        if (localObject != null)
        {
          paramInt = i;
          if (((LinearLayout)localObject).getVisibility() == 0) {
            paramInt = (int)this.jdField_a_of_type_AndroidAppActivity.getResources().getDimension(2131297080);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(paramInt);
      }
    }
    else
    {
      if (a()) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper
 * JD-Core Version:    0.7.0.1
 */