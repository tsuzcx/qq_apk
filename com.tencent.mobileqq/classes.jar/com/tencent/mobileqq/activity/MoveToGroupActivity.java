package com.tencent.mobileqq.activity;

import Override;
import adrg;
import adrh;
import adri;
import adrj;
import adrk;
import adrl;
import adrm;
import amod;
import amsu;
import amsw;
import amtj;
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
import bcef;
import bhht;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
  private adrm jdField_a_of_type_Adrm;
  private amsu jdField_a_of_type_Amsu = new adrg(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new adrj(this);
  @SuppressLint({"HandlerLeak"})
  private Handler jdField_a_of_type_AndroidOsHandler = new adrk(this);
  private View jdField_a_of_type_AndroidViewView;
  private bhht jdField_a_of_type_Bhht;
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
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new adri(this));
  }
  
  private void c()
  {
    bhht localbhht = new bhht(this);
    this.jdField_a_of_type_Bhht = localbhht;
    localbhht.b(getTitleBarHeight());
    localbhht.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing()))
    {
      this.jdField_a_of_type_Bhht.dismiss();
      this.jdField_a_of_type_Bhht = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.jdField_b_of_type_Byte);
    Groups localGroups = ((amsw)this.app.getManager(51)).a(String.valueOf(this.jdField_b_of_type_Byte));
    if (localGroups == null) {
      localIntent.putExtra("group_name", "");
    }
    for (;;)
    {
      setResult(-1, localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "AIO_edit_category_move");
      }
      bcef.b(this.app, "CliOper", "", "", "AIO", "AIO_edit_category_move", 0, 0, "", "", "", "");
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
    amsw localamsw = (amsw)this.app.getManager(51);
    if (localamsw != null) {
      this.jdField_a_of_type_JavaUtilList = localamsw.e();
    }
    if (this.jdField_a_of_type_Adrm == null)
    {
      this.jdField_a_of_type_Adrm = new adrm(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adrm);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "End Refresh size = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      return;
      this.jdField_a_of_type_Adrm.notifyDataSetChanged();
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
    Object localObject = new bhht(this, this.jdField_a_of_type_Int);
    ((bhht)localObject).c(paramInt);
    this.jdField_a_of_type_AndroidAppDialog = ((Dialog)localObject);
    this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new adrl(this));
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
      QQToast.a(BaseApplicationImpl.sApplication, 2131694062, 0).a();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
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
    super.setContentView(2131559488);
    setTitle(getString(2131693868));
    TextView localTextView = (TextView)findViewById(2131369068);
    localTextView.setContentDescription(amtj.a(2131706024));
    this.jdField_a_of_type_JavaLangString = getIntent().getExtras().getString("friendUin");
    this.d = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.jdField_a_of_type_Byte = getIntent().getExtras().getByte("mgid", (byte)0).byteValue();
    if (this.jdField_a_of_type_Byte == 0)
    {
      paramBundle = (amsw)this.app.getManager(51);
      if (paramBundle != null) {
        break label293;
      }
    }
    label293:
    for (paramBundle = null;; paramBundle = paramBundle.e(this.jdField_a_of_type_JavaLangString))
    {
      if (paramBundle != null) {
        this.jdField_a_of_type_Byte = ((byte)paramBundle.groupid);
      }
      this.jdField_b_of_type_Byte = this.jdField_a_of_type_Byte;
      this.jdField_a_of_type_JavaUtilList = ((amsw)this.app.getManager(51)).e();
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131371405));
      this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299076);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559251, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367754);
      b();
      addObserver(this.jdField_a_of_type_Amsu);
      this.jdField_a_of_type_Adrm = new adrm(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Adrm);
      localTextView.setOnClickListener(new adrh(this));
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    removeObserver(this.jdField_a_of_type_Amsu);
    d();
    if (this.d) {
      amod.a().a();
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
    if (this.jdField_a_of_type_Adrm != null) {
      this.jdField_a_of_type_Adrm.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true)) {
      if ((this.jdField_b_of_type_Byte >= 0) && (this.jdField_b_of_type_Byte != this.jdField_a_of_type_Byte)) {
        if (NetworkUtil.isNetSupport(this))
        {
          ((FriendListHandler)this.app.getBusinessHandler(1)).moveFriendToGroup(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Byte, this.jdField_a_of_type_Byte);
          c();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QQToast.a(this.app.getApp(), getString(2131694105), 1).b(getTitleBarHeight());
      finish();
      continue;
      if (this.jdField_b_of_type_Byte == this.jdField_a_of_type_Byte) {
        QQToast.a(this, getString(2131693866), 0).b(getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */