package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.RichTextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.TruncateAttr;

public class NativeTextImp
  extends TextView
  implements IView
{
  private static final String TAG = "NativeTextImp";
  private boolean hyperLinkClick = false;
  protected int mBackgroundColor = 0;
  protected Paint mBackgroundPaint;
  protected int mBorderBottomLeftRadius = 0;
  protected int mBorderBottomRightRadius = 0;
  protected int mBorderColor = -16777216;
  protected Paint mBorderPaint;
  protected int mBorderTopLeftRadius = 0;
  protected int mBorderTopRightRadius = 0;
  protected int mBorderWidth = 0;
  protected Boolean mEnableMarquee;
  protected int mFlags = 1;
  private TruncateAttr truncateAttr;
  
  public NativeTextImp(Context paramContext)
  {
    super(paramContext);
    getPaint().setAntiAlias(true);
  }
  
  private void handleException(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if ((paramCharSequence instanceof Spanned))
    {
      Object localObject1 = (Spanned)paramCharSequence;
      paramCharSequence = new SpannableStringBuilder((CharSequence)localObject1);
      int j = ((Spanned)localObject1).length();
      int i = 0;
      localObject1 = (MetricAffectingSpan[])((Spanned)localObject1).getSpans(0, j, MetricAffectingSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        j = localObject1.length;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          int k = paramCharSequence.getSpanStart(localObject2);
          if (isNotSpace(paramCharSequence, k - 1)) {
            paramCharSequence.insert(k, " ");
          }
          k = paramCharSequence.getSpanEnd(localObject2);
          if (isNotSpace(paramCharSequence, k)) {
            paramCharSequence.insert(k, " ");
          }
          i += 1;
        }
      }
      super.setText(paramCharSequence, paramBufferType);
    }
  }
  
  private boolean isNotSpace(CharSequence paramCharSequence, int paramInt)
  {
    return (paramInt < 0) || (paramInt >= paramCharSequence.length()) || (paramCharSequence.charAt(paramInt) != ' ');
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public boolean isFocused()
  {
    Boolean localBoolean = this.mEnableMarquee;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return super.isFocused();
  }
  
  public boolean isHyperLinkClick()
  {
    return this.hyperLinkClick;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mBackgroundColor != 0)
    {
      if (this.mBackgroundPaint == null)
      {
        this.mBackgroundPaint = new Paint();
        this.mBackgroundPaint.setAntiAlias(true);
      }
      this.mBackgroundPaint.setColor(this.mBackgroundColor);
      VirtualViewUtils.drawBackground(paramCanvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
    super.onDraw(paramCanvas);
    if ((this.mBorderWidth > 0) && (!TextUtils.isEmpty(getText())))
    {
      if (this.mBorderPaint == null)
      {
        this.mBorderPaint = new Paint();
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setAntiAlias(true);
      }
      this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
      this.mBorderPaint.setColor(this.mBorderColor);
      VirtualViewUtils.drawBorder(paramCanvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    Boolean localBoolean = this.mEnableMarquee;
    if (localBoolean != null)
    {
      super.onFocusChanged(localBoolean.booleanValue(), paramInt, paramRect);
      return;
    }
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    TruncateAttr localTruncateAttr = this.truncateAttr;
    if (localTruncateAttr != null)
    {
      RichTextUtils.addEllipsis2Text(this, localTruncateAttr);
      RichTextUtils.adjustImageSpan(this, this.truncateAttr);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Boolean localBoolean = this.mEnableMarquee;
    if (localBoolean != null)
    {
      super.onWindowFocusChanged(localBoolean.booleanValue());
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundColor = paramInt;
  }
  
  public void setBorderBottomLeftRadius(int paramInt)
  {
    this.mBorderBottomLeftRadius = paramInt;
  }
  
  public void setBorderBottomRightRadius(int paramInt)
  {
    this.mBorderBottomRightRadius = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.mBorderColor = paramInt;
  }
  
  public void setBorderTopLeftRadius(int paramInt)
  {
    this.mBorderTopLeftRadius = paramInt;
  }
  
  public void setBorderTopRightRadius(int paramInt)
  {
    this.mBorderTopRightRadius = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
  
  public void setEnableMarquee(boolean paramBoolean)
  {
    this.mEnableMarquee = Boolean.valueOf(paramBoolean);
    if (this.mEnableMarquee.booleanValue())
    {
      setSingleLine();
      setMarqueeRepeatLimit(-1);
      setFocusable(true);
      setHorizontallyScrolling(true);
      setEllipsize(TextUtils.TruncateAt.MARQUEE);
    }
  }
  
  public void setHyperLinkClick(boolean paramBoolean)
  {
    this.hyperLinkClick = paramBoolean;
  }
  
  public void setPaintFlags(int paramInt)
  {
    if (this.mFlags == paramInt) {
      return;
    }
    super.setPaintFlags(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    try
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      handleException(paramCharSequence, paramBufferType);
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("handleException error! msg=");
      paramCharSequence.append(localIndexOutOfBoundsException);
      LogUtil.QLog.e("NativeTextImp", 1, paramCharSequence.toString());
    }
  }
  
  public void setTruncateAttr(TruncateAttr paramTruncateAttr)
  {
    this.truncateAttr = paramTruncateAttr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp
 * JD-Core Version:    0.7.0.1
 */