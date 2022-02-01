package com.tencent.biz.qqcircle.fragments.main;

import aabe;
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
import vbr;
import vcv;
import vdj;

public class QCircleAggregationActivityFragment
  extends QCircleBaseFragment
{
  private QCircleAggregationFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart;
  private List<aabe> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    getActivity().getIntent();
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a(-1);
    }
  }
  
  public int a()
  {
    return 2131560684;
  }
  
  public List<aabe> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject = new vcv();
      ((vcv)localObject).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new vdj();
      ((vdj)localObject).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new vbr();
      ((vbr)localObject).a(this);
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
    QLog.d("QCircleAggregationActivityFragment", 1, "QCircleAggregationActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleAggregationFragmentsPart.a(1, false, false);
    }
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