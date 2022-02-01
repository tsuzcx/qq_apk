package com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.TextureView.SurfaceTextureListener;

class AlphaPlayerView$2
  implements TextureView.SurfaceTextureListener
{
  AlphaPlayerView$2(AlphaPlayerView paramAlphaPlayerView) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.d("AlphaPlayerView", "onSurfaceTextureAvailable");
    paramSurfaceTexture = this.a;
    AlphaPlayerView.a(paramSurfaceTexture, AlphaPlayerView.b(paramSurfaceTexture), paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.d("AlphaPlayerView", "onSurfaceTextureDestroyed");
    AlphaThreadUtil.a(new AlphaPlayerView.2.1(this));
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("onSurfaceTextureSizeChanged width:");
    paramSurfaceTexture.append(paramInt1);
    paramSurfaceTexture.append(" height:");
    paramSurfaceTexture.append(paramInt2);
    Log.d("AlphaPlayerView", paramSurfaceTexture.toString());
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.alphaplayer.AlphaPlayerView.2
 * JD-Core Version:    0.7.0.1
 */