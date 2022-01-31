package com.tencent.biz.qqstory.takevideo2;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout.CaptureButtonProgressInterceptor;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.atomic.AtomicBoolean;
import orf;
import orh;

public class StoryMultiFragmentPart
  extends StoryCapturePart
  implements CameraCaptureButtonLayout.CaptureButtonProgressInterceptor
{
  private int jdField_a_of_type_Int;
  private GLSurfaceView jdField_a_of_type_AndroidOpenglGLSurfaceView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_a_of_type_Boolean;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  
  public StoryMultiFragmentPart(@NonNull StoryEffectsCameraCaptureFragment paramStoryEffectsCameraCaptureFragment)
  {
    super(paramStoryEffectsCameraCaptureFragment);
  }
  
  void a(long paramLong)
  {
    if ((paramLong >= 8000L) && (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)))
    {
      SLog.c("story.publish.StoryMultiFragmentPart", "show fragment tip.");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("继续按住进入连拍模式");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setStartOffset(1500L);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setAnimationListener(new orh(this));
      this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = a(a());
    if (this.jdField_a_of_type_Boolean) {
      StorageManager.a = StorageManager.b;
    }
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370162));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370171));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370163));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370169));
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      this.jdField_a_of_type_AndroidOpenglGLSurfaceView = ((GLSurfaceView)paramView.findViewById(2131366943));
      c();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a().setCaptureButtonProgressInterceptor(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a().setMaxDuration((float)a().getLong("capture_max_duration", 10000L));
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    VideoEnvironment.a("AVCodec", this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.getActivity().getApplicationContext());
    boolean bool2 = VideoEnvironment.b(7);
    boolean bool3 = paramBundle.getBoolean("enable_multi_fragment", true);
    if ((bool2) && (bool3)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1 != bool3) {
        SLog.d("story.publish.StoryMultiFragmentPart", "we are requested turn on multi fragment capture ability, but avCodecSupport=%s", new Object[] { Boolean.valueOf(bool2) });
      }
      return bool1;
    }
  }
  
  public boolean a(@NonNull TextView paramTextView, @NonNull CircleProgress paramCircleProgress, long paramLong, float paramFloat)
  {
    long l = System.currentTimeMillis() - paramLong;
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((float)l >= paramFloat)
      {
        bool1 = true;
        if (!bool1) {
          break label210;
        }
        paramLong = 10000L;
      }
      for (i = 100;; i = (int)(100L * paramLong / 10000L))
      {
        paramTextView.setText((int)paramLong / 1000 + "秒");
        paramCircleProgress.setProgress(i);
        i = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = ((int)(l / 10000L));
        boolean bool2 = bool1;
        if (this.jdField_a_of_type_Int == i + 1)
        {
          SLog.b("story.publish.StoryMultiFragmentPart", "adjustFragmentThumb. fragment count = %d.", Integer.valueOf(this.jdField_a_of_type_Int));
          d();
          if (this.jdField_a_of_type_Int == 1) {
            StoryReportor.a("video_shoot", "series_shoot", 0, 0, new String[0]);
          }
          bool2 = bool1;
          if (this.jdField_a_of_type_Int < 6)
          {
            bool2 = bool1;
            if (!StoryEffectsCameraCaptureFragment.a())
            {
              QQToast.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.getActivity(), "手机内存空间不足。", 1).a();
              bool2 = true;
            }
          }
        }
        a(l);
        b(l);
        return bool2;
        bool1 = false;
        break;
        label210:
        paramLong = l % 10000L;
      }
    }
    if ((float)l >= paramFloat)
    {
      bool1 = true;
      label244:
      if (!bool1) {
        break label298;
      }
    }
    label298:
    for (int i = 100;; i = (int)((float)l / paramFloat * 100.0F))
    {
      paramTextView.setText((int)l / 1000 + "秒");
      paramCircleProgress.setProgress(i);
      break;
      bool1 = false;
      break label244;
    }
  }
  
  void b(long paramLong)
  {
    if ((paramLong >= 55000L) && (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true)))
    {
      SLog.c("story.publish.StoryMultiFragmentPart", "show end fragment tip.");
      this.jdField_b_of_type_AndroidWidgetTextView.setText("即将拍满6段进入编辑");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  void d()
  {
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.getActivity();
    SLog.b("story.publish.StoryMultiFragmentPart", "requestGetCurrentFrameBitmap");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a(new orf(this, localFragmentActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryMultiFragmentPart
 * JD-Core Version:    0.7.0.1
 */