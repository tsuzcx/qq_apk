package com.tencent.biz.videostory.widget.easylyric;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import atsc;
import atse;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import ywl;
import ywm;
import ywp;
import ywr;
import ywt;
import ywu;
import ywv;
import yww;
import ywx;
import ywy;
import ywz;

public class SingleLyricView
  extends RelativeLayout
  implements ywl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile atsc jdField_a_of_type_Atsc;
  private atse jdField_a_of_type_Atse;
  private final String jdField_a_of_type_JavaLangString = "SingleLyricView";
  private final ywm jdField_a_of_type_Ywm;
  private final ywr jdField_a_of_type_Ywr;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public SingleLyricView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLyricView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131562795, this, true);
    a(paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376744));
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376745));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Ywm = new ywm();
      this.jdField_a_of_type_Ywr = new ywt(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377146));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.SingleLyricView, paramInt, 0);
    try
    {
      this.jdField_b_of_type_Int = paramAttributeSet.getInteger(0, 1);
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.end();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateInterpolator());
    localValueAnimator.addUpdateListener(new ywu(this));
    localValueAnimator.addListener(new ywv(this, paramString));
    paramString = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
    paramString.setDuration(500L);
    paramString.addUpdateListener(new yww(this));
    paramString.addListener(new ywx(this));
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addListener(new ywy(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localValueAnimator, paramString });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Atsc = null;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    }
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(long paramLong)
  {
    int j = 1;
    if (this.jdField_a_of_type_Atsc == null) {}
    label100:
    label106:
    do
    {
      return;
      atse localatse = ywp.a().a(this.jdField_a_of_type_Atsc, this.jdField_a_of_type_Long + paramLong);
      int i;
      if (this.jdField_a_of_type_Atse != localatse)
      {
        i = 1;
        if ((!this.jdField_a_of_type_Boolean) || (paramLong >= this.jdField_b_of_type_Long)) {
          break label100;
        }
      }
      for (;;)
      {
        if ((localatse == null) || (i == 0) || (j != 0)) {
          break label106;
        }
        this.jdField_a_of_type_Atse = localatse;
        a(localatse.jdField_a_of_type_JavaLangString);
        this.c = localatse.jdField_a_of_type_JavaLangString;
        return;
        i = 0;
        break;
        j = 0;
      }
    } while ((j == 0) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaLangString.equals(this.c)) || (this.jdField_a_of_type_AndroidWidgetTextView == null));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.c = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Atse = null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Ywm.a(this);
    ywz.a().a(this.jdField_a_of_type_Ywr);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ywz.a().b(this.jdField_a_of_type_Ywr);
    this.jdField_a_of_type_Ywm.a();
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Atsc = null;
    this.jdField_a_of_type_AndroidOsHandler.post(new SingleLyricView.7(this, paramString1, paramString2));
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void setPos(long paramLong)
  {
    if (paramLong >= 0L) {}
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
      paramLong = 0L;
    }
  }
  
  public void setSongName(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramLong < 0L) {
        break label52;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = paramLong;
      return;
      label52:
      paramLong = 3000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView
 * JD-Core Version:    0.7.0.1
 */