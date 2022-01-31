package com.tencent.mobileqq.activity;

import acnd;
import acne;
import acnf;
import acng;
import acnh;
import acni;
import acnj;
import acnm;
import acnn;
import acno;
import acnp;
import acnq;
import acnr;
import acns;
import acnt;
import acnu;
import acnv;
import acnw;
import ajxl;
import ajyc;
import akim;
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
import axqw;
import bbbd;
import bbcv;
import bbgg;
import bcpt;
import bfpc;
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
  implements bfpc
{
  protected int a;
  protected long a;
  protected acnr a;
  public acnv a;
  ajxl jdField_a_of_type_Ajxl = new acni(this);
  akim jdField_a_of_type_Akim = new acnj(this);
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public bcpt a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<acnu> a;
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
    Object localObject = (ViewGroup)findViewById(2131375327);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377369);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368429);
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
  
  protected void a(acnu paramacnu)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131691044, new Object[] { ajyc.a(2131715793), ajyc.a(2131715793) });
      bbgg localbbgg = bbcv.a(this, 230);
      String str = paramacnu.jdField_a_of_type_JavaLangString;
      localbbgg.setTitle(2131720383);
      localbbgg.setMessage((CharSequence)localObject);
      localbbgg.setPositiveButton(getString(2131694793), new acnf(this, str, localbbgg));
      localbbgg.setPositiveButtonContentDescription(getString(2131691227));
      localbbgg.setNegativeButton(getString(2131690596), new acng(this, localbbgg));
      localbbgg.setNegativeButtonContentDescription(getString(2131691226));
      localbbgg.show();
      localObject = this.app;
      if (paramacnu.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramacnu = "1";; paramacnu = "0")
    {
      axqw.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramacnu, "", "", "");
      return;
      localObject = String.format(getString(2131720443), new Object[] { paramacnu.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(acnu paramacnu, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramacnu), 5, null, true);
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
      this.jdField_a_of_type_Acnr.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Acnv.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      acnu localacnu = (acnu)localList.get(i);
      localacnu.e = "";
      localacnu.f = "";
      if ((localacnu.m.equals(paramString)) || (localacnu.o.equals(paramString)) || (localacnu.n.equals(paramString)))
      {
        localacnu.e = localacnu.m;
        localArrayList1.add(localacnu);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localacnu.j.equals(paramString)) || (localacnu.l.equals(paramString)) || (localacnu.k.equals(paramString)))
        {
          localacnu.e = localacnu.j;
          localArrayList1.add(localacnu);
        }
        else if ((localacnu.g.equals(paramString)) || (localacnu.i.equals(paramString)) || (localacnu.h.equals(paramString)))
        {
          localacnu.e = localacnu.g;
          localArrayList1.add(localacnu);
        }
        else if (localacnu.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localacnu.e = localacnu.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localacnu);
        }
        else if ((localacnu.m.indexOf(paramString) == 0) || (localacnu.o.indexOf(paramString) == 0) || (localacnu.n.indexOf(paramString) == 0))
        {
          localacnu.e = localacnu.m;
          localacnu.f = localacnu.n;
          localArrayList2.add(localacnu);
        }
        else if ((localacnu.j.indexOf(paramString) == 0) || (localacnu.l.indexOf(paramString) == 0) || (localacnu.k.indexOf(paramString) == 0))
        {
          localacnu.e = localacnu.j;
          localacnu.f = localacnu.k;
          localArrayList2.add(localacnu);
        }
        else if ((localacnu.g.indexOf(paramString) == 0) || (localacnu.i.indexOf(paramString) == 0) || (localacnu.h.indexOf(paramString) == 0))
        {
          localacnu.e = localacnu.g;
          localacnu.f = localacnu.h;
          localArrayList2.add(localacnu);
        }
        else if (localacnu.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localacnu.e = localacnu.jdField_a_of_type_JavaLangString;
          localacnu.f = localacnu.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localacnu);
        }
        else if ((localacnu.m.indexOf(paramString) > 0) || (localacnu.o.indexOf(paramString) > 0) || (localacnu.n.indexOf(paramString) > 0))
        {
          localacnu.e = localacnu.m;
          localArrayList3.add(localacnu);
        }
        else if ((localacnu.j.indexOf(paramString) > 0) || (localacnu.l.indexOf(paramString) > 0) || (localacnu.k.indexOf(paramString) > 0))
        {
          localacnu.e = localacnu.j;
          localArrayList3.add(localacnu);
        }
        else if ((localacnu.g.indexOf(paramString) > 0) || (localacnu.i.indexOf(paramString) > 0) || (localacnu.h.indexOf(paramString) > 0))
        {
          localacnu.e = localacnu.g;
          localArrayList3.add(localacnu);
        }
        else if (localacnu.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localacnu.e = localacnu.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localacnu);
        }
      }
    }
    Collections.sort(localArrayList2, new acns(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acnr.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377906));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377369);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.d = ((TextView)findViewById(2131368431));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368457));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364566));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696515);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690572);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new acnd(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562361, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363480)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131365764)).setOnTouchListener(new acnh(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Acnv = new acnv(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acnv);
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
    Object localObject2 = new acnm(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562370);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new acnn(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375491);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365764));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acnt(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367678));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new acno(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363480);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new acnp(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370876);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375187));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acnq(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375671));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838514);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Acnr = new acnr(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acnr);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new acne(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bbbd.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
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
    super.setContentView(2131561157);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Akim);
    this.app.addObserver(this.jdField_a_of_type_Ajxl);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Akim);
    this.app.removeObserver(this.jdField_a_of_type_Ajxl);
    if (this.jdField_a_of_type_Bcpt != null)
    {
      this.jdField_a_of_type_Bcpt.b();
      this.jdField_a_of_type_Bcpt = null;
    }
    if (this.jdField_a_of_type_Acnv != null) {
      this.jdField_a_of_type_Acnv.c();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (acnw)paramView.getTag();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */