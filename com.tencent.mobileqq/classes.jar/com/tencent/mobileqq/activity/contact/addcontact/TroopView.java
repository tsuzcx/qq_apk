package com.tencent.mobileqq.activity.contact.addcontact;

import actj;
import afdi;
import afdj;
import afdn;
import afdp;
import afdr;
import affi;
import afgx;
import afgy;
import afgz;
import afha;
import afhb;
import afhc;
import afhd;
import afhe;
import afhf;
import afhg;
import afhh;
import afhi;
import afhj;
import afhk;
import afqs;
import afta;
import afth;
import afto;
import akhp;
import akil;
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
import awwa;
import axqy;
import bbfj;
import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsViewPagerAdapter;
import com.tencent.mobileqq.activity.contacts.view.ContactsViewPager;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.activity.contacts.view.SimpleCheckableSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.view.pullrefresh.ContactRefreshHeader;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppActivity;

public class TroopView
  extends ContactBaseView
{
  private int jdField_a_of_type_Int;
  private afdn jdField_a_of_type_Afdn = new afdn(this.jdField_a_of_type_Affi.a(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Afdr);
  afdr jdField_a_of_type_Afdr = new afgx(this);
  private afhj jdField_a_of_type_Afhj;
  public afhk a;
  private afqs jdField_a_of_type_Afqs = new afhc(this);
  afta jdField_a_of_type_Afta = new afhb(this);
  private afth jdField_a_of_type_Afth = new afhd(this);
  private afto jdField_a_of_type_Afto = new afhe(this);
  private akil jdField_a_of_type_Akil = new afha(this);
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  Button jdField_a_of_type_AndroidWidgetButton;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactsViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter;
  private ContactsViewPager jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager;
  private HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  private SimpleCheckableSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator;
  private CommonRefreshLayout jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout;
  private ContactRefreshHeader jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  public List<afdi> a;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public TroopView(affi paramaffi)
  {
    super(paramaffi);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private long a()
  {
    return this.jdField_a_of_type_Affi.a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_Affi.a().getWindow().getDecorView();
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
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((AppActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()) {
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    l();
    if (!paramBoolean) {
      a(1, 2131719799);
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b(paramInt, this.b);
    this.jdField_a_of_type_Afdn.a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1 = (afdi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject3;
    afdi localafdi;
    if (((afdi)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int j = ((afdi)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
      if (j > 0)
      {
        localObject2 = new String[j];
        localObject3 = new int[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((afdj)((afdi)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
          localObject3[i] = i;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setTabData((String[])localObject2, (int[])localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new afhf(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCurrentPosition(((afdi)localObject1).b, false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt + " currentClassifyPos:" + i);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(i, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          localafdi = (afdi)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = localafdi.d;
          if (((afdi)localObject1).b < 0) {
            break label386;
          }
          localObject2 = ((afdj)localafdi.jdField_a_of_type_JavaUtilArrayList.get(((afdi)localObject1).b)).b;
        }
      }
    }
    label386:
    for (localObject1 = ((afdj)localafdi.jdField_a_of_type_JavaUtilArrayList.get(((afdi)localObject1).b)).jdField_a_of_type_JavaLangString;; localObject1 = "")
    {
      ((AddContactViewPagerTroopFragment)localObject3).a((String)localObject2, (String)localObject1);
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.a();
    int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
    afdi localafdi = (afdi)this.jdField_a_of_type_JavaUtilList.get(i);
    i = 0;
    if (i < arrayOfString.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.findViewById(arrayOfInt[i]).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect))
      {
        axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i], localafdi.jdField_a_of_type_JavaLangString, "", "");
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,visible:" + arrayOfString[i] + "," + localafdi.jdField_a_of_type_JavaLangString);
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
    if (bbfj.g(BaseApplication.getContext()))
    {
      localObject = (akhp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null) {
        ((akhp)localObject).a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
    }
    Object localObject = this.jdField_a_of_type_Afhj.obtainMessage(1);
    this.jdField_a_of_type_Afhj.sendMessageDelayed((Message)localObject, 1000L);
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Affi.a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator = ((SimpleCheckableSlidingIndicator)findViewById(2131376283));
    int j = Color.parseColor("#F5F6FA");
    int i = getResources().getColor(2131166854);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      j = Color.parseColor("#282828");
      i = getResources().getColor(2131167006);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setIndicatorColor(j);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCheckedTextColor(i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368082));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131364640));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363479));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378337));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365763));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131375024));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i = actj.a(6.0F, getResources());
    j = actj.a(16.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new afdp(i, j));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Afdn);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager = ((ContactsViewPager)findViewById(2131364643));
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter = new AddContactFindTroopViewPagerAdapter(((FragmentActivity)this.jdField_a_of_type_Affi.a()).getSupportFragmentManager(), this.jdField_a_of_type_Affi.a(), (BaseActivity)this.jdField_a_of_type_Affi.a(), (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(this.jdField_a_of_type_Afqs);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOffscreenPageLimit(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOnPageChangeListener(new afhg(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnTabListener(this.jdField_a_of_type_Afth);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnRepeatClickListener(new afhh(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setScrollViewListener(this.jdField_a_of_type_Afta);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)findViewById(2131376744));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.findViewById(2131376742));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new afhi(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setOnRefreshListener(this.jdField_a_of_type_Afto);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setTopOffset(actj.a(5.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setOnScrollListener(new afgy(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new afgz(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131708978);
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
  
  protected void a()
  {
    super.a();
    super.a(2131559655);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369506));
    this.jdField_a_of_type_Afhj = new afhj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
    f();
    j();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    awwa.a("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
  }
  
  protected void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(true);
    }
  }
  
  protected void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b();
    }
  }
  
  protected void h()
  {
    super.h();
  }
  
  public void setNavStickyListener(afhk paramafhk)
  {
    this.jdField_a_of_type_Afhk = paramafhk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.TroopView
 * JD-Core Version:    0.7.0.1
 */