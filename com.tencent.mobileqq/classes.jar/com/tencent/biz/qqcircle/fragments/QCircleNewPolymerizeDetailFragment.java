package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.adapter.QCircleInsFeedAdapter;
import com.tencent.biz.qqcircle.adapter.QCircleWaterfallFeedsBlock;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleGoHomeButtonPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleNewPolymerizeDetailBodyPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePolymerizeDetailTitlePart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleSplashTransitionPart;
import com.tencent.biz.richframework.part.Part;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.List;

public class QCircleNewPolymerizeDetailFragment
  extends QCircleBaseFragment
{
  private List<Part> c;
  private QCirclePolymerizeDetailBean d;
  private int e;
  private String f;
  private int g = -1;
  
  private void u()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      this.d = ((QCirclePolymerizeDetailBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean"));
      localObject = this.d;
      if (localObject == null) {
        return;
      }
      int i = ((QCirclePolymerizeDetailBean)localObject).getPageId();
      if (i != 69)
      {
        if (i != 83)
        {
          if (i != 85) {
            return;
          }
          this.e = 76;
          this.g = 851;
          this.f = "pg_xsj_flowpage_rec_by_qzone_v865";
          return;
        }
        this.e = 71;
        this.g = 831;
        this.f = "pg_xsj_flowpage_group_updates_v865";
        return;
      }
      this.e = 54;
      this.g = 691;
      this.f = "pg_xsj_feed_details_and_rec_v865";
    }
  }
  
  public int a()
  {
    return this.g;
  }
  
  public String b()
  {
    return "QCircleNewPolymerizeDetailFragment";
  }
  
  protected int c()
  {
    return 2131626910;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.c.add(new QCirclePolymerizeDetailTitlePart());
      Object localObject1 = new ArrayList();
      Object localObject2 = new QCircleInsFeedAdapter(null);
      ((QCircleInsFeedAdapter)localObject2).setReportBean(n());
      ((List)localObject1).add(localObject2);
      localObject2 = new QCircleWaterfallFeedsBlock(new Bundle()).c(0);
      ((QCircleWaterfallFeedsBlock)localObject2).setReportBean(n());
      ((List)localObject1).add(localObject2);
      localObject1 = new QCircleNewPolymerizeDetailBodyPart((List)localObject1, 3, 2);
      ((QCircleNewPolymerizeDetailBodyPart)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleCommentPanelPart();
      ((QCircleCommentPanelPart)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleLightInteractListPart();
      ((QCircleLightInteractListPart)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleSharePartV2();
      ((QCircleSharePartV2)localObject1).a(n());
      this.c.add(localObject1);
      localObject1 = new QCircleGoHomeButtonPart();
      ((QCircleGoHomeButtonPart)localObject1).a(this.e);
      this.c.add(localObject1);
      localObject1 = new QCircleSplashTransitionPart();
      ((QCircleSplashTransitionPart)localObject1).a(n());
      this.c.add(localObject1);
    }
    return this.c;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleNewPolymerizeDetailFragment
 * JD-Core Version:    0.7.0.1
 */