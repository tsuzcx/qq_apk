package com.tencent.mobileqq.activity;

import Override;
import aeij;
import aeik;
import aeil;
import aeim;
import aein;
import aeio;
import aeip;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import anqq;
import anvi;
import anvk;
import anvx;
import bdla;
import bisl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.List;

public class MoveToGroupActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private aeip jdField_a_of_type_Aeip;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aeim(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new aein(this);
  private View jdField_a_of_type_AndroidViewView;
  private anvi jdField_a_of_type_Anvi = new aeij(this);
  private bisl jdField_a_of_type_Bisl;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private List<Entity> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private byte jdField_b_of_type_Byte;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private void b()
  {
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aeil(this));
  }
  
  private void c()
  {
    bisl localbisl = new bisl(this);
    this.jdField_a_of_type_Bisl = localbisl;
    localbisl.b(getTitleBarHeight());
    localbisl.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_b_of_type_Byte);
    Groups localGroups = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(this.jdField_b_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "AIO_edit_category_move");
      }
      bdla.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
      finish();
      return;
      localIntent.putExtra("group_name", localGroups.group_name);
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "Start Refresh:");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localanvk != null) {
      this.jdField_a_of_type_JavaUtilList = localanvk.e();
    }
    if (this.jdField_a_of_type_Aeip == null)
    {
      this.jdField_a_of_type_Aeip = new aeip(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeip);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "End Refresh size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return;
      this.jdField_a_of_type_Aeip.notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "showWaitingDialog");
    }
    a(false);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    Object localObject = new bisl(this, this.jdField_a_of_type_Int);
    ((bisl)localObject).c(paramInt);
    this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aeio(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
    this.jdField_a_of_type_Boolean = false;
    this.c = false;
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "dismissWaitingDialog delayPassed = " + this.c);
    }
    if ((this.c) && (this.jdField_a_of_type_AndroidAppDialog != null))
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
      if (paramBoolean) {
        a();
      }
    }
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.addFriendGroup(paramByte, paramString);
      return true;
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559521);
    setTitle(getString(2131694059));
    TextView localTextView = (TextView)findViewById(2131369231);
    localTextView.setContentDescription(anvx.a(2131706376));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.d = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.jdField_a_of_type_Byte = getIntent().getExtras().getByte("mgid", (byte)0).byteValue();
    if (this.jdField_a_of_type_Byte == 0)
    {
      paramBundle = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramBundle != null) {
        break label295;
      }
    }
    label295:
    for (paramBundle = null;; paramBundle = paramBundle.e(this.jdField_a_of_type_JavaLangString))
    {
      if (paramBundle != null) {
        this.jdField_a_of_type_Byte = ((byte)paramBundle.groupid);
      }
      this.jdField_b_of_type_Byte = this.jdField_a_of_type_Byte;
      this.jdField_a_of_type_JavaUtilList = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e();
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371590));
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299080);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559290, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367890);
      b();
      addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_Aeip = new aeip(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeip);
      localTextView.setOnClickListener(new aeik(this));
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    removeObserver(this.jdField_a_of_type_Anvi);
    d();
    if (this.d) {
      anqq.a().a();
    }
  }
  
  public boolean onBackEvent()
  {
    e();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.jdField_b_of_type_Byte = ((byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(i)).group_id);
    if (this.jdField_a_of_type_Aeip != null) {
      this.jdField_a_of_type_Aeip.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true)) {
      if ((this.jdField_b_of_type_Byte >= 0) && (this.jdField_b_of_type_Byte != this.jdField_a_of_type_Byte)) {
        if (NetworkUtil.isNetSupport(this))
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).moveFriendToGroup(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Byte, this.jdField_a_of_type_Byte);
          c();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.app.getApp(), getString(2131694302), 1).b(getTitleBarHeight());
      finish();
      continue;
      if (this.jdField_b_of_type_Byte == this.jdField_a_of_type_Byte) {
        QQToast.a(this, getString(2131694057), 0).b(getTitleBarHeight());
      }
      e();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */