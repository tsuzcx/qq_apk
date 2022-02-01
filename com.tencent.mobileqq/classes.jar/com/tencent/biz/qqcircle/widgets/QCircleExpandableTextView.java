package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import vuw;
import vvz;
import vwc;

public class QCircleExpandableTextView
  extends LinearLayout
{
  int jdField_a_of_type_Int = 0;
  public TextView a;
  public QCircleAsyncTextView a;
  public String a;
  public vwc a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d = 0;
  public int e = 0;
  public int f = -16777216;
  
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
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  private int a(TextView paramTextView, int paramInt)
  {
    return paramTextView.getLayout().getLineTop(paramInt) + paramTextView.getCompoundPaddingBottom() + paramTextView.getCompoundPaddingTop();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(1);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExpandableTextViewAttr);
    this.jdField_a_of_type_Int = paramContext.getInteger(2, 3);
    this.jdField_b_of_type_Int = paramContext.getInteger(0, 250);
    this.jdField_a_of_type_JavaLangString = paramContext.getString(1);
    this.jdField_b_of_type_JavaLangString = paramContext.getString(3);
    paramContext.recycle();
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() < 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getChildAt(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new vvz(this));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((getVisibility() == 8) || (!this.jdField_a_of_type_Boolean)) {
      super.onMeasure(paramInt1, paramInt2);
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setMaxLines(2147483647);
      super.onMeasure(paramInt1, paramInt2);
    } while (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getLineCount() <= this.jdField_a_of_type_Int);
    this.jdField_c_of_type_Int = a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.getLineCount());
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setMaxLines(this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Vwc != null) && (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 8)) {
      this.jdField_a_of_type_Vwc.a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.post(new QCircleExpandableTextView.2(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.post(new QCircleExpandableTextView.3(this));
  }
  
  public void setClickAreaTextColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setListener(vwc paramvwc)
  {
    this.jdField_a_of_type_Vwc = paramvwc;
  }
  
  public void setText(String paramString, vuw paramvuw)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setClickAreaTextColor(this.f);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(paramString, paramvuw);
  }
  
  public void setText(String paramString, boolean paramBoolean, vuw paramvuw)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label74;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      clearAnimation();
      setText(paramString, paramvuw);
      getLayoutParams().height = -2;
      if (this.jdField_a_of_type_Vwc != null) {
        this.jdField_a_of_type_Vwc.b(paramBoolean);
      }
      return;
      bool = false;
      break;
      label74:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView
 * JD-Core Version:    0.7.0.1
 */