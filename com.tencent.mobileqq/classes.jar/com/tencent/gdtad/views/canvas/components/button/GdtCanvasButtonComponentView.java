package com.tencent.gdtad.views.canvas.components.button;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasButtonView;
import java.lang.ref.WeakReference;
import qlg;

public class GdtCanvasButtonComponentView
  extends GdtCanvasComponentView
{
  private GdtCanvasButtonComponentData a;
  
  public GdtCanvasButtonComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasButtonComponentData);
  }
  
  private void a(Context paramContext, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    g();
    if ((paramGdtCanvasButtonComponentData == null) || (!paramGdtCanvasButtonComponentData.isValid()))
    {
      GdtLog.d("GdtCanvasButtonComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData = paramGdtCanvasButtonComponentData;
    setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().paddingBottom);
    paramContext = new GdtCanvasButtonView(paramContext, a().button);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, a().height);
    localLayoutParams.gravity = 17;
    addView(paramContext, localLayoutParams);
    paramGdtCanvasButtonComponentData = paramGdtCanvasButtonComponentData.actionUrl;
    if (!TextUtils.isEmpty(paramGdtCanvasButtonComponentData)) {
      paramContext.setOnClickListener(new qlg(this, paramGdtCanvasButtonComponentData));
    }
    this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(paramContext), new WeakReference(this));
    a(true);
  }
  
  public GdtViewStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus;
  }
  
  public GdtCanvasButtonComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView
 * JD-Core Version:    0.7.0.1
 */