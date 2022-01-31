package com.tencent.mobileqq.activity;

import acco;
import accp;
import accq;
import accr;
import accs;
import acct;
import accu;
import accx;
import accy;
import accz;
import acda;
import acdb;
import acdc;
import acdd;
import acde;
import acdf;
import acdg;
import acdh;
import ajjh;
import ajjy;
import ajuc;
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
import awqx;
import azzz;
import babr;
import bafb;
import bbmv;
import behi;
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
  implements behi
{
  protected int a;
  protected long a;
  protected acdc a;
  public acdg a;
  ajjh jdField_a_of_type_Ajjh = new acct(this);
  ajuc jdField_a_of_type_Ajuc = new accu(this);
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public bbmv a;
  public XListView a;
  protected Integer a;
  public String a;
  protected List<acdf> a;
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
    Object localObject = (ViewGroup)findViewById(2131309578);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131311553);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131302804);
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
  
  protected void a(acdf paramacdf)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131625472, new Object[] { ajjy.a(2131650002), ajjy.a(2131650002) });
      bafb localbafb = babr.a(this, 230);
      String str = paramacdf.jdField_a_of_type_JavaLangString;
      localbafb.setTitle(2131654487);
      localbafb.setMessage((CharSequence)localObject);
      localbafb.setPositiveButton(getString(2131629116), new accq(this, str, localbafb));
      localbafb.setPositiveButtonContentDescription(getString(2131625652));
      localbafb.setNegativeButton(getString(2131625035), new accr(this, localbafb));
      localbafb.setNegativeButtonContentDescription(getString(2131625651));
      localbafb.show();
      localObject = this.app;
      if (paramacdf.jdField_b_of_type_Int != 1) {
        break label203;
      }
    }
    label203:
    for (paramacdf = "1";; paramacdf = "0")
    {
      awqx.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramacdf, "", "", "");
      return;
      localObject = String.format(getString(2131654547), new Object[] { paramacdf.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(acdf paramacdf, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.15(this, paramFriends, paramacdf), 5, null, true);
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
      this.jdField_a_of_type_Acdc.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_Acdg.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      acdf localacdf = (acdf)localList.get(i);
      localacdf.e = "";
      localacdf.f = "";
      if ((localacdf.m.equals(paramString)) || (localacdf.o.equals(paramString)) || (localacdf.n.equals(paramString)))
      {
        localacdf.e = localacdf.m;
        localArrayList1.add(localacdf);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localacdf.j.equals(paramString)) || (localacdf.l.equals(paramString)) || (localacdf.k.equals(paramString)))
        {
          localacdf.e = localacdf.j;
          localArrayList1.add(localacdf);
        }
        else if ((localacdf.g.equals(paramString)) || (localacdf.i.equals(paramString)) || (localacdf.h.equals(paramString)))
        {
          localacdf.e = localacdf.g;
          localArrayList1.add(localacdf);
        }
        else if (localacdf.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localacdf.e = localacdf.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localacdf);
        }
        else if ((localacdf.m.indexOf(paramString) == 0) || (localacdf.o.indexOf(paramString) == 0) || (localacdf.n.indexOf(paramString) == 0))
        {
          localacdf.e = localacdf.m;
          localacdf.f = localacdf.n;
          localArrayList2.add(localacdf);
        }
        else if ((localacdf.j.indexOf(paramString) == 0) || (localacdf.l.indexOf(paramString) == 0) || (localacdf.k.indexOf(paramString) == 0))
        {
          localacdf.e = localacdf.j;
          localacdf.f = localacdf.k;
          localArrayList2.add(localacdf);
        }
        else if ((localacdf.g.indexOf(paramString) == 0) || (localacdf.i.indexOf(paramString) == 0) || (localacdf.h.indexOf(paramString) == 0))
        {
          localacdf.e = localacdf.g;
          localacdf.f = localacdf.h;
          localArrayList2.add(localacdf);
        }
        else if (localacdf.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localacdf.e = localacdf.jdField_a_of_type_JavaLangString;
          localacdf.f = localacdf.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localacdf);
        }
        else if ((localacdf.m.indexOf(paramString) > 0) || (localacdf.o.indexOf(paramString) > 0) || (localacdf.n.indexOf(paramString) > 0))
        {
          localacdf.e = localacdf.m;
          localArrayList3.add(localacdf);
        }
        else if ((localacdf.j.indexOf(paramString) > 0) || (localacdf.l.indexOf(paramString) > 0) || (localacdf.k.indexOf(paramString) > 0))
        {
          localacdf.e = localacdf.j;
          localArrayList3.add(localacdf);
        }
        else if ((localacdf.g.indexOf(paramString) > 0) || (localacdf.i.indexOf(paramString) > 0) || (localacdf.h.indexOf(paramString) > 0))
        {
          localacdf.e = localacdf.g;
          localArrayList3.add(localacdf);
        }
        else if (localacdf.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localacdf.e = localacdf.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localacdf);
        }
      }
    }
    Collections.sort(localArrayList2, new acdd(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Acdc.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131312084));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131311553);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.d = ((TextView)findViewById(2131302806));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302832));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131299006));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131630803);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131625011);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new acco(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131496760, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131297934)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131300167)).setOnTouchListener(new accs(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_Acdg = new acdg(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acdg);
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
    Object localObject2 = new accx(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131496769);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new accy(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131309736);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300167));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new acde(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131302060));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new accz(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131297934);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new acda(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131305203);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131309439));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new acdb(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131309910));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838503);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Acdc = new acdc(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Acdc);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new accp(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!azzz.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
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
    super.setContentView(2131495568);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_Ajuc);
    this.app.addObserver(this.jdField_a_of_type_Ajjh);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ajuc);
    this.app.removeObserver(this.jdField_a_of_type_Ajjh);
    if (this.jdField_a_of_type_Bbmv != null)
    {
      this.jdField_a_of_type_Bbmv.b();
      this.jdField_a_of_type_Bbmv = null;
    }
    if (this.jdField_a_of_type_Acdg != null) {
      this.jdField_a_of_type_Acdg.c();
    }
    super.doOnDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (acdh)paramView.getTag();
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