package com.tencent.mobileqq.activity.contact.newfriend;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class NewFriendActivity
  extends BaseForwardSelectionActivity
  implements View.OnClickListener, BaseNewFriendView.INewFriendContext
{
  public static int a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NewFriendActivity.UiHandler jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler;
  NewFriendManager jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager;
  private SystemMsgListView jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
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
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawables();
      this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidWidgetTextView.getCompoundDrawablePadding();
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[1], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[2], this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[3]);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  void a(int paramInt)
  {
    if ((!isFinishing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnDismissListener(new NewFriendActivity.1(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler.hasMessages(1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler.removeMessages(1);
      bool = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
    Message localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler.obtainMessage(1, 2131719050, 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler.sendMessageDelayed(localMessage, 1000L);
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendActivity$UiHandler = new NewFriendActivity.UiHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager = ((NewFriendManager)this.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER));
    setContentView(2131561401);
    setContentBackgroundResource(2130838979);
    paramBundle = (LinearLayout)findViewById(2131377356);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369133));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131369518));
    this.c.setVisibility(0);
    this.c.setOnClickListener(this);
    this.c.setText(2131689557);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131694478);
    d();
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.c.setContentDescription(this.c.getText());
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131693918) + HardCodeUtil.a(2131707503));
    }
    paramBundle = (MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (paramBundle != null) {
      paramBundle.a(4);
    }
    NewFriendVerificationManager.a(this.app).a(this.app.getCurrentAccountUin());
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
        break label413;
      }
      a(this.app, "0X800A182");
    }
    for (;;)
    {
      paramBundle = (NewFriendManager)this.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER);
      paramBundle.e = false;
      paramBundle.d = false;
      return true;
      label413:
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
      Intent localIntent = new Intent(this, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 3);
      localIntent.putExtra("EntranceId", 6);
      startActivityForResult(localIntent, 221);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendNewFriendManager.f();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity
 * JD-Core Version:    0.7.0.1
 */