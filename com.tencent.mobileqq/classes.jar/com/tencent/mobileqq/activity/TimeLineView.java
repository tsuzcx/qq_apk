package com.tencent.mobileqq.activity;

import actj;
import ajya;
import akaw;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.BitSet;
import java.util.Calendar;

public class TimeLineView
  extends FrameLayout
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AutoFitScrollView jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView;
  private BitSet jdField_a_of_type_JavaUtilBitSet;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private int jdField_b_of_type_Int;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  
  public TimeLineView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TimeLineView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public int a()
  {
    return actj.b(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public BitSet a()
  {
    return this.jdField_a_of_type_JavaUtilBitSet;
  }
  
  public Calendar a()
  {
    return (Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone();
  }
  
  void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Int = paramContext.getResources().getDisplayMetrics().widthPixels;
    paramContext = Calendar.getInstance();
    this.jdField_b_of_type_JavaUtilCalendar = paramContext;
    this.jdField_a_of_type_JavaUtilCalendar = paramContext;
    this.jdField_a_of_type_JavaUtilBitSet = new BitSet();
  }
  
  public void a(AutoFitScrollView paramAutoFitScrollView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView = paramAutoFitScrollView;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int k = actj.b(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int m = actj.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int n = actj.b(15.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i1 = actj.b(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int j = (this.jdField_b_of_type_Int >> 1) - (m >> 1);
    Paint localPaint1 = new Paint();
    Paint localPaint2 = new Paint();
    localPaint2.setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density * 12.0F);
    localPaint2.setColor(-8355712);
    localPaint2.setDither(true);
    Calendar localCalendar = (Calendar)this.jdField_a_of_type_JavaUtilCalendar.clone();
    int i = 0;
    if (!this.jdField_a_of_type_JavaUtilBitSet.get(0)) {
      return;
    }
    label151:
    int i2;
    int i3;
    Rect localRect;
    String str;
    if ((localCalendar.before(this.jdField_b_of_type_JavaUtilCalendar)) || (localCalendar.equals(this.jdField_b_of_type_JavaUtilCalendar)))
    {
      i2 = localCalendar.get(2) + 1;
      i3 = localCalendar.get(5);
      localRect = new Rect();
      if ((1 != i3) && (i3 != 15)) {
        break label419;
      }
      localRect.left = j;
      localRect.top = (getHeight() - n);
      localRect.right = (localRect.left + m);
      localRect.bottom = getHeight();
      if (i3 != 1) {
        break label389;
      }
      str = i2 + ajya.a(2131714965);
      label287:
      float f = localPaint2.measureText(str);
      i2 = actj.b(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramCanvas.drawText(str, m / 2 + j - f / 2.0F, (getHeight() >> 1) - i2, localPaint2);
      label339:
      j += k + m;
      if (!this.jdField_a_of_type_JavaUtilBitSet.get(i)) {
        break label463;
      }
      localPaint1.setColor(-15158035);
    }
    for (;;)
    {
      paramCanvas.drawRect(localRect, localPaint1);
      localCalendar.add(5, 1);
      i += 1;
      break label151;
      break;
      label389:
      str = i2 + "-" + i3;
      break label287;
      label419:
      localRect.left = j;
      localRect.top = (getHeight() - i1);
      localRect.right = (localRect.left + m);
      localRect.bottom = getHeight();
      break label339;
      label463:
      localPaint1.setColor(-3355444);
    }
  }
  
  public void setDate(QQAppInterface paramQQAppInterface, Calendar paramCalendar1, Calendar paramCalendar2, boolean paramBoolean)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeLineView", 2, "setDate date is null");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilCalendar = ((Calendar)paramCalendar1.clone());
    this.jdField_b_of_type_JavaUtilCalendar = ((Calendar)paramCalendar2.clone());
    StringBuilder localStringBuilder = new StringBuilder("setDate date: ");
    if (QLog.isColorLevel())
    {
      int i = this.jdField_a_of_type_JavaUtilCalendar.get(1);
      int j = this.jdField_a_of_type_JavaUtilCalendar.get(2);
      int k = this.jdField_a_of_type_JavaUtilCalendar.get(5);
      localStringBuilder.append(i).append("-").append(j + 1).append("-").append(k).append(" ~ ");
      i = this.jdField_b_of_type_JavaUtilCalendar.get(1);
      j = this.jdField_b_of_type_JavaUtilCalendar.get(2);
      k = this.jdField_b_of_type_JavaUtilCalendar.get(5);
      localStringBuilder.append(i).append("-").append(j + 1).append("-").append(k);
      localStringBuilder.append(", isLoc: ").append(paramBoolean);
    }
    paramQQAppInterface = (akaw)paramQQAppInterface.getManager(92);
    if (!paramBoolean) {}
    for (this.jdField_a_of_type_JavaUtilBitSet = paramQQAppInterface.c(this.jdField_a_of_type_JavaUtilCalendar, this.jdField_b_of_type_JavaUtilCalendar);; this.jdField_a_of_type_JavaUtilBitSet = paramQQAppInterface.a(paramCalendar1, paramCalendar2))
    {
      long l = paramCalendar1.getTimeInMillis();
      this.jdField_a_of_type_Int = ((int)((paramCalendar2.getTimeInMillis() - l) / 86400000L));
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.setFitWidth(this.jdField_a_of_type_Int * a() + this.jdField_b_of_type_Int, a());
      this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.b();
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", mDataSize: ").append(this.jdField_a_of_type_Int).append(", max scrollView Width: ").append(this.jdField_a_of_type_ComTencentMobileqqActivityAutoFitScrollView.jdField_a_of_type_Int).append(", item width: ").append(a());
        localStringBuilder.append(",displayWidth: ").append(this.jdField_b_of_type_Int);
        QLog.d("TimeLineView", 2, localStringBuilder.toString());
      }
      requestLayout();
      invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TimeLineView
 * JD-Core Version:    0.7.0.1
 */