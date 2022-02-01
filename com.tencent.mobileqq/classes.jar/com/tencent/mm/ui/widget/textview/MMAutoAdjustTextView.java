package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.luggage.wxa.standalone_open_runtime_sdk.R.styleable;
import com.tencent.mm.ui.g;

public class MMAutoAdjustTextView
  extends TextView
{
  private Paint a;
  private float b;
  private float c;
  
  public MMAutoAdjustTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MMAutoAdjustTextView));
    a();
  }
  
  public MMAutoAdjustTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MMAutoAdjustTextView));
    a();
  }
  
  private void a()
  {
    this.b = getTextSize();
    this.c = g.b(getContext());
    this.a = new Paint();
    this.a.set(getPaint());
  }
  
  private void a(TypedArray paramTypedArray)
  {
    if (paramTypedArray != null) {
      paramTypedArray.recycle();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    for (int i = getMeasuredWidth(); i > paramInt; i = getMeasuredWidth())
    {
      this.b -= g.a(getContext());
      setTextSize(0, this.b * this.c);
      measure(0, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(getText().toString(), paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(paramCharSequence.toString(), getWidth());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.MMAutoAdjustTextView
 * JD-Core Version:    0.7.0.1
 */