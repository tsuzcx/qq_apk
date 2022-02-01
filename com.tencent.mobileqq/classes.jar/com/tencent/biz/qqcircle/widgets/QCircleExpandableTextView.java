package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.biz.qcircle.R.styleable;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickAtTextListener;
import com.tencent.richframework.text.rich.RFWAsyncRichTextView.OnClickHashTagTextListener;
import java.util.List;

public class QCircleExpandableTextView
  extends LinearLayout
{
  QCircleAsyncTextView a;
  TextView b;
  int c = 0;
  int d = 0;
  String e;
  String f;
  boolean g = false;
  int h = 0;
  boolean i = true;
  int j = 0;
  int k = 0;
  boolean l = false;
  QCircleExpandableTextView.OnExpandStateChangeListener m;
  
  public QCircleExpandableTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleExpandableTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return 0;
    }
    int n;
    if (paramTextView.getLayout() == null) {
      n = paramTextView.getCompoundPaddingBottom();
    }
    for (paramInt = paramTextView.getCompoundPaddingTop();; paramInt = paramTextView.getCompoundPaddingTop())
    {
      return n + paramInt;
      n = paramTextView.getLayout().getLineTop(paramInt) + paramTextView.getCompoundPaddingBottom();
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(1);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.az);
    this.c = paramContext.getInteger(R.styleable.aC, 3);
    this.d = paramContext.getInteger(R.styleable.aA, 250);
    this.e = paramContext.getString(R.styleable.aB);
    this.f = paramContext.getString(R.styleable.aD);
    paramContext.recycle();
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public TextView getExpandTextView()
  {
    return this.b;
  }
  
  public List<String> getHashTagList()
  {
    return this.a.getHashTagList();
  }
  
  public TextView getSourceTextView()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() < 2) {
      return;
    }
    this.a = ((QCircleAsyncTextView)getChildAt(0));
    this.b = ((TextView)getChildAt(1));
    this.b.setText(this.f);
    this.b.setOnClickListener(new QCircleExpandableTextView.1(this));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.l;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getVisibility() != 8) && (this.g))
    {
      this.g = false;
      this.b.setVisibility(8);
      this.a.setMaxLines(2147483647);
      if (this.a.getLineCount() <= this.c)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      QCircleAsyncTextView localQCircleAsyncTextView = this.a;
      this.h = a(localQCircleAsyncTextView, localQCircleAsyncTextView.getLineCount());
      if (this.i) {
        this.a.setMaxLines(this.c);
      }
      if ((this.m != null) && (this.b.getVisibility() == 8)) {
        this.m.a();
      }
      this.b.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
      if (this.i)
      {
        this.a.post(new QCircleExpandableTextView.2(this));
        return;
      }
      this.a.post(new QCircleExpandableTextView.3(this));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setClickAreaTextColor(int paramInt)
  {
    this.a.setClickAreaTextColor(paramInt);
  }
  
  public void setListener(QCircleExpandableTextView.OnExpandStateChangeListener paramOnExpandStateChangeListener)
  {
    this.m = paramOnExpandStateChangeListener;
  }
  
  public void setNeedSpecialAreaBold(boolean paramBoolean)
  {
    this.a.setNeedSpecialAreaBold(paramBoolean);
  }
  
  public void setOnClickHashTagListener(RFWAsyncRichTextView.OnClickHashTagTextListener paramOnClickHashTagTextListener)
  {
    this.a.setOnClickHashTagTextListener(paramOnClickHashTagTextListener);
  }
  
  public void setSpecialAreaTextColor(int paramInt)
  {
    this.a.setSpecialClickAreaColor(paramInt);
  }
  
  public void setText(String paramString, RFWAsyncRichTextView.OnClickAtTextListener paramOnClickAtTextListener)
  {
    this.g = true;
    this.a.setOnClickAtTextListener(paramOnClickAtTextListener);
    this.a.setText(paramString);
  }
  
  public void setText(String paramString, boolean paramBoolean, RFWAsyncRichTextView.OnClickAtTextListener paramOnClickAtTextListener)
  {
    this.i = (paramBoolean ^ true);
    if (this.i) {
      this.b.setText(this.f);
    } else {
      this.b.setText(this.e);
    }
    clearAnimation();
    setText(paramString, paramOnClickAtTextListener);
    getLayoutParams().height = -2;
    paramString = this.m;
    if (paramString != null) {
      paramString.b(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView
 * JD-Core Version:    0.7.0.1
 */