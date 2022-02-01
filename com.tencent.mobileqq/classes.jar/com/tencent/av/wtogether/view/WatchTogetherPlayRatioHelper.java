package com.tencent.av.wtogether.view;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.av.wtogether.callback.WatchTogetherMediaPlayerProxy;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WatchTogetherPlayRatioHelper
  implements View.OnClickListener, View.OnTouchListener
{
  private static final float[] jdField_a_of_type_ArrayOfFloat = { 0.5F, 1.0F, 1.25F, 1.5F, 2.0F };
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131378369, 2131378371, 2131378370, 2131378368, 2131378367 };
  private static final TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[jdField_a_of_type_ArrayOfInt.length];
  private int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WatchTogetherMediaPlayerProxy jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy;
  private WatchTogetherPlayRatioHelper.OnSelectRatioClickListener jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper$OnSelectRatioClickListener;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  
  public WatchTogetherPlayRatioHelper(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    c();
    d();
    e();
  }
  
  private void a(boolean paramBoolean)
  {
    float f = 17.0F;
    int i = this.jdField_c_of_type_Int;
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130842486);
    if (paramBoolean)
    {
      f = 24.0F;
      localDrawable = this.jdField_a_of_type_AndroidViewView.getResources().getDrawable(2130842485);
      i = this.jdField_b_of_type_Int;
    }
    TextView[] arrayOfTextView = jdField_a_of_type_ArrayOfAndroidWidgetTextView;
    int k = arrayOfTextView.length;
    int j = 0;
    if (j < k)
    {
      TextView localTextView = arrayOfTextView[j];
      TextPaint localTextPaint = localTextView.getPaint();
      if (paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localTextPaint.setFakeBoldText(bool);
        localTextView.setTextSize(f);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, localDrawable.getConstantState().newDrawable());
        localTextView.setCompoundDrawablePadding(i);
        j += 1;
        break;
      }
    }
    f();
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    if (i < jdField_a_of_type_ArrayOfInt.length)
    {
      TextView localTextView = jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      GradientDrawable localGradientDrawable = (GradientDrawable)localTextView.getCompoundDrawables()[3];
      if (i == paramInt)
      {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131166063));
        localGradientDrawable.setColor(this.jdField_a_of_type_AndroidViewView.getResources().getColor(2131166062));
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(-1);
        localGradientDrawable.setColor(0);
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378369));
    jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = this.jdField_a_of_type_AndroidWidgetTextView;
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378371));
    jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = this.jdField_b_of_type_AndroidWidgetTextView;
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378370));
    jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = this.jdField_c_of_type_AndroidWidgetTextView;
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378368));
    jdField_a_of_type_ArrayOfAndroidWidgetTextView[3] = this.d;
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378367));
    jdField_a_of_type_ArrayOfAndroidWidgetTextView[4] = this.e;
    a(false);
    b(this.jdField_a_of_type_Int);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131298047);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidViewView.getResources().getDimensionPixelSize(2131298048);
  }
  
  private void e()
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfInt.length)
    {
      TextView localTextView = jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      localTextView.setOnClickListener(this);
      localTextView.setOnTouchListener(this);
      i += 1;
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) && (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.b()))
    {
      float f = this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a();
      int i = 0;
      for (;;)
      {
        if (i < jdField_a_of_type_ArrayOfFloat.length)
        {
          if (f == jdField_a_of_type_ArrayOfFloat[i]) {
            b(i);
          }
        }
        else {
          return;
        }
        i += 1;
      }
    }
    b(-1);
  }
  
  public void a()
  {
    f();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    if (paramInt == 2)
    {
      paramInt = (int)(ImmersiveUtils.getScreenWidth() * 0.2998501F);
      a(true);
    }
    for (;;)
    {
      localMarginLayoutParams.leftMargin = (paramInt / 2);
      localMarginLayoutParams.rightMargin = (paramInt / 2);
      if (this.jdField_a_of_type_AndroidViewView.isShown()) {
        this.jdField_a_of_type_AndroidViewView.requestLayout();
      }
      return;
      paramInt = AIOUtils.a(100.0F, this.jdField_a_of_type_AndroidViewView.getResources());
      a(false);
    }
  }
  
  public void a(WatchTogetherMediaPlayerProxy paramWatchTogetherMediaPlayerProxy)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy = paramWatchTogetherMediaPlayerProxy;
  }
  
  public void a(WatchTogetherPlayRatioHelper.OnSelectRatioClickListener paramOnSelectRatioClickListener)
  {
    this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper$OnSelectRatioClickListener = paramOnSelectRatioClickListener;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      b(this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper$OnSelectRatioClickListener != null) {
        this.jdField_a_of_type_ComTencentAvWtogetherViewWatchTogetherPlayRatioHelper$OnSelectRatioClickListener.f();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null)
      {
        this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(jdField_a_of_type_ArrayOfFloat[0]);
        continue;
        this.jdField_a_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null)
        {
          this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(jdField_a_of_type_ArrayOfFloat[1]);
          continue;
          this.jdField_a_of_type_Int = 2;
          if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null)
          {
            this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(jdField_a_of_type_ArrayOfFloat[2]);
            continue;
            this.jdField_a_of_type_Int = 3;
            if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null)
            {
              this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(jdField_a_of_type_ArrayOfFloat[3]);
              continue;
              this.jdField_a_of_type_Int = 4;
              if (this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy != null) {
                this.jdField_a_of_type_ComTencentAvWtogetherCallbackWatchTogetherMediaPlayerProxy.a(jdField_a_of_type_ArrayOfFloat[4]);
              }
            }
          }
        }
      }
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      paramView.setAlpha(0.5F);
      continue;
      paramView.setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.view.WatchTogetherPlayRatioHelper
 * JD-Core Version:    0.7.0.1
 */