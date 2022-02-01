package com.tencent.mobileqq.activity;

import Override;
import aedb;
import aedc;
import aedd;
import aede;
import aedf;
import aedg;
import aedh;
import aedi;
import aedj;
import aedk;
import aedl;
import aedm;
import aedn;
import aedo;
import amhm;
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
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import anvi;
import anvk;
import asfx;
import asgh;
import asgi;
import asgl;
import bisl;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupManagerActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private amhm<Groups> jdField_a_of_type_Amhm;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aedk(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new aedd(this);
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aedg(this);
  private anvi jdField_a_of_type_Anvi = new aedf(this);
  private asgh jdField_a_of_type_Asgh = new aedm(this);
  private asgl jdField_a_of_type_Asgl = new aedn(this);
  private Groups jdField_a_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  public List<Groups> a;
  private boolean jdField_a_of_type_Boolean;
  public byte[] a;
  private int jdField_b_of_type_Int;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new aedl(this);
  private boolean jdField_b_of_type_Boolean;
  public byte[] b;
  private boolean c;
  
  public GroupManagerActivity()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  private void a(byte paramByte)
  {
    c();
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    localbkzi.a(2131692990);
    localbkzi.a(2131692983, 3);
    localbkzi.c(2131692985);
    localbkzi.setOnDismissListener(new aedo(this));
    localbkzi.a(new aedc(this, paramByte));
    this.jdField_a_of_type_AndroidAppDialog = localbkzi;
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, GroupManagerActivity.class));
    paramActivity.overridePendingTransition(2130771979, 2130771980);
  }
  
  private void d()
  {
    this.leftView.setVisibility(8);
    setRightButton(2131692987, new aedb(this));
    setTitle(2131692986);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((asgi)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Asgh);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Asgl);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new aedh(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new aedi(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    localObject = getLayoutInflater().inflate(2131559290, null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView((View)localObject);
    ((View)localObject).findViewById(2131367890).setOnClickListener(new aedj(this));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public asfx a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new asfx(paramDragSortListView);
    paramDragSortListView.d(2131365893);
    paramDragSortListView.e(2131364684);
    paramDragSortListView.b(true);
    paramDragSortListView.a(true);
    paramDragSortListView.a(0);
    paramDragSortListView.b(0);
    return paramDragSortListView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "/************************Start Refresh:");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null) {}
    for (localObject = ((anvk)localObject).e();; localObject = null)
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
      if (this.jdField_a_of_type_Amhm == null)
      {
        this.jdField_a_of_type_Amhm = new amhm(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Amhm);
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
            this.jdField_a_of_type_Amhm.notifyDataSetChanged();
            break;
          }
        }
        localObject = (String)localObject + "]";
        QLog.d("GroupManagerActivity", 2, "End Refresh************************ s = " + (String)localObject);
      }
      return;
    }
  }
  
  public void a(int paramInt)
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
    Object localObject = new bisl(this, this.jdField_a_of_type_Int);
    ((bisl)localObject).c(paramInt);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new aede(this));
    this.jdField_b_of_type_AndroidAppDialog.show();
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 500L);
  }
  
  public void a(boolean paramBoolean)
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
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
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
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
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
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
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
    if (!NetworkUtil.isNetSupport(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694253, 0).a();
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
  
  public void c()
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
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299080);
    super.setContentView(2131561166);
    d();
    e();
    this.app.addObserver(this.jdField_a_of_type_Anvi);
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
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771977, 2130771978);
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
    overridePendingTransition(2130771977, 2130771978);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */