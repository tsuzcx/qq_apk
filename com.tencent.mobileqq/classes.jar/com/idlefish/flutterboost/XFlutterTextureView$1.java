package com.idlefish.flutterboost;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.view.TextureView.SurfaceTextureListener;
import io.flutter.Log;

class XFlutterTextureView$1
  implements TextureView.SurfaceTextureListener
{
  XFlutterTextureView$1(XFlutterTextureView paramXFlutterTextureView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
    XFlutterTextureView.access$002(this.this$0, true);
    if (XFlutterTextureView.access$100(this.this$0)) {
      XFlutterTextureView.access$200(this.this$0);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture paramSurfaceTexture)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
    XFlutterTextureView.access$002(this.this$0, false);
    if (XFlutterTextureView.access$100(this.this$0)) {
      XFlutterTextureView.access$400(this.this$0);
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.v("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
    if (XFlutterTextureView.access$100(this.this$0)) {
      XFlutterTextureView.access$300(this.this$0, paramInt1, paramInt2);
    }
  }
  
  public void onSurfaceTextureUpdated(@NonNull SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.idlefish.flutterboost.XFlutterTextureView.1
 * JD-Core Version:    0.7.0.1
 */