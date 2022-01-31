package com.tencent.mobileqq.activity.contact.addcontact;

import aciy;
import aeso;
import aesp;
import aest;
import aesv;
import aesx;
import aeuo;
import aewd;
import aewe;
import aewf;
import aewg;
import aewh;
import aewi;
import aewj;
import aewk;
import aewl;
import aewm;
import aewn;
import aewo;
import aewp;
import aewq;
import afex;
import afhf;
import afhm;
import afht;
import ajtg;
import ajuc;
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
import avwf;
import awqx;
import badq;
import bbmy;
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
  private aest jdField_a_of_type_Aest = new aest(this.jdField_a_of_type_Aeuo.a(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Aesx);
  aesx jdField_a_of_type_Aesx = new aewd(this);
  private aewp jdField_a_of_type_Aewp;
  public aewq a;
  private afex jdField_a_of_type_Afex = new aewi(this);
  afhf jdField_a_of_type_Afhf = new aewh(this);
  private afhm jdField_a_of_type_Afhm = new aewj(this);
  private afht jdField_a_of_type_Afht = new aewk(this);
  private ajuc jdField_a_of_type_Ajuc = new aewg(this);
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
  public List<aeso> a;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public TroopView(aeuo paramaeuo)
  {
    super(paramaeuo);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private long a()
  {
    return this.jdField_a_of_type_Aeuo.a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_Aeuo.a().getWindow().getDecorView();
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
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    l();
    if (!paramBoolean) {
      a(1, 2131653904);
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b(paramInt, this.b);
    this.jdField_a_of_type_Aest.a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1 = (aeso)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject3;
    aeso localaeso;
    if (((aeso)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int j = ((aeso)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
      if (j > 0)
      {
        localObject2 = new String[j];
        localObject3 = new int[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((aesp)((aeso)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
          localObject3[i] = i;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setTabData((String[])localObject2, (int[])localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new aewl(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCurrentPosition(((aeso)localObject1).b, false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt + " currentClassifyPos:" + i);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(i, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          localaeso = (aeso)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = localaeso.d;
          if (((aeso)localObject1).b < 0) {
            break label386;
          }
          localObject2 = ((aesp)localaeso.jdField_a_of_type_JavaUtilArrayList.get(((aeso)localObject1).b)).b;
        }
      }
    }
    label386:
    for (localObject1 = ((aesp)localaeso.jdField_a_of_type_JavaUtilArrayList.get(((aeso)localObject1).b)).jdField_a_of_type_JavaLangString;; localObject1 = "")
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
    aeso localaeso = (aeso)this.jdField_a_of_type_JavaUtilList.get(i);
    i = 0;
    if (i < arrayOfString.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.findViewById(arrayOfInt[i]).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect))
      {
        awqx.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i], localaeso.jdField_a_of_type_JavaLangString, "", "");
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,visible:" + arrayOfString[i] + "," + localaeso.jdField_a_of_type_JavaLangString);
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
    if (badq.g(BaseApplication.getContext()))
    {
      localObject = (ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null) {
        ((ajtg)localObject).a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
    }
    Object localObject = this.jdField_a_of_type_Aewp.obtainMessage(1);
    this.jdField_a_of_type_Aewp.sendMessageDelayed((Message)localObject, 1000L);
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Aeuo.a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator = ((SimpleCheckableSlidingIndicator)findViewById(2131310489));
    int j = Color.parseColor("#F5F6FA");
    int i = getResources().getColor(2131101260);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      j = Color.parseColor("#282828");
      i = getResources().getColor(2131101411);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setIndicatorColor(j);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCheckedTextColor(i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131302462));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131299081));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297934));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312509));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131309278));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i = aciy.a(6.0F, getResources());
    j = aciy.a(16.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new aesv(i, j));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aest);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager = ((ContactsViewPager)findViewById(2131299084));
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter = new AddContactFindTroopViewPagerAdapter(((FragmentActivity)this.jdField_a_of_type_Aeuo.a()).getSupportFragmentManager(), this.jdField_a_of_type_Aeuo.a(), (BaseActivity)this.jdField_a_of_type_Aeuo.a(), (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(this.jdField_a_of_type_Afex);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOffscreenPageLimit(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOnPageChangeListener(new aewm(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnTabListener(this.jdField_a_of_type_Afhm);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnRepeatClickListener(new aewn(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setScrollViewListener(this.jdField_a_of_type_Afhf);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)findViewById(2131310933));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.findViewById(2131310931));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new aewo(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setOnRefreshListener(this.jdField_a_of_type_Afht);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setTopOffset(aciy.a(5.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setOnScrollListener(new aewe(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new aewf(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131643182);
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
    super.a(2131494083);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131303832));
    this.jdField_a_of_type_Aewp = new aewp(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
    f();
    j();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    avwf.a("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b();
    }
  }
  
  protected void h()
  {
    super.h();
  }
  
  public void setNavStickyListener(aewq paramaewq)
  {
    this.jdField_a_of_type_Aewq = paramaewq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.TroopView
 * JD-Core Version:    0.7.0.1
 */