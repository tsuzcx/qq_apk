package com.tencent.biz.qqcircle.immersive.tab;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

public class QFSRecommendTabFragment
  extends QFSBaseLayerTabFragment
{
  protected QFSRecommendTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  public void X()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      QCircleFolderBean localQCircleFolderBean = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleFolderBean != null) {
        this.w = localQCircleFolderBean.hasRedDotShownOnEntrance();
      }
    }
  }
  
  public int a()
  {
    return 503;
  }
  
  public String b()
  {
    return "QFSRecommendTabFragment";
  }
  
  protected int c()
  {
    return 2131627120;
  }
  
  protected String f()
  {
    return "pg_xsj_explore_page";
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setPageId(a()).setActionType(23).setSubActionType(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSRecommendTabFragment
 * JD-Core Version:    0.7.0.1
 */