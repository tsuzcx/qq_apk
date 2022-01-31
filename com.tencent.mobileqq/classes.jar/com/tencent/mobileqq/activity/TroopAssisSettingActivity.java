package com.tencent.mobileqq.activity;

import acfs;
import acft;
import acfu;
import acfv;
import acfw;
import acfx;
import aiqd;
import ajxl;
import aktg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import asfb;
import bbix;
import bfol;
import bfoy;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
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
  public aiqd a;
  protected ajxl a;
  protected Handler a;
  protected CompoundButton.OnCheckedChangeListener a;
  public bbix a;
  protected XExpandableListView a;
  protected Runnable a;
  String a;
  public List<String> a;
  public Map<String, Integer> a;
  
  public TroopAssisSettingActivity()
  {
    this.jdField_a_of_type_JavaLangRunnable = new TroopAssisSettingActivity.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new acfs(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new acft(this);
    this.jdField_a_of_type_Ajxl = new acfx(this);
  }
  
  private View a()
  {
    Object localObject1 = b();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131558820, null);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView = ((XExpandableListView)View.inflate(this, 2131559179, null));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addHeaderView((View)localObject1);
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(52);
    if (localObject1 != null) {}
    for (localObject1 = ((TroopManager)localObject1).a();; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      if (localObject1 != null)
      {
        localObject2 = this.app.a().a();
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
          this.jdField_a_of_type_JavaUtilList.add(localTroopInfo.troopuin);
          if (this.app.b(localTroopInfo.troopuin) == 2) {
            localTroopInfo.lastMsgTime = this.app.a().a(localTroopInfo.troopuin, 1).time;
          } else {
            localTroopInfo.lastMsgTime = ((aktg)localObject2).a(localTroopInfo.troopuin, 1).lastmsgtime;
          }
        }
      }
      this.jdField_a_of_type_Aiqd = new aiqd(this, this.app, (List)localObject1, null);
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setAdapter(this.jdField_a_of_type_Aiqd);
      d();
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setFooterDividersEnabled(true);
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, true);
      return this.jdField_a_of_type_ComTencentWidgetXExpandableListView;
    }
  }
  
  private View b()
  {
    View localView = View.inflate(this, 2131559178, null);
    localView.findViewById(2131376103).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131376102);
    ((Switch)localObject).setChecked(asfb.a().a());
    ((Switch)localObject).setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    localObject = (TextView)localView.findViewById(2131376887);
    if (asfb.a().d(this.app)) {
      asfb.a().g(this.app);
    }
    for (int i = 2131693205;; i = 2131693204)
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
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnGroupClickListener(new acfv(this));
    this.jdField_a_of_type_ComTencentWidgetXExpandableListView.setOnChildClickListener(new acfw(this));
  }
  
  void a()
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
        this.leftView.setText(getString(2131720023) + "(99+)");
      }
    }
    return;
    label68:
    this.leftView.setText(getString(2131720023) + "(" + i + ")");
    return;
    label112:
    this.leftView.setText(getString(2131720023));
  }
  
  public void a(TroopInfo paramTroopInfo)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramTroopInfo != null)
    {
      localObject = (Boolean)this.jdField_a_of_type_Bbix.c.get(paramTroopInfo.troopuin);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {}
    }
    else
    {
      return;
    }
    bfol localbfol = (bfol)bfoy.a(this, null);
    int i = ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramTroopInfo.troopuin)).intValue();
    if (TextUtils.isEmpty(paramTroopInfo.getTroopName()))
    {
      localObject = paramTroopInfo.troopuin;
      localbfol.a(getString(2131720072, new Object[] { localObject }));
      if (i != 1) {
        break label216;
      }
      bool1 = true;
      label114:
      localbfol.a(2131697889, bool1);
      if (i != 4) {
        break label221;
      }
      bool1 = true;
      label130:
      localbfol.a(2131697894, bool1);
      if (i != 2) {
        break label226;
      }
      bool1 = true;
      label146:
      localbfol.a(2131697890, bool1);
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
      localbfol.a(2131697886, bool1);
      localbfol.d(getString(2131690596));
      localbfol.a(new acfu(this, i, paramTroopInfo, localbfol));
      localbfol.show();
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
    while (i < this.jdField_a_of_type_Aiqd.getGroupCount())
    {
      this.jdField_a_of_type_ComTencentWidgetXExpandableListView.a(i);
      i += 1;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(a());
    setContentBackgroundResource(2130838514);
    setTitle(2131693202);
    addObserver(this.jdField_a_of_type_Ajxl);
    this.app.a().addObserver(this);
    this.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("from");
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals("conversation"))) {
      a();
    }
    this.jdField_a_of_type_Bbix = ((bbix)this.app.getManager(31));
    return false;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.app != null) && (this.app.a() != null)) {
      this.app.a().deleteObserver(this);
    }
  }
  
  public void doOnPause()
  {
    c();
    super.doOnPause();
  }
  
  public void finish()
  {
    removeObserver(this.jdField_a_of_type_Ajxl);
    super.finish();
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