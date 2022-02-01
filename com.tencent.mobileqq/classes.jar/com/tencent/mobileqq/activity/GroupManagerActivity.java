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
  List<Groups> a;
  byte[] b = null;
  byte[] c = null;
  private DragSortListView d;
  private GroupEditeDragSortAdapter<Groups> e;
  private Dialog f;
  private Dialog g;
  private int h;
  private int i;
  private Groups j;
  private QQCustomDialogWtihInput k;
  private DialogInterface.OnClickListener l = new GroupManagerActivity.5(this);
  private DialogInterface.OnClickListener m = new GroupManagerActivity.6(this);
  private DragSortListView.DropListener n = new GroupManagerActivity.7(this);
  private DragSortListView.RemoveListener o = new GroupManagerActivity.8(this);
  private boolean p;
  private boolean q;
  private boolean r;
  @SuppressLint({"HandlerLeak"})
  private Handler s = new GroupManagerActivity.11(this);
  private FriendListObserver t = new GroupManagerActivity.13(this);
  
  public static void a(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, GroupManagerActivity.class));
    paramActivity.overridePendingTransition(2130771996, 2130771997);
  }
  
  private void b(byte paramByte)
  {
    c();
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
    localActionSheet.setMainTitle(2131890209);
    localActionSheet.addButton(2131890202, 3);
    localActionSheet.addCancelButton(2131890204);
    localActionSheet.setOnDismissListener(new GroupManagerActivity.9(this));
    localActionSheet.setOnButtonClickListener(new GroupManagerActivity.10(this, paramByte));
    this.f = localActionSheet;
    this.f.show();
  }
  
  private void d()
  {
    this.leftView.setVisibility(8);
    setRightButton(2131890206, new GroupManagerActivity.1(this));
    setTitle(2131890205);
  }
  
  private void e()
  {
    this.d = ((DragSortListView)findViewById(16908298));
    Object localObject = a(this.d);
    this.d.setFloatViewManager((DragSortListView.FloatViewManager)localObject);
    this.d.setOnTouchListener((View.OnTouchListener)localObject);
    this.d.setDropListener(this.n);
    this.d.setRemoveListener(this.o);
    localObject = new GroupManagerInputTextWatcher();
    this.d.setOnItemClickListener(new GroupManagerActivity.2(this, (GroupManagerInputTextWatcher)localObject));
    this.d.setLeftEventListener(new GroupManagerActivity.3(this));
    this.d.setVerticalScrollBarEnabled(false);
    View localView = getLayoutInflater().inflate(2131624965, null);
    this.d.addHeaderView(localView);
    localView.findViewById(2131434431).setOnClickListener(new GroupManagerActivity.4(this, (GroupManagerInputTextWatcher)localObject));
    localObject = new View(getActivity());
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, (int)(getResources().getDisplayMetrics().density * 10.0F)));
    this.d.addFooterView((View)localObject);
  }
  
  public DragSortController a(DragSortListView paramDragSortListView)
  {
    paramDragSortListView = new DragSortController(paramDragSortListView);
    paramDragSortListView.d(2131432152);
    paramDragSortListView.e(2131430779);
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
    this.a.clear();
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((FriendsManager)localObject2).k();
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Groups)((Iterator)localObject1).next();
        this.a.add(localObject2);
      }
    }
    localObject1 = this.e;
    if (localObject1 == null)
    {
      this.e = new GroupEditeDragSortAdapter(this, this.a, this.d);
      this.d.setAdapter(this.e);
    }
    else
    {
      ((GroupEditeDragSortAdapter)localObject1).notifyDataSetChanged();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("End Refresh************************ size = ");
      ((StringBuilder)localObject1).append(this.a.size());
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject1).toString());
      int i1 = 0;
      localObject1 = "[";
      while (i1 < this.a.size())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append((byte)((Groups)this.a.get(i1)).group_id);
        ((StringBuilder)localObject2).append("   ");
        localObject1 = ((StringBuilder)localObject2).toString();
        i1 += 1;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("]");
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("End Refresh************************ s = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "showWaitingDialog");
    }
    a(false);
    Object localObject = this.g;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GroupManagerActivity", 2, "WatingDialog is showing already!");
      }
      return;
    }
    localObject = new QQProgressDialog(this, this.h);
    ((QQProgressDialog)localObject).c(paramInt);
    this.g = ((Dialog)localObject);
    this.g.setOnDismissListener(new GroupManagerActivity.12(this));
    this.g.show();
    this.q = false;
    this.r = false;
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
      ((StringBuilder)localObject).append(this.r);
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.r)
    {
      localObject = this.g;
      if (localObject != null)
      {
        if (((Dialog)localObject).isShowing()) {
          this.g.dismiss();
        }
        this.g = null;
        if (paramBoolean) {
          a();
        }
      }
    }
  }
  
  public boolean a(byte paramByte)
  {
    boolean bool2 = NetworkUtil.isNetSupport(getApplication());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.deleteFriendGroup(paramByte);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(byte paramByte, String paramString)
  {
    boolean bool2 = NetworkUtil.isNetSupport(getApplication());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.addFriendGroup(paramByte, paramString);
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = NetworkUtil.isNetSupport(getApplication());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.resortFriendGroup(paramArrayOfByte1, paramArrayOfByte2);
      bool1 = true;
    }
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollToBottom:");
      localStringBuilder.append(this.a.size());
      QLog.d("GroupManagerActivity", 2, localStringBuilder.toString());
    }
    this.d.smoothScrollToPosition(this.a.size());
  }
  
  public boolean b(byte paramByte, String paramString)
  {
    boolean bool2 = NetworkUtil.isNetSupport(getApplication());
    boolean bool1 = false;
    if (!bool2)
    {
      QQToast.makeText(BaseApplicationImpl.sApplication, 2131892102, 0).show();
      return false;
    }
    FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    if (localFriendListHandler != null)
    {
      localFriendListHandler.renameFriendGroup(paramByte, paramString);
      bool1 = true;
    }
    return bool1;
  }
  
  void c()
  {
    Dialog localDialog = this.f;
    if (localDialog != null)
    {
      if (localDialog.isShowing()) {
        this.f.dismiss();
      }
      this.f = null;
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onCreate");
    }
    super.doOnCreate(paramBundle);
    this.h = getResources().getDimensionPixelSize(2131299920);
    super.setContentView(2131627458);
    d();
    e();
    this.app.addObserver(this.t);
    this.a = new ArrayList();
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onDestroy");
    }
    super.doOnDestroy();
    this.s.removeMessages(0);
    this.app.removeObserver(this.t);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771994, 2130771995);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (456 == paramMessage.what) {
      a();
    } else if (457 == paramMessage.what) {
      b();
    }
    return false;
  }
  
  protected boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    overridePendingTransition(2130771994, 2130771995);
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