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
  private QQProgressDialog a;
  private XListView b;
  private MoveToGroupActivity.ListAdapter c = null;
  private String d;
  private byte e;
  private byte f;
  private QQCustomDialogWtihInput g;
  private Dialog h;
  private View i;
  private View j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private List<Groups> o = null;
  private boolean p = false;
  private FriendListObserver q = new MoveToGroupActivity.1(this);
  private DialogInterface.OnClickListener r = new MoveToGroupActivity.4(this);
  @SuppressLint({"HandlerLeak"})
  private Handler s = new MoveToGroupActivity.5(this);
  
  private void b()
  {
    GroupManagerInputTextWatcher localGroupManagerInputTextWatcher = new GroupManagerInputTextWatcher();
    this.j.setOnClickListener(new MoveToGroupActivity.3(this, localGroupManagerInputTextWatcher));
  }
  
  private void c()
  {
    QQProgressDialog localQQProgressDialog = new QQProgressDialog(this);
    this.a = localQQProgressDialog;
    localQQProgressDialog.b(getTitleBarHeight());
    localQQProgressDialog.show();
  }
  
  private void d()
  {
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.a.dismiss();
      this.a = null;
    }
  }
  
  private void e()
  {
    Intent localIntent = getIntent();
    localIntent.putExtra("result", this.f);
    Groups localGroups = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).u(String.valueOf(this.f));
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
    this.o.clear();
    Object localObject = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null) {
      this.o = ((FriendsManager)localObject).k();
    }
    localObject = this.c;
    if (localObject == null)
    {
      this.c = new MoveToGroupActivity.ListAdapter(this, null);
      this.b.setAdapter(this.c);
    }
    else
    {
      ((MoveToGroupActivity.ListAdapter)localObject).notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("End Refresh size = ");
      ((StringBuilder)localObject).append(this.o.size());
      QLog.d("MoveToGroupActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "showWaitingDialog");
    }
    a(false);
    Object localObject = this.h;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MoveToGroupActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    localObject = new QQProgressDialog(this, this.n);
    ((QQProgressDialog)localObject).c(paramInt);
    this.h = ((Dialog)localObject);
    this.h.setOnDismissListener(new MoveToGroupActivity.6(this));
    this.h.show();
    this.k = false;
    this.m = false;
    localObject = this.s.obtainMessage(0);
    this.s.sendMessageDelayed((Message)localObject, 500L);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissWaitingDialog delayPassed = ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("MoveToGroupActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.m)
    {
      localObject = this.h;
      if (localObject != null)
      {
        if (((Dialog)localObject).isShowing()) {
          this.h.dismiss();
        }
        this.h = null;
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
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show();
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
    super.setContentView(2131625461);
    setTitle(getString(2131891864));
    TextView localTextView = (TextView)findViewById(2131436180);
    localTextView.setContentDescription(HardCodeUtil.a(2131904781));
    this.d = getIntent().getExtras().getString("friendUin");
    this.p = getIntent().getExtras().getBoolean("key_from_babyq_web_plugin", false);
    this.e = getIntent().getExtras().getByte("mgid", (byte)0).byteValue();
    if (this.e == 0)
    {
      paramBundle = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.m(this.d);
      }
      if ((paramBundle != null) && (paramBundle.isFriend())) {
        this.e = ((byte)paramBundle.groupid);
      }
    }
    this.f = this.e;
    this.o = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).k();
    this.b = ((XListView)findViewById(2131438897));
    this.n = getResources().getDimensionPixelSize(2131299920);
    this.b.setVerticalScrollBarEnabled(false);
    this.i = getLayoutInflater().inflate(2131624965, null);
    this.b.addHeaderView(this.i);
    this.j = this.i.findViewById(2131434431);
    b();
    addObserver(this.q);
    this.c = new MoveToGroupActivity.ListAdapter(this, null);
    this.b.setAdapter(this.c);
    localTextView.setOnClickListener(new MoveToGroupActivity.2(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.s.removeMessages(0);
    removeObserver(this.q);
    d();
    if (this.p) {
      BabyQIPCModule.a().d();
    }
  }
  
  protected boolean onBackEvent()
  {
    e();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = ((Integer)paramView.getTag()).intValue();
    this.f = ((byte)((Groups)this.o.get(i1)).group_id);
    MoveToGroupActivity.ListAdapter localListAdapter = this.c;
    if (localListAdapter != null) {
      localListAdapter.notifyDataSetChanged();
    }
    if (getIntent().getBooleanExtra("PARAM_EXECUTE_IMMEDIATELY", true))
    {
      i1 = this.f;
      if ((i1 >= 0) && (i1 != this.e))
      {
        if (NetworkUtil.isNetSupport(this))
        {
          ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).moveFriendToGroup(this.d, this.f, this.e);
          c();
          break label186;
        }
        QQToast.makeText(this.app.getApp(), getString(2131892155), 1).show(getTitleBarHeight());
        finish();
        break label186;
      }
      if (this.f == this.e) {
        QQToast.makeText(this, getString(2131891862), 0).show(getTitleBarHeight());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity
 * JD-Core Version:    0.7.0.1
 */