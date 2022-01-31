package com.tencent.mobileqq.activity;

import aeej;
import aeek;
import aeel;
import aeem;
import aeen;
import aeeo;
import aeep;
import aees;
import aeet;
import aeeu;
import aeev;
import aeew;
import aeex;
import aeey;
import aeez;
import aefa;
import aefb;
import aefc;
import alox;
import alpo;
import amab;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import azmj;
import bdal;
import bdcd;
import bdfq;
import beps;
import bhqp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TroopTransferActivity
  extends BaseActivity
  implements bhqp
{
  protected int a;
  protected long a;
  protected aeex a;
  public aefb a;
  alox jdField_a_of_type_Alox = new aeeo(this);
  amab jdField_a_of_type_Amab = new aeep(this);
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public beps a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<aefa> a;
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
    Object localObject = (ViewGroup)findViewById(2131375812);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377903);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368613);
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
  
  protected void a(aefa paramaefa)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131691097, new Object[] { alpo.a(2131716176), alpo.a(2131716176) });
      bdfq localbdfq = bdcd.a(this, 230);
      String str = paramaefa.jdField_a_of_type_JavaLangString;
      localbdfq.setTitle(2131720930);
      localbdfq.setMessage((CharSequence)localObject);
      localbdfq.setPositiveButton(getString(2131694951), new aeel(this, str, localbdfq));
      localbdfq.setPositiveButtonContentDescription(getString(2131691280));
      localbdfq.setNegativeButton(getString(2131690648), new aeem(this, localbdfq));
      localbdfq.setNegativeButtonContentDescription(getString(2131691279));
      localbdfq.show();
      localObject = this.app;
      if (paramaefa.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramaefa = "1";; paramaefa = "0")
    {
      azmj.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramaefa, "", "", "");
      return;
      localObject = String.format(getString(2131720992), new Object[] { paramaefa.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(aefa paramaefa, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramaefa), 5, null, true);
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
      this.jdField_a_of_type_Aeex.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Aefb.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      aefa localaefa = (aefa)localList.get(i);
      localaefa.e = "";
      localaefa.f = "";
      if ((localaefa.m.equals(paramString)) || (localaefa.o.equals(paramString)) || (localaefa.n.equals(paramString)))
      {
        localaefa.e = localaefa.m;
        localArrayList1.add(localaefa);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localaefa.j.equals(paramString)) || (localaefa.l.equals(paramString)) || (localaefa.k.equals(paramString)))
        {
          localaefa.e = localaefa.j;
          localArrayList1.add(localaefa);
        }
        else if ((localaefa.g.equals(paramString)) || (localaefa.i.equals(paramString)) || (localaefa.h.equals(paramString)))
        {
          localaefa.e = localaefa.g;
          localArrayList1.add(localaefa);
        }
        else if (localaefa.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localaefa.e = localaefa.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localaefa);
        }
        else if ((localaefa.m.indexOf(paramString) == 0) || (localaefa.o.indexOf(paramString) == 0) || (localaefa.n.indexOf(paramString) == 0))
        {
          localaefa.e = localaefa.m;
          localaefa.f = localaefa.n;
          localArrayList2.add(localaefa);
        }
        else if ((localaefa.j.indexOf(paramString) == 0) || (localaefa.l.indexOf(paramString) == 0) || (localaefa.k.indexOf(paramString) == 0))
        {
          localaefa.e = localaefa.j;
          localaefa.f = localaefa.k;
          localArrayList2.add(localaefa);
        }
        else if ((localaefa.g.indexOf(paramString) == 0) || (localaefa.i.indexOf(paramString) == 0) || (localaefa.h.indexOf(paramString) == 0))
        {
          localaefa.e = localaefa.g;
          localaefa.f = localaefa.h;
          localArrayList2.add(localaefa);
        }
        else if (localaefa.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localaefa.e = localaefa.jdField_a_of_type_JavaLangString;
          localaefa.f = localaefa.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localaefa);
        }
        else if ((localaefa.m.indexOf(paramString) > 0) || (localaefa.o.indexOf(paramString) > 0) || (localaefa.n.indexOf(paramString) > 0))
        {
          localaefa.e = localaefa.m;
          localArrayList3.add(localaefa);
        }
        else if ((localaefa.j.indexOf(paramString) > 0) || (localaefa.l.indexOf(paramString) > 0) || (localaefa.k.indexOf(paramString) > 0))
        {
          localaefa.e = localaefa.j;
          localArrayList3.add(localaefa);
        }
        else if ((localaefa.g.indexOf(paramString) > 0) || (localaefa.i.indexOf(paramString) > 0) || (localaefa.h.indexOf(paramString) > 0))
        {
          localaefa.e = localaefa.g;
          localArrayList3.add(localaefa);
        }
        else if (localaefa.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localaefa.e = localaefa.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localaefa);
        }
      }
    }
    Collections.sort(localArrayList2, new aeey(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aeex.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378457));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377903);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368659));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368613));
    this.d = ((TextView)findViewById(2131368615));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368644));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364643));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696691);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690623);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aeej(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562564, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363520)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131365849)).setOnTouchListener(new aeen(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Aefb = new aefb(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aefb);
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
    Object localObject2 = new aees(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
    localTranslateAnimation.setDuration(300L);
    localTranslateAnimation.setAnimationListener((Animation.AnimationListener)localObject2);
    localTranslateAnimation.setFillAfter(true);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setAnimationListener((Animation.AnimationListener)localObject2);
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this);
      this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_AndroidAppDialog.requestWindowFeature(1);
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setSoftInputMode(36);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562573);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aeet(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375981);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365849));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aeez(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367807));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aeeu(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363520);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new aeev(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371186);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375671));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aeew(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376166));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838591);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Aeex = new aeex(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aeex);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new aeek(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bdal.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
    while (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.14(this, paramArrayList), 5, null, true);
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
    super.setContentView(2131561344);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Amab);
    this.app.addObserver(this.jdField_a_of_type_Alox);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Amab);
    this.app.removeObserver(this.jdField_a_of_type_Alox);
    if (this.jdField_a_of_type_Beps != null)
    {
      this.jdField_a_of_type_Beps.b();
      this.jdField_a_of_type_Beps = null;
    }
    if (this.jdField_a_of_type_Aefb != null) {
      this.jdField_a_of_type_Aefb.c();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (aefc)paramView.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */