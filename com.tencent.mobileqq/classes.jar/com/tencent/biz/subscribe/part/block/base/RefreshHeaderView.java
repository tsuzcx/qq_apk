package com.tencent.biz.subscribe.part.block.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public class RefreshHeaderView
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RefreshHeaderView.OnRefreshListener jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView$OnRefreshListener;
  private final String jdField_a_of_type_JavaLangString = getResources().getString(2131719253);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private final String jdField_b_of_type_JavaLangString = getResources().getString(2131719249);
  private final String c = getResources().getString(2131719252);
  private final String d = getResources().getString(2131719250);
  
  public RefreshHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RefreshHeaderView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void a(int paramInt)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { a(), paramInt });
    localValueAnimator.setDuration(200L).start();
    localValueAnimator.addUpdateListener(new RefreshHeaderView.2(this, paramInt));
    localValueAnimator.start();
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(paramBoolean);
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localProgressBar.setVisibility(i);
  }
  
  private boolean a(float paramFloat, boolean paramBoolean)
  {
    return (paramFloat > 0.0F) && (!paramBoolean);
  }
  
  private boolean c()
  {
    return getParent() != null;
  }
  
  private void e()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams);
    setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131560725, null));
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, new LinearLayout.LayoutParams(-1, 0));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369374));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379844));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372398));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    measure(-2, -2);
    this.jdField_a_of_type_Int = getMeasuredHeight();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
  }
  
  public int a()
  {
    return ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams()).height;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    setState(0);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if ((a() > 0) || (paramFloat1 > 0.0F))
    {
      setVisibleHeight((int)paramFloat1 + a());
      if (this.jdField_b_of_type_Int <= 1)
      {
        if (a() > this.jdField_a_of_type_Int)
        {
          b();
          return;
        }
        a();
      }
    }
  }
  
  public boolean a()
  {
    int i = a();
    boolean bool;
    if ((a() > this.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int < 2))
    {
      setState(2);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.jdField_b_of_type_Int == 2)
    {
      int j = this.jdField_a_of_type_Int;
      if (i > j) {
        a(j);
      }
    }
    if (this.jdField_b_of_type_Int != 2) {
      a(0);
    }
    if (this.jdField_b_of_type_Int == 2) {
      a(this.jdField_a_of_type_Int);
    }
    return bool;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Float == -1.0F) {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 2)
      {
        this.jdField_a_of_type_Float = -1.0F;
        if ((c()) && (!this.jdField_a_of_type_Boolean)) {
          a();
        }
      }
      else
      {
        float f2 = paramMotionEvent.getRawY();
        float f1 = this.jdField_a_of_type_Float;
        f2 = (f2 - f1) / 2.0F;
        boolean bool;
        if (f1 == 0.0F) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
        this.jdField_b_of_type_Float += f2;
        if ((c()) && (!this.jdField_a_of_type_Boolean) && (a(f2, bool)))
        {
          a(f2, this.jdField_b_of_type_Float);
          if (a() > 0) {
            return false;
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
      this.jdField_b_of_type_Float = 0.0F;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void b()
  {
    setState(1);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void c()
  {
    QLog.d("RefreshHeaderView", 1, "refreshComplete");
    long l = 1000L - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      a().postDelayed(new RefreshHeaderView.1(this), l);
      return;
    }
    setState(3);
  }
  
  public void d()
  {
    if (a() != null) {
      a().removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_b_of_type_Int == 1) {
      setState(2);
    }
  }
  
  public void setOnRefreshListener(RefreshHeaderView.OnRefreshListener paramOnRefreshListener)
  {
    this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView$OnRefreshListener = paramOnRefreshListener;
  }
  
  public void setRefreshing(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      c();
    }
  }
  
  public void setState(int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    if (paramInt == i) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              QLog.d("RefreshHeaderView", 4, "STATE_JUST_SHOW_REFRESH_ANIMATION");
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              a(true);
              a(this.jdField_a_of_type_Int);
              this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
              setRefreshing(true);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            a(false);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
            a(0);
          }
        }
        else
        {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          a(true);
          a(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
          localObject = this.jdField_a_of_type_ComTencentBizSubscribePartBlockBaseRefreshHeaderView$OnRefreshListener;
          if (localObject != null) {
            ((RefreshHeaderView.OnRefreshListener)localObject).b();
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        a(false);
        if (this.jdField_b_of_type_Int != 1)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
          this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.c);
        }
      }
    }
    else
    {
      if (i == 1) {
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
      }
      if (this.jdField_b_of_type_Int == 2) {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.d);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("state:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("RefreshHeaderView", 1, ((StringBuilder)localObject).toString());
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setVisibleHeight(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.height = i;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.block.base.RefreshHeaderView
 * JD-Core Version:    0.7.0.1
 */