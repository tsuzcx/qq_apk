package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tyu;
import tzp;
import tzq;
import uaa;
import ydg;

public class QCircleAsyncTextView
  extends AsyncRichTextView
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private List<Integer> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private List<Integer> b;
  private List<tzq> c;
  
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
  
  private SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(" ");
    localSpannableString.setSpan(new uaa(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), 0, 1, 33);
    return localSpannableString;
  }
  
  private SpannableString a(CharSequence paramCharSequence, tzq paramtzq)
  {
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    paramtzq = new tzp(this, paramtzq);
    setHighlightColor(getResources().getColor(2131167138));
    localSpannableString.setSpan(paramtzq, 0, paramCharSequence.length(), 33);
    return localSpannableString;
  }
  
  public Spannable a(Spannable paramSpannable)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.b != null) && (this.b.size() > 0)) {
      i = 0;
    }
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if ((i == 0) && (((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue() > 0) && (paramSpannable.length() > ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue())) {
        localSpannableStringBuilder.append(paramSpannable.subSequence(0, ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue()));
      }
      if ((i > 0) && (((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue() > ((Integer)this.b.get(i - 1)).intValue()) && (paramSpannable.length() > ((Integer)this.b.get(i - 1)).intValue() + 1) && (paramSpannable.length() >= ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue())) {
        localSpannableStringBuilder.append(paramSpannable.subSequence(((Integer)this.b.get(i - 1)).intValue() + 1, ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue()));
      }
      if ((paramSpannable.length() > ((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue()) && (paramSpannable.length() > ((Integer)this.b.get(i)).intValue()) && (paramSpannable.length() >= ((Integer)this.b.get(i)).intValue() + 1)) {
        localSpannableStringBuilder.append(a(paramSpannable.subSequence(((Integer)this.jdField_a_of_type_JavaUtilList.get(i)).intValue(), ((Integer)this.b.get(i)).intValue() + 1), (tzq)this.c.get(i)));
      }
      if ((i == this.jdField_a_of_type_JavaUtilList.size() - 1) && (paramSpannable.length() > ((Integer)this.b.get(i)).intValue()) && (paramSpannable.length() > ((Integer)this.b.get(i)).intValue() + 1)) {
        localSpannableStringBuilder.append(paramSpannable.subSequence(((Integer)this.b.get(i)).intValue() + 1, paramSpannable.length()));
      }
      i += 1;
      continue;
      localSpannableStringBuilder.append(paramSpannable);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      localSpannableStringBuilder.append(a());
    }
    return localSpannableStringBuilder;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 16) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((getEllipsize() != TextUtils.TruncateAt.END) || (getLayout() == null) || (getLineCount() <= getMaxLines()) || (getMaxLines() <= 0));
      i = getLayout().getLineEnd(getMaxLines() - 1);
    } while (i <= 1);
    int k = (int)Math.ceil(getPaint().measureText("...") / getTextSize());
    int j = k;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      j = (int)(k + Math.ceil(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth() / getTextSize()));
    }
    Object localObject1 = getText().subSequence(0, i);
    k = 0;
    Object localObject2;
    if (k < j) {
      if (((CharSequence)localObject1).toString().endsWith("[/em]"))
      {
        localObject2 = ydg.g.matcher((CharSequence)localObject1);
        while (((Matcher)localObject2).find())
        {
          int m = ((Matcher)localObject2).start();
          int n = ((Matcher)localObject2).end();
          if ((m < i) && (n == i)) {
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      label196:
      if (i >= 0) {
        localObject1 = ((CharSequence)localObject1).subSequence(0, i);
      }
      for (;;)
      {
        k += 1;
        break;
        i -= 1;
        break label196;
        if ((localObject1 instanceof Spannable))
        {
          localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
          ((SpannableStringBuilder)localObject2).append("...");
          localObject1 = localObject2;
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            ((SpannableStringBuilder)localObject2).append(a());
          }
        }
        for (localObject1 = localObject2;; localObject1 = localObject1 + "...")
        {
          setText((CharSequence)localObject1, null);
          return;
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, tzq paramtzq)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.b == null) || (this.c == null))
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.b = new ArrayList();
      this.c = new ArrayList();
    }
    if ((!this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt1))) && (!this.b.contains(Integer.valueOf(paramInt2))))
    {
      this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt1));
      this.b.add(Integer.valueOf(paramInt2));
      this.c.add(paramtzq);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
    if (this.c != null) {
      this.c.clear();
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
  }
  
  public MovementMethod getDefaultMovementMethod()
  {
    return tyu.a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Boolean = false;
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.performClick();
  }
  
  public void setEndSpanIcon(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView
 * JD-Core Version:    0.7.0.1
 */