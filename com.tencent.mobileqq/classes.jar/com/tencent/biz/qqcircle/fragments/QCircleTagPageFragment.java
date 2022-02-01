package com.tencent.biz.qqcircle.fragments;

import aabe;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import java.util.ArrayList;
import java.util.List;
import uyn;
import uzt;
import vag;
import vbo;
import vbr;
import vdj;
import vfa;
import vfg;
import vfi;
import vfx;
import vge;
import vgl;
import vtq;
import vtt;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean;
  private List<aabe> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    if (getActivity() == null) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = getActivity().getIntent();
    } while ((localIntent == null) || (!localIntent.hasExtra("key_bundle_common_init_bean")));
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  public int a()
  {
    return 2131560812;
  }
  
  public List<aabe> a()
  {
    a();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new vge(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean));
      Object localObject1 = new ArrayList();
      Object localObject2 = new vag(null);
      ((vag)localObject2).a(a());
      ((List)localObject1).add(localObject2);
      localObject2 = new uzt(new Bundle());
      ((uzt)localObject2).a(a());
      ((List)localObject1).add(localObject2);
      localObject1 = new vfx((List)localObject1, 3, 1);
      ((vfx)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vfi();
      ((vfi)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vfa(uyn.a());
      ((vfa)localObject1).a(a());
      if ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo() != null)) {
        ((vfa)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCircleInitBean.getTagInfo());
      }
      ((vfa)localObject1).a(5);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vbo();
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      ((vbo)localObject1).a(true);
      localObject1 = new vdj();
      ((vdj)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vbr();
      ((vbr)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new vgl());
      this.jdField_a_of_type_JavaUtilList.add(new vfg());
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public int c()
  {
    return 31;
  }
  
  public String c()
  {
    return "QCircleTagPageFragment";
  }
  
  public String d()
  {
    return null;
  }
  
  public void i()
  {
    vtt.a().b(c());
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    vtq.a("", 6, 1);
    if (vtt.a().d()) {
      vtt.a().a(c(), getActivity().getIntent());
    }
    vtt.a().a(c());
  }
  
  public void onPause()
  {
    super.onPause();
    vtt.a().d(c());
  }
  
  public void onResume()
  {
    super.onResume();
    vtt.a().c(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */