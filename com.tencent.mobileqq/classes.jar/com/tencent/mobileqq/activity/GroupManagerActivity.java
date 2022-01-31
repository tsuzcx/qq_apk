package com.tencent.mobileqq.activity;

import aczd;
import acze;
import aczf;
import aczg;
import aczh;
import aczi;
import aczj;
import aczk;
import aczl;
import aczm;
import aczn;
import aczo;
import aczp;
import aker;
import alox;
import aloz;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import apkr;
import aplb;
import aplc;
import aplf;
import bdee;
import bdha;
import bepp;
import bhpy;
import bhql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupManagerActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private aker<Groups> jdField_a_of_type_Aker;
  private alox jdField_a_of_type_Alox = new aczh(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new aczl(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new aczf(this);
  private aplb jdField_a_of_type_Aplb = new aczn(this);
  private aplf jdField_a_of_type_Aplf = new aczo(this);
  private bdha jdField_a_of_type_Bdha;
  private Groups jdField_a_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  public List<Groups> a;
  private boolean jdField_a_of_type_Boolean;
  public byte[] a;
  private int jdField_b_of_type_Int;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new aczm(this);
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
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(2131693331);
    localbhpy.a(2131693324, 3);
    localbhpy.c(2131693326);
    localbhpy.setOnDismissListener(new aczp(this));
    localbhpy.a(new acze(this, paramByte));
    this.jdField_a_of_type_AndroidAppDialog = localbhpy;
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
    setRightButton(2131693328, new aczd(this));
    setTitle(2131693327);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((aplc)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Aplb);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Aplf);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new aczi(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new aczj(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    localObject = getLayoutInflater().inflate(2131559166, null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView((View)localObject);
    ((View)localObject).findViewById(2131367337).setOnClickListener(new aczk(this));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public apkr a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new apkr(paramDragSortListView);
    paramDragSortListView.d(2131365482);
    paramDragSortListView.e(2131364319);
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
    Object localObject = (aloz)this.app.getManager(51);
    if (localObject != null) {}
    for (localObject = ((aloz)localObject).e();; localObject = null)
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
      if (this.jdField_a_of_type_Aker == null)
      {
        this.jdField_a_of_type_Aker = new aker(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Aker);
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
            this.jdField_a_of_type_Aker.notifyDataSetChanged();
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
    Object localObject = new bepp(this, this.jdField_a_of_type_Int);
    ((bepp)localObject).c(paramInt);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new aczg(this));
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
    if (!bdee.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694764, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramByte);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    if (!bdee.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694764, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramByte, paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (!bdee.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694764, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.a(paramArrayOfByte1, paramArrayOfByte2);
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
    if (!bdee.d(getApplication()))
    {
      QQToast.a(BaseApplicationImpl.sApplication, 2131694764, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.a(1);
    if (localFriendListHandler != null) {
      localFriendListHandler.b(paramByte, paramString);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298914);
    super.setContentView(2131560966);
    d();
    e();
    this.app.addObserver(this.jdField_a_of_type_Alox);
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
    this.app.removeObserver(this.jdField_a_of_type_Alox);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */