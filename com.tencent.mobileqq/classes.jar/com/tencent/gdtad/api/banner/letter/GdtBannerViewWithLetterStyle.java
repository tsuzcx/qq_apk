package com.tencent.gdtad.api.banner.letter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;

public final class GdtBannerViewWithLetterStyle
  extends FrameLayout
  implements GdtBannerView
{
  private AdAntiSpamForClick a = new AdAntiSpamForClick();
  private GdtBannerView b;
  
  public GdtBannerViewWithLetterStyle(Context paramContext, GdtAd paramGdtAd)
  {
    super(paramContext);
    if ((paramContext != null) && (paramGdtAd != null) && (paramGdtAd.isValid()))
    {
      setBackgroundResource(2130840568);
      int j = paramGdtAd.getCreativeSize();
      int i = -2147483648;
      if ((j != 65) && (paramGdtAd.getCreativeSize() != 184) && (paramGdtAd.getCreativeSize() != 194))
      {
        if (paramGdtAd.getCreativeSize() == 285)
        {
          if ((paramGdtAd.getImageData(0) == null) || (paramGdtAd.getImageData(1) == null) || (paramGdtAd.getImageData(2) == null) || (!paramGdtAd.getImageData(0).a()) || (!paramGdtAd.getImageData(1).a()) || (!paramGdtAd.getImageData(2).a())) {
            break label424;
          }
          i = paramGdtAd.getImageData(0).b;
          j = paramGdtAd.getImageData(0).c;
        }
        else
        {
          j = -2147483648;
        }
      }
      else
      {
        if ((paramGdtAd.getImageData() == null) || (!paramGdtAd.getImageData().a())) {
          break label424;
        }
        i = paramGdtAd.getImageData().b;
        j = paramGdtAd.getImageData().c;
      }
      if ((i > 0) && (j > 0))
      {
        if ((paramGdtAd.getCreativeSize() != 65) && (paramGdtAd.getCreativeSize() != 184))
        {
          if (paramGdtAd.getCreativeSize() == 194)
          {
            this.b = new GdtBannerViewWithOnePicturePlusTwoTexts(paramContext, paramGdtAd.getImageData().a, i, j, paramGdtAd.getText(), paramGdtAd.getDescription());
          }
          else if (paramGdtAd.getCreativeSize() == 285)
          {
            this.b = new GdtBannerViewWithThreePicturesPlusOneText(paramContext, paramGdtAd.getImageData(0).a, paramGdtAd.getImageData(1).a, paramGdtAd.getImageData(2).a, i, j, paramGdtAd.getText());
          }
          else
          {
            GdtLog.d("GdtBannerViewWithLetterStyle", String.format("createBannerView error, creative size is %d", new Object[] { Integer.valueOf(paramGdtAd.getCreativeSize()) }));
            break label424;
          }
        }
        else {
          this.b = new GdtBannerViewWithOnePicturePlusOneText(paramContext, paramGdtAd.getImageData().a, i, j, paramGdtAd.getText());
        }
        addView(this.b.getView());
      }
      else
      {
        GdtLog.d("GdtBannerViewWithLetterStyle", "createBannerViewWithLetterStyle error, image width or image height is zero");
      }
      label424:
      paramContext = new ImageView(getContext());
      if ((paramGdtAd.getProductType() != 12) && (paramGdtAd.getProductType() != 38)) {
        paramContext.setImageResource(2130840570);
      } else {
        paramContext.setImageResource(2130840569);
      }
      addView(paramContext, -1, -1);
      return;
    }
    GdtLog.d("GdtBannerViewWithLetterStyle", "constructor");
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithLetterStyle", "pause");
    Object localObject = this.a;
    if (localObject != null) {
      ((AdAntiSpamForClick)localObject).setHasBeenPaused();
    }
    localObject = this.b;
    if (localObject == null) {
      return;
    }
    ((GdtBannerView)localObject).a(paramContext);
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithLetterStyle", "resume");
    GdtBannerView localGdtBannerView = this.b;
    if (localGdtBannerView == null) {
      return;
    }
    localGdtBannerView.b(paramContext);
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithLetterStyle", "destroy");
    GdtBannerView localGdtBannerView = this.b;
    if (localGdtBannerView == null) {
      return;
    }
    localGdtBannerView.c(paramContext);
  }
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return this.a;
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
    Object localObject = this.b;
    if ((localObject != null) && (((GdtBannerView)localObject).getView() != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      double d = paramInt1;
      Double.isNaN(d);
      int i = Double.valueOf(d * 0.7076023391812866D).intValue();
      d = paramInt2;
      Double.isNaN(d);
      int j = Double.valueOf(d * 0.9036144578313253D).intValue();
      d = paramInt1 - i;
      Double.isNaN(d);
      paramInt1 = Double.valueOf(d * 1.0D / 2.0D).intValue();
      d = paramInt2 - j;
      Double.isNaN(d);
      paramInt2 = Double.valueOf(d * 1.0D / 2.0D).intValue();
      localObject = new FrameLayout.LayoutParams(-1, -2);
      ((FrameLayout.LayoutParams)localObject).topMargin = paramInt2;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt2;
      ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt1;
      ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt1;
      this.b.getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setSize(i, j);
      return;
    }
    GdtLog.d("GdtBannerViewWithLetterStyle", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.letter.GdtBannerViewWithLetterStyle
 * JD-Core Version:    0.7.0.1
 */