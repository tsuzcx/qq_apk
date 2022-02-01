import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.utils.QLog;

public class amsn
  implements SurfaceHolder.Callback
{
  amsn(amsm paramamsm) {}
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramSurfaceHolder.getSurface() == null) {
      return;
    }
    paramSurfaceHolder.setFixedSize(paramInt2, paramInt3);
    QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceChanged");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (GraphicRendererMgr.getInstance() != null)
    {
      anmc.a(amsm.a(this.a)).a().setRenderMgrAndHolder(GraphicRendererMgr.getInstance(), paramSurfaceHolder);
      anmc.a(amsm.a(this.a)).a().getVideoCtrl().setLocalVideoPreviewCallback(new amso(this));
      anmc.a(amsm.a(this.a)).a().getVideoCtrl().setRemoteVideoPreviewCallback(new amsp(this));
    }
    for (;;)
    {
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceCreated");
      return;
      QLog.e("AVCameraCaptureModel", 0, "GraphicRendererMgr is null, so can't load");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    paramSurfaceHolder = this.a.a();
    if (paramSurfaceHolder == null)
    {
      QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceDestroyed avCtrl == null");
      return;
    }
    paramSurfaceHolder.enableCamera(0, false, new amsq(this));
    QLog.e("AVCameraCaptureModel", 0, "memoryLeak surfaceDestroyed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsn
 * JD-Core Version:    0.7.0.1
 */