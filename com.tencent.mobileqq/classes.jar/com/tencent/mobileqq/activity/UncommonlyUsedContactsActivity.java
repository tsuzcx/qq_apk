package com.tencent.mobileqq.activity;

import aeff;
import aefg;
import aefh;
import aefi;
import aefj;
import aefk;
import aefl;
import aefm;
import aefn;
import allb;
import allu;
import alox;
import aloz;
import alpo;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import awdn;
import azmj;
import bdcd;
import bdfq;
import beqa;
import bhpo;
import bhpy;
import bhql;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener, bhpo
{
  int jdField_a_of_type_Int;
  public aefl a;
  allb jdField_a_of_type_Allb = new aefh(this);
  alox jdField_a_of_type_Alox = new aefi(this);
  View jdField_a_of_type_AndroidViewView;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  awdn jdField_a_of_type_Awdn = new aefg(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  public ArrayList<aefn> a;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public UncommonlyUsedContactsActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  @TargetApi(14)
  private void a()
  {
    super.setContentView(2131560887);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375981));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131298961);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378448));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131380290));
    LayoutInflater.from(getActivity());
    this.jdField_a_of_type_Aefl = new aefl(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Aefl);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    do
    {
      return;
      paramInt -= 1;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
        return;
      }
      localObject1 = this.jdField_a_of_type_Aefl.getItem(paramInt);
    } while (!(localObject1 instanceof aefn));
    Object localObject1 = ((aefn)localObject1).jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (paramInt + 1 < this.jdField_a_of_type_Aefl.getCount())
    {
      if (((aefn)this.jdField_a_of_type_Aefl.getItem(paramInt + 1)).jdField_a_of_type_Int != 0) {
        break label217;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
      if (localObject2 != null)
      {
        paramInt = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramInt >= this.jdField_a_of_type_Int) {
          break label209;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label258;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      label209:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break;
      label217:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    label258:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377903);
    this.b = ((TextView)findViewById(2131368659));
    this.b.setText(getString(2131699395));
    this.c = ((TextView)findViewById(2131368613));
    this.d = ((TextView)findViewById(2131368644));
    this.c.setOnClickListener(this);
    this.d.setVisibility(0);
    this.d.setText(2131719870);
    if (AppSetting.c)
    {
      this.b.setContentDescription(getString(2131699395));
      this.d.setContentDescription(getString(2131719870) + alpo.a(2131716260));
      this.c.setContentDescription(getString(2131690623) + alpo.a(2131716255));
    }
    this.d.setOnClickListener(this);
  }
  
  private void c()
  {
    Object localObject4 = (aloz)this.app.getManager(51);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    ArrayList localArrayList2;
    if (localObject4 != null)
    {
      ConcurrentHashMap localConcurrentHashMap = ((aloz)localObject4).a();
      localObject1 = localConcurrentHashMap.keySet();
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        Iterator localIterator = ((Set)localObject1).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localArrayList2 = (ArrayList)localConcurrentHashMap.get((String)localIterator.next());
          localObject1 = "";
        } while ((localArrayList2 == null) || (localArrayList2.size() <= 0));
      }
    }
    label507:
    for (;;)
    {
      try
      {
        Collections.sort(localArrayList2, allu.a);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        localFriends = (Friends)localArrayList2.get(i);
        Object localObject2 = localObject1;
        if (i == 0)
        {
          Object localObject5 = ((aloz)localObject4).b();
          localObject2 = localObject1;
          if (localObject5 != null)
          {
            localObject2 = localObject1;
            if (((List)localObject5).size() > 0)
            {
              localObject5 = ((List)localObject5).iterator();
              localObject2 = localObject1;
              if (((Iterator)localObject5).hasNext())
              {
                localObject2 = (Groups)((Iterator)localObject5).next();
                if (((Groups)localObject2).group_id != localFriends.groupid) {
                  break label507;
                }
                localObject1 = ((Groups)localObject2).group_name + "(" + localArrayList2.size() + ")";
                continue;
              }
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Friends localFriends;
        QLog.d("qqBaseActivity", 1, "", localThrowable);
        continue;
        localObject1 = new aefn(this, 0, null);
        ((aefn)localObject1).a(localThrowable);
        localArrayList1.add(localObject1);
        localObject1 = new aefn(this, 1, localFriends);
        ((aefn)localObject1).a(localThrowable);
        localArrayList1.add(localObject1);
        i += 1;
        localObject1 = localThrowable;
        continue;
      }
      localObject1 = (PhoneContactManagerImp)this.app.getManager(11);
      int i = ((PhoneContactManagerImp)localObject1).d();
      if ((((PhoneContactManagerImp)localObject1).c()) || (i == 8))
      {
        Object localObject3 = ((PhoneContactManagerImp)localObject1).a(true);
        if (((List)localObject3).size() > 0)
        {
          localObject1 = getString(2131695186) + "(" + ((List)localObject3).size() + ")";
          localObject4 = new aefn(this, 0, null);
          ((aefn)localObject4).a((String)localObject1);
          localArrayList1.add(localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = new aefn(this, 1, (PhoneContact)((Iterator)localObject3).next());
            ((aefn)localObject4).a((String)localObject1);
            localArrayList1.add(localObject4);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    new beqa(getActivity()).a(paramInt1, this.jdField_a_of_type_AndroidViewView.getHeight(), 0, paramInt2);
  }
  
  void a(aefn paramaefn)
  {
    if (paramaefn.jdField_a_of_type_Awbv == null) {
      return;
    }
    bhpy localbhpy = (bhpy)bhql.a(this, null);
    localbhpy.a(getString(2131719755), 0);
    localbhpy.a(getString(2131699385), 0);
    if ((paramaefn.jdField_a_of_type_Awbv instanceof Friends))
    {
      localbhpy.a(getString(2131699390), 0);
      localbhpy.a(getString(2131699377), 3);
    }
    for (;;)
    {
      localbhpy.a(new aeff(this, paramaefn, localbhpy));
      localbhpy.c(2131690648);
      localbhpy.show();
      return;
      if (!(paramaefn.jdField_a_of_type_Awbv instanceof PhoneContact)) {
        break;
      }
      localbhpy.a(getString(2131699391), 0);
    }
  }
  
  public void a(String paramString)
  {
    bdcd.a(getActivity(), 230).setTitle(getString(2131691570)).setMessage(getString(2131690510)).setPositiveButton(2131692820, new aefk(this, paramString)).setNegativeButton(2131690624, new aefj(this)).show();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while (paramIntent == null);
    paramIntent = new ProfileActivity.AllInOne(paramIntent.getStringExtra("contactSearchResultUin"), 1);
    paramIntent.h = 60;
    ProfileActivity.b(getActivity(), paramIntent);
    azmj.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_Alox);
    addObserver(this.jdField_a_of_type_Allb);
    this.app.registObserver(this.jdField_a_of_type_Awdn);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Alox);
    removeObserver(this.jdField_a_of_type_Allb);
    this.app.unRegistObserver(this.jdField_a_of_type_Awdn);
    if (this.jdField_a_of_type_Aefl != null) {
      this.jdField_a_of_type_Aefl.c();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130771988, 2130771989);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (aefm)paramView.getTag();
    }
    try
    {
      paramView = (aefn)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int);
      if (paramView == null)
      {
        return;
        startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
        azmj.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
        return;
        finish();
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView = null;
      }
      a(paramView);
      azmj.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Aefl != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */