package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailBodyPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailTitlePart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

public class QCirclePolymerizeDetailFragment
  extends QCircleBaseFragment
{
  private QCirclePolymerizeDetailBean c;
  private List<Part> d;
  private int e;
  private String f;
  
  private void u()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      this.c = ((QCirclePolymerizeDetailBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean"));
      localObject = this.c;
      if (localObject == null) {
        return;
      }
      switch (((QCirclePolymerizeDetailBean)localObject).getPageId())
      {
      case 86: 
      case 87: 
      default: 
        return;
      case 89: 
        this.e = 85;
        this.f = "pg_xsj_flowpage_robot_daily_report";
        return;
      case 88: 
        this.e = 84;
        this.f = "pg_xsj_flowpage_robot_hashtag";
        return;
      case 85: 
        this.e = 76;
        this.f = "pg_xsj_flowpage_rec_by_qzone";
        return;
      case 84: 
        this.e = 72;
        return;
      }
      this.e = 71;
      this.f = "pg_xsj_flowpage_group_updates";
    }
  }
  
  public int a()
  {
    QCirclePolymerizeDetailBean localQCirclePolymerizeDetailBean = this.c;
    if (localQCirclePolymerizeDetailBean != null) {
      return localQCirclePolymerizeDetailBean.getPageId();
    }
    return 1;
  }
  
  public String b()
  {
    return "QCirclePolymerizeDetailFragment";
  }
  
  protected int c()
  {
    return 2131626910;
  }
  
  protected List<Part> d()
  {
    if (this.d == null)
    {
      this.d = new ArrayList();
      this.d.add(new QCirclePolymerizeDetailTitlePart());
      Object localObject = new ArrayList();
      QCircleInsFeedAdapter localQCircleInsFeedAdapter = new QCircleInsFeedAdapter(null);
      ((List)localObject).add(localQCircleInsFeedAdapter);
      localQCircleInsFeedAdapter.setReportBean(n());
      localObject = new QCirclePolymerizeDetailBodyPart((List)localObject, 3, 1);
      ((QCirclePolymerizeDetailBodyPart)localObject).a(this.c);
      ((QCirclePolymerizeDetailBodyPart)localObject).a(n());
      this.d.add(localObject);
      localObject = new QCircleSharePartV2();
      ((QCircleSharePartV2)localObject).a(n());
      this.d.add(localObject);
      localObject = new QCircleCommentPanelPart();
      ((QCircleCommentPanelPart)localObject).a(n());
      this.d.add(localObject);
      localObject = new QCircleLightInteractListPart();
      ((QCircleLightInteractListPart)localObject).a(n());
      this.d.add(localObject);
      localObject = new QCircleGoHomeButtonPart();
      ((QCircleGoHomeButtonPart)localObject).a(this.e);
      this.d.add(localObject);
      localObject = new QCircleSplashTransitionPart();
      ((QCircleSplashTransitionPart)localObject).a(n());
      this.d.add(localObject);
    }
    return this.d;
  }
  
  protected String f()
  {
    return this.f;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(32);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (getActivity() == null) {
      return;
    }
    u();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
  
  public void onPause()
  {
    super.onPause();
    QCircleReportHelper.getInstance().recordPageEndShow(a(), g());
  }
  
  public void onResume()
  {
    super.onResume();
    QCircleReportHelper.getInstance().recordPageStartShow(a());
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(this.e).setSubActionType(1).setThrActionType(1).setvid(""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePolymerizeDetailFragment
 * JD-Core Version:    0.7.0.1
 */