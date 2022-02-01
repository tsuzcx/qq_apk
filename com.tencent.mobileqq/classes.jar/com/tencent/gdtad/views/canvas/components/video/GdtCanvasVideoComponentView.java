package com.tencent.gdtad.views.canvas.components.video;

import com.tencent.ad.tangram.canvas.views.AdViewStatus;
import com.tencent.ad.tangram.canvas.views.canvas.components.AdCanvasComponentView;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.LoadListener;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoFullScreenListener;
import java.lang.ref.WeakReference;

public class GdtCanvasVideoComponentView
  extends AdCanvasComponentView
  implements GdtVideoCommonView.LoadListener, GdtVideoCommonView.VideoFullScreenListener
{
  public static int a;
  private static int b = 0;
  private AdCanvasPageView jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView;
  private GdtCanvasMutiVideoManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager;
  private GdtCanvasVideoComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasVideoComponentData;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private int c;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  private void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView.getCount())
    {
      AdCanvasComponentView localAdCanvasComponentView = this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView.getView(i);
      if (localAdCanvasComponentView != this) {
        localAdCanvasComponentView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  private void d()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView.getCount())
    {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView.getView(i).setVisibility(0);
      i += 1;
    }
  }
  
  public GdtCanvasVideoComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasVideoComponentData;
  }
  
  public void a()
  {
    d();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 8);
    post(new GdtCanvasVideoComponentView.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    stopLoad(paramBoolean);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b()))
    {
      c();
      this.c = this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasPageView.getScrollY();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 8);
    }
  }
  
  public boolean back()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null))
    {
      a();
      return true;
    }
    return super.back();
  }
  
  public AdViewStatus getStatus()
  {
    return this.status;
  }
  
  public void onActivityDestroy()
  {
    super.onActivityDestroy();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.j();
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void onViewPause()
  {
    super.onViewPause();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.a(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView));
      GdtLog.c("GdtCanvasVideoComponentView", "onViewPause " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    }
  }
  
  public void onViewResume()
  {
    super.onViewResume();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a();
      GdtLog.c("GdtCanvasVideoComponentView", "onViewResume " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView
 * JD-Core Version:    0.7.0.1
 */