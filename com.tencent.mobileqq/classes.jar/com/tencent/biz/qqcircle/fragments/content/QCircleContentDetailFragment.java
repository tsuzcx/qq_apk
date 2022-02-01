package com.tencent.biz.qqcircle.fragments.content;

import aabe;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StPoiInfoV2;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.List;
import uys;
import uzg;
import vbr;
import vcl;
import vdi;
import vfg;
import vfi;
import vfu;
import vgg;
import vgl;
import vgm;
import vmw;
import vtt;

public class QCircleContentDetailFragment
  extends QCircleBaseFragment
{
  private vmw a;
  
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
    return 2131560701;
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
  
  public List<aabe> a()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Vmw = new vmw();
    this.jdField_a_of_type_Vmw.a(a());
    localArrayList.add(this.jdField_a_of_type_Vmw);
    Object localObject = new vfi();
    ((vfi)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new vfg());
    if (QzoneConfig.getQQCircleIsOpenDanmaku())
    {
      localObject = new vgm();
      ((vgm)localObject).a(a());
      localArrayList.add(localObject);
    }
    localObject = new vgg();
    ((vgg)localObject).a(a());
    localArrayList.add(localObject);
    localObject = new vbr();
    ((vbr)localObject).a(a());
    localArrayList.add(localObject);
    localArrayList.add(new vgl());
    localObject = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if (localObject != null)
    {
      if (!((QCircleInitBean)localObject).getTagInfo().has()) {
        break label233;
      }
      localObject = new vfu();
      ((vfu)localObject).a(a());
      localArrayList.add(localObject);
    }
    for (;;)
    {
      localObject = new vcl();
      ((vcl)localObject).a(a());
      localArrayList.add(localObject);
      return localArrayList;
      label233:
      if (((QCircleInitBean)localObject).getPoiInfo().has())
      {
        localObject = new vdi();
        ((vdi)localObject).a(a());
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
    return getResources().getColor(2131167247);
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
    if (vtt.a().d()) {
      vtt.a().a(c(), getActivity().getIntent());
    }
    a();
  }
  
  public boolean onBackEvent()
  {
    if (super.onBackEvent()) {}
    while (this.jdField_a_of_type_Vmw == null) {
      return true;
    }
    this.jdField_a_of_type_Vmw.a(0.0F, 0.0F);
    return true;
  }
  
  public void onDestroy()
  {
    uzg.a(getActivity());
    uys.a();
    super.onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
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
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentDetailFragment
 * JD-Core Version:    0.7.0.1
 */