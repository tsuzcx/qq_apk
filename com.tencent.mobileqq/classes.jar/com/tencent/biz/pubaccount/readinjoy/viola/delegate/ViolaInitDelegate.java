package com.tencent.biz.pubaccount.readinjoy.viola.delegate;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaCreactPageObject;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.ViolaViewListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ViolaInitDelegate
{
  private int jdField_a_of_type_Int = 0;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private ViolaInitDelegate.ViolaGestureLayoutStateChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate$ViolaGestureLayoutStateChangeListener;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<ViolaBaseView> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public ViolaInitDelegate(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  private ViolaBaseView.ViolaCreactPageObject a(JSONObject paramJSONObject)
  {
    return new ViolaBaseView.ViolaCreactPageObject(this.jdField_a_of_type_JavaLangString, paramJSONObject, a(this.jdField_a_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return null;
      }
      paramString = FileUtils.a("viola_cache_file_" + paramString + "_" + localAppRuntime.getAccount());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
      return null;
    }
    return null;
  }
  
  private void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getArguments());
    HashMap localHashMap = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getSusConfigMap();
    if (localHashMap.containsKey(ViolaUiDelegate.n)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setBorderRadius(((Integer)localHashMap.get(ViolaUiDelegate.n)).intValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.o)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentMarginTop(((Integer)localHashMap.get(ViolaUiDelegate.o)).intValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.u)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setTitleBarHeight(((Integer)localHashMap.get(ViolaUiDelegate.u)).intValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.p)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsShowGrayBar(((Boolean)localHashMap.get(ViolaUiDelegate.p)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.r)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedShowBackView(((Boolean)localHashMap.get(ViolaUiDelegate.r)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.q)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(((Boolean)localHashMap.get(ViolaUiDelegate.q)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.s)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(((Boolean)localHashMap.get(ViolaUiDelegate.s)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.y)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContainerColor(Color.parseColor((String)localHashMap.get(ViolaUiDelegate.y)));
    }
    if (localHashMap.containsKey(ViolaUiDelegate.j)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(((Boolean)localHashMap.get(ViolaUiDelegate.j)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.B)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedChangeTitleAlpha(((Boolean)localHashMap.get(ViolaUiDelegate.B)).booleanValue());
    }
    if (localHashMap.containsKey(ViolaUiDelegate.C)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedGrayBarFloat(((Boolean)localHashMap.get(ViolaUiDelegate.C)).booleanValue());
    }
    paramViewGroup = (FrameLayout)paramViewGroup.findViewById(2131381682);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new ViolaInitDelegate.5(this, paramViewGroup));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), -1, -1, true);
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  }
  
  public ViolaBaseView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("url");
      this.jdField_b_of_type_JavaLangString = paramBundle.getString("colorBallData");
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.setBackgroundColor(0);
    paramViewGroup.setLayerType(2, null);
    b(paramViewGroup);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInitDelegate.1(this), 150L);
  }
  
  public void a(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2, ViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131381681));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    if (!paramBoolean1) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(paramViolaViewListener);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    paramViewGroup = a(paramJSONObject);
    if (paramBoolean2) {
      paramViewGroup.a();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, paramViewGroup);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().doOnBackPressed();
    } while (!paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().overridePendingTransition(2130772236, 2130772239);
    return;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
  }
  
  public void a(ViolaInitDelegate.ViolaGestureLayoutStateChangeListener paramViolaGestureLayoutStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaDelegateViolaInitDelegate$ViolaGestureLayoutStateChangeListener = paramViolaGestureLayoutStateChangeListener;
  }
  
  public void a(ViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramViolaViewListener);
  }
  
  public void a(Object paramObject) {}
  
  public void a(Object paramObject, String paramString) {}
  
  public void a(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      String str = ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString);
      if ((TextUtils.isEmpty(str)) || (!str.equals(ViolaUtils.getPageName(paramString)))) {}
    }
    for (paramString = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);; paramString = null)
    {
      if (paramString != null) {
        paramString.a(ViolaBizUtils.c().toString());
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    String str;
    int j;
    int i;
    if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.optString("url"))))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(true);
      }
      str = paramJSONObject.optString("url");
      j = paramJSONObject.optInt("position", 0);
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label289;
      }
      if (!ViolaUtils.getPageName(str).equals(ViolaUtils.getPageName(((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString))) {
        break label141;
      }
    }
    label141:
    label289:
    for (Object localObject = (ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i);; localObject = null)
    {
      if (localObject != null) {
        if (j != this.jdField_b_of_type_Int)
        {
          ((ViolaBaseView)localObject).a(ViolaBizUtils.a(paramJSONObject).toString());
          this.jdField_b_of_type_Int = j;
          this.c = str;
        }
      }
      while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity() == null))
      {
        return;
        i += 1;
        break;
      }
      paramJSONObject = new ViolaBaseView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), Boolean.valueOf(true));
      paramJSONObject.setListener(new ViolaInitDelegate.4(this));
      localObject = str + "&firstCreated=1";
      paramJSONObject.setPageStartTime(System.currentTimeMillis());
      paramJSONObject.a((String)localObject, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, new ViolaBaseView.ViolaCreactPageObject((String)localObject, new JSONObject(), a((String)localObject), 0, null));
      this.jdField_a_of_type_JavaUtilArrayList.add(paramJSONObject);
      if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) {
        this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.notifyDataSetChanged();
      }
      this.c = ((String)localObject);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      b(true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startSession", 1);
      b(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("ViolaInitDelegate", 1, "setUserVisibleHint Exception " + localException.getMessage());
    }
    b(false);
    return;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null;
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = new ViewPagerCompat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new ViolaInitDelegate.2(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new ViolaInitDelegate.3(this));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramString);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.d();
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      b(true);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      b(false);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if ((this.jdField_a_of_type_JavaUtilArrayList.get(i) instanceof ViolaBaseView)) {
        ((ViolaBaseView)this.jdField_a_of_type_JavaUtilArrayList.get(i)).onActivityDestroy();
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null)
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
      if (i >= 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(i - 1);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity().doOnBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate
 * JD-Core Version:    0.7.0.1
 */