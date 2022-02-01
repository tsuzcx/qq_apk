package com.tencent.mobileqq.activity;

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
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
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
  protected Handler a;
  protected CompoundButton.OnCheckedChangeListener a;
  TroopMessageSettingAdapter jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter;
  protected FriendListObserver a;
  protected RoamSettingController a;
  protected XExpandableListView a;
  protected Runnable a;
  String jdField_a_of_type_JavaLangString;
  List<String> jdField_a_of_type_JavaUtilList;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  
  public TroopAssisSettingActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new TroopAssisSettingActivity.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new TroopAssisSettingActivity.2(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new TroopAssisSettingActivity.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopAssisSettingActivity.7(this);
  }
  
  private View a()
  {
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131559002, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2131559425, null));
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
            localTroopInfo.lastMsgTime = this.app.getMessageFacade().a(localTroopInfo.troopuin, 1).time;
          } else {
            localTroopInfo.lastMsgTime = ((RecentUserProxy)localObject2).a(localTroopInfo.troopuin, 1).lastmsgtime;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter = new TroopMessageSettingAdapter(this, this.app, (List)localObject1, null);
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter);
      d();
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
      return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
    }
  }
  
  private View b()
  {
    View localView = View.inflate(this, 2131559424, null);
    localView.findViewById(2131378067).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131378066);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131378934);
    if (TroopAssistantManager.a().d(this.app)) {
      TroopAssistantManager.a().g(this.app);
    }
    for (int i = 2131693114;; i = 2131693113)
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
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new TroopAssisSettingActivity.5(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new TroopAssisSettingActivity.6(this));
  }
  
  void a()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.getMessageFacade();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.b();
        if (i <= 0) {
          break label112;
        }
        if (i <= 99) {
          break label68;
        }
        this.leftView.setText(getString(2131719718) + "(99+)");
      }
    }
    return;
    label68:
    this.leftView.setText(getString(2131719718) + "(" + i + ")");
    return;
    label112:
    this.leftView.setText(getString(2131719718));
  }
  
  void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramTroopInfo != null)
    {
      localObject = (Boolean)this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController.c.get(paramTroopInfo.troopuin);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {}
    }
    else
    {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    if (TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName()))
    {
      localObject = paramTroopInfo.troopuin;
      localActionSheet.setMainTitle(getString(2131719761, new Object[] { localObject }));
      if (i != 1) {
        break label216;
      }
      bool1 = true;
      label114:
      localActionSheet.addRadioButton(2131697646, bool1);
      if (i != 4) {
        break label221;
      }
      bool1 = true;
      label130:
      localActionSheet.addRadioButton(2131697651, bool1);
      if (i != 2) {
        break label226;
      }
      bool1 = true;
      label146:
      localActionSheet.addRadioButton(2131697647, bool1);
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
      localActionSheet.addRadioButton(2131697643, bool1);
      localActionSheet.addCancelButton(getString(2131690800));
      localActionSheet.setOnButtonClickListener(new TroopAssisSettingActivity.4(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
      return;
      localObject = paramTroopInfo.getTroopDisplayName();
      break;
      bool1 = false;
      break label114;
      bool1 = false;
      break label130;
      bool1 = false;
      break label146;
    }
  }
  
  void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.expandGroup(i);
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
    setContentBackgroundResource(2130838979);
    setTitle(2131693111);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(QQManagerFactory.MGR_TROOP_FILTER));
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */