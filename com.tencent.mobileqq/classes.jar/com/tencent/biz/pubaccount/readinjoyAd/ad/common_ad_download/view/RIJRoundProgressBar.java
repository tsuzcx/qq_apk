package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.IDownloadStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "Landroid/view/View;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnResource", "", "colorHighLight", "colorNormal", "colorPause", "currentProgress", "isPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "paint", "Landroid/graphics/Paint;", "pauseBtnRect", "Landroid/graphics/RectF;", "pauseRectColor", "", "pauseRectWidth", "", "progressColorHighLight", "progressColorNormal", "progressHighLightWidth", "progressRect", "progressWidthNormal", "startAngle", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pause", "setProgress", "progress", "setProgressStyle", "style", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setProgressText", "text", "start", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class RIJRoundProgressBar
  extends View
  implements IProgressView
{
  private final Paint a = new Paint();
  private float b = 2.0F;
  private float c = 2.0F;
  private float d = 8.0F;
  private String e = "#CCE5E5E5";
  private String f = "#FF00CAFC";
  private String g = "#FF00CAFC";
  private int h = 270;
  private int i;
  private int j = ParseUtil.a(this.e, "#CCE5E5E5");
  private int k = ParseUtil.a(this.f, "#FF00CAFC");
  private int l = ParseUtil.a(this.g, "#FF00CAFC");
  private int m = -1;
  private final RectF n = new RectF();
  private final RectF o = new RectF();
  private final AtomicBoolean p = new AtomicBoolean(false);
  
  public RIJRoundProgressBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth() / 2;
    int i2 = getHeight() / 2;
    int i3 = i1 - ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(this.b, getResources()) / 2;
    Object localObject = this.a;
    ((Paint)localObject).setStrokeWidth(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(this.b, getResources()));
    ((Paint)localObject).setColor(this.j);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStrokeCap(Paint.Cap.ROUND);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (paramCanvas != null) {
      paramCanvas.drawCircle(i1, i2, i3, this.a);
    }
    this.a.setStrokeWidth(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(this.c, getResources()));
    this.a.setColor(this.k);
    localObject = this.n;
    ((RectF)localObject).left = (i1 - i3);
    ((RectF)localObject).top = (i2 - i3);
    ((RectF)localObject).right = (i1 + i3);
    ((RectF)localObject).bottom = (i3 + i2);
    i3 = this.i * 360 / 100;
    if (paramCanvas != null) {
      paramCanvas.drawArc((RectF)localObject, this.h, i3, false, this.a);
    }
    if (this.p.get())
    {
      localObject = this.a;
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setColor(this.l);
      float f1 = ((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(this.d, getResources()) / 2.0F;
      localObject = this.o;
      float f2 = i1;
      ((RectF)localObject).left = (f2 - f1);
      float f3 = i2;
      ((RectF)localObject).top = (f3 - f1);
      ((RectF)localObject).right = (f2 + f1);
      ((RectF)localObject).bottom = (f3 + f1);
      if (paramCanvas != null) {
        paramCanvas.drawRect((RectF)localObject, this.a);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View.MeasureSpec.getSize(paramInt1);
    setMeasuredDimension(View.getDefaultSize(0, paramInt1), View.getDefaultSize(0, paramInt2));
    paramInt1 = View.MeasureSpec.makeMeasureSpec(RangesKt.coerceAtMost(getMeasuredWidth(), getMeasuredHeight()), 1073741824);
    super.onMeasure(paramInt1, paramInt1);
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      this.i = paramInt;
      postInvalidate();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setProgressStyle(@Nullable IDownloadStyle paramIDownloadStyle)
  {
    if (!(paramIDownloadStyle instanceof RoundProgressStyle)) {
      return;
    }
    paramIDownloadStyle = (RoundProgressStyle)paramIDownloadStyle;
    this.b = paramIDownloadStyle.getProgressWidthNormal();
    this.c = paramIDownloadStyle.getProgressHighLightWidth();
    this.d = paramIDownloadStyle.getPauseRectWidth();
    this.e = paramIDownloadStyle.getProgressColorNormal();
    this.f = paramIDownloadStyle.getProgressColorHighLight();
    this.g = paramIDownloadStyle.getPauseRectColor();
    this.j = ParseUtil.a(this.e, "#CCE5E5E5");
    this.k = ParseUtil.a(this.f, "#FF00CAFC");
    this.l = ParseUtil.a(this.g, "#FF00CAFC");
    this.h = paramIDownloadStyle.getStartAngle();
    this.m = paramIDownloadStyle.getBtnResource();
  }
  
  public void setProgressText(@Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJRoundProgressBar
 * JD-Core Version:    0.7.0.1
 */