package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.view.RotationSeekBar;
import tlo;

public class WSPlayerControlBar
  extends RelativeLayout
{
  private int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RotationSeekBar jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
  private final String jdField_a_of_type_JavaLangString = "WS_VIDEO_seekBar";
  private boolean jdField_a_of_type_Boolean;
  
  public WSPlayerControlBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WSPlayerControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WSPlayerControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559875, null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar = ((RotationSeekBar)paramContext.findViewById(2131379758));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131379759));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setMax(1000);
    addView(paramContext);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetImageView.getBackground() != null) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841474);
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
      if (localAnimationDrawable != null)
      {
        localAnimationDrawable.setVisible(true, true);
        localAnimationDrawable.setOneShot(false);
        localAnimationDrawable.start();
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        tlo.d("WS_VIDEO_seekBar", "showLoadingProgressBar error:" + localOutOfMemoryError);
      }
    }
  }
  
  public void a(Rect paramRect)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.removeCallbacks(paramRunnable);
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("WSPlayerControlBar hideLoadingProgressBar() mProgressLoading:").append(this.jdField_a_of_type_AndroidWidgetImageView).append(", getVisibility():");
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {}
    for (Object localObject = Integer.valueOf(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());; localObject = "null")
    {
      tlo.b("WS_VIDEO_ProgressBar", localObject);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        tlo.b("WS_VIDEO_ProgressBar", "WSPlayerControlBar hideLoadingProgressBar() hide");
        c();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return;
    }
  }
  
  public void c()
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
    if ((localAnimationDrawable != null) && (localAnimationDrawable.isRunning()))
    {
      localAnimationDrawable.setOneShot(true);
      localAnimationDrawable.stop();
    }
  }
  
  public void setNeedDeepClearScreen(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProgress(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setProgress((int)(1000.0F * paramFloat));
    }
  }
  
  public void setSeekBarActivated(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setActivated(paramBoolean);
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setThumb(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar
 * JD-Core Version:    0.7.0.1
 */