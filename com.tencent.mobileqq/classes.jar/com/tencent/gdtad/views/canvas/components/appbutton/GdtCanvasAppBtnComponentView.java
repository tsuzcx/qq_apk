package com.tencent.gdtad.views.canvas.components.appbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.GdtCanvasData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.xijing.GdtButtonData;
import com.tencent.gdtad.views.xijing.GdtTextData;
import java.lang.ref.WeakReference;
import yxs;
import yzg;
import yzl;
import yzp;
import zag;
import zcf;

public class GdtCanvasAppBtnComponentView
  extends GdtCanvasComponentView
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new yzp(this);
  private GdtCanvasAppBtnComponentData jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData;
  private yzl jdField_a_of_type_Yzl;
  
  public GdtCanvasAppBtnComponentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtCanvasAppBtnComponentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtCanvasAppBtnComponentView(Context paramContext, WeakReference<zag> paramWeakReference, GdtCanvasAppBtnComponentData paramGdtCanvasAppBtnComponentData, boolean paramBoolean)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasAppBtnComponentData, paramBoolean);
  }
  
  private void a(Context paramContext, GdtCanvasAppBtnComponentData paramGdtCanvasAppBtnComponentData, boolean paramBoolean)
  {
    g();
    if ((paramGdtCanvasAppBtnComponentData == null) || (!paramGdtCanvasAppBtnComponentData.isValid()))
    {
      yxs.d("GdtCanvasButtonComponentView", "init error");
      a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData = paramGdtCanvasAppBtnComponentData;
    yxs.b("GdtCanvasButtonComponentView", "init appId " + a().ad.getAppId() + " channel_id " + a().ad.getAppChannelId() + " autodownload " + a().getAutoDownLoad());
    FrameLayout.LayoutParams localLayoutParams;
    if (a().isFixed)
    {
      paramGdtCanvasAppBtnComponentData = new RelativeLayout.LayoutParams(-1, -2);
      paramGdtCanvasAppBtnComponentData.addRule(12);
      setLayoutParams(paramGdtCanvasAppBtnComponentData);
      setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().toBottom + a().paddingBottom);
      paramGdtCanvasAppBtnComponentData = new GdtCanvasAppBtnView(paramContext);
      localLayoutParams = new FrameLayout.LayoutParams(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.width, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.height);
      localLayoutParams.gravity = (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.gravity | 0x10);
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.gravity != 17) {
        break label426;
      }
      localLayoutParams.gravity = 17;
    }
    for (;;)
    {
      paramGdtCanvasAppBtnComponentData.setText(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.button.text.text);
      addView(paramGdtCanvasAppBtnComponentData, localLayoutParams);
      paramGdtCanvasAppBtnComponentData.a(paramContext, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData);
      this.jdField_a_of_type_Yzl = new yzl(paramContext, a().getAutoDownLoad(), a().ad, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.button.text.text, paramGdtCanvasAppBtnComponentData, paramBoolean, a().sourceId);
      paramGdtCanvasAppBtnComponentData.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Yzl.a(this.jdField_a_of_type_JavaLangRefWeakReference);
      this.jdField_a_of_type_Yzl.b();
      this.jdField_a_of_type_Yzg = new yzg(new WeakReference(paramGdtCanvasAppBtnComponentData), new WeakReference(this));
      a(true);
      return;
      setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
      setPadding(a().paddingLeft, a().paddingTop, a().paddingRight, a().paddingBottom);
      break;
      label426:
      if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.gravity == 3) {
        localLayoutParams.gravity = 3;
      } else if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData.gravity == 5) {
        localLayoutParams.gravity = 5;
      } else {
        localLayoutParams.gravity = 17;
      }
    }
  }
  
  public GdtCanvasAppBtnComponentData a()
  {
    return this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentData;
  }
  
  public yzg a()
  {
    return this.jdField_a_of_type_Yzg;
  }
  
  public void d()
  {
    super.d();
    if (this.jdField_a_of_type_Yzl != null) {
      this.jdField_a_of_type_Yzl.d();
    }
  }
  
  public void f()
  {
    super.f();
    if (this.jdField_a_of_type_Yzl != null) {
      this.jdField_a_of_type_Yzl.e();
    }
  }
  
  public void h()
  {
    if ((a() != null) && (a().isValid())) {
      zcf.b(a().ad);
    }
    for (;;)
    {
      this.jdField_a_of_type_Yzl.c();
      return;
      yxs.d("GdtCanvasButtonComponentView", "onClick error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView
 * JD-Core Version:    0.7.0.1
 */