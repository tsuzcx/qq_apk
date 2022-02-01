package com.tencent.mobileqq.activity;

import Override;
import afpe;
import afpf;
import afpg;
import afph;
import afpi;
import afpj;
import afpk;
import afpn;
import afpo;
import afpp;
import afpq;
import afpr;
import afps;
import afpt;
import afpu;
import afpv;
import afpw;
import afpx;
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
import anmu;
import anni;
import anxg;
import bcst;
import bgjw;
import bglp;
import bgpa;
import biax;
import bkij;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TroopTransferActivity
  extends BaseActivity
  implements bkij
{
  protected int a;
  protected long a;
  protected afps a;
  public afpw a;
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  anmu jdField_a_of_type_Anmu = new afpj(this);
  anxg jdField_a_of_type_Anxg = new afpk(this);
  public biax a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<afpv> a;
  public boolean a;
  protected View b;
  protected TextView b;
  public XListView b;
  protected String b;
  protected View c;
  protected TextView c;
  protected String c;
  protected TextView d;
  
  public TroopTransferActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
  }
  
  private void c()
  {
    Object localObject = (ViewGroup)findViewById(2131376599);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131378796);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368947);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      Long.parseLong(this.jdField_b_of_type_JavaLangString);
      if (l <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.transfer", 2, "troopuin = " + l + " is illegal");
        }
        finish();
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, localException.toString());
      }
      finish();
    }
  }
  
  protected void a(afpv paramafpv)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131690919, new Object[] { anni.a(2131714469), anni.a(2131714469) });
      bgpa localbgpa = bglp.a(this, 230);
      String str = paramafpv.jdField_a_of_type_JavaLangString;
      localbgpa.setTitle(2131718666);
      localbgpa.setMessage((CharSequence)localObject);
      localbgpa.setPositiveButton(getString(2131694081), new afpg(this, str, localbgpa));
      localbgpa.setPositiveButtonContentDescription(getString(2131691086));
      localbgpa.setNegativeButton(getString(2131690582), new afph(this, localbgpa));
      localbgpa.setNegativeButtonContentDescription(getString(2131691085));
      localbgpa.show();
      localObject = this.app;
      if (paramafpv.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramafpv = "1";; paramafpv = "0")
    {
      bcst.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramafpv, "", "", "");
      return;
      localObject = String.format(getString(2131718732), new Object[] { paramafpv.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(afpv paramafpv, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramafpv), 5, null, true);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Afps.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Afpw.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      afpv localafpv = (afpv)localList.get(i);
      localafpv.e = "";
      localafpv.f = "";
      if ((localafpv.m.equals(paramString)) || (localafpv.o.equals(paramString)) || (localafpv.n.equals(paramString)))
      {
        localafpv.e = localafpv.m;
        localArrayList1.add(localafpv);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localafpv.j.equals(paramString)) || (localafpv.l.equals(paramString)) || (localafpv.k.equals(paramString)))
        {
          localafpv.e = localafpv.j;
          localArrayList1.add(localafpv);
        }
        else if ((localafpv.g.equals(paramString)) || (localafpv.i.equals(paramString)) || (localafpv.h.equals(paramString)))
        {
          localafpv.e = localafpv.g;
          localArrayList1.add(localafpv);
        }
        else if (localafpv.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localafpv.e = localafpv.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localafpv);
        }
        else if ((localafpv.m.indexOf(paramString) == 0) || (localafpv.o.indexOf(paramString) == 0) || (localafpv.n.indexOf(paramString) == 0))
        {
          localafpv.e = localafpv.m;
          localafpv.f = localafpv.n;
          localArrayList2.add(localafpv);
        }
        else if ((localafpv.j.indexOf(paramString) == 0) || (localafpv.l.indexOf(paramString) == 0) || (localafpv.k.indexOf(paramString) == 0))
        {
          localafpv.e = localafpv.j;
          localafpv.f = localafpv.k;
          localArrayList2.add(localafpv);
        }
        else if ((localafpv.g.indexOf(paramString) == 0) || (localafpv.i.indexOf(paramString) == 0) || (localafpv.h.indexOf(paramString) == 0))
        {
          localafpv.e = localafpv.g;
          localafpv.f = localafpv.h;
          localArrayList2.add(localafpv);
        }
        else if (localafpv.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localafpv.e = localafpv.jdField_a_of_type_JavaLangString;
          localafpv.f = localafpv.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localafpv);
        }
        else if ((localafpv.m.indexOf(paramString) > 0) || (localafpv.o.indexOf(paramString) > 0) || (localafpv.n.indexOf(paramString) > 0))
        {
          localafpv.e = localafpv.m;
          localArrayList3.add(localafpv);
        }
        else if ((localafpv.j.indexOf(paramString) > 0) || (localafpv.l.indexOf(paramString) > 0) || (localafpv.k.indexOf(paramString) > 0))
        {
          localafpv.e = localafpv.j;
          localArrayList3.add(localafpv);
        }
        else if ((localafpv.g.indexOf(paramString) > 0) || (localafpv.i.indexOf(paramString) > 0) || (localafpv.h.indexOf(paramString) > 0))
        {
          localafpv.e = localafpv.g;
          localArrayList3.add(localafpv);
        }
        else if (localafpv.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localafpv.e = localafpv.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localafpv);
        }
      }
    }
    Collections.sort(localArrayList2, new afpt(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afps.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379365));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378796);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368994));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368947));
    this.d = ((TextView)findViewById(2131368949));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368979));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364860));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695518);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690563);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new afpe(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562820, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363719)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131366102)).setOnTouchListener(new afpi(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Afpw = new afpw(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afpw);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new TroopTransferActivity.13(this));
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Integer localInteger2 = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() - 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "finUpdateThread|[" + this.jdField_a_of_type_JavaLangInteger + ", needUpdateUI = " + paramBoolean + "]");
      }
      return;
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_JavaLangInteger.intValue() >= 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "too many update thread|total = " + this.jdField_a_of_type_JavaLangInteger);
      }
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Integer localInteger2 = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() + 1);
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopdisband.transfer", 2, "add update thread |nTotalThreadCount = " + this.jdField_a_of_type_JavaLangInteger);
      }
      return true;
    }
  }
  
  public void b()
  {
    int i = getTitleBarHeight();
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    Object localObject2 = new afpn(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
    localTranslateAnimation.setFillAfter(true);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setAnimationListener((Animation.AnimationListener)localObject2);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562829);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new afpo(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376788);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366102));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new afpu(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368135));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new afpp(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363719);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new afpq(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371769);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376449));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new afpr(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376990));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838758);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Afps = new afps(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afps);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new afpf(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bgjw.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
    while (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.14(this, paramArrayList), 5, null, true);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troop_uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("troop_code");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("uinname");
    this.jdField_a_of_type_Long = paramBundle.getLong("TROOP_INFO_FLAG_EXT");
    this.jdField_a_of_type_Int = paramBundle.getInt("troop_auth_submit_time");
    paramBundle = paramBundle.getStringArrayList("troopVipMembers");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate").append("| mTroopUin = ").append(this.jdField_a_of_type_JavaLangString).append("| mTroopCode = ").append(this.jdField_b_of_type_JavaLangString).append("| mTroopName = ").append(this.jdField_c_of_type_JavaLangString).append("| mVipMemberList").append(paramBundle);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    a();
    super.setContentView(2131561595);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Anxg);
    this.app.addObserver(this.jdField_a_of_type_Anmu);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Anxg);
    this.app.removeObserver(this.jdField_a_of_type_Anmu);
    if (this.jdField_a_of_type_Biax != null)
    {
      this.jdField_a_of_type_Biax.b();
      this.jdField_a_of_type_Biax = null;
    }
    if (this.jdField_a_of_type_Afpw != null) {
      this.jdField_a_of_type_Afpw.c();
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
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (afpx)paramView.getTag();
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.a; (paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_Int == 1); paramAdapterView = null)
      {
        a(paramAdapterView);
        return;
      }
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */