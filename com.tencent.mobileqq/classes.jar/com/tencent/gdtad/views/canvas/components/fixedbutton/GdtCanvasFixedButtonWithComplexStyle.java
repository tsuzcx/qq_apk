package com.tencent.gdtad.views.canvas.components.fixedbutton;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnComponentView;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import yze;
import yzg;
import yzt;
import zag;
import zba;
import zbc;

public class GdtCanvasFixedButtonWithComplexStyle
  extends GdtCanvasComponentView
{
  private GdtCanvasAppBtnComponentView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString = "GdtCanvasFixedButtonComplexStyle";
  private zba jdField_a_of_type_Zba;
  private zbc jdField_a_of_type_Zbc = new yzt(this);
  
  public GdtCanvasFixedButtonWithComplexStyle(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtCanvasFixedButtonWithComplexStyle(Context paramContext, GdtCanvasFixedButtonComponentData paramGdtCanvasFixedButtonComponentData, GdtAd paramGdtAd, WeakReference<zag> paramWeakReference)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131559102, this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131362679));
    TextView localTextView = (TextView)localView.findViewById(2131362680);
    localTextView.setText(paramGdtAd.getAppName());
    paramGdtAd = (TextView)localView.findViewById(2131362685);
    paramGdtAd.setText(yze.b(paramGdtCanvasFixedButtonComponentData.fileSize));
    Object localObject = (TextView)localView.findViewById(2131362666);
    ((TextView)localObject).setText(paramGdtCanvasFixedButtonComponentData.desc);
    localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin + yze.a(101.0F, BaseApplicationImpl.getContext().getResources()), ((RelativeLayout.LayoutParams)localObject).bottomMargin);
    post(new GdtCanvasFixedButtonWithComplexStyle.1(this, paramGdtAd, localTextView, paramGdtAd.getPaint().measureText(paramGdtAd.getText().toString())));
    paramGdtAd = (RelativeLayout)localView.findViewById(2131365344);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView = new GdtCanvasAppBtnComponentView(paramContext, paramWeakReference, paramGdtCanvasFixedButtonComponentData, true);
    paramWeakReference = new RelativeLayout.LayoutParams(yze.a(81.0F, BaseApplicationImpl.getContext().getResources()), yze.a(40.0F, BaseApplicationImpl.getContext().getResources()));
    paramGdtAd.addView(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView, paramWeakReference);
    paramGdtAd = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramGdtAd.width = yze.a(56.0F, paramContext.getResources());
    paramGdtAd.height = paramGdtAd.width;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramGdtAd);
    this.jdField_a_of_type_Zba = new zba(paramGdtCanvasFixedButtonComponentData.imageUrl, new WeakReference(this.jdField_a_of_type_Zbc));
    this.jdField_a_of_type_Zba.a();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_Zba.a());
  }
  
  public GdtCanvasComponentData a()
  {
    return null;
  }
  
  public yzg a()
  {
    return this.jdField_a_of_type_Yzg;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.d();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.f();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.fixedbutton.GdtCanvasFixedButtonWithComplexStyle
 * JD-Core Version:    0.7.0.1
 */