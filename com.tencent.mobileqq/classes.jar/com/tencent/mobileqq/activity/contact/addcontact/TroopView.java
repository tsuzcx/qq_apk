package com.tencent.mobileqq.activity.contact.addcontact;

import aekt;
import ahan;
import ahao;
import ahas;
import ahau;
import ahaw;
import ahcn;
import ahec;
import ahed;
import ahee;
import ahef;
import aheg;
import aheh;
import ahei;
import ahej;
import ahek;
import ahel;
import ahem;
import ahen;
import aheo;
import ahep;
import ahoj;
import ahqs;
import ahqz;
import ahrg;
import alzf;
import amab;
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
import ayrd;
import azmj;
import azwu;
import bdee;
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
  private ahas jdField_a_of_type_Ahas = new ahas(this.jdField_a_of_type_Ahcn.a(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ahaw);
  ahaw jdField_a_of_type_Ahaw = new ahec(this);
  private aheo jdField_a_of_type_Aheo;
  public ahep a;
  private ahoj jdField_a_of_type_Ahoj = new aheh(this);
  ahqs jdField_a_of_type_Ahqs = new aheg(this);
  private ahqz jdField_a_of_type_Ahqz = new ahei(this);
  private ahrg jdField_a_of_type_Ahrg = new ahej(this);
  private amab jdField_a_of_type_Amab = new ahef(this);
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
  public List<ahan> a;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  
  public TroopView(ahcn paramahcn)
  {
    super(paramahcn);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private long a()
  {
    return this.jdField_a_of_type_Ahcn.a().getSharedPreferences("last_buddy_list_refresh_time", 0).getLong("last_buddy_list_refresh_time", 0L);
  }
  
  private TopGestureLayout a()
  {
    ViewGroup localViewGroup2 = (ViewGroup)this.jdField_a_of_type_Ahcn.a().getWindow().getDecorView();
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
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, paramInt1, getResources().getString(paramInt2), 0).b(((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    l();
    if (!paramBoolean) {
      a(1, 2131720325);
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setCurrentScrollableContainer(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(paramInt, true));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b(paramInt, this.b);
    this.jdField_a_of_type_Ahas.a(paramInt);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(paramInt);
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1 = (ahan)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2;
    Object localObject3;
    ahan localahan;
    if (((ahan)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int j = ((ahan)localObject1).jdField_a_of_type_JavaUtilArrayList.size();
      if (j > 0)
      {
        localObject2 = new String[j];
        localObject3 = new int[j];
        int i = 0;
        while (i < j)
        {
          localObject2[i] = ((ahao)((ahan)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString;
          localObject3[i] = i;
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setTabData((String[])localObject2, (int[])localObject3);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        getViewTreeObserver().addOnGlobalLayoutListener(new ahek(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCurrentPosition(((ahan)localObject1).b, false);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.getCurrentItem();
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "onSelectedNewClassifyPostion. position:" + paramInt + " currentClassifyPos:" + i);
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(i, false);
        if (localObject2 != null)
        {
          localObject3 = (AddContactViewPagerTroopFragment)localObject2;
          localahan = (ahan)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject2 = localahan.d;
          if (((ahan)localObject1).b < 0) {
            break label386;
          }
          localObject2 = ((ahao)localahan.jdField_a_of_type_JavaUtilArrayList.get(((ahan)localObject1).b)).b;
        }
      }
    }
    label386:
    for (localObject1 = ((ahao)localahan.jdField_a_of_type_JavaUtilArrayList.get(((ahan)localObject1).b)).jdField_a_of_type_JavaLangString;; localObject1 = "")
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
    ahan localahan = (ahan)this.jdField_a_of_type_JavaUtilList.get(i);
    i = 0;
    if (i < arrayOfString.length)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.findViewById(arrayOfInt[i]).getLocalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect))
      {
        azmj.b(null, "dc00899", "Grp_find_new", "", "grptab", "sub_tag_exp", 0, 0, arrayOfString[i], localahan.jdField_a_of_type_JavaLangString, "", "");
        if (QLog.isColorLevel()) {
          QLog.i("addContacts.TroopView", 2, "checkAndReportHotTagExpose,visible:" + arrayOfString[i] + "," + localahan.jdField_a_of_type_JavaLangString);
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
    if (bdee.g(BaseApplication.getContext()))
    {
      localObject = (alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
      if (localObject != null) {
        ((alzf)localObject).a();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("addContacts.TroopView", 2, "initData falied. network unavailable");
    }
    Object localObject = this.jdField_a_of_type_Aheo.obtainMessage(1);
    this.jdField_a_of_type_Aheo.sendMessageDelayed((Message)localObject, 1000L);
  }
  
  private void i()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_Ahcn.a().getSharedPreferences("last_buddy_list_refresh_time", 0).edit().putLong("last_buddy_list_refresh_time", l).commit();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator = ((SimpleCheckableSlidingIndicator)findViewById(2131376786));
    int j = Color.parseColor("#F5F6FA");
    int i = getResources().getColor(2131166901);
    if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))
    {
      j = Color.parseColor("#282828");
      i = getResources().getColor(2131167057);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setIndicatorColor(j);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setCheckedTextColor(i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131368220));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131364719));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363520));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378930));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)findViewById(2131375494));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    i = aekt.a(6.0F, getResources());
    j = aekt.a(16.0F, getResources());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration(new ahau(i, j));
    if (!azwu.a()) {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Ahas);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager = ((ContactsViewPager)findViewById(2131364722));
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter = new AddContactFindTroopViewPagerAdapter(((FragmentActivity)this.jdField_a_of_type_Ahcn.a()).getSupportFragmentManager(), this.jdField_a_of_type_Ahcn.a(), (BaseActivity)this.jdField_a_of_type_Ahcn.a(), (ArrayList)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.a(this.jdField_a_of_type_Ahoj);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOffscreenPageLimit(6);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewContactsViewPager.setOnPageChangeListener(new ahel(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnTabListener(this.jdField_a_of_type_Ahqz);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setOnRepeatClickListener(new ahem(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleCheckableSlidingIndicator.setScrollViewListener(this.jdField_a_of_type_Ahqs);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout = ((CommonRefreshLayout)findViewById(2131377256));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setRefreshCompleteDelayDuration(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader = ((ContactRefreshHeader)this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.findViewById(2131377254));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshContactRefreshHeader.setRefreshHeaderUpdateListener(new ahen(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewPullrefreshCommonRefreshLayout.setOnRefreshListener(this.jdField_a_of_type_Ahrg);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setTopOffset(aekt.a(5.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView.setOnScrollListener(new ahed(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new ahee(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131709350);
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
    super.a(2131559707);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369768));
    this.jdField_a_of_type_Aheo = new aheo(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
    f();
    j();
  }
  
  protected void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
    ayrd.a("add_page", "search_grp", "exp", 0, 0, new String[] { "", "", "", "" });
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsAdapterContactsViewPagerAdapter.b();
    }
  }
  
  protected void h()
  {
    super.h();
  }
  
  public void setNavStickyListener(ahep paramahep)
  {
    this.jdField_a_of_type_Ahep = paramahep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.TroopView
 * JD-Core Version:    0.7.0.1
 */