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
import tsf;
import tsk;
import tsw;
import ttg;
import ttk;
import tua;
import tvv;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
{
  private QCircleFolderFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart;
  private List<tvv> jdField_a_of_type_JavaUtilList;
  private tsk jdField_a_of_type_Tsk;
  private ttg jdField_a_of_type_Ttg;
  
  private void c()
  {
    int i = 1;
    Intent localIntent = getActivity().getIntent();
    boolean bool = localIntent.getBooleanExtra("key_enable_splash", true);
    if (this.jdField_a_of_type_Tsk != null) {
      this.jdField_a_of_type_Tsk.a(bool);
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {}
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
    return 2131560549;
  }
  
  public String a()
  {
    return "QCircleFolderActivityFragment";
  }
  
  public List<tvv> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new tsf());
      this.jdField_a_of_type_JavaUtilList.add(new ttk(tqg.a()));
      List localList = this.jdField_a_of_type_JavaUtilList;
      Object localObject = new ttg(tqg.a());
      this.jdField_a_of_type_Ttg = ((ttg)localObject);
      localList.add(localObject);
      this.jdField_a_of_type_JavaUtilList.add(new tsw());
      localList = this.jdField_a_of_type_JavaUtilList;
      localObject = new QCircleFolderFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart = ((QCircleFolderFragmentsPart)localObject);
      localList.add(localObject);
      localList = this.jdField_a_of_type_JavaUtilList;
      localObject = new tsk();
      this.jdField_a_of_type_Tsk = ((tsk)localObject);
      localList.add(localObject);
      this.jdField_a_of_type_JavaUtilList.add(new tua());
    }
    c();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->doOnCreateView");
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
    if (this.jdField_a_of_type_Ttg != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleFolderActivityFragment", 4, bool);
      if (this.jdField_a_of_type_Ttg != null)
      {
        this.jdField_a_of_type_Ttg.a();
        this.jdField_a_of_type_Ttg.a(1);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    int i = 1;
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {}
    try
    {
      int j = Integer.parseInt(paramIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception paramIntent)
    {
      label34:
      break label34;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(i, false, false);
  }
  
  public void onResume()
  {
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderActivityFragment
 * JD-Core Version:    0.7.0.1
 */