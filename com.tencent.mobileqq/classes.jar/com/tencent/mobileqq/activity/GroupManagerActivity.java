package com.tencent.mobileqq.activity;

import abid;
import abie;
import abif;
import abig;
import abih;
import abii;
import abij;
import abik;
import abil;
import abim;
import abin;
import abio;
import abip;
import aing;
import ajxj;
import ajxl;
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
import antj;
import antt;
import antu;
import antx;
import bbfj;
import bbie;
import bcqf;
import bcql;
import bfpc;
import bfpp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView;
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
  private aing<Groups> jdField_a_of_type_Aing;
  private ajxj jdField_a_of_type_Ajxj = new abih(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new abil(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new abif(this);
  private antt jdField_a_of_type_Antt = new abin(this);
  private antx jdField_a_of_type_Antx = new abio(this);
  private bbie jdField_a_of_type_Bbie;
  private Groups jdField_a_of_type_ComTencentMobileqqDataGroups;
  private DragSortListView jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView;
  public List<Groups> a;
  private boolean jdField_a_of_type_Boolean;
  public byte[] a;
  private int jdField_b_of_type_Int;
  private Dialog jdField_b_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new abim(this);
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
    bfpc localbfpc = (bfpc)bfpp.a(this, null);
    localbfpc.a(2131693230);
    localbfpc.a(2131693223, 3);
    localbfpc.c(2131693225);
    localbfpc.setOnDismissListener(new abip(this));
    localbfpc.a(new abie(this, paramByte));
    this.jdField_a_of_type_AndroidAppDialog = localbfpc;
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
    setRightButton(2131693227, new abid(this));
    setTitle(2131693226);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setFloatViewManager((antu)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnTouchListener((View.OnTouchListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDropListener(this.jdField_a_of_type_Antt);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setRemoveListener(this.jdField_a_of_type_Antx);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setOnItemClickListener(new abii(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setLeftEventListener(new abij(this));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setVerticalScrollBarEnabled(false);
    localObject = getLayoutInflater().inflate(2131559123, null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addHeaderView((View)localObject);
    ((View)localObject).findViewById(2131367207).setOnClickListener(new abik(this));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(10.0F * getResources().getDisplayMetrics().density)));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.addFooterView((View)localObject);
  }
  
  public antj a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new antj(paramDragSortListView);
    paramDragSortListView.d(2131365398);
    paramDragSortListView.e(2131364254);
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
    Object localObject = (ajxl)this.app.getManager(51);
    if (localObject != null) {}
    for (localObject = ((ajxl)localObject).e();; localObject = null)
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
      if (this.jdField_a_of_type_Aing == null)
      {
        this.jdField_a_of_type_Aing = new aing(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setAdapter(this.jdField_a_of_type_Aing);
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
            this.jdField_a_of_type_Aing.notifyDataSetChanged();
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
    Object localObject = new bcqf(this, this.jdField_a_of_type_Int);
    ((bcqf)localObject).c(paramInt);
    this.jdField_b_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_b_of_type_AndroidAppDialog.setOnDismissListener(new abig(this));
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
    if (!bbfj.d(getApplication()))
    {
      bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).a();
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
    if (!bbfj.d(getApplication()))
    {
      bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).a();
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
    if (!bbfj.d(getApplication()))
    {
      bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).a();
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
    if (!bbfj.d(getApplication()))
    {
      bcql.a(BaseApplicationImpl.sApplication, 2131694608, 0).a();
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
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298865);
    super.setContentView(2131560783);
    d();
    e();
    this.app.addObserver(this.jdField_a_of_type_Ajxj);
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
    this.app.removeObserver(this.jdField_a_of_type_Ajxj);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity
 * JD-Core Version:    0.7.0.1
 */