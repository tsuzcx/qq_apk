package com.tencent.luggage.wxa.my;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.xweb.skia_canvas.SkiaCanvasApp;
import com.tencent.xweb.skia_canvas.SkiaCanvasView;

public class d
  extends TextureView
{
  private String a;
  private int b;
  private SkiaCanvasView c;
  private SkiaCanvasApp d;
  private d.a e;
  
  public d(@NonNull Context paramContext, @NonNull SkiaCanvasApp paramSkiaCanvasApp, int paramInt, String paramString)
  {
    super(paramContext);
    this.d = paramSkiaCanvasApp;
    this.b = paramInt;
    this.a = paramString;
    b();
  }
  
  private void b()
  {
    setSurfaceTextureListener(new d.2(this));
    setOpaque(false);
  }
  
  public void a()
  {
    SkiaCanvasView localSkiaCanvasView = this.c;
    if (localSkiaCanvasView != null) {
      localSkiaCanvasView.recycle();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SkiaCanvasView localSkiaCanvasView = this.c;
    if (localSkiaCanvasView != null) {
      localSkiaCanvasView.notifyVisibilityChanged(paramBoolean);
    }
  }
  
  public void setOnReadyListener(d.a parama)
  {
    this.e = parama;
    t.a(new d.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.my.d
 * JD-Core Version:    0.7.0.1
 */