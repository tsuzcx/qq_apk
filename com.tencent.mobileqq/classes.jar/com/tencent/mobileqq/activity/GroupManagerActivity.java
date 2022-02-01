package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortController;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.emosm.view.DragSortListView.FloatViewManager;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.utils.GroupManagerInputTextWatcher;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupManagerActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new GroupManagerActivity.5(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new GroupManagerActivity.11(this);
  private GroupEditeDragSortAdapter<Groups> jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new GroupManagerActivity.13(this);
  private Groups jdField_a_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = new GroupManagerActivity.7(this);
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = new GroupManagerActivity.8(this);
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  List<Groups> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  private int jdField_b_of_type_Int;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new GroupManagerActivity.6(this);
  private boolean jdField_b_of_type_Boolean;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  private boolean c;
  
  private void a(byte paramByte)
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.setMainTitle(2131693135);
    localActionSheet.addButton(2131693128, 3);
    localActionSheet.addCancelButton(2131693130);
    localActionSheet.setOnDismissListener(new GroupManagerActivity.9(this));
    localActionSheet.setOnButtonClickListener(new GroupManagerActivity.10(this, paramByte));
    this.jdField_a_of_type_AndroidAppDialog = localActionSheet;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, GroupManagerActivity.class));
    paramActivity.overridePendingTransition(2130771981, 2130771982);
  }
  
  private void d()
  {
    this.leftView.setVisibility(8);
    setRightButton(2131693132, new GroupManagerActivity.1(this));
    setTitle(2131693131);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((DragSortListView.FloatViewManager)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener);
    localObject = new GroupManagerInputTextWatcher();
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new GroupManagerActivity.2(this, (GroupManagerInputTextWatcher)localObject));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new GroupManagerActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    View localView = getLayoutInflater().inflate(2131559331, null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView(localView);
    localView.findViewById(2131368098).setOnClickListener(new GroupManagerActivity.4(this, (GroupManagerInputTextWatcher)localObject));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131366057);
    paramDragSortListView.e(2131364798);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    return paramDragSortListView;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "/************************Start Refresh:");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null) {}
    for (localObject = ((FriendsManager)localObject).d();; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Groups localGroups = (Groups)((Iterator)localObject).next();
          this.jdField_a_of_type_JavaUtilList.add(localGroups);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter = new GroupEditeDragSortAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("GroupManagerActivity", 2, "End Refresh************************ size = " + this.jdField_a_of_type_JavaUtilList.size());
        localObject = "[";
        int i = 0;
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilList.size())
          {
            localObject = (String)localObject + (byte)((Groups)this.jdField_a_of_type_JavaUtilList.get(i)).group_id + "   ";
            i += 1;
            continue;
            this.jdField_a_of_type_ComTencentMobileqqAdapterGroupEditeDragSortAdapter.notifyDataSetChanged();
            break;
          }
        }
        localObject = (String)localObject + "]";
        QLog.d("GroupManagerActivity", 2, "End Refresh************************ s = " + (String)localObject);
      }
      return;
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "showWaitingDialog");
    }
    a(false);
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    Object localObject = new QQProgressDialog(this, this.jdField_a_of_type_Int);
    ((QQProgressDialog)localObject).c(paramInt);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new GroupManagerActivity.12(this));
    this.jdField_b_of_type_AndroidAppDialog.show();
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "dismissWaitingDialog delayPassed = " + this.c);
    }
    if ((this.c) && (this.jdField_b_of_type_AndroidAppDialog != null))
    {
      if (this.jdField_b_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_b_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_b_of_type_AndroidAppDialog = null;
      if (paramBoolean) {
        a();
      }
    }
  }
  
  public boolean a(byte paramByte)
  {
    if (!NetworkUtil.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.deleteFriendGroup(paramByte);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!NetworkUtil.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.addFriendGroup(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!NetworkUtil.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.resortFriendGroup(paramArrayOfByte1, paramArrayOfByte2);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  @SuppressLint({"NewApi"})
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "scrollToBottom:" + this.jdField_a_of_type_JavaUtilList.size());
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.smoothScrollToPosition(this.jdField_a_of_type_JavaUtilList.size());
  }
  
  public boolean b(byte paramByte, String paramString)
  {
    if (!NetworkUtil.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694457, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null) {
      localFriendListHandler.renameFriendGroup(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null)
    {
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      this.jdField_a_of_type_AndroidAppDialog = null;
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299166);
    super.setContentView(2131561264);
    d();
    e();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onDestroy");
    }
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771979, 2130771980);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (456 == paramMessage.what) {
      a();
    }
    for (;;)
    {
      return false;
      if (457 == paramMessage.what) {
        b();
      }
    }
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(2130771979, 2130771980);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */