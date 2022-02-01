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
  protected XExpandableListView a;
  TroopMessageSettingAdapter b;
  Map<String, Integer> c;
  List<String> d;
  String e;
  protected IRoamSettingService f;
  protected Runnable g = new TroopAssisSettingActivity.1(this);
  protected Handler h = new TroopAssisSettingActivity.2(this, Looper.getMainLooper());
  protected CompoundButton.OnCheckedChangeListener i = new TroopAssisSettingActivity.3(this);
  protected RoamSettingObserver j = new TroopAssisSettingActivity.7(this);
  
  private View c()
  {
    Object localObject1 = d();
    Object localObject2 = getActivity().getLayoutInflater().inflate(2131624518, null);
    this.a = ((XExpandableListView)View.inflate(this, 2131625236, null));
    this.a.addHeaderView((View)localObject1);
    this.a.addFooterView((View)localObject2);
    localObject1 = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject1 != null) {
      localObject1 = ((TroopManager)localObject1).h();
    } else {
      localObject1 = null;
    }
    this.d = new ArrayList();
    if (localObject1 != null)
    {
      localObject2 = this.app.getProxyManager().g();
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        TroopInfo localTroopInfo = (TroopInfo)localIterator.next();
        this.d.add(localTroopInfo.troopuin);
        if (this.app.getTroopMask(localTroopInfo.troopuin) == 2) {
          localTroopInfo.lastMsgTime = this.app.getMessageFacade().getLastMessage(localTroopInfo.troopuin, 1).time;
        } else {
          localTroopInfo.lastMsgTime = ((RecentUserProxy)localObject2).b(localTroopInfo.troopuin, 1).lastmsgtime;
        }
      }
    }
    this.b = new TroopMessageSettingAdapter(this, this.app, (List)localObject1, null);
    this.a.setAdapter(this.b);
    f();
    this.a.setFooterDividersEnabled(true);
    ThreadManager.post(this.g, 8, null, true);
    return this.a;
  }
  
  private View d()
  {
    View localView = View.inflate(this, 2131625235, null);
    localView.findViewById(2131445897).setFocusable(true);
    Object localObject = (Switch)localView.findViewById(2131445896);
    ((Switch)localObject).setChecked(TroopAssistantManager.a().b());
    ((Switch)localObject).setOnCheckedChangeListener(this.i);
    localObject = (TextView)localView.findViewById(2131446843);
    int k;
    if (TroopAssistantManager.a().l(this.app))
    {
      TroopAssistantManager.a().m(this.app);
      k = 2131890188;
    }
    else
    {
      k = 2131890187;
    }
    ((TextView)localObject).setText(k);
    ((TextView)localObject).setFocusable(true);
    return localView;
  }
  
  private void e()
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
  private void f()
  {
    this.a.setDivider(null);
    this.a.setChildDivider(null);
    this.a.setCacheColorHint(0);
    this.a.setGroupIndicator(null);
    this.a.setOnItemClickListener(null);
    this.a.setOnGroupClickListener(new TroopAssisSettingActivity.5(this));
    this.a.setOnChildClickListener(new TroopAssisSettingActivity.6(this));
  }
  
  void a()
  {
    if (this.leftView != null)
    {
      Object localObject = this.app.getMessageFacade();
      if (localObject != null)
      {
        int k = ((QQMessageFacade)localObject).w();
        if (k > 0)
        {
          if (k > 99)
          {
            localObject = this.leftView;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getString(2131917002));
            localStringBuilder.append("(99+)");
            ((TextView)localObject).setText(localStringBuilder.toString());
            return;
          }
          localObject = this.leftView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(getString(2131917002));
          localStringBuilder.append("(");
          localStringBuilder.append(k);
          localStringBuilder.append(")");
          ((TextView)localObject).setText(localStringBuilder.toString());
          return;
        }
        this.leftView.setText(getString(2131917002));
      }
    }
  }
  
  void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      Object localObject = (Boolean)this.f.getMapRequest().get(paramTroopInfo.troopuin);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        return;
      }
      ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this, null);
      int k = ((Integer)this.c.get(paramTroopInfo.troopuin)).intValue();
      if (TextUtils.isEmpty(paramTroopInfo.getTroopDisplayName())) {
        localObject = paramTroopInfo.troopuin;
      } else {
        localObject = paramTroopInfo.getTroopDisplayName();
      }
      boolean bool2 = true;
      localActionSheet.setMainTitle(getString(2131917048, new Object[] { localObject }));
      boolean bool1;
      if (k == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131895425, bool1);
      if (k == 4) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131895430, bool1);
      if (k == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131895426, bool1);
      if (k == 3) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localActionSheet.addRadioButton(2131895422, bool1);
      localActionSheet.addCancelButton(getString(2131887648));
      localActionSheet.setOnButtonClickListener(new TroopAssisSettingActivity.4(this, k, paramTroopInfo, localActionSheet));
      localActionSheet.show();
    }
  }
  
  void b()
  {
    int k = 0;
    while (k < this.b.getGroupCount())
    {
      this.a.expandGroup(k);
      k += 1;
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
    super.setContentView(c());
    setContentBackgroundResource(2130838958);
    setTitle(2131890185);
    addObserver(this.j);
    this.app.getMessageFacade().addObserver(this);
    this.e = getIntent().getStringExtra("from");
    paramBundle = this.e;
    if ((paramBundle != null) && (paramBundle.equals("conversation"))) {
      a();
    }
    this.f = ((IRoamSettingService)this.app.getRuntimeService(IRoamSettingService.class, ""));
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.j);
    if ((this.app != null) && (this.app.getMessageFacade() != null)) {
      this.app.getMessageFacade().deleteObserver(this);
    }
  }
  
  protected void doOnPause()
  {
    e();
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