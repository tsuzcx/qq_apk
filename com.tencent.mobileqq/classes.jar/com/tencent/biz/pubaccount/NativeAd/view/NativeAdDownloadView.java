package com.tencent.biz.pubaccount.NativeAd.view;

import aciy;
import ajjy;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import nbj;
import org.json.JSONObject;
import rue;

public class NativeAdDownloadView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  public NativeAdDownloadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a()
  {
    float f2 = 2.0F;
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      inflate(getContext(), 2131494226, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131305631));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131312464));
    }
    int j = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("width"), 82);
    int i = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("minWidth"), 82);
    int k;
    int m;
    label145:
    float f1;
    if (j < i)
    {
      k = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("height"), 20);
      m = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("maxHeight"), 22);
      if (k >= 18) {
        break label757;
      }
      j = 18;
      f1 = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("corner"), 2.0F);
      if (f1 >= 2.0F) {
        break label775;
      }
      f1 = 2.0F;
    }
    label167:
    label553:
    label811:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetProgressBar.getLayoutParams();
      localLayoutParams.width = aciy.a(i, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.height = aciy.a(j, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams.addRule(13);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(100);
      Object localObject1 = new GradientDrawable();
      ((GradientDrawable)localObject1).setCornerRadius(aciy.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject1).setColor(nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("progressBg"), "#F2F2F2"));
      localObject1 = new ClipDrawable((Drawable)localObject1, 3, 1);
      ((ClipDrawable)localObject1).setLevel(10000);
      Object localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setCornerRadius(aciy.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      ((GradientDrawable)localObject2).setColor(nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("secondaryProgressBg"), "#F2F2F2"));
      localObject2 = new ClipDrawable((Drawable)localObject2, 3, 1);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(aciy.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localGradientDrawable.setColor(nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("progressColor"), "#12B7F5"));
      localObject1 = new LayerDrawable(new Drawable[] { localObject1, localObject2, new ClipDrawable(localGradientDrawable, 3, 1) });
      ((LayerDrawable)localObject1).setId(0, 16908288);
      ((LayerDrawable)localObject1).setId(1, 16908303);
      ((LayerDrawable)localObject1).setId(2, 16908301);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("textColor"), "#ffffff"));
      j = nbj.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("textSize"), 12);
      float f3;
      if (j < 10)
      {
        i = 10;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, i);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
        localObject1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("buttonBorderColor");
        localObject2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("buttonBorderSize");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
          break;
        }
        f3 = nbj.a((String)localObject2, 0.0F);
        if (f3 <= 2.0F) {
          break label806;
        }
      }
      for (;;)
      {
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).width = (localLayoutParams.width + aciy.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
        ((RelativeLayout.LayoutParams)localObject2).height = (localLayoutParams.height + aciy.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources()) * 2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        rue.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, aciy.a(f1, this.jdField_a_of_type_AndroidContentContext.getResources()), nbj.a((String)localObject1, "#12B7F5"), aciy.a(f2, this.jdField_a_of_type_AndroidContentContext.getResources()));
        return;
        i = j;
        if (j <= 100) {
          break;
        }
        i = 100;
        break;
        label757:
        j = k;
        if (k <= m) {
          break label145;
        }
        j = m;
        break label145;
        if (f1 <= 20.0F) {
          break label811;
        }
        f1 = 20.0F;
        break label167;
        i = j;
        if (j <= 16) {
          break label553;
        }
        i = 16;
        break label553;
        f2 = f3;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131494218, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131305629));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4)
    {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt2);
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641278));
      }
      return;
    }
    setProgress(paramInt2);
  }
  
  public void setProgress(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
    }
    setText(paramInt);
  }
  
  public void setProgressStyle(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    if (paramJSONObject != null)
    {
      this.jdField_a_of_type_Int = nbj.a(paramJSONObject.optString("style"), 1);
      setStyle(this.jdField_a_of_type_Int);
    }
  }
  
  public void setStyle(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a();
  }
  
  public void setText(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {}
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641276) + paramInt + "%");
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641280));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView
 * JD-Core Version:    0.7.0.1
 */