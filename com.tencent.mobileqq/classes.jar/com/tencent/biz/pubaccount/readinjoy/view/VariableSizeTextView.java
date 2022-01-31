package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import mjt;

public class VariableSizeTextView
  extends RelativeLayout
{
  public static final String a;
  protected float a;
  ViewConfiguration jdField_a_of_type_AndroidViewViewConfiguration = ViewConfiguration.get(getContext());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VariableSizeTextView.OnSizeChangedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener;
  protected boolean a;
  public float b;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  float d;
  float e;
  float f;
  private float g;
  private float h;
  private float i = 0.0F;
  private float j = 0.0F;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.readinjoy.atlas." + VariableSizeTextView.class.getSimpleName();
  }
  
  public VariableSizeTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public VariableSizeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VariableSizeTextView);
    this.jdField_a_of_type_Float = paramContext.getDimensionPixelSize(0, 0);
    paramContext.recycle();
    setClickable(true);
    setFocusable(true);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    paramContext.addRule(9);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramContext);
  }
  
  public int a(int paramInt)
  {
    int m = 1;
    int k = paramInt;
    paramInt = m;
    while (k / 10 != 0)
    {
      k /= 10;
      paramInt += 1;
    }
    return paramInt;
  }
  
  public void a()
  {
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (this.jdField_b_of_type_Float == 0.0F) {}
    for (localLayoutParams.height = ((int)(this.jdField_a_of_type_Float + 0.5F));; localLayoutParams.height = Math.min((int)(this.jdField_a_of_type_Float + 0.5F), (int)(this.jdField_b_of_type_Float + 0.5F)))
    {
      setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void b()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.i = this.jdField_a_of_type_AndroidWidgetTextView.getLineSpacingMultiplier();
      this.j = this.jdField_a_of_type_AndroidWidgetTextView.getLineSpacingExtra();
    }
    while ((this.i != 0.0F) || (this.j != 0.0F)) {
      return;
    }
    try
    {
      Field localField = TextView.class.getDeclaredField("mSpacingMult");
      localField.setAccessible(true);
      this.i = localField.getFloat(this);
      localField = TextView.class.getDeclaredField("mSpacingAdd");
      localField.setAccessible(true);
      this.j = localField.getFloat(this);
      return;
    }
    catch (Exception localException)
    {
      this.i = 1.0F;
      this.j = 3.0F;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b();
    paramCanvas = new StaticLayout(this.jdField_a_of_type_AndroidWidgetTextView.getText(), this.jdField_a_of_type_AndroidWidgetTextView.getPaint(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.i, this.j, true);
    float f1 = paramCanvas.getHeight() + getPaddingTop() + getPaddingBottom();
    int k = paramCanvas.getLineCount();
    if (f1 != this.jdField_b_of_type_Float)
    {
      this.jdField_b_of_type_Float = f1;
      a();
    }
    if (k > 5)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  action=" + k);
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (k == 0)
    {
      this.g = paramMotionEvent.getRawX();
      this.h = paramMotionEvent.getRawY();
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      this.d = this.jdField_c_of_type_Float;
      this.f = localLayoutParams.height;
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    float f1;
    int m;
    label472:
    do
    {
      do
      {
        do
        {
          return true;
          if (k != 1) {
            break;
          }
          this.d = paramMotionEvent.getRawY();
          k = localLayoutParams.height;
          if ((k != this.jdField_b_of_type_Float) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener != null)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener.a();
          }
        } while (k <= this.jdField_b_of_type_Float);
        paramMotionEvent = ValueAnimator.ofFloat(new float[] { k, this.jdField_b_of_type_Float });
        paramMotionEvent.setDuration(300L);
        paramMotionEvent.setInterpolator(new DecelerateInterpolator());
        paramMotionEvent.addUpdateListener(new mjt(this, localLayoutParams));
        setFocusable(false);
        setClickable(false);
        paramMotionEvent.start();
        return true;
      } while (k != 2);
      f1 = paramMotionEvent.getRawX() - this.g;
      float f2 = paramMotionEvent.getRawY() - this.h;
      if ((Math.max(Math.abs(f1), Math.abs(f2)) > this.jdField_a_of_type_AndroidViewViewConfiguration.getScaledTouchSlop()) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean) && ((f1 != 0.0F) || (f2 != 0.0F)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onTouchEvent()  action=" + k + " distanceX=" + f1 + " distanceY=" + f2);
        }
        if (Math.abs(f1) >= Math.abs(f2)) {
          this.jdField_c_of_type_Boolean = true;
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.e = this.d;
        this.d = paramMotionEvent.getRawY();
        f1 = this.e - this.d;
        m = localLayoutParams.height;
        k = (int)(m + f1);
        if (k <= this.jdField_b_of_type_Float) {
          continue;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label543;
        }
        if (f1 >= 0.0F) {
          break label537;
        }
        k = -1;
      }
      for (k = (int)(m + k * Math.pow(Math.abs(f1), 0.7D));; k = (int)(this.jdField_b_of_type_Float + 0.5F))
      {
        localLayoutParams.height = k;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener.a(m, k);
        }
        setLayoutParams(localLayoutParams);
        return true;
        this.jdField_b_of_type_Boolean = true;
        break;
        k = 1;
        break label472;
      }
    } while (((m >= this.jdField_a_of_type_Float) || (f1 <= 0.0F)) && (k < this.jdField_a_of_type_Float));
    label537:
    label543:
    localLayoutParams.height = k;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener.a(m, k);
    }
    setLayoutParams(localLayoutParams);
    return true;
    getParent().requestDisallowInterceptTouchEvent(false);
    return true;
  }
  
  public void setOnSizeChangedListener(VariableSizeTextView.OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView$OnSizeChangedListener = paramOnSizeChangedListener;
  }
  
  public void setPage(int paramInt1, int paramInt2)
  {
    Object localObject = paramInt1 + 1 + "/" + paramInt2;
    paramInt1 = a(paramInt1 + 1);
    paramInt2 = a(paramInt2);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(DisplayUtil.a(getContext(), 17.0F)), 0, paramInt1, 33);
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(DisplayUtil.a(getContext(), 12.0F)), paramInt1, paramInt2 + paramInt1 + 1, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#77FFFFFF")), paramInt1, paramInt2 + paramInt1 + 1, 33);
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("        " + paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView
 * JD-Core Version:    0.7.0.1
 */