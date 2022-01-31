package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.R.styleable;
import uct;
import ucw;

public class QCircleExpandableTextView
  extends LinearLayout
{
  int jdField_a_of_type_Int = 0;
  public TextView a;
  public AsyncRichTextView a;
  public String a;
  public ucw a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d = 0;
  public int e = 0;
  
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
  
  private int a(TextView paramTextView)
  {
    return paramTextView.getLayout().getLineTop(paramTextView.getLineCount()) + paramTextView.getCompoundPaddingBottom() + paramTextView.getCompoundPaddingTop();
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
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (getChildCount() < 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)getChildAt(0));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)getChildAt(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new uct(this));
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
      do
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(2147483647);
        super.onMeasure(paramInt1, paramInt2);
      } while (this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.getLineCount() <= this.jdField_a_of_type_Int);
      this.jdField_c_of_type_Int = a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView);
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setMaxLines(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      super.onMeasure(paramInt1, paramInt2);
    } while (!this.jdField_b_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.post(new QCircleExpandableTextView.2(this));
  }
  
  public void setListener(ucw paramucw)
  {
    this.jdField_a_of_type_Ucw = paramucw;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(paramString);
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (!this.jdField_b_of_type_Boolean) {
        break label70;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      clearAnimation();
      setText(paramString);
      getLayoutParams().height = -2;
      if (this.jdField_a_of_type_Ucw != null) {
        this.jdField_a_of_type_Ucw.a(paramBoolean);
      }
      return;
      bool = false;
      break;
      label70:
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView
 * JD-Core Version:    0.7.0.1
 */