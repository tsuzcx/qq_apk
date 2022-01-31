package com.tencent.gdtad.views.canvas.components.picture;

import android.content.Context;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.pictures.HotArea;
import com.tencent.gdtad.views.image.GdtGifImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import sea;
import yzd;
import yzv;
import yzw;
import yzx;
import zad;

public class GdtCanvasPictureComponentView
  extends GdtCanvasComponentView
{
  private GdtCanvasPictureComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData;
  private GdtGifImageView jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView;
  
  public GdtCanvasPictureComponentView(Context paramContext, WeakReference<zad> paramWeakReference, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasPictureComponentData, null);
  }
  
  public GdtCanvasPictureComponentView(Context paramContext, WeakReference<zad> paramWeakReference, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData, View.OnTouchListener paramOnTouchListener)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasPictureComponentData, paramOnTouchListener);
  }
  
  private void a(Context paramContext, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData, View.OnTouchListener paramOnTouchListener)
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
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    if (paramGdtCanvasPictureComponentData.isHotAreaValild())
    {
      ArrayList localArrayList = paramGdtCanvasPictureComponentData.hotAreaList;
      int i = 0;
      while (i < localArrayList.size())
      {
        Button localButton = new Button(getContext());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((HotArea)localArrayList.get(i)).width, ((HotArea)localArrayList.get(i)).height);
        localLayoutParams.topMargin = ((HotArea)localArrayList.get(i)).y;
        localLayoutParams.leftMargin = ((HotArea)localArrayList.get(i)).x;
        localButton.setLayoutParams(localLayoutParams);
        localButton.setBackgroundColor(0);
        localRelativeLayout.addView(localButton);
        localButton.setOnClickListener(new yzw(this, ((HotArea)localArrayList.get(i)).linkType, ((HotArea)localArrayList.get(i)).formModId, ((HotArea)localArrayList.get(i)).url));
        i += 1;
      }
    }
    addView(localRelativeLayout);
    localLinearLayout.setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().paddingBottom);
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView = new GdtGifImageView(paramContext, paramGdtCanvasPictureComponentData.url, paramGdtCanvasPictureComponentData.guassianUrl, new WeakReference(new yzv(this)));
    localLinearLayout.addView(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView);
    paramContext = this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView.getLayoutParams();
    paramContext.width = a().width;
    paramContext.height = a().height;
    this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView.setLayoutParams(paramContext);
    if (paramOnTouchListener != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView.setOnTouchListener(paramOnTouchListener);
    }
    for (;;)
    {
      sea.a();
      this.jdField_a_of_type_Yzd = new yzd(new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView), new WeakReference(this));
      return;
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtGifImageView.setOnTouchListener(new yzx(new GdtCanvasPictureComponentView.2(this, paramGdtCanvasPictureComponentData)));
    }
  }
  
  public GdtCanvasPictureComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPictureGdtCanvasPictureComponentData;
  }
  
  public yzd a()
  {
    return this.jdField_a_of_type_Yzd;
  }
  
  public void d()
  {
    super.d();
    sea.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView
 * JD-Core Version:    0.7.0.1
 */