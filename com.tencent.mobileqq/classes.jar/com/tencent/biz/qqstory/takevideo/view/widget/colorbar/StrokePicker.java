package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.strategy.StrokeStrategy;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.Stroke;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrokePicker
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private StrokePicker.OnStrokeDrawableSelectedListener jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker$OnStrokeDrawableSelectedListener;
  private StrokeStrategy jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrategyStrokeStrategy;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int[] jdField_a_of_type_ArrayOfInt;
  
  public StrokePicker(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StrokePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    setOrientation(1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Stroke a(float paramFloat)
  {
    if ((paramFloat < 0.0F) || (this.jdField_a_of_type_ArrayOfInt == null))
    {
      SLog.e("StrokePicker", "y pos is illegal : " + paramFloat);
      return null;
    }
    if (this.jdField_a_of_type_ArrayOfInt == null)
    {
      SLog.e("StrokePicker", "mStrokeYPos is null, exist time sequence error");
      return null;
    }
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (paramFloat <= this.jdField_a_of_type_ArrayOfInt[i]) {
        return (Stroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      }
      i += 1;
    }
    SLog.e("StrokePicker", "can not find Stroke with y :  " + paramFloat);
    return null;
  }
  
  public List a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(@NonNull StrokeStrategy paramStrokeStrategy)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrategyStrokeStrategy = paramStrokeStrategy;
    removeAllViews();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Int = 0;
    paramStrokeStrategy.a(this.jdField_a_of_type_JavaUtilArrayList, getContext());
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      Log.w("StrokePicker", "initStrokes : no stroke will be show.");
      return;
    }
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilArrayList.size()];
    int i = 0;
    label78:
    Object localObject1;
    Object localObject2;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramStrokeStrategy = (Stroke)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      localObject1 = new ImageView(getContext());
      localObject2 = new LinearLayout.LayoutParams(paramStrokeStrategy.jdField_a_of_type_Int, paramStrokeStrategy.b);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      ((LinearLayout.LayoutParams)localObject2).topMargin = paramStrokeStrategy.f;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setPadding(0, paramStrokeStrategy.c, 0, paramStrokeStrategy.d);
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      localObject2 = paramStrokeStrategy.a();
      if (localObject2 != null) {
        break label263;
      }
      Log.w("StrokePicker", "ThumbDrawable is null.");
      label195:
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      addView((View)localObject1);
      if (i != 0) {
        break label273;
      }
      paramStrokeStrategy.e = 0;
      this.jdField_a_of_type_ArrayOfInt[i] = paramStrokeStrategy.b;
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Int;
      int k = paramStrokeStrategy.f;
      this.jdField_a_of_type_Int = (paramStrokeStrategy.b + k + j);
      i += 1;
      break label78;
      break;
      label263:
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      break label195;
      label273:
      paramStrokeStrategy.e = (this.jdField_a_of_type_ArrayOfInt[(i - 1)] + paramStrokeStrategy.f);
      localObject1 = this.jdField_a_of_type_ArrayOfInt;
      localObject1[i] += this.jdField_a_of_type_ArrayOfInt[(i - 1)] + paramStrokeStrategy.f + paramStrokeStrategy.b;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    float f2 = paramMotionEvent.getY();
    if (f2 < 0.0F) {}
    for (;;)
    {
      f2 = f1;
      if (f1 > getHeight()) {
        f2 = getHeight();
      }
      Stroke localStroke = a(f2);
      if (localStroke != null)
      {
        Drawable localDrawable1 = localStroke.a(paramMotionEvent.getX(), f2 - localStroke.e);
        Drawable localDrawable2 = localStroke.b(paramMotionEvent.getX(), f2 - localStroke.e);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker$OnStrokeDrawableSelectedListener != null) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker$OnStrokeDrawableSelectedListener.a(paramMotionEvent, localDrawable1, localDrawable2, localStroke);
        }
      }
      return true;
      f1 = f2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.jdField_a_of_type_Int, 1073741824));
  }
  
  public void setOnStrokeSelectedListener(StrokePicker.OnStrokeDrawableSelectedListener paramOnStrokeDrawableSelectedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarStrokePicker$OnStrokeDrawableSelectedListener = paramOnStrokeDrawableSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.StrokePicker
 * JD-Core Version:    0.7.0.1
 */