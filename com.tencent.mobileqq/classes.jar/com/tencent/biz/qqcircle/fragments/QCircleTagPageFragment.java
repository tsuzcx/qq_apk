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
import trl;
import trn;
import trx;
import tsp;
import tsv;
import ttc;
import ttj;
import tvg;
import tyj;
import tym;

public class QCircleTagPageFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private List<tvg> jdField_a_of_type_JavaUtilList;
  
  private void b()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean"))) {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
    }
  }
  
  public int a()
  {
    return 2131560577;
  }
  
  public List<tvg> a()
  {
    b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new ttj(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean));
      Object localObject = new ArrayList();
      ((List)localObject).add(new trn(null));
      ((List)localObject).add(new trl(new Bundle()));
      localObject = new ttc((List)localObject, 3, 1);
      ((ttc)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new tsv();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      localObject = new tsp(tqg.a());
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
        ((tsp)localObject).a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
      }
      ((tsp)localObject).a(5);
      localObject = new trx();
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      ((trx)localObject).a(true);
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    tym.a().a(31);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    tyj.a("", 6, 1L);
    if (tym.a().b(31)) {
      tym.a().a(getActivity().getIntent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleTagPageFragment
 * JD-Core Version:    0.7.0.1
 */