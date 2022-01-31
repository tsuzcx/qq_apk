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
import ypk;
import ypm;
import ypz;
import yqo;
import yri;
import yrk;

public class GdtCanvasFixedButtonWithComplexStyle
  extends GdtCanvasComponentView
{
  private GdtCanvasAppBtnComponentView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString = "GdtCanvasFixedButtonComplexStyle";
  private yri jdField_a_of_type_Yri;
  private yrk jdField_a_of_type_Yrk = new ypz(this);
  
  public GdtCanvasFixedButtonWithComplexStyle(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtCanvasFixedButtonWithComplexStyle(Context paramContext, GdtCanvasFixedButtonComponentData paramGdtCanvasFixedButtonComponentData, GdtAd paramGdtAd, WeakReference<yqo> paramWeakReference)
  {
    super(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131493533, this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131297139));
    TextView localTextView = (TextView)localView.findViewById(2131297140);
    localTextView.setText(paramGdtAd.getAppName());
    paramGdtAd = (TextView)localView.findViewById(2131297145);
    paramGdtAd.setText(ypk.b(paramGdtCanvasFixedButtonComponentData.fileSize));
    Object localObject = (TextView)localView.findViewById(2131297126);
    ((TextView)localObject).setText(paramGdtCanvasFixedButtonComponentData.desc);
    localObject = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, ((RelativeLayout.LayoutParams)localObject).topMargin, ((RelativeLayout.LayoutParams)localObject).rightMargin + ypk.a(101.0F, BaseApplicationImpl.getContext().getResources()), ((RelativeLayout.LayoutParams)localObject).bottomMargin);
    post(new GdtCanvasFixedButtonWithComplexStyle.1(this, paramGdtAd, localTextView, paramGdtAd.getPaint().measureText(paramGdtAd.getText().toString())));
    paramGdtAd = (RelativeLayout)localView.findViewById(2131299777);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView = new GdtCanvasAppBtnComponentView(paramContext, paramWeakReference, paramGdtCanvasFixedButtonComponentData, true);
    paramWeakReference = new RelativeLayout.LayoutParams(ypk.a(81.0F, BaseApplicationImpl.getContext().getResources()), ypk.a(40.0F, BaseApplicationImpl.getContext().getResources()));
    paramGdtAd.addView(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnComponentView, paramWeakReference);
    paramGdtAd = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    paramGdtAd.width = ypk.a(56.0F, paramContext.getResources());
    paramGdtAd.height = paramGdtAd.width;
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramGdtAd);
    this.jdField_a_of_type_Yri = new yri(paramGdtCanvasFixedButtonComponentData.imageUrl, new WeakReference(this.jdField_a_of_type_Yrk));
    this.jdField_a_of_type_Yri.a();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_Yri.a());
  }
  
  public GdtCanvasComponentData a()
  {
    return null;
  }
  
  public ypm a()
  {
    return this.jdField_a_of_type_Ypm;
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