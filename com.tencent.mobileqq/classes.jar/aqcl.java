import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public abstract class aqcl
  extends LoadingLayoutBase
{
  protected static final Interpolator a;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  protected final ImageView a;
  protected final ProgressBar a;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  protected final PullToRefreshBase.Mode a;
  protected final PullToRefreshBase.Orientation a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private CharSequence c;
  private CharSequence d;
  
  static
  {
    jdField_a_of_type_AndroidViewAnimationInterpolator = new LinearInterpolator();
  }
  
  public aqcl(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    switch (aqcm.a[paramOrientation.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2131559459, this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131366433));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372487));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372485));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372486));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372482));
      localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      switch (aqcm.b[paramMode.ordinal()])
      {
      default: 
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i = 80;
          label179:
          localLayoutParams.gravity = i;
          this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131695787);
          this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131695788);
          this.c = paramContext.getString(2131695789);
          if (paramTypedArray.hasValue(7))
          {
            paramOrientation = paramTypedArray.getDrawable(7);
            if (paramOrientation != null) {
              aqcn.a(this, paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(11))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(11, paramOrientation);
            b(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(21))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(21, paramOrientation);
            a(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(12))
          {
            paramOrientation = paramTypedArray.getColorStateList(12);
            if (paramOrientation != null) {
              b(paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(10))
          {
            paramOrientation = paramTypedArray.getColorStateList(10);
            if (paramOrientation != null) {
              a(paramOrientation);
            }
          }
          paramOrientation = null;
          if (paramTypedArray.hasValue(2)) {
            paramOrientation = paramTypedArray.getDrawable(2);
          }
          switch (aqcm.b[paramMode.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(5)) {
              paramMode = paramTypedArray.getDrawable(5);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramOrientation = paramMode;
      if (paramMode == null) {
        paramOrientation = paramContext.getResources().getDrawable(b());
      }
      setLoadingDrawable(paramOrientation);
      g();
      return;
      LayoutInflater.from(paramContext).inflate(2131559458, this);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {}
      for (i = 48;; i = 3)
      {
        localLayoutParams.gravity = i;
        this.jdField_a_of_type_JavaLangCharSequence = paramContext.getString(2131695784);
        this.jdField_b_of_type_JavaLangCharSequence = paramContext.getString(2131695785);
        this.c = paramContext.getString(2131695786);
        break;
      }
      i = 5;
      break label179;
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(6))
      {
        paramMode = paramTypedArray.getDrawable(6);
        continue;
        if (paramTypedArray.hasValue(4))
        {
          paramMode = paramTypedArray.getDrawable(4);
        }
        else
        {
          paramMode = paramOrientation;
          if (paramTypedArray.hasValue(3)) {
            paramMode = paramTypedArray.getDrawable(3);
          }
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void a(ColorStateList paramColorStateList)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  private void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void b(ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramColorStateList);
    }
  }
  
  public final int a()
  {
    switch (aqcm.a[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation.ordinal()])
    {
    default: 
      return this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
    }
    return this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
  }
  
  public final void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      b(paramFloat);
    }
  }
  
  protected abstract void a(Drawable paramDrawable);
  
  protected abstract int b();
  
  protected abstract void b(float paramFloat);
  
  public final void d()
  {
    g();
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    i();
  }
  
  public final void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
    }
    k();
  }
  
  public final void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangCharSequence);
    }
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      j();
    }
  }
  
  public final void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.jdField_a_of_type_Boolean) {
      ((AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        if (!TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          break;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      l();
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public final void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    }
    if (this.jdField_a_of_type_AndroidWidgetProgressBar != null) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    }
  }
  
  protected abstract void i();
  
  protected abstract void j();
  
  protected abstract void k();
  
  protected abstract void l();
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    a(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_Boolean = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcl
 * JD-Core Version:    0.7.0.1
 */