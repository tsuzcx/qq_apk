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
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;

public class SingleLyricView
  extends RelativeLayout
  implements ILyricView
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final LyricControllerWrapper jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper;
  private final OnLyricListener jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricOnLyricListener;
  private volatile Lyric jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  private Sentence jdField_a_of_type_ComTencentMobileqqLyricDataSentence;
  private final String jdField_a_of_type_JavaLangString = "SingleLyricView";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
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
    LayoutInflater.from(paramContext).inflate(2131563025, this, true);
    a(paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377631));
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377632));
      paramContext = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378042));
      paramContext = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramContext != null) {
        paramContext.setVisibility(0);
      }
      paramContext = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramContext != null) {
        paramContext.setVisibility(8);
      }
    }
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper = new LyricControllerWrapper();
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricOnLyricListener = new SingleLyricView.1(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
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
    Object localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).end();
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
    ((ValueAnimator)localObject).setDuration(500L);
    ((ValueAnimator)localObject).setInterpolator(new AccelerateInterpolator());
    ((ValueAnimator)localObject).addUpdateListener(new SingleLyricView.2(this));
    ((ValueAnimator)localObject).addListener(new SingleLyricView.3(this, paramString));
    paramString = ValueAnimator.ofFloat(new float[] { 0.3F, 1.0F });
    paramString.setDuration(500L);
    paramString.addUpdateListener(new SingleLyricView.4(this));
    paramString.addListener(new SingleLyricView.5(this));
    paramString.setInterpolator(new DecelerateInterpolator());
    paramString.addListener(new SingleLyricView.6(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(new Animator[] { localObject, paramString });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
    Object localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      ((TextView)localObject).setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localObject != null) {
      ((AnimatorSet)localObject).cancel();
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null) {
      return;
    }
    Object localObject = LyricParserHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric, this.jdField_a_of_type_Long + paramLong);
    Sentence localSentence = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence;
    int j = 1;
    int i;
    if (localSentence != localObject) {
      i = 1;
    } else {
      i = 0;
    }
    if ((!this.jdField_a_of_type_Boolean) || (paramLong >= this.jdField_b_of_type_Long)) {
      j = 0;
    }
    if ((localObject != null) && (i != 0) && (j == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = ((Sentence)localObject);
      a(((Sentence)localObject).jdField_a_of_type_JavaLangString);
      this.c = ((Sentence)localObject).jdField_a_of_type_JavaLangString;
      return;
    }
    if ((j != 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!this.jdField_b_of_type_JavaLangString.equals(this.c)))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.jdField_b_of_type_JavaLangString);
        this.c = this.jdField_b_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqLyricDataSentence = null;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper.a(this);
    VideoPlayStatusDispatcher.a().a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricOnLyricListener);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    VideoPlayStatusDispatcher.a().b(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricOnLyricListener);
    this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricControllerWrapper.a();
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null) {
      localAnimatorSet.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(null);
  }
  
  public void setData(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
    this.jdField_a_of_type_AndroidOsHandler.post(new SingleLyricView.7(this, paramString1, paramString2));
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void setPos(long paramLong)
  {
    if (paramLong < 0L) {
      paramLong = 0L;
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setSongName(String paramString, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localTextView != null)
      {
        localTextView.setAlpha(1.0F);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramLong < 0L) {
        paramLong = 3000L;
      }
      this.jdField_b_of_type_Long = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.SingleLyricView
 * JD-Core Version:    0.7.0.1
 */