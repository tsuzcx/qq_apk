package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.text.rich.span.BoldClickableSpan.OnClickBoldTextListener;
import com.tencent.richframework.text.rich.style.NoScrollLinkMovementMethod;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import java.util.HashSet;

public class QCircleAsyncTextView
  extends RFWAsyncRichTextView
  implements QCircleSkinHelper.OnThemeUpdateListener
{
  public int a = 2131167084;
  private long d;
  private HashSet<BoldClickableSpan.OnClickBoldTextListener> e = new HashSet();
  
  public QCircleAsyncTextView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QCircleAsyncTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected BoldClickableSpan.OnClickBoldTextListener a(QCircleAsyncTextView.OnClickBoldTextListener paramOnClickBoldTextListener)
  {
    paramOnClickBoldTextListener = new QCircleAsyncTextView.1(this, paramOnClickBoldTextListener);
    this.e.add(paramOnClickBoldTextListener);
    return paramOnClickBoldTextListener;
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, QCircleAsyncTextView.OnClickBoldTextListener paramOnClickBoldTextListener)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramOnClickBoldTextListener, this.a, true);
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, QCircleAsyncTextView.OnClickBoldTextListener paramOnClickBoldTextListener, int paramInt3, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramInt2 >= paramInt1))
    {
      if (paramSpannableStringBuilder.length() < paramInt2) {
        return;
      }
      paramOnClickBoldTextListener = new BoldClickableSpan(a(paramOnClickBoldTextListener), paramInt3, paramBoolean);
      setHighlightColor(getResources().getColor(2131168376));
      paramSpannableStringBuilder.setSpan(paramOnClickBoldTextListener, paramInt1, paramInt2, 33);
    }
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable paramDrawable)
  {
    if ((!TextUtils.isEmpty(paramSpannableStringBuilder)) && (paramInt >= 0) && (paramInt <= paramSpannableStringBuilder.length()))
    {
      if (paramDrawable == null) {
        return;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpannableStringBuilder);
      paramSpannableStringBuilder.clear();
      paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(0, paramInt)).append(" ");
      if (paramInt < localSpannableStringBuilder.length()) {
        paramSpannableStringBuilder.append(localSpannableStringBuilder.subSequence(paramInt, localSpannableStringBuilder.length()));
      }
      paramSpannableStringBuilder.setSpan(new VerticalCenterImageSpan(paramDrawable), paramInt, paramInt + 1, 33);
    }
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return NoScrollLinkMovementMethod.a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
  }
  
  public void onThemeUpdate()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getText());
    int j = getText().length();
    int i = 0;
    BoldClickableSpan[] arrayOfBoldClickableSpan = (BoldClickableSpan[])localSpannableStringBuilder.getSpans(0, j, BoldClickableSpan.class);
    j = arrayOfBoldClickableSpan.length;
    while (i < j)
    {
      BoldClickableSpan localBoldClickableSpan = arrayOfBoldClickableSpan[i];
      localSpannableStringBuilder.setSpan(localBoldClickableSpan, localSpannableStringBuilder.getSpanStart(localBoldClickableSpan), localSpannableStringBuilder.getSpanEnd(localBoldClickableSpan), 33);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    setIsSpanClick(false);
    if (paramMotionEvent.getAction() == 0) {
      this.d = System.currentTimeMillis();
    } else if ((paramMotionEvent.getAction() == 1) && (System.currentTimeMillis() - this.d > 500L)) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (b()) {
      return true;
    }
    return super.performClick();
  }
  
  public void setClickAreaTextColor(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView
 * JD-Core Version:    0.7.0.1
 */