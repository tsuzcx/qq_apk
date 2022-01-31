package com.tencent.gdtad.views.canvas.components.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoCommonView.LoadListener;
import com.tencent.gdtad.views.video.GdtVideoCommonView.VideoFullScreenListener;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.lang.ref.WeakReference;
import qjq;

public class GdtCanvasVideoComponentView
  extends GdtCanvasComponentView
  implements GdtVideoCommonView.LoadListener, GdtVideoCommonView.VideoFullScreenListener
{
  public static int a;
  private static int b;
  private GdtCanvasMutiVideoManager jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager;
  private GdtCanvasPageView jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private int c;
  
  public GdtCanvasVideoComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasVideoComponentData paramGdtCanvasVideoComponentData, GdtCanvasMutiVideoManager paramGdtCanvasMutiVideoManager, GdtCanvasPageView paramGdtCanvasPageView)
  {
    super(paramContext, paramWeakReference);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager = paramGdtCanvasMutiVideoManager;
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView = paramGdtCanvasPageView;
    a(paramContext, paramGdtCanvasVideoComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasVideoComponentData paramGdtCanvasVideoComponentData)
  {
    if ((paramGdtCanvasVideoComponentData == null) || (!paramGdtCanvasVideoComponentData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData = paramGdtCanvasVideoComponentData;
    g();
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    localLinearLayout.setPadding(0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingTop, 0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingBottom);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = new GdtVideoCommonView(paramContext);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
    jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a = ("video_" + jdField_a_of_type_Int);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView);
    int i = getResources().getDisplayMetrics().widthPixels;
    if (b == 0) {
      b = (int)(i * 0.33F);
    }
    paramContext = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    paramContext.width = i;
    paramContext.height = b;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.width > 0) {
      paramContext.height = ((int)(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.height / this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.width * i));
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(paramContext);
    paramContext = new GdtVideoData();
    paramContext.setPlayScene(6);
    paramContext.setUrl(paramGdtCanvasVideoComponentData.url);
    paramContext.setCoverUrl(paramGdtCanvasVideoComponentData.thumbUrl);
    paramContext.setDurationMillis(paramGdtCanvasVideoComponentData.duration);
    paramContext.setLoop(paramGdtCanvasVideoComponentData.loop);
    paramContext.setAd(paramGdtCanvasVideoComponentData.ad);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setData(paramContext, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLoadListener(this);
    this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView), new WeakReference(this), 0.5F);
  }
  
  private void j()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a())
    {
      GdtCanvasComponentView localGdtCanvasComponentView = this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a(i);
      if (localGdtCanvasComponentView != this) {
        localGdtCanvasComponentView.setVisibility(8);
      }
      i += 1;
    }
  }
  
  private void k()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a())
    {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.a(i).setVisibility(0);
      i += 1;
    }
  }
  
  public GdtViewStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus;
  }
  
  public GdtCanvasComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a();
      GdtLog.c("GdtCanvasVideoComponentView", "onViewResume " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null))
    {
      h();
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b();
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasMutiVideoManager.a(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView));
      GdtLog.c("GdtCanvasVideoComponentView", "onViewPause " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.h();
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void h()
  {
    k();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 8);
    post(new qjq(this));
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a()))
    {
      j();
      this.c = this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.getScrollY();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView
 * JD-Core Version:    0.7.0.1
 */