package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class BeautySeekView
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 0;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView = null;
  SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new BeautySeekView.3(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private BeautySeekView.ActionListener jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView$ActionListener = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new BeautySeekView.2(this);
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  private int d = 0;
  
  public BeautySeekView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BeautySeekView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return;
      this.d = this.jdField_a_of_type_AndroidWidgetSeekBar.getMeasuredWidth();
      i = this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft();
      j = this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingRight();
      k = this.jdField_a_of_type_AndroidWidgetSeekBar.getLeft();
      m = (int)(this.c / 100.0F * (this.d - i - j)) + (k + i);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localMarginLayoutParams.leftMargin = m;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localMarginLayoutParams);
    } while (!QLog.isDevelopLevel());
    QLog.i("BeautySeekView", 4, String.format("updateMarker, pl: %s, pr: %s, w: %s, ml: %s, m: %s, left: %s, flag: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.d), Integer.valueOf(k), Integer.valueOf(this.c), Integer.valueOf(m), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramContext = inflate(paramContext, 2131559871, this);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131374037);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842114);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2131373954));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131373953));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131373955));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842122);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
      this.jdField_a_of_type_AndroidWidgetSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new BeautySeekView.1(this));
    }
    this.jdField_b_of_type_Int = AIOUtils.a(24.0F, getResources());
    if ((AudioHelper.a(0) == 1) && (this.jdField_a_of_type_AndroidWidgetSeekBar != null))
    {
      setBackgroundColor(-270080262);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setBackgroundColor(-536871168);
      setBackgroundColor(536870656);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    if (this.c == 50) {}
    for (String str = paramInt - 50 + "%";; str = paramInt + "%")
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      int i = this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
      int j = this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth() - this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingRight();
      int k = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetSeekBar.getLayoutParams()).leftMargin;
      k = this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft() + k;
      float f1 = paramInt * 1.0F / Math.abs(this.jdField_a_of_type_AndroidWidgetSeekBar.getMax());
      float f2 = j;
      int m = (int)((0.5F - f1) * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + f2 * f1 - i / 2.0F);
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = (k + m);
      if (QLog.isColorLevel()) {
        QLog.w("BeautySeekView", 2, "updateTip, progress[" + paramInt + "], seekBarLeft[" + k + "], tipWidth[" + i + "], thumbWidth[" + this.jdField_b_of_type_Int + "], seekWidth[" + j + "]");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
      return;
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (paramInt > this.c)
      {
        i = 2130842115;
        localView.setBackgroundResource(i);
      }
    }
    else
    {
      if (paramInt != 0) {
        break label73;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842118);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
      i = 2130842114;
      break;
      label73:
      if (paramInt <= 30) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842120);
      } else if (paramInt <= 60) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842121);
      } else {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842119);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    }
    c(paramInt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (this.c != paramInt2)
    {
      this.c = paramInt2;
      this.jdField_b_of_type_Boolean = true;
      a();
    }
    a(paramInt1);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetSeekBar != null) && (this.jdField_a_of_type_AndroidWidgetSeekBar.getMeasuredWidth() != this.d))
    {
      this.jdField_b_of_type_Boolean = false;
      a();
    }
  }
  
  public void setBeautySeekActionListener(BeautySeekView.ActionListener paramActionListener)
  {
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView$ActionListener = paramActionListener;
  }
  
  public void setMarginRight(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidWidgetSeekBar.getLayoutParams();
      if (QLog.isDevelopLevel()) {
        QLog.i("BeautySeekView", 4, "setMarginRight pre[" + localMarginLayoutParams.leftMargin + "], cur[" + paramInt + "]");
      }
      localMarginLayoutParams.rightMargin = paramInt;
      this.jdField_a_of_type_AndroidWidgetSeekBar.setLayoutParams(localMarginLayoutParams);
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView
 * JD-Core Version:    0.7.0.1
 */