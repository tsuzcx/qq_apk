package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;

class NativeButton$CenterImageSpan
  extends ImageSpan
{
  public NativeButton$CenterImageSpan(NativeButton paramNativeButton, @NonNull Drawable paramDrawable)
  {
    super(paramDrawable);
    if (TextUtils.isEmpty(NativeButton.access$000(paramNativeButton)))
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() + paramNativeButton.mCompoundDrawablePadding, getDrawableHeight());
      return;
    }
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() + paramNativeButton.mCompoundDrawablePadding, NativeButton.access$100(paramNativeButton));
  }
  
  private int getDrawableHeight()
  {
    if (NativeButton.access$800(this.this$0) > 0) {
      return NativeButton.access$900(this.this$0);
    }
    if (NativeButton.access$300(this.this$0).getComMeasuredHeight() > 0) {
      return NativeButton.access$300(this.this$0).getComMeasuredHeight();
    }
    if ((NativeButton.access$1000(this.this$0) != null) && (NativeButton.access$1100(this.this$0).mLayoutHeight > 0)) {
      return NativeButton.access$1200(this.this$0).mLayoutHeight;
    }
    return NativeButton.access$1300(this.this$0);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramPaint = paramPaint.getFontMetricsInt();
    int j;
    int i;
    if (TextUtils.isEmpty(NativeButton.access$200(this.this$0)))
    {
      paramCanvas.save();
      j = (NativeButton.access$300(this.this$0).getMeasuredHeight() - paramCharSequence.getIntrinsicHeight()) / 2;
      Rect localRect = paramCharSequence.getBounds();
      i = j;
      if (localRect.bottom != getDrawableHeight()) {
        i = j - (getDrawableHeight() - localRect.bottom) / 2;
      }
      paramCanvas.translate(paramFloat, i);
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth(), paramCharSequence.getIntrinsicHeight());
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() + this.this$0.mCompoundDrawablePadding, getDrawableHeight());
    }
    for (;;)
    {
      if (LogUtils.shouldLog()) {
        LogUtils.d("NativeButton", NativeButton.access$600(this.this$0) + " : draw:  start:" + paramInt1 + " end:" + paramInt2 + " x:" + paramFloat + " top:" + paramInt3 + " y:" + paramInt4 + " bottom:" + paramInt5 + " fm:" + paramPaint + " drawable getIntrinsicHeight :" + paramCharSequence.getIntrinsicHeight() + " mTextSize :" + NativeButton.access$700(this.this$0) + "measureHeight: " + NativeButton.access$300(this.this$0).getMeasuredHeight() + "transY: " + i);
      }
      return;
      j = NativeButton.access$400(this.this$0);
      i = j;
      if (NativeButton.access$300(this.this$0).getMeasuredHeight() > 0)
      {
        i = j;
        if (j > NativeButton.access$300(this.this$0).getMeasuredHeight()) {
          i = NativeButton.access$300(this.this$0).getMeasuredHeight();
        }
      }
      j = (paramPaint.descent + paramInt4 + paramInt4 + paramPaint.ascent) / 2;
      int k = paramCharSequence.getBounds().bottom / 2;
      i = (i - paramCharSequence.getIntrinsicHeight()) / 2 + (j - k);
      paramCanvas.save();
      paramCanvas.translate(paramFloat, i);
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth(), paramCharSequence.getIntrinsicHeight());
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
      paramCharSequence.setBounds(0, 0, paramCharSequence.getIntrinsicWidth() + this.this$0.mCompoundDrawablePadding, NativeButton.access$500(this.this$0));
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    return getDrawable().getIntrinsicWidth() + this.this$0.mCompoundDrawablePadding;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton.CenterImageSpan
 * JD-Core Version:    0.7.0.1
 */