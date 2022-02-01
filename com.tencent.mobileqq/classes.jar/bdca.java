import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

@TargetApi(14)
public class bdca
  extends PreviewContext
  implements TextureView.SurfaceTextureListener, bdbn
{
  public bdca(bdbg parambdbg, int paramInt1, int paramInt2)
  {
    super(parambdbg, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.mCamera.a();
    this.mCamera.a(0, paramInt1, paramInt2);
    this.mCamera.a(paramSurfaceTexture, null, this, true);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mCamera != null)
    {
      this.mCamera.b();
      this.mCamera.b(true);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdca
 * JD-Core Version:    0.7.0.1
 */