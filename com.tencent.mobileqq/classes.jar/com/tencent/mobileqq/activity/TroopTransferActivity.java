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
  protected int a;
  protected long a;
  protected Dialog a;
  protected View a;
  protected EditText a;
  protected ImageButton a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected TroopTransferActivity.SearchResultAdapter a;
  protected TroopTransferActivity.TroopMemberListAdapter a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopTransferActivity.4(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopTransferActivity.3(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopTransferActivity.5(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopTransferActivity.6(this);
  protected QQProgressNotifier a;
  protected XListView a;
  protected Integer a;
  protected String a;
  protected List<TroopTransferActivity.TroopMemberItem> a;
  protected boolean a;
  protected View b;
  protected TextView b;
  protected XListView b;
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
    Object localObject = (ViewGroup)findViewById(2131376636);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131378803);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131369202);
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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("troopuin = ");
          localStringBuilder.append(l);
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
    if (((this.jdField_a_of_type_Long & 0x800) == 0L) && (this.jdField_a_of_type_Int == 0)) {
      localObject = String.format(getString(2131719829), new Object[] { paramTroopMemberItem.jdField_b_of_type_JavaLangString });
    } else {
      localObject = getString(2131691071, new Object[] { HardCodeUtil.a(2131715576), HardCodeUtil.a(2131715576) });
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    String str = paramTroopMemberItem.jdField_a_of_type_JavaLangString;
    localQQCustomDialog.setTitle(2131719752);
    localQQCustomDialog.setMessage((CharSequence)localObject);
    localQQCustomDialog.setPositiveButton(getString(2131694583), new TroopTransferActivity.13(this, str, localQQCustomDialog));
    localQQCustomDialog.setPositiveButtonContentDescription(getString(2131691239));
    localQQCustomDialog.setNegativeButton(getString(2131690728), new TroopTransferActivity.14(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButtonContentDescription(getString(2131691238));
    localQQCustomDialog.show();
    Object localObject = this.app;
    if (paramTroopMemberItem.jdField_b_of_type_Int == 1) {
      paramTroopMemberItem = "1";
    } else {
      paramTroopMemberItem = "0";
    }
    ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Grp", "Transgrp_others", 0, 0, paramTroopMemberItem, "", "", "");
  }
  
  protected void a(TroopTransferActivity.TroopMemberItem paramTroopMemberItem, Friends paramFriends)
  {
    if (!a()) {
      return;
    }
    ThreadManager.post(new TroopTransferActivity.17(this, paramFriends, paramTroopMemberItem), 5, null, true);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_AndroidViewView.getLayoutParams().height = -1;
    if ((!paramString.equals("")) && (paramString.trim().length() != 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
      paramString = paramString.toLowerCase();
      List localList = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter.a();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)localList.get(i);
        localTroopMemberItem.e = "";
        localTroopMemberItem.f = "";
        if ((!localTroopMemberItem.m.equals(paramString)) && (!localTroopMemberItem.o.equals(paramString)) && (!localTroopMemberItem.n.equals(paramString)))
        {
          if ((!localTroopMemberItem.j.equals(paramString)) && (!localTroopMemberItem.l.equals(paramString)) && (!localTroopMemberItem.k.equals(paramString)))
          {
            if ((!localTroopMemberItem.g.equals(paramString)) && (!localTroopMemberItem.i.equals(paramString)) && (!localTroopMemberItem.h.equals(paramString)))
            {
              if (localTroopMemberItem.jdField_a_of_type_JavaLangString.equals(paramString))
              {
                localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
                localArrayList1.add(localTroopMemberItem);
              }
              else if ((localTroopMemberItem.m.indexOf(paramString) != 0) && (localTroopMemberItem.o.indexOf(paramString) != 0) && (localTroopMemberItem.n.indexOf(paramString) != 0))
              {
                if ((localTroopMemberItem.j.indexOf(paramString) != 0) && (localTroopMemberItem.l.indexOf(paramString) != 0) && (localTroopMemberItem.k.indexOf(paramString) != 0))
                {
                  if ((localTroopMemberItem.g.indexOf(paramString) != 0) && (localTroopMemberItem.i.indexOf(paramString) != 0) && (localTroopMemberItem.h.indexOf(paramString) != 0))
                  {
                    if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) == 0)
                    {
                      localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
                      localTroopMemberItem.f = localTroopMemberItem.jdField_a_of_type_JavaLangString;
                      localArrayList2.add(localTroopMemberItem);
                    }
                    else if ((localTroopMemberItem.m.indexOf(paramString) <= 0) && (localTroopMemberItem.o.indexOf(paramString) <= 0) && (localTroopMemberItem.n.indexOf(paramString) <= 0))
                    {
                      if ((localTroopMemberItem.j.indexOf(paramString) <= 0) && (localTroopMemberItem.l.indexOf(paramString) <= 0) && (localTroopMemberItem.k.indexOf(paramString) <= 0))
                      {
                        if ((localTroopMemberItem.g.indexOf(paramString) <= 0) && (localTroopMemberItem.i.indexOf(paramString) <= 0) && (localTroopMemberItem.h.indexOf(paramString) <= 0))
                        {
                          if (localTroopMemberItem.jdField_a_of_type_JavaLangString.indexOf(paramString) > 0)
                          {
                            localTroopMemberItem.e = localTroopMemberItem.jdField_a_of_type_JavaLangString;
                            localArrayList3.add(localTroopMemberItem);
                          }
                        }
                        else
                        {
                          localTroopMemberItem.e = localTroopMemberItem.g;
                          localArrayList3.add(localTroopMemberItem);
                        }
                      }
                      else
                      {
                        localTroopMemberItem.e = localTroopMemberItem.j;
                        localArrayList3.add(localTroopMemberItem);
                      }
                    }
                    else
                    {
                      localTroopMemberItem.e = localTroopMemberItem.m;
                      localArrayList3.add(localTroopMemberItem);
                    }
                  }
                  else
                  {
                    localTroopMemberItem.e = localTroopMemberItem.g;
                    localTroopMemberItem.f = localTroopMemberItem.h;
                    localArrayList2.add(localTroopMemberItem);
                  }
                }
                else
                {
                  localTroopMemberItem.e = localTroopMemberItem.j;
                  localTroopMemberItem.f = localTroopMemberItem.k;
                  localArrayList2.add(localTroopMemberItem);
                }
              }
              else
              {
                localTroopMemberItem.e = localTroopMemberItem.m;
                localTroopMemberItem.f = localTroopMemberItem.n;
                localArrayList2.add(localTroopMemberItem);
              }
            }
            else
            {
              localTroopMemberItem.e = localTroopMemberItem.g;
              localArrayList1.add(localTroopMemberItem);
            }
          }
          else
          {
            localTroopMemberItem.e = localTroopMemberItem.j;
            localArrayList1.add(localTroopMemberItem);
          }
        }
        else
        {
          localTroopMemberItem.e = localTroopMemberItem.m;
          localArrayList1.add(localTroopMemberItem);
        }
        i += 1;
      }
      Collections.sort(localArrayList2, new TroopTransferActivity.SearchResultComparator(this, null));
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList1);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList3);
      if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      } else {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379373));
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378803);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.d = ((TextView)findViewById(2131369204));
    this.d.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369233));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131365037));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131696219);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    String str = getIntent().getExtras().getString("leftViewText");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = getString(2131690706);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopTransferActivity.1(this));
    localObject = (RelativeLayout)getLayoutInflater().inflate(2131562770, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 0, 0);
    ((Button)((RelativeLayout)localObject).findViewById(2131363868)).setVisibility(8);
    ((EditText)((RelativeLayout)localObject).findViewById(2131366333)).setOnTouchListener(new TroopTransferActivity.2(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter = new TroopTransferActivity.TroopMemberListAdapter(this, this, paramArrayList);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      runOnUiThread(new TroopTransferActivity.15(this));
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Integer localInteger = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() - 1);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("finUpdateThread|[");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangInteger);
        ((StringBuilder)???).append(", needUpdateUI = ");
        ((StringBuilder)???).append(paramBoolean);
        ((StringBuilder)???).append("]");
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_JavaLangInteger.intValue() >= 2)
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("too many update thread|total = ");
        ((StringBuilder)???).append(this.jdField_a_of_type_JavaLangInteger);
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)???).toString());
      }
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangInteger)
    {
      Object localObject2 = this.jdField_a_of_type_JavaLangInteger;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(this.jdField_a_of_type_JavaLangInteger.intValue() + 1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("add update thread |nTotalThreadCount = ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangInteger);
        QLog.i("Q.troopdisband.transfer", 2, ((StringBuilder)localObject2).toString());
      }
      return true;
    }
  }
  
  protected void b()
  {
    int i = getTitleBarHeight();
    float f = -i;
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
    Object localObject2 = new TroopTransferActivity.7(this, localTranslateAnimation, (TranslateAnimation)localObject1, i);
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
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131562779);
      localObject2 = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).x = 0;
      ((WindowManager.LayoutParams)localObject2).y = 0;
      ((WindowManager.LayoutParams)localObject2).width = -1;
      ((WindowManager.LayoutParams)localObject2).height = -1;
      ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
      ((WindowManager.LayoutParams)localObject2).gravity = 51;
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
      this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new TroopTransferActivity.8(this, i, (TranslateAnimation)localObject1));
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376809);
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131366333));
      this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new TroopTransferActivity.SearchTextWatcher(this, null));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131368340));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new TroopTransferActivity.9(this));
      localObject1 = (Button)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131363868);
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new TroopTransferActivity.10(this));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppDialog.findViewById(2131371921);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131376483));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new TroopTransferActivity.11(this));
      this.jdField_b_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131377016));
      this.jdField_b_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
      this.jdField_b_of_type_ComTencentWidgetXListView.setDividerHeight(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$SearchResultAdapter = new TroopTransferActivity.SearchResultAdapter(this, this.jdField_a_of_type_JavaUtilList);
      this.jdField_b_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$SearchResultAdapter);
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnTouchListener(new TroopTransferActivity.12(this));
      this.jdField_b_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
  }
  
  protected void b(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(0);
    if (localTroopMemberCardInfo != null)
    {
      if (!Utils.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (!a()) {
        return;
      }
      ThreadManager.post(new TroopTransferActivity.16(this, paramArrayList), 5, null, true);
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
      localStringBuilder.append("onCreate");
      localStringBuilder.append("| mTroopUin = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("| mTroopCode = ");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("| mTroopName = ");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append("| mVipMemberList");
      localStringBuilder.append(paramBundle);
      QLog.i("Q.troopdisband.transfer", 2, localStringBuilder.toString());
    }
    a();
    super.setContentView(2131561538);
    a(paramBundle);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
    if (localObject != null)
    {
      ((QQProgressNotifier)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberListAdapter;
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    paramAdapterView = (TroopTransferActivity.ViewHolder)paramView.getTag();
    if (paramAdapterView != null) {
      paramAdapterView = paramAdapterView.a;
    } else {
      paramAdapterView = null;
    }
    if ((paramAdapterView != null) && (paramAdapterView.jdField_a_of_type_Int == 1)) {
      a(paramAdapterView);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopTransferActivity
 * JD-Core Version:    0.7.0.1
 */