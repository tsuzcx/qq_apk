package com.tencent.aelight.camera.ae.play;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class AETemplateInfoFragment$PlayerSurfaceTextureCallback
  implements TextureView.SurfaceTextureListener
{
  private WeakReference<AETemplateInfoFragment> mRef;
  
  public AETemplateInfoFragment$PlayerSurfaceTextureCallback(AETemplateInfoFragment paramAETemplateInfoFragment)
  {
    this.mRef = new WeakReference(paramAETemplateInfoFragment);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureAvailable");
    WeakReference localWeakReference = this.mRef;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      AETemplateInfoFragment.access$700((AETemplateInfoFragment)this.mRef.get(), paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureDestroyed");
    paramSurfaceTexture = this.mRef;
    if ((paramSurfaceTexture != null) && (paramSurfaceTexture.get() != null)) {
      AETemplateInfoFragment.access$800((AETemplateInfoFragment)this.mRef.get());
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.AETemplateInfoFragment.PlayerSurfaceTextureCallback
 * JD-Core Version:    0.7.0.1
 */