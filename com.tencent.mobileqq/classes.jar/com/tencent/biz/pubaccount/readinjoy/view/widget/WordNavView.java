package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordNavView
  extends View
{
  private float jdField_a_of_type_Float = ViewUtils.b(15.0F);
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private WordNavView.OnTouchingWordChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView$OnTouchingWordChangedListener;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<Float, String> jdField_a_of_type_JavaUtilMap;
  private float b;
  
  public WordNavView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private float a(int paramInt)
  {
    return getPaddingLeft() + getWidth() / 2 - this.jdField_a_of_type_AndroidTextTextPaint.measureText((String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)) / 2.0F;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setFlags(1);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(Color.parseColor("#878B99"));
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.b = Math.abs(this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics().top);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new WordNavView.MySimpleGestureDetector(this, null));
  }
  
  private float b(int paramInt)
  {
    return getPaddingTop() + getHeight() / this.jdField_a_of_type_JavaUtilArrayList.size() * (paramInt + 1) - this.b / 2.0F;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      float f = b(i);
      paramCanvas.drawText((String)this.jdField_a_of_type_JavaUtilArrayList.get(i), a(i), f, this.jdField_a_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_JavaUtilMap.put(Float.valueOf(f), this.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setIndexList(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    getLayoutParams().height = (this.jdField_a_of_type_JavaUtilArrayList.size() * (int)(this.jdField_a_of_type_Float + ViewUtils.b(5.0F)));
    requestLayout();
    invalidate();
  }
  
  public void setOnTouchingWordChangedListener(WordNavView.OnTouchingWordChangedListener paramOnTouchingWordChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetWordNavView$OnTouchingWordChangedListener = paramOnTouchingWordChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.WordNavView
 * JD-Core Version:    0.7.0.1
 */