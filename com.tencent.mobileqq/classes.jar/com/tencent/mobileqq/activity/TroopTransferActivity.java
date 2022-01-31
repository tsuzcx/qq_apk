package com.tencent.mobileqq.activity;

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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uek;
import uel;
import uem;
import uen;
import ueo;
import uep;
import ueq;
import uer;
import ues;
import uet;
import uew;
import uex;
import uey;
import uez;
import ufa;
import ufb;
import ufc;
import ufd;
import ufg;

public class TroopTransferActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener
{
  protected int a;
  protected long a;
  public Dialog a;
  public View a;
  public EditText a;
  protected ImageButton a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  public TroopTransferActivity.TroopMemberListAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ues(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new uet(this);
  public QQProgressNotifier a;
  protected XListView a;
  protected Integer a;
  public String a;
  protected List a;
  protected ufb a;
  public boolean a;
  protected View b;
  protected TextView b;
  public XListView b;
  public String b;
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
    Object localObject = (ViewGroup)findViewById(2131363244);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131362594);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131363245);
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
  
  protected void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem)
  {
    Object localObject;
    if (((this.jdField_a_of_type_Long & 0x800) != 0L) || (this.jdField_a_of_type_Int != 0))
    {
      localObject = getString(2131434521, new Object[] { "转让", "转让" });
      QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
      String str = paramTroopMemberItem.jdField_a_of_type_JavaLangString;
      localQQCustomDialog.setTitle(2131435208);
      localQQCustomDialog.setMessage((CharSequence)localObject);
      localQQCustomDialog.setPositiveButton(getString(2131433016), new uem(this, str, localQQCustomDialog));
      localQQCustomDialog.setPositiveButtonContentDescription(getString(2131427394));
      localQQCustomDialog.setNegativeButton(getString(2131433015), new uen(this, localQQCustomDialog));
      localQQCustomDialog.setNegativeButtonContentDescription(getString(2131427395));
      localQQCustomDialog.show();
      localObject = this.app;
      if (paramTroopMemberItem.jdField_b_of_type_Int != 1) {
        break label197;
      }
    }
    label197:
    for (paramTroopMemberItem = "1";; paramTroopMemberItem = "0")
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramTroopMemberItem, "", "", "");
      return;
      localObject = String.format(getString(2131435219), new Object[] { paramTroopMemberItem.jdField_b_of_type_JavaLangString });
      break;
    }
  }
  
  public void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new ueq(this, paramFriends, paramTroopMemberItem), 5, null, true);
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      paramAdapterView = (ufg)paramView.getTag();
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.a; (paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_Int == 1); paramAdapterView = null)
      {
        a(paramAdapterView);
        return;
      }
    }
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
      this.jdField_a_of_type_Ufb.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
    paramString = paramString.toLowerCase();
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    if (i < localList.size())
    {
      TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)localList.get(i);
      localTroopMemberItem.e = "";
      localTroopMemberItem.f = "";
      if ((localTroopMemberItem.m.equals(paramString)) || (localTroopMemberItem.o.equals(paramString)) || (localTroopMemberItem.n.equals(paramString)))
      {
        localTroopMemberItem.e = localTroopMemberItem.m;
        localArrayList1.add(localTroopMemberItem);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localTroopMemberItem.j.equals(paramString)) || (localTroopMemberItem.l.equals(paramString)) || (localTroopMemberItem.k.equals(paramString)))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localArrayList1.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.equals(paramString)) || (localTroopMemberItem.i.equals(paramString)) || (localTroopMemberItem.h.equals(paramString)))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localArrayList1.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.equals(paramString))
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList1.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.m.indexOf(paramString) == 0) || (localTroopMemberItem.o.indexOf(paramString) == 0) || (localTroopMemberItem.n.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.m;
          localTroopMemberItem.f = localTroopMemberItem.n;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.j.indexOf(paramString) == 0) || (localTroopMemberItem.l.indexOf(paramString) == 0) || (localTroopMemberItem.k.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localTroopMemberItem.f = localTroopMemberItem.k;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.indexOf(paramString) == 0) || (localTroopMemberItem.i.indexOf(paramString) == 0) || (localTroopMemberItem.h.indexOf(paramString) == 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localTroopMemberItem.f = localTroopMemberItem.h;
          localArrayList2.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localTroopMemberItem.f = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList2.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.m.indexOf(paramString) > 0) || (localTroopMemberItem.o.indexOf(paramString) > 0) || (localTroopMemberItem.n.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.m;
          localArrayList3.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.j.indexOf(paramString) > 0) || (localTroopMemberItem.l.indexOf(paramString) > 0) || (localTroopMemberItem.k.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.j;
          localArrayList3.add(localTroopMemberItem);
        }
        else if ((localTroopMemberItem.g.indexOf(paramString) > 0) || (localTroopMemberItem.i.indexOf(paramString) > 0) || (localTroopMemberItem.h.indexOf(paramString) > 0))
        {
          localTroopMemberItem.e = localTroopMemberItem.g;
          localArrayList3.add(localTroopMemberItem);
        }
        else if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
        {
          localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
          localArrayList3.add(localTroopMemberItem);
        }
      }
    }
    Collections.sort(localArrayList2, new ufc(this, null));
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Ufb.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  protected void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371573));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362594);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363381));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363245));
    this.d = ((TextView)findViewById(2131363473));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363428));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131363733));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131430381);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131433698);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new uek(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2130971517, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131368321)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131368322)).setOnTouchListener(new uer(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter = new TroopTransferActivity.TroopMemberListAdapter(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new ueo(this));
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
    Object localObject2 = new uew(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2130971524);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new uex(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362840);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368322));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ufd(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368323));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new uey(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368321);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new uez(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363925);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363923));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ufa(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365669));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838214);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_Ufb = new ufb(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ufb);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new uel(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  public void b(ArrayList paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if ((localTroopMemberCardInfo == null) || (!Utils.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString))) {}
    while (!a()) {
      return;
    }
    ThreadManager.post(new uep(this, paramArrayList), 5, null, true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
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
    super.setContentView(2130970652);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    c();
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.X_();
    }
    super.onDestroy();
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