package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QCircleSharePartV2;
import com.tencent.biz.qqcircle.bizparts.QCircleTaskCenterPart;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFolderIoc;
import com.tencent.biz.qqcircle.immersive.part.QFSMainChipPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMessageNoticePart;
import com.tencent.biz.qqcircle.immersive.part.QFSPublishFeedPart;
import com.tencent.biz.qqcircle.immersive.part.QFSPublishStatusBoxPart;
import com.tencent.biz.qqcircle.immersive.part.QFSSearchEntrancePart;
import com.tencent.biz.qqcircle.immersive.part.QFSTopPopBannerPart;
import com.tencent.biz.qqcircle.immersive.part.folder.IPageChangeObserver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import java.util.ArrayList;
import java.util.List;

public class QFSMainFragment
  extends QFSBaseFragment
  implements IPageChangeObserver
{
  private List<Part> c;
  private QFSMainMultiTabFragmentPart d;
  private IQFSFolderIoc e;
  private QCircleSharePartV2 f;
  private QFSPublishFeedPart g;
  private QCircleCommentPanelPart h;
  private QFSPublishStatusBoxPart i;
  private QFSTopPopBannerPart j;
  private QFSMessageNoticePart k;
  private QFSSearchEntrancePart l;
  private QCircleLightInteractListPart m;
  private QCircleRichMediaDownLoadPart n;
  
  public int a()
  {
    QFSMainMultiTabFragmentPart localQFSMainMultiTabFragmentPart = this.d;
    if (localQFSMainMultiTabFragmentPart != null) {
      return localQFSMainMultiTabFragmentPart.e();
    }
    return -1;
  }
  
  public void a(int paramInt)
  {
    QLog.d("QFSMainFragment", 1, "onPageSelected onShow");
  }
  
  public void a(IQFSFolderIoc paramIQFSFolderIoc)
  {
    this.e = paramIQFSFolderIoc;
  }
  
  public String b()
  {
    return "QFSMainFragment";
  }
  
  protected boolean bh_()
  {
    return true;
  }
  
  protected int c()
  {
    return 2131627145;
  }
  
  protected List<Part> d()
  {
    if (this.c == null)
    {
      this.c = new ArrayList();
      this.d = new QFSMainMultiTabFragmentPart();
      this.c.add(this.d);
      this.c.add(new QFSMainChipPart());
      this.f = new QCircleSharePartV2();
      this.c.add(this.f);
      QCircleTaskCenterPart localQCircleTaskCenterPart = new QCircleTaskCenterPart();
      localQCircleTaskCenterPart.a(this);
      this.c.add(localQCircleTaskCenterPart);
      this.c.add(new QCirclePushToastPart());
      this.h = new QCircleCommentPanelPart();
      this.c.add(this.h);
      this.h.a(this);
      if (QCircleHostGlobalInfo.getFolderUIType() == 3)
      {
        this.g = new QFSPublishFeedPart(QCirclePluginGlobalInfo.c());
        this.g.a(17);
        this.g.a(this);
        this.c.add(this.g);
      }
      this.j = new QFSTopPopBannerPart(QCirclePluginGlobalInfo.c());
      this.c.add(this.j);
      this.k = new QFSMessageNoticePart();
      this.c.add(this.k);
      this.l = new QFSSearchEntrancePart();
      this.c.add(this.l);
      this.m = new QCircleLightInteractListPart();
      this.c.add(this.m);
      this.n = new QCircleRichMediaDownLoadPart();
      this.c.add(this.n);
      this.i = new QFSPublishStatusBoxPart(QCirclePluginGlobalInfo.c());
      this.c.add(this.i);
    }
    return this.c;
  }
  
  protected String f()
  {
    if (a() == 501) {
      return "pg_xsj_following_page";
    }
    if (a() == 503) {
      return "pg_xsj_explore_page";
    }
    if (a() == 591) {
      return "pg_xsj_nearby_page";
    }
    return super.f();
  }
  
  protected int j()
  {
    return 0;
  }
  
  public QCircleReportBean n()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    this.a.setPageId(a());
    return this.a;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QFSMainMultiTabFragmentPart localQFSMainMultiTabFragmentPart = this.d;
    if (localQFSMainMultiTabFragmentPart != null) {
      localQFSMainMultiTabFragmentPart.a(this.e);
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    QLog.d(b(), 1, "fs_lifecycle onPause");
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.d(b(), 1, "fs_lifecycle onResume");
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSMainFragment
 * JD-Core Version:    0.7.0.1
 */