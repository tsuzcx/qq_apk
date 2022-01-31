package com.tencent.mobileqq.activity;

import acmz;
import acna;
import acnb;
import acnc;
import acnd;
import acne;
import acnf;
import acni;
import acnj;
import acnk;
import acnl;
import acnm;
import acnn;
import acno;
import acnp;
import acnq;
import acnr;
import acns;
import ajxj;
import ajya;
import akil;
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
import axqy;
import bbbr;
import bbdj;
import bbgu;
import bcqi;
import bfpt;
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
  implements bfpt
{
  protected int a;
  protected long a;
  protected acnn a;
  public acnr a;
  ajxj jdField_a_of_type_Ajxj = new acne(this);
  akil jdField_a_of_type_Akil = new acnf(this);
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public bcqi a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<acnq> a;
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
    Object localObject = (ViewGroup)findViewById(2131375329);
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
  
  protected void a(acnq paramacnq)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131691044, new Object[] { ajya.a(2131715804), ajya.a(2131715804) });
      bbgu localbbgu = bbdj.a(this, 230);
      String str = paramacnq.jdField_a_of_type_JavaLangString;
      localbbgu.setTitle(2131720394);
      localbbgu.setMessage((CharSequence)localObject);
      localbbgu.setPositiveButton(getString(2131694794), new acnb(this, str, localbbgu));
      localbbgu.setPositiveButtonContentDescription(getString(2131691227));
      localbbgu.setNegativeButton(getString(2131690596), new acnc(this, localbbgu));
      localbbgu.setNegativeButtonContentDescription(getString(2131691226));
      localbbgu.show();
      localObject = this.app;
      if (paramacnq.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramacnq = "1";; paramacnq = "0")
    {
      axqy.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramacnq, "", "", "");
      return;
      localObject = String.format(getString(2131720454), new Object[] { paramacnq.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(acnq paramacnq, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramacnq), 5, null, true);
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
      this.jdField_a_of_type_Acnn.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Acnr.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      acnq localacnq = (acnq)localList.get(i);
      localacnq.e = "";
      localacnq.f = "";
      if ((localacnq.m.equals(paramString)) || (localacnq.o.equals(paramString)) || (localacnq.n.equals(paramString)))
      {
        localacnq.e = localacnq.m;
        localArrayList1.add(localacnq);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localacnq.j.equals(paramString)) || (localacnq.l.equals(paramString)) || (localacnq.k.equals(paramString)))
        {
          localacnq.e = localacnq.j;
          localArrayList1.add(localacnq);
        }
        else if ((localacnq.g.equals(paramString)) || (localacnq.i.equals(paramString)) || (localacnq.h.equals(paramString)))
        {
          localacnq.e = localacnq.g;
          localArrayList1.add(localacnq);
        }
        else if (localacnq.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localacnq.e = localacnq.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localacnq);
        }
        else if ((localacnq.m.indexOf(paramString) == 0) || (localacnq.o.indexOf(paramString) == 0) || (localacnq.n.indexOf(paramString) == 0))
        {
          localacnq.e = localacnq.m;
          localacnq.f = localacnq.n;
          localArrayList2.add(localacnq);
        }
        else if ((localacnq.j.indexOf(paramString) == 0) || (localacnq.l.indexOf(paramString) == 0) || (localacnq.k.indexOf(paramString) == 0))
        {
          localacnq.e = localacnq.j;
          localacnq.f = localacnq.k;
          localArrayList2.add(localacnq);
        }
        else if ((localacnq.g.indexOf(paramString) == 0) || (localacnq.i.indexOf(paramString) == 0) || (localacnq.h.indexOf(paramString) == 0))
        {
          localacnq.e = localacnq.g;
          localacnq.f = localacnq.h;
          localArrayList2.add(localacnq);
        }
        else if (localacnq.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localacnq.e = localacnq.jdField_a_of_type_JavaLangString;
          localacnq.f = localacnq.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localacnq);
        }
        else if ((localacnq.m.indexOf(paramString) > 0) || (localacnq.o.indexOf(paramString) > 0) || (localacnq.n.indexOf(paramString) > 0))
        {
          localacnq.e = localacnq.m;
          localArrayList3.add(localacnq);
        }
        else if ((localacnq.j.indexOf(paramString) > 0) || (localacnq.l.indexOf(paramString) > 0) || (localacnq.k.indexOf(paramString) > 0))
        {
          localacnq.e = localacnq.j;
          localArrayList3.add(localacnq);
        }
        else if ((localacnq.g.indexOf(paramString) > 0) || (localacnq.i.indexOf(paramString) > 0) || (localacnq.h.indexOf(paramString) > 0))
        {
          localacnq.e = localacnq.g;
          localArrayList3.add(localacnq);
        }
        else if (localacnq.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localacnq.e = localacnq.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localacnq);
        }
      }
    }
    Collections.sort(localArrayList2, new acno(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acnn.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377911));
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
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364565));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696516);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690572);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new acmz(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562360, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363479)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131365763)).setOnTouchListener(new acnd(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Acnr = new acnr(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acnr);
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
    Object localObject2 = new acni(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562369);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new acnj(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375493);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365763));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acnp(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367678));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new acnk(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363479);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new acnl(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131370876);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375189));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acnm(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375673));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838514);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Acnn = new acnn(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acnn);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new acna(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bbbr.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
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
    super.setContentView(2131561156);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Akil);
    this.app.addObserver(this.jdField_a_of_type_Ajxj);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Akil);
    this.app.removeObserver(this.jdField_a_of_type_Ajxj);
    if (this.jdField_a_of_type_Bcqi != null)
    {
      this.jdField_a_of_type_Bcqi.b();
      this.jdField_a_of_type_Bcqi = null;
    }
    if (this.jdField_a_of_type_Acnr != null) {
      this.jdField_a_of_type_Acnr.c();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (acns)paramView.getTag();
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