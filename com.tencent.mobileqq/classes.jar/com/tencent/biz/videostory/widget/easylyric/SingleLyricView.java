package com.tencent.biz.videostory.widget.easylyric;

import aans;
import aant;
import aanw;
import aany;
import aaoa;
import aaob;
import aaoc;
import aaod;
import aaoe;
import aaof;
import aaog;
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
import awpy;
import awqa;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;

public class SingleLyricView
  extends RelativeLayout
  implements aans
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final aant jdField_a_of_type_Aant;
  private final aany jdField_a_of_type_Aany;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile awpy jdField_a_of_type_Awpy;
  private awqa jdField_a_of_type_Awqa;
  private final String jdField_a_of_type_JavaLangString = "SingleLyricView";
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
    LayoutInflater.from(paramContext).inflate(2131563043, this, true);
    a(paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377804));
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377805));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aant = new aant();
      this.jdField_a_of_type_Aany = new aaoa(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      return;
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378224));
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
    localValueAnimator.addUpdateListener(new aaob(this));
    localValueAnimator.addListener(new aaoc(this, paramString));
    paramString = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
    paramString.setDuration(500L);
    paramString.addUpdateListener(new aaod(this));
    paramString.addListener(new aaoe(this));
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addListener(new aaof(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localValueAnimator, paramString });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Awpy = null;
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
    if (this.jdField_a_of_type_Awpy == null) {}
    label100:
    label106:
    do
    {
      return;
      awqa localawqa = aanw.a().a(this.jdField_a_of_type_Awpy, this.jdField_a_of_type_Long + paramLong);
      int i;
      if (this.jdField_a_of_type_Awqa != localawqa)
      {
        i = 1;
        if ((!this.jdField_a_of_type_Boolean) || (paramLong >= this.jdField_b_of_type_Long)) {
          break label100;
        }
      }
      for (;;)
      {
        if ((localawqa == null) || (i == 0) || (j != 0)) {
          break label106;
        }
        this.jdField_a_of_type_Awqa = localawqa;
        a(localawqa.jdField_a_of_type_JavaLangString);
        this.c = localawqa.jdField_a_of_type_JavaLangString;
        return;
        i = 0;
        break;
        j = 0;
      }
    } while ((j == 0) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_JavaLangString.equals(this.c)) || (this.jdField_a_of_type_AndroidWidgetTextView == null));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    this.c = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_Awqa = null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Aant.a(this);
    aaog.a().a(this.jdField_a_of_type_Aany);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    aaog.a().b(this.jdField_a_of_type_Aany);
    this.jdField_a_of_type_Aant.a();
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Awpy = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView
 * JD-Core Version:    0.7.0.1
 */