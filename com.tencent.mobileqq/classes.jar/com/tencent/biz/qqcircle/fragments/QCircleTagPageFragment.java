package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import java.util.ArrayList;
import java.util.List;
import uxc;
import uyk;
import uyu;
import uzy;
import vab;
import vbt;
import vcw;
import vdc;
import vde;
import vdt;
import vea;
import veh;
import vrf;
import vri;
import zxj;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private List<zxj> jdField_a_of_type_JavaUtilList;
  
  private void a()
  {
    if (getActivity() == null) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = getActivity().getIntent();
    } while ((localIntent == null) || (!localIntent.hasExtra("key_bundle_common_init_bean")));
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  public int a()
  {
    return 2131560786;
  }
  
  public List<zxj> a()
  {
    a();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new vea(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean));
      Object localObject1 = new ArrayList();
      Object localObject2 = new uyu(null);
      ((uyu)localObject2).a(a());
      ((List)localObject1).add(localObject2);
      localObject2 = new uyk(new Bundle());
      ((uyk)localObject2).a(a());
      ((List)localObject1).add(localObject2);
      localObject1 = new vdt((List)localObject1, 3, 1);
      ((vdt)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vde();
      ((vde)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vcw(uxc.a());
      ((vcw)localObject1).a(a());
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
        ((vcw)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
      }
      ((vcw)localObject1).a(5);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new uzy();
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      ((uzy)localObject1).a(true);
      localObject1 = new vbt();
      ((vbt)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vab();
      ((vab)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(new veh());
      this.jdField_a_of_type_JavaUtilList.add(new vdc());
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
    vri.a().b(c());
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    vrf.a("", 6, 1);
    if (vri.a().d()) {
      vri.a().a(c(), getActivity().getIntent());
    }
    vri.a().a(c());
  }
  
  public void onPause()
  {
    super.onPause();
    vri.a().d(c());
  }
  
  public void onResume()
  {
    super.onResume();
    vri.a().c(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */