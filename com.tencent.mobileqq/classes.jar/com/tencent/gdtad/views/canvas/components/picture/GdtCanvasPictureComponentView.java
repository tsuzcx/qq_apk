package com.tencent.gdtad.views.canvas.components.picture;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;
import qma;
import qmb;
import qmc;

public class GdtCanvasPictureComponentView
  extends GdtCanvasComponentView
{
  private GdtCanvasPictureComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData;
  private GdtDrawableLoader.Listener jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener = new qmb(this);
  private GdtDrawableLoader jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  public GdtCanvasPictureComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasPictureComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    g();
    if ((paramGdtCanvasPictureComponentData == null) || (!paramGdtCanvasPictureComponentData.isValid()))
    {
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData = paramGdtCanvasPictureComponentData;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    localLinearLayout.setPadding(0, a().paddingTop, 0, a().paddingBottom);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentImageURLImageView);
    paramContext = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramContext.width = a().width;
    paramContext.height = a().height;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader = new GdtDrawableLoader(paramGdtCanvasPictureComponentData.url, new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener));
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a());
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnTouchListener(new qmc(new qma(this, paramGdtCanvasPictureComponentData)));
    this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(this.jdField_a_of_type_ComTencentImageURLImageView), new WeakReference(this));
  }
  
  public GdtViewStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus;
  }
  
  public GdtCanvasPictureComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView
 * JD-Core Version:    0.7.0.1
 */