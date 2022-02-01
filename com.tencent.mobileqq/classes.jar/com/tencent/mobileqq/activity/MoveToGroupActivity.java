package com.tencent.mobileqq.activity;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BabyQIPCModule;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new MoveToGroupActivity.4(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new MoveToGroupActivity.5(this);
  private View jdField_a_of_type_AndroidViewView;
  private MoveToGroupActivity.ListAdapter jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MoveToGroupActivity.1(this);
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private String jdField_a_of_type_JavaLangString;
  private List<Groups> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  private byte jdField_b_of_type_Byte;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d = false;
  
  private void b()
  {
    GroupManagerInputTextWatcher localGroupManagerInputTextWatcher = new GroupManagerInputTextWatcher();
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new MoveToGroupActivity.3(this, localGroupManagerInputTextWatcher));
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = localQQProgressDialog;
    localQQProgressDialog.b(getTitleBarHeight());
    localQQProgressDialog.show();
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_b_of_type_Byte);
    Groups localGroups = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(String.valueOf(this.jdField_b_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    } else {
      localIntent.putExtra("group_name", localGroups.group_name);
    }
    setResult(-1, localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "AIO_edit_category_move");
    }
    ReportController.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
    finish();
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "Start Refresh:");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null) {
      this.jdField_a_of_type_JavaUtilList = ((FriendsManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter;
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter = new MoveToGroupActivity.ListAdapter(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter);
    }
    else
    {
      ((MoveToGroupActivity.ListAdapter)localObject).notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("End Refresh size = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList.size());
      QLog.d("MoveToGroupActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "showWaitingDialog");
    }
    a(false);
    Object localObject = this.jdField_a_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    localObject = new QQProgressDialog(this, this.jdField_a_of_type_Int);
    ((QQProgressDialog)localObject).c(paramInt);
    this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new MoveToGroupActivity.6(this));
    this.jdField_a_of_type_AndroidAppDialog.show();
    this.jdField_a_of_type_Boolean = false;
    this.c = false;
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissWaitingDialog delayPassed = ");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("MoveToGroupActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.c)
    {
      localObject = this.jdField_a_of_type_AndroidAppDialog;
      if (localObject != null)
      {
        if (((Dialog)localObject).isShowing()) {
          this.jdField_a_of_type_AndroidAppDialog.dismiss();
        }
        this.jdField_a_of_type_AndroidAppDialog = null;
        if (paramBoolean) {
          a();
        }
      }
    }
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694422, 0).a();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559470);
    setTitle(getString(2131694226));
    TextView localTextView = (TextView)findViewById(2131369202);
    localTextView.setContentDescription(HardCodeUtil.a(2131706938));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.d = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.jdField_a_of_type_Byte = getIntent().getExtras().getByte("mgid", (byte)0).byteValue();
    if (this.jdField_a_of_type_Byte == 0)
    {
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.e(this.jdField_a_of_type_JavaLangString);
      }
      if ((paramBundle != null) && (paramBundle.isFriend())) {
        this.jdField_a_of_type_Byte = ((byte)paramBundle.groupid);
      }
    }
    this.jdField_b_of_type_Byte = this.jdField_a_of_type_Byte;
    this.jdField_a_of_type_JavaUtilList = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).d();
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371521));
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299168);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559208, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367851);
    b();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter = new MoveToGroupActivity.ListAdapter(this, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter);
    localTextView.setOnClickListener(new MoveToGroupActivity.2(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    d();
    if (this.d) {
      BabyQIPCModule.a().a();
    }
  }
  
  protected boolean onBackEvent()
  {
    e();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    this.jdField_b_of_type_Byte = ((byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(i)).group_id);
    MoveToGroupActivity.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityMoveToGroupActivity$ListAdapter;
    if (localListAdapter != null) {
      localListAdapter.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      i = this.jdField_b_of_type_Byte;
      if ((i >= 0) && (i != this.jdField_a_of_type_Byte))
      {
        if (NetworkUtil.isNetSupport(this))
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).moveFriendToGroup(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Byte, this.jdField_a_of_type_Byte);
          c();
          break label186;
        }
        QQToast.a(this.app.getApp(), getString(2131694473), 1).b(getTitleBarHeight());
        finish();
        break label186;
      }
      if (this.jdField_b_of_type_Byte == this.jdField_a_of_type_Byte) {
        QQToast.a(this, getString(2131694224), 0).b(getTitleBarHeight());
      }
    }
    e();
    label186:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */