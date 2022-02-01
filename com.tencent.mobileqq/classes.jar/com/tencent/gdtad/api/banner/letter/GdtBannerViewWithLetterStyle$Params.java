package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import com.tencent.gdtad.log.GdtLog;

final class GdtBannerViewWithLetterStyle$Params
{
  public int a = -2147483648;
  public int b = -2147483648;
  public int c = -2147483648;
  public int d = -2147483648;
  
  public GdtBannerViewWithLetterStyle$Params(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      GdtLog.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    this.a = Double.valueOf(0.02892561983471075D * paramInt1).intValue();
    this.b = Double.valueOf(0.02666666666666667D * paramInt2).intValue();
    this.c = Double.valueOf(0.06666666666666667D * paramInt2).intValue();
    this.d = Double.valueOf(0.16D * paramInt2).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle.Params
 * JD-Core Version:    0.7.0.1
 */