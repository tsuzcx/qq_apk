package com.tencent.gdtad.views.canvas.components.picture;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;
import qjn;
import qjo;
import qjp;

public class GdtCanvasPictureComponentView
  extends GdtCanvasComponentView
{
  public GdtCanvasPictureComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasPictureComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    if ((paramGdtCanvasPictureComponentData == null) || (!paramGdtCanvasPictureComponentData.isValid())) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData = paramGdtCanvasPictureComponentData;
    g();
    Object localObject = new LinearLayout(paramContext);
    addView((View)localObject);
    ((LinearLayout)localObject).setPadding(0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingTop, 0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingBottom);
    paramContext = new URLImageView(paramContext);
    ((LinearLayout)localObject).addView(paramContext);
    localObject = paramContext.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.width;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.height;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = URLDrawable.getDrawable(paramGdtCanvasPictureComponentData.url, URLDrawable.URLDrawableOptions.obtain());
    if (((URLDrawable)localObject).getStatus() == 0) {
      paramContext.setURLDrawableDownListener(new qjn(this));
    }
    for (;;)
    {
      paramContext.setImageDrawable((Drawable)localObject);
      paramContext.setOnTouchListener(new qjp(new qjo(this, paramGdtCanvasPictureComponentData)));
      this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(paramContext), new WeakReference(this));
      return;
      if (((URLDrawable)localObject).getStatus() == 1) {
        a(true);
      } else if ((((URLDrawable)localObject).getStatus() == 2) || (((URLDrawable)localObject).getStatus() == 3)) {
        a(false);
      } else {
        GdtLog.d("GdtCanvasPictureView", "status: " + ((URLDrawable)localObject).getStatus() + " url: " + paramGdtCanvasPictureComponentData.url);
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView
 * JD-Core Version:    0.7.0.1
 */