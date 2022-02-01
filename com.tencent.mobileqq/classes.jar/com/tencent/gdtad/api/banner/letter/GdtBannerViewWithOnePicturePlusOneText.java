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

final class GdtBannerViewWithOnePicturePlusOneText
  extends LinearLayout
  implements GdtBannerView
{
  private int jdField_a_of_type_Int = -2147483648;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GdtBannerImageView jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView;
  private int b = -2147483648;
  
  public GdtBannerViewWithOnePicturePlusOneText(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramInt1 < 0) || (paramInt2 < 0))
    {
      GdtLog.d("GdtBannerViewWithPictureText", "constructor");
      return;
    }
    setOrientation(0);
    setGravity(16);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView = new GdtBannerImageView(paramContext, paramString1);
    this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setId(2131367786);
    addView(this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131367789);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#333333"));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
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
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0) || (this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView == null) || (this.jdField_a_of_type_AndroidWidgetTextView == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      GdtLog.d("GdtBannerViewWithPictureText", "setSize error");
      return;
    }
    GdtBannerViewWithLetterStyle.Params localParams = new GdtBannerViewWithLetterStyle.Params(getContext(), paramInt1, paramInt2);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(Double.valueOf(1.0D * (paramInt2 - localParams.b * 2) / this.b * this.jdField_a_of_type_Int + localParams.b * 2).intValue(), paramInt2);
    this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerLetterGdtBannerImageView.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = localParams.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, localParams.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithOnePicturePlusOneText
 * JD-Core Version:    0.7.0.1
 */