package com.tencent.mobileqq.activity;

import Override;
import afin;
import afio;
import afip;
import afiq;
import afir;
import afis;
import afit;
import afiw;
import afix;
import afiy;
import afiz;
import afja;
import afjb;
import afjc;
import afjd;
import afje;
import afjf;
import afjg;
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
import anvi;
import anvx;
import aofu;
import bdla;
import bhbx;
import bhdj;
import biso;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
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

public class TroopTransferActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener
{
  protected int a;
  protected long a;
  protected afjb a;
  public afjf a;
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  anvi jdField_a_of_type_Anvi = new afis(this);
  aofu jdField_a_of_type_Aofu = new afit(this);
  public biso a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<afje> a;
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
    Object localObject = (ViewGroup)findViewById(2131376760);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131379020);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369231);
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
  
  protected void a(afje paramafje)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131691044, new Object[] { anvx.a(2131715158), anvx.a(2131715158) });
      QQCustomDialog localQQCustomDialog = bhdj.a(this, 230);
      String str = paramafje.jdField_a_of_type_JavaLangString;
      localQQCustomDialog.setTitle(2131719456);
      localQQCustomDialog.setMessage((CharSequence)localObject);
      localQQCustomDialog.setPositiveButton(getString(2131694399), new afip(this, str, localQQCustomDialog));
      localQQCustomDialog.setPositiveButtonContentDescription(getString(2131691211));
      localQQCustomDialog.setNegativeButton(getString(2131690697), new afiq(this, localQQCustomDialog));
      localQQCustomDialog.setNegativeButtonContentDescription(getString(2131691210));
      localQQCustomDialog.show();
      localObject = this.app;
      if (paramafje.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramafje = "1";; paramafje = "0")
    {
      bdla.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramafje, "", "", "");
      return;
      localObject = String.format(getString(2131719533), new Object[] { paramafje.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(afje paramafje, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramafje), 5, null, true);
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
      this.jdField_a_of_type_Afjb.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Afjf.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      afje localafje = (afje)localList.get(i);
      localafje.e = "";
      localafje.f = "";
      if ((localafje.m.equals(paramString)) || (localafje.o.equals(paramString)) || (localafje.n.equals(paramString)))
      {
        localafje.e = localafje.m;
        localArrayList1.add(localafje);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localafje.j.equals(paramString)) || (localafje.l.equals(paramString)) || (localafje.k.equals(paramString)))
        {
          localafje.e = localafje.j;
          localArrayList1.add(localafje);
        }
        else if ((localafje.g.equals(paramString)) || (localafje.i.equals(paramString)) || (localafje.h.equals(paramString)))
        {
          localafje.e = localafje.g;
          localArrayList1.add(localafje);
        }
        else if (localafje.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localafje.e = localafje.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localafje);
        }
        else if ((localafje.m.indexOf(paramString) == 0) || (localafje.o.indexOf(paramString) == 0) || (localafje.n.indexOf(paramString) == 0))
        {
          localafje.e = localafje.m;
          localafje.f = localafje.n;
          localArrayList2.add(localafje);
        }
        else if ((localafje.j.indexOf(paramString) == 0) || (localafje.l.indexOf(paramString) == 0) || (localafje.k.indexOf(paramString) == 0))
        {
          localafje.e = localafje.j;
          localafje.f = localafje.k;
          localArrayList2.add(localafje);
        }
        else if ((localafje.g.indexOf(paramString) == 0) || (localafje.i.indexOf(paramString) == 0) || (localafje.h.indexOf(paramString) == 0))
        {
          localafje.e = localafje.g;
          localafje.f = localafje.h;
          localArrayList2.add(localafje);
        }
        else if (localafje.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localafje.e = localafje.jdField_a_of_type_JavaLangString;
          localafje.f = localafje.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localafje);
        }
        else if ((localafje.m.indexOf(paramString) > 0) || (localafje.o.indexOf(paramString) > 0) || (localafje.n.indexOf(paramString) > 0))
        {
          localafje.e = localafje.m;
          localArrayList3.add(localafje);
        }
        else if ((localafje.j.indexOf(paramString) > 0) || (localafje.l.indexOf(paramString) > 0) || (localafje.k.indexOf(paramString) > 0))
        {
          localafje.e = localafje.j;
          localArrayList3.add(localafje);
        }
        else if ((localafje.g.indexOf(paramString) > 0) || (localafje.i.indexOf(paramString) > 0) || (localafje.h.indexOf(paramString) > 0))
        {
          localafje.e = localafje.g;
          localArrayList3.add(localafje);
        }
        else if (localafje.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localafje.e = localafje.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localafje);
        }
      }
    }
    Collections.sort(localArrayList2, new afjc(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afjb.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379618));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379020);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369278));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    this.d = ((TextView)findViewById(2131369233));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369262));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131365022));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131695952);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690676);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new afin(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562804, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363845)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131366280)).setOnTouchListener(new afir(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Afjf = new afjf(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afjf);
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
    Object localObject2 = new afiw(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562813);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new afix(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376947);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366280));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new afjd(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368378));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new afiy(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363845);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new afiz(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372032);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376602));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new afja(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377153));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838911);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Afjb = new afjb(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afjb);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new afio(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bhbx.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
    while (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.14(this, paramArrayList), 5, null, true);
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
    super.setContentView(2131561578);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Aofu);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aofu);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    if (this.jdField_a_of_type_Biso != null)
    {
      this.jdField_a_of_type_Biso.b();
      this.jdField_a_of_type_Biso = null;
    }
    if (this.jdField_a_of_type_Afjf != null) {
      this.jdField_a_of_type_Afjf.c();
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
      paramAdapterView = (afjg)paramView.getTag();
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