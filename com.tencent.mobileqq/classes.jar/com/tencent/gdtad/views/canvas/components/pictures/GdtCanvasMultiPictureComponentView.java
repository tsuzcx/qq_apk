package com.tencent.gdtad.views.canvas.components.pictures;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentData;
import com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import yzg;
import zab;
import zag;

public class GdtCanvasMultiPictureComponentView
  extends GdtCanvasComponentView
{
  private GdtCanvasMultiPictureComponentData a;
  
  public GdtCanvasMultiPictureComponentView(Context paramContext, WeakReference<zag> paramWeakReference, GdtCanvasMultiPictureComponentData paramGdtCanvasMultiPictureComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasMultiPictureComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasMultiPictureComponentData paramGdtCanvasMultiPictureComponentData)
  {
    if ((paramGdtCanvasMultiPictureComponentData == null) || (!paramGdtCanvasMultiPictureComponentData.isValid())) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPicturesGdtCanvasMultiPictureComponentData = paramGdtCanvasMultiPictureComponentData;
      paramContext = new LinearLayout(paramContext);
      paramContext.setGravity(1);
      paramContext.setOrientation(1);
      addView(paramContext);
      setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().paddingBottom);
      paramGdtCanvasMultiPictureComponentData = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPicturesGdtCanvasMultiPictureComponentData.imageList.iterator();
      while (paramGdtCanvasMultiPictureComponentData.hasNext())
      {
        GdtCanvasPictureComponentData localGdtCanvasPictureComponentData = (GdtCanvasPictureComponentData)paramGdtCanvasMultiPictureComponentData.next();
        if (localGdtCanvasPictureComponentData != null)
        {
          zab localzab = new zab(this, localGdtCanvasPictureComponentData);
          paramContext.addView(new GdtCanvasPictureComponentView(getContext(), this.jdField_a_of_type_JavaLangRefWeakReference, (GdtCanvasPictureComponentData)GdtCanvasPictureComponentData.class.cast(localGdtCanvasPictureComponentData), localzab));
        }
      }
    }
  }
  
  public GdtCanvasMultiPictureComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsPicturesGdtCanvasMultiPictureComponentData;
  }
  
  public yzg a()
  {
    return this.jdField_a_of_type_Yzg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.pictures.GdtCanvasMultiPictureComponentView
 * JD-Core Version:    0.7.0.1
 */