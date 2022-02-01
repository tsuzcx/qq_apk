package com.tencent.biz.qqcircle.fragments;

import aabg;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import uys;
import uyy;
import uzg;

public abstract class QCircleBaseFragment
  extends BasePartFragment
  implements aabg<QCircleReportBean>
{
  public static final ISPBandwidthPredictor a;
  protected QCircleReportBean a;
  
  static
  {
    jdField_a_of_type_ComTencentSuperplayerApiISPBandwidthPredictor = SuperPlayerFactory.createBandwidthPredictor(BaseApplicationImpl.getContext());
  }
  
  public QCircleInitBean a()
  {
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      return (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    return null;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean == null) {
      this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = new QCircleReportBean();
    }
    j();
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean.setPageId(c()).setPageIdStr(d());
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d(c(), 1, c() + "->doOnCreateView");
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(c(), paramQCircleReportBean);
  }
  
  public int b()
  {
    return uzg.a();
  }
  
  public abstract int c();
  
  public abstract String c();
  
  public abstract String d();
  
  public void i()
  {
    QLog.d(c(), 1, c() + "->onBackPressed");
  }
  
  protected void j()
  {
    if (getActivity() == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().getIntent();
      } while ((localObject == null) || (!((Intent)localObject).hasExtra("key_bundle_common_init_bean")));
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
    } while ((localObject == null) || (((QCircleInitBean)localObject).getFromReportBean() == null) || (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean == null));
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean.assembleFromReportData(((QCircleInitBean)localObject).getFromReportBean());
  }
  
  public void onAttach(Activity paramActivity)
  {
    QLog.d(c(), 1, c() + "->onAttach");
    super.onAttach(paramActivity);
  }
  
  public void onDestroy()
  {
    QLog.d(c(), 1, c() + "->onDestroy");
    super.onDestroy();
    uyy.a().a();
    uys.a();
  }
  
  public void onDetach()
  {
    QLog.d(c(), 1, c() + "->onDetach");
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    if (getActivity() != null) {
      jdField_a_of_type_ComTencentSuperplayerApiISPBandwidthPredictor.stop(getActivity());
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (getActivity() != null) {
      jdField_a_of_type_ComTencentSuperplayerApiISPBandwidthPredictor.start(getActivity());
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(c(), 1, c() + "->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
 * JD-Core Version:    0.7.0.1
 */