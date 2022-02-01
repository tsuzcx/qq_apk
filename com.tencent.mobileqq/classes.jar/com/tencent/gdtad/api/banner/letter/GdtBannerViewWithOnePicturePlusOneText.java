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
  private int a = -2147483648;
  private int b = -2147483648;
  private GdtBannerImageView c;
  private TextView d;
  
  public GdtBannerViewWithOnePicturePlusOneText(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    super(paramContext);
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      setOrientation(0);
      setGravity(16);
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new GdtBannerImageView(paramContext, paramString1);
      this.c.setId(2131434091);
      addView(this.c);
      this.d = new TextView(paramContext);
      this.d.setId(2131434094);
      this.d.setMaxLines(4);
      this.d.setEllipsize(TextUtils.TruncateAt.END);
      this.d.setTextColor(Color.parseColor("#333333"));
      this.d.setText(paramString2);
      addView(this.d);
      return;
    }
    GdtLog.d("GdtBannerViewWithPictureText", "constructor");
  }
  
  public void a(Context paramContext) {}
  
  public void b(Context paramContext) {}
  
  public void c(Context paramContext) {}
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return null;
  }
  
  public View getCloseView()
  {
    return null;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.a > 0) && (this.b > 0) && (this.c != null) && (this.d != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      GdtBannerViewWithLetterStyle.Params localParams = new GdtBannerViewWithLetterStyle.Params(getContext(), paramInt1, paramInt2);
      double d1 = paramInt2 - localParams.b * 2;
      Double.isNaN(d1);
      double d2 = this.b;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = this.a;
      Double.isNaN(d2);
      double d3 = localParams.b * 2;
      Double.isNaN(d3);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(Double.valueOf(d1 * d2 + d3).intValue(), paramInt2);
      this.c.setLayoutParams(localLayoutParams);
      this.c.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.leftMargin = localParams.a;
      this.d.setLayoutParams(localLayoutParams);
      this.d.setTextSize(0, localParams.d);
      return;
    }
    GdtLog.d("GdtBannerViewWithPictureText", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithOnePicturePlusOneText
 * JD-Core Version:    0.7.0.1
 */