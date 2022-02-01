package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import oiz;
import ojc;
import pil;

public class ReadInJoySubChannelFragment
  extends ReadInJoyBaseFragment
{
  public static final String a;
  protected int a;
  protected View a;
  protected oiz a;
  protected int b;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoySubChannelFragment.class.getName();
  }
  
  public ReadInJoySubChannelFragment()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public static ReadInJoySubChannelFragment a(int paramInt1, int paramInt2, String paramString)
  {
    ReadInJoySubChannelFragment localReadInJoySubChannelFragment = new ReadInJoySubChannelFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt1);
    localBundle.putInt("channel_type", paramInt2);
    localBundle.putString("channel_name", paramString);
    localReadInJoySubChannelFragment.setArguments(localBundle);
    return localReadInJoySubChannelFragment;
  }
  
  private void a()
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d((String)localObject, 2, new Object[] { "initUI, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
      localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131375979);
      this.jdField_a_of_type_Oiz = new oiz(getActivity());
      this.jdField_a_of_type_Oiz.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Oiz.b(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Oiz.a((ViewGroup)localObject);
      this.jdField_a_of_type_Oiz.a();
      localObject = (ViewGroup)this.jdField_a_of_type_Oiz.a();
      int i = b();
      if (i > 0) {
        ((ViewGroup)localObject).setPadding(0, i, 0, 0);
      }
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_Oiz != null)
    {
      this.jdField_a_of_type_Oiz.a(true);
      return;
    }
    ojc.e(a());
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Oiz != null)
    {
      this.jdField_a_of_type_Oiz.h();
      paramActivity = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
      if (paramActivity != null)
      {
        paramBundle = paramActivity.a();
        if ((paramActivity.b()) && (paramBundle != null)) {
          this.jdField_a_of_type_Oiz.a(true);
        }
      }
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.g();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("channel_id");
      this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("channel_type");
      this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("channel_name");
    }
    localObject = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d((String)localObject, 2, new Object[] { "onCreate, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    boolean bool = false;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560194, paramViewGroup, false);
    a();
    VideoReport.setPageId(this.jdField_a_of_type_AndroidViewView, "14");
    VideoReport.setPageParams(this.jdField_a_of_type_AndroidViewView, new pil().a(Integer.valueOf(this.jdField_a_of_type_Int)).a());
    paramLayoutInflater = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(paramLayoutInflater, 2, new Object[] { "onCreateView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroy, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onDestroy();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.d();
    }
    this.jdField_a_of_type_Oiz = null;
  }
  
  public void onDestroyView()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onDestroyView, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onDestroyView();
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void onPause()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onPause, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int), ", mIsShowingSelf = ", Boolean.valueOf(this.c) });
    super.onPause();
    if ((this.jdField_a_of_type_Oiz != null) && (this.c)) {
      this.jdField_a_of_type_Oiz.g();
    }
  }
  
  public void onResume()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onResume, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int), ", mIsShowingSelf = ", Boolean.valueOf(this.c) });
    super.onResume();
    if ((this.jdField_a_of_type_Oiz != null) && (this.c)) {
      this.jdField_a_of_type_Oiz.h();
    }
  }
  
  public void onStart()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onStart, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onStart();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.e();
    }
  }
  
  public void onStop()
  {
    boolean bool = false;
    String str = jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_Oiz != null) {
      bool = true;
    }
    QLog.d(str, 2, new Object[] { "onStop, mViewController = ", Boolean.valueOf(bool), ", mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
    super.onStop();
    if (this.jdField_a_of_type_Oiz != null) {
      this.jdField_a_of_type_Oiz.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySubChannelFragment
 * JD-Core Version:    0.7.0.1
 */