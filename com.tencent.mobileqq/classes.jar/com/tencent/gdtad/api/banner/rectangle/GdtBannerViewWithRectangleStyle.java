package com.tencent.gdtad.api.banner.rectangle;

import acon;
import acpm;
import acpt;
import acpu;
import acvc;
import acwn;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdClickUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLImageView;

public final class GdtBannerViewWithRectangleStyle
  extends RelativeLayout
  implements acpm
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new acpt(this);
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtHandler.Params jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private TextView b;
  
  public GdtBannerViewWithRectangleStyle(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if ((paramContext == null) || (paramParams == null) || (!paramParams.a()))
    {
      acvc.d("GdtBannerContainerView", "constructor");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    if (!a())
    {
      acvc.d("GdtBannerContainerView", "constructor");
      return;
    }
    setGravity(16);
    setPadding(1, 1, 1, 1);
    paramParams = new GradientDrawable();
    paramParams.setShape(0);
    paramParams.setStroke(1, Color.parseColor("#EFEFEF"));
    paramParams.setColor(-1);
    if (Build.VERSION.SDK_INT >= 16) {
      setBackground(paramParams);
    }
    paramParams = new RelativeLayout.LayoutParams(-2, -1);
    paramParams.addRule(9);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setId(2131367431);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL(a().getImageData().jdField_a_of_type_JavaLangString);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, paramParams);
    paramParams = new GradientDrawable();
    paramParams.setShape(0);
    paramParams.setCornerRadius(acwn.a(14.0F, getResources()));
    paramParams.setColor(Color.parseColor("#00CAFC"));
    Object localObject1 = new RelativeLayout.LayoutParams(acwn.a(58.0F, getResources()), acwn.a(29.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = acwn.a(12.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367430);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    a();
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackground(paramParams);
    }
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    paramParams = new LinearLayout(paramContext);
    paramParams.setOrientation(1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = acwn.a(12.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = acwn.a(12.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131367431);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131367430);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    addView(paramParams, (ViewGroup.LayoutParams)localObject1);
    Object localObject2;
    if ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184))
    {
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setMaxLines(2);
      ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject1).setText(a().getText());
      ((TextView)localObject1).setTextColor(Color.parseColor("#333333"));
      ((TextView)localObject1).setTextSize(2, 13.0F);
      paramParams.addView((View)localObject1, new LinearLayout.LayoutParams(-1, -2));
      localObject1 = new LinearLayout(paramContext);
      localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).topMargin = acwn.a(8.0F, getResources());
      ((LinearLayout)localObject1).setOrientation(0);
      ((LinearLayout)localObject1).setGravity(16);
      paramParams.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      int i = acwn.a(16.0F, getResources());
      paramParams = new LinearLayout.LayoutParams(i, i);
      localObject2 = new acpu(paramContext);
      ((acpu)localObject2).setImageURL(a().getAdvertiser_corporate_logo());
      ((acpu)localObject2).a(i / 2);
      ((LinearLayout)localObject1).addView((View)localObject2, paramParams);
      paramParams = new LinearLayout.LayoutParams(-1, -2);
      paramParams.leftMargin = acwn.a(4.0F, getResources());
      localObject2 = new TextView(paramContext);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setText(a().getAdvertiser_corporate_image_name());
      ((TextView)localObject2).setTextColor(Color.parseColor("#999999"));
      ((TextView)localObject2).setTextSize(2, 12.0F);
      ((LinearLayout)localObject1).addView((View)localObject2, paramParams);
    }
    for (;;)
    {
      localObject1 = new FrameLayout(paramContext);
      addView((View)localObject1, new FrameLayout.LayoutParams(acwn.a(36.0F, getResources()), acwn.a(22.0F, getResources())));
      paramParams = new LinearLayout(paramContext);
      localObject2 = new GradientDrawable();
      ((GradientDrawable)localObject2).setShape(0);
      ((GradientDrawable)localObject2).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, acwn.a(4.0F, getResources()), acwn.a(4.0F, getResources()), 0.0F, 0.0F });
      ((GradientDrawable)localObject2).setColor(Color.argb(127, 0, 0, 0));
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, acwn.a(14.0F, getResources()));
      paramParams.setOrientation(0);
      paramParams.setGravity(17);
      if (Build.VERSION.SDK_INT >= 16) {
        paramParams.setBackground((Drawable)localObject2);
      }
      ((FrameLayout)localObject1).addView(paramParams, localLayoutParams);
      localObject1 = new TextView(paramContext);
      ((TextView)localObject1).setText("广告");
      ((TextView)localObject1).setTextColor(Color.argb(Double.valueOf(204.0D).intValue(), 255, 255, 255));
      ((TextView)localObject1).setTextSize(2, 9.0F);
      paramParams.addView((View)localObject1);
      new LinearLayout.LayoutParams(acwn.a(8.0F, getResources()), acwn.a(8.0F, getResources())).leftMargin = acwn.a(2.0F, getResources());
      new ImageView(paramContext).setImageResource(2130840208);
      paramContext = new GradientDrawable();
      paramContext.setShape(0);
      paramContext.setStroke(1, Color.parseColor("#EBEDF5"));
      paramContext.setCornerRadius(acwn.a(6.0F, getResources()));
      paramContext.setColor(-1);
      paramParams = new RelativeLayout.LayoutParams(acwn.a(88.0F, getResources()), acwn.a(34.0F, getResources()));
      paramParams.leftMargin = acwn.a(3.0F, getResources());
      paramParams.topMargin = acwn.a(18.0F, getResources());
      this.b = new TextView(getContext());
      this.b.setGravity(17);
      this.b.setText("不感兴趣");
      this.b.setTextColor(Color.parseColor("#333333"));
      this.b.setTextSize(2, 14.0F);
      if (Build.VERSION.SDK_INT >= 16) {
        this.b.setBackground(paramContext);
      }
      if (Build.VERSION.SDK_INT > 22) {
        ViewCompat.setElevation(this.b, acwn.a(5.0F, getResources()));
      }
      addView(this.b, paramParams);
      this.b.setVisibility(8);
      return;
      if (a().getCreativeSize() == 194)
      {
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setMaxLines(1);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setText(a().getText());
        ((TextView)localObject2).setTextColor(Color.parseColor("#333333"));
        ((TextView)localObject2).setTypeface(null, 1);
        ((TextView)localObject2).setTextSize(2, 14.0F);
        paramParams.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = acwn.a(8.0F, getResources());
        localObject2 = new TextView(paramContext);
        ((TextView)localObject2).setMaxLines(2);
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setText(a().getDescription());
        ((TextView)localObject2).setTextColor(Color.parseColor("#666666"));
        ((TextView)localObject2).setTextSize(2, 13.0F);
        paramParams.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
      }
      else
      {
        acvc.d("GdtBannerContainerView", "constructor");
      }
    }
  }
  
  private GdtAd a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a())) {
      return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
  private void a()
  {
    if (!a()) {}
    while (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int i = AdClickUtil.getActionAboutApp(GdtHandler.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params), -2147483648);
    if ((i == 4) || (i == 5)) {}
    for (String str = "打开";; str = "查看")
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) && (this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a()) && (a() != null) && (a().getImageData() != null) && (a().getImageData().a()) && ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184) || (a().getCreativeSize() == 194));
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(Context paramContext) {}
  
  public View b()
  {
    return this.b;
  }
  
  public void b(Context paramContext)
  {
    a();
  }
  
  public void c(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      acvc.d("GdtBannerContainerView", "setSize error");
      return;
    }
    paramInt1 = paramInt2 - 2;
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(Double.valueOf(1.0D * paramInt1 / a().getImageData().b * a().getImageData().jdField_a_of_type_Int).intValue(), paramInt1);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle
 * JD-Core Version:    0.7.0.1
 */