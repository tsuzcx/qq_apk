package com.tencent.biz.qqcircle.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import tqg;
import tsa;
import tsf;
import tsp;
import tsu;
import ttl;
import tvg;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
{
  private QCircleFolderFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart;
  private List<tvg> jdField_a_of_type_JavaUtilList;
  private tsf jdField_a_of_type_Tsf;
  private tsp jdField_a_of_type_Tsp;
  
  private void c()
  {
    Intent localIntent = getActivity().getIntent();
    boolean bool = localIntent.getBooleanExtra("key_enable_splash", false);
    if (this.jdField_a_of_type_Tsf != null) {
      this.jdField_a_of_type_Tsf.a(bool);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {
      i = 1;
    }
    try
    {
      int j = Integer.parseInt(localIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(i);
  }
  
  public int a()
  {
    return 2131560547;
  }
  
  public List<tvg> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new tsa());
      this.jdField_a_of_type_JavaUtilList.add(new tsu(tqg.a()));
      List localList = this.jdField_a_of_type_JavaUtilList;
      Object localObject = new tsp(tqg.a());
      this.jdField_a_of_type_Tsp = ((tsp)localObject);
      localList.add(localObject);
      localList = this.jdField_a_of_type_JavaUtilList;
      localObject = new QCircleFolderFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart = ((QCircleFolderFragmentsPart)localObject);
      localList.add(localObject);
      localList = this.jdField_a_of_type_JavaUtilList;
      localObject = new tsf();
      this.jdField_a_of_type_Tsf = ((tsf)localObject);
      localList.add(localObject);
      this.jdField_a_of_type_JavaUtilList.add(new ttl());
    }
    c();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup != null) {}
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramViewGroup.setFitsSystemWindows(true);
        paramViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()) - 1, 0, 0);
        new FrameLayout.LayoutParams(-1, -1);
      }
      super.a(paramLayoutInflater, paramViewGroup, paramBundle);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onWriteClick?");
    if (this.jdField_a_of_type_Tsp != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleFolderActivityFragment", 4, bool);
      if (this.jdField_a_of_type_Tsp != null)
      {
        this.jdField_a_of_type_Tsp.a();
        this.jdField_a_of_type_Tsp.a(1);
      }
      return;
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {
      i = 1;
    }
    try
    {
      int j = Integer.parseInt(paramIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception paramIntent)
    {
      label26:
      break label26;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(i, false, false);
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderActivityFragment
 * JD-Core Version:    0.7.0.1
 */