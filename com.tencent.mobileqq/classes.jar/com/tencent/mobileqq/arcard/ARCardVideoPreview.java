package com.tencent.mobileqq.arcard;

import android.content.Context;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.widget.HWVideoPlayView;

public class ARCardVideoPreview
  extends HWVideoPlayView
{
  private int f;
  private int g;
  
  public ARCardVideoPreview(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super.a(paramArrayOfFloat1, GPUBaseFilter.a(this.f, this.g, this.b, this.c));
  }
  
  public void setVideoSize(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardVideoPreview
 * JD-Core Version:    0.7.0.1
 */