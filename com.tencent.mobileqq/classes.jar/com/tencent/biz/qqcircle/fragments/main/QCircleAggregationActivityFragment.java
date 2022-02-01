package com.tencent.biz.qqcircle.fragments.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleAggregationFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import vab;
import vbf;
import vbt;
import zxj;

public class QCircleAggregationActivityFragment
  extends QCircleBaseFragment
{
  private QCircleAggregationFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart;
  private List<zxj> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    Intent localIntent = getActivity().getIntent();
    int i;
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null) {
      i = -1;
    }
    try
    {
      int j = Integer.parseInt(localIntent.getStringExtra("key_first_show_tab"));
      i = j;
    }
    catch (Exception localException)
    {
      label29:
      break label29;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a(i);
  }
  
  public int a()
  {
    return 2131560669;
  }
  
  public List<zxj> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject = new vbf();
      ((vbf)localObject).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new vbt();
      ((vbt)localObject).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new vab();
      ((vab)localObject).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = this.jdField_a_of_type_JavaUtilList;
      QCircleAggregationFragmentsPart localQCircleAggregationFragmentsPart = new QCircleAggregationFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart = localQCircleAggregationFragmentsPart;
      ((List)localObject).add(localQCircleAggregationFragmentsPart);
    }
    a();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("QCircleAggregationActivityFragment", 1, "QCircleAggregationActivityFragment->doOnCreateView");
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
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null) {
      return this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a();
    }
    return 0;
  }
  
  public String c()
  {
    return "QCircleAggregationActivityFragment";
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a() == 1) {
        return "follow_page";
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a() == 3) {
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
    QLog.d("QCircleAggregationActivityFragment", 1, "QCircleAggregationActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null) {}
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
    this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a(i, false, false);
  }
  
  public void onResume()
  {
    QLog.d("QCircleAggregationActivityFragment", 1, "QCircleAggregationActivityFragment->onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleAggregationActivityFragment
 * JD-Core Version:    0.7.0.1
 */