package com.tencent.gdtad.views.canvas.components.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.xijing.GdtButtonView;
import java.lang.ref.WeakReference;
import yxs;
import yzg;
import yzs;
import zag;

public class GdtCanvasButtonComponentView
  extends GdtCanvasComponentView
{
  private GdtCanvasButtonComponentData a;
  
  public GdtCanvasButtonComponentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtCanvasButtonComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtCanvasButtonComponentView(Context paramContext, WeakReference<zag> paramWeakReference, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasButtonComponentData);
  }
  
  private void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      ((zag)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(paramString1, paramBoolean, paramString2, paramString3);
    }
  }
  
  public GdtCanvasButtonComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData;
  }
  
  public yzg a()
  {
    return this.jdField_a_of_type_Yzg;
  }
  
  public void a(Context paramContext, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    g();
    if ((paramGdtCanvasButtonComponentData == null) || (!paramGdtCanvasButtonComponentData.isValid()) || (getResources() == null))
    {
      yxs.d("GdtCanvasButtonComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData = paramGdtCanvasButtonComponentData;
    Object localObject;
    if (a().isFixed)
    {
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      setLayoutParams((ViewGroup.LayoutParams)localObject);
      setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().toBottom + a().paddingBottom);
      paramContext = new GdtButtonView(paramContext, a().button);
      localObject = new FrameLayout.LayoutParams(a().width, a().height);
      ((FrameLayout.LayoutParams)localObject).gravity = (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData.gravity | 0x10);
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData.gravity != 17) {
        break label300;
      }
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
    }
    for (;;)
    {
      addView(paramContext, (ViewGroup.LayoutParams)localObject);
      localObject = paramGdtCanvasButtonComponentData.actionUrl;
      paramContext.setOnClickListener(new yzs(this, paramGdtCanvasButtonComponentData.linkType, paramGdtCanvasButtonComponentData.isFixed, (String)localObject, paramGdtCanvasButtonComponentData.formModId));
      this.jdField_a_of_type_Yzg = new yzg(new WeakReference(paramContext), new WeakReference(this));
      a(true);
      return;
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().paddingBottom);
      break;
      label300:
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData.gravity == 3) {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
      } else if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsButtonGdtCanvasButtonComponentData.gravity == 5) {
        ((FrameLayout.LayoutParams)localObject).gravity = 5;
      } else {
        ((FrameLayout.LayoutParams)localObject).gravity = 17;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView
 * JD-Core Version:    0.7.0.1
 */