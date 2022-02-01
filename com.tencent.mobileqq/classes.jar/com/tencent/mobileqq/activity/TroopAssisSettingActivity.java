package com.tencent.mobileqq.activity;

import Override;
import afbc;
import afbd;
import afbe;
import afbf;
import afbg;
import afbh;
import amkj;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import anvi;
import aoxz;
import awtz;
import bhhi;
import bkzi;
import bkzz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.XExpandableListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class TroopAssisSettingActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public amkj a;
  protected Handler a;
  protected CompoundButton.OnCheckedChangeListener a;
  protected anvi a;
  public bhhi a;
  protected XExpandableListView a;
  protected Runnable a;
  String a;
  public List<String> a;
  public Map<String, Integer> a;
  
  public TroopAssisSettingActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new TroopAssisSettingActivity.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new afbc(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new afbd(this);
    this.jdField_a_of_type_Anvi = new afbh(this);
  }
  
  private View a()
  {
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131558961, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2131559359, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addHeaderView((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).b();; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (localObject1 != null)
      {
        localObject2 = this.app.getProxyManager().a();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(localTroopInfo.troopuin);
          if (this.app.getTroopMask(localTroopInfo.troopuin) == 2) {
            localTroopInfo.lastMsgTime = this.app.getMessageFacade().getLastMessage(localTroopInfo.troopuin, 1).time;
          } else {
            localTroopInfo.lastMsgTime = ((RecentUser)((aoxz)localObject2).findRecentUserByUin(localTroopInfo.troopuin, 1)).lastmsgtime;
          }
        }
      }
      this.jdField_a_of_type_Amkj = new amkj(this, this.app, (List)localObject1, null);
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_Amkj);
      d();
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
      return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
    }
  }
  
  private View b()
  {
    View localView = View.inflate(this, 2131559358, null);
    localView.findViewById(2131377656).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131377655);
    ((Switch)localObject).setChecked(awtz.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131378503);
    if (awtz.a().d(this.app)) {
      awtz.a().g(this.app);
    }
    for (int i = 2131692969;; i = 2131692968)
    {
      ((TextView)localObject).setText(i);
      ((TextView)localObject).setFocusable(true);
      return localView;
    }
  }
  
  private void c()
  {
    if (this.app != null)
    {
      MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1009);
      }
      localMqqHandler = this.app.getHandler(TroopAssistantActivity.class);
      if (localMqqHandler != null) {
        localMqqHandler.sendEmptyMessage(1);
      }
    }
  }
  
  @TargetApi(8)
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setCacheColorHint(0);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnItemClickListener(null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new afbf(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new afbg(this));
  }
  
  void a()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.getUnreadMsgsNum();
        if (i <= 0) {
          break label112;
        }
        if (i <= 99) {
          break label68;
        }
        this.leftView.setText(getString(2131719161) + "(99+)");
      }
    }
    return;
    label68:
    this.leftView.setText(getString(2131719161) + "(" + i + ")");
    return;
    label112:
    this.leftView.setText(getString(2131719161));
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramTroopInfo != null)
    {
      localObject = (Boolean)this.jdField_a_of_type_Bhhi.c.get(paramTroopInfo.troopuin);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {}
    }
    else
    {
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(this, null);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    if (TextUtils.isEmpty(paramTroopInfo.getTroopName()))
    {
      localObject = paramTroopInfo.troopuin;
      localbkzi.a(getString(2131719206, new Object[] { localObject }));
      if (i != 1) {
        break label216;
      }
      bool1 = true;
      label114:
      localbkzi.a(2131697392, bool1);
      if (i != 4) {
        break label221;
      }
      bool1 = true;
      label130:
      localbkzi.a(2131697397, bool1);
      if (i != 2) {
        break label226;
      }
      bool1 = true;
      label146:
      localbkzi.a(2131697393, bool1);
      if (i != 3) {
        break label231;
      }
    }
    label216:
    label221:
    label226:
    label231:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbkzi.a(2131697389, bool1);
      localbkzi.d(getString(2131690697));
      localbkzi.a(new afbe(this, i, paramTroopInfo, localbkzi));
      localbkzi.show();
      return;
      localObject = paramTroopInfo.getTroopName();
      break;
      bool1 = false;
      break label114;
      bool1 = false;
      break label130;
      bool1 = false;
      break label146;
    }
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Amkj.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(i);
      i += 1;
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
    super.doOnCreate(paramBundle);
    super.setContentView(a());
    setContentBackgroundResource(2130838911);
    setTitle(2131692966);
    addObserver(this.jdField_a_of_type_Anvi);
    this.app.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      a();
    }
    this.jdField_a_of_type_Bhhi = ((bhhi)this.app.getManager(QQManagerFactory.MGR_TROOP_FILTER));
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
  }
  
  public void doOnPause()
  {
    c();
    super.doOnPause();
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_Anvi);
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new TroopAssisSettingActivity.8(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */