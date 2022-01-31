package com.tencent.biz.qqstory.takevideo2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import omm;
import omn;
import omp;
import omq;
import omr;
import oms;

public class StoryLocalPublishPart
  extends StoryCapturePart
{
  public final int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new oms(this);
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  
  public StoryLocalPublishPart(@NonNull StoryEffectsCameraCaptureFragment paramStoryEffectsCameraCaptureFragment)
  {
    super(paramStoryEffectsCameraCaptureFragment);
    this.jdField_a_of_type_Int = a();
  }
  
  public void a()
  {
    super.a();
    a(new omq(this));
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    a(new omr(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    }
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)paramView.findViewById(2131370614));
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(new ColorDrawable(0));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideo2StoryEffectsCameraCaptureFragment.a().setContainerViewListener(new omm(this));
    Bosses.get().postJob(new omn(this, paramView));
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    super.a(paramPhotoCaptureResult);
  }
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    super.a(paramVideoCaptureResult, paramLocalMediaInfo);
  }
  
  public void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
  }
  
  public void b()
  {
    super.b();
    a(new omp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryLocalPublishPart
 * JD-Core Version:    0.7.0.1
 */