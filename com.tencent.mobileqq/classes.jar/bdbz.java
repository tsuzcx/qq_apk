import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;

public class bdbz
  extends PreviewContext
  implements SurfaceHolder.Callback, bdbn
{
  public bdbz(bdbg parambdbg, int paramInt1, int paramInt2)
  {
    super(parambdbg, paramInt1, paramInt2);
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    getPreviewFrame(paramArrayOfByte, paramCamera);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCamera.a(paramInt1, paramInt2, paramInt3);
    this.mCamera.a(null, paramSurfaceHolder, this, true);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mCamera.a();
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mCamera != null)
    {
      this.mCamera.b();
      this.mCamera.b(true);
      if (this.mActivtiyDestory) {
        this.mCamera = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbz
 * JD-Core Version:    0.7.0.1
 */