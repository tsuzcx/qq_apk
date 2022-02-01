package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ttpic.baseutils.audio.PlayerUtil;
import com.tencent.ttpic.baseutils.audio.PlayerUtil.Player;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class CountDownView
  extends RelativeLayout
{
  private static final String jdField_a_of_type_JavaLangString = "CountDownView";
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new CountDownView.MainHandler(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CountDownView.OnCountDownListener jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView$OnCountDownListener;
  private PlayerUtil.Player jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private boolean jdField_a_of_type_Boolean;
  private PlayerUtil.Player b;
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(paramContext, 2063663106);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    Object localObject;
    if (paramInt == 0)
    {
      setVisibility(4);
      localObject = this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView$OnCountDownListener;
      if (localObject != null) {
        ((CountDownView.OnCountDownListener)localObject).b();
      }
    }
    else
    {
      localObject = String.format(getResources().getConfiguration().locale, "%d", new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          try
          {
            Thread.sleep(150L);
          }
          catch (InterruptedException localInterruptedException)
          {
            LogUtils.e(localInterruptedException);
          }
        }
        if (paramInt == 1) {
          PlayerUtil.startPlayer(this.jdField_a_of_type_ComTencentTtpicBaseutilsAudioPlayerUtil$Player, true);
        } else if (paramInt <= 3) {
          PlayerUtil.startPlayer(this.b, true);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      setVisibility(4);
      CountDownView.OnCountDownListener localOnCountDownListener = this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView$OnCountDownListener;
      if (localOnCountDownListener != null) {
        localOnCountDownListener.a();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid input for countdown timer: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" seconds");
      LogUtils.w(str, localStringBuilder.toString());
      return;
    }
    setVisibility(0);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2064122543));
  }
  
  public void setCountDownListener(CountDownView.OnCountDownListener paramOnCountDownListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeViewCountDownView$OnCountDownListener = paramOnCountDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.CountDownView
 * JD-Core Version:    0.7.0.1
 */