package com.tencent.biz.qqstory.takevideo2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import javax.microedition.khronos.opengles.GL10;
import yqp;
import ziu;

public class StoryEffectsCameraCaptureView
  extends EffectsCameraCaptureView
{
  private ziu a;
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public StoryEffectsCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, long paramLong)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.r == 1)) {
      yqp.b("zhiqiang", "frameToMediaCodec the last frame=" + paramLong);
    }
    super.a(paramInt1, paramInt2, paramArrayOfFloat1, paramArrayOfFloat2, paramLong);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
    paramGL10 = this.jdField_a_of_type_Ziu;
    if (paramGL10 != null)
    {
      paramGL10.a(GlUtil.captureFrame(b(this.t), this.n, this.o, 0));
      this.jdField_a_of_type_Ziu = null;
    }
  }
  
  public void setCaptureRequest(ziu paramziu)
  {
    this.jdField_a_of_type_Ziu = paramziu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */