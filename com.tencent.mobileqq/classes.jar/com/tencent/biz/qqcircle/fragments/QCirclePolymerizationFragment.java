package com.tencent.biz.qqcircle.fragments;

import aabe;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import java.util.ArrayList;
import java.util.List;
import uyn;
import uzv;
import uzz;
import vah;
import van;
import vbn;
import vee;
import vel;
import vfa;
import vfi;
import vtq;
import vtt;

public class QCirclePolymerizationFragment
  extends QCircleBaseFragment
{
  private int jdField_a_of_type_Int;
  private QCirclePolymerizationBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean;
  private List<aabe> jdField_a_of_type_JavaUtilList;
  private int b = 71;
  
  private vbn a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean == null) {
      return null;
    }
    int i = 0;
    Object localObject;
    switch (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType())
    {
    default: 
      localObject = null;
      if (localObject == null) {
        localObject = new vah(null);
      }
      break;
    }
    for (;;)
    {
      ((vbn)localObject).a(a());
      QLog.i("QCirclePolymerizationFragment", 1, "generateHeaderBlock  polymerizationType : " + this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType());
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(vtt.a("ext1", String.valueOf(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getExt1From())));
      vtq.a("", i, 1, 1, localArrayList, null, c());
      return localObject;
      localObject = new vah(null);
      this.jdField_a_of_type_Int = 8;
      i = 46;
      this.b = 71;
      break;
      localObject = new uzv(null);
      i = 48;
      this.b = 73;
      break;
      localObject = new uzz(null);
      this.jdField_a_of_type_Int = 9;
      i = 47;
      this.b = 72;
      break;
    }
  }
  
  private void a()
  {
    if (getActivity() == null) {}
    Intent localIntent;
    do
    {
      return;
      localIntent = getActivity().getIntent();
    } while ((localIntent == null) || (!localIntent.hasExtra("key_bundle_common_init_bean")));
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean = ((QCirclePolymerizationBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
  }
  
  public int a()
  {
    return 2131560774;
  }
  
  public List<aabe> a()
  {
    a();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new vel(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean));
      Object localObject1 = new ArrayList();
      Object localObject2 = a();
      if (localObject2 != null)
      {
        ((vbn)localObject2).a(a());
        ((List)localObject1).add(localObject2);
      }
      localObject2 = new van(new Bundle());
      ((van)localObject2).a(a());
      ((List)localObject1).add(localObject2);
      localObject1 = new vee((List)localObject1, 3, 2);
      ((vee)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean);
      ((vee)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      localObject1 = new vfi();
      ((vfi)localObject1).a(a());
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      if ((this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType() != 16))
      {
        localObject1 = new vfa(uyn.a());
        ((vfa)localObject1).a(a());
        if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getTagInfo() != null) {
          ((vfa)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getTagInfo());
        }
        ((vfa)localObject1).a(this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean);
        ((vfa)localObject1).a(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_JavaUtilList.add(localObject1);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public int b()
  {
    return getResources().getColor(2131167247);
  }
  
  public int c()
  {
    return this.b;
  }
  
  public String c()
  {
    return "QCirclePolymerizationFragment";
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePolymerizationFragment
 * JD-Core Version:    0.7.0.1
 */