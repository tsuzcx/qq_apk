package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import uxh;
import uxx;
import vab;
import vav;
import vbs;
import vdc;
import vde;
import vdq;
import vec;
import veh;
import vei;
import vks;
import vri;
import zxj;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  private vks a;
  
  private void a()
  {
    int j = 31;
    QCircleInitBean localQCircleInitBean = a();
    int i;
    if (localQCircleInitBean != null)
    {
      ExtraTypeInfo localExtraTypeInfo = localQCircleInitBean.getExtraTypeInfo();
      int k = 0;
      i = k;
      if (localExtraTypeInfo != null) {}
      switch (localExtraTypeInfo.sourceType)
      {
      default: 
        i = k;
        if (localQCircleInitBean.getTagInfo().has()) {
          i = j;
        }
        break;
      }
    }
    for (;;)
    {
      a(new QCircleReportBean().setPageId(57).setFromPageId(i).setPageIdStr(d()));
      return;
      i = 1;
      break;
      i = 3;
      break;
      i = 31;
      break;
      i = 32;
      break;
      i = 59;
      break;
      i = 69;
      break;
    }
  }
  
  public int a()
  {
    return 2131560684;
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean == null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = new QCircleReportBean();
      this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean.setPageId(c()).setFromPageId(-1).setPageIdStr(d());
    }
    j();
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public List<zxj> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Vks = new vks();
    this.jdField_a_of_type_Vks.a(a());
    localArrayList.add(this.jdField_a_of_type_Vks);
    Object localObject = new vde();
    ((vde)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new vdc());
    if (QzoneConfig.getQQCircleIsOpenDanmaku())
    {
      localObject = new vei();
      ((vei)localObject).a(a());
      localArrayList.add(localObject);
    }
    localObject = new vec();
    ((vec)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vab();
    ((vab)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new veh());
    localObject = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if (localObject != null)
    {
      if (!((QCircleInitBean)localObject).getTagInfo().has()) {
        break label233;
      }
      localObject = new vdq();
      ((vdq)localObject).a(a());
      localArrayList.add(localObject);
    }
    for (;;)
    {
      localObject = new vav();
      ((vav)localObject).a(a());
      localArrayList.add(localObject);
      return localArrayList;
      label233:
      if (((QCircleInitBean)localObject).getPoiInfo().has())
      {
        localObject = new vbs();
        ((vbs)localObject).a(a());
        localArrayList.add(localObject);
      }
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int b()
  {
    return getResources().getColor(2131167224);
  }
  
  public int c()
  {
    return 57;
  }
  
  public String c()
  {
    return "QCircleContentDetailFragment";
  }
  
  public String d()
  {
    if ((a() != null) && (a().getTagInfo().has())) {
      return "topic_page";
    }
    return "layer_page";
  }
  
  public boolean e_()
  {
    return false;
  }
  
  public void i() {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (vri.a().d()) {
      vri.a().a(c(), getActivity().getIntent());
    }
    a();
  }
  
  public boolean onBackEvent()
  {
    if (super.onBackEvent()) {}
    while (this.jdField_a_of_type_Vks == null) {
      return true;
    }
    this.jdField_a_of_type_Vks.a(0.0F, 0.0F);
    return true;
  }
  
  public void onDestroy()
  {
    uxx.a(getActivity());
    uxh.a();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */