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
import com.tencent.biz.pubaccount.weishi_new.baseui.IPlayModeChangeListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.RotationSeekBar;

public class WSPlayerControlBar
  extends RelativeLayout
  implements IPlayModeChangeListener
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
    paramContext = LayoutInflater.from(paramContext).inflate(2131560049, null);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar = ((RotationSeekBar)paramContext.findViewById(2131380678));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131380679));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setPadding(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setMax(1000);
    addView(paramContext);
  }
  
  public void a()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      localImageView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidWidgetImageView.getBackground() == null) {
        try
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841896);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("showLoadingProgressBar error:");
          localStringBuilder.append(localOutOfMemoryError);
          WSLog.d("WS_VIDEO_seekBar", localStringBuilder.toString());
        }
      }
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidWidgetImageView.getBackground();
      if (localAnimationDrawable != null)
      {
        localAnimationDrawable.setVisible(true, true);
        localAnimationDrawable.setOneShot(false);
        localAnimationDrawable.start();
      }
    }
  }
  
  public void a(Rect paramRect)
  {
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.getGlobalVisibleRect(paramRect);
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.removeCallbacks(paramRunnable);
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSPlayerControlBar hideLoadingProgressBar() mProgressLoading:");
    localStringBuilder.append(this.jdField_a_of_type_AndroidWidgetImageView);
    localStringBuilder.append(", getVisibility():");
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      localObject = Integer.valueOf(((ImageView)localObject).getVisibility());
    } else {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    WSLog.b("WS_VIDEO_ProgressBar", localStringBuilder.toString());
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      WSLog.b("WS_VIDEO_ProgressBar", "WSPlayerControlBar hideLoadingProgressBar() hide");
      c();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
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
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.setProgress((int)(paramFloat * 1000.0F));
    }
  }
  
  public void setSeekBarActivated(boolean paramBoolean)
  {
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.setActivated(paramBoolean);
    }
  }
  
  public void setSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    RotationSeekBar localRotationSeekBar = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRotationSeekBar;
    if (localRotationSeekBar != null) {
      localRotationSeekBar.setThumb(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar
 * JD-Core Version:    0.7.0.1
 */