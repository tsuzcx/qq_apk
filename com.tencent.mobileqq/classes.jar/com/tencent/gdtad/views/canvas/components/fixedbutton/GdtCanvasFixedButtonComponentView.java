package com.tencent.gdtad.views.canvas.components.fixedbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView;
import java.lang.ref.WeakReference;
import yny;
import ypm;
import yqo;

public class GdtCanvasFixedButtonComponentView
  extends GdtCanvasComponentView
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private GdtAd jdField_a_of_type_ComTencentGdtadAditemGdtAd;
  private GdtCanvasFixedButtonComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData;
  
  public GdtCanvasFixedButtonComponentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtCanvasFixedButtonComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtCanvasFixedButtonComponentView(Context paramContext, WeakReference<yqo> paramWeakReference)
  {
    super(paramContext, paramWeakReference);
  }
  
  public GdtCanvasFixedButtonComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData;
  }
  
  public ypm a()
  {
    return this.jdField_a_of_type_Ypm;
  }
  
  public void a(Context paramContext, GdtCanvasFixedButtonComponentData paramGdtCanvasFixedButtonComponentData, GdtAd paramGdtAd, WeakReference<yqo> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramGdtAd;
    g();
    if ((paramGdtCanvasFixedButtonComponentData == null) || (!paramGdtCanvasFixedButtonComponentData.isValid()))
    {
      yny.d("GdtCanvasButtonComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData = paramGdtCanvasFixedButtonComponentData;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-1"))
    {
      this.jdField_a_of_type_AndroidViewView = new GdtCanvasFixedButtonWithComplexStyle(paramContext, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData, paramGdtAd, paramWeakReference);
      paramGdtAd = new RelativeLayout.LayoutParams(-1, -2);
    }
    for (;;)
    {
      addView(this.jdField_a_of_type_AndroidViewView, paramGdtAd);
      this.jdField_a_of_type_Ypm = new ypm(new WeakReference(this.jdField_a_of_type_AndroidViewView), new WeakReference(this));
      a(true);
      return;
      paramGdtAd = localObject;
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData.buttonStyle.equals("fixedBtn-2"))
      {
        this.jdField_a_of_type_AndroidViewView = new GdtCanvasAppBtnComponentView(paramContext, paramWeakReference, paramGdtCanvasFixedButtonComponentData, true);
        paramGdtAd = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsFixedbuttonGdtCanvasFixedButtonComponentData.height);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      }
    }
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      ((GdtCanvasComponentView)this.jdField_a_of_type_AndroidViewView).d();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_AndroidViewView != null) {
      ((GdtCanvasComponentView)this.jdField_a_of_type_AndroidViewView).f();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (!(this.jdField_a_of_type_AndroidViewView instanceof GdtCanvasFixedButtonWithComplexStyle)) {
        break label28;
      }
      ((GdtCanvasFixedButtonWithComplexStyle)this.jdField_a_of_type_AndroidViewView).h();
    }
    label28:
    while (!(this.jdField_a_of_type_AndroidViewView instanceof GdtCanvasAppBtnComponentView)) {
      return;
    }
    ((GdtCanvasAppBtnComponentView)this.jdField_a_of_type_AndroidViewView).h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonComponentView
 * JD-Core Version:    0.7.0.1
 */