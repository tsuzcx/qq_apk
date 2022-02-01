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
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private AdAntiSpamForClick jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick = new AdAntiSpamForClick();
  private GdtHandler.Params jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  private GdtBannerView jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
  
  public GdtBannerViewWithRectangleNewStyle(Context paramContext, GdtHandler.Params paramParams)
  {
    super(paramContext);
    if ((paramContext != null) && (paramParams != null) && (paramParams.a()))
    {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
      if (!a())
      {
        GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      paramContext = null;
      if ((a().getCreativeSize() != 65) && (a().getCreativeSize() != 184) && (a().getCreativeSize() != 194))
      {
        if (a().getCreativeSize() == 285)
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
      if ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184) || (a().getCreativeSize() == 194)) {
        this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = new GdtBannerViewWithOnePicture(getContext(), paramParams);
      }
      if (a().getCreativeSize() == 285) {
        this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = new GdtBannerViewWithThreePictures(getContext(), paramParams, GdtUIUtils.a(111.0F, getResources()), GdtUIUtils.a(83.0F, getResources()));
      }
      paramContext = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
      if ((paramContext != null) && (paramContext.a() != null)) {
        addView(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a());
      }
      return;
    }
    GdtLog.d("GdtBannerViewWithRectangleStyle", "constructor");
  }
  
  private GdtAd a()
  {
    GdtHandler.Params localParams = this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    if ((localParams != null) && (localParams.a())) {
      return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params.a;
    }
    return null;
  }
  
  private boolean a()
  {
    GdtHandler.Params localParams = this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
    return ((localParams != null) && (localParams.a()) && (a() != null) && (a().getImageData() != null) && (a().getImageData().a()) && ((a().getCreativeSize() == 65) || (a().getCreativeSize() == 184) || (a().getCreativeSize() == 194))) || (a().getCreativeSize() == 285);
  }
  
  public View a()
  {
    return this;
  }
  
  public AdAntiSpamForClick a()
  {
    return this.jdField_a_of_type_ComTencentAdTangramStatisticsAdAntiSpamForClick;
  }
  
  public void a(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "pause");
    GdtBannerView localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if ((localGdtBannerView != null) && (localGdtBannerView.a() != null)) {
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a().setHasBeenPaused();
    }
    localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localGdtBannerView != null) {
      localGdtBannerView.a(paramContext);
    }
  }
  
  public View b()
  {
    GdtBannerView localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localGdtBannerView != null) {
      return localGdtBannerView.b();
    }
    return null;
  }
  
  public void b(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "resume");
    GdtBannerView localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localGdtBannerView != null) {
      localGdtBannerView.b(paramContext);
    }
  }
  
  public void c(Context paramContext)
  {
    GdtLog.b("GdtBannerViewWithRectangleStyle", "destroy");
    GdtBannerView localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
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
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 8.0F, 8.0F, Path.Direction.CW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    else
    {
      setClipToOutline(true);
      setOutlineProvider(new GdtBannerViewWithRectangleNewStyle.1(this, i, j));
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if ((localObject != null) && (((GdtBannerView)localObject).a() != null) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      localObject = new RelativeLayout.LayoutParams(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a().setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.setSize(paramInt1, paramInt2);
      return;
    }
    GdtLog.d("GdtBannerViewWithRectangleStyle", "setSize error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleNewStyle
 * JD-Core Version:    0.7.0.1
 */