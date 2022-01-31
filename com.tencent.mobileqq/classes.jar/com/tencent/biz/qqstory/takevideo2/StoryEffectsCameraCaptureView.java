package com.tencent.biz.qqstory.takevideo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import javax.microedition.khronos.opengles.GL10;

public class StoryEffectsCameraCaptureView
  extends EffectsCameraCaptureView
{
  private StoryEffectsCameraCaptureView.CaptureRequest a;
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
    paramGL10 = this.a;
    if (paramGL10 != null)
    {
      paramGL10.a(GlUtil.a(a(this.k), this.f, this.g, 0));
      this.a = null;
    }
  }
  
  public void setCaptureRequest(StoryEffectsCameraCaptureView.CaptureRequest paramCaptureRequest)
  {
    this.a = paramCaptureRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */