package com.tencent.ditto.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.ditto.annoations.SourceCode.DittoJsonElement;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.LayoutAttrSet;
import com.tencent.ditto.utils.DittoLog;
import com.tencent.ditto.utils.DittoResourcesUtil;

public class DittoButtonArea
  extends DittoArea
{
  @DittoJsonElement("点击态颜色")
  public static final String PressBgColor = "press_bg_color";
  @DittoJsonElement
  public static final String Text = "text";
  @DittoJsonElement
  public static final String TextColor = "text_color";
  @DittoJsonElement
  public static final String TextSize = "text_size";
  private CharSequence mText = "";
  private int mTextColor = -16777216;
  private TextPaint mTextPaint = new TextPaint();
  private int mTextSize = 15;
  private Drawable normalStateDrawable;
  private int pressBgColor = 0;
  private GradientDrawable pressedDrawable;
  private Drawable pressedStateDrawable;
  private boolean showClickState = false;
  
  public DittoButtonArea(DittoHost paramDittoHost, LayoutAttrSet paramLayoutAttrSet)
  {
    super(paramDittoHost, paramLayoutAttrSet);
    this.mTextPaint.setTextAlign(Paint.Align.CENTER);
    this.mTextPaint.setAntiAlias(true);
    setBorderColor(-13750738);
    setBorderWidth(1);
    setAttr(paramLayoutAttrSet);
  }
  
  private GradientDrawable getPressedDrawable()
  {
    if (this.pressedDrawable == null)
    {
      this.pressedDrawable = new GradientDrawable();
      this.pressedDrawable.setColor(this.pressBgColor);
    }
    return this.pressedDrawable;
  }
  
  private Drawable getPressedStateDrawable()
  {
    Drawable localDrawable = this.pressedStateDrawable;
    if (localDrawable != null) {
      return localDrawable;
    }
    if (this.pressedDrawable == null)
    {
      this.pressedDrawable = new GradientDrawable();
      this.pressedDrawable.setColor(this.pressBgColor);
    }
    return this.pressedDrawable;
  }
  
  private void setAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    if (paramLayoutAttrSet != null)
    {
      String str;
      StringBuilder localStringBuilder;
      if (paramLayoutAttrSet.getAttr("press_bg_color", null) != null)
      {
        str = paramLayoutAttrSet.getAttr("press_bg_color", null);
        try
        {
          setPressBgColor(DittoResourcesUtil.parseColor(str));
          this.showClickState = true;
        }
        catch (Throwable localThrowable1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("the text ");
          localStringBuilder.append(str);
          localStringBuilder.append(" can't be parsed as color string");
          DittoLog.e("DITTO_UI", localStringBuilder.toString(), localThrowable1);
        }
      }
      if (paramLayoutAttrSet.getAttr("text_color", null) != null)
      {
        str = paramLayoutAttrSet.getAttr("text_color", null);
        if (!TextUtils.isEmpty(str)) {
          try
          {
            this.mTextColor = DittoResourcesUtil.parseColor(str);
            this.mTextPaint.setColor(this.mTextColor);
          }
          catch (Throwable localThrowable2)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("the text ");
            localStringBuilder.append(str);
            localStringBuilder.append(" can't be parsed as color string");
            DittoLog.e("DITTO_UI", localStringBuilder.toString(), localThrowable2);
          }
        }
      }
      if (paramLayoutAttrSet.hasAttr("text_size"))
      {
        int i = paramLayoutAttrSet.getAttr("text_size", 15);
        this.mTextSize = i;
        setTextSize(i);
      }
      if (paramLayoutAttrSet.getAttr("text", null) != null)
      {
        paramLayoutAttrSet = paramLayoutAttrSet.getAttr("text", null);
        if (!TextUtils.isEmpty(paramLayoutAttrSet)) {
          this.mText = paramLayoutAttrSet;
        }
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if (this.showClickState)
    {
      if (this.isPressed) {
        paramMotionEvent = getPressedStateDrawable();
      } else {
        paramMotionEvent = getNormalBackgroundDrawable();
      }
      setBackgroundDrawable(paramMotionEvent);
      invalidate();
    }
    return bool;
  }
  
  public Drawable getNormalBackgroundDrawable()
  {
    return this.normalStateDrawable;
  }
  
  public int getPressBgColor()
  {
    return this.pressBgColor;
  }
  
  public String getText()
  {
    CharSequence localCharSequence = this.mText;
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return "";
  }
  
  public boolean getTextBold(boolean paramBoolean)
  {
    return this.mTextPaint.isFakeBoldText();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = this.height;
    int j = getPaddingTop();
    int k = getPaddingBottom();
    int m = this.width;
    int n = getPaddingLeft();
    int i1 = getPaddingRight();
    Paint.FontMetrics localFontMetrics = this.mTextPaint.getFontMetrics();
    float f2 = localFontMetrics.bottom;
    float f3 = localFontMetrics.top;
    float f1 = i - j - k;
    f2 = (f1 - (f2 - f3)) / 2.0F;
    f3 = localFontMetrics.bottom;
    paramCanvas.drawText(this.mText.toString(), (m - n - i1) / 2, f1 - f2 - f3, this.mTextPaint);
    super.onDraw(paramCanvas);
  }
  
  public void onLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.pressBgColor != 0) {
      getPressedDrawable().setBounds(new Rect(0, 0, this.width, this.height));
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    getPaddingLeft();
    getPaddingRight();
    int i;
    if (k != 1073741824)
    {
      i = (int)Layout.getDesiredWidth(this.mText, this.mTextPaint);
      if (k == -2147483648) {
        paramInt1 = Math.min(paramInt1, i);
      } else {
        paramInt1 = i;
      }
    }
    if (j != 1073741824)
    {
      Paint.FontMetricsInt localFontMetricsInt = this.mTextPaint.getFontMetricsInt();
      i = localFontMetricsInt.bottom - localFontMetricsInt.top;
      if (j == -2147483648) {
        paramInt2 = Math.min(paramInt2, i);
      } else {
        paramInt2 = i;
      }
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setBorderColor(int paramInt)
  {
    getPressedDrawable().setStroke(this.borderWidth, paramInt);
    super.setBorderColor(paramInt);
  }
  
  public void setBorderRadius(int paramInt)
  {
    getPressedDrawable().setCornerRadius(paramInt);
    super.setBorderRadius(paramInt);
  }
  
  public void setBorderWidth(int paramInt)
  {
    getPressedDrawable().setStroke(paramInt, this.borderColor);
    super.setBorderWidth(paramInt);
  }
  
  public void setLayoutAttr(LayoutAttrSet paramLayoutAttrSet)
  {
    super.setLayoutAttr(paramLayoutAttrSet);
    setAttr(paramLayoutAttrSet);
  }
  
  public void setNormalBackgroundDrawable(Drawable paramDrawable)
  {
    this.normalStateDrawable = paramDrawable;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setPressBgColor(int paramInt)
  {
    this.pressBgColor = paramInt;
    if (paramInt == -1)
    {
      this.pressedDrawable = null;
      this.showClickState = false;
      return;
    }
    getPressedDrawable().setColor(paramInt);
  }
  
  public void setPressedDrawable(Drawable paramDrawable)
  {
    this.pressedStateDrawable = paramDrawable;
    boolean bool;
    if (paramDrawable != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.showClickState = bool;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    this.mText = ((CharSequence)localObject);
    requestLayout();
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.mTextPaint.setFakeBoldText(paramBoolean);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = paramInt;
    this.mTextPaint.setColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    setTextSize(2, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, getContext().getResources().getDisplayMetrics());
    if (this.mTextPaint.getTextSize() == paramFloat) {
      return;
    }
    this.mTextPaint.setTextSize(paramFloat);
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ditto.widget.DittoButtonArea
 * JD-Core Version:    0.7.0.1
 */