package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ucj;
import uck;
import ucl;
import ucm;
import ucn;
import uco;
import ucp;
import ucq;

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new ucl(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ucm(this);
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new uck(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  public ArrayList a;
  public ucp a;
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
    super.setContentView(2130970285);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362822));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131558938);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366465));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131366701));
    LayoutInflater.from(getActivity());
    this.jdField_a_of_type_Ucp = new ucp(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_Ucp);
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
      localObject1 = this.jdField_a_of_type_Ucp.getItem(paramInt);
    } while (!(localObject1 instanceof UncommonlyUsedContactsActivity.ListItem));
    Object localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (paramInt + 1 < this.jdField_a_of_type_Ucp.getCount())
    {
      if (((UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_Ucp.getItem(paramInt + 1)).jdField_a_of_type_Int != 0) {
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
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362577);
    this.b = ((TextView)findViewById(2131363363));
    this.b.setText(getString(2131437778));
    this.c = ((TextView)findViewById(2131363227));
    this.d = ((TextView)findViewById(2131363410));
    this.c.setText(2131433681);
    this.c.setOnClickListener(this);
    this.d.setVisibility(0);
    this.d.setText(2131436773);
    if (AppSetting.b)
    {
      this.b.setContentDescription(getString(2131437778));
      this.d.setContentDescription(getString(2131436773) + " 按钮");
      this.c.setContentDescription(getString(2131433681) + " 按钮");
    }
    this.d.setOnClickListener(this);
  }
  
  private void c()
  {
    Object localObject4 = (FriendsManager)this.app.getManager(50);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    ArrayList localArrayList2;
    if (localObject4 != null)
    {
      ConcurrentHashMap localConcurrentHashMap = ((FriendsManager)localObject4).a();
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
        Collections.sort(localArrayList2, ContactSorter.a);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        localFriends = (Friends)localArrayList2.get(i);
        Object localObject2 = localObject1;
        if (i == 0)
        {
          Object localObject5 = ((FriendsManager)localObject4).a();
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
        localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
        ((UncommonlyUsedContactsActivity.ListItem)localObject1).a(localThrowable);
        localArrayList1.add(localObject1);
        localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 1, localFriends);
        ((UncommonlyUsedContactsActivity.ListItem)localObject1).a(localThrowable);
        localArrayList1.add(localObject1);
        i += 1;
        localObject1 = localThrowable;
        continue;
      }
      localObject1 = (PhoneContactManagerImp)this.app.getManager(10);
      int i = ((PhoneContactManagerImp)localObject1).c();
      if ((((PhoneContactManagerImp)localObject1).c()) || (i == 8))
      {
        Object localObject3 = ((PhoneContactManagerImp)localObject1).a(true);
        if (((List)localObject3).size() > 0)
        {
          localObject1 = getString(2131436140) + "(" + ((List)localObject3).size() + ")";
          localObject4 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
          ((UncommonlyUsedContactsActivity.ListItem)localObject4).a((String)localObject1);
          localArrayList1.add(localObject4);
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = new UncommonlyUsedContactsActivity.ListItem(this, 1, (PhoneContact)((Iterator)localObject3).next());
            ((UncommonlyUsedContactsActivity.ListItem)localObject4).a((String)localObject1);
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
    new QQToastNotifier(getActivity()).a(paramInt1, this.jdField_a_of_type_AndroidViewView.getHeight(), 0, paramInt2);
  }
  
  void a(UncommonlyUsedContactsActivity.ListItem paramListItem)
  {
    if (paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity == null) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getString(2131433630), 0);
    localActionSheet.a(getString(2131437779), 0);
    if ((paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localActionSheet.a(getString(2131437780), 0);
      localActionSheet.a(getString(2131437782), 3);
    }
    for (;;)
    {
      localActionSheet.a(new ucj(this, paramListItem, localActionSheet));
      localActionSheet.c(2131432998);
      localActionSheet.show();
      return;
      if (!(paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact)) {
        break;
      }
      localActionSheet.a(getString(2131437781), 0);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ucp != null) {
      a(paramInt1);
    }
  }
  
  public void a(String paramString)
  {
    DialogUtil.a(getActivity(), 230).setTitle(getString(2131434501)).setMessage(getString(2131434510)).setPositiveButton(2131433214, new uco(this, paramString)).setNegativeButton(2131433682, new ucn(this)).show();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
    ReportController.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_Ucp != null) {
      this.jdField_a_of_type_Ucp.V_();
    }
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034129, 2131034130);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      paramView = (ucq)paramView.getTag();
    }
    try
    {
      paramView = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramView.jdField_a_of_type_Int);
      if (paramView == null)
      {
        return;
        startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
        ReportController.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
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
      ReportController.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */