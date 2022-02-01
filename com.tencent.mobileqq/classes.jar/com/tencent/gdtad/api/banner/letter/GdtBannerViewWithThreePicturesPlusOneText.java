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
  private int a = -2147483648;
  private int b = -2147483648;
  private GdtBannerImageView c;
  private GdtBannerImageView d;
  private GdtBannerImageView e;
  private TextView f;
  
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
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new GdtBannerImageView(paramContext, paramString1);
      this.c.setId(2131434091);
      localLinearLayout.addView(this.c);
      this.d = new GdtBannerImageView(paramContext, paramString2);
      this.d.setId(2131434092);
      localLinearLayout.addView(this.d);
      this.e = new GdtBannerImageView(paramContext, paramString3);
      this.e.setId(2131434093);
      localLinearLayout.addView(this.e);
      this.f = new TextView(paramContext);
      this.f.setGravity(1);
      this.f.setId(2131434094);
      this.f.setLines(1);
      this.f.setEllipsize(TextUtils.TruncateAt.END);
      this.f.setTextColor(Color.parseColor("#333333"));
      this.f.setText(paramString4);
      addView(this.f);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize285", "constructor");
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
    if ((this.a > 0) && (this.b > 0) && (this.c != null) && (this.d != null) && (this.e != null) && (this.f != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      GdtBannerViewWithLetterStyle.Params localParams = new GdtBannerViewWithLetterStyle.Params(getContext(), paramInt1, paramInt2);
      double d1 = paramInt1 - localParams.a * 2;
      Double.isNaN(d1);
      paramInt2 = Double.valueOf(d1 * 1.0D / 3.0D).intValue();
      d1 = paramInt2 - localParams.b * 2;
      Double.isNaN(d1);
      double d2 = this.a;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = this.b;
      Double.isNaN(d2);
      double d3 = localParams.b * 2;
      Double.isNaN(d3);
      int i = Double.valueOf(d1 * d2 + d3).intValue();
      d1 = paramInt1;
      Double.isNaN(d1);
      paramInt1 = Double.valueOf(d1 * 0.839285714285714D).intValue();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = 0;
      this.c.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = localParams.a;
      this.d.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
      this.d.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt2, i);
      localLayoutParams.leftMargin = localParams.a;
      this.e.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
      this.e.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(paramInt1, -2);
      localLayoutParams.topMargin = localParams.b;
      this.f.setLayoutParams(localLayoutParams);
      this.f.setTextSize(0, localParams.d);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize285", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithThreePicturesPlusOneText
 * JD-Core Version:    0.7.0.1
 */