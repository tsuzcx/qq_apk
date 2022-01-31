package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import java.util.ArrayList;
import java.util.List;
import tqg;
import trq;
import trs;
import tsc;
import tsw;
import ttg;
import ttl;
import ttr;
import tty;
import tvv;
import tzv;
import tzy;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private List<tvv> jdField_a_of_type_JavaUtilList;
  
  private void b()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  public int a()
  {
    return 2131560594;
  }
  
  public String a()
  {
    return "QCircleTagPageFragment";
  }
  
  public List<tvv> a()
  {
    b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new tty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean));
      Object localObject = new ArrayList();
      ((List)localObject).add(new trs(null));
      ((List)localObject).add(new trq(new Bundle()));
      localObject = new ttr((List)localObject, 3, 1);
      ((ttr)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new ttl();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new ttg(tqg.a());
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
        ((ttg)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
      }
      ((ttg)localObject).a(5);
      localObject = new tsc();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      ((tsc)localObject).a(true);
      this.jdField_a_of_type_JavaUtilList.add(new tsw());
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    tzy.a().a(31);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    tzv.a("", 6, 1L);
    if (tzy.a().b(31)) {
      tzy.a().a(getActivity().getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */