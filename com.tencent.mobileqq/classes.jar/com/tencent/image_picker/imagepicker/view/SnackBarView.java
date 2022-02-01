package com.tencent.image_picker.imagepicker.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

public class SnackBarView
  extends RelativeLayout
{
  private static final Interpolator a = new FastOutLinearInInterpolator();
  private TextView b;
  private Button c;
  
  public SnackBarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SnackBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SnackBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    View.inflate(getContext(), 2131625243, this);
    if (isInEditMode()) {
      return;
    }
    ViewCompat.setTranslationY(this, getContext().getResources().getDimensionPixelSize(2131300058));
    ViewCompat.setAlpha(this, 0.0F);
    int i = getContext().getResources().getDimensionPixelSize(2131300066);
    setPadding(i, 0, i, 0);
    this.b = ((TextView)findViewById(2131432386));
    this.c = ((Button)findViewById(2131432385));
  }
  
  private void a(Runnable paramRunnable)
  {
    ViewCompat.animate(this).translationY(getHeight()).setDuration(200L).alpha(0.5F).withEndAction(paramRunnable);
  }
  
  public void a(@StringRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 2131918053;
    }
    this.c.setText(i);
    this.c.setOnClickListener(new SnackBarView.1(this, paramOnClickListener));
  }
  
  public void b(@StringRes int paramInt, View.OnClickListener paramOnClickListener)
  {
    setText(paramInt);
    a(0, paramOnClickListener);
    ViewCompat.animate(this).translationY(0.0F).setDuration(200L).setInterpolator(a).alpha(1.0F);
  }
  
  public void setText(@StringRes int paramInt)
  {
    this.b.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.view.SnackBarView
 * JD-Core Version:    0.7.0.1
 */