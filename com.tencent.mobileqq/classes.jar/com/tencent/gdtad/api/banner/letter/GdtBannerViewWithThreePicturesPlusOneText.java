package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;

final class GdtBannerViewWithThreePicturesPlusOneText
  extends LinearLayout
  implements GdtBannerView
{
  private int jdField_a_of_type_Int = -2147483648;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtBannerImageView jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView;
  private int jdField_b_of_type_Int = -2147483648;
  private GdtBannerImageView jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView;
  private GdtBannerImageView c;
  
  public GdtBannerViewWithThreePicturesPlusOneText(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    super(paramContext);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      setOrientation(1);
      setGravity(1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(0);
      addView(localLinearLayout, localLayoutParams);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView = new GdtBannerImageView(paramContext, paramString1);
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setId(2131367549);
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView);
      this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView = new GdtBannerImageView(paramContext, paramString2);
      this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setId(2131367550);
      localLinearLayout.addView(this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView);
      this.c = new GdtBannerImageView(paramContext, paramString3);
      this.c.setId(2131367551);
      localLinearLayout.addView(this.c);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367552);
      this.jdField_a_of_type_AndroidWidgetTextView.setLines(1);
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString4);
      addView(this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize285", "constructor");
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return null;
  }
  
  public void a(Context paramContext) {}
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView != null) && (this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView != null) && (this.c != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      GdtBannerViewWithLetterStyle.Params localParams = new GdtBannerViewWithLetterStyle.Params(getContext(), paramInt1, paramInt2);
      double d1 = paramInt1 - localParams.jdField_a_of_type_Int * 2;
      Double.isNaN(d1);
      paramInt2 = Double.valueOf(d1 * 1.0D / 3.0D).intValue();
      d1 = paramInt2 - localParams.jdField_b_of_type_Int * 2;
      Double.isNaN(d1);
      double d2 = this.jdField_a_of_type_Int;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = this.jdField_b_of_type_Int;
      Double.isNaN(d2);
      double d3 = localParams.jdField_b_of_type_Int * 2;
      Double.isNaN(d3);
      int i = Double.valueOf(d1 * d2 + d3).intValue();
      d1 = paramInt1;
      Double.isNaN(d1);
      paramInt1 = Double.valueOf(d1 * 0.839285714285714D).intValue();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = 0;
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setPadding(localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = localParams.jdField_a_of_type_Int;
      this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setPadding(localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = localParams.jdField_a_of_type_Int;
      this.c.setPadding(localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int, localParams.jdField_b_of_type_Int);
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
      localLayoutParams.topMargin = localParams.jdField_b_of_type_Int;
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localParams.d);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize285", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithThreePicturesPlusOneText
 * JD-Core Version:    0.7.0.1
 */