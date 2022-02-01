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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/RIJRoundProgressBar;", "Landroid/view/View;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/view/IProgressView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnResource", "", "colorHighLight", "colorNormal", "colorPause", "currentProgress", "isPause", "Ljava/util/concurrent/atomic/AtomicBoolean;", "paint", "Landroid/graphics/Paint;", "pauseBtnRect", "Landroid/graphics/RectF;", "pauseRectColor", "", "pauseRectWidth", "", "progressColorHighLight", "progressColorNormal", "progressHighLightWidth", "progressRect", "progressWidthNormal", "startAngle", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pause", "setProgress", "progress", "setProgressStyle", "style", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/common_ad_download/style/IDownloadStyle;", "setProgressText", "text", "start", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRoundProgressBar
  extends View
  implements IProgressView
{
  private float jdField_a_of_type_Float = 2.0F;
  private int jdField_a_of_type_Int = 270;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString = "#CCE5E5E5";
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private float jdField_b_of_type_Float = 2.0F;
  private int jdField_b_of_type_Int;
  private final RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_b_of_type_JavaLangString = "#FF00CAFC";
  private float jdField_c_of_type_Float = 8.0F;
  private int jdField_c_of_type_Int = ParseUtil.a(this.jdField_a_of_type_JavaLangString, "#CCE5E5E5");
  private String jdField_c_of_type_JavaLangString = "#FF00CAFC";
  private int d = ParseUtil.a(this.jdField_b_of_type_JavaLangString, "#FF00CAFC");
  private int e = ParseUtil.a(this.jdField_c_of_type_JavaLangString, "#FF00CAFC");
  private int f = -1;
  
  public RIJRoundProgressBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        postInvalidate();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(true, false)) {
        postInvalidate();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onDraw(@Nullable Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    int k = i - AIOUtils.a(this.jdField_a_of_type_Float, getResources()) / 2;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
    ((Paint)localObject).setStrokeWidth(AIOUtils.a(this.jdField_a_of_type_Float, getResources()));
    ((Paint)localObject).setColor(this.jdField_c_of_type_Int);
    ((Paint)localObject).setAntiAlias(true);
    ((Paint)localObject).setStrokeCap(Paint.Cap.ROUND);
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (paramCanvas != null) {
      paramCanvas.drawCircle(i, j, k, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.a(this.jdField_b_of_type_Float, getResources()));
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    ((RectF)localObject).left = (i - k);
    ((RectF)localObject).top = (j - k);
    ((RectF)localObject).right = (i + k);
    ((RectF)localObject).bottom = (k + j);
    k = this.jdField_b_of_type_Int * 360 / 100;
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Int, k, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      ((Paint)localObject).setColor(this.e);
      float f1 = AIOUtils.a(this.jdField_c_of_type_Float, getResources()) / 2.0F;
      localObject = this.jdField_b_of_type_AndroidGraphicsRectF;
      ((RectF)localObject).left = (i - f1);
      ((RectF)localObject).top = (j - f1);
      ((RectF)localObject).right = (i + f1);
      ((RectF)localObject).bottom = (f1 + j);
      if (paramCanvas != null) {
        paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
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
      this.jdField_b_of_type_Int = paramInt;
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
    this.jdField_a_of_type_Float = ((RoundProgressStyle)paramIDownloadStyle).getProgressWidthNormal();
    this.jdField_b_of_type_Float = ((RoundProgressStyle)paramIDownloadStyle).getProgressHighLightWidth();
    this.jdField_c_of_type_Float = ((RoundProgressStyle)paramIDownloadStyle).getPauseRectWidth();
    this.jdField_a_of_type_JavaLangString = ((RoundProgressStyle)paramIDownloadStyle).getProgressColorNormal();
    this.jdField_b_of_type_JavaLangString = ((RoundProgressStyle)paramIDownloadStyle).getProgressColorHighLight();
    this.jdField_c_of_type_JavaLangString = ((RoundProgressStyle)paramIDownloadStyle).getPauseRectColor();
    this.jdField_c_of_type_Int = ParseUtil.a(this.jdField_a_of_type_JavaLangString, "#CCE5E5E5");
    this.d = ParseUtil.a(this.jdField_b_of_type_JavaLangString, "#FF00CAFC");
    this.e = ParseUtil.a(this.jdField_c_of_type_JavaLangString, "#FF00CAFC");
    this.jdField_a_of_type_Int = ((RoundProgressStyle)paramIDownloadStyle).getStartAngle();
    this.f = ((RoundProgressStyle)paramIDownloadStyle).getBtnResource();
  }
  
  public void setProgressText(@Nullable String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJRoundProgressBar
 * JD-Core Version:    0.7.0.1
 */