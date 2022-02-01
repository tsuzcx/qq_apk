package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleCheckableSlidingIndicator.ScrollViewListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.contacts.pullrefresh.OnRefreshListener;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;

public class TroopView
  extends ContactBaseView
{
  private int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  AddContactTroopClassifyAdapter.onItemClickListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter$onItemClickListener = new TroopView.1(this);
  private AddContactTroopClassifyAdapter jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter = new AddContactTroopClassifyAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter$onItemClickListener);
  private TroopView.UIHandler jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$UIHandler;
  TroopView.onNavStickyListener jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$onNavStickyListener;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  private ContactsBaseFragment.RefreshDataListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener = new TroopView.3(this);
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter;
  SimpleCheckableSlidingIndicator.ScrollViewListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener = new TroopView.2(this);
  private SimpleCheckableSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator;
  private SimpleSlidingIndicator.OnTabListener jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener = new TroopView.4(this);
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader;
  private OnRefreshListener jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshOnRefreshListener = new TroopView.5(this);
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private TroopBusinessObserver jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new TroopView.12(this);
  List<AddContactFindTroopClassifyInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public TroopView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext);
  }
  
  private long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getWindow().getDecorView();
    View localView = localViewGroup2.getChildAt(0);
    ViewGroup localViewGroup1 = localViewGroup2;
    if (localView != null)
    {
      localViewGroup1 = localViewGroup2;
      if ((localView instanceof ViewGroup)) {
        localViewGroup1 = (ViewGroup)localView;
      }
    }
    if ((localViewGroup1 instanceof TopGestureLayout)) {
      return (TopGestureLayout)localViewGroup1;
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b(paramInt, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter.a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1 = (AddContactFindTroopClassifyInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject3;
    AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo;
    if (((AddContactFindTroopClassifyInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int j = ((AddContactFindTroopClassifyInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
      if (j > 0)
      {
        localObject2 = new String[j];
        localObject3 = new int[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((AddContactFindTroopClassifyInfo.TagInfo)((AddContactFindTroopClassifyInfo)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
          localObject3[i] = i;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setTabData((String[])localObject2, (int[])localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new TroopView.6(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setCurrentPosition(((AddContactFindTroopClassifyInfo)localObject1).b, false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt + " currentClassifyPos:" + i);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(i, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = localAddContactFindTroopClassifyInfo.d;
          if (((AddContactFindTroopClassifyInfo)localObject1).b < 0) {
            break label386;
          }
          localObject2 = ((AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaUtilArrayList.get(((AddContactFindTroopClassifyInfo)localObject1).b)).b;
        }
      }
    }
    label386:
    for (localObject1 = ((AddContactFindTroopClassifyInfo.TagInfo)localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaUtilArrayList.get(((AddContactFindTroopClassifyInfo)localObject1).b)).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      ((AddContactViewPagerTroopFragment)localObject3).a((String)localObject2, (String)localObject1);
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()) {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    l();
    if (!paramBoolean) {
      a(1, 2131719529);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.a();
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.getCurrentItem();
    AddContactFindTroopClassifyInfo localAddContactFindTroopClassifyInfo = (AddContactFindTroopClassifyInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    i = 0;
    if (i < arrayOfString.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.findViewById(arrayOfInt[i]).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect))
      {
        ReportController.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i], localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString, "", "");
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,visible:" + arrayOfString[i] + "," + localAddContactFindTroopClassifyInfo.jdField_a_of_type_JavaLangString);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,not visible:" + arrayOfString[i]);
        }
      }
    }
  }
  
  private void f()
  {
    k();
    if (NetworkUtil.g(BaseApplication.getContext()))
    {
      localObject = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localObject != null) {
        ((TroopHandler)localObject).a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$UIHandler.obtainMessage(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$UIHandler.sendMessageDelayed((Message)localObject, 1000L);
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator = ((SimpleCheckableSlidingIndicator)findViewById(2131378256));
    int j = Color.parseColor("#F5F6FA");
    int i = getResources().getColor(2131167033);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      j = Color.parseColor("#282828");
      i = getResources().getColor(2131167197);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setIndicatorColor(j);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setCheckedTextColor(i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131369047));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)findViewById(2131365240));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363942));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380584));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366452));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131376820));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i = AIOUtils.a(6.0F, getResources());
    j = AIOUtils.a(16.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new AddContactTroopClassifyAdapter.SpacesItemDecoration(i, j));
    if (!StudyModeManager.a()) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopAddContactTroopClassifyAdapter);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager = ((ContactsViewPager)findViewById(2131365243));
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter = new AddContactFindTroopViewPagerAdapter(((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a()).getSupportFragmentManager(), this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), (BaseActivity)this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a(), (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsBaseFragment$RefreshDataListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOffscreenPageLimit(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPager.setOnPageChangeListener(new TroopView.7(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setOnTabListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$OnTabListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setOnRepeatClickListener(new TroopView.8(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator.setScrollViewListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleCheckableSlidingIndicator$ScrollViewListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)findViewById(2131378761));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.findViewById(2131378759));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new TroopView.9(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshCommonRefreshLayout.setOnRefreshListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshOnRefreshListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setTopOffset(AIOUtils.a(5.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView.setOnScrollListener(new TroopView.10(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new TroopView.11(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131708953);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a()
  {
    super.a();
    super.setContentView(2131559971);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131370752));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$UIHandler = new TroopView.UIHandler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    f();
    j();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    SearchUtils.a("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsContactsViewPagerAdapter.b();
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void setNavStickyListener(TroopView.onNavStickyListener paramonNavStickyListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopTroopView$onNavStickyListener = paramonNavStickyListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView
 * JD-Core Version:    0.7.0.1
 */