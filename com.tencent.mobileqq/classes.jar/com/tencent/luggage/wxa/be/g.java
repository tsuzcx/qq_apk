package com.tencent.luggage.wxa.be;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import com.tencent.luggage.wxa.kp.f;
import com.tencent.luggage.wxa.mv.a;
import com.tencent.luggage.wxa.qz.o;

public class g
  extends b
  implements f
{
  private SurfaceTexture d;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public static void p()
  {
    a.a(new g.1());
  }
  
  protected a.a a(String paramString)
  {
    return super.a(paramString);
  }
  
  protected d a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.d.setDefaultBufferSize(paramInt1, paramInt2);
    return new h(paramContext, this.d, paramInt1, paramInt2);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (getRecordView() == null) {
      return;
    }
    getRecordView().a(paramMotionEvent);
  }
  
  public void setCustomSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    o.d("MicroMsg.SameLayerCameraView", "setCustomSurfaceTexture:%s", new Object[] { paramSurfaceTexture });
    this.d = paramSurfaceTexture;
  }
  
  public void setDisplayScreenSize(Size paramSize) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.g
 * JD-Core Version:    0.7.0.1
 */