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

final class GdtBannerViewWithOnePicturePlusTwoTexts
  extends LinearLayout
  implements GdtBannerView
{
  private int a = -2147483648;
  private int b = -2147483648;
  private GdtBannerImageView c;
  private LinearLayout d;
  private TextView e;
  private TextView f;
  
  public GdtBannerViewWithOnePicturePlusTwoTexts(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
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
      this.d = new LinearLayout(paramContext);
      this.d.setOrientation(1);
      addView(this.d);
      this.e = new TextView(paramContext);
      this.e.setId(2131434094);
      this.e.setLines(1);
      this.e.setEllipsize(TextUtils.TruncateAt.END);
      this.e.setTextColor(Color.parseColor("#333333"));
      this.e.setText(paramString2);
      this.d.addView(this.e);
      this.f = new TextView(paramContext);
      this.f.setId(2131434086);
      this.f.setMaxLines(2);
      this.f.setEllipsize(TextUtils.TruncateAt.END);
      this.f.setTextColor(Color.parseColor("#666666"));
      this.f.setText(paramString3);
      this.d.addView(this.f);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize194", "constructor");
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
      double d1 = paramInt2 - localParams.b * 2;
      Double.isNaN(d1);
      double d2 = this.b;
      Double.isNaN(d2);
      d1 = d1 * 1.0D / d2;
      d2 = this.a;
      Double.isNaN(d2);
      double d3 = localParams.b * 2;
      Double.isNaN(d3);
      paramInt1 = Double.valueOf(d1 * d2 + d3).intValue();
      this.c.setPadding(localParams.b, localParams.b, localParams.b, localParams.b);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(paramInt1, paramInt2);
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.leftMargin = localParams.a;
      this.d.setLayoutParams(localLayoutParams);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      this.e.setLayoutParams(localLayoutParams);
      this.e.setTextSize(0, localParams.d);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = localParams.c;
      this.f.setLayoutParams(localLayoutParams);
      this.f.setTextSize(0, localParams.d);
      return;
    }
    GdtLog.d("GdtBannerViewForCreativeSize194", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithOnePicturePlusTwoTexts
 * JD-Core Version:    0.7.0.1
 */