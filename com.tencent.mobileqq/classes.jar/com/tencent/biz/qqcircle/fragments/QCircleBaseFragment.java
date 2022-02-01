package com.tencent.biz.qqcircle.fragments;

import aaaf;
import aavz;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import bgru;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import uwz;
import uxb;
import uxh;
import uxp;
import uxx;
import vjg;
import zwe;
import zwj;
import zxl;

public abstract class QCircleBaseFragment
  extends BasePartFragment
  implements zxl<QCircleReportBean>
{
  protected QCircleReportBean a;
  
  private void a()
  {
    File localFile = new File(uxb.i);
    if ((localFile.exists()) || (bgru.a() == null))
    {
      QLog.i("QCircleBaseFragment", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    aaaf.a(localFile, (String)aavz.a().a("KEY_QCIRCLE_BASE_VIEW_DOWNLOAD_URL", "https://downv6.qq.com/video_story/qcircle/base/qcircle_download_pics.zip"), uxb.f);
  }
  
  private void b()
  {
    zwe localzwe = zwj.a(uwz.a());
    vjg localvjg = new vjg(this);
    localzwe.a(new String[] { "https://downv6.qq.com/video_story/qcircle/animation/rocket1.zip", "https://downv6.qq.com/video_story/qcircle/animation/rocket2.zip", "https://downv6.qq.com/video_story/qcircle/animation/rocket3.zip", "https://downv6.qq.com/video_story/qcircle/animation/rocket_start.zip", "https://downv6.qq.com/video_story/qcircle/animation/rocket_end.zip", "https://downv6.qq.com/video_story/qcircle/animation/single_rocket.zip", "https://downv6.qq.com/video_story/qcircle/animation/list_to_grid.zip", "https://downv6.qq.com/video_story/qcircle/animation/grid_to_list.zip", "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf", "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_fullscreen_disconnect.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_halfscreen_disconnect.png", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-platform/wezone/2020-wezone-img/2020-empty-state/6-preload/img_preload_detailpage_disconnect.png" }, localvjg);
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
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    j();
    return this.a.setPageId(c()).setPageIdStr(d());
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d(c(), 1, c() + "->doOnCreateView");
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    b();
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(c(), paramQCircleReportBean);
  }
  
  public int b()
  {
    return uxx.a();
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
    } while ((localObject == null) || (((QCircleInitBean)localObject).mFromReportBean == null) || (this.a == null));
    this.a.assembleFromReportData(((QCircleInitBean)localObject).mFromReportBean);
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
    uxp.a().a();
    uxh.a();
  }
  
  public void onDetach()
  {
    QLog.d(c(), 1, c() + "->onDetach");
    super.onDetach();
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