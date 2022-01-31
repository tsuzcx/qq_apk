package com.tencent.mobileqq.activity;

import aeiy;
import aeiz;
import aeja;
import aejb;
import aejc;
import aejd;
import aeje;
import aejh;
import aeji;
import aejj;
import aejk;
import aejl;
import aejm;
import aejn;
import aejo;
import aejp;
import aejq;
import aejr;
import altm;
import alud;
import ameq;
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
import azqs;
import bdeu;
import bdgm;
import bdjz;
import beub;
import bhuw;
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
  implements bhuw
{
  protected int a;
  protected long a;
  protected aejm a;
  public aejq a;
  altm jdField_a_of_type_Altm = new aejd(this);
  ameq jdField_a_of_type_Ameq = new aeje(this);
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public beub a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<aejp> a;
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
    Object localObject = (ViewGroup)findViewById(2131375863);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131377957);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131368624);
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
  
  protected void a(aejp paramaejp)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131691098, new Object[] { alud.a(2131716188), alud.a(2131716188) });
      bdjz localbdjz = bdgm.a(this, 230);
      String str = paramaejp.jdField_a_of_type_JavaLangString;
      localbdjz.setTitle(2131720942);
      localbdjz.setMessage((CharSequence)localObject);
      localbdjz.setPositiveButton(getString(2131694953), new aeja(this, str, localbdjz));
      localbdjz.setPositiveButtonContentDescription(getString(2131691281));
      localbdjz.setNegativeButton(getString(2131690648), new aejb(this, localbdjz));
      localbdjz.setNegativeButtonContentDescription(getString(2131691280));
      localbdjz.show();
      localObject = this.app;
      if (paramaejp.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramaejp = "1";; paramaejp = "0")
    {
      azqs.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramaejp, "", "", "");
      return;
      localObject = String.format(getString(2131721004), new Object[] { paramaejp.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(aejp paramaejp, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramaejp), 5, null, true);
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
      this.jdField_a_of_type_Aejm.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Aejq.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      aejp localaejp = (aejp)localList.get(i);
      localaejp.e = "";
      localaejp.f = "";
      if ((localaejp.m.equals(paramString)) || (localaejp.o.equals(paramString)) || (localaejp.n.equals(paramString)))
      {
        localaejp.e = localaejp.m;
        localArrayList1.add(localaejp);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localaejp.j.equals(paramString)) || (localaejp.l.equals(paramString)) || (localaejp.k.equals(paramString)))
        {
          localaejp.e = localaejp.j;
          localArrayList1.add(localaejp);
        }
        else if ((localaejp.g.equals(paramString)) || (localaejp.i.equals(paramString)) || (localaejp.h.equals(paramString)))
        {
          localaejp.e = localaejp.g;
          localArrayList1.add(localaejp);
        }
        else if (localaejp.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localaejp.e = localaejp.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localaejp);
        }
        else if ((localaejp.m.indexOf(paramString) == 0) || (localaejp.o.indexOf(paramString) == 0) || (localaejp.n.indexOf(paramString) == 0))
        {
          localaejp.e = localaejp.m;
          localaejp.f = localaejp.n;
          localArrayList2.add(localaejp);
        }
        else if ((localaejp.j.indexOf(paramString) == 0) || (localaejp.l.indexOf(paramString) == 0) || (localaejp.k.indexOf(paramString) == 0))
        {
          localaejp.e = localaejp.j;
          localaejp.f = localaejp.k;
          localArrayList2.add(localaejp);
        }
        else if ((localaejp.g.indexOf(paramString) == 0) || (localaejp.i.indexOf(paramString) == 0) || (localaejp.h.indexOf(paramString) == 0))
        {
          localaejp.e = localaejp.g;
          localaejp.f = localaejp.h;
          localArrayList2.add(localaejp);
        }
        else if (localaejp.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localaejp.e = localaejp.jdField_a_of_type_JavaLangString;
          localaejp.f = localaejp.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localaejp);
        }
        else if ((localaejp.m.indexOf(paramString) > 0) || (localaejp.o.indexOf(paramString) > 0) || (localaejp.n.indexOf(paramString) > 0))
        {
          localaejp.e = localaejp.m;
          localArrayList3.add(localaejp);
        }
        else if ((localaejp.j.indexOf(paramString) > 0) || (localaejp.l.indexOf(paramString) > 0) || (localaejp.k.indexOf(paramString) > 0))
        {
          localaejp.e = localaejp.j;
          localArrayList3.add(localaejp);
        }
        else if ((localaejp.g.indexOf(paramString) > 0) || (localaejp.i.indexOf(paramString) > 0) || (localaejp.h.indexOf(paramString) > 0))
        {
          localaejp.e = localaejp.g;
          localArrayList3.add(localaejp);
        }
        else if (localaejp.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localaejp.e = localaejp.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localaejp);
        }
      }
    }
    Collections.sort(localArrayList2, new aejn(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aejm.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378511));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377957);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.d = ((TextView)findViewById(2131368626));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368655));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131364645));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696693);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690623);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new aeiy(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562582, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363522)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131365851)).setOnTouchListener(new aejc(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Aejq = new aejq(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aejq);
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
    Object localObject2 = new aejh(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562591);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new aeji(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376034);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365851));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aejo(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131367817));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new aejj(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363522);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new aejk(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371205);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131375722));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aejl(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376220));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838592);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Aejm = new aejm(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aejm);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new aeiz(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!bdeu.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
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
    super.setContentView(2131561362);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Ameq);
    this.app.addObserver(this.jdField_a_of_type_Altm);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ameq);
    this.app.removeObserver(this.jdField_a_of_type_Altm);
    if (this.jdField_a_of_type_Beub != null)
    {
      this.jdField_a_of_type_Beub.b();
      this.jdField_a_of_type_Beub = null;
    }
    if (this.jdField_a_of_type_Aejq != null) {
      this.jdField_a_of_type_Aejq.c();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (aejr)paramView.getTag();
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