package com.tencent.biz.qqcircle.fragments.main;

import aabe;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launchbean.QCircleFolderBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import uyn;
import vbr;
import vcv;
import vda;
import vdj;
import vfa;
import vfe;
import vff;
import vgg;
import vgl;

public class QCircleFolderActivityFragment
  extends QCircleBaseFragment
{
  private QCircleFolderFragmentsPart jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart;
  private List<aabe> jdField_a_of_type_JavaUtilList;
  private vda jdField_a_of_type_Vda;
  private vfa jdField_a_of_type_Vfa;
  
  private void b()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (this.jdField_a_of_type_Vda != null) {
        this.jdField_a_of_type_Vda.a(localQCircleFolderBean.isEnableSplash());
      }
      if ((localQCircleFolderBean.getAssignShowTabType() != -1) && (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null)) {
        this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(localQCircleFolderBean.getAssignShowTabType());
      }
    }
  }
  
  public int a()
  {
    return 2131560728;
  }
  
  public List<aabe> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      Object localObject1 = new vcv();
      ((vcv)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new vfe(uyn.a()));
      this.jdField_a_of_type_Vfa = new vfa(uyn.a());
      this.jdField_a_of_type_Vfa.a(this);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Vfa);
      localObject1 = new vdj();
      ((vdj)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vbr();
      ((vbr)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      Object localObject2 = new QCircleFolderFragmentsPart();
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart = ((QCircleFolderFragmentsPart)localObject2);
      ((List)localObject1).add(localObject2);
      localObject1 = this.jdField_a_of_type_JavaUtilList;
      localObject2 = new vda();
      this.jdField_a_of_type_Vda = ((vda)localObject2);
      ((List)localObject1).add(localObject2);
      localObject1 = new vgg();
      ((vgg)localObject1).a(this);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new vgl());
      this.jdField_a_of_type_JavaUtilList.add(new vff());
    }
    b();
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("onWriteClick?");
    if (this.jdField_a_of_type_Vfa != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleFolderActivityFragment", 4, bool);
      if (this.jdField_a_of_type_Vfa != null)
      {
        this.jdField_a_of_type_Vfa.a();
        this.jdField_a_of_type_Vfa.a(1);
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
    QLog.d("QCircleFolderActivityFragment", 1, "QCircleFolderActivityFragment->onNewIntent");
    super.onNewIntent(paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart != null)
    {
      paramIntent = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      this.jdField_a_of_type_ComTencentBizQqcircleBizpartsQCircleFolderFragmentsPart.a(paramIntent.getAssignShowTabType(), false, false);
    }
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