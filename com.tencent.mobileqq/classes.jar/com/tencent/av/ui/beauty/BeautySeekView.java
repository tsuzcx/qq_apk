package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
    Object localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      return;
    }
    this.d = ((SeekBar)localObject).getMeasuredWidth();
    int i = this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft();
    int j = this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingRight();
    int k = this.jdField_a_of_type_AndroidWidgetSeekBar.getLeft();
    int m = k + i + (int)(this.c / 100.0F * (this.d - i - j));
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).leftMargin = m;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.i("BeautySeekView", 4, String.format("updateMarker, pl: %s, pr: %s, w: %s, ml: %s, m: %s, left: %s, flag: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.d), Integer.valueOf(k), Integer.valueOf(this.c), Integer.valueOf(m), Boolean.valueOf(this.jdField_b_of_type_Boolean) }));
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramContext = inflate(paramContext, 2131559747, this);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131373594);
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842011);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)paramContext.findViewById(2131373526));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131373525));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131373527));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842019);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    paramContext = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (paramContext != null)
    {
      paramContext.setMax(100);
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
      this.jdField_a_of_type_AndroidWidgetSeekBar.getViewTreeObserver().addOnGlobalLayoutListener(new BeautySeekView.1(this));
    }
    this.jdField_b_of_type_Int = AIOUtils.b(24.0F, getResources());
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
    Object localObject;
    if (this.c == 50)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt - 50);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("%");
      localObject = ((StringBuilder)localObject).toString();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i = this.jdField_b_of_type_AndroidWidgetTextView.getWidth();
    int j = this.jdField_a_of_type_AndroidWidgetSeekBar.getWidth() - this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingRight();
    int k = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetSeekBar.getLayoutParams()).leftMargin + this.jdField_a_of_type_AndroidWidgetSeekBar.getPaddingLeft();
    float f = paramInt * 1.0F / Math.abs(this.jdField_a_of_type_AndroidWidgetSeekBar.getMax());
    int m = (int)(j * f + (0.5F - f) * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() - i / 2.0F);
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).leftMargin = (m + k);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTip, progress[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("], seekBarLeft[");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("], tipWidth[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], thumbWidth[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("], seekWidth[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("]");
      QLog.w("BeautySeekView", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_b_of_type_AndroidWidgetTextView.requestLayout();
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetSeekBar == null) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      int i;
      if (paramInt > this.c) {
        i = 2130842012;
      } else {
        i = 2130842011;
      }
      localView.setBackgroundResource(i);
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842015);
    } else if (paramInt <= 30) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842017);
    } else if (paramInt <= 60) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842018);
    } else {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130842016);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setThumb(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  public void a(int paramInt)
  {
    SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localSeekBar != null) {
      localSeekBar.setProgress(paramInt);
    }
    c(paramInt);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    paramString2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramString2 != null) {
      paramString2.setText(paramString1);
    }
    if (this.c != paramInt2)
    {
      this.c = paramInt2;
      this.jdField_b_of_type_Boolean = true;
      a();
    }
    a(paramInt1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_b_of_type_Boolean)
    {
      SeekBar localSeekBar = this.jdField_a_of_type_AndroidWidgetSeekBar;
      if ((localSeekBar != null) && (localSeekBar.getMeasuredWidth() != this.d))
      {
        this.jdField_b_of_type_Boolean = false;
        a();
      }
    }
  }
  
  public void setBeautySeekActionListener(BeautySeekView.ActionListener paramActionListener)
  {
    this.jdField_a_of_type_ComTencentAvUiBeautyBeautySeekView$ActionListener = paramActionListener;
  }
  
  public void setMarginRight(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)((SeekBar)localObject).getLayoutParams();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMarginRight pre[");
        localStringBuilder.append(((ViewGroup.MarginLayoutParams)localObject).leftMargin);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.i("BeautySeekView", 4, localStringBuilder.toString());
      }
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = paramInt;
      this.jdField_a_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.beauty.BeautySeekView
 * JD-Core Version:    0.7.0.1
 */