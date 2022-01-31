package com.tencent.mobileqq.activity.contact.newfriend;

import ahlc;
import ahll;
import ahlm;
import alud;
import alwd;
import alxr;
import amgf;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import bety;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements ahlc, View.OnClickListener
{
  public static int a;
  private ahlm jdField_a_of_type_Ahlm;
  alxr jdField_a_of_type_Alxr;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bety a;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public static void a(Context paramContext, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, NewFriendActivity.class);
    localIntent.putExtra("EntranceId", paramInt);
    localIntent.setFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ThreadManager.excute(new NewFriendActivity.2(paramQQAppInterface, paramString), 16, null, false);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839229);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public void a(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_Bety == null))
    {
      this.jdField_a_of_type_Bety = new bety(this, getTitleBarHeight());
      this.jdField_a_of_type_Bety.setOnDismissListener(new ahll(this));
      this.jdField_a_of_type_Bety.c(paramInt);
      this.jdField_a_of_type_Bety.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bety.setCancelable(false);
      this.jdField_a_of_type_Bety.show();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Ahlm.hasMessages(1))
    {
      this.jdField_a_of_type_Ahlm.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_Bety != null)
    {
      this.jdField_a_of_type_Bety.cancel();
      this.jdField_a_of_type_Bety = null;
      return true;
    }
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[0], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
    }
  }
  
  public void c()
  {
    Message localMessage = this.jdField_a_of_type_Ahlm.obtainMessage(1, 2131719785, 0);
    this.jdField_a_of_type_Ahlm.sendMessageDelayed(localMessage, 1000L);
  }
  
  void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = new SystemMsgListView(this, this.mFlingHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(getIntent(), this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.b();
      if (isResume()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.c();
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_Ahlm = new ahlm(this);
    this.jdField_a_of_type_Alxr = ((alxr)this.app.getManager(34));
    setContentView(2131561111);
    setContentBackgroundResource(2130838592);
    paramBundle = (LinearLayout)findViewById(2131376034);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368336));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131368655));
    this.c.setVisibility(0);
    this.c.setOnClickListener(this);
    this.c.setText(2131689628);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694790);
    d();
    if (AppSetting.c)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.c.setContentDescription(this.c.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694187) + alud.a(2131707898));
    }
    paramBundle = (alwd)this.app.getManager(159);
    if (paramBundle != null) {
      paramBundle.a(4);
    }
    amgf.a(this.app).a(this.app.getCurrentAccountUin());
    paramBundle = getIntent().getStringExtra("from");
    int j = getIntent().getIntExtra("fromSubType", -1);
    int i;
    if (("from_lsa".equals(paramBundle)) || ("from_notification".equals(paramBundle)))
    {
      i = j;
      if (j == -1) {
        i = jdField_a_of_type_Int;
      }
      if (i != 6) {
        break label409;
      }
      a(this.app, "0X800A182");
    }
    for (;;)
    {
      paramBundle = (alxr)this.app.getManager(34);
      paramBundle.e = false;
      paramBundle.d = false;
      return true;
      label409:
      if ((i == 9) || (i == 10) || (i == 1)) {
        a(this.app, "0X8009CBC");
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.f();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.d();
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.c();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.b();
    }
  }
  
  public void doOnStop()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.e();
    }
    super.doOnStop();
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = new Intent(this, AddContactsActivity.class);
      paramView.putExtra("entrence_data_report", 3);
      paramView.putExtra("EntranceId", 6);
      startActivityForResult(paramView, 221);
      this.jdField_a_of_type_Alxr.f();
      return;
    }
    finish();
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */