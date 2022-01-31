import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.AECamera.qudong.AETemplateInfoFragment;
import java.lang.ref.WeakReference;

public class bhau
  implements TextureView.SurfaceTextureListener
{
  private WeakReference<AETemplateInfoFragment> a;
  
  public bhau(AETemplateInfoFragment paramAETemplateInfoFragment)
  {
    this.a = new WeakReference(paramAETemplateInfoFragment);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureAvailable");
    if ((this.a != null) && (this.a.get() != null)) {
      AETemplateInfoFragment.a((AETemplateInfoFragment)this.a.get(), paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureDestroyed");
    if ((this.a != null) && (this.a.get() != null)) {
      AETemplateInfoFragment.c((AETemplateInfoFragment)this.a.get());
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    QLog.i("AETemplateInfoFragment", 1, "[player lifecycle]---onSurfaceTextureSizeChanged");
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhau
 * JD-Core Version:    0.7.0.1
 */