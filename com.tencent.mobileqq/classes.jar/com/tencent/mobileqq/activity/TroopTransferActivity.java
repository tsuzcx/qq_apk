package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;

public class TroopTransferActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener
{
  TroopMngObserver A = new TroopTransferActivity.5(this);
  TroopObserver B = new TroopTransferActivity.6(this);
  protected Integer C = Integer.valueOf(0);
  protected View a;
  protected TextView b;
  protected TextView c;
  protected TextView d;
  protected TextView e;
  protected LinearLayout f;
  protected XListView g;
  protected TroopTransferActivity.TroopMemberListAdapter h;
  protected Dialog i;
  protected EditText j;
  protected ImageButton k;
  protected View l;
  protected RelativeLayout m;
  protected XListView n;
  protected View o;
  protected List<TroopTransferActivity.TroopMemberItem> p = new ArrayList();
  protected TroopTransferActivity.SearchResultAdapter q;
  protected String r;
  protected String s;
  protected String t;
  protected long u;
  protected int v;
  protected boolean w;
  protected QQProgressNotifier x;
  AvatarObserver y = new TroopTransferActivity.3(this);
  FriendListObserver z = new TroopTransferActivity.4(this);
  
  private void d()
  {
    Object localObject = (ViewGroup)findViewById(2131444897);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131447484);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131436180);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void a()
  {
    try
    {
      long l1 = Long.parseLong(this.r);
      Long.parseLong(this.s);
      if (l1 <= 0L)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("troopuin = ");
          localStringBuilder.append(l1);
          localStringBuilder.append(" is illegal");
          QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
        }
        finish();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, localException.toString());
      }
      finish();
    }
  }
  
  protected void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem)
  {
    if (((this.u & 0x800) == 0L) && (this.v == 0)) {
      localObject = String.format(getString(2131917434), new Object[] { paramTroopMemberItem.d });
    } else {
      localObject = getString(2131888017, new Object[] { HardCodeUtil.a(2131913048), HardCodeUtil.a(2131913048) });
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    String str = paramTroopMemberItem.c;
    localQQCustomDialog.setTitle(2131917355);
    localQQCustomDialog.setMessage((CharSequence)localObject);
    localQQCustomDialog.setPositiveButton(getString(2131892267), new TroopTransferActivity.13(this, str, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131888185));
    localQQCustomDialog.setNegativeButton(getString(2131887648), new TroopTransferActivity.14(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131888184));
    localQQCustomDialog.show();
    Object localObject = this.app;
    if (paramTroopMemberItem.b == 1) {
      paramTroopMemberItem = "1";
    } else {
      paramTroopMemberItem = "0";
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramTroopMemberItem, "", "", "");
  }
  
  protected void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem, Friends paramFriends)
  {
    if (!c()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.17(this, paramFriends, paramTroopMemberItem), 5, null, true);
  }
  
  void a(String paramString)
  {
    this.p.clear();
    this.o.getLayoutParams().height = -1;
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.k.setVisibility(0);
      this.n.setVisibility(0);
      paramString = paramString.toLowerCase();
      List localList = this.h.a();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i1 = 0;
      while (i1 < localList.size())
      {
        TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)localList.get(i1);
        localTroopMemberItem.g = "";
        localTroopMemberItem.h = "";
        if ((!localTroopMemberItem.o.equals(paramString)) && (!localTroopMemberItem.q.equals(paramString)) && (!localTroopMemberItem.p.equals(paramString)))
        {
          if ((!localTroopMemberItem.l.equals(paramString)) && (!localTroopMemberItem.n.equals(paramString)) && (!localTroopMemberItem.m.equals(paramString)))
          {
            if ((!localTroopMemberItem.i.equals(paramString)) && (!localTroopMemberItem.k.equals(paramString)) && (!localTroopMemberItem.j.equals(paramString)))
            {
              if (localTroopMemberItem.c.equals(paramString))
              {
                localTroopMemberItem.g = localTroopMemberItem.c;
                localArrayList1.add(localTroopMemberItem);
              }
              else if ((localTroopMemberItem.o.indexOf(paramString) != 0) && (localTroopMemberItem.q.indexOf(paramString) != 0) && (localTroopMemberItem.p.indexOf(paramString) != 0))
              {
                if ((localTroopMemberItem.l.indexOf(paramString) != 0) && (localTroopMemberItem.n.indexOf(paramString) != 0) && (localTroopMemberItem.m.indexOf(paramString) != 0))
                {
                  if ((localTroopMemberItem.i.indexOf(paramString) != 0) && (localTroopMemberItem.k.indexOf(paramString) != 0) && (localTroopMemberItem.j.indexOf(paramString) != 0))
                  {
                    if (localTroopMemberItem.c.indexOf(paramString) == 0)
                    {
                      localTroopMemberItem.g = localTroopMemberItem.c;
                      localTroopMemberItem.h = localTroopMemberItem.c;
                      localArrayList2.add(localTroopMemberItem);
                    }
                    else if ((localTroopMemberItem.o.indexOf(paramString) <= 0) && (localTroopMemberItem.q.indexOf(paramString) <= 0) && (localTroopMemberItem.p.indexOf(paramString) <= 0))
                    {
                      if ((localTroopMemberItem.l.indexOf(paramString) <= 0) && (localTroopMemberItem.n.indexOf(paramString) <= 0) && (localTroopMemberItem.m.indexOf(paramString) <= 0))
                      {
                        if ((localTroopMemberItem.i.indexOf(paramString) <= 0) && (localTroopMemberItem.k.indexOf(paramString) <= 0) && (localTroopMemberItem.j.indexOf(paramString) <= 0))
                        {
                          if (localTroopMemberItem.c.indexOf(paramString) > 0)
                          {
                            localTroopMemberItem.g = localTroopMemberItem.c;
                            localArrayList3.add(localTroopMemberItem);
                          }
                        }
                        else
                        {
                          localTroopMemberItem.g = localTroopMemberItem.i;
                          localArrayList3.add(localTroopMemberItem);
                        }
                      }
                      else
                      {
                        localTroopMemberItem.g = localTroopMemberItem.l;
                        localArrayList3.add(localTroopMemberItem);
                      }
                    }
                    else
                    {
                      localTroopMemberItem.g = localTroopMemberItem.o;
                      localArrayList3.add(localTroopMemberItem);
                    }
                  }
                  else
                  {
                    localTroopMemberItem.g = localTroopMemberItem.i;
                    localTroopMemberItem.h = localTroopMemberItem.j;
                    localArrayList2.add(localTroopMemberItem);
                  }
                }
                else
                {
                  localTroopMemberItem.g = localTroopMemberItem.l;
                  localTroopMemberItem.h = localTroopMemberItem.m;
                  localArrayList2.add(localTroopMemberItem);
                }
              }
              else
              {
                localTroopMemberItem.g = localTroopMemberItem.o;
                localTroopMemberItem.h = localTroopMemberItem.p;
                localArrayList2.add(localTroopMemberItem);
              }
            }
            else
            {
              localTroopMemberItem.g = localTroopMemberItem.i;
              localArrayList1.add(localTroopMemberItem);
            }
          }
          else
          {
            localTroopMemberItem.g = localTroopMemberItem.l;
            localArrayList1.add(localTroopMemberItem);
          }
        }
        else
        {
          localTroopMemberItem.g = localTroopMemberItem.o;
          localArrayList1.add(localTroopMemberItem);
        }
        i1 += 1;
      }
      Collections.sort(localArrayList2, new TroopTransferActivity.SearchResultComparator(this, null));
      this.p.addAll(localArrayList1);
      this.p.addAll(localArrayList2);
      this.p.addAll(localArrayList3);
      if (this.p.isEmpty()) {
        this.l.setVisibility(0);
      } else {
        this.l.setVisibility(8);
      }
      this.q.notifyDataSetChanged();
      return;
    }
    this.k.setVisibility(8);
    this.n.setVisibility(8);
    this.l.setVisibility(8);
    this.q.notifyDataSetChanged();
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.f = ((LinearLayout)findViewById(2131448113));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.f.setFitsSystemWindows(true);
    }
    this.a = findViewById(2131447484);
    this.c = ((TextView)findViewById(2131436227));
    this.d = ((TextView)findViewById(2131436180));
    this.e = ((TextView)findViewById(2131436182));
    this.e.setVisibility(4);
    this.b = ((TextView)findViewById(2131436211));
    this.b.setVisibility(4);
    this.g = ((XListView)findViewById(2131431170));
    this.c.setText(2131893985);
    this.d.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131887625);
    }
    this.d.setText((CharSequence)localObject);
    this.d.setOnClickListener(new TroopTransferActivity.1(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131629215, this.g, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131429816)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131432634)).setOnTouchListener(new TroopTransferActivity.2(this));
    this.g.addHeaderView((View)localObject);
    this.h = new TroopTransferActivity.TroopMemberListAdapter(this, this, paramArrayList);
    this.g.setAdapter(this.h);
    this.g.setOnItemClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new TroopTransferActivity.15(this));
    }
    synchronized (this.C)
    {
      Integer localInteger = this.C;
      this.C = Integer.valueOf(this.C.intValue() - 1);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("finUpdateThread|[");
        ((StringBuilder)???).append(this.C);
        ((StringBuilder)???).append(", needUpdateUI = ");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append("]");
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  protected void b()
  {
    int i1 = getTitleBarHeight();
    float f1 = -i1;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    Object localObject2 = new TroopTransferActivity.7(this, localTranslateAnimation, (TranslateAnimation)localObject1, i1);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
    localTranslateAnimation.setFillAfter(true);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setAnimationListener((Animation.AnimationListener)localObject2);
    if (this.i == null)
    {
      this.i = new ReportDialog(this);
      this.i.setCanceledOnTouchOutside(true);
      this.i.requestWindowFeature(1);
      this.i.getWindow().setSoftInputMode(36);
      this.i.setContentView(2131629224);
      localObject2 = this.i.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.i.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.i.setOnDismissListener(new TroopTransferActivity.8(this, i1, (TranslateAnimation)localObject1));
      this.o = this.i.findViewById(2131445137);
      this.j = ((EditText)this.i.findViewById(2131432634));
      this.j.addTextChangedListener(new TroopTransferActivity.SearchTextWatcher(this, null));
      this.j.setSelection(0);
      this.j.requestFocus();
      this.k = ((ImageButton)this.i.findViewById(2131435215));
      this.k.setOnClickListener(new TroopTransferActivity.9(this));
      localObject1 = (Button)this.i.findViewById(2131429816);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new TroopTransferActivity.10(this));
      this.l = this.i.findViewById(2131439366);
      this.m = ((RelativeLayout)this.i.findViewById(2131444724));
      this.m.setOnClickListener(new TroopTransferActivity.11(this));
      this.n = ((XListView)this.i.findViewById(2131445380));
      this.n.setBackgroundResource(2130838958);
      this.n.setDividerHeight(0);
      this.p.clear();
      this.q = new TroopTransferActivity.SearchResultAdapter(this, this.p);
      this.n.setAdapter(this.q);
      this.n.setOnTouchListener(new TroopTransferActivity.12(this));
      this.n.setOnItemClickListener(this);
    }
    this.f.startAnimation(localTranslateAnimation);
  }
  
  protected void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if (localTroopMemberCardInfo != null)
    {
      if (!Utils.a(localTroopMemberCardInfo.troopuin, this.r)) {
        return;
      }
      if (!c()) {
        return;
      }
      ThreadManager.post(new TroopTransferActivity.16(this, paramArrayList), 5, null, true);
    }
  }
  
  protected boolean c()
  {
    if (this.C.intValue() >= 2)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("too many update thread|total = ");
        ((StringBuilder)???).append(this.C);
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)???).toString());
      }
      return false;
    }
    synchronized (this.C)
    {
      Object localObject2 = this.C;
      this.C = Integer.valueOf(this.C.intValue() + 1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("add update thread |nTotalThreadCount = ");
        ((StringBuilder)localObject2).append(this.C);
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)localObject2).toString());
      }
      return true;
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
    this.w = false;
    paramBundle = getIntent().getExtras();
    this.r = paramBundle.getString("troop_uin");
    this.s = paramBundle.getString("troop_code");
    this.t = paramBundle.getString("uinname");
    this.u = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
    this.v = paramBundle.getInt("troop_auth_submit_time");
    paramBundle = paramBundle.getStringArrayList("troopVipMembers");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate");
      localStringBuilder.append("| mTroopUin = ");
      localStringBuilder.append(this.r);
      localStringBuilder.append("| mTroopCode = ");
      localStringBuilder.append(this.s);
      localStringBuilder.append("| mTroopName = ");
      localStringBuilder.append(this.t);
      localStringBuilder.append("| mVipMemberList");
      localStringBuilder.append(paramBundle);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    a();
    super.setContentView(2131627899);
    a(paramBundle);
    this.app.addObserver(this.B);
    this.app.addObserver(this.A);
    this.app.addObserver(this.z);
    this.app.addObserver(this.y);
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.B);
    this.app.removeObserver(this.A);
    this.app.removeObserver(this.z);
    this.app.removeObserver(this.y);
    Object localObject = this.x;
    if (localObject != null)
    {
      ((QQProgressNotifier)localObject).b();
      this.x = null;
    }
    localObject = this.h;
    if (localObject != null) {
      ((TroopTransferActivity.TroopMemberListAdapter)localObject).c();
    }
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.w) {
      return;
    }
    paramAdapterView = (TroopTransferActivity.ViewHolder)paramView.getTag();
    if (paramAdapterView != null) {
      paramAdapterView = paramAdapterView.a;
    } else {
      paramAdapterView = null;
    }
    if ((paramAdapterView != null) && (paramAdapterView.a == 1)) {
      a(paramAdapterView);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */