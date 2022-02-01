package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bksn;
import bkss;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pki;
import pkj;
import pkk;
import pkm;
import pkp;
import pkq;
import pkr;
import plh;
import pll;
import teh;

public abstract class ReadInJoyDynamicChannelBaseFragment
  extends ReadInJoyBaseFragment
  implements bkss, pki, pkm
{
  protected int a;
  public XRecyclerView a;
  protected String a;
  protected List<View> a;
  protected boolean a;
  public int b;
  public String b;
  protected boolean b;
  public int c;
  protected String c;
  
  public ReadInJoyDynamicChannelBaseFragment()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_JavaLangString = "0X8007626";
    this.jdField_c_of_type_JavaLangString = "0X8007625";
    this.jdField_b_of_type_Boolean = true;
  }
  
  public static String a(int paramInt)
  {
    return "dynamic_feeds_" + paramInt;
  }
  
  public static teh a(String paramString)
  {
    teh localteh2 = teh.a(paramString, false);
    teh localteh1 = localteh2;
    if (localteh2 == null) {
      localteh1 = teh.a(paramString, true);
    }
    return localteh1;
  }
  
  private void m()
  {
    n();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView = new XRecyclerView(getActivity());
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = new StaggeredGridLayoutManager(this.jdField_a_of_type_Int, 1);
    localStaggeredGridLayoutManager.setGapStrategy(0);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setLayoutManager(localStaggeredGridLayoutManager);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().setOnBindHeaderObserver(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new pkp(this, localStaggeredGridLayoutManager));
    c();
    d();
  }
  
  private void n()
  {
    Object localObject1 = a(a());
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "initOfflineConfig failed, templateFactory is null.");
      return;
    }
    if (((teh)localObject1).a() > 0) {
      this.jdField_a_of_type_Int = ((teh)localObject1).a();
    }
    localObject1 = ((teh)localObject1).a();
    if (localObject1 != null)
    {
      String str1 = ((pkj)localObject1).a("expose_t_name");
      String str2 = ((pkj)localObject1).a("click_t_name");
      if (!TextUtils.isEmpty(str1)) {
        this.jdField_b_of_type_JavaLangString = str1;
      }
      if (!TextUtils.isEmpty(str2)) {
        this.jdField_c_of_type_JavaLangString = str2;
      }
      str1 = ((pkj)localObject1).a("is_support_pull_refresh");
      if (!TextUtils.isEmpty(str1)) {
        this.jdField_b_of_type_Boolean = str1.equals("1");
      }
      str1 = ((pkj)localObject1).b("is_need_id_list");
      boolean bool = false;
      if (!TextUtils.isEmpty(str1)) {
        bool = str1.equals("1");
      }
      str1 = ((pkj)localObject1).b("cgi");
      str2 = ((pkj)localObject1).b("request_pre_process");
      String str3 = ((pkj)localObject1).b("receive_pre_process");
      Object localObject2 = new pkq();
      ((pkq)localObject2).jdField_a_of_type_JavaLangString = str1;
      ((pkq)localObject2).jdField_a_of_type_Boolean = bool;
      ((pkq)localObject2).jdField_b_of_type_JavaLangString = str2;
      ((pkq)localObject2).jdField_c_of_type_JavaLangString = str3;
      Object localObject3 = plh.a();
      if (localObject3 != null) {
        ((plh)localObject3).a(this.jdField_b_of_type_Int, (pkq)localObject2);
      }
      int j = ((pkj)localObject1).a();
      localObject2 = new ArrayList();
      if (j > 0)
      {
        int i = 0;
        while (i < j)
        {
          localObject3 = ((pkj)localObject1).a(i);
          if (localObject3 != null)
          {
            pkr localpkr = new pkr();
            localpkr.jdField_a_of_type_JavaLangString = ((pkk)localObject3).jdField_a_of_type_JavaLangString;
            localpkr.jdField_b_of_type_JavaLangString = ((pkk)localObject3).jdField_b_of_type_JavaLangString;
            localpkr.jdField_c_of_type_JavaLangString = ((pkj)localObject1).a(i, "cgi");
            localpkr.d = ((pkj)localObject1).a(i, "request_pre_process");
            localpkr.e = ((pkj)localObject1).a(i, "receive_pre_process");
            ((List)localObject2).add(localpkr);
          }
          i += 1;
        }
        localObject1 = pll.a();
        if (localObject1 != null) {
          ((pll)localObject1).a(this.jdField_b_of_type_Int, (List)localObject2);
        }
      }
      QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.jdField_a_of_type_Int), "\n", "mExposedTName = ", this.jdField_b_of_type_JavaLangString, "\n", "mClickTName = ", this.jdField_c_of_type_JavaLangString, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.jdField_b_of_type_Boolean), "\n", "bodyIsNeedIDList = ", Boolean.valueOf(bool), "\n", "bodyCGI = ", str1, "\n", "bodyReqJSMethod = ", str2, "\n", "bodyRecJSMethod = ", str3, "\n", "headerConfigSize = ", Integer.valueOf(j), "\n" });
      return;
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "initOfflineConfig \n", "mSpanCount = ", Integer.valueOf(this.jdField_a_of_type_Int), "\n", "mExposedTName = ", this.jdField_b_of_type_JavaLangString, "\n", "mClickTName = ", this.jdField_c_of_type_JavaLangString, "\n", "isSupportPullRefresh = ", Boolean.valueOf(this.jdField_b_of_type_Boolean), "\n", "config is null." });
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected String a()
  {
    return "dynamic_feeds_" + this.jdField_b_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(true);
  }
  
  protected void a(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "addHeader.");
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramView)) {
      this.jdField_a_of_type_JavaUtilList.add(paramView);
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (!((RecyclerViewWithHeaderFooter)localObject).a(paramView)) {
      ((RecyclerViewWithHeaderFooter)localObject).a(paramView);
    }
    localObject = (bksn)((RecyclerViewWithHeaderFooter)localObject).getAdapter();
    if (!((bksn)localObject).a(paramView)) {
      ((bksn)localObject).a(paramView);
    }
    b();
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.post(new ReadInJoyDynamicChannelBaseFragment.1(this));
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.post(new ReadInJoyDynamicChannelBaseFragment.2(this));
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b(View paramView)
  {
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "removeHeader.");
    RecyclerViewWithHeaderFooter localRecyclerViewWithHeaderFooter = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    localRecyclerViewWithHeaderFooter.b(paramView);
    ((bksn)localRecyclerViewWithHeaderFooter.getAdapter()).b(paramView);
    b();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void e()
  {
    super.e();
    a(true);
  }
  
  public void f()
  {
    super.f();
    a(true);
  }
  
  public void g()
  {
    super.g();
  }
  
  protected void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      b((View)localIterator.next());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Int = paramBundle.getInt("channel_id");
      this.jdField_c_of_type_Int = paramBundle.getInt("channel_type");
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("channel_name");
    }
    QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "onCreate, mChannelID = ", Integer.valueOf(this.jdField_b_of_type_Int), ", mChannelType = ", Integer.valueOf(this.jdField_c_of_type_Int), ", mChannelName = ", this.jdField_a_of_type_JavaLangString });
    m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.jdField_a_of_type_ComTencentWidgetPull2refreshXRecyclerView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment
 * JD-Core Version:    0.7.0.1
 */