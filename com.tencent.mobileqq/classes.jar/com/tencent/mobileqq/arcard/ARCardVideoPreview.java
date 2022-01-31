package com.tencent.mobileqq.arcard;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;

public class ARCardVideoPreview
  extends HWVideoPlayView
{
  private int h;
  private int i;
  
  public ARCardVideoPreview(Context paramContext)
  {
    super(paramContext);
  }
  
  public ARCardVideoPreview(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super.a(paramArrayOfFloat1, GPUBaseFilter.a(this.h, this.i, this.b, this.c));
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.h = paramInt1;
    this.i = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardVideoPreview
 * JD-Core Version:    0.7.0.1
 */