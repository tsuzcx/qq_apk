package com.tencent.gdtad.views.canvas.components.button;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.gdtad.views.GdtViewStatus;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentData;
import com.tencent.gdtad.views.canvas.components.GdtCanvasComponentView;
import java.lang.ref.WeakReference;
import qjm;

public class GdtCanvasButtonComponentView
  extends GdtCanvasComponentView
{
  public GdtCanvasButtonComponentView(Context paramContext, WeakReference paramWeakReference, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    super(paramContext, paramWeakReference);
    a(paramContext, paramGdtCanvasButtonComponentData);
  }
  
  @TargetApi(16)
  private void a(Context paramContext, GdtCanvasButtonComponentData paramGdtCanvasButtonComponentData)
  {
    g();
    if ((paramGdtCanvasButtonComponentData == null) || (!paramGdtCanvasButtonComponentData.isValid())) {
      return;
    }
    inflate(paramContext, 2130969005, this);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData = paramGdtCanvasButtonComponentData;
    ((LinearLayout)findViewById(2131364659)).setPadding(0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingTop, 0, this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.paddingBottom);
    paramContext = (Button)findViewById(2131364660);
    Object localObject = paramContext.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.width;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsGdtCanvasComponentData.height;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramContext.setText(paramGdtCanvasButtonComponentData.title);
    paramContext.setBackgroundColor(paramGdtCanvasButtonComponentData.backgroundColor);
    paramContext.setTextSize(0, paramGdtCanvasButtonComponentData.fontSize);
    paramContext.setTextColor(paramGdtCanvasButtonComponentData.fontColor);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setShape(0);
    ((GradientDrawable)localObject).setCornerRadius(paramGdtCanvasButtonComponentData.borderCornerRadius);
    ((GradientDrawable)localObject).setStroke(paramGdtCanvasButtonComponentData.borderWidth, paramGdtCanvasButtonComponentData.borderColor);
    ((GradientDrawable)localObject).setColor(paramGdtCanvasButtonComponentData.backgroundColor);
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.setBackground((Drawable)localObject);
    }
    paramGdtCanvasButtonComponentData = paramGdtCanvasButtonComponentData.actionUrl;
    if (!TextUtils.isEmpty(paramGdtCanvasButtonComponentData)) {
      paramContext.setOnClickListener(new qjm(this, paramGdtCanvasButtonComponentData));
    }
    this.jdField_a_of_type_ComTencentGdtadViewsGdtViewStatus = new GdtViewStatus(new WeakReference(paramContext), new WeakReference(this));
    a(true);
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
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.button.GdtCanvasButtonComponentView
 * JD-Core Version:    0.7.0.1
 */