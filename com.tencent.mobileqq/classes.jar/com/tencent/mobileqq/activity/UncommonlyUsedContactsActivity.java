package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class UncommonlyUsedContactsActivity
  extends BaseActivity
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  UncommonlyUsedContactsActivity.GatheredGrpListAdapter jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new UncommonlyUsedContactsActivity.4(this);
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new UncommonlyUsedContactsActivity.2(this);
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new UncommonlyUsedContactsActivity.3(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList<UncommonlyUsedContactsActivity.ListItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private TextView b;
  private TextView c;
  private TextView d;
  
  @TargetApi(14)
  private void a()
  {
    super.setContentView(2131561169);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131377356));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299215);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380035));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131382091));
    LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter = new UncommonlyUsedContactsActivity.GatheredGrpListAdapter(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter);
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getItem(paramInt);
    } while (!(localObject1 instanceof UncommonlyUsedContactsActivity.ListItem));
    Object localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString;
    Object localObject2;
    if (paramInt + 1 < this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getCount())
    {
      localObject2 = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getItem(paramInt + 1);
      if ((localObject2 == null) || (((UncommonlyUsedContactsActivity.ListItem)localObject2).jdField_a_of_type_Int != 0)) {
        break label223;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
      if (localObject2 != null)
      {
        paramInt = ((View)localObject2).getBottom();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (paramInt >= this.jdField_a_of_type_Int) {
          break label215;
        }
        ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label264;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
      label215:
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      break;
      label223:
      localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
      {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
    }
    label264:
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379451);
    this.b = ((TextView)findViewById(2131369534));
    this.b.setText(getString(2131698871));
    this.c = ((TextView)findViewById(2131369487));
    this.d = ((TextView)findViewById(2131369518));
    this.c.setOnClickListener(this);
    this.d.setVisibility(0);
    this.d.setText(2131719114);
    if (AppSetting.d)
    {
      this.b.setContentDescription(getString(2131698871));
      this.d.setContentDescription(getString(2131719114) + HardCodeUtil.a(2131715732));
      this.c.setContentDescription(getString(2131690778) + HardCodeUtil.a(2131715727));
    }
    this.d.setOnClickListener(this);
  }
  
  private void c()
  {
    Object localObject4 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
    label506:
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
                  break label506;
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
      localObject1 = (PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      int i = ((PhoneContactManagerImp)localObject1).d();
      if ((((PhoneContactManagerImp)localObject1).d()) || (i == 8))
      {
        Object localObject3 = ((PhoneContactManagerImp)localObject1).a(true);
        if (((List)localObject3).size() > 0)
        {
          localObject1 = getString(2131694800) + "(" + ((List)localObject3).size() + ")";
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
    localActionSheet.addButton(getString(2131719035), 0);
    localActionSheet.addButton(getString(2131698866), 0);
    if ((paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localActionSheet.addButton(getString(2131698868), 0);
      localActionSheet.addButton(getString(2131698864), 3);
    }
    for (;;)
    {
      localActionSheet.setOnButtonClickListener(new UncommonlyUsedContactsActivity.1(this, paramListItem, localActionSheet));
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.show();
      return;
      if (!(paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact)) {
        break;
      }
      localActionSheet.addButton(getString(2131698869), 0);
    }
  }
  
  void a(String paramString)
  {
    DialogUtil.a(getActivity(), 230).setTitle(getString(2131691567)).setMessage(getString(2131690705)).setPositiveButton(2131692673, new UncommonlyUsedContactsActivity.6(this, paramString)).setNegativeButton(2131690779, new UncommonlyUsedContactsActivity.5(this)).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    ReportController.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.c();
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
    overridePendingTransition(2130771990, 2130771991);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      localObject = (UncommonlyUsedContactsActivity.GatheredViewHolder)paramView.getTag();
    }
    try
    {
      localObject = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_JavaUtilArrayList.get(((UncommonlyUsedContactsActivity.GatheredViewHolder)localObject).jdField_a_of_type_Int);
      if (localObject == null) {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
          ReportController.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
          continue;
          finish();
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        UncommonlyUsedContactsActivity.ListItem localListItem = null;
        continue;
        a(localListItem);
        ReportController.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter != null) {
      a(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */