package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdUIUtils;

public final class f
  extends TextView
{
  private static final String TAG = "AdCanvasAppBtnView";
  private final int MAX_PROGRESS = 100;
  private Rect bounds = new Rect();
  private Drawable leftBackroundDrawable;
  private RectF leftBounds = new RectF();
  private f.a params;
  private volatile float progress = 100.0F;
  private Drawable rightBackgroundDrawable;
  
  public f(Context paramContext, f.a parama)
  {
    super(paramContext);
    init(paramContext, parama);
  }
  
  private static Drawable createBackgroundDrawable(f.a parama, int paramInt)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setColor(paramInt);
    if (parama.borderCornerRadius > 0) {
      localGradientDrawable.setCornerRadius(parama.borderCornerRadius);
    }
    if (parama.borderWidth > 0) {
      localGradientDrawable.setStroke(parama.borderWidth, parama.borderColor);
    }
    return localGradientDrawable;
  }
  
  @TargetApi(16)
  private void init(Context paramContext, f.a parama)
  {
    if (parama == null)
    {
      AdLog.e("AdCanvasAppBtnView", "init error");
      return;
    }
    this.params = parama;
    try
    {
      setSingleLine(false);
      setLines(1);
      setGravity(17);
      setEllipsize(TextUtils.TruncateAt.END);
      int i = AdUIUtils.dp2px(5.0F, paramContext.getResources());
      setPadding(i, 0, i, 0);
      if (parama.textSize > 0) {
        setTextSize(0, parama.textSize);
      }
      setTextColor(parama.leftTextColor);
      this.leftBackroundDrawable = createBackgroundDrawable(parama, parama.leftBackgroundColor);
      this.rightBackgroundDrawable = createBackgroundDrawable(parama, parama.rightBackgroundColor);
      return;
    }
    catch (Exception paramContext)
    {
      AdLog.e("AdCanvasAppBtnView", "init error:", paramContext);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.bounds.set(0, 0, getWidth(), getHeight());
    this.leftBounds.set(0.0F, 0.0F, getWidth() * (this.progress / 100.0F), getHeight());
    paramCanvas.save();
    paramCanvas.clipRect(this.leftBounds);
    this.leftBackroundDrawable.setBounds(this.bounds);
    this.leftBackroundDrawable.draw(paramCanvas);
    setTextColor(this.params.leftTextColor);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
    if (this.progress < 100.0F)
    {
      paramCanvas.save();
      paramCanvas.clipRect(this.leftBounds, Region.Op.DIFFERENCE);
      this.rightBackgroundDrawable.setBounds(this.bounds);
      this.rightBackgroundDrawable.draw(paramCanvas);
      setTextColor(this.params.rightTextColor);
      super.onDraw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  public void setProgress(int paramInt)
  {
    float f = Math.min(Math.max(0, paramInt), 100);
    if (f != this.progress)
    {
      this.progress = f;
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.f
 * JD-Core Version:    0.7.0.1
 */