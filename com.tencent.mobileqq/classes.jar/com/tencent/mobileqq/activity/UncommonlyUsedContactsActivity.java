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
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
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
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver = new UncommonlyUsedContactsActivity.2(this);
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new UncommonlyUsedContactsActivity.3(this);
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  ArrayList<UncommonlyUsedContactsActivity.ListItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private TextView b;
  private TextView c;
  private TextView d;
  
  @TargetApi(14)
  private void a()
  {
    super.setContentView(2131561032);
    getWindow().setBackgroundDrawable(null);
    c();
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376809));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299223);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379364));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131381293));
    LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter = new UncommonlyUsedContactsActivity.GatheredGrpListAdapter(this, this, this.app, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, 1, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnScrollGroupFloatingListener(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    paramInt -= 1;
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0) != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0).getBottom() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getItem(paramInt);
    if (!(localObject1 instanceof UncommonlyUsedContactsActivity.ListItem)) {
      return;
    }
    localObject1 = ((UncommonlyUsedContactsActivity.ListItem)localObject1).jdField_a_of_type_JavaLangString;
    paramInt += 1;
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getCount())
    {
      Object localObject2 = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter.getItem(paramInt);
      if ((localObject2 != null) && (((UncommonlyUsedContactsActivity.ListItem)localObject2).jdField_a_of_type_Int == 0))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getChildAt(0);
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getBottom();
          localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
          int i = this.jdField_a_of_type_Int;
          if (paramInt < i) {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = (paramInt - i);
          } else {
            ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
      else
      {
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (((RelativeLayout.LayoutParams)localObject2).topMargin != 0)
        {
          ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
          this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378803);
    this.b = ((TextView)findViewById(2131369249));
    this.b.setText(getString(2131698950));
    this.c = ((TextView)findViewById(2131369202));
    this.d = ((TextView)findViewById(2131369233));
    this.c.setOnClickListener(this);
    this.d.setVisibility(0);
    this.d.setText(2131718832);
    if (AppSetting.d)
    {
      this.b.setContentDescription(getString(2131698950));
      TextView localTextView = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131718832));
      localStringBuilder.append(HardCodeUtil.a(2131715656));
      localTextView.setContentDescription(localStringBuilder.toString());
      localTextView = this.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131690706));
      localStringBuilder.append(HardCodeUtil.a(2131715651));
      localTextView.setContentDescription(localStringBuilder.toString());
    }
    this.d.setOnClickListener(this);
  }
  
  private void c()
  {
    Object localObject3 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2;
    if (localObject3 != null)
    {
      ConcurrentHashMap localConcurrentHashMap = ((FriendsManager)localObject3).a();
      Set localSet = localConcurrentHashMap.keySet();
      if ((localSet != null) && (localSet.size() > 0))
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
        {
          ArrayList localArrayList2 = (ArrayList)localConcurrentHashMap.get((String)localIterator.next());
          if ((localArrayList2 != null) && (localArrayList2.size() > 0))
          {
            try
            {
              Collections.sort(localArrayList2, ContactSorter.a);
            }
            catch (Throwable localThrowable)
            {
              QLog.d("qqBaseActivity", 1, "", localThrowable);
            }
            localObject1 = "";
            i = 0;
            while (i < localArrayList2.size())
            {
              Friends localFriends = (Friends)localArrayList2.get(i);
              localObject2 = localObject1;
              if (i == 0)
              {
                Object localObject4 = ((FriendsManager)localObject3).a();
                localObject2 = localObject1;
                if (localObject4 != null)
                {
                  localObject2 = localObject1;
                  if (((List)localObject4).size() > 0)
                  {
                    localObject4 = ((List)localObject4).iterator();
                    for (;;)
                    {
                      localObject2 = localObject1;
                      if (!((Iterator)localObject4).hasNext()) {
                        break;
                      }
                      localObject2 = (Groups)((Iterator)localObject4).next();
                      if (((Groups)localObject2).group_id == localFriends.groupid)
                      {
                        localObject1 = new StringBuilder();
                        ((StringBuilder)localObject1).append(((Groups)localObject2).group_name);
                        ((StringBuilder)localObject1).append("(");
                        ((StringBuilder)localObject1).append(localArrayList2.size());
                        ((StringBuilder)localObject1).append(")");
                        localObject1 = ((StringBuilder)localObject1).toString();
                      }
                    }
                  }
                }
                localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
                ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
                localArrayList1.add(localObject1);
              }
              localObject1 = new UncommonlyUsedContactsActivity.ListItem(this, 1, localFriends);
              ((UncommonlyUsedContactsActivity.ListItem)localObject1).a((String)localObject2);
              localArrayList1.add(localObject1);
              i += 1;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    Object localObject1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    int i = ((IPhoneContactService)localObject1).getSelfBindState();
    if ((((IPhoneContactService)localObject1).isBindContactOk()) || (i == 8))
    {
      localObject2 = ((IPhoneContactService)localObject1).getBindHideNoneFriendList(true);
      if (((List)localObject2).size() > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getString(2131694786));
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(((List)localObject2).size());
        ((StringBuilder)localObject1).append(")");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject3 = new UncommonlyUsedContactsActivity.ListItem(this, 0, null);
        ((UncommonlyUsedContactsActivity.ListItem)localObject3).a((String)localObject1);
        localArrayList1.add(localObject3);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new UncommonlyUsedContactsActivity.ListItem(this, 1, (PhoneContact)((Iterator)localObject2).next());
          ((UncommonlyUsedContactsActivity.ListItem)localObject3).a((String)localObject1);
          localArrayList1.add(localObject3);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList1;
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
    localActionSheet.addButton(getString(2131718751), 0);
    localActionSheet.addButton(getString(2131698945), 0);
    if ((paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof Friends))
    {
      localActionSheet.addButton(getString(2131698947), 0);
      localActionSheet.addButton(getString(2131698943), 3);
    }
    else
    {
      if (!(paramListItem.jdField_a_of_type_ComTencentMobileqqPersistenceEntity instanceof PhoneContact)) {
        return;
      }
      localActionSheet.addButton(getString(2131698948), 0);
    }
    localActionSheet.setOnButtonClickListener(new UncommonlyUsedContactsActivity.1(this, paramListItem, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  void a(String paramString)
  {
    DialogUtil.a(getActivity(), 230).setTitle(getString(2131691488)).setMessage(getString(2131690633)).setPositiveButton(2131692630, new UncommonlyUsedContactsActivity.6(this, paramString)).setNegativeButton(2131690707, new UncommonlyUsedContactsActivity.5(this)).show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramInt1 != 21001) {
        return;
      }
      if (paramIntent != null)
      {
        paramIntent = new AllInOne(paramIntent.getStringExtra("contactSearchResultUin"), 1);
        paramIntent.profileEntryType = 60;
        ProfileUtils.openProfileCard(getActivity(), paramIntent);
        ReportController.b(this.app, "CliOper", "", "", "0X8004C58", "0X8004C58", 3, 0, "", "", "", "");
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactObserverContactBindObserver);
    UncommonlyUsedContactsActivity.GatheredGrpListAdapter localGatheredGrpListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity$GatheredGrpListAdapter;
    if (localGatheredGrpListAdapter != null) {
      localGatheredGrpListAdapter.c();
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
    overridePendingTransition(2130772002, 2130772003);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202) {
      if (i != 2131369233) {
        localObject = (UncommonlyUsedContactsActivity.GatheredViewHolder)paramView.getTag();
      }
    }
    try
    {
      localObject = (UncommonlyUsedContactsActivity.ListItem)this.jdField_a_of_type_JavaUtilArrayList.get(((UncommonlyUsedContactsActivity.GatheredViewHolder)localObject).jdField_a_of_type_Int);
    }
    catch (Exception localException)
    {
      label43:
      break label43;
    }
    Object localObject = null;
    if (localObject != null)
    {
      a((UncommonlyUsedContactsActivity.ListItem)localObject);
      ReportController.b(this.app, "CliOper", "", "", "0X8004C50", "0X8004C50", 0, 0, "", "", "", "");
      break label154;
      startActivity(new Intent(this, SettingUncommUsedContactsActivity.class));
      ReportController.b(this.app, "CliOper", "", "", "0X8004C55", "0X8004C55", 0, 0, "", "", "", "");
      break label154;
      finish();
    }
    label154:
    EventCollector.getInstance().onViewClicked(paramView);
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity
 * JD-Core Version:    0.7.0.1
 */