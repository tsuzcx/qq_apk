package com.tencent.gdtad.api.banner.letter;

import ackj;
import acli;
import aclp;
import aclq;
import acqy;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.gdtad.aditem.GdtAd;

public final class GdtBannerViewWithLetterStyle
  extends FrameLayout
  implements acli
{
  acli a;
  
  public GdtBannerViewWithLetterStyle(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext == null) || (paramGdtAd == null) || (!paramGdtAd.isValid()))
    {
      acqy.d("GdtBannerViewWithLetterStyle", "constructor");
      return;
    }
    setBackgroundResource(2130840197);
    if ((paramGdtAd.getImageData() == null) || (!paramGdtAd.getImageData().a()))
    {
      paramContext = new ImageView(getContext());
      paramContext.setImageResource(2130840198);
      addView(paramContext, -1, -1);
      return;
    }
    int i;
    if (paramGdtAd.getImageData() != null)
    {
      i = paramGdtAd.getImageData().jdField_a_of_type_Int;
      j = paramGdtAd.getImageData().b;
    }
    for (;;)
    {
      if ((i <= 0) || (j <= 0))
      {
        acqy.d("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
        break;
      }
      if ((paramGdtAd.getCreativeSize() == 65) || (paramGdtAd.getCreativeSize() == 184)) {}
      for (this.a = new aclp(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText());; this.a = new aclq(paramContext, paramGdtAd.getImageData().jdField_a_of_type_JavaLangString, i, j, paramGdtAd.getText(), paramGdtAd.getDescription()))
      {
        addView(this.a.a());
        break;
        if (paramGdtAd.getCreativeSize() != 194) {
          break label228;
        }
      }
      label228:
      acqy.d("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
      break;
      i = -2147483648;
    }
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.a(paramContext);
  }
  
  public View b()
  {
    return null;
  }
  
  public void b(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.b(paramContext);
  }
  
  public void c(Context paramContext)
  {
    if (this.a == null) {
      return;
    }
    this.a.c(paramContext);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (this.a.a() == null) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      acqy.d("GdtBannerViewWithLetterStyle", "setSize error");
      return;
    }
    int i = Double.valueOf(0.7076023391812866D * paramInt1).intValue();
    int j = Double.valueOf(0.9036144578313253D * paramInt2).intValue();
    paramInt1 = Double.valueOf((paramInt1 - i) * 1.0D / 2.0D).intValue();
    paramInt2 = Double.valueOf((paramInt2 - j) * 1.0D / 2.0D).intValue();
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.bottomMargin = paramInt2;
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.rightMargin = paramInt1;
    this.a.a().setLayoutParams(localLayoutParams);
    this.a.setSize(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle
 * JD-Core Version:    0.7.0.1
 */