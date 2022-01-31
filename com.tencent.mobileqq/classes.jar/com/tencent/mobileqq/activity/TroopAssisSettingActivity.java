package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.RoamSettingController;
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
import tso;
import tsp;
import tsq;
import tsr;
import tss;
import tst;
import tsu;
import tsv;

public class TroopAssisSettingActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  public Handler a;
  protected CompoundButton.OnCheckedChangeListener a;
  public TroopMessageSettingAdapter a;
  protected FriendListObserver a;
  public RoamSettingController a;
  protected XExpandableListView a;
  protected Runnable a;
  public String a;
  public List a;
  public Map a;
  
  public TroopAssisSettingActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new tso(this);
    this.jdField_a_of_type_AndroidOsHandler = new tsp(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new tsq(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new tsu(this);
  }
  
  private View a()
  {
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2130968792, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2130969045, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setBackgroundColor(getResources().getColor(2131493351));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addHeaderView((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(51);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).a();; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (localObject1 != null)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Entity localEntity = (Entity)((Iterator)localObject2).next();
          this.jdField_a_of_type_JavaUtilList.add(((TroopInfo)localEntity).troopuin);
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
    View localView = View.inflate(this, 2130969044, null);
    localView.findViewById(2131364823).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131364824);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131364822);
    if (TroopAssistantManager.a().d(this.app)) {
      TroopAssistantManager.a().g(this.app);
    }
    for (int i = 2131435690;; i = 2131435689)
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
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new tss(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new tst(this));
  }
  
  public void a()
  {
    int i;
    if (this.leftView != null)
    {
      QQMessageFacade localQQMessageFacade = this.app.a();
      if (localQQMessageFacade != null)
      {
        i = localQQMessageFacade.b();
        if (i <= 0) {
          break label112;
        }
        if (i <= 99) {
          break label68;
        }
        this.leftView.setText(getString(2131433280) + "(99+)");
      }
    }
    return;
    label68:
    this.leftView.setText(getString(2131433280) + "(" + i + ")");
    return;
    label112:
    this.leftView.setText(getString(2131433280));
  }
  
  public void a(TroopInfo paramTroopInfo)
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
    if (TextUtils.isEmpty(paramTroopInfo.getTroopName()))
    {
      localObject = paramTroopInfo.troopuin;
      localActionSheet.a(getString(2131435693, new Object[] { localObject }));
      if (i != 1) {
        break label216;
      }
      bool1 = true;
      label114:
      localActionSheet.a(2131430229, bool1);
      if (i != 4) {
        break label221;
      }
      bool1 = true;
      label130:
      localActionSheet.a(2131430230, bool1);
      if (i != 2) {
        break label226;
      }
      bool1 = true;
      label146:
      localActionSheet.a(2131430231, bool1);
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
      localActionSheet.a(2131430232, bool1);
      localActionSheet.d(getString(2131432998));
      localActionSheet.a(new tsr(this, i, paramTroopInfo, localActionSheet));
      localActionSheet.show();
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
    while (i < this.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(i);
      i += 1;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(a());
    setContentBackgroundResource(2130838210);
    setTitle(2131435681);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.a().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      a();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsRoamSettingController = ((RoamSettingController)this.app.getManager(30));
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  protected void doOnPause()
  {
    c();
    super.doOnPause();
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    super.finish();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new tsv(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity
 * JD-Core Version:    0.7.0.1
 */