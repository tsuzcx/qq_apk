import com.tencent.TMG.sdk.AVVideoCtrl.LocalVideoPreviewCallback;
import com.tencent.TMG.sdk.AVVideoCtrl.VideoFrame;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel.1.1.1;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public class amso
  extends AVVideoCtrl.LocalVideoPreviewCallback
{
  amso(amsn paramamsn) {}
  
  public void onFrameReceive(AVVideoCtrl.VideoFrame paramVideoFrame)
  {
    Object localObject = anbd.a(amsm.a(this.a.a));
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((ande)localObject).a();
    } while (localObject == null);
    ((ApolloSurfaceView)localObject).queueEvent(new AVCameraCaptureModel.1.1.1(this, (ApolloSurfaceView)localObject, paramVideoFrame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amso
 * JD-Core Version:    0.7.0.1
 */