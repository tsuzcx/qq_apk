package com.tencent.gdtad.views.canvas.components.video;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasPageView;
import com.tencent.gdtad.views.video.GdtVideoCommonView;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.lang.ref.WeakReference;
import yxp;
import yzd;
import zaa;
import zad;
import zbg;
import zbi;

public class GdtCanvasVideoComponentView
  extends GdtCanvasComponentView
  implements zbg, zbi
{
  public static int a;
  private static int b;
  private GdtCanvasVideoComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasVideoComponentData;
  private GdtCanvasPageView jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView;
  private GdtVideoCommonView jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView;
  private zaa jdField_a_of_type_Zaa;
  private int c;
  
  public GdtCanvasVideoComponentView(Context paramContext, WeakReference<zad> paramWeakReference, GdtCanvasVideoComponentData paramGdtCanvasVideoComponentData, zaa paramzaa, GdtCanvasPageView paramGdtCanvasPageView)
  {
    super(paramContext, paramWeakReference);
    this.jdField_a_of_type_Zaa = paramzaa;
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView = paramGdtCanvasPageView;
    a(paramContext, paramGdtCanvasVideoComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasVideoComponentData paramGdtCanvasVideoComponentData)
  {
    if ((paramGdtCanvasVideoComponentData == null) || (!paramGdtCanvasVideoComponentData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasVideoComponentData = paramGdtCanvasVideoComponentData;
    g();
    Object localObject = new LinearLayout(paramContext);
    addView((View)localObject);
    ((LinearLayout)localObject).setPadding(0, a().paddingTop, 0, a().paddingBottom);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView = new GdtVideoCommonView(paramContext);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setOnVideoFullScreen(this);
    jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a = ("video_" + jdField_a_of_type_Int);
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView);
    int i = getResources().getDisplayMetrics().widthPixels;
    if (b == 0) {
      b = (int)(i * 0.33F);
    }
    paramContext = this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.getLayoutParams();
    paramContext.width = i;
    paramContext.height = b;
    if (a().width > 0) {
      paramContext.height = ((int)(a().height / a().width * i));
    }
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLayoutParams(paramContext);
    localObject = new GdtVideoData();
    ((GdtVideoData)localObject).setPlayScene(6);
    ((GdtVideoData)localObject).setUrl(paramGdtCanvasVideoComponentData.url);
    ((GdtVideoData)localObject).setCoverUrl(paramGdtCanvasVideoComponentData.thumbUrl);
    ((GdtVideoData)localObject).setDurationMillis(paramGdtCanvasVideoComponentData.duration);
    ((GdtVideoData)localObject).setLoop(paramGdtCanvasVideoComponentData.isLoop());
    if (a() != null) {}
    for (paramContext = a().ad;; paramContext = null)
    {
      ((GdtVideoData)localObject).setAd(paramContext);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setData((GdtVideoData)localObject, this.jdField_a_of_type_Zaa);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setLoadListener(this);
      this.jdField_a_of_type_Yzd = new yzd(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView), new WeakReference(this), 0.5F);
      return;
    }
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
  
  public GdtCanvasVideoComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsVideoGdtCanvasVideoComponentData;
  }
  
  public yzd a()
  {
    return this.jdField_a_of_type_Yzd;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null)
    {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a();
      yxp.c("GdtCanvasVideoComponentView", "onViewResume " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b()) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null))
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
      this.jdField_a_of_type_Zaa.a(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView));
      yxp.c("GdtCanvasVideoComponentView", "onViewPause " + this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.a);
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
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.j();
    }
    jdField_a_of_type_Int = 0;
  }
  
  public void h()
  {
    k();
    this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(false, 8);
    post(new GdtCanvasVideoComponentView.1(this));
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView != null) && (!this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.b()))
    {
      j();
      this.c = this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasPageView.getScrollY();
      this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView.setisFullScreen(true, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.video.GdtCanvasVideoComponentView
 * JD-Core Version:    0.7.0.1
 */