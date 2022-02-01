package com.tencent.biz.qqcircle.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import uxc;
import vab;
import vbf;
import vbk;
import vbt;
import vcw;
import vda;
import vdb;
import vec;
import veh;
import vja;
import zxj;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
{
  private QCircleFolderFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart;
  private List<zxj> jdField_a_of_type_JavaUtilList;
  private vbk jdField_a_of_type_Vbk;
  private vcw jdField_a_of_type_Vcw;
  
  private void b()
  {
    Intent localIntent = getActivity().getIntent();
    boolean bool = localIntent.getBooleanExtra("key_enable_splash", true);
    if (this.jdField_a_of_type_Vbk != null) {
      this.jdField_a_of_type_Vbk.a(bool);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {
      i = -1;
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
    if (!localIntent.getBooleanExtra("key_enable_page_memory_cache", true))
    {
      vja.a().a(1);
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(1);
      }
    }
  }
  
  public int a()
  {
    return 2131560711;
  }
  
  public List<zxj> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject1 = new vbf();
      ((vbf)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new vda(uxc.a()));
      this.jdField_a_of_type_Vcw = new vcw(uxc.a());
      this.jdField_a_of_type_Vcw.a(this);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vcw);
      localObject1 = new vbt();
      ((vbt)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vab();
      ((vab)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      Object localObject2 = new QCircleFolderFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart = ((QCircleFolderFragmentsPart)localObject2);
      ((List)localObject1).add(localObject2);
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      localObject2 = new vbk();
      this.jdField_a_of_type_Vbk = ((vbk)localObject2);
      ((List)localObject1).add(localObject2);
      localObject1 = new vec();
      ((vec)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new veh());
      this.jdField_a_of_type_JavaUtilList.add(new vdb());
    }
    b();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onWriteClick?");
    if (this.jdField_a_of_type_Vcw != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleFolderActivityFragment", 4, bool);
      if (this.jdField_a_of_type_Vcw != null)
      {
        this.jdField_a_of_type_Vcw.a();
        this.jdField_a_of_type_Vcw.a(1);
      }
      return;
    }
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
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a();
    }
    return 0;
  }
  
  public String c()
  {
    return "QCircleFolderActivityFragment";
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a() == 1) {
        return "follow_page";
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a() == 3) {
        return "explore_page";
      }
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderActivityFragment
 * JD-Core Version:    0.7.0.1
 */