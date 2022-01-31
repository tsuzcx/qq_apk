package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import uag;
import ucc;
import ucd;

public class QCircleAsyncTextView
  extends AsyncRichTextView
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  
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
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, ucd paramucd)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt2 < paramInt1) || (paramSpannableStringBuilder.length() < paramInt2)) {
      return;
    }
    paramucd = new ucc(this, paramucd);
    setHighlightColor(getResources().getColor(2131167140));
    paramSpannableStringBuilder.setSpan(paramucd, paramInt1, paramInt2, 33);
  }
  
  public void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt, Drawable paramDrawable)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramInt < 0) || (paramInt > paramSpannableStringBuilder.length()) || (paramDrawable == null)) {
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
  
  public MovementMethod getDefaultMovementMethod()
  {
    return uag.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = false;
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    while ((paramMotionEvent.getAction() != 1) || (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 500L)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public boolean performClick()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView
 * JD-Core Version:    0.7.0.1
 */