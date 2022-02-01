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
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
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
  protected RoamSettingObserver a;
  protected IRoamSettingService a;
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
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new TroopAssisSettingActivity.7(this);
  }
  
  private View a()
  {
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131558896, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2131559300, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addHeaderView((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject1 != null) {
      localObject1 = ((TroopManager)localObject1).b();
    } else {
      localObject1 = null;
    }
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
  
  private View b()
  {
    View localView = View.inflate(this, 2131559299, null);
    localView.findViewById(2131377495).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131377494);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131378321);
    int i;
    if (TroopAssistantManager.a().d(this.app))
    {
      TroopAssistantManager.a().g(this.app);
      i = 2131693074;
    }
    else
    {
      i = 2131693073;
    }
    ((TextView)localObject).setText(i);
    ((TextView)localObject).setFocusable(true);
    return localView;
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
    if (this.leftView != null)
    {
      Object localObject = this.app.getMessageFacade();
      if (localObject != null)
      {
        int i = ((QQMessageFacade)localObject).b();
        if (i > 0)
        {
          if (i > 99)
          {
            localObject = this.leftView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131719442));
            localStringBuilder.append("(99+)");
            ((TextView)localObject).setText(localStringBuilder.toString());
            return;
          }
          localObject = this.leftView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131719442));
          localStringBuilder.append("(");
          localStringBuilder.append(i);
          localStringBuilder.append(")");
          ((TextView)localObject).setText(localStringBuilder.toString());
          return;
        }
        this.leftView.setText(getString(2131719442));
      }
    }
  }
  
  void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      Object localObject = (Boolean)this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().get(paramTroopInfo.troopuin);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
      int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
      if (TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName())) {
        localObject = paramTroopInfo.troopuin;
      } else {
        localObject = paramTroopInfo.getTroopDisplayName();
      }
      boolean bool2 = true;
      localActionSheet.setMainTitle(getString(2131719485, new Object[] { localObject }));
      boolean bool1;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131697652, bool1);
      if (i == 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131697657, bool1);
      if (i == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131697653, bool1);
      if (i == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131697649, bool1);
      localActionSheet.addCancelButton(getString(2131690728));
      localActionSheet.setOnButtonClickListener(new TroopAssisSettingActivity.4(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(a());
    setContentBackgroundResource(2130838739);
    setTitle(2131693071);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.app.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    paramBundle = this.jdField_a_of_type_JavaLangString;
    if ((paramBundle != null) && (paramBundle.equals("conversation"))) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService = ((IRoamSettingService)this.app.getRuntimeService(IRoamSettingService.class, ""));
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
  }
  
  protected void doOnPause()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */