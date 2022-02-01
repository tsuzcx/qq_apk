package com.tencent.gdtad.api.banner.rectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;

public class GdtBannerViewWithRectangleNewStyle
  extends RelativeLayout
  implements GdtBannerView
{
  private GdtHandler.Params a;
  private AdAntiSpamForClick b = new AdAntiSpamForClick();
  private GdtBannerView c;
  private Path d;
  private RectF e;
  
  public GdtBannerViewWithRectangleNewStyle(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if ((paramContext != null) && (paramParams != null) && (paramParams.a()))
    {
      this.a = paramParams;
      if (!a())
      {
        GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
        return;
      }
      this.d = new Path();
      this.e = new RectF();
      paramContext = null;
      if ((getAd().getCreativeSize() != 65) && (getAd().getCreativeSize() != 184) && (getAd().getCreativeSize() != 194))
      {
        if (getAd().getCreativeSize() == 285)
        {
          paramContext = new GradientDrawable();
          paramContext.setColor(-1);
        }
      }
      else
      {
        int i = Color.argb(255, 255, 255, 255);
        int j = Color.argb(255, 192, 231, 255);
        paramContext = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
        paramContext.setGradientCenter(0.5F, 0.9F);
      }
      if (paramContext != null) {
        paramContext.setCornerRadius(10.0F);
      }
      if (Build.VERSION.SDK_INT >= 16) {
        setBackground(paramContext);
      }
      if ((getAd().getCreativeSize() == 65) || (getAd().getCreativeSize() == 184) || (getAd().getCreativeSize() == 194)) {
        this.c = new GdtBannerViewWithOnePicture(getContext(), paramParams);
      }
      if (getAd().getCreativeSize() == 285) {
        this.c = new GdtBannerViewWithThreePictures(getContext(), paramParams, GdtUIUtils.a(111.0F, getResources()), GdtUIUtils.a(83.0F, getResources()));
      }
      paramContext = this.c;
      if ((paramContext != null) && (paramContext.getView() != null)) {
        addView(this.c.getView());
      }
      return;
    }
    GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
  }
  
  private boolean a()
  {
    GdtHandler.Params localParams = this.a;
    return ((localParams != null) && (localParams.a()) && (getAd() != null) && (getAd().getImageData() != null) && (getAd().getImageData().a()) && ((getAd().getCreativeSize() == 65) || (getAd().getCreativeSize() == 184) || (getAd().getCreativeSize() == 194))) || (getAd().getCreativeSize() == 285);
  }
  
  private GdtAd getAd()
  {
    GdtHandler.Params localParams = this.a;
    if ((localParams != null) && (localParams.a())) {
      return this.a.a;
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "pause");
    GdtBannerView localGdtBannerView = this.c;
    if ((localGdtBannerView != null) && (localGdtBannerView.getAntiSpamForClick() != null)) {
      this.c.getAntiSpamForClick().setHasBeenPaused();
    }
    localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      localGdtBannerView.a(paramContext);
    }
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "resume");
    GdtBannerView localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      localGdtBannerView.b(paramContext);
    }
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "destroy");
    GdtBannerView localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      localGdtBannerView.c(paramContext);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    if (Build.VERSION.SDK_INT < 21)
    {
      this.d.reset();
      this.e.set(0.0F, 0.0F, i, j);
      this.d.addRoundRect(this.e, 8.0F, 8.0F, Path.Direction.CW);
      paramCanvas.clipPath(this.d);
    }
    else
    {
      setClipToOutline(true);
      setOutlineProvider(new GdtBannerViewWithRectangleNewStyle.1(this, i, j));
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public AdAntiSpamForClick getAntiSpamForClick()
  {
    return this.b;
  }
  
  public View getCloseView()
  {
    GdtBannerView localGdtBannerView = this.c;
    if (localGdtBannerView != null) {
      return localGdtBannerView.getCloseView();
    }
    return null;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    Object localObject = this.c;
    if ((localObject != null) && (((GdtBannerView)localObject).getView() != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      this.c.getView().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.c.setSize(paramInt1, paramInt2);
      return;
    }
    GdtLog.d("GdtBannerViewWithRectangleStyle", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleNewStyle
 * JD-Core Version:    0.7.0.1
 */